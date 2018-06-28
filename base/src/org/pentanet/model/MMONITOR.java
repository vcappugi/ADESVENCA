package org.pentanet.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MGoal;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.util.CCache;
import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 * 	Bank Model
 *	
 *  @author Jorg Janke
 *  @version $Id: MBank.java,v 1.2 2006/07/30 00:51:05 jjanke Exp $
 */
public class MMONITOR extends X_MONITOR
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3459010882027283811L;


	/**
	 * 	Get MBank from Cache
	 *	@param ctx context
	 *	@param C_Bank_ID id
	 *	@return MBank
	 */
	public static MMONITOR get (Properties ctx, int C_Bank_ID)
	{
		Integer key = new Integer (C_Bank_ID);
		MMONITOR retValue = (MMONITOR)s_cache.get (key);
		if (retValue != null)
			return retValue;
		retValue = new MMONITOR (ctx, C_Bank_ID, null);
		if (retValue.get_ID() != 0)
			s_cache.put (key, retValue);
		return retValue;
	} //	get

	/**	Cache						*/
	private static CCache<Integer,MMONITOR> s_cache = 
		new CCache<Integer,MMONITOR> ("C_Bank", 3);
	
	
	/**************************************************************************
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param C_Bank_ID bank
	 *	@param trxName trx
	 */
	public MMONITOR (Properties ctx, int C_Bank_ID, String trxName)
	{
		super (ctx, C_Bank_ID, trxName);
	}	//	MBank

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName trx
	 */
	public MMONITOR (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
	}	//	MBank

	/**
	 * 	Get Accessible Goals
	 *	@param ctx context
	 *	@return array of goals
	 */
	public static MMONITOR[] getGoals(Properties ctx)
	{
		ArrayList<MMONITOR> list = new ArrayList<MMONITOR>();
		String sql = "SELECT * FROM MONITOR WHERE IsActive='Y' AND (AD_ROLE_ID = " + MRole.getDefault().get_ID()+" OR AD_User_ID = " + MRole.getDefault().getAD_User_ID() +")"
			+ " ORDER BY MONITOR_ID";
		sql = MRole.getDefault(ctx, false).addAccessSQL(sql, "MONITOR", false, true);	//	RW to restrict Access
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		
		{
			pstmt = DB.prepareStatement (sql, null);
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				MMONITOR goal = new MMONITOR (ctx, rs, null);
				//goal.updateGoal(false);
				list.add (goal);
			}
		}
		catch (Exception e)
		{
		//	s_log.log (Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		MMONITOR[] retValue = new MMONITOR[list.size ()];
		list.toArray (retValue);
		return retValue;
	}	//	getGoals

	
	
	
	/**
	 * 	String Representation
	 *	@return info
	 */
	public String toString ()
	{
		StringBuffer sb = new StringBuffer ("MBank[");
		sb.append (get_ID ()).append ("-").append(getName ()).append ("]");
		return sb.toString ();
	}	//	toString
	
	/**************************************************************************
	 * 	Before Save
	 *	@param newRecord new
	 *	@return save
	 */
	protected boolean beforeSave (boolean newRecord)
	{
		//	Client/Org Check
		if (getAD_Org_ID() == 0)
		{
			int context_AD_Org_ID = Env.getAD_Org_ID(getCtx());
			if (context_AD_Org_ID != 0)
			{
				setAD_Org_ID(context_AD_Org_ID);
				log.warning("Changed Org to Context=" + context_AD_Org_ID);
			}
		}
		return true;
	}	//	beforeSave
	
	
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return true if can be saved
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		if (!success || newRecord)
		{			
			if(newRecord)
			{
				
			}			
			return success;
		}
		//	Propagate Description changes

	 	 			
		if (is_ValueChanged("name") || is_ValueChanged("value"))
		{
		}
		return true;
	}	//	afterSave
	
	/**
	 * 	Before Delete
	 *	@return true of it can be deleted
	 */
	protected boolean beforeDelete ()
	{
		return true;
	}	//	beforeDelete
		
	
}	
