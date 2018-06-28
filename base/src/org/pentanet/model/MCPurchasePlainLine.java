package org.pentanet.model;

import java.util.Properties;

public class MCPurchasePlainLine extends X_C_Purchase_Plain_Line {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MCPurchasePlainLine(Properties ctx, int C_Purchase_Plain_Line_ID,
			String trxName) {
		super(ctx, C_Purchase_Plain_Line_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	protected boolean afterSave (boolean newRecord, boolean success) {
		return true;
	}
	protected boolean afterDelete (boolean success)
	{
		return true;
	}
}
