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

/** Generated Interface for C_BudgetPublic
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_BudgetPublic 
{

    /** TableName=C_BudgetPublic */
    public static final String Table_Name = "C_BudgetPublic";

    /** AD_Table_ID=1000061 */
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

    /** Column name BudgetPeriodType */
    public static final String COLUMNNAME_BudgetPeriodType = "BudgetPeriodType";

	/** Set BudgetPeriodType	  */
	public void setBudgetPeriodType (String BudgetPeriodType);

	/** Get BudgetPeriodType	  */
	public String getBudgetPeriodType();

    /** Column name BudgetType */
    public static final String COLUMNNAME_BudgetType = "BudgetType";

	/** Set BudgetType	  */
	public void setBudgetType (String BudgetType);

	/** Get BudgetType	  */
	public String getBudgetType();

    /** Column name C_BudgetP_Lot_ID */
    public static final String COLUMNNAME_C_BudgetP_Lot_ID = "C_BudgetP_Lot_ID";

	/** Set C_BudgetP_Lot	  */
	public void setC_BudgetP_Lot_ID (int C_BudgetP_Lot_ID);

	/** Get C_BudgetP_Lot	  */
	public int getC_BudgetP_Lot_ID();

	public org.pentanet.model.I_C_BudgetP_Lot getC_BudgetP_Lot() throws RuntimeException;

    /** Column name C_BudgetPublic_ID */
    public static final String COLUMNNAME_C_BudgetPublic_ID = "C_BudgetPublic_ID";

	/** Set C_BudgetPublic	  */
	public void setC_BudgetPublic_ID (int C_BudgetPublic_ID);

	/** Get C_BudgetPublic	  */
	public int getC_BudgetPublic_ID();

    /** Column name C_BudgetPublic_Source_ID */
    public static final String COLUMNNAME_C_BudgetPublic_Source_ID = "C_BudgetPublic_Source_ID";

	/** Set C_BudgetPublic_Source_ID	  */
	public void setC_BudgetPublic_Source_ID (int C_BudgetPublic_Source_ID);

	/** Get C_BudgetPublic_Source_ID	  */
	public int getC_BudgetPublic_Source_ID();

	public org.pentanet.model.I_C_BudgetPublic getC_BudgetPublic_Source() throws RuntimeException;

    /** Column name C_Financial_Ob_ID */
    public static final String COLUMNNAME_C_Financial_Ob_ID = "C_Financial_Ob_ID";

	/** Set C_Financial_Ob	  */
	public void setC_Financial_Ob_ID (int C_Financial_Ob_ID);

	/** Get C_Financial_Ob	  */
	public int getC_Financial_Ob_ID();

	public org.pentanet.model.I_C_Financial_Ob getC_Financial_Ob() throws RuntimeException;

    /** Column name Class_Budget */
    public static final String COLUMNNAME_Class_Budget = "Class_Budget";

	/** Set Class_Budget	  */
	public void setClass_Budget (String Class_Budget);

	/** Get Class_Budget	  */
	public String getClass_Budget();

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

    /** Column name C_Year_ID */
    public static final String COLUMNNAME_C_Year_ID = "C_Year_ID";

	/** Set Year.
	  * Calendar Year
	  */
	public void setC_Year_ID (int C_Year_ID);

	/** Get Year.
	  * Calendar Year
	  */
	public int getC_Year_ID();

	public org.compiere.model.I_C_Year getC_Year() throws RuntimeException;

    /** Column name DateConfirm */
    public static final String COLUMNNAME_DateConfirm = "DateConfirm";

	/** Set Date Confirm.
	  * Date Confirm of this Order
	  */
	public void setDateConfirm (Timestamp DateConfirm);

	/** Get Date Confirm.
	  * Date Confirm of this Order
	  */
	public Timestamp getDateConfirm();

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

    /** Column name isCentralAction */
    public static final String COLUMNNAME_isCentralAction = "isCentralAction";

	/** Set isCentralAction	  */
	public void setisCentralAction (boolean isCentralAction);

	/** Get isCentralAction	  */
	public boolean isCentralAction();

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
