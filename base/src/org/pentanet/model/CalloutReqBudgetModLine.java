package org.pentanet.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

public class CalloutReqBudgetModLine extends CalloutEngine {

	/*********************************+
	 * crea sumatorias de cedentes y receptoras en la solicitud de modificacion presupuestaria
	 * 
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String totales(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		
		int sol_budget = (Integer) mTab.getValue("C_ReqBudget_Mod_ID");	
		
		BigDecimal  total_cedente=DB.getSQLValueBD(null, "select coalesce(sum (Amount),0)  from C_ReqBudget_Mod_line where C_ReqBudget_Mod_ID=" + sol_budget+" AND MovementTye='C'");
		BigDecimal  total_receptora=DB.getSQLValueBD(null, "select coalesce(sum (Amount),0)  from C_ReqBudget_Mod_line where C_ReqBudget_Mod_ID=" + sol_budget+" AND MovementTye='R'");
		BigDecimal diferencia=total_cedente.subtract(total_receptora);
		String mensa = "Totales: Cedente=" + total_cedente.toString() + "|  Total Receptora="+total_receptora.toString()+" | Diferencia"+diferencia.toString();
		
		if (mensa.isEmpty())
			mensa="";
		//ADialog.warn(WindowNo, null, sql);
		mTab.setValue("AmtBalance", diferencia.add(new BigDecimal ((char[]) mTab.getValue("Amount"))));
	return "";
	}
	
	/************************************
	 * actualiza el campo de saldo disponible cuando se crea el presupuesto
	 * @return
	 */
	
	public String Upd_Amount (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		//if (!(mTab.get_ValueAsString("RealAmount") != "0.00"))
			mTab.setValue("RealAmount", value);
				
		
		return "";
	}
	
	
}
