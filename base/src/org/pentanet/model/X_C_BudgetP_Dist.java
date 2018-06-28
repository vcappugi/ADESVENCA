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

/** Generated Model for C_BudgetP_Dist
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_C_BudgetP_Dist extends PO implements I_C_BudgetP_Dist, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20130118L;

    /** Standard Constructor */
    public X_C_BudgetP_Dist (Properties ctx, int C_BudgetP_Dist_ID, String trxName)
    {
      super (ctx, C_BudgetP_Dist_ID, trxName);
      /** if (C_BudgetP_Dist_ID == 0)
        {
			setC_BudgetP_Dist_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetP_Dist (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetP_Dist[")
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
			set_Value (COLUMNNAME_Account_ID, null);
		else 
			set_Value (COLUMNNAME_Account_ID, Integer.valueOf(Account_ID));
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

	/** Set C_BudgetP_Dist.
		@param C_BudgetP_Dist_ID C_BudgetP_Dist	  */
	public void setC_BudgetP_Dist_ID (int C_BudgetP_Dist_ID)
	{
		if (C_BudgetP_Dist_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetP_Dist_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetP_Dist_ID, Integer.valueOf(C_BudgetP_Dist_ID));
	}

	/** Get C_BudgetP_Dist.
		@return C_BudgetP_Dist	  */
	public int getC_BudgetP_Dist_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetP_Dist_ID);
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

	public org.pentanet.model.I_C_BudgetPublic_Line getC_BudgetPublic_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic_Line)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic_Line.Table_Name)
			.getPO(getC_BudgetPublic_Line_ID(), get_TrxName());	}

	/** Set C_BudgetPublic_Line.
		@param C_BudgetPublic_Line_ID C_BudgetPublic_Line	  */
	public void setC_BudgetPublic_Line_ID (int C_BudgetPublic_Line_ID)
	{
		if (C_BudgetPublic_Line_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetPublic_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetPublic_Line_ID, Integer.valueOf(C_BudgetPublic_Line_ID));
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

	/** Set Periodo_1.
		@param Periodo_1 Periodo_1	  */
	public void setPeriodo_1 (BigDecimal Periodo_1)
	{
		set_Value (COLUMNNAME_Periodo_1, Periodo_1);
	}

	/** Get Periodo_1.
		@return Periodo_1	  */
	public BigDecimal getPeriodo_1 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_1);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_10.
		@param Periodo_10 Periodo_10	  */
	public void setPeriodo_10 (BigDecimal Periodo_10)
	{
		set_Value (COLUMNNAME_Periodo_10, Periodo_10);
	}

	/** Get Periodo_10.
		@return Periodo_10	  */
	public BigDecimal getPeriodo_10 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_10);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_11.
		@param Periodo_11 Periodo_11	  */
	public void setPeriodo_11 (BigDecimal Periodo_11)
	{
		set_Value (COLUMNNAME_Periodo_11, Periodo_11);
	}

	/** Get Periodo_11.
		@return Periodo_11	  */
	public BigDecimal getPeriodo_11 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_11);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_12.
		@param Periodo_12 Periodo_12	  */
	public void setPeriodo_12 (BigDecimal Periodo_12)
	{
		set_Value (COLUMNNAME_Periodo_12, Periodo_12);
	}

	/** Get Periodo_12.
		@return Periodo_12	  */
	public BigDecimal getPeriodo_12 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_12);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_2.
		@param Periodo_2 Periodo_2	  */
	public void setPeriodo_2 (BigDecimal Periodo_2)
	{
		set_Value (COLUMNNAME_Periodo_2, Periodo_2);
	}

	/** Get Periodo_2.
		@return Periodo_2	  */
	public BigDecimal getPeriodo_2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_3.
		@param Periodo_3 Periodo_3	  */
	public void setPeriodo_3 (BigDecimal Periodo_3)
	{
		set_Value (COLUMNNAME_Periodo_3, Periodo_3);
	}

	/** Get Periodo_3.
		@return Periodo_3	  */
	public BigDecimal getPeriodo_3 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_3);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_4.
		@param Periodo_4 Periodo_4	  */
	public void setPeriodo_4 (BigDecimal Periodo_4)
	{
		set_Value (COLUMNNAME_Periodo_4, Periodo_4);
	}

	/** Get Periodo_4.
		@return Periodo_4	  */
	public BigDecimal getPeriodo_4 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_4);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_5.
		@param Periodo_5 Periodo_5	  */
	public void setPeriodo_5 (BigDecimal Periodo_5)
	{
		set_Value (COLUMNNAME_Periodo_5, Periodo_5);
	}

	/** Get Periodo_5.
		@return Periodo_5	  */
	public BigDecimal getPeriodo_5 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_5);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_6.
		@param Periodo_6 Periodo_6	  */
	public void setPeriodo_6 (BigDecimal Periodo_6)
	{
		set_Value (COLUMNNAME_Periodo_6, Periodo_6);
	}

	/** Get Periodo_6.
		@return Periodo_6	  */
	public BigDecimal getPeriodo_6 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_6);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_7.
		@param Periodo_7 Periodo_7	  */
	public void setPeriodo_7 (BigDecimal Periodo_7)
	{
		set_Value (COLUMNNAME_Periodo_7, Periodo_7);
	}

	/** Get Periodo_7.
		@return Periodo_7	  */
	public BigDecimal getPeriodo_7 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_7);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_8.
		@param Periodo_8 Periodo_8	  */
	public void setPeriodo_8 (BigDecimal Periodo_8)
	{
		set_Value (COLUMNNAME_Periodo_8, Periodo_8);
	}

	/** Get Periodo_8.
		@return Periodo_8	  */
	public BigDecimal getPeriodo_8 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_8);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Periodo_9.
		@param Periodo_9 Periodo_9	  */
	public void setPeriodo_9 (BigDecimal Periodo_9)
	{
		set_Value (COLUMNNAME_Periodo_9, Periodo_9);
	}

	/** Get Periodo_9.
		@return Periodo_9	  */
	public BigDecimal getPeriodo_9 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Periodo_9);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}