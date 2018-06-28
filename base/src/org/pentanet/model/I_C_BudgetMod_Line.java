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

/** Generated Interface for C_BudgetMod_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_BudgetMod_Line 
{

    /** TableName=C_BudgetMod_Line */
    public static final String Table_Name = "C_BudgetMod_Line";

    /** AD_Table_ID=1000076 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name Account_ID */
    public static final String COLUMNNAME_Account_ID = "Account_ID";

	/** Set Account.
	  * Account used
	  */
	public void setAccount_ID (int Account_ID);

	/** Get Account.
	  * Account used
	  */
	public int getAccount_ID();

	public org.compiere.model.I_C_ElementValue getAccount() throws RuntimeException;

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

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";

	/** Set Amount.
	  * Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount);

	/** Get Amount.
	  * Amount in a defined currency
	  */
	public BigDecimal getAmount();

    /** Column name C_BudgetMod_ID */
    public static final String COLUMNNAME_C_BudgetMod_ID = "C_BudgetMod_ID";

	/** Set C_BudgetMod	  */
	public void setC_BudgetMod_ID (int C_BudgetMod_ID);

	/** Get C_BudgetMod	  */
	public int getC_BudgetMod_ID();

	public org.pentanet.model.I_C_BudgetMod getC_BudgetMod() throws RuntimeException;

    /** Column name C_BudgetMod_Line_ID */
    public static final String COLUMNNAME_C_BudgetMod_Line_ID = "C_BudgetMod_Line_ID";

	/** Set C_BudgetMod_Line	  */
	public void setC_BudgetMod_Line_ID (int C_BudgetMod_Line_ID);

	/** Get C_BudgetMod_Line	  */
	public int getC_BudgetMod_Line_ID();

    /** Column name C_BUDGETPMOD_TYPE_ID_ID */
    public static final String COLUMNNAME_C_BUDGETPMOD_TYPE_ID_ID = "C_BUDGETPMOD_TYPE_ID_ID";

	/** Set C_BUDGETPMOD_TYPE_ID_ID	  */
	public void setC_BUDGETPMOD_TYPE_ID_ID (int C_BUDGETPMOD_TYPE_ID_ID);

	/** Get C_BUDGETPMOD_TYPE_ID_ID	  */
	public int getC_BUDGETPMOD_TYPE_ID_ID();

	public org.pentanet.model.I_C_BUDGETPMOD_TYPE_ID getC_BUDGETPMOD_TYPE_ID() throws RuntimeException;

    /** Column name C_Manage_Unit_ID */
    public static final String COLUMNNAME_C_Manage_Unit_ID = "C_Manage_Unit_ID";

	/** Set C_Manage_Unit	  */
	public void setC_Manage_Unit_ID (int C_Manage_Unit_ID);

	/** Get C_Manage_Unit	  */
	public int getC_Manage_Unit_ID();

	public org.compiere.model.I_C_Manage_Unit getC_Manage_Unit() throws RuntimeException;

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

    /** Column name Line */
    public static final String COLUMNNAME_Line = "Line";

	/** Set Line No.
	  * Unique line for this document
	  */
	public void setLine (int Line);

	/** Get Line No.
	  * Unique line for this document
	  */
	public int getLine();

    /** Column name MovementTye */
    public static final String COLUMNNAME_MovementTye = "MovementTye";

	/** Set MovementTye	  */
	public void setMovementTye (String MovementTye);

	/** Get MovementTye	  */
	public String getMovementTye();

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

    /** Column name Source_Account_ID */
    public static final String COLUMNNAME_Source_Account_ID = "Source_Account_ID";

	/** Set Source_Account_ID	  */
	public void setSource_Account_ID (int Source_Account_ID);

	/** Get Source_Account_ID	  */
	public int getSource_Account_ID();

	public org.compiere.model.I_C_ElementValue getSource_Account() throws RuntimeException;

    /** Column name Source_Amount */
    public static final String COLUMNNAME_Source_Amount = "Source_Amount";

	/** Set Source_Amount	  */
	public void setSource_Amount (BigDecimal Source_Amount);

	/** Get Source_Amount	  */
	public BigDecimal getSource_Amount();

    /** Column name Source_Project_ID */
    public static final String COLUMNNAME_Source_Project_ID = "Source_Project_ID";

	/** Set Source_Project_ID	  */
	public void setSource_Project_ID (int Source_Project_ID);

	/** Get Source_Project_ID	  */
	public int getSource_Project_ID();

	public org.pentanet.model.I_C_BudgetPublic getSource_Project() throws RuntimeException;

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
