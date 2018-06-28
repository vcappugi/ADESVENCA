package org.pentanet.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MRMailTextVar extends X_R_MailTextVar{

	private static final long serialVersionUID = 201402110001L;
	
	public MRMailTextVar (Properties ctx, int HR_VacationRequisition_ID, String trxName)
	{
		super (ctx, HR_VacationRequisition_ID, trxName);

	}
	
	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 */
	public MRMailTextVar (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	
	

}
