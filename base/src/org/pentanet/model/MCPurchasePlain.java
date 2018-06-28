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

public final class MCPurchasePlain extends X_C_Purchase_Plain implements DocAction, ProcessCall {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public MCPurchasePlain (Properties ctx, int C_Purchase_Plain_ID, String trxName)
	{
		super (ctx, C_Purchase_Plain_ID, trxName);
		//  New
		if (C_Purchase_Plain_ID == 0)
		{
			setDocAction(DOCACTION_Prepare);
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
		//m_processMsg = null;
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
