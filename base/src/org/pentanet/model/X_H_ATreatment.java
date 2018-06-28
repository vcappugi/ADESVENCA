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

/** Generated Model for H_ATreatment
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_ATreatment extends PO implements I_H_ATreatment, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111128L;

    /** Standard Constructor */
    public X_H_ATreatment (Properties ctx, int H_ATreatment_ID, String trxName)
    {
      super (ctx, H_ATreatment_ID, trxName);
      /** if (H_ATreatment_ID == 0)
        {
			setH_ATreatment_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_ATreatment (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_ATreatment[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set ApplicationTime.
		@param ApplicationTime 
		Fecha y Hora de la aplicación del tratamiento
	  */
	public void setApplicationTime (Timestamp ApplicationTime)
	{
		set_Value (COLUMNNAME_ApplicationTime, ApplicationTime);
	}

	/** Get ApplicationTime.
		@return Fecha y Hora de la aplicación del tratamiento
	  */
	public Timestamp getApplicationTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ApplicationTime);
	}

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
	public void setDose (BigDecimal Dose)
	{
		set_Value (COLUMNNAME_Dose, Dose);
	}

	/** Get Dose.
		@return Dosis de un medicamento
	  */
	public BigDecimal getDose () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Dose);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set H_ATreatment.
		@param H_ATreatment_ID H_ATreatment	  */
	public void setH_ATreatment_ID (int H_ATreatment_ID)
	{
		if (H_ATreatment_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_ATreatment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_ATreatment_ID, Integer.valueOf(H_ATreatment_ID));
	}

	/** Get H_ATreatment.
		@return H_ATreatment	  */
	public int getH_ATreatment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_ATreatment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_Patient.
		@param H_Patient_ID H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID)
	{
		if (H_Patient_ID < 1) 
			set_Value (COLUMNNAME_H_Patient_ID, null);
		else 
			set_Value (COLUMNNAME_H_Patient_ID, Integer.valueOf(H_Patient_ID));
	}

	/** Get H_Patient.
		@return H_Patient	  */
	public int getH_Patient_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Patient_ID);
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

	/** Set IsApplied.
		@param IsApplied 
		Define si fue aplicado un medicamento del tratamiento
	  */
	public void setIsApplied (boolean IsApplied)
	{
		set_Value (COLUMNNAME_IsApplied, Boolean.valueOf(IsApplied));
	}

	/** Get IsApplied.
		@return Define si fue aplicado un medicamento del tratamiento
	  */
	public boolean isApplied () 
	{
		Object oo = get_Value(COLUMNNAME_IsApplied);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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
	
	
	/** Set ActualApplicationTime.
	@param ActualApplicationTime 
	Fecha y Hora de la aplicación real del tratamiento
  */
	public void setActualApplicationTime (Timestamp ActualApplicationTime)
	{
		set_Value (COLUMNNAME_ActualApplicationTime, ActualApplicationTime);
	}
	
	/** Get ActualApplicationTime.
		@return Fecha y Hora de la aplicación real del tratamiento
	  */
	public Timestamp getActualApplicationTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ActualApplicationTime);
	}
}