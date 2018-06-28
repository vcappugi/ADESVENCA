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
import org.compiere.model.MPaymentAllocate;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.pentanet.model.MCBudgetPublic;
import org.pentanet.model.MCBudgetPublicExec;
import org.pentanet.model.MCBudgetPublicExecLine;


public class Create_Budget_Exec_pay extends SvrProcess {

	@Override
	protected void prepare() {
		

	}

	@Override
	/***********************************************************************
	 * Crea el registro de Ejecucion presupuestaria para Pagos
	 * Desarrollado por vcappugi
	 * 
	 ***********************************************************************/
	protected String doIt() throws Exception {
		
		int Record_id = getRecord_ID(); //ID del documento
		return "";
		
	}
	
	String ejecuta_pay (int Record_id) {
		
		int i,cuenta_c=0,cuenta_p=0;
		int linea=0;
		
		MPayment pay = new MPayment(getCtx(), Record_id, null);
		//Valida si es un cargo directo
		boolean tipo = pay.isReceipt(); 
		if ((pay.getC_Charge_ID()>0) && !(pay.getM_Requisition_ID() > 0)) {
			
			//busca cuenta presupuestaria del cargo
		    int partida = DB.getSQLValue(get_TrxName(), "SELECT Account_ID FROM C_Charge_Acct where C_Charge_id =" + pay.getC_Charge_ID());	
		    int cuenta =  DB.getSQLValue(get_TrxName(), "select (select account_id from c_validcombination where c_validcombination_id = C_Charge_acct. ch_expense_acct)  from C_Charge_Acct where c_charge_id =" + pay.getC_Charge_ID());
		    int presupuesto = DB.getSQLValue(get_TrxName(), "select c_budgetpublic_id from c_payment where c_payment_id =" + pay.getC_Payment_ID());
		    int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");
			executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");
		    
			if ((pay.getDocStatus()=="VO") || (pay.getDocStatus()=="RE"))  //Si esta reversada elimina y no hace nada
				return "";
		    
		    //crea la ejecucion presupuestaria de un cargo directo
		    if (presupuesto > 0) {  //Es posible que un cargo no tenga presupuesto y debe pasar 
			MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);
			//BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
			BudgetExec.setHelp("Ejec Presupuestaria de Pago/Cobro");
			BudgetExec.setC_Payment_ID(pay.getC_Payment_ID());
			if (!tipo)
			     BudgetExec.setC_Budget_Moment_ID(Budget_Moment("P"));
			else
				 BudgetExec.setC_Budget_Moment_ID(Budget_Moment("C"));
			BudgetExec.setC_BudgetPublic_ID(presupuesto);
			BudgetExec.save();
			//Ahora la linea del cargo directo para incluirlo....
			MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);
			BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
			//BudgetExecLine.save();
			//BudgetExecLine.setDescription(rs.getString(1));
			//BudgetExec.setC_BudgetPublic_ID();
			//BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
			//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
			BudgetExecLine.setAmount(pay.getPayAmt());
			BudgetExecLine.setC_BudgetPublic_ID(presupuesto);
			BudgetExecLine.setAccount_ID(cuenta);
			BudgetExecLine.setC_ElementValue_ID(partida);
			String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='P'");
			BudgetExecLine.setAprov(resp);;  //Aprobación Directa
			//BudgetExecLine.setC_BudgetPublic_ID();
			BudgetExecLine.save();
			BudgetExec.setIsApproved(resp);;  //Aprobación Directa
			BudgetExec.save();
			//BudgetExecLine.setC_BudgetPublic_ID();
			BudgetExecLine.save();
		    }
		////////////////////////////////////Solicitud de viaticos //////////////////////////////////////////////////////////77	
		} else if (pay.getM_Requisition_ID()>0){  //Si es una solicitud de requisición (viaticos)
			//busca cuenta presupuestaria del viatico
		    //Para viaticos solo se presupeusta desde el pago, por lo que se borran todos los registros
			//si es que existen
			int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");
			executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");
			
			if ((pay.getDocStatus()=="VO") || (pay.getDocStatus()=="RE"))  //Si esta reversada elimina y no hace nada
				return "";
				    
////////////////////////////////////////////////////////////////////////////
//crea la ejecucion presupuestaria de una solicitud de viaticos Compromiso//
///////////////////////////////////////////////////////////////////////////
		    MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);	
			BudgetExec.setHelp("Ejec Presupuestaria de Pago/Cobro");
			BudgetExec.setC_Payment_ID(pay.getC_Payment_ID());
			if (!tipo)
			     BudgetExec.setC_Budget_Moment_ID(Budget_Moment("O"));
			else
				 BudgetExec.setC_Budget_Moment_ID(Budget_Moment("C"));
			//BudgetExec.setC_BudgetPublic_ID(presupuesto);
			BudgetExec.save();
			//Ahora la linea del la requisicion para incluirla
			
			String sql_fact = "Select b.c_elementvalue_id, rl.linenetamt, rl.c_budgetpublic_id, ev.c_elementvalue_id as account_id "+
					"from m_requisitionline rl " + 
					"inner join m_requisition r on r.m_requisition_id = rl.m_requisition_id "+
					"inner join m_product_budg b on b.m_product_id= rl.m_product_id "+
					"inner join m_product_acct ac on ac.m_product_id = rl.m_product_id "+
					"inner join c_validcombination vc on vc.c_validcombination_id = ac.p_asset_acct "+
					"inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id "+
					"where  rl.M_Requisition_ID=" + pay.getM_Requisition_ID();
			
			PreparedStatement pstmt1 = DB.prepareStatement (sql_fact, get_TrxName());
			ResultSet rs1;
			
			try {
				rs1 = pstmt1.executeQuery ();
				while (rs1.next ())
					{
					
					MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);  //La copia (PAgo)
					BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					//BudgetExecLine.save();
					//BudgetExecLine.setDescription(rs.getString(1));
					//BudgetExec.setC_BudgetPublic_ID();
					//BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
					//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
					BudgetExecLine.setAmount(rs1.getBigDecimal(2));
					BudgetExecLine.setC_BudgetPublic_ID(rs1.getInt(3));
					BudgetExecLine.setAccount_ID(rs1.getInt(4));   //cuenta contable
					BudgetExecLine.setC_ElementValue_ID(rs1.getInt(1));  //Cuenta presupuestaria
					String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='O'");
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
			 ////////////////////////////////////////////////////////////////////////
			//crea la ejecucion presupuestaria de una solicitud de viaticos Causado//
			///////////////////////////////////////////////////////////////////////
		     BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);	
			BudgetExec.setHelp("Ejec Presupuestaria de Pago/Cobro");
			BudgetExec.setC_Payment_ID(pay.getC_Payment_ID());
			if (!tipo)
			     BudgetExec.setC_Budget_Moment_ID(Budget_Moment("F"));
			else
				 BudgetExec.setC_Budget_Moment_ID(Budget_Moment("C"));
			//BudgetExec.setC_BudgetPublic_ID(presupuesto);
			BudgetExec.save();
			//Ahora la linea del la requisicion para incluirla
			
			 sql_fact = "Select b.c_elementvalue_id, rl.linenetamt, rl.c_budgetpublic_id, ev.c_elementvalue_id as account_id "+
					"from m_requisitionline rl " + 
					"inner join m_requisition r on r.m_requisition_id = rl.m_requisition_id "+
					"inner join m_product_budg b on b.m_product_id= rl.m_product_id "+
					"inner join m_product_acct ac on ac.m_product_id = rl.m_product_id "+
					"inner join c_validcombination vc on vc.c_validcombination_id = ac.p_asset_acct "+
					"inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id "+
					"where  rl.M_Requisition_ID=" + pay.getM_Requisition_ID();
			
			PreparedStatement pstmt2 = DB.prepareStatement (sql_fact, get_TrxName());
			ResultSet rs2;
			
			try {
				rs2 = pstmt2.executeQuery ();
				while (rs2.next ())
					{
					
					MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);  //La copia (PAgo)
					BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					//BudgetExecLine.save();
					//BudgetExecLine.setDescription(rs.getString(1));
					//BudgetExec.setC_BudgetPublic_ID();
					//BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
					//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
					BudgetExecLine.setAmount(rs2.getBigDecimal(2));
					BudgetExecLine.setC_BudgetPublic_ID(rs2.getInt(3));
					BudgetExecLine.setAccount_ID(rs2.getInt(4));   //cuenta contable
					BudgetExecLine.setC_ElementValue_ID(rs2.getInt(1));  //Cuenta presupuestaria
					String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='F'");
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
		    ////////////////////////////////////////////////////////////////////////
			//crea la ejecucion presupuestaria de una solicitud de viaticos Pagado//
			///////////////////////////////////////////////////////////////////////
		     BudgetExec = new MCBudgetPublicExec(getCtx(), 0, null);	
			BudgetExec.setHelp("Ejec Presupuestaria de Pago/Cobro");
			BudgetExec.setC_Payment_ID(pay.getC_Payment_ID());
			if (!tipo)
			     BudgetExec.setC_Budget_Moment_ID(Budget_Moment("P"));
			else
				 BudgetExec.setC_Budget_Moment_ID(Budget_Moment("C"));
			//BudgetExec.setC_BudgetPublic_ID(presupuesto);
			BudgetExec.save();
			//Ahora la linea del la requisicion para incluirla
			
			 sql_fact = "Select b.c_elementvalue_id, rl.linenetamt, rl.c_budgetpublic_id, ev.c_elementvalue_id as account_id "+
					"from m_requisitionline rl " + 
					"inner join m_requisition r on r.m_requisition_id = rl.m_requisition_id "+
					"inner join m_product_budg b on b.m_product_id= rl.m_product_id "+
					"inner join m_product_acct ac on ac.m_product_id = rl.m_product_id "+
					"inner join c_validcombination vc on vc.c_validcombination_id = ac.p_asset_acct "+
					"inner join c_elementvalue ev on ev.c_elementvalue_id = vc.account_id "+
					"where  rl.M_Requisition_ID=" + pay.getM_Requisition_ID();
			
			PreparedStatement pstmt3 = DB.prepareStatement (sql_fact, get_TrxName());
			ResultSet rs3;
			
			try {
				rs3 = pstmt3.executeQuery ();
				while (rs3.next ())
					{
					
					MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), 0, null);  //La copia (PAgo)
					BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
					//BudgetExecLine.save();
					//BudgetExecLine.setDescription(rs.getString(1));
					//BudgetExec.setC_BudgetPublic_ID();
					//BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
					//BudgetExecLine.setM_Product_ID(olines[i].getM_Product_ID());
					BudgetExecLine.setAmount(rs3.getBigDecimal(2));
					BudgetExecLine.setC_BudgetPublic_ID(rs3.getInt(3));
					BudgetExecLine.setAccount_ID(rs3.getInt(4));   //cuenta contable
					BudgetExecLine.setC_ElementValue_ID(rs3.getInt(1));  //Cuenta presupuestaria
					String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='P'");
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
				
		//Hasta aqui solicitud de viaticos	
		}else if (pay.isPrepayment())  //Si no es un cargo, revisa si es un anticipo (debe tener una orden de compra)
		{		
			
		}
		else		//Si no es anticipo es facturas  
		{
		
		//las facturas relacionadas a los pagos
			int executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec_Line " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");
			executeUpdate = DB.executeUpdate("delete from C_BudgetPublic_Exec " +
					"where c_budgetpublic_exec_id in (select c_budgetpublic_exec_id from c_budgetpublic_exec where  c_payment_id ="+pay.getC_Payment_ID()+")");	
			
			if ((pay.getDocStatus()=="VO") || (pay.getDocStatus()=="RE"))  //Si esta reversada elimina y no hace nada
				return "";
			
		String sql_fact = "select c_invoice_id from c_paymentallocate where c_payment_id ="+Record_id;
		PreparedStatement pstmt = DB.prepareStatement (sql_fact, get_TrxName());
		ResultSet rs;
		
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				   		
						MInvoice Invoice = new MInvoice (getCtx(), rs.getInt(1), null);
						MInvoiceLine[] ilines = Invoice.getLines();
						
						MOrder Order = new MOrder (getCtx(), Invoice.getC_Order_ID(), null);
						MOrderLine[] olines = Order.getLines();
						
						
						int BudgetPublic_ID = ilines[0].getC_BudgetPublic_ID();
						
						//Busca Ejecucion comprometida en Orden
						int ejec = 0; //Find_exec(Order.getC_Order_ID());
						//no busca nada para crear uno nuevo
						
				
						String DocNo = pay.getDocumentNo();
				
						String Tipo ="Pago/Cobro: " + DocNo;
						
						MCBudgetPublicExec BudgetExec = new MCBudgetPublicExec(getCtx(), ejec, null);
						//BudgetExec.setDescription("Ejecucion Presupuestaria Proceso :" + DocNo);
						BudgetExec.setHelp(BudgetExec.getHelp()+" / "+Tipo);
						//BudgetExec.setC_Invoice_ID(Invoice.getC_Invoice_ID());
						BudgetExec.setC_Payment_ID(pay.getC_Payment_ID());
						if (!tipo)
						     BudgetExec.setC_Budget_Moment_ID(Budget_Moment("P"));
						else
							BudgetExec.setC_Budget_Moment_ID(Budget_Moment("C"));
						String resp = DB.getSQLValueString(get_TrxName(), "select IsAutomatic from C_Budget_Moment where actionl='P' or actionl='C' ");
						BudgetExec.setIsApproved(resp);;  //Aprobación Directa
						
						
						BudgetExec.save();
						
				
				
						for (i=0; i<ilines.length; i++) 
						{
						//	BudgetExec.setIsApproved("N");
							//Busca La Linea de Ejecucion
							linea = Find_exec_line(BudgetExec.getC_BudgetPublic_Exec_ID(), ilines[i].getM_Product_ID(), BudgetPublic_ID);
							linea=0;  //Crea en blanco directamente
							MCBudgetPublicExecLine BudgetExecLine = new MCBudgetPublicExecLine(getCtx(), linea, null);
							BudgetExecLine.setC_BudgetPublic_Exec_ID(BudgetExec.getC_BudgetPublic_Exec_ID());
							BudgetExecLine.save();
							BudgetExecLine.setDescription(rs.getString(1));
							//BudgetExec.setC_BudgetPublic_ID();
							BudgetExecLine.setC_InvoiceLine_ID(ilines[i].getC_InvoiceLine_ID());
							BudgetExecLine.setM_Product_ID(ilines[i].getM_Product_ID());
							BudgetExecLine.setAmount(ilines[i].getLineNetAmt());
							if (!tipo)
							      BudgetExecLine.setAccount_ID(find_cont (ilines[i].getM_Product_ID()));
							else
								BudgetExecLine.setAccount_ID(find_cont_i (ilines[i].getM_Product_ID()));
							
							BudgetExecLine.setC_ElementValue_ID(find_budg(ilines[i].getM_Product_ID()));
							BudgetExecLine.setC_BudgetPublic_ID(ilines[i].getC_BudgetPublic_ID());
							BudgetExecLine.setAprov(resp);  //Aprobación Directa
							BudgetExecLine.save();
						    }
						//Incluye el Impuesto ahora ..
						 // String X = rs.getString(1)  //para recuperar un string de la 1era columna del query
					    // Int Y =rs.getInt(2)              //para recuperar un int de la 2da columna
					    // BigDecimal Z= rs.getBigDecimal(3)    //Para recuperar un BD de la 3era columna
              }
             } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//Proceso para parar el documento originario
			}
		
	}
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
	

}