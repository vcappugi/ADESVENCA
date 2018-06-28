package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCPreInvoiceLineG extends X_C_PreInvoiceLineG{

	
	private MCWorkDDLine[] m_WorkDDlines;
	
	
	/**
	 * 	Preinvoice Line Constructor
	 * 	@param ctx context
	 * 	@param C_PreInvoiceLineG_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCPreInvoiceLineG(Properties ctx, int C_PreInvoiceLineG_ID, String trxName) {
		super (ctx, C_PreInvoiceLineG_ID, trxName);
	}

	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCPreInvoiceLineG (Properties ctx, ResultSet rs, String trxName)
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
		MCPreInvoiceG pinv = new MCPreInvoiceG(Env.getCtx(), getC_PreInvoiceG_ID(), get_TrxName());
		
		BigDecimal a = getPrice_Pure();
		//if(getPrice_Usd().signum()==0)
		//	return true;
				
		MClient client = new MClient(Env.getCtx(), getAD_Client_ID(), get_TrxName());
				
		BigDecimal price_conv = MConversionRate.convert (getCtx(),
				getPrice_Usd(), pinv.getC_Currency_ID(), client.getC_Currency_ID(),
				pinv.getDateAcct(), 0, getAD_Client_ID(), getAD_Org_ID());
		
		if(price_conv==null)
			price_conv = getPrice_Pure();
		else
			price_conv = price_conv.add(getPrice_Pure());
		
		//setPrice(price_conv);
		
		//Only while DocStatus is Draft
		if(pinv.getDocStatus().equals("DR")){
			//setLineNetAmt_Pure(getPrice_Pure().multiply(getQty()));
			//setLineNetAmt_Usd(getPrice_Usd().multiply(getQty()));
			//setLineNetAmt(price_conv.multiply(getQty()));
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
		
		String sql = "SELECT SUM(COALESCE(LineNetAmt)) FROM C_PreInvoiceLineG "
				+ " WHERE C_PreInvoiceG_ID = " + getC_PreInvoiceG_ID() 
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLineG_ID = " + getC_PreInvoiceLineG_ID();
			
		String sql_pure = "SELECT SUM(COALESCE(LineNetAmt_Pure)) FROM C_PreInvoiceLineG "
				+ " WHERE C_PreInvoiceG_ID = " + getC_PreInvoiceG_ID()
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLineG_ID = " + getC_PreInvoiceLineG_ID();
			
		String sql_usd = "SELECT SUM(COALESCE(LineNetAmt_Usd)) FROM C_PreInvoiceLineG "
				+ " WHERE C_PreInvoiceG_ID = " + getC_PreInvoiceG_ID()
				+ " AND IsActive='Y' AND NOT C_PreInvoiceLineG_ID = " + getC_PreInvoiceLineG_ID();
			
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
			
		MCPreInvoiceG pInv = new MCPreInvoiceG(Env.getCtx(), getC_PreInvoiceG_ID(), null);
		pInv.setGrandTotal(grandTotal);
		pInv.setGrandTotal_Pure(grandTotal_Pure);
		pInv.setGrandTotal_Usd(grandTotal_Usd);
		pInv.save();	
		
		
		return true;
	}	//	afterSave
	
	
	
	public MCWorkDDLine[] getWorkDDLines(){
		
		if (m_WorkDDlines != null && m_WorkDDlines.length != 0) {
			set_TrxName(m_WorkDDlines, get_TrxName());
			return m_WorkDDlines;
		}
		
		//
		String sql = "SELECT * FROM C_WorkDDLine WHERE C_PreInvoiceLineG_ID = ?";
		ArrayList<MCWorkDDLine> list = new ArrayList<MCWorkDDLine>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			pstmt.setInt (1, getC_PreInvoiceLineG_ID());
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				MCWorkDDLine line = new MCWorkDDLine(getCtx(), rs, get_TrxName());
				list.add (line);
			}
		} 
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		//
		m_WorkDDlines = new MCWorkDDLine[list.size ()];
		list.toArray (m_WorkDDlines);
		return m_WorkDDlines;
	}

}
