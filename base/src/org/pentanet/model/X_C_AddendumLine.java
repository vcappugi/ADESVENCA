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

/** Generated Model for C_AddendumLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_AddendumLine extends PO implements I_C_AddendumLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160429L;

    /** Standard Constructor */
    public X_C_AddendumLine (Properties ctx, int C_AddendumLine_ID, String trxName)
    {
      super (ctx, C_AddendumLine_ID, trxName);
      /** if (C_AddendumLine_ID == 0)
        {
			setC_AddendumLine_ID (0);
			setC_AddendumType_ID (0);
			setC_Contract_ID (0);
			setM_Product_ID (0);
			setName (null);
			setProcessed (false);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_AddendumLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_AddendumLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set C_AddendumLine.
		@param C_AddendumLine_ID C_AddendumLine	  */
	public void setC_AddendumLine_ID (int C_AddendumLine_ID)
	{
		if (C_AddendumLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_AddendumLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_AddendumLine_ID, Integer.valueOf(C_AddendumLine_ID));
	}

	/** Get C_AddendumLine.
		@return C_AddendumLine	  */
	public int getC_AddendumLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AddendumLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_AddendumType getC_AddendumType() throws RuntimeException
    {
		return (org.pentanet.model.I_C_AddendumType)MTable.get(getCtx(), org.pentanet.model.I_C_AddendumType.Table_Name)
			.getPO(getC_AddendumType_ID(), get_TrxName());	}

	/** Set C_AddendumType.
		@param C_AddendumType_ID C_AddendumType	  */
	public void setC_AddendumType_ID (int C_AddendumType_ID)
	{
		if (C_AddendumType_ID < 1) 
			set_Value (COLUMNNAME_C_AddendumType_ID, null);
		else 
			set_Value (COLUMNNAME_C_AddendumType_ID, Integer.valueOf(C_AddendumType_ID));
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

	public org.pentanet.model.I_C_Contract getC_Contract() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Contract)MTable.get(getCtx(), org.pentanet.model.I_C_Contract.Table_Name)
			.getPO(getC_Contract_ID(), get_TrxName());	}

	/** Set C_Contract.
		@param C_Contract_ID C_Contract	  */
	public void setC_Contract_ID (int C_Contract_ID)
	{
		if (C_Contract_ID < 1) 
			set_Value (COLUMNNAME_C_Contract_ID, null);
		else 
			set_Value (COLUMNNAME_C_Contract_ID, Integer.valueOf(C_Contract_ID));
	}

	/** Get C_Contract.
		@return C_Contract	  */
	public int getC_Contract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Line Amount.
		@param LineNetAmt 
		Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public void setLineNetAmt (BigDecimal LineNetAmt)
	{
		set_Value (COLUMNNAME_LineNetAmt, LineNetAmt);
	}

	/** Get Line Amount.
		@return Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public BigDecimal getLineNetAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LineNetAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Line Amount Pure.
		@param LineNetAmt_Pure Line Amount Pure	  */
	public void setLineNetAmt_Pure (BigDecimal LineNetAmt_Pure)
	{
		set_Value (COLUMNNAME_LineNetAmt_Pure, LineNetAmt_Pure);
	}

	/** Get Line Amount Pure.
		@return Line Amount Pure	  */
	public BigDecimal getLineNetAmt_Pure () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LineNetAmt_Pure);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Line Amount USD.
		@param LineNetAmt_Usd Line Amount USD	  */
	public void setLineNetAmt_Usd (BigDecimal LineNetAmt_Usd)
	{
		set_Value (COLUMNNAME_LineNetAmt_Usd, LineNetAmt_Usd);
	}

	/** Get Line Amount USD.
		@return Line Amount USD	  */
	public BigDecimal getLineNetAmt_Usd () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LineNetAmt_Usd);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set MoveRate.
		@param MoveRate MoveRate	  */
	public void setMoveRate (BigDecimal MoveRate)
	{
		set_Value (COLUMNNAME_MoveRate, MoveRate);
	}

	/** Get MoveRate.
		@return MoveRate	  */
	public BigDecimal getMoveRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_MoveRate);
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

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Price_Pure.
		@param Price_Pure Price_Pure	  */
	public void setPrice_Pure (BigDecimal Price_Pure)
	{
		set_Value (COLUMNNAME_Price_Pure, Price_Pure);
	}

	/** Get Price_Pure.
		@return Price_Pure	  */
	public BigDecimal getPrice_Pure () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price_Pure);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Price_Usd.
		@param Price_Usd Price_Usd	  */
	public void setPrice_Usd (BigDecimal Price_Usd)
	{
		set_Value (COLUMNNAME_Price_Usd, Price_Usd);
	}

	/** Get Price_Usd.
		@return Price_Usd	  */
	public BigDecimal getPrice_Usd () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price_Usd);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_ValueNoCheck (COLUMNNAME_Processed, Boolean.valueOf(Processed));
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

	/** Set QtyPreinvoiced.
		@param QtyPreinvoiced QtyPreinvoiced	  */
	public void setQtyPreinvoiced (BigDecimal QtyPreinvoiced)
	{
		set_Value (COLUMNNAME_QtyPreinvoiced, QtyPreinvoiced);
	}

	/** Get QtyPreinvoiced.
		@return QtyPreinvoiced	  */
	public BigDecimal getQtyPreinvoiced () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyPreinvoiced);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ReducedRate.
		@param ReducedRate ReducedRate	  */
	public void setReducedRate (BigDecimal ReducedRate)
	{
		set_Value (COLUMNNAME_ReducedRate, ReducedRate);
	}

	/** Get ReducedRate.
		@return ReducedRate	  */
	public BigDecimal getReducedRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ReducedRate);
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