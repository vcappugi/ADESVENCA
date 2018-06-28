package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.DB;
import org.compiere.util.Trx;

public class MCBudgetPublic extends X_C_BudgetPublic implements DocAction, ProcessCall {
	public MCBudgetPublic(Properties ctx, int C_BudgetPublic_ID, String trxName)
	{
		super(ctx, C_BudgetPublic_ID, trxName);
		//  New
				if (C_BudgetPublic_ID == 0)
				{
					setDocAction(DOCACTION_Complete);
					setDocStatus(DOCSTATUS_Drafted);			
					setProcessed(false);
					//setProcessing(false);
					//setPosted (false);
					//			
				
				}
	}
	
	@Override
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean processIt(String action) throws Exception {
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (action, getDocAction());
		
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
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
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
		setProcessed(true);
		setDocAction(DOCACTION_Close);
		//Actualizar las lineas
		String sql = "Update C_BudgetPublic_Line set Processed='Y' where C_BudgetPublic_ID=" + getC_BudgetPublic_ID();
		int action = DB.executeUpdate(sql,null);
		return DocAction.STATUS_Completed;
		
	    
	
		
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
