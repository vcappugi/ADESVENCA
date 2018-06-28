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

/** Generated Model for HR_LiquidationProg_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_LiquidationProg_Line extends PO implements I_HR_LiquidationProg_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160113L;

    /** Standard Constructor */
    public X_HR_LiquidationProg_Line (Properties ctx, int HR_LiquidationProg_Line_ID, String trxName)
    {
      super (ctx, HR_LiquidationProg_Line_ID, trxName);
      /** if (HR_LiquidationProg_Line_ID == 0)
        {
			setHR_LiquidationProg_Line_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_LiquidationProg_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_LiquidationProg_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount 
		Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}

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
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

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

	/** Set Cedula.
		@param Cedula Cedula	  */
	public void setCedula (String Cedula)
	{
		throw new IllegalArgumentException ("Cedula is virtual column");	}

	/** Get Cedula.
		@return Cedula	  */
	public String getCedula () 
	{
		return (String)get_Value(COLUMNNAME_Cedula);
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

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
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

	public org.pentanet.model.I_HR_LiquidationProg getHR_LiquidationProg() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_LiquidationProg)MTable.get(getCtx(), org.pentanet.model.I_HR_LiquidationProg.Table_Name)
			.getPO(getHR_LiquidationProg_ID(), get_TrxName());	}

	/** Set HR_LiquidationProg.
		@param HR_LiquidationProg_ID HR_LiquidationProg	  */
	public void setHR_LiquidationProg_ID (int HR_LiquidationProg_ID)
	{
		if (HR_LiquidationProg_ID < 1) 
			set_Value (COLUMNNAME_HR_LiquidationProg_ID, null);
		else 
			set_Value (COLUMNNAME_HR_LiquidationProg_ID, Integer.valueOf(HR_LiquidationProg_ID));
	}

	/** Get HR_LiquidationProg.
		@return HR_LiquidationProg	  */
	public int getHR_LiquidationProg_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_LiquidationProg_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_LiquidationProg_Line.
		@param HR_LiquidationProg_Line_ID HR_LiquidationProg_Line	  */
	public void setHR_LiquidationProg_Line_ID (int HR_LiquidationProg_Line_ID)
	{
		if (HR_LiquidationProg_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_LiquidationProg_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_LiquidationProg_Line_ID, Integer.valueOf(HR_LiquidationProg_Line_ID));
	}

	/** Get HR_LiquidationProg_Line.
		@return HR_LiquidationProg_Line	  */
	public int getHR_LiquidationProg_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_LiquidationProg_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_LiquidationRequisition getHR_LiquidationRequisition() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_LiquidationRequisition)MTable.get(getCtx(), org.pentanet.model.I_HR_LiquidationRequisition.Table_Name)
			.getPO(getHR_LiquidationRequisition_ID(), get_TrxName());	}

	/** Set HR_LiquidationRequisition.
		@param HR_LiquidationRequisition_ID HR_LiquidationRequisition	  */
	public void setHR_LiquidationRequisition_ID (int HR_LiquidationRequisition_ID)
	{
		if (HR_LiquidationRequisition_ID < 1) 
			set_Value (COLUMNNAME_HR_LiquidationRequisition_ID, null);
		else 
			set_Value (COLUMNNAME_HR_LiquidationRequisition_ID, Integer.valueOf(HR_LiquidationRequisition_ID));
	}

	/** Get HR_LiquidationRequisition.
		@return HR_LiquidationRequisition	  */
	public int getHR_LiquidationRequisition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_LiquidationRequisition_ID);
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

	/** PaidList AD_Reference_ID=1000153 */
	public static final int PAIDLIST_AD_Reference_ID=1000153;
	/** Paid = P */
	public static final String PAIDLIST_Paid = "P";
	/** Reprogram = R */
	public static final String PAIDLIST_Reprogram = "R";
	/** Anulate = A */
	public static final String PAIDLIST_Anulate = "A";
	/** Set PaidList.
		@param PaidList PaidList	  */
	public void setPaidList (String PaidList)
	{

		set_Value (COLUMNNAME_PaidList, PaidList);
	}

	/** Get PaidList.
		@return PaidList	  */
	public String getPaidList () 
	{
		return (String)get_Value(COLUMNNAME_PaidList);
	}

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
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