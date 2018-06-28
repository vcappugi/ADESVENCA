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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for C_JourneyManagement_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_JourneyManagement_Line extends PO implements I_C_JourneyManagement_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141218L;

    /** Standard Constructor */
    public X_C_JourneyManagement_Line (Properties ctx, int C_JourneyManagement_Line_ID, String trxName)
    {
      super (ctx, C_JourneyManagement_Line_ID, trxName);
      /** if (C_JourneyManagement_Line_ID == 0)
        {
			setC_Activity_ID (0);
			setC_JourneyManagement_Line_ID (0);
			setC_UOM_ID (0);
			setDateEnd (new Timestamp( System.currentTimeMillis() ));
			setDateStart (new Timestamp( System.currentTimeMillis() ));
			setM_Product_ID (0);
			setPriceList (Env.ZERO);
			setQtyEntered (Env.ZERO);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_JourneyManagement_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_JourneyManagement_Line[")
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

	public org.pentanet.model.I_C_JourneyManagement getC_JourneyManagement() throws RuntimeException
    {
		return (org.pentanet.model.I_C_JourneyManagement)MTable.get(getCtx(), org.pentanet.model.I_C_JourneyManagement.Table_Name)
			.getPO(getC_JourneyManagement_ID(), get_TrxName());	}

	/** Set C_JourneyManagement.
		@param C_JourneyManagement_ID C_JourneyManagement	  */
	public void setC_JourneyManagement_ID (int C_JourneyManagement_ID)
	{
		if (C_JourneyManagement_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_JourneyManagement_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_JourneyManagement_ID, Integer.valueOf(C_JourneyManagement_ID));
	}

	/** Get C_JourneyManagement.
		@return C_JourneyManagement	  */
	public int getC_JourneyManagement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_JourneyManagement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_JourneyManagement_Line.
		@param C_JourneyManagement_Line_ID C_JourneyManagement_Line	  */
	public void setC_JourneyManagement_Line_ID (int C_JourneyManagement_Line_ID)
	{
		if (C_JourneyManagement_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_JourneyManagement_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_JourneyManagement_Line_ID, Integer.valueOf(C_JourneyManagement_Line_ID));
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

	/** Set DateArrived.
		@param DateArrived DateArrived	  */
	public void setDateArrived (Timestamp DateArrived)
	{
		set_Value (COLUMNNAME_DateArrived, DateArrived);
	}

	/** Get DateArrived.
		@return DateArrived	  */
	public Timestamp getDateArrived () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateArrived);
	}

	/** Set DateEnd.
		@param DateEnd DateEnd	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get DateEnd.
		@return DateEnd	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		set_Value (COLUMNNAME_DateStart, DateStart);
	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
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

	/** Set IsApplied.
		@param IsApplied 
		Define si fue aplicado un medicamento del tratamiento
	  */
	public void setIsApplied (boolean IsApplied)
	{
		set_Value (COLUMNNAME_IsApplied, Boolean.valueOf(IsApplied));
	}

	/** Get IsApplied.
		@return Define si fue aplicado un medicamento del tratamiento
	  */
	public boolean isApplied () 
	{
		Object oo = get_Value(COLUMNNAME_IsApplied);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Justification.
		@param Justification Justification	  */
	public void setJustification (String Justification)
	{
		set_Value (COLUMNNAME_Justification, Justification);
	}

	/** Get Justification.
		@return Justification	  */
	public String getJustification () 
	{
		return (String)get_Value(COLUMNNAME_Justification);
	}

	/** Set KmEnd.
		@param KmEnd KmEnd	  */
	public void setKmEnd (BigDecimal KmEnd)
	{
		set_Value (COLUMNNAME_KmEnd, KmEnd);
	}

	/** Get KmEnd.
		@return KmEnd	  */
	public BigDecimal getKmEnd () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_KmEnd);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set KmStart.
		@param KmStart KmStart	  */
	public void setKmStart (BigDecimal KmStart)
	{
		set_Value (COLUMNNAME_KmStart, KmStart);
	}

	/** Get KmStart.
		@return KmStart	  */
	public BigDecimal getKmStart () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_KmStart);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getM_Product_ID()));
    }

	public org.compiere.model.I_M_RequisitionLine getM_RequisitionLine() throws RuntimeException
    {
		return (org.compiere.model.I_M_RequisitionLine)MTable.get(getCtx(), org.compiere.model.I_M_RequisitionLine.Table_Name)
			.getPO(getM_RequisitionLine_ID(), get_TrxName());	}

	/** Set Requisition Line.
		@param M_RequisitionLine_ID 
		Material Requisition Line
	  */
	public void setM_RequisitionLine_ID (int M_RequisitionLine_ID)
	{
		if (M_RequisitionLine_ID < 1) 
			set_Value (COLUMNNAME_M_RequisitionLine_ID, null);
		else 
			set_Value (COLUMNNAME_M_RequisitionLine_ID, Integer.valueOf(M_RequisitionLine_ID));
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

	/** Set Price.
		@param PriceEntered 
		Price Entered - the price based on the selected/base UoM
	  */
	public void setPriceEntered (BigDecimal PriceEntered)
	{
		set_Value (COLUMNNAME_PriceEntered, PriceEntered);
	}

	/** Get Price.
		@return Price Entered - the price based on the selected/base UoM
	  */
	public BigDecimal getPriceEntered () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceEntered);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set List Price.
		@param PriceList 
		List Price
	  */
	public void setPriceList (BigDecimal PriceList)
	{
		set_Value (COLUMNNAME_PriceList, PriceList);
	}

	/** Get List Price.
		@return List Price
	  */
	public BigDecimal getPriceList () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceList);
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
		@param QtyEntered 
		The Quantity Entered is based on the selected UoM
	  */
	public void setQtyEntered (BigDecimal QtyEntered)
	{
		set_Value (COLUMNNAME_QtyEntered, QtyEntered);
	}

	/** Get Quantity.
		@return The Quantity Entered is based on the selected UoM
	  */
	public BigDecimal getQtyEntered () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyEntered);
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