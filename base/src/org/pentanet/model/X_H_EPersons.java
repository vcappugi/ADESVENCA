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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for H_EPersons
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_H_EPersons extends PO implements I_H_EPersons, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111128L;

    /** Standard Constructor */
    public X_H_EPersons (Properties ctx, int H_EPersons_ID, String trxName)
    {
      super (ctx, H_EPersons_ID, trxName);
      /** if (H_EPersons_ID == 0)
        {
			setH_EPersons_ID (0);
			setIDCard (null);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_H_EPersons (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_H_EPersons[")
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

	/** Set Coverage.
		@param Coverage Coverage	  */
	public void setCoverage (BigDecimal Coverage)
	{
		set_Value (COLUMNNAME_Coverage, Coverage);
	}

	/** Get Coverage.
		@return Coverage	  */
	public BigDecimal getCoverage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Coverage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Deductible.
		@param Deductible Deductible	  */
	public void setDeductible (BigDecimal Deductible)
	{
		set_Value (COLUMNNAME_Deductible, Deductible);
	}

	/** Get Deductible.
		@return Deductible	  */
	public BigDecimal getDeductible () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Deductible);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	public org.pentanet.model.I_H_Admission getH_Admission() throws RuntimeException
    {
		return (org.pentanet.model.I_H_Admission)MTable.get(getCtx(), org.pentanet.model.I_H_Admission.Table_Name)
			.getPO(getH_Admission_ID(), get_TrxName());	}

	/** Set H_Admission.
		@param H_Admission_ID H_Admission	  */
	public void setH_Admission_ID (int H_Admission_ID)
	{
		if (H_Admission_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Admission_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Admission_ID, Integer.valueOf(H_Admission_ID));
	}

	/** Get H_Admission.
		@return H_Admission	  */
	public int getH_Admission_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Admission_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set H_EPersons.
		@param H_EPersons_ID H_EPersons	  */
	public void setH_EPersons_ID (int H_EPersons_ID)
	{
		if (H_EPersons_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_EPersons_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_EPersons_ID, Integer.valueOf(H_EPersons_ID));
	}

	/** Get H_EPersons.
		@return H_EPersons	  */
	public int getH_EPersons_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_EPersons_ID);
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

	/** Set IOperator.
		@param IOperator 
		Insurance Operator
	  */
	public void setIOperator (String IOperator)
	{
		set_Value (COLUMNNAME_IOperator, IOperator);
	}

	/** Get IOperator.
		@return Insurance Operator
	  */
	public String getIOperator () 
	{
		return (String)get_Value(COLUMNNAME_IOperator);
	}

	/** Set IsBPartner.
		@param IsBPartner 
		Define si es Socio de Negocio
	  */
	public void setIsBPartner (boolean IsBPartner)
	{
		set_Value (COLUMNNAME_IsBPartner, Boolean.valueOf(IsBPartner));
	}

	/** Get IsBPartner.
		@return Define si es Socio de Negocio
	  */
	public boolean isBPartner () 
	{
		Object oo = get_Value(COLUMNNAME_IsBPartner);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsCompanion.
		@param IsCompanion 
		Define si es acompañante del paciente
	  */
	public void setIsCompanion (boolean IsCompanion)
	{
		set_Value (COLUMNNAME_IsCompanion, Boolean.valueOf(IsCompanion));
	}

	/** Get IsCompanion.
		@return Define si es acompañante del paciente
	  */
	public boolean isCompanion () 
	{
		Object oo = get_Value(COLUMNNAME_IsCompanion);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsFResponsible.
		@param IsFResponsible 
		Define si la persona es Responsable Financiero
	  */
	public void setIsFResponsible (boolean IsFResponsible)
	{
		set_Value (COLUMNNAME_IsFResponsible, Boolean.valueOf(IsFResponsible));
	}

	/** Get IsFResponsible.
		@return Define si la persona es Responsable Financiero
	  */
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

	/** Set IsIResponsible.
		@param IsIResponsible 
		Define si es responsable ante la institucion
	  */
	public void setIsIResponsible (boolean IsIResponsible)
	{
		set_Value (COLUMNNAME_IsIResponsible, Boolean.valueOf(IsIResponsible));
	}

	/** Get IsIResponsible.
		@return Define si es responsable ante la institucion
	  */
	public boolean isIResponsible () 
	{
		Object oo = get_Value(COLUMNNAME_IsIResponsible);
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

	/** Set Key.
		@param Key Key	  */
	public void setKey (String Key)
	{
		set_Value (COLUMNNAME_Key, Key);
	}

	/** Get Key.
		@return Key	  */
	public String getKey () 
	{
		return (String)get_Value(COLUMNNAME_Key);
	}

	/** Set Kinship.
		@param Kinship Kinship	  */
	public void setKinship (String Kinship)
	{
		set_Value (COLUMNNAME_Kinship, Kinship);
	}

	/** Get Kinship.
		@return Kinship	  */
	public String getKinship () 
	{
		return (String)get_Value(COLUMNNAME_Kinship);
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
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

	/** Set TypeOfNegotiation.
		@param TypeOfNegotiation 
		Tipo de Negociacion 
	  */
	public void setTypeOfNegotiation (String TypeOfNegotiation)
	{
		set_Value (COLUMNNAME_TypeOfNegotiation, TypeOfNegotiation);
	}

	/** Get TypeOfNegotiation.
		@return Tipo de Negociacion 
	  */
	public String getTypeOfNegotiation () 
	{
		return (String)get_Value(COLUMNNAME_TypeOfNegotiation);
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