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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_HCMFamily
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_HCMFamily extends PO implements I_HR_HCMFamily, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150317L;

    /** Standard Constructor */
    public X_HR_HCMFamily (Properties ctx, int HR_HCMFamily_ID, String trxName)
    {
      super (ctx, HR_HCMFamily_ID, trxName);
      /** if (HR_HCMFamily_ID == 0)
        {
			setHR_HCMFamily_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_HCMFamily (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_HCMFamily[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Cedula.
		@param Cedula Cedula	  */
	public void setCedula (String Cedula)
	{
		throw new IllegalArgumentException ("Cedula is virtual column");	}

	/** Get Cedula.
		@return Cedula	  */
	public String getCedula () 
	{
		return (String)get_Value(COLUMNNAME_Cedula);
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

	/** Set genero.
		@param genero genero	  */
	public void setgenero (String genero)
	{
		throw new IllegalArgumentException ("genero is virtual column");	}

	/** Get genero.
		@return genero	  */
	public String getgenero () 
	{
		return (String)get_Value(COLUMNNAME_genero);
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

	public org.pentanet.model.I_HR_Family getHR_Family() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Family)MTable.get(getCtx(), org.pentanet.model.I_HR_Family.Table_Name)
			.getPO(getHR_Family_ID(), get_TrxName());	}

	/** Set HR_Family.
		@param HR_Family_ID HR_Family	  */
	public void setHR_Family_ID (int HR_Family_ID)
	{
		if (HR_Family_ID < 1) 
			set_Value (COLUMNNAME_HR_Family_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Family_ID, Integer.valueOf(HR_Family_ID));
	}

	/** Get HR_Family.
		@return HR_Family	  */
	public int getHR_Family_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Family_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_HCMFamily.
		@param HR_HCMFamily_ID HR_HCMFamily	  */
	public void setHR_HCMFamily_ID (int HR_HCMFamily_ID)
	{
		if (HR_HCMFamily_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_HCMFamily_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_HCMFamily_ID, Integer.valueOf(HR_HCMFamily_ID));
	}

	/** Get HR_HCMFamily.
		@return HR_HCMFamily	  */
	public int getHR_HCMFamily_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMFamily_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_HCMRequest getHR_HCMRequest() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_HCMRequest)MTable.get(getCtx(), org.pentanet.model.I_HR_HCMRequest.Table_Name)
			.getPO(getHR_HCMRequest_ID(), get_TrxName());	}

	/** Set HR_HCMRequest.
		@param HR_HCMRequest_ID HR_HCMRequest	  */
	public void setHR_HCMRequest_ID (int HR_HCMRequest_ID)
	{
		if (HR_HCMRequest_ID < 1) 
			set_Value (COLUMNNAME_HR_HCMRequest_ID, null);
		else 
			set_Value (COLUMNNAME_HR_HCMRequest_ID, Integer.valueOf(HR_HCMRequest_ID));
	}

	/** Get HR_HCMRequest.
		@return HR_HCMRequest	  */
	public int getHR_HCMRequest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_HCMRequest_ID);
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

	/** Set Parentesco.
		@param Parentesco Parentesco	  */
	public void setParentesco (String Parentesco)
	{
		throw new IllegalArgumentException ("Parentesco is virtual column");	}

	/** Get Parentesco.
		@return Parentesco	  */
	public String getParentesco () 
	{
		return (String)get_Value(COLUMNNAME_Parentesco);
	}

	/** Set Rate.
		@param Rate 
		Rate or Tax or Exchange
	  */
	public void setRate (BigDecimal Rate)
	{
		set_Value (COLUMNNAME_Rate, Rate);
	}

	/** Get Rate.
		@return Rate or Tax or Exchange
	  */
	public BigDecimal getRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rate);
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
}