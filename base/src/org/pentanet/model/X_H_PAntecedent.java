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

/** Generated Model for H_PAntecedent
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_PAntecedent extends PO implements I_H_PAntecedent, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111128L;

    /** Standard Constructor */
    public X_H_PAntecedent (Properties ctx, int H_PAntecedent_ID, String trxName)
    {
      super (ctx, H_PAntecedent_ID, trxName);
      /** if (H_PAntecedent_ID == 0)
        {
			setH_PAntecedent_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_PAntecedent (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_PAntecedent[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.pentanet.model.I_H_AntecedentList getH_AntecedentList() throws RuntimeException
    {
		return (org.pentanet.model.I_H_AntecedentList)MTable.get(getCtx(), org.pentanet.model.I_H_AntecedentList.Table_Name)
			.getPO(getH_AntecedentList_ID(), get_TrxName());	}

	/** Set H_AntecedentList.
		@param H_AntecedentList_ID H_AntecedentList	  */
	public void setH_AntecedentList_ID (int H_AntecedentList_ID)
	{
		if (H_AntecedentList_ID < 1) 
			set_Value (COLUMNNAME_H_AntecedentList_ID, null);
		else 
			set_Value (COLUMNNAME_H_AntecedentList_ID, Integer.valueOf(H_AntecedentList_ID));
	}

	/** Get H_AntecedentList.
		@return H_AntecedentList	  */
	public int getH_AntecedentList_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_AntecedentList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_MHistory.
		@param H_MHistory_ID H_MHistory	  */
	public void setH_MHistory_ID (int H_MHistory_ID)
	{
		if (H_MHistory_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_MHistory_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_MHistory_ID, Integer.valueOf(H_MHistory_ID));
	}

	/** Get H_MHistory.
		@return H_MHistory	  */
	public int getH_MHistory_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_MHistory_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_PAntecedent.
		@param H_PAntecedent_ID H_PAntecedent	  */
	public void setH_PAntecedent_ID (int H_PAntecedent_ID)
	{
		if (H_PAntecedent_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_PAntecedent_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_PAntecedent_ID, Integer.valueOf(H_PAntecedent_ID));
	}

	/** Get H_PAntecedent.
		@return H_PAntecedent	  */
	public int getH_PAntecedent_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_PAntecedent_ID);
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