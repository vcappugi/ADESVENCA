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

/** Generated Interface for C_Payment_SchemaLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_Payment_SchemaLine 
{

    /** TableName=C_Payment_SchemaLine */
    public static final String Table_Name = "C_Payment_SchemaLine";

    /** AD_Table_ID=1000275 */
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

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException;

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

    /** Column name C_Advance_Request_ID */
    public static final String COLUMNNAME_C_Advance_Request_ID = "C_Advance_Request_ID";

	/** Set C_Advance_Request	  */
	public void setC_Advance_Request_ID (int C_Advance_Request_ID);

	/** Get C_Advance_Request	  */
	public int getC_Advance_Request_ID();

	public org.pentanet.model.I_C_Advance_Request getC_Advance_Request() throws RuntimeException;

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

    /** Column name C_Group_Line_ID */
    public static final String COLUMNNAME_C_Group_Line_ID = "C_Group_Line_ID";

	/** Set C_Group_Line	  */
	public void setC_Group_Line_ID (int C_Group_Line_ID);

	/** Get C_Group_Line	  */
	public int getC_Group_Line_ID();

	public org.pentanet.model.I_C_Group_Line getC_Group_Line() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException;

    /** Column name C_Order_ID */
    public static final String COLUMNNAME_C_Order_ID = "C_Order_ID";

	/** Set Order.
	  * Order
	  */
	public void setC_Order_ID (int C_Order_ID);

	/** Get Order.
	  * Order
	  */
	public int getC_Order_ID();

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException;

    /** Column name C_Payment_ID */
    public static final String COLUMNNAME_C_Payment_ID = "C_Payment_ID";

	/** Set Payment.
	  * Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID);

	/** Get Payment.
	  * Payment identifier
	  */
	public int getC_Payment_ID();

	public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException;

    /** Column name C_Payment_SchemaGroup_ID */
    public static final String COLUMNNAME_C_Payment_SchemaGroup_ID = "C_Payment_SchemaGroup_ID";

	/** Set Payment Schema Group	  */
	public void setC_Payment_SchemaGroup_ID (int C_Payment_SchemaGroup_ID);

	/** Get Payment Schema Group	  */
	public int getC_Payment_SchemaGroup_ID();

	public org.pentanet.model.I_C_Payment_SchemaGroup getC_Payment_SchemaGroup() throws RuntimeException;

    /** Column name C_Payment_Schema_ID */
    public static final String COLUMNNAME_C_Payment_Schema_ID = "C_Payment_Schema_ID";

	/** Set C_Payment_Schema	  */
	public void setC_Payment_Schema_ID (int C_Payment_Schema_ID);

	/** Get C_Payment_Schema	  */
	public int getC_Payment_Schema_ID();

    /** Column name C_Payment_SchemaLine_ID */
    public static final String COLUMNNAME_C_Payment_SchemaLine_ID = "C_Payment_SchemaLine_ID";

	/** Set C_Payment_SchemaLine	  */
	public void setC_Payment_SchemaLine_ID (int C_Payment_SchemaLine_ID);

	/** Get C_Payment_SchemaLine	  */
	public int getC_Payment_SchemaLine_ID();

    /** Column name C_Purchase_Plain_Line_ID */
    public static final String COLUMNNAME_C_Purchase_Plain_Line_ID = "C_Purchase_Plain_Line_ID";

	/** Set C_Purchase_Plain_Line	  */
	public void setC_Purchase_Plain_Line_ID (int C_Purchase_Plain_Line_ID);

	/** Get C_Purchase_Plain_Line	  */
	public int getC_Purchase_Plain_Line_ID();

	public org.pentanet.model.I_C_Purchase_Plain_Line getC_Purchase_Plain_Line() throws RuntimeException;

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

    /** Column name Document */
    public static final String COLUMNNAME_Document = "Document";

	/** Set Document	  */
	public void setDocument (String Document);

	/** Get Document	  */
	public String getDocument();

    /** Column name DueClasif */
    public static final String COLUMNNAME_DueClasif = "DueClasif";

	/** Set DueClasif	  */
	public void setDueClasif (String DueClasif);

	/** Get DueClasif	  */
	public String getDueClasif();

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

    /** Column name IsDue */
    public static final String COLUMNNAME_IsDue = "IsDue";

	/** Set Due.
	  * Subscription Renewal is Due
	  */
	public void setIsDue (boolean IsDue);

	/** Get Due.
	  * Subscription Renewal is Due
	  */
	public boolean isDue();

    /** Column name IsGenerated */
    public static final String COLUMNNAME_IsGenerated = "IsGenerated";

	/** Set Generated.
	  * This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated);

	/** Get Generated.
	  * This Line is generated
	  */
	public boolean isGenerated();

    /** Column name IsTotalPaid */
    public static final String COLUMNNAME_IsTotalPaid = "IsTotalPaid";

	/** Set IsTotalPaid	  */
	public void setIsTotalPaid (boolean IsTotalPaid);

	/** Get IsTotalPaid	  */
	public boolean isTotalPaid();

    /** Column name PayAmt */
    public static final String COLUMNNAME_PayAmt = "PayAmt";

	/** Set Payment amount.
	  * Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt);

	/** Get Payment amount.
	  * Amount being paid
	  */
	public BigDecimal getPayAmt();

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

    /** Column name Record_ID */
    public static final String COLUMNNAME_Record_ID = "Record_ID";

	/** Set Record ID.
	  * Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID);

	/** Get Record ID.
	  * Direct internal record ID
	  */
	public int getRecord_ID();

    /** Column name Type */
    public static final String COLUMNNAME_Type = "Type";

	/** Set Type.
	  * Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type);

	/** Get Type.
	  * Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType();

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

    /** Column name ValidTo */
    public static final String COLUMNNAME_ValidTo = "ValidTo";

	/** Set Valid to.
	  * Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo);

	/** Get Valid to.
	  * Valid to including this date (last day)
	  */
	public Timestamp getValidTo();

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
