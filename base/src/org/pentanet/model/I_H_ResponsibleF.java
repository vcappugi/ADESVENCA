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

/** Generated Interface for H_ResponsibleF
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_ResponsibleF 
{

    /** TableName=H_ResponsibleF */
    public static final String Table_Name = "H_ResponsibleF";

    /** AD_Table_ID=1000047 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(7);

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

    /** Column name Card */
    public static final String COLUMNNAME_Card = "Card";

	/** Set Card	  */
	public void setCard (boolean Card);

	/** Get Card	  */
	public boolean isCard();

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

    /** Column name CopyCI */
    public static final String COLUMNNAME_CopyCI = "CopyCI";

	/** Set CopyCI	  */
	public void setCopyCI (boolean CopyCI);

	/** Get CopyCI	  */
	public boolean isCopyCI();

    /** Column name Coverage */
    public static final String COLUMNNAME_Coverage = "Coverage";

	/** Set Coverage	  */
	public void setCoverage (BigDecimal Coverage);

	/** Get Coverage	  */
	public BigDecimal getCoverage();

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

    /** Column name Deductible */
    public static final String COLUMNNAME_Deductible = "Deductible";

	/** Set Deductible	  */
	public void setDeductible (BigDecimal Deductible);

	/** Get Deductible	  */
	public BigDecimal getDeductible();

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

    /** Column name H_Admission_ID */
    public static final String COLUMNNAME_H_Admission_ID = "H_Admission_ID";

	/** Set H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID);

	/** Get H_Admission	  */
	public int getH_Admission_ID();

	public org.pentanet.model.I_H_Admission getH_Admission() throws RuntimeException;

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

    /** Column name H_Patient_ID */
    public static final String COLUMNNAME_H_Patient_ID = "H_Patient_ID";

	/** Set H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID);

	/** Get H_Patient	  */
	public int getH_Patient_ID();

	public org.pentanet.model.I_H_Patient getH_Patient() throws RuntimeException;

    /** Column name H_ResponsibleF_ID */
    public static final String COLUMNNAME_H_ResponsibleF_ID = "H_ResponsibleF_ID";

	/** Set H_ResponsibleF	  */
	public void setH_ResponsibleF_ID (int H_ResponsibleF_ID);

	/** Get H_ResponsibleF	  */
	public int getH_ResponsibleF_ID();

    /** Column name IOperator */
    public static final String COLUMNNAME_IOperator = "IOperator";

	/** Set IOperator.
	  * Insurance Operator
	  */
	public void setIOperator (String IOperator);

	/** Get IOperator.
	  * Insurance Operator
	  */
	public String getIOperator();

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

    /** Column name Key */
    public static final String COLUMNNAME_Key = "Key";

	/** Set Key	  */
	public void setKey (String Key);

	/** Get Key	  */
	public String getKey();

    /** Column name Titular */
    public static final String COLUMNNAME_Titular = "Titular";

	/** Set Titular	  */
	public void setTitular (String Titular);

	/** Get Titular	  */
	public String getTitular();

    /** Column name TypeOfNegotiation */
    public static final String COLUMNNAME_TypeOfNegotiation = "TypeOfNegotiation";

	/** Set TypeOfNegotiation.
	  * Tipo de Negociacion 
	  */
	public void setTypeOfNegotiation (String TypeOfNegotiation);

	/** Get TypeOfNegotiation.
	  * Tipo de Negociacion 
	  */
	public String getTypeOfNegotiation();

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

    /** Column name U_Voucher */
    public static final String COLUMNNAME_U_Voucher = "U_Voucher";

	/** Set U_Voucher	  */
	public void setU_Voucher (boolean U_Voucher);

	/** Get U_Voucher	  */
	public boolean isU_Voucher();

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
