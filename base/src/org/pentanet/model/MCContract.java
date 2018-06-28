package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.DB;


public class MCContract extends X_C_Contract {

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
	public MCContract(Properties ctx, int C_Contract_ID, String trxName) {
		super (ctx, C_Contract_ID, trxName);
	}

	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MCContract (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	


	/**
	 * 
	 * @param dateEnd
	 * @return
	 */
	public Timestamp calculateDateFinish(Timestamp dateEnd){
		
		Timestamp dateNew = null;
		
		BigDecimal ejecDays = getDiffDate(getDateStart(), getDateFinish()); 
				
		BigDecimal penDays = getNetDays().add(getParalDays()).subtract(ejecDays);
		
		String sql = "SELECT adddays_ts('" + dateEnd + "', " + penDays + ")"; 
		
		dateNew = DB.getSQLValueTS(get_TrxName(), sql);
		
		return dateNew;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public BigDecimal getDiffDate(Timestamp date1, Timestamp date2){
		
		BigDecimal difDays = DB.getSQLValueBD(get_TrxName(), 
						"SELECT DiffDate('" + date2 + "','" + date1 + "')::numeric");
		
		return difDays;
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
			+ "' WHERE C_Contract_ID=" + getC_Contract_ID();
		int noLine = DB.executeUpdate("UPDATE C_ContractLine " + set, get_TrxName());
		
		log.fine(processed + " - Lines=" + noLine);
	}	//	setProcessed
	
}

