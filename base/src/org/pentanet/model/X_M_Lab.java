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

/** Generated Model for M_Lab
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_M_Lab extends PO implements I_M_Lab, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131016L;

    /** Standard Constructor */
    public X_M_Lab (Properties ctx, int M_Lab_ID, String trxName)
    {
      super (ctx, M_Lab_ID, trxName);
      /** if (M_Lab_ID == 0)
        {
			setM_Lab_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_M_Lab (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_Lab[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set Usuario.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get Usuario.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User_Rev() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_Rev_ID(), get_TrxName());	}

	/** Set AD_User_Rev_ID.
		@param AD_User_Rev_ID AD_User_Rev_ID	  */
	public void setAD_User_Rev_ID (int AD_User_Rev_ID)
	{
		if (AD_User_Rev_ID < 1) 
			set_Value (COLUMNNAME_AD_User_Rev_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_Rev_ID, Integer.valueOf(AD_User_Rev_ID));
	}

	/** Get AD_User_Rev_ID.
		@return AD_User_Rev_ID	  */
	public int getAD_User_Rev_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_Rev_ID);
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

	/** Set Valuation Date.
		@param DateValue 
		Date of valuation
	  */
	public void setDateValue (Timestamp DateValue)
	{
		set_Value (COLUMNNAME_DateValue, DateValue);
	}

	/** Get Valuation Date.
		@return Date of valuation
	  */
	public Timestamp getDateValue () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateValue);
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

	/** Set Destination.
		@param Destination 
		Destino
	  */
	public void setDestination (String Destination)
	{
		set_Value (COLUMNNAME_Destination, Destination);
	}

	/** Get Destination.
		@return Destino
	  */
	public String getDestination () 
	{
		return (String)get_Value(COLUMNNAME_Destination);
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

	/** Set Delivered.
		@param IsDelivered Delivered	  */
	public void setIsDelivered (boolean IsDelivered)
	{
		set_Value (COLUMNNAME_IsDelivered, Boolean.valueOf(IsDelivered));
	}

	/** Get Delivered.
		@return Delivered	  */
	public boolean isDelivered () 
	{
		Object oo = get_Value(COLUMNNAME_IsDelivered);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsOther.
		@param IsOther 
		Es Otro
	  */
	public void setIsOther (boolean IsOther)
	{
		set_Value (COLUMNNAME_IsOther, Boolean.valueOf(IsOther));
	}

	/** Get IsOther.
		@return Es Otro
	  */
	public boolean isOther () 
	{
		Object oo = get_Value(COLUMNNAME_IsOther);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsRev.
		@param IsRev IsRev	  */
	public void setIsRev (boolean IsRev)
	{
		set_Value (COLUMNNAME_IsRev, Boolean.valueOf(IsRev));
	}

	/** Get IsRev.
		@return IsRev	  */
	public boolean isRev () 
	{
		Object oo = get_Value(COLUMNNAME_IsRev);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsSampleSupplier.
		@param IsSampleSupplier 
		Muestra de Proveedor
	  */
	public void setIsSampleSupplier (boolean IsSampleSupplier)
	{
		set_Value (COLUMNNAME_IsSampleSupplier, Boolean.valueOf(IsSampleSupplier));
	}

	/** Get IsSampleSupplier.
		@return Muestra de Proveedor
	  */
	public boolean isSampleSupplier () 
	{
		Object oo = get_Value(COLUMNNAME_IsSampleSupplier);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Stocked.
		@param IsStocked 
		Organization stocks this product
	  */
	public void setIsStocked (boolean IsStocked)
	{
		set_Value (COLUMNNAME_IsStocked, Boolean.valueOf(IsStocked));
	}

	/** Get Stocked.
		@return Organization stocks this product
	  */
	public boolean isStocked () 
	{
		Object oo = get_Value(COLUMNNAME_IsStocked);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsWarehouse.
		@param IsWarehouse 
		Almacen
	  */
	public void setIsWarehouse (boolean IsWarehouse)
	{
		set_Value (COLUMNNAME_IsWarehouse, Boolean.valueOf(IsWarehouse));
	}

	/** Get IsWarehouse.
		@return Almacen
	  */
	public boolean isWarehouse () 
	{
		Object oo = get_Value(COLUMNNAME_IsWarehouse);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** List_Origin AD_Reference_ID=1000085 */
	public static final int LIST_ORIGIN_AD_Reference_ID=1000085;
	/** Area Operativa = O */
	public static final String LIST_ORIGIN_AreaOperativa = "O";
	/** Planta = P */
	public static final String LIST_ORIGIN_Planta = "P";
	/** Productos Quimicos = Q */
	public static final String LIST_ORIGIN_ProductosQuimicos = "Q";
	/** Otros = T */
	public static final String LIST_ORIGIN_Otros = "T";
	/** Set List_Origin.
		@param List_Origin List_Origin	  */
	public void setList_Origin (String List_Origin)
	{

		set_Value (COLUMNNAME_List_Origin, List_Origin);
	}

	/** Get List_Origin.
		@return List_Origin	  */
	public String getList_Origin () 
	{
		return (String)get_Value(COLUMNNAME_List_Origin);
	}

	/** Set M_Lab.
		@param M_Lab_ID M_Lab	  */
	public void setM_Lab_ID (int M_Lab_ID)
	{
		if (M_Lab_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Lab_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Lab_ID, Integer.valueOf(M_Lab_ID));
	}

	/** Get M_Lab.
		@return M_Lab	  */
	public int getM_Lab_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Lab_ID);
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

	/** Set Origin.
		@param Origin 
		Origen
	  */
	public void setOrigin (String Origin)
	{
		set_Value (COLUMNNAME_Origin, Origin);
	}

	/** Get Origin.
		@return Origen
	  */
	public String getOrigin () 
	{
		return (String)get_Value(COLUMNNAME_Origin);
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

	/** Set Volume.
		@param Volume 
		Volume of a product
	  */
	public void setVolume (String Volume)
	{
		set_Value (COLUMNNAME_Volume, Volume);
	}

	/** Get Volume.
		@return Volume of a product
	  */
	public String getVolume () 
	{
		return (String)get_Value(COLUMNNAME_Volume);
	}
}