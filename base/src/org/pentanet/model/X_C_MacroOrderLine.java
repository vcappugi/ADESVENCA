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

/** Generated Model for C_MacroOrderLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_C_MacroOrderLine extends PO implements I_C_MacroOrderLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20130912L;

    /** Standard Constructor */
    public X_C_MacroOrderLine (Properties ctx, int C_MacroOrderLine_ID, String trxName)
    {
      super (ctx, C_MacroOrderLine_ID, trxName);
      /** if (C_MacroOrderLine_ID == 0)
        {
			setC_MacroOrderLine_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_MacroOrderLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_MacroOrderLine[")
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

	public org.pentanet.model.I_C_MacroOrder getC_MacroOrder() throws RuntimeException
    {
		return (org.pentanet.model.I_C_MacroOrder)MTable.get(getCtx(), org.pentanet.model.I_C_MacroOrder.Table_Name)
			.getPO(getC_MacroOrder_ID(), get_TrxName());	}

	/** Set C_MacroOrder.
		@param C_MacroOrder_ID C_MacroOrder	  */
	public void setC_MacroOrder_ID (int C_MacroOrder_ID)
	{
		if (C_MacroOrder_ID < 1) 
			set_Value (COLUMNNAME_C_MacroOrder_ID, null);
		else 
			set_Value (COLUMNNAME_C_MacroOrder_ID, Integer.valueOf(C_MacroOrder_ID));
	}

	/** Get C_MacroOrder.
		@return C_MacroOrder	  */
	public int getC_MacroOrder_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_MacroOrder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_MacroOrderLine.
		@param C_MacroOrderLine_ID C_MacroOrderLine	  */
	public void setC_MacroOrderLine_ID (int C_MacroOrderLine_ID)
	{
		if (C_MacroOrderLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_MacroOrderLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_MacroOrderLine_ID, Integer.valueOf(C_MacroOrderLine_ID));
	}

	/** Get C_MacroOrderLine.
		@return C_MacroOrderLine	  */
	public int getC_MacroOrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_MacroOrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
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