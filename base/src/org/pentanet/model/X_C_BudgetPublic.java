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

/** Generated Model for C_BudgetPublic
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_BudgetPublic extends PO implements I_C_BudgetPublic, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171003L;

    /** Standard Constructor */
    public X_C_BudgetPublic (Properties ctx, int C_BudgetPublic_ID, String trxName)
    {
      super (ctx, C_BudgetPublic_ID, trxName);
      /** if (C_BudgetPublic_ID == 0)
        {
			setC_BudgetPublic_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetPublic (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetPublic[")
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

	/** BudgetPeriodType AD_Reference_ID=1000046 */
	public static final int BUDGETPERIODTYPE_AD_Reference_ID=1000046;
	/** ANUAL = A */
	public static final String BUDGETPERIODTYPE_ANUAL = "A";
	/** TRIMESTRAL = T */
	public static final String BUDGETPERIODTYPE_TRIMESTRAL = "T";
	/** SEMESTRAL = S */
	public static final String BUDGETPERIODTYPE_SEMESTRAL = "S";
	/** MENSUAL = M */
	public static final String BUDGETPERIODTYPE_MENSUAL = "M";
	/** Set BudgetPeriodType.
		@param BudgetPeriodType BudgetPeriodType	  */
	public void setBudgetPeriodType (String BudgetPeriodType)
	{

		set_Value (COLUMNNAME_BudgetPeriodType, BudgetPeriodType);
	}

	/** Get BudgetPeriodType.
		@return BudgetPeriodType	  */
	public String getBudgetPeriodType () 
	{
		return (String)get_Value(COLUMNNAME_BudgetPeriodType);
	}

	/** BudgetType AD_Reference_ID=1000043 */
	public static final int BUDGETTYPE_AD_Reference_ID=1000043;
	/** Ordinario = O */
	public static final String BUDGETTYPE_Ordinario = "O";
	/** Coordinado = C */
	public static final String BUDGETTYPE_Coordinado = "C";
	/** LAEE = L */
	public static final String BUDGETTYPE_LAEE = "L";
	/** FIDES = F */
	public static final String BUDGETTYPE_FIDES = "F";
	/** Set BudgetType.
		@param BudgetType BudgetType	  */
	public void setBudgetType (String BudgetType)
	{

		set_Value (COLUMNNAME_BudgetType, BudgetType);
	}

	/** Get BudgetType.
		@return BudgetType	  */
	public String getBudgetType () 
	{
		return (String)get_Value(COLUMNNAME_BudgetType);
	}

	public org.pentanet.model.I_C_BudgetP_Lot getC_BudgetP_Lot() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetP_Lot)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetP_Lot.Table_Name)
			.getPO(getC_BudgetP_Lot_ID(), get_TrxName());	}

	/** Set C_BudgetP_Lot.
		@param C_BudgetP_Lot_ID C_BudgetP_Lot	  */
	public void setC_BudgetP_Lot_ID (int C_BudgetP_Lot_ID)
	{
		if (C_BudgetP_Lot_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetP_Lot_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetP_Lot_ID, Integer.valueOf(C_BudgetP_Lot_ID));
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

	/** Set C_BudgetPublic.
		@param C_BudgetPublic_ID C_BudgetPublic	  */
	public void setC_BudgetPublic_ID (int C_BudgetPublic_ID)
	{
		if (C_BudgetPublic_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_ID, Integer.valueOf(C_BudgetPublic_ID));
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

	public org.pentanet.model.I_C_BudgetPublic getC_BudgetPublic_Source() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic.Table_Name)
			.getPO(getC_BudgetPublic_Source_ID(), get_TrxName());	}

	/** Set C_BudgetPublic_Source_ID.
		@param C_BudgetPublic_Source_ID C_BudgetPublic_Source_ID	  */
	public void setC_BudgetPublic_Source_ID (int C_BudgetPublic_Source_ID)
	{
		if (C_BudgetPublic_Source_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetPublic_Source_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetPublic_Source_ID, Integer.valueOf(C_BudgetPublic_Source_ID));
	}

	/** Get C_BudgetPublic_Source_ID.
		@return C_BudgetPublic_Source_ID	  */
	public int getC_BudgetPublic_Source_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_Source_ID);
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

	/** Class_Budget AD_Reference_ID=1000057 */
	public static final int CLASS_BUDGET_AD_Reference_ID=1000057;
	/** Proyecto = PR */
	public static final String CLASS_BUDGET_Proyecto = "PR";
	/** Accion Centralizada = AC */
	public static final String CLASS_BUDGET_AccionCentralizada = "AC";
	/** Accion Especifica = AE */
	public static final String CLASS_BUDGET_AccionEspecifica = "AE";
	/** Set Class_Budget.
		@param Class_Budget Class_Budget	  */
	public void setClass_Budget (String Class_Budget)
	{

		set_Value (COLUMNNAME_Class_Budget, Class_Budget);
	}

	/** Get Class_Budget.
		@return Class_Budget	  */
	public String getClass_Budget () 
	{
		return (String)get_Value(COLUMNNAME_Class_Budget);
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

	/** Set Date Confirm.
		@param DateConfirm 
		Date Confirm of this Order
	  */
	public void setDateConfirm (Timestamp DateConfirm)
	{
		set_Value (COLUMNNAME_DateConfirm, DateConfirm);
	}

	/** Get Date Confirm.
		@return Date Confirm of this Order
	  */
	public Timestamp getDateConfirm () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateConfirm);
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

	/** Set isCentralAction.
		@param isCentralAction isCentralAction	  */
	public void setisCentralAction (boolean isCentralAction)
	{
		set_Value (COLUMNNAME_isCentralAction, Boolean.valueOf(isCentralAction));
	}

	/** Get isCentralAction.
		@return isCentralAction	  */
	public boolean isCentralAction () 
	{
		Object oo = get_Value(COLUMNNAME_isCentralAction);
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