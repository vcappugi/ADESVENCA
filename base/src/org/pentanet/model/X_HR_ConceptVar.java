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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_ConceptVar
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_ConceptVar extends PO implements I_HR_ConceptVar, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141120L;

    /** Standard Constructor */
    public X_HR_ConceptVar (Properties ctx, int HR_ConceptVar_ID, String trxName)
    {
      super (ctx, HR_ConceptVar_ID, trxName);
      /** if (HR_ConceptVar_ID == 0)
        {
			setHR_ConceptVar_ID (0);
			setName (null);
			setSQLVar (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_ConceptVar (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_ConceptVar[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set HR_ConceptVar.
		@param HR_ConceptVar_ID HR_ConceptVar	  */
	public void setHR_ConceptVar_ID (int HR_ConceptVar_ID)
	{
		if (HR_ConceptVar_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_ConceptVar_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_ConceptVar_ID, Integer.valueOf(HR_ConceptVar_ID));
	}

	/** Get HR_ConceptVar.
		@return HR_ConceptVar	  */
	public int getHR_ConceptVar_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_ConceptVar_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set IsGlobal.
		@param IsGlobal IsGlobal	  */
	public void setIsGlobal (boolean IsGlobal)
	{
		set_Value (COLUMNNAME_IsGlobal, Boolean.valueOf(IsGlobal));
	}

	/** Get IsGlobal.
		@return IsGlobal	  */
	public boolean isGlobal () 
	{
		Object oo = get_Value(COLUMNNAME_IsGlobal);
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

	/** Set QtyVar.
		@param QtyVar QtyVar	  */
	public void setQtyVar (BigDecimal QtyVar)
	{
		set_Value (COLUMNNAME_QtyVar, QtyVar);
	}

	/** Get QtyVar.
		@return QtyVar	  */
	public BigDecimal getQtyVar () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyVar);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set SQLVar.
		@param SQLVar SQLVar	  */
	public void setSQLVar (String SQLVar)
	{
		set_Value (COLUMNNAME_SQLVar, SQLVar);
	}

	/** Get SQLVar.
		@return SQLVar	  */
	public String getSQLVar () 
	{
		return (String)get_Value(COLUMNNAME_SQLVar);
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