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

/** Generated Model for C_Contract
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Contract extends PO implements I_C_Contract, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160719L;

    /** Standard Constructor */
    public X_C_Contract (Properties ctx, int C_Contract_ID, String trxName)
    {
      super (ctx, C_Contract_ID, trxName);
      /** if (C_Contract_ID == 0)
        {
			setC_Contract_ID (0);
			setDateDoc (new Timestamp( System.currentTimeMillis() ));
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Contract (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Contract[")
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

	/** Set C_Contract.
		@param C_Contract_ID C_Contract	  */
	public void setC_Contract_ID (int C_Contract_ID)
	{
		if (C_Contract_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Contract_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Contract_ID, Integer.valueOf(C_Contract_ID));
	}

	/** Get C_Contract.
		@return C_Contract	  */
	public int getC_Contract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException
    {
		return (org.compiere.model.I_C_Currency)MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
			.getPO(getC_Currency_ID(), get_TrxName());	}

	/** Set Currency.
		@param C_Currency_ID 
		The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Currency.
		@return The Currency for this record
	  */
	public int getC_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Division getC_Division() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Division)MTable.get(getCtx(), org.pentanet.model.I_C_Division.Table_Name)
			.getPO(getC_Division_ID(), get_TrxName());	}

	/** Set C_Division.
		@param C_Division_ID C_Division	  */
	public void setC_Division_ID (int C_Division_ID)
	{
		if (C_Division_ID < 1) 
			set_Value (COLUMNNAME_C_Division_ID, null);
		else 
			set_Value (COLUMNNAME_C_Division_ID, Integer.valueOf(C_Division_ID));
	}

	/** Get C_Division.
		@return C_Division	  */
	public int getC_Division_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Division_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ConfigContract.
		@param ConfigContract ConfigContract	  */
	public void setConfigContract (String ConfigContract)
	{
		set_Value (COLUMNNAME_ConfigContract, ConfigContract);
	}

	/** Get ConfigContract.
		@return ConfigContract	  */
	public String getConfigContract () 
	{
		return (String)get_Value(COLUMNNAME_ConfigContract);
	}

	public org.pentanet.model.I_C_ServiceLine getC_ServiceLine() throws RuntimeException
    {
		return (org.pentanet.model.I_C_ServiceLine)MTable.get(getCtx(), org.pentanet.model.I_C_ServiceLine.Table_Name)
			.getPO(getC_ServiceLine_ID(), get_TrxName());	}

	/** Set ServiceLine.
		@param C_ServiceLine_ID ServiceLine	  */
	public void setC_ServiceLine_ID (int C_ServiceLine_ID)
	{
		if (C_ServiceLine_ID < 1) 
			set_Value (COLUMNNAME_C_ServiceLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_ServiceLine_ID, Integer.valueOf(C_ServiceLine_ID));
	}

	/** Get ServiceLine.
		@return ServiceLine	  */
	public int getC_ServiceLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ServiceLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rate.
		@param CurrencyRate 
		Currency Conversion Rate
	  */
	public void setCurrencyRate (BigDecimal CurrencyRate)
	{
		throw new IllegalArgumentException ("CurrencyRate is virtual column");	}

	/** Get Rate.
		@return Currency Conversion Rate
	  */
	public BigDecimal getCurrencyRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CurrencyRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Document Date.
		@param DateDoc 
		Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc)
	{
		set_Value (COLUMNNAME_DateDoc, DateDoc);
	}

	/** Get Document Date.
		@return Date of the Document
	  */
	public Timestamp getDateDoc () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDoc);
	}

	/** Set Finish Date.
		@param DateFinish 
		Finish or (planned) completion date
	  */
	public void setDateFinish (Timestamp DateFinish)
	{
		set_Value (COLUMNNAME_DateFinish, DateFinish);
	}

	/** Get Finish Date.
		@return Finish or (planned) completion date
	  */
	public Timestamp getDateFinish () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateFinish);
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

	/** Set Net Days.
		@param NetDays 
		Net Days in which payment is due
	  */
	public void setNetDays (BigDecimal NetDays)
	{
		set_Value (COLUMNNAME_NetDays, NetDays);
	}

	/** Get Net Days.
		@return Net Days in which payment is due
	  */
	public BigDecimal getNetDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ParalDays.
		@param ParalDays ParalDays	  */
	public void setParalDays (BigDecimal ParalDays)
	{
		set_Value (COLUMNNAME_ParalDays, ParalDays);
	}

	/** Get ParalDays.
		@return ParalDays	  */
	public BigDecimal getParalDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ParalDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Status AD_Reference_ID=1000223 */
	public static final int STATUS_AD_Reference_ID=1000223;
	/** Paralizado = PA */
	public static final String STATUS_Paralizado = "PA";
	/** Activo = AC */
	public static final String STATUS_Activo = "AC";
	/** Inactivo = IN */
	public static final String STATUS_Inactivo = "IN";
	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus () 
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	/** Set Tax Amount.
		@param TaxAmt 
		Tax Amount for a document
	  */
	public void setTaxAmt (BigDecimal TaxAmt)
	{
		set_Value (COLUMNNAME_TaxAmt, TaxAmt);
	}

	/** Get Tax Amount.
		@return Tax Amount for a document
	  */
	public BigDecimal getTaxAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Type AD_Reference_ID=1000211 */
	public static final int TYPE_AD_Reference_ID=1000211;
	/** Mixto = MIX */
	public static final String TYPE_Mixto = "MIX";
	/** Volúmen = VOL */
	public static final String TYPE_Volúmen = "VOL";
	/** Consumo = CON */
	public static final String TYPE_Consumo = "CON";
	/** Set Type.
		@param Type 
		Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
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