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

/** Generated Model for C_Contract_Var
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Contract_Var extends PO implements I_C_Contract_Var, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160505L;

    /** Standard Constructor */
    public X_C_Contract_Var (Properties ctx, int C_Contract_Var_ID, String trxName)
    {
      super (ctx, C_Contract_Var_ID, trxName);
      /** if (C_Contract_Var_ID == 0)
        {
			setC_Contract_Phase_ID (0);
			setC_Contract_Var_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Contract_Var (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Contract_Var[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.pentanet.model.I_C_ContractLine getC_ContractLine() throws RuntimeException
    {
		return (org.pentanet.model.I_C_ContractLine)MTable.get(getCtx(), org.pentanet.model.I_C_ContractLine.Table_Name)
			.getPO(getC_ContractLine_ID(), get_TrxName());	}

	/** Set C_ContractLine.
		@param C_ContractLine_ID C_ContractLine	  */
	public void setC_ContractLine_ID (int C_ContractLine_ID)
	{
		if (C_ContractLine_ID < 1) 
			set_Value (COLUMNNAME_C_ContractLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_ContractLine_ID, Integer.valueOf(C_ContractLine_ID));
	}

	/** Get C_ContractLine.
		@return C_ContractLine	  */
	public int getC_ContractLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ContractLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Contract_Phase getC_Contract_Phase() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Contract_Phase)MTable.get(getCtx(), org.pentanet.model.I_C_Contract_Phase.Table_Name)
			.getPO(getC_Contract_Phase_ID(), get_TrxName());	}

	/** Set Contract Phase.
		@param C_Contract_Phase_ID Contract Phase	  */
	public void setC_Contract_Phase_ID (int C_Contract_Phase_ID)
	{
		if (C_Contract_Phase_ID < 1) 
			set_Value (COLUMNNAME_C_Contract_Phase_ID, null);
		else 
			set_Value (COLUMNNAME_C_Contract_Phase_ID, Integer.valueOf(C_Contract_Phase_ID));
	}

	/** Get Contract Phase.
		@return Contract Phase	  */
	public int getC_Contract_Phase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_Phase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Contract_Var.
		@param C_Contract_Var_ID C_Contract_Var	  */
	public void setC_Contract_Var_ID (int C_Contract_Var_ID)
	{
		if (C_Contract_Var_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Contract_Var_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Contract_Var_ID, Integer.valueOf(C_Contract_Var_ID));
	}

	/** Get C_Contract_Var.
		@return C_Contract_Var	  */
	public int getC_Contract_Var_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_Var_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Calculated.
		@param IsCalculated 
		The value is calculated by the system
	  */
	public void setIsCalculated (boolean IsCalculated)
	{
		set_Value (COLUMNNAME_IsCalculated, Boolean.valueOf(IsCalculated));
	}

	/** Get Calculated.
		@return The value is calculated by the system
	  */
	public boolean isCalculated () 
	{
		Object oo = get_Value(COLUMNNAME_IsCalculated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsVar.
		@param IsVar IsVar	  */
	public void setIsVar (boolean IsVar)
	{
		set_Value (COLUMNNAME_IsVar, Boolean.valueOf(IsVar));
	}

	/** Get IsVar.
		@return IsVar	  */
	public boolean isVar () 
	{
		Object oo = get_Value(COLUMNNAME_IsVar);
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

	/** Set Script.
		@param Script 
		Dynamic Java Language Script to calculate result
	  */
	public void setScript (String Script)
	{
		set_Value (COLUMNNAME_Script, Script);
	}

	/** Get Script.
		@return Dynamic Java Language Script to calculate result
	  */
	public String getScript () 
	{
		return (String)get_Value(COLUMNNAME_Script);
	}

	/** Set Validate.
		@param Validate Validate	  */
	public void setValidate (String Validate)
	{
		set_Value (COLUMNNAME_Validate, Validate);
	}

	/** Get Validate.
		@return Validate	  */
	public String getValidate () 
	{
		return (String)get_Value(COLUMNNAME_Validate);
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