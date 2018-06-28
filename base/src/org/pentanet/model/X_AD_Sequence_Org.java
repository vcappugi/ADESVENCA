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

/** Generated Model for AD_Sequence_Org
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_AD_Sequence_Org extends PO implements I_AD_Sequence_Org, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141205L;

    /** Standard Constructor */
    public X_AD_Sequence_Org (Properties ctx, int AD_Sequence_Org_ID, String trxName)
    {
      super (ctx, AD_Sequence_Org_ID, trxName);
      /** if (AD_Sequence_Org_ID == 0)
        {
			setAD_Sequence_Org_ID (0);
			setC_DocType_ID (0);
			setCurrentNext (0);
			setIncrementNo (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_AD_Sequence_Org (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AD_Sequence_Org[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AD_Sequence_Org.
		@param AD_Sequence_Org_ID AD_Sequence_Org	  */
	public void setAD_Sequence_Org_ID (int AD_Sequence_Org_ID)
	{
		if (AD_Sequence_Org_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_Sequence_Org_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Sequence_Org_ID, Integer.valueOf(AD_Sequence_Org_ID));
	}

	/** Get AD_Sequence_Org.
		@return AD_Sequence_Org	  */
	public int getAD_Sequence_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Sequence_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Current Next.
		@param CurrentNext 
		The next number to be used
	  */
	public void setCurrentNext (int CurrentNext)
	{
		set_Value (COLUMNNAME_CurrentNext, Integer.valueOf(CurrentNext));
	}

	/** Get Current Next.
		@return The next number to be used
	  */
	public int getCurrentNext () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CurrentNext);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Increment.
		@param IncrementNo 
		The number to increment the last document number by
	  */
	public void setIncrementNo (int IncrementNo)
	{
		set_Value (COLUMNNAME_IncrementNo, Integer.valueOf(IncrementNo));
	}

	/** Get Increment.
		@return The number to increment the last document number by
	  */
	public int getIncrementNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IncrementNo);
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
}