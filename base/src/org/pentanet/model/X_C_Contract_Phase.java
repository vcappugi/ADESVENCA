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
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for C_Contract_Phase
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_C_Contract_Phase extends PO implements I_C_Contract_Phase, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160509L;

    /** Standard Constructor */
    public X_C_Contract_Phase (Properties ctx, int C_Contract_Phase_ID, String trxName)
    {
      super (ctx, C_Contract_Phase_ID, trxName);
      /** if (C_Contract_Phase_ID == 0)
        {
			setC_Contract_ID (0);
			setC_Contract_Phase_ID (0);
			setC_Phase_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_Contract_Phase (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Contract_Phase[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.pentanet.model.I_C_Contract getC_Contract() throws RuntimeException
    {
		return (org.pentanet.model.I_C_Contract)MTable.get(getCtx(), org.pentanet.model.I_C_Contract.Table_Name)
			.getPO(getC_Contract_ID(), get_TrxName());	}

	/** Set C_Contract.
		@param C_Contract_ID C_Contract	  */
	public void setC_Contract_ID (int C_Contract_ID)
	{
		if (C_Contract_ID < 1) 
			set_Value (COLUMNNAME_C_Contract_ID, null);
		else 
			set_Value (COLUMNNAME_C_Contract_ID, Integer.valueOf(C_Contract_ID));
	}

	/** Get C_Contract.
		@return C_Contract	  */
	public int getC_Contract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Contract Phase.
		@param C_Contract_Phase_ID Contract Phase	  */
	public void setC_Contract_Phase_ID (int C_Contract_Phase_ID)
	{
		if (C_Contract_Phase_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Contract_Phase_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Contract_Phase_ID, Integer.valueOf(C_Contract_Phase_ID));
	}

	/** Get Contract Phase.
		@return Contract Phase	  */
	public int getC_Contract_Phase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Contract_Phase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Phase getC_Phase() throws RuntimeException
    {
		return (org.compiere.model.I_C_Phase)MTable.get(getCtx(), org.compiere.model.I_C_Phase.Table_Name)
			.getPO(getC_Phase_ID(), get_TrxName());	}

	/** Set Standard Phase.
		@param C_Phase_ID 
		Standard Phase of the Project Type
	  */
	public void setC_Phase_ID (int C_Phase_ID)
	{
		if (C_Phase_ID < 1) 
			set_Value (COLUMNNAME_C_Phase_ID, null);
		else 
			set_Value (COLUMNNAME_C_Phase_ID, Integer.valueOf(C_Phase_ID));
	}

	/** Get Standard Phase.
		@return Standard Phase of the Project Type
	  */
	public int getC_Phase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Phase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Type AD_Reference_ID=1000211 */
	public static final int TYPE_AD_Reference_ID=1000211;
	/** Mixto = MIX */
	public static final String TYPE_Mixto = "MIX";
	/** Volúmen = VOL */
	public static final String TYPE_Volúmen = "VOL";
	/** Consumo = CON */
	public static final String TYPE_Consumo = "CON";
	/** Set Type.
		@param Type 
		Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
	}
}