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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_Turn
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_HR_Turn extends PO implements I_HR_Turn, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131115L;

    /** Standard Constructor */
    public X_HR_Turn (Properties ctx, int HR_Turn_ID, String trxName)
    {
      super (ctx, HR_Turn_ID, trxName);
      /** if (HR_Turn_ID == 0)
        {
			setHR_Turn_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Turn (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_Turn[")
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

	/** Set HourEnd.
		@param HourEnd HourEnd	  */
	public void setHourEnd (Timestamp HourEnd)
	{
		set_Value (COLUMNNAME_HourEnd, HourEnd);
	}

	/** Get HourEnd.
		@return HourEnd	  */
	public Timestamp getHourEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_HourEnd);
	}

	/** Set HourStart.
		@param HourStart HourStart	  */
	public void setHourStart (Timestamp HourStart)
	{
		set_Value (COLUMNNAME_HourStart, HourStart);
	}

	/** Get HourStart.
		@return HourStart	  */
	public Timestamp getHourStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_HourStart);
	}

	/** Set HR_Turn.
		@param HR_Turn_ID HR_Turn	  */
	public void setHR_Turn_ID (int HR_Turn_ID)
	{
		if (HR_Turn_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Turn_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Turn_ID, Integer.valueOf(HR_Turn_ID));
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

	/** Set QtyHD.
		@param QtyHD 
		Cantidad Horas Diurnas
	  */
	public void setQtyHD (BigDecimal QtyHD)
	{
		set_Value (COLUMNNAME_QtyHD, QtyHD);
	}

	/** Get QtyHD.
		@return Cantidad Horas Diurnas
	  */
	public BigDecimal getQtyHD () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyHD);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyHED.
		@param QtyHED 
		Cantidad Horas Extras Diurnas
	  */
	public void setQtyHED (BigDecimal QtyHED)
	{
		set_Value (COLUMNNAME_QtyHED, QtyHED);
	}

	/** Get QtyHED.
		@return Cantidad Horas Extras Diurnas
	  */
	public BigDecimal getQtyHED () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyHED);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyHEN.
		@param QtyHEN 
		Cantidad Horas Extras Nocturnas
	  */
	public void setQtyHEN (BigDecimal QtyHEN)
	{
		set_Value (COLUMNNAME_QtyHEN, QtyHEN);
	}

	/** Get QtyHEN.
		@return Cantidad Horas Extras Nocturnas
	  */
	public BigDecimal getQtyHEN () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyHEN);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyHN.
		@param QtyHN 
		Cantidad Horas Nocturnas
	  */
	public void setQtyHN (BigDecimal QtyHN)
	{
		set_Value (COLUMNNAME_QtyHN, QtyHN);
	}

	/** Get QtyHN.
		@return Cantidad Horas Nocturnas
	  */
	public BigDecimal getQtyHN () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyHN);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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