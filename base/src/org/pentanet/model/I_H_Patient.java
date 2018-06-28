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

/** Generated Interface for H_Patient
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_Patient 
{

    /** TableName=H_Patient */
    public static final String Table_Name = "H_Patient";

    /** AD_Table_ID=1000011 */
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

    /** Column name Bussines */
    public static final String COLUMNNAME_Bussines = "Bussines";

	/** Set Bussines	  */
	public void setBussines (String Bussines);

	/** Get Bussines	  */
	public String getBussines();

    /** Column name Carnet */
    public static final String COLUMNNAME_Carnet = "Carnet";

	/** Set Carnet	  */
	public void setCarnet (boolean Carnet);

	/** Get Carnet	  */
	public boolean isCarnet();

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

    /** Column name C_City_ID */
    public static final String COLUMNNAME_C_City_ID = "C_City_ID";

	/** Set City.
	  * City
	  */
	public void setC_City_ID (int C_City_ID);

	/** Get City.
	  * City
	  */
	public int getC_City_ID();

    /** Column name Ced_titular */
    public static final String COLUMNNAME_Ced_titular = "Ced_titular";

	/** Set Ced_titular	  */
	public void setCed_titular (String Ced_titular);

	/** Get Ced_titular	  */
	public String getCed_titular();

    /** Column name Cedula */
    public static final String COLUMNNAME_Cedula = "Cedula";

	/** Set Cedula	  */
	public void setCedula (boolean Cedula);

	/** Get Cedula	  */
	public boolean isCedula();

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

    /** Column name C_LocationW_ID */
    public static final String COLUMNNAME_C_LocationW_ID = "C_LocationW_ID";

	/** Set C_LocationW_ID	  */
	public void setC_LocationW_ID (int C_LocationW_ID);

	/** Get C_LocationW_ID	  */
	public int getC_LocationW_ID();

	public I_C_Location getC_LocationW() throws RuntimeException;

    /** Column name COrigen */
    public static final String COLUMNNAME_COrigen = "COrigen";

	/** Set COrigen.
	  * Ciudad de Procedencia
	  */
	public void setCOrigen (String COrigen);

	/** Get COrigen.
	  * Ciudad de Procedencia
	  */
	public String getCOrigen();

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

    /** Column name C_SalesRegionD_ID */
    public static final String COLUMNNAME_C_SalesRegionD_ID = "C_SalesRegionD_ID";

	/** Set C_SalesRegionD_ID	  */
	public void setC_SalesRegionD_ID (int C_SalesRegionD_ID);

	/** Get C_SalesRegionD_ID	  */
	public int getC_SalesRegionD_ID();

	public org.compiere.model.I_C_SalesRegion getC_SalesRegionD() throws RuntimeException;

    /** Column name C_SalesRegion_ID */
    public static final String COLUMNNAME_C_SalesRegion_ID = "C_SalesRegion_ID";

	/** Set Sales Region.
	  * Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID);

	/** Get Sales Region.
	  * Sales coverage region
	  */
	public int getC_SalesRegion_ID();

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException;

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

    /** Column name EMail */
    public static final String COLUMNNAME_EMail = "EMail";

	/** Set EMail Address.
	  * Electronic Mail Address
	  */
	public void setEMail (String EMail);

	/** Get EMail Address.
	  * Electronic Mail Address
	  */
	public String getEMail();

    /** Column name Fecha_Vcto_Poliza */
    public static final String COLUMNNAME_Fecha_Vcto_Poliza = "Fecha_Vcto_Poliza";

	/** Set Fecha_Vcto_Poliza	  */
	public void setFecha_Vcto_Poliza (Timestamp Fecha_Vcto_Poliza);

	/** Get Fecha_Vcto_Poliza	  */
	public Timestamp getFecha_Vcto_Poliza();

    /** Column name GenerateAdmission */
    public static final String COLUMNNAME_GenerateAdmission = "GenerateAdmission";

	/** Set GenerateAdmission.
	  * Botón para generar admisiones
	  */
	public void setGenerateAdmission (String GenerateAdmission);

	/** Get GenerateAdmission.
	  * Botón para generar admisiones
	  */
	public String getGenerateAdmission();

    /** Column name H_Bed_ID */
    public static final String COLUMNNAME_H_Bed_ID = "H_Bed_ID";

	/** Set H_Bed	  */
	public void setH_Bed_ID (int H_Bed_ID);

	/** Get H_Bed	  */
	public int getH_Bed_ID();

	public org.pentanet.model.I_H_Bed getH_Bed() throws RuntimeException;

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

    /** Column name H_MHistory_ID */
    public static final String COLUMNNAME_H_MHistory_ID = "H_MHistory_ID";

	/** Set H_MHistory	  */
	public void setH_MHistory_ID (int H_MHistory_ID);

	/** Get H_MHistory	  */
	public int getH_MHistory_ID();

	public org.pentanet.model.I_H_MHistory getH_MHistory() throws RuntimeException;

    /** Column name HomePhone */
    public static final String COLUMNNAME_HomePhone = "HomePhone";

	/** Set HomePhone	  */
	public void setHomePhone (String HomePhone);

	/** Get HomePhone	  */
	public String getHomePhone();

    /** Column name H_Patient_ID */
    public static final String COLUMNNAME_H_Patient_ID = "H_Patient_ID";

	/** Set H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID);

	/** Get H_Patient	  */
	public int getH_Patient_ID();

    /** Column name IDCard */
    public static final String COLUMNNAME_IDCard = "IDCard";

	/** Set IDCard	  */
	public void setIDCard (String IDCard);

	/** Get IDCard	  */
	public String getIDCard();

    /** Column name InitialDiagnostic */
    public static final String COLUMNNAME_InitialDiagnostic = "InitialDiagnostic";

	/** Set InitialDiagnostic	  */
	public void setInitialDiagnostic (String InitialDiagnostic);

	/** Get InitialDiagnostic	  */
	public String getInitialDiagnostic();

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

    /** Column name IsCompleted */
    public static final String COLUMNNAME_IsCompleted = "IsCompleted";

	/** Set IsCompleted	  */
	public void setIsCompleted (boolean IsCompleted);

	/** Get IsCompleted	  */
	public boolean isCompleted();

    /** Column name IsFResponsible */
    public static final String COLUMNNAME_IsFResponsible = "IsFResponsible";

	/** Set IsFResponsible	  */
	public void setIsFResponsible (boolean IsFResponsible);

	/** Get IsFResponsible	  */
	public boolean isFResponsible();

    /** Column name IsInsured */
    public static final String COLUMNNAME_IsInsured = "IsInsured";

	/** Set IsInsured	  */
	public void setIsInsured (boolean IsInsured);

	/** Get IsInsured	  */
	public boolean isInsured();

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

    /** Column name NroPoliza */
    public static final String COLUMNNAME_NroPoliza = "NroPoliza";

	/** Set NroPoliza	  */
	public void setNroPoliza (String NroPoliza);

	/** Get NroPoliza	  */
	public String getNroPoliza();

    /** Column name PaymentForm */
    public static final String COLUMNNAME_PaymentForm = "PaymentForm";

	/** Set PaymentForm	  */
	public void setPaymentForm (String PaymentForm);

	/** Get PaymentForm	  */
	public String getPaymentForm();

    /** Column name Photo */
    public static final String COLUMNNAME_Photo = "Photo";

	/** Set Photo	  */
	public void setPhoto (int Photo);

	/** Get Photo	  */
	public int getPhoto();

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

    /** Column name Profesion */
    public static final String COLUMNNAME_Profesion = "Profesion";

	/** Set Profesion	  */
	public void setProfesion (String Profesion);

	/** Get Profesion	  */
	public String getProfesion();

    /** Column name Religion */
    public static final String COLUMNNAME_Religion = "Religion";

	/** Set Religion	  */
	public void setReligion (String Religion);

	/** Get Religion	  */
	public String getReligion();

    /** Column name Sex */
    public static final String COLUMNNAME_Sex = "Sex";

	/** Set Sex	  */
	public void setSex (String Sex);

	/** Get Sex	  */
	public String getSex();

    /** Column name Titular_Poliza */
    public static final String COLUMNNAME_Titular_Poliza = "Titular_Poliza";

	/** Set Titular_Poliza	  */
	public void setTitular_Poliza (String Titular_Poliza);

	/** Get Titular_Poliza	  */
	public String getTitular_Poliza();

    /** Column name UltimoV */
    public static final String COLUMNNAME_UltimoV = "UltimoV";

	/** Set UltimoV	  */
	public void setUltimoV (boolean UltimoV);

	/** Get UltimoV	  */
	public boolean isUltimoV();

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
