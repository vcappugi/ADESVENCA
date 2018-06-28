/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.acct;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MClientInfo;
import org.compiere.model.MCurrency;
import org.compiere.model.MDocType;
import org.compiere.model.MFactAcct;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.MTax;
import org.compiere.model.ProductCost;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.model.MCPreInvoice;
import org.pentanet.model.MCWorkDD;

/**
 *  Post WorkDD Documents.
 *  <pre>
 *  Table:              C_WorkDD (1000306)
 *  Document Types:     WDD
 *  </pre>
 *  @author Wilmer Lisboa
 *  @version  $Id: Doc_WorkDD.java,v 1.3 2016/04/26 00:53:33 Wlisboa Exp $
 */
public class Doc_WorkDD extends Doc
{
	/**
	 *  Constructor
	 * 	@param ass accounting schemata
	 * 	@param rs record
	 * 	@param trxName trx
	 */
	public Doc_WorkDD(MAcctSchema[] ass, ResultSet rs, String trxName)
	{
		super (ass, MCWorkDD.class, rs, null, trxName);
	}	//	Doc_Order

	

	/*
	 *  
	 */
	public ArrayList<Fact> createFacts(MAcctSchema as)
	{
		
		ArrayList<Fact> facts = new ArrayList<Fact>();
		
		
		//Datos para la contabilizacion
		int tabla = get_Table_ID();
		int esquema= as.getC_AcctSchema_ID();
		int moneda = 0; 
		int account1=0;
		int account2=0;
		int accounting=0;
		BigDecimal amtAcct = new BigDecimal(0);
		BigDecimal amtSouce = new BigDecimal(0);
		
		BigDecimal totaldebe_usd_p = new BigDecimal(0);
		BigDecimal totaldebe_veb_p = new BigDecimal(0);
		
		BigDecimal totaldebe_usd_c = new BigDecimal(0);
		BigDecimal totaldebe_veb_c = new BigDecimal(0);
		
		MCWorkDD WorkDD = new MCWorkDD(getCtx(),get_ID(),getTrxName());
		
		int ccosto = WorkDD.getC_Activity_ID();
		int mun = WorkDD.getC_Municipality_ID();
		int sdn = WorkDD.getC_BPartner_ID();
		int Record = WorkDD.getC_WorkDD_ID();
		String fecha_acct = DB.getSQLValueString(null,"SELECT to_char(DateAcct, 'dd/mm/yyyy') FROM c_WorkDD where C_WorkDD_id =" + Record);
		int Period_ID = DB.getSQLValue(null, "select c_period_id from c_period where startdate <= '"+fecha_acct+"'  and enddate >= '"+fecha_acct+"'");
		int Project_ID = DB.getSQLValue(null," select c_project_id from c_project where c_contract_id in (select c_contract_id from c_workdd where C_WorkDD_id =" + Record+")");
		
		String sql = "SELECT c_charge_id, dateacct, c_bpartner_id, m_product_id, line_id, "
				+ "debe_id, haber_id, c_currency_id, puro, convertido, t FROM cont_WorkDD ("+Record+") order by m_product_id";
	
		PreparedStatement pstmtl=null;
		ResultSet rsl=null;
		
		try
		{
			pstmtl = DB.prepareStatement (sql, getTrxName());
			rsl = pstmtl.executeQuery();
			while (rsl.next ())
			{
				account1=rsl.getInt(6);
				account2=rsl.getInt(7);				
				amtSouce = rsl.getBigDecimal(9);  // Puro
				amtAcct = rsl.getBigDecimal(10);  // Convertido
				boolean type = rsl.getString(11).equals("Y")?true:false;
				
				
				
				if(type){
					//DEBE
					createFact(as, Period_ID, WorkDD, rsl.getInt(8), WorkDD.getC_BPartner_ID(), account2, rsl.getInt(5), amtSouce, amtAcct, rsl.getInt(4), ccosto, Project_ID);
					accounting=account1;
				}
				
				// cuentas potes
				else{
					// debe
					createFact(as, Period_ID, WorkDD, rsl.getInt(8), WorkDD.getC_BPartner_ID(), account1, rsl.getInt(5), amtSouce, amtAcct, rsl.getInt(4), ccosto, Project_ID);
					// haber
					createFact(as, Period_ID, WorkDD, rsl.getInt(8), WorkDD.getC_BPartner_ID(), account2, rsl.getInt(5), amtSouce.multiply(new BigDecimal(-1)) , amtAcct.multiply(new BigDecimal(-1)), rsl.getInt(4), ccosto, Project_ID);
					
				}
				
				if (type) {
				
					if (as.getC_Currency_ID()==rsl.getInt(8))
					{
						totaldebe_veb_p= totaldebe_veb_p.add(amtSouce);
						totaldebe_veb_c= totaldebe_veb_c.add(amtAcct);
					}
					else
					{
						totaldebe_usd_p= totaldebe_usd_p.add(amtSouce);				
						totaldebe_usd_c= totaldebe_usd_c.add(amtAcct);
					}
				
				}
				
			}	// www
			
				//debe  primero usd luego veb
			
			if (totaldebe_veb_p.signum()!=0 )
			{
			
				createFact(as, Period_ID, WorkDD, as.getC_Currency_ID(), sdn, accounting, 0, totaldebe_veb_p.multiply(new BigDecimal (-1)), totaldebe_veb_c.multiply(new BigDecimal (-1)), 0, ccosto, Project_ID);
			}
			
			if (totaldebe_usd_p.signum()!=0 )
			{
			
				createFact(as, Period_ID, WorkDD, WorkDD.getC_Currency_ID(), sdn, accounting, 0, totaldebe_usd_p.multiply(new BigDecimal(-1)), totaldebe_usd_c.multiply(new BigDecimal (-1)), 0, ccosto, Project_ID);
			}
				
				
		} //try
		catch(Exception e)
		{
			log.info(e.toString());
		}
		
		return facts;
		
	}



