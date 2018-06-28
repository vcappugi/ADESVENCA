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

/** Generated Interface for C_InvoiceReturn
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE)
 */
public interface I_C_InvoiceReturn 
{

    /** TableName=C_InvoiceReturn */
    public static final String Table_Name = "C_InvoiceReturn";

    /** AD_Table_ID=1000319 */
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

    /** Column name AD_User_Gest_ID */
    public static final String COLUMNNAME_AD_User_Gest_ID = "AD_User_Gest_ID";

	/** Set AD_User_Gest_ID	  */
	public void setAD_User_Gest_ID (int AD_User_Gest_ID);

	/** Get AD_User_Gest_ID	  */
	public int getAD_User_Gest_ID();

	public org.compiere.model.I_AD_User getAD_User_Gest() throws RuntimeException;

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

    /** Column name C_InvoiceReturn_ID */
    public static final String COLUMNNAME_C_InvoiceReturn_ID = "C_InvoiceReturn_ID";

	/** Set C_InvoiceReturn	  */
	public void setC_InvoiceReturn_ID (int C_InvoiceReturn_ID);

	/** Get C_InvoiceReturn	  */
	public int getC_InvoiceReturn_ID();

    /** Column name Comments */
    public static final String COLUMNNAME_Comments = "Comments";

	/** Set Comments.
	  * Comments or additional information
	  */
	public void setComments (String Comments);

	/** Get Comments.
	  * Comments or additional information
	  */
	public String getComments();

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

    /** Column name DateEnd1 */
    public static final String COLUMNNAME_DateEnd1 = "DateEnd1";

	/** Set DateEnd1	  */
	public void setDateEnd1 (Timestamp DateEnd1);

	/** Get DateEnd1	  */
	public Timestamp getDateEnd1();

    /** Column name DateEnd2 */
    public static final String COLUMNNAME_DateEnd2 = "DateEnd2";

	/** Set DateEnd2	  */
	public void setDateEnd2 (Timestamp DateEnd2);

	/** Get DateEnd2	  */
	public Timestamp getDateEnd2();

    /** Column name DateStart */
    public static final String COLUMNNAME_DateStart = "DateStart";

	/** Set Date Start.
	  * Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart);

	/** Get Date Start.
	  * Date Start for this Order
	  */
	public Timestamp getDateStart();

    /** Column name email1 */
    public static final String COLUMNNAME_email1 = "email1";

	/** Set email1	  */
	public void setemail1 (String email1);

	/** Get email1	  */
	public String getemail1();

    /** Column name EMail2 */
    public static final String COLUMNNAME_EMail2 = "EMail2";

	/** Set EMail2	  */
	public void setEMail2 (String EMail2);

	/** Get EMail2	  */
	public String getEMail2();

    /** Column name fecha_f */
    public static final String COLUMNNAME_fecha_f = "fecha_f";

	/** Set fecha_f	  */
	public void setfecha_f (Timestamp fecha_f);

	/** Get fecha_f	  */
	public Timestamp getfecha_f();

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

    /** Column name IsDifPO */
    public static final String COLUMNNAME_IsDifPO = "IsDifPO";

	/** Set IsDifPO	  */
	public void setIsDifPO (boolean IsDifPO);

	/** Get IsDifPO	  */
	public boolean isDifPO();

    /** Column name IsErrorEnmi */
    public static final String COLUMNNAME_IsErrorEnmi = "IsErrorEnmi";

	/** Set IsErrorEnmi	  */
	public void setIsErrorEnmi (boolean IsErrorEnmi);

	/** Get IsErrorEnmi	  */
	public boolean isErrorEnmi();

    /** Column name IsErrorFiscal */
    public static final String COLUMNNAME_IsErrorFiscal = "IsErrorFiscal";

	/** Set IsErrorFiscal	  */
	public void setIsErrorFiscal (boolean IsErrorFiscal);

	/** Get IsErrorFiscal	  */
	public boolean isErrorFiscal();

    /** Column name IsErrorImp */
    public static final String COLUMNNAME_IsErrorImp = "IsErrorImp";

	/** Set IsErrorImp	  */
	public void setIsErrorImp (boolean IsErrorImp);

	/** Get IsErrorImp	  */
	public boolean isErrorImp();

    /** Column name IsErrorIva */
    public static final String COLUMNNAME_IsErrorIva = "IsErrorIva";

	/** Set IsErrorIva	  */
	public void setIsErrorIva (boolean IsErrorIva);

	/** Get IsErrorIva	  */
	public boolean isErrorIva();

    /** Column name IsErrorRif */
    public static final String COLUMNNAME_IsErrorRif = "IsErrorRif";

	/** Set IsErrorRif	  */
	public void setIsErrorRif (boolean IsErrorRif);

	/** Get IsErrorRif	  */
	public boolean isErrorRif();

    /** Column name IsFailNE */
    public static final String COLUMNNAME_IsFailNE = "IsFailNE";

	/** Set IsFailNE	  */
	public void setIsFailNE (boolean IsFailNE);

	/** Get IsFailNE	  */
	public boolean isFailNE();

    /** Column name IsFailPO */
    public static final String COLUMNNAME_IsFailPO = "IsFailPO";

	/** Set IsFailPO	  */
	public void setIsFailPO (boolean IsFailPO);

	/** Get IsFailPO	  */
	public boolean isFailPO();

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

    /** Column name IsSent */
    public static final String COLUMNNAME_IsSent = "IsSent";

	/** Set IsSent	  */
	public void setIsSent (boolean IsSent);

	/** Get IsSent	  */
	public boolean isSent();

    /** Column name num_control */
    public static final String COLUMNNAME_num_control = "num_control";

	/** Set num_control	  */
	public void setnum_control (String num_control);

	/** Get num_control	  */
	public String getnum_control();

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

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name SendEMail */
    public static final String COLUMNNAME_SendEMail = "SendEMail";

	/** Set Send EMail.
	  * Enable sending Document EMail
	  */
	public void setSendEMail (String SendEMail);

	/** Get Send EMail.
	  * Enable sending Document EMail
	  */
	public String getSendEMail();

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
