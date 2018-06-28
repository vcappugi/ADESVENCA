/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.pentanet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.I_AD_Table;
import org.compiere.model.MTable;
import org.compiere.util.CCache;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

/**
 *	Persistent Column Model
 *	
 *  @author Jorg Janke
 *  @version $Id: MColumn.java,v 1.6 2006/08/09 05:23:49 jjanke Exp $
 */
public class MMONITORLINE extends X_MONITORLINE
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954312267794622096L;

	/**
	 * 	Get MColumn from Cache
	 *	@param ctx context
	 * 	@param AD_Column_ID id
	 *	@return MColumn
	 */
	public static MMONITORLINE get (Properties ctx, int AD_Column_ID)
	{
		Integer key = new Integer (AD_Column_ID);
		MMONITORLINE retValue = (MMONITORLINE) s_cache.get (key);
		if (retValue != null)
			return retValue;
		retValue = new MMONITORLINE (ctx, AD_Column_ID, null);
		if (retValue.get_ID () != 0)
			s_cache.put (key, retValue);
		return retValue;
	}	//	get

	/**
	 * 	Get Column Name
	 *	@param ctx context
	 *	@param AD_Column_ID id
	 *	@return Column Name or null
	 */
	public static String getColumnName (Properties ctx, int AD_Column_ID)
	{
		MMONITORLINE col = MMONITORLINE.get(ctx, AD_Column_ID);
		if (col.get_ID() == 0)
			return null;
		return col.get_ColumnName(0);
	}	//	getColumnName
	
	/**	Cache						*/
	private static CCache<Integer,MMONITORLINE>	s_cache	= new CCache<Integer,MMONITORLINE>("AD_Column", 20);
	
	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (MMONITORLINE.class);
	
	/**************************************************************************
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param AD_Column_ID
	 *	@param trxName transaction
	 */
	public MMONITORLINE (Properties ctx, int AD_Column_ID, String trxName)
	{
		super (ctx, AD_Column_ID, trxName);
		if (AD_Column_ID == 0)
		{
		//	setAD_Element_ID (0);
		//	setAD_Reference_ID (0);
		//	setColumnName (null);
		//	setName (null);
		//	setEntityType (null);	// U
		}
	}	//	MColumn

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MMONITORLINE (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MColumn
	

	
	
	/**
	 * 	Before Save
	 *	@param newRecord new
	 *	@return true
	 */
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
	}	//	beforeSave

	
	
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return success
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		//	Update Fields
		return success;
	}	//	afterSave
	
	
	/**
	* Get Table Id for a column
	* @param ctx context
	* @param AD_Column_ID id
	* @param trxName transaction
	* @return MColumn
	*/
	public static int getTable_ID(Properties ctx, int AD_Column_ID, String trxName)
	{
		String sqlStmt = "SELECT AD_Table_ID FROM AD_Column WHERE AD_Column_ID=?";
		return DB.getSQLValue(trxName, sqlStmt, AD_Column_ID);
	}
	
}	//	MColumn
