package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MInOutLine;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCHesLine extends X_C_HesLine{

	/**************************************************************************
	 * 	Invoice Line Constructor
	 * 	@param ctx context
	 * 	@param C_InvoiceLine_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCHesLine (Properties ctx, int C_HesLine_ID, String trxName)
	{
		super (ctx, C_HesLine_ID, trxName);

		
	}	//	MHesLine

	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCHesLine (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MInvoiceLine
	
	
	
	/**
	 * 	Parent Constructor
	 * 	@param Hes
	*/
	public MCHesLine(MCHes hes)
	{
		this (hes.getCtx(), 0, hes.get_TrxName());
		setClientOrg(hes);
		setC_Hes_ID(hes.getC_Hes_ID());	
	}	//	MCHesLine
	
	
	/**************************************************************************
	 * 	Before Save
	 *	@param newRecord
	 *	@return true if save
	 */
	protected boolean beforeSave (boolean newRecord)
	{
		String sql = "SELECT SUM(LineNetAmt) FROM C_HesLine WHERE not C_HesLine_id="+getC_HesLine_ID()+" and C_Hes_ID=?";
		BigDecimal  ii = DB.getSQLValueBD (get_TrxName(), sql, getC_Hes_ID());
		
		if(ii == null)
			ii = new BigDecimal(0);
		
		ii = ii.add(getLineNetAmt());
		
		MCHes hes = new MCHes(getCtx(), getC_Hes_ID(), get_TrxName());
		hes.setGrandTotal(ii);
		hes.save();
		
		
		return true;
		
	}
}
