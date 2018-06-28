/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.pentanet.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for H_Budget
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Budget extends PO implements I_H_Budget, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120224L;

    /** Standard Constructor */
    public X_H_Budget (Properties ctx, int H_Budget_ID, String trxName)
    {
      super (ctx, H_Budget_ID, trxName);
      /** if (H_Budget_ID == 0)
        {
			setH_Budget_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Budget (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_H_Budget[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Create lines from.
		@param CreateFrom 
		Process which will generate a new document lines based on an existing document
	  */
	public void setCreateFrom (String CreateFrom)
	{
		set_Value (COLUMNNAME_CreateFrom, CreateFrom);
	}

	/** Get Create lines from.
		@return Process which will generate a new document lines based on an existing document
	  */
	public String getCreateFrom () 
	{
		return (String)get_Value(COLUMNNAME_CreateFrom);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set H_Budget.
		@param H_Budget_ID H_Budget	  */
	public void setH_Budget_ID (int H_Budget_ID)
	{
		if (H_Budget_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Budget_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Budget_ID, Integer.valueOf(H_Budget_ID));
	}

	/** Get H_Budget.
		@return H_Budget	  */
	public int getH_Budget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Budget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Diagnostic getH_Diagnostic() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Diagnostic)MTable.get(getCtx(), org.pentanet.model.I_H_Diagnostic.Table_Name)
			.getPO(getH_Diagnostic_ID(), get_TrxName());	}

	/** Set H_Diagnostic.
		@param H_Diagnostic_ID H_Diagnostic	  */
	public void setH_Diagnostic_ID (int H_Diagnostic_ID)
	{
		if (H_Diagnostic_ID < 1) 
			set_Value (COLUMNNAME_H_Diagnostic_ID, null);
		else 
			set_Value (COLUMNNAME_H_Diagnostic_ID, Integer.valueOf(H_Diagnostic_ID));
	}

	/** Get H_Diagnostic.
		@return H_Diagnostic	  */
	public int getH_Diagnostic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Diagnostic_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Comment/Help.
		@param Help 
		Comment or Hint
	  */
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp () 
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}