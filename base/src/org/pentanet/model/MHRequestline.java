package org.pentanet.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.Env;

public class MHRequestline extends X_H_Request_line {

	public MHRequestline(Properties ctx, int H_Request_line_ID, String trxName) {
		super(ctx, H_Request_line_ID, trxName);
		// TODO Auto-generated constructor stub
		
	}
	
	public MHRequestline (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MPayment

}
