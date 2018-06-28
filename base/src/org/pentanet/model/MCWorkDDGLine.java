package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCWorkDDGLine extends X_C_WorkDDGLine{

	/**
	 * 	Preinvoice Line Constructor
	 * 	@param ctx context
	 * 	@param C_PreInvoiceLineG_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCWorkDDGLine(Properties ctx, int C_WorkDDGLine_ID, String trxName) {
		super (ctx, C_WorkDDGLine_ID, trxName);
	}

	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCWorkDDGLine (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	

	
	/**************************************************************************
	 * 	Before Save
	 *	@param newRecord new
	 *	@return true
	 */
	protected boolean beforeSave (boolean newRecord)
	{
		MCWorkDDG wdd = new MCWorkDDG(Env.getCtx(), getC_WorkDDG_ID(), get_TrxName());
		
		if(getPrice_Usd().equals(new BigDecimal(0)))
			return true;
				
		MClient client = new MClient(Env.getCtx(), getAD_Client_ID(), get_TrxName());
				
		BigDecimal price_conv = MConversionRate.convert (getCtx(),
				getPrice_Usd(), wdd.getC_Currency_ID(), client.getC_Currency_ID(),
				wdd.getDateAcct(), 0, getAD_Client_ID(), getAD_Org_ID());
		
        String sql = "SELECT COALESCE(("
        		+ " SELECT (CASE WHEN wgl.percent > 0 THEN ((CASE WHEN wgl.percent > 0  THEN wgl.percent/100 ELSE 1 END) * " +
                " SUM((CASE WHEN IsReducedRate = 'Y'  AND (Now() :: date between Startdate and Enddate) AND CondType = 'TR' THEN wgl.reducedrate ELSE 0 END) :: numeric(100,2) + " +
                " (CASE WHEN IsMove = 'Y'  AND (Now() :: date between Startdate and Enddate) AND CondType = 'M' THEN wgl.moverate ELSE 0 END)) " +
                " ) ELSE 0 END) :: numeric(100,2) percent FROM C_WorkDDGline wgl " +
                " LEFT JOIN C_WorkDD_Cond wc ON wc.C_WorkDDG_id = wgl.C_WorkDDG_id " +
                " WHERE wgl.C_WorkDDG_id = "+ getC_WorkDDG_ID() +"  AND wgl.C_WorkDDGline_ID = " + getC_WorkDDGLine_ID() + " GROUP BY wgl.C_ContractLine_ID, wgl.percent"
                		+ " ),0)";
            //ADialog.info(0, null,"Documento creado  "+ sql);

            BigDecimal percent = DB.getSQLValueBD(null,sql);
            percent = percent.signum() == 0 ? new BigDecimal(1) : percent.divide(new BigDecimal(100));
			
		//setPrice(price_conv.add(getPrice_Pure()));
		
		
		//Only while DocStatus is Draft
		if(wdd.getDocStatus().equals("DR")){
			//setLineNetAmt_Pure(getPrice_Pure().multiply(getQty()).multiply(percent));
			//setLineNetAmt_Usd(getPrice_Usd().multiply(getQty()).multiply(percent));
			//setLineNetAmt(getPrice().multiply(getQty()).multiply(percent));
		}
		
		return true;
	}
	
	
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return saved
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		if (!success)
			return success;
		
		String sql = "SELECT SUM(COALESCE(LineNetAmt,0)) + (SELECT COALESCE(SUM(COALESCE(grandtotal,0)),0) FROM c_workdd WHERE C_WorkDDG_ID = "+getC_WorkDDG_ID()+") FROM C_WorkDDGLine"
				+ " WHERE C_WorkDDG_ID = " + getC_WorkDDG_ID() 
				+ " AND IsActive='Y' AND NOT C_WorkDDGLine_ID = " + getC_WorkDDGLine_ID();
			
		String sql_pure = "SELECT SUM(COALESCE(LineNetAmt_Pure,0)) + (SELECT COALESCE(SUM(COALESCE(grandtotal_pure,0)),0) FROM c_workdd WHERE C_WorkDDG_ID = "+getC_WorkDDG_ID()+") FROM C_WorkDDGLine"
				+ " WHERE C_WorkDDG_ID = " + getC_WorkDDG_ID()
				+ " AND IsActive='Y' AND NOT C_WorkDDGLine_ID = " + getC_WorkDDGLine_ID();
			
		String sql_usd = "SELECT SUM(COALESCE(LineNetAmt_Usd,0)) + (SELECT COALESCE(SUM(COALESCE(grandtotal_usd,0)),0) FROM c_workdd WHERE C_WorkDDG_ID = "+getC_WorkDDG_ID()+") FROM C_WorkDDGLine"
				+ " WHERE C_WorkDDG_ID = " + getC_WorkDDG_ID()
				+ " AND IsActive='Y' AND NOT C_WorkDDGLine_ID = " + getC_WorkDDGLine_ID();
			
		BigDecimal grandTotal = DB.getSQLValueBD(null, sql);
		BigDecimal grandTotal_Pure = DB.getSQLValueBD(null, sql_pure);
		BigDecimal grandTotal_Usd = DB.getSQLValueBD(null, sql_usd);
			
		if(grandTotal==null)
			grandTotal = new BigDecimal(0);
			
		if(grandTotal_Pure==null)
			grandTotal_Pure = new BigDecimal(0);
			
		if(grandTotal_Usd==null)
			grandTotal_Usd = new BigDecimal(0);
			
		if(isActive()){
			grandTotal = grandTotal.add(getLineNetAmt());
			grandTotal_Pure = grandTotal_Pure.add(getLineNetAmt_Pure());
			grandTotal_Usd = grandTotal_Usd.add(getLineNetAmt_Usd());
		}
			
		MCWorkDDG wdd = new MCWorkDDG(Env.getCtx(), getC_WorkDDG_ID(), null);
		wdd.setGrandTotal(grandTotal);
		wdd.setGrandTotal_Pure(grandTotal_Pure);
		wdd.setGrandTotal_Usd(grandTotal_Usd);
		wdd.save();	
		
		
		return true;
	}	//	afterSave
	
}
