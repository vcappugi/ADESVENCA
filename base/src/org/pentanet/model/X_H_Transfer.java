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

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for H_Transfer
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Transfer extends PO implements I_H_Transfer, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120218L;

    /** Standard Constructor */
    public X_H_Transfer (Properties ctx, int H_Transfer_ID, String trxName)
    {
      super (ctx, H_Transfer_ID, trxName);
      /** if (H_Transfer_ID == 0)
        {
			setH_Transfer_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Transfer (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Transfer[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_SalesRegion getC_SalesRegionD() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegionD_ID(), get_TrxName());	}

	/** Set C_SalesRegionD_ID.
		@param C_SalesRegionD_ID C_SalesRegionD_ID	  */
	public void setC_SalesRegionD_ID (int C_SalesRegionD_ID)
	{
		if (C_SalesRegionD_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, Integer.valueOf(C_SalesRegionD_ID));
	}

	/** Get C_SalesRegionD_ID.
		@return C_SalesRegionD_ID	  */
	public int getC_SalesRegionD_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegionD_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegion_ID(), get_TrxName());	}

	/** Set Sales Region.
		@param C_SalesRegion_ID 
		Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
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

	/** Set Generate_Mov.
		@param Generate_Mov Generate_Mov	  */
	public void setGenerate_Mov (String Generate_Mov)
	{
		set_Value (COLUMNNAME_Generate_Mov, Generate_Mov);
	}

	/** Get Generate_Mov.
		@return Generate_Mov	  */
	public String getGenerate_Mov () 
	{
		return (String)get_Value(COLUMNNAME_Generate_Mov);
	}

	public org.pentanet.model.I_H_Admission getH_Admission() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Admission)MTable.get(getCtx(), org.pentanet.model.I_H_Admission.Table_Name)
			.getPO(getH_Admission_ID(), get_TrxName());	}

	/** Set H_Admission.
		@param H_Admission_ID H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID)
	{
		if (H_Admission_ID < 1) 
			set_Value (COLUMNNAME_H_Admission_ID, null);
		else 
			set_Value (COLUMNNAME_H_Admission_ID, Integer.valueOf(H_Admission_ID));
	}

	/** Get H_Admission.
		@return H_Admission	  */
	public int getH_Admission_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Admission_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Bed getH_Bed() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Bed)MTable.get(getCtx(), org.pentanet.model.I_H_Bed.Table_Name)
			.getPO(getH_Bed_ID(), get_TrxName());	}

	/** Set H_Bed.
		@param H_Bed_ID H_Bed	  */
	public void setH_Bed_ID (int H_Bed_ID)
	{
		if (H_Bed_ID < 1) 
			set_Value (COLUMNNAME_H_Bed_ID, null);
		else 
			set_Value (COLUMNNAME_H_Bed_ID, Integer.valueOf(H_Bed_ID));
	}

	/** Get H_Bed.
		@return H_Bed	  */
	public int getH_Bed_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Bed_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set H_Transfer.
		@param H_Transfer_ID H_Transfer	  */
	public void setH_Transfer_ID (int H_Transfer_ID)
	{
		if (H_Transfer_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Transfer_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Transfer_ID, Integer.valueOf(H_Transfer_ID));
	}

	/** Get H_Transfer.
		@return H_Transfer	  */
	public int getH_Transfer_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Transfer_ID);
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