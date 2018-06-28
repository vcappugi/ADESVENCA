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
import org.compiere.util.KeyNamePair;

/** Generated Model for H_Patient
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_Patient extends PO implements I_H_Patient, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120327L;

    /** Standard Constructor */
    public X_H_Patient (Properties ctx, int H_Patient_ID, String trxName)
    {
      super (ctx, H_Patient_ID, trxName);
      /** if (H_Patient_ID == 0)
        {
			setH_Patient_ID (0);
			setIDCard (null);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_Patient (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_Patient[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BDate.
		@param BDate BDate	  */
	public void setBDate (Timestamp BDate)
	{
		set_Value (COLUMNNAME_BDate, BDate);
	}

	/** Get BDate.
		@return BDate	  */
	public Timestamp getBDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_BDate);
	}

	/** Set Bussines.
		@param Bussines Bussines	  */
	public void setBussines (String Bussines)
	{
		set_Value (COLUMNNAME_Bussines, Bussines);
	}

	/** Get Bussines.
		@return Bussines	  */
	public String getBussines () 
	{
		return (String)get_Value(COLUMNNAME_Bussines);
	}

	/** Set Carnet.
		@param Carnet Carnet	  */
	public void setCarnet (boolean Carnet)
	{
		set_Value (COLUMNNAME_Carnet, Boolean.valueOf(Carnet));
	}

	/** Get Carnet.
		@return Carnet	  */
	public boolean isCarnet () 
	{
		Object oo = get_Value(COLUMNNAME_Carnet);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set City.
		@param C_City_ID 
		City
	  */
	public void setC_City_ID (int C_City_ID)
	{
		if (C_City_ID < 1) 
			set_Value (COLUMNNAME_C_City_ID, null);
		else 
			set_Value (COLUMNNAME_C_City_ID, Integer.valueOf(C_City_ID));
	}

	/** Get City.
		@return City
	  */
	public int getC_City_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_City_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Ced_titular.
		@param Ced_titular Ced_titular	  */
	public void setCed_titular (String Ced_titular)
	{
		set_Value (COLUMNNAME_Ced_titular, Ced_titular);
	}

	/** Get Ced_titular.
		@return Ced_titular	  */
	public String getCed_titular () 
	{
		return (String)get_Value(COLUMNNAME_Ced_titular);
	}

	/** Set Cedula.
		@param Cedula Cedula	  */
	public void setCedula (boolean Cedula)
	{
		set_Value (COLUMNNAME_Cedula, Boolean.valueOf(Cedula));
	}

	/** Get Cedula.
		@return Cedula	  */
	public boolean isCedula () 
	{
		Object oo = get_Value(COLUMNNAME_Cedula);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public I_C_Location getC_Location() throws RuntimeException
    {
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_Name)
			.getPO(getC_Location_ID(), get_TrxName());	}

	/** Set Address.
		@param C_Location_ID 
		Location or Address
	  */
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1) 
			set_Value (COLUMNNAME_C_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Location getC_LocationW() throws RuntimeException
    {
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_Name)
			.getPO(getC_LocationW_ID(), get_TrxName());	}

	/** Set C_LocationW_ID.
		@param C_LocationW_ID C_LocationW_ID	  */
	public void setC_LocationW_ID (int C_LocationW_ID)
	{
		if (C_LocationW_ID < 1) 
			set_Value (COLUMNNAME_C_LocationW_ID, null);
		else 
			set_Value (COLUMNNAME_C_LocationW_ID, Integer.valueOf(C_LocationW_ID));
	}

	/** Get C_LocationW_ID.
		@return C_LocationW_ID	  */
	public int getC_LocationW_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_LocationW_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set COrigen.
		@param COrigen 
		Ciudad de Procedencia
	  */
	public void setCOrigen (String COrigen)
	{
		set_Value (COLUMNNAME_COrigen, COrigen);
	}

	/** Get COrigen.
		@return Ciudad de Procedencia
	  */
	public String getCOrigen () 
	{
		return (String)get_Value(COLUMNNAME_COrigen);
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegionD() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegionD_ID(), get_TrxName());	}

	/** Set C_SalesRegionD_ID.
		@param C_SalesRegionD_ID C_SalesRegionD_ID	  */
	public void setC_SalesRegionD_ID (int C_SalesRegionD_ID)
	{
		if (C_SalesRegionD_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegionD_ID, Integer.valueOf(C_SalesRegionD_ID));
	}

	/** Get C_SalesRegionD_ID.
		@return C_SalesRegionD_ID	  */
	public int getC_SalesRegionD_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegionD_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
    {
		return (org.compiere.model.I_C_SalesRegion)MTable.get(getCtx(), org.compiere.model.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegion_ID(), get_TrxName());	}

	/** Set Sales Region.
		@param C_SalesRegion_ID 
		Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
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

	/** Set EMail Address.
		@param EMail 
		Electronic Mail Address
	  */
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
		@return Electronic Mail Address
	  */
	public String getEMail () 
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}

	/** Set Fecha_Vcto_Poliza.
		@param Fecha_Vcto_Poliza Fecha_Vcto_Poliza	  */
	public void setFecha_Vcto_Poliza (Timestamp Fecha_Vcto_Poliza)
	{
		set_Value (COLUMNNAME_Fecha_Vcto_Poliza, Fecha_Vcto_Poliza);
	}

	/** Get Fecha_Vcto_Poliza.
		@return Fecha_Vcto_Poliza	  */
	public Timestamp getFecha_Vcto_Poliza () 
	{
		return (Timestamp)get_Value(COLUMNNAME_Fecha_Vcto_Poliza);
	}

	/** Set GenerateAdmission.
		@param GenerateAdmission 
		Botón para generar admisiones
	  */
	public void setGenerateAdmission (String GenerateAdmission)
	{
		set_Value (COLUMNNAME_GenerateAdmission, GenerateAdmission);
	}

	/** Get GenerateAdmission.
		@return Botón para generar admisiones
	  */
	public String getGenerateAdmission () 
	{
		return (String)get_Value(COLUMNNAME_GenerateAdmission);
	}

	public org.pentanet.model.I_H_Bed getH_Bed() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Bed)MTable.get(getCtx(), org.pentanet.model.I_H_Bed.Table_Name)
			.getPO(getH_Bed_ID(), get_TrxName());	}

	/** Set H_Bed.
		@param H_Bed_ID H_Bed	  */
	public void setH_Bed_ID (int H_Bed_ID)
	{
		if (H_Bed_ID < 1) 
			set_Value (COLUMNNAME_H_Bed_ID, null);
		else 
			set_Value (COLUMNNAME_H_Bed_ID, Integer.valueOf(H_Bed_ID));
	}

	/** Get H_Bed.
		@return H_Bed	  */
	public int getH_Bed_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Bed_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_H_MHistory getH_MHistory() throws RuntimeException
    {
		return (org.pentanet.model.I_H_MHistory)MTable.get(getCtx(), org.pentanet.model.I_H_MHistory.Table_Name)
			.getPO(getH_MHistory_ID(), get_TrxName());	}

	/** Set H_MHistory.
		@param H_MHistory_ID H_MHistory	  */
	public void setH_MHistory_ID (int H_MHistory_ID)
	{
		if (H_MHistory_ID < 1) 
			set_Value (COLUMNNAME_H_MHistory_ID, null);
		else 
			set_Value (COLUMNNAME_H_MHistory_ID, Integer.valueOf(H_MHistory_ID));
	}

	/** Get H_MHistory.
		@return H_MHistory	  */
	public int getH_MHistory_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_MHistory_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HomePhone.
		@param HomePhone HomePhone	  */
	public void setHomePhone (String HomePhone)
	{
		set_Value (COLUMNNAME_HomePhone, HomePhone);
	}

	/** Get HomePhone.
		@return HomePhone	  */
	public String getHomePhone () 
	{
		return (String)get_Value(COLUMNNAME_HomePhone);
	}

	/** Set H_Patient.
		@param H_Patient_ID H_Patient	  */
	public void setH_Patient_ID (int H_Patient_ID)
	{
		if (H_Patient_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Patient_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Patient_ID, Integer.valueOf(H_Patient_ID));
	}

	/** Get H_Patient.
		@return H_Patient	  */
	public int getH_Patient_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Patient_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IDCard.
		@param IDCard IDCard	  */
	public void setIDCard (String IDCard)
	{
		set_Value (COLUMNNAME_IDCard, IDCard);
	}

	/** Get IDCard.
		@return IDCard	  */
	public String getIDCard () 
	{
		return (String)get_Value(COLUMNNAME_IDCard);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getIDCard());
    }

	/** Set InitialDiagnostic.
		@param InitialDiagnostic InitialDiagnostic	  */
	public void setInitialDiagnostic (String InitialDiagnostic)
	{
		set_Value (COLUMNNAME_InitialDiagnostic, InitialDiagnostic);
	}

	/** Get InitialDiagnostic.
		@return InitialDiagnostic	  */
	public String getInitialDiagnostic () 
	{
		return (String)get_Value(COLUMNNAME_InitialDiagnostic);
	}

	/** Set IsCompleted.
		@param IsCompleted IsCompleted	  */
	public void setIsCompleted (boolean IsCompleted)
	{
		set_Value (COLUMNNAME_IsCompleted, Boolean.valueOf(IsCompleted));
	}

	/** Get IsCompleted.
		@return IsCompleted	  */
	public boolean isCompleted () 
	{
		Object oo = get_Value(COLUMNNAME_IsCompleted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsFResponsible.
		@param IsFResponsible IsFResponsible	  */
	public void setIsFResponsible (boolean IsFResponsible)
	{
		set_Value (COLUMNNAME_IsFResponsible, Boolean.valueOf(IsFResponsible));
	}

	/** Get IsFResponsible.
		@return IsFResponsible	  */
	public boolean isFResponsible () 
	{
		Object oo = get_Value(COLUMNNAME_IsFResponsible);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsInsured.
		@param IsInsured IsInsured	  */
	public void setIsInsured (boolean IsInsured)
	{
		set_Value (COLUMNNAME_IsInsured, Boolean.valueOf(IsInsured));
	}

	/** Get IsInsured.
		@return IsInsured	  */
	public boolean isInsured () 
	{
		Object oo = get_Value(COLUMNNAME_IsInsured);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsPolicyHolder.
		@param IsPolicyHolder 
		Indica si es titular de una poliza de seguros
	  */
	public void setIsPolicyHolder (boolean IsPolicyHolder)
	{
		set_Value (COLUMNNAME_IsPolicyHolder, Boolean.valueOf(IsPolicyHolder));
	}

	/** Get IsPolicyHolder.
		@return Indica si es titular de una poliza de seguros
	  */
	public boolean isPolicyHolder () 
	{
		Object oo = get_Value(COLUMNNAME_IsPolicyHolder);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** MaritalStatus AD_Reference_ID=1000010 */
	public static final int MARITALSTATUS_AD_Reference_ID=1000010;
	/** Soltero = S */
	public static final String MARITALSTATUS_Soltero = "S";
	/** Casado = C */
	public static final String MARITALSTATUS_Casado = "C";
	/** Divorciado = D */
	public static final String MARITALSTATUS_Divorciado = "D";
	/** Viudo = V */
	public static final String MARITALSTATUS_Viudo = "V";
	/** Concubino = B */
	public static final String MARITALSTATUS_Concubino = "B";
	/** Otro = O */
	public static final String MARITALSTATUS_Otro = "O";
	/** Set MaritalStatus.
		@param MaritalStatus MaritalStatus	  */
	public void setMaritalStatus (String MaritalStatus)
	{

		set_Value (COLUMNNAME_MaritalStatus, MaritalStatus);
	}

	/** Get MaritalStatus.
		@return MaritalStatus	  */
	public String getMaritalStatus () 
	{
		return (String)get_Value(COLUMNNAME_MaritalStatus);
	}

	/** Set Movil.
		@param Movil Movil	  */
	public void setMovil (String Movil)
	{
		set_Value (COLUMNNAME_Movil, Movil);
	}

	/** Get Movil.
		@return Movil	  */
	public String getMovil () 
	{
		return (String)get_Value(COLUMNNAME_Movil);
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

	/** Set NroPoliza.
		@param NroPoliza NroPoliza	  */
	public void setNroPoliza (String NroPoliza)
	{
		set_Value (COLUMNNAME_NroPoliza, NroPoliza);
	}

	/** Get NroPoliza.
		@return NroPoliza	  */
	public String getNroPoliza () 
	{
		return (String)get_Value(COLUMNNAME_NroPoliza);
	}

	/** PaymentForm AD_Reference_ID=1000034 */
	public static final int PAYMENTFORM_AD_Reference_ID=1000034;
	/** SEGURO MEDICO = S */
	public static final String PAYMENTFORM_SEGUROMEDICO = "S";
	/** EFECTIVO - CHEQUE - TARJETA = E */
	public static final String PAYMENTFORM_EFECTIVO_CHEQUE_TARJETA = "E";
	/** CONVENIO DE PAGO = C */
	public static final String PAYMENTFORM_CONVENIODEPAGO = "C";
	/** Set PaymentForm.
		@param PaymentForm PaymentForm	  */
	public void setPaymentForm (String PaymentForm)
	{

		set_Value (COLUMNNAME_PaymentForm, PaymentForm);
	}

	/** Get PaymentForm.
		@return PaymentForm	  */
	public String getPaymentForm () 
	{
		return (String)get_Value(COLUMNNAME_PaymentForm);
	}

	/** Set Photo.
		@param Photo Photo	  */
	public void setPhoto (int Photo)
	{
		set_Value (COLUMNNAME_Photo, Integer.valueOf(Photo));
	}

	/** Get Photo.
		@return Photo	  */
	public int getPhoto () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Photo);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Profesion.
		@param Profesion Profesion	  */
	public void setProfesion (String Profesion)
	{
		set_Value (COLUMNNAME_Profesion, Profesion);
	}

	/** Get Profesion.
		@return Profesion	  */
	public String getProfesion () 
	{
		return (String)get_Value(COLUMNNAME_Profesion);
	}

	/** Set Religion.
		@param Religion Religion	  */
	public void setReligion (String Religion)
	{
		set_Value (COLUMNNAME_Religion, Religion);
	}

	/** Get Religion.
		@return Religion	  */
	public String getReligion () 
	{
		return (String)get_Value(COLUMNNAME_Religion);
	}

	/** Sex AD_Reference_ID=1000009 */
	public static final int SEX_AD_Reference_ID=1000009;
	/** Femenino = F */
	public static final String SEX_Femenino = "F";
	/** Masculino = M */
	public static final String SEX_Masculino = "M";
	/** Set Sex.
		@param Sex Sex	  */
	public void setSex (String Sex)
	{

		set_Value (COLUMNNAME_Sex, Sex);
	}

	/** Get Sex.
		@return Sex	  */
	public String getSex () 
	{
		return (String)get_Value(COLUMNNAME_Sex);
	}

	/** Set Titular_Poliza.
		@param Titular_Poliza Titular_Poliza	  */
	public void setTitular_Poliza (String Titular_Poliza)
	{
		set_Value (COLUMNNAME_Titular_Poliza, Titular_Poliza);
	}

	/** Get Titular_Poliza.
		@return Titular_Poliza	  */
	public String getTitular_Poliza () 
	{
		return (String)get_Value(COLUMNNAME_Titular_Poliza);
	}

	/** Set UltimoV.
		@param UltimoV UltimoV	  */
	public void setUltimoV (boolean UltimoV)
	{
		set_Value (COLUMNNAME_UltimoV, Boolean.valueOf(UltimoV));
	}

	/** Get UltimoV.
		@return UltimoV	  */
	public boolean isUltimoV () 
	{
		Object oo = get_Value(COLUMNNAME_UltimoV);
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

	/** Set WorkPhone.
		@param WorkPhone WorkPhone	  */
	public void setWorkPhone (String WorkPhone)
	{
		set_Value (COLUMNNAME_WorkPhone, WorkPhone);
	}

	/** Get WorkPhone.
		@return WorkPhone	  */
	public String getWorkPhone () 
	{
		return (String)get_Value(COLUMNNAME_WorkPhone);
	}
}