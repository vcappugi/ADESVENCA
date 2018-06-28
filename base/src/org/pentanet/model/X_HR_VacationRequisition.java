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

/** Generated Model for HR_VacationRequisition
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_VacationRequisition extends PO implements I_HR_VacationRequisition, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140909L;

    /** Standard Constructor */
    public X_HR_VacationRequisition (Properties ctx, int HR_VacationRequisition_ID, String trxName)
    {
      super (ctx, HR_VacationRequisition_ID, trxName);
      /** if (HR_VacationRequisition_ID == 0)
        {
			setC_BPartner_ID (0);
			setHR_VacationRequisition_ID (0);
			setRequisitionType (null);
// VPr
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_VacationRequisition (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_VacationRequisition[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BonDays.
		@param BonDays BonDays	  */
	public void setBonDays (BigDecimal BonDays)
	{
		throw new IllegalArgumentException ("BonDays is virtual column");	}

	/** Get BonDays.
		@return BonDays	  */
	public BigDecimal getBonDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BonDays);
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

	/** Set DateEnd2.
		@param DateEnd2 DateEnd2	  */
	public void setDateEnd2 (Timestamp DateEnd2)
	{
		set_Value (COLUMNNAME_DateEnd2, DateEnd2);
	}

	/** Get DateEnd2.
		@return DateEnd2	  */
	public Timestamp getDateEnd2 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd2);
	}

	/** Set DateEnd3.
		@param DateEnd3 DateEnd3	  */
	public void setDateEnd3 (Timestamp DateEnd3)
	{
		set_Value (COLUMNNAME_DateEnd3, DateEnd3);
	}

	/** Get DateEnd3.
		@return DateEnd3	  */
	public Timestamp getDateEnd3 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd3);
	}

	/** Set DateEnd4.
		@param DateEnd4 DateEnd4	  */
	public void setDateEnd4 (Timestamp DateEnd4)
	{
		set_Value (COLUMNNAME_DateEnd4, DateEnd4);
	}

	/** Get DateEnd4.
		@return DateEnd4	  */
	public Timestamp getDateEnd4 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd4);
	}

	/** Set DateEnd5.
		@param DateEnd5 DateEnd5	  */
	public void setDateEnd5 (Timestamp DateEnd5)
	{
		set_Value (COLUMNNAME_DateEnd5, DateEnd5);
	}

	/** Get DateEnd5.
		@return DateEnd5	  */
	public Timestamp getDateEnd5 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd5);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		throw new IllegalArgumentException ("DateStart is virtual column");	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
	}

	/** Set DateStart2.
		@param DateStart2 DateStart2	  */
	public void setDateStart2 (Timestamp DateStart2)
	{
		set_Value (COLUMNNAME_DateStart2, DateStart2);
	}

	/** Get DateStart2.
		@return DateStart2	  */
	public Timestamp getDateStart2 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart2);
	}

	/** Set DateStart3.
		@param DateStart3 DateStart3	  */
	public void setDateStart3 (Timestamp DateStart3)
	{
		set_Value (COLUMNNAME_DateStart3, DateStart3);
	}

	/** Get DateStart3.
		@return DateStart3	  */
	public Timestamp getDateStart3 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart3);
	}

	/** Set DateStart4.
		@param DateStart4 DateStart4	  */
	public void setDateStart4 (Timestamp DateStart4)
	{
		set_Value (COLUMNNAME_DateStart4, DateStart4);
	}

	/** Get DateStart4.
		@return DateStart4	  */
	public Timestamp getDateStart4 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart4);
	}

	/** Set DateStart5.
		@param DateStart5 DateStart5	  */
	public void setDateStart5 (Timestamp DateStart5)
	{
		set_Value (COLUMNNAME_DateStart5, DateStart5);
	}

	/** Get DateStart5.
		@return DateStart5	  */
	public Timestamp getDateStart5 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart5);
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

	public org.eevolution.model.I_HR_Job getHR_Job() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Job)MTable.get(getCtx(), org.eevolution.model.I_HR_Job.Table_Name)
			.getPO(getHR_Job_ID(), get_TrxName());	}

	/** Set Payroll Job.
		@param HR_Job_ID Payroll Job	  */
	public void setHR_Job_ID (int HR_Job_ID)
	{
		throw new IllegalArgumentException ("HR_Job_ID is virtual column");	}

	/** Get Payroll Job.
		@return Payroll Job	  */
	public int getHR_Job_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Job_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac1() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_PeriodVac)MTable.get(getCtx(), org.pentanet.model.I_HR_PeriodVac.Table_Name)
			.getPO(getHR_PeriodVac1_ID(), get_TrxName());	}

	/** Set HR_PeriodVac1_ID.
		@param HR_PeriodVac1_ID HR_PeriodVac1_ID	  */
	public void setHR_PeriodVac1_ID (int HR_PeriodVac1_ID)
	{
		if (HR_PeriodVac1_ID < 1) 
			set_Value (COLUMNNAME_HR_PeriodVac1_ID, null);
		else 
			set_Value (COLUMNNAME_HR_PeriodVac1_ID, Integer.valueOf(HR_PeriodVac1_ID));
	}

	/** Get HR_PeriodVac1_ID.
		@return HR_PeriodVac1_ID	  */
	public int getHR_PeriodVac1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodVac1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac2() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_PeriodVac)MTable.get(getCtx(), org.pentanet.model.I_HR_PeriodVac.Table_Name)
			.getPO(getHR_PeriodVac2_ID(), get_TrxName());	}

	/** Set HR_PeriodVac2_ID.
		@param HR_PeriodVac2_ID HR_PeriodVac2_ID	  */
	public void setHR_PeriodVac2_ID (int HR_PeriodVac2_ID)
	{
		if (HR_PeriodVac2_ID < 1) 
			set_Value (COLUMNNAME_HR_PeriodVac2_ID, null);
		else 
			set_Value (COLUMNNAME_HR_PeriodVac2_ID, Integer.valueOf(HR_PeriodVac2_ID));
	}

	/** Get HR_PeriodVac2_ID.
		@return HR_PeriodVac2_ID	  */
	public int getHR_PeriodVac2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodVac2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac3() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_PeriodVac)MTable.get(getCtx(), org.pentanet.model.I_HR_PeriodVac.Table_Name)
			.getPO(getHR_PeriodVac3_ID(), get_TrxName());	}

	/** Set HR_PeriodVac3_ID.
		@param HR_PeriodVac3_ID HR_PeriodVac3_ID	  */
	public void setHR_PeriodVac3_ID (int HR_PeriodVac3_ID)
	{
		if (HR_PeriodVac3_ID < 1) 
			set_Value (COLUMNNAME_HR_PeriodVac3_ID, null);
		else 
			set_Value (COLUMNNAME_HR_PeriodVac3_ID, Integer.valueOf(HR_PeriodVac3_ID));
	}

	/** Get HR_PeriodVac3_ID.
		@return HR_PeriodVac3_ID	  */
	public int getHR_PeriodVac3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodVac3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac4() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_PeriodVac)MTable.get(getCtx(), org.pentanet.model.I_HR_PeriodVac.Table_Name)
			.getPO(getHR_PeriodVac4_ID(), get_TrxName());	}

	/** Set HR_PeriodVac4_ID.
		@param HR_PeriodVac4_ID HR_PeriodVac4_ID	  */
	public void setHR_PeriodVac4_ID (int HR_PeriodVac4_ID)
	{
		if (HR_PeriodVac4_ID < 1) 
			set_Value (COLUMNNAME_HR_PeriodVac4_ID, null);
		else 
			set_Value (COLUMNNAME_HR_PeriodVac4_ID, Integer.valueOf(HR_PeriodVac4_ID));
	}

	/** Get HR_PeriodVac4_ID.
		@return HR_PeriodVac4_ID	  */
	public int getHR_PeriodVac4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodVac4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_PeriodVac)MTable.get(getCtx(), org.pentanet.model.I_HR_PeriodVac.Table_Name)
			.getPO(getHR_PeriodVac_ID(), get_TrxName());	}

	/** Set HR_PeriodVac.
		@param HR_PeriodVac_ID HR_PeriodVac	  */
	public void setHR_PeriodVac_ID (int HR_PeriodVac_ID)
	{
		if (HR_PeriodVac_ID < 1) 
			set_Value (COLUMNNAME_HR_PeriodVac_ID, null);
		else 
			set_Value (COLUMNNAME_HR_PeriodVac_ID, Integer.valueOf(HR_PeriodVac_ID));
	}

	/** Get HR_PeriodVac.
		@return HR_PeriodVac	  */
	public int getHR_PeriodVac_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_PeriodVac_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence2() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Vacation_Incidence)MTable.get(getCtx(), org.pentanet.model.I_HR_Vacation_Incidence.Table_Name)
			.getPO(getHR_Vacation_Incidence2_ID(), get_TrxName());	}

	/** Set HR_Vacation_Incidence2_ID.
		@param HR_Vacation_Incidence2_ID HR_Vacation_Incidence2_ID	  */
	public void setHR_Vacation_Incidence2_ID (int HR_Vacation_Incidence2_ID)
	{
		if (HR_Vacation_Incidence2_ID < 1) 
			set_Value (COLUMNNAME_HR_Vacation_Incidence2_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Vacation_Incidence2_ID, Integer.valueOf(HR_Vacation_Incidence2_ID));
	}

	/** Get HR_Vacation_Incidence3_ID.
		@return HR_Vacation_Incidence3_ID	  */
	public int getHR_Vacation_Incidence3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_Incidence3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence3() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Vacation_Incidence)MTable.get(getCtx(), org.pentanet.model.I_HR_Vacation_Incidence.Table_Name)
			.getPO(getHR_Vacation_Incidence2_ID(), get_TrxName());	}

	/** Set HR_Vacation_Incidence3_ID.
		@param HR_Vacation_Incidence3_ID HR_Vacation_Incidence2_ID	  */
	public void setHR_Vacation_Incidence3_ID (int HR_Vacation_Incidence3_ID)
	{
		if (HR_Vacation_Incidence3_ID < 1) 
			set_Value (COLUMNNAME_HR_Vacation_Incidence3_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Vacation_Incidence3_ID, Integer.valueOf(HR_Vacation_Incidence3_ID));
	}

	/** Get HR_Vacation_Incidence2_ID.
		@return HR_Vacation_Incidence2_ID	  */
	public int getHR_Vacation_Incidence2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_Incidence2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	
	
	
	
	

	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Vacation_Incidence)MTable.get(getCtx(), org.pentanet.model.I_HR_Vacation_Incidence.Table_Name)
			.getPO(getHR_Vacation_Incidence_ID(), get_TrxName());	}

	/** Set HR_Vacation_Incidence.
		@param HR_Vacation_Incidence_ID HR_Vacation_Incidence	  */
	public void setHR_Vacation_Incidence_ID (int HR_Vacation_Incidence_ID)
	{
		if (HR_Vacation_Incidence_ID < 1) 
			set_Value (COLUMNNAME_HR_Vacation_Incidence_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Vacation_Incidence_ID, Integer.valueOf(HR_Vacation_Incidence_ID));
	}

	/** Get HR_Vacation_Incidence.
		@return HR_Vacation_Incidence	  */
	public int getHR_Vacation_Incidence_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_Incidence_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_VacationRequisition.
		@param HR_VacationRequisition_ID HR_VacationRequisition	  */
	public void setHR_VacationRequisition_ID (int HR_VacationRequisition_ID)
	{
		if (HR_VacationRequisition_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_VacationRequisition_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_VacationRequisition_ID, Integer.valueOf(HR_VacationRequisition_ID));
	}

	/** Get HR_VacationRequisition.
		@return HR_VacationRequisition	  */
	public int getHR_VacationRequisition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_VacationRequisition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_ZonaOperacion getHR_ZonaOperacion() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_ZonaOperacion)MTable.get(getCtx(), org.pentanet.model.I_HR_ZonaOperacion.Table_Name)
			.getPO(getHR_ZonaOperacion_ID(), get_TrxName());	}

	/** Set HR_ZonaOperacion.
		@param HR_ZonaOperacion_ID HR_ZonaOperacion	  */
	public void setHR_ZonaOperacion_ID (int HR_ZonaOperacion_ID)
	{
		if (HR_ZonaOperacion_ID < 1) 
			set_Value (COLUMNNAME_HR_ZonaOperacion_ID, null);
		else 
			set_Value (COLUMNNAME_HR_ZonaOperacion_ID, Integer.valueOf(HR_ZonaOperacion_ID));
	}

	/** Get HR_ZonaOperacion.
		@return HR_ZonaOperacion	  */
	public int getHR_ZonaOperacion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_ZonaOperacion_ID);
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

	/** Set IsHavePenDays.
		@param IsHavePenDays IsHavePenDays	  */
	public void setIsHavePenDays (boolean IsHavePenDays)
	{
		set_Value (COLUMNNAME_IsHavePenDays, Boolean.valueOf(IsHavePenDays));
	}

	/** Get IsHavePenDays.
		@return IsHavePenDays	  */
	public boolean isHavePenDays () 
	{
		Object oo = get_Value(COLUMNNAME_IsHavePenDays);
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

	/** Set PenDays.
		@param PenDays PenDays	  */
	public void setPenDays (BigDecimal PenDays)
	{
		set_Value (COLUMNNAME_PenDays, PenDays);
	}

	/** Get PenDays.
		@return PenDays	  */
	public BigDecimal getPenDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PenDays);
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

	/** RequisitionType AD_Reference_ID=1000133 */
	public static final int REQUISITIONTYPE_AD_Reference_ID=1000133;
	/** Vacaciones Efectivas = VEf */
	public static final String REQUISITIONTYPE_VacacionesEfectivas = "VEf";
	/** Vacaciones Programadas = VPr */
	public static final String REQUISITIONTYPE_VacacionesProgramadas = "VPr";
	/** Reprogramación de Vacaciones = VRe */
	//public static final String REQUISITIONTYPE_ReprogramaciónDeVacaciones = "VRe";
	/** Vacaciones Anticipadas = VAn */
	public static final String REQUISITIONTYPE_VacacionesAnticipadas = "VAn";
	/** Set RequisitionType.
		@param RequisitionType RequisitionType	  */
	public void setRequisitionType (String RequisitionType)
	{

		set_Value (COLUMNNAME_RequisitionType, RequisitionType);
	}

	/** Get RequisitionType.
		@return RequisitionType	  */
	public String getRequisitionType () 
	{
		return (String)get_Value(COLUMNNAME_RequisitionType);
	}

	/** Set VacDays.
		@param VacDays VacDays	  */
	public void setVacDays (BigDecimal VacDays)
	{
		set_ValueNoCheck (COLUMNNAME_VacDays, VacDays);
	}

	/** Get VacDays.
		@return VacDays	  */
	public BigDecimal getVacDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_VacDays);
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