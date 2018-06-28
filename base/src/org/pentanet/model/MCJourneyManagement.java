package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.wf.DocWorkflowManager;
import org.compiere.wf.MWorkflow;
import org.pentanet.model.X_C_JourneyManagement_Line;
import org.compiere.model.MColumn;
import org.compiere.model.MDocType;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProcess;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfo;
import org.pentanet.model.X_M_ProductTransp_Line;
import org.pentanet.process.CreateOrder_From_JourneyM;


public class MCJourneyManagement extends X_C_JourneyManagement implements DocAction,DocOptions{

	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;

	private String m_processMsg;

	private int C_DocType_ID;
	private int C_BPartner_Location_ID;
	private int C_BPartner_ID;
	private int C_PaymentTerm_ID;
	private int C_Order_ID;
	private int C_Tax_ID;
	private int C_OrderLine_ID;
	private MOrder order;
	private String sql;
	
	public MCJourneyManagement (Properties ctx, int C_JourneyManagement_ID, String trxName)
	{
		super (ctx, C_JourneyManagement_ID, trxName);
		//  New
		if (C_JourneyManagement_ID == 0)
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
	public MCJourneyManagement(Properties ctx, ResultSet rs, String trxName)
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
		
		
		// If status = Completed, add "Reactivate" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
			options[index++] = DocumentEngine.ACTION_ReActivate;
			//options[index++] = DocumentEngine.ACTION_Void;
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
		
		setAD_User_Gest_ID(Env.getAD_User_ID(getCtx()));
		
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

	
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}
		
		setIsGenerated(true);
		
		// Create ODC Complete
		if(!createOrder())
			setIsGenerated(false);

		
		if (!isApproved())
			approveIt();
		
		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();
		
