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

/** Generated Model for C_Payment_SchemaLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Payment_SchemaLine extends PO implements I_C_Payment_SchemaLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160114L;

    /** Standard Constructor */
    public X_C_Payment_SchemaLine (Properties ctx, int C_Payment_SchemaLine_ID, String trxName)
    {
      super (ctx, C_Payment_SchemaLine_ID, trxName);
      /** if (C_Payment_SchemaLine_ID == 0)
        {
			setC_Payment_Schema_ID (0);
			setC_Payment_SchemaLine_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_Payment_SchemaLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Payment_SchemaLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_C_Advance_Request getC_Advance_Request() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Advance_Request)MTable.get(getCtx(), org.pentanet.model.I_C_Advance_Request.Table_Name)
			.getPO(getC_Advance_Request_ID(), get_TrxName());	}

	/** Set C_Advance_Request.
		@param C_Advance_Request_ID C_Advance_Request	  */
	public void setC_Advance_Request_ID (int C_Advance_Request_ID)
	{
		if (C_Advance_Request_ID < 1) 
			set_Value (COLUMNNAME_C_Advance_Request_ID, null);
		else 
			set_Value (COLUMNNAME_C_Advance_Request_ID, Integer.valueOf(C_Advance_Request_ID));
	}

	/** Get C_Advance_Request.
		@return C_Advance_Request	  */
	public int getC_Advance_Request_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Advance_Request_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_C_Group_Line getC_Group_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Group_Line)MTable.get(getCtx(), org.pentanet.model.I_C_Group_Line.Table_Name)
			.getPO(getC_Group_Line_ID(), get_TrxName());	}

	/** Set C_Group_Line.
		@param C_Group_Line_ID C_Group_Line	  */
	public void setC_Group_Line_ID (int C_Group_Line_ID)
	{
		if (C_Group_Line_ID < 1) 
			set_Value (COLUMNNAME_C_Group_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_Group_Line_ID, Integer.valueOf(C_Group_Line_ID));
	}

	/** Get C_Group_Line.
		@return C_Group_Line	  */
	public int getC_Group_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Group_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
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

	public org.pentanet.model.I_C_Payment_SchemaGroup getC_Payment_SchemaGroup() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Payment_SchemaGroup)MTable.get(getCtx(), org.pentanet.model.I_C_Payment_SchemaGroup.Table_Name)
			.getPO(getC_Payment_SchemaGroup_ID(), get_TrxName());	}

	/** Set Payment Schema Group.
		@param C_Payment_SchemaGroup_ID Payment Schema Group	  */
	public void setC_Payment_SchemaGroup_ID (int C_Payment_SchemaGroup_ID)
	{
		if (C_Payment_SchemaGroup_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_SchemaGroup_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_SchemaGroup_ID, Integer.valueOf(C_Payment_SchemaGroup_ID));
	}

	/** Get Payment Schema Group.
		@return Payment Schema Group	  */
	public int getC_Payment_SchemaGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_SchemaGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Payment_Schema.
		@param C_Payment_Schema_ID C_Payment_Schema	  */
	public void setC_Payment_Schema_ID (int C_Payment_Schema_ID)
	{
		if (C_Payment_Schema_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Schema_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_Schema_ID, Integer.valueOf(C_Payment_Schema_ID));
	}

	/** Get C_Payment_Schema.
		@return C_Payment_Schema	  */
	public int getC_Payment_Schema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_Schema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_Payment_SchemaLine.
		@param C_Payment_SchemaLine_ID C_Payment_SchemaLine	  */
	public void setC_Payment_SchemaLine_ID (int C_Payment_SchemaLine_ID)
	{
		if (C_Payment_SchemaLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Payment_SchemaLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_SchemaLine_ID, Integer.valueOf(C_Payment_SchemaLine_ID));
	}

	/** Get C_Payment_SchemaLine.
		@return C_Payment_SchemaLine	  */
	public int getC_Payment_SchemaLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_SchemaLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_C_Purchase_Plain_Line getC_Purchase_Plain_Line() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Purchase_Plain_Line)MTable.get(getCtx(), org.pentanet.model.I_C_Purchase_Plain_Line.Table_Name)
			.getPO(getC_Purchase_Plain_Line_ID(), get_TrxName());	}

	/** Set C_Purchase_Plain_Line.
		@param C_Purchase_Plain_Line_ID C_Purchase_Plain_Line	  */
	public void setC_Purchase_Plain_Line_ID (int C_Purchase_Plain_Line_ID)
	{
		if (C_Purchase_Plain_Line_ID < 1) 
			set_Value (COLUMNNAME_C_Purchase_Plain_Line_ID, null);
		else 
			set_Value (COLUMNNAME_C_Purchase_Plain_Line_ID, Integer.valueOf(C_Purchase_Plain_Line_ID));
	}

	/** Get C_Purchase_Plain_Line.
		@return C_Purchase_Plain_Line	  */
	public int getC_Purchase_Plain_Line_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Purchase_Plain_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Document.
		@param Document Document	  */
	public void setDocument (String Document)
	{
		set_ValueNoCheck (COLUMNNAME_Document, Document);
	}

	/** Get Document.
		@return Document	  */
	public String getDocument () 
	{
		return (String)get_Value(COLUMNNAME_Document);
	}

	/** DueClasif AD_Reference_ID=1000207 */
	public static final int DUECLASIF_AD_Reference_ID=1000207;
	/** MAS 90 VENCIDA = VMAS90 */
	public static final String DUECLASIF_MAS90VENCIDA = "VMAS90";
	/** MENOS 90 VENCIDA = VMEN90 */
	public static final String DUECLASIF_MENOS90VENCIDA = "VMEN90";
	/** MENOS 60 VENCIDA = VMEN60 */
	public static final String DUECLASIF_MENOS60VENCIDA = "VMEN60";
	/** MENOS 30 VENCIDA = VMEN30 */
	public static final String DUECLASIF_MENOS30VENCIDA = "VMEN30";
	/** POR VENCER A 30 = PVMEN30 */
	public static final String DUECLASIF_PORVENCERA30 = "PVMEN30";
	/** POR VENCER A 60 = PVMEN60 */
	public static final String DUECLASIF_PORVENCERA60 = "PVMEN60";
	/** POR VENCER A 90 = PVMEN90 */
	public static final String DUECLASIF_PORVENCERA90 = "PVMEN90";
	/** POR VENCER MAS DE 90 = PVMAS90 */
	public static final String DUECLASIF_PORVENCERMASDE90 = "PVMAS90";
	/** Set DueClasif.
		@param DueClasif DueClasif	  */
	public void setDueClasif (String DueClasif)
	{

		set_Value (COLUMNNAME_DueClasif, DueClasif);
	}

	/** Get DueClasif.
		@return DueClasif	  */
	public String getDueClasif () 
	{
		return (String)get_Value(COLUMNNAME_DueClasif);
	}

	/** Set Grand Total.
		@param GrandTotal 
		Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal)
	{
		set_Value (COLUMNNAME_GrandTotal, GrandTotal);
	}

	/** Get Grand Total.
		@return Total amount of document
	  */
	public BigDecimal getGrandTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrandTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Approved.
		@param IsApproved 
		Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved)
	{
		set_Value (COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
	}

	/** Get Approved.
		@return Indicates if this document requires approval
	  */
	public boolean isApproved () 
	{
		Object oo = get_Value(COLUMNNAME_IsApproved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Due.
		@param IsDue 
		Subscription Renewal is Due
	  */
	public void setIsDue (boolean IsDue)
	{
		set_Value (COLUMNNAME_IsDue, Boolean.valueOf(IsDue));
	}

	/** Get Due.
		@return Subscription Renewal is Due
	  */
	public boolean isDue () 
	{
		Object oo = get_Value(COLUMNNAME_IsDue);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Generated.
		@param IsGenerated 
		This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated)
	{
		set_Value (COLUMNNAME_IsGenerated, Boolean.valueOf(IsGenerated));
	}

	/** Get Generated.
		@return This Line is generated
	  */
	public boolean isGenerated () 
	{
		Object oo = get_Value(COLUMNNAME_IsGenerated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsTotalPaid.
		@param IsTotalPaid IsTotalPaid	  */
	public void setIsTotalPaid (boolean IsTotalPaid)
	{
		set_Value (COLUMNNAME_IsTotalPaid, Boolean.valueOf(IsTotalPaid));
	}

	/** Get IsTotalPaid.
		@return IsTotalPaid	  */
	public boolean isTotalPaid () 
	{
		Object oo = get_Value(COLUMNNAME_IsTotalPaid);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Payment amount.
		@param PayAmt 
		Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt)
	{
		set_Value (COLUMNNAME_PayAmt, PayAmt);
	}

	/** Get Payment amount.
		@return Amount being paid
	  */
	public BigDecimal getPayAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PayAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Record ID.
		@param Record_ID 
		Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_Value (COLUMNNAME_Record_ID, null);
		else 
			set_Value (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Record ID.
		@return Direct internal record ID
	  */
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Type.
		@param Type 
		Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type)
	{
		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
	}

	/** Set Valid to.
		@param ValidTo 
		Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
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