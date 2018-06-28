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

/** Generated Interface for C_AddendumType
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_AddendumType 
{

    /** TableName=C_AddendumType */
    public static final String Table_Name = "C_AddendumType";

    /** AD_Table_ID=1000310 */
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

    /** Column name AddendumType */
    public static final String COLUMNNAME_AddendumType = "AddendumType";

	/** Set AddendumType	  */
	public void setAddendumType (String AddendumType);

	/** Get AddendumType	  */
	public String getAddendumType();

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

    /** Column name C_Addendum_ID */
    public static final String COLUMNNAME_C_Addendum_ID = "C_Addendum_ID";

	/** Set C_Addendum	  */
	public void setC_Addendum_ID (int C_Addendum_ID);

	/** Get C_Addendum	  */
	public int getC_Addendum_ID();

	public org.pentanet.model.I_C_Addendum getC_Addendum() throws RuntimeException;

    /** Column name C_AddendumType_ID */
    public static final String COLUMNNAME_C_AddendumType_ID = "C_AddendumType_ID";

	/** Set C_AddendumType	  */
	public void setC_AddendumType_ID (int C_AddendumType_ID);

	/** Get C_AddendumType	  */
	public int getC_AddendumType_ID();

    /** Column name ComponentRate */
    public static final String COLUMNNAME_ComponentRate = "ComponentRate";

	/** Set ComponentRate	  */
	public void setComponentRate (BigDecimal ComponentRate);

	/** Get ComponentRate	  */
	public BigDecimal getComponentRate();

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

    /** Column name DateTo */
    public static final String COLUMNNAME_DateTo = "DateTo";

	/** Set Date To	  */
	public void setDateTo (Timestamp DateTo);

	/** Get Date To	  */
	public Timestamp getDateTo();

    /** Column name DaysW */
    public static final String COLUMNNAME_DaysW = "DaysW";

	/** Set DaysW	  */
	public void setDaysW (int DaysW);

	/** Get DaysW	  */
	public int getDaysW();

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

    /** Column name EndDateNew */
    public static final String COLUMNNAME_EndDateNew = "EndDateNew";

	/** Set EndDateNew	  */
	public void setEndDateNew (Timestamp EndDateNew);

	/** Get EndDateNew	  */
	public Timestamp getEndDateNew();

    /** Column name GenerateLines */
    public static final String COLUMNNAME_GenerateLines = "GenerateLines";

	/** Set GenerateLines	  */
	public void setGenerateLines (String GenerateLines);

	/** Get GenerateLines	  */
	public String getGenerateLines();

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

    /** Column name IsExternal */
    public static final String COLUMNNAME_IsExternal = "IsExternal";

	/** Set IsExternal	  */
	public void setIsExternal (boolean IsExternal);

	/** Get IsExternal	  */
	public boolean isExternal();

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
}
