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

/** Generated Model for C_PreInvoiceLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_PreInvoiceLine extends PO implements I_C_PreInvoiceLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161221L;

    /** Standard Constructor */
    public X_C_PreInvoiceLine (Properties ctx, int C_PreInvoiceLine_ID, String trxName)
    {
      super (ctx, C_PreInvoiceLine_ID, trxName);
      /** if (C_PreInvoiceLine_ID == 0)
        {
			setC_PreInvoice_ID (0);
			setC_PreInvoiceLine_ID (0);
			setLineNetAmt (Env.ZERO);
			setLineNetAmt_Pure (Env.ZERO);
			setLineNetAmt_Usd (Env.ZERO);
			setPrice (Env.ZERO);
			setPrice_Pure (Env.ZERO);
			setPrice_Usd (Env.ZERO);
			setQty (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_C_PreInvoiceLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_PreInvoiceLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_Value (COLUMNNAME_C_Charge_ID, null);
		else 
			set_Value (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
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

	public org.pentanet.model.I_C_PreInvoiceG getC_PreInvoiceG() throws RuntimeException
    {
		return (org.pentanet.model.I_C_PreInvoiceG)MTable.get(getCtx(), org.pentanet.model.I_C_PreInvoiceG.Table_Name)
			.getPO(getC_PreInvoiceG_ID(), get_TrxName());	}

	/** Set PreInvoice Global.
		@param C_PreInvoiceG_ID PreInvoice Global	  */
	public void setC_PreInvoiceG_ID (int C_PreInvoiceG_ID)
	{
		if (C_PreInvoiceG_ID < 1) 
			set_Value (COLUMNNAME_C_PreInvoiceG_ID, null);
		else 
			set_Value (COLUMNNAME_C_PreInvoiceG_ID, Integer.valueOf(C_PreInvoiceG_ID));
	}

	/** Get PreInvoice Global.
		@return PreInvoice Global	  */
	public int getC_PreInvoiceG_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PreInvoiceG_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_PreInvoice getC_PreInvoice() throws RuntimeException
    {
		return (org.pentanet.model.I_C_PreInvoice)MTable.get(getCtx(), org.pentanet.model.I_C_PreInvoice.Table_Name)
			.getPO(getC_PreInvoice_ID(), get_TrxName());	}

	/** Set PreInvoice.
		@param C_PreInvoice_ID PreInvoice	  */
	public void setC_PreInvoice_ID (int C_PreInvoice_ID)
	{
		if (C_PreInvoice_ID < 1) 
			set_Value (COLUMNNAME_C_PreInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_PreInvoice_ID, Integer.valueOf(C_PreInvoice_ID));
	}

	/** Get PreInvoice.
		@return PreInvoice	  */
	public int getC_PreInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PreInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PreInvoice Line.
		@param C_PreInvoiceLine_ID PreInvoice Line	  */
	public void setC_PreInvoiceLine_ID (int C_PreInvoiceLine_ID)
	{
		if (C_PreInvoiceLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_PreInvoiceLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_PreInvoiceLine_ID, Integer.valueOf(C_PreInvoiceLine_ID));
	}

	/** Get PreInvoice Line.
		@return PreInvoice Line	  */
	public int getC_PreInvoiceLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PreInvoiceLine_ID);
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
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
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
}