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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for c_currentpos
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS
 */
public interface I_c_currentpos 
{

    /** TableName=c_currentpos */
    public static final String Table_Name = "c_currentpos";

    /** AD_Table_ID=1000000 */
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

    /** Column name BeginningBalance */
    public static final String COLUMNNAME_BeginningBalance = "BeginningBalance";

	/** Set Beginning Balance.
	  * Balance prior to any transactions
	  */
	public void setBeginningBalance (BigDecimal BeginningBalance);

	/** Get Beginning Balance.
	  * Balance prior to any transactions
	  */
	public BigDecimal getBeginningBalance();

    /** Column name c_currentpos_ID */
    public static final String COLUMNNAME_c_currentpos_ID = "c_currentpos_ID";

	/** Set c_currentpos	  */
	public void setc_currentpos_ID (int c_currentpos_ID);

	/** Get c_currentpos	  */
	public int getc_currentpos_ID();

    /** Column name C_POS_ID */
    public static final String COLUMNNAME_C_POS_ID = "C_POS_ID";

	/** Set POS Terminal.
	  * Point of Sales Terminal
	  */
	public void setC_POS_ID (int C_POS_ID);

	/** Get POS Terminal.
	  * Point of Sales Terminal
	  */
	public int getC_POS_ID();

	public org.compiere.model.I_C_POS getC_POS() throws RuntimeException;

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

    /** Column name difference */
    public static final String COLUMNNAME_difference = "difference";

	/** Set difference	  */
	public void setdifference (BigDecimal difference);

	/** Get difference	  */
	public BigDecimal getdifference();

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

    /** Column name EndingBalance */
    public static final String COLUMNNAME_EndingBalance = "EndingBalance";

	/** Set Ending balance.
	  * Ending  or closing balance
	  */
	public void setEndingBalance (BigDecimal EndingBalance);

	/** Get Ending balance.
	  * Ending  or closing balance
	  */
	public BigDecimal getEndingBalance();

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

    /** Column name MatchStatement */
    public static final String COLUMNNAME_MatchStatement = "MatchStatement";

	/** Set Match Statement	  */
	public void setMatchStatement (boolean MatchStatement);

	/** Get Match Statement	  */
	public boolean isMatchStatement();

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

    /** Column name posdateClose */
    public static final String COLUMNNAME_posdateClose = "posdateClose";

	/** Set posdateClose	  */
	public void setposdateClose (Timestamp posdateClose);

	/** Get posdateClose	  */
	public Timestamp getposdateClose();

    /** Column name posdateOpen */
    public static final String COLUMNNAME_posdateOpen = "posdateOpen";

	/** Set posdateOpen	  */
	public void setposdateOpen (Timestamp posdateOpen);

	/** Get posdateOpen	  */
	public Timestamp getposdateOpen();

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

    /** Column name ProcessedOn */
    public static final String COLUMNNAME_ProcessedOn = "ProcessedOn";

	/** Set Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public void setProcessedOn (BigDecimal ProcessedOn);

	/** Get Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public BigDecimal getProcessedOn();

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
}
