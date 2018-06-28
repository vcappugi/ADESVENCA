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
package org.compiere.model;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Properties;

import org.compiere.util.CCache;
import org.compiere.util.CLogger;



/**
 *	Cash Book Model
 *	
 *  @author Jorg Janke
 *  @version $Id: MCashBook.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 *  @author red1 - FR: [ 2214883 ] Remove SQL code and Replace for Query
 */
public class Mcamas extends X_c_camas
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4602423783184037174L;

	/**
	 * 	Get MCashBook from Cache
	 *	@param ctx context
	 *	@param C_CashBook_ID id
	 *	@return MCashBook
	 */
	public static Mcamas get (Properties ctx, int C_CashBook_ID)
	{
		return get(ctx, C_CashBook_ID, null);
	}	//	get
	
	/**
	 * Gets MCashBook from Cache under transaction scope
	 * @param ctx 				context	
	 * @param C_CashBook_ID		id of cashbook to load
	 * @param trxName			transaction name
	 * @return   Cashbook
	 */
	public static Mcamas get(Properties ctx, int C_CashBook_ID, String trxName)
	{
		Integer key = new Integer (C_CashBook_ID);
		Mcamas retValue = (Mcamas) s_cache.get (key);
		if (retValue != null)
			return retValue;
		retValue = new Mcamas (ctx, C_CashBook_ID, trxName);
		if (retValue.get_ID () != 0)
			s_cache.put (key, retValue);
		return retValue;
	}	//	get

	/**	Cache						*/
	private static CCache<Integer,Mcamas> s_cache
		= new CCache<Integer,Mcamas>("", 20);
	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (Mcamas.class);
	
	/**************************************************************************
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param C_CashBook_ID id
	 *	@param trxName transaction
	 */
	public Mcamas (Properties ctx, int C_CashBook_ID, String trxName)
	{
		super (ctx, C_CashBook_ID, trxName);
	}	//	MCashBook

	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return success
	 */
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		if (newRecord && success)
			insert_Accounting("C_CashBook_Acct", "C_AcctSchema_Default", null);

		return success;
	}	//	afterSave

	/**
	 * 	Before Delete
	 *	@return true
	 */
	protected boolean beforeDelete ()
	{
		return delete_Accounting("C_Cashbook_Acct"); 
	}	//	beforeDelete

}	//	MCashBook
