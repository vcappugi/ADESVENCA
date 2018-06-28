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
/** Generated Model - DO NOT CHANGE */
package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for LCO_Comprobant
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_LCO_Comprobant extends PO implements I_LCO_Comprobant, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131212L;

    /** Standard Constructor */
    public X_LCO_Comprobant (Properties ctx, int LCO_Comprobant_ID, String trxName)
    {
      super (ctx, LCO_Comprobant_ID, trxName);
      /** if (LCO_Comprobant_ID == 0)
        {
			setC_Invoice_ID (0);
			setLCO_Comprobant_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_LCO_Comprobant (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LCO_Comprobant[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Alicuota.
		@param Alicuota Alicuota	  */
	public void setAlicuota (String Alicuota)
	{
		set_Value (COLUMNNAME_Alicuota, Alicuota);
	}

	/** Get Alicuota.
		@return Alicuota	  */
	public String getAlicuota () 
	{
		return (String)get_Value(COLUMNNAME_Alicuota);
	}

	/** Set Base_Imponible.
		@param Base_Imponible Base_Imponible	  */
	public void setBase_Imponible (BigDecimal Base_Imponible)
	{
		set_Value (COLUMNNAME_Base_Imponible, Base_Imponible);
	}

	/** Get Base_Imponible.
		@return Base_Imponible	  */
	public BigDecimal getBase_Imponible () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Base_Imponible);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set C_BPartner_ID.
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get C_BPartner_ID.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_Payment_ID(), get_TrxName());	}

	/** Set Payment.
		@param C_Payment_ID 
		Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID)
	{
		if (C_Payment_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
	}

	/** Get Payment.
		@return Payment identifier
	  */
	public int getC_Payment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Comment/Help.
		@param Help 
		Comment or Hint
	  */
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp () 
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Impuesto_Iva.
		@param Impuesto_Iva Impuesto_Iva	  */
	public void setImpuesto_Iva (BigDecimal Impuesto_Iva)
	{
		set_Value (COLUMNNAME_Impuesto_Iva, Impuesto_Iva);
	}

	/** Get Impuesto_Iva.
		@return Impuesto_Iva	  */
	public BigDecimal getImpuesto_Iva () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Impuesto_Iva);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Iva_Retenido.
		@param Iva_Retenido Iva_Retenido	  */
	public void setIva_Retenido (BigDecimal Iva_Retenido)
	{
		set_Value (COLUMNNAME_Iva_Retenido, Iva_Retenido);
	}

	/** Get Iva_Retenido.
		@return Iva_Retenido	  */
	public BigDecimal getIva_Retenido () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Iva_Retenido);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set LCO_Comprobant.
		@param LCO_Comprobant_ID LCO_Comprobant	  */
	public void setLCO_Comprobant_ID (int LCO_Comprobant_ID)
	{
		if (LCO_Comprobant_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_Comprobant_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_Comprobant_ID, Integer.valueOf(LCO_Comprobant_ID));
	}

	/** Get LCO_Comprobant.
		@return LCO_Comprobant	  */
	public int getLCO_Comprobant_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_Comprobant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.globalqss.model.I_LCO_InvoiceWithholding getLCO_InvoiceWithholding() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_InvoiceWithholding)MTable.get(getCtx(), org.globalqss.model.I_LCO_InvoiceWithholding.Table_Name)
			.getPO(getLCO_InvoiceWithholding_ID(), get_TrxName());	}

	/** Set Invoice Withholding.
		@param LCO_InvoiceWithholding_ID Invoice Withholding	  */
	public void setLCO_InvoiceWithholding_ID (int LCO_InvoiceWithholding_ID)
	{
		if (LCO_InvoiceWithholding_ID < 1) 
			set_Value (COLUMNNAME_LCO_InvoiceWithholding_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_InvoiceWithholding_ID, Integer.valueOf(LCO_InvoiceWithholding_ID));
	}

	/** Get Invoice Withholding.
		@return Invoice Withholding	  */
	public int getLCO_InvoiceWithholding_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_InvoiceWithholding_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Monto_Exento.
		@param Monto_Exento Monto_Exento	  */
	public void setMonto_Exento (BigDecimal Monto_Exento)
	{
		set_Value (COLUMNNAME_Monto_Exento, Monto_Exento);
	}

	/** Get Monto_Exento.
		@return Monto_Exento	  */
	public BigDecimal getMonto_Exento () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Monto_Exento);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Monto_mas_IVA.
		@param Monto_mas_IVA Monto_mas_IVA	  */
	public void setMonto_mas_IVA (BigDecimal Monto_mas_IVA)
	{
		set_Value (COLUMNNAME_Monto_mas_IVA, Monto_mas_IVA);
	}

	/** Get Monto_mas_IVA.
		@return Monto_mas_IVA	  */
	public BigDecimal getMonto_mas_IVA () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Monto_mas_IVA);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set num_comprobante.
		@param num_comprobante num_comprobante	  */
	public void setnum_comprobante (String num_comprobante)
	{
		set_Value (COLUMNNAME_num_comprobante, num_comprobante);
	}

	/** Get num_comprobante.
		@return num_comprobante	  */
	public String getnum_comprobante () 
	{
		return (String)get_Value(COLUMNNAME_num_comprobante);
	}

	/** Set Payment amount.
		@param PayAmt 
		Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt)
	{
		set_Value (COLUMNNAME_PayAmt, PayAmt);
	}

	/** Get Payment amount.
		@return Amount being paid
	  */
	public BigDecimal getPayAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PayAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Porcentaje_Retenido.
		@param Porcentaje_Retenido Porcentaje_Retenido	  */
	public void setPorcentaje_Retenido (String Porcentaje_Retenido)
	{
		set_Value (COLUMNNAME_Porcentaje_Retenido, Porcentaje_Retenido);
	}

	/** Get Porcentaje_Retenido.
		@return Porcentaje_Retenido	  */
	public String getPorcentaje_Retenido () 
	{
		return (String)get_Value(COLUMNNAME_Porcentaje_Retenido);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}