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
package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for C_PreInvoiceG
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_PreInvoiceG 
{

    /** TableName=C_PreInvoiceG */
    public static final String Table_Name = "C_PreInvoiceG";

    /** AD_Table_ID=1000296 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException;

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Contract_ID */
    public static final String COLUMNNAME_C_Contract_ID = "C_Contract_ID";

	/** Set C_Contract	  */
	public void setC_Contract_ID (int C_Contract_ID);

	/** Get C_Contract	  */
	public int getC_Contract_ID();

	public org.pentanet.model.I_C_Contract getC_Contract() throws RuntimeException;

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException;

    /** Column name C_Division_ID */
    public static final String COLUMNNAME_C_Division_ID = "C_Division_ID";

	/** Set C_Division	  */
	public void setC_Division_ID (int C_Division_ID);

	/** Get C_Division	  */
	public int getC_Division_ID();


    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException;

    /** Column name C_Municipality_ID */
    public static final String COLUMNNAME_C_Municipality_ID = "C_Municipality_ID";

	/** Set C_Municipality	  */
	public void setC_Municipality_ID (int C_Municipality_ID);

	/** Get C_Municipality	  */
	public int getC_Municipality_ID();

	public org.pentanet.model.I_C_Municipality getC_Municipality() throws RuntimeException;

    /** Column name C_PreInvoiceG_ID */
    public static final String COLUMNNAME_C_PreInvoiceG_ID = "C_PreInvoiceG_ID";

	/** Set PreInvoice Global	  */
	public void setC_PreInvoiceG_ID (int C_PreInvoiceG_ID);

	/** Get PreInvoice Global	  */
	public int getC_PreInvoiceG_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name C_ServiceLine_ID */
    public static final String COLUMNNAME_C_ServiceLine_ID = "C_ServiceLine_ID";

	/** Set ServiceLine	  */
	public void setC_ServiceLine_ID (int C_ServiceLine_ID);

	/** Get ServiceLine	  */
	public int getC_ServiceLine_ID();


    /** Column name C_Standing_ID */
    public static final String COLUMNNAME_C_Standing_ID = "C_Standing_ID";

	/** Set Standing	  */
	public void setC_Standing_ID (int C_Standing_ID);

	/** Get Standing	  */
	public int getC_Standing_ID();


    /** Column name CurrencyRate */
    public static final String COLUMNNAME_CurrencyRate = "CurrencyRate";

	/** Set Rate.
	  * Currency Conversion Rate
	  */
	public void setCurrencyRate (BigDecimal CurrencyRate);

	/** Get Rate.
	  * Currency Conversion Rate
	  */
	public BigDecimal getCurrencyRate();

    /** Column name C_Well_ID */
    public static final String COLUMNNAME_C_Well_ID = "C_Well_ID";

	/** Set C_Well	  */
	public void setC_Well_ID (int C_Well_ID);

	/** Get C_Well	  */
	public int getC_Well_ID();


    /** Column name C_WorkDDG_ID */
    public static final String COLUMNNAME_C_WorkDDG_ID = "C_WorkDDG_ID";

	/** Set Day to Day Work	  */
	public void setC_WorkDDG_ID (int C_WorkDDG_ID);

	/** Get Day to Day Work	  */
	public int getC_WorkDDG_ID();

	public org.pentanet.model.I_C_WorkDDG getC_WorkDDG() throws RuntimeException;

    /** Column name DateAcct */
    public static final String COLUMNNAME_DateAcct = "DateAcct";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Timestamp getDateAcct();

    /** Column name DateDoc */
    public static final String COLUMNNAME_DateDoc = "DateDoc";

	/** Set Document Date.
	  * Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc);

	/** Get Document Date.
	  * Date of the Document
	  */
	public Timestamp getDateDoc();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name EndDate */
    public static final String COLUMNNAME_EndDate = "EndDate";

	/** Set End Date.
	  * Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate);

	/** Get End Date.
	  * Last effective date (inclusive)
	  */
	public Timestamp getEndDate();

    /** Column name GenerateAdjustment */
    public static final String COLUMNNAME_GenerateAdjustment = "GenerateAdjustment";

	/** Set GenerateAdjustment	  */
	public void setGenerateAdjustment (String GenerateAdjustment);

	/** Get GenerateAdjustment	  */
	public String getGenerateAdjustment();

    /** Column name GenerateHes */
    public static final String COLUMNNAME_GenerateHes = "GenerateHes";

	/** Set GenerateHes	  */
	public void setGenerateHes (String GenerateHes);

	/** Get GenerateHes	  */
	public String getGenerateHes();

    /** Column name GrandTotal */
    public static final String COLUMNNAME_GrandTotal = "GrandTotal";

	/** Set Grand Total.
	  * Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal);

	/** Get Grand Total.
	  * Total amount of document
	  */
	public BigDecimal getGrandTotal();

    /** Column name GrandTotal_Pure */
    public static final String COLUMNNAME_GrandTotal_Pure = "GrandTotal_Pure";

	/** Set GrandTotal_Pure	  */
	public void setGrandTotal_Pure (BigDecimal GrandTotal_Pure);

	/** Get GrandTotal_Pure	  */
	public BigDecimal getGrandTotal_Pure();

    /** Column name GrandTotal_Usd */
    public static final String COLUMNNAME_GrandTotal_Usd = "GrandTotal_Usd";

	/** Set GrandTotal_Usd	  */
	public void setGrandTotal_Usd (BigDecimal GrandTotal_Usd);

	/** Get GrandTotal_Usd	  */
	public BigDecimal getGrandTotal_Usd();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsApproved */
    public static final String COLUMNNAME_IsApproved = "IsApproved";

	/** Set Approved.
	  * Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved);

	/** Get Approved.
	  * Indicates if this document requires approval
	  */
	public boolean isApproved();

    /** Column name Posted */
    public static final String COLUMNNAME_Posted = "Posted";

	/** Set Posted.
	  * Posting status
	  */
	public void setPosted (boolean Posted);

	/** Get Posted.
	  * Posting status
	  */
	public boolean isPosted();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Recalculate */
    public static final String COLUMNNAME_Recalculate = "Recalculate";

	/** Set Recalculate	  */
	public void setRecalculate (String Recalculate);

	/** Get Recalculate	  */
	public String getRecalculate();

    /** Column name StartDate */
    public static final String COLUMNNAME_StartDate = "StartDate";

	/** Set Start Date.
	  * First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate);

	/** Get Start Date.
	  * First effective day (inclusive)
	  */
	public Timestamp getStartDate();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
