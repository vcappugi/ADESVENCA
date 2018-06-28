package org.pentanet.process;

import java.awt.Window;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.model.MOrder;
import org.pentanet.model.MHTransfer;
import org.pentanet.model.MSalesOrder;
import org.compiere.apps.ADialog;
import org.pentanet.model.*;


public class ProcesTransfer extends SvrProcess {
	private int SalesRegion_ID=0;
	private int SalesRegionD_ID=0;
	private int Bed_ID =0;
	
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("C_SalesRegion_ID"))
				SalesRegion_ID = para[i].getParameterAsInt();
			else if (name.equals("C_SalesRegionD_ID"))
				SalesRegionD_ID = para[i].getParameterAsInt();
			else if (name.equalsIgnoreCase("H_Bed_ID"))
				Bed_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		

	} //prepare

	@Override
	protected String doIt() throws Exception {
		String lineasi="";
		int bet_anterior=0;
		MHTransfer MTo = new MHTransfer(getCtx(), 0,null);
		MHTransfer Mfrom = new MHTransfer(getCtx(), getRecord_ID(),null);
		//verificar donde esta primero
		//int loc_actual = Patient_Locations(Mfrom.getH_Admission_ID());
		//if (loc_actual !=0) {
			//MHTransfer MActual = new MHTransfer(getCtx(),loc_actual,null);
		    MHAdmission admi = new MHAdmission (getCtx(),Mfrom.getH_Admission_ID(),null);
		    
			bet_anterior = admi.getH_Bed_ID();
			int salesregiond = admi.getC_SalesRegionD_ID();
			int salesregion =admi.getC_SalesRegion_ID();
			
			MTo.setH_Admission_ID(Mfrom.getH_Admission_ID());
			if (salesregion==SalesRegion_ID && salesregiond==SalesRegionD_ID && bet_anterior==Bed_ID)
			{
				ADialog.warn(0, null, "Este destino es el ultimo registrado \n no se realizara ningun registro");
				return "Destino ya registrado";
			}
							
			MTo.setC_SalesRegion_ID(SalesRegion_ID);
			MTo.setC_SalesRegionD_ID(SalesRegionD_ID);
		    MTo.setH_Bed_ID(Bed_ID);
			MTo.setDateTrx(Env.getContextAsDate(getCtx(),"Date"));
			MTo.setName("Movimiento generado");
			MTo.save();
			Mfrom.setGenerate_Mov("Y");
			Mfrom.save();
			lineasi = Include_Prod(MTo.getH_Admission_ID(),MTo.getH_Transfer_ID());
			
			//Colocar los datos actualizados en la admision (sustituye la ubcacion actual)
			MHAdmission Admiss = new MHAdmission(getCtx(), Mfrom.getH_Admission_ID(),null);
			Admiss.setC_SalesRegion_ID(SalesRegion_ID);
			Admiss.setC_SalesRegionD_ID(SalesRegionD_ID);
			Admiss.setH_Bed_ID(Bed_ID);
			Admiss.save();
			//coloca la cama que entra como ocupada
			MHBed bedto = new MHBed(getCtx(),Bed_ID,null);
			bedto.setIsOccupied(true);
			bedto.save();
			//coloca la cama que deja como desocupada
			MHBed bed = new MHBed(getCtx(),bet_anterior,null);
			bed.setIsOccupied(false);
			bed.save();
			
			
			
			
			return "Movimiento Registrado....";
			
			
			
		//}	
			//Ahora debo incluir los productos asociados al traslado en la orden de venta
		
		//return null;
	}//doIt
	
	
	
	/***************************************************************************
	 * Include_Prod :  incluye los productos predefinidos y automaticos en la 
	 *                 orden de venta
	 * Recibe:		   
	 * Devuelve:
	 ***************************************************************************/
	
	public String Include_Prod(int Admision_ID, int Transfer_ID){
		String sqll, resp;
		BigDecimal price=new BigDecimal(0);
		MHTransfer Lact = new MHTransfer(getCtx(),Transfer_ID,null);
		//Busco las lineas de productos del esquema de servicios y prod por region
		String sql1 = "SELECT H_ProdxRegion_ID"
		+ " FROM H_ProdxRegion"
		+" WHERE C_SalesRegion_ID=" + Lact.getC_SalesRegion_ID() 
		+" AND C_SalesRegionD_ID="+Lact.getC_SalesRegionD_ID()
		+" AND H_Bed_ID ="+Lact.getH_Bed_ID();
		int Service = DB.getSQLValue(null, sql1);
		//Buscar datos generales
		//Orden de Ventas
		int id_orden = DB.getSQLValue(null, "SELECT C_ORDER_ID FROM C_ORDER WHERE H_ADMISSION_ID="+Admision_ID);
		MSalesOrder Osales = new MSalesOrder(getCtx(),id_orden,null);
		int presupuesto = DB.getSQLValue(null, "select H_Asigned_budget_ID from H_Asigned_Budget where h_admission_ID="+Admision_ID);
		
		if (Service > 0) {
			sqll = "SELECT M_Product_ID, Qty, C_UOM_ID FROM H_ProdxRegion_Lines WHERE H_ProdxRegion_ID="+Service;
			ResultSet rs = null;
			try {
				PreparedStatement pstmt1 = DB.prepareStatement (sqll, "H_ProdxRegion_Lines");
				rs = pstmt1.executeQuery();
				while (rs.next()){
					//Ubicar el precio del producto
					
					resp = Osales.CreateOrderLine(Osales, rs.getInt(1), rs.getBigDecimal(2), price, rs.getInt(3),presupuesto, "NC");
				}
			}
			catch (Exception e){
				return null;
			}
			
		}
		
		return null;
	}
}
