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

/** Generated Model for C_WorkDD_Cond
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_WorkDD_Cond extends PO implements I_C_WorkDD_Cond, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160505L;

    /** Standard Constructor */
    public X_C_WorkDD_Cond (Properties ctx, int C_WorkDD_Cond_ID, String trxName)
    {
      super (ctx, C_WorkDD_Cond_ID, trxName);
      /** if (C_WorkDD_Cond_ID == 0)
        {
			setCondType (null);
			setC_WorkDD_Cond_ID (0);
			setC_WorkDDG_ID (0);
			setEndDate (new Timestamp( System.currentTimeMillis() ));
			setStartDate (new Timestamp( System.currentTimeMillis() ));
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_WorkDD_Cond (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_WorkDD_Cond[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** CondType AD_Reference_ID=1000219 */
	public static final int CONDTYPE_AD_Reference_ID=1000219;
	/** Tasa Reduciada = TR */
	public static final String CONDTYPE_TasaReduciada = "TR";
	/** Mudanza = M */
	public static final String CONDTYPE_Mudanza = "M";
	/** Operación = O */
	public static final String CONDTYPE_Operación = "O";
	/** Tipo de Fluido = TF */
	public static final String CONDTYPE_TipoDeFluido = "TF";
	/** Set CondType.
		@param CondType CondType	  */
	public void setCondType (String CondType)
	{

		set_Value (COLUMNNAME_CondType, CondType);
	}

	/** Get CondType.
		@return CondType	  */
	public String getCondType () 
	{
		return (String)get_Value(COLUMNNAME_CondType);
	}

	public org.compiere.model.I_C_Phase getC_Phase() throws RuntimeException
    {
		return (org.compiere.model.I_C_Phase)MTable.get(getCtx(), org.compiere.model.I_C_Phase.Table_Name)
			.getPO(getC_Phase_ID(), get_TrxName());	}

	/** Set Standard Phase.
		@param C_Phase_ID 
		Standard Phase of the Project Type
	  */
	public void setC_Phase_ID (int C_Phase_ID)
	{
		if (C_Phase_ID < 1) 
			set_Value (COLUMNNAME_C_Phase_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phase_ID, Integer.valueOf(C_Phase_ID));
	}

	/** Get Standard Phase.
		@return Standard Phase of the Project Type
	  */
	public int getC_Phase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Day to Day Work Conditional.
		@param C_WorkDD_Cond_ID Day to Day Work Conditional	  */
	public void setC_WorkDD_Cond_ID (int C_WorkDD_Cond_ID)
	{
		if (C_WorkDD_Cond_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WorkDD_Cond_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WorkDD_Cond_ID, Integer.valueOf(C_WorkDD_Cond_ID));
	}

	/** Get Day to Day Work Conditional.
		@return Day to Day Work Conditional	  */
	public int getC_WorkDD_Cond_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDD_Cond_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_WorkDDG getC_WorkDDG() throws RuntimeException
    {
		return (org.pentanet.model.I_C_WorkDDG)MTable.get(getCtx(), org.pentanet.model.I_C_WorkDDG.Table_Name)
			.getPO(getC_WorkDDG_ID(), get_TrxName());	}

	/** Set Day to Day Work.
		@param C_WorkDDG_ID Day to Day Work	  */
	public void setC_WorkDDG_ID (int C_WorkDDG_ID)
	{
		if (C_WorkDDG_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDG_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDG_ID, Integer.valueOf(C_WorkDDG_ID));
	}

	/** Get Day to Day Work.
		@return Day to Day Work	  */
	public int getC_WorkDDG_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDDG_ID);
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

	/** Set GenerateVar.
		@param GenerateVar GenerateVar	  */
	public void setGenerateVar (String GenerateVar)
	{
		set_Value (COLUMNNAME_GenerateVar, GenerateVar);
	}

	/** Get GenerateVar.
		@return GenerateVar	  */
	public String getGenerateVar () 
	{
		return (String)get_Value(COLUMNNAME_GenerateVar);
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