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

/** Generated Model for HR_Vacation
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_Vacation extends PO implements I_HR_Vacation, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140909L;

    /** Standard Constructor */
    public X_HR_Vacation (Properties ctx, int HR_Vacation_ID, String trxName)
    {
      super (ctx, HR_Vacation_ID, trxName);
      /** if (HR_Vacation_ID == 0)
        {
			setHR_Vacation_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Vacation (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_Vacation[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AdiDays.
		@param AdiDays AdiDays	  */
	public void setAdiDays (BigDecimal AdiDays)
	{
		set_Value (COLUMNNAME_AdiDays, AdiDays);
	}

	/** Get AdiDays.
		@return AdiDays	  */
	public BigDecimal getAdiDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AdiDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AntDays.
		@param AntDays AntDays	  */
	public void setAntDays (BigDecimal AntDays)
	{
		set_Value (COLUMNNAME_AntDays, AntDays);
	}

	/** Get AntDays.
		@return AntDays	  */
	public BigDecimal getAntDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AntDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set BonDays.
		@param BonDays BonDays	  */
	public void setBonDays (BigDecimal BonDays)
	{
		set_Value (COLUMNNAME_BonDays, BonDays);
	}

	/** Get BonDays.
		@return BonDays	  */
	public BigDecimal getBonDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BonDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getC_BPartner_ID()));
    }

	/** Set DateEnd.
		@param DateEnd DateEnd	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get DateEnd.
		@return DateEnd	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
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

	/** Set HR_Vacation.
		@param HR_Vacation_ID HR_Vacation	  */
	public void setHR_Vacation_ID (int HR_Vacation_ID)
	{
		if (HR_Vacation_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Vacation_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Vacation_ID, Integer.valueOf(HR_Vacation_ID));
	}

	/** Get HR_Vacation.
		@return HR_Vacation	  */
	public int getHR_Vacation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Vacation_ID);
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
		throw new IllegalArgumentException ("HR_ZonaOperacion_ID is virtual column");	}

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

	/** Set Paid.
		@param IsPaid 
		The document is paid
	  */
	public void setIsPaid (boolean IsPaid)
	{
		set_Value (COLUMNNAME_IsPaid, Boolean.valueOf(IsPaid));
	}

	/** Get Paid.
		@return The document is paid
	  */
	public boolean isPaid () 
	{
		Object oo = get_Value(COLUMNNAME_IsPaid);
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

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		throw new IllegalArgumentException ("StartDate is virtual column");	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}

	/** Set VacDays.
		@param VacDays VacDays	  */
	public void setVacDays (BigDecimal VacDays)
	{
		set_Value (COLUMNNAME_VacDays, VacDays);
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