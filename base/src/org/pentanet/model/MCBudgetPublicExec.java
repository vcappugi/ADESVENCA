package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.Trx;

public class MCBudgetPublicExec extends X_C_BudgetPublic_Exec implements DocAction, ProcessCall {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MCBudgetPublicExec(Properties ctx, int C_BudgetPublic_Exec_ID, String trxName)
	{
		super (ctx, C_BudgetPublic_Exec_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
	@Override
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean processIt(String action) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean invalidateIt() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String prepareIt() {
		// TODO Auto-generated method stub
		return null;
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
		 * Aqui se hace la actualizacion de el documento original,
		 * coloca en tiempo presupuestario
		 * y aprueba el documento de ejecucion 
		 */
		
		return null;
	}
	@Override
	public boolean voidIt() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean closeIt() {
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
	public String getDocumentNo() {
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
