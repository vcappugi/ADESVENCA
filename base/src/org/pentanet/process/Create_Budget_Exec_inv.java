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
import org.pentanet.model.MCBudgetPublic;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;


public class Create_Budget_Exec_inv extends SvrProcess {
    
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
		int eje = ejecuta_inv(Record_id);
		return "";
	}
	
	/***********************************************************************
	 * Metodo de ejecucion separado que recibe el id del documento
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	
	public int ejecuta_inv(int Record_id) {
		
		int i,cuenta_c=0,cuenta_p=0;
		int partida;
		int linea=0;
		int BudgetPublic_ID=0;
		MInvoice Invoice = new MInvoice (Env.getCtx(), Record_id, null);
		
		
		MInvoiceLine[] ilines = Invoice.getLines();
		//Eloimina las ejecuciones presupuestrias anteriormente generadas
		int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
				"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_invoice_id ="+Invoice.getC_Invoice_ID()+")");
		executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
				"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_invoice_id ="+Invoice.getC_Invoice_ID()+")");
		
		
		if ((Invoice.getDocStatus()=="VO") || (Invoice.getDocStatus()=="RE"))  //Si esta reversada elimina y no hace nada
			return 1;
		
		/*if (!Invoice.isSOTrx()) {
		MOrder Order = new MOrder (getCtx(), Invoice.getC_Order_ID(), null);
		MOrderLine[] olines = Order.getLines();
		
		    BudgetPublic_ID = olines[0].getC_BudgetPublic_ID();
		}
		
		else
		*/
			BudgetPublic_ID = ilines[0].getC_BudgetPublic_ID();
		
		//Busca Ejecucion comprometida en Orden
		int ejec = 0; //Find_exec(Order.getC_Order_ID());
		//no busca nada para crear uno nuevo...
		

		String DocNo = Invoice.getDocumentNo();

		String Tipo ="Factura: " + DocNo;
		
		MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(Env.getCtx(), ejec, null);
		//BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
		BudgetExec.setHelp(Tipo);
		BudgetExec.setC_Invoice_ID(Invoice.getC_Invoice_ID());
		if (Invoice.isSOTrx())
			BudgetExec.setC_Budget_Moment_ID(Budget_Moment("I"));
		else
			BudgetExec.setC_Budget_Moment_ID(Budget_Moment("F"));
		//Para el automatico de presupuesto
		String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='I' or actionl='F' ");
		BudgetExec.setIsApproved(resp);;  //Aprobación Directa
		
		BudgetExec.save();

        
        

		for (i=0; i<ilines.length; i++) 
		{
			BudgetExec.setIsApproved(resp);
			//Busca La Linea de Ejecucion
			linea = Find_exec_line(BudgetExec.getC_BudgetPublic_Exec_ID(), ilines[i].getM_Product_ID(), BudgetPublic_ID);
			
			MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(Env.getCtx(), 0, null);
			BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
			//BudgetExecLine.save();
			//BudgetExecLine.setDescription(rs.getString(1));
			BudgetExecLine.setC_BudgetPublic_ID(ilines[i].getC_BudgetPublic_ID());
			BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
			//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
			BudgetExecLine.setAmount(ilines[i].getLineNetAmt());
			if (!Invoice.isSOTrx())
			    BudgetExecLine.setAccount_ID(find_cont (ilines[i].getM_Product_ID()));
			else
				BudgetExecLine.setAccount_ID(find_cont_i (ilines[i].getM_Product_ID()));
			if (ilines[i].getM_Product_ID()>0) {
			BudgetExecLine.setC_ElementValue_ID(find_budg(ilines[i].getM_Product_ID()));
			BudgetExecLine.setM_Product_ID(ilines[i].getM_Product_ID());
			}
			if (ilines[i].getC_Charge_ID()>0) {
				BudgetExecLine.setC_ElementValue_ID(find_budg_charge(ilines[i].getC_Charge_ID()));
			}
			BudgetExecLine.setAprov(resp);  //Aprobación Directa
			
			BudgetExecLine.save();
		    }
		//Incluye el Impuesto ahora ..
		String sql_impuesto ="SELECT C_Tax_ID, TaxAmt FROM C_InvoiceTax WHERE C_Invoice_ID="+Record_id + " and TaxAmt>0";
		String sql2="";
		PreparedStatement pstmt = DB.prepareStatement (sql_impuesto, get_TrxName());
		ResultSet rs;
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				   //busco l apartida de el presupuesto
				   partida=busca_partida_impuesto(BudgetPublic_ID,rs.getInt(1));
				   linea = Find_exec_line_Tax(BudgetExec.getC_BudgetPublic_Exec_ID(), partida, BudgetPublic_ID);
				   if (partida > 0) {
					    // String X = rs.getString(1)  //para recuperar un string de la 1era columna del query
					    // Int Y =rs.getInt(2)              //para recuperar un int de la 2da columna
					    // BigDecimal Z= rs.getBigDecimal(3)    //Para recuperar un BD de la 3era columna
					   MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(Env.getCtx(), linea, null);
					   BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
						//BudgetExecLine.setC_OrderLine_ID(olines[i].getC_OrderLine_ID());
						//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
						BudgetExecLine.setAmount(rs.getBigDecimal(2));
						//BudgetExecLine.setAccount_ID(partida);
						BudgetExecLine.setC_ElementValue_ID(partida);
						BudgetExecLine.setC_BudgetPublic_ID(BudgetPublic_ID);
						BudgetExecLine.save();
				   	}
		                  }
			String recalcula = DB.getSQLValueString(null,"Select recalc_budget_balance(1)");
		} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();//Proceso para parar el documento originario
						}
		
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
