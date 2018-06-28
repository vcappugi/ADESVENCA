package org.pentanet.model;

import java.util.Properties;

public class MCBudgetRelation extends X_C_Budget_Relation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MCBudgetRelation (Properties ctx, int M_Patient_ID, String trxName){
		super (ctx, M_Patient_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
}
