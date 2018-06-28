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

/** Generated Model for C_WorkDDLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_WorkDDLine extends PO implements I_C_WorkDDLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161221L;

    /** Standard Constructor */
    public X_C_WorkDDLine (Properties ctx, int C_WorkDDLine_ID, String trxName)
    {
      super (ctx, C_WorkDDLine_ID, trxName);
      /** if (C_WorkDDLine_ID == 0)
        {
			setC_Charge_ID (0);
			setC_ContractLine_ID (0);
			setC_WorkDDLine_ID (0);
			setIsWorkingHours (false);
// N
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
    public X_C_WorkDDLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_WorkDDLine[")
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

	public org.compiere.model.I_C_Phase getC_Phase() throws RuntimeException
    {
		return (org.compiere.model.I_C_Phase)MTable.get(getCtx(), org.compiere.model.I_C_Phase.Table_Name)
			.getPO(getC_Phase_ID(), get_TrxName());	}

	/** Set Standard Phase.
		@param C_Phase_ID 
		Standard Phase of the Project Type
	  */
	public void setC_Phase_ID (int C_Phase_ID)
	{
		if (C_Phase_ID < 1) 
			set_Value (COLUMNNAME_C_Phase_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phase_ID, Integer.valueOf(C_Phase_ID));
	}

	/** Get Standard Phase.
		@return Standard Phase of the Project Type
	  */
	public int getC_Phase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phase_ID);
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

	public org.pentanet.model.I_C_PreInvoiceLine getC_PreInvoiceLine() throws RuntimeException
    {
		return (org.pentanet.model.I_C_PreInvoiceLine)MTable.get(getCtx(), org.pentanet.model.I_C_PreInvoiceLine.Table_Name)
			.getPO(getC_PreInvoiceLine_ID(), get_TrxName());	}

	/** Set PreInvoice Line.
		@param C_PreInvoiceLine_ID PreInvoice Line	  */
	public void setC_PreInvoiceLine_ID (int C_PreInvoiceLine_ID)
	{
		if (C_PreInvoiceLine_ID < 1) 
			set_Value (COLUMNNAME_C_PreInvoiceLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_PreInvoiceLine_ID, Integer.valueOf(C_PreInvoiceLine_ID));
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

	public org.pentanet.model.I_C_WorkDD getC_WorkDD() throws RuntimeException
    {
		return (org.pentanet.model.I_C_WorkDD)MTable.get(getCtx(), org.pentanet.model.I_C_WorkDD.Table_Name)
			.getPO(getC_WorkDD_ID(), get_TrxName());	}

	/** Set Day to Day Work.
		@param C_WorkDD_ID Day to Day Work	  */
	public void setC_WorkDD_ID (int C_WorkDD_ID)
	{
		if (C_WorkDD_ID < 1) 
			set_Value (COLUMNNAME_C_WorkDD_ID, null);
		else 
			set_Value (COLUMNNAME_C_WorkDD_ID, Integer.valueOf(C_WorkDD_ID));
	}

	/** Get Day to Day Work.
		@return Day to Day Work	  */
	public int getC_WorkDD_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDD_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Day to Day Work Line.
		@param C_WorkDDLine_ID Day to Day Work Line	  */
	public void setC_WorkDDLine_ID (int C_WorkDDLine_ID)
	{
		if (C_WorkDDLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDLine_ID, Integer.valueOf(C_WorkDDLine_ID));
	}

	/** Get Day to Day Work Line.
		@return Day to Day Work Line	  */
	public int getC_WorkDDLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDDLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Hours.
		@param Hours Hours	  */
	public void setHours (BigDecimal Hours)
	{
		set_Value (COLUMNNAME_Hours, Hours);
	}

	/** Get Hours.
		@return Hours	  */
	public BigDecimal getHours () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Hours);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set IsWorkingHours.
		@param IsWorkingHours IsWorkingHours	  */
	public void setIsWorkingHours (boolean IsWorkingHours)
	{
		set_Value (COLUMNNAME_IsWorkingHours, Boolean.valueOf(IsWorkingHours));
	}

	/** Get IsWorkingHours.
		@return IsWorkingHours	  */
	public boolean isWorkingHours () 
	{
		Object oo = get_Value(COLUMNNAME_IsWorkingHours);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set QtyEquipment.
		@param QtyEquipment QtyEquipment	  */
	public void setQtyEquipment (BigDecimal QtyEquipment)
	{
		set_Value (COLUMNNAME_QtyEquipment, QtyEquipment);
	}

	/** Get QtyEquipment.
		@return QtyEquipment	  */
	public BigDecimal getQtyEquipment () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyEquipment);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyHoursForDay.
		@param QtyHoursForDay QtyHoursForDay	  */
	public void setQtyHoursForDay (BigDecimal QtyHoursForDay)
	{
		set_Value (COLUMNNAME_QtyHoursForDay, QtyHoursForDay);
	}

	/** Get QtyHoursForDay.
		@return QtyHoursForDay	  */
	public BigDecimal getQtyHoursForDay () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyHoursForDay);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Recalculate.
		@param Recalculate Recalculate	  */
	public void setRecalculate (String Recalculate)
	{
		set_Value (COLUMNNAME_Recalculate, Recalculate);
	}

	/** Get Recalculate.
		@return Recalculate	  */
	public String getRecalculate () 
	{
		return (String)get_Value(COLUMNNAME_Recalculate);
	}
}