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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_PeriodR
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_HR_PeriodR extends PO implements I_HR_PeriodR, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131115L;

    /** Standard Constructor */
    public X_HR_PeriodR (Properties ctx, int HR_PeriodR_ID, String trxName)
    {
      super (ctx, HR_PeriodR_ID, trxName);
      /** if (HR_PeriodR_ID == 0)
        {
			setHR_PeriodR_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_PeriodR (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_PeriodR[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BtnProcess.
		@param BtnProcess BtnProcess	  */
	public void setBtnProcess (String BtnProcess)
	{
		set_Value (COLUMNNAME_BtnProcess, BtnProcess);
	}

	/** Get BtnProcess.
		@return BtnProcess	  */
	public String getBtnProcess () 
	{
		return (String)get_Value(COLUMNNAME_BtnProcess);
	}

	/** Set DateEnd.
		@param DateEnd DateEnd	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get DateEnd.
		@return DateEnd	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set DateIni.
		@param DateIni DateIni	  */
	public void setDateIni (Timestamp DateIni)
	{
		set_Value (COLUMNNAME_DateIni, DateIni);
	}

	/** Get DateIni.
		@return DateIni	  */
	public Timestamp getDateIni () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateIni);
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

	/** Set HR_PeriodR.
		@param HR_PeriodR_ID HR_PeriodR	  */
	public void setHR_PeriodR_ID (int HR_PeriodR_ID)
	{
		if (HR_PeriodR_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_PeriodR_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_PeriodR_ID, Integer.valueOf(HR_PeriodR_ID));
	}

	/** Get HR_PeriodR.
		@return HR_PeriodR	  */
	public int getHR_PeriodR_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodR_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Rotation getHR_Rotation() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Rotation)MTable.get(getCtx(), org.pentanet.model.I_HR_Rotation.Table_Name)
			.getPO(getHR_Rotation_ID(), get_TrxName());	}

	/** Set HR_Rotation.
		@param HR_Rotation_ID HR_Rotation	  */
	public void setHR_Rotation_ID (int HR_Rotation_ID)
	{
		if (HR_Rotation_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Rotation_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Rotation_ID, Integer.valueOf(HR_Rotation_ID));
	}

	/** Get HR_Rotation.
		@return HR_Rotation	  */
	public int getHR_Rotation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Rotation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ISPROCESSED.
		@param ISPROCESSED ISPROCESSED	  */
	public void setISPROCESSED (boolean ISPROCESSED)
	{
		set_Value (COLUMNNAME_ISPROCESSED, Boolean.valueOf(ISPROCESSED));
	}

	/** Get ISPROCESSED.
		@return ISPROCESSED	  */
	public boolean isPROCESSED () 
	{
		Object oo = get_Value(COLUMNNAME_ISPROCESSED);
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