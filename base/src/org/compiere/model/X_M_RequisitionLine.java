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
import java.util.Properties;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for M_RequisitionLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_M_RequisitionLine extends PO implements I_M_RequisitionLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151016L;

    /** Standard Constructor */
    public X_M_RequisitionLine (Properties ctx, int M_RequisitionLine_ID, String trxName)
    {
      super (ctx, M_RequisitionLine_ID, trxName);
      /** if (M_RequisitionLine_ID == 0)
        {
			setLine (0);
// @SQL=SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM M_RequisitionLine WHERE M_Requisition_ID=@M_Requisition_ID@
			setLineNetAmt (Env.ZERO);
			setM_Requisition_ID (0);
			setM_RequisitionLine_ID (0);
			setPriceActual (Env.ZERO);
			setQty (Env.ZERO);
// 1
        } */
    }

    /** Load Constructor */
    public X_M_RequisitionLine (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuffer sb = new StringBuffer ("X_M_RequisitionLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
    {
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_Name)
			.getPO(getA_Asset_ID(), get_TrxName());	}

	/** Set Asset.
		@param A_Asset_ID 
		Asset used internally or by customers
	  */
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1) 
			set_Value (COLUMNNAME_A_Asset_ID, null);
		else 
			set_Value (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Asset.
		@return Asset used internally or by customers
	  */
	public int getA_Asset_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getC_OrderLine_ID(), get_TrxName());	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID 
		Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Table_CostLine.
		@param C_Table_CostLine_ID C_Table_CostLine	  */
	public void setC_Table_CostLine_ID (int C_Table_CostLine_ID)
	{
		if (C_Table_CostLine_ID < 1) 
			set_Value (COLUMNNAME_C_Table_CostLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_Table_CostLine_ID, Integer.valueOf(C_Table_CostLine_ID));
	}

	/** Get C_Table_CostLine.
		@return C_Table_CostLine	  */
	public int getC_Table_CostLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Table_CostLine_ID);
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
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
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

	/** Set C_UOM_TRANSP_ID.
		@param C_UOM_TRANSP_ID C_UOM_TRANSP_ID	  */
	public void setC_UOM_TRANSP_ID (int C_UOM_TRANSP_ID)
	{
		if (C_UOM_TRANSP_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_TRANSP_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_TRANSP_ID, Integer.valueOf(C_UOM_TRANSP_ID));
	}

	/** Get C_UOM_TRANSP_ID.
		@return C_UOM_TRANSP_ID	  */
	public int getC_UOM_TRANSP_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_TRANSP_ID);
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

	/** Set hour_qty.
		@param hour_qty hour_qty	  */
	public void sethour_qty (BigDecimal hour_qty)
	{
		set_Value (COLUMNNAME_hour_qty, hour_qty);
	}

	/** Get hour_qty.
		@return hour_qty	  */
	public BigDecimal gethour_qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_hour_qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set IsPrincipal.
		@param IsPrincipal IsPrincipal	  */
	public void setIsPrincipal (boolean IsPrincipal)
	{
		set_Value (COLUMNNAME_IsPrincipal, Boolean.valueOf(IsPrincipal));
	}

	/** Get IsPrincipal.
		@return IsPrincipal	  */
	public boolean isPrincipal () 
	{
		Object oo = get_Value(COLUMNNAME_IsPrincipal);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsReady.
		@param IsReady IsReady	  */
	public void setIsReady (boolean IsReady)
	{
		set_Value (COLUMNNAME_IsReady, Boolean.valueOf(IsReady));
	}

	/** Get IsReady.
		@return IsReady	  */
	public boolean isReady () 
	{
		Object oo = get_Value(COLUMNNAME_IsReady);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsRecLib.
		@param IsRecLib IsRecLib	  */
	public void setIsRecLib (boolean IsRecLib)
	{
		set_Value (COLUMNNAME_IsRecLib, Boolean.valueOf(IsRecLib));
	}

	/** Get IsRecLib.
		@return IsRecLib	  */
	public boolean isRecLib () 
	{
		Object oo = get_Value(COLUMNNAME_IsRecLib);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLine()));
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
			set_Value (COLUMNNAME_M_AttributeSetInstance_ID, null);
		else 
			set_Value (COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
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

	public org.compiere.model.I_M_Requisition getM_Requisition() throws RuntimeException
    {
		return (org.compiere.model.I_M_Requisition)MTable.get(getCtx(), org.compiere.model.I_M_Requisition.Table_Name)
			.getPO(getM_Requisition_ID(), get_TrxName());	}

	/** Set Requisition.
		@param M_Requisition_ID 
		Material Requisition
	  */
	public void setM_Requisition_ID (int M_Requisition_ID)
	{
		if (M_Requisition_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Requisition_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Requisition_ID, Integer.valueOf(M_Requisition_ID));
	}

	/** Get Requisition.
		@return Material Requisition
	  */
	public int getM_Requisition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Requisition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Requisition Line.
		@param M_RequisitionLine_ID 
		Material Requisition Line
	  */
	public void setM_RequisitionLine_ID (int M_RequisitionLine_ID)
	{
		if (M_RequisitionLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_RequisitionLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_RequisitionLine_ID, Integer.valueOf(M_RequisitionLine_ID));
	}

	/** Get Requisition Line.
		@return Material Requisition Line
	  */
	public int getM_RequisitionLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_RequisitionLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unit Price.
		@param PriceActual 
		Actual Price 
	  */
	public void setPriceActual (BigDecimal PriceActual)
	{
		set_Value (COLUMNNAME_PriceActual, PriceActual);
	}

	/** Get Unit Price.
		@return Actual Price 
	  */
	public BigDecimal getPriceActual () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceActual);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Product_Tarnsp.
		@param Product_Tarnsp Product_Tarnsp	  */
	public void setProduct_Tarnsp (String Product_Tarnsp)
	{
		set_Value (COLUMNNAME_Product_Tarnsp, Product_Tarnsp);
	}

	/** Get Product_Tarnsp.
		@return Product_Tarnsp	  */
	public String getProduct_Tarnsp () 
	{
		return (String)get_Value(COLUMNNAME_Product_Tarnsp);
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

	/** Set Qty_transp.
		@param Qty_transp Qty_transp	  */
	public void setQty_transp (BigDecimal Qty_transp)
	{
		set_Value (COLUMNNAME_Qty_transp, Qty_transp);
	}

	/** Get Qty_transp.
		@return Qty_transp	  */
	public BigDecimal getQty_transp () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty_transp);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Set H_Request.
			@param H_Request_ID H_Request	  */
	public void setH_Request_ID (int H_Request_ID)
	{
			if (H_Request_ID < 1) 
				set_Value (COLUMNNAME_H_Request_ID, null);
			else 
			set_Value (COLUMNNAME_H_Request_ID, Integer.valueOf(H_Request_ID));
		}
	
		/** Get H_Request.
			@return H_Request	  */
		public int getH_Request_ID () 
		{
			Integer ii = (Integer)get_Value(COLUMNNAME_H_Request_ID);
			if (ii == null)
				 return 0;
			return ii.intValue();
		}

		@Override
		public void setC_BudgetPublic_ID(int C_BudgetPublic_ID) {

			if (C_BudgetPublic_ID < 1) 
				set_Value (COLUMNNAME_C_BudgetPublic_ID, null);
			else 
			set_Value (COLUMNNAME_C_BudgetPublic_ID, Integer.valueOf(C_BudgetPublic_ID));
			
		}

		@Override
		public int getC_BudgetPublic_ID() {
			Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_ID);
			if (ii == null)
				 return 0;
			return ii.intValue();
		}
		@Override
		
		public void setC_Manage_Unit_ID(int C_Manage_Unit_ID) {

			if (C_Manage_Unit_ID < 1) 
				set_Value (COLUMNNAME_C_Manage_Unit_ID, null);
			else 
			set_Value (COLUMNNAME_C_Manage_Unit_ID, Integer.valueOf(C_Manage_Unit_ID));
			
		}

		@Override
		public int getC_Manage_Unit_ID() {
			Integer ii = (Integer)get_Value(COLUMNNAME_C_Manage_Unit_ID);
			if (ii == null)
				 return 0;
			return ii.intValue();
		}
		
		@Override
		public void setC_ElementValuet_ID(int C_ElementValuet_ID) {

			if (C_ElementValuet_ID < 1) 
				set_Value (COLUMNNAME_C_ElementValuet_ID, null);
			else 
			set_Value (COLUMNNAME_C_ElementValuet_ID, Integer.valueOf(C_ElementValuet_ID));
			
		}

		@Override
		public int getC_ElementValuet_ID() {
			Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValuet_ID);
			if (ii == null)
				 return 0;
			return ii.intValue();
		}
		
}