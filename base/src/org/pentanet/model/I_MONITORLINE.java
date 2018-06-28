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

/** Generated Interface for MONITORLINE
 *  @author Adempiere (generated) 
 *  @version Release 3.5.4a
 */
public interface I_MONITORLINE 
{

    /** TableName=MONITORLINE */
    public static final String Table_Name = "MONITORLINE";

    /** AD_Table_ID=1000015 */
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

    /** Column name AD_PrintColor_ID */
    public static final String COLUMNNAME_AD_PrintColor_ID = "AD_PrintColor_ID";

	/** Set Print Color.
	  * Color used for printing and display
	  */
	public void setAD_PrintColor_ID (int AD_PrintColor_ID);

	/** Get Print Color.
	  * Color used for printing and display
	  */
	public int getAD_PrintColor_ID();

	public I_AD_PrintColor getAD_PrintColor() throws RuntimeException;

    /** Column name AD_Window_ID */
    public static final String COLUMNNAME_AD_Window_ID = "AD_Window_ID";

	/** Set Window.
	  * Data entry or display window
	  */
	public void setAD_Window_ID (int AD_Window_ID);

	/** Get Window.
	  * Data entry or display window
	  */
	public int getAD_Window_ID();

	public I_AD_Window getAD_Window() throws RuntimeException;

    /** Column name ButtonHigh */
    public static final String COLUMNNAME_ButtonHigh = "ButtonHigh";

	/** Set ButtonHigh	  */
	public void setButtonHigh (int ButtonHigh);

	/** Get ButtonHigh	  */
	public int getButtonHigh();

    /** Column name ButtonWidth */
    public static final String COLUMNNAME_ButtonWidth = "ButtonWidth";

	/** Set ButtonWidth	  */
	public void setButtonWidth (int ButtonWidth);

	/** Get ButtonWidth	  */
	public int getButtonWidth();

    /** Column name COLUMNAMECLAVE */
    public static final String COLUMNNAME_COLUMNAMECLAVE = "COLUMNAMECLAVE";

	/** Set COLUMNAMECLAVE	  */
	public void setCOLUMNAMECLAVE (String COLUMNAMECLAVE);

	/** Get COLUMNAMECLAVE	  */
	public String getCOLUMNAMECLAVE();

    /** Column name COLUMNAMEDICION */
    public static final String COLUMNNAME_COLUMNAMEDICION = "COLUMNAMEDICION";

	/** Set COLUMNAMEDICION	  */
	public void setCOLUMNAMEDICION (String COLUMNAMEDICION);

	/** Get COLUMNAMEDICION	  */
	public String getCOLUMNAMEDICION();

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

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name HTMLBUTTON */
    public static final String COLUMNNAME_HTMLBUTTON = "HTMLBUTTON";

	/** Set HTMLBUTTON	  */
	public void setHTMLBUTTON (String HTMLBUTTON);

	/** Get HTMLBUTTON	  */
	public String getHTMLBUTTON();

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

    /** Column name MONITOR_ID */
    public static final String COLUMNNAME_MONITOR_ID = "MONITOR_ID";

	/** Set MONITOR	  */
	public void setMONITOR_ID (int MONITOR_ID);

	/** Get MONITOR	  */
	public int getMONITOR_ID();

	public I_MONITOR getMONITOR() throws RuntimeException;

    /** Column name MONITORLINE_ID */
    public static final String COLUMNNAME_MONITORLINE_ID = "MONITORLINE_ID";

	/** Set MONITORLINE	  */
	public void setMONITORLINE_ID (int MONITORLINE_ID);

	/** Get MONITORLINE	  */
	public int getMONITORLINE_ID();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name QUERYMONITOR */
    public static final String COLUMNNAME_QUERYMONITOR = "QUERYMONITOR";

	/** Set QUERYMONITOR	  */
	public void setQUERYMONITOR (String QUERYMONITOR);

	/** Get QUERYMONITOR	  */
	public String getQUERYMONITOR();

    /** Column name TablaVentana */
    public static final String COLUMNNAME_TablaVentana = "TablaVentana";

	/** Set TablaVentana	  */
	public void setTablaVentana (int TablaVentana);

	/** Get TablaVentana	  */
	public int getTablaVentana();

	public I_AD_Table getTablaVent() throws RuntimeException;

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
}
