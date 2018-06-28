package org.compiere.report;

import org.compiere.process.ProcessInfo;
import org.compiere.process.SvrProcess;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.EMail;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.compiere.model.MClient;
import org.compiere.model.MPInstancePara;
import org.compiere.model.MProcess;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.compiere.process.ProcessInfo;
import org.compiere.report.ReportStarter;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MPInstancePara;
import org.compiere.report.*;

import java.io.File;

@SuppressWarnings("unused")
public class NewEmailPDF extends SvrProcess{
	
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {

		// TODO Auto-generated method stub
		return "";
	}
	
	private String m_receipt = null;
	
	/*****************************************************************************
	 * Creacion y Envio de mensaje SIN Adjunto
	 ******************************************************************************/
	public String sendEmail(String from, String to, String tittle, String subtittle, String body){
		
		MClient cliente = new MClient(Env.getCtx(),Env.getContextAsInt(Env.getCtx(), "AD_Client_ID"),null);
		
		String sql ="SELECT url_image FROM AD_Client WHERE AD_Client_ID="+cliente.getAD_Client_ID();
		String url_img=DB.getSQLValueString(null, sql);
		
		//Crear mensaje HTML
		String mensaje = message(subtittle, body, url_img);
		
		//Si from es nulo
		if(from==null)
		{
			from = cliente.getRequestUser();
		}
		
		EMail correo = new EMail(Env.getCtx(),cliente.getSMTPHost(),from,to,tittle,mensaje,true);
		if(m_receipt!=null)
		{
			correo.setReceipt(m_receipt);
		}
		correo.send();
		
		return "Mensaje Enviado . . . ";
	} 
	
	/*
	 * Without FROM
	 */
	public String sendEmail(String to, String tittle, String subtittle, String body){
		
		return sendEmail(null,to,tittle,subtittle, body);
		
	}
	
	/*
	 * Without FROM and SUBTITTLE
	 */
	public String sendEmail(String to, String tittle, String body){
		
		return sendEmail(null, to,tittle,null, body);
		
	}
	
	/*****************************************************************************
	 * Creacion y Envio de mensaje CON Adjunto
	 * dataE (from, to, tittle, subtittle, body)
	 ******************************************************************************/
	public String sendEmail(String[] dataE, int AD_Process_ID, Object[] params, int Record_ID){
				
		MClient cliente = new MClient(Env.getCtx(),Env.getContextAsInt(Env.getCtx(), "AD_Client_ID"),null);
		
		String sql = "SELECT url_image FROM AD_Client WHERE AD_Client_ID="+cliente.getAD_Client_ID();
		String url_img=DB.getSQLValueString(null, sql);
		
		//Crear mensaje HTML
		String mensaje = message(dataE[3], dataE[4], url_img);
		
		//Si from es nulo
		if(dataE[0]==null)
		{
			dataE[0] = cliente.getRequestUser();
		}
		
		//Crear Adjunto
		File att = attachment(AD_Process_ID, params, Record_ID);
		
		EMail correo = new EMail(Env.getCtx(),cliente.getSMTPHost(),dataE[0],dataE[1],dataE[2],mensaje,true);
		if(m_receipt!=null)
		{
			correo.setReceipt(m_receipt);
		}
		correo.addAttachment(att);
		correo.send();
		
		return "Mensaje Enviado . . . ";
	}
	
	
	/*
	 * Create Attachment
	 */
	public File attachment(int AD_Process_ID, Object[] params, int Record_ID)
	{
		//Instancio el proceso
		MProcess pro = new MProcess(Env.getCtx(), AD_Process_ID, null);
		MPInstance inst = new MPInstance (pro, 0);
		
		String sql = "SELECT seqNo FROM AD_PInstance_Para WHERE AD_PInstance_ID="+inst.getAD_PInstance_ID();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			try
			{
				pstmt = DB.prepareStatement(sql, null);
				rs = pstmt.executeQuery();
				int i=0;
				while(rs.next())
				{
					uptadeParameter(inst.getAD_PInstance_ID(), rs.getInt(1), params[i]);
					i++;
				}	
			}
			finally
			{
				pstmt.close();
				rs.close();
			}
		}catch(Exception e){
			log.info(e.toString());
			return null;
		}

		ProcessInfo pi = new ProcessInfo("Reporte", AD_Process_ID, 0, Record_ID); 
		pi.setAD_PInstance_ID(inst.getAD_PInstance_ID());
		pi.setPrintPreview(false);
		pi.setClassName("org.compiere.report.ReportStarter");
		pi.setIsBatch(true);
		
		ReportStarter report = new ReportStarter();
		report.startProcess(Env.getCtx(), pi, null);

		return pi.getPDFReport();
	}
	
	/*
	 * Update Parameters
	 */
	public boolean uptadeParameter(int AD_Instance_ID, int seqNo, Object value)
	{
		String par;
		String sql = "UPDATE AD_PInstance_Para SET ";
		String whereCl = " WHERE AD_PInstance_ID="+AD_Instance_ID+" AND seqNo="+seqNo;
		
		if(value == null)
		{
			return true;
		}
		else if (value instanceof BigDecimal)
		{
			par = "P_Number="+(BigDecimal)value;
		}
		else if (value instanceof Integer)
		{
			par = "P_Number="+(Integer)value;
		}
		else if (value instanceof Timestamp)
		{
			par = "P_Date="+(Timestamp)value;
		}
		else if (value instanceof Boolean)
		{
			par = "P_String="+ value.toString();
		}
		else
		{
			par = "P_String="+ value.toString();
		}

		sql = sql + par + whereCl;
		DB.executeUpdate(sql, null);
		
		return true;
	}
	
	/**
	 *  Receipt to send EMail
	 *  @return email receipt
	 */
	public String setReceipt(String receipt)
	{
		m_receipt = receipt;
		return m_receipt;
	}
	
	/*****************************************************************************
	 * Creacion del cuerpo del mensaje a ser enviado
	 ******************************************************************************/
	public String message(String subtittle, String body, String url_img){
		String mensaje="";
		
		
		mensaje = "<!-- HTML correo desde ADempiere Esvenca -->"+
				"<BODY><meta charset=\"UNICODE\" />"+
		"<img src=\""+url_img+"\""+
		"alt=\"\" width=\"220\" height=\"74\">";
				
		if(subtittle!=null)
				mensaje=mensaje+"<H4>"+subtittle+"</H4>";
		
		mensaje=mensaje+"<p> "+body;
		
		return mensaje;
	} 
	
	
}



