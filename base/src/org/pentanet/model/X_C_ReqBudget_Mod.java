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

/** Generated Model for C_ReqBudget_Mod
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_ReqBudget_Mod extends PO implements I_C_ReqBudget_Mod, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180625L;

    /** Standard Constructor */
    public X_C_ReqBudget_Mod (Properties ctx, int C_ReqBudget_Mod_ID, String trxName)
    {
      super (ctx, C_ReqBudget_Mod_ID, trxName);
      /** if (C_ReqBudget_Mod_ID == 0)
        {
			setC_ReqBudget_Mod_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_ReqBudget_Mod (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_ReqBudget_Mod[")
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

	public org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID getC_BUDGETPMOD_TYPE_ID() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID)MTable.get(getCtx(), org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID.Table_Name)
			.getPO(getC_BUDGETPMOD_TYPE_ID_ID(), get_TrxName());	}

	/** Set C_BUDGETPMOD_TYPE_ID.
		@param C_BUDGETPMOD_TYPE_ID_ID C_BUDGETPMOD_TYPE_ID	  */
	public void setC_BUDGETPMOD_TYPE_ID_ID (int C_BUDGETPMOD_TYPE_ID_ID)
	{
		if (C_BUDGETPMOD_TYPE_ID_ID < 1) 
			set_Value (COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID, null);
		else 
			set_Value (COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID, Integer.valueOf(C_BUDGETPMOD_TYPE_ID_ID));
	}

	/** Get C_BUDGETPMOD_TYPE_ID.
		@return C_BUDGETPMOD_TYPE_ID	  */
	public int getC_BUDGETPMOD_TYPE_ID_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Manage_Unit getC_Manage_Unit() throws RuntimeException
    {
		return (org.compiere.model.I_C_Manage_Unit)MTable.get(getCtx(), org.compiere.model.I_C_Manage_Unit.Table_Name)
			.getPO(getC_Manage_Unit_ID(), get_TrxName());	}

	/** Set C_Manage_Unit.
		@param C_Manage_Unit_ID C_Manage_Unit	  */
	public void setC_Manage_Unit_ID (int C_Manage_Unit_ID)
	{
		if (C_Manage_Unit_ID < 1) 
			set_Value (COLUMNNAME_C_Manage_Unit_ID, null);
		else 
			set_Value (COLUMNNAME_C_Manage_Unit_ID, Integer.valueOf(C_Manage_Unit_ID));
	}

	/** Get C_Manage_Unit.
		@return C_Manage_Unit	  */
	public int getC_Manage_Unit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Manage_Unit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_ReqBudget_Mod.
		@param C_ReqBudget_Mod_ID C_ReqBudget_Mod	  */
	public void setC_ReqBudget_Mod_ID (int C_ReqBudget_Mod_ID)
	{
		if (C_ReqBudget_Mod_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_ID, Integer.valueOf(C_ReqBudget_Mod_ID));
	}

	/** Get C_ReqBudget_Mod.
		@return C_ReqBudget_Mod	  */
	public int getC_ReqBudget_Mod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ReqBudget_Mod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set GenerateMod.
		@param GenerateMod GenerateMod	  */
	public void setGenerateMod (String GenerateMod)
	{
		set_Value (COLUMNNAME_GenerateMod, GenerateMod);
	}

	/** Get GenerateMod.
		@return GenerateMod	  */
	public String getGenerateMod () 
	{
		return (String)get_Value(COLUMNNAME_GenerateMod);
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