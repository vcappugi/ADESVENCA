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

/** Generated Model for C_MacroOrder
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_C_MacroOrder extends PO implements I_C_MacroOrder, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20130912L;

    /** Standard Constructor */
    public X_C_MacroOrder (Properties ctx, int C_MacroOrder_ID, String trxName)
    {
      super (ctx, C_MacroOrder_ID, trxName);
      /** if (C_MacroOrder_ID == 0)
        {
			setC_MacroOrder_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_MacroOrder (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_MacroOrder[")
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

	public org.compiere.model.I_C_Activity getcentro_l() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getcentro_list(), get_TrxName());	}

	/** Set centro_list.
		@param centro_list centro_list	  */
	public void setcentro_list (int centro_list)
	{
		set_Value (COLUMNNAME_centro_list, Integer.valueOf(centro_list));
	}

	/** Get centro_list.
		@return centro_list	  */
	public int getcentro_list () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_centro_list);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** C_Line AD_Reference_ID=1000084 */
	public static final int C_LINE_AD_Reference_ID=1000084;
	/** FLUIDOS = in ('30') */
	public static final String C_LINE_FLUIDOS = "in ('30')";
	/** CONTROL DE SOLIDO = in ('40') */
	public static final String C_LINE_CONTROLDESOLIDO = "in ('40')";
	/** ADMINISTRACION = not in ('30','40') */
	public static final String C_LINE_ADMINISTRACION = "not in ('30','40')";
	/** Set C_Line.
		@param C_Line C_Line	  */
	public void setC_Line (String C_Line)
	{

		set_Value (COLUMNNAME_C_Line, C_Line);
	}

	/** Get C_Line.
		@return C_Line	  */
	public String getC_Line () 
	{
		return (String)get_Value(COLUMNNAME_C_Line);
	}

	/** Set C_MacroOrder.
		@param C_MacroOrder_ID C_MacroOrder	  */
	public void setC_MacroOrder_ID (int C_MacroOrder_ID)
	{
		if (C_MacroOrder_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_MacroOrder_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_MacroOrder_ID, Integer.valueOf(C_MacroOrder_ID));
	}

	/** Get C_MacroOrder.
		@return C_MacroOrder	  */
	public int getC_MacroOrder_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_MacroOrder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
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

	/** Set GenerateLines.
		@param GenerateLines GenerateLines	  */
	public void setGenerateLines (String GenerateLines)
	{
		set_ValueNoCheck (COLUMNNAME_GenerateLines, GenerateLines);
	}

	/** Get GenerateLines.
		@return GenerateLines	  */
	public String getGenerateLines () 
	{
		return (String)get_Value(COLUMNNAME_GenerateLines);
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

	/** Set Processed_Button.
		@param Processed_Button Processed_Button	  */
	public void setProcessed_Button (String Processed_Button)
	{
		set_Value (COLUMNNAME_Processed_Button, Processed_Button);
	}

	/** Get Processed_Button.
		@return Processed_Button	  */
	public String getProcessed_Button () 
	{
		return (String)get_Value(COLUMNNAME_Processed_Button);
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