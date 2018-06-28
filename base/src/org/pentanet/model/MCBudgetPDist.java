package org.pentanet.model;

import java.util.Properties;

public class MCBudgetPDist extends X_C_BudgetP_Dist {

	public MCBudgetPDist (Properties ctx, int C_BudgetP_Dist_ID, String trxName){
		super (ctx, C_BudgetP_Dist_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
	
}
