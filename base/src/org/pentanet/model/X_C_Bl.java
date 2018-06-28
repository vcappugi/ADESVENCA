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

/** Generated Model for C_Bl
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Bl extends PO implements I_C_Bl, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141105L;

    /** Standard Constructor */
    public X_C_Bl (Properties ctx, int C_Bl_ID, String trxName)
    {
      super (ctx, C_Bl_ID, trxName);
      /** if (C_Bl_ID == 0)
        {
			setC_Bl_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Bl (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Bl[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set C_Bl.
		@param C_Bl_ID C_Bl	  */
	public void setC_Bl_ID (int C_Bl_ID)
	{
		if (C_Bl_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Bl_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Bl_ID, Integer.valueOf(C_Bl_ID));
	}

	/** Get C_Bl.
		@return C_Bl	  */
	public int getC_Bl_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Bl_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Company AD_Reference_ID=1000126 */
	public static final int COMPANY_AD_Reference_ID=1000126;
	/** MAERSK LINE = MAERSK LINE */
	public static final String COMPANY_MAERSKLINE = "MAERSK LINE";
	/** CMA-CGM = CMA-CGM */
	public static final String COMPANY_CMA_CGM = "CMA-CGM";
	/** ZIM = ZIM */
	public static final String COMPANY_ZIM = "ZIM";
	/** HAMBURG SUD VENEZUELA, C.A. = HAMBURG SUD VENEZUELA, C.A. */
	public static final String COMPANY_HAMBURGSUDVENEZUELACA = "HAMBURG SUD VENEZUELA, C.A.";
	/** Set Company.
		@param Company Company	  */
	public void setCompany (String Company)
	{

		set_Value (COLUMNNAME_Company, Company);
	}

	/** Get Company.
		@return Company	  */
	public String getCompany () 
	{
		return (String)get_Value(COLUMNNAME_Company);
	}

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
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

	/** Set Invoiced.
		@param IsInvoiced 
		Is this invoiced?
	  */
	public void setIsInvoiced (boolean IsInvoiced)
	{
		set_Value (COLUMNNAME_IsInvoiced, Boolean.valueOf(IsInvoiced));
	}

	/** Get Invoiced.
		@return Is this invoiced?
	  */
	public boolean isInvoiced () 
	{
		Object oo = get_Value(COLUMNNAME_IsInvoiced);
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

	/** Set Tracking.
		@param Tracking Tracking	  */
	public void setTracking (String Tracking)
	{
		set_Value (COLUMNNAME_Tracking, Tracking);
	}

	/** Get Tracking.
		@return Tracking	  */
	public String getTracking () 
	{
		return (String)get_Value(COLUMNNAME_Tracking);
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