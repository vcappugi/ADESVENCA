/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
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
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved.               *
 * Contributor(s): Victor Perez www.e-evolution.com                           *
 *****************************************************************************/
package org.compiere.acct;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCharge;
import org.compiere.model.MElementValue;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.MHRConcept;
import org.eevolution.model.MHRMovement;
import org.eevolution.model.MHRProcess;
import org.eevolution.model.X_HR_Concept_Acct;


/**
 *  Post Payroll Documents.
 *  <pre>
 *  Table:              HR_Process (??)
 *  Document Types:     HR_Process
 *  </pre>
 *  @author Oscar Gomez Islas
 *  @author victor.perez@e-evolution.com,www.e-evolution.com
 *  @version  $Id: Doc_Payroll.java,v 1.1 2007/01/20 00:40:02 ogomezi Exp $
 *  @author Cristina Ghita, www.arhipac.ro
 */
public class Doc_HRProcess extends Doc
{
	public MHRProcess process = null;
	
	/** Process Payroll **/
	public static final String	DOCTYPE_Payroll			= "HRP";
	/**
	 *  Constructor
	 * 	@param ass accounting schema
	 * 	@param rs record
	 * 	@parem trxName trx
	 */
	public Doc_HRProcess (MAcctSchema[] ass, ResultSet rs, String trxName)
	{
		super(ass, MHRProcess.class, rs, DOCTYPE_Payroll, trxName);
	}	//	Doc_Payroll

	@Override
	protected String loadDocumentDetails ()
	{
		process = (MHRProcess)getPO();
		setDateDoc(getDateAcct());
		//	Contained Objects
		p_lines = loadLines(process);
		log.fine("Lines=" + p_lines.length);
		return null;
	}   //  loadDocumentDetails


	/**
	 *	Load Payroll Line
	 *	@param Payroll Process
	 *  @return DocLine Array
	 */
	private DocLine[] loadLines(MHRProcess process)
	{
		ArrayList<DocLine> list = new ArrayList<DocLine>();
		/*
		MHRMovement[] lines = process.getLines(true);
		for (int i = 0; i < lines.length; i++)
		{
			MHRMovement line = lines[i];
			DocLine_Payroll docLine = new DocLine_Payroll (line, this);
			//
			log.fine(docLine.toString());
			list.add(docLine);
		}
		*/
		//	Return Array
		DocLine[] dls = new DocLine[list.size()];
		list.toArray(dls);
		return dls;
	}	//	loadLines

	@Override
	public BigDecimal getBalance()
	{
		BigDecimal retValue = Env.ZERO;
		return retValue; 
	}   //  getBalance

