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

/** Generated Model for HR_TakenCourses_par
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_TakenCourses_par extends PO implements I_HR_TakenCourses_par, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150827L;

    /** Standard Constructor */
    public X_HR_TakenCourses_par (Properties ctx, int HR_TakenCourses_par_ID, String trxName)
    {
      super (ctx, HR_TakenCourses_par_ID, trxName);
      /** if (HR_TakenCourses_par_ID == 0)
        {
			setHR_TakenCourses_par_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_TakenCourses_par (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_TakenCourses_par[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getBPartner_Emplo() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getBPartner_Employee(), get_TrxName());	}

	/** Set BPartner_Employee.
		@param BPartner_Employee BPartner_Employee	  */
	public void setBPartner_Employee (int BPartner_Employee)
	{
		set_Value (COLUMNNAME_BPartner_Employee, Integer.valueOf(BPartner_Employee));
	}

	/** Get BPartner_Employee.
		@return BPartner_Employee	  */
	public int getBPartner_Employee () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BPartner_Employee);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getBPartner_Instit() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getBPartner_Institute(), get_TrxName());	}

	/** Set BPartner_Institute.
		@param BPartner_Institute BPartner_Institute	  */
	public void setBPartner_Institute (int BPartner_Institute)
	{
		set_Value (COLUMNNAME_BPartner_Institute, Integer.valueOf(BPartner_Institute));
	}

	/** Get BPartner_Institute.
		@return BPartner_Institute	  */
	public int getBPartner_Institute () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BPartner_Institute);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getBPartner_Provi() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getBPartner_Provider(), get_TrxName());	}

	/** Set BPartner_Provider.
		@param BPartner_Provider BPartner_Provider	  */
	public void setBPartner_Provider (int BPartner_Provider)
	{
		set_Value (COLUMNNAME_BPartner_Provider, Integer.valueOf(BPartner_Provider));
	}

	/** Get BPartner_Provider.
		@return BPartner_Provider	  */
	public int getBPartner_Provider () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BPartner_Provider);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_City getC_City() throws RuntimeException
    {
		return (org.compiere.model.I_C_City)MTable.get(getCtx(), org.compiere.model.I_C_City.Table_Name)
			.getPO(getC_City_ID(), get_TrxName());	}

	/** Set City.
		@param C_City_ID 
		City
	  */
	public void setC_City_ID (int C_City_ID)
	{
		if (C_City_ID < 1) 
			set_Value (COLUMNNAME_C_City_ID, null);
		else 
			set_Value (COLUMNNAME_C_City_ID, Integer.valueOf(C_City_ID));
	}

	/** Get City.
		@return City
	  */
	public int getC_City_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_City_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Country getC_Country() throws RuntimeException
    {
		return (org.compiere.model.I_C_Country)MTable.get(getCtx(), org.compiere.model.I_C_Country.Table_Name)
			.getPO(getC_Country_ID(), get_TrxName());	}

	/** Set Country.
		@param C_Country_ID 
		Country 
	  */
	public void setC_Country_ID (int C_Country_ID)
	{
		if (C_Country_ID < 1) 
			set_Value (COLUMNNAME_C_Country_ID, null);
		else 
			set_Value (COLUMNNAME_C_Country_ID, Integer.valueOf(C_Country_ID));
	}

	/** Get Country.
		@return Country 
	  */
	public int getC_Country_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Country_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Cost Value.
		@param CostAmt 
		Value with Cost
	  */
	public void setCostAmt (BigDecimal CostAmt)
	{
		set_Value (COLUMNNAME_CostAmt, CostAmt);
	}

	/** Get Cost Value.
		@return Value with Cost
	  */
	public BigDecimal getCostAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CostAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_Region getC_Region() throws RuntimeException
    {
		return (org.compiere.model.I_C_Region)MTable.get(getCtx(), org.compiere.model.I_C_Region.Table_Name)
			.getPO(getC_Region_ID(), get_TrxName());	}

	/** Set Region.
		@param C_Region_ID 
		Identifies a geographical Region
	  */
	public void setC_Region_ID (int C_Region_ID)
	{
		if (C_Region_ID < 1) 
			set_Value (COLUMNNAME_C_Region_ID, null);
		else 
			set_Value (COLUMNNAME_C_Region_ID, Integer.valueOf(C_Region_ID));
	}

	/** Get Region.
		@return Identifies a geographical Region
	  */
	public int getC_Region_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Region_ID);
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

	/** Set EndCourse.
		@param EndCourse EndCourse	  */
	public void setEndCourse (Timestamp EndCourse)
	{
		set_Value (COLUMNNAME_EndCourse, EndCourse);
	}

	/** Get EndCourse.
		@return EndCourse	  */
	public Timestamp getEndCourse () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndCourse);
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

	/** Set HR_TakenCourses_par.
		@param HR_TakenCourses_par_ID HR_TakenCourses_par	  */
	public void setHR_TakenCourses_par_ID (int HR_TakenCourses_par_ID)
	{
		if (HR_TakenCourses_par_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_TakenCourses_par_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_TakenCourses_par_ID, Integer.valueOf(HR_TakenCourses_par_ID));
	}

	/** Get HR_TakenCourses_par.
		@return HR_TakenCourses_par	  */
	public int getHR_TakenCourses_par_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_TakenCourses_par_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ID_Activity.
		@param ID_Activity ID_Activity	  */
	public void setID_Activity (int ID_Activity)
	{
		set_Value (COLUMNNAME_ID_Activity, Integer.valueOf(ID_Activity));
	}

	/** Get ID_Activity.
		@return ID_Activity	  */
	public int getID_Activity () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ID_Activity);
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

	/** Set num_factura.
		@param num_factura num_factura	  */
	public void setnum_factura (String num_factura)
	{
		set_Value (COLUMNNAME_num_factura, num_factura);
	}

	/** Get num_factura.
		@return num_factura	  */
	public String getnum_factura () 
	{
		return (String)get_Value(COLUMNNAME_num_factura);
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

	/** Set StartCourse.
		@param StartCourse StartCourse	  */
	public void setStartCourse (Timestamp StartCourse)
	{
		set_Value (COLUMNNAME_StartCourse, StartCourse);
	}

	/** Get StartCourse.
		@return StartCourse	  */
	public Timestamp getStartCourse () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartCourse);
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