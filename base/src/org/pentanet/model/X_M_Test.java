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
import org.compiere.util.KeyNamePair;

/** Generated Model for M_Test
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_M_Test extends PO implements I_M_Test, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131016L;

    /** Standard Constructor */
    public X_M_Test (Properties ctx, int M_Test_ID, String trxName)
    {
      super (ctx, M_Test_ID, trxName);
      /** if (M_Test_ID == 0)
        {
			setM_Test_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_M_Test (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_Test[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Densidad.
		@param Densidad Densidad	  */
	public void setDensidad (String Densidad)
	{
		set_Value (COLUMNNAME_Densidad, Densidad);
	}

	/** Get Densidad.
		@return Densidad	  */
	public String getDensidad () 
	{
		return (String)get_Value(COLUMNNAME_Densidad);
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

	/** Set M_Test.
		@param M_Test_ID M_Test	  */
	public void setM_Test_ID (int M_Test_ID)
	{
		if (M_Test_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Test_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Test_ID, Integer.valueOf(M_Test_ID));
	}

	/** Get M_Test.
		@return M_Test	  */
	public int getM_Test_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Test_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Presión.
		@param Presión Presión	  */
	public void setPresión (String Presión)
	{
		set_Value (COLUMNNAME_Presión, Presión);
	}

	/** Get Presión.
		@return Presión	  */
	public String getPresión () 
	{
		return (String)get_Value(COLUMNNAME_Presión);
	}

	/** Set Profundidad.
		@param Profundidad Profundidad	  */
	public void setProfundidad (String Profundidad)
	{
		set_Value (COLUMNNAME_Profundidad, Profundidad);
	}

	/** Get Profundidad.
		@return Profundidad	  */
	public String getProfundidad () 
	{
		return (String)get_Value(COLUMNNAME_Profundidad);
	}

	/** Set Temperatura.
		@param Temperatura Temperatura	  */
	public void setTemperatura (String Temperatura)
	{
		set_Value (COLUMNNAME_Temperatura, Temperatura);
	}

	/** Get Temperatura.
		@return Temperatura	  */
	public String getTemperatura () 
	{
		return (String)get_Value(COLUMNNAME_Temperatura);
	}

	/** Set Unidad.
		@param Unidad Unidad	  */
	public void setUnidad (String Unidad)
	{
		set_Value (COLUMNNAME_Unidad, Unidad);
	}

	/** Get Unidad.
		@return Unidad	  */
	public String getUnidad () 
	{
		return (String)get_Value(COLUMNNAME_Unidad);
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