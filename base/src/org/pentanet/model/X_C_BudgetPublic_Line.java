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

/** Generated Model for C_BudgetPublic_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_BudgetPublic_Line extends PO implements I_C_BudgetPublic_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170525L;

    /** Standard Constructor */
    public X_C_BudgetPublic_Line (Properties ctx, int C_BudgetPublic_Line_ID, String trxName)
    {
      super (ctx, C_BudgetPublic_Line_ID, trxName);
      /** if (C_BudgetPublic_Line_ID == 0)
        {
			setC_BudgetPublic_Line_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetPublic_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetPublic_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set AmountModify.
		@param AmountModify AmountModify	  */
	public void setAmountModify (BigDecimal AmountModify)
	{
		set_Value (COLUMNNAME_AmountModify, AmountModify);
	}

	/** Get AmountModify.
		@return AmountModify	  */
	public BigDecimal getAmountModify () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmountModify);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtCau.
		@param AmtCau AmtCau	  */
	public void setAmtCau (BigDecimal AmtCau)
	{
		set_Value (COLUMNNAME_AmtCau, AmtCau);
	}

	/** Get AmtCau.
		@return AmtCau	  */
	public BigDecimal getAmtCau () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtCau);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtComp.
		@param AmtComp AmtComp	  */
	public void setAmtComp (BigDecimal AmtComp)
	{
		set_Value (COLUMNNAME_AmtComp, AmtComp);
	}

	/** Get AmtComp.
		@return AmtComp	  */
	public BigDecimal getAmtComp () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtComp);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtPay.
		@param AmtPay AmtPay	  */
	public void setAmtPay (BigDecimal AmtPay)
	{
		set_Value (COLUMNNAME_AmtPay, AmtPay);
	}

	/** Get AmtPay.
		@return AmtPay	  */
	public BigDecimal getAmtPay () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtPay);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set AmtPreC.
		@param AmtPreC AmtPreC	  */
	public void setAmtPreC (BigDecimal AmtPreC)
	{
		set_Value (COLUMNNAME_AmtPreC, AmtPreC);
	}

	/** Get AmtPreC.
		@return AmtPreC	  */
	public BigDecimal getAmtPreC () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtPreC);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_ElementValue getC_Acct_Cont() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_Acct_Cont_ID(), get_TrxName());	}

	/** Set C_Acct_Cont_ID.
		@param C_Acct_Cont_ID C_Acct_Cont_ID	  */
	public void setC_Acct_Cont_ID (int C_Acct_Cont_ID)
	{
		if (C_Acct_Cont_ID < 1) 
			set_Value (COLUMNNAME_C_Acct_Cont_ID, null);
		else 
			set_Value (COLUMNNAME_C_Acct_Cont_ID, Integer.valueOf(C_Acct_Cont_ID));
	}

	/** Get C_Acct_Cont_ID.
		@return C_Acct_Cont_ID	  */
	public int getC_Acct_Cont_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Acct_Cont_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getC_Budget_Account() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_Budget_Account_ID(), get_TrxName());	}

	/** Set C_Budget_Account_ID.
		@param C_Budget_Account_ID C_Budget_Account_ID	  */
	public void setC_Budget_Account_ID (int C_Budget_Account_ID)
	{
		if (C_Budget_Account_ID < 1) 
			set_Value (COLUMNNAME_C_Budget_Account_ID, null);
		else 
			set_Value (COLUMNNAME_C_Budget_Account_ID, Integer.valueOf(C_Budget_Account_ID));
	}

	/** Get C_Budget_Account_ID.
		@return C_Budget_Account_ID	  */
	public int getC_Budget_Account_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Budget_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_BudgetPublic getC_BudgetPublic() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic.Table_Name)
			.getPO(getC_BudgetPublic_ID(), get_TrxName());	}

	/** Set C_BudgetPublic.
		@param C_BudgetPublic_ID C_BudgetPublic	  */
	public void setC_BudgetPublic_ID (int C_BudgetPublic_ID)
	{
		if (C_BudgetPublic_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetPublic_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetPublic_ID, Integer.valueOf(C_BudgetPublic_ID));
	}

	/** Get C_BudgetPublic.
		@return C_BudgetPublic	  */
	public int getC_BudgetPublic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_BudgetPublic_Line.
		@param C_BudgetPublic_Line_ID C_BudgetPublic_Line	  */
	public void setC_BudgetPublic_Line_ID (int C_BudgetPublic_Line_ID)
	{
		if (C_BudgetPublic_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_Line_ID, Integer.valueOf(C_BudgetPublic_Line_ID));
	}

	/** Get C_BudgetPublic_Line.
		@return C_BudgetPublic_Line	  */
	public int getC_BudgetPublic_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
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

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set RealAmount.
		@param RealAmount RealAmount	  */
	public void setRealAmount (BigDecimal RealAmount)
	{
		set_Value (COLUMNNAME_RealAmount, RealAmount);
	}

	/** Get RealAmount.
		@return RealAmount	  */
	public BigDecimal getRealAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RealAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Recalculate.
		@param Recalculate Recalculate	  */
	public void setRecalculate (String Recalculate)
	{
		set_Value (COLUMNNAME_Recalculate, Recalculate);
	}

	/** Get Recalculate.
		@return Recalculate	  */
	public String getRecalculate () 
	{
		return (String)get_Value(COLUMNNAME_Recalculate);
	}
	
	


}