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

/** Generated Model for HR_WorkPermit
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_HR_WorkPermit extends PO implements I_HR_WorkPermit, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150413L;

    /** Standard Constructor */
    public X_HR_WorkPermit (Properties ctx, int HR_WorkPermit_ID, String trxName)
    {
      super (ctx, HR_WorkPermit_ID, trxName);
      /** if (HR_WorkPermit_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_DocType_ID (0);
			setDateEnd (new Timestamp( System.currentTimeMillis() ));
			setDateRequest (new Timestamp( System.currentTimeMillis() ));
			setDateStart (new Timestamp( System.currentTimeMillis() ));
			setHR_WorkPermit_ID (0);
			setType (null);
        } */
    }

    /** Load Constructor */
    public X_HR_WorkPermit (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_WorkPermit[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set DateRequest.
		@param DateRequest DateRequest	  */
	public void setDateRequest (Timestamp DateRequest)
	{
		set_Value (COLUMNNAME_DateRequest, DateRequest);
	}

	/** Get DateRequest.
		@return DateRequest	  */
	public Timestamp getDateRequest () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateRequest);
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
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

	public org.eevolution.model.I_HR_Process getHR_Process() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Process)MTable.get(getCtx(), org.eevolution.model.I_HR_Process.Table_Name)
			.getPO(getHR_Process_ID(), get_TrxName());	}

	/** Set Payroll Process.
		@param HR_Process_ID Payroll Process	  */
	public void setHR_Process_ID (int HR_Process_ID)
	{
		if (HR_Process_ID < 1) 
			set_Value (COLUMNNAME_HR_Process_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Process_ID, Integer.valueOf(HR_Process_ID));
	}

	/** Get Payroll Process.
		@return Payroll Process	  */
	public int getHR_Process_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_WorkPermit.
		@param HR_WorkPermit_ID HR_WorkPermit	  */
	public void setHR_WorkPermit_ID (int HR_WorkPermit_ID)
	{
		if (HR_WorkPermit_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_WorkPermit_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_WorkPermit_ID, Integer.valueOf(HR_WorkPermit_ID));
	}

	/** Get HR_WorkPermit.
		@return HR_WorkPermit	  */
	public int getHR_WorkPermit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkPermit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Approved.
		@param IsApproved 
		Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved)
	{
		set_Value (COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
	}

	/** Get Approved.
		@return Indicates if this document requires approval
	  */
	public boolean isApproved () 
	{
		Object oo = get_Value(COLUMNNAME_IsApproved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsCity.
		@param IsCity IsCity	  */
	public void setIsCity (boolean IsCity)
	{
		set_Value (COLUMNNAME_IsCity, Boolean.valueOf(IsCity));
	}

	/** Get IsCity.
		@return IsCity	  */
	public boolean isCity () 
	{
		Object oo = get_Value(COLUMNNAME_IsCity);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Net Days.
		@param NetDays 
		Net Days in which payment is due
	  */
	public void setNetDays (BigDecimal NetDays)
	{
		set_Value (COLUMNNAME_NetDays, NetDays);
	}

	/** Get Net Days.
		@return Net Days in which payment is due
	  */
	public BigDecimal getNetDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetDays);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Relationship AD_Reference_ID=1000178 */
	public static final int RELATIONSHIP_AD_Reference_ID=1000178;
	/** Conyugue = CON */
	public static final String RELATIONSHIP_Conyugue = "CON";
	/** Ascendiente = ASC */
	public static final String RELATIONSHIP_Ascendiente = "ASC";
	/** Descendiente = DES */
	public static final String RELATIONSHIP_Descendiente = "DES";
	/** Hermano(a) = HER */
	public static final String RELATIONSHIP_HermanoA = "HER";
	/** Sobrino = SOB */
	public static final String RELATIONSHIP_Sobrino = "SOB";
	/** Tio(a) = TIO */
	public static final String RELATIONSHIP_TioA = "TIO";
	/** Primo(a) = PRI */
	public static final String RELATIONSHIP_PrimoA = "PRI";
	/** Suegro(a) = SUE */
	public static final String RELATIONSHIP_SuegroA = "SUE";
	/** Cuñado(a) = CUN */
	public static final String RELATIONSHIP_CuñadoA = "CUN";
	/** Yerno o Nuera = YNU */
	public static final String RELATIONSHIP_YernoONuera = "YNU";
	/** Set Relationship.
		@param Relationship Relationship	  */
	public void setRelationship (String Relationship)
	{

		set_Value (COLUMNNAME_Relationship, Relationship);
	}

	/** Get Relationship.
		@return Relationship	  */
	public String getRelationship () 
	{
		return (String)get_Value(COLUMNNAME_Relationship);
	}

	/** Type AD_Reference_ID=1000177 */
	public static final int TYPE_AD_Reference_ID=1000177;
	/** Enfermedad Común = SL_E1 */
	public static final String TYPE_EnfermedadComún = "SL_E1";
	/** Enfermedad Ocupacional = SL_EP */
	public static final String TYPE_EnfermedadOcupacional = "SL_EP";
	/** Accidente Laboral = SL_AL */
	public static final String TYPE_AccidenteLaboral = "SL_AL";
	/** Descanso Compensatorio = WP_DE */
	public static final String TYPE_DescansoCompensatorio = "WP_DE";
	/** Consulta Médica (Medio Día)  = WP_C1/2 */
	public static final String TYPE_ConsultaMédicaMedioDía = "WP_C1/2";
	/** Presentación Trabajo de Grado  = WP_PR_1 */
	public static final String TYPE_PresentaciónTrabajoDeGrado = "WP_PR_1";
	/** Presentación Acto de Grado  = WP_PR_2 */
	public static final String TYPE_PresentaciónActoDeGrado = "WP_PR_2";
	/** Permiso Otros Estudios  = WP_PR_3 */
	public static final String TYPE_PermisoOtrosEstudios = "WP_PR_3";
	/** Permiso por Actividad Deportiva = WP_PR_4 */
	public static final String TYPE_PermisoPorActividadDeportiva = "WP_PR_4";
	/** Muerte de Familiar  = WP_MF */
	public static final String TYPE_MuerteDeFamiliar = "WP_MF";
	/** Licencia por Paternidad  = WP_NH */
	public static final String TYPE_LicenciaPorPaternidad = "WP_NH";
	/** Permiso por Matrimonio  = WP_PM */
	public static final String TYPE_PermisoPorMatrimonio = "WP_PM";
	/** Trámite de Documentos Personales (Un Día) = WP_PR_5 */
	public static final String TYPE_TrámiteDeDocumentosPersonalesUnDía = "WP_PR_5";
	/** Asuntos Personales   = WP_PNR_1 */
	public static final String TYPE_AsuntosPersonales = "WP_PNR_1";
	/** Consulta Médica (Un Día)  = WP_E1 */
	public static final String TYPE_ConsultaMédicaUnDía = "WP_E1";
	/** Trámite de Documentos Personales (Medio Día) = WP_PR_6 */
	public static final String TYPE_TrámiteDeDocumentosPersonalesMedioDía = "WP_PR_6";
	/** Reposo Pre/Post Natal  = SL_RN */
	public static final String TYPE_ReposoPrePostNatal = "SL_RN";
	/** Set Type.
		@param Type Type	  */
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
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