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

/** Generated Model for HR_VacBonusAdvance
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_VacBonusAdvance extends PO implements I_HR_VacBonusAdvance, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140923L;

    /** Standard Constructor */
    public X_HR_VacBonusAdvance (Properties ctx, int HR_VacBonusAdvance_ID, String trxName)
    {
      super (ctx, HR_VacBonusAdvance_ID, trxName);
      /** if (HR_VacBonusAdvance_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_DocType_ID (0);
			setHR_VacBonusAdvance_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_VacBonusAdvance (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_VacBonusAdvance[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AmtSCAvailable.
		@param AmtSCAvailable AmtSCAvailable	  */
	public void setAmtSCAvailable (BigDecimal AmtSCAvailable)
	{
		set_Value (COLUMNNAME_AmtSCAvailable, AmtSCAvailable);
	}

	/** Get AmtSCAvailable.
		@return AmtSCAvailable	  */
	public BigDecimal getAmtSCAvailable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSCAvailable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtSCEstimated.
		@param AmtSCEstimated AmtSCEstimated	  */
	public void setAmtSCEstimated (BigDecimal AmtSCEstimated)
	{
		set_Value (COLUMNNAME_AmtSCEstimated, AmtSCEstimated);
	}

	/** Get AmtSCEstimated.
		@return AmtSCEstimated	  */
	public BigDecimal getAmtSCEstimated () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSCEstimated);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtSCRequired.
		@param AmtSCRequired AmtSCRequired	  */
	public void setAmtSCRequired (BigDecimal AmtSCRequired)
	{
		set_Value (COLUMNNAME_AmtSCRequired, AmtSCRequired);
	}

	/** Get AmtSCRequired.
		@return AmtSCRequired	  */
	public BigDecimal getAmtSCRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSCRequired);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiAvailable.
		@param AmtUtiAvailable AmtUtiAvailable	  */
	public void setAmtUtiAvailable (BigDecimal AmtUtiAvailable)
	{
		set_Value (COLUMNNAME_AmtUtiAvailable, AmtUtiAvailable);
	}

	/** Get AmtUtiAvailable.
		@return AmtUtiAvailable	  */
	public BigDecimal getAmtUtiAvailable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiAvailable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiCommitted.
		@param AmtUtiCommitted AmtUtiCommitted	  */
	public void setAmtUtiCommitted (BigDecimal AmtUtiCommitted)
	{
		set_Value (COLUMNNAME_AmtUtiCommitted, AmtUtiCommitted);
	}

	/** Get AmtUtiCommitted.
		@return AmtUtiCommitted	  */
	public BigDecimal getAmtUtiCommitted () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiCommitted);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiEstimated.
		@param AmtUtiEstimated AmtUtiEstimated	  */
	public void setAmtUtiEstimated (BigDecimal AmtUtiEstimated)
	{
		set_Value (COLUMNNAME_AmtUtiEstimated, AmtUtiEstimated);
	}

	/** Get AmtUtiEstimated.
		@return AmtUtiEstimated	  */
	public BigDecimal getAmtUtiEstimated () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiEstimated);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiGenEstimated.
		@param AmtUtiGenEstimated AmtUtiGenEstimated	  */
	public void setAmtUtiGenEstimated (BigDecimal AmtUtiGenEstimated)
	{
		set_Value (COLUMNNAME_AmtUtiGenEstimated, AmtUtiGenEstimated);
	}

	/** Get AmtUtiGenEstimated.
		@return AmtUtiGenEstimated	  */
	public BigDecimal getAmtUtiGenEstimated () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiGenEstimated);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiGenRequired.
		@param AmtUtiGenRequired AmtUtiGenRequired	  */
	public void setAmtUtiGenRequired (BigDecimal AmtUtiGenRequired)
	{
		set_Value (COLUMNNAME_AmtUtiGenRequired, AmtUtiGenRequired);
	}

	/** Get AmtUtiGenRequired.
		@return AmtUtiGenRequired	  */
	public BigDecimal getAmtUtiGenRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiGenRequired);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtUtiRequired.
		@param AmtUtiRequired AmtUtiRequired	  */
	public void setAmtUtiRequired (BigDecimal AmtUtiRequired)
	{
		set_Value (COLUMNNAME_AmtUtiRequired, AmtUtiRequired);
	}

	/** Get AmtUtiRequired.
		@return AmtUtiRequired	  */
	public BigDecimal getAmtUtiRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtUtiRequired);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacAvailable.
		@param AmtVacAvailable AmtVacAvailable	  */
	public void setAmtVacAvailable (BigDecimal AmtVacAvailable)
	{
		set_Value (COLUMNNAME_AmtVacAvailable, AmtVacAvailable);
	}

	/** Get AmtVacAvailable.
		@return AmtVacAvailable	  */
	public BigDecimal getAmtVacAvailable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacAvailable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacCommitted.
		@param AmtVacCommitted AmtVacCommitted	  */
	public void setAmtVacCommitted (BigDecimal AmtVacCommitted)
	{
		set_Value (COLUMNNAME_AmtVacCommitted, AmtVacCommitted);
	}

	/** Get AmtVacCommitted.
		@return AmtVacCommitted	  */
	public BigDecimal getAmtVacCommitted () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacCommitted);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacEstimated.
		@param AmtVacEstimated AmtVacEstimated	  */
	public void setAmtVacEstimated (BigDecimal AmtVacEstimated)
	{
		set_Value (COLUMNNAME_AmtVacEstimated, AmtVacEstimated);
	}

	/** Get AmtVacEstimated.
		@return AmtVacEstimated	  */
	public BigDecimal getAmtVacEstimated () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacEstimated);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtVacRequired.
		@param AmtVacRequired AmtVacRequired	  */
	public void setAmtVacRequired (BigDecimal AmtVacRequired)
	{
		set_Value (COLUMNNAME_AmtVacRequired, AmtVacRequired);
	}

	/** Get AmtVacRequired.
		@return AmtVacRequired	  */
	public BigDecimal getAmtVacRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtVacRequired);
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

	/** Set Date Required.
		@param DateRequired 
		Date when required
	  */
	public void setDateRequired (Timestamp DateRequired)
	{
		set_Value (COLUMNNAME_DateRequired, DateRequired);
	}

	/** Get Date Required.
		@return Date when required
	  */
	public Timestamp getDateRequired () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateRequired);
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

	public org.eevolution.model.I_HR_Department getHR_Department() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Department)MTable.get(getCtx(), org.eevolution.model.I_HR_Department.Table_Name)
			.getPO(getHR_Department_ID(), get_TrxName());	}

	/** Set Payroll Department.
		@param HR_Department_ID Payroll Department	  */
	public void setHR_Department_ID (int HR_Department_ID)
	{
		throw new IllegalArgumentException ("HR_Department_ID is virtual column");	}

	/** Get Payroll Department.
		@return Payroll Department	  */
	public int getHR_Department_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Department_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_VacBonusAdvance.
		@param HR_VacBonusAdvance_ID HR_VacBonusAdvance	  */
	public void setHR_VacBonusAdvance_ID (int HR_VacBonusAdvance_ID)
	{
		if (HR_VacBonusAdvance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacBonusAdvance_ID, Integer.valueOf(HR_VacBonusAdvance_ID));
	}

	/** Get HR_VacBonusAdvance.
		@return HR_VacBonusAdvance	  */
	public int getHR_VacBonusAdvance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacBonusAdvance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set QtyShareSC.
		@param QtyShareSC QtyShareSC	  */
	public void setQtyShareSC (BigDecimal QtyShareSC)
	{
		set_Value (COLUMNNAME_QtyShareSC, QtyShareSC);
	}

	/** Get QtyShareSC.
		@return QtyShareSC	  */
	public BigDecimal getQtyShareSC () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyShareSC);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total.
		@param Total Total	  */
	public void setTotal (BigDecimal Total)
	{
		set_Value (COLUMNNAME_Total, Total);
	}

	/** Get Total.
		@return Total	  */
	public BigDecimal getTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total);
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