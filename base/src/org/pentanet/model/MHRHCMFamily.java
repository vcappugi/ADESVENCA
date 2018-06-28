package org.pentanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.util.Msg;


public class MHRHCMFamily extends X_HR_HCMFamily {

	public MHRHCMFamily(Properties ctx, int HR_HCMFamily_ID, String trxName) {
		super(ctx, HR_HCMFamily_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MHRHCMFamily (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MHRHCMFamily
	
	protected boolean beforeSave (boolean newRecord)
	{
		if(getHR_HCMFamily_ID() <= 0)
		{
			String sql = "SELECT  parentesco,(diffdate(now(),birthday)/365) :: numeric(10,0) FROM HR_Family where HR_Family_ID = " + getHR_Family_ID();
		    //ADialog.info(0 , null,"La cuenta Debe "+ sql);  
		    
		    MHRHCMRequest Req = new MHRHCMRequest(getCtx(),getHR_HCMRequest_ID() , get_TrxName() );
		    
		    CPreparedStatement pstmt = DB.prepareStatement(sql, null);
		    ResultSet rs;
			try {
				rs = pstmt.executeQuery ();

		    while (rs.next ())
		    {
		         String sqlr ="SELECT amount :: numeric(10,2) FROM HR_HCMTab t " +
		                   "INNER JOIN HR_HCMTabLine tl ON tl.HR_HCMTab_id = t.HR_HCMTab_id " +
		                   "INNER JOIN HR_HCMTabVersion tv ON tv.HR_HCMTabVersion_id = tl.HR_HCMTabVersion_id " +
		                   "where ("+rs.getInt(2)+" BETWEEN age_from AND age_to) AND ('"+ Req.getDateDoc() +"' BETWEEN tv.validfrom AND tv.validto) " +
		                "AND (CASE '"+rs.getString(1)+"' WHEN 'Hno' THEN (CASE WHEN isbrother = 'Y' THEN 1 ELSE 0 END) WHEN 'HO' THEN " + 
		                "(CASE WHEN isson = 'Y' THEN 1 ELSE 0 END) ELSE (CASE WHEN isson = 'N' AND isbrother = 'N' THEN 1 ELSE 0 END) " +
		                "END) =1";
		        //ADialog.info(0 , null,"La cuenta Debe "+ sqlr); 
		         setRate(DB.getSQLValueBD(null,sqlr));
		        
		    }
		    String m_processMsg = "OOOOOOOOK";
		    pstmt.close();
		    rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		}
		return true;
	}	//	beforeDelete

}