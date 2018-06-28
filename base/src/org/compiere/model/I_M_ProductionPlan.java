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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for M_ProductionPlan
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_M_ProductionPlan 
{

    /** TableName=M_ProductionPlan */
    public static final String Table_Name = "M_ProductionPlan";

    /** AD_Table_ID=385 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name aceitemax */
    public static final String COLUMNNAME_aceitemax = "aceitemax";

	/** Set aceitemax	  */
	public void setaceitemax (String aceitemax);

	/** Get aceitemax	  */
	public String getaceitemax();

    /** Column name aceitemin */
    public static final String COLUMNNAME_aceitemin = "aceitemin";

	/** Set aceitemin	  */
	public void setaceitemin (String aceitemin);

	/** Get aceitemin	  */
	public String getaceitemin();

    /** Column name aceiteuom */
    public static final String COLUMNNAME_aceiteuom = "aceiteuom";

	/** Set aceiteuom	  */
	public void setaceiteuom (String aceiteuom);

	/** Get aceiteuom	  */
	public String getaceiteuom();

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

    /** Column name aguamax */
    public static final String COLUMNNAME_aguamax = "aguamax";

	/** Set aguamax	  */
	public void setaguamax (String aguamax);

	/** Get aguamax	  */
	public String getaguamax();

    /** Column name aguamin */
    public static final String COLUMNNAME_aguamin = "aguamin";

	/** Set aguamin	  */
	public void setaguamin (String aguamin);

	/** Get aguamin	  */
	public String getaguamin();

    /** Column name aguauom */
    public static final String COLUMNNAME_aguauom = "aguauom";

	/** Set aguauom	  */
	public void setaguauom (String aguauom);

	/** Get aguauom	  */
	public String getaguauom();

    /** Column name alcalinidadmax */
    public static final String COLUMNNAME_alcalinidadmax = "alcalinidadmax";

	/** Set alcalinidadmax	  */
	public void setalcalinidadmax (String alcalinidadmax);

	/** Get alcalinidadmax	  */
	public String getalcalinidadmax();

    /** Column name alcalinidadmin */
    public static final String COLUMNNAME_alcalinidadmin = "alcalinidadmin";

	/** Set alcalinidadmin	  */
	public void setalcalinidadmin (String alcalinidadmin);

	/** Get alcalinidadmin	  */
	public String getalcalinidadmin();

    /** Column name alcalinidaduom */
    public static final String COLUMNNAME_alcalinidaduom = "alcalinidaduom";

	/** Set alcalinidaduom	  */
	public void setalcalinidaduom (String alcalinidaduom);

	/** Get alcalinidaduom	  */
	public String getalcalinidaduom();

    /** Column name arenamax */
    public static final String COLUMNNAME_arenamax = "arenamax";

	/** Set arenamax	  */
	public void setarenamax (String arenamax);

	/** Get arenamax	  */
	public String getarenamax();

    /** Column name arenamin */
    public static final String COLUMNNAME_arenamin = "arenamin";

	/** Set arenamin	  */
	public void setarenamin (String arenamin);

	/** Get arenamin	  */
	public String getarenamin();

    /** Column name arenauom */
    public static final String COLUMNNAME_arenauom = "arenauom";

	/** Set arenauom	  */
	public void setarenauom (String arenauom);

	/** Get arenauom	  */
	public String getarenauom();

    /** Column name BaseDensity */
    public static final String COLUMNNAME_BaseDensity = "BaseDensity";

	/** Set BaseDensity	  */
	public void setBaseDensity (BigDecimal BaseDensity);

	/** Get BaseDensity	  */
	public BigDecimal getBaseDensity();

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

    /** Column name Densidadmax */
    public static final String COLUMNNAME_Densidadmax = "Densidadmax";

	/** Set Densidadmax	  */
	public void setDensidadmax (String Densidadmax);

	/** Get Densidadmax	  */
	public String getDensidadmax();

    /** Column name Densidadmin */
    public static final String COLUMNNAME_Densidadmin = "Densidadmin";

	/** Set Densidadmin	  */
	public void setDensidadmin (String Densidadmin);

	/** Get Densidadmin	  */
	public String getDensidadmin();

    /** Column name densidaduom */
    public static final String COLUMNNAME_densidaduom = "densidaduom";

	/** Set densidaduom	  */
	public void setdensidaduom (String densidaduom);

	/** Get densidaduom	  */
	public String getdensidaduom();

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

    /** Column name EndDensity */
    public static final String COLUMNNAME_EndDensity = "EndDensity";

	/** Set EndDensity	  */
	public void setEndDensity (BigDecimal EndDensity);

	/** Get EndDensity	  */
	public BigDecimal getEndDensity();

    /** Column name estabielectmax */
    public static final String COLUMNNAME_estabielectmax = "estabielectmax";

	/** Set estabielectmax	  */
	public void setestabielectmax (String estabielectmax);

	/** Get estabielectmax	  */
	public String getestabielectmax();

    /** Column name estabielectmin */
    public static final String COLUMNNAME_estabielectmin = "estabielectmin";

	/** Set estabielectmin	  */
	public void setestabielectmin (String estabielectmin);

	/** Get estabielectmin	  */
	public String getestabielectmin();

    /** Column name estabielectuom */
    public static final String COLUMNNAME_estabielectuom = "estabielectuom";

	/** Set estabielectuom	  */
	public void setestabielectuom (String estabielectuom);

	/** Get estabielectuom	  */
	public String getestabielectuom();

    /** Column name excesocalmax */
    public static final String COLUMNNAME_excesocalmax = "excesocalmax";

	/** Set excesocalmax	  */
	public void setexcesocalmax (String excesocalmax);

	/** Get excesocalmax	  */
	public String getexcesocalmax();

    /** Column name excesocalmin */
    public static final String COLUMNNAME_excesocalmin = "excesocalmin";

	/** Set excesocalmin	  */
	public void setexcesocalmin (String excesocalmin);

	/** Get excesocalmin	  */
	public String getexcesocalmin();

    /** Column name excesocaluom */
    public static final String COLUMNNAME_excesocaluom = "excesocaluom";

	/** Set excesocaluom	  */
	public void setexcesocaluom (String excesocaluom);

	/** Get excesocaluom	  */
	public String getexcesocaluom();

    /** Column name ExistenceQty */
    public static final String COLUMNNAME_ExistenceQty = "ExistenceQty";

	/** Set Existence Quantity	  */
	public void setExistenceQty (BigDecimal ExistenceQty);

	/** Get Existence Quantity	  */
	public BigDecimal getExistenceQty();

    /** Column name filtraapimax */
    public static final String COLUMNNAME_filtraapimax = "filtraapimax";

	/** Set filtraapimax	  */
	public void setfiltraapimax (String filtraapimax);

	/** Get filtraapimax	  */
	public String getfiltraapimax();

    /** Column name filtraapimin */
    public static final String COLUMNNAME_filtraapimin = "filtraapimin";

	/** Set filtraapimin	  */
	public void setfiltraapimin (String filtraapimin);

	/** Get filtraapimin	  */
	public String getfiltraapimin();

    /** Column name filtraapiuom */
    public static final String COLUMNNAME_filtraapiuom = "filtraapiuom";

	/** Set filtraapiuom	  */
	public void setfiltraapiuom (String filtraapiuom);

	/** Get filtraapiuom	  */
	public String getfiltraapiuom();

    /** Column name fluid_type */
    public static final String COLUMNNAME_fluid_type = "fluid_type";

	/** Set fluid_type	  */
	public void setfluid_type (String fluid_type);

	/** Get fluid_type	  */
	public String getfluid_type();

    /** Column name gelesmax */
    public static final String COLUMNNAME_gelesmax = "gelesmax";

	/** Set gelesmax	  */
	public void setgelesmax (String gelesmax);

	/** Get gelesmax	  */
	public String getgelesmax();

    /** Column name gelesmin */
    public static final String COLUMNNAME_gelesmin = "gelesmin";

	/** Set gelesmin	  */
	public void setgelesmin (String gelesmin);

	/** Get gelesmin	  */
	public String getgelesmin();

    /** Column name gelesuom */
    public static final String COLUMNNAME_gelesuom = "gelesuom";

	/** Set gelesuom	  */
	public void setgelesuom (String gelesuom);

	/** Get gelesuom	  */
	public String getgelesuom();

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

    /** Column name M_Locator_ID */
    public static final String COLUMNNAME_M_Locator_ID = "M_Locator_ID";

	/** Set Locator.
	  * Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID);

	/** Get Locator.
	  * Warehouse Locator
	  */
	public int getM_Locator_ID();

	public I_M_Locator getM_Locator() throws RuntimeException;

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

    /** Column name M_Production_ID */
    public static final String COLUMNNAME_M_Production_ID = "M_Production_ID";

	/** Set Production.
	  * Plan for producing a product
	  */
	public void setM_Production_ID (int M_Production_ID);

	/** Get Production.
	  * Plan for producing a product
	  */
	public int getM_Production_ID();

	public org.compiere.model.I_M_Production getM_Production() throws RuntimeException;

    /** Column name M_ProductionPlan_ID */
    public static final String COLUMNNAME_M_ProductionPlan_ID = "M_ProductionPlan_ID";

	/** Set Production Plan.
	  * Plan for how a product is produced
	  */
	public void setM_ProductionPlan_ID (int M_ProductionPlan_ID);

	/** Get Production Plan.
	  * Plan for how a product is produced
	  */
	public int getM_ProductionPlan_ID();

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

    /** Column name ProductionQty */
    public static final String COLUMNNAME_ProductionQty = "ProductionQty";

	/** Set Production Quantity.
	  * Quantity of products to produce
	  */
	public void setProductionQty (BigDecimal ProductionQty);

	/** Get Production Quantity.
	  * Quantity of products to produce
	  */
	public BigDecimal getProductionQty();

    /** Column name puntocemax */
    public static final String COLUMNNAME_puntocemax = "puntocemax";

	/** Set puntocemax	  */
	public void setpuntocemax (String puntocemax);

	/** Get puntocemax	  */
	public String getpuntocemax();

    /** Column name puntocemin */
    public static final String COLUMNNAME_puntocemin = "puntocemin";

	/** Set puntocemin	  */
	public void setpuntocemin (String puntocemin);

	/** Get puntocemin	  */
	public String getpuntocemin();

    /** Column name puntoceuom */
    public static final String COLUMNNAME_puntoceuom = "puntoceuom";

	/** Set puntoceuom	  */
	public void setpuntoceuom (String puntoceuom);

	/** Get puntoceuom	  */
	public String getpuntoceuom();

    /** Column name RequestQty */
    public static final String COLUMNNAME_RequestQty = "RequestQty";

	/** Set RequestQty	  */
	public void setRequestQty (BigDecimal RequestQty);

	/** Get RequestQty	  */
	public BigDecimal getRequestQty();

    /** Column name solidomax */
    public static final String COLUMNNAME_solidomax = "solidomax";

	/** Set solidomax	  */
	public void setsolidomax (String solidomax);

	/** Get solidomax	  */
	public String getsolidomax();

    /** Column name solidomin */
    public static final String COLUMNNAME_solidomin = "solidomin";

	/** Set solidomin	  */
	public void setsolidomin (String solidomin);

	/** Get solidomin	  */
	public String getsolidomin();

    /** Column name solidouom */
    public static final String COLUMNNAME_solidouom = "solidouom";

	/** Set solidouom	  */
	public void setsolidouom (String solidouom);

	/** Get solidouom	  */
	public String getsolidouom();

    /** Column name turbidezmax */
    public static final String COLUMNNAME_turbidezmax = "turbidezmax";

	/** Set turbidezmax	  */
	public void setturbidezmax (String turbidezmax);

	/** Get turbidezmax	  */
	public String getturbidezmax();

    /** Column name turbidezmin */
    public static final String COLUMNNAME_turbidezmin = "turbidezmin";

	/** Set turbidezmin	  */
	public void setturbidezmin (String turbidezmin);

	/** Get turbidezmin	  */
	public String getturbidezmin();

    /** Column name turbidezuom */
    public static final String COLUMNNAME_turbidezuom = "turbidezuom";

	/** Set turbidezuom	  */
	public void setturbidezuom (String turbidezuom);

	/** Get turbidezuom	  */
	public String getturbidezuom();

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

    /** Column name viscocidadmax */
    public static final String COLUMNNAME_viscocidadmax = "viscocidadmax";

	/** Set viscocidadmax	  */
	public void setviscocidadmax (String viscocidadmax);

	/** Get viscocidadmax	  */
	public String getviscocidadmax();

    /** Column name viscocidadmin */
    public static final String COLUMNNAME_viscocidadmin = "viscocidadmin";

	/** Set viscocidadmin	  */
	public void setviscocidadmin (String viscocidadmin);

	/** Get viscocidadmin	  */
	public String getviscocidadmin();

    /** Column name viscocidaduom */
    public static final String COLUMNNAME_viscocidaduom = "viscocidaduom";

	/** Set viscocidaduom	  */
	public void setviscocidaduom (String viscocidaduom);

	/** Get viscocidaduom	  */
	public String getviscocidaduom();

    /** Column name viscoplastimax */
    public static final String COLUMNNAME_viscoplastimax = "viscoplastimax";

	/** Set viscoplastimax	  */
	public void setviscoplastimax (String viscoplastimax);

	/** Get viscoplastimax	  */
	public String getviscoplastimax();

    /** Column name viscoplastimin */
    public static final String COLUMNNAME_viscoplastimin = "viscoplastimin";

	/** Set viscoplastimin	  */
	public void setviscoplastimin (String viscoplastimin);

	/** Get viscoplastimin	  */
	public String getviscoplastimin();

    /** Column name viscoplastiuom */
    public static final String COLUMNNAME_viscoplastiuom = "viscoplastiuom";

	/** Set viscoplastiuom	  */
	public void setviscoplastiuom (String viscoplastiuom);

	/** Get viscoplastiuom	  */
	public String getviscoplastiuom();

    /** Column name Weight */
    public static final String COLUMNNAME_Weight = "Weight";

	/** Set Weight.
	  * Weight of a product
	  */
	public void setWeight (BigDecimal Weight);

	/** Get Weight.
	  * Weight of a product
	  */
	public BigDecimal getWeight();
}
