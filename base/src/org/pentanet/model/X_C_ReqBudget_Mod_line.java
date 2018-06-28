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

/** Generated Model for C_ReqBudget_Mod_line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_ReqBudget_Mod_line extends PO implements I_C_ReqBudget_Mod_line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170810L;

    /** Standard Constructor */
    public X_C_ReqBudget_Mod_line (Properties ctx, int C_ReqBudget_Mod_line_ID, String trxName)
    {
      super (ctx, C_ReqBudget_Mod_line_ID, trxName);
      /** if (C_ReqBudget_Mod_line_ID == 0)
        {
			setAC_Project (0);
			setC_Manage_Unit_ID (0);
			setC_ReqBudget_Mod_line_ID (0);
			setMovementTye (null);
// C
			setSource_Account_ID (0);
			setSource_Project_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_ReqBudget_Mod_line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_ReqBudget_Mod_line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_ElementValue getAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getAccount_ID(), get_TrxName());	}

	/** Set Account.
		@param Account_ID 
		Account used
	  */
	public void setAccount_ID (int Account_ID)
	{
		if (Account_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Account_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Account_ID, Integer.valueOf(Account_ID));
	}

	/** Get Account.
		@return Account used
	  */
	public int getAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_BudgetPublic getAC_Proj() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic.Table_Name)
			.getPO(getAC_Project(), get_TrxName());	}

	/** Set AC_Project.
		@param AC_Project AC_Project	  */
	public void setAC_Project (int AC_Project)
	{
		set_Value (COLUMNNAME_AC_Project, Integer.valueOf(AC_Project));
	}

	/** Get AC_Project.
		@return AC_Project	  */
	public int getAC_Project () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AC_Project);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Amount.
		@param Amount 
		Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.pentanet.model.I_C_BudgetMod getC_BudgetMod() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetMod)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetMod.Table_Name)
			.getPO(getC_BudgetMod_ID(), get_TrxName());	}

	/** Set C_BudgetMod.
		@param C_BudgetMod_ID C_BudgetMod	  */
	public void setC_BudgetMod_ID (int C_BudgetMod_ID)
	{
		if (C_BudgetMod_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetMod_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetMod_ID, Integer.valueOf(C_BudgetMod_ID));
	}

	/** Get C_BudgetMod.
		@return C_BudgetMod	  */
	public int getC_BudgetMod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetMod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID getC_BUDGETPMOD_TYPE_ID() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID)MTable.get(getCtx(), org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID.Table_Name)
			.getPO(getC_BUDGETPMOD_TYPE_ID_ID(), get_TrxName());	}

	/** Set C_BUDGETPMOD_TYPE_ID_ID.
		@param C_BUDGETPMOD_TYPE_ID_ID C_BUDGETPMOD_TYPE_ID_ID	  */
	public void setC_BUDGETPMOD_TYPE_ID_ID (int C_BUDGETPMOD_TYPE_ID_ID)
	{
		if (C_BUDGETPMOD_TYPE_ID_ID < 1) 
			set_Value (COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID, null);
		else 
			set_Value (COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID, Integer.valueOf(C_BUDGETPMOD_TYPE_ID_ID));
	}

	/** Get C_BUDGETPMOD_TYPE_ID_ID.
		@return C_BUDGETPMOD_TYPE_ID_ID	  */
	public int getC_BUDGETPMOD_TYPE_ID_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Manage_Unit getC_Manage_Unit() throws RuntimeException
    {
		return (org.compiere.model.I_C_Manage_Unit)MTable.get(getCtx(), org.compiere.model.I_C_Manage_Unit.Table_Name)
			.getPO(getC_Manage_Unit_ID(), get_TrxName());	}

	/** Set C_Manage_Unit.
		@param C_Manage_Unit_ID C_Manage_Unit	  */
	public void setC_Manage_Unit_ID (int C_Manage_Unit_ID)
	{
		if (C_Manage_Unit_ID < 1) 
			set_Value (COLUMNNAME_C_Manage_Unit_ID, null);
		else 
			set_Value (COLUMNNAME_C_Manage_Unit_ID, Integer.valueOf(C_Manage_Unit_ID));
	}

	/** Get C_Manage_Unit.
		@return C_Manage_Unit	  */
	public int getC_Manage_Unit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Manage_Unit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_ReqBudget_Mod getC_ReqBudget_Mod() throws RuntimeException
    {
		return (org.pentanet.model.I_C_ReqBudget_Mod)MTable.get(getCtx(), org.pentanet.model.I_C_ReqBudget_Mod.Table_Name)
			.getPO(getC_ReqBudget_Mod_ID(), get_TrxName());	}

	/** Set C_ReqBudget_Mod.
		@param C_ReqBudget_Mod_ID C_ReqBudget_Mod	  */
	public void setC_ReqBudget_Mod_ID (int C_ReqBudget_Mod_ID)
	{
		if (C_ReqBudget_Mod_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_ID, Integer.valueOf(C_ReqBudget_Mod_ID));
	}

	/** Get C_ReqBudget_Mod.
		@return C_ReqBudget_Mod	  */
	public int getC_ReqBudget_Mod_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ReqBudget_Mod_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_ReqBudget_Mod_line.
		@param C_ReqBudget_Mod_line_ID C_ReqBudget_Mod_line	  */
	public void setC_ReqBudget_Mod_line_ID (int C_ReqBudget_Mod_line_ID)
	{
		if (C_ReqBudget_Mod_line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_ReqBudget_Mod_line_ID, Integer.valueOf(C_ReqBudget_Mod_line_ID));
	}

	/** Get C_ReqBudget_Mod_line.
		@return C_ReqBudget_Mod_line	  */
	public int getC_ReqBudget_Mod_line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ReqBudget_Mod_line_ID);
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** MovementTye AD_Reference_ID=1000143 */
	public static final int MOVEMENTTYE_AD_Reference_ID=1000143;
	/** Receptor = R */
	public static final String MOVEMENTTYE_Receptor = "R";
	/** Cedente = C */
	public static final String MOVEMENTTYE_Cedente = "C";
	/** Set MovementTye.
		@param MovementTye MovementTye	  */
	public void setMovementTye (String MovementTye)
	{

		set_Value (COLUMNNAME_MovementTye, MovementTye);
	}

	/** Get MovementTye.
		@return MovementTye	  */
	public String getMovementTye () 
	{
		return (String)get_Value(COLUMNNAME_MovementTye);
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

	public org.compiere.model.I_C_ElementValue getSource_Account() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getSource_Account_ID(), get_TrxName());	}

	/** Set Source_Account_ID.
		@param Source_Account_ID Source_Account_ID	  */
	public void setSource_Account_ID (int Source_Account_ID)
	{
		if (Source_Account_ID < 1) 
			set_Value (COLUMNNAME_Source_Account_ID, null);
		else 
			set_Value (COLUMNNAME_Source_Account_ID, Integer.valueOf(Source_Account_ID));
	}

	/** Get Source_Account_ID.
		@return Source_Account_ID	  */
	public int getSource_Account_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Source_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Source_Amount.
		@param Source_Amount Source_Amount	  */
	public void setSource_Amount (BigDecimal Source_Amount)
	{
		set_Value (COLUMNNAME_Source_Amount, Source_Amount);
	}

	/** Get Source_Amount.
		@return Source_Amount	  */
	public BigDecimal getSource_Amount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Source_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.pentanet.model.I_C_BudgetPublic getSource_Project() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic.Table_Name)
			.getPO(getSource_Project_ID(), get_TrxName());	}

	/** Set Source_Project_ID.
		@param Source_Project_ID Source_Project_ID	  */
	public void setSource_Project_ID (int Source_Project_ID)
	{
		if (Source_Project_ID < 1) 
			set_Value (COLUMNNAME_Source_Project_ID, null);
		else 
			set_Value (COLUMNNAME_Source_Project_ID, Integer.valueOf(Source_Project_ID));
	}

	/** Get Source_Project_ID.
		@return Source_Project_ID	  */
	public int getSource_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Source_Project_ID);
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
}