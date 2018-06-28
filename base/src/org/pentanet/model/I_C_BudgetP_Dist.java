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

/** Generated Interface for C_BudgetP_Dist
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_C_BudgetP_Dist 
{

    /** TableName=C_BudgetP_Dist */
    public static final String Table_Name = "C_BudgetP_Dist";

    /** AD_Table_ID=1000075 */
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

    /** Column name C_BudgetP_Dist_ID */
    public static final String COLUMNNAME_C_BudgetP_Dist_ID = "C_BudgetP_Dist_ID";

	/** Set C_BudgetP_Dist	  */
	public void setC_BudgetP_Dist_ID (int C_BudgetP_Dist_ID);

	/** Get C_BudgetP_Dist	  */
	public int getC_BudgetP_Dist_ID();

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

	public org.pentanet.model.I_C_BudgetPublic_Line getC_BudgetPublic_Line() throws RuntimeException;

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

    /** Column name Periodo_1 */
    public static final String COLUMNNAME_Periodo_1 = "Periodo_1";

	/** Set Periodo_1	  */
	public void setPeriodo_1 (BigDecimal Periodo_1);

	/** Get Periodo_1	  */
	public BigDecimal getPeriodo_1();

    /** Column name Periodo_10 */
    public static final String COLUMNNAME_Periodo_10 = "Periodo_10";

	/** Set Periodo_10	  */
	public void setPeriodo_10 (BigDecimal Periodo_10);

	/** Get Periodo_10	  */
	public BigDecimal getPeriodo_10();

    /** Column name Periodo_11 */
    public static final String COLUMNNAME_Periodo_11 = "Periodo_11";

	/** Set Periodo_11	  */
	public void setPeriodo_11 (BigDecimal Periodo_11);

	/** Get Periodo_11	  */
	public BigDecimal getPeriodo_11();

    /** Column name Periodo_12 */
    public static final String COLUMNNAME_Periodo_12 = "Periodo_12";

	/** Set Periodo_12	  */
	public void setPeriodo_12 (BigDecimal Periodo_12);

	/** Get Periodo_12	  */
	public BigDecimal getPeriodo_12();

    /** Column name Periodo_2 */
    public static final String COLUMNNAME_Periodo_2 = "Periodo_2";

	/** Set Periodo_2	  */
	public void setPeriodo_2 (BigDecimal Periodo_2);

	/** Get Periodo_2	  */
	public BigDecimal getPeriodo_2();

    /** Column name Periodo_3 */
    public static final String COLUMNNAME_Periodo_3 = "Periodo_3";

	/** Set Periodo_3	  */
	public void setPeriodo_3 (BigDecimal Periodo_3);

	/** Get Periodo_3	  */
	public BigDecimal getPeriodo_3();

    /** Column name Periodo_4 */
    public static final String COLUMNNAME_Periodo_4 = "Periodo_4";

	/** Set Periodo_4	  */
	public void setPeriodo_4 (BigDecimal Periodo_4);

	/** Get Periodo_4	  */
	public BigDecimal getPeriodo_4();

    /** Column name Periodo_5 */
    public static final String COLUMNNAME_Periodo_5 = "Periodo_5";

	/** Set Periodo_5	  */
	public void setPeriodo_5 (BigDecimal Periodo_5);

	/** Get Periodo_5	  */
	public BigDecimal getPeriodo_5();

    /** Column name Periodo_6 */
    public static final String COLUMNNAME_Periodo_6 = "Periodo_6";

	/** Set Periodo_6	  */
	public void setPeriodo_6 (BigDecimal Periodo_6);

	/** Get Periodo_6	  */
	public BigDecimal getPeriodo_6();

    /** Column name Periodo_7 */
    public static final String COLUMNNAME_Periodo_7 = "Periodo_7";

	/** Set Periodo_7	  */
	public void setPeriodo_7 (BigDecimal Periodo_7);

	/** Get Periodo_7	  */
	public BigDecimal getPeriodo_7();

    /** Column name Periodo_8 */
    public static final String COLUMNNAME_Periodo_8 = "Periodo_8";

	/** Set Periodo_8	  */
	public void setPeriodo_8 (BigDecimal Periodo_8);

	/** Get Periodo_8	  */
	public BigDecimal getPeriodo_8();

    /** Column name Periodo_9 */
    public static final String COLUMNNAME_Periodo_9 = "Periodo_9";

	/** Set Periodo_9	  */
	public void setPeriodo_9 (BigDecimal Periodo_9);

	/** Get Periodo_9	  */
	public BigDecimal getPeriodo_9();

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
