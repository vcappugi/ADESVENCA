/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
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
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved.               *
 * Contributor(s): Victor Perez www.e-evolution.com                           *
 *****************************************************************************/
package org.eevolution.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.apps.ADialog;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MFactAcct;
import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.compiere.model.MRule;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.Query;
import org.compiere.model.Scriptlet;
import org.compiere.print.ReportEngine;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.pentanet.model.MVariableProcess;
import org.pentanet.model.X_HR_ConceptVar;
import org.pentanet.process.NewEmail;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

/**
 * HR Process Model
 *
 *  @author oscar.gomez@e-evolution.com, e-Evolution http://www.e-evolution.com
 *			<li> Original contributor of Payroll Functionality
 *  @author victor.perez@e-evolution.com, e-Evolution http://www.e-evolution.com
 * 			<li> FR [ 2520591 ] Support multiples calendar for Org 
 *			@see http://sourceforge.net/tracker2/?func=detail&atid=879335&aid=2520591&group_id=176962
 * @author Cristina Ghita, www.arhipac.ro
 * 
 * @author Jenny Rodriguez - jrodriguez@dcsla.com, Double Click Sistemas http://www.dcsla.com
 *			<li> 
 * @author Rafael Salazar C. - rsalazar@dcsla.com, Double Click Sistemas http://www.dcsla.com
 *			<li> 
 */
