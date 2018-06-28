package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.compiere.apps.ADialog;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.MProductPricing;
import org.compiere.util.DB;
import org.compiere.util.Env;

@SuppressWarnings("unused")
public class CalloutTreatment extends CalloutEngine {

	@SuppressWarnings("deprecation")
	public String GeneraTratAp(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		//Creado por Vladimir Mata
		
		int H_Treatment_ID=Env.getContextAsInt(ctx, WindowNo, "H_Treatment_ID");
		if (H_Treatment_ID==0) return "";
		
		int H_Patient_ID= Env.getContextAsInt(ctx, WindowNo, "H_Patient_ID");
		//********************************
		//Revisar DocStatus IP en el query
		//
		//*************************
		int H_Admission_ID=DB.getSQLValue(null, "SELECT H_Admission_ID FROM H_Admission WHERE H_Patient_ID="+H_Patient_ID+"-- AND DocStatus='IP'");
		if (H_Admission_ID<=0) {
			ADialog.error(WindowNo,null , "No se pudo generar el tratamiento para el paciente ya que no posee una Admisión \"En Proceso\"");
			return "ERROR: Tratamiento no generado";
		}
		//Creación del Tratamiento Aplicado
		//Búsqueda del Tratamiento Padre
		String ID_Tramamiento= Env.getContext(ctx, WindowNo,"H_Treatment_ID");
		MHTreatment Tratamiento = new MHTreatment(ctx, Integer.parseInt(ID_Tramamiento),null);
		
		//Establecimiento de la fecha y hora de inicio del tratamiento aplicado
		Calendar FInicio= new GregorianCalendar();
			
		//Declaración de variables auxiliares para el establecimiento del tratamiento
		Calendar FFin=new GregorianCalendar();
		Calendar aux=new GregorianCalendar();
		Timestamp aplicacion=new Timestamp(0,0,0,0,0,0,0);
		
		int periodo=0;
		int unidad=0;
		int frecuencia=0;
		int contador=0;

		DB.executeUpdate("DELETE FROM H_ATREATMENT WHERE H_TREATMENT_ID="+Integer.parseInt(ID_Tramamiento));
		String sql_l =	"SELECT trl.H_Treatment_ID, trl.M_Product_ID, trl.Dose, trl.C_UOM_ID, trl.Period, cuom.uomsymbol, trl.Frequency, trl.H_TreatmentLine_Id, hist.H_Patient_ID " +
						"FROM H_TreatmentLine trl " +
						"LEFT JOIN C_UOM cuom ON cuom.C_UOM_ID=CAST(trl.PeriodType AS int) " +
						"INNER JOIN H_Treatment tr ON tr.H_Treatment_ID=trl.H_Treatment_ID " +
						"INNER JOIN H_MHistory hist ON hist.H_MHistory_ID=tr.H_MHistory_ID " +
						"WHERE trl.H_Treatment_ID="+Integer.parseInt(ID_Tramamiento);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql_l, "MHATreatment");
			rs = pstmt.executeQuery();
			
