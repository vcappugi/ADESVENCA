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

/** Generated Model for C_HesLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_HesLine extends PO implements I_C_HesLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160429L;

    /** Standard Constructor */
    public X_C_HesLine (Properties ctx, int C_HesLine_ID, String trxName)
    {
      super (ctx, C_HesLine_ID, trxName);
      /** if (C_HesLine_ID == 0)
        {
			setC_Hes_ID (0);
			setC_HesLine_ID (0);
			setLineNetAmt (Env.ZERO);
			setPrice (Env.ZERO);
			setQty (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_C_HesLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_HesLine[")
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

	public org.pentanet.model.I_C_Hes getC_Hes() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Hes)MTable.get(getCtx(), org.pentanet.model.I_C_Hes.Table_Name)
			.getPO(getC_Hes_ID(), get_TrxName());	}

	/** Set Hes.
		@param C_Hes_ID Hes	  */
	public void setC_Hes_ID (int C_Hes_ID)
	{
		if (C_Hes_ID < 1) 
			set_Value (COLUMNNAME_C_Hes_ID, null);
		else 
			set_Value (COLUMNNAME_C_Hes_ID, Integer.valueOf(C_Hes_ID));
	}

	/** Get Hes.
		@return Hes	  */
	public int getC_Hes_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Hes_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HesLine.
		@param C_HesLine_ID HesLine	  */
	public void setC_HesLine_ID (int C_HesLine_ID)
	{
		if (C_HesLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_HesLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_HesLine_ID, Integer.valueOf(C_HesLine_ID));
	}

	/** Get HesLine.
		@return HesLine	  */
	public int getC_HesLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_HesLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_PreInvoiceLineG getC_PreInvoiceLineG() throws RuntimeException
    {
		return (org.pentanet.model.I_C_PreInvoiceLineG)MTable.get(getCtx(), org.pentanet.model.I_C_PreInvoiceLineG.Table_Name)
			.getPO(getC_PreInvoiceLineG_ID(), get_TrxName());	}

	/** Set PreInvoice Global Line.
		@param C_PreInvoiceLineG_ID PreInvoice Global Line	  */
	public void setC_PreInvoiceLineG_ID (int C_PreInvoiceLineG_ID)
	{
		if (C_PreInvoiceLineG_ID < 1) 
			set_Value (COLUMNNAME_C_PreInvoiceLineG_ID, null);
		else 
			set_Value (COLUMNNAME_C_PreInvoiceLineG_ID, Integer.valueOf(C_PreInvoiceLineG_ID));
	}

	/** Get PreInvoice Global Line.
		@return PreInvoice Global Line	  */
	public int getC_PreInvoiceLineG_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PreInvoiceLineG_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ProjectLine getC_ProjectLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_ProjectLine)MTable.get(getCtx(), org.compiere.model.I_C_ProjectLine.Table_Name)
			.getPO(getC_ProjectLine_ID(), get_TrxName());	}

	/** Set Project Line.
		@param C_ProjectLine_ID 
		Task or step in a project
	  */
	public void setC_ProjectLine_ID (int C_ProjectLine_ID)
	{
		if (C_ProjectLine_ID < 1) 
			set_Value (COLUMNNAME_C_ProjectLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_ProjectLine_ID, Integer.valueOf(C_ProjectLine_ID));
	}

	/** Get Project Line.
		@return Task or step in a project
	  */
	public int getC_ProjectLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ProjectLine_ID);
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
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