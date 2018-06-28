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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_CompetitorCourses
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_CompetitorCourses extends PO implements I_HR_CompetitorCourses, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150828L;

    /** Standard Constructor */
    public X_HR_CompetitorCourses (Properties ctx, int HR_CompetitorCourses_ID, String trxName)
    {
      super (ctx, HR_CompetitorCourses_ID, trxName);
      /** if (HR_CompetitorCourses_ID == 0)
        {
			setC_Activity_ID (0);
			setC_BPartner_ID (0);
			setHR_CompetitorCourses_ID (0);
			setHR_TakenCourses_Line_ID (0);
			setIsCost (false);
// N
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_CompetitorCourses (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_CompetitorCourses[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set HR_CompetitorCourses.
		@param HR_CompetitorCourses_ID HR_CompetitorCourses	  */
	public void setHR_CompetitorCourses_ID (int HR_CompetitorCourses_ID)
	{
		if (HR_CompetitorCourses_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_CompetitorCourses_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_CompetitorCourses_ID, Integer.valueOf(HR_CompetitorCourses_ID));
	}

	/** Get HR_CompetitorCourses.
		@return HR_CompetitorCourses	  */
	public int getHR_CompetitorCourses_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_CompetitorCourses_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_TakenCourses getHR_TakenCourses() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_TakenCourses)MTable.get(getCtx(), org.pentanet.model.I_HR_TakenCourses.Table_Name)
			.getPO(getHR_TakenCourses_ID(), get_TrxName());	}

	/** Set HR_TakenCourses.
		@param HR_TakenCourses_ID HR_TakenCourses	  */
	public void setHR_TakenCourses_ID (int HR_TakenCourses_ID)
	{
		if (HR_TakenCourses_ID < 1) 
			set_Value (COLUMNNAME_HR_TakenCourses_ID, null);
		else 
			set_Value (COLUMNNAME_HR_TakenCourses_ID, Integer.valueOf(HR_TakenCourses_ID));
	}

	/** Get HR_TakenCourses.
		@return HR_TakenCourses	  */
	public int getHR_TakenCourses_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_TakenCourses_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_TakenCourses_Line getHR_TakenCourses_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_TakenCourses_Line)MTable.get(getCtx(), org.pentanet.model.I_HR_TakenCourses_Line.Table_Name)
			.getPO(getHR_TakenCourses_Line_ID(), get_TrxName());	}

	/** Set HR_TakenCourses_Line.
		@param HR_TakenCourses_Line_ID HR_TakenCourses_Line	  */
	public void setHR_TakenCourses_Line_ID (int HR_TakenCourses_Line_ID)
	{
		if (HR_TakenCourses_Line_ID < 1) 
			set_Value (COLUMNNAME_HR_TakenCourses_Line_ID, null);
		else 
			set_Value (COLUMNNAME_HR_TakenCourses_Line_ID, Integer.valueOf(HR_TakenCourses_Line_ID));
	}

	/** Get HR_TakenCourses_Line.
		@return HR_TakenCourses_Line	  */
	public int getHR_TakenCourses_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_TakenCourses_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IsCost.
		@param IsCost IsCost	  */
	public void setIsCost (boolean IsCost)
	{
		set_Value (COLUMNNAME_IsCost, Boolean.valueOf(IsCost));
	}

	/** Get IsCost.
		@return IsCost	  */
	public boolean isCost () 
	{
		Object oo = get_Value(COLUMNNAME_IsCost);
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