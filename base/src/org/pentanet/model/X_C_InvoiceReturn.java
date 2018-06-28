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

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for C_InvoiceReturn
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_InvoiceReturn extends PO implements I_C_InvoiceReturn, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160915L;

    /** Standard Constructor */
    public X_C_InvoiceReturn (Properties ctx, int C_InvoiceReturn_ID, String trxName)
    {
      super (ctx, C_InvoiceReturn_ID, trxName);
      /** if (C_InvoiceReturn_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_InvoiceReturn_ID (0);
			setDateStart (new Timestamp( System.currentTimeMillis() ));
			setfecha_f (new Timestamp( System.currentTimeMillis() ));
			setnum_factura (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_InvoiceReturn (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_InvoiceReturn[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User_Gest() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_Gest_ID(), get_TrxName());	}

	/** Set AD_User_Gest_ID.
		@param AD_User_Gest_ID AD_User_Gest_ID	  */
	public void setAD_User_Gest_ID (int AD_User_Gest_ID)
	{
		if (AD_User_Gest_ID < 1) 
			set_Value (COLUMNNAME_AD_User_Gest_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_Gest_ID, Integer.valueOf(AD_User_Gest_ID));
	}

	/** Get AD_User_Gest_ID.
		@return AD_User_Gest_ID	  */
	public int getAD_User_Gest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_Gest_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Usuario.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get Usuario.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
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

	/** Get Business Partner .
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

	/** Set C_InvoiceReturn.
		@param C_InvoiceReturn_ID C_InvoiceReturn	  */
	public void setC_InvoiceReturn_ID (int C_InvoiceReturn_ID)
	{
		if (C_InvoiceReturn_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_InvoiceReturn_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_InvoiceReturn_ID, Integer.valueOf(C_InvoiceReturn_ID));
	}

	/** Get C_InvoiceReturn.
		@return C_InvoiceReturn	  */
	public int getC_InvoiceReturn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_InvoiceReturn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Comments.
		@param Comments 
		Comments or additional information
	  */
	public void setComments (String Comments)
	{
		set_Value (COLUMNNAME_Comments, Comments);
	}

	/** Get Comments.
		@return Comments or additional information
	  */
	public String getComments () 
	{
		return (String)get_Value(COLUMNNAME_Comments);
	}

	/** Set DateEnd.
		@param DateEnd DateEnd	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get DateEnd.
		@return DateEnd	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set DateEnd1.
		@param DateEnd1 DateEnd1	  */
	public void setDateEnd1 (Timestamp DateEnd1)
	{
		set_Value (COLUMNNAME_DateEnd1, DateEnd1);
	}

	/** Get DateEnd1.
		@return DateEnd1	  */
	public Timestamp getDateEnd1 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd1);
	}

	/** Set DateEnd2.
		@param DateEnd2 DateEnd2	  */
	public void setDateEnd2 (Timestamp DateEnd2)
	{
		set_Value (COLUMNNAME_DateEnd2, DateEnd2);
	}

	/** Get DateEnd2.
		@return DateEnd2	  */
	public Timestamp getDateEnd2 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd2);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		set_Value (COLUMNNAME_DateStart, DateStart);
	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
	}

	/** Set email1.
		@param email1 email1	  */
	public void setemail1 (String email1)
	{
		throw new IllegalArgumentException ("email1 is virtual column");	}

	/** Get email1.
		@return email1	  */
	public String getemail1 () 
	{
		return (String)get_Value(COLUMNNAME_email1);
	}

	/** Set EMail2.
		@param EMail2 EMail2	  */
	public void setEMail2 (String EMail2)
	{
		set_Value (COLUMNNAME_EMail2, EMail2);
	}

	/** Get EMail2.
		@return EMail2	  */
	public String getEMail2 () 
	{
		return (String)get_Value(COLUMNNAME_EMail2);
	}

	/** Set fecha_f.
		@param fecha_f fecha_f	  */
	public void setfecha_f (Timestamp fecha_f)
	{
		set_Value (COLUMNNAME_fecha_f, fecha_f);
	}

	/** Get fecha_f.
		@return fecha_f	  */
	public Timestamp getfecha_f () 
	{
		return (Timestamp)get_Value(COLUMNNAME_fecha_f);
	}

	/** Set IsDifPO.
		@param IsDifPO IsDifPO	  */
	public void setIsDifPO (boolean IsDifPO)
	{
		set_Value (COLUMNNAME_IsDifPO, Boolean.valueOf(IsDifPO));
	}

	/** Get IsDifPO.
		@return IsDifPO	  */
	public boolean isDifPO () 
	{
		Object oo = get_Value(COLUMNNAME_IsDifPO);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsErrorEnmi.
		@param IsErrorEnmi IsErrorEnmi	  */
	public void setIsErrorEnmi (boolean IsErrorEnmi)
	{
		set_Value (COLUMNNAME_IsErrorEnmi, Boolean.valueOf(IsErrorEnmi));
	}

	/** Get IsErrorEnmi.
		@return IsErrorEnmi	  */
	public boolean isErrorEnmi () 
	{
		Object oo = get_Value(COLUMNNAME_IsErrorEnmi);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsErrorFiscal.
		@param IsErrorFiscal IsErrorFiscal	  */
	public void setIsErrorFiscal (boolean IsErrorFiscal)
	{
		set_Value (COLUMNNAME_IsErrorFiscal, Boolean.valueOf(IsErrorFiscal));
	}

	/** Get IsErrorFiscal.
		@return IsErrorFiscal	  */
	public boolean isErrorFiscal () 
	{
		Object oo = get_Value(COLUMNNAME_IsErrorFiscal);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsErrorImp.
		@param IsErrorImp IsErrorImp	  */
	public void setIsErrorImp (boolean IsErrorImp)
	{
		set_Value (COLUMNNAME_IsErrorImp, Boolean.valueOf(IsErrorImp));
	}

	/** Get IsErrorImp.
		@return IsErrorImp	  */
	public boolean isErrorImp () 
	{
		Object oo = get_Value(COLUMNNAME_IsErrorImp);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsErrorIva.
		@param IsErrorIva IsErrorIva	  */
	public void setIsErrorIva (boolean IsErrorIva)
	{
		set_Value (COLUMNNAME_IsErrorIva, Boolean.valueOf(IsErrorIva));
	}

	/** Get IsErrorIva.
		@return IsErrorIva	  */
	public boolean isErrorIva () 
	{
		Object oo = get_Value(COLUMNNAME_IsErrorIva);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsErrorRif.
		@param IsErrorRif IsErrorRif	  */
	public void setIsErrorRif (boolean IsErrorRif)
	{
		set_Value (COLUMNNAME_IsErrorRif, Boolean.valueOf(IsErrorRif));
	}

	/** Get IsErrorRif.
		@return IsErrorRif	  */
	public boolean isErrorRif () 
	{
		Object oo = get_Value(COLUMNNAME_IsErrorRif);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsFailNE.
		@param IsFailNE IsFailNE	  */
	public void setIsFailNE (boolean IsFailNE)
	{
		set_Value (COLUMNNAME_IsFailNE, Boolean.valueOf(IsFailNE));
	}

	/** Get IsFailNE.
		@return IsFailNE	  */
	public boolean isFailNE () 
	{
		Object oo = get_Value(COLUMNNAME_IsFailNE);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsFailPO.
		@param IsFailPO IsFailPO	  */
	public void setIsFailPO (boolean IsFailPO)
	{
		set_Value (COLUMNNAME_IsFailPO, Boolean.valueOf(IsFailPO));
	}

	/** Get IsFailPO.
		@return IsFailPO	  */
	public boolean isFailPO () 
	{
		Object oo = get_Value(COLUMNNAME_IsFailPO);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsOther.
		@param IsOther 
		Es Otro
	  */
	public void setIsOther (boolean IsOther)
	{
		set_Value (COLUMNNAME_IsOther, Boolean.valueOf(IsOther));
	}

	/** Get IsOther.
		@return Es Otro
	  */
	public boolean isOther () 
	{
		Object oo = get_Value(COLUMNNAME_IsOther);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsSent.
		@param IsSent IsSent	  */
	public void setIsSent (boolean IsSent)
	{
		set_Value (COLUMNNAME_IsSent, Boolean.valueOf(IsSent));
	}

	/** Get IsSent.
		@return IsSent	  */
	public boolean isSent () 
	{
		Object oo = get_Value(COLUMNNAME_IsSent);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set num_control.
		@param num_control num_control	  */
	public void setnum_control (String num_control)
	{
		set_Value (COLUMNNAME_num_control, num_control);
	}

	/** Get num_control.
		@return num_control	  */
	public String getnum_control () 
	{
		return (String)get_Value(COLUMNNAME_num_control);
	}

	/** Set num_factura.
		@param num_factura num_factura	  */
	public void setnum_factura (String num_factura)
	{
		set_Value (COLUMNNAME_num_factura, num_factura);
	}

	/** Get num_factura.
		@return num_factura	  */
	public String getnum_factura () 
	{
		return (String)get_Value(COLUMNNAME_num_factura);
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

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Send EMail.
		@param SendEMail 
		Enable sending Document EMail
	  */
	public void setSendEMail (String SendEMail)
	{
		set_Value (COLUMNNAME_SendEMail, SendEMail);
	}

	/** Get Send EMail.
		@return Enable sending Document EMail
	  */
	public String getSendEMail () 
	{
		return (String)get_Value(COLUMNNAME_SendEMail);
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