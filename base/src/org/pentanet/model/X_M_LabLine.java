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

/** Generated Model for M_LabLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_M_LabLine extends PO implements I_M_LabLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131016L;

    /** Standard Constructor */
    public X_M_LabLine (Properties ctx, int M_LabLine_ID, String trxName)
    {
      super (ctx, M_LabLine_ID, trxName);
      /** if (M_LabLine_ID == 0)
        {
			setM_LabLine_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_M_LabLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_LabLine[")
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

	public I_M_Lab getM_Lab() throws RuntimeException
    {
		return (I_M_Lab)MTable.get(getCtx(), I_M_Lab.Table_Name)
			.getPO(getM_Lab_ID(), get_TrxName());	}

	/** Set M_Lab_ID.
		@param M_Lab_ID M_Lab_ID	  */
	public void setM_Lab_ID (int M_Lab_ID)
	{
		if (M_Lab_ID < 1) 
			set_Value (COLUMNNAME_M_Lab_ID, null);
		else 
			set_Value (COLUMNNAME_M_Lab_ID, Integer.valueOf(M_Lab_ID));
	}

	/** Get M_Lab_ID.
		@return M_Lab_ID	  */
	public int getM_Lab_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Lab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_LabLine.
		@param M_LabLine_ID M_LabLine	  */
	public void setM_LabLine_ID (int M_LabLine_ID)
	{
		if (M_LabLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_LabLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_LabLine_ID, Integer.valueOf(M_LabLine_ID));
	}

	/** Get M_LabLine.
		@return M_LabLine	  */
	public int getM_LabLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_LabLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_M_Test getM_Test() throws RuntimeException
    {
		return (org.pentanet.model.I_M_Test)MTable.get(getCtx(), org.pentanet.model.I_M_Test.Table_Name)
			.getPO(getM_Test_ID(), get_TrxName());	}

	/** Set M_Test.
		@param M_Test_ID M_Test	  */
	public void setM_Test_ID (int M_Test_ID)
	{
		if (M_Test_ID < 1) 
			set_Value (COLUMNNAME_M_Test_ID, null);
		else 
			set_Value (COLUMNNAME_M_Test_ID, Integer.valueOf(M_Test_ID));
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

	/** Set Result1.
		@param Result1 Result1	  */
	public void setResult1 (String Result1)
	{
		set_Value (COLUMNNAME_Result1, Result1);
	}

	/** Get Result1.
		@return Result1	  */
	public String getResult1 () 
	{
		return (String)get_Value(COLUMNNAME_Result1);
	}

	/** Set Result10.
		@param Result10 Result10	  */
	public void setResult10 (String Result10)
	{
		set_Value (COLUMNNAME_Result10, Result10);
	}

	/** Get Result10.
		@return Result10	  */
	public String getResult10 () 
	{
		return (String)get_Value(COLUMNNAME_Result10);
	}

	/** Set Result11.
		@param Result11 Result11	  */
	public void setResult11 (String Result11)
	{
		set_Value (COLUMNNAME_Result11, Result11);
	}

	/** Get Result11.
		@return Result11	  */
	public String getResult11 () 
	{
		return (String)get_Value(COLUMNNAME_Result11);
	}

	/** Set Result12.
		@param Result12 Result12	  */
	public void setResult12 (String Result12)
	{
		set_Value (COLUMNNAME_Result12, Result12);
	}

	/** Get Result12.
		@return Result12	  */
	public String getResult12 () 
	{
		return (String)get_Value(COLUMNNAME_Result12);
	}

	/** Set Result13.
		@param Result13 Result13	  */
	public void setResult13 (String Result13)
	{
		set_Value (COLUMNNAME_Result13, Result13);
	}

	/** Get Result13.
		@return Result13	  */
	public String getResult13 () 
	{
		return (String)get_Value(COLUMNNAME_Result13);
	}

	/** Set Result14.
		@param Result14 Result14	  */
	public void setResult14 (String Result14)
	{
		set_Value (COLUMNNAME_Result14, Result14);
	}

	/** Get Result14.
		@return Result14	  */
	public String getResult14 () 
	{
		return (String)get_Value(COLUMNNAME_Result14);
	}

	/** Set Result15.
		@param Result15 Result15	  */
	public void setResult15 (String Result15)
	{
		set_Value (COLUMNNAME_Result15, Result15);
	}

	/** Get Result15.
		@return Result15	  */
	public String getResult15 () 
	{
		return (String)get_Value(COLUMNNAME_Result15);
	}

	/** Set Result16.
		@param Result16 Result16	  */
	public void setResult16 (String Result16)
	{
		set_Value (COLUMNNAME_Result16, Result16);
	}

	/** Get Result16.
		@return Result16	  */
	public String getResult16 () 
	{
		return (String)get_Value(COLUMNNAME_Result16);
	}

	/** Set Result17.
		@param Result17 Result17	  */
	public void setResult17 (String Result17)
	{
		set_Value (COLUMNNAME_Result17, Result17);
	}

	/** Get Result17.
		@return Result17	  */
	public String getResult17 () 
	{
		return (String)get_Value(COLUMNNAME_Result17);
	}

	/** Set Result18.
		@param Result18 Result18	  */
	public void setResult18 (String Result18)
	{
		set_Value (COLUMNNAME_Result18, Result18);
	}

	/** Get Result18.
		@return Result18	  */
	public String getResult18 () 
	{
		return (String)get_Value(COLUMNNAME_Result18);
	}

	/** Set Result19.
		@param Result19 Result19	  */
	public void setResult19 (String Result19)
	{
		set_Value (COLUMNNAME_Result19, Result19);
	}

	/** Get Result19.
		@return Result19	  */
	public String getResult19 () 
	{
		return (String)get_Value(COLUMNNAME_Result19);
	}

	/** Set Result2.
		@param Result2 Result2	  */
	public void setResult2 (String Result2)
	{
		set_Value (COLUMNNAME_Result2, Result2);
	}

	/** Get Result2.
		@return Result2	  */
	public String getResult2 () 
	{
		return (String)get_Value(COLUMNNAME_Result2);
	}

	/** Set Result20.
		@param Result20 Result20	  */
	public void setResult20 (String Result20)
	{
		set_Value (COLUMNNAME_Result20, Result20);
	}

	/** Get Result20.
		@return Result20	  */
	public String getResult20 () 
	{
		return (String)get_Value(COLUMNNAME_Result20);
	}

	/** Set Result3.
		@param Result3 Result3	  */
	public void setResult3 (String Result3)
	{
		set_Value (COLUMNNAME_Result3, Result3);
	}

	/** Get Result3.
		@return Result3	  */
	public String getResult3 () 
	{
		return (String)get_Value(COLUMNNAME_Result3);
	}

	/** Set Result4.
		@param Result4 Result4	  */
	public void setResult4 (String Result4)
	{
		set_Value (COLUMNNAME_Result4, Result4);
	}

	/** Get Result4.
		@return Result4	  */
	public String getResult4 () 
	{
		return (String)get_Value(COLUMNNAME_Result4);
	}

	/** Set Result5.
		@param Result5 Result5	  */
	public void setResult5 (String Result5)
	{
		set_Value (COLUMNNAME_Result5, Result5);
	}

	/** Get Result5.
		@return Result5	  */
	public String getResult5 () 
	{
		return (String)get_Value(COLUMNNAME_Result5);
	}

	/** Set Result6.
		@param Result6 Result6	  */
	public void setResult6 (String Result6)
	{
		set_Value (COLUMNNAME_Result6, Result6);
	}

	/** Get Result6.
		@return Result6	  */
	public String getResult6 () 
	{
		return (String)get_Value(COLUMNNAME_Result6);
	}

	/** Set Result7.
		@param Result7 Result7	  */
	public void setResult7 (String Result7)
	{
		set_Value (COLUMNNAME_Result7, Result7);
	}

	/** Get Result7.
		@return Result7	  */
	public String getResult7 () 
	{
		return (String)get_Value(COLUMNNAME_Result7);
	}

	/** Set Result8.
		@param Result8 Result8	  */
	public void setResult8 (String Result8)
	{
		set_Value (COLUMNNAME_Result8, Result8);
	}

	/** Get Result8.
		@return Result8	  */
	public String getResult8 () 
	{
		return (String)get_Value(COLUMNNAME_Result8);
	}

	/** Set Result9.
		@param Result9 Result9	  */
	public void setResult9 (String Result9)
	{
		set_Value (COLUMNNAME_Result9, Result9);
	}

	/** Get Result9.
		@return Result9	  */
	public String getResult9 () 
	{
		return (String)get_Value(COLUMNNAME_Result9);
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