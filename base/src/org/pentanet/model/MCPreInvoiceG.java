package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.JComponent;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.apps.ADialog;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MDocType;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCPreInvoiceG extends X_C_PreInvoiceG implements DocAction, DocOptions{

	
	private String m_processMsg;
	private Boolean from_day_day = false;
	
	private MCPreInvoiceLineG[] m_lines;
	/**
	 * 	Preinvoice Constructor
	 * 	@param ctx context
	 * 	@param C_InvoiceLine_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCPreInvoiceG(Properties ctx, int C_PreInvoiceG_ID, String trxName) {
		super (ctx, C_PreInvoiceG_ID, trxName);
		
		//  New
		if (C_PreInvoiceG_ID == 0)
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

	
	public Boolean getFrom_day_day() {
		return from_day_day;
	}


	public void setFrom_day_day(Boolean from_day_day) {
		this.from_day_day = from_day_day;
	}


	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCPreInvoiceG (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	
	
	
	
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
		
		
		// If status = Completed, add "Reactivate" in the list
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
		
		//String sql = "SELECT COUNT(*) FROM C_PreInvoice WHERE C_DocType_ID = ? AND C_PreInvoiceG_ID = ?";
		int gen = DB.getSQLValue(get_TrxName(), 
				"SELECT COUNT(*) FROM C_PreInvoice WHERE C_DocType_ID = ? AND C_PreInvoiceG_ID = ?",
				getC_DocType_ID(), getC_PreInvoiceG_ID());
		
		if(gen>0)
			return DocAction.STATUS_InProgress;
		
		MCWorkDDLine workDDLine = null;
		
		//Generate Preinvoice	
		MCPreInvoice pinv = new MCPreInvoice(Env.getCtx(), 0, get_TrxName());
		
		pinv.setC_PreInvoiceG_ID(getC_PreInvoiceG_ID());
		pinv.setValue(getValue());
		pinv.setDocumentNo(getDocumentNo());
		pinv.setDescription(getDescription());
		pinv.setHelp(getHelp());
		pinv.setC_DocType_ID(getC_DocType_ID());
		pinv.setAD_Org_ID(getAD_Org_ID());
		pinv.setC_Activity_ID(getC_Activity_ID());
		pinv.setC_Currency_ID(getC_Currency_ID());
		pinv.setC_Municipality_ID(getC_Municipality_ID());
		pinv.setC_Contract_ID(getC_Contract_ID());
		pinv.setDateAcct(getDateAcct());
		pinv.setDateDoc(getDateDoc());
		pinv.setStartDate(getStartDate());
		pinv.setEndDate(getEndDate());
		pinv.setGrandTotal(getGrandTotal());
		pinv.setGrandTotal_Pure(getGrandTotal_Pure());
		pinv.setGrandTotal_Usd(getGrandTotal_Usd());
		pinv.save();
		
		//Preinvoice Lines
		for (int i = 0; i < getLines().length; i++){
			
			MCPreInvoiceLineG line = m_lines[i];
			
			MCPreInvoiceLine pinvl = new MCPreInvoiceLine(Env.getCtx(), 0, get_TrxName());
			pinvl.setAD_Org_ID(line.getAD_Org_ID());
			pinvl.setC_PreInvoice_ID(pinv.getC_PreInvoice_ID());
			pinvl.setC_PreInvoiceG_ID(pinv.getC_PreInvoiceG_ID());
			pinvl.setC_ContractLine_ID(line.getC_ContractLine_ID());
			pinvl.setC_Charge_ID(line.getC_Charge_ID());
			pinvl.setQty(line.getQty());
			pinvl.setPrice(line.getPrice());
			pinvl.setC_UOM_ID(DB.getSQLValue(null, "select c_uom_id from c_contractline where C_contractline_id = " + line.getC_ContractLine_ID()));
			pinvl.setPrice_Usd(line.getPrice_Usd());
			pinvl.setPrice_Pure(line.getPrice_Pure());
			pinvl.setLineNetAmt(line.getLineNetAmt());
			pinvl.setLineNetAmt_Usd(line.getLineNetAmt_Usd());
			pinvl.setLineNetAmt_Pure(line.getLineNetAmt_Pure());
			pinvl.save();
			
			//Join Work Day Day with Preinvoice Line
			if(line.getWorkDDLines()!=null){ 
				
				for (int j = 0; j < line.getWorkDDLines().length; j++){
					
					workDDLine = line.getWorkDDLines()[j];
					if(workDDLine.getC_PreInvoiceLine_ID()==0){
						workDDLine.setC_PreInvoiceLine_ID(pinvl.getC_PreInvoiceLine_ID());
						workDDLine.save();
					}
				}//for
			}
			
			if(!from_day_day && line.getWorkDDLines().length == 0)// si viene desde el dia a dia, es porque ya fue restado del contrato
			{
				//Update Contract Qty Preinvoiced
				X_C_ContractLine contLine = new X_C_ContractLine(Env.getCtx(), line.getC_ContractLine_ID(), get_TrxName());
				contLine.setQtyPreinvoiced(contLine.getQtyPreinvoiced().subtract(line.getQty()));
				contLine.save();
			}
			
		}//Preinvoice Lines	
		
		
		//Differences between Day-Day and Preinvoice
		createDifferences();
		
		
		pinv.processIt(DOCACTION_Complete);
		pinv.save();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cl.value, cl.name,(cl.qty - cl.qtypreinvoiced)::numeric(20,2) as qty_disp "
					+"FROM c_contractline cl "
					+"INNER JOIN C_PreInvoiceline pl ON pl.c_contractline_id = cl.c_contractline_id "
					+"WHERE  (cl.qty - cl.qtypreinvoiced) < (cl.qty*10/100) AND pl.C_PreInvoiceG_ID="+getC_PreInvoiceG_ID();
		
		pstmt = DB.prepareStatement(sql,null);
		try{
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
			String mensaje = "";
			while (rs.next())
			{
				if(mensaje.equals(""))
				{
					mensaje += "Quedan menos de 10% de las siguientes partidas:\n\n";
				}
				mensaje += rs.getString(1)+" - "+rs.getString(2)+"\n";
			}
			
			if(!mensaje.equals(""))
				
			{
				ADialog.info(0, null, mensaje);
			}
		}
		catch(SQLException e)
		{
		
		}
		
		return DocAction.STATUS_InProgress;
	}


	public MCPreInvoiceLineG[] getLines(){
		
		if (m_lines != null && m_lines.length != 0) {
			set_TrxName(m_lines, get_TrxName());
			return m_lines;
		}
		
		//
		String sql = "SELECT * FROM C_PreInvoiceLineG WHERE C_PreInvoiceG_ID = ?";
		ArrayList<MCPreInvoiceLineG> list = new ArrayList<MCPreInvoiceLineG>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			pstmt.setInt (1, getC_PreInvoiceG_ID());
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				MCPreInvoiceLineG line = new MCPreInvoiceLineG(getCtx(), rs, get_TrxName());
				list.add (line);
			}
		} 
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		//
		m_lines = new MCPreInvoiceLineG[list.size ()];
		list.toArray (m_lines);
		return m_lines;
	}
	
	/**
	 * 
	 */
	private void createDifferences(){
		
		MCWorkDD workDD2 = null;
		
		for (int i = 0; i < getLines().length; i++){
					
			MCPreInvoiceLineG line = m_lines[i];
			BigDecimal qtyWorkDD = new BigDecimal(0);
				
			if(line.getWorkDDLines()!=null){ 
						
				qtyWorkDD = new BigDecimal(0);
						
				for (int j = 0; j < line.getWorkDDLines().length; j++){	
					MCWorkDDLine workDDLine = line.getWorkDDLines()[j];	
					qtyWorkDD = qtyWorkDD.add(workDDLine.getQty());	
				} 
				
			} //if
			
			//Differences between Day-Day and Preinvoice
			if(qtyWorkDD.signum()!=0){
				
				BigDecimal qtyDiff = line.getQty().subtract(qtyWorkDD);
						
				//Validate Difference
				if(qtyDiff.signum()!=0){
					if(workDD2==null){
						workDD2 = new MCWorkDD(getCtx(), 0, get_TrxName());
						workDD2.setAD_Org_ID(getAD_Org_ID());
						workDD2.setC_WorkDDG_ID(getC_WorkDDG_ID());
						workDD2.setC_DocType_ID(1000100);  /////////////////////////OJO/////////////////
						workDD2.setDateDoc(getDateDoc());
						workDD2.setDateAcct(getDateAcct());
						workDD2.setC_Contract_ID(getC_Contract_ID());
						workDD2.setC_Activity_ID(getC_Activity_ID());
						workDD2.setC_Municipality_ID(getC_Municipality_ID());
						workDD2.setC_Currency_ID(getC_Currency_ID());
						workDD2.setStartDate(getStartDate());
						workDD2.setEndDate(getEndDate());
						workDD2.save();
					}
					
					MCWorkDDLine workDDLine2 = new MCWorkDDLine(getCtx(), 0, get_TrxName());
					workDDLine2.setAD_Org_ID(line.getAD_Org_ID());
					workDDLine2.setC_WorkDD_ID(workDD2.getC_WorkDD_ID());
					workDDLine2.setC_ContractLine_ID(line.getC_ContractLine_ID());
					workDDLine2.setC_Charge_ID(line.getC_Charge_ID());
					workDDLine2.setC_UOM_ID(DB.getSQLValue(null, "select c_uom_id from c_contractline where C_contractline_id = " + line.getC_ContractLine_ID()));
					workDDLine2.setQty(qtyDiff);
					workDDLine2.setPrice_Pure(line.getPrice_Pure());
					workDDLine2.setPrice_Usd(line.getPrice_Usd());
					workDDLine2.setC_PreInvoiceLineG_ID(line.getC_PreInvoiceLineG_ID());
					//workDDLine2.setC_PreInvoiceLine_ID(pinvl.getC_PreInvoiceLine_ID());
					workDDLine2.save();
				}
			}
		}//for			
				
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
		
		//No Aprobado
		if(!isApproved())
			return false;
		
		setProcessed(true);
		setDocAction(DOCACTION_None);	
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
		if(getValue() == null || getValue().toString().length() < 2)
		{
			String code = DB.getSQLValueString(null, "SELECT * FROM generate_preinvoiceg_code("+getC_Contract_ID()+","+getC_Activity_ID()+")");
			
			setValue(code);
		}
		
		return true;
	}	//	beforeSave
	
	protected boolean afterSave(boolean newRecord, boolean success)
	{
		
		return true;
	}



	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Solo se borra lo que este en estado Borrador
	@Override
	protected boolean beforeDelete() {
		
		String valida =  DB.getSQLValueString(null,"SELECT DocStatus FROM C_PreInvoice WHERE C_PreInvoice_ID=" + getC_PreInvoiceG_ID());
        if (!valida.contains("DR")){
        	
        	throw new AdempiereException("No se puede Eliminar este documento por motivos de Auditoria");

        }
		
		return true;
	}

	
	/**
	 * 	Set Processed.
	 * 	Propergate to Lines
	 *	@param processed processed
	 */
	public void setProcessed (boolean processed)
	{
		super.setProcessed (processed);
		if (get_ID() == 0)
			return;
		String set = "SET Processed='"
			+ (processed ? "Y" : "N")
			+ "' WHERE C_PreInvoiceG_ID=" + getC_PreInvoiceG_ID();
		int noLine = DB.executeUpdate("UPDATE C_PreInvoiceLineG " + set, get_TrxName());
		m_lines = null;
		
		log.fine(processed + " - Lines=" + noLine);
	}	//	setProcessed
	
}
