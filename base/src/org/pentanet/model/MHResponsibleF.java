package org.pentanet.model;

import java.awt.Window;
import java.math.BigDecimal;
import java.util.Properties;
import org.compiere.apps.ADialog;
import org.compiere.util.DB;
import org.compiere.util.Env;

//import com.sun.java.swing.plaf.windows.WindowsBorders;


public class MHResponsibleF extends X_H_ResponsibleF {

	private static final long serialVersionUID = 20120229L;
	
	public MHResponsibleF(Properties ctx, int H_ResponsibleF_ID, String trxName)
	{
		super (ctx, H_ResponsibleF_ID, trxName);
	}//MHResponsibleF
	

	protected boolean afterSave (boolean newRecord, boolean success){
		int admision = getH_Admission_ID();

		String sql="SELECT H_Asigned_Budget_ID FROM H_Asigned_Budget WHERE H_Admission_ID="+admision; 
		int H_budget = DB.getSQLValue(null, sql);
		if (H_budget >0) { 
			MHAsignedBudget A_Budget =new MHAsignedBudget(getCtx(), H_budget , null);
		
			
			int resp = ValidaPresupuesto(getCtx(), admision, getCoverage());
			if (resp > 0) {
					//ADialog.error(0, null, "El Presupuesto Asignado supera la Cobertura del Paciente\nEstatus del Presupuesto Asignado: \"En Negociación\"\n");
					A_Budget.setABudgetStatus("EN");			
			}
			else {
				A_Budget.setABudgetStatus("VA");
			}
			A_Budget.save();
		}
		else
			return false;
		
		return true;
	}//afterSave
	
	/*
	 * Valida presupuesto con respecto a la admision y cobertura
	 */
	private static int ValidaPresupuesto(Properties ctx, int H_Admission_ID, BigDecimal monto){
		MHAdmission Admission = new MHAdmission(ctx, H_Admission_ID, null);
		
		String sql="SELECT SUM(coverage) FROM H_ResponsibleF WHERE H_Admission_ID="+Admission.getH_Admission_ID();
		BigDecimal Coverage=new BigDecimal(DB.getSQLValue(null, sql)).add(monto);
		
		sql="SELECT H_Asigned_Budget_ID FROM H_Asigned_Budget WHERE H_Admission_ID="+Admission.getH_Admission_ID(); 
		MHAsignedBudget Budget =new MHAsignedBudget(ctx, DB.getSQLValue(null, sql), null);
		
		return Budget.getTotal_Budget().compareTo(Coverage);
	}
	
}
