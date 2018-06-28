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
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pentanet.model.MCPreInvoice;
import org.pentanet.model.MCPreInvoiceG;
import org.pentanet.model.MCPreInvoiceLine;
import org.pentanet.model.MCPreInvoiceLineG;



/**
 *	Process for loading Bank Statements into I_BankStatement
 *
 *	@author Maarten Klinker, Eldir Tomassen
 *	@version $Id: LoadBankStatement.java,v 1.2 2006/07/30 00:51:01 jjanke Exp $
 */
public class LoadPreInvoice extends SvrProcess
{
	

	public LoadPreInvoice()
	{
		super();
		log.info("LoadPreInvoice");
	}	//	LoadBankStatement

	/**	Client to be imported to			*/
	private int				m_AD_Client_ID = 0;

	/** Organization to be imported to			*/
	private int				m_AD_Org_ID = 0;
	

	/** File to be imported					*/
	private String fileName = "";
	
	/** Current context					*/
	private Properties m_ctx;
	
	/** C_PreInvoiceG_ID   **/
	private int C_PreInvoiceG_ID;
	
	/** C_PreInvoiceG_ID   **/
	private int C_PreInvoice_ID;
	
	private String datedoc;
	private String startdate;
	private String enddate;
	private BigDecimal tasa;
	
	
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
		log.info("LoadPreInvoice.doIt");
		String message = "@Error@";
	         
		String csvFile = fileName;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		
		String preinvoice = "";
		boolean isFirst = true;
		int count = 1;
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
				log.warning("  - - - - -- - -- - --  LINEA: "+count);
				count++;

				String[] linePos = line.split(cvsSplitBy);
			
				datedoc = linePos[5];//mcontreras
				startdate = linePos[6];//mcontreras
				enddate = linePos[7];//mcontreras
				log.warning(preinvoice+"("+preinvoice.length()+") == "+linePos[4] + datedoc+"("+(linePos[4]+linePos[5]).length()+")");
				
				/*
				 * Si usas windows y el csv no te deja formatear la fecha y tu maquina virtual no sirve y necesitas migrar rapido, aqui esta tu teipe. mcontreras
				 */
				
				/*
				
				 
				datedoc = datedoc.split(" ")[0].split("/")[2]+"-"+this.putZeroDate(datedoc.split(" ")[0].split("/")[1])+"-"+this.putZeroDate(datedoc.split(" ")[0].split("/")[0])+" 00:00:00";
				startdate = startdate.split(" ")[0].split("/")[2]+"-"+this.putZeroDate(startdate.split(" ")[0].split("/")[1])+"-"+this.putZeroDate(startdate.split(" ")[0].split("/")[0])+" 00:00:00";
				enddate = enddate.split(" ")[0].split("/")[2]+"-"+this.putZeroDate(enddate.split(" ")[0].split("/")[1])+"-"+this.putZeroDate(enddate.split(" ")[0].split("/")[0])+" 00:00:00";*/
				
				if(!preinvoice.equals(linePos[4] + datedoc)){
					preinvoice = linePos[4] + datedoc;
					isFirst = true;
					
					tasa = DB.getSQLValueBD(null,"SELECT cr.MultiplyRate FROM C_Conversion_Rate cr "
				    		   +"WHERE cr.C_Currency_ID = "+linePos[11]+" AND cr.C_Currency_ID_To=205 AND '"+datedoc+"' BETWEEN cr.ValidFrom and cr.ValidTo");//mcontreras
					
					if(tasa == null || tasa.toString().length() == 0)
					{
						tasa = new BigDecimal(0);
					}
				}
				
				
				if(linePos[0].equals("Y")){
					if(isFirst){
						createHeaderG(linePos); //Crea Cabecera Global
						createHeader(linePos);  //Crea Cabecera (Original)
						isFirst = false;
					}
					createLineG(linePos);  //Crea Línea Global
					createLine(linePos);   //Crea Línea (Original)
					
				}
				else{
					if(isFirst){
						createHeader(linePos);  //Crea Cabecera de Ajuste/Recalculo
						isFirst = false;
					}
					createLine(linePos);    //Crea Línea de Ajuste/Recalculo
					
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
	 * Create Header Global
	 * @param linePos
	 */
	private void createHeaderG(String[] linePos){
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		MCPreInvoiceG pinvG = new MCPreInvoiceG(Env.getCtx(), 0, null);
		pinvG.setAD_Org_ID(Integer.parseInt(linePos[1]));
		pinvG.setC_Contract_ID(Integer.parseInt(linePos[2]));
		pinvG.setC_DocType_ID(Integer.parseInt(linePos[3]));
		pinvG.setValue(linePos[4]);
		pinvG.setDateDoc(Timestamp.valueOf(datedoc));
		pinvG.setDateAcct(Timestamp.valueOf(datedoc));
		pinvG.setStartDate(Timestamp.valueOf(startdate));
		pinvG.setEndDate(Timestamp.valueOf(enddate));
		pinvG.setC_BPartner_ID(Integer.parseInt(linePos[8]));
		pinvG.setC_Municipality_ID(Integer.parseInt(linePos[9]));
		pinvG.setDescription(linePos[10]);
		pinvG.setC_Currency_ID(Integer.parseInt(linePos[11]));
		pinvG.setC_Activity_ID(Integer.parseInt(linePos[12]));
		pinvG.setDocStatus("DR"); // from IP to DR :: lhernandeza
		pinvG.setDocAction("CL");
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		pinvG.save();
		
		//pinvG.setDocStatus("IP"); // from IP to DR :: lhernandeza
		//pinvG.save();
		
		C_PreInvoiceG_ID = pinvG.getC_PreInvoiceG_ID();
		
	}
	
	/**
	 * Create Line Global
	 * @param linePos
	 */
	private void createLineG(String[] linePos){
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5] + " - " + linePos[13]);
		
