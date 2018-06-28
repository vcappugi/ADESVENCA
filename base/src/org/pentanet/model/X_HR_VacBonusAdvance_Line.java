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

/** Generated Model for HR_VacBonusAdvance_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_VacBonusAdvance_Line extends PO implements I_HR_VacBonusAdvance_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140813L;

    /** Standard Constructor */
    public X_HR_VacBonusAdvance_Line (Properties ctx, int HR_VacBonusAdvance_Line_ID, String trxName)
    {
      super (ctx, HR_VacBonusAdvance_Line_ID, trxName);
      /** if (HR_VacBonusAdvance_Line_ID == 0)
        {
			setHR_VacBonusAdvance_Line_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_VacBonusAdvance_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_VacBonusAdvance_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AmtVacAvailable.
		@param AmtVacAvailable AmtVacAvailable	  */
	public void setAmtVacAvailable (BigDecimal AmtVacAvailable)
	{
		set_Value (COLUMNNAME_AmtVacAvailable, AmtVacAvailable);
	}

	/** Get AmtVacAvailable.
		@return AmtVacAvailable	  */
	public BigDecimal getAmtVacAvailable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacAvailable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacCommitted.
		@param AmtVacCommitted AmtVacCommitted	  */
	public void setAmtVacCommitted (BigDecimal AmtVacCommitted)
	{
		set_Value (COLUMNNAME_AmtVacCommitted, AmtVacCommitted);
	}

	/** Get AmtVacCommitted.
		@return AmtVacCommitted	  */
	public BigDecimal getAmtVacCommitted () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacCommitted);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacEstimated.
		@param AmtVacEstimated AmtVacEstimated	  */
	public void setAmtVacEstimated (BigDecimal AmtVacEstimated)
	{
		set_Value (COLUMNNAME_AmtVacEstimated, AmtVacEstimated);
	}

	/** Get AmtVacEstimated.
		@return AmtVacEstimated	  */
	public BigDecimal getAmtVacEstimated () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacEstimated);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacRequired.
		@param AmtVacRequired AmtVacRequired	  */
	public void setAmtVacRequired (BigDecimal AmtVacRequired)
	{
		set_Value (COLUMNNAME_AmtVacRequired, AmtVacRequired);
	}

	/** Get AmtVacRequired.
		@return AmtVacRequired	  */
	public BigDecimal getAmtVacRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacRequired);
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

	public org.pentanet.model.I_HR_VacBonusAdvance getHR_VacBonusAdvance() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_VacBonusAdvance)MTable.get(getCtx(), org.pentanet.model.I_HR_VacBonusAdvance.Table_Name)
			.getPO(getHR_VacBonusAdvance_ID(), get_TrxName());	}

	/** Set HR_VacBonusAdvance.
		@param HR_VacBonusAdvance_ID HR_VacBonusAdvance	  */
	public void setHR_VacBonusAdvance_ID (int HR_VacBonusAdvance_ID)
	{
		if (HR_VacBonusAdvance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_ID, Integer.valueOf(HR_VacBonusAdvance_ID));
	}

	/** Get HR_VacBonusAdvance.
		@return HR_VacBonusAdvance	  */
	public int getHR_VacBonusAdvance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacBonusAdvance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_VacBonusAdvance_Line.
		@param HR_VacBonusAdvance_Line_ID HR_VacBonusAdvance_Line	  */
	public void setHR_VacBonusAdvance_Line_ID (int HR_VacBonusAdvance_Line_ID)
	{
		if (HR_VacBonusAdvance_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_Line_ID, Integer.valueOf(HR_VacBonusAdvance_Line_ID));
	}

	/** Get HR_VacBonusAdvance_Line.
		@return HR_VacBonusAdvance_Line	  */
	public int getHR_VacBonusAdvance_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacBonusAdvance_Line_ID);
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