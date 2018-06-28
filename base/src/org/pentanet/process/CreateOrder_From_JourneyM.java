package org.pentanet.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.wf.DocWorkflowManager;
import org.compiere.apps.ADialog;

import java.util.Properties;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.pentanet.model.X_C_JourneyManagement;
import org.pentanet.model.X_C_JourneyManagement_Line;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MRequisition;
import org.compiere.model.MTab;

/* Función para Crear Orden desde Gerenciamiento de Viajes
 * @autor Ronny Montaño
 * */
public class CreateOrder_From_JourneyM extends SvrProcess {

	private int C_JourneyManagement_ID;
	private int C_DocType_ID;
	private int C_BPartner_Location_ID;
	private int C_BPartner_ID;
	private int C_PaymentTerm_ID;
	private int C_Order_ID;
	private int C_Tax_ID;
	private int C_OrderLine_ID;
	private MOrder order;
	private String sql;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	protected String doIt() throws Exception {
			
		C_JourneyManagement_ID = getRecord_ID();
		String cc;		
		Date fecha = new Date();
		Timestamp fechaTS = new Timestamp(fecha.getTime());
		
		X_C_JourneyManagement journeyM = new X_C_JourneyManagement(getCtx(), C_JourneyManagement_ID, get_TrxName());   //Objeto del Gerenciamiento
		MRequisition req = new MRequisition(getCtx(), journeyM.getM_Requisition_ID(), get_TrxName()); //Objeto de la Requisición
		
		String mensaje = verifyPriceList (journeyM.getM_PriceList_ID(), journeyM.getC_JourneyManagement_ID());
		if(mensaje.length()>0)
		{
			return "ERROR: Productos no pertenecen a Lista de Precio: " + mensaje;
		}
		
		
		C_BPartner_ID = journeyM.getC_BPartner_ID(); //Socio de Negocio
		if(C_BPartner_ID==0)
		{
			return "ERROR: Socio de Negocio";
		}
			
		C_DocType_ID=journeyM.getC_DocTypeTarget_ID(); 
		if(C_DocType_ID==0)
		{
			return "ERROR: Tipo de Documento";
		}
		
		//Dirección Socio de Negocio
		sql = "SELECT C_BPartner_Location_ID FROM C_BPartner_Location WHERE IsActive='Y' AND C_BPartner_ID=" + C_BPartner_ID;
		C_BPartner_Location_ID = DB.getSQLValue(get_TrxName(), sql);
		if(C_BPartner_Location_ID==0)
		{
			return "ERROR: Dirección Socio de Negocio";
		}
		
		//Termino de Pago Socio de Negocio
		sql = "SELECT PO_PaymentTerm_ID FROM C_BPartner WHERE C_BPartner_ID=" + C_BPartner_ID;
		C_PaymentTerm_ID = DB.getSQLValue(get_TrxName(), sql);
		if(C_PaymentTerm_ID==0)
		{
			return "ERROR: Término de Pago";
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
			order.setAD_User_Gest_ID(journeyM.getAD_User_Gest_ID());
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
				+ "IsApplied, COALESCE(help,' ') FROM C_JourneyManagement_Line WHERE C_JourneyManagement_ID=" + C_JourneyManagement_ID;
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
					
					MOrderLine oline = new MOrderLine(getCtx(), 0, get_TrxName());
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
			return e.toString();
		}

		journeyM.setProcessed(true);
		journeyM.setIsGenerated(true);
		journeyM.save();
	
		//Completar Orden
		order.setProcessed(true);
		order.save();
		DocWorkflowManager.processStartWF(order);
		
		journeyM.setC_Order_ID(order.getC_Order_ID());
		journeyM.save();
		
		//Marcar Lineas que ya esten completadas el servicio
		verifyRequisition(req.getM_Requisition_ID());
		
			return "Orden Generada Nro " + order.getDocumentNo();
	}
	
	
	/* Verifica si los productos pertenecen a la lista de precio
	 * 
	 */
	
	protected String verifyPriceList (int M_PriceList_ID, int C_JourneyManagement_ID)
	{
		String mensaje = "";
		log.warning("M_PriceList_ID= " + M_PriceList_ID + "    C_JourneyManagement_ID= "+ C_JourneyManagement_ID);
		sql = "SELECT jml.M_Product_ID, f.M_Product_ID, p.Name FROM C_JourneyManagement_Line jml "
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
	
	protected boolean verifyRequisition(int M_Requisition_ID)
	{
		//Lineas de la requisición que NO tienen cantidades pendientes
		sql = "SELECT * FROM (SELECT f.M_RequisitionLine_ID, SUM(pend) pend, SUM(pend_qty) pend_qty " +
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

	/*
	 * Verificar si hay una orden abierta de la misma requisición y proveedor
	 */
	
	protected int verifyOrder(int M_Requisition_ID, int C_BPartner_ID)
	{
		sql = "SELECT coalesce(MAX(ol.C_Order_ID),0) FROM C_Order o "
				+ "INNER JOIN C_OrderLine ol ON ol.C_Order_ID = o.C_Order_ID "
				+ "INNER JOIN M_RequisitionLine rl ON rl.M_RequisitionLine_ID = ol.M_RequisitionLine_ID "
				+ "WHERE o.DocStatus='DR' AND rl.M_Requisition_ID=" + M_Requisition_ID + " AND o.C_BPartner_ID="+C_BPartner_ID;

		return DB.getSQLValue(get_TrxName(), sql);
	}
	
}