		MCPreInvoiceLineG pinvlG = new MCPreInvoiceLineG(Env.getCtx(), 0, null);
		pinvlG.setAD_Org_ID(Integer.parseInt(linePos[1]));//mcontreras
		pinvlG.setC_PreInvoiceG_ID(C_PreInvoiceG_ID);     //Enlace con Cabecera Global
		log.warning(" ##### " + linePos[13] + " - " + linePos[14] + " - " + linePos[15] + " - " + linePos[16]+ " - " + linePos[17]);
		pinvlG.setC_ContractLine_ID(Integer.parseInt(linePos[13]));
		pinvlG.setC_Charge_ID(Integer.parseInt(linePos[14]));
		pinvlG.setQty(new BigDecimal(linePos[15]));
		pinvlG.setPrice_Usd(new BigDecimal(linePos[16]));
		pinvlG.setPrice_Pure(new BigDecimal(linePos[17]));
		pinvlG.setPrice(pinvlG.getPrice_Pure().add(pinvlG.getPrice_Usd().multiply(tasa)).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvlG.setLineNetAmt_Usd(pinvlG.getQty().multiply(pinvlG.getPrice_Usd()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvlG.setLineNetAmt_Pure(pinvlG.getQty().multiply(pinvlG.getPrice_Pure()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvlG.setLineNetAmt(pinvlG.getQty().multiply(pinvlG.getPrice()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5] + " - " + linePos[13]);
		
		pinvlG.save();
		
	}
	
	/**
	 * Create Header
	 * @param linePos
	 */
	private void createHeader(String[] linePos){
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		MCPreInvoice pinv = new MCPreInvoice(Env.getCtx(), 0, null);
		pinv.setC_PreInvoiceG_ID(C_PreInvoiceG_ID);  //Enlace con Cabecera Global
		pinv.setAD_Org_ID(Integer.parseInt(linePos[1]));
		pinv.setC_Contract_ID(Integer.parseInt(linePos[2]));
		pinv.setC_DocType_ID(Integer.parseInt(linePos[3]));
		pinv.setValue(linePos[4]);
		pinv.setDateDoc(Timestamp.valueOf(datedoc));
		pinv.setDateAcct(Timestamp.valueOf(datedoc));
		pinv.setStartDate(Timestamp.valueOf(startdate));
		pinv.setEndDate(Timestamp.valueOf(enddate));
		pinv.setC_BPartner_ID(Integer.parseInt(linePos[8]));
		pinv.setC_Municipality_ID(Integer.parseInt(linePos[9]));
		pinv.setDescription(linePos[10]);
		pinv.setC_Currency_ID(Integer.parseInt(linePos[11]));
		pinv.setC_Activity_ID(Integer.parseInt(linePos[12]));
		pinv.setDocStatus("CO");
		pinv.setDocAction("CL");
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5]);
		
		pinv.save();
		
		C_PreInvoiceG_ID = pinv.getC_PreInvoiceG_ID();
		C_PreInvoice_ID = pinv.getC_PreInvoice_ID();
		
	}
	
	/**
	 * Create Line
	 * @param linePos
	 */
	private void createLine(String[] linePos){
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5] + " - " + linePos[13]);
		
		MCPreInvoiceLine pinvl = new MCPreInvoiceLine(Env.getCtx(), 0, null);
		pinvl.setC_PreInvoiceG_ID(C_PreInvoiceG_ID);  //Enlace con Cabecera Global
		pinvl.setC_PreInvoice_ID(C_PreInvoice_ID);   //Enlace con Cabecera 2
		log.warning(" ##### " + linePos[13] + " - " + linePos[14] + " - " + linePos[15] + " - " + linePos[16]+ " - " + linePos[17]);
		pinvl.setC_ContractLine_ID(Integer.parseInt(linePos[13]));
		pinvl.setC_Charge_ID(Integer.parseInt(linePos[14]));
		pinvl.setQty(new BigDecimal(linePos[15]));
		pinvl.setPrice_Usd(new BigDecimal(linePos[16]));
		pinvl.setPrice_Pure(new BigDecimal(linePos[17]));
		pinvl.setPrice(pinvl.getPrice_Pure().add(pinvl.getPrice_Usd().multiply(tasa)).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvl.setLineNetAmt_Usd(pinvl.getQty().multiply(pinvl.getPrice_Usd()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvl.setLineNetAmt_Pure(pinvl.getQty().multiply(pinvl.getPrice_Pure()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvl.setLineNetAmt(pinvl.getQty().multiply(pinvl.getPrice()).setScale(3, BigDecimal.ROUND_HALF_UP));//mcontreras
		pinvl.setAD_Org_ID(Integer.parseInt(linePos[1]));//mcontreras
		
		//log.warning("  - - - - -- - -- - --  " + linePos[4] + " - " + linePos[5] + " - " + linePos[13]);
		
		pinvl.save();
		
	}
	
	private String putZeroDate(String date)
	{
		int temp = Integer.parseInt(date);
		
		if(temp < 10)
		{
			date = "0"+temp;
		}
		
		return date;
	}
	
	
}	//	LoadBankStatement
