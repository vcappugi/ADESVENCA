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

/** Generated Interface for H_Asigned_Budget_Line
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_H_Asigned_Budget_Line 
{

    /** TableName=H_Asigned_Budget_Line */
    public static final String Table_Name = "H_Asigned_Budget_Line";

    /** AD_Table_ID=1000034 */
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

    /** Column name H_Asigned_Budget_ID */
    public static final String COLUMNNAME_H_Asigned_Budget_ID = "H_Asigned_Budget_ID";

	/** Set H_Asigned_Budget	  */
	public void setH_Asigned_Budget_ID (int H_Asigned_Budget_ID);

	/** Get H_Asigned_Budget	  */
	public int getH_Asigned_Budget_ID();

	public org.pentanet.model.I_H_Asigned_Budget getH_Asigned_Budget() throws RuntimeException;

    /** Column name H_Asigned_Budget_Line_ID */
    public static final String COLUMNNAME_H_Asigned_Budget_Line_ID = "H_Asigned_Budget_Line_ID";

	/** Set H_Asigned_Budget_Line	  */
	public void setH_Asigned_Budget_Line_ID (int H_Asigned_Budget_Line_ID);

	/** Get H_Asigned_Budget_Line	  */
	public int getH_Asigned_Budget_Line_ID();

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
	
    /** Column name PriceList */	
    public static final String COLUMNNAME_PriceList = "PriceList";

	/** Set List Price.
	  * List Price
	  */
	public void setPriceList (BigDecimal PriceList);

	/** Get List Price.
	  * List Price
	  */
	public BigDecimal getPriceList();
	
	
	//Agregado por Vladimir Mata 30-01-2012
		/** Column name PriceEntered */
	    public static final String COLUMNNAME_PriceEntered = "PriceEntered";

		/** Set Price.
		  * Price Entered - the price based on the selected/base UoM
		  */
		public void setPriceEntered (BigDecimal PriceEntered);

		/** Get Price.
		  * Price Entered - the price based on the selected/base UoM
		  */
		public BigDecimal getPriceEntered();
		
		/** Column name PriceActual */
	    public static final String COLUMNNAME_PriceActual = "PriceActual";

		/** Set Unit Price.
		  * Actual Price 
		  */
		public void setPriceActual (BigDecimal PriceActual);

		/** Get Unit Price.
		  * Actual Price 
		  */
		public BigDecimal getPriceActual();
		
		/** Column name LineTotalAmt */
	    public static final String COLUMNNAME_LineTotalAmt = "LineTotalAmt";

		/** Set Line Total.
		  * Total line amount incl. Tax
		  */
		public void setLineTotalAmt (BigDecimal LineTotalAmt);

		/** Get Line Total.
		  * Total line amount incl. Tax
		  */
		public BigDecimal getLineTotalAmt();
		
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
		
		/** Column name TaxAmt */
	    public static final String COLUMNNAME_TaxAmt = "TaxAmt";

		/** Set Tax Amount.
		  * Tax Amount for a document
		  */
		public void setTaxAmt (BigDecimal TaxAmt);

		/** Get Tax Amount.
		  * Tax Amount for a document
		  */
		public BigDecimal getTaxAmt();
		
		/** Column name C_Tax_ID */
	    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";

		/** Set Tax.
		  * Tax identifier
		  */
		public void setC_Tax_ID (int C_Tax_ID);

		/** Get Tax.
		  * Tax identifier
		  */
		public int getC_Tax_ID();

		public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException;

		
		
		
		
		
		
		public static final String COLUMNNAME_QtyBudgeted = "QtyBudgeted";

		/** Set Quantity Budgeted.
		  * Budgeted Quantity
		  */
		public void setQtyBudgeted (BigDecimal QtyBudgeted);

		/** Get Quantity Budgeted.
		  * Budgeted Quantity
		  */
		public BigDecimal getQtyBudgeted();
}
