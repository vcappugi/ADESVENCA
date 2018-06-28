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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for H_Admission
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Admission extends PO implements I_H_Admission, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120327L;

    /** Standard Constructor */
    public X_H_Admission (Properties ctx, int H_Admission_ID, String trxName)
    {
      super (ctx, H_Admission_ID, trxName);
      /** if (H_Admission_ID == 0)
        {
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setH_Admission_ID (0);
			setH_Patient_ID (0);
			setM_PriceList_Version_ID (0);
			setName (null);
			setProcessed (false);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Admission (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Admission[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AdmissionDate.
		@param AdmissionDate AdmissionDate	  */
	public void setAdmissionDate (Timestamp AdmissionDate)
	{
		set_Value (COLUMNNAME_AdmissionDate, AdmissionDate);
	}

	/** Get AdmissionDate.
		@return AdmissionDate	  */
	public Timestamp getAdmissionDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_AdmissionDate);
	}

	/** Set Alta.
		@param Alta Alta	  */
	public void setAlta (String Alta)
	{
		set_Value (COLUMNNAME_Alta, Alta);
	}

	/** Get Alta.
		@return Alta	  */
	public String getAlta () 
	{
		return (String)get_Value(COLUMNNAME_Alta);
	}

	/** Arrival AD_Reference_ID=1000013 */
	public static final int ARRIVAL_AD_Reference_ID=1000013;
	/** Propios Medios = M */
	public static final String ARRIVAL_PropiosMedios = "M";
	/** Conocido = C */
	public static final String ARRIVAL_Conocido = "C";
	/** Ambulancia = A */
	public static final String ARRIVAL_Ambulancia = "A";
	/** Policia = P */
	public static final String ARRIVAL_Policia = "P";
	/** Desconocido = D */
	public static final String ARRIVAL_Desconocido = "D";
	/** Otro = O */
	public static final String ARRIVAL_Otro = "O";
	/** Set Arrival.
		@param Arrival Arrival	  */
	public void setArrival (String Arrival)
	{

		set_Value (COLUMNNAME_Arrival, Arrival);
	}

	/** Get Arrival.
		@return Arrival	  */
	public String getArrival () 
	{
		return (String)get_Value(COLUMNNAME_Arrival);
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

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException
    {
		return (org.compiere.model.I_C_Campaign)MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_Name)
			.getPO(getC_Campaign_ID(), get_TrxName());	}

	/** Set Campaign.
		@param C_Campaign_ID 
		Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID)
	{
		if (C_Campaign_ID < 1) 
			set_Value (COLUMNNAME_C_Campaign_ID, null);
		else 
			set_Value (COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
	}

	/** Get Campaign.
		@return Marketing Campaign
	  */
	public int getC_Campaign_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Campaign_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegionD() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegionD_ID(), get_TrxName());	}

	/** Set C_SalesRegionD_ID.
		@param C_SalesRegionD_ID C_SalesRegionD_ID	  */
	public void setC_SalesRegionD_ID (int C_SalesRegionD_ID)
	{
		if (C_SalesRegionD_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, Integer.valueOf(C_SalesRegionD_ID));
	}

	/** Get C_SalesRegionD_ID.
		@return C_SalesRegionD_ID	  */
	public int getC_SalesRegionD_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegionD_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegion_ID(), get_TrxName());	}

	/** Set Sales Region.
		@param C_SalesRegion_ID 
		Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set GenerateBudget.
		@param GenerateBudget GenerateBudget	  */
	public void setGenerateBudget (String GenerateBudget)
	{
		set_Value (COLUMNNAME_GenerateBudget, GenerateBudget);
	}

	/** Get GenerateBudget.
		@return GenerateBudget	  */
	public String getGenerateBudget () 
	{
		return (String)get_Value(COLUMNNAME_GenerateBudget);
	}

	/** Set H_Admission.
		@param H_Admission_ID H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID)
	{
		if (H_Admission_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Admission_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Admission_ID, Integer.valueOf(H_Admission_ID));
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

	/** Set H_Asigned_Budget.
		@param H_Asigned_Budget_ID H_Asigned_Budget	  */
	public void setH_Asigned_Budget_ID (int H_Asigned_Budget_ID)
	{
		throw new IllegalArgumentException ("H_Asigned_Budget_ID is virtual column");	}

	/** Get H_Asigned_Budget.
		@return H_Asigned_Budget	  */
	public int getH_Asigned_Budget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Asigned_Budget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Bed getH_Bed() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Bed)MTable.get(getCtx(), org.pentanet.model.I_H_Bed.Table_Name)
			.getPO(getH_Bed_ID(), get_TrxName());	}

	/** Set H_Bed_ID.
		@param H_Bed_ID H_Bed_ID	  */
	public void setH_Bed_ID (int H_Bed_ID)
	{
		if (H_Bed_ID < 1) 
			set_Value (COLUMNNAME_H_Bed_ID, null);
		else 
			set_Value (COLUMNNAME_H_Bed_ID, Integer.valueOf(H_Bed_ID));
	}

	/** Get H_Bed_ID.
		@return H_Bed_ID	  */
	public int getH_Bed_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Bed_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_H_Diagnostic getH_Diagnostic() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Diagnostic)MTable.get(getCtx(), org.pentanet.model.I_H_Diagnostic.Table_Name)
			.getPO(getH_Diagnostic_ID(), get_TrxName());	}

	/** Set H_Diagnostic.
		@param H_Diagnostic_ID H_Diagnostic	  */
	public void setH_Diagnostic_ID (int H_Diagnostic_ID)
	{
		if (H_Diagnostic_ID < 1) 
			set_Value (COLUMNNAME_H_Diagnostic_ID, null);
		else 
			set_Value (COLUMNNAME_H_Diagnostic_ID, Integer.valueOf(H_Diagnostic_ID));
	}

	/** Get H_Diagnostic.
		@return H_Diagnostic	  */
	public int getH_Diagnostic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Diagnostic_ID);
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

	public org.compiere.model.I_M_PriceList_Version getM_PriceList_Version() throws RuntimeException
    {
		return (org.compiere.model.I_M_PriceList_Version)MTable.get(getCtx(), org.compiere.model.I_M_PriceList_Version.Table_Name)
			.getPO(getM_PriceList_Version_ID(), get_TrxName());	}

	/** Set Price List Version.
		@param M_PriceList_Version_ID 
		Identifies a unique instance of a Price List
	  */
	public void setM_PriceList_Version_ID (int M_PriceList_Version_ID)
	{
		if (M_PriceList_Version_ID < 1) 
			set_Value (COLUMNNAME_M_PriceList_Version_ID, null);
		else 
			set_Value (COLUMNNAME_M_PriceList_Version_ID, Integer.valueOf(M_PriceList_Version_ID));
	}

	/** Get Price List Version.
		@return Identifies a unique instance of a Price List
	  */
	public int getM_PriceList_Version_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_Version_ID);
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

	public org.pentanet.model.I_H_Bed getOperatingR() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Bed)MTable.get(getCtx(), org.pentanet.model.I_H_Bed.Table_Name)
			.getPO(getOperatingRoom(), get_TrxName());	}

	/** Set OperatingRoom.
		@param OperatingRoom 
		Quirofano
	  */
	public void setOperatingRoom (int OperatingRoom)
	{
		set_Value (COLUMNNAME_OperatingRoom, Integer.valueOf(OperatingRoom));
	}

	/** Get OperatingRoom.
		@return Quirofano
	  */
	public int getOperatingRoom () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OperatingRoom);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ORUsageDate.
		@param ORUsageDate 
		Fecha estimada para el uso del quirofano
	  */
	public void setORUsageDate (Timestamp ORUsageDate)
	{
		set_Value (COLUMNNAME_ORUsageDate, ORUsageDate);
	}

	/** Get ORUsageDate.
		@return Fecha estimada para el uso del quirofano
	  */
	public Timestamp getORUsageDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ORUsageDate);
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

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
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