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

/** Generated Interface for HR_WorkedTime
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_WorkedTime 
{

    /** TableName=HR_WorkedTime */
    public static final String Table_Name = "HR_WorkedTime";

    /** AD_Table_ID=1000137 */
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

    /** Column name Approve1_ID */
    public static final String COLUMNNAME_Approve1_ID = "Approve1_ID";

	/** Set Approve1_ID	  */
	public void setApprove1_ID (int Approve1_ID);

	/** Get Approve1_ID	  */
	public int getApprove1_ID();

	public org.compiere.model.I_AD_User getApprove1() throws RuntimeException;

    /** Column name Approve2_ID */
    public static final String COLUMNNAME_Approve2_ID = "Approve2_ID";

	/** Set Approve2_ID	  */
	public void setApprove2_ID (int Approve2_ID);

	/** Get Approve2_ID	  */
	public int getApprove2_ID();

	public org.compiere.model.I_AD_User getApprove2() throws RuntimeException;

    /** Column name ApprovedBy_ID */
    public static final String COLUMNNAME_ApprovedBy_ID = "ApprovedBy_ID";

	/** Set ApprovedBy_ID	  */
	public void setApprovedBy_ID (int ApprovedBy_ID);

	/** Get ApprovedBy_ID	  */
	public int getApprovedBy_ID();

	public org.compiere.model.I_AD_User getApprovedBy() throws RuntimeException;

    /** Column name BtnApprove */
    public static final String COLUMNNAME_BtnApprove = "BtnApprove";

	/** Set BtnApprove	  */
	public void setBtnApprove (String BtnApprove);

	/** Get BtnApprove	  */
	public String getBtnApprove();

    /** Column name BtnElaborate */
    public static final String COLUMNNAME_BtnElaborate = "BtnElaborate";

	/** Set BtnElaborate	  */
	public void setBtnElaborate (String BtnElaborate);

	/** Get BtnElaborate	  */
	public String getBtnElaborate();

    /** Column name BtnProcess */
    public static final String COLUMNNAME_BtnProcess = "BtnProcess";

	/** Set BtnProcess	  */
	public void setBtnProcess (String BtnProcess);

	/** Get BtnProcess	  */
	public String getBtnProcess();

    /** Column name BtnRevise */
    public static final String COLUMNNAME_BtnRevise = "BtnRevise";

	/** Set BtnRevise	  */
	public void setBtnRevise (String BtnRevise);

	/** Get BtnRevise	  */
	public String getBtnRevise();

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

    /** Column name Elaborate1_ID */
    public static final String COLUMNNAME_Elaborate1_ID = "Elaborate1_ID";

	/** Set Elaborate1_ID	  */
	public void setElaborate1_ID (int Elaborate1_ID);

	/** Get Elaborate1_ID	  */
	public int getElaborate1_ID();

	public org.compiere.model.I_AD_User getElaborate1() throws RuntimeException;

    /** Column name Elaborate2_ID */
    public static final String COLUMNNAME_Elaborate2_ID = "Elaborate2_ID";

	/** Set Elaborate2_ID	  */
	public void setElaborate2_ID (int Elaborate2_ID);

	/** Get Elaborate2_ID	  */
	public int getElaborate2_ID();

	public org.compiere.model.I_AD_User getElaborate2() throws RuntimeException;

    /** Column name ElaboratedBy */
    public static final String COLUMNNAME_ElaboratedBy = "ElaboratedBy";

	/** Set ElaboratedBy	  */
	public void setElaboratedBy (int ElaboratedBy);

	/** Get ElaboratedBy	  */
	public int getElaboratedBy();

	public org.compiere.model.I_AD_User getElaborate() throws RuntimeException;

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

    /** Column name HR_Payroll_ID */
    public static final String COLUMNNAME_HR_Payroll_ID = "HR_Payroll_ID";

	/** Set Payroll	  */
	public void setHR_Payroll_ID (int HR_Payroll_ID);

	/** Get Payroll	  */
	public int getHR_Payroll_ID();

	public org.eevolution.model.I_HR_Payroll getHR_Payroll() throws RuntimeException;

    /** Column name HR_Period_ID */
    public static final String COLUMNNAME_HR_Period_ID = "HR_Period_ID";

	/** Set Payroll Period	  */
	public void setHR_Period_ID (int HR_Period_ID);

	/** Get Payroll Period	  */
	public int getHR_Period_ID();

	public org.eevolution.model.I_HR_Period getHR_Period() throws RuntimeException;

    /** Column name HR_Standing_ID */
    public static final String COLUMNNAME_HR_Standing_ID = "HR_Standing_ID";

	/** Set HR_Standing	  */
	public void setHR_Standing_ID (int HR_Standing_ID);

	/** Get HR_Standing	  */
	public int getHR_Standing_ID();

	public org.pentanet.model.I_HR_Standing getHR_Standing() throws RuntimeException;

    /** Column name HR_WorkedTime_ID */
    public static final String COLUMNNAME_HR_WorkedTime_ID = "HR_WorkedTime_ID";

	/** Set HR_WorkedTime	  */
	public void setHR_WorkedTime_ID (int HR_WorkedTime_ID);

	/** Get HR_WorkedTime	  */
	public int getHR_WorkedTime_ID();

    /** Column name HR_WorkGroup_ID */
    public static final String COLUMNNAME_HR_WorkGroup_ID = "HR_WorkGroup_ID";

	/** Set HR_WorkGroup	  */
	public void setHR_WorkGroup_ID (int HR_WorkGroup_ID);

	/** Get HR_WorkGroup	  */
	public int getHR_WorkGroup_ID();

	public org.pentanet.model.I_HR_WorkGroup getHR_WorkGroup() throws RuntimeException;

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

    /** Column name IsElaborated */
    public static final String COLUMNNAME_IsElaborated = "IsElaborated";

	/** Set IsElaborated	  */
	public void setIsElaborated (boolean IsElaborated);

	/** Get IsElaborated	  */
	public boolean isElaborated();

    /** Column name ISPROCESSED */
    public static final String COLUMNNAME_ISPROCESSED = "ISPROCESSED";

	/** Set ISPROCESSED	  */
	public void setISPROCESSED (boolean ISPROCESSED);

	/** Get ISPROCESSED	  */
	public boolean isPROCESSED();

    /** Column name IsRevised */
    public static final String COLUMNNAME_IsRevised = "IsRevised";

	/** Set IsRevised	  */
	public void setIsRevised (boolean IsRevised);

	/** Get IsRevised	  */
	public boolean isRevised();

    /** Column name IsWeek */
    public static final String COLUMNNAME_IsWeek = "IsWeek";

	/** Set IsWeek	  */
	public void setIsWeek (boolean IsWeek);

	/** Get IsWeek	  */
	public boolean isWeek();

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

    /** Column name NetDays */
    public static final String COLUMNNAME_NetDays = "NetDays";

	/** Set Net Days.
	  * Net Days in which payment is due
	  */
	public void setNetDays (BigDecimal NetDays);

	/** Get Net Days.
	  * Net Days in which payment is due
	  */
	public BigDecimal getNetDays();

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

    /** Column name Revise1_ID */
    public static final String COLUMNNAME_Revise1_ID = "Revise1_ID";

	/** Set Revise1_ID	  */
	public void setRevise1_ID (int Revise1_ID);

	/** Get Revise1_ID	  */
	public int getRevise1_ID();

	public org.compiere.model.I_AD_User getRevise1() throws RuntimeException;

    /** Column name Revise2_ID */
    public static final String COLUMNNAME_Revise2_ID = "Revise2_ID";

	/** Set Revise2_ID	  */
	public void setRevise2_ID (int Revise2_ID);

	/** Get Revise2_ID	  */
	public int getRevise2_ID();

	public org.compiere.model.I_AD_User getRevise2() throws RuntimeException;

    /** Column name RevisedBy_ID */
    public static final String COLUMNNAME_RevisedBy_ID = "RevisedBy_ID";

	/** Set RevisedBy_ID	  */
	public void setRevisedBy_ID (int RevisedBy_ID);

	/** Get RevisedBy_ID	  */
	public int getRevisedBy_ID();

	public org.compiere.model.I_AD_User getRevisedBy() throws RuntimeException;

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

    /** Column name UserLevel1 */
    public static final String COLUMNNAME_UserLevel1 = "UserLevel1";

	/** Set UserLevel1	  */
	public void setUserLevel1 (int UserLevel1);

	/** Get UserLevel1	  */
	public int getUserLevel1();

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
