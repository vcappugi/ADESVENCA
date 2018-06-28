/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.apps.ADialog;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.util.ValueNamePair;
import org.compiere.model.ModelValidator;

/**
 *  Payment Model.
 *  - retrieve and create payments for invoice
 *  <pre>
 *  Event chain
 *  - Payment inserted
 *      C_Payment_Trg fires
 *          update DocumentNo with payment summary
 *  - Payment posted (C_Payment_Post)
 *      create allocation line
 *          C_Allocation_Trg fires
 *              Update C_BPartner Open Item Amount
 *      update invoice (IsPaid)
 *      link invoice-payment if batch
 *
 *  Lifeline:
 *  -   Created by VPayment or directly
 *  -   When changed in VPayment
 *      - old payment is reversed
 *      - new payment created
 *
 *  When Payment is posed, the Allocation is made
 *  </pre>
 *  @author 	Jorg Janke
 *  @author victor.perez@e-evolution.com, e-Evolution http://www.e-evolution.com
 * 			<li>FR [ 1948157  ]  Is necessary the reference for document reverse
 *  		@see http://sourceforge.net/tracker/?func=detail&atid=879335&aid=1948157&group_id=176962 
 *			<li> FR [ 1866214 ]  
 *			@sse http://sourceforge.net/tracker/index.php?func=detail&aid=1866214&group_id=176962&atid=879335 
 * 			<li> FR [ 2520591 ] Support multiples calendar for Org 
 *			@see http://sourceforge.net/tracker2/?func=detail&atid=879335&aid=2520591&group_id=176962 
 *
 *  @author Carlos Ruiz - globalqss [ 2141475 ] Payment <> allocations must not be completed - implement lots of validations on prepareIt
 *  @version 	$Id: MPayment.java,v 1.4 2006/10/02 05:18:39 jjanke Exp $
 */
public final class MHAdmission extends X_H_Admission
	implements DocAction, ProcessCall
{


    /**
     * 
     */
    private static final long serialVersionUID = 6200327948230438741L;

	private String estado;
	private String accion;
	private String m_processMsg;
	
	/**************************************************************************
	 *  Default Constructor
	 *  @param ctx context
	 *  @param  C_Payment_ID    payment to load, (0 create new payment)
	 *  @param trxName trx name
	 */
	public MHAdmission (Properties ctx, int H_Admission_ID, String trxName)
	{
		super (ctx, H_Admission_ID, trxName);
		//  New
		if (H_Admission_ID == 0)
		{
			setDocAction(DOCACTION_Prepare);
			setDocStatus(DOCSTATUS_Drafted);			
			setProcessed(false);
			//setProcessing(false);
			//setPosted (false);
			//			
		}
	}   //  MPayment
	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *	@param trxName transaction
	 */
	public MHAdmission (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MPayment

	/**	Temporary	Payment Processors		*/
	private MPaymentProcessor[]	m_mPaymentProcessors = null;
	/**	Temporary	Payment Processor		*/
	private MPaymentProcessor	m_mPaymentProcessor = null;
	/** Logger								*/
	private static CLogger		s_log = CLogger.getCLogger (MHAdmission.class);
	/** Error Message						*/
	private String				m_errorMessage = null;
	
	/** Reversal Indicator			*/
	public static String	REVERSE_INDICATOR = "^";
	
	/**
	 *  Reset Payment to new status
	 */
	public void resetNew()
	{
		setH_Admission_ID(0);		//	forces new Record
		set_ValueNoCheck ("DocumentNo", null);
		setDocAction(DOCACTION_Prepare);
		setDocStatus(DOCSTATUS_Drafted);
		setProcessed(false);
		//setPosted (false);		
	}	//	resetNew


	@Override
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Auto-generated method stub
		return false;
	}


	
	/**************************************************************************
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 */
	public boolean processIt (String processAction)
	{
		//m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	process


	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean invalidateIt() {
		log.info(toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	
	}


	@Override
	public String prepareIt() {
		//Ojo, validaciones para no cambiar de estado.
		//No puedo colocar en progreso si: 
		// No tiene responsable financiero.
		/*
		String pg = getGenerateBudget();
		if (getGenerateBudget().contains("N"))
		{
			ADialog.warn(Env.WINDOW_INFO,null, "DOCUMENTO SIN PRESUPUESTO GENERADO");
			setDocAction(DOCACTION_Prepare);
			return DocAction.STATUS_InProgress;
		}
		*/	
		estado = getDocStatus();
		accion = getDocAction();
		if (estado.equalsIgnoreCase("DR") && accion.equalsIgnoreCase("CO"))
			{setDocAction(DOCACTION_Complete);
			return DocAction.STATUS_InProgress;
			}
		else
		{
			setDocAction(DOCACTION_Close);
			return DocAction.STATUS_InProgress;
		}
	}


	@Override
	public boolean approveIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean rejectIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String completeIt() {
		if (STATUS_InProgress.equals(getDocStatus()) && DOCACTION_Complete.equals(getDocAction()))
		{
			setProcessed(false);
			return DocAction.STATUS_InProgress;
		}	
		else if (STATUS_Completed.equals(getDocStatus()) && DOCACTION_Close.equals(getDocAction())){
			setProcessed(true);
			setDocAction(DOCACTION_None);
			return DocAction.STATUS_Closed;
		}
		/*
		else if (STATUS_Invalid.equals(getDocStatus()) && DOCACTION_Close.equals(getDocAction())) {
			setProcessed(false);
			return DocAction.STATUS_Drafted;
		}
		*/
		else{
			setProcessed(true);
			setDocAction(DOCACTION_Close);
			return DocAction.STATUS_Completed;
		}
		
	} //completit


	@Override
	public boolean voidIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean closeIt() {
		// TODO Auto-generated method stub
		log.info(toString());
		// Before Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_CLOSE);
		if (m_processMsg != null)
			return false;

		// After Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_CLOSE);
		if (m_processMsg != null)
			return false;

		
		setDocAction(DOCACTION_None);
		return true;
	}


	@Override
	public boolean reverseCorrectIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean reverseAccrualIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean reActivateIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getDocumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File createPDF() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getProcessMsg() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getDoc_User_ID() {
		// TODO Auto-generated method stub
		return 0;
	}


	protected boolean beforeSave (boolean newRecord)
	{
		//setDescription(getDescription(), "M");
		
		return true;
	}	//	beforeSave

	@Override
	public int getC_Currency_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}
	
}   //  MPayment
