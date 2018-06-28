package org.pentanet.model;
import java.util.Properties;

public class MHTreatment extends X_H_Treatment {

	public MHTreatment(Properties ctx, int M_Patient_ID, String trxName)
	{
		super (ctx, M_Patient_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
	
	
}