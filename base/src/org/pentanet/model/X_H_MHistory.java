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

/** Generated Model for H_MHistory
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_MHistory extends PO implements I_H_MHistory, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120330L;

    /** Standard Constructor */
    public X_H_MHistory (Properties ctx, int H_MHistory_ID, String trxName)
    {
      super (ctx, H_MHistory_ID, trxName);
      /** if (H_MHistory_ID == 0)
        {
			setH_MHistory_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_MHistory (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_MHistory[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Alta.
		@param Alta Alta	  */
	public void setAlta (String Alta)
	{
		set_Value (COLUMNNAME_Alta, Alta);
	}

	/** Get Alta.
		@return Alta	  */
	public String getAlta () 
	{
		return (String)get_Value(COLUMNNAME_Alta);
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

	/** Set Diagnosis.
		@param Diagnosis Diagnosis	  */
	public void setDiagnosis (String Diagnosis)
	{
		set_Value (COLUMNNAME_Diagnosis, Diagnosis);
	}

	/** Get Diagnosis.
		@return Diagnosis	  */
	public String getDiagnosis () 
	{
		return (String)get_Value(COLUMNNAME_Diagnosis);
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

	/** Set HDate.
		@param HDate HDate	  */
	public void setHDate (Timestamp HDate)
	{
		set_Value (COLUMNNAME_HDate, HDate);
	}

	/** Get HDate.
		@return HDate	  */
	public Timestamp getHDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_HDate);
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

	/** Set H_MHistory.
		@param H_MHistory_ID H_MHistory	  */
	public void setH_MHistory_ID (int H_MHistory_ID)
	{
		if (H_MHistory_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_MHistory_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_MHistory_ID, Integer.valueOf(H_MHistory_ID));
	}

	/** Get H_MHistory.
		@return H_MHistory	  */
	public int getH_MHistory_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_MHistory_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Patient getH_Patient() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Patient)MTable.get(getCtx(), org.pentanet.model.I_H_Patient.Table_Name)
			.getPO(getH_Patient_ID(), get_TrxName());	}

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

	/** Set Symptoms.
		@param Symptoms Symptoms	  */
	public void setSymptoms (String Symptoms)
	{
		set_Value (COLUMNNAME_Symptoms, Symptoms);
	}

	/** Get Symptoms.
		@return Symptoms	  */
	public String getSymptoms () 
	{
		return (String)get_Value(COLUMNNAME_Symptoms);
	}

	/** Set Treatment.
		@param Treatment Treatment	  */
	public void setTreatment (String Treatment)
	{
		set_Value (COLUMNNAME_Treatment, Treatment);
	}

	/** Get Treatment.
		@return Treatment	  */
	public String getTreatment () 
	{
		return (String)get_Value(COLUMNNAME_Treatment);
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