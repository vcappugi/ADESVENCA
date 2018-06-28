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

/** Generated Model for H_Bed
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Bed extends PO implements I_H_Bed, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111128L;

    /** Standard Constructor */
    public X_H_Bed (Properties ctx, int H_Bed_ID, String trxName)
    {
      super (ctx, H_Bed_ID, trxName);
      /** if (H_Bed_ID == 0)
        {
			setH_Bed_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Bed (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Bed[")
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

	/** Set H_Bed.
		@param H_Bed_ID H_Bed	  */
	public void setH_Bed_ID (int H_Bed_ID)
	{
		if (H_Bed_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Bed_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Bed_ID, Integer.valueOf(H_Bed_ID));
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

	public org.pentanet.model.I_H_Room getH_Room() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Room)MTable.get(getCtx(), org.pentanet.model.I_H_Room.Table_Name)
			.getPO(getH_Room_ID(), get_TrxName());	}

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

	/** Set IsOccupied.
		@param IsOccupied 
		Define si la cama esta ocupada o no
	  */
	public void setIsOccupied (boolean IsOccupied)
	{
		set_Value (COLUMNNAME_IsOccupied, Boolean.valueOf(IsOccupied));
	}

	/** Get IsOccupied.
		@return Define si la cama esta ocupada o no
	  */
	public boolean isOccupied () 
	{
		Object oo = get_Value(COLUMNNAME_IsOccupied);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsReserved.
		@param IsReserved 
		Define si la cama está reservada
	  */
	public void setIsReserved (boolean IsReserved)
	{
		set_Value (COLUMNNAME_IsReserved, Boolean.valueOf(IsReserved));
	}

	/** Get IsReserved.
		@return Define si la cama está reservada
	  */
	public boolean isReserved () 
	{
		Object oo = get_Value(COLUMNNAME_IsReserved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set ReservationDate.
		@param ReservationDate 
		Fecha de Reservación de la cama
	  */
	public void setReservationDate (Timestamp ReservationDate)
	{
		set_Value (COLUMNNAME_ReservationDate, ReservationDate);
	}

	/** Get ReservationDate.
		@return Fecha de Reservación de la cama
	  */
	public Timestamp getReservationDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ReservationDate);
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