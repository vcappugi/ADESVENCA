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

/** Generated Model for C_Payment_Schema
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Payment_Schema extends PO implements I_C_Payment_Schema, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150928L;

    /** Standard Constructor */
    public X_C_Payment_Schema (Properties ctx, int C_Payment_Schema_ID, String trxName)
    {
      super (ctx, C_Payment_Schema_ID, trxName);
      /** if (C_Payment_Schema_ID == 0)
        {
			setC_Payment_Schema_ID (0);
			setDateTrx (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDescription (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Payment_Schema (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Payment_Schema[")
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

	public org.pentanet.model.I_C_Financial_Ob getC_Financial_Ob() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Financial_Ob)MTable.get(getCtx(), org.pentanet.model.I_C_Financial_Ob.Table_Name)
			.getPO(getC_Financial_Ob_ID(), get_TrxName());	}

	/** Set C_Financial_Ob.
		@param C_Financial_Ob_ID C_Financial_Ob	  */
	public void setC_Financial_Ob_ID (int C_Financial_Ob_ID)
	{
		if (C_Financial_Ob_ID < 1) 
			set_Value (COLUMNNAME_C_Financial_Ob_ID, null);
		else 
			set_Value (COLUMNNAME_C_Financial_Ob_ID, Integer.valueOf(C_Financial_Ob_ID));
	}

	/** Get C_Financial_Ob.
		@return C_Financial_Ob	  */
	public int getC_Financial_Ob_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Financial_Ob_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Close_Dist.
		@param Close_Dist Close_Dist	  */
	public void setClose_Dist (String Close_Dist)
	{
		set_Value (COLUMNNAME_Close_Dist, Close_Dist);
	}

	/** Get Close_Dist.
		@return Close_Dist	  */
	public String getClose_Dist () 
	{
		return (String)get_Value(COLUMNNAME_Close_Dist);
	}

	/** Set C_Payment_Schema.
		@param C_Payment_Schema_ID C_Payment_Schema	  */
	public void setC_Payment_Schema_ID (int C_Payment_Schema_ID)
	{
		if (C_Payment_Schema_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Schema_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Schema_ID, Integer.valueOf(C_Payment_Schema_ID));
	}

	/** Get C_Payment_Schema.
		@return C_Payment_Schema	  */
	public int getC_Payment_Schema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_Schema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
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

	/** Set GeneratePayment.
		@param GeneratePayment GeneratePayment	  */
	public void setGeneratePayment (String GeneratePayment)
	{
		set_Value (COLUMNNAME_GeneratePayment, GeneratePayment);
	}

	/** Get GeneratePayment.
		@return GeneratePayment	  */
	public String getGeneratePayment () 
	{
		return (String)get_Value(COLUMNNAME_GeneratePayment);
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

	/** Set Approved.
		@param IsApproved 
		Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved)
	{
		set_Value (COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
	}

	/** Get Approved.
		@return Indicates if this document requires approval
	  */
	public boolean isApproved () 
	{
		Object oo = get_Value(COLUMNNAME_IsApproved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Closed Status.
		@param IsClosed 
		The status is closed
	  */
	public void setIsClosed (boolean IsClosed)
	{
		set_Value (COLUMNNAME_IsClosed, Boolean.valueOf(IsClosed));
	}

	/** Get Closed Status.
		@return The status is closed
	  */
	public boolean isClosed () 
	{
		Object oo = get_Value(COLUMNNAME_IsClosed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsSent.
		@param IsSent IsSent	  */
	public void setIsSent (boolean IsSent)
	{
		set_Value (COLUMNNAME_IsSent, Boolean.valueOf(IsSent));
	}

	/** Get IsSent.
		@return IsSent	  */
	public boolean isSent () 
	{
		Object oo = get_Value(COLUMNNAME_IsSent);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Processed_Button.
		@param Processed_Button Processed_Button	  */
	public void setProcessed_Button (String Processed_Button)
	{
		set_Value (COLUMNNAME_Processed_Button, Processed_Button);
	}

	/** Get Processed_Button.
		@return Processed_Button	  */
	public String getProcessed_Button () 
	{
		return (String)get_Value(COLUMNNAME_Processed_Button);
	}

	/** Set Send EMail.
		@param SendEMail 
		Enable sending Document EMail
	  */
	public void setSendEMail (String SendEMail)
	{
		set_Value (COLUMNNAME_SendEMail, SendEMail);
	}

	/** Get Send EMail.
		@return Enable sending Document EMail
	  */
	public String getSendEMail () 
	{
		return (String)get_Value(COLUMNNAME_SendEMail);
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