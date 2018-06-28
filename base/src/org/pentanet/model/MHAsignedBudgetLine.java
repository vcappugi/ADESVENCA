package org.pentanet.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.apps.ADialog;
import org.compiere.model.X_AD_Tree;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MHAsignedBudgetLine extends X_H_Asigned_Budget_Line {
	private static final long serialVersionUID = 20111129L;
	public MHAsignedBudgetLine(Properties ctx, int H_Asigned_budget_Line_ID, String trxName)
	{
		super (ctx, H_Asigned_budget_Line_ID, trxName);
	}
	
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@return true
	 */
	protected boolean afterSave (boolean newRecord, boolean success) {
		//setDescription(get_Value(COLUMNNAME_LineTotalAmt).toString());
		String sql;
		if (newRecord){
			sql="SELECT M_Product_ID FROM H_Asigned_Budget_Line WHERE H_Asigned_Budget_ID="+getH_Asigned_Budget_ID()+" AND M_Product_ID="+getM_Product_ID();
			String EqualProduct=DB.getSQLValueString(null, sql);
			
			if("f".equals(DB.getSQLValueString(null, sql))) {
				return false;
			}
		}
		MHAsignedBudget A_Budget= new MHAsignedBudget(getCtx(), getH_Asigned_Budget_ID(),null);		
		
		sql="SELECT SUM(LineTotalAmt) FROM H_Asigned_Budget_Line WHERE H_Asigned_Budget_ID="+getH_Asigned_Budget_ID()+" AND M_Product_ID<>"+getM_Product_ID();
		BigDecimal TotalAnt=new BigDecimal((DB.getSQLValue(null, sql)));
		
		sql="UPDATE H_Asigned_Budget SET Total_Budget="+TotalAnt.add(getLineTotalAmt())+" WHERE H_Admission_ID="+A_Budget.getH_Admission_ID();
		
		int no = DB.executeUpdate(sql, null);
		if (CreateAdmiCallout.ValidaPresusuesto(getCtx(), A_Budget.getH_Admission_ID())>0) {
			//ADialog.error(WindowNo, null, "El Presupuesto Asignado supera la Covertura del Paciente");
			A_Budget.setABudgetStatus("EN");			
		}
		else {
			A_Budget.setABudgetStatus("VA");
		}
		
		A_Budget.save();
				
		return success;
	}
	
	@Override
	protected boolean afterDelete (boolean success)
	{
		String hola="hola";
		hola=hola+"";
		if (success){
			MHAsignedBudget A_Budget= new MHAsignedBudget(getCtx(), getH_Asigned_Budget_ID(),null);	
			String sql="UPDATE H_Asigned_Budget SET Total_Budget=(SELECT SUM(LineTotalAmt) FROM H_Asigned_Budget_Line WHERE H_Asigned_Budget_ID="+getH_Asigned_Budget_ID()+" AND M_Product_ID<>"+getM_Product_ID()+") "+
					   "WHERE H_Admission_ID="+A_Budget.getH_Admission_ID();
		
			int no = DB.executeUpdate(sql, null);
			if (CreateAdmiCallout.ValidaPresusuesto(getCtx(), A_Budget.getH_Admission_ID())>0) {
				//ADialog.error(WindowNo, null, "El Presupuesto Asignado supera la Covertura del Paciente");
				A_Budget.setABudgetStatus("EN");			
			}
			else {
				A_Budget.setABudgetStatus("VA");
			}			
			A_Budget.save();
		}
			
		return success;
	}	//	afterDelete
	
}
