package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
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

import javax.swing.JOptionPane;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.compiere.model.Scriptlet;
import org.compiere.model.X_AD_Table;
import org.compiere.process.SvrProcess;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.eevolution.model.MHRAttribute;
import org.eevolution.model.MHRConcept;
import org.eevolution.model.MHRConceptCategory;
import org.eevolution.model.MHREmployee;
import org.eevolution.model.MHRMovement;
import org.eevolution.model.MHRPayroll;
import org.eevolution.model.MHRPayrollConcept;
import org.eevolution.model.MHRPeriod;
import org.eevolution.model.MHRProcess;
import org.pentanet.model.MHRMovementRet;
import org.pentanet.model.MVariableProcess;
import org.pentanet.model.X_HR_ConceptVar;
import org.pentanet.model.X_HR_Retroactive;
import org.pentanet.model.X_HR_Retroactive_Line;


@SuppressWarnings("unused")
public class Retroactive extends SvrProcess{
	
	public List<MHRProcess> listProcess;
	HashMap<String, Object> m_scriptCtx = new HashMap<String, Object>();
	public Timestamp m_dateFrom;
	public Timestamp m_dateTo;	
	// Variable que se usan en los groovy
	public List<X_HR_ConceptVar> listConceptVarG;
	public List<X_HR_ConceptVar> listConceptVarP;
	public List<MVariableProcess> listVareableP = new ArrayList<MVariableProcess>();
	public List<MHRPayrollConcept> linesConcept;
	
	//para las sumatorias de los conceptos
	public List<MHRConcept> listConceptAsg; // Solo Conceptos tipo Asignaciones 
	public List<MHRConcept> listConceptDed; // Solo Conceptos tipo Deducciones 
	public List<MHRConcept> listConceptPer; // Solo Conceptos marcado como remunerados
	public List<MBPartner> listBpartner;
	
	private List<MHRConcept> activeConceptRule = new ArrayList<MHRConcept>();
	Object m_description = null;
	
	public int m_C_BPartner_ID = 0;
	private String m_C_BPartnerName ="";
	private int m_C_BPartnerCont =0;
	public int m_AD_User_ID = 0;
	public int m_HR_Concept_ID = 0;
	public String m_columnType   = "";
	/** The employee being processed */
	private MHREmployee m_employee;
	private MHRProcess m_process;
	private X_HR_Retroactive_Line m_retroactl;
	private X_HR_Retroactive m_retroactive;
	private int m_retroact_id;
	private int m_retroactl_id;
	private int m_procesret_id;
	
	private String VarGlobal;
	private String VarParcial;
	private int filas;
	private int colum;
	
