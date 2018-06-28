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

/** Generated Model for C_AddendumType
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_AddendumType extends PO implements I_C_AddendumType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160429L;

    /** Standard Constructor */
    public X_C_AddendumType (Properties ctx, int C_AddendumType_ID, String trxName)
    {
      super (ctx, C_AddendumType_ID, trxName);
      /** if (C_AddendumType_ID == 0)
        {
			setAddendumType (null);
			setC_Addendum_ID (0);
			setC_AddendumType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_AddendumType (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_AddendumType[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** AddendumType AD_Reference_ID=1000221 */
	public static final int ADDENDUMTYPE_AD_Reference_ID=1000221;
	/** Tiempo = T */
	public static final String ADDENDUMTYPE_Tiempo = "T";
	/** Cantidad = C */
	public static final String ADDENDUMTYPE_Cantidad = "C";
	/** Alcance = A */
	public static final String ADDENDUMTYPE_Alcance = "A";
	/** Set AddendumType.
		@param AddendumType AddendumType	  */
	public void setAddendumType (String AddendumType)
	{

		set_Value (COLUMNNAME_AddendumType, AddendumType);
	}

	/** Get AddendumType.
		@return AddendumType	  */
	public String getAddendumType () 
	{
		return (String)get_Value(COLUMNNAME_AddendumType);
	}

	public org.pentanet.model.I_C_Addendum getC_Addendum() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Addendum)MTable.get(getCtx(), org.pentanet.model.I_C_Addendum.Table_Name)
			.getPO(getC_Addendum_ID(), get_TrxName());	}

	/** Set C_Addendum.
		@param C_Addendum_ID C_Addendum	  */
	public void setC_Addendum_ID (int C_Addendum_ID)
	{
		if (C_Addendum_ID < 1) 
			set_Value (COLUMNNAME_C_Addendum_ID, null);
		else 
			set_Value (COLUMNNAME_C_Addendum_ID, Integer.valueOf(C_Addendum_ID));
	}

	/** Get C_Addendum.
		@return C_Addendum	  */
	public int getC_Addendum_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Addendum_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_AddendumType.
		@param C_AddendumType_ID C_AddendumType	  */
	public void setC_AddendumType_ID (int C_AddendumType_ID)
	{
		if (C_AddendumType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_AddendumType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_AddendumType_ID, Integer.valueOf(C_AddendumType_ID));
	}

	/** Get C_AddendumType.
		@return C_AddendumType	  */
	public int getC_AddendumType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AddendumType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ComponentRate.
		@param ComponentRate ComponentRate	  */
	public void setComponentRate (BigDecimal ComponentRate)
	{
		set_Value (COLUMNNAME_ComponentRate, ComponentRate);
	}

	/** Get ComponentRate.
		@return ComponentRate	  */
	public BigDecimal getComponentRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ComponentRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Date To.
		@param DateTo Date To	  */
	public void setDateTo (Timestamp DateTo)
	{
		set_Value (COLUMNNAME_DateTo, DateTo);
	}

	/** Get Date To.
		@return Date To	  */
	public Timestamp getDateTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTo);
	}

	/** Set DaysW.
		@param DaysW DaysW	  */
	public void setDaysW (int DaysW)
	{
		set_Value (COLUMNNAME_DaysW, Integer.valueOf(DaysW));
	}

	/** Get DaysW.
		@return DaysW	  */
	public int getDaysW () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DaysW);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

	/** Set EndDateNew.
		@param EndDateNew EndDateNew	  */
	public void setEndDateNew (Timestamp EndDateNew)
	{
		set_Value (COLUMNNAME_EndDateNew, EndDateNew);
	}

	/** Get EndDateNew.
		@return EndDateNew	  */
	public Timestamp getEndDateNew () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDateNew);
	}

	/** Set GenerateLines.
		@param GenerateLines GenerateLines	  */
	public void setGenerateLines (String GenerateLines)
	{
		set_Value (COLUMNNAME_GenerateLines, GenerateLines);
	}

	/** Get GenerateLines.
		@return GenerateLines	  */
	public String getGenerateLines () 
	{
		return (String)get_Value(COLUMNNAME_GenerateLines);
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

	/** Set IsExternal.
		@param IsExternal IsExternal	  */
	public void setIsExternal (boolean IsExternal)
	{
		set_Value (COLUMNNAME_IsExternal, Boolean.valueOf(IsExternal));
	}

	/** Get IsExternal.
		@return IsExternal	  */
	public boolean isExternal () 
	{
		Object oo = get_Value(COLUMNNAME_IsExternal);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}

	/** Type AD_Reference_ID=1000222 */
	public static final int TYPE_AD_Reference_ID=1000222;
	/** Paralización = P */
	public static final String TYPE_Paralización = "P";
	/** Reactivación = R */
	public static final String TYPE_Reactivación = "R";
	/** Extensión = E */
	public static final String TYPE_Extensión = "E";
	/** Set Type.
		@param Type 
		Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
	}
}