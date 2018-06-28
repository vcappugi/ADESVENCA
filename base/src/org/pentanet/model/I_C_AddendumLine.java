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

/** Generated Interface for C_AddendumLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_AddendumLine 
{

    /** TableName=C_AddendumLine */
    public static final String Table_Name = "C_AddendumLine";

    /** AD_Table_ID=1000311 */
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

    /** Column name C_AddendumLine_ID */
    public static final String COLUMNNAME_C_AddendumLine_ID = "C_AddendumLine_ID";

	/** Set C_AddendumLine	  */
	public void setC_AddendumLine_ID (int C_AddendumLine_ID);

	/** Get C_AddendumLine	  */
	public int getC_AddendumLine_ID();

    /** Column name C_AddendumType_ID */
    public static final String COLUMNNAME_C_AddendumType_ID = "C_AddendumType_ID";

	/** Set C_AddendumType	  */
	public void setC_AddendumType_ID (int C_AddendumType_ID);

	/** Get C_AddendumType	  */
	public int getC_AddendumType_ID();

	public org.pentanet.model.I_C_AddendumType getC_AddendumType() throws RuntimeException;

    /** Column name C_Contract_ID */
    public static final String COLUMNNAME_C_Contract_ID = "C_Contract_ID";

	/** Set C_Contract	  */
	public void setC_Contract_ID (int C_Contract_ID);

	/** Get C_Contract	  */
	public int getC_Contract_ID();

	public org.pentanet.model.I_C_Contract getC_Contract() throws RuntimeException;

    /** Column name C_ContractLine_ID */
    public static final String COLUMNNAME_C_ContractLine_ID = "C_ContractLine_ID";

	/** Set C_ContractLine	  */
	public void setC_ContractLine_ID (int C_ContractLine_ID);

	/** Get C_ContractLine	  */
	public int getC_ContractLine_ID();

	public org.pentanet.model.I_C_ContractLine getC_ContractLine() throws RuntimeException;

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

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;

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

    /** Column name LineNetAmt */
    public static final String COLUMNNAME_LineNetAmt = "LineNetAmt";

	/** Set Line Amount.
	  * Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public void setLineNetAmt (BigDecimal LineNetAmt);

	/** Get Line Amount.
	  * Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public BigDecimal getLineNetAmt();

    /** Column name LineNetAmt_Pure */
    public static final String COLUMNNAME_LineNetAmt_Pure = "LineNetAmt_Pure";

	/** Set Line Amount Pure	  */
	public void setLineNetAmt_Pure (BigDecimal LineNetAmt_Pure);

	/** Get Line Amount Pure	  */
	public BigDecimal getLineNetAmt_Pure();

    /** Column name LineNetAmt_Usd */
    public static final String COLUMNNAME_LineNetAmt_Usd = "LineNetAmt_Usd";

	/** Set Line Amount USD	  */
	public void setLineNetAmt_Usd (BigDecimal LineNetAmt_Usd);

	/** Get Line Amount USD	  */
	public BigDecimal getLineNetAmt_Usd();

    /** Column name MoveRate */
    public static final String COLUMNNAME_MoveRate = "MoveRate";

	/** Set MoveRate	  */
	public void setMoveRate (BigDecimal MoveRate);

	/** Get MoveRate	  */
	public BigDecimal getMoveRate();

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

    /** Column name Price */
    public static final String COLUMNNAME_Price = "Price";

	/** Set Price.
	  * Price
	  */
	public void setPrice (BigDecimal Price);

	/** Get Price.
	  * Price
	  */
	public BigDecimal getPrice();

    /** Column name Price_Pure */
    public static final String COLUMNNAME_Price_Pure = "Price_Pure";

	/** Set Price_Pure	  */
	public void setPrice_Pure (BigDecimal Price_Pure);

	/** Get Price_Pure	  */
	public BigDecimal getPrice_Pure();

    /** Column name Price_Usd */
    public static final String COLUMNNAME_Price_Usd = "Price_Usd";

	/** Set Price_Usd	  */
	public void setPrice_Usd (BigDecimal Price_Usd);

	/** Get Price_Usd	  */
	public BigDecimal getPrice_Usd();

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

    /** Column name QtyPreinvoiced */
    public static final String COLUMNNAME_QtyPreinvoiced = "QtyPreinvoiced";

	/** Set QtyPreinvoiced	  */
	public void setQtyPreinvoiced (BigDecimal QtyPreinvoiced);

	/** Get QtyPreinvoiced	  */
	public BigDecimal getQtyPreinvoiced();

    /** Column name ReducedRate */
    public static final String COLUMNNAME_ReducedRate = "ReducedRate";

	/** Set ReducedRate	  */
	public void setReducedRate (BigDecimal ReducedRate);

	/** Get ReducedRate	  */
	public BigDecimal getReducedRate();

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
