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

/** Generated Interface for H_Admission
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_Admission 
{

    /** TableName=H_Admission */
    public static final String Table_Name = "H_Admission";

    /** AD_Table_ID=1000013 */
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

    /** Column name AdmissionDate */
    public static final String COLUMNNAME_AdmissionDate = "AdmissionDate";

	/** Set AdmissionDate	  */
	public void setAdmissionDate (Timestamp AdmissionDate);

	/** Get AdmissionDate	  */
	public Timestamp getAdmissionDate();

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

    /** Column name Alta */
    public static final String COLUMNNAME_Alta = "Alta";

	/** Set Alta	  */
	public void setAlta (String Alta);

	/** Get Alta	  */
	public String getAlta();

    /** Column name Arrival */
    public static final String COLUMNNAME_Arrival = "Arrival";

	/** Set Arrival	  */
	public void setArrival (String Arrival);

	/** Get Arrival	  */
	public String getArrival();

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

    /** Column name C_Campaign_ID */
    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";

	/** Set Campaign.
	  * Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID);

	/** Get Campaign.
	  * Marketing Campaign
	  */
	public int getC_Campaign_ID();

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException;

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

    /** Column name C_SalesRegionD_ID */
    public static final String COLUMNNAME_C_SalesRegionD_ID = "C_SalesRegionD_ID";

	/** Set C_SalesRegionD_ID	  */
	public void setC_SalesRegionD_ID (int C_SalesRegionD_ID);

	/** Get C_SalesRegionD_ID	  */
	public int getC_SalesRegionD_ID();

	public org.compiere.model.I_C_SalesRegion getC_SalesRegionD() throws RuntimeException;

    /** Column name C_SalesRegion_ID */
    public static final String COLUMNNAME_C_SalesRegion_ID = "C_SalesRegion_ID";

	/** Set Sales Region.
	  * Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID);

	/** Get Sales Region.
	  * Sales coverage region
	  */
	public int getC_SalesRegion_ID();

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException;

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

    /** Column name GenerateBudget */
    public static final String COLUMNNAME_GenerateBudget = "GenerateBudget";

	/** Set GenerateBudget	  */
	public void setGenerateBudget (String GenerateBudget);

	/** Get GenerateBudget	  */
	public String getGenerateBudget();

    /** Column name H_Admission_ID */
    public static final String COLUMNNAME_H_Admission_ID = "H_Admission_ID";

	/** Set H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID);

	/** Get H_Admission	  */
	public int getH_Admission_ID();

    /** Column name H_Asigned_Budget_ID */
    public static final String COLUMNNAME_H_Asigned_Budget_ID = "H_Asigned_Budget_ID";

	/** Set H_Asigned_Budget	  */
	public void setH_Asigned_Budget_ID (int H_Asigned_Budget_ID);

	/** Get H_Asigned_Budget	  */
	public int getH_Asigned_Budget_ID();

    /** Column name H_Bed_ID */
    public static final String COLUMNNAME_H_Bed_ID = "H_Bed_ID";

	/** Set H_Bed_ID	  */
	public void setH_Bed_ID (int H_Bed_ID);

	/** Get H_Bed_ID	  */
	public int getH_Bed_ID();

	public org.pentanet.model.I_H_Bed getH_Bed() throws RuntimeException;

    /** Column name H_Diagnostic_ID */
    public static final String COLUMNNAME_H_Diagnostic_ID = "H_Diagnostic_ID";

	/** Set H_Diagnostic	  */
	public void setH_Diagnostic_ID (int H_Diagnostic_ID);

	/** Get H_Diagnostic	  */
	public int getH_Diagnostic_ID();

	public org.pentanet.model.I_H_Diagnostic getH_Diagnostic() throws RuntimeException;

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

    /** Column name H_Patient_ID */
    public static final String COLUMNNAME_H_Patient_ID = "H_Patient_ID";

	/** Set H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID);

	/** Get H_Patient	  */
	public int getH_Patient_ID();

	public org.pentanet.model.I_H_Patient getH_Patient() throws RuntimeException;

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

    /** Column name M_PriceList_Version_ID */
    public static final String COLUMNNAME_M_PriceList_Version_ID = "M_PriceList_Version_ID";

	/** Set Price List Version.
	  * Identifies a unique instance of a Price List
	  */
	public void setM_PriceList_Version_ID (int M_PriceList_Version_ID);

	/** Get Price List Version.
	  * Identifies a unique instance of a Price List
	  */
	public int getM_PriceList_Version_ID();

	public org.compiere.model.I_M_PriceList_Version getM_PriceList_Version() throws RuntimeException;

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

    /** Column name OperatingRoom */
    public static final String COLUMNNAME_OperatingRoom = "OperatingRoom";

	/** Set OperatingRoom.
	  * Quirofano
	  */
	public void setOperatingRoom (int OperatingRoom);

	/** Get OperatingRoom.
	  * Quirofano
	  */
	public int getOperatingRoom();

	public org.pentanet.model.I_H_Bed getOperatingR() throws RuntimeException;

    /** Column name ORUsageDate */
    public static final String COLUMNNAME_ORUsageDate = "ORUsageDate";

	/** Set ORUsageDate.
	  * Fecha estimada para el uso del quirofano
	  */
	public void setORUsageDate (Timestamp ORUsageDate);

	/** Get ORUsageDate.
	  * Fecha estimada para el uso del quirofano
	  */
	public Timestamp getORUsageDate();

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

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

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
