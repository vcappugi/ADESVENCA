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

/** Generated Model for HR_RotationWG
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_HR_RotationWG extends PO implements I_HR_RotationWG, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131115L;

    /** Standard Constructor */
    public X_HR_RotationWG (Properties ctx, int HR_RotationWG_ID, String trxName)
    {
      super (ctx, HR_RotationWG_ID, trxName);
      /** if (HR_RotationWG_ID == 0)
        {
			setHR_RotationWG_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_RotationWG (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_RotationWG[")
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

	public org.pentanet.model.I_HR_GuardRole getHR_GuardRole() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_GuardRole)MTable.get(getCtx(), org.pentanet.model.I_HR_GuardRole.Table_Name)
			.getPO(getHR_GuardRole_ID(), get_TrxName());	}

	/** Set HR_GuardRole.
		@param HR_GuardRole_ID HR_GuardRole	  */
	public void setHR_GuardRole_ID (int HR_GuardRole_ID)
	{
		if (HR_GuardRole_ID < 1) 
			set_Value (COLUMNNAME_HR_GuardRole_ID, null);
		else 
			set_Value (COLUMNNAME_HR_GuardRole_ID, Integer.valueOf(HR_GuardRole_ID));
	}

	/** Get HR_GuardRole.
		@return HR_GuardRole	  */
	public int getHR_GuardRole_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_GuardRole_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Rotation getHR_Rotation() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Rotation)MTable.get(getCtx(), org.pentanet.model.I_HR_Rotation.Table_Name)
			.getPO(getHR_Rotation_ID(), get_TrxName());	}

	/** Set HR_Rotation.
		@param HR_Rotation_ID HR_Rotation	  */
	public void setHR_Rotation_ID (int HR_Rotation_ID)
	{
		if (HR_Rotation_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Rotation_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Rotation_ID, Integer.valueOf(HR_Rotation_ID));
	}

	/** Get HR_Rotation.
		@return HR_Rotation	  */
	public int getHR_Rotation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Rotation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_RotationType getHR_RotationType() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_RotationType)MTable.get(getCtx(), org.pentanet.model.I_HR_RotationType.Table_Name)
			.getPO(getHR_RotationType_ID(), get_TrxName());	}

	/** Set HR_RotationType.
		@param HR_RotationType_ID HR_RotationType	  */
	public void setHR_RotationType_ID (int HR_RotationType_ID)
	{
		if (HR_RotationType_ID < 1) 
			set_Value (COLUMNNAME_HR_RotationType_ID, null);
		else 
			set_Value (COLUMNNAME_HR_RotationType_ID, Integer.valueOf(HR_RotationType_ID));
	}

	/** Get HR_RotationType.
		@return HR_RotationType	  */
	public int getHR_RotationType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_RotationType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_RotationWG.
		@param HR_RotationWG_ID HR_RotationWG	  */
	public void setHR_RotationWG_ID (int HR_RotationWG_ID)
	{
		if (HR_RotationWG_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_RotationWG_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_RotationWG_ID, Integer.valueOf(HR_RotationWG_ID));
	}

	/** Get HR_RotationWG.
		@return HR_RotationWG	  */
	public int getHR_RotationWG_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_RotationWG_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Standing getHR_Standing() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Standing)MTable.get(getCtx(), org.pentanet.model.I_HR_Standing.Table_Name)
			.getPO(getHR_Standing_ID(), get_TrxName());	}

	/** Set HR_Standing.
		@param HR_Standing_ID HR_Standing	  */
	public void setHR_Standing_ID (int HR_Standing_ID)
	{
		if (HR_Standing_ID < 1) 
			set_Value (COLUMNNAME_HR_Standing_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Standing_ID, Integer.valueOf(HR_Standing_ID));
	}

	/** Get HR_Standing.
		@return HR_Standing	  */
	public int getHR_Standing_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Standing_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_WorkGroup getHR_WorkGroup() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_WorkGroup)MTable.get(getCtx(), org.pentanet.model.I_HR_WorkGroup.Table_Name)
			.getPO(getHR_WorkGroup_ID(), get_TrxName());	}

	/** Set HR_WorkGroup.
		@param HR_WorkGroup_ID HR_WorkGroup	  */
	public void setHR_WorkGroup_ID (int HR_WorkGroup_ID)
	{
		if (HR_WorkGroup_ID < 1) 
			set_Value (COLUMNNAME_HR_WorkGroup_ID, null);
		else 
			set_Value (COLUMNNAME_HR_WorkGroup_ID, Integer.valueOf(HR_WorkGroup_ID));
	}

	/** Get HR_WorkGroup.
		@return HR_WorkGroup	  */
	public int getHR_WorkGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkGroup_ID);
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
}