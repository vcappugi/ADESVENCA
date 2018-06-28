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

/** Generated Interface for H_EPersons
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_EPersons 
{

    /** TableName=H_EPersons */
    public static final String Table_Name = "H_EPersons";

    /** AD_Table_ID=1000020 */
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

    /** Column name BDate */
    public static final String COLUMNNAME_BDate = "BDate";

	/** Set BDate	  */
	public void setBDate (Timestamp BDate);

	/** Get BDate	  */
	public Timestamp getBDate();

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

    /** Column name C_LocationW_ID */
    public static final String COLUMNNAME_C_LocationW_ID = "C_LocationW_ID";

	/** Set C_LocationW_ID	  */
	public void setC_LocationW_ID (int C_LocationW_ID);

	/** Get C_LocationW_ID	  */
	public int getC_LocationW_ID();

	public I_C_Location getC_LocationW() throws RuntimeException;

    /** Column name C_Location_ID */
    public static final String COLUMNNAME_C_Location_ID = "C_Location_ID";

	/** Set Address.
	  * Location or Address
	  */
	public void setC_Location_ID (int C_Location_ID);

	/** Get Address.
	  * Location or Address
	  */
	public int getC_Location_ID();

	public I_C_Location getC_Location() throws RuntimeException;

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

    /** Column name H_EPersons_ID */
    public static final String COLUMNNAME_H_EPersons_ID = "H_EPersons_ID";

	/** Set H_EPersons	  */
	public void setH_EPersons_ID (int H_EPersons_ID);

	/** Get H_EPersons	  */
	public int getH_EPersons_ID();

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

    /** Column name HomePhone */
    public static final String COLUMNNAME_HomePhone = "HomePhone";

	/** Set HomePhone	  */
	public void setHomePhone (String HomePhone);

	/** Get HomePhone	  */
	public String getHomePhone();

    /** Column name IDCard */
    public static final String COLUMNNAME_IDCard = "IDCard";

	/** Set IDCard	  */
	public void setIDCard (String IDCard);

	/** Get IDCard	  */
	public String getIDCard();

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

    /** Column name IsBPartner */
    public static final String COLUMNNAME_IsBPartner = "IsBPartner";

	/** Set IsBPartner.
	  * Define si es Socio de Negocio
	  */
	public void setIsBPartner (boolean IsBPartner);

	/** Get IsBPartner.
	  * Define si es Socio de Negocio
	  */
	public boolean isBPartner();

    /** Column name IsCompanion */
    public static final String COLUMNNAME_IsCompanion = "IsCompanion";

	/** Set IsCompanion.
	  * Define si es acompañante del paciente
	  */
	public void setIsCompanion (boolean IsCompanion);

	/** Get IsCompanion.
	  * Define si es acompañante del paciente
	  */
	public boolean isCompanion();

    /** Column name IsFResponsible */
    public static final String COLUMNNAME_IsFResponsible = "IsFResponsible";

	/** Set IsFResponsible.
	  * Define si la persona es Responsable Financiero
	  */
	public void setIsFResponsible (boolean IsFResponsible);

	/** Get IsFResponsible.
	  * Define si la persona es Responsable Financiero
	  */
	public boolean isFResponsible();

    /** Column name IsIResponsible */
    public static final String COLUMNNAME_IsIResponsible = "IsIResponsible";

	/** Set IsIResponsible.
	  * Define si es responsable ante la institucion
	  */
	public void setIsIResponsible (boolean IsIResponsible);

	/** Get IsIResponsible.
	  * Define si es responsable ante la institucion
	  */
	public boolean isIResponsible();

    /** Column name IsPolicyHolder */
    public static final String COLUMNNAME_IsPolicyHolder = "IsPolicyHolder";

	/** Set IsPolicyHolder.
	  * Indica si es titular de una poliza de seguros
	  */
	public void setIsPolicyHolder (boolean IsPolicyHolder);

	/** Get IsPolicyHolder.
	  * Indica si es titular de una poliza de seguros
	  */
	public boolean isPolicyHolder();

    /** Column name Key */
    public static final String COLUMNNAME_Key = "Key";

	/** Set Key	  */
	public void setKey (String Key);

	/** Get Key	  */
	public String getKey();

    /** Column name Kinship */
    public static final String COLUMNNAME_Kinship = "Kinship";

	/** Set Kinship	  */
	public void setKinship (String Kinship);

	/** Get Kinship	  */
	public String getKinship();

    /** Column name MaritalStatus */
    public static final String COLUMNNAME_MaritalStatus = "MaritalStatus";

	/** Set MaritalStatus	  */
	public void setMaritalStatus (String MaritalStatus);

	/** Get MaritalStatus	  */
	public String getMaritalStatus();

    /** Column name Movil */
    public static final String COLUMNNAME_Movil = "Movil";

	/** Set Movil	  */
	public void setMovil (String Movil);

	/** Get Movil	  */
	public String getMovil();

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

    /** Column name Sex */
    public static final String COLUMNNAME_Sex = "Sex";

	/** Set Sex	  */
	public void setSex (String Sex);

	/** Get Sex	  */
	public String getSex();

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

    /** Column name WorkPhone */
    public static final String COLUMNNAME_WorkPhone = "WorkPhone";

	/** Set WorkPhone	  */
	public void setWorkPhone (String WorkPhone);

	/** Get WorkPhone	  */
	public String getWorkPhone();
}
