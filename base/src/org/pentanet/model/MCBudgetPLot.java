package org.pentanet.model;

import java.util.Properties;

public class MCBudgetPLot extends X_C_BudgetP_Lot {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MCBudgetPLot (Properties ctx, int M_Patient_ID, String trxName){
		super (ctx, M_Patient_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	
	{
	    
		return true;
		
	}
}
