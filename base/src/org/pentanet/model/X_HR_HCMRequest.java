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

/** Generated Model for HR_HCMRequest
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_HCMRequest extends PO implements I_HR_HCMRequest, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150629L;

    /** Standard Constructor */
    public X_HR_HCMRequest (Properties ctx, int HR_HCMRequest_ID, String trxName)
    {
      super (ctx, HR_HCMRequest_ID, trxName);
      /** if (HR_HCMRequest_ID == 0)
        {
			setC_BPartner_ID (0);
			setCoverMonth (null);
			setDateDoc (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setExpMonth (null);
// 12
			setHR_HCMRequest_ID (0);
			setHR_HCMTabVersion_ID (0);
			setPercSalary (Env.ZERO);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_HCMRequest (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_HCMRequest[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** CoverMonth AD_Reference_ID=1000174 */
	public static final int COVERMONTH_AD_Reference_ID=1000174;
	/** Octubre = 01 */
	public static final String COVERMONTH_Octubre = "01";
	/** Noviembre = 02 */
	public static final String COVERMONTH_Noviembre = "02";
	/** Diciembre = 03 */
	public static final String COVERMONTH_Diciembre = "03";
	/** Enero = 04 */
	public static final String COVERMONTH_Enero = "04";
	/** Febrero = 05 */
	public static final String COVERMONTH_Febrero = "05";
	/** Marzo = 06 */
	public static final String COVERMONTH_Marzo = "06";
	/** Abril = 07 */
	public static final String COVERMONTH_Abril = "07";
	/** Mayo = 08 */
	public static final String COVERMONTH_Mayo = "08";
	/** Junio = 09 */
	public static final String COVERMONTH_Junio = "09";
	/** Julio = 10 */
	public static final String COVERMONTH_Julio = "10";
	/** Agosto = 11 */
	public static final String COVERMONTH_Agosto = "11";
	/** Septiembre = 12 */
	public static final String COVERMONTH_Septiembre = "12";
	/** Set CoverMonth.
		@param CoverMonth CoverMonth	  */
	public void setCoverMonth (String CoverMonth)
	{

		set_Value (COLUMNNAME_CoverMonth, CoverMonth);
	}

	/** Get CoverMonth.
		@return CoverMonth	  */
	public String getCoverMonth () 
	{
		return (String)get_Value(COLUMNNAME_CoverMonth);
	}

	/** CoverMonth1 AD_Reference_ID=1000174 */
	public static final int COVERMONTH1_AD_Reference_ID=1000174;
	/** Octubre = 01 */
	public static final String COVERMONTH1_Octubre = "01";
	/** Noviembre = 02 */
	public static final String COVERMONTH1_Noviembre = "02";
	/** Diciembre = 03 */
	public static final String COVERMONTH1_Diciembre = "03";
	/** Enero = 04 */
	public static final String COVERMONTH1_Enero = "04";
	/** Febrero = 05 */
	public static final String COVERMONTH1_Febrero = "05";
	/** Marzo = 06 */
	public static final String COVERMONTH1_Marzo = "06";
	/** Abril = 07 */
	public static final String COVERMONTH1_Abril = "07";
	/** Mayo = 08 */
	public static final String COVERMONTH1_Mayo = "08";
	/** Junio = 09 */
	public static final String COVERMONTH1_Junio = "09";
	/** Julio = 10 */
	public static final String COVERMONTH1_Julio = "10";
	/** Agosto = 11 */
	public static final String COVERMONTH1_Agosto = "11";
	/** Septiembre = 12 */
	public static final String COVERMONTH1_Septiembre = "12";
	/** Set CoverMonth1.
		@param CoverMonth1 CoverMonth1	  */
	public void setCoverMonth1 (String CoverMonth1)
	{

		set_Value (COLUMNNAME_CoverMonth1, CoverMonth1);
	}

	/** Get CoverMonth1.
		@return CoverMonth1	  */
	public String getCoverMonth1 () 
	{
		return (String)get_Value(COLUMNNAME_CoverMonth1);
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

	/** Set Distribute.
		@param Distribute Distribute	  */
	public void setDistribute (String Distribute)
	{
		set_Value (COLUMNNAME_Distribute, Distribute);
	}

	/** Get Distribute.
		@return Distribute	  */
	public String getDistribute () 
	{
		return (String)get_Value(COLUMNNAME_Distribute);
	}

	/** ExpMonth AD_Reference_ID=1000174 */
	public static final int EXPMONTH_AD_Reference_ID=1000174;
	/** Octubre = 01 */
	public static final String EXPMONTH_Octubre = "01";
	/** Noviembre = 02 */
	public static final String EXPMONTH_Noviembre = "02";
	/** Diciembre = 03 */
	public static final String EXPMONTH_Diciembre = "03";
	/** Enero = 04 */
	public static final String EXPMONTH_Enero = "04";
	/** Febrero = 05 */
	public static final String EXPMONTH_Febrero = "05";
	/** Marzo = 06 */
	public static final String EXPMONTH_Marzo = "06";
	/** Abril = 07 */
	public static final String EXPMONTH_Abril = "07";
	/** Mayo = 08 */
	public static final String EXPMONTH_Mayo = "08";
	/** Junio = 09 */
	public static final String EXPMONTH_Junio = "09";
	/** Julio = 10 */
	public static final String EXPMONTH_Julio = "10";
	/** Agosto = 11 */
	public static final String EXPMONTH_Agosto = "11";
	/** Septiembre = 12 */
	public static final String EXPMONTH_Septiembre = "12";
	/** Set ExpMonth.
		@param ExpMonth ExpMonth	  */
	public void setExpMonth (String ExpMonth)
	{

		set_Value (COLUMNNAME_ExpMonth, ExpMonth);
	}

	/** Get ExpMonth.
		@return ExpMonth	  */
	public String getExpMonth () 
	{
		return (String)get_Value(COLUMNNAME_ExpMonth);
	}

	/** ExpMonth1 AD_Reference_ID=1000174 */
	public static final int EXPMONTH1_AD_Reference_ID=1000174;
	/** Octubre = 01 */
	public static final String EXPMONTH1_Octubre = "01";
	/** Noviembre = 02 */
	public static final String EXPMONTH1_Noviembre = "02";
	/** Diciembre = 03 */
	public static final String EXPMONTH1_Diciembre = "03";
	/** Enero = 04 */
	public static final String EXPMONTH1_Enero = "04";
	/** Febrero = 05 */
	public static final String EXPMONTH1_Febrero = "05";
	/** Marzo = 06 */
	public static final String EXPMONTH1_Marzo = "06";
	/** Abril = 07 */
	public static final String EXPMONTH1_Abril = "07";
	/** Mayo = 08 */
	public static final String EXPMONTH1_Mayo = "08";
	/** Junio = 09 */
	public static final String EXPMONTH1_Junio = "09";
	/** Julio = 10 */
	public static final String EXPMONTH1_Julio = "10";
	/** Agosto = 11 */
	public static final String EXPMONTH1_Agosto = "11";
	/** Septiembre = 12 */
	public static final String EXPMONTH1_Septiembre = "12";
	/** Set ExpMonth1.
		@param ExpMonth1 ExpMonth1	  */
	public void setExpMonth1 (String ExpMonth1)
	{

		set_Value (COLUMNNAME_ExpMonth1, ExpMonth1);
	}

	/** Get ExpMonth1.
		@return ExpMonth1	  */
	public String getExpMonth1 () 
	{
		return (String)get_Value(COLUMNNAME_ExpMonth1);
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

	/** Set HR_HCMFamily.
		@param HR_HCMFamily_ID HR_HCMFamily	  */
	public void setHR_HCMFamily_ID (int HR_HCMFamily_ID)
	{
		if (HR_HCMFamily_ID < 1) 
			set_Value (COLUMNNAME_HR_HCMFamily_ID, null);
		else 
			set_Value (COLUMNNAME_HR_HCMFamily_ID, Integer.valueOf(HR_HCMFamily_ID));
	}

	/** Get HR_HCMFamily.
		@return HR_HCMFamily	  */
	public int getHR_HCMFamily_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMFamily_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_HCMRequest.
		@param HR_HCMRequest_ID HR_HCMRequest	  */
	public void setHR_HCMRequest_ID (int HR_HCMRequest_ID)
	{
		if (HR_HCMRequest_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_HCMRequest_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_HCMRequest_ID, Integer.valueOf(HR_HCMRequest_ID));
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

	public org.pentanet.model.I_HR_HCMTabVersion getHR_HCMTabVersion() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_HCMTabVersion)MTable.get(getCtx(), org.pentanet.model.I_HR_HCMTabVersion.Table_Name)
			.getPO(getHR_HCMTabVersion_ID(), get_TrxName());	}

	/** Set HR_HCMTabVersion.
		@param HR_HCMTabVersion_ID HR_HCMTabVersion	  */
	public void setHR_HCMTabVersion_ID (int HR_HCMTabVersion_ID)
	{
		if (HR_HCMTabVersion_ID < 1) 
			set_Value (COLUMNNAME_HR_HCMTabVersion_ID, null);
		else 
			set_Value (COLUMNNAME_HR_HCMTabVersion_ID, Integer.valueOf(HR_HCMTabVersion_ID));
	}

	/** Get HR_HCMTabVersion.
		@return HR_HCMTabVersion	  */
	public int getHR_HCMTabVersion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMTabVersion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IsApplied.
		@param IsApplied 
		Define si fue aplicado un medicamento del tratamiento
	  */
	public void setIsApplied (boolean IsApplied)
	{
		set_Value (COLUMNNAME_IsApplied, Boolean.valueOf(IsApplied));
	}

	/** Get IsApplied.
		@return Define si fue aplicado un medicamento del tratamiento
	  */
	public boolean isApplied () 
	{
		Object oo = get_Value(COLUMNNAME_IsApplied);
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

	/** Set PercSalary.
		@param PercSalary PercSalary	  */
	public void setPercSalary (BigDecimal PercSalary)
	{
		set_Value (COLUMNNAME_PercSalary, PercSalary);
	}

	/** Get PercSalary.
		@return PercSalary	  */
	public BigDecimal getPercSalary () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PercSalary);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set PercSalary2.
		@param PercSalary2 PercSalary2	  */
	public void setPercSalary2 (BigDecimal PercSalary2)
	{
		set_Value (COLUMNNAME_PercSalary2, PercSalary2);
	}

	/** Get PercSalary2.
		@return PercSalary2	  */
	public BigDecimal getPercSalary2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PercSalary2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set PercUtil.
		@param PercUtil PercUtil	  */
	public void setPercUtil (BigDecimal PercUtil)
	{
		set_Value (COLUMNNAME_PercUtil, PercUtil);
	}

	/** Get PercUtil.
		@return PercUtil	  */
	public BigDecimal getPercUtil () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PercUtil);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set PercUtil2.
		@param PercUtil2 PercUtil2	  */
	public void setPercUtil2 (BigDecimal PercUtil2)
	{
		set_Value (COLUMNNAME_PercUtil2, PercUtil2);
	}

	/** Get PercUtil2.
		@return PercUtil2	  */
	public BigDecimal getPercUtil2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PercUtil2);
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