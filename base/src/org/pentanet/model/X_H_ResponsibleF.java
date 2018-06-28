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

/** Generated Model for H_ResponsibleF
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_ResponsibleF extends PO implements I_H_ResponsibleF, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120229L;

    /** Standard Constructor */
    public X_H_ResponsibleF (Properties ctx, int H_ResponsibleF_ID, String trxName)
    {
      super (ctx, H_ResponsibleF_ID, trxName);
      /** if (H_ResponsibleF_ID == 0)
        {
			setCoverage (Env.ZERO);
			setDeductible (Env.ZERO);
			setH_ResponsibleF_ID (0);
			setKey (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_ResponsibleF (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_H_ResponsibleF[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Card.
		@param Card Card	  */
	public void setCard (boolean Card)
	{
		set_Value (COLUMNNAME_Card, Boolean.valueOf(Card));
	}

	/** Get Card.
		@return Card	  */
	public boolean isCard () 
	{
		Object oo = get_Value(COLUMNNAME_Card);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CopyCI.
		@param CopyCI CopyCI	  */
	public void setCopyCI (boolean CopyCI)
	{
		set_Value (COLUMNNAME_CopyCI, Boolean.valueOf(CopyCI));
	}

	/** Get CopyCI.
		@return CopyCI	  */
	public boolean isCopyCI () 
	{
		Object oo = get_Value(COLUMNNAME_CopyCI);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Coverage.
		@param Coverage Coverage	  */
	public void setCoverage (BigDecimal Coverage)
	{
		set_Value (COLUMNNAME_Coverage, Coverage);
	}

	/** Get Coverage.
		@return Coverage	  */
	public BigDecimal getCoverage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Coverage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Deductible.
		@param Deductible Deductible	  */
	public void setDeductible (BigDecimal Deductible)
	{
		set_Value (COLUMNNAME_Deductible, Deductible);
	}

	/** Get Deductible.
		@return Deductible	  */
	public BigDecimal getDeductible () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Deductible);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	public org.pentanet.model.I_H_Admission getH_Admission() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Admission)MTable.get(getCtx(), org.pentanet.model.I_H_Admission.Table_Name)
			.getPO(getH_Admission_ID(), get_TrxName());	}

	/** Set H_Admission.
		@param H_Admission_ID H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID)
	{
		if (H_Admission_ID < 1) 
			set_Value (COLUMNNAME_H_Admission_ID, null);
		else 
			set_Value (COLUMNNAME_H_Admission_ID, Integer.valueOf(H_Admission_ID));
	}

	/** Get H_Admission.
		@return H_Admission	  */
	public int getH_Admission_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Admission_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_H_Patient getH_Patient() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Patient)MTable.get(getCtx(), org.pentanet.model.I_H_Patient.Table_Name)
			.getPO(getH_Patient_ID(), get_TrxName());	}

	/** Set H_Patient.
		@param H_Patient_ID H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID)
	{
		if (H_Patient_ID < 1) 
			set_Value (COLUMNNAME_H_Patient_ID, null);
		else 
			set_Value (COLUMNNAME_H_Patient_ID, Integer.valueOf(H_Patient_ID));
	}

	/** Get H_Patient.
		@return H_Patient	  */
	public int getH_Patient_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Patient_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_ResponsibleF.
		@param H_ResponsibleF_ID H_ResponsibleF	  */
	public void setH_ResponsibleF_ID (int H_ResponsibleF_ID)
	{
		if (H_ResponsibleF_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_ResponsibleF_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_ResponsibleF_ID, Integer.valueOf(H_ResponsibleF_ID));
	}

	/** Get H_ResponsibleF.
		@return H_ResponsibleF	  */
	public int getH_ResponsibleF_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_ResponsibleF_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IOperator.
		@param IOperator 
		Insurance Operator
	  */
	public void setIOperator (String IOperator)
	{
		set_Value (COLUMNNAME_IOperator, IOperator);
	}

	/** Get IOperator.
		@return Insurance Operator
	  */
	public String getIOperator () 
	{
		return (String)get_Value(COLUMNNAME_IOperator);
	}

	/** Set Key.
		@param Key Key	  */
	public void setKey (String Key)
	{
		set_Value (COLUMNNAME_Key, Key);
	}

	/** Get Key.
		@return Key	  */
	public String getKey () 
	{
		return (String)get_Value(COLUMNNAME_Key);
	}

	/** Set Titular.
		@param Titular Titular	  */
	public void setTitular (String Titular)
	{
		set_Value (COLUMNNAME_Titular, Titular);
	}

	/** Get Titular.
		@return Titular	  */
	public String getTitular () 
	{
		return (String)get_Value(COLUMNNAME_Titular);
	}

	/** Set TypeOfNegotiation.
		@param TypeOfNegotiation 
		Tipo de Negociacion 
	  */
	public void setTypeOfNegotiation (String TypeOfNegotiation)
	{
		set_Value (COLUMNNAME_TypeOfNegotiation, TypeOfNegotiation);
	}

	/** Get TypeOfNegotiation.
		@return Tipo de Negociacion 
	  */
	public String getTypeOfNegotiation () 
	{
		return (String)get_Value(COLUMNNAME_TypeOfNegotiation);
	}

	/** Set U_Voucher.
		@param U_Voucher U_Voucher	  */
	public void setU_Voucher (boolean U_Voucher)
	{
		set_Value (COLUMNNAME_U_Voucher, Boolean.valueOf(U_Voucher));
	}

	/** Get U_Voucher.
		@return U_Voucher	  */
	public boolean isU_Voucher () 
	{
		Object oo = get_Value(COLUMNNAME_U_Voucher);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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