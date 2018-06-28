package org.pentanet.model;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.apps.ADialog;

public class CalloutBudget extends CalloutEngine {

	/*********************************+
	 * Busca la cuenta contable desde la cuenta presupuestaria
	 * 
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String Acct_Budget(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		
		int cuenta = (Integer) value;	
		String sql = "select c_acct_cont from C_Budget_Relation where c_acct_bud=" + cuenta;
		int  cuenta_contable=DB.getSQLValue(null, sql);
		mTab.setValue("C_Acct_Cont", cuenta_contable);
		//ADialog.warn(WindowNo, null, sql);	
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
