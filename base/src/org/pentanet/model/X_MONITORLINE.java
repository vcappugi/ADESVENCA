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

/** Generated Model for MONITORLINE
 *  @author Adempiere (generated) 
 *  @version Release 3.5.4a - $Id$ */
public class X_MONITORLINE extends PO implements I_MONITORLINE, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20100110L;

    /** Standard Constructor */
    public X_MONITORLINE (Properties ctx, int MONITORLINE_ID, String trxName)
    {
      super (ctx, MONITORLINE_ID, trxName);
      /** if (MONITORLINE_ID == 0)
        {
			setAD_Window_ID (0);
			setCOLUMNAMECLAVE (null);
			setCOLUMNAMEDICION (null);
			setMONITOR_ID (0);
			setMONITORLINE_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_MONITORLINE (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_MONITORLINE[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_AD_PrintColor getAD_PrintColor() throws RuntimeException
    {
		return (I_AD_PrintColor)MTable.get(getCtx(), I_AD_PrintColor.Table_Name)
			.getPO(getAD_PrintColor_ID(), get_TrxName());	}

	/** Set Print Color.
		@param AD_PrintColor_ID 
		Color used for printing and display
	  */
	public void setAD_PrintColor_ID (int AD_PrintColor_ID)
	{
		if (AD_PrintColor_ID < 1) 
			set_Value (COLUMNNAME_AD_PrintColor_ID, null);
		else 
			set_Value (COLUMNNAME_AD_PrintColor_ID, Integer.valueOf(AD_PrintColor_ID));
	}

	/** Get Print Color.
		@return Color used for printing and display
	  */
	public int getAD_PrintColor_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_PrintColor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_AD_Window getAD_Window() throws RuntimeException
    {
		return (I_AD_Window)MTable.get(getCtx(), I_AD_Window.Table_Name)
			.getPO(getAD_Window_ID(), get_TrxName());	}

	/** Set Window.
		@param AD_Window_ID 
		Data entry or display window
	  */
	public void setAD_Window_ID (int AD_Window_ID)
	{
		if (AD_Window_ID < 1) 
			set_Value (COLUMNNAME_AD_Window_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Window_ID, Integer.valueOf(AD_Window_ID));
	}

	/** Get Window.
		@return Data entry or display window
	  */
	public int getAD_Window_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ButtonHigh.
		@param ButtonHigh ButtonHigh	  */
	public void setButtonHigh (int ButtonHigh)
	{
		set_Value (COLUMNNAME_ButtonHigh, Integer.valueOf(ButtonHigh));
	}

	/** Get ButtonHigh.
		@return ButtonHigh	  */
	public int getButtonHigh () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ButtonHigh);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ButtonWidth.
		@param ButtonWidth ButtonWidth	  */
	public void setButtonWidth (int ButtonWidth)
	{
		set_Value (COLUMNNAME_ButtonWidth, Integer.valueOf(ButtonWidth));
	}

	/** Get ButtonWidth.
		@return ButtonWidth	  */
	public int getButtonWidth () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ButtonWidth);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set COLUMNAMECLAVE.
		@param COLUMNAMECLAVE COLUMNAMECLAVE	  */
	public void setCOLUMNAMECLAVE (String COLUMNAMECLAVE)
	{
		set_Value (COLUMNNAME_COLUMNAMECLAVE, COLUMNAMECLAVE);
	}

	/** Get COLUMNAMECLAVE.
		@return COLUMNAMECLAVE	  */
	public String getCOLUMNAMECLAVE () 
	{
		return (String)get_Value(COLUMNNAME_COLUMNAMECLAVE);
	}

	/** Set COLUMNAMEDICION.
		@param COLUMNAMEDICION COLUMNAMEDICION	  */
	public void setCOLUMNAMEDICION (String COLUMNAMEDICION)
	{
		set_Value (COLUMNNAME_COLUMNAMEDICION, COLUMNAMEDICION);
	}

	/** Get COLUMNAMEDICION.
		@return COLUMNAMEDICION	  */
	public String getCOLUMNAMEDICION () 
	{
		return (String)get_Value(COLUMNNAME_COLUMNAMEDICION);
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

	/** Set HTMLBUTTON.
		@param HTMLBUTTON HTMLBUTTON	  */
	public void setHTMLBUTTON (String HTMLBUTTON)
	{
		set_Value (COLUMNNAME_HTMLBUTTON, HTMLBUTTON);
	}

	/** Get HTMLBUTTON.
		@return HTMLBUTTON	  */
	public String getHTMLBUTTON () 
	{
		return (String)get_Value(COLUMNNAME_HTMLBUTTON);
	}

	public I_MONITOR getMONITOR() throws RuntimeException
    {
		return (I_MONITOR)MTable.get(getCtx(), I_MONITOR.Table_Name)
			.getPO(getMONITOR_ID(), get_TrxName());	}

	/** Set MONITOR.
		@param MONITOR_ID MONITOR	  */
	public void setMONITOR_ID (int MONITOR_ID)
	{
		if (MONITOR_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_MONITOR_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_MONITOR_ID, Integer.valueOf(MONITOR_ID));
	}

	/** Get MONITOR.
		@return MONITOR	  */
	public int getMONITOR_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MONITOR_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set MONITORLINE.
		@param MONITORLINE_ID MONITORLINE	  */
	public void setMONITORLINE_ID (int MONITORLINE_ID)
	{
		if (MONITORLINE_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_MONITORLINE_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_MONITORLINE_ID, Integer.valueOf(MONITORLINE_ID));
	}

	/** Get MONITORLINE.
		@return MONITORLINE	  */
	public int getMONITORLINE_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MONITORLINE_ID);
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

	/** Set QUERYMONITOR.
		@param QUERYMONITOR QUERYMONITOR	  */
	public void setQUERYMONITOR (String QUERYMONITOR)
	{
		set_Value (COLUMNNAME_QUERYMONITOR, QUERYMONITOR);
	}

	/** Get QUERYMONITOR.
		@return QUERYMONITOR	  */
	public String getQUERYMONITOR () 
	{
		return (String)get_Value(COLUMNNAME_QUERYMONITOR);
	}

	public I_AD_Table getTablaVent() throws RuntimeException
    {
		return (I_AD_Table)MTable.get(getCtx(), I_AD_Table.Table_Name)
			.getPO(getTablaVentana(), get_TrxName());	}

	/** Set TablaVentana.
		@param TablaVentana TablaVentana	  */
	public void setTablaVentana (int TablaVentana)
	{
		set_Value (COLUMNNAME_TablaVentana, Integer.valueOf(TablaVentana));
	}

	/** Get TablaVentana.
		@return TablaVentana	  */
	public int getTablaVentana () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TablaVentana);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}