package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.apps.ADialog;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.model.MCBudgetPDist;
import org.pentanet.model.MCBudgetPLot;



public class BudgetDist extends SvrProcess {
	private int budgetp_lot_id;
	 
	@Override
	protected void prepare() {
		budgetp_lot_id = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		BigDecimal monto_dist[];
		MCBudgetPLot bplot = new MCBudgetPLot(getCtx(),budgetp_lot_id,get_TrxName());
		String sql_elim ="";
		
		String sql ="select line.amount, line.c_budget_account_ID, line.c_budgetpublic_line_id,line.c_budgetpublic_id ,(select budgetdist_type from c_budgetp_lot where c_budgetp_lot_id="+budgetp_lot_id+") as typedist" 
				+ " from c_budgetpublic_line line where c_budgetpublic_ID in (select C_BudgetPublic_ID from c_budgetPublic where c_BudgetP_Lot_ID="+budgetp_lot_id+")";
		
		////Solo si no existe distribucion previa, o borro la anterior ??
		if (bplot.getExecuteDist().equalsIgnoreCase("Y")){
			//Ya hay distribución previa, debo generarla...???
			ADialog.warn(Env.WINDOW_MAIN,null,"Ya Existe una Distribución, se eliminará para crear una nueva");
			sql_elim = "DELETE FROM C_BudgetP_Dist WHERE C_BudgetPublic_ID in (SELECT"
					+" C_BudgetPublic_ID FROM C_BudgetPublic WHERE C_BudgetP_Lot_ID="+budgetp_lot_id+")";
			DB.executeUpdate(sql_elim,null);		
		}
		
		
		//////////////
		ResultSet rs = null;
		try
		{
			PreparedStatement pstmt1 = DB.prepareStatement (sql, "C_BudgetPublic_Line");
			rs = pstmt1.executeQuery();
			while (rs.next())
			{
				//Crear la linea desde el presupuesto
				MCBudgetPDist dist = new MCBudgetPDist(getCtx(), 0, get_TrxName());
				dist.setC_BudgetPublic_Line_ID(rs.getInt(3));
				dist.setAccount_ID(rs.getInt(2));
				dist.setC_BudgetPublic_ID(rs.getInt(4));
				if (rs.getString(5).equalsIgnoreCase("M")) {
					monto_dist =  Distribucion (rs.getBigDecimal(1),12);
					dist.setPeriodo_1(monto_dist[0]);
					dist.setPeriodo_2(monto_dist[0]);
					dist.setPeriodo_3(monto_dist[0]);
					dist.setPeriodo_4(monto_dist[0]);
					dist.setPeriodo_5(monto_dist[0]);
					dist.setPeriodo_6(monto_dist[0]);
					dist.setPeriodo_7(monto_dist[0]);
					dist.setPeriodo_8(monto_dist[0]);
					dist.setPeriodo_9(monto_dist[0]);
					dist.setPeriodo_10(monto_dist[0]);
					dist.setPeriodo_11(monto_dist[0]);
					dist.setPeriodo_12(monto_dist[0].add(monto_dist[1]));
				}
				if (rs.getString(5).equalsIgnoreCase("T")) {
					monto_dist =  Distribucion (rs.getBigDecimal(1),4);
					dist.setPeriodo_1(monto_dist[0]);
					dist.setPeriodo_2(monto_dist[0]);
					dist.setPeriodo_3(monto_dist[0]);
					dist.setPeriodo_4(monto_dist[0].add(monto_dist[1]));
					
					
				}
				if (rs.getString(5).equalsIgnoreCase("B")) {
					monto_dist =  Distribucion (rs.getBigDecimal(1),6);
					dist.setPeriodo_1(monto_dist[0]);
					dist.setPeriodo_2(monto_dist[0]);
					dist.setPeriodo_3(monto_dist[0]);
					dist.setPeriodo_4(monto_dist[0]);
					dist.setPeriodo_5(monto_dist[0]);
					dist.setPeriodo_6(monto_dist[0].add(monto_dist[1]));
					
				}
				if (rs.getString(5).equalsIgnoreCase("S")) {
					monto_dist =  Distribucion (rs.getBigDecimal(1),2);
					dist.setPeriodo_1(monto_dist[0]);
					dist.setPeriodo_2(monto_dist[0].add(monto_dist[1]));
				}
					
				
				
				dist.save();
				
			}
		}
		catch(Exception e){
			return e.toString();
		}
		
		
		/////////////
		//Coloca marca para determinar que ya se hizo la distribución
		bplot.setExecuteDist("Y");
		bplot.save();
		///////////
		return "Ok";
	}
	
	/*
	 * Realiza la distribucion trimestral de un monto 
	 * 4 periodos en el año
	 */
	private BigDecimal[] Distribucion (BigDecimal monto, int periodo){
		BigDecimal monto1[];
		monto1= (monto.divideAndRemainder(new BigDecimal (periodo)));
		return monto1;
	}

}
