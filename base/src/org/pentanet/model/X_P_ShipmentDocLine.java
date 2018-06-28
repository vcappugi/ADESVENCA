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

/** Generated Model for P_ShipmentDocLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_P_ShipmentDocLine extends PO implements I_P_ShipmentDocLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20111223L;

    /** Standard Constructor */
    public X_P_ShipmentDocLine (Properties ctx, int P_ShipmentDocLine_ID, String trxName)
    {
      super (ctx, P_ShipmentDocLine_ID, trxName);
      /** if (P_ShipmentDocLine_ID == 0)
        {
			setP_ShipmentDocLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_P_ShipmentDocLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_P_ShipmentDocLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException
    {
		return (org.compiere.model.I_M_InOut)MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
			.getPO(getM_InOut_ID(), get_TrxName());	}

	/** Set Shipment/Receipt.
		@param M_InOut_ID 
		Material Shipment Document
	  */
	public void setM_InOut_ID (int M_InOut_ID)
	{
		if (M_InOut_ID < 1) 
			set_Value (COLUMNNAME_M_InOut_ID, null);
		else 
			set_Value (COLUMNNAME_M_InOut_ID, Integer.valueOf(M_InOut_ID));
	}

	/** Get Shipment/Receipt.
		@return Material Shipment Document
	  */
	public int getM_InOut_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_InOut_ID);
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

	public org.pentanet.model.I_P_ShipmentDoc getP_ShipmentDoc() throws RuntimeException
    {
		return (org.pentanet.model.I_P_ShipmentDoc)MTable.get(getCtx(), org.pentanet.model.I_P_ShipmentDoc.Table_Name)
			.getPO(getP_ShipmentDoc_ID(), get_TrxName());	}

	/** Set P_ShipmentDoc.
		@param P_ShipmentDoc_ID P_ShipmentDoc	  */
	public void setP_ShipmentDoc_ID (int P_ShipmentDoc_ID)
	{
		if (P_ShipmentDoc_ID < 1) 
			set_Value (COLUMNNAME_P_ShipmentDoc_ID, null);
		else 
			set_Value (COLUMNNAME_P_ShipmentDoc_ID, Integer.valueOf(P_ShipmentDoc_ID));
	}

	/** Get P_ShipmentDoc.
		@return P_ShipmentDoc	  */
	public int getP_ShipmentDoc_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_P_ShipmentDoc_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set P_ShipmentDocLine.
		@param P_ShipmentDocLine_ID P_ShipmentDocLine	  */
	public void setP_ShipmentDocLine_ID (int P_ShipmentDocLine_ID)
	{
		if (P_ShipmentDocLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_P_ShipmentDocLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_P_ShipmentDocLine_ID, Integer.valueOf(P_ShipmentDocLine_ID));
	}

	/** Get P_ShipmentDocLine.
		@return P_ShipmentDocLine	  */
	public int getP_ShipmentDocLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_P_ShipmentDocLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}