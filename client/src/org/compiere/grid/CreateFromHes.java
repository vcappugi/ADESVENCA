/******************************************************************************
 * Copyright (C) 2009 Low Heng Sin                                            *
 * Copyright (C) 2009 Idalica Corporation                                     *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.compiere.grid;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;

import org.compiere.apps.ADialog;
import org.compiere.minigrid.IMiniTable;
import org.compiere.model.GridTab;
import org.compiere.model.MBankAccount;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.MClient;
import org.compiere.model.MPayment;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.pentanet.model.MCContractLine;
import org.pentanet.model.MCHes;
import org.pentanet.model.MCHesLine;
import org.pentanet.model.MCPreInvoiceLineG;

/**
 *  Create Transactions for Bank Statements
 *
 *  @author Jorg Janke
 *  @version  $Id: VCreateFromStatement.java,v 1.2 2006/07/30 00:51:28 jjanke Exp $
 *  @author Victor Perez, e-Evolucion 
 *  <li> RF [1811114] http://sourceforge.net/tracker/index.php?func=detail&aid=1811114&group_id=176962&atid=879335
 *  @author Teo Sarca, www.arhipac.ro
 * 			<li>BF [ 2007837 ] VCreateFrom.save() should run in trx
 */
@SuppressWarnings("unused")
public class CreateFromHes extends CreateFrom 
{
	private Boolean currency_client;
	public MBankAccount bankAccount;
	
	/**
	 *  Protected Constructor
	 *  @param mTab MTab
	 */
	public CreateFromHes(GridTab mTab)
	{
		super(mTab);
		log.info(mTab.toString());
	}   //  VCreateFromHes

	/**
	 *  Dynamic Init
	 *  @return true if initialized
	 */
	public boolean dynInit() throws Exception
	{
		log.config("");
		setTitle(Msg.translate(Env.getCtx(), "C_Hes_ID") + " .. " + Msg.translate(Env.getCtx(), "CreateFrom"));
		
		return true;
	}   //  dynInit
	
	/**
	 *  Get SQL WHERE parameter
	 *  @param f field
	 *  @return Upper case text with % at the end
	 */
	private String getSQLText (String text)
	{
		String s = text.toUpperCase();
		if (!s.endsWith("%"))
			s += "%";
		log.fine( "String=" + s);
		return s;
	}   //  getSQLText
	
	protected Vector<Vector<Object>> getPreInvoiceData(Object C_PreInvoiceG_ID)
	{
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		BigDecimal C_Currency_ID = DB.getSQLValueBD(null, "SELECT C_Currency_ID FROM C_Hes WHERE C_Hes_ID= " + getGridTab().getValue("C_Hes_ID"));
		MClient client = new MClient(Env.getCtx(), null);
		
		
		String sql_c = "";
		
		String sql_b =  " pl.C_PreInvoiceLineG_ID, (cl.value || '_' || cl.name) partidas FROM C_PreInvoiceG p"
					+ " INNER JOIN C_PreInvoiceLineG pl ON pl.C_PreInvoiceG_ID = p.C_PreInvoiceG_ID "
					+ " INNER JOIN C_ContractLine cl ON cl.C_ContractLine_ID = pl.C_ContractLine_ID "
					+ " left JOIN (SELECT p.C_PreInvoiceG_ID, sum(pl.qty) :: numeric(100,3) qty, (cl.value || '_' || cl.name) partidas "
					+ " FROM C_PreInvoice p INNER JOIN C_PreInvoiceLine pl ON pl.C_PreInvoice_ID = p.C_PreInvoice_ID " 
					+ " INNER JOIN C_ContractLine cl ON cl.C_ContractLine_ID = pl.C_ContractLine_ID "
					+ " GROUP BY cl.value, cl.name, p.C_PreInvoiceG_ID) con ON con.C_PreInvoiceG_ID = p.C_PreInvoiceG_ID "
					+ " AND con.partidas = (cl.value || '_' || cl.name) "
					+ " WHERE p.docstatus in ('IP','CO', 'CL') AND p.C_PreInvoiceG_ID = " + C_PreInvoiceG_ID
					+ " AND pl.C_ContractLine_ID NOT IN (SELECT C_ContractLine_ID FROM C_HesLine WHERE C_Hes_ID = "+getGridTab().getValue("C_Hes_ID")+")";
		
		if(C_Currency_ID.toString().equals(((Integer)client.getC_Currency_ID()).toString())){
			sql_c = "SELECT (con.qty - COALESCE(pl.qtyhes_veb,0)) :: numeric(1000,3) qty_pf,";
			sql_b = sql_b +  " AND pl.linenetamt_pure > 0 AND ((con.qty - COALESCE(pl.qtyhes_veb,0)) > 0)";
			currency_client = true;
		}else{
			sql_c = "SELECT (con.qty - COALESCE(pl.qtyhes_usd,0)) :: numeric(1000,3) qty_pf, ";
			sql_b = sql_b + " AND pl.linenetamt_usd > 0 AND ((con.qty - COALESCE(pl.qtyhes_usd,0)) > 0)";
			currency_client = false;
		}
		
		sql_c = sql_c + sql_b + " ORDER BY partidas";
		
		//ADialog.info(0, null, "sql = " + sql_c.toString());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql_c.toString(), null);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				Vector<Object> line = new Vector<Object>(3);
				line.add(new Boolean(false));       //  0-Selection
				KeyNamePair pp = new KeyNamePair(rs.getInt(2), rs.getString(3));
				line.add(pp);                     //  1-C_PreInvoiceLineG_ID
				line.add(rs.getBigDecimal(1));       //  2-Qty_PreInvoice
				line.add(rs.getBigDecimal(1));       //  3-Qty_Hes
				data.add(line);
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql_c, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		
		return data;
	}
	
