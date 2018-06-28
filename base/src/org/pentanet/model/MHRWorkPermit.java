package org.pentanet.model;

	import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

	import org.compiere.model.MDocType;
import org.compiere.model.MMailText;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.process.NewEmail;
	

	public class MHRWorkPermit extends X_HR_WorkPermit implements DocAction,DocOptions{
		
		private static final long serialVersionUID = 2014021100123L;
		
		/**	Process Message 			*/
		private String m_processMsg = null;
		
		
		public MHRWorkPermit (Properties ctx, int HR_WorkPermit_ID, String trxName)
		{
			super (ctx, HR_WorkPermit_ID, trxName);
			//  New
			if (HR_WorkPermit_ID == 0)
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
		public MHRWorkPermit (Properties ctx, ResultSet rs, String trxName)
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
				//options[index++] = DocumentEngine.ACTION_Prepare;
			}
			
			
			// If status = Completed, add "Anulate" in the list
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
			
			MDocType doc = new MDocType(Env.getCtx(), getC_DocType_ID(), null);
			
			if(doc.getName().equals("WorkPermit"))
			{
				int R_MailText_ID = DB.getSQLValue(null, "SELECT R_MailText_ID FROM R_MailText WHERE value = 'WP_MailSup'");
				
				MMailText plantilla = new MMailText(Env.getCtx(), R_MailText_ID, null);
			    MMailData datos = plantilla.getMailDataVar(getHR_WorkPermit_ID(),null);
				
			    //sendEmail(String to, String tittle, String body)
			    NewEmail correo = new NewEmail();
			    //correo.sendEmail(datos.getEmail(), datos.getTittle(), datos.getBody());
			    correo.sendEmail(datos.getEmail(), datos.getTittle(), datos.getBody());
			    
			}
		    
			//setDocAction(DOCACTION_Complete);
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
			
			//	Re-Check
			if (!m_justPrepared)
			{
				String status = prepareIt();
				if (!DocAction.STATUS_InProgress.equals(status))
					return status;
			}
			
			String aprobado;
			if (isApproved()){
				aprobado = "Aprobada";
			}else{
				aprobado = "Rechazada";
			}
			
			MDocType doc = new MDocType(Env.getCtx(), getC_DocType_ID(), null);
			
			if(doc.getName().equals("WorkPermit"))
			{
				//Notificar via Correo al Empleado
				int R_MailText_ID = DB.getSQLValue(null, "SELECT R_MailText_ID FROM R_MailText WHERE value = 'WP_MailEmp'");
				
				MMailText plantilla = new MMailText(Env.getCtx(), R_MailText_ID, null);
			    MMailData datos = plantilla.getMailDataVar(getHR_WorkPermit_ID(), aprobado);
				
			    //sendEmail(String to, String tittle, String body)
			    NewEmail correo = new NewEmail();
			    
			    correo.addCc(datos.getEmailCc());
			    correo.sendEmail(datos.getEmail(), datos.getTittle(), datos.getBody());
			}
		    
			
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
		
			if(getHR_Process_ID()==0)
			{
				if(isApproved()) {
					setProcessed(true);
					setDocAction("--");
					setDocStatus("VO");
				}
				else{
					m_processMsg = "Permiso No Aprobado";
					return false;
				}
				
			}
			else
			{
				m_processMsg = "Permiso Procesado en Nómina --HR_Process_ID = " + getHR_Process_ID();
				return false;
			}
			
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
			if(getDocumentNo()==null)
				setDefiniteDocumentNo();
			
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

		
	}   //  MHRWorkPermit
