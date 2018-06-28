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

/** Generated Model for R_MailTextVar
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_R_MailTextVar extends PO implements I_R_MailTextVar, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150421L;

    /** Standard Constructor */
    public X_R_MailTextVar (Properties ctx, int R_MailTextVar_ID, String trxName)
    {
      super (ctx, R_MailTextVar_ID, trxName);
      /** if (R_MailTextVar_ID == 0)
        {
			setName (null);
			setR_MailTextVar_ID (0);
			setSQLVar (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_R_MailTextVar (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_R_MailTextVar[")
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

	/** Set IsMail.
		@param IsMail IsMail	  */
	public void setIsMail (boolean IsMail)
	{
		set_Value (COLUMNNAME_IsMail, Boolean.valueOf(IsMail));
	}

	/** Get IsMail.
		@return IsMail	  */
	public boolean isMail () 
	{
		Object oo = get_Value(COLUMNNAME_IsMail);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsMailCc.
		@param IsMailCc IsMailCc	  */
	public void setIsMailCc (boolean IsMailCc)
	{
		set_Value (COLUMNNAME_IsMailCc, Boolean.valueOf(IsMailCc));
	}

	/** Get IsMailCc.
		@return IsMailCc	  */
	public boolean isMailCc () 
	{
		Object oo = get_Value(COLUMNNAME_IsMailCc);
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

	public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException
    {
		return (org.compiere.model.I_R_MailText)MTable.get(getCtx(), org.compiere.model.I_R_MailText.Table_Name)
			.getPO(getR_MailText_ID(), get_TrxName());	}

	/** Set Mail Template.
		@param R_MailText_ID 
		Text templates for mailings
	  */
	public void setR_MailText_ID (int R_MailText_ID)
	{
		if (R_MailText_ID < 1) 
			set_Value (COLUMNNAME_R_MailText_ID, null);
		else 
			set_Value (COLUMNNAME_R_MailText_ID, Integer.valueOf(R_MailText_ID));
	}

	/** Get Mail Template.
		@return Text templates for mailings
	  */
	public int getR_MailText_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_R_MailText_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set R_MailTextVar.
		@param R_MailTextVar_ID R_MailTextVar	  */
	public void setR_MailTextVar_ID (int R_MailTextVar_ID)
	{
		if (R_MailTextVar_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_R_MailTextVar_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_R_MailTextVar_ID, Integer.valueOf(R_MailTextVar_ID));
	}

	/** Get R_MailTextVar.
		@return R_MailTextVar	  */
	public int getR_MailTextVar_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_R_MailTextVar_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SQLVar.
		@param SQLVar SQLVar	  */
	public void setSQLVar (String SQLVar)
	{
		set_Value (COLUMNNAME_SQLVar, SQLVar);
	}

	/** Get SQLVar.
		@return SQLVar	  */
	public String getSQLVar () 
	{
		return (String)get_Value(COLUMNNAME_SQLVar);
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
	
	/** Set IsEncrypted.
	@param IsEncrypted	  */
public void setIsEncrypted (boolean IsEncrypted)
{
	set_Value (COLUMNNAME_IsEncrypted, Boolean.valueOf(IsEncrypted));
}

/** Get IsEncrypted.
	@return IsEncrypted	  */
public boolean isEncrypted () 
{
	Object oo = get_Value(COLUMNNAME_IsEncrypted);
	if (oo != null) 
	{
		 if (oo instanceof Boolean) 
			 return ((Boolean)oo).booleanValue(); 
		return "Y".equals(oo);
	}
	return false;
}
}