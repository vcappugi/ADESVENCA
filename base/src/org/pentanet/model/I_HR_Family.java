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

/** Generated Interface for HR_Family
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_Family 
{

    /** TableName=HR_Family */
    public static final String Table_Name = "HR_Family";

    /** AD_Table_ID=1000101 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name Accident_Insurance_Policy */
    public static final String COLUMNNAME_Accident_Insurance_Policy = "Accident_Insurance_Policy";

	/** Set Accident_Insurance_Policy.
	  * Indica si la persona aplica para el seguro de poliza contra accidentes
	  */
	public void setAccident_Insurance_Policy (boolean Accident_Insurance_Policy);

	/** Get Accident_Insurance_Policy.
	  * Indica si la persona aplica para el seguro de poliza contra accidentes
	  */
	public boolean isAccident_Insurance_Policy();

    /** Column name Accident_Percent */
    public static final String COLUMNNAME_Accident_Percent = "Accident_Percent";

	/** Set Accident_Percent	  */
	public void setAccident_Percent (String Accident_Percent);

	/** Get Accident_Percent	  */
	public String getAccident_Percent();

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name Address1 */
    public static final String COLUMNNAME_Address1 = "Address1";

	/** Set Address 1.
	  * Address line 1 for this location
	  */
	public void setAddress1 (String Address1);

	/** Get Address 1.
	  * Address line 1 for this location
	  */
	public String getAddress1();

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

    /** Column name Birthday */
    public static final String COLUMNNAME_Birthday = "Birthday";

	/** Set Birthday.
	  * Birthday or Anniversary day
	  */
	public void setBirthday (Timestamp Birthday);

	/** Get Birthday.
	  * Birthday or Anniversary day
	  */
	public Timestamp getBirthday();

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

    /** Column name Cedula */
    public static final String COLUMNNAME_Cedula = "Cedula";

	/** Set Cedula	  */
	public void setCedula (String Cedula);

	/** Get Cedula	  */
	public String getCedula();

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

    /** Column name Emergency_Call */
    public static final String COLUMNNAME_Emergency_Call = "Emergency_Call";

	/** Set Emergency_Call.
	  * Llamar en caso de emergencia
	  */
	public void setEmergency_Call (boolean Emergency_Call);

	/** Get Emergency_Call.
	  * Llamar en caso de emergencia
	  */
	public boolean isEmergency_Call();

    /** Column name genero */
    public static final String COLUMNNAME_genero = "genero";

	/** Set genero	  */
	public void setgenero (String genero);

	/** Get genero	  */
	public String getgenero();

    /** Column name Hcm */
    public static final String COLUMNNAME_Hcm = "Hcm";

	/** Set Hcm.
	  * Indica si aplica o no el beneficio de HCM para la persona indicada en la carga familiar
	  */
	public void setHcm (boolean Hcm);

	/** Get Hcm.
	  * Indica si aplica o no el beneficio de HCM para la persona indicada en la carga familiar
	  */
	public boolean isHcm();

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

    /** Column name HR_Family_ID */
    public static final String COLUMNNAME_HR_Family_ID = "HR_Family_ID";

	/** Set HR_Family	  */
	public void setHR_Family_ID (int HR_Family_ID);

	/** Get HR_Family	  */
	public int getHR_Family_ID();

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

    /** Column name Islr */
    public static final String COLUMNNAME_Islr = "Islr";

	/** Set Islr.
	  * Indica si aplica o no el impuesto sobre la renta
	  */
	public void setIslr (boolean Islr);

	/** Get Islr.
	  * Indica si aplica o no el impuesto sobre la renta
	  */
	public boolean islr();

    /** Column name Last_Name */
    public static final String COLUMNNAME_Last_Name = "Last_Name";

	/** Set Last_Name	  */
	public void setLast_Name (String Last_Name);

	/** Get Last_Name	  */
	public String getLast_Name();

    /** Column name Life_Benefit */
    public static final String COLUMNNAME_Life_Benefit = "Life_Benefit";

	/** Set Life_Benefit.
	  * Indica si aplica o no el beneficio de vida para la persona indicada en la carga familiar del empleado
	  */
	public void setLife_Benefit (boolean Life_Benefit);

	/** Get Life_Benefit.
	  * Indica si aplica o no el beneficio de vida para la persona indicada en la carga familiar del empleado
	  */
	public boolean isLife_Benefit();

    /** Column name Life_Percent */
    public static final String COLUMNNAME_Life_Percent = "Life_Percent";

	/** Set Life_Percent	  */
	public void setLife_Percent (String Life_Percent);

	/** Get Life_Percent	  */
	public String getLife_Percent();

    /** Column name Maternity */
    public static final String COLUMNNAME_Maternity = "Maternity";

	/** Set Maternity.
	  * Indica si aplica o no el beneficio de maternidad para la persona indicada en la carga familiar del empleado
	  */
	public void setMaternity (boolean Maternity);

	/** Get Maternity.
	  * Indica si aplica o no el beneficio de maternidad para la persona indicada en la carga familiar del empleado
	  */
	public boolean isMaternity();

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

    /** Column name Parentesco */
    public static final String COLUMNNAME_Parentesco = "Parentesco";

	/** Set Parentesco	  */
	public void setParentesco (String Parentesco);

	/** Get Parentesco	  */
	public String getParentesco();

    /** Column name Phone */
    public static final String COLUMNNAME_Phone = "Phone";

	/** Set Phone.
	  * Identifies a telephone number
	  */
	public void setPhone (String Phone);

	/** Get Phone.
	  * Identifies a telephone number
	  */
	public String getPhone();

    /** Column name Rate */
    public static final String COLUMNNAME_Rate = "Rate";

	/** Set Rate.
	  * Rate or Tax or Exchange
	  */
	public void setRate (BigDecimal Rate);

	/** Get Rate.
	  * Rate or Tax or Exchange
	  */
	public BigDecimal getRate();

    /** Column name same_address */
    public static final String COLUMNNAME_same_address = "same_address";

	/** Set same_address	  */
	public void setsame_address (boolean same_address);

	/** Get same_address	  */
	public boolean issame_address();

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
