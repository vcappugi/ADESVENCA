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

/** Generated Model for H_Room
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Room extends PO implements I_H_Room, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120312L;

    /** Standard Constructor */
    public X_H_Room (Properties ctx, int H_Room_ID, String trxName)
    {
      super (ctx, H_Room_ID, trxName);
      /** if (H_Room_ID == 0)
        {
			setH_Room_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Room (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Room[")
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

	/** Set Floor.
		@param Floor Floor	  */
	public void setFloor (int Floor)
	{
		set_Value (COLUMNNAME_Floor, Integer.valueOf(Floor));
	}

	/** Get Floor.
		@return Floor	  */
	public int getFloor () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Floor);
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

	/** Set H_Room.
		@param H_Room_ID H_Room	  */
	public void setH_Room_ID (int H_Room_ID)
	{
		if (H_Room_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Room_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Room_ID, Integer.valueOf(H_Room_ID));
	}

	/** Get H_Room.
		@return H_Room	  */
	public int getH_Room_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Room_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IsOperatingRoom.
		@param IsOperatingRoom 
		Define si es un quirofano
	  */
	public void setIsOperatingRoom (boolean IsOperatingRoom)
	{
		set_Value (COLUMNNAME_IsOperatingRoom, Boolean.valueOf(IsOperatingRoom));
	}

	/** Get IsOperatingRoom.
		@return Define si es un quirofano
	  */
	public boolean isOperatingRoom () 
	{
		Object oo = get_Value(COLUMNNAME_IsOperatingRoom);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
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