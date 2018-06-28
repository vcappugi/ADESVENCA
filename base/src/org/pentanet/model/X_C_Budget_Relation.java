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

/** Generated Model for C_Budget_Relation
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_C_Budget_Relation extends PO implements I_C_Budget_Relation, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20121119L;

    /** Standard Constructor */
    public X_C_Budget_Relation (Properties ctx, int C_Budget_Relation_ID, String trxName)
    {
      super (ctx, C_Budget_Relation_ID, trxName);
      /** if (C_Budget_Relation_ID == 0)
        {
			setC_Budget_Relation_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Budget_Relation (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Budget_Relation[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_ElementValue getC_Acct_() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_Acct_Bud(), get_TrxName());	}

	/** Set C_Acct_Bud.
		@param C_Acct_Bud C_Acct_Bud	  */
	public void setC_Acct_Bud (int C_Acct_Bud)
	{
		set_Value (COLUMNNAME_C_Acct_Bud, Integer.valueOf(C_Acct_Bud));
	}

	/** Get C_Acct_Bud.
		@return C_Acct_Bud	  */
	public int getC_Acct_Bud () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Acct_Bud);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getC_Acct_C() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_Acct_Cont(), get_TrxName());	}

	/** Set C_Acct_Cont.
		@param C_Acct_Cont C_Acct_Cont	  */
	public void setC_Acct_Cont (int C_Acct_Cont)
	{
		set_Value (COLUMNNAME_C_Acct_Cont, Integer.valueOf(C_Acct_Cont));
	}

	/** Get C_Acct_Cont.
		@return C_Acct_Cont	  */
	public int getC_Acct_Cont () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Acct_Cont);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Budget_Relation.
		@param C_Budget_Relation_ID C_Budget_Relation	  */
	public void setC_Budget_Relation_ID (int C_Budget_Relation_ID)
	{
		if (C_Budget_Relation_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Budget_Relation_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Budget_Relation_ID, Integer.valueOf(C_Budget_Relation_ID));
	}

	/** Get C_Budget_Relation.
		@return C_Budget_Relation	  */
	public int getC_Budget_Relation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Budget_Relation_ID);
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