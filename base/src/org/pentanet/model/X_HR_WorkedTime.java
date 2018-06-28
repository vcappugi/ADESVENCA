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

/** Generated Model for HR_WorkedTime
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_WorkedTime extends PO implements I_HR_WorkedTime, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140711L;

    /** Standard Constructor */
    public X_HR_WorkedTime (Properties ctx, int HR_WorkedTime_ID, String trxName)
    {
      super (ctx, HR_WorkedTime_ID, trxName);
      /** if (HR_WorkedTime_ID == 0)
        {
			setDateStart (new Timestamp( System.currentTimeMillis() ));
			setHR_Standing_ID (0);
			setHR_WorkedTime_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_WorkedTime (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_WorkedTime[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getApprove1() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getApprove1_ID(), get_TrxName());	}

	/** Set Approve1_ID.
		@param Approve1_ID Approve1_ID	  */
	public void setApprove1_ID (int Approve1_ID)
	{
		if (Approve1_ID < 1) 
			set_Value (COLUMNNAME_Approve1_ID, null);
		else 
			set_Value (COLUMNNAME_Approve1_ID, Integer.valueOf(Approve1_ID));
	}

	/** Get Approve1_ID.
		@return Approve1_ID	  */
	public int getApprove1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Approve1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getApprove2() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getApprove2_ID(), get_TrxName());	}

	/** Set Approve2_ID.
		@param Approve2_ID Approve2_ID	  */
	public void setApprove2_ID (int Approve2_ID)
	{
		if (Approve2_ID < 1) 
			set_Value (COLUMNNAME_Approve2_ID, null);
		else 
			set_Value (COLUMNNAME_Approve2_ID, Integer.valueOf(Approve2_ID));
	}

	/** Get Approve2_ID.
		@return Approve2_ID	  */
	public int getApprove2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Approve2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getApprovedBy() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getApprovedBy_ID(), get_TrxName());	}

	/** Set ApprovedBy_ID.
		@param ApprovedBy_ID ApprovedBy_ID	  */
	public void setApprovedBy_ID (int ApprovedBy_ID)
	{
		if (ApprovedBy_ID < 1) 
			set_Value (COLUMNNAME_ApprovedBy_ID, null);
		else 
			set_Value (COLUMNNAME_ApprovedBy_ID, Integer.valueOf(ApprovedBy_ID));
	}

	/** Get ApprovedBy_ID.
		@return ApprovedBy_ID	  */
	public int getApprovedBy_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ApprovedBy_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BtnApprove.
		@param BtnApprove BtnApprove	  */
	public void setBtnApprove (String BtnApprove)
	{
		set_Value (COLUMNNAME_BtnApprove, BtnApprove);
	}

	/** Get BtnApprove.
		@return BtnApprove	  */
	public String getBtnApprove () 
	{
		return (String)get_Value(COLUMNNAME_BtnApprove);
	}

	/** Set BtnElaborate.
		@param BtnElaborate BtnElaborate	  */
	public void setBtnElaborate (String BtnElaborate)
	{
		set_Value (COLUMNNAME_BtnElaborate, BtnElaborate);
	}

	/** Get BtnElaborate.
		@return BtnElaborate	  */
	public String getBtnElaborate () 
	{
		return (String)get_Value(COLUMNNAME_BtnElaborate);
	}

	/** Set BtnProcess.
		@param BtnProcess BtnProcess	  */
	public void setBtnProcess (String BtnProcess)
	{
		set_Value (COLUMNNAME_BtnProcess, BtnProcess);
	}

	/** Get BtnProcess.
		@return BtnProcess	  */
	public String getBtnProcess () 
	{
		return (String)get_Value(COLUMNNAME_BtnProcess);
	}

	/** Set BtnRevise.
		@param BtnRevise BtnRevise	  */
	public void setBtnRevise (String BtnRevise)
	{
		set_Value (COLUMNNAME_BtnRevise, BtnRevise);
	}

	/** Get BtnRevise.
		@return BtnRevise	  */
	public String getBtnRevise () 
	{
		return (String)get_Value(COLUMNNAME_BtnRevise);
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getC_Activity_ID(), get_TrxName());	}

	/** Set Activity.
		@param C_Activity_ID 
		Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1) 
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else 
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_AD_User getElaborate1() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getElaborate1_ID(), get_TrxName());	}

	/** Set Elaborate1_ID.
		@param Elaborate1_ID Elaborate1_ID	  */
	public void setElaborate1_ID (int Elaborate1_ID)
	{
		if (Elaborate1_ID < 1) 
			set_Value (COLUMNNAME_Elaborate1_ID, null);
		else 
			set_Value (COLUMNNAME_Elaborate1_ID, Integer.valueOf(Elaborate1_ID));
	}

	/** Get Elaborate1_ID.
		@return Elaborate1_ID	  */
	public int getElaborate1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Elaborate1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getElaborate2() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getElaborate2_ID(), get_TrxName());	}

	/** Set Elaborate2_ID.
		@param Elaborate2_ID Elaborate2_ID	  */
	public void setElaborate2_ID (int Elaborate2_ID)
	{
		if (Elaborate2_ID < 1) 
			set_Value (COLUMNNAME_Elaborate2_ID, null);
		else 
			set_Value (COLUMNNAME_Elaborate2_ID, Integer.valueOf(Elaborate2_ID));
	}

	/** Get Elaborate2_ID.
		@return Elaborate2_ID	  */
	public int getElaborate2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Elaborate2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getElaborate() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getElaboratedBy(), get_TrxName());	}

	/** Set ElaboratedBy.
		@param ElaboratedBy ElaboratedBy	  */
	public void setElaboratedBy (int ElaboratedBy)
	{
		set_Value (COLUMNNAME_ElaboratedBy, Integer.valueOf(ElaboratedBy));
	}

	/** Get ElaboratedBy.
		@return ElaboratedBy	  */
	public int getElaboratedBy () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ElaboratedBy);
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

	public org.eevolution.model.I_HR_Payroll getHR_Payroll() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Payroll)MTable.get(getCtx(), org.eevolution.model.I_HR_Payroll.Table_Name)
			.getPO(getHR_Payroll_ID(), get_TrxName());	}

	/** Set Payroll.
		@param HR_Payroll_ID Payroll	  */
	public void setHR_Payroll_ID (int HR_Payroll_ID)
	{
		if (HR_Payroll_ID < 1) 
			set_Value (COLUMNNAME_HR_Payroll_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Payroll_ID, Integer.valueOf(HR_Payroll_ID));
	}

	/** Get Payroll.
		@return Payroll	  */
	public int getHR_Payroll_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Payroll_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eevolution.model.I_HR_Period getHR_Period() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Period)MTable.get(getCtx(), org.eevolution.model.I_HR_Period.Table_Name)
			.getPO(getHR_Period_ID(), get_TrxName());	}

	/** Set Payroll Period.
		@param HR_Period_ID Payroll Period	  */
	public void setHR_Period_ID (int HR_Period_ID)
	{
		if (HR_Period_ID < 1) 
			set_Value (COLUMNNAME_HR_Period_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Period_ID, Integer.valueOf(HR_Period_ID));
	}

	/** Get Payroll Period.
		@return Payroll Period	  */
	public int getHR_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Standing getHR_Standing() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Standing)MTable.get(getCtx(), org.pentanet.model.I_HR_Standing.Table_Name)
			.getPO(getHR_Standing_ID(), get_TrxName());	}

	/** Set HR_Standing.
		@param HR_Standing_ID HR_Standing	  */
	public void setHR_Standing_ID (int HR_Standing_ID)
	{
		if (HR_Standing_ID < 1) 
			set_Value (COLUMNNAME_HR_Standing_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Standing_ID, Integer.valueOf(HR_Standing_ID));
	}

	/** Get HR_Standing.
		@return HR_Standing	  */
	public int getHR_Standing_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Standing_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_WorkedTime.
		@param HR_WorkedTime_ID HR_WorkedTime	  */
	public void setHR_WorkedTime_ID (int HR_WorkedTime_ID)
	{
		if (HR_WorkedTime_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTime_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTime_ID, Integer.valueOf(HR_WorkedTime_ID));
	}

	/** Get HR_WorkedTime.
		@return HR_WorkedTime	  */
	public int getHR_WorkedTime_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkedTime_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_WorkGroup getHR_WorkGroup() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_WorkGroup)MTable.get(getCtx(), org.pentanet.model.I_HR_WorkGroup.Table_Name)
			.getPO(getHR_WorkGroup_ID(), get_TrxName());	}

	/** Set HR_WorkGroup.
		@param HR_WorkGroup_ID HR_WorkGroup	  */
	public void setHR_WorkGroup_ID (int HR_WorkGroup_ID)
	{
		if (HR_WorkGroup_ID < 1) 
			set_Value (COLUMNNAME_HR_WorkGroup_ID, null);
		else 
			set_Value (COLUMNNAME_HR_WorkGroup_ID, Integer.valueOf(HR_WorkGroup_ID));
	}

	/** Get HR_WorkGroup.
		@return HR_WorkGroup	  */
	public int getHR_WorkGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkGroup_ID);
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

	/** Set IsElaborated.
		@param IsElaborated IsElaborated	  */
	public void setIsElaborated (boolean IsElaborated)
	{
		set_Value (COLUMNNAME_IsElaborated, Boolean.valueOf(IsElaborated));
	}

	/** Get IsElaborated.
		@return IsElaborated	  */
	public boolean isElaborated () 
	{
		Object oo = get_Value(COLUMNNAME_IsElaborated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set IsRevised.
		@param IsRevised IsRevised	  */
	public void setIsRevised (boolean IsRevised)
	{
		set_Value (COLUMNNAME_IsRevised, Boolean.valueOf(IsRevised));
	}

	/** Get IsRevised.
		@return IsRevised	  */
	public boolean isRevised () 
	{
		Object oo = get_Value(COLUMNNAME_IsRevised);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsWeek.
		@param IsWeek IsWeek	  */
	public void setIsWeek (boolean IsWeek)
	{
		set_Value (COLUMNNAME_IsWeek, Boolean.valueOf(IsWeek));
	}

	/** Get IsWeek.
		@return IsWeek	  */
	public boolean isWeek () 
	{
		Object oo = get_Value(COLUMNNAME_IsWeek);
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

	public org.compiere.model.I_AD_User getRevise1() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getRevise1_ID(), get_TrxName());	}

	/** Set Revise1_ID.
		@param Revise1_ID Revise1_ID	  */
	public void setRevise1_ID (int Revise1_ID)
	{
		if (Revise1_ID < 1) 
			set_Value (COLUMNNAME_Revise1_ID, null);
		else 
			set_Value (COLUMNNAME_Revise1_ID, Integer.valueOf(Revise1_ID));
	}

	/** Get Revise1_ID.
		@return Revise1_ID	  */
	public int getRevise1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Revise1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getRevise2() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getRevise2_ID(), get_TrxName());	}

	/** Set Revise2_ID.
		@param Revise2_ID Revise2_ID	  */
	public void setRevise2_ID (int Revise2_ID)
	{
		if (Revise2_ID < 1) 
			set_Value (COLUMNNAME_Revise2_ID, null);
		else 
			set_Value (COLUMNNAME_Revise2_ID, Integer.valueOf(Revise2_ID));
	}

	/** Get Revise2_ID.
		@return Revise2_ID	  */
	public int getRevise2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Revise2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getRevisedBy() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getRevisedBy_ID(), get_TrxName());	}

	/** Set RevisedBy_ID.
		@param RevisedBy_ID RevisedBy_ID	  */
	public void setRevisedBy_ID (int RevisedBy_ID)
	{
		if (RevisedBy_ID < 1) 
			set_Value (COLUMNNAME_RevisedBy_ID, null);
		else 
			set_Value (COLUMNNAME_RevisedBy_ID, Integer.valueOf(RevisedBy_ID));
	}

	/** Get RevisedBy_ID.
		@return RevisedBy_ID	  */
	public int getRevisedBy_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RevisedBy_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set UserLevel1.
		@param UserLevel1 UserLevel1	  */
	public void setUserLevel1 (int UserLevel1)
	{
		set_Value (COLUMNNAME_UserLevel1, Integer.valueOf(UserLevel1));
	}

	/** Get UserLevel1.
		@return UserLevel1	  */
	public int getUserLevel1 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_UserLevel1);
		if (ii == null)
			 return 0;
		return ii.intValue();
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