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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for H_InventoryChargeConf
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_InventoryChargeConf extends PO implements I_H_InventoryChargeConf, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120312L;

    /** Standard Constructor */
    public X_H_InventoryChargeConf (Properties ctx, int H_InventoryChargeConf_ID, String trxName)
    {
      super (ctx, H_InventoryChargeConf_ID, trxName);
      /** if (H_InventoryChargeConf_ID == 0)
        {
			setH_InventoryChargeConf_ID (0);
			setName (null);
			setProductCharge (0);
			setServiceCharge (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_InventoryChargeConf (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_InventoryChargeConf[")
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

	/** Set H_InventoryChargeConf.
		@param H_InventoryChargeConf_ID H_InventoryChargeConf	  */
	public void setH_InventoryChargeConf_ID (int H_InventoryChargeConf_ID)
	{
		if (H_InventoryChargeConf_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_InventoryChargeConf_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_InventoryChargeConf_ID, Integer.valueOf(H_InventoryChargeConf_ID));
	}

	/** Get H_InventoryChargeConf.
		@return H_InventoryChargeConf	  */
	public int getH_InventoryChargeConf_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_InventoryChargeConf_ID);
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

	public org.compiere.model.I_C_Charge getProductCha() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getProductCharge(), get_TrxName());	}

	/** Set ProductCharge.
		@param ProductCharge 
		Cargo asociado a productos, que serán rebajados del inventario
	  */
	public void setProductCharge (int ProductCharge)
	{
		set_Value (COLUMNNAME_ProductCharge, Integer.valueOf(ProductCharge));
	}

	/** Get ProductCharge.
		@return Cargo asociado a productos, que serán rebajados del inventario
	  */
	public int getProductCharge () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ProductCharge);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Charge getServiceCha() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getServiceCharge(), get_TrxName());	}

	/** Set ServiceCharge.
		@param ServiceCharge 
		Cargo asociado a los servicios
	  */
	public void setServiceCharge (int ServiceCharge)
	{
		set_Value (COLUMNNAME_ServiceCharge, Integer.valueOf(ServiceCharge));
	}

	/** Get ServiceCharge.
		@return Cargo asociado a los servicios
	  */
	public int getServiceCharge () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ServiceCharge);
		if (ii == null)
			 return 0;
		return ii.intValue();
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