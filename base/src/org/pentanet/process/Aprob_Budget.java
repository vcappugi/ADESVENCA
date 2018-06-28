package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.compiere.apps.ADialog;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;
import org.pentanet.model.MCBudgetPublicLine;

public class Aprob_Budget extends SvrProcess {
    private int ejec;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ejec = getRecord_ID();

	}

	@Override
	protected String doIt() throws Exception {
		MCBudgetPublicExec e = new MCBudgetPublicExec(getCtx(),ejec,null );
		String covertura="R";
		//Aprobar la ejecucion presupuestaria
		if (valida()) {
			String ap = e.getIsApproved();
			if (ap != null)
				if (!ap.equalsIgnoreCase("Y")) { 
					ajusta();
					if ((e.getM_Requisition_ID()) > 0 )
						covertura="R";
					if((e.getC_Order_ID()) > 0 )
						covertura="RO";
					if (e.getC_Invoice_ID() > 0)
						covertura ="ROI";
					if (e.getC_Payment_ID() > 0)
						covertura ="ROIP";
					if (e.getHR_Process_ID() > 0)
						covertura ="HRP";
					cubre(e, covertura);
			
			DB.executeUpdate("UPDATE C_BudgetPublic_Exec set IsApproved='Y' Where C_BudgetPublic_Exec_ID="+ejec, get_TrxName());	
			return "Ejecucion aprobada";
			}
		}
		else
			ADialog.error(Env.WINDOW_MAIN, null, "No se han validado todas las lineas, no cuenta con validación presupuestaria suficiente");
				
		//Actualiza presupuesto segun tiempo presupuestario
		
		//
		return "";
	}

	/*
	 * Verifica la aprobacion de cada linea del documento.
	 * Campo a revisar: Aprov
	 * Tabla: C_BudgetPublic_Exec_Line
	 */
	Boolean valida() {
		int presup;
		String indicador="N";
		Boolean resp =false;
		int tlin=0, lineas=0;
		MCBudgetPublicExecLine Bpel;
		
		String sql = "SELECT C_BudgetPublic_Exec_Line_ID FROM C_BudgetPublic_Exec_Line WHERE C_BudgetPublic_Exec_ID=" + ejec;
		tlin = DB.getSQLValue(null, "SELECT COUNT(C_BudgetPublic_Exec_Line) FROM C_BudgetPublic_Exec_Line WHERE C_BudgetPublic_Exec_ID=" + ejec);
		PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs;
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				Bpel = new MCBudgetPublicExecLine(getCtx(), rs.getInt(1), null);
				if (Bpel.getAprov()!=null){
					if (Bpel.getAprov().equalsIgnoreCase("Y")) {
						lineas = lineas +1;
					}
				}
			
			}
			if(tlin==lineas){
				resp = true;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return resp;
	}
	/*
	 * Ajusta la cuenta de cada linea de la ejecucion presupuestaria
	 * 
	 */
	Boolean ajusta() {
		int presup, bpline_id;
		String indicador="N";
		String mom;
		Boolean resp =false;
		MCBudgetPublicExecLine Bpel;
		MCBudgetPublicLine Bp;
		String sql = "SELECT C_BudgetPublic_Exec_Line_ID FROM C_BudgetPublic_Exec_Line WHERE C_BudgetPublic_Exec_ID=" + ejec;
		PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs;
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				Bpel = new MCBudgetPublicExecLine(getCtx(), rs.getInt(1), null);
				bpline_id = DB.getSQLValue(get_TrxName(), "SELECT C_BudgetPublic_Line_ID FROM C_BudgetPublic_Line WHERE C_BudgetPublic_ID="+Bpel.getC_BudgetPublic_ID()+" AND C_Budget_Account_ID="+Bpel.getC_ElementValue_ID());
				Bp = new MCBudgetPublicLine(getCtx(), bpline_id, null);
				mom = Moment(DB.getSQLValue(get_TrxName(), "SELECT C_Budget_Moment_ID FROM C_BudgetPublic_Exec WHERE C_BudgetPublic_Exec_ID="+ejec));
				if (mom.equalsIgnoreCase("R")){
					Bp.setAmtPreC(Bp.getAmtPreC().add(Bpel.getAmount()));
					Bp.recalculate();
					//Bp.setRealAmount(Bp.getRealAmount().subtract(Bpel.getAmount())); 
				}
				if (mom.equalsIgnoreCase("O")){
					Bp.setAmtComp(Bp.getAmtComp().add(Bpel.getAmount()));
					//Bp.setRealAmount(Bp.getRealAmount().subtract(Bpel.getAmount())); 
					Bp.recalculate();
				}
				if (mom.equalsIgnoreCase("F")){
					//Bp.setAmtComp(Bp.getAmtComp().subtract(Bpel.getAmount()));
					Bp.setAmtCau(Bp.getAmtCau().add(Bpel.getAmount()));
					Bp.recalculate();
				}
				if (mom.equalsIgnoreCase("P")){
					//Bp.setAmtCau(Bp.getAmtCau().subtract(Bpel.getAmount()));
					Bp.setAmtPay(Bp.getAmtPay().add(Bpel.getAmount()));
					Bp.recalculate();
				}
				
				Bp.save();
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Proceso para parar el documento originario
		}
		
		
		return resp;
	}

	String Moment (int moment_id){
		String literal;
		String sql_m = "select actionl from c_budget_moment where C_Budget_Moment_ID="+moment_id;
		literal = DB.getSQLValueString(null,sql_m);
		return literal;
		
	}
	void cubre(MCBudgetPublicExec e, String c){
		if (c.equalsIgnoreCase("R"))
			DB.executeUpdate("Update M_Requisition set isbudgetcover='Y' where M_Requisition_ID="+e.getM_Requisition_ID(),null);
		if (c.equalsIgnoreCase("RO"))
			DB.executeUpdate("Update C_Order set isbudgetcover='Y' where C_Order_ID="+e.getC_Order_ID() ,null);
		if (c.equalsIgnoreCase("ROI"))
			DB.executeUpdate("Update C_Invoice set isbudgetcover='Y' where C_Invoice_ID="+e.getC_Invoice_ID() ,null);
		if (c.equalsIgnoreCase("ROIP"))
			DB.executeUpdate("Update C_Payment set isbudgetcover='Y' where C_Payment_ID="+e.getC_Payment_ID() ,null);
		if (c.equalsIgnoreCase("HRP"))
			DB.executeUpdate("Update HR_Process set isbudgetcover='Y' where HR_Process_ID="+e.getHR_Process_ID() ,null);
		
		
	}
	
	
}
