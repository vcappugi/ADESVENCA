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

/** Generated Interface for HR_VacationRequisition
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_VacationRequisition 
{

    /** TableName=HR_VacationRequisition */
    public static final String Table_Name = "HR_VacationRequisition";

    /** AD_Table_ID=1000195 */
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

    /** Column name BonDays */
    public static final String COLUMNNAME_BonDays = "BonDays";

	/** Set BonDays	  */
	public void setBonDays (BigDecimal BonDays);

	/** Get BonDays	  */
	public BigDecimal getBonDays();

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

    /** Column name DateEnd2 */
    public static final String COLUMNNAME_DateEnd2 = "DateEnd2";

	/** Set DateEnd2	  */
	public void setDateEnd2 (Timestamp DateEnd2);

	/** Get DateEnd2	  */
	public Timestamp getDateEnd2();

    /** Column name DateEnd3 */
    public static final String COLUMNNAME_DateEnd3 = "DateEnd3";

	/** Set DateEnd3	  */
	public void setDateEnd3 (Timestamp DateEnd3);

	/** Get DateEnd3	  */
	public Timestamp getDateEnd3();

    /** Column name DateEnd4 */
    public static final String COLUMNNAME_DateEnd4 = "DateEnd4";

	/** Set DateEnd4	  */
	public void setDateEnd4 (Timestamp DateEnd4);

	/** Get DateEnd4	  */
	public Timestamp getDateEnd4();

    /** Column name DateEnd5 */
    public static final String COLUMNNAME_DateEnd5 = "DateEnd5";

	/** Set DateEnd5	  */
	public void setDateEnd5 (Timestamp DateEnd5);

	/** Get DateEnd5	  */
	public Timestamp getDateEnd5();

    /** Column name DateStart */
    public static final String COLUMNNAME_DateStart = "DateStart";

	/** Set Date Start.
	  * Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart);

	/** Get Date Start.
	  * Date Start for this Order
	  */
	public Timestamp getDateStart();

    /** Column name DateStart2 */
    public static final String COLUMNNAME_DateStart2 = "DateStart2";

	/** Set DateStart2	  */
	public void setDateStart2 (Timestamp DateStart2);

	/** Get DateStart2	  */
	public Timestamp getDateStart2();

    /** Column name DateStart3 */
    public static final String COLUMNNAME_DateStart3 = "DateStart3";

	/** Set DateStart3	  */
	public void setDateStart3 (Timestamp DateStart3);

	/** Get DateStart3	  */
	public Timestamp getDateStart3();

    /** Column name DateStart4 */
    public static final String COLUMNNAME_DateStart4 = "DateStart4";

	/** Set DateStart4	  */
	public void setDateStart4 (Timestamp DateStart4);

	/** Get DateStart4	  */
	public Timestamp getDateStart4();

    /** Column name DateStart5 */
    public static final String COLUMNNAME_DateStart5 = "DateStart5";

	/** Set DateStart5	  */
	public void setDateStart5 (Timestamp DateStart5);

	/** Get DateStart5	  */
	public Timestamp getDateStart5();

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

    /** Column name HR_Job_ID */
    public static final String COLUMNNAME_HR_Job_ID = "HR_Job_ID";

	/** Set Payroll Job	  */
	public void setHR_Job_ID (int HR_Job_ID);

	/** Get Payroll Job	  */
	public int getHR_Job_ID();

	public org.eevolution.model.I_HR_Job getHR_Job() throws RuntimeException;

    /** Column name HR_PeriodVac1_ID */
    public static final String COLUMNNAME_HR_PeriodVac1_ID = "HR_PeriodVac1_ID";

	/** Set HR_PeriodVac1_ID	  */
	public void setHR_PeriodVac1_ID (int HR_PeriodVac1_ID);

	/** Get HR_PeriodVac1_ID	  */
	public int getHR_PeriodVac1_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac1() throws RuntimeException;

    /** Column name HR_PeriodVac2_ID */
    public static final String COLUMNNAME_HR_PeriodVac2_ID = "HR_PeriodVac2_ID";

	/** Set HR_PeriodVac2_ID	  */
	public void setHR_PeriodVac2_ID (int HR_PeriodVac2_ID);

	/** Get HR_PeriodVac2_ID	  */
	public int getHR_PeriodVac2_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac2() throws RuntimeException;

    /** Column name HR_PeriodVac3_ID */
    public static final String COLUMNNAME_HR_PeriodVac3_ID = "HR_PeriodVac3_ID";

	/** Set HR_PeriodVac3_ID	  */
	public void setHR_PeriodVac3_ID (int HR_PeriodVac3_ID);

	/** Get HR_PeriodVac3_ID	  */
	public int getHR_PeriodVac3_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac3() throws RuntimeException;

    /** Column name HR_PeriodVac4_ID */
    public static final String COLUMNNAME_HR_PeriodVac4_ID = "HR_PeriodVac4_ID";

	/** Set HR_PeriodVac4_ID	  */
	public void setHR_PeriodVac4_ID (int HR_PeriodVac4_ID);

	/** Get HR_PeriodVac4_ID	  */
	public int getHR_PeriodVac4_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac4() throws RuntimeException;

    /** Column name HR_PeriodVac_ID */
    public static final String COLUMNNAME_HR_PeriodVac_ID = "HR_PeriodVac_ID";

	/** Set HR_PeriodVac	  */
	public void setHR_PeriodVac_ID (int HR_PeriodVac_ID);

	/** Get HR_PeriodVac	  */
	public int getHR_PeriodVac_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac() throws RuntimeException;

    /** Column name HR_Vacation_Incidence2_ID */
    public static final String COLUMNNAME_HR_Vacation_Incidence2_ID = "HR_Vacation_Incidence2_ID";

	/** Set HR_Vacation_Incidence2_ID	  */
	public void setHR_Vacation_Incidence2_ID (int HR_Vacation_Incidence2_ID);

	/** Get HR_Vacation_Incidence2_ID	  */
	public int getHR_Vacation_Incidence2_ID();

	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence2() throws RuntimeException;
	
	
	 /** Column name HR_Vacation_Incidence3_ID */
    public static final String COLUMNNAME_HR_Vacation_Incidence3_ID = "HR_Vacation_Incidence3_ID";

	/** Set HR_Vacation_Incidence3_ID	  */
	public void setHR_Vacation_Incidence3_ID (int HR_Vacation_Incidence3_ID);

	/** Get HR_Vacation_Incidence3_ID	  */
	public int getHR_Vacation_Incidence3_ID();

	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence3() throws RuntimeException;
	
	

    /** Column name HR_Vacation_Incidence_ID */
    public static final String COLUMNNAME_HR_Vacation_Incidence_ID = "HR_Vacation_Incidence_ID";

	/** Set HR_Vacation_Incidence	  */
	public void setHR_Vacation_Incidence_ID (int HR_Vacation_Incidence_ID);

	/** Get HR_Vacation_Incidence	  */
	public int getHR_Vacation_Incidence_ID();

	public org.pentanet.model.I_HR_Vacation_Incidence getHR_Vacation_Incidence() throws RuntimeException;

    /** Column name HR_VacationRequisition_ID */
    public static final String COLUMNNAME_HR_VacationRequisition_ID = "HR_VacationRequisition_ID";

	/** Set HR_VacationRequisition	  */
	public void setHR_VacationRequisition_ID (int HR_VacationRequisition_ID);

	/** Get HR_VacationRequisition	  */
	public int getHR_VacationRequisition_ID();

    /** Column name HR_ZonaOperacion_ID */
    public static final String COLUMNNAME_HR_ZonaOperacion_ID = "HR_ZonaOperacion_ID";

	/** Set HR_ZonaOperacion	  */
	public void setHR_ZonaOperacion_ID (int HR_ZonaOperacion_ID);

	/** Get HR_ZonaOperacion	  */
	public int getHR_ZonaOperacion_ID();

	public org.pentanet.model.I_HR_ZonaOperacion getHR_ZonaOperacion() throws RuntimeException;

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

    /** Column name IsHavePenDays */
    public static final String COLUMNNAME_IsHavePenDays = "IsHavePenDays";

	/** Set IsHavePenDays	  */
	public void setIsHavePenDays (boolean IsHavePenDays);

	/** Get IsHavePenDays	  */
	public boolean isHavePenDays();

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

    /** Column name PenDays */
    public static final String COLUMNNAME_PenDays = "PenDays";

	/** Set PenDays	  */
	public void setPenDays (BigDecimal PenDays);

	/** Get PenDays	  */
	public BigDecimal getPenDays();

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

    /** Column name RequisitionType */
    public static final String COLUMNNAME_RequisitionType = "RequisitionType";

	/** Set RequisitionType	  */
	public void setRequisitionType (String RequisitionType);

	/** Get RequisitionType	  */
	public String getRequisitionType();

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

    /** Column name VacDays */
    public static final String COLUMNNAME_VacDays = "VacDays";

	/** Set VacDays	  */
	public void setVacDays (BigDecimal VacDays);

	/** Get VacDays	  */
	public BigDecimal getVacDays();

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
