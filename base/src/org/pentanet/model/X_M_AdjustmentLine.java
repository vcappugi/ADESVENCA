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

/** Generated Model for M_AdjustmentLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_M_AdjustmentLine extends PO implements I_M_AdjustmentLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161228L;

    /** Standard Constructor */
    public X_M_AdjustmentLine (Properties ctx, int M_AdjustmentLine_ID, String trxName)
    {
      super (ctx, M_AdjustmentLine_ID, trxName);
      /** if (M_AdjustmentLine_ID == 0)
        {
			setC_Activity_ID (0);
			setC_Project_ID (0);
			setC_ProjectLine_ID (0);
			setM_AdjustmentLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_M_AdjustmentLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_AdjustmentLine[")
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

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
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

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_Value (COLUMNNAME_C_Project_ID, null);
		else 
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
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

	public org.pentanet.model.I_M_Adjustment getM_Adjustment() throws RuntimeException
    {
		return (org.pentanet.model.I_M_Adjustment)MTable.get(getCtx(), org.pentanet.model.I_M_Adjustment.Table_Name)
			.getPO(getM_Adjustment_ID(), get_TrxName());	}

	/** Set M_Adjustment.
		@param M_Adjustment_ID M_Adjustment	  */
	public void setM_Adjustment_ID (int M_Adjustment_ID)
	{
		if (M_Adjustment_ID < 1) 
			set_Value (COLUMNNAME_M_Adjustment_ID, null);
		else 
			set_Value (COLUMNNAME_M_Adjustment_ID, Integer.valueOf(M_Adjustment_ID));
	}

	/** Get M_Adjustment.
		@return M_Adjustment	  */
	public int getM_Adjustment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Adjustment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_AdjustmentLine.
		@param M_AdjustmentLine_ID M_AdjustmentLine	  */
	public void setM_AdjustmentLine_ID (int M_AdjustmentLine_ID)
	{
		if (M_AdjustmentLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_AdjustmentLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_AdjustmentLine_ID, Integer.valueOf(M_AdjustmentLine_ID));
	}

	/** Get M_AdjustmentLine.
		@return M_AdjustmentLine	  */
	public int getM_AdjustmentLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_AdjustmentLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Part_Code.
		@param Part_Code Part_Code	  */
	public void setPart_Code (String Part_Code)
	{
		throw new IllegalArgumentException ("Part_Code is virtual column");	}

	/** Get Part_Code.
		@return Part_Code	  */
	public String getPart_Code () 
	{
		return (String)get_Value(COLUMNNAME_Part_Code);
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

	/** Set QtyDif.
		@param QtyDif QtyDif	  */
	public void setQtyDif (BigDecimal QtyDif)
	{
		set_Value (COLUMNNAME_QtyDif, QtyDif);
	}

	/** Get QtyDif.
		@return QtyDif	  */
	public BigDecimal getQtyDif () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyDif);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyR.
		@param QtyR QtyR	  */
	public void setQtyR (BigDecimal QtyR)
	{
		set_Value (COLUMNNAME_QtyR, QtyR);
	}

	/** Get QtyR.
		@return QtyR	  */
	public BigDecimal getQtyR () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyR);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set QtyT.
		@param QtyT QtyT	  */
	public void setQtyT (BigDecimal QtyT)
	{
		set_Value (COLUMNNAME_QtyT, QtyT);
	}

	/** Get QtyT.
		@return QtyT	  */
	public BigDecimal getQtyT () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyT);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}