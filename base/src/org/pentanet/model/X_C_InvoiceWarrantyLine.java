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

/** Generated Model for C_InvoiceWarrantyLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_InvoiceWarrantyLine extends PO implements I_C_InvoiceWarrantyLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160816L;

    /** Standard Constructor */
    public X_C_InvoiceWarrantyLine (Properties ctx, int C_InvoiceWarrantyLine_ID, String trxName)
    {
      super (ctx, C_InvoiceWarrantyLine_ID, trxName);
      /** if (C_InvoiceWarrantyLine_ID == 0)
        {
			setC_InvoiceWarrantyLine_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_InvoiceWarrantyLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_InvoiceWarrantyLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_InvoiceWarranty getC_InvoiceWarranty() throws RuntimeException
    {
		return (org.pentanet.model.I_C_InvoiceWarranty)MTable.get(getCtx(), org.pentanet.model.I_C_InvoiceWarranty.Table_Name)
			.getPO(getC_InvoiceWarranty_ID(), get_TrxName());	}

	/** Set C_InvoiceWarranty.
		@param C_InvoiceWarranty_ID C_InvoiceWarranty	  */
	public void setC_InvoiceWarranty_ID (int C_InvoiceWarranty_ID)
	{
		if (C_InvoiceWarranty_ID < 1) 
			set_Value (COLUMNNAME_C_InvoiceWarranty_ID, null);
		else 
			set_Value (COLUMNNAME_C_InvoiceWarranty_ID, Integer.valueOf(C_InvoiceWarranty_ID));
	}

	/** Get C_InvoiceWarranty.
		@return C_InvoiceWarranty	  */
	public int getC_InvoiceWarranty_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_InvoiceWarranty_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_InvoiceWarrantyLine.
		@param C_InvoiceWarrantyLine_ID C_InvoiceWarrantyLine	  */
	public void setC_InvoiceWarrantyLine_ID (int C_InvoiceWarrantyLine_ID)
	{
		if (C_InvoiceWarrantyLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_InvoiceWarrantyLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_InvoiceWarrantyLine_ID, Integer.valueOf(C_InvoiceWarrantyLine_ID));
	}

	/** Get C_InvoiceWarrantyLine.
		@return C_InvoiceWarrantyLine	  */
	public int getC_InvoiceWarrantyLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_InvoiceWarrantyLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Date Invoiced.
		@param DateInvoiced 
		Date printed on Invoice
	  */
	public void setDateInvoiced (Timestamp DateInvoiced)
	{
		set_Value (COLUMNNAME_DateInvoiced, DateInvoiced);
	}

	/** Get Date Invoiced.
		@return Date printed on Invoice
	  */
	public Timestamp getDateInvoiced () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateInvoiced);
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

	/** Set IsWarranty.
		@param IsWarranty IsWarranty	  */
	public void setIsWarranty (boolean IsWarranty)
	{
		set_Value (COLUMNNAME_IsWarranty, Boolean.valueOf(IsWarranty));
	}

	/** Get IsWarranty.
		@return IsWarranty	  */
	public boolean isWarranty () 
	{
		Object oo = get_Value(COLUMNNAME_IsWarranty);
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

	/** Set Open Amount.
		@param OpenAmt 
		Open item amount
	  */
	public void setOpenAmt (BigDecimal OpenAmt)
	{
		throw new IllegalArgumentException ("OpenAmt is virtual column");	}

	/** Get Open Amount.
		@return Open item amount
	  */
	public BigDecimal getOpenAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_OpenAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total_Invoice.
		@param Total_Invoice Total_Invoice	  */
	public void setTotal_Invoice (BigDecimal Total_Invoice)
	{
		set_Value (COLUMNNAME_Total_Invoice, Total_Invoice);
	}

	/** Get Total_Invoice.
		@return Total_Invoice	  */
	public BigDecimal getTotal_Invoice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Invoice);
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