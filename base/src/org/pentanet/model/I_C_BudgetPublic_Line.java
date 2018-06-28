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

/** Generated Interface for C_BudgetPublic_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_BudgetPublic_Line 
{

    /** TableName=C_BudgetPublic_Line */
    public static final String Table_Name = "C_BudgetPublic_Line";

    /** AD_Table_ID=1000062 */
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

    /** Column name AmountModify */
    public static final String COLUMNNAME_AmountModify = "AmountModify";

	/** Set AmountModify	  */
	public void setAmountModify (BigDecimal AmountModify);

	/** Get AmountModify	  */
	public BigDecimal getAmountModify();

    /** Column name AmtCau */
    public static final String COLUMNNAME_AmtCau = "AmtCau";

	/** Set AmtCau	  */
	public void setAmtCau (BigDecimal AmtCau);

	/** Get AmtCau	  */
	public BigDecimal getAmtCau();

    /** Column name AmtComp */
    public static final String COLUMNNAME_AmtComp = "AmtComp";

	/** Set AmtComp	  */
	public void setAmtComp (BigDecimal AmtComp);

	/** Get AmtComp	  */
	public BigDecimal getAmtComp();

    /** Column name AmtPay */
    public static final String COLUMNNAME_AmtPay = "AmtPay";

	/** Set AmtPay	  */
	public void setAmtPay (BigDecimal AmtPay);

	/** Get AmtPay	  */
	public BigDecimal getAmtPay();

    /** Column name AmtPreC */
    public static final String COLUMNNAME_AmtPreC = "AmtPreC";

	/** Set AmtPreC	  */
	public void setAmtPreC (BigDecimal AmtPreC);

	/** Get AmtPreC	  */
	public BigDecimal getAmtPreC();

    /** Column name C_Acct_Cont_ID */
    public static final String COLUMNNAME_C_Acct_Cont_ID = "C_Acct_Cont_ID";

	/** Set C_Acct_Cont_ID	  */
	public void setC_Acct_Cont_ID (int C_Acct_Cont_ID);

	/** Get C_Acct_Cont_ID	  */
	public int getC_Acct_Cont_ID();

	public org.compiere.model.I_C_ElementValue getC_Acct_Cont() throws RuntimeException;

    /** Column name C_Budget_Account_ID */
    public static final String COLUMNNAME_C_Budget_Account_ID = "C_Budget_Account_ID";

	/** Set C_Budget_Account_ID	  */
	public void setC_Budget_Account_ID (int C_Budget_Account_ID);

	/** Get C_Budget_Account_ID	  */
	public int getC_Budget_Account_ID();

	public org.compiere.model.I_C_ElementValue getC_Budget_Account() throws RuntimeException;

    /** Column name C_BudgetPublic_ID */
    public static final String COLUMNNAME_C_BudgetPublic_ID = "C_BudgetPublic_ID";

	/** Set C_BudgetPublic	  */
	public void setC_BudgetPublic_ID (int C_BudgetPublic_ID);

	/** Get C_BudgetPublic	  */
	public int getC_BudgetPublic_ID();

	public org.pentanet.model.I_C_BudgetPublic getC_BudgetPublic() throws RuntimeException;

    /** Column name C_BudgetPublic_Line_ID */
    public static final String COLUMNNAME_C_BudgetPublic_Line_ID = "C_BudgetPublic_Line_ID";

	/** Set C_BudgetPublic_Line	  */
	public void setC_BudgetPublic_Line_ID (int C_BudgetPublic_Line_ID);

	/** Get C_BudgetPublic_Line	  */
	public int getC_BudgetPublic_Line_ID();

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

    /** Column name RealAmount */
    public static final String COLUMNNAME_RealAmount = "RealAmount";

	/** Set RealAmount	  */
	public void setRealAmount (BigDecimal RealAmount);

	/** Get RealAmount	  */
	public BigDecimal getRealAmount();

    /** Column name Recalculate */
    public static final String COLUMNNAME_Recalculate = "Recalculate";

	/** Set Recalculate	  */
	public void setRecalculate (String Recalculate);

	/** Get Recalculate	  */
	public String getRecalculate();

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
