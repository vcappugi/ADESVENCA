
package org.compiere.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.util.CCache;
import org.compiere.util.CLogger;
import org.compiere.util.DB;


public class Mcurrentpos extends X_c_currentpos
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3459010882027283811L;
	private static CLogger	s_log	= CLogger.getCLogger (Mcurrentpos.class);


	public static Mcurrentpos get (Properties ctx, int c_currentpos_ID)
	{
		Integer key = new Integer (c_currentpos_ID);
		Mcurrentpos retValue = (Mcurrentpos)s_cache.get (key);
		if (retValue != null)
			return retValue;
		retValue = new Mcurrentpos (ctx, c_currentpos_ID, null);
		if (retValue.get_ID() != 0)
			s_cache.put (key, retValue);
		return retValue;
	} //	get

	/**	Cache						*/
	private static CCache<Integer,Mcurrentpos> s_cache = 
		new CCache<Integer,Mcurrentpos> ("c_currentpos", 3);
	
	
	/**************************************************************************
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param C_Bank_ID bank
	 *	@param trxName trx
	 */
	public Mcurrentpos (Properties ctx, int c_currentpos_ID, String trxName)
	{
		super (ctx, c_currentpos_ID, trxName);
	}	

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName trx
	 */
	public Mcurrentpos (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
	}	

	/**
	 * 	String Representation
	 *	@return info
	 */
	public String toString ()
	{
		return "";
	}	//	toString

	/**************************************************************************
	 * 	Before Save
	 *	@param newRecord new
	 *	@return save
	 */
	protected boolean beforeSave (boolean newRecord)
	{

		return true;
	}	//	beforeSave	
	
	public static Mcurrentpos[] find (Properties ctx, 
			int  m_pos_id)
		{
			StringBuffer sql = new StringBuffer ("SELECT * FROM c_currentpos WHERE IsActive='Y' and docstatus='DR' and c_pos_id=?");
			String finalSQL = MRole.getDefault().addAccessSQL(sql.toString(), 
					"c_currentpos", MRole.SQL_NOTQUALIFIED, MRole.SQL_RO);
				ArrayList<Mcurrentpos> list = new ArrayList<Mcurrentpos>();
				PreparedStatement pstmt = null;
				try
				{
					pstmt = DB.prepareStatement(finalSQL, null);
					pstmt.setInt(1, m_pos_id);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next())
						list.add(new Mcurrentpos (ctx, rs, null));
					rs.close();
					pstmt.close();
					pstmt = null;
				}
				catch (Exception e)
				{
					s_log.log(Level.SEVERE, "find - " + finalSQL, e);
				}
				try
				{
					if (pstmt != null)
						pstmt.close();
					pstmt = null;
				}
				catch (Exception e)
				{
					pstmt = null;
				}
				//	Return
				Mcurrentpos[] retValue = new Mcurrentpos[list.size()];
				list.toArray(retValue);
				return retValue;
			}	//	find
			
	
	
}