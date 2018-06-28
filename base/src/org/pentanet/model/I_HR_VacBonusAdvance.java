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

/** Generated Interface for HR_VacBonusAdvance
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_VacBonusAdvance 
{

    /** TableName=HR_VacBonusAdvance */
    public static final String Table_Name = "HR_VacBonusAdvance";

    /** AD_Table_ID=1000203 */
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

    /** Column name AmtSCAvailable */
    public static final String COLUMNNAME_AmtSCAvailable = "AmtSCAvailable";

	/** Set AmtSCAvailable	  */
	public void setAmtSCAvailable (BigDecimal AmtSCAvailable);

	/** Get AmtSCAvailable	  */
	public BigDecimal getAmtSCAvailable();

    /** Column name AmtSCEstimated */
    public static final String COLUMNNAME_AmtSCEstimated = "AmtSCEstimated";

	/** Set AmtSCEstimated	  */
	public void setAmtSCEstimated (BigDecimal AmtSCEstimated);

	/** Get AmtSCEstimated	  */
	public BigDecimal getAmtSCEstimated();

    /** Column name AmtSCRequired */
    public static final String COLUMNNAME_AmtSCRequired = "AmtSCRequired";

	/** Set AmtSCRequired	  */
	public void setAmtSCRequired (BigDecimal AmtSCRequired);

	/** Get AmtSCRequired	  */
	public BigDecimal getAmtSCRequired();

    /** Column name AmtUtiAvailable */
    public static final String COLUMNNAME_AmtUtiAvailable = "AmtUtiAvailable";

	/** Set AmtUtiAvailable	  */
	public void setAmtUtiAvailable (BigDecimal AmtUtiAvailable);

	/** Get AmtUtiAvailable	  */
	public BigDecimal getAmtUtiAvailable();

    /** Column name AmtUtiCommitted */
    public static final String COLUMNNAME_AmtUtiCommitted = "AmtUtiCommitted";

	/** Set AmtUtiCommitted	  */
	public void setAmtUtiCommitted (BigDecimal AmtUtiCommitted);

	/** Get AmtUtiCommitted	  */
	public BigDecimal getAmtUtiCommitted();

    /** Column name AmtUtiEstimated */
    public static final String COLUMNNAME_AmtUtiEstimated = "AmtUtiEstimated";

	/** Set AmtUtiEstimated	  */
	public void setAmtUtiEstimated (BigDecimal AmtUtiEstimated);

	/** Get AmtUtiEstimated	  */
	public BigDecimal getAmtUtiEstimated();

    /** Column name AmtUtiGenEstimated */
    public static final String COLUMNNAME_AmtUtiGenEstimated = "AmtUtiGenEstimated";

	/** Set AmtUtiGenEstimated	  */
	public void setAmtUtiGenEstimated (BigDecimal AmtUtiGenEstimated);

	/** Get AmtUtiGenEstimated	  */
	public BigDecimal getAmtUtiGenEstimated();

    /** Column name AmtUtiGenRequired */
    public static final String COLUMNNAME_AmtUtiGenRequired = "AmtUtiGenRequired";

	/** Set AmtUtiGenRequired	  */
	public void setAmtUtiGenRequired (BigDecimal AmtUtiGenRequired);

	/** Get AmtUtiGenRequired	  */
	public BigDecimal getAmtUtiGenRequired();

    /** Column name AmtUtiRequired */
    public static final String COLUMNNAME_AmtUtiRequired = "AmtUtiRequired";

	/** Set AmtUtiRequired	  */
	public void setAmtUtiRequired (BigDecimal AmtUtiRequired);

	/** Get AmtUtiRequired	  */
	public BigDecimal getAmtUtiRequired();

    /** Column name AmtVacAvailable */
    public static final String COLUMNNAME_AmtVacAvailable = "AmtVacAvailable";

	/** Set AmtVacAvailable	  */
	public void setAmtVacAvailable (BigDecimal AmtVacAvailable);

	/** Get AmtVacAvailable	  */
	public BigDecimal getAmtVacAvailable();

    /** Column name AmtVacCommitted */
    public static final String COLUMNNAME_AmtVacCommitted = "AmtVacCommitted";

	/** Set AmtVacCommitted	  */
	public void setAmtVacCommitted (BigDecimal AmtVacCommitted);

	/** Get AmtVacCommitted	  */
	public BigDecimal getAmtVacCommitted();

    /** Column name AmtVacEstimated */
    public static final String COLUMNNAME_AmtVacEstimated = "AmtVacEstimated";

	/** Set AmtVacEstimated	  */
	public void setAmtVacEstimated (BigDecimal AmtVacEstimated);

	/** Get AmtVacEstimated	  */
	public BigDecimal getAmtVacEstimated();

    /** Column name AmtVacRequired */
    public static final String COLUMNNAME_AmtVacRequired = "AmtVacRequired";

	/** Set AmtVacRequired	  */
	public void setAmtVacRequired (BigDecimal AmtVacRequired);

	/** Get AmtVacRequired	  */
	public BigDecimal getAmtVacRequired();

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

    /** Column name Cedula */
    public static final String COLUMNNAME_Cedula = "Cedula";

	/** Set Cedula	  */
	public void setCedula (String Cedula);

	/** Get Cedula	  */
	public String getCedula();

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

    /** Column name DateRequired */
    public static final String COLUMNNAME_DateRequired = "DateRequired";

	/** Set Date Required.
	  * Date when required
	  */
	public void setDateRequired (Timestamp DateRequired);

	/** Get Date Required.
	  * Date when required
	  */
	public Timestamp getDateRequired();

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

    /** Column name HR_Department_ID */
    public static final String COLUMNNAME_HR_Department_ID = "HR_Department_ID";

	/** Set Payroll Department	  */
	public void setHR_Department_ID (int HR_Department_ID);

	/** Get Payroll Department	  */
	public int getHR_Department_ID();

	public org.eevolution.model.I_HR_Department getHR_Department() throws RuntimeException;

    /** Column name HR_VacBonusAdvance_ID */
    public static final String COLUMNNAME_HR_VacBonusAdvance_ID = "HR_VacBonusAdvance_ID";

	/** Set HR_VacBonusAdvance	  */
	public void setHR_VacBonusAdvance_ID (int HR_VacBonusAdvance_ID);

	/** Get HR_VacBonusAdvance	  */
	public int getHR_VacBonusAdvance_ID();

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

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

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

    /** Column name QtyShareSC */
    public static final String COLUMNNAME_QtyShareSC = "QtyShareSC";

	/** Set QtyShareSC	  */
	public void setQtyShareSC (BigDecimal QtyShareSC);

	/** Get QtyShareSC	  */
	public BigDecimal getQtyShareSC();

    /** Column name Total */
    public static final String COLUMNNAME_Total = "Total";

	/** Set Total	  */
	public void setTotal (BigDecimal Total);

	/** Get Total	  */
	public BigDecimal getTotal();

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
