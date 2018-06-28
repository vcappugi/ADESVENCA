package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MMailText;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.MHRPeriod;
import org.pentanet.process.NewEmail;

public class MCAdvanceRequest extends X_C_Advance_Request implements DocAction, DocOptions{
	
	private static final long serialVersionUID = 20140211L;
	
	private String m_processMsg;
	
	
	public  MCAdvanceRequest (Properties ctx, int C_Advance_Request_ID, String trxName)
	{
		super (ctx, C_Advance_Request_ID, trxName);
		//  New
		if (C_Advance_Request_ID == 0)
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
	public MCAdvanceRequest (Properties ctx, ResultSet rs, String trxName)
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
		
		/*
		// If status = Completed, add "Reactivate" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
			options[index++] = DocumentEngine.ACTION_ReActivate;
			options[index++] = DocumentEngine.ACTION_Void;
		}   	
		*/
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
	    
			//setDocAction(DOCACTION_Complete);
			return DocAction.STATUS_InProgress;
		//}
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

		//Users
		String sql = "SELECT AD_User_Rev_ID, DateRev FROM User_Aprob_RG(?,?)";
					
		try
		{
			PreparedStatement pstmt = DB.prepareStatement(sql.toString(), null);
			pstmt.setInt(1, get_Table_ID());
			pstmt.setInt(2, get_ID());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				if(rs.getInt(1)!=0){
					setAD_User_Rev_ID(rs.getInt(1));
				}else{
					setAD_User_Rev_ID(Env.getAD_User_ID(getCtx()));
				}
				setAD_User_Aprob_ID(Env.getAD_User_ID(getCtx()));
			}
			rs.close();
			pstmt.close();
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql.toString(), e);
		}
				
				
		
		if (!isApproved())
			approveIt();
		
		//Notificar via Correo al Empleado
		
		int R_MailText_ID = DB.getSQLValue(null, "SELECT R_MailText_ID FROM R_MailText WHERE value = 'AR_Complet'");
		
		MMailText plantilla = new MMailText(Env.getCtx(), R_MailText_ID, null);
	    MMailData datos = plantilla.getMailDataVar(getC_Advance_Request_ID(),null);
		
	    //sendEmail(String to, String tittle, String body)
	    NewEmail correo = new NewEmail();
	    
	    correo.addCc(datos.getEmailCc());
	    correo.sendEmail(datos.getEmail(), datos.getTittle(), datos.getBody());
	    
		
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
		//setDescription(getDescription(), "M");
		
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
		
		String valida =  DB.getSQLValueString(null,"SELECT DocStatus FROM C_Advance_Request WHERE C_Advance_Request_ID=" + getC_Advance_Request_ID());
        if (!valida.contains("DR")){
        	
        	throw new AdempiereException("No se puede Eliminar este documento por motivos de Auditoria");

        }
		
		return true;
	}
	
	
}   //  MVacationRequisition


