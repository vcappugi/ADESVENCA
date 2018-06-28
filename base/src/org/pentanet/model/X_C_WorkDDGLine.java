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

/** Generated Model for C_WorkDDGLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_WorkDDGLine extends PO implements I_C_WorkDDGLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161221L;

    /** Standard Constructor */
    public X_C_WorkDDGLine (Properties ctx, int C_WorkDDGLine_ID, String trxName)
    {
      super (ctx, C_WorkDDGLine_ID, trxName);
      /** if (C_WorkDDGLine_ID == 0)
        {
			setC_WorkDDGLine_ID (0);
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
    public X_C_WorkDDGLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_WorkDDGLine[")
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

	public org.pentanet.model.I_C_Contract_Var getC_Contract_Var() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Contract_Var)MTable.get(getCtx(), org.pentanet.model.I_C_Contract_Var.Table_Name)
			.getPO(getC_Contract_Var_ID(), get_TrxName());	}

	/** Set C_Contract_Var.
		@param C_Contract_Var_ID C_Contract_Var	  */
	public void setC_Contract_Var_ID (int C_Contract_Var_ID)
	{
		if (C_Contract_Var_ID < 1) 
			set_Value (COLUMNNAME_C_Contract_Var_ID, null);
		else 
			set_Value (COLUMNNAME_C_Contract_Var_ID, Integer.valueOf(C_Contract_Var_ID));
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
			set_ValueNoCheck (COLUMNNAME_C_Phase_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Phase_ID, Integer.valueOf(C_Phase_ID));
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

	public org.pentanet.model.I_C_WorkDDG getC_WorkDDG() throws RuntimeException
    {
		return (org.pentanet.model.I_C_WorkDDG)MTable.get(getCtx(), org.pentanet.model.I_C_WorkDDG.Table_Name)
			.getPO(getC_WorkDDG_ID(), get_TrxName());	}

	/** Set Day to Day Work.
		@param C_WorkDDG_ID Day to Day Work	  */
	public void setC_WorkDDG_ID (int C_WorkDDG_ID)
	{
		if (C_WorkDDG_ID < 1) 
			set_Value (COLUMNNAME_C_WorkDDG_ID, null);
		else 
			set_Value (COLUMNNAME_C_WorkDDG_ID, Integer.valueOf(C_WorkDDG_ID));
	}

	/** Get Day to Day Work.
		@return Day to Day Work	  */
	public int getC_WorkDDG_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDDG_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Day to Day Work Line.
		@param C_WorkDDGLine_ID Day to Day Work Line	  */
	public void setC_WorkDDGLine_ID (int C_WorkDDGLine_ID)
	{
		if (C_WorkDDGLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDGLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WorkDDGLine_ID, Integer.valueOf(C_WorkDDGLine_ID));
	}

	/** Get Day to Day Work Line.
		@return Day to Day Work Line	  */
	public int getC_WorkDDGLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WorkDDGLine_ID);
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

	/** Set IsAutomaticGenerated.
		@param IsAutomaticGenerated IsAutomaticGenerated	  */
	public void setIsAutomaticGenerated (boolean IsAutomaticGenerated)
	{
		set_Value (COLUMNNAME_IsAutomaticGenerated, Boolean.valueOf(IsAutomaticGenerated));
	}

	/** Get IsAutomaticGenerated.
		@return IsAutomaticGenerated	  */
	public boolean isAutomaticGenerated () 
	{
		Object oo = get_Value(COLUMNNAME_IsAutomaticGenerated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set IsMove.
		@param IsMove IsMove	  */
	public void setIsMove (boolean IsMove)
	{
		set_Value (COLUMNNAME_IsMove, Boolean.valueOf(IsMove));
	}

	/** Get IsMove.
		@return IsMove	  */
	public boolean isMove () 
	{
		Object oo = get_Value(COLUMNNAME_IsMove);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsReducedRate.
		@param IsReducedRate IsReducedRate	  */
	public void setIsReducedRate (boolean IsReducedRate)
	{
		set_Value (COLUMNNAME_IsReducedRate, Boolean.valueOf(IsReducedRate));
	}

	/** Get IsReducedRate.
		@return IsReducedRate	  */
	public boolean isReducedRate () 
	{
		Object oo = get_Value(COLUMNNAME_IsReducedRate);
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

	/** ItemType AD_Reference_ID=1000220 */
	public static final int ITEMTYPE_AD_Reference_ID=1000220;
	/** Equipo = EQ */
	public static final String ITEMTYPE_Equipo = "EQ";
	/** Servicio = S */
	public static final String ITEMTYPE_Servicio = "S";
	/** Personal = P */
	public static final String ITEMTYPE_Personal = "P";
	/** Trailer = T */
	public static final String ITEMTYPE_Trailer = "T";
	/** Producto Químico = PQ */
	public static final String ITEMTYPE_ProductoQuímico = "PQ";
	/** Set ItemType.
		@param ItemType ItemType	  */
	public void setItemType (String ItemType)
	{

		set_Value (COLUMNNAME_ItemType, ItemType);
	}

	/** Get ItemType.
		@return ItemType	  */
	public String getItemType () 
	{
		return (String)get_Value(COLUMNNAME_ItemType);
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

	/** Set Percent.
		@param Percent 
		Percentage
	  */
	public void setPercent (BigDecimal Percent)
	{
		set_Value (COLUMNNAME_Percent, Percent);
	}

	/** Get Percent.
		@return Percentage
	  */
	public BigDecimal getPercent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Percent);
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

	/** Set QtyPending.
		@param QtyPending QtyPending	  */
	public void setQtyPending (BigDecimal QtyPending)
	{
		set_Value (COLUMNNAME_QtyPending, QtyPending);
	}

	/** Get QtyPending.
		@return QtyPending	  */
	public BigDecimal getQtyPending () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyPending);
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
}