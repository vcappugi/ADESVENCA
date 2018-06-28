/********************************
 * Create Budget Exec: proceso para crear la ejecucion presupuestaria
 * basado en factura
 * usa PO de budetexec, objeto donde se guardan las transacciones 
 * presupuestarias.
 * llamado desde un nodo del WF de Process_Requisition (incluido manualmente)  
 * Creado por: vcappugi
 * Fecha: Septiembre 2012
 * Modulo:Presupuesto Publico
 *********************************/

package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.compiere.apps.ADialog;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.model.PO;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPayment;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.pentanet.model.MCBudgetPublic;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;


public class Create_Budget_Exec_BS extends SvrProcess {
    
	@Override
	protected void prepare() {
		

	}

	@Override
	/***********************************************************************
	 * Crea el registro de Ejecucion presupuestaria para estados de cuenta bancario
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	protected String doIt() throws Exception {
		
		int Record_id = getRecord_ID(); //ID del documento
		int eje = ejecuta_bankstatement(Record_id);
		return "";
	}
	
	/***********************************************************************
	 * Metodo de ejecucion separado que recibe el id del documento
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	
	public int ejecuta_bankstatement(int Record_id) {

		
		int i,cuenta_c=0,cuenta_p=0;
		int linea=0;
		
		MBankStatement bs = new MBankStatement(getCtx(), Record_id, null);
		
		//Valida las lineas del estado de cuenta
		 int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_BankStatement_id ="+Record_id+")");
			executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_BankStatement_id ="+Record_id+")");
			if ((bs.getDocStatus().contains("VO")) || (bs.getDocStatus().contains("RE")))  //Si esta reversada elimina y no hace nada
				return 1;
		//Crea el docuemnto de ejecucion presupuestaria
			MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
			BudgetExec.setHelp("Ejec Presupuestaria de Pago/Cobro por Estado de Cuenta");
			BudgetExec.setC_Budget_Moment_ID(Budget_Moment("P"));
			BudgetExec.setC_BankStatement_ID(Record_id);
			BudgetExec.save();
		//Ahora las lineas de acuerdo a las que tengan cargo	
		String sql = "Select C_Manage_Unit_ID, C_BudgetPublic_ID, C_ElementValue_ID, abs(ChargeAmt), C_BankStatementLine_ID from C_BankStatementLine where C_ElementValue_ID >0 and C_BankStatement_ID=" + Record_id;
		PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs;	
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				 	int partida = rs.getInt(3);	
				    int presupuesto = rs.getInt(2);
				    int unidad = rs.getInt(1);
				    BigDecimal monto = rs.getBigDecimal(4);
				    MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
					BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					BudgetExecLine.setAmount(monto);
					BudgetExecLine.setC_BudgetPublic_ID(presupuesto);
					//BudgetExecLine.setAccount_ID(partida);
					BudgetExecLine.setC_ElementValue_ID(partida);
					BudgetExecLine.setC_BankStatementLine_ID(rs.getInt(5));
					String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='P'");
					BudgetExecLine.setAprov(resp);;  //Aprobación Directa
					BudgetExecLine.save();
					BudgetExec.setIsApproved(resp);;  //Aprobación Directa
					BudgetExec.save();
					//BudgetExecLine.setC_BudgetPublic_ID();
					BudgetExecLine.save();
				    
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Proceso para parar el documento originario
		}
		//Ahora el comprometido de forma directa
		
		MCBudgetPublicExec BudgetExecCopy = new MCBudgetPublicExec(getCtx(), 0, null);
		BudgetExecCopy.copyValues(BudgetExec, BudgetExecCopy);
		BudgetExecCopy.setC_Budget_Moment_ID(Budget_Moment("O"));
		BudgetExecCopy.save();
		//Ahora las lineas de acuerdo a las que tengan cargo	
				 sql = "Select C_Manage_Unit_ID, C_BudgetPublic_ID, C_ElementValue_ID, abs(ChargeAmt), C_BankStatementLine_ID from C_BankStatementLine where C_ElementValue_ID >0 and C_BankStatement_ID=" + Record_id;
				 pstmt = DB.prepareStatement (sql, get_TrxName());
					
				try {
					rs = pstmt.executeQuery ();
					while (rs.next ())
						{
						 	int partida = rs.getInt(3);	
						    int presupuesto = rs.getInt(2);
						    int unidad = rs.getInt(1);
						    BigDecimal monto = rs.getBigDecimal(4);
						    MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
							BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExecCopy.getC_BudgetPublic_Exec_ID());
							BudgetExecLine.setAmount(monto);
							BudgetExecLine.setC_BudgetPublic_ID(presupuesto);
							//BudgetExecLine.setAccount_ID(partida);
							BudgetExecLine.setC_ElementValue_ID(partida);
							BudgetExecLine.setC_BankStatementLine_ID(rs.getInt(5));
							String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='P'");
							BudgetExecLine.setAprov(resp);;  //Aprobación Directa
							BudgetExecLine.save();
							BudgetExec.setIsApproved(resp);;  //Aprobación Directa
							BudgetExec.save();
							//BudgetExecLine.setC_BudgetPublic_ID();
							BudgetExecLine.save();
						    
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//Proceso para parar el documento originario
				}
		
		
		
		
			
		//*****************************************************
		String recalcula = DB.getSQLValueString(null,"Select recalc_budget_balance(1)");
		return 0;
	}
	
	
	
	/***********************************
	 * Busca la Cuenta presupuestaria
	 ***********************************/
	
