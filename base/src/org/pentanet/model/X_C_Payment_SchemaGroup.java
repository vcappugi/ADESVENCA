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

/** Generated Model for C_Payment_SchemaGroup
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Payment_SchemaGroup extends PO implements I_C_Payment_SchemaGroup, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150924L;

    /** Standard Constructor */
    public X_C_Payment_SchemaGroup (Properties ctx, int C_Payment_SchemaGroup_ID, String trxName)
    {
      super (ctx, C_Payment_SchemaGroup_ID, trxName);
      /** if (C_Payment_SchemaGroup_ID == 0)
        {
			setC_Payment_SchemaGroup_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Payment_SchemaGroup (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Payment_SchemaGroup[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount 
		Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.pentanet.model.I_C_Group_Line getC_Group_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Group_Line)MTable.get(getCtx(), org.pentanet.model.I_C_Group_Line.Table_Name)
			.getPO(getC_Group_Line_ID(), get_TrxName());	}

	/** Set C_Group_Line.
		@param C_Group_Line_ID C_Group_Line	  */
	public void setC_Group_Line_ID (int C_Group_Line_ID)
	{
		if (C_Group_Line_ID < 1) 
			set_Value (COLUMNNAME_C_Group_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_Group_Line_ID, Integer.valueOf(C_Group_Line_ID));
	}

	/** Get C_Group_Line.
		@return C_Group_Line	  */
	public int getC_Group_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Group_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payment Schema Group.
		@param C_Payment_SchemaGroup_ID Payment Schema Group	  */
	public void setC_Payment_SchemaGroup_ID (int C_Payment_SchemaGroup_ID)
	{
		if (C_Payment_SchemaGroup_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Payment_SchemaGroup_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_SchemaGroup_ID, Integer.valueOf(C_Payment_SchemaGroup_ID));
	}

	/** Get Payment Schema Group.
		@return Payment Schema Group	  */
	public int getC_Payment_SchemaGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_SchemaGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Payment_Schema getC_Payment_Schema() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Payment_Schema)MTable.get(getCtx(), org.pentanet.model.I_C_Payment_Schema.Table_Name)
			.getPO(getC_Payment_Schema_ID(), get_TrxName());	}

	/** Set C_Payment_Schema.
		@param C_Payment_Schema_ID C_Payment_Schema	  */
	public void setC_Payment_Schema_ID (int C_Payment_Schema_ID)
	{
		if (C_Payment_Schema_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_Schema_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_Schema_ID, Integer.valueOf(C_Payment_Schema_ID));
	}

	/** Get C_Payment_Schema.
		@return C_Payment_Schema	  */
	public int getC_Payment_Schema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_Schema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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