package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class MCBudgetMod extends X_C_BudgetMod implements DocAction, DocOptions{


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
	public MCBudgetMod (Properties ctx, int C_BudgetMod_ID, String trxName)
	{
		super (ctx, C_BudgetMod_ID, trxName);
		//  New
		if (C_BudgetMod_ID == 0)
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
	public MCBudgetMod (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MPayment

	
	/** Reversal Indicator			*/
	public static String	REVERSE_INDICATOR = "^";
	
	/**
	 *  Reset Request to new status
	 */
	public void resetNew()
	{
		setC_BudgetMod_ID(0);		//	forces new Record
		//set_ValueNoCheck ("DocumentNo", null);
		setDocAction(DOCACTION_Prepare);
		setDocStatus(DOCSTATUS_Drafted);
		setProcessed(false);
		//setPosted (false);		
	}	//	resetNew



	
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


	/**************************************************************************
	 * 	Customize Valid Actions
	 *	@param *
	 *	@return index
	 *********************************************************/
	
    public int customizeValidActions (String docStatus, Object processing, 
            String orderType, String isSOTrx, int AD_Table_ID, String[] docAction, String[] options, int index) {

		// If status = Drafted, add "Prepare" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Drafted)
				|| docStatus.equals(DocumentEngine.STATUS_Invalid)) {
			options[index++] = DocumentEngine.ACTION_Prepare;
		}
		
		
		// If status = Completed, add "Reactivate" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
			//options[index++] = DocumentEngine.ACTION_ReActivate;
			options[index++] = DocumentEngine.ACTION_Void;
		}   	
		
		return index;
	}
    
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
			{
			setDocAction(DOCACTION_Complete);
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
		/*
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
		
		else if (STATUS_Invalid.equals(getDocStatus()) && DOCACTION_Close.equals(getDocAction())) {
			setProcessed(false);
			return DocAction.STATUS_Drafted;
		}
		
		else{
		*/
			setProcessed(true);
			setDocAction(DOCACTION_Close);
			return DocAction.STATUS_Completed;
		//}
		
	} //completit

	/**
	 * 	Set Processed.
	 * 	Propergate to Lines
	 *	@param processed processed
	 */
	public void setProcessed (boolean processed)
	{
		super.setProcessed (processed);
		if (get_ID() == 0)
			return;
		String set = "SET Processed='"
			+ (processed ? "Y" : "N")
			+ "' WHERE H_Request_ID=" + getC_BudgetMod_ID();
		int noLine = DB.executeUpdate("UPDATE H_Request_Line " + set, get_TrxName());

		log.fine(processed + " - Lines=" + noLine);
	}	//	setProcessed
	


	public boolean voidIt() {
		
			setProcessed(true);
		setDocAction(DOCACTION_None);
		return true;
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
		
		return m_processMsg;
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
	
	
	//Solo se borra lo que este en estado Borrador
	@Override
	protected boolean beforeDelete() {
		
		String valida =  DB.getSQLValueString(null,"SELECT DocStatus FROM H_Request WHERE H_Request_ID=" + getC_BudgetMod_ID());
        if (!valida.contains("DR")){
        	
        	throw new AdempiereException("No se puede Eliminar este documento por motivos de Auditoria");

        }
		
		return true;
	}
	
	
}   //  MHRequest
