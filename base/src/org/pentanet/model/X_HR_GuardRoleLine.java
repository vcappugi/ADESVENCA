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

/** Generated Model for HR_GuardRoleLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_HR_GuardRoleLine extends PO implements I_HR_GuardRoleLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131115L;

    /** Standard Constructor */
    public X_HR_GuardRoleLine (Properties ctx, int HR_GuardRoleLine_ID, String trxName)
    {
      super (ctx, HR_GuardRoleLine_ID, trxName);
      /** if (HR_GuardRoleLine_ID == 0)
        {
			setDaysR (0);
			setDaysW (0);
			setHR_GuardRoleLine_ID (0);
			setHR_Turn_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_GuardRoleLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_GuardRoleLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set DaysR.
		@param DaysR DaysR	  */
	public void setDaysR (int DaysR)
	{
		set_Value (COLUMNNAME_DaysR, Integer.valueOf(DaysR));
	}

	/** Get DaysR.
		@return DaysR	  */
	public int getDaysR () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DaysR);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DaysW.
		@param DaysW DaysW	  */
	public void setDaysW (int DaysW)
	{
		set_Value (COLUMNNAME_DaysW, Integer.valueOf(DaysW));
	}

	/** Get DaysW.
		@return DaysW	  */
	public int getDaysW () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DaysW);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_HR_GuardRole getHR_GuardRole() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_GuardRole)MTable.get(getCtx(), org.pentanet.model.I_HR_GuardRole.Table_Name)
			.getPO(getHR_GuardRole_ID(), get_TrxName());	}

	/** Set HR_GuardRole.
		@param HR_GuardRole_ID HR_GuardRole	  */
	public void setHR_GuardRole_ID (int HR_GuardRole_ID)
	{
		if (HR_GuardRole_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_GuardRole_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_GuardRole_ID, Integer.valueOf(HR_GuardRole_ID));
	}

	/** Get HR_GuardRole.
		@return HR_GuardRole	  */
	public int getHR_GuardRole_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_GuardRole_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_GuardRoleLine.
		@param HR_GuardRoleLine_ID HR_GuardRoleLine	  */
	public void setHR_GuardRoleLine_ID (int HR_GuardRoleLine_ID)
	{
		if (HR_GuardRoleLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_GuardRoleLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_GuardRoleLine_ID, Integer.valueOf(HR_GuardRoleLine_ID));
	}

	/** Get HR_GuardRoleLine.
		@return HR_GuardRoleLine	  */
	public int getHR_GuardRoleLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_GuardRoleLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getHR_Turn() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getHR_Turn_ID(), get_TrxName());	}

	/** Set HR_Turn.
		@param HR_Turn_ID HR_Turn	  */
	public void setHR_Turn_ID (int HR_Turn_ID)
	{
		if (HR_Turn_ID < 1) 
			set_Value (COLUMNNAME_HR_Turn_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Turn_ID, Integer.valueOf(HR_Turn_ID));
	}

	/** Get HR_Turn.
		@return HR_Turn	  */
	public int getHR_Turn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Turn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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