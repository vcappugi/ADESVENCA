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

/** Generated Model for H_TreatmentLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_TreatmentLine extends PO implements I_H_TreatmentLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111128L;

    /** Standard Constructor */
    public X_H_TreatmentLine (Properties ctx, int H_TreatmentLine_ID, String trxName)
    {
      super (ctx, H_TreatmentLine_ID, trxName);
      /** if (H_TreatmentLine_ID == 0)
        {
			setH_TreatmentLine_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_TreatmentLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_TreatmentLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
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

	/** Set Dose.
		@param Dose 
		Dosis de un medicamento
	  */
	public void setDose (int Dose)
	{
		set_Value (COLUMNNAME_Dose, Integer.valueOf(Dose));
	}

	/** Get Dose.
		@return Dosis de un medicamento
	  */
	public int getDose () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dose);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Frequency.
		@param Frequency 
		Frequency of events
	  */
	public void setFrequency (BigDecimal Frequency)
	{
		set_Value (COLUMNNAME_Frequency, Frequency);
	}

	/** Get Frequency.
		@return Frequency of events
	  */
	public BigDecimal getFrequency () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Frequency);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set H_TreatmentLine.
		@param H_TreatmentLine_ID H_TreatmentLine	  */
	public void setH_TreatmentLine_ID (int H_TreatmentLine_ID)
	{
		if (H_TreatmentLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_TreatmentLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_TreatmentLine_ID, Integer.valueOf(H_TreatmentLine_ID));
	}

	/** Get H_TreatmentLine.
		@return H_TreatmentLine	  */
	public int getH_TreatmentLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_TreatmentLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Treatment getH_Treatment() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Treatment)MTable.get(getCtx(), org.pentanet.model.I_H_Treatment.Table_Name)
			.getPO(getH_Treatment_ID(), get_TrxName());	}

	/** Set H_Treatment.
		@param H_Treatment_ID H_Treatment	  */
	public void setH_Treatment_ID (int H_Treatment_ID)
	{
		if (H_Treatment_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Treatment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Treatment_ID, Integer.valueOf(H_Treatment_ID));
	}

	/** Get H_Treatment.
		@return H_Treatment	  */
	public int getH_Treatment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Treatment_ID);
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

	/** Set Period.
		@param Period Period	  */
	public void setPeriod (BigDecimal Period)
	{
		set_Value (COLUMNNAME_Period, Period);
	}

	/** Get Period.
		@return Period	  */
	public BigDecimal getPeriod () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Period);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getPeriodT() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getPeriodType(), get_TrxName());	}

	/** Set Period Type.
		@param PeriodType 
		Period Type
	  */
	public void setPeriodType (int PeriodType)
	{
		set_Value (COLUMNNAME_PeriodType, Integer.valueOf(PeriodType));
	}

	/** Get Period Type.
		@return Period Type
	  */
	public int getPeriodType () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PeriodType);
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
	
	
	
	/** Set TreatmentDate.
	@param TreatmentDate 
	Fecha del tratamiento
  */
	public void setTreatmentDate (Timestamp TreatmentDate)
	{
		set_Value (COLUMNNAME_TreatmentDate, TreatmentDate);
	}
	
	/** Get TreatmentDate.
		@return Fecha del tratamiento
	  */
	public Timestamp getTreatmentDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_TreatmentDate);
	}
}