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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_HCMTab
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_HCMTab extends PO implements I_HR_HCMTab, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150220L;

    /** Standard Constructor */
    public X_HR_HCMTab (Properties ctx, int HR_HCMTab_ID, String trxName)
    {
      super (ctx, HR_HCMTab_ID, trxName);
      /** if (HR_HCMTab_ID == 0)
        {
			setage_from (Env.ZERO);
			setage_to (Env.ZERO);
			setHR_HCMTab_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_HCMTab (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_HCMTab[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set age_from.
		@param age_from age_from	  */
	public void setage_from (BigDecimal age_from)
	{
		set_Value (COLUMNNAME_age_from, age_from);
	}

	/** Get age_from.
		@return age_from	  */
	public BigDecimal getage_from () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_age_from);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set age_to.
		@param age_to age_to	  */
	public void setage_to (BigDecimal age_to)
	{
		set_Value (COLUMNNAME_age_to, age_to);
	}

	/** Get age_to.
		@return age_to	  */
	public BigDecimal getage_to () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_age_to);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set HR_HCMTab.
		@param HR_HCMTab_ID HR_HCMTab	  */
	public void setHR_HCMTab_ID (int HR_HCMTab_ID)
	{
		if (HR_HCMTab_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_HCMTab_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_HCMTab_ID, Integer.valueOf(HR_HCMTab_ID));
	}

	/** Get HR_HCMTab.
		@return HR_HCMTab	  */
	public int getHR_HCMTab_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMTab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IsBrother.
		@param IsBrother IsBrother	  */
	public void setIsBrother (boolean IsBrother)
	{
		set_Value (COLUMNNAME_IsBrother, Boolean.valueOf(IsBrother));
	}

	/** Get IsBrother.
		@return IsBrother	  */
	public boolean isBrother () 
	{
		Object oo = get_Value(COLUMNNAME_IsBrother);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsSon.
		@param IsSon IsSon	  */
	public void setIsSon (boolean IsSon)
	{
		set_Value (COLUMNNAME_IsSon, Boolean.valueOf(IsSon));
	}

	/** Get IsSon.
		@return IsSon	  */
	public boolean isSon () 
	{
		Object oo = get_Value(COLUMNNAME_IsSon);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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