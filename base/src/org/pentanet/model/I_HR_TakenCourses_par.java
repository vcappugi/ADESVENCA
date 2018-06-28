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

/** Generated Interface for HR_TakenCourses_par
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_HR_TakenCourses_par 
{

    /** TableName=HR_TakenCourses_par */
    public static final String Table_Name = "HR_TakenCourses_par";

    /** AD_Table_ID=1000266 */
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

    /** Column name BPartner_Employee */
    public static final String COLUMNNAME_BPartner_Employee = "BPartner_Employee";

	/** Set BPartner_Employee	  */
	public void setBPartner_Employee (int BPartner_Employee);

	/** Get BPartner_Employee	  */
	public int getBPartner_Employee();

	public org.compiere.model.I_C_BPartner getBPartner_Emplo() throws RuntimeException;

    /** Column name BPartner_Institute */
    public static final String COLUMNNAME_BPartner_Institute = "BPartner_Institute";

	/** Set BPartner_Institute	  */
	public void setBPartner_Institute (int BPartner_Institute);

	/** Get BPartner_Institute	  */
	public int getBPartner_Institute();

	public org.compiere.model.I_C_BPartner getBPartner_Instit() throws RuntimeException;

    /** Column name BPartner_Provider */
    public static final String COLUMNNAME_BPartner_Provider = "BPartner_Provider";

	/** Set BPartner_Provider	  */
	public void setBPartner_Provider (int BPartner_Provider);

	/** Get BPartner_Provider	  */
	public int getBPartner_Provider();

	public org.compiere.model.I_C_BPartner getBPartner_Provi() throws RuntimeException;

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

	public org.compiere.model.I_C_City getC_City() throws RuntimeException;

    /** Column name C_Country_ID */
    public static final String COLUMNNAME_C_Country_ID = "C_Country_ID";

	/** Set Country.
	  * Country 
	  */
	public void setC_Country_ID (int C_Country_ID);

	/** Get Country.
	  * Country 
	  */
	public int getC_Country_ID();

	public org.compiere.model.I_C_Country getC_Country() throws RuntimeException;

    /** Column name CostAmt */
    public static final String COLUMNNAME_CostAmt = "CostAmt";

	/** Set Cost Value.
	  * Value with Cost
	  */
	public void setCostAmt (BigDecimal CostAmt);

	/** Get Cost Value.
	  * Value with Cost
	  */
	public BigDecimal getCostAmt();

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

    /** Column name C_Region_ID */
    public static final String COLUMNNAME_C_Region_ID = "C_Region_ID";

	/** Set Region.
	  * Identifies a geographical Region
	  */
	public void setC_Region_ID (int C_Region_ID);

	/** Get Region.
	  * Identifies a geographical Region
	  */
	public int getC_Region_ID();

	public org.compiere.model.I_C_Region getC_Region() throws RuntimeException;

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

    /** Column name EndCourse */
    public static final String COLUMNNAME_EndCourse = "EndCourse";

	/** Set EndCourse	  */
	public void setEndCourse (Timestamp EndCourse);

	/** Get EndCourse	  */
	public Timestamp getEndCourse();

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

    /** Column name HR_TakenCourses_par_ID */
    public static final String COLUMNNAME_HR_TakenCourses_par_ID = "HR_TakenCourses_par_ID";

	/** Set HR_TakenCourses_par	  */
	public void setHR_TakenCourses_par_ID (int HR_TakenCourses_par_ID);

	/** Get HR_TakenCourses_par	  */
	public int getHR_TakenCourses_par_ID();

    /** Column name ID_Activity */
    public static final String COLUMNNAME_ID_Activity = "ID_Activity";

	/** Set ID_Activity	  */
	public void setID_Activity (int ID_Activity);

	/** Get ID_Activity	  */
	public int getID_Activity();

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

    /** Column name M_Product_Cost_ID */
    public static final String COLUMNNAME_M_Product_Cost_ID = "M_Product_Cost_ID";

	/** Set M_Product_Cost_ID	  */
	public void setM_Product_Cost_ID (int M_Product_Cost_ID);

	/** Get M_Product_Cost_ID	  */
	public int getM_Product_Cost_ID();

	public org.compiere.model.I_M_Product getM_Product_Cost() throws RuntimeException;

    /** Column name M_Product_Exp_ID */
    public static final String COLUMNNAME_M_Product_Exp_ID = "M_Product_Exp_ID";

	/** Set M_Product_Exp_ID	  */
	public void setM_Product_Exp_ID (int M_Product_Exp_ID);

	/** Get M_Product_Exp_ID	  */
	public int getM_Product_Exp_ID();

	public org.compiere.model.I_M_Product getM_Product_Exp() throws RuntimeException;

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

    /** Column name num_factura */
    public static final String COLUMNNAME_num_factura = "num_factura";

	/** Set num_factura	  */
	public void setnum_factura (String num_factura);

	/** Get num_factura	  */
	public String getnum_factura();

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

    /** Column name StartCourse */
    public static final String COLUMNNAME_StartCourse = "StartCourse";

	/** Set StartCourse	  */
	public void setStartCourse (Timestamp StartCourse);

	/** Get StartCourse	  */
	public Timestamp getStartCourse();

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
