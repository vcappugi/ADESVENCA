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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.util.Env;

/** Generated Model for M_Storage
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_M_Storage extends PO implements I_M_Storage, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150506L;

    /** Standard Constructor */
    public X_M_Storage (Properties ctx, int M_Storage_ID, String trxName)
    {
      super (ctx, M_Storage_ID, trxName);
      /** if (M_Storage_ID == 0)
        {
			setM_AttributeSetInstance_ID (0);
			setM_Locator_ID (0);
			setM_Product_ID (0);
			setQtyOnHand (Env.ZERO);
			setQtyOrdered (Env.ZERO);
			setQtyReserved (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_M_Storage (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_Storage[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException
    {
		return (org.compiere.model.I_C_Currency)MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
			.getPO(getC_Currency_ID(), get_TrxName());	}

	/** Set Currency.
		@param C_Currency_ID 
		The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Currency.
		@return The Currency for this record
	  */
	public int getC_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Cost_Pure.
		@param Cost_Pure Cost_Pure	  */
	public void setCost_Pure (BigDecimal Cost_Pure)
	{
		set_Value (COLUMNNAME_Cost_Pure, Cost_Pure);
	}

	/** Get Cost_Pure.
		@return Cost_Pure	  */
	public BigDecimal getCost_Pure () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Cost_Pure);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Cost_USD.
		@param Cost_USD Cost_USD	  */
	public void setCost_USD (BigDecimal Cost_USD)
	{
		set_Value (COLUMNNAME_Cost_USD, Cost_USD);
	}

	/** Get Cost_USD.
		@return Cost_USD	  */
	public BigDecimal getCost_USD () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Cost_USD);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Date last inventory count.
		@param DateLastInventory 
		Date of Last Inventory Count
	  */
	public void setDateLastInventory (Timestamp DateLastInventory)
	{
		set_Value (COLUMNNAME_DateLastInventory, DateLastInventory);
	}

	/** Get Date last inventory count.
		@return Date of Last Inventory Count
	  */
	public Timestamp getDateLastInventory () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastInventory);
	}

	/** Set Dist_Costo.
		@param Dist_Costo 
		Dist_Costo
	  */
	public void setDist_Costo (BigDecimal Dist_Costo)
	{
		set_Value (COLUMNNAME_Dist_Costo, Dist_Costo);
	}

	/** Get Dist_Costo.
		@return Dist_Costo
	  */
	public BigDecimal getDist_Costo () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Dist_Costo);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_M_AttributeSetInstance getM_AttributeSetInstance() throws RuntimeException
    {
		return (I_M_AttributeSetInstance)MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
			.getPO(getM_AttributeSetInstance_ID(), get_TrxName());	}

	/** Set Attribute Set Instance.
		@param M_AttributeSetInstance_ID 
		Product Attribute Set Instance
	  */
	public void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID)
	{
		if (M_AttributeSetInstance_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSetInstance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
	}

	/** Get Attribute Set Instance.
		@return Product Attribute Set Instance
	  */
	public int getM_AttributeSetInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_M_Locator getM_Locator() throws RuntimeException
    {
		return (I_M_Locator)MTable.get(getCtx(), I_M_Locator.Table_Name)
			.getPO(getM_Locator_ID(), get_TrxName());	}

	/** Set Locator.
		@param M_Locator_ID 
		Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID)
	{
		if (M_Locator_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Locator_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
	}

	/** Get Locator.
		@return Warehouse Locator
	  */
	public int getM_Locator_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Locator_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_Product_Cost.
		@param M_Product_Cost M_Product_Cost	  */
	public void setM_Product_Cost (BigDecimal M_Product_Cost)
	{
		set_Value (COLUMNNAME_M_Product_Cost, M_Product_Cost);
	}

	/** Get M_Product_Cost.
		@return M_Product_Cost	  */
	public BigDecimal getM_Product_Cost () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_M_Product_Cost);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set M_Product_Cost_Real.
		@param M_Product_Cost_Real M_Product_Cost_Real	  */
	public void setM_Product_Cost_Real (BigDecimal M_Product_Cost_Real)
	{
		set_Value (COLUMNNAME_M_Product_Cost_Real, M_Product_Cost_Real);
	}

	/** Get M_Product_Cost_Real.
		@return M_Product_Cost_Real	  */
	public BigDecimal getM_Product_Cost_Real () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_M_Product_Cost_Real);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

	/** Set On Hand Quantity.
		@param QtyOnHand 
		On Hand Quantity
	  */
	public void setQtyOnHand (BigDecimal QtyOnHand)
	{
		set_Value (COLUMNNAME_QtyOnHand, QtyOnHand);
	}

	/** Get On Hand Quantity.
		@return On Hand Quantity
	  */
	public BigDecimal getQtyOnHand () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyOnHand);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Ordered Quantity.
		@param QtyOrdered 
		Ordered Quantity
	  */
	public void setQtyOrdered (BigDecimal QtyOrdered)
	{
		set_ValueNoCheck (COLUMNNAME_QtyOrdered, QtyOrdered);
	}

	/** Get Ordered Quantity.
		@return Ordered Quantity
	  */
	public BigDecimal getQtyOrdered () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyOrdered);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Reserved Quantity.
		@param QtyReserved 
		Reserved Quantity
	  */
	public void setQtyReserved (BigDecimal QtyReserved)
	{
		set_ValueNoCheck (COLUMNNAME_QtyReserved, QtyReserved);
	}

	/** Get Reserved Quantity.
		@return Reserved Quantity
	  */
	public BigDecimal getQtyReserved () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyReserved);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}