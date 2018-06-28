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

/** Generated Model for HR_Vacation_Incidence
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_Vacation_Incidence extends PO implements I_HR_Vacation_Incidence, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140321L;

    /** Standard Constructor */
    public X_HR_Vacation_Incidence (Properties ctx, int HR_Vacation_Incidence_ID, String trxName)
    {
      super (ctx, HR_Vacation_Incidence_ID, trxName);
      /** if (HR_Vacation_Incidence_ID == 0)
        {
			setHR_Vacation_Incidence_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Vacation_Incidence (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_Vacation_Incidence[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set DateEnd1.
		@param DateEnd1 DateEnd1	  */
	public void setDateEnd1 (Timestamp DateEnd1)
	{
		set_Value (COLUMNNAME_DateEnd1, DateEnd1);
	}

	/** Get DateEnd1.
		@return DateEnd1	  */
	public Timestamp getDateEnd1 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd1);
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

	/** Set DateStart1.
		@param DateStart1 DateStart1	  */
	public void setDateStart1 (Timestamp DateStart1)
	{
		set_Value (COLUMNNAME_DateStart1, DateStart1);
	}

	/** Get DateStart1.
		@return DateStart1	  */
	public Timestamp getDateStart1 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart1);
	}

	/** Set Date Start2.
		@param DateStart2 
		Date Start for this Order
	  */
	public void setDateStart2 (Timestamp DateStart2)
	{
		set_Value (COLUMNNAME_DateStart2, DateStart2);
	}

	/** Get Date Start2.
		@return Date Start for this Order
	  */
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

	/** Set HR_Vacation_Incidence.
		@param HR_Vacation_Incidence_ID HR_Vacation_Incidence	  */
	public void setHR_Vacation_Incidence_ID (int HR_Vacation_Incidence_ID)
	{
		if (HR_Vacation_Incidence_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Vacation_Incidence_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Vacation_Incidence_ID, Integer.valueOf(HR_Vacation_Incidence_ID));
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

	/** Set IsAnticipated.
		@param IsAnticipated IsAnticipated	  */
	public void setIsAnticipated (boolean IsAnticipated)
	{
		set_Value (COLUMNNAME_IsAnticipated, Boolean.valueOf(IsAnticipated));
	}

	/** Get IsAnticipated.
		@return IsAnticipated	  */
	public boolean isAnticipated () 
	{
		Object oo = get_Value(COLUMNNAME_IsAnticipated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsAutomaticGenerated.
		@param IsAutomaticGenerated IsAutomaticGenerated	  */
	public void setIsAutomaticGenerated (boolean IsAutomaticGenerated)
	{
		set_Value (COLUMNNAME_IsAutomaticGenerated, Boolean.valueOf(IsAutomaticGenerated));
	}

	/** Get IsAutomaticGenerated.
		@return IsAutomaticGenerated	  */
	public boolean isAutomaticGenerated () 
	{
		Object oo = get_Value(COLUMNNAME_IsAutomaticGenerated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsDisfrutated.
		@param IsDisfrutated IsDisfrutated	  */
	public void setIsDisfrutated (boolean IsDisfrutated)
	{
		set_Value (COLUMNNAME_IsDisfrutated, Boolean.valueOf(IsDisfrutated));
	}

	/** Get IsDisfrutated.
		@return IsDisfrutated	  */
	public boolean isDisfrutated () 
	{
		Object oo = get_Value(COLUMNNAME_IsDisfrutated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsProgramated.
		@param IsProgramated IsProgramated	  */
	public void setIsProgramated (boolean IsProgramated)
	{
		set_Value (COLUMNNAME_IsProgramated, Boolean.valueOf(IsProgramated));
	}

	/** Get IsProgramated.
		@return IsProgramated	  */
	public boolean isProgramated () 
	{
		Object oo = get_Value(COLUMNNAME_IsProgramated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsReprogManual.
		@param IsReprogManual IsReprogManual	  */
	public void setIsReprogManual (boolean IsReprogManual)
	{
		set_Value (COLUMNNAME_IsReprogManual, Boolean.valueOf(IsReprogManual));
	}

	/** Get IsReprogManual.
		@return IsReprogManual	  */
	public boolean isReprogManual () 
	{
		Object oo = get_Value(COLUMNNAME_IsReprogManual);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsReprogPay.
		@param IsReprogPay IsReprogPay	  */
	public void setIsReprogPay (boolean IsReprogPay)
	{
		set_Value (COLUMNNAME_IsReprogPay, Boolean.valueOf(IsReprogPay));
	}

	/** Get IsReprogPay.
		@return IsReprogPay	  */
	public boolean isReprogPay () 
	{
		Object oo = get_Value(COLUMNNAME_IsReprogPay);
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