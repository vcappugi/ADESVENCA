package org.pentanet.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MMAdjustment extends X_M_Adjustment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MMAdjustment(Properties ctx, int M_Adjustment_ID, String trxName) {
		super(ctx, M_Adjustment_ID, trxName);
		// TODO Auto-generated constructor stub
		
	}
	
	public MMAdjustment (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MPayment

	
	/**
	 * 	Set Processed.
	 * 	Propagate to Lines
	 *	@param processed processed
	 */
	public void setProcessed (boolean processed)
	{
		super.setProcessed (processed);
		if (get_ID() == 0)
			return;
		String set = "SET Processed='"
			+ (processed ? "Y" : "N")
			+ "' WHERE M_Adjustment_ID=" + getM_Adjustment_ID();
		int noLine = DB.executeUpdateEx("UPDATE M_AdjustmentLine " + set, get_TrxName());

		log.fine("setProcessed - " + processed + " - Lines=" + noLine);
	}	//	setProcessed
	
}
