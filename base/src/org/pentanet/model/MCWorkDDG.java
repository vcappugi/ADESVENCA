package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;

public class MCWorkDDG extends X_C_WorkDDG implements DocAction, DocOptions{

private String m_processMsg;
	
	
	public MCWorkDDG (Properties ctx, int C_WorkDDG_ID, String trxName)
	{
		super (ctx, C_WorkDDG_ID, trxName);
		//  New
		if (C_WorkDDG_ID == 0)
		{
			setDocAction(DOCACTION_Complete);
			setDocStatus(DOCSTATUS_Drafted);			
			setProcessed(false);
			//setIsApproved (false);
			//setProcessing(false);
			//setPosted (false);
			//			
		}
	}
	
	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 */
	public MCWorkDDG (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MRequisition
	
	
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
	
	
	
	
	/**************************************************************************
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 **************************************/
	public boolean processIt (String processAction)
	{
		//m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	process

	/**	Just Prepared Flag			*/
	private boolean 		m_justPrepared = false;

	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean invalidateIt() {
		log.info(toString());
		
		return true;
	
	}


	@Override
	public String prepareIt() {

		m_justPrepared = true;
		
		return DocAction.STATUS_InProgress;
	}


	@Override
	public boolean approveIt() {
		
		setIsApproved(true);
		
		return true;
	}


	@Override
	public boolean rejectIt() {
		
		setIsApproved(false);
		return true;
	}


	@Override
	public String completeIt() {

		if (!isApproved())
			approveIt();
		
		
		/*
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}
		*/
		
		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();
		
		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
						
	} //completit


	private void setDefiniteDocumentNo() {
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());

		if (dt.isOverwriteSeqOnComplete()) {
			String value = DB.getDocumentNo(getC_DocType_ID(), get_TrxName(), true, this);
			if (value != null)
				setDocumentNo(value);
		}
	}
	
	@Override
	public boolean voidIt() {
		
		//No Aprobado
		if(!isApproved())
			return false;
		
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

		
		//setDocAction(DOCACTION_None);
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
	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	public String getProcessMsg()
	{
		return m_processMsg;
	}	//	getProcessMsg


	@Override
	public int getDoc_User_ID() {
		// TODO Auto-generated method stub
		return 0;
	}


	protected boolean beforeSave (boolean newRecord)
	{
		if(getValue() == null || getValue().toString().length() < 2)
		{
			String code = DB.getSQLValueString(null, "SELECT 'Dia a Dia '||to_char(NOW(), 'TMMON')||'-'||to_char(NOW(),'YY')");
			
			setValue(code);
		}
		
		return true;
	}	//	beforeSave

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Solo se borra lo que este en estado Borrador
	@Override
	protected boolean beforeDelete() {
		
		String valida =  DB.getSQLValueString(null,"SELECT DocStatus FROM C_WorkDDG WHERE C_WorkDDG_ID=" + getC_WorkDDG_ID());
        if (!valida.contains("DR")){
        	
        	throw new AdempiereException("No se puede Eliminar este documento por motivos de Auditoria");

        }
		
		return true;
	}

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
			+ "' WHERE C_WorkDDG_ID=" + getC_WorkDDG_ID();
		int noLine = DB.executeUpdate("UPDATE C_WorkDDGLine " + set, get_TrxName());
		
		log.fine(processed + " - Lines=" + noLine);
	}	//	setProcessed
	
}


