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

/** Generated Interface for M_AdjustmentLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_M_AdjustmentLine 
{

    /** TableName=M_AdjustmentLine */
    public static final String Table_Name = "M_AdjustmentLine";

    /** AD_Table_ID=1000285 */
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

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException;

    /** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";

	/** Set Account Element.
	  * Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID);

	/** Get Account Element.
	  * Account Element
	  */
	public int getC_ElementValue_ID();

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException;

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

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException;

    /** Column name C_ProjectLine_ID */
    public static final String COLUMNNAME_C_ProjectLine_ID = "C_ProjectLine_ID";

	/** Set Project Line.
	  * Task or step in a project
	  */
	public void setC_ProjectLine_ID (int C_ProjectLine_ID);

	/** Get Project Line.
	  * Task or step in a project
	  */
	public int getC_ProjectLine_ID();

	public org.compiere.model.I_C_ProjectLine getC_ProjectLine() throws RuntimeException;

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

    /** Column name M_Adjustment_ID */
    public static final String COLUMNNAME_M_Adjustment_ID = "M_Adjustment_ID";

	/** Set M_Adjustment	  */
	public void setM_Adjustment_ID (int M_Adjustment_ID);

	/** Get M_Adjustment	  */
	public int getM_Adjustment_ID();

	public org.pentanet.model.I_M_Adjustment getM_Adjustment() throws RuntimeException;

    /** Column name M_AdjustmentLine_ID */
    public static final String COLUMNNAME_M_AdjustmentLine_ID = "M_AdjustmentLine_ID";

	/** Set M_AdjustmentLine	  */
	public void setM_AdjustmentLine_ID (int M_AdjustmentLine_ID);

	/** Get M_AdjustmentLine	  */
	public int getM_AdjustmentLine_ID();

    /** Column name Part_Code */
    public static final String COLUMNNAME_Part_Code = "Part_Code";

	/** Set Part_Code	  */
	public void setPart_Code (String Part_Code);

	/** Get Part_Code	  */
	public String getPart_Code();

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

    /** Column name QtyDif */
    public static final String COLUMNNAME_QtyDif = "QtyDif";

	/** Set QtyDif	  */
	public void setQtyDif (BigDecimal QtyDif);

	/** Get QtyDif	  */
	public BigDecimal getQtyDif();

    /** Column name QtyR */
    public static final String COLUMNNAME_QtyR = "QtyR";

	/** Set QtyR	  */
	public void setQtyR (BigDecimal QtyR);

	/** Get QtyR	  */
	public BigDecimal getQtyR();

    /** Column name QtyT */
    public static final String COLUMNNAME_QtyT = "QtyT";

	/** Set QtyT	  */
	public void setQtyT (BigDecimal QtyT);

	/** Get QtyT	  */
	public BigDecimal getQtyT();

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
