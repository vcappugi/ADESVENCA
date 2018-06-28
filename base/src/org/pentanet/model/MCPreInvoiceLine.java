package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCPreInvoiceLine extends X_C_PreInvoiceLine {

	/**
	 * 	Preinvoice Line Constructor
	 * 	@param ctx context
	 * 	@param C_PreInvoiceLineG_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCPreInvoiceLine(Properties ctx, int C_PreInvoiceLine_ID, String trxName) {
		super (ctx, C_PreInvoiceLine_ID, trxName);
	}

	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCPreInvoiceLine (Properties ctx, ResultSet rs, String trxName)
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

		//if(getPrice_Usd().signum()==0)
		//	return true;
				
		MClient client = new MClient(Env.getCtx(), getAD_Client_ID(), get_TrxName());
				
		MCPreInvoiceG pinv = new MCPreInvoiceG(getCtx(), getC_PreInvoiceG_ID(), get_TrxName());
				
		BigDecimal price_conv = MConversionRate.convert (getCtx(),
				getPrice_Usd(), pinv.getC_Currency_ID(), client.getC_Currency_ID(),
				pinv.getDateAcct(), 0, getAD_Client_ID(), getAD_Org_ID());
			
		if(price_conv==null)
			price_conv = getPrice_Pure();
		else
			price_conv = price_conv.add(getPrice_Pure());
		
		//setPrice(price_conv);
		
		//setLineNetAmt_Pure(getPrice_Pure().multiply(getQty()));
		//setLineNetAmt_Usd(getPrice_Usd().multiply(getQty()));
		//setLineNetAmt(price_conv.multiply(getQty()));
		
		
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
		
		String sql = "SELECT SUM(COALESCE(LineNetAmt)) FROM C_PreInvoiceLine "
				+ " WHERE C_PreInvoice_ID = " + getC_PreInvoice_ID()
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLine_ID = " + getC_PreInvoiceLine_ID();
			
		String sql_pure = "SELECT SUM(COALESCE(LineNetAmt_Pure)) FROM C_PreInvoiceLine "
				+ " WHERE C_PreInvoice_ID = " + getC_PreInvoice_ID()
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLine_ID = " + getC_PreInvoiceLine_ID();
			
		String sql_usd = "SELECT SUM(COALESCE(LineNetAmt_Usd)) FROM C_PreInvoiceLine "
				+ " WHERE C_PreInvoice_ID = " + getC_PreInvoice_ID()
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLine_ID = " + getC_PreInvoiceLine_ID();
			
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
			
		MCPreInvoice pInv = new MCPreInvoice(Env.getCtx(), getC_PreInvoice_ID(), null);
		pInv.setGrandTotal(grandTotal);
		pInv.setGrandTotal_Pure(grandTotal_Pure);
		pInv.setGrandTotal_Usd(grandTotal_Usd);
		pInv.save();	
		
		
		return true;
	}	//	afterSave
	
}
