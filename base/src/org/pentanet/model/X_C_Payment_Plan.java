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

/** Generated Model for C_Payment_Plan
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Payment_Plan extends PO implements I_C_Payment_Plan, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150330L;

    /** Standard Constructor */
    public X_C_Payment_Plan (Properties ctx, int C_Payment_Plan_ID, String trxName)
    {
      super (ctx, C_Payment_Plan_ID, trxName);
      /** if (C_Payment_Plan_ID == 0)
        {
			setC_Payment_Plan_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Payment_Plan (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Payment_Plan[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getC_BankAccount_ID(), get_TrxName());	}

	/** Set Bank Account.
		@param C_BankAccount_ID 
		Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID)
	{
		if (C_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_C_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankAccount_ID, Integer.valueOf(C_BankAccount_ID));
	}

	/** Get Bank Account.
		@return Account at the Bank
	  */
	public int getC_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Payment_Plan.
		@param C_Payment_Plan_ID C_Payment_Plan	  */
	public void setC_Payment_Plan_ID (int C_Payment_Plan_ID)
	{
		if (C_Payment_Plan_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Plan_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Plan_ID, Integer.valueOf(C_Payment_Plan_ID));
	}

	/** Get C_Payment_Plan.
		@return C_Payment_Plan	  */
	public int getC_Payment_Plan_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_Plan_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CreateTo.
		@param CreateTo CreateTo	  */
	public void setCreateTo (String CreateTo)
	{
		set_Value (COLUMNNAME_CreateTo, CreateTo);
	}

	/** Get CreateTo.
		@return CreateTo	  */
	public String getCreateTo () 
	{
		return (String)get_Value(COLUMNNAME_CreateTo);
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

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		set_Value (COLUMNNAME_DateStart, DateStart);
	}

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

	/** Set Payment_Process.
		@param Payment_Process Payment_Process	  */
	public void setPayment_Process (String Payment_Process)
	{
		set_Value (COLUMNNAME_Payment_Process, Payment_Process);
	}

	/** Get Payment_Process.
		@return Payment_Process	  */
	public String getPayment_Process () 
	{
		return (String)get_Value(COLUMNNAME_Payment_Process);
	}

	/** TenderType AD_Reference_ID=214 */
	public static final int TENDERTYPE_AD_Reference_ID=214;
	/** Credit Card = C */
	public static final String TENDERTYPE_CreditCard = "C";
	/** Check = K */
	public static final String TENDERTYPE_Check = "K";
	/** Direct Deposit = A */
	public static final String TENDERTYPE_DirectDeposit = "A";
	/** Direct Debit = D */
	public static final String TENDERTYPE_DirectDebit = "D";
	/** Account = T */
	public static final String TENDERTYPE_Account = "T";
	/** Cash = X */
	public static final String TENDERTYPE_Cash = "X";
	/** Set Tender type.
		@param TenderType 
		Method of Payment
	  */
	public void setTenderType (String TenderType)
	{

		set_Value (COLUMNNAME_TenderType, TenderType);
	}

	/** Get Tender type.
		@return Method of Payment
	  */
	public String getTenderType () 
	{
		return (String)get_Value(COLUMNNAME_TenderType);
	}

	/** Set Total_Payment_120D.
		@param Total_Payment_120D Total_Payment_120D	  */
	public void setTotal_Payment_120D (BigDecimal Total_Payment_120D)
	{
		set_Value (COLUMNNAME_Total_Payment_120D, Total_Payment_120D);
	}

	/** Get Total_Payment_120D.
		@return Total_Payment_120D	  */
	public BigDecimal getTotal_Payment_120D () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_120D);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Payment_30D.
		@param Total_Payment_30D Total_Payment_30D	  */
	public void setTotal_Payment_30D (BigDecimal Total_Payment_30D)
	{
		set_Value (COLUMNNAME_Total_Payment_30D, Total_Payment_30D);
	}

	/** Get Total_Payment_30D.
		@return Total_Payment_30D	  */
	public BigDecimal getTotal_Payment_30D () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_30D);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Payment_60D.
		@param Total_Payment_60D Total_Payment_60D	  */
	public void setTotal_Payment_60D (BigDecimal Total_Payment_60D)
	{
		set_Value (COLUMNNAME_Total_Payment_60D, Total_Payment_60D);
	}

	/** Get Total_Payment_60D.
		@return Total_Payment_60D	  */
	public BigDecimal getTotal_Payment_60D () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_60D);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Payment_75D.
		@param Total_Payment_75D Total_Payment_75D	  */
	public void setTotal_Payment_75D (BigDecimal Total_Payment_75D)
	{
		set_Value (COLUMNNAME_Total_Payment_75D, Total_Payment_75D);
	}

	/** Get Total_Payment_75D.
		@return Total_Payment_75D	  */
	public BigDecimal getTotal_Payment_75D () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_75D);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Payment_90D.
		@param Total_Payment_90D Total_Payment_90D	  */
	public void setTotal_Payment_90D (BigDecimal Total_Payment_90D)
	{
		set_Value (COLUMNNAME_Total_Payment_90D, Total_Payment_90D);
	}

	/** Get Total_Payment_90D.
		@return Total_Payment_90D	  */
	public BigDecimal getTotal_Payment_90D () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_90D);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Payment_Plan.
		@param Total_Payment_Plan Total_Payment_Plan	  */
	public void setTotal_Payment_Plan (BigDecimal Total_Payment_Plan)
	{
		set_Value (COLUMNNAME_Total_Payment_Plan, Total_Payment_Plan);
	}

	/** Get Total_Payment_Plan.
		@return Total_Payment_Plan	  */
	public BigDecimal getTotal_Payment_Plan () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Payment_Plan);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Update_Amt.
		@param Update_Amt Update_Amt	  */
	public void setUpdate_Amt (String Update_Amt)
	{
		set_Value (COLUMNNAME_Update_Amt, Update_Amt);
	}

	/** Get Update_Amt.
		@return Update_Amt	  */
	public String getUpdate_Amt () 
	{
		return (String)get_Value(COLUMNNAME_Update_Amt);
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