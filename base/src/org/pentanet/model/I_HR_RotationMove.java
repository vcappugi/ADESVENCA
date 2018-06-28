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

/** Generated Interface for HR_RotationMove
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_HR_RotationMove 
{

    /** TableName=HR_RotationMove */
    public static final String Table_Name = "HR_RotationMove";

    /** AD_Table_ID=1000131 */
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

    /** Column name HR_GuardRole_ID */
    public static final String COLUMNNAME_HR_GuardRole_ID = "HR_GuardRole_ID";

	/** Set HR_GuardRole	  */
	public void setHR_GuardRole_ID (int HR_GuardRole_ID);

	/** Get HR_GuardRole	  */
	public int getHR_GuardRole_ID();

	public org.pentanet.model.I_HR_GuardRole getHR_GuardRole() throws RuntimeException;

    /** Column name HR_Rotation_ID */
    public static final String COLUMNNAME_HR_Rotation_ID = "HR_Rotation_ID";

	/** Set HR_Rotation	  */
	public void setHR_Rotation_ID (int HR_Rotation_ID);

	/** Get HR_Rotation	  */
	public int getHR_Rotation_ID();

	public org.pentanet.model.I_HR_Rotation getHR_Rotation() throws RuntimeException;

    /** Column name HR_RotationMove_ID */
    public static final String COLUMNNAME_HR_RotationMove_ID = "HR_RotationMove_ID";

	/** Set HR_RotationMove	  */
	public void setHR_RotationMove_ID (int HR_RotationMove_ID);

	/** Get HR_RotationMove	  */
	public int getHR_RotationMove_ID();

    /** Column name HR_RotationType_ID */
    public static final String COLUMNNAME_HR_RotationType_ID = "HR_RotationType_ID";

	/** Set HR_RotationType	  */
	public void setHR_RotationType_ID (int HR_RotationType_ID);

	/** Get HR_RotationType	  */
	public int getHR_RotationType_ID();

	public org.pentanet.model.I_HR_RotationType getHR_RotationType() throws RuntimeException;

    /** Column name HR_Standing_ID */
    public static final String COLUMNNAME_HR_Standing_ID = "HR_Standing_ID";

	/** Set HR_Standing	  */
	public void setHR_Standing_ID (int HR_Standing_ID);

	/** Get HR_Standing	  */
	public int getHR_Standing_ID();

	public org.pentanet.model.I_HR_Standing getHR_Standing() throws RuntimeException;

    /** Column name HR_Turn_ID */
    public static final String COLUMNNAME_HR_Turn_ID = "HR_Turn_ID";

	/** Set HR_Turn	  */
	public void setHR_Turn_ID (int HR_Turn_ID);

	/** Get HR_Turn	  */
	public int getHR_Turn_ID();

	public org.pentanet.model.I_HR_Turn getHR_Turn() throws RuntimeException;

    /** Column name HR_WorkGroup_ID */
    public static final String COLUMNNAME_HR_WorkGroup_ID = "HR_WorkGroup_ID";

	/** Set HR_WorkGroup	  */
	public void setHR_WorkGroup_ID (int HR_WorkGroup_ID);

	/** Get HR_WorkGroup	  */
	public int getHR_WorkGroup_ID();

	public org.pentanet.model.I_HR_WorkGroup getHR_WorkGroup() throws RuntimeException;

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
