package org.sisconsulta.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.util.DB;
import org.compiere.util.Trx;

@SuppressWarnings("unused")
public class MGLClose extends X_GL_Close implements DocAction, DocOptions, ProcessCall{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7793190587180215790L;
	private String estado;
	private String accion;
	public MGLClose(Properties ctx, int GL_Close_ID, String trxName) {
		super(ctx, GL_Close_ID, trxName);
		// TODO Apéndice de constructor generado automáticamente
	}

	@Override
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean processIt(String action) throws Exception {
		// TODO Apéndice de método generado automáticamente
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (action, getDocAction());
	}

	@Override
	public boolean unlockIt() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean invalidateIt() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public String prepareIt() {
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
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean rejectIt() {
		log.info("rejectIt - " + toString());
		
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
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean closeIt() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean reverseCorrectIt() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean reverseAccrualIt() {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean reActivateIt() {
		setProcessed(false);
		setDocStatus("DR");
		setDocAction(DOCACTION_Complete);
		return true;
	}

	@Override
	public String getSummary() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String getDocumentNo() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String getDocumentInfo() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public File createPDF() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String getProcessMsg() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public int getDoc_User_ID() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public int getC_Currency_ID() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
	@Override
	public int customizeValidActions(String docStatus, Object processing,
			String orderType, String isSOTrx, int AD_Table_ID,
			String[] docAction, String[] options, int index) {
		//
		
		 if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
			   
			    options[index++] = DocumentEngine.ACTION_ReActivate;
	            options[index++] = DocumentEngine.ACTION_Void;
	           
	        }       
		return index;
	}
}
