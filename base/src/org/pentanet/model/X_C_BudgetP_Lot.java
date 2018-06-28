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

/** Generated Model for C_BudgetP_Lot
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_C_BudgetP_Lot extends PO implements I_C_BudgetP_Lot, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20130121L;

    /** Standard Constructor */
    public X_C_BudgetP_Lot (Properties ctx, int C_BudgetP_Lot_ID, String trxName)
    {
      super (ctx, C_BudgetP_Lot_ID, trxName);
      /** if (C_BudgetP_Lot_ID == 0)
        {
			setC_BudgetP_Lot_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetP_Lot (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetP_Lot[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount 
		Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		throw new IllegalArgumentException ("Amount is virtual column");	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** BudgetDist_Type AD_Reference_ID=1000057 */
	public static final int BUDGETDIST_TYPE_AD_Reference_ID=1000057;
	/** Mensual = M */
	public static final String BUDGETDIST_TYPE_Mensual = "M";
	/** Trimestral = T */
	public static final String BUDGETDIST_TYPE_Trimestral = "T";
	/** Bimensual = B */
	public static final String BUDGETDIST_TYPE_Bimensual = "B";
	/** Semestral = S */
	public static final String BUDGETDIST_TYPE_Semestral = "S";
	/** Set BudgetDist_Type.
		@param BudgetDist_Type BudgetDist_Type	  */
	public void setBudgetDist_Type (String BudgetDist_Type)
	{

		set_Value (COLUMNNAME_BudgetDist_Type, BudgetDist_Type);
	}

	/** Get BudgetDist_Type.
		@return BudgetDist_Type	  */
	public String getBudgetDist_Type () 
	{
		return (String)get_Value(COLUMNNAME_BudgetDist_Type);
	}

	/** Set C_BudgetP_Lot.
		@param C_BudgetP_Lot_ID C_BudgetP_Lot	  */
	public void setC_BudgetP_Lot_ID (int C_BudgetP_Lot_ID)
	{
		if (C_BudgetP_Lot_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetP_Lot_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetP_Lot_ID, Integer.valueOf(C_BudgetP_Lot_ID));
	}

	/** Get C_BudgetP_Lot.
		@return C_BudgetP_Lot	  */
	public int getC_BudgetP_Lot_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetP_Lot_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Year getC_Year() throws RuntimeException
    {
		return (org.compiere.model.I_C_Year)MTable.get(getCtx(), org.compiere.model.I_C_Year.Table_Name)
			.getPO(getC_Year_ID(), get_TrxName());	}

	/** Set Year.
		@param C_Year_ID 
		Calendar Year
	  */
	public void setC_Year_ID (int C_Year_ID)
	{
		if (C_Year_ID < 1) 
			set_Value (COLUMNNAME_C_Year_ID, null);
		else 
			set_Value (COLUMNNAME_C_Year_ID, Integer.valueOf(C_Year_ID));
	}

	/** Get Year.
		@return Calendar Year
	  */
	public int getC_Year_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Year_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set ExecuteDist.
		@param ExecuteDist ExecuteDist	  */
	public void setExecuteDist (String ExecuteDist)
	{
		set_Value (COLUMNNAME_ExecuteDist, ExecuteDist);
	}

	/** Get ExecuteDist.
		@return ExecuteDist	  */
	public String getExecuteDist () 
	{
		return (String)get_Value(COLUMNNAME_ExecuteDist);
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