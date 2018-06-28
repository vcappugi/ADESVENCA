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

/** Generated Model for C_BudgetPublic_Exec_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_BudgetPublic_Exec_Line extends PO implements I_C_BudgetPublic_Exec_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160126L;

    /** Standard Constructor */
    public X_C_BudgetPublic_Exec_Line (Properties ctx, int C_BudgetPublic_Exec_Line_ID, String trxName)
    {
      super (ctx, C_BudgetPublic_Exec_Line_ID, trxName);
      /** if (C_BudgetPublic_Exec_Line_ID == 0)
        {
			setC_BudgetPublic_Exec_Line_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_BudgetPublic_Exec_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_BudgetPublic_Exec_Line[")
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

	/** Aprov AD_Reference_ID=319 */
	public static final int APROV_AD_Reference_ID=319;
	/** Yes = Y */
	public static final String APROV_Yes = "Y";
	/** No = N */
	public static final String APROV_No = "N";
	/** Set Aprov.
		@param Aprov Aprov	  */
	public void setAprov (String Aprov)
	{

		set_Value (COLUMNNAME_Aprov, Aprov);
	}

	/** Get Aprov.
		@return Aprov	  */
	public String getAprov () 
	{
		return (String)get_Value(COLUMNNAME_Aprov);
	}

	public org.compiere.model.I_C_BP_Group getC_BP_Group() throws RuntimeException
    {
		return (org.compiere.model.I_C_BP_Group)MTable.get(getCtx(), org.compiere.model.I_C_BP_Group.Table_Name)
			.getPO(getC_BP_Group_ID(), get_TrxName());	}

	/** Set Business Partner Group.
		@param C_BP_Group_ID 
		Business Partner Group
	  */
	public void setC_BP_Group_ID (int C_BP_Group_ID)
	{
		if (C_BP_Group_ID < 1) 
			set_Value (COLUMNNAME_C_BP_Group_ID, null);
		else 
			set_Value (COLUMNNAME_C_BP_Group_ID, Integer.valueOf(C_BP_Group_ID));
	}

	/** Get Business Partner Group.
		@return Business Partner Group
	  */
	public int getC_BP_Group_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BP_Group_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_BudgetPublic_Exec getC_BudgetPublic_Exec() throws RuntimeException
    {
		return (org.pentanet.model.I_C_BudgetPublic_Exec)MTable.get(getCtx(), org.pentanet.model.I_C_BudgetPublic_Exec.Table_Name)
			.getPO(getC_BudgetPublic_Exec_ID(), get_TrxName());	}

	/** Set C_BudgetPublic_Exec.
		@param C_BudgetPublic_Exec_ID C_BudgetPublic_Exec	  */
	public void setC_BudgetPublic_Exec_ID (int C_BudgetPublic_Exec_ID)
	{
		if (C_BudgetPublic_Exec_ID < 1) 
			set_Value (COLUMNNAME_C_BudgetPublic_Exec_ID, null);
		else 
			set_Value (COLUMNNAME_C_BudgetPublic_Exec_ID, Integer.valueOf(C_BudgetPublic_Exec_ID));
	}

	/** Get C_BudgetPublic_Exec.
		@return C_BudgetPublic_Exec	  */
	public int getC_BudgetPublic_Exec_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_Exec_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_BudgetPublic_Exec_Line.
		@param C_BudgetPublic_Exec_Line_ID C_BudgetPublic_Exec_Line	  */
	public void setC_BudgetPublic_Exec_Line_ID (int C_BudgetPublic_Exec_Line_ID)
	{
		if (C_BudgetPublic_Exec_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_Exec_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BudgetPublic_Exec_Line_ID, Integer.valueOf(C_BudgetPublic_Exec_Line_ID));
	}

	/** Get C_BudgetPublic_Exec_Line.
		@return C_BudgetPublic_Exec_Line	  */
	public int getC_BudgetPublic_Exec_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BudgetPublic_Exec_Line_ID);
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

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_InvoiceLine getC_InvoiceLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_InvoiceLine)MTable.get(getCtx(), org.compiere.model.I_C_InvoiceLine.Table_Name)
			.getPO(getC_InvoiceLine_ID(), get_TrxName());	}

	/** Set Invoice Line.
		@param C_InvoiceLine_ID 
		Invoice Detail Line
	  */
	public void setC_InvoiceLine_ID (int C_InvoiceLine_ID)
	{
		if (C_InvoiceLine_ID < 1) 
			set_Value (COLUMNNAME_C_InvoiceLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_InvoiceLine_ID, Integer.valueOf(C_InvoiceLine_ID));
	}

	/** Get Invoice Line.
		@return Invoice Detail Line
	  */
	public int getC_InvoiceLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_InvoiceLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getC_OrderLine_ID(), get_TrxName());	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID 
		Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_Payment_ID(), get_TrxName());	}

	/** Set Payment.
		@param C_Payment_ID 
		Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID)
	{
		if (C_Payment_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
	}

	/** Get Payment.
		@return Payment identifier
	  */
	public int getC_Payment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_ID);
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

	public org.eevolution.model.I_HR_Concept getHR_Concept() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Concept)MTable.get(getCtx(), org.eevolution.model.I_HR_Concept.Table_Name)
			.getPO(getHR_Concept_ID(), get_TrxName());	}

	/** Set Payroll Concept.
		@param HR_Concept_ID Payroll Concept	  */
	public void setHR_Concept_ID (int HR_Concept_ID)
	{
		if (HR_Concept_ID < 1) 
			set_Value (COLUMNNAME_HR_Concept_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Concept_ID, Integer.valueOf(HR_Concept_ID));
	}

	/** Get Payroll Concept.
		@return Payroll Concept	  */
	public int getHR_Concept_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_RequisitionLine getM_RequisitionLine() throws RuntimeException
    {
		return (org.compiere.model.I_M_RequisitionLine)MTable.get(getCtx(), org.compiere.model.I_M_RequisitionLine.Table_Name)
			.getPO(getM_RequisitionLine_ID(), get_TrxName());	}

	/** Set Requisition Line.
		@param M_RequisitionLine_ID 
		Material Requisition Line
	  */
	public void setM_RequisitionLine_ID (int M_RequisitionLine_ID)
	{
		if (M_RequisitionLine_ID < 1) 
			set_Value (COLUMNNAME_M_RequisitionLine_ID, null);
		else 
			set_Value (COLUMNNAME_M_RequisitionLine_ID, Integer.valueOf(M_RequisitionLine_ID));
	}

	/** Get Requisition Line.
		@return Material Requisition Line
	  */
	public int getM_RequisitionLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_RequisitionLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	@Override
	public int getC_BankStatementLine_ID() {
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankStatementLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public void setC_BankStatementLine_ID(int C_BankStatementLine_ID) {
		if (C_BankStatementLine_ID < 1) 
			set_Value (COLUMNNAME_C_BankStatementLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankStatementLine_ID, Integer.valueOf(C_BankStatementLine_ID));
		
	}
	
	/** Set GL_JournalLine_ID.
	@param GL_JournalLine_ID GL_JournalLine_ID	  */
public void setGL_JournalLine_ID (int GL_JournalLine_ID)
{
	if (GL_JournalLine_ID < 1) 
		set_ValueNoCheck (COLUMNNAME_GL_JournalLine_ID, null);
	else 
		set_ValueNoCheck (COLUMNNAME_GL_JournalLine_ID, Integer.valueOf(GL_JournalLine_ID));
}

/** Get C_BudgetPublic_Line.
	@return C_BudgetPublic_Line	  */
public int getGL_JournalLine_ID () 
{
	Integer ii = (Integer)get_Value(COLUMNNAME_GL_JournalLine_ID);
	if (ii == null)
		 return 0;
	return ii.intValue();
}
}