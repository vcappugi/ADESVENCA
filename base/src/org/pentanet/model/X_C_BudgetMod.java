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
import org.compiere.util.KeyNamePair;

/** Generated Model for C_BudgetMod
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_BudgetMod extends PO implements I_C_BudgetMod, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180625L;

    /** Standard Constructor */
    public X_C_BudgetMod (Properties ctx, int C_BudgetMod_ID, String trxName)
    {
      super (ctx, C_BudgetMod_ID, trxName);
      /** if (C_BudgetMod_ID == 0)
        {
			setC_BudgetMod_ID (0);
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setName (null);
			setProcessed (false);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetMod (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetMod[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set C_BudgetMod.
		@param C_BudgetMod_ID C_BudgetMod	  */
	public void setC_BudgetMod_ID (int C_BudgetMod_ID)
	{
		if (C_BudgetMod_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetMod_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetMod_ID, Integer.valueOf(C_BudgetMod_ID));
	}

	/** Get C_BudgetMod.
		@return C_BudgetMod	  */
	public int getC_BudgetMod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetMod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_C_BudgetPublic getC_BudgetPublic() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic.Table_Name)
			.getPO(getC_BudgetPublic_ID(), get_TrxName());	}

	/** Set C_BudgetPublic.
		@param C_BudgetPublic_ID C_BudgetPublic	  */
	public void setC_BudgetPublic_ID (int C_BudgetPublic_ID)
	{
		if (C_BudgetPublic_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetPublic_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetPublic_ID, Integer.valueOf(C_BudgetPublic_ID));
	}

	/** Get C_BudgetPublic.
		@return C_BudgetPublic	  */
	public int getC_BudgetPublic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_ID);
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

	/** Set DateApproval.
		@param DateApproval DateApproval	  */
	public void setDateApproval (Timestamp DateApproval)
	{
		set_Value (COLUMNNAME_DateApproval, DateApproval);
	}

	/** Get DateApproval.
		@return DateApproval	  */
	public Timestamp getDateApproval () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateApproval);
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

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
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

	/** tipogasto AD_Reference_ID=1000244 */
	public static final int TIPOGASTO_AD_Reference_ID=1000244;
	/** Gastos de Capital = CA */
	public static final String TIPOGASTO_GastosDeCapital = "CA";
	/** Gastos Corrientes = CO */
	public static final String TIPOGASTO_GastosCorrientes = "CO";
	/** Set tipogasto.
		@param tipogasto tipogasto	  */
	public void settipogasto (String tipogasto)
	{

		set_Value (COLUMNNAME_tipogasto, tipogasto);
	}

	/** Get tipogasto.
		@return tipogasto	  */
	public String gettipogasto () 
	{
		return (String)get_Value(COLUMNNAME_tipogasto);
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