	@Override
	public ArrayList<Fact> createFacts (MAcctSchema as)
	{ 
		BigDecimal totalamt = Env.ZERO;
		BigDecimal totalamtconcept = Env.ZERO;
		 BigDecimal porcen = Env.ZERO;
		 BigDecimal porcen2 = Env.ZERO;
		 BigDecimal tot_guard = Env.ZERO;
		 BigDecimal sumAmount = Env.ZERO;
		 DocLine linea = null;
		 DocLine lineamayor = null;
		 MAccount account_may=null, accum_may2 = null;
		 
		Fact fact = new Fact(this, as, Fact.POST_Actual);	
		/* 
		final String sql= "SELECT m.HR_Concept_id, MAX(c.Name) As Name, SUM(m.Amount) As Amount, MAX(c.AccountSign) As AccountSign, " //1: id concepto,2: nombre concepto,3:amount,4:signo
		 + " MAX(CA.IsBalancing) As IsBalancing, m.AD_Org_ID As AD_Org_ID, HR_EXPENSE_ACCT, HR_REVENUE_ACCT"  //5: balanceado,6: org, debito: 7, credito: 8 (debito y credito son las combinaciones)
		 + " FROM HR_Movement m"
		 + " INNER JOIN HR_Concept_Acct ca ON (ca.HR_Concept_ID=m.HR_Concept_ID AND ca.IsActive = 'Y') "   //and contract and org and  ???
		 + " INNER JOIN HR_Concept      c  ON (c.HR_Concept_ID=m.HR_Concept_ID AND c.IsActive = 'Y')"
		 + " INNER JOIN C_BPartner      bp ON (bp.C_BPartner_ID = m.C_BPartner_ID)"
		 + " WHERE m.HR_Process_ID=? AND (m.Qty <> 0 OR m.Amount <> 0) AND c.AccountSign != 'N'"
		 + " GROUP BY m.HR_Concept_ID,m.AD_Org_ID"
		 + " ORDER BY m.AD_Org_ID";
		 
		final String sql="SELECT m.HR_Concept_id, max(c.name) As Name , SUM(m.Amount) As Amount, max(c.AccountSign) As AccountSign, " 
		  +"MAX(CA.IsBalancing) As IsBalancing, m.AD_Org_ID As AD_Org_ID,   max(HR_EXPENSE_ACCT) as HR_EXPENSE_ACCT, max(ca.HR_REVENUE_ACCT) as HR_REVENUE_ACCT, em.HR_Payroll_Type_Line_ID as PayrollType "
		 +"FROM HR_Movement m "
		 +"INNER JOIN HR_Concept      c  ON (c.HR_Concept_ID=m.HR_Concept_ID AND c.IsActive = 'Y') "
		 +"INNER JOIN C_BPartner      bp ON (bp.C_BPartner_ID = m.C_BPartner_ID) "
		 +"INNER JOIN HR_Employee     em ON (em.C_BPartner_ID=m.C_BPartner_ID ) "
		 +"INNER JOIN HR_Concept_Acct ca ON (ca.HR_Concept_ID=m.HR_Concept_ID AND ca.IsActive = 'Y' AND (ca.HR_Payroll_Type_Line_ID=em.HR_Payroll_Type_Line_ID OR ca.HR_Payroll_Type_Line_ID is null)) "
		 +"WHERE m.HR_Process_ID=? AND (m.Qty <> 0 OR m.Amount <> 0) AND c.AccountSign != 'N' "  //and c.hr_concept_id = 1000906
		 +"GROUP BY m.HR_Concept_ID,m.AD_Org_ID, em.HR_Payroll_Type_Line_ID "
		
		 +"ORDER BY m.AD_Org_ID, HR_Concept_ID";
		 */
		final String sql="SELECT SUM(AMOUNT_ST), CC, IDCONCEPT, HR_EXPENSE_ACCT, HR_REVENUE_ACCT, ACCOUNTSIGN, "
				+ " ISAPORT, ISBALANCING, ORG_ID "
				+ " FROM PAYROLL_PROCESS_ACCT(?)  " //WHERE HR_EXPENSE_ACCT <> 0 and  HR_REVENUE_ACCT <>0
				+ " GROUP BY CC, IDCONCEPT, HR_EXPENSE_ACCT, HR_REVENUE_ACCT, ACCOUNTSIGN, IsBalancing, ORG_ID, ISAPORT";
		ResultSet rs = null; 
		PreparedStatement pstmt = null;
		try
		{
			pstmt = DB.prepareStatement (sql, getTrxName());
			pstmt.setInt (1, process.getHR_Process_ID());  
			rs = pstmt.executeQuery ();	
			while (rs.next())
			{
				int HR_Concept_ID = rs.getInt("IDCONCEPT");
				
				int debe = rs.getInt("HR_EXPENSE_ACCT");  //Tego el debe (combinacion contable)
				int haber = rs.getInt("HR_REVENUE_ACCT"); //Tengo elHaber (Combinacion)											
				// round amount according to currency
				BigDecimal Amount2 = rs.getBigDecimal(1);
				Amount2 = Amount2.setScale(2, BigDecimal.ROUND_HALF_UP);
		       if (Amount2.compareTo(new BigDecimal(0)) > 0 ) {
						String AccountSign = rs.getString("ACCOUNTSIGN");
						boolean isBalancing = "Y".equals(rs.getString("ISBALANCING"));
						boolean isAport = "Y".equals(rs.getString("ISAPORT"));
						int AD_OrgTrx_ID=rs.getInt("ORG_ID");
						int C_Activity_ID=rs.getInt("CC");
						if (AccountSign != null && AccountSign.length() > 0 
								&& (MHRConcept.ACCOUNTSIGN_Debit.equals(AccountSign) 
										|| MHRConcept.ACCOUNTSIGN_Credit.equals(AccountSign))) 
						{
							if (isBalancing)
							{
								//MAccount accountBPD = MAccount.get (getCtx(), getAccountBalancing(as.getC_AcctSchema_ID(),HR_Concept_ID,MHRConcept.ACCOUNTSIGN_Debit));
								MAccount accountBPD = MAccount.get (getCtx(), debe);
								FactLine debit=fact.createLine(null, accountBPD,as.getC_Currency_ID(),Amount2, null);
								debit.setAD_OrgTrx_ID(AD_OrgTrx_ID);
								debit.setC_Activity_ID(C_Activity_ID);
								//debit.setC_BPartner_ID(C_BPartner_ID);
								
								//MAccount accountBPC = MAccount.get (getCtx(),this.getAccountBalancing(as.getC_AcctSchema_ID(),HR_Concept_ID, MHRConcept.ACCOUNTSIGN_Credit));
								MAccount accountBPC = MAccount.get (getCtx(),haber);
								FactLine credit = fact.createLine(null,accountBPC ,as.getC_Currency_ID(),null,Amount2);
								credit.setAD_OrgTrx_ID(AD_OrgTrx_ID);
								credit.setC_Activity_ID(C_Activity_ID);
								//credit.setC_BPartner_ID(C_BPartner_ID);
								
							}
							else
							{
								if (MHRConcept.ACCOUNTSIGN_Debit.equals(AccountSign))
								{
									MAccount accountBPD = MAccount.get (getCtx(), debe);
									
									FactLine debit=fact.createLine(null, accountBPD,as.getC_Currency_ID(),Amount2, null);
									debit.setAD_OrgTrx_ID(AD_OrgTrx_ID);
									debit.setC_Activity_ID(C_Activity_ID);
									//debit.setC_BPartner_ID(C_BPartner_ID);
									sumAmount = sumAmount.abs();
									
									account_may = accountBPD;
								}
								else if (MHRConcept.ACCOUNTSIGN_Credit.equals(AccountSign))
								{
									MAccount accountBPC = MAccount.get (getCtx(),haber);
									
									FactLine credit = fact.createLine(null,accountBPC ,as.getC_Currency_ID(),null,Amount2);
									credit.setAD_OrgTrx_ID(AD_OrgTrx_ID);
									credit.setC_Activity_ID(C_Activity_ID);
									
									account_may = accountBPC;
									//credit.setC_BPartner_ID(C_BPartner_ID);
									Amount2 = Amount2.abs().negate();
								}
								if (porcen.compareTo( Amount2.abs()) < 0) {
									porcen = Amount2.abs();
									lineamayor = linea;
									accum_may2=account_may;
								}
								//Verifica si los aportes y provisiones estan marcados como Balancing
								if (isAport == isBalancing){
									totalamt = totalamt.add(Amount2).setScale(2, BigDecimal.ROUND_HALF_UP);
									totalamtconcept =totalamtconcept.add(Amount2).setScale(2, BigDecimal.ROUND_HALF_UP);
								}
							}
						}
						
						} //End del if si es cero	
					} //End While 1
		         } //End try 1
				catch (Exception e)
				{
					log.log(Level.SEVERE, sql, e);
					p_Error = e.getLocalizedMessage();
					return null;
				}
		/*
					//la diferencia en caso que el comprobante este descuadrado va a una linea de ajuste de la misma cuenta
					if (totalamtconcept.abs().compareTo(sumAmount) !=0){
						BigDecimal difer = totalamtconcept.abs().subtract(sumAmount.abs());
						
						if (difer.signum() > 0){
						     FactLine ajuste = fact.createLine(null,accum_may2 ,as.getC_Currency_ID(),null,difer);
						}
						else {
							 FactLine ajuste = fact.createLine(null,accum_may2 ,as.getC_Currency_ID(),difer,null);
						}
						
						totalamt = totalamt.subtract(difer.abs());
                        					
						totalamtconcept = Env.ZERO;
					} //fin del ajuste de diferencia
					
					
				
				
*/				
			// La linea de la totalizacion
			if (totalamt.signum() != 0)
			{
				int C_Charge_ID = process.getHR_Payroll().getC_Charge_ID();
				if (C_Charge_ID > 0) {
					MAccount acct = MCharge.getAccount(C_Charge_ID, as, totalamt);
					FactLine regTotal = null;
					if(totalamt.signum() > 0)
						regTotal = fact.createLine(null, acct ,as.getC_Currency_ID(), null, totalamt);
					else
						regTotal = fact.createLine(null, acct ,as.getC_Currency_ID(), totalamt.abs(), null);
					regTotal.setAD_Org_ID(getAD_Org_ID());
					regTotal.setC_Activity_ID(process.getC_Activity_ID());
				}
			}

		
	/*
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
			p_Error = e.getLocalizedMessage();
			return null;
		}
		finally
		{
			DB.close(rs, pstmt);
			pstmt = null;
			rs = null;
		}
*/
		ArrayList<Fact> facts = new ArrayList<Fact>();
		facts.add(fact);
		return facts;
	}

	/**
	 * get account balancing
	 * @param AcctSchema_ID
	 * @param HR_Concept_ID
	 * @param AccountSign Debit or Credit only
	 * @return Account ID 
	 */
	private int getAccountBalancing (int AcctSchema_ID, int HR_Concept_ID, String AccountSign)
	{
		String field;
		if (MElementValue.ACCOUNTSIGN_Debit.equals(AccountSign))
		{
			field = X_HR_Concept_Acct.COLUMNNAME_HR_Expense_Acct;
		}
		else if (MElementValue.ACCOUNTSIGN_Credit.equals(AccountSign))
		{
			field = X_HR_Concept_Acct.COLUMNNAME_HR_Revenue_Acct;
		}
		else
		{
			throw new IllegalArgumentException("Invalid value for AccountSign="+AccountSign);
		}
		final String sqlAccount = "SELECT "+field+" FROM HR_Concept_Acct"
							+ " WHERE HR_Concept_ID=? AND C_AcctSchema_ID=?";
		int Account_ID = DB.getSQLValueEx(getTrxName(), sqlAccount, HR_Concept_ID, AcctSchema_ID);		
		return Account_ID;
	}

}   //  Doc_Payroll
