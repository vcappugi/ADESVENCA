/********************************
 * Create Budget Exec: proceso para crear la ejecucion presupuestaria
 * basado en orden de compra 
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
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPayment;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.eevolution.model.MHRProcess;
import org.pentanet.model.MCBudgetPublic;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;



public class Create_Budget_Exec_Payroll extends SvrProcess {

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
		int i,cuenta_c=0,cuenta_p=0;
		int partida;
		MHRProcess Process = new MHRProcess (getCtx(), Record_id, null);
				
		
        String DocNo = Process.getName();
		String Tipo ="Proceso de Nomina: " + DocNo;
		String SQL_Orig ="select pr.name, pr.hr_process_id, sum(m.amount), pr.dateacct, e.c_elementvalue_id, pr.c_budgetpublic_id, m.hr_concept_id, cac.hr_payroll_type_line_id "+
"from hr_process pr "+
"inner join hr_movement m on m.hr_process_id = pr.hr_process_id "+
"inner join c_bpartner bp on bp.c_bpartner_id = m.c_bpartner_id "+
"inner join c_bp_group bpg on bpg.c_bp_group_id = bp.c_bp_group_id "+
"inner join hr_employee emp on emp.c_bpartner_id = bp.c_bpartner_id "+
"inner join hr_concept_acct cac on cac.hr_concept_id = m.hr_concept_id "+
"inner join c_elementvalue e on e.c_elementvalue_id = cac.c_budget_account_id and cac.hr_payroll_type_line_id = emp.hr_payroll_type_line_id "+
"where pr.hr_process_id = "+ Process.getHR_Process_ID() +
"  group by pr.name, pr.hr_process_id, pr.dateacct, e.c_elementvalue_id, pr.c_budgetpublic_id, m.hr_concept_id, cac.hr_payroll_type_line_id";
			
		//Eloimina las ejecuciones presupuestrias anteriormente generadas
				int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
						"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  hr_process_id ="+Process.getHR_Process_ID()+")");
				executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
						"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  hr_process_id ="+Process.getHR_Process_ID()+")");
			
				if ((Process.getDocStatus()=="VO") || (Process.getDocStatus()=="RE"))  //Si esta reversada elimina y no hace nada
					return "";		
				
				//"SELECT A.Description,B.C_Order_ID ,A.LinenetAmt,A.C_OrderLine_ID,B.dateordered,B.DocStatus, A.M_Product_ID FROM adempiere.C_OrderLine A INNER JOIN adempiere.C_Order B ON A.C_Order_ID=B.C_Order_ID  WHERE A.C_Order_ID="+ Order.getC_Order_ID();
		String year =   Process.getDateAcct().toString().substring(0, 4);    
		int org_id = Process.getAD_Org_ID();

		MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
		BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
		BudgetExec.setHelp(BudgetExec.getHelp()+" / "+Tipo);
		
		//BudgetExec.setC_BudgetPublic_ID( );
		
		//BudgetExec.setC_Order_ID(Order.getC_Order_ID());
		BudgetExec.setC_Budget_Moment_ID(Budget_Moment("O"));
		
		BudgetExec.setHR_Process_ID(Process.getHR_Process_ID());
		BudgetExec.setIsApproved("N");
		BudgetExec.save();
		
		//Ahora las lineas de la ejecucion presupuestaria
		PreparedStatement pstmt = DB.prepareStatement (SQL_Orig, get_TrxName());
		ResultSet rs;
		rs = pstmt.executeQuery ();
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
				BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
				//BudgetExecLine.save();
				//BudgetExecLine.setDescription(rs.getString(1));
				//BudgetExec.setC_BudgetPublic_ID();
				BudgetExecLine.setAprov("Y");
				BudgetExecLine.setHR_Concept_ID(rs.getInt(7)); 
				BudgetExecLine.setAmount(rs.getBigDecimal(3));
				//BudgetExecLine.setAccount_ID(rs.getInt(columnIndex));   //Cuenta contable
				BudgetExecLine.setC_ElementValue_ID(rs.getInt(5)); //Cuenta presupuestaria
				BudgetExecLine.setC_BudgetPublic_ID(rs.getInt(6));  //Presupuesto
				BudgetExecLine.setC_BP_Group_ID(rs.getInt(8));   //Grupo de SDN
				BudgetExecLine.save();
				
				}
			String recalcula = DB.getSQLValueString(null,"Select recalc_budget_balance(1)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Proceso para parar el documento originario
		}
				
		Process.setProcessed(true);  //Coloco el proceso de nomina en procesado para que se bloquee
		Process.save();
		return "";
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
	
	/****************************************
	 * Busca la cuenta contable
	 ****************************************/
	
	int find_cont (int product){
		String sql = "select ev.c_elementvalue_id from m_product_acct acct inner join c_validcombination vc on vc.c_validcombination_id = acct.p_asset_acct inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id WHERE acct.m_product_ID=" + product;
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
	/***************************************************
	 * Busca partida presupuestaria de impuesto
	 ***************************************************/
	
	int busca_partida_impuesto(int Budget, int tax){
		int part;
		part =DB.getSQLValue(null, "select c_elementvalue_id from c_tax_budg where c_tax_id = " + tax);
		return part;
	}
	
	

}
