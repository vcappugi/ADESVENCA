package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.DBException;
import org.compiere.model.MDocType;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.model.X_HR_VacBonusAdvance_Line;
import org.pentanet.model.X_HR_PeriodVac;

public class MHRVacBonusAdvance extends X_HR_VacBonusAdvance implements DocAction,DocOptions{
	
	private static final long serialVersionUID = 20140813L;
	
	private String m_processMsg;
	private X_HR_Credits_Pool pool;
	
	public MHRVacBonusAdvance (Properties ctx, int HR_VacBonusAdvance_ID, String trxName)
	{
		super (ctx, HR_VacBonusAdvance_ID, trxName);
		//  New
		if (HR_VacBonusAdvance_ID == 0)
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
	public MHRVacBonusAdvance (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MHRVacBonusAdvance
	
	
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
		
		if(getTotal().compareTo(new BigDecimal(0))<=0){
			m_processMsg = "Monto Requerido Inválido";
			return DocAction.STATUS_Invalid;
		}
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

	
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}
		
		if (!isApproved())
			approveIt();
		
		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();
		
		
		//Utilidad Fraccionada
		if(getAmtUtiRequired().compareTo(new BigDecimal(0))>0)
			insertPool(getAmtUtiRequired(), "UTIF", getDateRequired());
	
		
		//Utilidad por Generar
		if(getAmtUtiGenRequired().compareTo(new BigDecimal(0))>0)
			insertPool(getAmtUtiGenRequired(), "UTIG", getDateRequired());	
		
		
		//Sueldo por Cobrar
		if(getAmtSCRequired().compareTo(new BigDecimal(0))>0){
			
			BigDecimal amount = getAmtSCRequired().divide(getQtyShareSC(), BigDecimal.ROUND_HALF_UP, 2);
			Timestamp date;
			String sql;
			
			for(int i = 1; i <= getQtyShareSC().intValue(); i++){					
				sql = "SELECT add_months(" + getDateRequired() + ", " + i + ")";
				date = DB.getSQLValueTS(null, sql, getDateRequired());
				
				insertPool(amount, "SC", date);
			}	
		}
		
		
		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
						
	} //completit


	/*
	 * Insertar prestamo en el pool
	 */
	private void insertPool(BigDecimal amount, String value, Timestamp date) {
		
		pool = new X_HR_Credits_Pool(Env.getCtx(), 0, null);
		pool.setC_BPartner_ID(getC_BPartner_ID());
		pool.setC_DocType_ID(getC_DocType_ID());
		pool.setDateStart(date);
		pool.setAD_Table_ID(get_Table_ID());
		pool.setAmount(amount);
		pool.setRecord_ID(getHR_VacBonusAdvance_ID());
		pool.setQty(getQtyShareSC());
		pool.setValue(value);
		pool.save();
		
	}
	
	
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

	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return saved
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		
		//Evaluar si hay registros en la linea
		String sql;
		sql = "SELECT COUNT(*) FROM HR_VacBonusAdvance_Line WHERE HR_VacBonusAdvance_ID="+getHR_VacBonusAdvance_ID();
		Integer con = DB.getSQLValue(null, sql);
		
		boolean modi=false;
		
		//Si hay registros en la linea
		if(con>0)
		{			
			sql = "SELECT C_BPartner_ID FROM HR_Vacation WHERE HR_Vacation_ID ="+
					"(SELECT MAX(HR_Vacation_ID) FROM HR_VacBonusAdvance_Line WHERE HR_VacBonusAdvance_ID="+getHR_VacBonusAdvance_ID()+")";
			Integer oldC_BPartner_ID = DB.getSQLValue(null, sql);
			
			if(oldC_BPartner_ID!=getC_BPartner_ID())
			{
				sql="DELETE FROM HR_VacBonusAdvance_Line WHERE HR_VacBonusAdvance_ID="+getHR_VacBonusAdvance_ID();
				DB.executeUpdate(sql, null);
				modi=true;
			}			
		}

		//Si no habian registros o se eliminaron por haber un cambio de socio de negocio
		if((con<=0)||(modi==true))
		{
			Integer sn = getC_BPartner_ID();
			Integer HR_VacBonusAdvance_ID = getHR_VacBonusAdvance_ID();
			
			String whereclause = "";
			if (getC_DocType_ID() == 1000077){
				whereclause =  " AND vac.DateStart < now() ";
			}
			
			//Cargar Datos de Vacaciones Vencidas
			sql="SELECT vac.HR_Vacation_ID, (vac.BonDays*(atr.amount/30)), vac.HR_PeriodVac_ID FROM HR_Vacation vac " +
			    "INNER JOIN HR_Attribute atr ON atr.C_BPartner_ID=vac.C_BPartner_ID AND atr.IsActive='Y' AND atr.HR_Concept_ID=(SELECT HR_Concept_ID FROM HR_Concept WHERE value='SBM') " +
			    "WHERE vac.C_BPartner_ID="+sn+" AND vac.IsPaid='N' "  + whereclause;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try
			{
				pstmt = DB.prepareStatement(sql, null);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					X_HR_PeriodVac per = new X_HR_PeriodVac (getCtx(), rs.getInt(3), null);
					
					BigDecimal disp = new BigDecimal(0);
					BigDecimal comp = new BigDecimal(0);
					BigDecimal esti = rs.getBigDecimal(2);
					
					//Comprometido de Vacaciones
					sql="SELECT SUM(amount) FROM HR_Credits_Pool WHERE Value='VAC' AND IsDiscounted='N' AND C_BPartner_ID="+sn+" AND "
						+" (DateStart BETWEEN "+ per.getDateStart() +" AND "+ per.getDateEnd() +")";
					comp=DB.getSQLValueBD(sql,null);
					
					if(comp==null)
						comp = new BigDecimal(0);
					
					disp = disp.add(rs.getBigDecimal(2)).subtract(comp);
					
					X_HR_VacBonusAdvance_Line vac = new X_HR_VacBonusAdvance_Line (getCtx(), 0, null);
					vac.setHR_Vacation_ID(rs.getInt(1));
					vac.setHR_VacBonusAdvance_ID(HR_VacBonusAdvance_ID);
					vac.setAmtVacEstimated(esti);
					vac.setAmtVacCommitted(comp);
					vac.setAmtVacAvailable(disp);
					vac.save();
				}
				rs.close();
				pstmt.close();
				pstmt = null;
			}
			catch (SQLException e)
			{
				throw new DBException(e, sql);
			}
			finally
			{
				DB.close(rs, pstmt);
				rs = null; pstmt = null;
			}
		}
		
		return true;
	}	//	afterSave
	
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
	
}   //  MVacationRequisition
