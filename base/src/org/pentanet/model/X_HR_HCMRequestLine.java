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

/** Generated Model for HR_HCMRequestLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_HCMRequestLine extends PO implements I_HR_HCMRequestLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150331L;

    /** Standard Constructor */
    public X_HR_HCMRequestLine (Properties ctx, int HR_HCMRequestLine_ID, String trxName)
    {
      super (ctx, HR_HCMRequestLine_ID, trxName);
      /** if (HR_HCMRequestLine_ID == 0)
        {
			setHR_HCMRequestLine_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_HCMRequestLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_HCMRequestLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amt 
		Amount
	  */
	public void setAmt (BigDecimal Amt)
	{
		set_Value (COLUMNNAME_Amt, Amt);
	}

	/** Get Amount.
		@return Amount
	  */
	public BigDecimal getAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Amt_Ut.
		@param Amt_Ut Amt_Ut	  */
	public void setAmt_Ut (BigDecimal Amt_Ut)
	{
		set_Value (COLUMNNAME_Amt_Ut, Amt_Ut);
	}

	/** Get Amt_Ut.
		@return Amt_Ut	  */
	public BigDecimal getAmt_Ut () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amt_Ut);
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

	public org.pentanet.model.I_HR_Family getHR_Family1() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family1_ID(), get_TrxName());	}

	/** Set HR_Family1_ID.
		@param HR_Family1_ID HR_Family1_ID	  */
	public void setHR_Family1_ID (int HR_Family1_ID)
	{
		if (HR_Family1_ID < 1) 
			set_Value (COLUMNNAME_HR_Family1_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family1_ID, Integer.valueOf(HR_Family1_ID));
	}

	/** Get HR_Family1_ID.
		@return HR_Family1_ID	  */
	public int getHR_Family1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Family getHR_Family2() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family2_ID(), get_TrxName());	}

	/** Set HR_Family2_ID.
		@param HR_Family2_ID HR_Family2_ID	  */
	public void setHR_Family2_ID (int HR_Family2_ID)
	{
		if (HR_Family2_ID < 1) 
			set_Value (COLUMNNAME_HR_Family2_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family2_ID, Integer.valueOf(HR_Family2_ID));
	}

	/** Get HR_Family2_ID.
		@return HR_Family2_ID	  */
	public int getHR_Family2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Family getHR_Family3() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family3_ID(), get_TrxName());	}

	/** Set HR_Family3_ID.
		@param HR_Family3_ID HR_Family3_ID	  */
	public void setHR_Family3_ID (int HR_Family3_ID)
	{
		if (HR_Family3_ID < 1) 
			set_Value (COLUMNNAME_HR_Family3_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family3_ID, Integer.valueOf(HR_Family3_ID));
	}

	/** Get HR_Family3_ID.
		@return HR_Family3_ID	  */
	public int getHR_Family3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Family getHR_Family4() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family4_ID(), get_TrxName());	}

	/** Set HR_Family4_ID.
		@param HR_Family4_ID HR_Family4_ID	  */
	public void setHR_Family4_ID (int HR_Family4_ID)
	{
		if (HR_Family4_ID < 1) 
			set_Value (COLUMNNAME_HR_Family4_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family4_ID, Integer.valueOf(HR_Family4_ID));
	}

	/** Get HR_Family4_ID.
		@return HR_Family4_ID	  */
	public int getHR_Family4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Family getHR_Family() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family_ID(), get_TrxName());	}

	/** Set HR_Family.
		@param HR_Family_ID HR_Family	  */
	public void setHR_Family_ID (int HR_Family_ID)
	{
		if (HR_Family_ID < 1) 
			set_Value (COLUMNNAME_HR_Family_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family_ID, Integer.valueOf(HR_Family_ID));
	}

	/** Get HR_Family.
		@return HR_Family	  */
	public int getHR_Family_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_HCMRequest.
		@param HR_HCMRequest_ID HR_HCMRequest	  */
	public void setHR_HCMRequest_ID (int HR_HCMRequest_ID)
	{
		if (HR_HCMRequest_ID < 1) 
			set_Value (COLUMNNAME_HR_HCMRequest_ID, null);
		else 
			set_Value (COLUMNNAME_HR_HCMRequest_ID, Integer.valueOf(HR_HCMRequest_ID));
	}

	/** Get HR_HCMRequest.
		@return HR_HCMRequest	  */
	public int getHR_HCMRequest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMRequest_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_HCMRequestLine.
		@param HR_HCMRequestLine_ID HR_HCMRequestLine	  */
	public void setHR_HCMRequestLine_ID (int HR_HCMRequestLine_ID)
	{
		if (HR_HCMRequestLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_HCMRequestLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_HCMRequestLine_ID, Integer.valueOf(HR_HCMRequestLine_ID));
	}

	/** Get HR_HCMRequestLine.
		@return HR_HCMRequestLine	  */
	public int getHR_HCMRequestLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMRequestLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_HCMTabLine getHR_HCMTabLine() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_HCMTabLine)MTable.get(getCtx(), org.pentanet.model.I_HR_HCMTabLine.Table_Name)
			.getPO(getHR_HCMTabLine_ID(), get_TrxName());	}

	/** Set HR_HCMTabLine.
		@param HR_HCMTabLine_ID HR_HCMTabLine	  */
	public void setHR_HCMTabLine_ID (int HR_HCMTabLine_ID)
	{
		if (HR_HCMTabLine_ID < 1) 
			set_Value (COLUMNNAME_HR_HCMTabLine_ID, null);
		else 
			set_Value (COLUMNNAME_HR_HCMTabLine_ID, Integer.valueOf(HR_HCMTabLine_ID));
	}

	/** Get HR_HCMTabLine.
		@return HR_HCMTabLine	  */
	public int getHR_HCMTabLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMTabLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eevolution.model.I_HR_Process getHR_Process() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Process)MTable.get(getCtx(), org.eevolution.model.I_HR_Process.Table_Name)
			.getPO(getHR_Process_ID(), get_TrxName());	}

	/** Set Payroll Process.
		@param HR_Process_ID Payroll Process	  */
	public void setHR_Process_ID (int HR_Process_ID)
	{
		if (HR_Process_ID < 1) 
			set_Value (COLUMNNAME_HR_Process_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Process_ID, Integer.valueOf(HR_Process_ID));
	}

	/** Get Payroll Process.
		@return Payroll Process	  */
	public int getHR_Process_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set issalaryinteg.
		@param issalaryinteg issalaryinteg	  */
	public void setissalaryinteg (boolean issalaryinteg)
	{
		set_Value (COLUMNNAME_issalaryinteg, Boolean.valueOf(issalaryinteg));
	}

	/** Get issalaryinteg.
		@return issalaryinteg	  */
	public boolean issalaryinteg () 
	{
		Object oo = get_Value(COLUMNNAME_issalaryinteg);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Month_Aplication AD_Reference_ID=1000154 */
	public static final int MONTH_APLICATION_AD_Reference_ID=1000154;
	/** Enero = 01 */
	public static final String MONTH_APLICATION_Enero = "01";
	/** Febrero = 02 */
	public static final String MONTH_APLICATION_Febrero = "02";
	/** Marzo = 03 */
	public static final String MONTH_APLICATION_Marzo = "03";
	/** Abril = 04 */
	public static final String MONTH_APLICATION_Abril = "04";
	/** Mayo = 05 */
	public static final String MONTH_APLICATION_Mayo = "05";
	/** Junio = 06 */
	public static final String MONTH_APLICATION_Junio = "06";
	/** Julio = 07 */
	public static final String MONTH_APLICATION_Julio = "07";
	/** Agosto = 08 */
	public static final String MONTH_APLICATION_Agosto = "08";
	/** Septiembre = 09 */
	public static final String MONTH_APLICATION_Septiembre = "09";
	/** Octubre = 10 */
	public static final String MONTH_APLICATION_Octubre = "10";
	/** Noviembre = 11 */
	public static final String MONTH_APLICATION_Noviembre = "11";
	/** Diciembre = 12 */
	public static final String MONTH_APLICATION_Diciembre = "12";
	/** Set Month_Aplication.
		@param Month_Aplication Month_Aplication	  */
	public void setMonth_Aplication (String Month_Aplication)
	{

		set_Value (COLUMNNAME_Month_Aplication, Month_Aplication);
	}

	/** Get Month_Aplication.
		@return Month_Aplication	  */
	public String getMonth_Aplication () 
	{
		return (String)get_Value(COLUMNNAME_Month_Aplication);
	}

	/** Month_Orig AD_Reference_ID=1000174 */
	public static final int MONTH_ORIG_AD_Reference_ID=1000174;
	/** Octubre = 01 */
	public static final String MONTH_ORIG_Octubre = "01";
	/** Noviembre = 02 */
	public static final String MONTH_ORIG_Noviembre = "02";
	/** Diciembre = 03 */
	public static final String MONTH_ORIG_Diciembre = "03";
	/** Enero = 04 */
	public static final String MONTH_ORIG_Enero = "04";
	/** Febrero = 05 */
	public static final String MONTH_ORIG_Febrero = "05";
	/** Marzo = 06 */
	public static final String MONTH_ORIG_Marzo = "06";
	/** Abril = 07 */
	public static final String MONTH_ORIG_Abril = "07";
	/** Mayo = 08 */
	public static final String MONTH_ORIG_Mayo = "08";
	/** Junio = 09 */
	public static final String MONTH_ORIG_Junio = "09";
	/** Julio = 10 */
	public static final String MONTH_ORIG_Julio = "10";
	/** Agosto = 11 */
	public static final String MONTH_ORIG_Agosto = "11";
	/** Septiembre = 12 */
	public static final String MONTH_ORIG_Septiembre = "12";
	/** Set Month_Orig.
		@param Month_Orig Month_Orig	  */
	public void setMonth_Orig (String Month_Orig)
	{

		set_Value (COLUMNNAME_Month_Orig, Month_Orig);
	}

	/** Get Month_Orig.
		@return Month_Orig	  */
	public String getMonth_Orig () 
	{
		return (String)get_Value(COLUMNNAME_Month_Orig);
	}

	/** Set Percent.
		@param Percent 
		Percentage
	  */
	public void setPercent (BigDecimal Percent)
	{
		set_Value (COLUMNNAME_Percent, Percent);
	}

	/** Get Percent.
		@return Percentage
	  */
	public BigDecimal getPercent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Percent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Percent2.
		@param Percent2 
		Percentage
	  */
	public void setPercent2 (BigDecimal Percent2)
	{
		set_Value (COLUMNNAME_Percent2, Percent2);
	}

	/** Get Percent2.
		@return Percentage
	  */
	public BigDecimal getPercent2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Percent2);
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