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

/** Generated Model for C_Well
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Well extends PO implements I_C_Well, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160505L;

    /** Standard Constructor */
    public X_C_Well (Properties ctx, int C_Well_ID, String trxName)
    {
      super (ctx, C_Well_ID, trxName);
      /** if (C_Well_ID == 0)
        {
			setC_Well_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Well (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Well[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getC_Activity_ID(), get_TrxName());	}

	/** Set Activity.
		@param C_Activity_ID 
		Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1) 
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else 
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Cluster getC_Cluster() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Cluster)MTable.get(getCtx(), org.pentanet.model.I_C_Cluster.Table_Name)
			.getPO(getC_Cluster_ID(), get_TrxName());	}

	/** Set C_Cluster.
		@param C_Cluster_ID C_Cluster	  */
	public void setC_Cluster_ID (int C_Cluster_ID)
	{
		if (C_Cluster_ID < 1) 
			set_Value (COLUMNNAME_C_Cluster_ID, null);
		else 
			set_Value (COLUMNNAME_C_Cluster_ID, Integer.valueOf(C_Cluster_ID));
	}

	/** Get C_Cluster.
		@return C_Cluster	  */
	public int getC_Cluster_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Cluster_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Field getC_Field() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Field)MTable.get(getCtx(), org.pentanet.model.I_C_Field.Table_Name)
			.getPO(getC_Field_ID(), get_TrxName());	}

	/** Set C_Field.
		@param C_Field_ID C_Field	  */
	public void setC_Field_ID (int C_Field_ID)
	{
		if (C_Field_ID < 1) 
			set_Value (COLUMNNAME_C_Field_ID, null);
		else 
			set_Value (COLUMNNAME_C_Field_ID, Integer.valueOf(C_Field_ID));
	}

	/** Get C_Field.
		@return C_Field	  */
	public int getC_Field_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Field_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Well.
		@param C_Well_ID C_Well	  */
	public void setC_Well_ID (int C_Well_ID)
	{
		if (C_Well_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Well_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Well_ID, Integer.valueOf(C_Well_ID));
	}

	/** Get C_Well.
		@return C_Well	  */
	public int getC_Well_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Well_ID);
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
}