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

/** Generated Interface for HR_HCMRequestLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_HCMRequestLine 
{

    /** TableName=HR_HCMRequestLine */
    public static final String Table_Name = "HR_HCMRequestLine";

    /** AD_Table_ID=1000213 */
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

    /** Column name Amt */
    public static final String COLUMNNAME_Amt = "Amt";

	/** Set Amount.
	  * Amount
	  */
	public void setAmt (BigDecimal Amt);

	/** Get Amount.
	  * Amount
	  */
	public BigDecimal getAmt();

    /** Column name Amt_Ut */
    public static final String COLUMNNAME_Amt_Ut = "Amt_Ut";

	/** Set Amt_Ut	  */
	public void setAmt_Ut (BigDecimal Amt_Ut);

	/** Get Amt_Ut	  */
	public BigDecimal getAmt_Ut();

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

    /** Column name DateTrx */
    public static final String COLUMNNAME_DateTrx = "DateTrx";

	/** Set Transaction Date.
	  * Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx);

	/** Get Transaction Date.
	  * Transaction Date
	  */
	public Timestamp getDateTrx();

    /** Column name HR_Family1_ID */
    public static final String COLUMNNAME_HR_Family1_ID = "HR_Family1_ID";

	/** Set HR_Family1_ID	  */
	public void setHR_Family1_ID (int HR_Family1_ID);

	/** Get HR_Family1_ID	  */
	public int getHR_Family1_ID();

	public org.pentanet.model.I_HR_Family getHR_Family1() throws RuntimeException;

    /** Column name HR_Family2_ID */
    public static final String COLUMNNAME_HR_Family2_ID = "HR_Family2_ID";

	/** Set HR_Family2_ID	  */
	public void setHR_Family2_ID (int HR_Family2_ID);

	/** Get HR_Family2_ID	  */
	public int getHR_Family2_ID();

	public org.pentanet.model.I_HR_Family getHR_Family2() throws RuntimeException;

    /** Column name HR_Family3_ID */
    public static final String COLUMNNAME_HR_Family3_ID = "HR_Family3_ID";

	/** Set HR_Family3_ID	  */
	public void setHR_Family3_ID (int HR_Family3_ID);

	/** Get HR_Family3_ID	  */
	public int getHR_Family3_ID();

	public org.pentanet.model.I_HR_Family getHR_Family3() throws RuntimeException;

    /** Column name HR_Family4_ID */
    public static final String COLUMNNAME_HR_Family4_ID = "HR_Family4_ID";

	/** Set HR_Family4_ID	  */
	public void setHR_Family4_ID (int HR_Family4_ID);

	/** Get HR_Family4_ID	  */
	public int getHR_Family4_ID();

	public org.pentanet.model.I_HR_Family getHR_Family4() throws RuntimeException;

    /** Column name HR_Family_ID */
    public static final String COLUMNNAME_HR_Family_ID = "HR_Family_ID";

	/** Set HR_Family	  */
	public void setHR_Family_ID (int HR_Family_ID);

	/** Get HR_Family	  */
	public int getHR_Family_ID();

	public org.pentanet.model.I_HR_Family getHR_Family() throws RuntimeException;

    /** Column name HR_HCMRequest_ID */
    public static final String COLUMNNAME_HR_HCMRequest_ID = "HR_HCMRequest_ID";

	/** Set HR_HCMRequest	  */
	public void setHR_HCMRequest_ID (int HR_HCMRequest_ID);

	/** Get HR_HCMRequest	  */
	public int getHR_HCMRequest_ID();

    /** Column name HR_HCMRequestLine_ID */
    public static final String COLUMNNAME_HR_HCMRequestLine_ID = "HR_HCMRequestLine_ID";

	/** Set HR_HCMRequestLine	  */
	public void setHR_HCMRequestLine_ID (int HR_HCMRequestLine_ID);

	/** Get HR_HCMRequestLine	  */
	public int getHR_HCMRequestLine_ID();

    /** Column name HR_HCMTabLine_ID */
    public static final String COLUMNNAME_HR_HCMTabLine_ID = "HR_HCMTabLine_ID";

	/** Set HR_HCMTabLine	  */
	public void setHR_HCMTabLine_ID (int HR_HCMTabLine_ID);

	/** Get HR_HCMTabLine	  */
	public int getHR_HCMTabLine_ID();

	public org.pentanet.model.I_HR_HCMTabLine getHR_HCMTabLine() throws RuntimeException;

    /** Column name HR_Process_ID */
    public static final String COLUMNNAME_HR_Process_ID = "HR_Process_ID";

	/** Set Payroll Process	  */
	public void setHR_Process_ID (int HR_Process_ID);

	/** Get Payroll Process	  */
	public int getHR_Process_ID();

	public org.eevolution.model.I_HR_Process getHR_Process() throws RuntimeException;

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

    /** Column name issalaryinteg */
    public static final String COLUMNNAME_issalaryinteg = "issalaryinteg";

	/** Set issalaryinteg	  */
	public void setissalaryinteg (boolean issalaryinteg);

	/** Get issalaryinteg	  */
	public boolean issalaryinteg();

    /** Column name Month_Aplication */
    public static final String COLUMNNAME_Month_Aplication = "Month_Aplication";

	/** Set Month_Aplication	  */
	public void setMonth_Aplication (String Month_Aplication);

	/** Get Month_Aplication	  */
	public String getMonth_Aplication();

    /** Column name Month_Orig */
    public static final String COLUMNNAME_Month_Orig = "Month_Orig";

	/** Set Month_Orig	  */
	public void setMonth_Orig (String Month_Orig);

	/** Get Month_Orig	  */
	public String getMonth_Orig();

    /** Column name Percent */
    public static final String COLUMNNAME_Percent = "Percent";

	/** Set Percent.
	  * Percentage
	  */
	public void setPercent (BigDecimal Percent);

	/** Get Percent.
	  * Percentage
	  */
	public BigDecimal getPercent();

    /** Column name Percent2 */
    public static final String COLUMNNAME_Percent2 = "Percent2";

	/** Set Percent2.
	  * Percentage
	  */
	public void setPercent2 (BigDecimal Percent2);

	/** Get Percent2.
	  * Percentage
	  */
	public BigDecimal getPercent2();

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
