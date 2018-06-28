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
package org.pentanet.process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.pentanet.model.MCHes;
import org.pentanet.model.MCHesLine;



/**
 *	Process for loading Bank Statements into I_BankStatement
 *
 *	@author Maarten Klinker, Eldir Tomassen
 *	@version $Id: LoadBankStatement.java,v 1.2 2006/07/30 00:51:01 jjanke Exp $
 */
/**
 *	@author Lhernandeza
 */

public class LoadHes extends SvrProcess
{
	

	public LoadHes()
	{
		super();
		log.info("LoadHes");
	}	//	LoadBankStatement

	/**	Client to be imported to			*/
	private int				m_AD_Client_ID = 0;

	/** Organization to be imported to			*/
	private int				m_AD_Org_ID = 0;
	

	/** File to be imported					*/
	private String fileName = "";
	
	/** Current context					*/
	private Properties m_ctx;
	
	
	/** C_Hes_ID   **/
	private int C_Hes_ID;
	
	
	/**
	 *  Prepare - e.g., get Parameters.
	 */
	protected void prepare()
	{
		log.info("");
		m_ctx = Env.getCtx();
		
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (name.equals("FileName"))
				fileName = (String)para[i].getParameter();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		
		m_AD_Client_ID = Env.getAD_Client_ID(m_ctx);
		log.info("AD_Client_ID=" + m_AD_Client_ID);
		
		m_AD_Org_ID = Env.getAD_Org_ID(m_ctx);
		log.info("AD_Org_ID=" + m_AD_Org_ID);
	}	//	prepare


	/**
	 *  Perform process.
	 *  @return Message
	 *  @throws Exception
	 */
	protected String doIt() throws java.lang.Exception
	{
		log.info("LoadHes.doIt");
		String message = "@Error@";
	         
		String csvFile = fileName;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		
		String hes = "";
		boolean isFirst = true;
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				String[] linePos = line.split(cvsSplitBy);

				if(!hes.equals(linePos[2] + linePos[3] + linePos[6])){
					hes = linePos[2] + linePos[3] + linePos[6];
					isFirst = true;
				}
				
				if(isFirst){
					log.warning("  - - - - -- - -- - --  " );
					log.warning("  NUEVA HES  " );
					log.warning("  - - - - -- - -- - --  " );
					createHeader(linePos); //Crea Cabecera
					createLine(linePos);  //Crea Línea
					isFirst = false;
				}else{
					log.warning("  - - - - -- - -- - --  " );
					log.warning("  MISMA HES  " );
					log.warning("  - - - - -- - -- - --  " );
					createLine(linePos);  //Crea Línea
				}
			
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					message = "@OK@";
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return message;
	}	//	doIt

	/**
	 * Create Header
	 * @param linePos
	 */
	private void createHeader(String[] linePos){
		
		log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		MCHes pinvG = new MCHes(Env.getCtx(), 0, get_TrxName());
		
		pinvG.setAD_Org_ID(Integer.parseInt(linePos[0]));
		pinvG.setC_Contract_ID(Integer.parseInt(linePos[1]));
		pinvG.setC_DocType_ID(1000096); //HES
		pinvG.setC_PreInvoiceG_ID(Integer.parseInt(linePos[2]));
		pinvG.setDateDoc(Timestamp.valueOf(linePos[3]));
		pinvG.setDateAcct(Timestamp.valueOf(linePos[4]));
		pinvG.setValue(linePos[5]);
		pinvG.setC_BPartner_ID(Integer.parseInt(linePos[6]));
		pinvG.setC_PaymentTerm_ID(Integer.parseInt(linePos[7]));
		pinvG.setC_Municipality_ID(Integer.parseInt(linePos[8]));
		pinvG.setC_Activity_ID(Integer.parseInt(linePos[9]));
		pinvG.setStartDate(Timestamp.valueOf(linePos[10]));
		pinvG.setEndDate(Timestamp.valueOf(linePos[11]));
		pinvG.setC_Currency_ID(Integer.parseInt(linePos[12]));
		
		pinvG.setDocStatus("DR");//chequear ##
		pinvG.setDocAction("CO");//chequear ##
		
		log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		pinvG.save();
		
//		C_PreInvoiceG_ID = pinvG.getC_PreInvoiceG_ID();
		C_Hes_ID =  pinvG.getC_Hes_ID();
		
	}
	
	/**
	 * Create Line
	 * @param linePos
	 */
	private void createLine(String[] linePos){
		
		log.warning("  - - - - -- - -- - --  " + linePos[13] + " - " + linePos[14] + " - " + linePos[15]);
		
		MCHesLine pinvlG = new MCHesLine(Env.getCtx(), 0, get_TrxName());
		pinvlG.setC_Hes_ID(C_Hes_ID);     //Enlace con Cabecera
		pinvlG.setC_ContractLine_ID(Integer.parseInt(linePos[13]));
		pinvlG.setQty(new BigDecimal(linePos[14]));
		pinvlG.setPrice(new BigDecimal(linePos[15]));
		pinvlG.setC_PreInvoiceLineG_ID(Integer.parseInt(linePos[16]));
		pinvlG.setLineNetAmt(pinvlG.getQty().multiply(pinvlG.getPrice()));
		
		log.warning("  - - - - -- - -- - --  " + linePos[13] + " - " + linePos[14] + " - " + linePos[15]);
		
		pinvlG.save();
		
	}
	

}	//	LoadBankStatement