	public Hashtable<Integer, MHRMovement> m_movement = new Hashtable<Integer, MHRMovement>();
	private static StringBuffer s_scriptImport = new StringBuffer(	 " import org.eevolution.model.*;" 
			+" import org.compiere.model.*; "
			+" import org.adempiere.model.*; "
			+" import org.compiere.util.*; "
			+" import java.math.*; "
			+" import java.sql.*; " 
			+ "import java.util.*; "
			+ "import java.text.*; ");
	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (MHRProcess.class);
	public static final String CONCEPT_PP_COST_COLLECTOR_LABOR = "PP_COST_COLLECTOR_LABOR"; // HARDCODED
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		CreateRetroactive();
		return null;
	}
	
	public void CreateRetroactive() throws Exception{
		
		X_AD_Table table = new X_AD_Table(getCtx(), getTable_ID(), get_TrxName());
		String whereClause = null;
		
		if (table.getName().equals("HR_Retroactive")){
			
			int nprocess = DB.getSQLValue(null, "SELECT COUNT(rl.name) FROM hr_retroactive_line rl"
					+ "LEFT JOIN (select distinct hr_process_id from hr_movement_ret  "
					+ "where hr_retroactive_id = " + getRecord_ID() +") mov on mov.hr_process_id = rl.hr_process_id"
					+ "where hr_retroactive_id = " + getRecord_ID()
					+ "AND NOT rl.hr_process_id isnull AND mov.hr_process_id isnull");

			if (nprocess < 0){
				m_retroact_id = getRecord_ID();
				m_retroactive = new X_HR_Retroactive(getCtx(), getRecord_ID(), get_TrxName());
				m_procesret_id = m_retroactive.getHR_Process_ID();
				
				GenerateMovements(m_procesret_id, m_retroact_id);
				
			}


			
		}else{
			
			whereClause ="HR_Process_ID in (select hr_process_id from hr_retroactive_line where hr_retroactive_line_id ="+ getRecord_ID() + ")";
			X_HR_Retroactive_Line rl = new X_HR_Retroactive_Line(getCtx(), getRecord_ID(), get_TrxName());
			m_retroact_id = rl.getHR_Retroactive_ID();
			m_retroactl_id = getRecord_ID();
			m_retroactive = new X_HR_Retroactive(getCtx(), rl.getHR_Retroactive_ID(), get_TrxName());
			m_procesret_id = m_retroactive.getHR_Process_ID();
			
			String whereCRL ="";
			Object[] param = null;
			if(rl.getC_BPartner_ID() > 0){
				param = new Object[]{rl.getHR_Process_ID(), m_retroact_id, getRecord_ID(), rl.getC_BPartner_ID()};
				whereCRL =" AND C_BPartner_ID = ?";
			}else{
				param = new Object[]{rl.getHR_Process_ID(), m_retroact_id, getRecord_ID()};
			}
			
			//Borrar Movement_Ret de un proceso en especifico
			int no = DB.executeUpdateEx("DELETE FROM HR_Movement_Ret WHERE HR_Process_ID= ? AND HR_Retroactive_ID = ?  AND HR_Retroactive_Line_ID = ?"
					+ whereCRL,
					param , get_TrxName());
			log.info("HR_Movement_Ret deleted #"+ no);
		}
		
		if (whereClause != null){
			
			listProcess = new Query(getCtx(), MHRProcess.Table_Name, whereClause.toString(), get_TrxName())
			.setOnlyActiveRecords(true)
			.setOrderBy(MHRProcess.COLUMNNAME_DateAcct)
			.list();
			
			for( MHRProcess pros : listProcess){
				m_retroactl_id = DB.getSQLValue(null, "SELECT HR_Retroactive_Line_ID  FROM HR_Retroactive_Line "
						+ " WHERE HR_Retroactive_ID = " + m_retroact_id +" AND HR_Process_ID = " + pros.getHR_Process_ID());
				CreateMovements(pros.getHR_Process_ID(), m_retroactl_id);
				
			}
			
		}
	}
	
	
	public void CreateMovements(int proc, int m_retroact_ID)  throws Exception{
		
		m_process = new MHRProcess (getCtx(), proc, get_TrxName());
		m_retroactl = new X_HR_Retroactive_Line(getCtx(), m_retroact_ID, get_TrxName());
		MHRPeriod period = new MHRPeriod(getCtx(), m_process.getHR_Period_ID(), get_TrxName());
		
		m_scriptCtx.clear();
		m_scriptCtx.put("process", this);
		m_scriptCtx.put("_Process", m_process.getHR_Process_ID());
		m_scriptCtx.put("_Period", m_process.getHR_Period_ID());
		m_scriptCtx.put("_Payroll", m_process.getHR_Payroll_ID());
		m_scriptCtx.put("_Department", m_process.getHR_Department_ID());

		log.info("info data - " + " Process: " + m_process.getHR_Process_ID()+ ", Period: " + m_process.getHR_Period_ID()+ ", "
				+ "Payroll: " + m_process.getHR_Payroll_ID()+ ", "
				+ "Department: " + m_process.getHR_Department_ID());

		if (period != null)
		{
			m_dateFrom = period.getStartDate();
			m_dateTo   = period.getEndDate();
			m_scriptCtx.put("_From", period.getStartDate());
			m_scriptCtx.put("_To", period.getEndDate());
		}
		
		
		//Genera las Variables Globales que se estaran usando en los groovy
		listVareableP.clear();
		setVarGlobal(); 

		
		linesConcept =  new Query(getCtx(), MHRPayrollConcept.Table_Name,
				"HR_Retroactive_ID = " + m_retroactive.getHR_Retroactive_ID() , get_TrxName()) //-- AND c_bpartner_id = 1005407
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRPayrollConcept.COLUMNNAME_SeqNo)
		.list();
		
		if(linesConcept.size() == 0){
			linesConcept =  new Query(getCtx(), MHRPayrollConcept.Table_Name,
					"HR_Retroactive_ID IsNull AND HR_Payroll_ID = " + m_process.getHR_Payroll_ID(), get_TrxName()) //-- AND c_bpartner_id = 1005407
			.setOnlyActiveRecords(true)
			.setOrderBy(MHRPayrollConcept.COLUMNNAME_SeqNo)
			.list();
		}
		
		// Hey, I can filter this array with Emloyees of Payrroll's Contract ???
		// this is the process,
		String whereClause =" ";
		if (m_retroactive.isCompensatory() == true){
			whereClause = " AND HR_Concept_ID = " + m_retroactive.getHR_Concept2_ID();
		}
		if (m_retroactl.getC_BPartner_ID() > 0){
			whereClause = whereClause + " AND C_BPartner_ID = " + m_retroactl.getC_BPartner_ID();
		}
		
		List<MBPartner> linesEmployee = new Query(getCtx(), MBPartner.Table_Name,
				" C_BPartner_ID IN (SELECT Distinct C_BPartner_ID FROM HR_Movement WHERE HR_Process_ID = " 
				+ m_process.getHR_Process_ID() + "" + whereClause+")" , get_TrxName()) //-- AND c_bpartner_id = 1005407
		.setOnlyActiveRecords(true)
		.setOrderBy(MBPartner.COLUMNNAME_Name)
		.list();
		
		//
		int count = 1;
		for(MBPartner bp : linesEmployee)	//=============================================================== Employee
		{

			log.info("Employee ***************************************************************************************************");
			log.info("Employee ******* "+bp.getC_BPartner_ID()+" ************** N° " + count + "  ------------- " + bp.getName());
			log.info("Employee ***************************************************************************************************");

			count++;
			m_C_BPartner_ID = bp.get_ID();
			m_C_BPartnerName = bp.getName();
			m_C_BPartnerCont = count;
			m_employee = MHREmployee.getActiveEmployee(getCtx(), m_C_BPartner_ID, get_TrxName());
			m_scriptCtx.remove("_DateStart");
			m_scriptCtx.remove("_DateEnd");
			m_scriptCtx.remove("_Days");
			m_scriptCtx.remove("_C_BPartner_ID");
			m_scriptCtx.put("_DateStart", m_employee.getStartDate());
			m_scriptCtx.put("_DateEnd", m_employee.getEndDate() == null ? TimeUtil.getDay(2999, 12, 31) : m_employee.getEndDate());
			m_scriptCtx.put("_Days", org.compiere.util.TimeUtil.getDaysBetween(period.getStartDate(),period.getEndDate())+1);
			m_scriptCtx.put("_C_BPartner_ID", bp.getC_BPartner_ID());

			//createCostCollectorMovements(bp.get_ID(), period);
			
			//Genera las Variables Parcial que se estaran usando en los groovy para el empleado
			listVareableP.clear();
			setVarParcial(m_employee.getC_BPartner_ID(), null); 

			m_movement.clear();
			loadMovements(m_movement, m_C_BPartner_ID);
			loadConcept(m_movement, m_C_BPartner_ID);
			
			//
			for(MHRPayrollConcept pc : linesConcept) // ==================================================== Concept
			{
				m_HR_Concept_ID  = pc.getHR_Concept_ID();
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
			} // concept

			// Save movements: Se coloco directo en el Metodo createMovementFromConcept
			for (MHRMovement m: m_movement.values())
			{
				MHRMovementRet mov = null;
				MHRConcept c = (MHRConcept) m.getHR_Concept();
				if (c.isRegistered() || m.isEmpty())
				{	
					log.fine("Skip saving " + m);
				}
				else
				{	
					boolean saveThisRecord =
						m.isPrinted() || c.isPaid() || c.isPrinted();
					if (saveThisRecord){
						
						mov = new MHRMovementRet(getCtx(), 0, get_TrxName());
						mov.setC_BPartner_ID(m_C_BPartner_ID);
						mov.setHR_Concept_ID(m.getHR_Concept_ID());
						mov.setHR_Concept_Category_ID(m.getHR_Concept_Category_ID());
						mov.setHR_Process_ID(m.getHR_Process_ID());
						mov.setHR_ProcessRet_ID(new BigDecimal(m_procesret_id));
						mov.setHR_Department_ID(m_employee.getHR_Department_ID());
						mov.setHR_Job_ID(m_employee.getHR_Job_ID());
						mov.setColumnType(m.getColumnType());
						mov.setAD_Rule_ID(m.getAD_Rule_ID());
						mov.setValidFrom(m_dateFrom);
						mov.setValidTo(m_dateTo);
						mov.setIsPrinted(m.isPrinted());
						mov.setIsRegistered(c.isRegistered());//Desmarcado por rmontano
						mov.setC_Activity_ID(m_employee.getC_Activity_ID());
						mov.setDescription(m.getDescription());
						mov.setQty(m.getQty()); 
						mov.setAmount(m.getAmount());
						mov.setTextMsg(m.getTextMsg());						
						mov.setServiceDate(m.getServiceDate());
						
						mov.setHR_Retroactive_ID(m_retroact_id);
						mov.setHR_Retroactive_Line_ID(m_retroact_ID);
						
						mov.setProcessed(true);
						
						mov.saveEx();
					}
				}
			}
			
		} // for each employee

	} // createMovements
	
	
	/**
	 * Load HR_Movements and store them in a HR_Concept_ID->MHRMovement hashtable
	 * @param movements hashtable
	 * @param C_PBartner_ID
	 */
	private void loadMovements(Hashtable<Integer,MHRMovement> movements, int C_PBartner_ID)
	{
		String whereClause = MHRMovement.COLUMNNAME_HR_Process_ID+"=?"
		+" AND " + MHRMovement.COLUMNNAME_C_BPartner_ID + "=?  AND HR_Concept_ID IN"
				+ " (SELECT HR_Concept_ID FROM HR_Concept WHERE isnotretroactive ='N')"
				+ " AND HR_Concept_Category_ID IN "
				+ " (SELECT HR_Concept_Category_ID FROM HR_Concept_Category WHERE value = 'V')"
				+ " AND ColumnType = 'Q'";
		
		if (m_retroactive.isCompensatory()== true)
			whereClause = whereClause + " AND NOT HR_Concept_ID = " + m_retroactive.getHR_Concept2_ID();
		
		List<MHRMovement> list = new Query(getCtx(), MHRMovement.Table_Name, whereClause, get_TrxName())
		.setParameters(new Object[]{m_process.getHR_Process_ID(), C_PBartner_ID})
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
	
	private void loadConcept(Hashtable<Integer,MHRMovement> movements, int C_PBartner_ID)
	{	
		String sql = null;
		BigDecimal vconcept = new BigDecimal(0); 
		String whereClause = " ";
		
		if (m_retroactive.isCompensatory()){
			sql = "SELECT (CASE WHEN ColumnType = 'Q' THEN Qty ELSE Amount END) "
					+ "FROM HR_Movement where HR_Process_ID = " + m_process.getHR_Process_ID() 
					+ " AND C_BPartner_ID = " + C_PBartner_ID + " AND HR_Concept_ID = " + m_retroactive.getHR_Concept2_ID();
			vconcept = DB.getSQLValueBD(null, sql);
			whereClause = " HR_Concept_ID IN (" + m_retroactive.getHR_Concept_ID() + "," + m_retroactive.getHR_Concept2_ID() +") ";
			
		}else{
			
			vconcept = m_retroactive.getAmount();
			whereClause = " HR_Concept_ID IN (" + m_retroactive.getHR_Concept_ID() +") ";
			
		}
		
		List<MHRConcept> list = new Query(getCtx(), MHRConcept.Table_Name, whereClause, get_TrxName())
		.list();
		
		for (MHRConcept mc : list)
		{
				
			MHRMovement movement = new MHRMovement (getCtx(), 0, get_TrxName());
			movement.setC_BPartner_ID(m_C_BPartner_ID);
			movement.setHR_Concept_ID(mc.getHR_Concept_ID());
			movement.setHR_Concept_Category_ID(mc.getHR_Concept_Category_ID());
			movement.setHR_Process_ID(m_process.getHR_Process_ID());
			movement.setHR_Department_ID(m_employee.getHR_Department_ID());
			movement.setHR_Job_ID(m_employee.getHR_Job_ID());
			movement.setColumnType(mc.getColumnType());
			movement.setValidFrom(m_dateFrom);
			movement.setValidTo(m_dateTo);
			movement.setIsPrinted(true);
			movement.setIsRegistered(mc.isRegistered());//Desmarcado por rmontano
			movement.setC_Activity_ID(m_employee.getC_Activity_ID());
			if (mc.getHR_Concept_ID() == m_retroactive.getHR_Concept_ID()){
				if (mc.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity)){
					
					movement.setQty(vconcept); 
					
				}else{
					
					movement.setAmount(vconcept);
				}
			}else{
				if (mc.getColumnType().equals(MHRConcept.COLUMNTYPE_Quantity)){
					
					movement.setQty(new BigDecimal(0)); 
					
				}else{
					
					movement.setAmount(new BigDecimal(0));
				}
			}
		
			movement.setProcessed(true);
			
			movements.put(movement.getHR_Concept_ID(), movement);
		}
	}
	
	private MHRMovement createMovementFromConcept(MHRConcept concept,
			boolean printed) {
		log.info("Calculating concept " + concept.getValue());
		m_columnType   = concept.getColumnType();
		
		//JOptionPane.showMessageDialog(null, getCtx());
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		
		String sql ="SELECT COALESCE(Payroll_Clasif,'Q') FROM HR_Payroll WHERE HR_Payroll_ID = " + m_process.getHR_Payroll_ID();
		String tn = DB.getSQLValueString(null, sql);
		
		if (!tn.equals("UT")){
			whereClause.append("? >= ValidFrom AND ( ? <= ValidTo OR ValidTo IS NULL)");
			params.add(m_dateFrom);
			params.add(m_dateTo);
			whereClause.append(" AND HR_Concept_ID = ? ");
		}else{
			whereClause.append(" HR_Concept_ID = ? ");
		}
		
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
			m_movement.put(concept.getHR_Concept_ID(), dummymov);
			return dummymov;
		}

		log.info("Concept - " + concept.getName());
		log.info("Socio N: ****** " + m_C_BPartnerName + "  N°: " + (m_C_BPartnerCont - 1) + "  [" + m_employee.getC_BPartner_ID()+"]");
		
		MHRMovement movement = new MHRMovement (getCtx(), 0, get_TrxName());
		movement.setC_BPartner_ID(m_C_BPartner_ID);
		movement.setHR_Concept_ID(concept.getHR_Concept_ID());
		movement.setHR_Concept_Category_ID(concept.getHR_Concept_Category_ID());
		movement.setHR_Process_ID(m_process.getHR_Process_ID());
		movement.setHR_Department_ID(m_employee.getHR_Department_ID());
		movement.setHR_Job_ID(m_employee.getHR_Job_ID());
		movement.setColumnType(m_columnType);
		movement.setAD_Rule_ID(att.getAD_Rule_ID());
		movement.setValidFrom(m_dateFrom);
		movement.setValidTo(m_dateTo);
		movement.setIsPrinted(printed);
		movement.setIsRegistered(concept.isRegistered());//Desmarcado por rmontano
		movement.setC_Activity_ID(m_employee.getC_Activity_ID());
		
		if (MHRConcept.TYPE_RuleEngine.equals(concept.getType()))
		{
			log.info("Executing rule for concept " + concept.getValue());
			if (activeConceptRule.contains(concept)) {
				throw new AdempiereException("Recursion loop detected in concept " + concept.getValue());
			}
			activeConceptRule.add(concept);
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
		m_movement.put(concept.getHR_Concept_ID(), movement);
		
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
			Exception ex = engine.execute();
			if (ex != null)
			{
				throw ex;
			}
			result = engine.getResult(false);
			m_description = engine.getDescription();
		}
		catch (Exception e)
		{
			throw new AdempiereException("Execution error - @AD_Rule_ID@="+rulee.getValue() + "  --C_BPartner_ID =" + m_employee.getC_BPartner_ID() 
					+ "HR_Process_ID = " + m_process.getHR_Process_ID());
		}
		return result;
	}

	
	/*
	 * PARA GENERAR VARIABLES PARCIALES Y GLOBALES SEGUN EL CASO
	 */
	
	public String getVarGlobal() {
		return VarGlobal;
	}

	public void setVarGlobal() {
		
		String varGlobal = "";
		Object valor = "";
		MHRPeriod period = new MHRPeriod(getCtx(), m_process.getHR_Period_ID(), get_TrxName());
		
		// Lista la Tabla que contiene las Variables para los Groovys
		String whereClause = " isglobal = ? AND isactive = 'Y' AND (HR_Payroll_ID ISNULL OR HR_Payroll_ID = ? )";
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		params.add(m_process.getHR_Payroll_ID());
		
		listConceptVarG = new Query(getCtx(), X_HR_ConceptVar.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(X_HR_ConceptVar.COLUMNNAME_Value)
		.list();
		
		for( X_HR_ConceptVar var : listConceptVarG){
			
			String sqlv="";

				try {// try{ } catch{ }
					
						//Carga el SQL de la ventana y le remplaza la variables
						sqlv = var.getSQLVar().replace("@_Period@", m_process.getHR_Period_ID()+"")
								.replace("@_Process@", m_process.getHR_Process_ID()+"")
								.replace("@_Payroll@", m_process.getHR_Payroll_ID()+"")
								.replace("@_Contract@", m_process.getHR_Contract_ID()+"")
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
	public void setVarParcial(int C_BPartner_ID, String variables) {
		
		String varParcial = "";
		Object valor = "";
		MHRPeriod period = new MHRPeriod(getCtx(), m_process.getHR_Period_ID(), get_TrxName());
		
		if (variables == null){
			
			// Lista la Tabla que contiene las Variables para los Groovys
			String whereClause = " isglobal = ? AND isactive = 'Y' AND (HR_Payroll_ID ISNULL OR HR_Payroll_ID = ? )";
			List<Object> params = new ArrayList<Object>();
			params.add(false);
			params.add(m_process.getHR_Payroll_ID());
				
			listConceptVarP = new Query(getCtx(), X_HR_ConceptVar.Table_Name, whereClause.toString(), get_TrxName())
			.setParameters(params)
			.setOnlyActiveRecords(true)
			.setOrderBy(X_HR_ConceptVar.COLUMNNAME_Value)
			.list();
			
			for( X_HR_ConceptVar var : listConceptVarP){
				
				String sqlv="";
	
					try {// try{ } catch{ }
																			
						sqlv = var.getSQLVar().replace("@_Period@", m_process.getHR_Period_ID()+"")
								.replace("@_Process@", m_process.getHR_Process_ID()+"")
								.replace("@_Payroll@", m_process.getHR_Payroll_ID()+"")
								.replace("@_Contract@", m_process.getHR_Contract_ID()+"")
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

			m.setHR_Process_ID(m_process.getHR_Process_ID());
			//m.setHR_Concept_ID(m_HR_Concept_ID);
			m.setHR_Concept_ID(c.getHR_Concept_ID());
			m.setC_BPartner_ID(m_C_BPartner_ID);
			m.setDescription("Agregado por regla"); // TODO: translate
			m.setValidFrom(m_dateFrom);
			m.setValidTo(m_dateTo);

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
			m.setHR_Process_ID(m_process.getHR_Process_ID());
			m.setHR_Concept_ID(c.getHR_Concept_ID());
			m.setC_BPartner_ID(m_C_BPartner_ID);
			m.setDescription("Added From Rule"); // TODO: translate
			m.setValidFrom(m_dateTo);
			m.setValidTo(m_dateTo);
			m.setIsRegistered(isRegistered);
			
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
			params.add(m_process.getAD_Org_ID());
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
			params.add(m_process.getAD_Org_ID());
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
			params.add(m_process.getAD_Org_ID());
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
			params.add(m_process.getAD_Org_ID());
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
			params.add(m_process.getAD_Org_ID());
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
			params.add(m_process.getAD_Org_ID());
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
			payroll_id = m_process.getHR_Payroll_ID();
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
			fieldName = MHRMovementRet.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovementRet.COLUMNNAME_Amount;
		}
		else
		{
			return 0; // TODO: throw exception?
		}
		//
		MHRPeriod p = MHRPeriod.get(getCtx(), m_process.getHR_Period_ID());
		ArrayList<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		//check client
		whereClause.append("AD_Client_ID = ?");
		params.add(getAD_Client_ID());
		//check concept
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_C_BPartner_ID  + "=?");
		params.add(m_C_BPartner_ID);
		//
		//check process and payroll
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Process p"
				+" INNER JOIN HR_Period pr ON (pr.HR_Period_id=p.HR_Period_ID)"
				+" WHERE HR_MovementRet.HR_Process_ID = p.HR_Process_ID" 
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
		
		
		X_HR_Retroactive_Line rl = new X_HR_Retroactive_Line(getCtx(), getRecord_ID(), get_TrxName());
		whereClause.append(" AND HR_Retroactive_ID= ?");
		params.add(rl.getHR_Retroactive_ID());
		
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovementRet.Table_Name)
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
			payroll_id = m_process.getHR_Payroll_ID();
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
			fieldName = MHRMovementRet.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovementRet.COLUMNNAME_Amount;
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
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_C_BPartner_ID  + "=?");
		params.add(m_C_BPartner_ID);
		//
		//check process and payroll
		whereClause.append(" AND EXISTS (SELECT 1 FROM HR_Process p"
				+" INNER JOIN HR_Period pr ON (pr.HR_Period_id=p.HR_Period_ID)"
				+" WHERE HR_MovementRet.HR_Process_ID = p.HR_Process_ID" 
				+" AND p.HR_Payroll_ID = ?");

		params.add(payroll_id);
		if (period_id > 0)
		{
			whereClause.append(" AND pr.HR_Period_ID = ?");
			params.add(period_id);
		}
		whereClause.append(")");
		
		
		X_HR_Retroactive_Line rl = new X_HR_Retroactive_Line(getCtx(), getRecord_ID(), get_TrxName());
		whereClause.append(" AND HR_Retroactive_ID= ?");
		params.add(rl.getHR_Retroactive_ID());
		
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovementRet.Table_Name)
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
			payroll_id = m_process.getHR_Payroll_ID();
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
			fieldName = MHRMovementRet.COLUMNNAME_Qty;
		}
		else if (MHRConcept.COLUMNTYPE_Amount.equals(concept.getColumnType()))
		{
			fieldName = MHRMovementRet.COLUMNNAME_Amount;
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
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_HR_Concept_ID + "=?");
		params.add(concept.get_ID());
		//check partner
		whereClause.append(" AND " + MHRMovementRet.COLUMNNAME_C_BPartner_ID  + "=?");
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
							+" WHERE HR_Movement_Ret.HR_Process_ID = p.HR_Process_ID" 
							+" AND p.HR_Payroll_ID=?");

		params.add(payroll_id);
		
		whereClause.append(")");
		
		X_HR_Retroactive_Line rl = new X_HR_Retroactive_Line(getCtx(), getRecord_ID(), get_TrxName());
		whereClause.append(" AND HR_Retroactive_ID= ?");
		params.add(rl.getHR_Retroactive_ID());
		//
		StringBuffer sql = new StringBuffer("SELECT COALESCE(SUM(").append(fieldName).append("),0) FROM ").append(MHRMovementRet.Table_Name)
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
			params.add(m_process.getAD_Org_ID());
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
			return getConceptSumAsig(m_process.getHR_Payroll_ID(), idCatConcept);
		else if (CatConcept.equals("D"))
			return getConceptSumDed(m_process.getHR_Payroll_ID(), idCatConcept);
		else if (CatConcept.equals("V"))
			return getConceptSumPer(m_process.getHR_Payroll_ID(), idCatConcept);
		else
			return 0;
	}
	
	public double getConceptSumAsig(int idDefinConcept, int idCatConcept)
	{
		String wherel ="";
		if (m_process.getHR_Payroll_Type_Line_ID() != 0 ){
				wherel = " AND (CASE WHEN not HR_Payroll_Type_line_ID is null THEN"
						+ "(CASE WHEN not HR_Payroll_Type_line2_ID is null THEN"
						+ "(HR_Payroll_Type_line_ID = "+m_process.getHR_Payroll_Type_Line_ID()+" OR HR_Payroll_Type_line2_ID = "+m_process.getHR_Payroll_Type_Line_ID()+")"
						+ "	ELSE HR_Payroll_Type_line_ID = "+m_process.getHR_Payroll_Type_Line_ID()+" END)"
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
		if (m_process.getHR_Payroll_Type_Line_ID() != 0 ){
				wherel = " AND (CASE WHEN not HR_Payroll_Type_line_ID is null THEN"
						+ "(CASE WHEN not HR_Payroll_Type_line2_ID is null THEN"
						+ "(HR_Payroll_Type_line_ID = "+m_process.getHR_Payroll_Type_Line_ID()+" OR HR_Payroll_Type_line2_ID = "+m_process.getHR_Payroll_Type_Line_ID()+")"
						+ "	ELSE HR_Payroll_Type_line_ID = "+m_process.getHR_Payroll_Type_Line_ID()+" END)"
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
			params.add(m_process.getAD_Org_ID());
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


	// Genera los los movimientos en la tabla HR_Movement Proceso Total
	public void GenerateMovements(int proc, int m_retroact_ID){
		
    	MHRProcess process = new MHRProcess(getCtx(), proc, get_TrxName());
    	MHRPeriod period = new MHRPeriod(getCtx(), process.getHR_Period_ID(), get_TrxName());
    	
		if(!process.getDocStatus().equals("CO") || !process.getDocStatus().equals("CL")){
				
				Object[] par = null;
				String wherel ="";
				/*if (getC_BPartner_ID() !=0){
					wherel =" AND C_BPartner_ID = ? ";
					par = new Object[]{getHR_Process_ID(), false, getC_BPartner_ID()};
				}else if (getHR_Payroll_Type_Line_ID() != 0 ){
					wherel = " AND C_BPartner_ID IN (SELECT distinct C_BPartner_ID FROM HR_Employee WHERE HR_Payroll_Type_line_ID = " + getHR_Payroll_Type_Line_ID() + ")";
					par = new Object[]{getHR_Process_ID(), false};
				}else if (getHR_Standing_ID() != 0 ){
					wherel = " AND C_BPartner_ID IN (SELECT distinct C_BPartner_ID FROM HR_Employee WHERE HR_Standing_ID = " + getHR_Standing_ID() + ")";
					par = new Object[]{getHR_Process_ID(), false};
				}else{*/
				
					par = new Object[]{proc};
					
					// RE-Process, delete movement except concept type Incidence 
					String sqldel = "DELETE FROM HR_Movement WHERE HR_Process_ID = ? " + wherel;
					int no = DB.executeUpdateEx(sqldel, par, get_TrxName());
					log.info("HR_Movement deleted #"+ no);
				
				
				String  whereClause = "C_BPartner_ID IN (SELECT distinct C_BPartner_ID FROM HR_Movement_Ret WHERE HR_Retroactive_ID = "+ m_retroact_ID+ " ) AND AD_Org_ID = " + process.getAD_Org_ID();
				
				listBpartner = new Query(getCtx(), MBPartner.Table_Name, whereClause.toString(), get_TrxName())
				.setOnlyActiveRecords(true)
				.setOrderBy(MBPartner.COLUMNNAME_Value)
				.list();
				
				int count = 1;
				for(MBPartner bp : listBpartner){
					
					count++;
					m_C_BPartner_ID = bp.get_ID();
					m_C_BPartnerName = bp.getName();
					m_C_BPartnerCont = count;
					m_employee = MHREmployee.getActiveEmployee(getCtx(), m_C_BPartner_ID, get_TrxName());
					
					log.info("Employee ****************************************************************************************************");
					log.info("Employee ******* "+bp.getC_BPartner_ID()+" ************** N° " + count + "/" + (listBpartner.size()+ 1)
							+"   ------------- " + bp.getName());
					log.info("Employee ****************************************************************************************************");
					
					String sql ="SELECT id_concept, qty, amount FROM  process_movement_ret("+ m_C_BPartner_ID +","+ m_retroact_ID +");";
		            PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		            ResultSet rs;
		            try {
						rs= pstmt.executeQuery ();
			            while (rs.next ())
			            {
			            	MHRConcept concept = MHRConcept.get(getCtx(), rs.getInt(1));
			            	
			    			MHRMovement movement = new MHRMovement (getCtx(), 0, get_TrxName());
			    			movement.setC_BPartner_ID(m_C_BPartner_ID);
			    			movement.setHR_Concept_ID(concept.getHR_Concept_ID());
			    			movement.setHR_Concept_Category_ID(concept.getHR_Concept_Category_ID());
			    			movement.setHR_Process_ID(proc);
			    			movement.setHR_Department_ID(m_employee.getHR_Department_ID());
			    			movement.setHR_Job_ID(m_employee.getHR_Job_ID());
			    			movement.setColumnType(concept.getColumnType());
			    			movement.setValidFrom(period.getStartDate());
			    			movement.setValidTo(period.getEndDate());
			    			movement.setIsPrinted(concept.isPrinted());
			    			movement.setIsRegistered(concept.isRegistered());//Desmarcado por rmontano
			    			movement.setC_Activity_ID(m_employee.getC_Activity_ID());
			    			//movement.setDescription(m_description.toString());
			    			movement.setQty(rs.getBigDecimal(2)); 
			    			movement.setAmount(rs.getBigDecimal(3));
			    			movement.setTextMsg(null);						
			    			movement.setServiceDate(null);
			    			movement.setProcessed(true);
			    			movement.saveEx();
			            }
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}//Process no complit
	}
	
}
