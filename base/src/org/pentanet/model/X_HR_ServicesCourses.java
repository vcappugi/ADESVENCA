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

/** Generated Model for HR_ServicesCourses
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_ServicesCourses extends PO implements I_HR_ServicesCourses, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150825L;

    /** Standard Constructor */
    public X_HR_ServicesCourses (Properties ctx, int HR_ServicesCourses_ID, String trxName)
    {
      super (ctx, HR_ServicesCourses_ID, trxName);
      /** if (HR_ServicesCourses_ID == 0)
        {
			setHR_ServicesCourses_ID (0);
			setM_Product_Cost_ID (0);
			setM_Product_Exp_ID (0);
			setName (null);
			setType_Service (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_ServicesCourses (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_ServicesCourses[")
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

	/** Set Services Courses.
		@param HR_ServicesCourses_ID Services Courses	  */
	public void setHR_ServicesCourses_ID (int HR_ServicesCourses_ID)
	{
		if (HR_ServicesCourses_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_ServicesCourses_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_ServicesCourses_ID, Integer.valueOf(HR_ServicesCourses_ID));
	}

	/** Get Services Courses.
		@return Services Courses	  */
	public int getHR_ServicesCourses_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_ServicesCourses_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product_Cost() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_Cost_ID(), get_TrxName());	}

	/** Set M_Product_Cost_ID.
		@param M_Product_Cost_ID M_Product_Cost_ID	  */
	public void setM_Product_Cost_ID (int M_Product_Cost_ID)
	{
		if (M_Product_Cost_ID < 1) 
			set_Value (COLUMNNAME_M_Product_Cost_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_Cost_ID, Integer.valueOf(M_Product_Cost_ID));
	}

	/** Get M_Product_Cost_ID.
		@return M_Product_Cost_ID	  */
	public int getM_Product_Cost_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Cost_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product_Exp() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_Exp_ID(), get_TrxName());	}

	/** Set M_Product_Exp_ID.
		@param M_Product_Exp_ID M_Product_Exp_ID	  */
	public void setM_Product_Exp_ID (int M_Product_Exp_ID)
	{
		if (M_Product_Exp_ID < 1) 
			set_Value (COLUMNNAME_M_Product_Exp_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_Exp_ID, Integer.valueOf(M_Product_Exp_ID));
	}

	/** Get M_Product_Exp_ID.
		@return M_Product_Exp_ID	  */
	public int getM_Product_Exp_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Exp_ID);
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

	/** Type_Service AD_Reference_ID=1000193 */
	public static final int TYPE_SERVICE_AD_Reference_ID=1000193;
	/** Comidas = C */
	public static final String TYPE_SERVICE_Comidas = "C";
	/** Hospedaje = H */
	public static final String TYPE_SERVICE_Hospedaje = "H";
	/** Trasporte Fijo = TF */
	public static final String TYPE_SERVICE_TrasporteFijo = "TF";
	/** Taxi = TX */
	public static final String TYPE_SERVICE_Taxi = "TX";
	/** Set Type_Service.
		@param Type_Service Type_Service	  */
	public void setType_Service (String Type_Service)
	{

		set_Value (COLUMNNAME_Type_Service, Type_Service);
	}

	/** Get Type_Service.
		@return Type_Service	  */
	public String getType_Service () 
	{
		return (String)get_Value(COLUMNNAME_Type_Service);
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