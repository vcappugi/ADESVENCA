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

/** Generated Model for M_ProductTransp_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_M_ProductTransp_Line extends PO implements I_M_ProductTransp_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141007L;

    /** Standard Constructor */
    public X_M_ProductTransp_Line (Properties ctx, int M_ProductTransp_Line_ID, String trxName)
    {
      super (ctx, M_ProductTransp_Line_ID, trxName);
      /** if (M_ProductTransp_Line_ID == 0)
        {
			setC_JourneyManagement_Line_ID (0);
			setC_UOM_ID (0);
			setM_Product_ID (0);
			setM_ProductTransp_Line_ID (0);
			setM_ProductTransportation_ID (0);
			setQty (Env.ZERO);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_M_ProductTransp_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_ProductTransp_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.pentanet.model.I_C_JourneyManagement_Line getC_JourneyManagement_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_C_JourneyManagement_Line)MTable.get(getCtx(), org.pentanet.model.I_C_JourneyManagement_Line.Table_Name)
			.getPO(getC_JourneyManagement_Line_ID(), get_TrxName());	}

	/** Set C_JourneyManagement_Line.
		@param C_JourneyManagement_Line_ID C_JourneyManagement_Line	  */
	public void setC_JourneyManagement_Line_ID (int C_JourneyManagement_Line_ID)
	{
		if (C_JourneyManagement_Line_ID < 1) 
			set_Value (COLUMNNAME_C_JourneyManagement_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_JourneyManagement_Line_ID, Integer.valueOf(C_JourneyManagement_Line_ID));
	}

	/** Get C_JourneyManagement_Line.
		@return C_JourneyManagement_Line	  */
	public int getC_JourneyManagement_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_JourneyManagement_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
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

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_ProductTransp_Line.
		@param M_ProductTransp_Line_ID M_ProductTransp_Line	  */
	public void setM_ProductTransp_Line_ID (int M_ProductTransp_Line_ID)
	{
		if (M_ProductTransp_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_ProductTransp_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_ProductTransp_Line_ID, Integer.valueOf(M_ProductTransp_Line_ID));
	}

	/** Get M_ProductTransp_Line.
		@return M_ProductTransp_Line	  */
	public int getM_ProductTransp_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_ProductTransp_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_M_ProductTransportation getM_ProductTransportation() throws RuntimeException
    {
		return (org.pentanet.model.I_M_ProductTransportation)MTable.get(getCtx(), org.pentanet.model.I_M_ProductTransportation.Table_Name)
			.getPO(getM_ProductTransportation_ID(), get_TrxName());	}

	/** Set M_ProductTransportation.
		@param M_ProductTransportation_ID M_ProductTransportation	  */
	public void setM_ProductTransportation_ID (int M_ProductTransportation_ID)
	{
		if (M_ProductTransportation_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_ProductTransportation_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_ProductTransportation_ID, Integer.valueOf(M_ProductTransportation_ID));
	}

	/** Get M_ProductTransportation.
		@return M_ProductTransportation	  */
	public int getM_ProductTransportation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_ProductTransportation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Quantity.
		@param Qty 
		Quantity
	  */
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}

	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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