		setProcessed(true);
		
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
						
	} //completit
	
	
	/**
	 * 	Set Processed.
	 * 	Propagate to Lines
	 *	@param processed processed
	 */
	public void setProcessed (boolean processed)
	{
		super.setProcessed (processed);
		if (get_ID() == 0)
			return;
		//
		final String sql = "UPDATE C_JourneyManagement_Line SET Processed=? WHERE C_JourneyManagement_ID=?";
		int noLine = DB.executeUpdateEx(sql, new Object[]{processed, getC_JourneyManagement_ID()}, get_TrxName());
		
		log.fine("Processed=" + processed + " - Lines=" + noLine);
	}	//	setProcessed
	
	
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
		
		if(isGenerated()){
			MOrder ord = new MOrder(Env.getCtx(), getC_Order_ID(), get_TrxName());
			
			if(!ord.getDocStatus().contains("RE") && !ord.getDocStatus().contains("VO") && ord.getC_Order_ID() != 0) {
				m_processMsg = "No se puede Reactivar el Documento. ***Orden Generada***";
				return false;
			}
		}
		
		setC_Order_ID(0);
		
		setDocAction(DOCACTION_Complete);
		setDocStatus(DOCSTATUS_Drafted);
		setProcessed(false);
		setIsGenerated(false);
		setIsApproved(false);
		setIsApproved2(false);
		setIsApproved3(false);
		
		return true;
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
		if(getC_JourneyManagement_ID()<=0)
		{
			String value = DB.getDocumentNo (getAD_Client_ID(), p_info.getTableName(), get_TrxName(), this);
			setValue(value);
			setDocumentNo(value);
		}
		return true;
	}
	
	/**
	 * 	Crear líneas del Gerenciamiento antes de Guardar
	 *	@param newRecord Id del Gerenciamiento
	 **	@param success Guardado con exito
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		String sql, sql2;
		sql = "SELECT COUNT(*) FROM C_JourneyManagement_Line WHERE C_JourneyManagement_ID="+getC_JourneyManagement_ID();
		int cont = DB.getSQLValue(get_TrxName(), sql);
		BigDecimal precio = new BigDecimal(0);
		
		if(cont==0) //Si NO tiene líneas
		{
			//Obtener líneas de la requisición
			sql = "SELECT M_Product_ID, (CASE WHEN C_Activity_ID is null THEN (SELECT C_Activity_ID FROM M_Requisition "
				+ "WHERE M_Requisition_ID="+getM_Requisition_ID()+") ELSE C_Activity_ID END), "
				+ "C_UOM_ID, Qty, PriceActual, LineNetAmt, IsPrincipal, Description, M_RequisitionLine_ID, "
				+ "C_Table_CostLine_ID, hour_qty "
				+ "FROM M_RequisitionLine WHERE IsReady='N' AND M_Requisition_ID="+getM_Requisition_ID();
			
			MRequisition req = new MRequisition(getCtx(), getM_Requisition_ID(), get_TrxName());
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try  //try 1
			{
				pstmt = DB.prepareStatement(sql, get_TrxName());
				rs = pstmt.executeQuery();
				
				while(rs.next()) //while 1
				{
					BigDecimal qty = new BigDecimal(0);
					if(rs.getBigDecimal(4).signum()>0){
						qty = rs.getBigDecimal(4);
					}
					else if(rs.getBigDecimal(11).signum()>0){
						qty = rs.getBigDecimal(11);
					}
					
					precio = getPrice(rs.getInt(1));
					
					//Crear las Líneas del Gerenciamiento (Monitoreo)
					X_C_JourneyManagement_Line journeyL = new X_C_JourneyManagement_Line(getCtx(), 0, get_TrxName());
					journeyL.setC_JourneyManagement_ID(getC_JourneyManagement_ID());
					journeyL.setM_Product_ID(rs.getInt(1));
					journeyL.setC_Activity_ID(rs.getInt(2));
					journeyL.setC_UOM_ID(rs.getInt(3));
					journeyL.setDateStart(req.getDateRequired());
					journeyL.setDateEnd(req.getDateRequired());
					journeyL.setQtyEntered(qty);
					journeyL.setPriceList(precio);
					journeyL.setLineNetAmt(precio.multiply(qty));
					journeyL.setIsPrincipal(rs.getBoolean(7));
					journeyL.setDescription(rs.getString(8));
					journeyL.setM_RequisitionLine_ID(rs.getInt(9));
					journeyL.setC_Table_CostLine_ID(rs.getInt(10));
					journeyL.save();
					
					//Crear las Líneas del Transporte de Carga (Con gerenciamiento pendiente)
					sql2 ="select * from (SELECT pt.M_ProductTransportation_ID, pt.M_Product_ID, pt.C_UOM_ID, "
							+ "(isnull(pt.Qty) - SUM(isnull(ptl.Qty))) pend "
							+ "FROM M_ProductTransportation pt LEFT JOIN M_ProductTransp_Line ptl ON "
							+ "ptl.M_ProductTransportation_ID = pt.M_ProductTransportation_ID "
							+ "WHERE pt.M_RequisitionLine_ID="+rs.getInt(9)
							+ " GROUP BY pt.M_ProductTransportation_ID, pt.M_Product_ID, pt.C_UOM_ID, pt.Qty) f WHERE f.pend>0";
					
					PreparedStatement pstmt_l = null;
					ResultSet rs_l = null;
					
					try //try 2
					{
						pstmt_l = DB.prepareStatement(sql2, get_TrxName());
						rs_l = pstmt_l.executeQuery();
						while(rs_l.next()) //while 2
						{
							X_M_ProductTransp_Line transp = new X_M_ProductTransp_Line(getCtx(), 0, get_TrxName());
							transp.setM_ProductTransportation_ID(rs_l.getInt(1));
							transp.setM_Product_ID(rs_l.getInt(2));
							transp.setC_UOM_ID(rs_l.getInt(3));
							transp.setC_JourneyManagement_Line_ID(journeyL.getC_JourneyManagement_Line_ID());
							transp.setQty(rs_l.getBigDecimal(4));
							transp.setAD_Org_ID(req.getAD_Org_ID());
							transp.save();
						} //while 2
						pstmt_l.close();
						rs_l.close();
					}
					catch(Exception e)
					{
						log.info(e.toString());
						return false;
					} //try 2
					
				} //while 1
				
				pstmt.close();
				rs.close();
			}
			catch(Exception e)
			{
				log.info(e.toString());
				return false;
			} //try 1
		}
		
		return true;
	}	//	After Save

	
	/*
	 * Precio de Lista
	 */
	private BigDecimal getPrice(int M_Product_ID){
		
		sql="SELECT MAX(pp.PriceList) FROM M_PriceList pl INNER JOIN M_PriceList_Version plv ON plv.M_PriceList_ID=pl.M_PriceList_ID " +
				"INNER JOIN C_JourneyManagement jm ON jm.M_PriceList_ID=pl.M_PriceList_ID " +
		    	"INNER JOIN M_ProductPriceVendorBreak pp ON pp.M_PriceList_Version_ID=plv.M_PriceList_Version_ID AND pp.C_BPartner_ID = jm.C_BPartner_ID " +
		    	"WHERE pp.M_Product_ID=" + M_Product_ID + " AND jm.C_JourneyManagement_ID=" + getC_JourneyManagement_ID() + " AND plv.IsActive='Y'";
		
		BigDecimal precio = DB.getSQLValueBD(null, sql);
		
		if(precio==null){
		    sql="SELECT MAX(pp.PriceList) FROM M_PriceList pl INNER JOIN M_PriceList_Version plv ON plv.M_PriceList_ID=pl.M_PriceList_ID " +
			    	"INNER JOIN M_ProductPrice pp ON pp.M_PriceList_Version_ID=plv.M_PriceList_Version_ID " +
			    	"INNER JOIN C_JourneyManagement jm ON jm.M_PriceList_ID=pl.M_PriceList_ID " +
			    	"WHERE pp.M_Product_ID=" + M_Product_ID + " AND jm.C_JourneyManagement_ID=" + getC_JourneyManagement_ID() + " AND plv.IsActive='Y'";
		}
		
		if(precio==null){
			precio = new BigDecimal(0);
		}
		
		return precio;
	}
	
	/*
	 * Crear Orden
	 */
	public boolean createOrder(){

		String cc;		
		Date fecha = new Date();
		Timestamp fechaTS = new Timestamp(fecha.getTime());
		
		X_C_JourneyManagement journeyM = new X_C_JourneyManagement(getCtx(), getC_JourneyManagement_ID(), get_TrxName());   //Objeto del Gerenciamiento
		MRequisition req = new MRequisition(getCtx(), journeyM.getM_Requisition_ID(), get_TrxName()); //Objeto de la Requisición
		
		String mensaje = verifyPriceList (journeyM.getM_PriceList_ID(), journeyM.getC_JourneyManagement_ID());
		if(mensaje.length()>0)
		{
			m_processMsg = "Productos no pertenecen a Lista de Precio: " + mensaje;
			return false;
		}
		
		
		C_BPartner_ID = journeyM.getC_BPartner_ID(); //Socio de Negocio
		if(C_BPartner_ID==0){
			m_processMsg = "ERROR: Socio de Negocio";
			return false;
		}
			
		C_DocType_ID=journeyM.getC_DocTypeTarget_ID();
		if(C_DocType_ID==0){
			m_processMsg = "ERROR: Tipo de Documento";
			return false;
		}
		
		//Dirección Socio de Negocio
		sql = "SELECT C_BPartner_Location_ID FROM C_BPartner_Location WHERE IsActive='Y' AND C_BPartner_ID=" + C_BPartner_ID;
		C_BPartner_Location_ID = DB.getSQLValue(get_TrxName(), sql);
		if(C_BPartner_Location_ID==0){
			m_processMsg = "ERROR: Dirección Socio de Negocio";
			return false;
		}
		
		//Termino de Pago Socio de Negocio
		sql = "SELECT PO_PaymentTerm_ID FROM C_BPartner WHERE C_BPartner_ID=" + C_BPartner_ID;
		C_PaymentTerm_ID = DB.getSQLValue(get_TrxName(), sql);
		if(C_PaymentTerm_ID==0){
			m_processMsg = "ERROR: Término de Pago Socio de Negocio";
			return false;
		}
		
		//Value del Centro de Costo
		cc = DB.getSQLValueString(null,"SELECT substr(value,1,10) FROM C_Activity WHERE C_Activity_ID="+req.getC_Activity_ID());
		
		//C_Order_ID = verifyOrder(req.getM_Requisition_ID(), C_BPartner_ID);
		
		C_Order_ID =0; //Para crear una orden por gerenciamiento
		if(C_Order_ID==0)
		{
			//Crear ORDEN
			order = new MOrder(getCtx(), 0, get_TrxName());
			order.setAD_Org_ID(req.getAD_Org_ID());
			order.setC_DocType_ID(C_DocType_ID);
			order.setC_DocTypeTarget_ID(C_DocType_ID);
			order.setC_BPartner_ID(C_BPartner_ID);
			order.setBill_BPartner_ID(C_BPartner_ID);
			order.setC_BPartner_Location_ID(C_BPartner_Location_ID);
			order.setBill_Location_ID(C_BPartner_Location_ID);
			order.setM_Warehouse_ID(req.getM_Warehouse_ID());
			order.setPriorityRule(req.getPriorityRule());
			order.setInvoiceRule("D");
			order.setM_PriceList_ID(journeyM.getM_PriceList_ID());
			order.setC_Currency_ID(205);                            //Bolivares
			order.setC_PaymentTerm_ID(C_PaymentTerm_ID);
			order.setC_Activity_ID(req.getC_Activity_ID());
			order.setDescription(req.getDescription());
			order.setDateOrdered(fechaTS);
			order.setDatePromised(fechaTS);
			order.setDateAcct(fechaTS);
			order.setDocAction("CO");
			order.setIsSOTrx(false);
			order.setAD_User_ID(req.getAD_User_ID());
			order.save();
			order.setAD_User_Gest_ID(getAD_User_Gest_ID());
			order.setC_Bl_ID(req.getC_Bl_ID());
			order.setC_JourneyManagement_ID(journeyM.getC_JourneyManagement_ID());
			order.save();
			
			C_Order_ID = order.getC_Order_ID();
		}
		else
		{
			//Objeto de la orden
			order = new MOrder(getCtx(), C_Order_ID, get_TrxName());
		}
		
		//Líneas del gerenciamiento
		sql = "SELECT M_Product_ID, Description, QtyEntered, C_UOM_ID, (CASE WHEN PriceEntered<>0 THEN PriceEntered ELSE PriceList END), "
				+ "C_Activity_ID, LineNetAmt, DateStart, IsPrincipal, C_JourneyManagement_Line_ID, isnull(M_RequisitionLine_ID), "
				+ "IsApplied, COALESCE(help,' ') FROM C_JourneyManagement_Line WHERE C_JourneyManagement_ID=" + getC_JourneyManagement_ID();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{	
			pstmt = DB.prepareStatement(sql, get_TrxName());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				C_OrderLine_ID = 0;
				if(rs.getString(12).equals("N")) //Si NO es monto cero
				{
					sql="SELECT tax.C_Tax_ID FROM C_Tax tax " +
						"INNER JOIN M_Product pro ON tax.C_TaxCategory_ID = pro.C_TaxCategory_ID " +
						"WHERE tax.IsDefault='Y' AND tax.IsActive='Y' AND M_Product_ID=" + rs.getInt(1);
					C_Tax_ID = DB.getSQLValue(get_TrxName(), sql);
					
					MRequisitionLine rlin = new MRequisitionLine (getCtx(),0,get_TrxName());
					
					MOrderLine oline = new MOrderLine(getCtx(), rs.getInt(11), get_TrxName());
					oline.setC_Order_ID(C_Order_ID);
					oline.setC_BPartner_ID(C_BPartner_ID);
					oline.setC_BPartner_Location_ID(C_BPartner_Location_ID);
					oline.setM_Product_ID(rs.getInt(1));
					oline.setDescription(rs.getString(2));
					oline.setQtyEntered(rs.getBigDecimal(3));
					oline.setQtyOrdered(rs.getBigDecimal(3));
					oline.setQty(rs.getBigDecimal(3));
					oline.setC_UOM_ID(rs.getInt(4));
					oline.setPriceEntered(rs.getBigDecimal(5));
					oline.setPriceActual(rs.getBigDecimal(5));
					oline.setPriceList(rs.getBigDecimal(5));
					oline.setC_Tax_ID(C_Tax_ID);
					oline.setC_Activity_ID(rs.getInt(6));
					oline.setLineNetAmt(rs.getBigDecimal(7));
					oline.setDatePromised(rs.getTimestamp(8));
					oline.setDateOrdered(order.getDateOrdered());
					oline.setIsPrincipal(rs.getBoolean(9));
					oline.setAD_Org_ID(order.getAD_Org_ID());
					oline.setM_RequisitionLine_ID(rs.getInt(11));
					oline.setJustification(rs.getString(13));
					oline.setC_Manage_Unit_ID(rlin.getC_Manage_Unit_ID());
					oline.setC_BudgetPublic_ID(rlin.getC_BudgetPublic_ID());
					oline.setC_ElementValue_ID(rlin.getC_ElementValuet_ID());
					
					oline.save();
					C_OrderLine_ID = oline.getC_OrderLine_ID();
				}
				X_C_JourneyManagement_Line journeyl = new X_C_JourneyManagement_Line(getCtx(), rs.getInt(10), get_TrxName());
				journeyl.setC_OrderLine_ID(C_OrderLine_ID);
				journeyl.setProcessed(true);
				journeyl.save();
			}
			
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			log.info(e.toString());
			return false;
		}

		journeyM.setProcessed(true);
		journeyM.setIsGenerated(true);
		journeyM.save();
	
		//Completar Orden
		order.setProcessed(true);
		order.save();
		DocWorkflowManager.processStartWF(order);

		setC_Order_ID(order.getC_Order_ID());
		//Marcar Lineas que ya esten completadas el servicio
		verifyRequisition(req.getM_Requisition_ID());
		
		return true;
	}
	
	
	/* Verifica si los productos pertenecen a la lista de precio
	 * 
	 */
	
	protected String verifyPriceList (int M_PriceList_ID, int C_JourneyManagement_ID)
	{
		String mensaje = "";
		
		String sql = "SELECT jml.M_Product_ID, f.M_Product_ID, p.Name FROM C_JourneyManagement_Line jml "
				+ "LEFT JOIN (SELECT pp.M_Product_ID FROM M_PriceList_Version plv "
				+ "INNER JOIN M_ProductPrice pp ON pp.M_PriceList_Version_ID = plv.M_PriceList_Version_ID "
				+ "WHERE plv.M_PriceList_ID = " + M_PriceList_ID + ") f ON f.M_Product_ID=jml.M_Product_ID "
				+ "INNER JOIN M_Product p ON p.M_Product_ID=jml.M_Product_ID "
				+ "WHERE jml.C_JourneyManagement_ID = " + C_JourneyManagement_ID;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
		try
		{
			pstmt1 = DB.prepareStatement(sql, get_TrxName());
			rs1 = pstmt1.executeQuery();
			
			while(rs1.next())
			{
				if(rs1.getInt(2)==0)
				{
					mensaje = mensaje + rs1.getString(3) + ", ";
				}
			}
			
			pstmt1.close();
			rs1.close();
			
		}catch(Exception e) {
			log.info(e.toString());
			return e.toString();
		}
		
		return mensaje;
	}
	
	private boolean verifyRequisition(int M_Requisition_ID)
	{
		//Lineas de la requisición que NO tienen cantidades pendientes
		String sql = "SELECT * FROM (SELECT f.M_RequisitionLine_ID, SUM(pend) pend, SUM(pend_qty) pend_qty " +
				"from (SELECT rl.M_RequisitionLine_ID, pt.M_ProductTransportation_ID, (isnull(pt.Qty) - SUM(isnull(ptl.Qty))) pend, " +
				"(isnull(rl.Qty) - SUM(isnull(jml.QtyEntered))) pend_qty FROM M_RequisitionLine rl " +
					"LEFT JOIN M_ProductTransportation pt ON pt.M_RequisitionLine_ID = rl.M_RequisitionLine_ID " +
					"LEFT JOIN M_ProductTransp_Line ptl ON ptl.M_ProductTransportation_ID = pt.M_ProductTransportation_ID " +
					"LEFT JOIN C_JourneyManagement_Line jml ON jml.M_RequisitionLine_ID = rl.M_RequisitionLine_ID " +
					"WHERE rl.M_Requisition_ID = " + M_Requisition_ID + " GROUP BY rl.M_RequisitionLine_ID, pt.M_ProductTransportation_ID) f " + 
				"GROUP BY f.M_RequisitionLine_ID) f2 WHERE f2.pend<=0 AND f2.pend_qty<=0";
		
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		try
		{
			pstmt2 = DB.prepareStatement(sql, get_TrxName());
			rs2 = pstmt2.executeQuery();
			
			while(rs2.next())
			{
				DB.executeUpdate("UPDATE M_RequisitionLine SET IsReady='Y' WHERE M_RequisitionLine_ID=" + rs2.getInt(1), null);
			}
			
			pstmt2.close();
			rs2.close();
			
		}catch(Exception e) {
			log.info(e.toString());
			return false;
		}
		
		return true;
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
