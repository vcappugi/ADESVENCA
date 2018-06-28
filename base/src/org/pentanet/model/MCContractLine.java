package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.util.DB;
import org.compiere.util.Env;


public class MCContractLine extends X_C_ContractLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3575451914372472138L;


	/**
	 * 	Contract Constructor
	 * 	@param ctx context
	 * 	@param C_PreInvoiceLineG_ID invoice line or 0
	 * 	@param trxName transaction name
	 */
	public MCContractLine(Properties ctx, int C_ContractLine_ID, String trxName) {
		super (ctx, C_ContractLine_ID, trxName);
	}

	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCContractLine (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	

	@Override
	protected boolean beforeSave(boolean newRecord) {
				
		MClient client = new MClient(Env.getCtx(), getAD_Client_ID(), get_TrxName());
				
		MCContract cont = new MCContract(getCtx(), getC_Contract_ID(), get_TrxName());
			
		//	Get Rate
		BigDecimal rate = MConversionRate.getRate(cont.getC_Currency_ID(), client.getC_Currency_ID(),
				cont.getDateDoc(), 0, getAD_Client_ID(), getAD_Org_ID());
			
		BigDecimal price_conv = getPrice_Usd().multiply(rate).setScale(4, BigDecimal.ROUND_HALF_UP);
		
		if(price_conv==null)
			price_conv = getPrice_Pure();
		else
			price_conv = price_conv.add(getPrice_Pure());
		
		setPrice(price_conv);
		
		setLineNetAmt_Pure(getPrice_Pure().multiply(getQty()));
		setLineNetAmt_Usd(getPrice_Usd().multiply(getQty()));
		setLineNetAmt(price_conv.multiply(getQty()));
		
		return true;
	}
	
	/**
	 * 	Set Processed.
	 * 	Propergate to Lines
	 *	@param processed processed
	 */
	public void setProcessed (boolean processed)
	{
		super.setProcessed (processed);
		if (get_ID() == 0)
			return;
		String set = "SET Processed='"
			+ (processed ? "Y" : "N")
			+ "' WHERE C_ContractLine_ID=" + getC_ContractLine_ID();
		int noLine = DB.executeUpdate("UPDATE C_ContractLine_Acct " + set, get_TrxName());
		
		log.fine(processed + " - Lines=" + noLine);
	}	//	setProcessed
	
}

