package org.pentanet.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.util.DB;
import org.compiere.apps.ADialog;
import org.pentanet.model.MHProdxRegion;
import org.pentanet.model.MHProdxRegionLines;


/*
 * Duplicate internal use document
 * vcappugi
 * jan 2014
 */
public class CopyFromMInventory extends SvrProcess {
	int M_Inventory_FROM;
	
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("M_Inventory_ID"))
				M_Inventory_FROM = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	/************************************************************+
	 * Copy_lines: copiar Lineas de otra estructura de M_Inventory
	
	 ***************************************************************/
	
	@Override
	protected String doIt() throws Exception {
		
		MInventory minv = new MInventory (getCtx(), M_Inventory_FROM, null);
		
		MInventory ninv = new MInventory (getCtx(), getRecord_ID(), null);
		
		ninv.setAD_Org_ID(minv.getAD_Org_ID());
		ninv.setC_DocType_ID(minv.getC_DocType_ID());
		ninv.setDescription(minv.getDescription());
		ninv.setM_Warehouse_ID(minv.getM_Warehouse_ID());
		ninv.setM_Locator_ID(minv.getM_Locator_ID());
		ninv.setC_Charge_ID(minv.getC_Charge_ID());
		ninv.setC_Activity_ID(minv.getC_Activity_ID());
		ninv.setC_Project_ID(minv.getC_Project_ID());
		ninv.setC_Phase_ID(minv.getC_Phase_ID());
		ninv.save();	
		
		//Lineas
		MInventoryLine mline[] = minv.getLines(true);
		for (int i = 0; i < mline.length; i++)
		{
			MInventoryLine mlinen = new MInventoryLine(getCtx(),0,null);
			mlinen.setM_Inventory_ID(ninv.getM_Inventory_ID());
			mlinen.setLine(mline[i].getLine());
			mlinen.setM_Product_ID(mline[i].getM_Product_ID());
			mlinen.setQty(mline[i].getQty());
			mlinen.setC_Charge_ID(mline[i].getC_Charge_ID());
			mlinen.setQtyCount(mline[i].getQtyCount());
			mlinen.setQtyInternalUse(mline[i].getQty()); //Evita traer cantidades inversar del Reverso
			mlinen.setIsIn(mline[i].isIn());
			mlinen.setIsResult(mline[i].isResult());
			mlinen.setC_UOM_ID(mline[i].getC_UOM_ID());
			mlinen.setA_Asset_ID(mline[i].getA_Asset_ID());
			mlinen.setM_Locator_ID(mline[i].getM_Locator_ID());
			mlinen.setM_Product_Cost(mline[i].getM_Product_Cost());
			mlinen.setAmt(mline[i].getAmt());
			mlinen.setC_ProjectLine_ID(mline[i].getC_ProjectLine_ID());
			mlinen.setM_Warehouse_ID(mline[i].getM_Warehouse_ID());
			mlinen.save();
			
		}
		
		
		return "Lineas Generadas Correctamente";
	}

}
