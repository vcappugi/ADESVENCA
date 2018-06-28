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

/** Generated Interface for C_WorkDDLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_WorkDDLine 
{

    /** TableName=C_WorkDDLine */
    public static final String Table_Name = "C_WorkDDLine";

    /** AD_Table_ID=1000307 */
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

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException;

    /** Column name C_ContractLine_ID */
    public static final String COLUMNNAME_C_ContractLine_ID = "C_ContractLine_ID";

	/** Set C_ContractLine	  */
	public void setC_ContractLine_ID (int C_ContractLine_ID);

	/** Get C_ContractLine	  */
	public int getC_ContractLine_ID();

	public org.pentanet.model.I_C_ContractLine getC_ContractLine() throws RuntimeException;

    /** Column name C_Phase_ID */
    public static final String COLUMNNAME_C_Phase_ID = "C_Phase_ID";

	/** Set Standard Phase.
	  * Standard Phase of the Project Type
	  */
	public void setC_Phase_ID (int C_Phase_ID);

	/** Get Standard Phase.
	  * Standard Phase of the Project Type
	  */
	public int getC_Phase_ID();

	public org.compiere.model.I_C_Phase getC_Phase() throws RuntimeException;

    /** Column name C_PreInvoiceLineG_ID */
    public static final String COLUMNNAME_C_PreInvoiceLineG_ID = "C_PreInvoiceLineG_ID";

	/** Set PreInvoice Global Line	  */
	public void setC_PreInvoiceLineG_ID (int C_PreInvoiceLineG_ID);

	/** Get PreInvoice Global Line	  */
	public int getC_PreInvoiceLineG_ID();

	public org.pentanet.model.I_C_PreInvoiceLineG getC_PreInvoiceLineG() throws RuntimeException;

    /** Column name C_PreInvoiceLine_ID */
    public static final String COLUMNNAME_C_PreInvoiceLine_ID = "C_PreInvoiceLine_ID";

	/** Set PreInvoice Line	  */
	public void setC_PreInvoiceLine_ID (int C_PreInvoiceLine_ID);

	/** Get PreInvoice Line	  */
	public int getC_PreInvoiceLine_ID();

	public org.pentanet.model.I_C_PreInvoiceLine getC_PreInvoiceLine() throws RuntimeException;

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

    /** Column name C_WorkDD_ID */
    public static final String COLUMNNAME_C_WorkDD_ID = "C_WorkDD_ID";

	/** Set Day to Day Work	  */
	public void setC_WorkDD_ID (int C_WorkDD_ID);

	/** Get Day to Day Work	  */
	public int getC_WorkDD_ID();

	public org.pentanet.model.I_C_WorkDD getC_WorkDD() throws RuntimeException;

    /** Column name C_WorkDDLine_ID */
    public static final String COLUMNNAME_C_WorkDDLine_ID = "C_WorkDDLine_ID";

	/** Set Day to Day Work Line	  */
	public void setC_WorkDDLine_ID (int C_WorkDDLine_ID);

	/** Get Day to Day Work Line	  */
	public int getC_WorkDDLine_ID();

    /** Column name Hours */
    public static final String COLUMNNAME_Hours = "Hours";

	/** Set Hours	  */
	public void setHours (BigDecimal Hours);

	/** Get Hours	  */
	public BigDecimal getHours();

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

    /** Column name IsCalculated */
    public static final String COLUMNNAME_IsCalculated = "IsCalculated";

	/** Set Calculated.
	  * The value is calculated by the system
	  */
	public void setIsCalculated (boolean IsCalculated);

	/** Get Calculated.
	  * The value is calculated by the system
	  */
	public boolean isCalculated();

    /** Column name IsWorkingHours */
    public static final String COLUMNNAME_IsWorkingHours = "IsWorkingHours";

	/** Set IsWorkingHours	  */
	public void setIsWorkingHours (boolean IsWorkingHours);

	/** Get IsWorkingHours	  */
	public boolean isWorkingHours();

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

    /** Column name QtyEquipment */
    public static final String COLUMNNAME_QtyEquipment = "QtyEquipment";

	/** Set QtyEquipment	  */
	public void setQtyEquipment (BigDecimal QtyEquipment);

	/** Get QtyEquipment	  */
	public BigDecimal getQtyEquipment();

    /** Column name QtyHoursForDay */
    public static final String COLUMNNAME_QtyHoursForDay = "QtyHoursForDay";

	/** Set QtyHoursForDay	  */
	public void setQtyHoursForDay (BigDecimal QtyHoursForDay);

	/** Get QtyHoursForDay	  */
	public BigDecimal getQtyHoursForDay();

    /** Column name Recalculate */
    public static final String COLUMNNAME_Recalculate = "Recalculate";

	/** Set Recalculate	  */
	public void setRecalculate (String Recalculate);

	/** Get Recalculate	  */
	public String getRecalculate();

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