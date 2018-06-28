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

/** Generated Model for H_MPriceList_Mod_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_MPriceList_Mod_Line extends PO implements I_H_MPriceList_Mod_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111219L;

    /** Standard Constructor */
    public X_H_MPriceList_Mod_Line (Properties ctx, int H_MPriceList_Mod_Line_ID, String trxName)
    {
      super (ctx, H_MPriceList_Mod_Line_ID, trxName);
      /** if (H_MPriceList_Mod_Line_ID == 0)
        {
			setH_MPriceList_Mod_Line_ID (0);
        } */
    }

    /** Load Constructor */
    public X_H_MPriceList_Mod_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_MPriceList_Mod_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.pentanet.model.I_H_MPriceList_Mod getH_MPriceList_Mod() throws RuntimeException
    {
		return (org.pentanet.model.I_H_MPriceList_Mod)MTable.get(getCtx(), org.pentanet.model.I_H_MPriceList_Mod.Table_Name)
			.getPO(getH_MPriceList_Mod_ID(), get_TrxName());	}

	/** Set H_MPriceList_Mod.
		@param H_MPriceList_Mod_ID H_MPriceList_Mod	  */
	public void setH_MPriceList_Mod_ID (int H_MPriceList_Mod_ID)
	{
		if (H_MPriceList_Mod_ID < 1) 
			set_Value (COLUMNNAME_H_MPriceList_Mod_ID, null);
		else 
			set_Value (COLUMNNAME_H_MPriceList_Mod_ID, Integer.valueOf(H_MPriceList_Mod_ID));
	}

	/** Get H_MPriceList_Mod.
		@return H_MPriceList_Mod	  */
	public int getH_MPriceList_Mod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_MPriceList_Mod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_MPriceList_Mod_Line.
		@param H_MPriceList_Mod_Line_ID H_MPriceList_Mod_Line	  */
	public void setH_MPriceList_Mod_Line_ID (int H_MPriceList_Mod_Line_ID)
	{
		if (H_MPriceList_Mod_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_MPriceList_Mod_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_MPriceList_Mod_Line_ID, Integer.valueOf(H_MPriceList_Mod_Line_ID));
	}

	/** Get H_MPriceList_Mod_Line.
		@return H_MPriceList_Mod_Line	  */
	public int getH_MPriceList_Mod_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_MPriceList_Mod_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product_Category)MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
			.getPO(getM_Product_Category_ID(), get_TrxName());	}

	/** Set Product Category.
		@param M_Product_Category_ID 
		Category of a Product
	  */
	public void setM_Product_Category_ID (int M_Product_Category_ID)
	{
		if (M_Product_Category_ID < 1) 
			set_Value (COLUMNNAME_M_Product_Category_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
	}

	/** Get Product Category.
		@return Category of a Product
	  */
	public int getM_Product_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
}