			//Creación de cada linea correspondiente al Tratamiento Aplicado
			while (rs.next())
			{
				
				periodo=rs.getInt(5);
				frecuencia=rs.getInt(7);
				
				switch(rs.getString(6).toCharArray()[0]){
				case 'h':	unidad=Calendar.HOUR;
							break;
				case 'd': 	unidad=Calendar.DATE;
							break;							
				case 'm':	unidad=Calendar.MONTH;
							break;
				case 'y':	unidad=Calendar.YEAR;
							break;
				}
				
				MHTreatmentLine LineasTrat=new MHTreatmentLine(ctx, rs.getInt(8),null);
				FInicio.setTimeInMillis(LineasTrat.getTreatmentDate().getTime());
				
				copy(FInicio,aux);
				copy(FInicio,FFin);
				
				FFin.add(unidad, periodo);

				while (aux.compareTo(FFin)<0){
					MHATreatment TratAplicado = new MHATreatment(ctx, 0,null);

					aplicacion.setTime(aux.getTimeInMillis());
					TratAplicado.setApplicationTime(aplicacion);
					TratAplicado.setActualApplicationTime(aplicacion);
										
					TratAplicado.setH_Treatment_ID(rs.getInt(1));
					TratAplicado.setM_Product_ID(rs.getInt(2));
					TratAplicado.setDose(rs.getBigDecimal(3));
					TratAplicado.setC_UOM_ID(rs.getInt(4));
					TratAplicado.setH_Patient_ID(rs.getInt(9));
					TratAplicado.setIsApplied(false);
					TratAplicado.save();
					
					aux.add(Calendar.HOUR, frecuencia);
					contador++;
				}				
			}
		}
		catch(Exception e){
			log.info(e.toString());
			return e.toString();
		}

		return "Tratamiento Aplicado creado satisfactoriamente, "+contador+" registros generados";
	}
	
	public String InsertATInSO(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		
		String val= value.toString(); 
		int H_Patient_ID=Env.getContextAsInt(ctx, WindowNo, "H_Patient_ID");
		int M_Product_ID=Env.getContextAsInt(ctx, WindowNo, "M_ProductSubstitute_ID");
		if (M_Product_ID==0) M_Product_ID=Env.getContextAsInt(ctx, WindowNo, "M_Product_ID");

		int C_UOM_ID=Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
		BigDecimal Qty=new BigDecimal(Env.getContextAsInt(ctx, WindowNo, "Dose"));
		
		if (M_Product_ID==0 || C_UOM_ID==0 || Qty.compareTo(new BigDecimal(0))==0) return"";
		else if ("false".compareTo(val)==0){			
			mTab.setValue("IsApplied", true);
			return "El tratamiento ya fue aplicado e incluido en la orden de consumo anteriormente";
		}
				
		String sql="SELECT abu.H_Asigned_Budget_ID FROM H_Admission adm " +
					"INNER JOIN H_Asigned_Budget abu ON abu.H_Admission_ID=adm.H_Admission_ID " +
					"WHERE adm.H_Patient_ID="+H_Patient_ID+" --AND adm.DocStatus='CO';";//<-- Revisar DocStatus*********
		int H_Asigned_Budget_ID=DB.getSQLValue(null, sql);
		if (H_Asigned_Budget_ID<=0) {
			mTab.setValue("IsApplied", false);
			return "El Paciente no posee ningún Presupuesto asociado";
		}
				
		sql="SELECT DISTINCT co.C_Order_ID FROM H_ATreatment atr " +
			"INNER JOIN H_Admission adm ON adm.H_Patient_ID=atr.H_Patient_ID " +
			"INNER JOIN C_Order co ON co.H_Admission_ID=adm.H_Admission_ID " +
			"WHERE atr.H_Patient_ID="+H_Patient_ID+" --AND adm.DocStatus='CO'"; //<-- Revisar DocStatus*********
		int C_Order_ID=DB.getSQLValue(null, sql);
		if (C_Order_ID<=0) {
			mTab.setValue("IsApplied", false);
			return "El Paciente no posee ninguna Orden de Venta asociada";
		}
		MSalesOrder Order=new MSalesOrder(ctx,C_Order_ID,null);
		MHAdmission Admission=new MHAdmission(ctx, Order.getH_Admission_ID(),null); 
		
		sql="SELECT PriceList FROM M_ProductPrice WHERE M_PriceList_Version_ID="+Admission.getM_PriceList_Version_ID()+" AND M_Product_ID="+M_Product_ID;
		BigDecimal PriceList=DB.getSQLValueBD(null, sql);
		if(PriceList==null) {
			mTab.setValue("IsApplied", false);
			return "El Producto no se encuentra en la Lista de Precios";
		}
				
		Order.CreateOrderLine(Order, M_Product_ID, Qty, PriceList, C_UOM_ID, H_Asigned_Budget_ID, "CO");		
		//Rebaja de Inventario del Tratamiento Aplicado
		CreateInventory(ctx,H_Patient_ID, M_Product_ID, Qty);
		
		return "La Orden de Consumo del Paciente fue actualizada";
	}
	
	public static String CreateInventory (Properties ctx, int H_Patient_ID, int M_Product_ID, BigDecimal Qty){
		//Rebaja de Inventario del Tratamiento Aplicado
		
		MInventory Inventory=new MInventory(ctx,0,null);
		
		String sql="SELECT M_Warehouse_ID FROM H_Admission adm " +
			"INNER JOIN H_Bed bed ON bed.H_Bed_ID=adm.H_Bed_ID " +
			"INNER JOIN H_Room room ON room.H_Room_ID=bed.H_Room_ID " +
			"WHERE adm.H_Patient_ID="+H_Patient_ID+" --AND adm.DocStatus='CO'"; //<-- Revisar DocStatus*********
		
		int M_Warehouse_ID=DB.getSQLValue(null, sql);
		Inventory.setM_Warehouse_ID(M_Warehouse_ID);
		
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Timestamp MovementDate = new java.sql.Timestamp(lnMilisegundos);
		
		Inventory.setMovementDate(MovementDate);
		
		Inventory.setC_DocType_ID(1000023);
		
		String patient=DB.getSQLValueString(null, "SELECT value||'_'||name FROM H_Patient WHERE H_Patient_ID="+H_Patient_ID);
		String admission=DB.getSQLValueString(null, "SELECT value||'_'||name FROM H_Admission WHERE H_Patient_ID="+H_Patient_ID+" --AND DocStatus='CO'");
		String product=DB.getSQLValueString(null, "SELECT value||'_'||name FROM M_Product WHERE M_Product_ID="+M_Product_ID);
		String Description="Rebaja de Inventario del Producto \""+product+"\" para la aplicación del Tratamiento del Paciente \""+patient+"\", cuya Admisión es \""+admission+"\"";
		Inventory.setDescription(Description);
		
		int correlativo=DB.getSQLValue(null, "SELECT COUNT(M_Inventory_ID) FROM M_Inventory WHERE DocumentNo LIKE 'RITA%'");
		Inventory.setDocumentNo("RITA-"+String.format("%07d",correlativo));
		
		Inventory.save();
		
		MInventoryLine InventoryLine=new MInventoryLine(ctx,0,null);
		InventoryLine.setM_Inventory_ID(Inventory.getM_Inventory_ID());
		InventoryLine.setM_Product_ID(M_Product_ID);
		InventoryLine.setQtyInternalUse(Qty);
		
		int C_Charge_ID=DB.getSQLValue(null, "SELECT ProductCharge FROM H_InventoryChargeConf WHERE IsActive='Y'");
		InventoryLine.setC_Charge_ID(C_Charge_ID);
		
		int M_Locator_ID=DB.getSQLValue(null, "SELECT M_Locator_ID FROM M_Locator WHERE M_Warehouse_ID="+M_Warehouse_ID+" AND IsDefault='Y'");
		InventoryLine.setM_Locator_ID(M_Locator_ID);
		
		InventoryLine.setLine(10);
		InventoryLine.save();
		
		Inventory.completeIt();
		Inventory.save();
		return "Creado con éxito";
	}
	
	public static void copy(Calendar fuente, Calendar destino){
		destino.set(fuente.get(Calendar.YEAR),
					fuente.get(Calendar.MONTH),
					fuente.get(Calendar.DATE),
					fuente.get(Calendar.HOUR),
					fuente.get(Calendar.MINUTE),
					fuente.get(Calendar.SECOND));
	}
}
