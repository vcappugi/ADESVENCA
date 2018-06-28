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
import org.compiere.util.KeyNamePair;
import org.compiere.util.DB;

/** Generated Model for H_Asigned_Budget
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Asigned_Budget extends PO implements I_H_Asigned_Budget, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111129L;

    /** Standard Constructor */
    public X_H_Asigned_Budget (Properties ctx, int H_Asigned_Budget_ID, String trxName)
    {
      super (ctx, H_Asigned_Budget_ID, trxName);
      /** if (H_Asigned_Budget_ID == 0)
        {
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setH_Asigned_Budget_ID (0);
			setName (null);
			setProcessed (false);
        } */
    }

    /** Load Constructor */
    public X_H_Asigned_Budget (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Asigned_Budget[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.pentanet.model.I_H_Admission getH_Admission() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Admission)MTable.get(getCtx(), org.pentanet.model.I_H_Admission.Table_Name)
			.getPO(getH_Admission_ID(), get_TrxName());	}

	/** Set H_Admission.
		@param H_Admission_ID H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID)
	{
		if (H_Admission_ID < 1) 
			set_Value (COLUMNNAME_H_Admission_ID, null);
		else 
			set_Value (COLUMNNAME_H_Admission_ID, Integer.valueOf(H_Admission_ID));
	}

	/** Get H_Admission.
		@return H_Admission	  */
	public int getH_Admission_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Admission_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_Asigned_Budget.
		@param H_Asigned_Budget_ID H_Asigned_Budget	  */
	public void setH_Asigned_Budget_ID (int H_Asigned_Budget_ID)
	{
		if (H_Asigned_Budget_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Asigned_Budget_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Asigned_Budget_ID, Integer.valueOf(H_Asigned_Budget_ID));
	}

	/** Get H_Asigned_Budget.
		@return H_Asigned_Budget	  */
	public int getH_Asigned_Budget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Asigned_Budget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Budget getH_Budget() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Budget)MTable.get(getCtx(), org.pentanet.model.I_H_Budget.Table_Name)
			.getPO(getH_Budget_ID(), get_TrxName());	}

	/** Set H_Budget.
		@param H_Budget_ID H_Budget	  */
	public void setH_Budget_ID (int H_Budget_ID)
	{
		if (H_Budget_ID < 1) 
			set_Value (COLUMNNAME_H_Budget_ID, null);
		else 
			set_Value (COLUMNNAME_H_Budget_ID, Integer.valueOf(H_Budget_ID));
	}

	/** Get H_Budget.
		@return H_Budget	  */
	public int getH_Budget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Budget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Diagnostic getH_Diagnostic() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Diagnostic)MTable.get(getCtx(), org.pentanet.model.I_H_Diagnostic.Table_Name)
			.getPO(getH_Diagnostic_ID(), get_TrxName());	}

	/** Set H_Diagnostic.
		@param H_Diagnostic_ID H_Diagnostic	  */
	public void setH_Diagnostic_ID (int H_Diagnostic_ID)
	{
		if (H_Diagnostic_ID < 1) 
			set_Value (COLUMNNAME_H_Diagnostic_ID, null);
		else 
			set_Value (COLUMNNAME_H_Diagnostic_ID, Integer.valueOf(H_Diagnostic_ID));
	}

	/** Get H_Diagnostic.
		@return H_Diagnostic	  */
	public int getH_Diagnostic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Diagnostic_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Get H_Diagnostic.
	@return H_Diagnostic	  */
public BigDecimal getTotal_Budget () 
{
	BigDecimal ii = (BigDecimal)get_Value(COLUMNNAME_Total_Budget);
	return ii;
}


	public org.pentanet.model.I_H_Patient getH_Patient() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Patient)MTable.get(getCtx(), org.pentanet.model.I_H_Patient.Table_Name)
			.getPO(getH_Patient_ID(), get_TrxName());	}

	/** Set H_Patient.
		@param H_Patient_ID H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID)
	{
		if (H_Patient_ID < 1) 
			set_Value (COLUMNNAME_H_Patient_ID, null);
		else 
			set_Value (COLUMNNAME_H_Patient_ID, Integer.valueOf(H_Patient_ID));
	}

	/** Set Total_Budget
	@param H_Asigned_Budget_ID	  */
public void setTotal_Budget ()
{
	String sql = "select sum(LineTotalAmt) from H_Asigned_Budget_line where H_Asigned_Budget_ID =" + getH_Asigned_Budget_ID();
	BigDecimal totalB = DB.getSQLValueBD(null, sql);
	set_Value(COLUMNNAME_Total_Budget, totalB);
	this.save();
	
}
public void setTotal_Budget (BigDecimal Total_Budget)
{
	set_Value(COLUMNNAME_Total_Budget, Total_Budget);
	
}
	
	/** Get H_Patient.
		@return H_Patient	  */
	public int getH_Patient_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Patient_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
	
	/** Set Assigned Budget Status.
	@param ABudgetStatus 
	The current status of the Assigned Budget
  */
	public void setABudgetStatus (String ABudgetStatus)
	{
	
		set_Value (COLUMNNAME_ABudgetStatus, ABudgetStatus);
	}
	
	/** Get Assigned Budget Status.
		@return The current status of the Assigned Budget
	  */
	public String getABudgetStatus () 
	{
		return (String)get_Value(COLUMNNAME_ABudgetStatus);
	}
	
	/** Set Price List Version.
	@param M_PriceList_Version_ID 
	Identifies a unique instance of a Price List
  */
	public void setM_PriceList_Version_ID (int M_PriceList_Version_ID)
	{
		if (M_PriceList_Version_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_PriceList_Version_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_PriceList_Version_ID, Integer.valueOf(M_PriceList_Version_ID));
	}
	
	/** Get Price List Version.
		@return Identifies a unique instance of a Price List
	  */
	public int getM_PriceList_Version_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_Version_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}