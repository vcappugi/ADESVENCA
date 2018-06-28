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

/** Generated Model for HR_VacationProg_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_VacationProg_Line extends PO implements I_HR_VacationProg_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140711L;

    /** Standard Constructor */
    public X_HR_VacationProg_Line (Properties ctx, int HR_VacationProg_Line_ID, String trxName)
    {
      super (ctx, HR_VacationProg_Line_ID, trxName);
      /** if (HR_VacationProg_Line_ID == 0)
        {
			setHR_VacationProg_Line_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_VacationProg_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_VacationProg_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BonDays.
		@param BonDays BonDays	  */
	public void setBonDays (BigDecimal BonDays)
	{
		set_Value (COLUMNNAME_BonDays, BonDays);
	}

	/** Get BonDays.
		@return BonDays	  */
	public BigDecimal getBonDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BonDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		throw new IllegalArgumentException ("C_BPartner_ID is virtual column");	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DateEnd.
		@param DateEnd DateEnd	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		throw new IllegalArgumentException ("DateEnd is virtual column");	}

	/** Get DateEnd.
		@return DateEnd	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		throw new IllegalArgumentException ("DateStart is virtual column");	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
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

	/** Set HR_Vacation.
		@param HR_Vacation_ID HR_Vacation	  */
	public void setHR_Vacation_ID (int HR_Vacation_ID)
	{
		if (HR_Vacation_ID < 1) 
			set_Value (COLUMNNAME_HR_Vacation_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Vacation_ID, Integer.valueOf(HR_Vacation_ID));
	}

	/** Get HR_Vacation.
		@return HR_Vacation	  */
	public int getHR_Vacation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_Vacation_Incidence.
		@param HR_Vacation_Incidence_ID HR_Vacation_Incidence	  */
	public void setHR_Vacation_Incidence_ID (int HR_Vacation_Incidence_ID)
	{
		if (HR_Vacation_Incidence_ID < 1) 
			set_Value (COLUMNNAME_HR_Vacation_Incidence_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Vacation_Incidence_ID, Integer.valueOf(HR_Vacation_Incidence_ID));
	}

	/** Get HR_Vacation_Incidence.
		@return HR_Vacation_Incidence	  */
	public int getHR_Vacation_Incidence_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_Incidence_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_VacationProg getHR_VacationProg() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_VacationProg)MTable.get(getCtx(), org.pentanet.model.I_HR_VacationProg.Table_Name)
			.getPO(getHR_VacationProg_ID(), get_TrxName());	}

	/** Set HR_VacationProg.
		@param HR_VacationProg_ID HR_VacationProg	  */
	public void setHR_VacationProg_ID (int HR_VacationProg_ID)
	{
		if (HR_VacationProg_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacationProg_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacationProg_ID, Integer.valueOf(HR_VacationProg_ID));
	}

	/** Get HR_VacationProg.
		@return HR_VacationProg	  */
	public int getHR_VacationProg_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacationProg_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_VacationProg_Line.
		@param HR_VacationProg_Line_ID HR_VacationProg_Line	  */
	public void setHR_VacationProg_Line_ID (int HR_VacationProg_Line_ID)
	{
		if (HR_VacationProg_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacationProg_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacationProg_Line_ID, Integer.valueOf(HR_VacationProg_Line_ID));
	}

	/** Get HR_VacationProg_Line.
		@return HR_VacationProg_Line	  */
	public int getHR_VacationProg_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacationProg_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Paid.
		@param IsPaid 
		The document is paid
	  */
	public void setIsPaid (boolean IsPaid)
	{
		set_Value (COLUMNNAME_IsPaid, Boolean.valueOf(IsPaid));
	}

	/** Get Paid.
		@return The document is paid
	  */
	public boolean isPaid () 
	{
		Object oo = get_Value(COLUMNNAME_IsPaid);
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