	@Override
	protected String loadDocumentDetails() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BigDecimal getBalance() {
		// TODO Auto-generated method stub
		return new BigDecimal(0);
		
	}
	

	private void createFact(MAcctSchema as, int Period_ID, MCWorkDD WorkDD, int C_Currency_ID, int C_BPartner_ID, int Account_ID, int Line_ID, 
			BigDecimal amtSouce, BigDecimal amtAcct, int M_Product_ID, int C_Activity_ID, int C_Project_ID ){
	
		
		MFactAcct cont = new MFactAcct(getCtx(), 0, getTrxName());  //creo un registro en fact_acct
		
		cont.setC_Currency_ID(C_Currency_ID);
		
		cont.setAD_Org_ID(WorkDD.getAD_Org_ID());
		cont.setAD_Table_ID(get_Table_ID());
		cont.setC_BPartner_ID(C_BPartner_ID);
		cont.setAccount_ID(Account_ID);
		cont.setLine_ID(Line_ID);
		
		if(amtAcct.signum()>=0){
			cont.setAmtAcctDr(amtAcct.abs());
			cont.setAmtSourceDr(amtSouce.abs());
		}else { //Valor Negativo, Cambiar al HABER
			cont.setAmtAcctCr(amtAcct.abs());
			cont.setAmtSourceCr(amtSouce.abs());					
		}

		cont.setC_AcctSchema_ID(as.getC_AcctSchema_ID()); 
		cont.setDateAcct(WorkDD.getDateAcct());
		cont.setDateTrx(WorkDD.getDateAcct());
		cont.setDescription(WorkDD.getDescription());
		cont.setC_Activity_ID(C_Activity_ID);
		cont.setRecord_ID(WorkDD.getC_WorkDD_ID());   
		cont.setC_Period_ID(Period_ID);
		cont.setPostingType("A");
		cont.setM_Product_ID(M_Product_ID);
		cont.setC_Project_ID(C_Project_ID);
		cont.save();
		
	}
	

}   //  Doc_Order