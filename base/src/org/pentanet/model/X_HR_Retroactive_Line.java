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

/** Generated Model for HR_Retroactive_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_Retroactive_Line extends PO implements I_HR_Retroactive_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150413L;

    /** Standard Constructor */
    public X_HR_Retroactive_Line (Properties ctx, int HR_Retroactive_Line_ID, String trxName)
    {
      super (ctx, HR_Retroactive_Line_ID, trxName);
      /** if (HR_Retroactive_Line_ID == 0)
        {
			setHR_Retroactive_Line_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Retroactive_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_Retroactive_Line[")
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

	public org.pentanet.model.I_HR_Retroactive getHR_Retroactive() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Retroactive)MTable.get(getCtx(), org.pentanet.model.I_HR_Retroactive.Table_Name)
			.getPO(getHR_Retroactive_ID(), get_TrxName());	}

	/** Set HR_Retroactive.
		@param HR_Retroactive_ID HR_Retroactive	  */
	public void setHR_Retroactive_ID (int HR_Retroactive_ID)
	{
		if (HR_Retroactive_ID < 1) 
			set_Value (COLUMNNAME_HR_Retroactive_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Retroactive_ID, Integer.valueOf(HR_Retroactive_ID));
	}

	/** Get HR_Retroactive.
		@return HR_Retroactive	  */
	public int getHR_Retroactive_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Retroactive_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_Retroactive_Line.
		@param HR_Retroactive_Line_ID HR_Retroactive_Line	  */
	public void setHR_Retroactive_Line_ID (int HR_Retroactive_Line_ID)
	{
		if (HR_Retroactive_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Retroactive_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Retroactive_Line_ID, Integer.valueOf(HR_Retroactive_Line_ID));
	}

	/** Get HR_Retroactive_Line.
		@return HR_Retroactive_Line	  */
	public int getHR_Retroactive_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Retroactive_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IsProcess.
		@param IsProcess IsProcess	  */
	public void setIsProcess (boolean IsProcess)
	{
		set_Value (COLUMNNAME_IsProcess, Boolean.valueOf(IsProcess));
	}

	/** Get IsProcess.
		@return IsProcess	  */
	public boolean isProcess () 
	{
		Object oo = get_Value(COLUMNNAME_IsProcess);
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