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

/** Generated Interface for H_ATreatment
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_ATreatment 
{

    /** TableName=H_ATreatment */
    public static final String Table_Name = "H_ATreatment";

    /** AD_Table_ID=1000029 */
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

    /** Column name ApplicationTime */
    public static final String COLUMNNAME_ApplicationTime = "ApplicationTime";

	/** Set ApplicationTime.
	  * Fecha y Hora de la aplicación del tratamiento
	  */
	public void setApplicationTime (Timestamp ApplicationTime);

	/** Get ApplicationTime.
	  * Fecha y Hora de la aplicación del tratamiento
	  */
	public Timestamp getApplicationTime();

    /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

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

    /** Column name Dose */
    public static final String COLUMNNAME_Dose = "Dose";

	/** Set Dose.
	  * Dosis de un medicamento
	  */
	public void setDose (BigDecimal Dose);

	/** Get Dose.
	  * Dosis de un medicamento
	  */
	public BigDecimal getDose();

    /** Column name H_ATreatment_ID */
    public static final String COLUMNNAME_H_ATreatment_ID = "H_ATreatment_ID";

	/** Set H_ATreatment	  */
	public void setH_ATreatment_ID (int H_ATreatment_ID);

	/** Get H_ATreatment	  */
	public int getH_ATreatment_ID();

    /** Column name H_Patient_ID */
    public static final String COLUMNNAME_H_Patient_ID = "H_Patient_ID";

	/** Set H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID);

	/** Get H_Patient	  */
	public int getH_Patient_ID();

    /** Column name H_Treatment_ID */
    public static final String COLUMNNAME_H_Treatment_ID = "H_Treatment_ID";

	/** Set H_Treatment	  */
	public void setH_Treatment_ID (int H_Treatment_ID);

	/** Get H_Treatment	  */
	public int getH_Treatment_ID();

	public org.pentanet.model.I_H_Treatment getH_Treatment() throws RuntimeException;

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

    /** Column name IsApplied */
    public static final String COLUMNNAME_IsApplied = "IsApplied";

	/** Set IsApplied.
	  * Define si fue aplicado un medicamento del tratamiento
	  */
	public void setIsApplied (boolean IsApplied);

	/** Get IsApplied.
	  * Define si fue aplicado un medicamento del tratamiento
	  */
	public boolean isApplied();

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

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
	
	
    /** Column name ActualApplicationTime */
    public static final String COLUMNNAME_ActualApplicationTime = "ActualApplicationTime";

	/** Set ActualApplicationTime.
	  * Fecha y Hora de la aplicación real del tratamiento
	  */
	public void setActualApplicationTime (Timestamp ActualApplicationTime);

	/** Get ActualApplicationTime.
	  * Fecha y Hora de la aplicación real del tratamiento
	  */
	public Timestamp getActualApplicationTime();

}
