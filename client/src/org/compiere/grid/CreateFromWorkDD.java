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

import java.awt.TrayIcon.MessageType;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.compiere.apps.ADialog;
import org.compiere.minigrid.IMiniTable;
import org.compiere.model.GridTab;
import org.compiere.model.MBankAccount;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.pentanet.model.MCHesLine;
import org.pentanet.model.MCPreInvoiceG;
import org.pentanet.model.MCPreInvoiceLineG;
import org.pentanet.model.MCWorkDDLine;
import org.pentanet.model.MVentanaAsociada;
import org.python.core.exceptions;


/**
 *  Create Transactions for Bank Statements
 *
 *  @author Jorg Janke
 *  @version  $Id: VCreateFromStatement.java,v 1.2 2006/07/30 00:51:28 jjanke Exp $
 *  @author Victor Perez, e-Evolucion 
 *  <li> RF [1811114] http://sourceforge.net/tracker/index.php?func=detail&aid=1811114&group_id=176962&atid=879335
 *  @author Teo Sarca, www.arhipac.ro
 * 			<li>BF [ 2007837 ] VCreateFrom.save() should run in trx
 *  @author Luis Hernandez, ESVENCA
 */
@SuppressWarnings("unused")
public class CreateFromWorkDD extends CreateFrom 
{
	public MBankAccount bankAccount;
	
	/**
	 *  Protected Constructor
	 *  @param mTab MTab
	 */
	public CreateFromWorkDD(GridTab mTab)
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
		setTitle(Msg.translate(Env.getCtx(), "C_WorkDDG_ID") + " .. " + Msg.translate(Env.getCtx(), "CreateFrom"));
		
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
	
	private Timestamp startdate = null;
	private Timestamp enddate = null;
	private int C_WorkDDG_ID = 0;
	private int C_Contract_ID = 0; 

	protected Vector<Vector<Object>> getPreInvoiceData(int C_WorkDDG_ID, Timestamp startdate, Timestamp enddate)
	{
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		this.startdate = startdate;
		this.enddate = enddate;
		this.C_WorkDDG_ID = C_WorkDDG_ID;
		//BigDecimal C_Currency_ID = DB.getSQLValueBD(null, "SELECT C_Currency_ID FROM C_Hes WHERE C_Hes_ID= " + getGridTab().getValue("C_Hes_ID"));
		//MClient client = new MClient(Env.getCtx(), null);
		
		
		String sql = "SELECT cl.C_Contractline_ID, cl.value ||'-'|| cl.name partida, sum(wdl.qty)::numeric(15,3) dia_a_dia "
		+ "FROM C_workdd wd INNER JOIN C_workddline wdl ON wdl.C_workdd_id = wd.C_workdd_id "
		+ "INNER JOIN C_Contractline cl ON cl.C_Contractline_ID = wdl.C_Contractline_ID "
		+ "WHERE wd.C_workddg_id = (select C_workddg_id from C_workddg where  C_workddg_ID= "+ C_WorkDDG_ID + ") AND "
		+ "(startdate::date BETWEEN '"+startdate+"'::date AND '"+enddate+"'::date "
		+ "OR enddate::date BETWEEN '"+startdate+"'::date AND '"+enddate+"'::date) "
		+ "AND wdl.c_preinvoiceline_id is null AND wdl.c_preinvoicelineg_id is null " 
		+ "GROUP BY cl.C_Contractline_ID, cl.value, cl.name ORDER BY partida ";
		//ADialog.info(0, null, "DATA----  " + sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, null);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				Vector<Object> line = new Vector<Object>(3);
				line.add(new Boolean(false));        //  0-Selection
				//KeyNamePair pp = new KeyNamePair(rs.getInt(2), rs.getString(3));
				line.add(rs.getString(2));           //  1-Partidas
				line.add(rs.getBigDecimal(3));       //  2-Qty
				line.add(new Boolean(true));        //  3-Cargo
				//line.add(new BigDecimal(0));       //  
				data.add(line);
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
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
		miniTable.setColumnClass(1, String.class, true);        //  1-Partidas
		miniTable.setColumnClass(2, BigDecimal.class, true);     //  2-Qty
		miniTable.setColumnClass(3, Boolean.class, false);      //  4-Cargo Default
		//miniTable.setColumnClass(3, BigDecimal.class, false);        //  3-Qty_Hes
		//  Table UI
		miniTable.autoSize();
	}

