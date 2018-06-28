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

/** Generated Model for HR_WorkedTimeLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE) - $Id$ */
public class X_HR_WorkedTimeLine extends PO implements I_HR_WorkedTimeLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131115L;

    /** Standard Constructor */
    public X_HR_WorkedTimeLine (Properties ctx, int HR_WorkedTimeLine_ID, String trxName)
    {
      super (ctx, HR_WorkedTimeLine_ID, trxName);
      /** if (HR_WorkedTimeLine_ID == 0)
        {
			setC_BPartner_ID (0);
			setHR_WorkedTimeLine_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_WorkedTimeLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_WorkedTimeLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Activity getActivity10() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity10_ID(), get_TrxName());	}

	/** Set Activity10_ID.
		@param Activity10_ID Activity10_ID	  */
	public void setActivity10_ID (int Activity10_ID)
	{
		if (Activity10_ID < 1) 
			set_Value (COLUMNNAME_Activity10_ID, null);
		else 
			set_Value (COLUMNNAME_Activity10_ID, Integer.valueOf(Activity10_ID));
	}

	/** Get Activity10_ID.
		@return Activity10_ID	  */
	public int getActivity10_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity10_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity11() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity11_ID(), get_TrxName());	}

	/** Set Activity11_ID.
		@param Activity11_ID Activity11_ID	  */
	public void setActivity11_ID (int Activity11_ID)
	{
		if (Activity11_ID < 1) 
			set_Value (COLUMNNAME_Activity11_ID, null);
		else 
			set_Value (COLUMNNAME_Activity11_ID, Integer.valueOf(Activity11_ID));
	}

	/** Get Activity11_ID.
		@return Activity11_ID	  */
	public int getActivity11_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity11_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity12() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity12_ID(), get_TrxName());	}

	/** Set Activity12_ID.
		@param Activity12_ID Activity12_ID	  */
	public void setActivity12_ID (int Activity12_ID)
	{
		if (Activity12_ID < 1) 
			set_Value (COLUMNNAME_Activity12_ID, null);
		else 
			set_Value (COLUMNNAME_Activity12_ID, Integer.valueOf(Activity12_ID));
	}

	/** Get Activity12_ID.
		@return Activity12_ID	  */
	public int getActivity12_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity12_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity13() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity13_ID(), get_TrxName());	}

	/** Set Activity13_ID.
		@param Activity13_ID Activity13_ID	  */
	public void setActivity13_ID (int Activity13_ID)
	{
		if (Activity13_ID < 1) 
			set_Value (COLUMNNAME_Activity13_ID, null);
		else 
			set_Value (COLUMNNAME_Activity13_ID, Integer.valueOf(Activity13_ID));
	}

	/** Get Activity13_ID.
		@return Activity13_ID	  */
	public int getActivity13_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity13_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity14() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity14_ID(), get_TrxName());	}

	/** Set Activity14_ID.
		@param Activity14_ID Activity14_ID	  */
	public void setActivity14_ID (int Activity14_ID)
	{
		if (Activity14_ID < 1) 
			set_Value (COLUMNNAME_Activity14_ID, null);
		else 
			set_Value (COLUMNNAME_Activity14_ID, Integer.valueOf(Activity14_ID));
	}

	/** Get Activity14_ID.
		@return Activity14_ID	  */
	public int getActivity14_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity14_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity15() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity15_ID(), get_TrxName());	}

	/** Set Activity15_ID.
		@param Activity15_ID Activity15_ID	  */
	public void setActivity15_ID (int Activity15_ID)
	{
		if (Activity15_ID < 1) 
			set_Value (COLUMNNAME_Activity15_ID, null);
		else 
			set_Value (COLUMNNAME_Activity15_ID, Integer.valueOf(Activity15_ID));
	}

	/** Get Activity15_ID.
		@return Activity15_ID	  */
	public int getActivity15_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity15_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity16() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity16_ID(), get_TrxName());	}

	/** Set Activity16_ID.
		@param Activity16_ID Activity16_ID	  */
	public void setActivity16_ID (int Activity16_ID)
	{
		if (Activity16_ID < 1) 
			set_Value (COLUMNNAME_Activity16_ID, null);
		else 
			set_Value (COLUMNNAME_Activity16_ID, Integer.valueOf(Activity16_ID));
	}

	/** Get Activity16_ID.
		@return Activity16_ID	  */
	public int getActivity16_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity16_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity17() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity17_ID(), get_TrxName());	}

	/** Set Activity17_ID.
		@param Activity17_ID Activity17_ID	  */
	public void setActivity17_ID (int Activity17_ID)
	{
		if (Activity17_ID < 1) 
			set_Value (COLUMNNAME_Activity17_ID, null);
		else 
			set_Value (COLUMNNAME_Activity17_ID, Integer.valueOf(Activity17_ID));
	}

	/** Get Activity17_ID.
		@return Activity17_ID	  */
	public int getActivity17_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity17_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity18() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity18_ID(), get_TrxName());	}

	/** Set Activity18_ID.
		@param Activity18_ID Activity18_ID	  */
	public void setActivity18_ID (int Activity18_ID)
	{
		if (Activity18_ID < 1) 
			set_Value (COLUMNNAME_Activity18_ID, null);
		else 
			set_Value (COLUMNNAME_Activity18_ID, Integer.valueOf(Activity18_ID));
	}

	/** Get Activity18_ID.
		@return Activity18_ID	  */
	public int getActivity18_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity18_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity19() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity19_ID(), get_TrxName());	}

	/** Set Activity19_ID.
		@param Activity19_ID Activity19_ID	  */
	public void setActivity19_ID (int Activity19_ID)
	{
		if (Activity19_ID < 1) 
			set_Value (COLUMNNAME_Activity19_ID, null);
		else 
			set_Value (COLUMNNAME_Activity19_ID, Integer.valueOf(Activity19_ID));
	}

	/** Get Activity19_ID.
		@return Activity19_ID	  */
	public int getActivity19_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity19_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity1() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity1_ID(), get_TrxName());	}

	/** Set Activity1_ID.
		@param Activity1_ID Activity1_ID	  */
	public void setActivity1_ID (int Activity1_ID)
	{
		if (Activity1_ID < 1) 
			set_Value (COLUMNNAME_Activity1_ID, null);
		else 
			set_Value (COLUMNNAME_Activity1_ID, Integer.valueOf(Activity1_ID));
	}

	/** Get Activity1_ID.
		@return Activity1_ID	  */
	public int getActivity1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity20() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity20_ID(), get_TrxName());	}

	/** Set Activity20_ID.
		@param Activity20_ID Activity20_ID	  */
	public void setActivity20_ID (int Activity20_ID)
	{
		if (Activity20_ID < 1) 
			set_Value (COLUMNNAME_Activity20_ID, null);
		else 
			set_Value (COLUMNNAME_Activity20_ID, Integer.valueOf(Activity20_ID));
	}

	/** Get Activity20_ID.
		@return Activity20_ID	  */
	public int getActivity20_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity20_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity21() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity21_ID(), get_TrxName());	}

	/** Set Activity21_ID.
		@param Activity21_ID Activity21_ID	  */
	public void setActivity21_ID (int Activity21_ID)
	{
		if (Activity21_ID < 1) 
			set_Value (COLUMNNAME_Activity21_ID, null);
		else 
			set_Value (COLUMNNAME_Activity21_ID, Integer.valueOf(Activity21_ID));
	}

	/** Get Activity21_ID.
		@return Activity21_ID	  */
	public int getActivity21_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity21_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity22() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity22_ID(), get_TrxName());	}

	/** Set Activity22_ID.
		@param Activity22_ID Activity22_ID	  */
	public void setActivity22_ID (int Activity22_ID)
	{
		if (Activity22_ID < 1) 
			set_Value (COLUMNNAME_Activity22_ID, null);
		else 
			set_Value (COLUMNNAME_Activity22_ID, Integer.valueOf(Activity22_ID));
	}

	/** Get Activity22_ID.
		@return Activity22_ID	  */
	public int getActivity22_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity22_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity23() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity23_ID(), get_TrxName());	}

	/** Set Activity23_ID.
		@param Activity23_ID Activity23_ID	  */
	public void setActivity23_ID (int Activity23_ID)
	{
		if (Activity23_ID < 1) 
			set_Value (COLUMNNAME_Activity23_ID, null);
		else 
			set_Value (COLUMNNAME_Activity23_ID, Integer.valueOf(Activity23_ID));
	}

	/** Get Activity23_ID.
		@return Activity23_ID	  */
	public int getActivity23_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity23_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity24() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity24_ID(), get_TrxName());	}

	/** Set Activity24_ID.
		@param Activity24_ID Activity24_ID	  */
	public void setActivity24_ID (int Activity24_ID)
	{
		if (Activity24_ID < 1) 
			set_Value (COLUMNNAME_Activity24_ID, null);
		else 
			set_Value (COLUMNNAME_Activity24_ID, Integer.valueOf(Activity24_ID));
	}

	/** Get Activity24_ID.
		@return Activity24_ID	  */
	public int getActivity24_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity24_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity25() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity25_ID(), get_TrxName());	}

	/** Set Activity25_ID.
		@param Activity25_ID Activity25_ID	  */
	public void setActivity25_ID (int Activity25_ID)
	{
		if (Activity25_ID < 1) 
			set_Value (COLUMNNAME_Activity25_ID, null);
		else 
			set_Value (COLUMNNAME_Activity25_ID, Integer.valueOf(Activity25_ID));
	}

	/** Get Activity25_ID.
		@return Activity25_ID	  */
	public int getActivity25_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity25_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity26() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity26_ID(), get_TrxName());	}

	/** Set Activity26_ID.
		@param Activity26_ID Activity26_ID	  */
	public void setActivity26_ID (int Activity26_ID)
	{
		if (Activity26_ID < 1) 
			set_Value (COLUMNNAME_Activity26_ID, null);
		else 
			set_Value (COLUMNNAME_Activity26_ID, Integer.valueOf(Activity26_ID));
	}

	/** Get Activity26_ID.
		@return Activity26_ID	  */
	public int getActivity26_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity26_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity27() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity27_ID(), get_TrxName());	}

	/** Set Activity27_ID.
		@param Activity27_ID Activity27_ID	  */
	public void setActivity27_ID (int Activity27_ID)
	{
		if (Activity27_ID < 1) 
			set_Value (COLUMNNAME_Activity27_ID, null);
		else 
			set_Value (COLUMNNAME_Activity27_ID, Integer.valueOf(Activity27_ID));
	}

	/** Get Activity27_ID.
		@return Activity27_ID	  */
	public int getActivity27_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity27_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity28() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity28_ID(), get_TrxName());	}

	/** Set Activity28_ID.
		@param Activity28_ID Activity28_ID	  */
	public void setActivity28_ID (int Activity28_ID)
	{
		if (Activity28_ID < 1) 
			set_Value (COLUMNNAME_Activity28_ID, null);
		else 
			set_Value (COLUMNNAME_Activity28_ID, Integer.valueOf(Activity28_ID));
	}

	/** Get Activity28_ID.
		@return Activity28_ID	  */
	public int getActivity28_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity28_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity29() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity29_ID(), get_TrxName());	}

	/** Set Activity29_ID.
		@param Activity29_ID Activity29_ID	  */
	public void setActivity29_ID (int Activity29_ID)
	{
		if (Activity29_ID < 1) 
			set_Value (COLUMNNAME_Activity29_ID, null);
		else 
			set_Value (COLUMNNAME_Activity29_ID, Integer.valueOf(Activity29_ID));
	}

	/** Get Activity29_ID.
		@return Activity29_ID	  */
	public int getActivity29_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity29_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity2() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity2_ID(), get_TrxName());	}

	/** Set Activity2_ID.
		@param Activity2_ID Activity2_ID	  */
	public void setActivity2_ID (int Activity2_ID)
	{
		if (Activity2_ID < 1) 
			set_Value (COLUMNNAME_Activity2_ID, null);
		else 
			set_Value (COLUMNNAME_Activity2_ID, Integer.valueOf(Activity2_ID));
	}

	/** Get Activity2_ID.
		@return Activity2_ID	  */
	public int getActivity2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity30() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity30_ID(), get_TrxName());	}

	/** Set Activity30_ID.
		@param Activity30_ID Activity30_ID	  */
	public void setActivity30_ID (int Activity30_ID)
	{
		if (Activity30_ID < 1) 
			set_Value (COLUMNNAME_Activity30_ID, null);
		else 
			set_Value (COLUMNNAME_Activity30_ID, Integer.valueOf(Activity30_ID));
	}

	/** Get Activity30_ID.
		@return Activity30_ID	  */
	public int getActivity30_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity30_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity31() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity31_ID(), get_TrxName());	}

	/** Set Activity31_ID.
		@param Activity31_ID Activity31_ID	  */
	public void setActivity31_ID (int Activity31_ID)
	{
		if (Activity31_ID < 1) 
			set_Value (COLUMNNAME_Activity31_ID, null);
		else 
			set_Value (COLUMNNAME_Activity31_ID, Integer.valueOf(Activity31_ID));
	}

	/** Get Activity31_ID.
		@return Activity31_ID	  */
	public int getActivity31_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity31_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity3() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity3_ID(), get_TrxName());	}

	/** Set Activity3_ID.
		@param Activity3_ID Activity3_ID	  */
	public void setActivity3_ID (int Activity3_ID)
	{
		if (Activity3_ID < 1) 
			set_Value (COLUMNNAME_Activity3_ID, null);
		else 
			set_Value (COLUMNNAME_Activity3_ID, Integer.valueOf(Activity3_ID));
	}

	/** Get Activity3_ID.
		@return Activity3_ID	  */
	public int getActivity3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity4() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity4_ID(), get_TrxName());	}

	/** Set Activity4_ID.
		@param Activity4_ID Activity4_ID	  */
	public void setActivity4_ID (int Activity4_ID)
	{
		if (Activity4_ID < 1) 
			set_Value (COLUMNNAME_Activity4_ID, null);
		else 
			set_Value (COLUMNNAME_Activity4_ID, Integer.valueOf(Activity4_ID));
	}

	/** Get Activity4_ID.
		@return Activity4_ID	  */
	public int getActivity4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity5() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity5_ID(), get_TrxName());	}

	/** Set Activity5_ID.
		@param Activity5_ID Activity5_ID	  */
	public void setActivity5_ID (int Activity5_ID)
	{
		if (Activity5_ID < 1) 
			set_Value (COLUMNNAME_Activity5_ID, null);
		else 
			set_Value (COLUMNNAME_Activity5_ID, Integer.valueOf(Activity5_ID));
	}

	/** Get Activity5_ID.
		@return Activity5_ID	  */
	public int getActivity5_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity5_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity6() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity6_ID(), get_TrxName());	}

	/** Set Activity6_ID.
		@param Activity6_ID Activity6_ID	  */
	public void setActivity6_ID (int Activity6_ID)
	{
		if (Activity6_ID < 1) 
			set_Value (COLUMNNAME_Activity6_ID, null);
		else 
			set_Value (COLUMNNAME_Activity6_ID, Integer.valueOf(Activity6_ID));
	}

	/** Get Activity6_ID.
		@return Activity6_ID	  */
	public int getActivity6_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity6_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity7() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity7_ID(), get_TrxName());	}

	/** Set Activity7_ID.
		@param Activity7_ID Activity7_ID	  */
	public void setActivity7_ID (int Activity7_ID)
	{
		if (Activity7_ID < 1) 
			set_Value (COLUMNNAME_Activity7_ID, null);
		else 
			set_Value (COLUMNNAME_Activity7_ID, Integer.valueOf(Activity7_ID));
	}

	/** Get Activity7_ID.
		@return Activity7_ID	  */
	public int getActivity7_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity7_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity8() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity8_ID(), get_TrxName());	}

	/** Set Activity8_ID.
		@param Activity8_ID Activity8_ID	  */
	public void setActivity8_ID (int Activity8_ID)
	{
		if (Activity8_ID < 1) 
			set_Value (COLUMNNAME_Activity8_ID, null);
		else 
			set_Value (COLUMNNAME_Activity8_ID, Integer.valueOf(Activity8_ID));
	}

	/** Get Activity8_ID.
		@return Activity8_ID	  */
	public int getActivity8_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity8_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getActivity9() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getActivity9_ID(), get_TrxName());	}

	/** Set Activity9_ID.
		@param Activity9_ID Activity9_ID	  */
	public void setActivity9_ID (int Activity9_ID)
	{
		if (Activity9_ID < 1) 
			set_Value (COLUMNNAME_Activity9_ID, null);
		else 
			set_Value (COLUMNNAME_Activity9_ID, Integer.valueOf(Activity9_ID));
	}

	/** Get Activity9_ID.
		@return Activity9_ID	  */
	public int getActivity9_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Activity9_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.pentanet.model.I_HR_Turn getD10() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD10_ID(), get_TrxName());	}

	/** Set D10_ID.
		@param D10_ID D10_ID	  */
	public void setD10_ID (int D10_ID)
	{
		if (D10_ID < 1) 
			set_Value (COLUMNNAME_D10_ID, null);
		else 
			set_Value (COLUMNNAME_D10_ID, Integer.valueOf(D10_ID));
	}

	/** Get D10_ID.
		@return D10_ID	  */
	public int getD10_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D10_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD11() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD11_ID(), get_TrxName());	}

	/** Set D11_ID.
		@param D11_ID D11_ID	  */
	public void setD11_ID (int D11_ID)
	{
		if (D11_ID < 1) 
			set_Value (COLUMNNAME_D11_ID, null);
		else 
			set_Value (COLUMNNAME_D11_ID, Integer.valueOf(D11_ID));
	}

	/** Get D11_ID.
		@return D11_ID	  */
	public int getD11_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D11_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD12() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD12_ID(), get_TrxName());	}

	/** Set D12_ID.
		@param D12_ID D12_ID	  */
	public void setD12_ID (int D12_ID)
	{
		if (D12_ID < 1) 
			set_Value (COLUMNNAME_D12_ID, null);
		else 
			set_Value (COLUMNNAME_D12_ID, Integer.valueOf(D12_ID));
	}

	/** Get D12_ID.
		@return D12_ID	  */
	public int getD12_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D12_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD13() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD13_ID(), get_TrxName());	}

	/** Set D13_ID.
		@param D13_ID D13_ID	  */
	public void setD13_ID (int D13_ID)
	{
		if (D13_ID < 1) 
			set_Value (COLUMNNAME_D13_ID, null);
		else 
			set_Value (COLUMNNAME_D13_ID, Integer.valueOf(D13_ID));
	}

	/** Get D13_ID.
		@return D13_ID	  */
	public int getD13_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D13_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD14() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD14_ID(), get_TrxName());	}

	/** Set D14_ID.
		@param D14_ID D14_ID	  */
	public void setD14_ID (int D14_ID)
	{
		if (D14_ID < 1) 
			set_Value (COLUMNNAME_D14_ID, null);
		else 
			set_Value (COLUMNNAME_D14_ID, Integer.valueOf(D14_ID));
	}

	/** Get D14_ID.
		@return D14_ID	  */
	public int getD14_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D14_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD15() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD15_ID(), get_TrxName());	}

	/** Set D15_ID.
		@param D15_ID D15_ID	  */
	public void setD15_ID (int D15_ID)
	{
		if (D15_ID < 1) 
			set_Value (COLUMNNAME_D15_ID, null);
		else 
			set_Value (COLUMNNAME_D15_ID, Integer.valueOf(D15_ID));
	}

	/** Get D15_ID.
		@return D15_ID	  */
	public int getD15_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D15_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD16() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD16_ID(), get_TrxName());	}

	/** Set D16_ID.
		@param D16_ID D16_ID	  */
	public void setD16_ID (int D16_ID)
	{
		if (D16_ID < 1) 
			set_Value (COLUMNNAME_D16_ID, null);
		else 
			set_Value (COLUMNNAME_D16_ID, Integer.valueOf(D16_ID));
	}

	/** Get D16_ID.
		@return D16_ID	  */
	public int getD16_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D16_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD17() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD17_ID(), get_TrxName());	}

	/** Set D17_ID.
		@param D17_ID D17_ID	  */
	public void setD17_ID (int D17_ID)
	{
		if (D17_ID < 1) 
			set_Value (COLUMNNAME_D17_ID, null);
		else 
			set_Value (COLUMNNAME_D17_ID, Integer.valueOf(D17_ID));
	}

	/** Get D17_ID.
		@return D17_ID	  */
	public int getD17_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D17_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD18() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD18_ID(), get_TrxName());	}

	/** Set D18_ID.
		@param D18_ID D18_ID	  */
	public void setD18_ID (int D18_ID)
	{
		if (D18_ID < 1) 
			set_Value (COLUMNNAME_D18_ID, null);
		else 
			set_Value (COLUMNNAME_D18_ID, Integer.valueOf(D18_ID));
	}

	/** Get D18_ID.
		@return D18_ID	  */
	public int getD18_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D18_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD19() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD19_ID(), get_TrxName());	}

	/** Set D19_ID.
		@param D19_ID D19_ID	  */
	public void setD19_ID (int D19_ID)
	{
		if (D19_ID < 1) 
			set_Value (COLUMNNAME_D19_ID, null);
		else 
			set_Value (COLUMNNAME_D19_ID, Integer.valueOf(D19_ID));
	}

	/** Get D19_ID.
		@return D19_ID	  */
	public int getD19_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D19_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD1() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD1_ID(), get_TrxName());	}

	/** Set D1_ID.
		@param D1_ID D1_ID	  */
	public void setD1_ID (int D1_ID)
	{
		if (D1_ID < 1) 
			set_Value (COLUMNNAME_D1_ID, null);
		else 
			set_Value (COLUMNNAME_D1_ID, Integer.valueOf(D1_ID));
	}

	/** Get D1_ID.
		@return D1_ID	  */
	public int getD1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD20() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD20_ID(), get_TrxName());	}

	/** Set D20_ID.
		@param D20_ID D20_ID	  */
	public void setD20_ID (int D20_ID)
	{
		if (D20_ID < 1) 
			set_Value (COLUMNNAME_D20_ID, null);
		else 
			set_Value (COLUMNNAME_D20_ID, Integer.valueOf(D20_ID));
	}

	/** Get D20_ID.
		@return D20_ID	  */
	public int getD20_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D20_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD21() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD21_ID(), get_TrxName());	}

	/** Set D21_ID.
		@param D21_ID D21_ID	  */
	public void setD21_ID (int D21_ID)
	{
		if (D21_ID < 1) 
			set_Value (COLUMNNAME_D21_ID, null);
		else 
			set_Value (COLUMNNAME_D21_ID, Integer.valueOf(D21_ID));
	}

	/** Get D21_ID.
		@return D21_ID	  */
	public int getD21_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D21_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD22() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD22_ID(), get_TrxName());	}

	/** Set D22_ID.
		@param D22_ID D22_ID	  */
	public void setD22_ID (int D22_ID)
	{
		if (D22_ID < 1) 
			set_Value (COLUMNNAME_D22_ID, null);
		else 
			set_Value (COLUMNNAME_D22_ID, Integer.valueOf(D22_ID));
	}

	/** Get D22_ID.
		@return D22_ID	  */
	public int getD22_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D22_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD23() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD23_ID(), get_TrxName());	}

	/** Set D23_ID.
		@param D23_ID D23_ID	  */
	public void setD23_ID (int D23_ID)
	{
		if (D23_ID < 1) 
			set_Value (COLUMNNAME_D23_ID, null);
		else 
			set_Value (COLUMNNAME_D23_ID, Integer.valueOf(D23_ID));
	}

	/** Get D23_ID.
		@return D23_ID	  */
	public int getD23_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D23_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD24() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD24_ID(), get_TrxName());	}

	/** Set D24_ID.
		@param D24_ID D24_ID	  */
	public void setD24_ID (int D24_ID)
	{
		if (D24_ID < 1) 
			set_Value (COLUMNNAME_D24_ID, null);
		else 
			set_Value (COLUMNNAME_D24_ID, Integer.valueOf(D24_ID));
	}

	/** Get D24_ID.
		@return D24_ID	  */
	public int getD24_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D24_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD25() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD25_ID(), get_TrxName());	}

	/** Set D25_ID.
		@param D25_ID D25_ID	  */
	public void setD25_ID (int D25_ID)
	{
		if (D25_ID < 1) 
			set_Value (COLUMNNAME_D25_ID, null);
		else 
			set_Value (COLUMNNAME_D25_ID, Integer.valueOf(D25_ID));
	}

	/** Get D25_ID.
		@return D25_ID	  */
	public int getD25_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D25_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD26() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD26_ID(), get_TrxName());	}

	/** Set D26_ID.
		@param D26_ID D26_ID	  */
	public void setD26_ID (int D26_ID)
	{
		if (D26_ID < 1) 
			set_Value (COLUMNNAME_D26_ID, null);
		else 
			set_Value (COLUMNNAME_D26_ID, Integer.valueOf(D26_ID));
	}

	/** Get D26_ID.
		@return D26_ID	  */
	public int getD26_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D26_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD27() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD27_ID(), get_TrxName());	}

	/** Set D27_ID.
		@param D27_ID D27_ID	  */
	public void setD27_ID (int D27_ID)
	{
		if (D27_ID < 1) 
			set_Value (COLUMNNAME_D27_ID, null);
		else 
			set_Value (COLUMNNAME_D27_ID, Integer.valueOf(D27_ID));
	}

	/** Get D27_ID.
		@return D27_ID	  */
	public int getD27_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D27_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD28() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD28_ID(), get_TrxName());	}

	/** Set D28_ID.
		@param D28_ID D28_ID	  */
	public void setD28_ID (int D28_ID)
	{
		if (D28_ID < 1) 
			set_Value (COLUMNNAME_D28_ID, null);
		else 
			set_Value (COLUMNNAME_D28_ID, Integer.valueOf(D28_ID));
	}

	/** Get D28_ID.
		@return D28_ID	  */
	public int getD28_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D28_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD29() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD29_ID(), get_TrxName());	}

	/** Set D29_ID.
		@param D29_ID D29_ID	  */
	public void setD29_ID (int D29_ID)
	{
		if (D29_ID < 1) 
			set_Value (COLUMNNAME_D29_ID, null);
		else 
			set_Value (COLUMNNAME_D29_ID, Integer.valueOf(D29_ID));
	}

	/** Get D29_ID.
		@return D29_ID	  */
	public int getD29_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D29_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD2() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD2_ID(), get_TrxName());	}

	/** Set D2_ID.
		@param D2_ID D2_ID	  */
	public void setD2_ID (int D2_ID)
	{
		if (D2_ID < 1) 
			set_Value (COLUMNNAME_D2_ID, null);
		else 
			set_Value (COLUMNNAME_D2_ID, Integer.valueOf(D2_ID));
	}

	/** Get D2_ID.
		@return D2_ID	  */
	public int getD2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD30() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD30_ID(), get_TrxName());	}

	/** Set D30_ID.
		@param D30_ID D30_ID	  */
	public void setD30_ID (int D30_ID)
	{
		if (D30_ID < 1) 
			set_Value (COLUMNNAME_D30_ID, null);
		else 
			set_Value (COLUMNNAME_D30_ID, Integer.valueOf(D30_ID));
	}

	/** Get D30_ID.
		@return D30_ID	  */
	public int getD30_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D30_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD31() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD31_ID(), get_TrxName());	}

	/** Set D31_ID.
		@param D31_ID D31_ID	  */
	public void setD31_ID (int D31_ID)
	{
		if (D31_ID < 1) 
			set_Value (COLUMNNAME_D31_ID, null);
		else 
			set_Value (COLUMNNAME_D31_ID, Integer.valueOf(D31_ID));
	}

	/** Get D31_ID.
		@return D31_ID	  */
	public int getD31_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D31_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD3() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD3_ID(), get_TrxName());	}

	/** Set D3_ID.
		@param D3_ID D3_ID	  */
	public void setD3_ID (int D3_ID)
	{
		if (D3_ID < 1) 
			set_Value (COLUMNNAME_D3_ID, null);
		else 
			set_Value (COLUMNNAME_D3_ID, Integer.valueOf(D3_ID));
	}

	/** Get D3_ID.
		@return D3_ID	  */
	public int getD3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD4() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD4_ID(), get_TrxName());	}

	/** Set D4_ID.
		@param D4_ID D4_ID	  */
	public void setD4_ID (int D4_ID)
	{
		if (D4_ID < 1) 
			set_Value (COLUMNNAME_D4_ID, null);
		else 
			set_Value (COLUMNNAME_D4_ID, Integer.valueOf(D4_ID));
	}

	/** Get D4_ID.
		@return D4_ID	  */
	public int getD4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD5() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD5_ID(), get_TrxName());	}

	/** Set D5_ID.
		@param D5_ID D5_ID	  */
	public void setD5_ID (int D5_ID)
	{
		if (D5_ID < 1) 
			set_Value (COLUMNNAME_D5_ID, null);
		else 
			set_Value (COLUMNNAME_D5_ID, Integer.valueOf(D5_ID));
	}

	/** Get D5_ID.
		@return D5_ID	  */
	public int getD5_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D5_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD6() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD6_ID(), get_TrxName());	}

	/** Set D6_ID.
		@param D6_ID D6_ID	  */
	public void setD6_ID (int D6_ID)
	{
		if (D6_ID < 1) 
			set_Value (COLUMNNAME_D6_ID, null);
		else 
			set_Value (COLUMNNAME_D6_ID, Integer.valueOf(D6_ID));
	}

	/** Get D6_ID.
		@return D6_ID	  */
	public int getD6_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D6_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD7() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD7_ID(), get_TrxName());	}

	/** Set D7_ID.
		@param D7_ID D7_ID	  */
	public void setD7_ID (int D7_ID)
	{
		if (D7_ID < 1) 
			set_Value (COLUMNNAME_D7_ID, null);
		else 
			set_Value (COLUMNNAME_D7_ID, Integer.valueOf(D7_ID));
	}

	/** Get D7_ID.
		@return D7_ID	  */
	public int getD7_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D7_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD8() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD8_ID(), get_TrxName());	}

	/** Set D8_ID.
		@param D8_ID D8_ID	  */
	public void setD8_ID (int D8_ID)
	{
		if (D8_ID < 1) 
			set_Value (COLUMNNAME_D8_ID, null);
		else 
			set_Value (COLUMNNAME_D8_ID, Integer.valueOf(D8_ID));
	}

	/** Get D8_ID.
		@return D8_ID	  */
	public int getD8_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D8_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pentanet.model.I_HR_Turn getD9() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_Turn)MTable.get(getCtx(), org.pentanet.model.I_HR_Turn.Table_Name)
			.getPO(getD9_ID(), get_TrxName());	}

	/** Set D9_ID.
		@param D9_ID D9_ID	  */
	public void setD9_ID (int D9_ID)
	{
		if (D9_ID < 1) 
			set_Value (COLUMNNAME_D9_ID, null);
		else 
			set_Value (COLUMNNAME_D9_ID, Integer.valueOf(D9_ID));
	}

	/** Get D9_ID.
		@return D9_ID	  */
	public int getD9_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_D9_ID);
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

	public org.pentanet.model.I_HR_WorkedTime getHR_WorkedTime() throws RuntimeException
    {
		return (org.pentanet.model.I_HR_WorkedTime)MTable.get(getCtx(), org.pentanet.model.I_HR_WorkedTime.Table_Name)
			.getPO(getHR_WorkedTime_ID(), get_TrxName());	}

	/** Set HR_WorkedTime.
		@param HR_WorkedTime_ID HR_WorkedTime	  */
	public void setHR_WorkedTime_ID (int HR_WorkedTime_ID)
	{
		if (HR_WorkedTime_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTime_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTime_ID, Integer.valueOf(HR_WorkedTime_ID));
	}

	/** Get HR_WorkedTime.
		@return HR_WorkedTime	  */
	public int getHR_WorkedTime_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkedTime_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set HR_WorkedTimeLine.
		@param HR_WorkedTimeLine_ID HR_WorkedTimeLine	  */
	public void setHR_WorkedTimeLine_ID (int HR_WorkedTimeLine_ID)
	{
		if (HR_WorkedTimeLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTimeLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_WorkedTimeLine_ID, Integer.valueOf(HR_WorkedTimeLine_ID));
	}

	/** Get HR_WorkedTimeLine.
		@return HR_WorkedTimeLine	  */
	public int getHR_WorkedTimeLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_WorkedTimeLine_ID);
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