@SuppressWarnings("unused")
public class MHRProcess extends X_HR_Process implements DocAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5310991830396703407L;

	private String m_C_BPartnerName ="";
	private int m_C_BPartnerCont =0;
	public int m_C_BPartner_ID = 0;
	public int m_AD_User_ID = 0;
	public int m_HR_Concept_ID = 0;
	public String m_columnType   = "";
	public Timestamp m_dateFrom;
	public Timestamp m_dateTo;	
	/** HR_Concept_ID->MHRMovement */
	public Hashtable<Integer, MHRMovement> m_movement = new Hashtable<Integer, MHRMovement>();
	public MHRPayrollConcept[] linesConcept;
	
	//para las sumatorias de los conceptos
	public List<MHRConcept> listConceptAsg; // Solo Conceptos tipo Asignaciones 
	public List<MHRConcept> listConceptDed; // Solo Conceptos tipo Deducciones 
	public List<MHRConcept> listConceptPer; // Solo Conceptos marcado como remunerados
	
	public List<MHREmployee> listEmployee; // Solo Conceptos marcado como remunerados
	
	// Variable que se usan en los groovy
	public List<X_HR_ConceptVar> listConceptVarG;
	public List<X_HR_ConceptVar> listConceptVarP;
	public List<MVariableProcess> listVareableP = new ArrayList<MVariableProcess>();
	
	public int payrolltypeline = 0;
	
	/** The employee being processed */
	private MHREmployee m_employee;
	
	/** The Chang Job being processed */
	private int m_changejob;
	
	/** the context for rules */
	HashMap<String, Object> m_scriptCtx = new HashMap<String, Object>();
	/* stack of concepts executing rules - to check loop in recursion */
	private List<MHRConcept> activeConceptRule = new ArrayList<MHRConcept>();

	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (MHRProcess.class);
	public static final String CONCEPT_PP_COST_COLLECTOR_LABOR = "PP_COST_COLLECTOR_LABOR"; // HARDCODED
	Object m_description = null;


	private static StringBuffer s_scriptImport = new StringBuffer(	 " import org.eevolution.model.*;" 
			+" import org.compiere.model.*; "
			+" import org.adempiere.model.*; "
			+" import org.compiere.util.*; "
			+" import java.math.*; "
			+" import java.sql.*; " 
			+ "import java.util.*; "
			+ "import java.text.*; ");

	public static void addScriptImportPackage(String packageName)
	{
		s_scriptImport.append(" import ").append(packageName).append(";");
	}

	/**************************************************************************
	 *  Default Constructor
	 *  @param ctx context
	 *  @param  HR_Process_ID    To load, (0 create new order)
	 */
	public MHRProcess(Properties ctx, int HR_Process_ID, String trxName) 
	{ 
		super(ctx, HR_Process_ID,trxName);
		
		if (HR_Process_ID == 0)
		{
			setDocStatus(DOCSTATUS_Drafted);
			setDocAction(DOCACTION_Prepare);
			setC_DocType_ID(0);
			set_ValueNoCheck ("DocumentNo", null);
			setProcessed(false);
			setProcessing(false);
			setPosted(false);
			setHR_Department_ID(0);
			setC_BPartner_ID(0);
		}
		
	}

	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 */
	public MHRProcess(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs,trxName);
		
	}	//	MHRProcess

	@Override
	public final void setProcessed(boolean processed)
	{		
		super.setProcessed(processed);
		if (get_ID() <= 0)
		{
			return;
		}
		final String sql = "UPDATE HR_Process SET Processed=? WHERE HR_Process_ID=?";
		DB.executeUpdateEx(sql, new Object[]{processed, get_ID()}, get_TrxName());
	}	//	setProcessed

	@Override
	protected boolean beforeSave(boolean newRecord)
	{
		if (getAD_Client_ID() == 0)
		{
			throw new AdempiereException("@AD_Client_ID@ = 0");
		}
		/*if (getAD_Org_ID() == 0)
		{
			int context_AD_Org_ID = Env.getAD_Org_ID(getCtx());
			if (context_AD_Org_ID == 0)
			{
				throw new AdempiereException("@AD_Org_ID@ = *");
			}
			setAD_Org_ID(context_AD_Org_ID);
			log.warning("Changed Org to Context=" + context_AD_Org_ID);
		}*/
		setC_DocType_ID(getC_DocTypeTarget_ID());

		return true;
	}       
	
	/**
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 */
	public boolean processIt(String processAction) 
	{
		//VerifyWorkedTime(); Verifica la tabla HR_Movement
		DocumentEngine engine = new DocumentEngine(this, getDocStatus());
		return engine.processIt(processAction, getDocAction());
	}	//	processIt

	/**	Process Message 			*/
	private String		m_processMsg = null;
	/**	Just Prepared Flag			*/
	private boolean		m_justPrepared = false;

	private int colum;

	/**
	 * 	Unlock Document.
	 * 	@return true if success
	 */
	public boolean unlockIt() 
	{
		log.info("unlockIt - " + toString());
		setProcessing(false);
		return true;
	}	//	unlockIt


	/**
	 * 	Invalidate Document
	 * 	@return true if success
	 */
	public boolean invalidateIt() 
	{
		log.info("invalidateIt - " + toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	}	//	invalidateIt


	/**************************************************************************
	 *	Prepare Document
	 * 	@return new status (In Progress or Invalid)
	 */
	public String prepareIt()
	{
		
	    //VerifyWorkedTime();
		log.info("prepareIt - " + toString());

		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_PREPARE);
		
		
		if (m_processMsg != null)
		{
			return DocAction.STATUS_Invalid;
		}
		
		//Actualiza la fecha de contabiizacion (Proceso y periodo)
		setDateAcct(getDateAct());
		DB.executeUpdate("Update HR_Period SET DateAcct = '"+ getDateAct() +"' WHERE HR_Period_ID =" + getHR_Period_ID(), null);
		
		//	Std Period open?
		MHRPeriod period = MHRPeriod.get(getCtx(), getHR_Period_ID());
		MPeriod.testPeriodOpen(getCtx(), getHR_Period_ID() > 0 ? period.getDateAcct():getDateAcct(), getC_DocTypeTarget_ID(), getAD_Org_ID());
	
		
		//	New or in Progress/Invalid
		if (   DOCSTATUS_Drafted.equals(getDocStatus()) 
				|| DOCSTATUS_InProgress.equals(getDocStatus())
				|| DOCSTATUS_Invalid.equals(getDocStatus()) 
				|| getC_DocType_ID() == 0)
		{
			setC_DocType_ID(getC_DocTypeTarget_ID()); 
		}

		try 
		{
			if (!getDocAction().equals("CO")){
				//JOptionPane.showMessageDialog(null, getDocAction());
				if (getDocAction().equals("PR") || getDocStatus().equals("DR")){
					String hora = getHoraAct();
					createMovements();
					
					if(Env.getAD_Role_ID(getCtx()) == 1000000)
						JOptionPane.showMessageDialog(null, " Hora Inicio: " + hora + " Hora Final: " + getHoraAct());
					
				}
			}
		} 
		catch (Exception e) 
		{
			throw new AdempiereException(e);
		}
		
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		//
		m_justPrepared = true;
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt


	/**
	 * 	Complete Document
	 * 	@return new status (Complete, In Progress, Invalid, Waiting ..)
	 */
	public String completeIt()
	{
		// verifica el tipo de nomina para prevenir que se procese de programacion de pago de vacacions
		String pclas =DB.getSQLValueString(null,"SELECT COALESCE(Payroll_Clasif,'Q') FROM HR_Payroll WHERE HR_Payroll_id = " + getHR_Payroll_ID());
		String vapproved = DB.getSQLValueString(null,"SELECT IsApproved FROM hr_vacationprog WHERE hr_process_id = " + getHR_Process_ID());
		
		Boolean complete = true;
		// verefica que la nomina sea de vacaciones y la progremacion este marcada  como aprovada para cerrar el proceso
		if(pclas !=  null){
			if(pclas.equals("VAC") && vapproved.equals("N")){
				complete = false;
			}
		}
		
		if(complete == true){
			
			//	Re-Check
			if (!m_justPrepared)
			{
				String status = prepareIt();
				if (!DocAction.STATUS_InProgress.equals(status))
					return status;
			}
	
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
			if (m_processMsg != null)
				return DocAction.STATUS_Invalid;
	
			//	User Validation
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
			if (m_processMsg != null)
			{
				return DocAction.STATUS_Invalid;
			}
			//

			if(pclas.equals("LIQ")){
				getCompleted_Process_Liq();// Completa el Proceso de Liquidación marcadas para pagar
			}else{
				getCompleted_Process_Vac();// Completa el Proceso de vacaciones marcadas para pagar
			}
			
			setProcessed(true);	
			setDocAction(DOCACTION_Close);
			return DocAction.STATUS_Completed;
			
		}else{
			return DocAction.STATUS_InProgress;
		}//	completeIt
		
		
	}

	/**
	 * 	Approve Document
	 * 	@return true if success
	 */
	public boolean  approveIt() {
		return true;
	}	//	approveIt


	/**
	 * 	Reject Approval
	 * 	@return true if success
	 */
	public boolean rejectIt() {
		log.info("rejectIt - " + toString());
		return true;
	}	//	rejectIt

	/**
	 * 	Post Document - nothing
	 * 	@return true if success
	 */
	public boolean postIt() {
		log.info("postIt - " + toString());
		return false;
	}	//	postIt


	/**
	 * 	Void Document.
	 * 	Set Qtys to 0 - Sales: reverse all documents
	 * 	@return true if success
	 */
	public boolean voidIt() {
		log.info("voidIt - " + toString());
		// Before Void
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_VOID);
		if (m_processMsg != null)
			return false;

		// After Void
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_VOID);
		if (m_processMsg != null)
			return false;

		setProcessed(true);
		setDocAction(DOCACTION_None);
		return true;
	}	//	voidIt


	/**
	 * 	Close Document.
	 * 	Cancel not delivered Qunatities
	 * 	@return true if success 
	 */
	public boolean closeIt()
	{
		if (isProcessed())
		{
			log.info(toString());
			
			// Before Close
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_CLOSE);
			if (m_processMsg != null)
				return false;
			
			// After Close
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_CLOSE);
			if (m_processMsg != null)
				return false;

			setProcessed(true);
			setDocAction(DOCACTION_None);
			return true;
		}     	
		return false;
	}	//	closeIt


	/**
	 * 	Reverse Correction - same void
	 * 	@return true if success
	 */
	public boolean reverseCorrectIt() {
		log.info("reverseCorrectIt - " + toString());
		// Before reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_REVERSECORRECT);
		if (m_processMsg != null)
			return false;
		
		// After reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_REVERSECORRECT);
		if (m_processMsg != null)
			return false;
		
		return voidIt();
	}	//	reverseCorrectionIt


	/**
	 * 	Reverse Accrual - none
	 * 	@return true if success
	 */
	public boolean reverseAccrualIt() {
		log.info("reverseAccrualIt - " + toString());
		// Before reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;
		
		// After reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;
		
		return false;
	}	//	reverseAccrualIt


	/**
	 * 	Re-activate.
	 * 	@return true if success
	 */
	public boolean reActivateIt() {
		log.info("reActivateIt - " + toString());

		// Before reActivate
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_REACTIVATE);
		if (m_processMsg != null)
			return false;
		
		//	Can we delete posting
		MPeriod.testPeriodOpen(getCtx(), getDateAcct(), MPeriodControl.DOCBASETYPE_Payroll, getAD_Org_ID());

		//	Delete 
		String sql = "DELETE FROM HR_Movement WHERE HR_Process_ID =" + this.getHR_Process_ID() + " AND IsRegistered = 'N'" ;
		int no = DB.executeUpdate(sql, get_TrxName());
		log.fine("HR_Process deleted #" + no);

		//	Delete Posting
		no = MFactAcct.deleteEx(MHRProcess.Table_ID, getHR_Process_ID(), get_TrxName());
		log.fine("Fact_Acct deleted #" + no);
		
		// After reActivate
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_REACTIVATE);
		if (m_processMsg != null)
			return false;

		setDocAction(DOCACTION_Complete);
		setProcessed(false);
		return true;
	}	//	reActivateIt


	/**
	 * 	Get Document Owner (Responsible)
	 *	@return AD_User_ID
	 */
	public int getDoc_User_ID() {
		return 0;
	}	//	getDoc_User_ID


	/**
	 * 	Get Document Approval Amount
	 *	@return amount
	 */
	public java.math.BigDecimal getApprovalAmt() 
	{
		return BigDecimal.ZERO;
	}	//	getApprovalAmt

	/**
	 * 
	 */
	public int getC_Currency_ID() 
	{
		return 0;
	}

	public String getProcessMsg() 
	{
		return m_processMsg;
	}

	public String getSummary()
	{
		return "";
	}

	/**
	 * 	Create PDF
	 *	@return File or null
	 */
	public File createPDF ()
	{
		try
		{
			File temp = File.createTempFile(get_TableName()+get_ID()+"_", ".pdf");
			return createPDF (temp);
		}
		catch (Exception e)
		{
			log.severe("Could not create PDF - " + e.getMessage());
		}
		return null;
	}	//	getPDF

	/**
	 * 	Create PDF file
	 *	@param file output file
	 *	@return file if success
	 */
	public File createPDF (File file)
	{
		ReportEngine re = ReportEngine.get (getCtx(), ReportEngine.ORDER, 0);
		if (re == null)
			return null;
		return re.getPDF(file);
	}	//	createPDF

	/**
	 * 	Get Document Info
	 *	@return document info (untranslated)
	 */
	public String getDocumentInfo()
	{
		org.compiere.model.MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		return dt.getName() + " " + getDocumentNo();
	}	//	getDocumentInfo


	/**
	 * 	Get Lines
	 *	@param requery requery
	 *	@return lines
	 */
	public MHRMovement[] getLines (boolean requery)
	{
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		// For HR_Process:
		whereClause.append(MHRMovement.COLUMNNAME_HR_Process_ID+"=?");
		params.add(getHR_Process_ID());
		// With Qty or Amounts
		whereClause.append("AND (Qty <> 0 OR Amount <> 0)"); // TODO: it's really needed ?
		// Only Active Concepts
		whereClause.append(" AND EXISTS(SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Movement.HR_Concept_ID"
				+" AND c.IsActive=?"
				+" AND c.AccountSign<>?)"); // TODO : why ?
		params.add(true);
		params.add(MHRConcept.ACCOUNTSIGN_Natural); // TODO : why ?
		// Concepts with accounting
		whereClause.append(" AND EXISTS(SELECT 1 FROM HR_Concept_Acct ca WHERE ca.HR_Concept_ID=HR_Movement.HR_Concept_ID"
				+" AND ca.IsActive=? AND ca.IsBalancing<>?)");
		params.add(true);
		params.add(true);
		// BPartner field is filled
		whereClause.append(" AND C_BPartner_ID IS NOT NULL");
		//
		// ORDER BY
		StringBuffer orderByClause = new StringBuffer();
		orderByClause.append("(SELECT bp.C_BP_Group_ID FROM C_BPartner bp WHERE bp.C_BPartner_ID=HR_Movement.C_BPartner_ID)");
		//
		List<MHRMovement> list = new Query (getCtx(), MHRMovement.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(orderByClause.toString())
		.list();
		return list.toArray(new MHRMovement[list.size()]);
	}

	/**
	 * Load HR_Movements and store them in a HR_Concept_ID->MHRMovement hashtable
	 * @param movements hashtable
	 * @param C_PBartner_ID
	 */
	private void loadMovements(Hashtable<Integer,MHRMovement> movements, int C_PBartner_ID)
	{
		final String whereClause = MHRMovement.COLUMNNAME_HR_Process_ID+"=?"
		+" AND "+MHRMovement.COLUMNNAME_C_BPartner_ID+"=?";
		List<MHRMovement> list = new Query(getCtx(), MHRMovement.Table_Name, whereClause, get_TrxName())
		.setParameters(new Object[]{getHR_Process_ID(), C_PBartner_ID})
		.list();
		for (MHRMovement mvm : list)
		{
			if(movements.containsKey(mvm.getHR_Concept_ID()))
			{
				MHRMovement lastM = movements.get(mvm.getHR_Concept_ID());
				String columntype = lastM.getColumnType();
				if (columntype.equals(MHRConcept.COLUMNTYPE_Amount))
				{
					mvm.addAmount(lastM.getAmount());
				}
				else if (columntype.equals(MHRConcept.COLUMNTYPE_Quantity))
				{
					mvm.addQty(lastM.getQty());
				
				}
			}
			movements.put(mvm.getHR_Concept_ID(), mvm);
		}
	}

	/**
	 * Execute the script
	 * @param AD_Rule_ID
	 * @param string 
	 * @return
	 */
	private Object executeScript(int AD_Rule_ID, String columnType)
	{
		MRule rulee = MRule.get(getCtx(), AD_Rule_ID);
		Object result = null;
		m_description = null;
		try
		{
			String text = "";
			String ptextG = ""; String ptextP = "";
			String tvar = "";
			
			if (rulee.getScript() != null)
			{
				int pos = rulee.getScript().lastIndexOf("_VariableP[");
				if(pos > 0){
					String[] frag= rulee.getScript().split("#");
					tvar = frag[1];
					//Genera las Variables Parcial que se estaran usando en los groovy para el empleado
					setVarParcial(m_employee.getC_BPartner_ID(), tvar); 
				}
				tvar= "#" + tvar + "#";
				
				
				ptextG= " VARIABLES_G : " + 
				(getVarGlobal() == null ? " " : getVarGlobal().replace("\"", ""));
				
				ptextP=  " VARIABLES_P : " + 
				(getVarParcial() == null ? " " : getVarParcial().replace("\"", ""));
				
				text = rulee.getScript().trim().replaceAll("\\bget", "process.get")
				.replace(".process.get", ".get")
				.replace("_VariableG[];", (getVarGlobal() == null ? " " : getVarGlobal())) // Variables Globales
				.replace("_VariableP[" + tvar + "];", (getVarParcial() == null ? " " : getVarParcial())) // Variables Parciales
				.replace("_PVariablesG[]", ptextG) // Variables para Imprimir
				.replace("_PVariablesP[]", ptextP); // Variables para Imprimir
				log.info("  ***************************************************************************************************");
				log.info("TEXT= "+text+"  ");
				log.info("  ***************************************************************************************************");

				
			}
			String resultType = "double";
			if  (MHRAttribute.COLUMNTYPE_Date.equals(columnType))
				resultType = "Timestamp";
			else if  (MHRAttribute.COLUMNTYPE_Text.equals(columnType))
				resultType = "String";
			final String script =
				s_scriptImport.toString()
				+"  " + resultType + " result = 0; "
				+" String description = null; "
				+ "DateFormat df = new SimpleDateFormat(\"yyyy-MM-dd 00:00:00\"); "
				+ text;
			Scriptlet engine = new Scriptlet (Scriptlet.VARIABLE, script, m_scriptCtx);	
			log.info("  ***************************************************************************************************");
			log.info("engine.variables= "+engine.getVariable() +" |||| engine.script=  "+engine.getScript());
			Exception ex = engine.execute();
			log.info("  ***************************************************************************************************");
			log.info("EX= "+ex+"  ");
			log.info("  ***************************************************************************************************");

			if (ex != null)
			{
				throw ex;
			}
			result = engine.getResult(false);
			m_description = engine.getDescription();
		}
		catch (Exception e)
		{
			throw new AdempiereException("Execution error - @AD_Rule_ID@="+rulee.getValue() + "  --C_BPartner_ID =" + m_employee.getC_BPartner_ID());
		}
		return result;
	}

	/**
	 * creates movements for concepts related to labor
	 * @param C_BPartner_ID
	 * @param period
	 
	private void createCostCollectorMovements(int C_BPartner_ID, MHRPeriod period)
	{
		List<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		whereClause.append("EXISTS (SELECT 1 FROM AD_User u WHERE u.AD_User_ID=PP_Cost_Collector.AD_User_ID AND u.C_BPartner_ID=?)");
		params.add(C_BPartner_ID);
		whereClause.append(" AND "+MPPCostCollector.COLUMNNAME_MovementDate + ">=?");
		params.add(period.getStartDate());
		whereClause.append(" AND "+MPPCostCollector.COLUMNNAME_MovementDate + "<=?");
		params.add(period.getEndDate());
		whereClause.append(" AND "+MPPCostCollector.COLUMNNAME_DocStatus + " IN (?,?)");
		params.add(MPPCostCollector.DOCSTATUS_Completed);
		params.add(MPPCostCollector.DOCSTATUS_Closed);

		List<MPPCostCollector> listColector = new Query(getCtx(), MPPCostCollector.Table_Name, 
				whereClause.toString(), get_TrxName())
		.setOnlyActiveRecords(true)
		.setParameters(params)
		.setOrderBy(MPPCostCollector.COLUMNNAME_PP_Cost_Collector_ID+" DESC") 
		.list();


		for (MPPCostCollector cc : listColector)
		{
			createMovementForCC(C_BPartner_ID, cc);
		}
	}
*/
	/**
	 * create movement for cost collector
	 * @param C_BPartner_ID
	 * @param cc
	 * @return
	 */
	private MHRMovement createMovementForCC(int C_BPartner_ID, I_PP_Cost_Collector cc)
	{
		//get the concept that should store the labor
		MHRConcept concept = MHRConcept.forValue(getCtx(), CONCEPT_PP_COST_COLLECTOR_LABOR);

		//get the attribute for specific concept
		List<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		whereClause.append("? >= ValidFrom AND ( ? <= ValidTo OR ValidTo IS NULL)");
		params.add(m_dateFrom);
		params.add(m_dateTo);
		whereClause.append(" AND HR_Concept_ID = ? ");
		params.add(concept.get_ID());
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept conc WHERE conc.HR_Concept_ID = HR_Attribute.HR_Concept_ID )");
		MHRAttribute att = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (att == null)
		{
			throw new AdempiereException(); // TODO ?? is necessary
		}

		if (MHRConcept.TYPE_RuleEngine.equals(concept.getType()))
		{
			Object result = null;

			m_scriptCtx.put("_CostCollector", cc);
			try
			{
				result = executeScript(att.getAD_Rule_ID(), att.getColumnType());
			}
			finally
			{
				m_scriptCtx.remove("_CostCollector");
			}
			if(result == null)
			{
				// TODO: throw exception ???
				log.warning("Variable (result) is null");
			}

			//get employee
			MHREmployee employee = MHREmployee.getActiveEmployee(getCtx(), C_BPartner_ID, get_TrxName());

			//create movement
			MHRMovement mv = new MHRMovement(this, concept);
			mv.setC_BPartner_ID(C_BPartner_ID);
			mv.setAD_Rule_ID(att.getAD_Rule_ID());
			mv.setHR_Job_ID(employee.getHR_Job_ID());
			mv.setHR_Department_ID(employee.getHR_Department_ID());
			mv.setC_Activity_ID(employee.getC_Activity_ID());
			mv.setValidFrom(m_dateFrom);
			mv.setValidTo(m_dateTo); 
			mv.setPP_Cost_Collector_ID(cc.getPP_Cost_Collector_ID());	
			mv.setIsRegistered(true);//Desmarcado por rmontano
			mv.setColumnValue(result);
			mv.setProcessed(true);
			mv.saveEx();
			return mv;
		}
		else
		{
			throw new AdempiereException(); //TODO ?? is necessary
		}

	}



	/**
	 * create Movements for corresponding process , period
	 */
	private void createMovements() throws Exception
	{
		m_scriptCtx.clear();
		m_scriptCtx.put("process", this);
		m_scriptCtx.put("_Process", getHR_Process_ID());
		m_scriptCtx.put("_Period", getHR_Period_ID());
		m_scriptCtx.put("_Payroll", getHR_Payroll_ID());
		m_scriptCtx.put("_Department", getHR_Department_ID());

		log.info("info data - " + " Process: " +getHR_Process_ID()+ ", Period: " +getHR_Period_ID()+ ", Payroll: " +getHR_Payroll_ID()+ ", Department: " +getHR_Department_ID());
		MHRPeriod period = new MHRPeriod(getCtx(), getHR_Period_ID(), get_TrxName());
		if (period != null)
		{
			m_dateFrom = period.getStartDate();
			m_dateTo   = period.getEndDate();
			m_scriptCtx.put("_From", period.getStartDate());
			m_scriptCtx.put("_To", period.getEndDate());
		}
		
		
		//Genera las Variables Globales que se estaran usando en los groovy
		setVarGlobal(); 
		
		
		
		Object[] par = null;
		String wherel ="";
		if (getC_BPartner_ID() !=0){
			wherel =" AND C_BPartner_ID = ? ";
			par = new Object[]{getHR_Process_ID(), false, getC_BPartner_ID()};
		}else if (getHR_Payroll_Type_Line_ID() != 0 ){
			wherel = " AND C_BPartner_ID IN (SELECT distinct C_BPartner_ID FROM HR_Employee WHERE HR_Payroll_Type_line_ID = " + getHR_Payroll_Type_Line_ID() + ")";
			par = new Object[]{getHR_Process_ID(), false};
		}else if (getHR_Standing_ID() != 0 ){
			wherel = " AND C_BPartner_ID IN (SELECT distinct C_BPartner_ID FROM HR_Employee WHERE HR_Standing_ID = " + getHR_Standing_ID() + ")";
			par = new Object[]{getHR_Process_ID(), false};
		}else{
			par = new Object[]{getHR_Process_ID(), false};
		}
		
		
		// RE-Process, delete movement except concept type Incidence 
		int no = DB.executeUpdateEx("DELETE FROM HR_Movement m WHERE HR_Process_ID=? AND IsWorkedTime = ? " + wherel,
				par, get_TrxName());
		log.info("HR_Movement deleted #"+ no);

		linesConcept = MHRPayrollConcept.getPayrollConcepts(this);
		// Hey, I can filter this array with Emloyees of Payrroll's Contract ???
		// this is the process, 
		MBPartner[] linesEmployee = MHREmployee.getEmployees(this);
		
		//
		int count = 1;
		for(MBPartner bp : linesEmployee)	//=============================================================== Employee
		{

			log.info("Employee ***************************************************************************************************");
			log.warning("Employee ******* "+bp.getC_BPartner_ID()+" ************** N° " + count + "  ------------- " + bp.getName());
			log.info("Employee ***************************************************************************************************");

			
			count++;
			m_C_BPartner_ID = bp.get_ID();
			m_C_BPartnerName = bp.getName();
			m_C_BPartnerCont = count;
			m_employee = MHREmployee.getActiveEmployee(getCtx(), m_C_BPartner_ID, get_TrxName());
			m_changejob = DB.getSQLValue(null,"select idchangjob from filter_employee_pay("+bp.get_ID()+",null,null,"+getHR_Process_ID()+")");
			m_scriptCtx.remove("_DateStart");
			m_scriptCtx.remove("_DateEnd");
			m_scriptCtx.remove("_Days");
			m_scriptCtx.remove("_C_BPartner_ID");
			m_scriptCtx.put("_DateStart", m_employee.getStartDate());
			m_scriptCtx.put("_DateEnd", m_employee.getEndDate() == null ? TimeUtil.getDay(2999, 12, 31) : m_employee.getEndDate());
			m_scriptCtx.put("_Days", org.compiere.util.TimeUtil.getDaysBetween(period.getStartDate(),period.getEndDate())+1);
			m_scriptCtx.put("_C_BPartner_ID", bp.getC_BPartner_ID());
			m_scriptCtx.put("_HR_Process_ID", getHR_Process_ID());

			//createCostCollectorMovements(bp.get_ID(), period);
			
			//Genera las Variables Parcial que se estaran usando en los groovy para el empleado
			listVareableP.clear();
			setVarParcial(m_employee.getC_BPartner_ID(), null); 
			//log.warning("m_movement ANTES ******* " + m_movement );
			m_movement.clear();
			//log.warning("m_movement DESPUES ******* " + m_movement );
			loadMovements(m_movement, m_C_BPartner_ID);
			//
			for(MHRPayrollConcept pc : linesConcept) // ==================================================== Concept
			{
				X_HR_Concept conce = new X_HR_Concept(Env.getCtx(), pc.getHR_Concept_ID(), get_TrxName());
				log.warning("HR_Concept_ID ******* " + pc.getHR_Concept_ID() + " concepto = " + conce.getName());
				
				m_HR_Concept_ID      = pc.getHR_Concept_ID();
				MHRConcept concept = MHRConcept.get(getCtx(), m_HR_Concept_ID);
				
				boolean printed = pc.isPrinted() || concept.isPrinted();
				MHRMovement movement = m_movement.get(concept.get_ID()); // as it's now recursive, it can happen that the concept is already generated
				if (movement == null) {
					
					movement = createMovementFromConcept(concept, printed);
					movement = m_movement.get(concept.get_ID());
				}
				if (movement == null)
				{
					throw new AdempiereException("Concept " + concept.getValue() + " not created");
				}
				
				log.info("Employee ***************************************************************************************************");
				log.warning("HR_Concept_ID ******* "+pc.getHR_Concept_ID()+"  -------qty= "+ movement.getQty() +" --- Amount=" +movement.getAmount()  + " ---printed " + printed);
				log.info("Employee ***************************************************************************************************");
			} // concept
			//for (MHRPayrollConcept pc : linesConcept)
			{
			//	log.warning("*/*/*/*/*/*/*/ pc:" + pc.getHR_Concept_ID());
			}
			//for (MHRMovement m: m_movement.values())
			{
			//	X_HR_Concept conce = new X_HR_Concept(Env.getCtx(), m.getHR_Concept_ID(), get_TrxName());
			//	log.warning("ID_concepto= "+m.getHR_Concept_ID() + " m = " + m. + " ID_NOMINA= " + m.getHR_Process_ID());
			}

			// Save movements: Se coloco directo en el Metodo createMovementFromConcept
			//log.warning( "m_movement.values() = "+ m_movement.values() );
			for (MHRMovement m: m_movement.values())
			{
				
				MHRConcept c = (MHRConcept) m.getHR_Concept();
				//log.warning("c = "+ c.isRegistered() + "   m = " + m.isEmpty() + "      concept = " + m.getHR_Concept_ID());
				if (c.isRegistered() || m.isEmpty())
				{	
					log.fine("Skip saving "+m);
				}
				else
				{
					boolean saveThisRecord =
						m.isPrinted() || c.isPaid() || c.isPrinted();
					//log.warning("saveThisRecord = " + saveThisRecord);
					
					if (saveThisRecord)
						m.saveEx();
				}
			}
			
		} // for each employee
		//
		// Save period & finish
		period.setProcessed(true);
		period.saveEx();
	} // createMovements

	private void getCompleted_Process_Vac() {
		
		String sql;
		String wherevac;
		int dayvac;
		
		MHRPeriod period = new MHRPeriod(getCtx(), getHR_Period_ID(), get_TrxName());
		if (period != null)
		{
			m_dateFrom = period.getStartDate();
			m_dateTo   = period.getEndDate();
		}
		
		String pclas =DB.getSQLValueString(null,"SELECT Payroll_Clasif FROM HR_Payroll WHERE HR_Payroll_id = " + getHR_Payroll_ID());
		String vprocess = DB.getSQLValueString(null,"SELECT processed FROM hr_vacationprog WHERE hr_process_id = " + getHR_Process_ID());
		if (pclas != null){
			if(pclas.equals("VAC") && vprocess.equals("N")){
				
				
				//MBPartner[] linesEmployee = MHREmployee.getEmployees(this);
				//for(MBPartner bp : linesEmployee)	//=============================================================== Employee
				//{
					
					
					//Cambia el status de vacaciones programada a pagado y las incidencias de vacaciones las inactivas
					
				    sql="SELECT v.hr_vacation_id, vpl.hr_vacation_incidence_id, COALESCE(hr_vacation_incidence2_id,0), v.pendays, vpl.ispaid, "
				    + " vpl.isreprogram, vpl.isanulate, v.hr_periodvac_id, RequisitionType, v.c_bpartner_id  FROM hr_vacationprog vp " +
				    "INNER JOIN hr_vacationprog_line vpl ON vpl.hr_vacationprog_id = vp.hr_vacationprog_id " +
				    "INNER JOIN hr_vacation v ON v.hr_vacation_id = vpl.hr_vacation_id " +
				    "LEFT JOIN hr_vacationrequisition vr ON vr.hr_vacationrequisition_id = vpl.hr_vacationrequisition_id "+
				    "WHERE vp.processed = 'N' and vp.hr_period_id= "+ getHR_Period_ID() + " and vp.hr_process_id= "+ getHR_Process_ID(); //+  " and  v.c_bpartner_id= " + bp.getC_BPartner_ID();
				    
				    try {
					   
						PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
						ResultSet rs = null;
						rs = pstmt.executeQuery ();
						
					    while (rs.next()){
					    	//JOptionPane.showMessageDialog(null,  getHR_Period_ID() + "  " + rs.getString(6) + "  " + rs.getInt(8));
					        if (rs.getString(5).equals("Y")){//ispaid
						        if (rs.getInt(3) != 0 ){
				
						            wherevac = "("+ rs.getInt(2) +", " + rs.getInt(3) + ")";
						            dayvac= rs.getInt(4) - DB.getSQLValue(null, "SELECT vacdays FROM hr_vacation_incidence where hr_vacation_incidence_id = " + rs.getInt(3));
				
						        }else{
				
						            wherevac = "("+ rs.getInt(2) + ")";
						            dayvac= rs.getInt(4);
						        }
				
						        DB.executeUpdate("Update hr_vacation Set ispaid ='Y', pendays= "+ dayvac +" Where hr_vacation_id = " + rs.getInt(1),null);
						        DB.executeUpdate("Update hr_vacation_incidence Set isActive ='N' Where hr_vacation_incidence_id in " +  wherevac, null);
	
					        }else if(rs.getString(6).equals("Y") || rs.getString(7).equals("Y")){
					        	
						        if (rs.getInt(3) != 0 ){
									
						            wherevac = "("+ rs.getInt(2) +", " + rs.getInt(3) + ")";
				
						        }else{
				
						            wherevac = "("+ rs.getInt(2) + ")";
						            dayvac= rs.getInt(4);
						        }
					        	
					        	DB.executeUpdate("Update hr_vacation_incidence Set isActive ='N', IsReprogPay ='Y' Where hr_vacation_incidence_id in " +  wherevac, null);
	
					        	if(rs.getString(6).equals("Y")){//Enviar correo
					        		
					                //Obtener Periodo
					                String sqlc="SELECT per.name FROM HR_PeriodVac per WHERE "
					                        +"HR_PeriodVac_ID="+ rs.getInt(8);
					                
					                String periodo=DB.getSQLValueString(null, sqlc);
					               
					                //Obtener Empleado
					                sqlc="SELECT emp.name FROM C_BPartner emp WHERE "
					                        +"C_BPartner_ID="+rs.getInt(10);
					                String empleado=DB.getSQLValueString(null, sqlc);
					               
					                //Obtener Zona oprecaion
					                sqlc="SELECT emp.HR_ZonaOperacion_ID FROM HR_Employee emp WHERE IsActive='Y' "
					                        +"AND C_BPartner_ID="+rs.getInt(10);
					                
					                String zo=DB.getSQLValueString(null, sqlc);
					               
					                //Obtener tipo de Solicitud
					                sqlc ="SELECT name FROM AD_Ref_List WHERE AD_Reference_ID=1000133 AND value='"+rs.getString(9)+"'";
					                String tipo = DB.getSQLValueString(null,sqlc);
					               
					                String titulo= "Reprogramar Vacaciones del período " + periodo + " de "+empleado;
					                
					        		 //Envio de correo por nodo de aprobación
					                /*sqlc="SELECT DISTINCT us.email, us.description "+
					                    "FROM AD_WF_NextCondition cond "+
					                    "INNER JOIN AD_WF_NodeNext pnod ON pnod.AD_WF_NodeNext_ID=cond.AD_WF_NodeNext_ID "+
					                    "INNER JOIN AD_WF_Node nod ON nod.AD_WF_Node_ID=pnod.AD_WF_Next_ID "+
					                    "INNER JOIN AD_Workflow wf ON nod.AD_Workflow_ID=wf.AD_Workflow_ID "+
					                    "INNER JOIN AD_WF_Responsible resp ON resp.AD_WF_Responsible_ID=nod.AD_WF_Responsible_ID "+
					                    "INNER JOIN AD_User_Roles rol_us ON rol_us.AD_Role_ID=resp.AD_Role_ID "+
					                    "INNER JOIN AD_User us ON us.AD_User_ID=rol_us.AD_User_ID "+
					                    "WHERE cond.AD_Column_ID=1005142 AND wf.AD_Workflow_ID=1000011 AND rol_us.IsActive='Y' AND not us.AD_User_ID =100 AND cond.value='"+zo+"'";
									*/
									
					                //Enviar Correo a Encargado de Aprobar Vacaciones
					                sqlc="SELECT u.email, u.description FROM HR_Employee e "+
					                            "INNER JOIN HR_ZonaOperacion zo ON zo.HR_ZonaOperacion_ID=e.HR_ZonaOperacion_ID "+
					                            "INNER JOIN AD_User u ON u.AD_User_ID=(CASE WHEN zo.ElaborateVac_ID is null THEN zo.Elaborate1_ID ELSE zo.ElaborateVac_ID END) "+
					                            "WHERE e.IsActive='Y' AND e.C_BPartner_ID= " + rs.getInt(10);
					                
					                PreparedStatement pstmtc = DB.prepareStatement (sqlc, get_TrxName());
					                ResultSet rsc;
					                try {
					                    rsc = pstmtc.executeQuery ();
					                    while (rsc.next ())
					                    {
	
					                        String supervisor=rsc.getString(2);
					                        String mail_u= rsc.getString(1);
					                       
					                        String body = "<P>Estimado (s) Señor(es) "+ supervisor +"</p> " +
					                                "<P>Por medio del presente  solicitamos reprogramar las vacaciones del Sr(a). "+empleado+".</p>" +
					                                "<P>Para visualizar la solicitud pulse aquí " +
					                                "<A HREF=\"http://adempiere.esvenca.com:8084/webui/\">ADempiere</A>. "+
					                                "<br><br><br>"+
					                                "<p ALIGN=right><i>Esperando brindarle la Calidad de Servicio que usted se merece." +
					                                "<br>Equipo de Planificación y Compensación.</i></p>" +
					                                "<br>" +
					                                "<P ALIGN=right><FONT SIZE=2>En caso de perdida de usuario o clave ADempiere comunicarse con "+
					                                "<A HREF= \"http://soporte.esvenca.com\">Soporte IT</A>.</FONT>";
					                                   
				                                    NewEmail correo = new NewEmail();
					                                    //sendEmail(Properties ctx, String to,String tittle,String subtittle, String body, String note)
								                    	//JOptionPane.showMessageDialog(null, rs.getInt(10));
				                                    correo.sendEmail(mail_u, titulo, null, body);
					                    }
					                } catch (SQLException e) {
					                   
					                    e.printStackTrace();
					                }
					        	}
					        	
					        }//fin ispaid
					    }
			
					} catch (SQLException e) {
						
						e.printStackTrace();//Proceso para parar el documento originario
					}
				  //Al completar la nomina colocar procesado la Programación de Pagos
			        DB.executeUpdate("Update hr_vacationprog Set processed ='Y' WHERE processed = 'N' and hr_period_id= "+ getHR_Period_ID() + " and hr_process_id= "+ getHR_Process_ID(), null);
				}
			
		}else{
			
			// Lista de Empleados
			String whereClause = " HR_Employee.C_BPartner_ID in (SELECT distinct C_BPartner_ID FROM hr_movement WHERE hr_process_id = ?) "
					+ "AND (SELECT idemployee FROM  filter_employee(HR_Employee.C_BPartner_ID, null, null, ?))= HR_Employee_ID "
					+ "AND HR_Employee.Ad_Org_ID = ? ";
			List<Object> params = new ArrayList<Object>();
			params.add(getHR_Process_ID());
			params.add(getHR_Process_ID());
			params.add(getAD_Org_ID());
				
			listEmployee = new Query(getCtx(), MHREmployee.Table_Name, whereClause.toString(), get_TrxName())
			.setParameters(params)
			.setOrderBy(MHREmployee.COLUMNNAME_C_BPartner_ID)
			.list();
			
			for( MHREmployee emp : listEmployee){
				
				int cc = DB.getSQLValue(null, "SELECT COALESCE(MAX(m.C_Activity_ID),0) FROM hr_movement m "
				+ " INNER JOIN hr_concept c ON c.hr_concept_id = m.hr_concept_id "
				+ " WHERE hr_process_id = "+ getHR_Process_ID() +" AND isworkedtime = 'Y' and C_BPartner_ID = "+ emp.getC_BPartner_ID() +" and"
				+ " c.ismanual = 'N'");
				
				if (cc != emp.getC_Activity_ID() && emp.getC_Activity_ID()!= 0){
					//Actualiza el Centro de Costo del empleado
					DB.executeUpdate("Update HR_Employee Set C_Activity_ID ="+ cc +"  WHERE HR_Employee_ID = " + emp.getHR_Employee_ID(), null);
				}
				//Actualiza el movimiento de rotacion
				String sqlw = "Update HR_RotationMove SET Processed = 'Y' WHERE DateEnd <= '"+ m_dateTo +"' "
						+ "AND C_BPartner_ID = "+ emp.getC_BPartner_ID() +" AND Processed = 'N'";
				DB.executeUpdate(sqlw, null);
			}
			
			 		
		}
		
		
	}//getCompleted_Process_Vac
	
	/*Completa el proceso de liquidacion */
	/****************************************/
	private void getCompleted_Process_Liq(){
		
		String sql =("SELECT lpl.hr_liquidationrequisition_id, lpl.C_BPartner_ID, lpl.ispaid, lpl.paidlist "
				+ " FROM hr_liquidationprog lp "
				+ " INNER JOIN hr_liquidationprog_line lpl ON lpl.hr_liquidationprog_id = lp.hr_liquidationprog_id"
				+ " WHERE lp.HR_Process_ID = " + getHR_Process_ID());
		
        PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
        ResultSet rs;
        try {
	            rs = pstmt.executeQuery ();
	            while (rs.next ())
	            {
	            	if(rs.getString(4).equals("P")){
	            		DB.executeUpdate("Update hr_liquidationrequisition Set ispaid ='Y', docstatus='CO', docaction='CL', processed='Y' "
	            			+ " Where hr_liquidationrequisition_id = " +  rs.getInt(1) + " and C_BPartner_ID = " + rs.getInt(2), null);
	            	}else{
	            		// RE-Process, delete movement except concept type Incidence 
	            		int no = DB.executeUpdateEx("DELETE FROM HR_Movement WHERE HR_Process_ID = " + getHR_Process_ID() + " AND C_BPartner_ID = " + rs.getInt(2), null);
	            	}
	            }
	            pstmt.close();
	            rs.close();
            } catch (SQLException e) {
				
				e.printStackTrace();//Proceso para parar el documento originario
			}
        	
		 //Al completar la nomina colocar procesado la Programación de Pagos
        DB.executeUpdate("Update hr_liquidationprog Set processed ='Y' WHERE processed = 'N' and hr_process_id= "+ getHR_Process_ID(), null);
	}
	

	private MHRMovement createMovementFromConcept(MHRConcept concept,
			boolean printed) {
		log.info("Calculating concept " + concept.getValue());
		m_columnType       = concept.getColumnType();
		
		 
		
		//JOptionPane.showMessageDialog(null, getCtx());
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		
		String sql ="SELECT COALESCE(Payroll_Clasif,'Q') FROM HR_Payroll WHERE HR_Payroll_ID = " + getHR_Payroll_ID();
		String tn = DB.getSQLValueString(null, sql);
		
		/*if (!tn.equals("UT")){
			whereClause.append("? >= ValidFrom AND ( ? <= ValidTo OR ValidTo IS NULL)");
			params.add(m_dateFrom);
			params.add(m_dateTo);
			whereClause.append(" AND HR_Concept_ID = ? ");
		}else{
			whereClause.append(" HR_Concept_ID = ? ");
		}*/
		
		whereClause.append(" HR_Concept_ID = ? ");
		params.add(concept.getHR_Concept_ID());
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept conc WHERE conc.HR_Concept_ID = HR_Attribute.HR_Concept_ID )");

		// Check the concept is within a valid range for the attribute
		if (concept.isEmployee())
		{
			whereClause.append(" AND C_BPartner_ID = ? AND (HR_Employee_ID = ? OR HR_Employee_ID IS NULL)");
			params.add(m_employee.getC_BPartner_ID());
			params.add(m_employee.get_ID());
		}

		MHRAttribute att = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (att == null || concept.isRegistered())
		{
			log.info("Skip concept "+concept+" - attribute not found");
			MHRMovement dummymov = new MHRMovement (getCtx(), 0, get_TrxName());
			dummymov.setIsRegistered(true); // to avoid landing on movement table
			//log.warning("ANTES DEL PUT concept.getHR_Concept_ID() = " + concept.getHR_Concept_ID() + " movement = " + dummymov);
			m_movement.put(concept.getHR_Concept_ID(), dummymov);
			//log.warning("m_movement.values() = " + m_movement.values());
			return dummymov;
		}

		log.info("Concept - " + concept.getName());
		log.info("Socio N: ****** " + m_C_BPartnerName + "  N°: " + (m_C_BPartnerCont - 1) + "  [" + m_employee.getC_BPartner_ID()+"]");
		
		MHRMovement movement = new MHRMovement (getCtx(), 0, get_TrxName());
		movement.setC_BPartner_ID(m_C_BPartner_ID);
		movement.setHR_Concept_ID(concept.getHR_Concept_ID());
		movement.setHR_Concept_Category_ID(concept.getHR_Concept_Category_ID());
		movement.setHR_Process_ID(getHR_Process_ID());
		movement.setHR_Department_ID(m_employee.getHR_Department_ID());
		movement.setHR_Job_ID(m_employee.getHR_Job_ID());
		movement.setHR_Change_Job_ID(m_changejob);
		movement.setColumnType(m_columnType);
		movement.setAD_Rule_ID(att.getAD_Rule_ID());
		movement.setValidFrom(m_dateFrom);
		movement.setValidTo(m_dateTo);
		movement.setIsPrinted(printed);
		movement.setIsRegistered(concept.isRegistered());//Desmarcado por rmontano
		movement.setC_Activity_ID(m_employee.getC_Activity_ID());
		
		if (concept.getHR_Concept_ID()==1001050 || concept.getHR_Concept_ID()==1000653)
		{
			//JOptionPane.showMessageDialog(null, "snb*******");
		}
		
		if (MHRConcept.TYPE_RuleEngine.equals(concept.getType()))
		{
			log.info("--------------------------------------------------------------------------");
			log.info("Executing rule for concept " + concept.getValue());
			log.info("concept type " + concept.getType());
			log.info("--------------------------------------------------------------------------");
			
			if (activeConceptRule.contains(concept)) {
				throw new AdempiereException("Recursion loop detected in concept " + concept.getValue());
			}
			activeConceptRule.add(concept);
			
			log.info("--------------------------------------------------------------------------");
			log.info("ad_rule_id " + att.getAD_Rule_ID() + " ***** getColumnType " + att.getColumnType());
			log.info("--------------------------------------------------------------------------");
			
			Object result = executeScript(att.getAD_Rule_ID(), att.getColumnType());
			activeConceptRule.remove(concept);
			if (result == null)
			{
				// TODO: throw exception ???
				log.warning("Variable (result) is null");
				return movement;
			}
			movement.setColumnValue(result); // double rounded in MHRMovement.setColumnValue
			if (m_description != null)
				movement.setDescription(m_description.toString());
		}
		else
		{
			movement.setQty(att.getQty()); 
			movement.setAmount(att.getAmount());
			movement.setTextMsg(att.getTextMsg());						
			movement.setServiceDate(att.getServiceDate());
		}
		movement.setProcessed(true);
		//log.warning("ANTES DEL PUT concept.getHR_Concept_ID() = " + concept.getHR_Concept_ID() + " movement = " + movement);
		m_movement.put(concept.getHR_Concept_ID(), movement);
		//log.warning("m_movement.values() = " + m_movement.values());
		
		/*MHRConcept c = (MHRConcept) movement.getHR_Concept();
		if (c.isRegistered() || movement.isEmpty())
		{	
			log.fine("Skip saving "+ movement);
		}
		else
		{
			boolean saveThisRecord =
					movement.isPrinted() || c.isPaid() || c.isPrinted();
			if (saveThisRecord)
				movement.saveEx();
		}*/
		
		return movement;
	}



	// Helper methods -------------------------------------------------------------------------------

	/**
	 * Helper Method : get the value of the concept
	 * @param pconcept
	 * @return
	 */
	public double getConcept (String pconcept)
	{
		
 		MHRConcept concept = MHRConcept.forValue(getCtx(), pconcept.trim());

		if (concept == null)
		{
			return 0; // TODO throw exception ?
		}

		MHRMovement m = m_movement.get(concept.get_ID());
		if (m == null) {
			createMovementFromConcept(concept, concept.isPrinted());
			m = m_movement.get(concept.get_ID());
		}
		if (m == null)
		{
			throw new AdempiereException("Concept " + concept.getValue() + " not created");
		}

		String type = m.getColumnType();
		if (MHRMovement.COLUMNTYPE_Amount.equals(type))
		{
			return m.getAmount().doubleValue();
			
		}
		else if (MHRMovement.COLUMNTYPE_Quantity.equals(type))
		{
			return m.getQty().doubleValue();
		}
		else
		{
			// TODO: throw exception ?
			return 0;
		}
	} // getConcept

	/**
	 * Helper Method : get the value of the concept string type
	 * @param pconcept
	 * @return
	 */
	public String getConceptString (String pconcept)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pconcept.trim());

		if (concept == null)
		{
			return null; // TODO throw exception ?
		}

		MHRMovement m = m_movement.get(concept.get_ID());
		if (m == null) {
			createMovementFromConcept(concept, concept.isPrinted());
			m = m_movement.get(concept.get_ID());
		}

		String type = m.getColumnType();
		if (MHRMovement.COLUMNTYPE_Text.equals(type))
		{
			return m.getTextMsg();
		}
		else
		{
			// TODO: throw exception ?
			return null;
		}
	} // getConceptString

	/**
	 * Helper Method : get the value of the concept date type
	 * @param pconcept
	 * @return
	 */
	public Timestamp getConceptDate (String pconcept)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pconcept.trim());

		if (concept == null)
		{
			return null; // TODO throw exception ?
		}

		MHRMovement m = m_movement.get(concept.get_ID());
		if (m == null) {
			createMovementFromConcept(concept, concept.isPrinted());
			m = m_movement.get(concept.get_ID());
		}

		String type = m.getColumnType();
		if (MHRMovement.COLUMNTYPE_Text.equals(type))
		{
			return m.getServiceDate();
		}
		else
		{
			// TODO: throw exception ?
			return null;
		}
	} // getConceptDate

	/**
	 * Helper Method : sets the value of a concept
	 * @param conceptValue
	 * @param value
	 */
	public void setConcept (String conceptValue, double value)
	{
		try
		{
			MHRConcept c = MHRConcept.forValue(getCtx(), conceptValue); 
			if (c == null)
			{
				return; // TODO throw exception
			}
			MHRMovement m = new MHRMovement(getCtx(), 0, get_TrxName());
			MHREmployee employee = MHREmployee.getActiveEmployee(getCtx(), m_C_BPartner_ID, get_TrxName());
			m.setColumnType(c.getColumnType());
			m.setColumnValue(BigDecimal.valueOf(value));

			m.setHR_Process_ID(getHR_Process_ID());
			//m.setHR_Concept_ID(m_HR_Concept_ID);
			m.setHR_Concept_ID(c.getHR_Concept_ID());
			m.setC_BPartner_ID(m_C_BPartner_ID);
			m.setDescription("Agregado por regla"); // TODO: translate
			m.setValidFrom(m_dateFrom);
			m.setValidTo(m_dateTo);
			m.setHR_Change_Job_ID(m_changejob);
			
			m.setHR_Concept_Category_ID(c.getHR_Concept_Category_ID());
			m.setHR_Department_ID(employee.getHR_Department_ID());
			m.setHR_Job_ID(employee.getHR_Job_ID());
			m.setIsRegistered(c.isRegistered());
			m.setC_Activity_ID(employee.getC_Activity_ID());
			// m.setProcessed(true);  ??			
			
			m.saveEx();
		} 
		catch(Exception e)
		{
			s_log.warning(e.getMessage());
		}
	} // setConcept
	
	/* Helper Method : sets the value of a concept and set if isRegistered 
	* @param conceptValue
	* @param value
	* @param isRegistered
	*/
	public void setConcept (String conceptValue,double value,boolean isRegistered)
	{
		try
		{
			MHRConcept c = MHRConcept.forValue(getCtx(), conceptValue); 
			if (c == null)
			{
				return; // TODO throw exception
			}
			MHRMovement m = new MHRMovement(Env.getCtx(),0,get_TrxName());
			MHREmployee employee = MHREmployee.getActiveEmployee(getCtx(), m_C_BPartner_ID, get_TrxName());
			m.setColumnType(c.getColumnType());
			if (c.getColumnType().equals(MHRConcept.COLUMNTYPE_Amount))
				m.setAmount(BigDecimal.valueOf(value));
			else if (c.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity))
				m.setQty(BigDecimal.valueOf(value));
			else
				return;
			m.setHR_Process_ID(getHR_Process_ID());
			m.setHR_Concept_ID(c.getHR_Concept_ID());
			m.setC_BPartner_ID(m_C_BPartner_ID);
			m.setDescription("Added From Rule"); // TODO: translate
			m.setValidFrom(m_dateTo);
			m.setValidTo(m_dateTo);
			m.setIsRegistered(isRegistered);
			m.setHR_Change_Job_ID(m_changejob);
			
			m.setHR_Concept_Category_ID(c.getHR_Concept_Category_ID());
			m.setHR_Department_ID(employee.getHR_Department_ID());
			m.setHR_Job_ID(employee.getHR_Job_ID());
			m.setIsRegistered(c.isRegistered());
			m.setC_Activity_ID(employee.getC_Activity_ID());
			// m.setProcessed(true);  ??			

			m.saveEx();
		} 
		catch(Exception e)
		{
			s_log.warning(e.getMessage());
		}
	} // setConcept

	/**
	 * Helper Method : get the sum of the concept values, grouped by the Category
	 * @param pconcept
	 * @return
	 */
	public double getConceptGroup (String pconcept)
	{
		final MHRConceptCategory category = MHRConceptCategory.forValue(getCtx(), pconcept);
		if (category == null)
		{
			return 0.0; // TODO: need to throw exception ?
		}
		//
		double value = 0.0;
		for(MHRPayrollConcept pc : linesConcept)
		{
			MHRConcept con = MHRConcept.get(getCtx(), pc.getHR_Concept_ID());
			if(con.getHR_Concept_Category_ID() == category.get_ID())
			{
				MHRMovement movement = m_movement.get(pc.getHR_Concept_ID());
				if (movement == null) {
					createMovementFromConcept(con, con.isPrinted());
					movement = m_movement.get(con.get_ID());
				}
				else
				{
					String columnType = movement.getColumnType();
					if(MHRConcept.COLUMNTYPE_Amount.equals(columnType))
					{
						value += movement.getAmount().doubleValue();
					}
					else if (MHRConcept.COLUMNTYPE_Quantity.equals(columnType))
					{
						value += movement.getQty().doubleValue();
					}
				}
			}
		}
		return value;
	} // getConceptGroup


	/**
	 * Helper Method : Get Concept [get concept to search key ]
	 * @param pList Value List
	 * @param amount Amount to search
	 * @param column Number of column to return (1.......8)
	 * @return The amount corresponding to the designated column 'column'
	 */
	public double getList (String pList, double amount, String columnParam)
	{
		BigDecimal value = Env.ZERO;
		String column = columnParam;
		if (m_columnType.equals(MHRConcept.COLUMNTYPE_Amount))
		{
			column = column.toString().length() == 1 ? "Col_"+column : "Amount"+column;
			ArrayList<Object> params = new ArrayList<Object>();
			String sqlList = "SELECT " +column+
				" FROM HR_List l " +
				"INNER JOIN HR_ListVersion lv ON (lv.HR_List_ID=l.HR_List_ID) " +
				"INNER JOIN HR_ListLine ll ON (ll.HR_ListVersion_ID=lv.HR_ListVersion_ID) " +
				"WHERE l.IsActive='Y' AND lv.IsActive='Y' AND ll.IsActive='Y' AND l.Value = ? AND " +
				"l.AD_Client_ID = ? AND " +
				"(? BETWEEN lv.ValidFrom AND lv.ValidTo ) AND " +
				"(? BETWEEN ll.MinValue AND	ll.MaxValue)";
			params.add(pList);
			params.add(getAD_Client_ID());
			params.add(m_dateFrom);
			params.add(BigDecimal.valueOf(amount));

			value = DB.getSQLValueBDEx(get_TrxName(),sqlList,params);
		}
		//
		if (value == null)
		{
			throw new IllegalStateException("getList Out of Range");
		}
		return value.doubleValue();
	} // getList


	/**
	 * Helper Method : Get Attribute [get Attribute to search key concept ]
	 * @param pConcept - Value to Concept
	 * @return	Amount of concept, applying to employee
	 */ 
	public double getAttribute (String pConcept)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pConcept);
		if (concept == null)
			return 0;

		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		// check ValidFrom:
		whereClause.append(MHRAttribute.COLUMNNAME_ValidFrom + "<=?");
		params.add(m_dateFrom);
		//check client
		whereClause.append(" AND AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID" 
				+ " AND c.Value = ?)");
		params.add(pConcept);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}

		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return 0.0;

		// if column type is Quantity return quantity
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity))
			return attribute.getQty().doubleValue();

		// if column type is Amount return amount
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Amount))
			return attribute.getAmount().doubleValue();

		//something else
		return 0.0; //TODO throw exception ?? 
	} // getAttribute


	// LVE Localización Venezuela - RTSC: 14/03/2011
	/**
	 * Helper Method : Get Attribute [get Attribute to search key concept and date ]
	 * @param pConcept - Value to Concept
	 * @param date
	 * @return	Amount of concept, applying to employee
	 */ 
	public double getAttribute (String pConcept, Timestamp date)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pConcept);
		if (concept == null)
			return 0;
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append(" AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID AND c.Value = ? AND ((? >= HR_Attribute.validfrom AND HR_Attribute.validto IS NULL) OR (? >= HR_Attribute.validfrom AND ? <= HR_Attribute.validto)))");
		params.add(pConcept);
		params.add(date);
		params.add(date);
		params.add(date);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}
		
		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return 0.0;

		// if column type is Quantity return quantity
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity))
			return attribute.getQty().doubleValue();

		// if column type is Amount return amount
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Amount))
			return attribute.getAmount().doubleValue();

		//something else
		return 0.0; //TODO throw exception ?? 
	} // getAttribute

	// LVE Localización Venezuela - JCRA: 14/03/2011
    /**
	* Helper Method : Get Attribute [get Attribute to search key concept and date ] 
	* @param pConcept - Value to Concept
	* @param date1
	* @param date2
	* @return	Amount of concept, applying to employee
	*/ 
	public double getAttribute (String pConcept, Timestamp date1, Timestamp date2)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pConcept);
		if (concept == null)
			return 0;
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		// check ValidFrom:
		whereClause.append(MHRAttribute.COLUMNNAME_ValidFrom + "<=?");
		params.add(date2);
		//check client
		whereClause.append(" AND AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID AND c.Value = ? " 
		+ " AND (HR_Attribute.validto IS NULL OR HR_Attribute.validto >= ?) )");
		params.add(pConcept);
		params.add(date1);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}
		
		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return 0.0;
	
		// if column type is Quantity return quantity
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity))
			return attribute.getQty().doubleValue();
	
		// if column type is Amount return amount
		if (concept.getColumnType().equals(MHRConcept.COLUMNTYPE_Amount))
			return attribute.getAmount().doubleValue();
	
		//something else
		return 0.0; //TODO throw exception ?? 
	} // getAttribute
	
	/**
	 * 	Helper Method : Get Attribute [get Attribute to search key concept ]
	 *  @param conceptValue
	 *  @return ServiceDate
	 */ 
	public Timestamp getAttributeDate (String conceptValue, Timestamp date)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return null;

		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID AND c.Value = ? AND ((? >= HR_Attribute.validfrom AND HR_Attribute.validto IS NULL) OR (? >= HR_Attribute.validfrom AND ? <= HR_Attribute.validto)))");
		params.add(conceptValue);
		params.add(date);
		params.add(date);
		params.add(date);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
         // LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}
		
		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return null;

		return attribute.getServiceDate();
	} // getAttributeDate

	/**
	 * 	Helper Method : Get Attribute [get Attribute to search key concept ]
	 *  @param conceptValue
	 *  @return ServiceDate
	 */ 
	public Timestamp getAttributeDate (String conceptValue)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return null;
        //JOptionPane.showMessageDialog(null, "OK");
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID" 
				+ " AND c.Value = ?)");
		params.add(conceptValue);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
         // LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}

		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return null;

		return attribute.getServiceDate();
	} // getAttributeDate

	/**
	 * 	Helper Method : Get Attribute [get Attribute to search key concept ]
	 *  @param conceptValue
	 *  @return TextMsg
	 */ 
	public String getAttributeString (String conceptValue)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return null;

		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID" 
				+ " AND c.Value = ?)");
		params.add(conceptValue);
		//
		if (!concept.getType().equals(MHRConcept.TYPE_Information))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}

		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		if (attribute == null)
			return null;

		return attribute.getTextMsg();
	} // getAttributeString

	/**
	 * 	Helper Method : Get the number of days between start and end, in Timestamp format
	 *  @param date1 
	 *  @param date2
	 *  @return no. of days
	 */ 
	public int getDays (Timestamp date1, Timestamp date2)
	{		
		// adds one for the last day
		return org.compiere.util.TimeUtil.getDaysBetween(date1,date2) + 1;
	} // getDays


	/**
	 * 	Helper Method : Get the number of days between start and end, in String format
	 *  @param date1 
	 *  @param date2
	 *  @return no. of days
	 */  
	public  int getDays (String date1, String date2)
	{		
		Timestamp dat1 = Timestamp.valueOf(date1);
		Timestamp dat2 = Timestamp.valueOf(date2);
		return getDays(dat1, dat2);
	}  // getDays

	/**
	 * 	Helper Method : Get Months, Date in Format Timestamp
	 *  @param start
	 *  @param end
	 *  @return no. of month between two dates
	 */ 
	public int getMonths(Timestamp startParam,Timestamp endParam)
	{
		boolean negative = false;
		Timestamp start = startParam;
		Timestamp end = endParam;
		if (end.before(start))
		{
			negative = true;
			Timestamp temp = start;
			start = end;
			end = temp;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(start);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		GregorianCalendar calEnd = new GregorianCalendar();

		calEnd.setTime(end);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);

		if (cal.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR))
		{
			if (negative)
				return (calEnd.get(Calendar.MONTH) - cal.get(Calendar.MONTH)) * -1;
			return calEnd.get(Calendar.MONTH) - cal.get(Calendar.MONTH);
		}

		//	not very efficient, but correct
		int counter = 0;
		while (calEnd.after(cal))
		{
			cal.add (Calendar.MONTH, 1);
			counter++;
		}
		if (negative)
			return counter * -1;
		return counter;
	} // getMonths


	/**
	 * Helper Method : Concept for a range from-to in periods.
	 * Periods with values of 0 -1 1, etc. actual previous one period, next period
	 * 0 corresponds to actual period.
	 * @param conceptValue concept key(value)
	 * @param periodFrom the search is done by the period value, it helps to search from previous years
	 * @param periodTo
	 */
	public double getConcept (String conceptValue, int periodFrom, int periodTo)
	{
		return getConcept(conceptValue, null, periodFrom,periodTo);
	} // getConcept

	/**
	 *  Helper Method : Concept by range from-to in periods from a different payroll
	 *  periods with values 0 -1 1, etc. actual previous one period, next period
	 *  0 corresponds to actual period
	 *  @param conceptValue 
	 *  @param pFrom 
	 *  @param pTo the search is done by the period value, it helps to search from previous years
	 *  @param payrollValue is the value of the payroll.
	 */
	public double getConcept(String conceptValue, String payrollValue, int periodFrom, int periodTo)
	{
		int payroll_id;
		if (payrollValue == null)
		{
			payroll_id = getHR_Payroll_ID();
		}
		else
		{
			payroll_id = MHRPayroll.forValue(getCtx(), payrollValue).get_ID();
		}

		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return 0.0;
		//
		// Detect field name
		final String fieldName;
		if (MHRConcept.COLUMNTYPE_Quantity.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Amount;
		}
		else
		{
			return 0; // TODO: throw exception?
		}
		//
		MHRPeriod p = MHRPeriod.get(getCtx(), getHR_Period_ID());
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_C_BPartner_ID  + "=?");
		params.add(m_C_BPartner_ID);
		//
		//check process and payroll
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Process p"
				+" INNER JOIN HR_Period pr ON (pr.HR_Period_id=p.HR_Period_ID)"
				+" WHERE HR_Movement.HR_Process_ID = p.HR_Process_ID" 
				+" AND p.HR_Payroll_ID = ?");

		params.add(payroll_id);
		if (periodFrom < 0)
		{
			whereClause.append(" AND pr.PeriodNo >= ?");
			params.add(p.getPeriodNo() + periodFrom);
		}
		if (periodTo > 0)
		{
			whereClause.append(" AND pr.PeriodNo <= ?");
			params.add(p.getPeriodNo() + periodTo);
		}
		whereClause.append(")");
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovement.Table_Name)
		.append(" WHERE ").append(whereClause);
		BigDecimal value = DB.getSQLValueBDEx(get_TrxName(), sql.toString(), params);
		return value.doubleValue();

	} // getConcept
	
	/**
	 *  Helper Method : Concept by range from-to in periods from a different payroll
	 *  periods with values 0 -1 1, etc. actual previous one period, next period
	 *  0 corresponds to actual period
	 *  @param conceptValue 
	 *  @param period_id key the table
	 *  @param payrollValue is the value of the payroll.
	 */
	public double getConcept(String conceptValue, String payrollValue, int period_id)
	{
		int payroll_id;
		if (payrollValue == null)
		{
			payroll_id = getHR_Payroll_ID();
		}
		else
		{
			payroll_id = MHRPayroll.forValue(getCtx(), payrollValue).get_ID();
		}

		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return 0.0;
		//
		// Detect field name
		final String fieldName;
		if (MHRConcept.COLUMNTYPE_Quantity.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Amount;
		}
		else
		{
			return 0; // TODO: throw exception?
		}
		//
		//MHRPeriod p = MHRPeriod.get(getCtx(), getHR_Period_ID());
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_C_BPartner_ID  + "=?");
		params.add(m_C_BPartner_ID);
		//
		//check process and payroll
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Process p"
				+" INNER JOIN HR_Period pr ON (pr.HR_Period_id=p.HR_Period_ID)"
				+" WHERE HR_Movement.HR_Process_ID = p.HR_Process_ID" 
				+" AND p.HR_Payroll_ID = ?");

		params.add(payroll_id);
		if (period_id > 0)
		{
			whereClause.append(" AND pr.HR_Period_ID = ?");
			params.add(period_id);
		}
		whereClause.append(")");
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovement.Table_Name)
		.append(" WHERE ").append(whereClause);
		BigDecimal value = DB.getSQLValueBDEx(get_TrxName(), sql.toString(), params);
		return value.doubleValue();

	} // getConcept

	/**
	 * Helper Method: gets Concept value of a payrroll between 2 dates
	 * @param pConcept
	 * @param pPayrroll
	 * @param from
	 * @param to
	 * */
	public double getConcept (String conceptValue, String payrollValue,Timestamp from,Timestamp to)
	{
		int payroll_id;
		if (payrollValue == null)
		{
			payroll_id = getHR_Payroll_ID();
		}
		else
		{
			payroll_id = MHRPayroll.forValue(getCtx(), payrollValue).get_ID();
		}
		
		MHRConcept concept = MHRConcept.forValue(getCtx(), conceptValue);
		if (concept == null)
			return 0.0;
		//
		// Detect field name
		final String fieldName;
		if (MHRConcept.COLUMNTYPE_Quantity.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovement.COLUMNNAME_Amount;
		}
		else
		{
			return 0; // TODO: throw exception?
		}
		//
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovement.COLUMNNAME_C_BPartner_ID  + "=?");
		params.add(m_C_BPartner_ID);
		
		if (from == null)
			return 0.0;
		if (to == null)
			return 0.0;
		
		//Adding dates 
		whereClause.append(" AND validTo BETWEEN ? AND ?");
		params.add(from);
		params.add(to);
		//
		//check process and payroll
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Process p"
							+" INNER JOIN HR_Period pr ON (pr.HR_Period_id=p.HR_Period_ID)"
							+" WHERE HR_Movement.HR_Process_ID = p.HR_Process_ID" 
							+" AND p.HR_Payroll_ID=?");

		params.add(payroll_id);
		
		whereClause.append(")");
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovement.Table_Name)
								.append(" WHERE ").append(whereClause);
		BigDecimal value = DB.getSQLValueBDEx(get_TrxName(), sql.toString(), params);
		return value.doubleValue();
		
	} // getConcept
	
	/**
	 * Helper Method : Attribute that had from some date to another to date,
	 * if it finds just one period it's seen for the attribute of such period 
	 * if there are two or more attributes based on the days
	 * @param ctx
	 * @param vAttribute
	 * @param dateFrom
	 * @param dateTo
	 * @return attribute value
	 */
	public double getAttribute (Properties ctx, String vAttribute, Timestamp dateFrom, Timestamp dateTo)
	{
		// TODO ???
		log.warning("not implemented yet -> getAttribute (Properties, String, Timestamp, Timestamp)");
		return 0;
	} // getAttribute

	/**
	 *  Helper Method : Attribute that had from some period to another to period,
	 *   periods with values 0 -1 1, etc. actual previous one period, next period
	 *  0 corresponds to actual period
	 *  Value of HR_Attribute
	 *  if it finds just one period it's seen for the attribute of such period 
	 *  if there are two or more attributes 
	 *  pFrom and pTo the search is done by the period value, it helps to search 
	 *  from previous year based on the days
	 *  @param ctx
	 *  @param vAttribute
	 *  @param periodFrom
	 *  @param periodTo
	 *  @param pFrom
	 *  @param pTo
	 *  @return attribute value	  
	 */
	public double getAttribute (Properties ctx, String vAttribute, int periodFrom,int periodTo,
			String pFrom,String pTo)
	{
		// TODO ???
		log.warning("not implemented yet -> getAttribute (Properties, String, int, int, String, String)");
		return 0;
	} // getAttribute
	
	
		
	/**
	 * Helper Method : Get AttributeInvoice 
	 * @param pConcept - Value to Concept
	 * @return	C_Invoice_ID, 0 if does't
	 */ 
	public int getAttributeInvoice (String pConcept)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pConcept);
		if (concept == null)
			return 0;
		
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		// check ValidFrom:
		whereClause.append(MHRAttribute.COLUMNNAME_ValidFrom + "<=?");
		params.add(m_dateFrom);
		//check client
		whereClause.append(" AND AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID" 
						   + " AND c.Value = ?)");
		params.add(pConcept);
		//
		if (!MHRConcept.TYPE_Information.equals(concept.getType()))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}
		
		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		
		if(attribute!=null)
			return (Integer) attribute.get_Value("C_Invoice_ID");
		else
			return 0;
		
	} // getAttributeInvoice
	
	
	public double getConceptSum(int idCatConcept, String CatConcept)
	{
		if(CatConcept.equals("A"))
			return getConceptSumAsig(getHR_Payroll_ID(), idCatConcept);
		else if (CatConcept.equals("D"))
			return getConceptSumDed(getHR_Payroll_ID(), idCatConcept);
		else if (CatConcept.equals("V"))
			return getConceptSumPer(getHR_Payroll_ID(), idCatConcept);
		else
			return 0;
	}
	
	public double getConceptSumAsig(int idDefinConcept, int idCatConcept)
	{
		String wherel ="";
		if (getHR_Payroll_Type_Line_ID() != 0 ){
				wherel = " AND (CASE WHEN not HR_Payroll_Type_line_ID is null THEN"
						+ "(CASE WHEN not HR_Payroll_Type_line2_ID is null THEN"
						+ "(HR_Payroll_Type_line_ID = "+getHR_Payroll_Type_Line_ID()+" OR HR_Payroll_Type_line2_ID = "+getHR_Payroll_Type_Line_ID()+")"
						+ "	ELSE HR_Payroll_Type_line_ID = "+getHR_Payroll_Type_Line_ID()+" END)"
						+ "ELSE 1=1 END)";
		}
		
		// Lista la Tabla que contiene las Variables para los Groovys
		String whereClause = " HR_Concept.HR_Concept_id in (select HR_Concept_id from HR_PayrollConcept where  HR_Payroll_ID= ? AND IsActive = 'Y'" + wherel +") "
				+ "and HR_Concept.IsActive = 'Y' and HR_Concept.HR_Concept_Category_id = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(idDefinConcept);
		params.add(idCatConcept);
		
		listConceptAsg = new Query(getCtx(), MHRConcept.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRConcept.COLUMNNAME_Value)
		.list();
		
		double  Sum = 0;
		for( MHRConcept var : listConceptAsg){
			try {
				
				Sum = Sum + getConcept(var.getValue());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new AdempiereException("Error Calculo de Sumatoria de Concepto: " 
				+ var.getValue());
			}

		}

		return Sum;
	}
	
	public double getConceptSumDed(int idDefinConcept, int idCatConcept)
	{

		String wherel ="";
		if (getHR_Payroll_Type_Line_ID() != 0 ){
				wherel = " AND (CASE WHEN not HR_Payroll_Type_line_ID is null THEN"
						+ "(CASE WHEN not HR_Payroll_Type_line2_ID is null THEN"
						+ "(HR_Payroll_Type_line_ID = "+getHR_Payroll_Type_Line_ID()+" OR HR_Payroll_Type_line2_ID = "+getHR_Payroll_Type_Line_ID()+")"
						+ "	ELSE HR_Payroll_Type_line_ID = "+getHR_Payroll_Type_Line_ID()+" END)"
						+ "ELSE 1=1 END)";
		}
		
		// Lista la Tabla que contiene las Variables para los Groovys
		String whereClause = " HR_Concept.HR_Concept_id in (select HR_Concept_id from HR_PayrollConcept where  HR_Payroll_ID= ? AND IsActive = 'Y'" + wherel +") "
				+ "and HR_Concept.IsActive = 'Y' and HR_Concept.HR_Concept_Category_id = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(idDefinConcept);
		params.add(idCatConcept);
		
		listConceptDed = new Query(getCtx(), MHRConcept.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRConcept.COLUMNNAME_Value)
		.list();
		
		double  Sum = 0;
		for( MHRConcept var : listConceptDed){
			try {
				
				Sum = Sum + getConcept(var.getValue());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new AdempiereException("Error Calculo de Sumatoria de Concepto: " 
				+ var.getValue());
			}

		}

		return Sum;
	}
	
	public double getConceptSumPer(int idDefinConcept, int idCatConcept)
	{

		//sql="SELECT value FROM hr_concept where isrecompensed='Y' AND IsActive = 'Y' order by value";
		// Lista la Tabla que contiene las Variables para los Groovys
		String whereClause = " HR_Concept.isrecompensed= ? AND HR_Concept.IsActive = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		params.add(true);
		
		listConceptPer = new Query(getCtx(), MHRConcept.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRConcept.COLUMNNAME_Value)
		.list();
		
		double  Sum = 0;
		for( MHRConcept var : listConceptPer){
			try {
				
				Sum = Sum + getConcept(var.getValue());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new AdempiereException("Error Calculo de Sumatoria de Concepto: " 
				+ var.getValue());
			}

		}

		return Sum;
	}
	
	/**
	 * Helper Method : Get AttributeDocType
	 * @param pConcept - Value to Concept
	 * @return	C_DocType_ID, 0 if does't
	 */ 
	public int getAttributeDocType (String pConcept)
	{
		MHRConcept concept = MHRConcept.forValue(getCtx(), pConcept);
		if (concept == null)
			return 0;
		
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		// check ValidFrom:
		whereClause.append(MHRAttribute.COLUMNNAME_ValidFrom + "<=?");
		params.add(m_dateFrom);
		//check client
		whereClause.append(" AND AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Concept c WHERE c.HR_Concept_ID=HR_Attribute.HR_Concept_ID" 
						   + " AND c.Value = ?)");
		params.add(pConcept);
		//
		if (!MHRConcept.TYPE_Information.equals(concept.getType()))
		{
			whereClause.append(" AND " + MHRAttribute.COLUMNNAME_C_BPartner_ID + " = ?");
			params.add(m_C_BPartner_ID);
		}
		// LVE Localización Venezuela
		// when is employee, it is necessary to check if the organization of the employee is equal to that of the attribute
		if (concept.isEmployee()){
			whereClause.append(" AND ( " + MHRAttribute.COLUMNNAME_AD_Org_ID + "=? OR " + MHRAttribute.COLUMNNAME_AD_Org_ID + "= 0 )");
			params.add(getAD_Org_ID());
		}
		
		MHRAttribute attribute = new Query(getCtx(), MHRAttribute.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOrderBy(MHRAttribute.COLUMNNAME_ValidFrom + " DESC")
		.first();
		
		if(attribute!=null)
			return (Integer) attribute.get_Value("C_DocType_ID");
		else
			return 0;
		 
	} // getAttributeDocType

	/**
	 * Helper Method : get days from specific period
	 * @param period
	 * @return no. of days
	 */
	public double getDays (int period)
	{
		/* TODO: This getter could have an error as it's not using the parameter, and it doesn't what is specified in help */
		log.warning("instead of using getDays in the formula it's recommended to use _DaysPeriod+1");
		return Env.getContextAsInt(getCtx(), "_DaysPeriod") + 1;
	} // getDays

	public String getDocAct ()
	{
		return getDocAction();
	} // getDocAct
	
	/*
	 * PARA GENERAR VARIABLES PARCIALES Y GLOBALES SEGUN EL CASO
	 */
	
	public String getVarGlobal() {
		return VarGlobal;
	}

	public void setVarGlobal() {
		
		String varGlobal = "";
		Object valor = "";
		MHRPeriod period = new MHRPeriod(getCtx(), getHR_Period_ID(), get_TrxName());
		
		// Lista la Tabla que contiene las Variables para los Groovys
		String whereClause = " isglobal = ? AND isactive = 'Y' AND (HR_Payroll_ID ISNULL OR HR_Payroll_ID = ? )";
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		params.add(getHR_Payroll_ID());
		
		listConceptVarG = new Query(getCtx(), X_HR_ConceptVar.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(X_HR_ConceptVar.COLUMNNAME_Value)
		.list();
		
		for( X_HR_ConceptVar var : listConceptVarG){
			
			String sqlv="";

				try {// try{ } catch{ }
					
						//Carga el SQL de la ventana y le remplaza la variables
						sqlv = var.getSQLVar().replace("@_Period@", getHR_Period_ID()+"")
								.replace("@_Process@", getHR_Process_ID()+"")
								.replace("@_Payroll@", getHR_Payroll_ID()+"")
								.replace("@_Contract@", getHR_Contract_ID()+"")
								.replace("@_From@", "'"+period.getStartDate()+"'")
								.replace("@_To@", "'"+period.getEndDate()+"'");
						
						PreparedStatement pstmtv = DB.prepareStatement (sqlv, get_TrxName());
						ResultSet rsv;
						rsv = pstmtv.executeQuery ();
						
							try{ 
								filas =0;
								valor=0;
								if (rsv.wasNull() == false){//Verifica si el Resulset esta null
									colum = 0;
									while (rsv.next ())
										{
												filas = rsv.getRow(); // Cuenta las filas
												colum = rsv.getMetaData().getColumnCount(); // Obtiene la Cantidad de columnas
												for(int i = 1; i <= colum; i++)
													if (var.getQtyVar().signum() != 0 ) // verifica que la cantidad de Columnas descrita en la ventana sea diferente de 0
														varGlobal = varGlobal + uptadeParameter(rsv.getMetaData().getColumnName(i).toUpperCase(), rsv.getObject(i));
													else
														valor = rsv.getObject(i);
										}
								}
								if(filas == 0 || var.getQtyVar().signum() == 0){ // verifica si presento filas y si la cantidad de Columna es 0
									varGlobal = varGlobal + uptadeParameter(var.getValue(), valor);
								}
							}finally{
								pstmtv.close();
								rsv.close();
							}//Close de Resultset y PreparedStatement
								
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new AdempiereException("Error Calculando Variable Globales: " 
						+ var.getValue() + "\n" + sqlv);
					}
				
		}//for de las variables

		VarGlobal = varGlobal;
	}
	
	public String getVarParcial() {
		return VarParcial;
	}
	
	public String getHoraAct() {
		Calendar fecha = new GregorianCalendar();
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
	    return (hora + ":" + minuto + ":" + segundo);
	}
	
	@SuppressWarnings("deprecation")
	public Timestamp getDateAct() {

	    java.util.Date today = new java.util.Date();
	    System.out.println(new java.sql.Timestamp(today.getDate()));
	    
	    return (new java.sql.Timestamp(today.getTime()));
	}
	
	public void setVarParcial(int C_BPartner_ID, String variables) {
		
		String varParcial = "";
		Object valor = "";
		MHRPeriod period = new MHRPeriod(getCtx(), getHR_Period_ID(), get_TrxName());
		
		if (variables == null){
			
			// Lista la Tabla que contiene las Variables para los Groovys
			String whereClause = " isglobal = ? AND isactive = 'Y' AND (HR_Payroll_ID ISNULL OR HR_Payroll_ID = ? )";
			List<Object> params = new ArrayList<Object>();
			params.add(false);
			params.add(getHR_Payroll_ID());
				
			listConceptVarP = new Query(getCtx(), X_HR_ConceptVar.Table_Name, whereClause.toString(), get_TrxName())
			.setParameters(params)
			.setOnlyActiveRecords(true)
			.setOrderBy(X_HR_ConceptVar.COLUMNNAME_Value)
			.list();
			
			for( X_HR_ConceptVar var : listConceptVarP){
				
				String sqlv="";
	
					try {// try{ } catch{ }
																			
						sqlv = var.getSQLVar().replace("@_Period@", getHR_Period_ID()+"")
								.replace("@_Process@", getHR_Process_ID()+"")
								.replace("@_Payroll@", getHR_Payroll_ID()+"")
								.replace("@_Contract@", getHR_Contract_ID()+"")
								.replace("@_From@", "'"+period.getStartDate()+"'")
								.replace("@_To@", "'"+period.getEndDate()+"'")
								.replace("@_C_BPartner_ID@", C_BPartner_ID +"")
								.replace("@_Employee@", m_employee.getHR_Employee_ID()+"")
								.replace("@_DateStart@", "'"+m_employee.getStartDate()+"'")
								.replace("@_DateEnd@", "'"+ (m_employee.getEndDate() == null ? TimeUtil.getDay(2999, 12, 31) : m_employee.getEndDate())+"");
						
						PreparedStatement pstmtv = DB.prepareStatement (sqlv, get_TrxName());
						ResultSet rsv;
						rsv = pstmtv.executeQuery ();
						try{
							
						
							filas =0;
							valor=0;
							String concvar ="";
							if (rsv.wasNull() == false){//Verifica si el Resulset esta null
								colum = 0;
								while (rsv.next ())
									{
											filas = rsv.getRow(); // Cuenta las filas
											colum = rsv.getMetaData().getColumnCount(); // Obtiene la Cantidad de columnas
											for(int i = 1; i <= colum; i++)
												if (var.getQtyVar().signum()!= 0) // verifica que la cantidad de Columnas descrita en la ventana sea diferente de 0
													concvar = concvar + uptadeParameter(rsv.getMetaData().getColumnName(i).toUpperCase(),rsv.getObject(i));
												else
													valor = rsv.getObject(i);
									}
							}
							if(filas == 0 || var.getQtyVar().signum() == 0){ // verifica si presento filas y si la cantidad de Columna es 0
								concvar = concvar + uptadeParameter(var.getValue(), valor);
							}
							
							//Lista las variables con sus respectivos value que presentan en la tabla
							listVareableP.add(new MVariableProcess(var.getValue(),concvar, null));
							
						}finally{
								pstmtv.close();
								rsv.close();
						}//Close de Resultset y PreparedStatement
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new AdempiereException("Error Calculando Variable Parciales: " 
						+ var.getValue() + "\n" + sqlv);
					}
	
			}
		}else{
			
			String[] codigo = variables.replace("'", "").split(",");
			for(String cod : codigo){ //Busca las variables segun el codigo del groovy
				for( MVariableProcess var : listVareableP){
					if (cod.equals(var.getName())){
						varParcial = varParcial + var.getCode();
						break;
					}
				}
			}
		}
		VarParcial = varParcial;
	}
	
	private String VarGlobal;
	private String VarParcial;

	private int filas;
	
	public String uptadeParameter(String value, Object valor)
    {
        String par;

        if(value == null)
        {
        	par = " v_" + value +"=\""+""+ "\"; ";
        }
        else if (valor instanceof BigDecimal)
        {	
        	BigDecimal resp = (BigDecimal)valor;
        	if (resp.signum() >= 0)
        		par = " v_" + value +"=" + resp + "; ";
        	else
        		par = " v_" + value +"= 0; ";
        }
        else if (valor instanceof Integer)
        {
        	int resp = (Integer)valor;
        	if (resp >= 0)
        		par = " v_" + value +"=" + resp + "; ";
        	else
        		par = " v_" + value +"= 0; ";
        }
        else if (valor instanceof Timestamp)
        {
            par = " Timestamp v_" + value +"= Timestamp.valueOf(df.format(df.parse(\"" + valor.toString() + "\"))); ";
        }
        else if (valor instanceof Boolean)
        {
            par = " v_" + value +"=\""+valor.toString()+ "\"; ";
        }
        else
        {
            par = " v_" + value +"=\""+valor.toString()+ "\"; ";
        }

        return par;
    }
	
	public void getProcess_RotationMove(){
		MHRPeriod period = new MHRPeriod(getCtx(), getHR_Period_ID(), get_TrxName());
		String sql;
		sql = "UPDATE hr_rotationmove SET  processed = 'Y' where c_bpartner_id in "
				+ "(select distinct c_bpartner_id from hr_movement where hr_process_id = "+ getHR_Process_ID() +")"
				+ "AND dateend <= '"+ period.getEndDate() +"' AND processed = 'N'";
		DB.executeUpdate(sql,null);
	}
	

}	//	MHRProcess