	/**
	 *  Save Statement - Insert Data
	 *  @return true if saved
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public boolean save(IMiniTable miniTable, String trxName)
	{
		//ADialog.warn(0, null, "SAVE------");
		String sql = "SELECT AD_Org_ID, C_Activity_ID, C_DocType_ID, C_Municipality_ID, "
				+ "now()::Timestamp, C_Contract_ID, C_BPartner_ID, value, C_Currency_ID, C_WorkDDG_ID FROM c_workddg WHERE C_WorkDDG_ID = "+ C_WorkDDG_ID ;
		
		MCPreInvoiceG PreInvoiceG = new MCPreInvoiceG(Env.getCtx(), 0, null);
		//Create HeaderG
		PreparedStatement pstmt = DB.prepareStatement (sql);
		if (createHeaderG(pstmt, PreInvoiceG))
			log.info("createHeaderG successful");
		PreInvoiceG.setDocStatus("IP");
		PreInvoiceG.save();
		
		
		
		ArrayList<Integer> WorkDDG_ID = new ArrayList<Integer>();
		ArrayList<ArrayList> partidas_ID = new ArrayList<ArrayList>();
		
		//row select
		for (int i = 0; i < miniTable.getRowCount(); i++)
		{
			String partida = (String)miniTable.getValueAt(i, 1);
			BigDecimal qty = (BigDecimal)miniTable.getValueAt(i, 2);
			
			if (((Boolean)miniTable.getValueAt(i, 0)).booleanValue())
			{
				//ADialog.warn(0, null, "Se Selecciono la Partida: " + partida+ " " + qty +" "+ (i+1));
				MCPreInvoiceLineG PreInvoiceLineG = new MCPreInvoiceLineG(Env.getCtx(), 0, null); //(Env.getCtx(), 0, trxName);
				PreInvoiceLineG.setC_PreInvoiceG_ID(PreInvoiceG.get_ID());
				 

				String sql_2 = "SELECT cl.C_ContractLine_ID, price_usd::numeric(20,3), price_pure::numeric(20,3), C_Charge_ID,price, cl.C_uom_id "
						+ "FROM C_ContractLine cl "
						+ "INNER JOIN C_ContractLine_Acct cla ON cla.C_ContractLine_ID = cl.C_ContractLine_ID "
						+ "WHERE C_Contract_ID = " + C_Contract_ID + " AND isdefault = 'Y' AND VALUE||'-'||name = '"+partida+"'";
				//ADialog.warn(0, null, "sql_2: " + sql_2 );
				
				String sql_tasa = "SELECT cr.MultiplyRate "
						 +"FROM C_Conversion_Rate cr "
						 +"INNER JOIN C_PreInvoiceG pg ON pg.C_Currency_ID = cr.C_Currency_ID "
						 +"WHERE pg.C_PreInvoiceG_ID = "+PreInvoiceG.get_ID()+" AND cr.C_Currency_ID_To=205 AND pg.DateAcct BETWEEN cr.ValidFrom and cr.ValidTo";
				
				BigDecimal tasa = DB.getSQLValueBD(null,sql_tasa);
				
				//Create LineG
				try{
					PreparedStatement pstmt2 = DB.prepareStatement(sql_2);
					ResultSet rs2 = pstmt2.executeQuery ();
					while (rs2.next())
					{
						PreInvoiceLineG.setC_ContractLine_ID(rs2.getInt(1));
						PreInvoiceLineG.setC_UOM_ID(rs2.getInt(6));
						PreInvoiceLineG.setQty(qty);
						PreInvoiceLineG.setPrice_Usd(rs2.getBigDecimal(2));
						PreInvoiceLineG.setPrice_Pure(rs2.getBigDecimal(3));
						PreInvoiceLineG.setPrice(PreInvoiceLineG.getPrice_Pure().add(PreInvoiceLineG.getPrice_Usd().multiply(tasa)));
						PreInvoiceLineG.setLineNetAmt_Pure(qty.multiply(rs2.getBigDecimal(3)).setScale(3, BigDecimal.ROUND_HALF_UP));
						PreInvoiceLineG.setLineNetAmt_Usd(qty.multiply(rs2.getBigDecimal(2)).setScale(3, BigDecimal.ROUND_HALF_UP));
						PreInvoiceLineG.setLineNetAmt(qty.multiply(PreInvoiceLineG.getPrice()).setScale(3, BigDecimal.ROUND_HALF_UP));
						
						
						if (((Boolean)miniTable.getValueAt(i, 3)).booleanValue())
						{
							PreInvoiceLineG.setC_Charge_ID(rs2.getInt(4));						
						}else {
							//ADialog.warn(0, null, "no es DEFAULT " );
														
							ArrayList<ArrayList> listcargos = LlenarCargos(rs2.getInt(1));
					        
					        Object[] objetoDialog = new Object[listcargos.size()];
					        for (int K = 0; K < objetoDialog.length; K++) {
					            objetoDialog[K] = listcargos.get(K).get(0);
					        }
					        
					        @SuppressWarnings({ })
							String CargoSelect = 
					       (String) JOptionPane.showInputDialog(null,"Partida: "+ partida, "Seleccione el Cargo",
					                		JOptionPane.INFORMATION_MESSAGE,null, objetoDialog, null);
					        
					        int C_Charge_ID = 0, e = 0;
					        boolean flag=true;
					        while(flag){
					        	if (CargoSelect.equals(listcargos.get(e).get(0))){
					        		C_Charge_ID = Integer.parseInt(listcargos.get(e).get(1).toString());
					        		flag = false;
					        	}
					        	e++;
					        }
					        PreInvoiceLineG.setC_Charge_ID(C_Charge_ID);
						}

						PreInvoiceLineG.setC_PreInvoiceG_ID(PreInvoiceG.get_ID());
						PreInvoiceLineG.save();
						ArrayList<String> partidas = new ArrayList<String>();
						partidas.add(partida);
						partidas.add(String.valueOf(PreInvoiceLineG.get_ID()));
						partidas_ID.add(partidas);
					}
					
				}catch(Exception e){	log.warning(e.getMessage());		}
			
				
			}
		}
		MCPreInvoiceG PreInvoiceGAfterSavePLG = new MCPreInvoiceG(Env.getCtx(), PreInvoiceG.get_ID(), null);// para que se traiga los totales actualizados
		PreInvoiceGAfterSavePLG.setFrom_day_day(true);
		PreInvoiceGAfterSavePLG.prepareIt();
		
	
		for(ArrayList elem : partidas_ID){
			String sql_1 = "SELECT cl.value ||'-'|| cl.name partida, wdl.C_workddline_ID "
					+ "FROM C_workdd wd INNER JOIN C_workddline wdl ON wdl.C_workdd_id = wd.C_workdd_id "
					+ "INNER JOIN C_Contractline cl ON cl.C_Contractline_ID = wdl.C_Contractline_ID "
					+ "WHERE wd.C_workddg_ID=" + C_WorkDDG_ID + " AND "
					+ "(startdate::date BETWEEN '"+startdate+"'::date AND '"+enddate+"'::date "
					+ "OR enddate::date BETWEEN '"+startdate+"'::date AND '"+enddate+"'::date) "
					+ "AND cl.value ||'-'|| cl.name = '" + elem.get(0) +"'" ;
			//ADialog.warn(0, null, "sql_1 " + sql_1 );
			try{
				PreparedStatement pstt = DB.prepareStatement(sql_1);
				ResultSet rs3 = pstt.executeQuery ();
				while (rs3.next())
				{
					MCWorkDDLine CWorkDDLine = new MCWorkDDLine(Env.getCtx(), rs3.getInt(2), null);
					//ADialog.warn(0, null, "PreInvoiceLineG.get_ID() " + PreInvoiceLineG.get_ID());
					CWorkDDLine.setC_PreInvoiceLineG_ID(Integer.parseInt(elem.get(1).toString()));
					CWorkDDLine.save();
					WorkDDG_ID.add(rs3.getInt(2));
				}
			}catch(Exception e){	log.warning(e.getMessage());	}
			
		}
		
		for(Integer elemento : WorkDDG_ID){
			String sql_II = "SELECT pl.c_preinvoiceline_id FROM C_WorkDDLine wdl "
					+ "INNER JOIN c_preinvoicelineg plg ON plg.c_preinvoicelineg_id = wdl.c_preinvoicelineg_id "
					+ "INNER JOIN c_preinvoice p ON p.c_preinvoiceg_id = plg.c_preinvoiceg_id "
					+ "INNER JOIN c_preinvoiceline pl ON pl.c_preinvoice_id = p.c_preinvoice_id and wdl.c_contractline_id = pl.c_contractline_id "
					+ "WHERE C_WorkDDLine_ID = " + elemento;
			Integer c_preinvoiceline_id = DB.getSQLValue(null, sql_II);
			//ADialog.warn(0, null, "sql_II " + sql_II + " -----c_preinvoiceline_id: " + c_preinvoiceline_id);
			
			MCWorkDDLine CWorkDDLine = new MCWorkDDLine(Env.getCtx(), elemento, null);
			CWorkDDLine.setC_PreInvoiceLine_ID(c_preinvoiceline_id);
			CWorkDDLine.save();
		}
		
		
		
		try {
			MWindow windows = new MWindow(Env.getCtx(),1000149,null);
			MQuery query = new MQuery();
			log.warning("PreInvoiceG: "+PreInvoiceG.get_ID());
			query.addRestriction("C_PreInvoiceG_ID", MQuery.EQUAL, PreInvoiceG.get_ID());
			MVentanaAsociada mv = new MVentanaAsociada (null, windows, 1000296, query);
		}catch (Exception e){
			return true;
		}
		
		return true;
	}   //  save
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private ArrayList<ArrayList> LlenarCargos(int C_ContractLine_id) {
		ArrayList<ArrayList> listcargos = new ArrayList<ArrayList>();
		String sql = "SELECT cla.c_charge_id::text, ch.name FROM C_ContractLine cl "
				+ "INNER JOIN c_contractline_acct cla ON cla.C_ContractLine_ID = cl.C_ContractLine_ID "
				+ "INNER JOIN c_charge ch ON ch.c_charge_id = cla.c_charge_id "
				+ "WHERE cl.C_ContractLine_id = " + C_ContractLine_id;
		try{
			PreparedStatement pstmt3 = DB.prepareStatement(sql);
			ResultSet rs3 = pstmt3.executeQuery ();
			while (rs3.next())
			{
				ArrayList<String> cargos = new ArrayList<String>();
	            cargos.add(rs3.getString(2)); 
	            cargos.add(rs3.getString(1));
	            listcargos.add(cargos);
			}
		}catch(Exception e){	
			log.warning(e.getMessage());	
			return null;
		}
		return listcargos;
	}

	
	private boolean createHeaderG(PreparedStatement pstmt, MCPreInvoiceG PreInvoiceG){
		
		try{
			ResultSet rs = pstmt.executeQuery ();
			while (rs.next())
			{
				PreInvoiceG.setAD_Org_ID(rs.getInt(1));
				PreInvoiceG.setC_Activity_ID(rs.getInt(2)); 
				PreInvoiceG.setC_DocType_ID(rs.getInt(3)); 
				PreInvoiceG.setC_Municipality_ID(rs.getInt(4));
				PreInvoiceG.setDateAcct(rs.getTimestamp(5));
				PreInvoiceG.setDateDoc(rs.getTimestamp(5));
				PreInvoiceG.setEndDate(enddate);
				PreInvoiceG.setStartDate(startdate);
				PreInvoiceG.setC_Contract_ID( C_Contract_ID = rs.getInt(6));
				PreInvoiceG.setC_BPartner_ID(rs.getInt(7));
				PreInvoiceG.setDescription(JOptionPane.showInputDialog("Ingresar Descripcion de la Proforma"));
				PreInvoiceG.setHelp("Documento Generado desde el Dia a Dia: " + rs.getString(8));
				PreInvoiceG.setC_Currency_ID(rs.getInt(9));
				PreInvoiceG.setC_WorkDDG_ID(rs.getInt(10));
				PreInvoiceG.setDocStatus("DR"); // from IP to DR :: lhernandeza
				PreInvoiceG.setDocAction("CO");
			}
			if (!PreInvoiceG.save())
			{	
				log.log(Level.SEVERE, "Header not created"); 
				return false;
			}else {
				boolean flag= true; 
				while(flag){
					
					String value = "";
					try{
						String code = DB.getSQLValueString(null, "SELECT * FROM generate_preinvoiceg_code("+PreInvoiceG.getC_Contract_ID()+","+PreInvoiceG.getC_Activity_ID()+")");
						
						value = JOptionPane.showInputDialog("Ingresar Codigo de la Proforma",code);

						if (value.toString().length()>5 && value!=null){
							PreInvoiceG.setValue(value);
							flag=false;
						}
						
					}catch(Exception e){
						//ADialog.info(0, null, "value = "+value);
						//e.getMessage();
					}
					
					
					
				}
			};
		}catch(Exception e){	
			log.warning(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	protected Vector<String> getOISColumnNames()
	{
		//  Header Info
		Vector<String> columnNames = new Vector<String>(2);
		columnNames.add(Msg.getMsg(Env.getCtx(), "Select"));
		columnNames.add(Msg.translate(Env.getCtx(), "C_ContractLine_ID"));
		columnNames.add(Msg.translate(Env.getCtx(), "Qty"));
		columnNames.add("Cargo Default");
//		columnNames.add(Msg.getElement(Env.getCtx(), "CCargo Default"));
	    
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
