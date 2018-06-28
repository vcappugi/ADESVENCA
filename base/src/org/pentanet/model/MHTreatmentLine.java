package org.pentanet.model;

import java.util.Properties;

public class MHTreatmentLine extends X_H_TreatmentLine {

	public MHTreatmentLine(Properties ctx, int M_Patient_ID, String trxName)
	{
		super (ctx, M_Patient_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
}