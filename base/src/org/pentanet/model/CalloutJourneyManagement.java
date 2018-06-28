package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MRequisition;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutJourneyManagement extends CalloutEngine{

	String sql;
	
	/*Completar datos del Transportista
	 * */
	public String fillShipperData (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		if(mTab.getValue("M_Shipper_ID")!=null)
		{
		    //Obtener datos del Transportista
		    sql="SELECT Value FROM M_Shipper WHERE M_Shipper_ID="+mTab.getValue("M_Shipper_ID");
		    String cedula=DB.getSQLValueString(null, sql);
		    if(cedula==null)
		        cedula="";

		    sql="SELECT Phone FROM M_Shipper WHERE M_Shipper_ID="+mTab.getValue("M_Shipper_ID");
		    String tlf=DB.getSQLValueString(null, sql);
		    if(tlf==null)
		        tlf="";

		    mTab.setValue("Phone",tlf);
		    mTab.setValue("Cedula",cedula);
		}
		
		return "";
	}
	
	
	/*Completar datos de la Requisición
	 * */
	public String fillRequisitionData (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
	
		int M_Requisition_ID = 0;
		
		if(mTab.getValue("M_Requisition2_ID")!=null)
		{
			mTab.setValue("M_Requisition_ID", mTab.getValue("M_Requisition2_ID"));
			
			M_Requisition_ID = (Integer)mTab.getValue("M_Requisition_ID");
			
			MRequisition req = new MRequisition(Env.getCtx(), M_Requisition_ID, null);
		    
		    mTab.setValue("C_Table_Cost_ID",req.getC_Table_Cost_ID());
		    mTab.setValue("Description",req.getDescription());
		}
		else if(mTab.getValue("M_Requisition_ID")!=null)
		{
			M_Requisition_ID = (Integer)mTab.getValue("M_Requisition_ID");
			
			MRequisition req = new MRequisition(Env.getCtx(), M_Requisition_ID, null);
		    
		    mTab.setValue("M_PriceList_ID",req.getM_PriceList_ID());
		    mTab.setValue("Description",req.getDescription());
		    mTab.setValue("AD_User_ID", req.getAD_User_ID());
		}
		
		return "";
	}
	
	
	/*Calcular Montos
	 * */
	public String calculateAmounts (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal total = new BigDecimal(0);
		
		int C_JourneyManagement_ID = (Integer)mTab.getValue("C_JourneyManagement_ID");
		X_C_JourneyManagement journey = new X_C_JourneyManagement(Env.getCtx(), C_JourneyManagement_ID, null);
		
		//Si esta checkeado como Monto Cero
		if(mTab.getValue("IsApplied").toString()=="true")
		{
		    mTab.setValue("LineNetAmt", new BigDecimal(0));
		    mTab.setValue("PriceEntered",new BigDecimal(0));
			return "";
		}
		
		if(mTab.getValue("M_Product_ID")!=null) //Producto cargado
		{
			int id_jm = (Integer)mTab.getValue("C_JourneyManagement_ID");
			int id_prod = (Integer)mTab.getValue("M_Product_ID");
			BigDecimal qty = (BigDecimal)mTab.getValue("QtyEntered");
			BigDecimal precioAjust = (BigDecimal)mTab.getValue("PriceEntered");
			BigDecimal porc = new BigDecimal(0);
			BigDecimal precio = new BigDecimal(0);
			
			//Precio del Producto
			if(journey.getM_PriceList_ID()!=0) //Precio según Lista de Precio
			{
				
				sql="SELECT MAX(pp.PriceList) FROM M_PriceList pl INNER JOIN M_PriceList_Version plv ON plv.M_PriceList_ID=pl.M_PriceList_ID " +
						"INNER JOIN C_JourneyManagement jm ON jm.M_PriceList_ID=pl.M_PriceList_ID " +
				    	"INNER JOIN M_ProductPriceVendorBreak pp ON pp.M_PriceList_Version_ID=plv.M_PriceList_Version_ID AND pp.C_BPartner_ID = jm.C_BPartner_ID " +
				    	"WHERE pp.M_Product_ID="+id_prod+" AND jm.C_JourneyManagement_ID="+id_jm+" AND plv.IsActive='Y'";
				
				precio=DB.getSQLValueBD(null, sql);
				
				if(precio==null){
				    sql="SELECT MAX(pp.PriceList) FROM M_PriceList pl INNER JOIN M_PriceList_Version plv ON plv.M_PriceList_ID=pl.M_PriceList_ID " +
					    	"INNER JOIN M_ProductPrice pp ON pp.M_PriceList_Version_ID=plv.M_PriceList_Version_ID " +
					    	"INNER JOIN C_JourneyManagement jm ON jm.M_PriceList_ID=pl.M_PriceList_ID " +
					    	"WHERE pp.M_Product_ID="+id_prod+" AND jm.C_JourneyManagement_ID="+id_jm+" AND plv.IsActive='Y'";
				}
				
			}
			else //Precio según Tabulador
			{
				if((Integer)mTab.getValue("C_Table_CostLine_ID")!=0) //Destino Tabulador
				{
					sql = "SELECT costo FROM C_Table_CostLine WHERE C_Table_Cost_ID="+journey.getC_Table_Cost_ID()+
							" AND C_Table_CostLine_ID="+(Integer)mTab.getValue("C_Table_CostLine_ID");
				}
				else
				{
					return "";
				}
			}
			precio=DB.getSQLValueBD(null, sql);
			
		    //Recargo por tipo de producto
		    switch(id_prod)
		    {
		        case 1004349: //REc 25% por fin de semana y feriado
		            porc = new BigDecimal(0.25);
		            break;

		        case 10005934: //Viaje de Retorno
		            porc= new BigDecimal(0.50);
		            break;

		        case 10005914: //Destino Adicional menor a 80km
		        	porc= new BigDecimal(0.30);
		            break;

		        case 10005913: //Destino Adicional mayor a 81 Km
		        	porc= new BigDecimal(0.80);
		            break;

		        case 1004914: //Incumplimeinto de Servicio por Causas Ajenas
		        	porc= new BigDecimal(-0.50);
		            break;

		        default:
		        	porc= new BigDecimal(0);
		    }		    
		    
		    if(precio==null)
		    	precio= new BigDecimal(0);
		    	
		    if(precioAjust==null)
		    	precioAjust = new BigDecimal(0);
		    
		    if(qty==null)
		    	qty= new BigDecimal(0);
		    
		   if(porc.signum()>0) //Si el producto es de recargo
		    {
		    	sql = "SELECT MAX(CASE WHEN PriceEntered > 0 THEN PriceEntered ELSE PriceList END) "
		    			+ "FROM C_JourneyManagement_Line WHERE IsPrincipal='Y' AND C_JourneyManagement_ID="+id_jm;
		    	precio = DB.getSQLValueBD(null, sql);
		    	if(precio==null)
		    		precio=new BigDecimal(0);
		    	precio = precio.multiply(porc);
		    }
		    
		    if(qty.signum()>0){
		    	if(precioAjust.signum()>0){
		    		total = precioAjust.multiply(qty);
		    	}else{
		    		total = precio.multiply(qty);
		    	}
		    }
		    
		    mTab.setValue("LineNetAmt", total);
		    mTab.setValue("PriceList",precio);
		}
		
		return "";
	}
	
	
	/*Llenar campos en tabla transportar
	 * */
	public String fillTransportate (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		//Unidad de Medida
	    sql = "SELECT C_UOM_ID FROM M_ProductTransportation WHERE M_ProductTransportation_ID="+mTab.getValue("M_ProductTransportation_ID");
	    int um = DB.getSQLValue(null, sql);
		
	    //Producto
	    sql = "SELECT M_Product_ID FROM M_ProductTransportation WHERE M_ProductTransportation_ID="+mTab.getValue("M_ProductTransportation_ID");
	    int prod = DB.getSQLValue(null, sql);
	    
	    mTab.setValue("C_UOM_ID", um);
	    mTab.setValue("M_Product_ID", prod);
	    
		return "";
	}
	
}
