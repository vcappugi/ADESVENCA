package org.pentanet.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.util.DB;

public class MHEPersons extends X_H_EPersons {
	private static final long serialVersionUID = 20111129L;
	public MHEPersons(Properties ctx, int H_EPersons_ID, String trxName)
	{
		super (ctx, H_EPersons_ID, trxName);
	}
	
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@return true
	 */
	protected boolean afterSave (boolean newRecord, boolean success) {
		
		int Asigned_Budget_ID= DB.getSQLValue(null, "SELECT H_Asigned_Budget_ID FROM H_Asigned_Budget WHERE H_Admission_ID="+getH_Admission_ID());
		
		if (Asigned_Budget_ID>0 && success){
			
			MHAsignedBudget A_Budget= new MHAsignedBudget(getCtx(), Asigned_Budget_ID,null);		
			int ExceptEPerson=getH_EPersons_ID();
			
			if (newRecord){
				ExceptEPerson=0;
			}
			
			String sql="SELECT SUM(coverage) FROM H_EPersons WHERE H_Admission_ID="+getH_Admission_ID()+" AND H_EPersons_ID<>"+ExceptEPerson;
			BigDecimal Coverage=new BigDecimal(((DB.getSQLValue(null, sql))<0 ? 0:DB.getSQLValue(null, sql)));
			
			Coverage=Coverage.add(getCoverage());
			if (A_Budget.getTotal_Budget().compareTo(Coverage)>0) {
				//ADialog.error(WindowNo, null, "El Presupuesto Asignado supera la Covertura del Paciente");
				A_Budget.setABudgetStatus("EN");			
			}
			else {
				A_Budget.setABudgetStatus("VA");
			}
			
			A_Budget.save();
		}		
				
		return success;
	}
}