	int find_budg(int product) {
		String sqlt="";
		int cuenta_p =0;
			sqlt = "SELECT C_ElementValue_ID FROM M_Product_Budg WHERE M_Product_ID="+product;
			cuenta_p = DB.getSQLValue(null, sqlt);
		return cuenta_p;
	}
	

	int find_budg_charge(int charge) {
		String sqlt="";
		int cuenta_p =0;
			sqlt = "SELECT C_ElementValue_ID FROM C_Charge_Acct WHERE C_Charge_ID="+charge;
			cuenta_p = DB.getSQLValue(null, sqlt);
		return cuenta_p;
	}
	
	/****************************************
	 * Busca la cuenta contable
	 ****************************************/
	
	int find_cont (int product){
		String sql = "select ev.c_elementvalue_id from m_product_acct acct inner join c_validcombination vc on vc.c_validcombination_id = acct.p_asset_acct inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id WHERE acct.m_product_ID=" + product;
		int  cuenta_contable=DB.getSQLValue(null, sql);
		return cuenta_contable;
	}
	
	/****************************************
	 * Busca la cuenta contable de ingresos 
	 ****************************************/
	
	int find_cont_i (int product){
		String sql = "select ev.c_elementvalue_id from m_product_acct acct inner join c_validcombination vc on vc.c_validcombination_id = acct.p_revenue_acct inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id WHERE acct.m_product_ID=" + product;
		int  cuenta_contable=DB.getSQLValue(null, sql);
		return cuenta_contable;
	}
	
	/******************************************************
	 * Evaluacion  de la disponibilidad presupuestaria
	 ******************************************************/
	BigDecimal eval_budget(int cta, int budget, BigDecimal amount){
		int result =0;
		String sql = "select COALESCE(realamount,0) from C_BudgetPublic_Line Where C_budget_Account_ID="+cta+" AND C_BudgetPublic_ID ="+budget;
		BigDecimal disponible = DB.getSQLValueBD(null, sql);
		if (disponible==null)
			disponible = new BigDecimal(0);
		
		/*if (disponible.compareTo(amount) ==-1)
			result = -1;
		else
			result =1;
		*/
		
		return disponible;
	}
	
	
	
	/************************************************
	 * Buscar Momento Presupuestario
	 * 
	 ***********************************************/
	int Budget_Moment(String literal){
		int id;
		String sql_m = "select C_Budget_Moment_ID from c_budget_moment where actionl='"+literal+"'";
		id = DB.getSQLValue(null,sql_m);
		return id;
	}
	
	/****************************************************
	 * Busca Ejecucion existente de una orden
	 * Devuelve el ID de la Ejecucion
	 ****************************************************/
	int Find_exec(int Ord){
		int id;
		String sql_m = "SELECT C_BudgetPublic_Exec_ID FROM C_BudgetPublic_Exec WHERE C_Order_ID="+Ord;
		id = DB.getSQLValue(null,sql_m);
		if (id <0 )
			id =0;
		return id;
		
	}
	
	/******************************************************
	 * Busca la linea de ejecucion presupuestaria del documento
	 * devuelve cero si no existe
	 *******************************************************/
	int Find_exec_line(int bexec, int prod, int budg){
		int id;
		String sql_m = "SELECT C_BudgetPublic_Exec_Line_ID FROM C_BudgetPublic_Exec_Line WHERE M_Product_ID="+prod+" and c_budgetpublic_id="+budg+" and C_BudgetPublic_Exec_ID="+bexec;
		id = DB.getSQLValue(null,sql_m);
		if (id <0 )
			id =0;
		return id;
		
	}
	
	/******************************************************
	 * Busca la linea de ejecucion presupuestaria del impuesto del documento
	 * devuelve cero si no existe
	 *******************************************************/
	int Find_exec_line_Tax(int bexec, int partida, int budg){
		int id;
		String sql_m = "SELECT C_BudgetPublic_Exec_Line_ID FROM C_BudgetPublic_Exec_Line WHERE C_ElementValue_ID="+partida+" and c_budgetpublic_id="+budg+" and C_BudgetPublic_Exec_ID="+bexec;
		id = DB.getSQLValue(null,sql_m);
		if (id <0 )
			id =0;
		return id;
		
	}
	/***************************************************
	 * Busca partida presupuestaria de impuesto
	 ***************************************************/
	
	int busca_partida_impuesto(int Budget, int tax){
		int part;
		part =DB.getSQLValue(null, "select c_elementvalue_id from c_tax_budg where c_tax_id = " + tax);
		return part;
	}	

}
