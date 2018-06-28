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

/** Generated Interface for LCO_Comprobant
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_LCO_Comprobant 
{

    /** TableName=LCO_Comprobant */
    public static final String Table_Name = "LCO_Comprobant";

    /** AD_Table_ID=1000157 */
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

    /** Column name Alicuota */
    public static final String COLUMNNAME_Alicuota = "Alicuota";

	/** Set Alicuota	  */
	public void setAlicuota (String Alicuota);

	/** Get Alicuota	  */
	public String getAlicuota();

    /** Column name Base_Imponible */
    public static final String COLUMNNAME_Base_Imponible = "Base_Imponible";

	/** Set Base_Imponible	  */
	public void setBase_Imponible (BigDecimal Base_Imponible);

	/** Get Base_Imponible	  */
	public BigDecimal getBase_Imponible();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set C_BPartner_ID.
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get C_BPartner_ID.
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException;

    /** Column name C_Payment_ID */
    public static final String COLUMNNAME_C_Payment_ID = "C_Payment_ID";

	/** Set Payment.
	  * Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID);

	/** Get Payment.
	  * Payment identifier
	  */
	public int getC_Payment_ID();

	public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException;

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

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

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

    /** Column name Impuesto_Iva */
    public static final String COLUMNNAME_Impuesto_Iva = "Impuesto_Iva";

	/** Set Impuesto_Iva	  */
	public void setImpuesto_Iva (BigDecimal Impuesto_Iva);

	/** Get Impuesto_Iva	  */
	public BigDecimal getImpuesto_Iva();

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

    /** Column name Iva_Retenido */
    public static final String COLUMNNAME_Iva_Retenido = "Iva_Retenido";

	/** Set Iva_Retenido	  */
	public void setIva_Retenido (BigDecimal Iva_Retenido);

	/** Get Iva_Retenido	  */
	public BigDecimal getIva_Retenido();

    /** Column name LCO_Comprobant_ID */
    public static final String COLUMNNAME_LCO_Comprobant_ID = "LCO_Comprobant_ID";

	/** Set LCO_Comprobant	  */
	public void setLCO_Comprobant_ID (int LCO_Comprobant_ID);

	/** Get LCO_Comprobant	  */
	public int getLCO_Comprobant_ID();

    /** Column name LCO_InvoiceWithholding_ID */
    public static final String COLUMNNAME_LCO_InvoiceWithholding_ID = "LCO_InvoiceWithholding_ID";

	/** Set Invoice Withholding	  */
	public void setLCO_InvoiceWithholding_ID (int LCO_InvoiceWithholding_ID);

	/** Get Invoice Withholding	  */
	public int getLCO_InvoiceWithholding_ID();

	public org.globalqss.model.I_LCO_InvoiceWithholding getLCO_InvoiceWithholding() throws RuntimeException;

    /** Column name Monto_Exento */
    public static final String COLUMNNAME_Monto_Exento = "Monto_Exento";

	/** Set Monto_Exento	  */
	public void setMonto_Exento (BigDecimal Monto_Exento);

	/** Get Monto_Exento	  */
	public BigDecimal getMonto_Exento();

    /** Column name Monto_mas_IVA */
    public static final String COLUMNNAME_Monto_mas_IVA = "Monto_mas_IVA";

	/** Set Monto_mas_IVA	  */
	public void setMonto_mas_IVA (BigDecimal Monto_mas_IVA);

	/** Get Monto_mas_IVA	  */
	public BigDecimal getMonto_mas_IVA();

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

    /** Column name num_comprobante */
    public static final String COLUMNNAME_num_comprobante = "num_comprobante";

	/** Set num_comprobante	  */
	public void setnum_comprobante (String num_comprobante);

	/** Get num_comprobante	  */
	public String getnum_comprobante();

    /** Column name PayAmt */
    public static final String COLUMNNAME_PayAmt = "PayAmt";

	/** Set Payment amount.
	  * Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt);

	/** Get Payment amount.
	  * Amount being paid
	  */
	public BigDecimal getPayAmt();

    /** Column name Porcentaje_Retenido */
    public static final String COLUMNNAME_Porcentaje_Retenido = "Porcentaje_Retenido";

	/** Set Porcentaje_Retenido	  */
	public void setPorcentaje_Retenido (String Porcentaje_Retenido);

	/** Get Porcentaje_Retenido	  */
	public String getPorcentaje_Retenido();

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
