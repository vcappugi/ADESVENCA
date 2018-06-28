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
import org.compiere.model.X_GL_JournalLine;
import org.compiere.model.X_GL_Journal;
import org.compiere.model.X_GL_JournalBatch;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;


public class Create_Budget_Exec_GL extends SvrProcess {
    
	@Override
	protected void prepare() {
		

	}

	@Override
	/***********************************************************************
	 * Crea el registro de Ejecucion presupuestaria para Ordenes de Compra
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	protected String doIt() throws Exception {
		
		int Record_id = getRecord_ID(); //ID del documento
		int eje = ejecuta_gl(Record_id);
		return "";
	}
	
	/***********************************************************************
	 * Metodo de ejecucion separado que recibe el id del documento
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	
	public int ejecuta_gl(int Record_id) {

		
		int i,cuenta_c=0,cuenta_p=0;
		int linea=0;
		
		X_GL_JournalBatch gl = new X_GL_JournalBatch(getCtx(), Record_id, null);
		//Valida si es un cargo directo
					
			
		    int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  gl_journalbatch_id ="+gl.getGL_JournalBatch_ID() +")");
			executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  gl_journalbatch_id ="+gl.getGL_JournalBatch_ID()+")");
		    
			if ((gl.getDocStatus().contains("VO")) || (gl.getDocStatus().contains("RE")))  //Si esta reversada elimina y no hace nada
				return 1;
		    if ( (gl.getDocumentNo().startsWith("$-IN")) || (gl.getDocumentNo().startsWith("Bs-IN")) ) {
		  	  
			MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
			//BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
			BudgetExec.setHelp("Ejec Presupuestaria de ingresos por contabilidad");
			BudgetExec.setGL_JournalBatch_ID(gl.getGL_JournalBatch_ID());
			BudgetExec.setC_Budget_Moment_ID(Budget_Moment("I"));
			//BudgetExec.setC_BudgetPublic_ID(presupuesto);
			BudgetExec.save();
			//Ahora las lineas	solo las de ingreso		
			String sql_fact = " select c_manage_unit_id, c_budgetpublic_id, c_elementvalue_id, amtsourcedr, amtsourcecr, GL_JournalLine_ID "
					+ "from gl_journalline where gl_journal_id  in (select gl_journal_id from gl_journal where gl_journalbatch_id "
					+ "in (select gl_journalbatch_id from gl_journalbatch where gl_journalbatch_id=" + gl.getGL_JournalBatch_ID() +")) and c_elementvalue_id in (select c_elementvalue_id from c_elementvalue where substr(value,1,3) ='P-4')";
			
			PreparedStatement pstmt1 = DB.prepareStatement (sql_fact, get_TrxName());
			ResultSet rs1;
			
			try {
				rs1 = pstmt1.executeQuery ();
				while (rs1.next ())
					{
					
					MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);  
					BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					if (rs1.getBigDecimal(4).compareTo(new BigDecimal(0))>0)
					      BudgetExecLine.setAmount(rs1.getBigDecimal(4));
					else
						BudgetExecLine.setAmount(rs1.getBigDecimal(5));
					BudgetExecLine.setGL_JournalLine_ID(rs1.getInt(6));
					BudgetExecLine.setC_BudgetPublic_ID(rs1.getInt(2));
					//BudgetExecLine.setAccount_ID(rs1.getInt(3));   //cuenta contable
					BudgetExecLine.setC_ElementValue_ID(rs1.getInt(3));  //Cuenta presupuestaria
					String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='I'");
					BudgetExecLine.setAprov(resp);;  //Aprobación Directa
					//BudgetExecLine.setC_BudgetPublic_ID();
					BudgetExecLine.save();
					BudgetExec.setIsApproved(resp);;  //Aprobación Directa
					BudgetExec.save();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//Proceso para parar el documento originario
				}
			
		    } else {
			//Ahora los gastos, se colocan en comprometido
			
			  
		    	     MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
					//BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
					BudgetExec.setHelp("Ejec Presupuestaria de Gastos relacionados a ingresos por contabilidad");
					BudgetExec.setGL_JournalBatch_ID(gl.getGL_JournalBatch_ID());
					BudgetExec.setC_Budget_Moment_ID(Budget_Moment("O"));
					//BudgetExec.setC_BudgetPublic_ID(presupuesto);
					BudgetExec.save();
					//Ahora las lineas	solo las de ingreso		
					String sql_fact = " select c_manage_unit_id, c_budgetpublic_id, c_elementvalue_id, amtsourcedr, amtsourcecr, GL_JournalLine_ID "
							+ "from gl_journalline where gl_journal_id  in (select gl_journal_id from gl_journal where amtsourcedr <> 0 and gl_journalbatch_id "
							+ "in (select gl_journalbatch_id from gl_journalbatch where gl_journalbatch_id=" + gl.getGL_JournalBatch_ID() +")) and c_elementvalue_id in (select c_elementvalue_id from c_elementvalue where substr(value,1,3) in ('P-5', 'P-6')) ";
					
					PreparedStatement pstmt2 = DB.prepareStatement (sql_fact, get_TrxName());
					ResultSet rs2;
					
					try {
						rs2 = pstmt2.executeQuery ();
						while (rs2.next ())
							{
							
							MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);  
							BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
							BudgetExecLine.setAmount(rs2.getBigDecimal(4));
							BudgetExecLine.setGL_JournalLine_ID(rs2.getInt(6));
							BudgetExecLine.setC_BudgetPublic_ID(rs2.getInt(2));
							//BudgetExecLine.setAccount_ID(rs1.getInt(3));   //cuenta contable
							BudgetExecLine.setC_ElementValue_ID(rs2.getInt(3));  //Cuenta presupuestaria
							String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='I'");
							BudgetExecLine.setAprov(resp);;  //Aprobación Directa
							//BudgetExecLine.setC_BudgetPublic_ID();
							BudgetExecLine.save();
							BudgetExec.setIsApproved(resp);;  //Aprobación Directa
							BudgetExec.save();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();//Proceso para parar el documento originario
						}
		    }
			
			
			
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
