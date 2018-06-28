package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;
import org.compiere.model.MRequisition;

public class CalloutBudgetCover extends CalloutEngine {
	// Para el id del producto
	public String Requisition_Cover(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value) {

		Integer Product_id = (Integer) mTab.getValue("M_Product_ID");
		Integer cantidad = ((BigDecimal) mTab.getValue("Qty")).intValueExact();
		String org_id = mTab.getValue("AD_Org_ID").toString();
		Integer id_doc = (Integer) mTab.getValue("M_Requisition_ID");

		if (valida_plain(ctx, mTab.getValue("M_Requisition_ID").toString(),
				Product_id, cantidad)) {
			if (Product_id == null || Product_id.intValue() == 0)
				return "";

			int cta_cont, cta_bud, ctab[] = null, i;
			String nameBud[] = null, cuentas="";
			BigDecimal Disp=null, Gasto;
			// Buscar cuentas contables y presupuestarias del producto
			String sql = "Select Account_ID from C_ValidCombination Where C_ValidCombination_ID = (Select P_Asset_Acct From M_Product_Acct Where M_Product_ID ="
			+ Product_id + ")";
			cta_cont = DB.getSQLValue(ctx.toString(), sql);
			int nro_ctas = DB.getSQLValue(ctx.toString(), "SELECT COUNT(C_ElementValue_ID) FROM M_Product_Budg WHERE M_Product_ID =" + Product_id); 
			ctab = new int [nro_ctas];
			nameBud = new String [nro_ctas];
			
			//String sql2 = "SELECT C_ElementValue_ID FROM M_Product_Acct where M_Product_id="+ Product_id;
			String sql2 = "SELECT C_ElementValue_ID, Name FROM C_ElementValue WHERE C_ElementValue_ID in (SELECT C_ElementValue_ID FROM M_Product_Budg WHERE M_Product_ID = "+ Product_id + ")";
			//Crear dos arreglos con las cuentas presupuestarias asociadas al producto (pueden ser mas de una)
			//
			PreparedStatement pstmt = DB.prepareStatement (sql2, null);
			ResultSet rs;
			i =0;
			try {
					rs = pstmt.executeQuery ();
					while (rs.next ())
					{
						ctab[i] =  rs.getInt(1);
						nameBud[i] = rs.getString(2) ;
						cuentas  = cuentas + "," +  rs.getString(1);
						i++;
					}
				}
			catch (SQLException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			//
			
			if (cuentas != null)
				cuentas = cuentas.substring(1, cuentas.length());
			else
				cuentas ="";
			
			//Esto siguiente se Elimina o comenta
			 	cta_bud = DB.getSQLValue(ctx.toString(), sql2);
			 	String year = DB
						.getSQLValueString(
								ctx.toString(),
								"select extract(year from datedoc):: varchar from  m_requisition where m_requisition_id ="
										+ id_doc);
			 	String namecta_bud = DB.getSQLValueString(null,
					"SELECT Value || '-'|| Name FROM C_ElementValue WHERE C_ElementValue_ID="
							+ cta_bud);
			 		int year_id = DB.getSQLValue(null,
						"Select C_Year_ID from C_Year where FiscalYear='" + year + "'");
			 		
			//Hasta aqui
			
			// Busco el presupuesto
						
			// Proceso para parar el documento originario
			int BudgetPublic_ID = DB.getSQLValue(null,
					"SELECT C_BudgetPublic_ID FROM M_Requisition WHERE M_Requisition_ID="
							+ id_doc);

			if (BudgetPublic_ID > 0 || cuentas!="") {
				// busco si hya disponibilidad en el presupuesto
				//Aqui esta el problema, de que partida o cuenta ubico el presupuesto si hay mas de una ??
				Gasto = (BigDecimal) mTab.getValue("LineNetAmt");
//OJO esto es referencial....				
				//Muestra una linea de la cuenta que posee saldo para esta compra....
				String cta_selec =null;
				String sql_disp = "SELECT RealAmount, C_Budget_Account_ID FROM C_BudgetPublic_Line WHERE (C_BudgetPublic_ID="+BudgetPublic_ID+" AND C_Budget_Account_ID in ("+cuentas+") AND (realamount >="+Gasto+"))";
	            
				PreparedStatement pstmt1 = DB.prepareStatement (sql_disp, null);
				ResultSet rs1;
				try {
					
						rs1 = pstmt1.executeQuery ();
						while (rs1.next ())
						{
									Disp = rs1.getBigDecimal(1);
									cta_selec = rs1.getString(2);
						}
					}
				catch (SQLException e) 
					{
					// TODO Auto-generated catch block
					e.printStackTrace();			
					}
				
				
////				
				//Disp = DB
				//		.getSQLValueBD(
				//				ctx.toString(),
				//				"Select coalesce(realamount,0) from C_BudgetPublic_Line Where C_budget_Account_ID="
				//						+ cta_bud
				//						+ " AND C_BudgetPublic_ID ="
				//						+ BudgetPublic_ID);
				
				
				
				if (Disp == null)
					Disp = new BigDecimal(0);
				
				if (Disp.equals(new BigDecimal(0))
						|| Disp.compareTo(Gasto) != 1) {
					// DB.executeUpdate("Update M_Requisition set isbudgetcover='N' where M_Requisition_ID="+id_doc,null);
					ADialog.error(
							WindowNo,
							null,
							"No existe Disponibilidad Presupuestaria para este Producto o Servicio, lo disponible en la cuenta"
									+ namecta_bud + " es: " + Disp.toString());
					DB.executeUpdate(
							"Update M_Requisition set isbudgetcover='X'  where M_Requisition_ID="
									+ id_doc, null);
					mTab.setValue("Qty", new BigDecimal(0));
				} else
					DB.executeUpdate(
							"Update M_Requisition set isbudgetcover='N'  where M_Requisition_ID="
									+ id_doc, null);

			} else {
				ADialog.error(WindowNo, null,
						"No existe Presupuesto para este Producto o Servicio");
				DB.executeUpdate(
						"Update M_Requisition set isbudgetcover='X'  where M_Requisition_ID="
								+ id_doc, null);
				mTab.setValue("Qty", new BigDecimal(0));

			}
		} else {
			// cuando no esta en el plan de compras
			DB.executeUpdate(
					"Update M_Requisition set isbudgetcover='X' Where M_Requisition_ID="
							+ id_doc, null);
			// mTab.setValue("Qty", 0);
		}

		return "";
	}

	boolean valida_plain(Properties ctx, String mreq_id, int p_id, Integer qty) {

		int reID = Integer.parseInt(mreq_id);
		MRequisition mreq = new MRequisition(ctx, reID, null);
		int year = mreq.getDateDoc().getYear() + 1900;
		int year_id = DB.getSQLValue(null,
				"Select C_Year_ID from C_Year where FiscalYear='" + year + "'");
		String sql = "SELECT  coalesce(sum(qty_real),0) FROM C_Purchase_Plain_Line  WHERE C_Purchase_Plain_ID in (Select C_Purchase_Plain_ID from C_Purchase_Plain WHERE C_Year_ID = "
				+ year_id
				+ " AND IsActive='Y' AND DocStatus='CO')"
				+ "AND M_Product_ID =" + p_id;
		String mandatory = DB.getSQLValueString(null,
				"SELECT isMandatory FROM C_Purchase_Plain WHERE C_Year_ID="
						+ year_id);

		int quantity = DB.getSQLValue(null, sql);
		if (quantity > 0) {
			if (qty.compareTo(quantity) <= 0)
				return true;
			else {
				if (mandatory.equalsIgnoreCase("Y")) {
					ADialog.error(
							Env.WINDOW_MAIN,
							null,
							"No hay cantidad suficiente en el plan de compras, lo planificado actualmente es de :"
									+ quantity);
					return false;
				} else {
					ADialog.error(
							Env.WINDOW_MAIN,
							null,
							"No hay cantidad suficiente en el plan de compras, lo planificado actualmente es de :"
									+ quantity
									+ " Se continúa por no ser obligatorio");
					return true;
				}
			}
		} else {
			if (mandatory.equalsIgnoreCase("Y")) {
				ADialog.warn(Env.WINDOW_MAIN, null,
						"NO ESTA EN EL PLAN DE COMPRAS O TIENE CERO (0) EN CANTIDAD!!!");
				return false;
			}

			else {
				ADialog.warn(
						Env.WINDOW_MAIN,
						null,
						"NO ESTA EN EL PLAN DE COMPRAS O TIENE CERO (0) EN CANTIDAD, SE CONTINÚA POR NO SER OBLIGATORIO");
				return true;
			}

		}
	}

	/*
	 * Copia el budgetpublic de la pestaña original a la nueva
	 */

	public String CopyBudget(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value) {

		int budg = DB.getSQLValue(null,
				"SELECT C_BudgetPublic_ID from M_Requisition WHERE M_Requisition_ID="
						+ (Integer) mTab.getValue("M_Requisition_ID"));
		mTab.setValue("C_BudgetPublic_ID", budg);

		return "";

	}

}