	public void info()
	{
		
	}
	
	protected void configureMiniTable (IMiniTable miniTable)
	{
		miniTable.setColumnClass(0, Boolean.class, false);      //  0-Selection
		miniTable.setColumnClass(1, String.class, true);        //  1-C_PreInvoiceLineG_ID
		miniTable.setColumnClass(2, BigDecimal.class, true);     //  2-Qty_PreInvoice
		miniTable.setColumnClass(3, BigDecimal.class, false);        //  3-Qty_Hes
		//  Table UI
		miniTable.autoSize();
	}

	/**
	 *  Save Statement - Insert Data
	 *  @return true if saved
	 */
	public boolean save(IMiniTable miniTable, String trxName)
	{
		//  fixed values
		int C_Hes_ID = ((Integer)getGridTab().getValue("C_Hes_ID")).intValue();
		MCHes hs = new MCHes (Env.getCtx(), C_Hes_ID, null);
		log.config(hs.toString());
		
		//  Lines Verificar 
		for (int i = 0; i < miniTable.getRowCount(); i++)
		{
			BigDecimal open = (BigDecimal)miniTable.getValueAt(i, 2);
			BigDecimal qty = (BigDecimal)miniTable.getValueAt(i, 3);
			
			if (((Boolean)miniTable.getValueAt(i, 0)).booleanValue())
			{
				if((open.subtract(qty)).signum() < 0){
					ADialog.warn(0, null, "La Cantidad de la Partida Seleccionada es Menor que la Solicitada. / Linea #" + (i+1));
					return false;
				}
			}
		}
		
		//  Lines
		for (int i = 0; i < miniTable.getRowCount(); i++)
		{
			if (((Boolean)miniTable.getValueAt(i, 0)).booleanValue())
			{
				
				KeyNamePair pp = (KeyNamePair)miniTable.getValueAt(i, 1);   //  1-C_PreInvoiceLineG_ID
				int C_PreInvoiceLineG_ID = pp.getKey();
				BigDecimal qty = (BigDecimal)miniTable.getValueAt(i, 3); //  3- Qty_Hes
				
				log.fine("Line PreInvoiceG = " + C_PreInvoiceLineG_ID);
				
				MCHesLine hsl = null; //getHesLine(C_PreInvoiceLineG_ID); Miguel Contreras
				
				if(hsl == null)
					hsl = new MCHesLine (hs);
				
				hsl.setC_Hes_ID(C_Hes_ID);
				hsl.setC_PreInvoiceLineG_ID(C_PreInvoiceLineG_ID);
				
				MCPreInvoiceLineG pgl = new MCPreInvoiceLineG(Env.getCtx(),C_PreInvoiceLineG_ID, trxName);
				
				hsl.setC_ContractLine_ID(pgl.getC_ContractLine_ID());
				
				MCContractLine cl = new MCContractLine(Env.getCtx(),hsl.getC_ContractLine_ID(), trxName);
				hsl.setC_UOM_ID(cl.getC_UOM_ID());
				
				int line = DB.getSQLValue(null, "SELECT count(*) * 10 FROM c_hesline where c_hes_id = " + hs.get_ID());

				hsl.setLine(line + 10);
				hsl.setQty(qty);
				
				BigDecimal price = new BigDecimal(0);
				
				if(currency_client)
				{
					price = pgl.getPrice_Pure();
				}
				else
				{
					price = pgl.getPrice_Usd();
				}
				
				hsl.setPrice(price);
				hsl.setLineNetAmt(price.multiply(qty).setScale(3, BigDecimal.ROUND_HALF_UP));
				
				if(hs.getC_PreInvoiceG_ID() == 0 ){
					hs.setC_PreInvoiceG_ID(pgl.getC_PreInvoiceG_ID());
				}
				
				if (!hsl.save())
					log.log(Level.SEVERE, "Line not created #" + i);
			}   //   if selected
		}   //  for all rows
		
		hs.save();
		ADialog.info(0,null,"Lineas Generadas Exitosamente.");
		return true;
	}   //  save
	
	protected Vector<String> getOISColumnNames()
	{
		//  Header Info
		Vector<String> columnNames = new Vector<String>(3);
		columnNames.add(Msg.getMsg(Env.getCtx(), "Select"));
		columnNames.add(Msg.translate(Env.getCtx(), "Partida"));
		columnNames.add(Msg.translate(Env.getCtx(), "Cantidad Proforma"));
		columnNames.add(Msg.translate(Env.getCtx(), "Cantidad Hes"));
	    
	    return columnNames;
	}
	
	private MCHesLine getHesLine(int C_PreInvoiceLineG_ID){
		
		int C_HesLine_ID = DB.getSQLValue(null, "SELECT C_HesLine_ID FROM C_HesLine WHERE C_PreInvoiceLineG_ID = ?", C_PreInvoiceLineG_ID);
		
		if(C_HesLine_ID > 0)
			return new MCHesLine(Env.getCtx(),C_HesLine_ID, null);
		else
			return null;
	}
}
