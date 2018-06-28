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

/** Generated Interface for HR_Vacation
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_Vacation 
{

    /** TableName=HR_Vacation */
    public static final String Table_Name = "HR_Vacation";

    /** AD_Table_ID=1000187 */
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

    /** Column name AdiDays */
    public static final String COLUMNNAME_AdiDays = "AdiDays";

	/** Set AdiDays	  */
	public void setAdiDays (BigDecimal AdiDays);

	/** Get AdiDays	  */
	public BigDecimal getAdiDays();

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

    /** Column name AntDays */
    public static final String COLUMNNAME_AntDays = "AntDays";

	/** Set AntDays	  */
	public void setAntDays (BigDecimal AntDays);

	/** Get AntDays	  */
	public BigDecimal getAntDays();

    /** Column name BonDays */
    public static final String COLUMNNAME_BonDays = "BonDays";

	/** Set BonDays	  */
	public void setBonDays (BigDecimal BonDays);

	/** Get BonDays	  */
	public BigDecimal getBonDays();

    /** Column name BtnProcess */
    public static final String COLUMNNAME_BtnProcess = "BtnProcess";

	/** Set BtnProcess	  */
	public void setBtnProcess (String BtnProcess);

	/** Get BtnProcess	  */
	public String getBtnProcess();

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

    /** Column name DateEnd */
    public static final String COLUMNNAME_DateEnd = "DateEnd";

	/** Set DateEnd	  */
	public void setDateEnd (Timestamp DateEnd);

	/** Get DateEnd	  */
	public Timestamp getDateEnd();

    /** Column name DateEnd2 */
    public static final String COLUMNNAME_DateEnd2 = "DateEnd2";

	/** Set DateEnd2	  */
	public void setDateEnd2 (Timestamp DateEnd2);

	/** Get DateEnd2	  */
	public Timestamp getDateEnd2();

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

    /** Column name HR_PeriodVac_ID */
    public static final String COLUMNNAME_HR_PeriodVac_ID = "HR_PeriodVac_ID";

	/** Set HR_PeriodVac	  */
	public void setHR_PeriodVac_ID (int HR_PeriodVac_ID);

	/** Get HR_PeriodVac	  */
	public int getHR_PeriodVac_ID();

	public org.pentanet.model.I_HR_PeriodVac getHR_PeriodVac() throws RuntimeException;

    /** Column name HR_Vacation_ID */
    public static final String COLUMNNAME_HR_Vacation_ID = "HR_Vacation_ID";

	/** Set HR_Vacation	  */
	public void setHR_Vacation_ID (int HR_Vacation_ID);

	/** Get HR_Vacation	  */
	public int getHR_Vacation_ID();

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

    /** Column name IsPaid */
    public static final String COLUMNNAME_IsPaid = "IsPaid";

	/** Set Paid.
	  * The document is paid
	  */
	public void setIsPaid (boolean IsPaid);

	/** Get Paid.
	  * The document is paid
	  */
	public boolean isPaid();

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
