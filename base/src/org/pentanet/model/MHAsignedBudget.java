package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.DB;
import org.compiere.util.Trx;

public final class MHAsignedBudget extends X_H_Asigned_Budget implements DocAction, ProcessCall
{
	private static final long serialVersionUID = 20111129L;
	private String estado;
	private String accion;
	private String m_processMsg;
	/** Reversal Indicator			*/
	public static String	REVERSE_INDICATOR = "^";
	
	public MHAsignedBudget(Properties ctx, int H_Asigned_budget_ID, String trxName)
	{
		super (ctx, H_Asigned_budget_ID, trxName);
		
		if (H_Asigned_budget_ID == 0)
		{
			setDocAction(DOCACTION_Prepare);
			setDocStatus(DOCSTATUS_Drafted);			
			setProcessed(false);
		}
	}

	public void resetNew()
	{
		setH_Admission_ID(0);		//	forces new Record
		set_ValueNoCheck ("DocumentNo", null);
		setDocAction(DOCACTION_Prepare);
		setDocStatus(DOCSTATUS_Drafted);
		setProcessed(false);
		//setPosted (false);		
	}	//	resetNew
	


	
	
	public boolean processIt (String processAction)
	{
		//m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	process

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
		
		estado = getDocStatus();
		accion = getDocAction();
		if (estado.equalsIgnoreCase("DR") && accion.equalsIgnoreCase("CO")){				
			
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
	public String completeIt() {
		if (STATUS_InProgress.equals(getDocStatus()) && DOCACTION_Complete.equals(getDocAction()))
		{
			DB.executeUpdate("UPDATE H_Admission SET GenerateBudget='A' WHERE H_Admission_ID="+getH_Admission_ID(),null);
			setProcessed(false);
			return DocAction.STATUS_InProgress;
		}	
		else if (STATUS_Completed.equals(getDocStatus()) && DOCACTION_Close.equals(getDocAction())){
			
			setProcessed(true);
			setDocAction(DOCACTION_None);
			return DocAction.STATUS_Closed;
		
		}
		else{
			setProcessed(true);
			setDocAction(DOCACTION_Close);
			return DocAction.STATUS_Completed;
		}
		
	} //completit


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
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean voidIt() {
		// TODO Auto-generated method stub
		return false;
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
		
	
}
