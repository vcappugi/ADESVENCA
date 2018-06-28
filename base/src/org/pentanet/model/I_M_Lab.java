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

/** Generated Interface for M_Lab
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_M_Lab 
{

    /** TableName=M_Lab */
    public static final String Table_Name = "M_Lab";

    /** AD_Table_ID=1000108 */
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

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set Usuario.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get Usuario.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name AD_User_Rev_ID */
    public static final String COLUMNNAME_AD_User_Rev_ID = "AD_User_Rev_ID";

	/** Set AD_User_Rev_ID	  */
	public void setAD_User_Rev_ID (int AD_User_Rev_ID);

	/** Get AD_User_Rev_ID	  */
	public int getAD_User_Rev_ID();

	public org.compiere.model.I_AD_User getAD_User_Rev() throws RuntimeException;

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

    /** Column name DateEnd */
    public static final String COLUMNNAME_DateEnd = "DateEnd";

	/** Set DateEnd	  */
	public void setDateEnd (Timestamp DateEnd);

	/** Get DateEnd	  */
	public Timestamp getDateEnd();

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

    /** Column name DateValue */
    public static final String COLUMNNAME_DateValue = "DateValue";

	/** Set Valuation Date.
	  * Date of valuation
	  */
	public void setDateValue (Timestamp DateValue);

	/** Get Valuation Date.
	  * Date of valuation
	  */
	public Timestamp getDateValue();

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

    /** Column name Destination */
    public static final String COLUMNNAME_Destination = "Destination";

	/** Set Destination.
	  * Destino
	  */
	public void setDestination (String Destination);

	/** Get Destination.
	  * Destino
	  */
	public String getDestination();

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

    /** Column name IsDelivered */
    public static final String COLUMNNAME_IsDelivered = "IsDelivered";

	/** Set Delivered	  */
	public void setIsDelivered (boolean IsDelivered);

	/** Get Delivered	  */
	public boolean isDelivered();

    /** Column name IsOther */
    public static final String COLUMNNAME_IsOther = "IsOther";

	/** Set IsOther.
	  * Es Otro
	  */
	public void setIsOther (boolean IsOther);

	/** Get IsOther.
	  * Es Otro
	  */
	public boolean isOther();

    /** Column name IsRev */
    public static final String COLUMNNAME_IsRev = "IsRev";

	/** Set IsRev	  */
	public void setIsRev (boolean IsRev);

	/** Get IsRev	  */
	public boolean isRev();

    /** Column name IsSampleSupplier */
    public static final String COLUMNNAME_IsSampleSupplier = "IsSampleSupplier";

	/** Set IsSampleSupplier.
	  * Muestra de Proveedor
	  */
	public void setIsSampleSupplier (boolean IsSampleSupplier);

	/** Get IsSampleSupplier.
	  * Muestra de Proveedor
	  */
	public boolean isSampleSupplier();

    /** Column name IsStocked */
    public static final String COLUMNNAME_IsStocked = "IsStocked";

	/** Set Stocked.
	  * Organization stocks this product
	  */
	public void setIsStocked (boolean IsStocked);

	/** Get Stocked.
	  * Organization stocks this product
	  */
	public boolean isStocked();

    /** Column name IsWarehouse */
    public static final String COLUMNNAME_IsWarehouse = "IsWarehouse";

	/** Set IsWarehouse.
	  * Almacen
	  */
	public void setIsWarehouse (boolean IsWarehouse);

	/** Get IsWarehouse.
	  * Almacen
	  */
	public boolean isWarehouse();

    /** Column name List_Origin */
    public static final String COLUMNNAME_List_Origin = "List_Origin";

	/** Set List_Origin	  */
	public void setList_Origin (String List_Origin);

	/** Get List_Origin	  */
	public String getList_Origin();

    /** Column name M_Lab_ID */
    public static final String COLUMNNAME_M_Lab_ID = "M_Lab_ID";

	/** Set M_Lab	  */
	public void setM_Lab_ID (int M_Lab_ID);

	/** Get M_Lab	  */
	public int getM_Lab_ID();

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

    /** Column name Origin */
    public static final String COLUMNNAME_Origin = "Origin";

	/** Set Origin.
	  * Origen
	  */
	public void setOrigin (String Origin);

	/** Get Origin.
	  * Origen
	  */
	public String getOrigin();

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

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

    /** Column name Volume */
    public static final String COLUMNNAME_Volume = "Volume";

	/** Set Volume.
	  * Volume of a product
	  */
	public void setVolume (String Volume);

	/** Get Volume.
	  * Volume of a product
	  */
	public String getVolume();
}
