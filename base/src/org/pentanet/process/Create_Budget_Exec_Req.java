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


import org.pentanet.model.MCBudgetPublic;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;


public class Create_Budget_Exec_Req extends SvrProcess {

	@Override
	protected void prepare() {
		

	}

	@Override
	/***********************************************************************
	 * Crea el registro de Ejecucion presupuestaria para Requisiciones
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	protected String doIt() throws Exception {
		
		int Record_id = getRecord_ID(); //ID del documento
		int i,cuenta_c=0,cuenta_p=0;
		int partida;
		MRequisition Requisition = new MRequisition (getCtx(), Record_id, null);
		MRequisitionLine[] rlines = Requisition.getLines();
		int BudgetPublic_ID = rlines[0].getC_BudgetPublic_ID();

		String DocNo = Requisition.getDocumentNo();

		String Tipo ="Requisicion: " + DocNo;
		String SQL_Orig = "SELECT A.Description,B.M_Requisition_ID ,A.LinenetAmt,A.M_RequisitionLine_ID,B.daterequired,B.DocStatus, A.M_Product_ID FROM adempiere.M_Requisitionline A INNER JOIN adempiere.M_Requisition B ON A.M_Requisition_ID=B.M_Requisition_ID WHERE A.M_Requisition_ID="+ Requisition.getM_Requisition_ID();
		String year =   Requisition.getDateRequired().toString().substring(0, 4);    
		int org_id = Requisition.getAD_Org_ID();
        
		MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
		BudgetExec.setDescription("Ejec Presupuestaria Requisicion :" + DocNo);
		BudgetExec.setHelp(Tipo);
		BudgetExec.setC_BudgetPublic_ID(BudgetPublic_ID);
		BudgetExec.setM_Requisition_ID(Requisition.getM_Requisition_ID());
		//if (Requisition.isViatic())
		//	BudgetExec.setC_Budget_Moment_ID(Budget_Moment("O"));  //Coloco el Presupuesto en Compromiso
		//else
		    BudgetExec.setC_Budget_Moment_ID(Budget_Moment("R"));
		String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='R'");
		
		BudgetExec.setIsApproved(resp);;  //Aprobación Directa
		
		BudgetExec.save();



		for (i=0; i<rlines.length; i++) 
		{
			//BudgetExec.setIsApproved("Y");
			MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
			BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
			//BudgetExecLine.save();
			//BudgetExecLine.setDescription(rs.getString(1));
			//BudgetExec.setC_BudgetPublic_ID();
			//BudgetExecLine.setM_Requisition_ID(rlines[i].getM_Requisition_ID());
			BudgetExecLine.setM_Product_ID(rlines[i].getM_Product_ID());
			BudgetExecLine.setAmount(rlines[i].getLineNetAmt());
			BudgetExecLine.setAccount_ID(find_cont (rlines[i].getM_Product_ID()));
			BudgetExecLine.setC_ElementValue_ID(find_budg(rlines[i].getM_Product_ID()));
			BudgetExecLine.setC_BudgetPublic_ID(rlines[i].getC_BudgetPublic_ID());
			
			BudgetExecLine.setAprov(resp);;   //Aprobación directa de la linea
			BudgetExecLine.save();
			DB.executeUpdate("Update C_Budgetpublic_Line set amtprec=amtprec+"+rlines[i].getLineNetAmt()+" where C_BudgetPublic_ID= "+BudgetExecLine.getC_BudgetPublic_ID()+" and C_Budget_Account_ID="+BudgetExecLine.getC_ElementValue_ID());
			DB.executeUpdate("Update C_Budgetpublic_Line set RealAmount=Amount+AmountModify-amtprec-amtcomp where C_BudgetPublic_ID= "+BudgetExecLine.getC_BudgetPublic_ID()+" and C_Budget_Account_ID="+BudgetExecLine.getC_ElementValue_ID());
			
			
			
		    }
		//Ahora se crea las lineas de los impuestos correspondientes
		String sql_impuesto ="SELECT C_Tax_ID, TaxAmt FROM C_OrderTax WHERE C_Order_ID="+Record_id;
		String sql2="";
		PreparedStatement pstmt = DB.prepareStatement (sql_impuesto, get_TrxName());
		ResultSet rs;
		rs = pstmt.executeQuery ();
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				   //busco l apartida de el presupuesto
				   partida=busca_partida_impuesto(BudgetPublic_ID,rs.getInt(1));
				    // String X = rs.getString(1)  //para recuperar un string de la 1era columna del query
				    // Int Y =rs.getInt(2)              //para recuperar un int de la 2da columna
				    // BigDecimal Z= rs.getBigDecimal(3)    //Para recuperar un BD de la 3era columna
				   MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
				   BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					//BudgetExecLine.setC_OrderLine_ID(olines[i].getC_OrderLine_ID());
					//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
					BudgetExecLine.setAmount(rs.getBigDecimal(2));
					//BudgetExecLine.setAccount_ID(partida);
					//busco la cuenta presupuestaria del impuesto
					BudgetExecLine.setAccount_ID(DB.getSQLValue(null, "select e.c_elementvalue_id from c_tax_acct ta inner join c_validcombination vc on vc.c_validcombination_id = t_credit_acct inner join c_elementvalue e on e.c_elementvalue_id = vc.account_id where ta.c_tax_id =" + rs.getInt(1)));	
					BudgetExecLine.setC_ElementValue_ID(partida);
					BudgetExecLine.setC_BudgetPublic_ID(BudgetPublic_ID);
					BudgetExecLine.setAprov(resp);;   //Aprobación directa de la linea
					BudgetExecLine.save();
				   
		                  }
		} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();//Proceso para parar el documento originario
						}
		//Actualiza los saldos presupuestarios
		
		//
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
