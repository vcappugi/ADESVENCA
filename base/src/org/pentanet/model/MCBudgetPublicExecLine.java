package org.pentanet.model;

import java.util.Properties;

public class MCBudgetPublicExecLine extends X_C_BudgetPublic_Exec_Line {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MCBudgetPublicExecLine(Properties ctx, int C_BudgetPublic_Exec_ID, String trxName)
	{
		super (ctx, C_BudgetPublic_Exec_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
	
		return true;
		
	}
}
