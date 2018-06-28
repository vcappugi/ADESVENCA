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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for M_ProductionPlan
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0.1LTS (VE) - $Id$ */
public class X_M_ProductionPlan extends PO implements I_M_ProductionPlan, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150416L;

    /** Standard Constructor */
    public X_M_ProductionPlan (Properties ctx, int M_ProductionPlan_ID, String trxName)
    {
      super (ctx, M_ProductionPlan_ID, trxName);
      /** if (M_ProductionPlan_ID == 0)
        {
			setExistenceQty (Env.ZERO);
// 0
			setLine (0);
// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM M_ProductionPlan WHERE M_Production_ID=@M_Production_ID@
			setM_Locator_ID (0);
// @M_Locator_ID@
			setM_Product_ID (0);
			setM_Production_ID (0);
			setM_ProductionPlan_ID (0);
			setProcessed (false);
			setProductionQty (Env.ZERO);
// 1
			setRequestQty (Env.ZERO);
// 0
        } */
    }

    /** Load Constructor */
    public X_M_ProductionPlan (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_ProductionPlan[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set aceitemax.
		@param aceitemax aceitemax	  */
	public void setaceitemax (String aceitemax)
	{
		set_Value (COLUMNNAME_aceitemax, aceitemax);
	}

	/** Get aceitemax.
		@return aceitemax	  */
	public String getaceitemax () 
	{
		return (String)get_Value(COLUMNNAME_aceitemax);
	}

	/** Set aceitemin.
		@param aceitemin aceitemin	  */
	public void setaceitemin (String aceitemin)
	{
		set_Value (COLUMNNAME_aceitemin, aceitemin);
	}

	/** Get aceitemin.
		@return aceitemin	  */
	public String getaceitemin () 
	{
		return (String)get_Value(COLUMNNAME_aceitemin);
	}

	/** aceiteuom AD_Reference_ID=53323 */
	public static final int ACEITEUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String ACEITEUOM_Angle = "AN";
	/** Area = AR */
	public static final String ACEITEUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String ACEITEUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String ACEITEUOM_Density = "DE";
	/** Energy = EN */
	public static final String ACEITEUOM_Energy = "EN";
	/** Force = FO */
	public static final String ACEITEUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String ACEITEUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String ACEITEUOM_Length = "LE";
	/** Power = PO */
	public static final String ACEITEUOM_Power = "PO";
	/** Pressure = PR */
	public static final String ACEITEUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String ACEITEUOM_Temperature = "TE";
	/** Time = TM */
	public static final String ACEITEUOM_Time = "TM";
	/** Torque = TO */
	public static final String ACEITEUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String ACEITEUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String ACEITEUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String ACEITEUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String ACEITEUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String ACEITEUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String ACEITEUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String ACEITEUOM_Frequency = "FR";
	/** Other = OT */
	public static final String ACEITEUOM_Other = "OT";
	/** Set aceiteuom.
		@param aceiteuom aceiteuom	  */
	public void setaceiteuom (String aceiteuom)
	{

		set_Value (COLUMNNAME_aceiteuom, aceiteuom);
	}

	/** Get aceiteuom.
		@return aceiteuom	  */
	public String getaceiteuom () 
	{
		return (String)get_Value(COLUMNNAME_aceiteuom);
	}

	/** Set aguamax.
		@param aguamax aguamax	  */
	public void setaguamax (String aguamax)
	{
		set_Value (COLUMNNAME_aguamax, aguamax);
	}

	/** Get aguamax.
		@return aguamax	  */
	public String getaguamax () 
	{
		return (String)get_Value(COLUMNNAME_aguamax);
	}

	/** Set aguamin.
		@param aguamin aguamin	  */
	public void setaguamin (String aguamin)
	{
		set_Value (COLUMNNAME_aguamin, aguamin);
	}

	/** Get aguamin.
		@return aguamin	  */
	public String getaguamin () 
	{
		return (String)get_Value(COLUMNNAME_aguamin);
	}

	/** aguauom AD_Reference_ID=53323 */
	public static final int AGUAUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String AGUAUOM_Angle = "AN";
	/** Area = AR */
	public static final String AGUAUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String AGUAUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String AGUAUOM_Density = "DE";
	/** Energy = EN */
	public static final String AGUAUOM_Energy = "EN";
	/** Force = FO */
	public static final String AGUAUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String AGUAUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String AGUAUOM_Length = "LE";
	/** Power = PO */
	public static final String AGUAUOM_Power = "PO";
	/** Pressure = PR */
	public static final String AGUAUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String AGUAUOM_Temperature = "TE";
	/** Time = TM */
	public static final String AGUAUOM_Time = "TM";
	/** Torque = TO */
	public static final String AGUAUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String AGUAUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String AGUAUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String AGUAUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String AGUAUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String AGUAUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String AGUAUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String AGUAUOM_Frequency = "FR";
	/** Other = OT */
	public static final String AGUAUOM_Other = "OT";
	/** Set aguauom.
		@param aguauom aguauom	  */
	public void setaguauom (String aguauom)
	{

		set_Value (COLUMNNAME_aguauom, aguauom);
	}

	/** Get aguauom.
		@return aguauom	  */
	public String getaguauom () 
	{
		return (String)get_Value(COLUMNNAME_aguauom);
	}

	/** Set alcalinidadmax.
		@param alcalinidadmax alcalinidadmax	  */
	public void setalcalinidadmax (String alcalinidadmax)
	{
		set_Value (COLUMNNAME_alcalinidadmax, alcalinidadmax);
	}

	/** Get alcalinidadmax.
		@return alcalinidadmax	  */
	public String getalcalinidadmax () 
	{
		return (String)get_Value(COLUMNNAME_alcalinidadmax);
	}

	/** Set alcalinidadmin.
		@param alcalinidadmin alcalinidadmin	  */
	public void setalcalinidadmin (String alcalinidadmin)
	{
		set_Value (COLUMNNAME_alcalinidadmin, alcalinidadmin);
	}

	/** Get alcalinidadmin.
		@return alcalinidadmin	  */
	public String getalcalinidadmin () 
	{
		return (String)get_Value(COLUMNNAME_alcalinidadmin);
	}

	/** alcalinidaduom AD_Reference_ID=53323 */
	public static final int ALCALINIDADUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String ALCALINIDADUOM_Angle = "AN";
	/** Area = AR */
	public static final String ALCALINIDADUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String ALCALINIDADUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String ALCALINIDADUOM_Density = "DE";
	/** Energy = EN */
	public static final String ALCALINIDADUOM_Energy = "EN";
	/** Force = FO */
	public static final String ALCALINIDADUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String ALCALINIDADUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String ALCALINIDADUOM_Length = "LE";
	/** Power = PO */
	public static final String ALCALINIDADUOM_Power = "PO";
	/** Pressure = PR */
	public static final String ALCALINIDADUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String ALCALINIDADUOM_Temperature = "TE";
	/** Time = TM */
	public static final String ALCALINIDADUOM_Time = "TM";
	/** Torque = TO */
	public static final String ALCALINIDADUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String ALCALINIDADUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String ALCALINIDADUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String ALCALINIDADUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String ALCALINIDADUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String ALCALINIDADUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String ALCALINIDADUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String ALCALINIDADUOM_Frequency = "FR";
	/** Other = OT */
	public static final String ALCALINIDADUOM_Other = "OT";
	/** Set alcalinidaduom.
		@param alcalinidaduom alcalinidaduom	  */
	public void setalcalinidaduom (String alcalinidaduom)
	{

		set_Value (COLUMNNAME_alcalinidaduom, alcalinidaduom);
	}

	/** Get alcalinidaduom.
		@return alcalinidaduom	  */
	public String getalcalinidaduom () 
	{
		return (String)get_Value(COLUMNNAME_alcalinidaduom);
	}

	/** Set arenamax.
		@param arenamax arenamax	  */
	public void setarenamax (String arenamax)
	{
		set_Value (COLUMNNAME_arenamax, arenamax);
	}

	/** Get arenamax.
		@return arenamax	  */
	public String getarenamax () 
	{
		return (String)get_Value(COLUMNNAME_arenamax);
	}

	/** Set arenamin.
		@param arenamin arenamin	  */
	public void setarenamin (String arenamin)
	{
		set_Value (COLUMNNAME_arenamin, arenamin);
	}

	/** Get arenamin.
		@return arenamin	  */
	public String getarenamin () 
	{
		return (String)get_Value(COLUMNNAME_arenamin);
	}

	/** arenauom AD_Reference_ID=53323 */
	public static final int ARENAUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String ARENAUOM_Angle = "AN";
	/** Area = AR */
	public static final String ARENAUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String ARENAUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String ARENAUOM_Density = "DE";
	/** Energy = EN */
	public static final String ARENAUOM_Energy = "EN";
	/** Force = FO */
	public static final String ARENAUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String ARENAUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String ARENAUOM_Length = "LE";
	/** Power = PO */
	public static final String ARENAUOM_Power = "PO";
	/** Pressure = PR */
	public static final String ARENAUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String ARENAUOM_Temperature = "TE";
	/** Time = TM */
	public static final String ARENAUOM_Time = "TM";
	/** Torque = TO */
	public static final String ARENAUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String ARENAUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String ARENAUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String ARENAUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String ARENAUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String ARENAUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String ARENAUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String ARENAUOM_Frequency = "FR";
	/** Other = OT */
	public static final String ARENAUOM_Other = "OT";
	/** Set arenauom.
		@param arenauom arenauom	  */
	public void setarenauom (String arenauom)
	{

		set_Value (COLUMNNAME_arenauom, arenauom);
	}

	/** Get arenauom.
		@return arenauom	  */
	public String getarenauom () 
	{
		return (String)get_Value(COLUMNNAME_arenauom);
	}

	/** Set BaseDensity.
		@param BaseDensity BaseDensity	  */
	public void setBaseDensity (BigDecimal BaseDensity)
	{
		set_Value (COLUMNNAME_BaseDensity, BaseDensity);
	}

	/** Get BaseDensity.
		@return BaseDensity	  */
	public BigDecimal getBaseDensity () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BaseDensity);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Densidadmax.
		@param Densidadmax Densidadmax	  */
	public void setDensidadmax (String Densidadmax)
	{
		set_Value (COLUMNNAME_Densidadmax, Densidadmax);
	}

	/** Get Densidadmax.
		@return Densidadmax	  */
	public String getDensidadmax () 
	{
		return (String)get_Value(COLUMNNAME_Densidadmax);
	}

	/** Set Densidadmin.
		@param Densidadmin Densidadmin	  */
	public void setDensidadmin (String Densidadmin)
	{
		set_Value (COLUMNNAME_Densidadmin, Densidadmin);
	}

	/** Get Densidadmin.
		@return Densidadmin	  */
	public String getDensidadmin () 
	{
		return (String)get_Value(COLUMNNAME_Densidadmin);
	}

	/** densidaduom AD_Reference_ID=53323 */
	public static final int DENSIDADUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String DENSIDADUOM_Angle = "AN";
	/** Area = AR */
	public static final String DENSIDADUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String DENSIDADUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String DENSIDADUOM_Density = "DE";
	/** Energy = EN */
	public static final String DENSIDADUOM_Energy = "EN";
	/** Force = FO */
	public static final String DENSIDADUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String DENSIDADUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String DENSIDADUOM_Length = "LE";
	/** Power = PO */
	public static final String DENSIDADUOM_Power = "PO";
	/** Pressure = PR */
	public static final String DENSIDADUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String DENSIDADUOM_Temperature = "TE";
	/** Time = TM */
	public static final String DENSIDADUOM_Time = "TM";
	/** Torque = TO */
	public static final String DENSIDADUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String DENSIDADUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String DENSIDADUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String DENSIDADUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String DENSIDADUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String DENSIDADUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String DENSIDADUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String DENSIDADUOM_Frequency = "FR";
	/** Other = OT */
	public static final String DENSIDADUOM_Other = "OT";
	/** Set densidaduom.
		@param densidaduom densidaduom	  */
	public void setdensidaduom (String densidaduom)
	{

		set_Value (COLUMNNAME_densidaduom, densidaduom);
	}

	/** Get densidaduom.
		@return densidaduom	  */
	public String getdensidaduom () 
	{
		return (String)get_Value(COLUMNNAME_densidaduom);
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

	/** Set EndDensity.
		@param EndDensity EndDensity	  */
	public void setEndDensity (BigDecimal EndDensity)
	{
		set_Value (COLUMNNAME_EndDensity, EndDensity);
	}

	/** Get EndDensity.
		@return EndDensity	  */
	public BigDecimal getEndDensity () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_EndDensity);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set estabielectmax.
		@param estabielectmax estabielectmax	  */
	public void setestabielectmax (String estabielectmax)
	{
		set_Value (COLUMNNAME_estabielectmax, estabielectmax);
	}

	/** Get estabielectmax.
		@return estabielectmax	  */
	public String getestabielectmax () 
	{
		return (String)get_Value(COLUMNNAME_estabielectmax);
	}

	/** Set estabielectmin.
		@param estabielectmin estabielectmin	  */
	public void setestabielectmin (String estabielectmin)
	{
		set_Value (COLUMNNAME_estabielectmin, estabielectmin);
	}

	/** Get estabielectmin.
		@return estabielectmin	  */
	public String getestabielectmin () 
	{
		return (String)get_Value(COLUMNNAME_estabielectmin);
	}

	/** estabielectuom AD_Reference_ID=53323 */
	public static final int ESTABIELECTUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String ESTABIELECTUOM_Angle = "AN";
	/** Area = AR */
	public static final String ESTABIELECTUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String ESTABIELECTUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String ESTABIELECTUOM_Density = "DE";
	/** Energy = EN */
	public static final String ESTABIELECTUOM_Energy = "EN";
	/** Force = FO */
	public static final String ESTABIELECTUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String ESTABIELECTUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String ESTABIELECTUOM_Length = "LE";
	/** Power = PO */
	public static final String ESTABIELECTUOM_Power = "PO";
	/** Pressure = PR */
	public static final String ESTABIELECTUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String ESTABIELECTUOM_Temperature = "TE";
	/** Time = TM */
	public static final String ESTABIELECTUOM_Time = "TM";
	/** Torque = TO */
	public static final String ESTABIELECTUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String ESTABIELECTUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String ESTABIELECTUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String ESTABIELECTUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String ESTABIELECTUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String ESTABIELECTUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String ESTABIELECTUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String ESTABIELECTUOM_Frequency = "FR";
	/** Other = OT */
	public static final String ESTABIELECTUOM_Other = "OT";
	/** Set estabielectuom.
		@param estabielectuom estabielectuom	  */
	public void setestabielectuom (String estabielectuom)
	{

		set_Value (COLUMNNAME_estabielectuom, estabielectuom);
	}

	/** Get estabielectuom.
		@return estabielectuom	  */
	public String getestabielectuom () 
	{
		return (String)get_Value(COLUMNNAME_estabielectuom);
	}

	/** Set excesocalmax.
		@param excesocalmax excesocalmax	  */
	public void setexcesocalmax (String excesocalmax)
	{
		set_Value (COLUMNNAME_excesocalmax, excesocalmax);
	}

	/** Get excesocalmax.
		@return excesocalmax	  */
	public String getexcesocalmax () 
	{
		return (String)get_Value(COLUMNNAME_excesocalmax);
	}

	/** Set excesocalmin.
		@param excesocalmin excesocalmin	  */
	public void setexcesocalmin (String excesocalmin)
	{
		set_Value (COLUMNNAME_excesocalmin, excesocalmin);
	}

	/** Get excesocalmin.
		@return excesocalmin	  */
	public String getexcesocalmin () 
	{
		return (String)get_Value(COLUMNNAME_excesocalmin);
	}

	/** excesocaluom AD_Reference_ID=53323 */
	public static final int EXCESOCALUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String EXCESOCALUOM_Angle = "AN";
	/** Area = AR */
	public static final String EXCESOCALUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String EXCESOCALUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String EXCESOCALUOM_Density = "DE";
	/** Energy = EN */
	public static final String EXCESOCALUOM_Energy = "EN";
	/** Force = FO */
	public static final String EXCESOCALUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String EXCESOCALUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String EXCESOCALUOM_Length = "LE";
	/** Power = PO */
	public static final String EXCESOCALUOM_Power = "PO";
	/** Pressure = PR */
	public static final String EXCESOCALUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String EXCESOCALUOM_Temperature = "TE";
	/** Time = TM */
	public static final String EXCESOCALUOM_Time = "TM";
	/** Torque = TO */
	public static final String EXCESOCALUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String EXCESOCALUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String EXCESOCALUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String EXCESOCALUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String EXCESOCALUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String EXCESOCALUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String EXCESOCALUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String EXCESOCALUOM_Frequency = "FR";
	/** Other = OT */
	public static final String EXCESOCALUOM_Other = "OT";
	/** Set excesocaluom.
		@param excesocaluom excesocaluom	  */
	public void setexcesocaluom (String excesocaluom)
	{

		set_Value (COLUMNNAME_excesocaluom, excesocaluom);
	}

	/** Get excesocaluom.
		@return excesocaluom	  */
	public String getexcesocaluom () 
	{
		return (String)get_Value(COLUMNNAME_excesocaluom);
	}

	/** Set Existence Quantity.
		@param ExistenceQty Existence Quantity	  */
	public void setExistenceQty (BigDecimal ExistenceQty)
	{
		set_Value (COLUMNNAME_ExistenceQty, ExistenceQty);
	}

	/** Get Existence Quantity.
		@return Existence Quantity	  */
	public BigDecimal getExistenceQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ExistenceQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set filtraapimax.
		@param filtraapimax filtraapimax	  */
	public void setfiltraapimax (String filtraapimax)
	{
		set_Value (COLUMNNAME_filtraapimax, filtraapimax);
	}

	/** Get filtraapimax.
		@return filtraapimax	  */
	public String getfiltraapimax () 
	{
		return (String)get_Value(COLUMNNAME_filtraapimax);
	}

	/** Set filtraapimin.
		@param filtraapimin filtraapimin	  */
	public void setfiltraapimin (String filtraapimin)
	{
		set_Value (COLUMNNAME_filtraapimin, filtraapimin);
	}

	/** Get filtraapimin.
		@return filtraapimin	  */
	public String getfiltraapimin () 
	{
		return (String)get_Value(COLUMNNAME_filtraapimin);
	}

	/** filtraapiuom AD_Reference_ID=53323 */
	public static final int FILTRAAPIUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String FILTRAAPIUOM_Angle = "AN";
	/** Area = AR */
	public static final String FILTRAAPIUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String FILTRAAPIUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String FILTRAAPIUOM_Density = "DE";
	/** Energy = EN */
	public static final String FILTRAAPIUOM_Energy = "EN";
	/** Force = FO */
	public static final String FILTRAAPIUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String FILTRAAPIUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String FILTRAAPIUOM_Length = "LE";
	/** Power = PO */
	public static final String FILTRAAPIUOM_Power = "PO";
	/** Pressure = PR */
	public static final String FILTRAAPIUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String FILTRAAPIUOM_Temperature = "TE";
	/** Time = TM */
	public static final String FILTRAAPIUOM_Time = "TM";
	/** Torque = TO */
	public static final String FILTRAAPIUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String FILTRAAPIUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String FILTRAAPIUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String FILTRAAPIUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String FILTRAAPIUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String FILTRAAPIUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String FILTRAAPIUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String FILTRAAPIUOM_Frequency = "FR";
	/** Other = OT */
	public static final String FILTRAAPIUOM_Other = "OT";
	/** Set filtraapiuom.
		@param filtraapiuom filtraapiuom	  */
	public void setfiltraapiuom (String filtraapiuom)
	{

		set_Value (COLUMNNAME_filtraapiuom, filtraapiuom);
	}

	/** Get filtraapiuom.
		@return filtraapiuom	  */
	public String getfiltraapiuom () 
	{
		return (String)get_Value(COLUMNNAME_filtraapiuom);
	}

	/** fluid_type AD_Reference_ID=1000095 */
	public static final int FLUID_TYPE_AD_Reference_ID=1000095;
	/** DRILLING = DRILLING */
	public static final String FLUID_TYPE_DRILLING = "DRILLING";
	/** 100%_AMN = 100%_AMN */
	public static final String FLUID_TYPE_100_AMN = "100%_AMN";
	/** SALMUERA = SALMUERA */
	public static final String FLUID_TYPE_SALMUERA = "SALMUERA";
	/** EMULSION = EMULSION */
	public static final String FLUID_TYPE_EMULSION = "EMULSION";
	/** Set fluid_type.
		@param fluid_type fluid_type	  */
	public void setfluid_type (String fluid_type)
	{

		set_Value (COLUMNNAME_fluid_type, fluid_type);
	}

	/** Get fluid_type.
		@return fluid_type	  */
	public String getfluid_type () 
	{
		return (String)get_Value(COLUMNNAME_fluid_type);
	}

	/** Set gelesmax.
		@param gelesmax gelesmax	  */
	public void setgelesmax (String gelesmax)
	{
		set_Value (COLUMNNAME_gelesmax, gelesmax);
	}

	/** Get gelesmax.
		@return gelesmax	  */
	public String getgelesmax () 
	{
		return (String)get_Value(COLUMNNAME_gelesmax);
	}

	/** Set gelesmin.
		@param gelesmin gelesmin	  */
	public void setgelesmin (String gelesmin)
	{
		set_Value (COLUMNNAME_gelesmin, gelesmin);
	}

	/** Get gelesmin.
		@return gelesmin	  */
	public String getgelesmin () 
	{
		return (String)get_Value(COLUMNNAME_gelesmin);
	}

	/** gelesuom AD_Reference_ID=53323 */
	public static final int GELESUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String GELESUOM_Angle = "AN";
	/** Area = AR */
	public static final String GELESUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String GELESUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String GELESUOM_Density = "DE";
	/** Energy = EN */
	public static final String GELESUOM_Energy = "EN";
	/** Force = FO */
	public static final String GELESUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String GELESUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String GELESUOM_Length = "LE";
	/** Power = PO */
	public static final String GELESUOM_Power = "PO";
	/** Pressure = PR */
	public static final String GELESUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String GELESUOM_Temperature = "TE";
	/** Time = TM */
	public static final String GELESUOM_Time = "TM";
	/** Torque = TO */
	public static final String GELESUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String GELESUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String GELESUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String GELESUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String GELESUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String GELESUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String GELESUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String GELESUOM_Frequency = "FR";
	/** Other = OT */
	public static final String GELESUOM_Other = "OT";
	/** Set gelesuom.
		@param gelesuom gelesuom	  */
	public void setgelesuom (String gelesuom)
	{

		set_Value (COLUMNNAME_gelesuom, gelesuom);
	}

	/** Get gelesuom.
		@return gelesuom	  */
	public String getgelesuom () 
	{
		return (String)get_Value(COLUMNNAME_gelesuom);
	}

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLine()));
    }

	public I_M_Locator getM_Locator() throws RuntimeException
    {
		return (I_M_Locator)MTable.get(getCtx(), I_M_Locator.Table_Name)
			.getPO(getM_Locator_ID(), get_TrxName());	}

	/** Set Locator.
		@param M_Locator_ID 
		Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID)
	{
		if (M_Locator_ID < 1) 
			set_Value (COLUMNNAME_M_Locator_ID, null);
		else 
			set_Value (COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
	}

	/** Get Locator.
		@return Warehouse Locator
	  */
	public int getM_Locator_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Locator_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Production getM_Production() throws RuntimeException
    {
		return (org.compiere.model.I_M_Production)MTable.get(getCtx(), org.compiere.model.I_M_Production.Table_Name)
			.getPO(getM_Production_ID(), get_TrxName());	}

	/** Set Production.
		@param M_Production_ID 
		Plan for producing a product
	  */
	public void setM_Production_ID (int M_Production_ID)
	{
		if (M_Production_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Production_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Production_ID, Integer.valueOf(M_Production_ID));
	}

	/** Get Production.
		@return Plan for producing a product
	  */
	public int getM_Production_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Production_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Production Plan.
		@param M_ProductionPlan_ID 
		Plan for how a product is produced
	  */
	public void setM_ProductionPlan_ID (int M_ProductionPlan_ID)
	{
		if (M_ProductionPlan_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_ProductionPlan_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_ProductionPlan_ID, Integer.valueOf(M_ProductionPlan_ID));
	}

	/** Get Production Plan.
		@return Plan for how a product is produced
	  */
	public int getM_ProductionPlan_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_ProductionPlan_ID);
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

	/** Set Production Quantity.
		@param ProductionQty 
		Quantity of products to produce
	  */
	public void setProductionQty (BigDecimal ProductionQty)
	{
		set_Value (COLUMNNAME_ProductionQty, ProductionQty);
	}

	/** Get Production Quantity.
		@return Quantity of products to produce
	  */
	public BigDecimal getProductionQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ProductionQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set puntocemax.
		@param puntocemax puntocemax	  */
	public void setpuntocemax (String puntocemax)
	{
		set_Value (COLUMNNAME_puntocemax, puntocemax);
	}

	/** Get puntocemax.
		@return puntocemax	  */
	public String getpuntocemax () 
	{
		return (String)get_Value(COLUMNNAME_puntocemax);
	}

	/** Set puntocemin.
		@param puntocemin puntocemin	  */
	public void setpuntocemin (String puntocemin)
	{
		set_Value (COLUMNNAME_puntocemin, puntocemin);
	}

	/** Get puntocemin.
		@return puntocemin	  */
	public String getpuntocemin () 
	{
		return (String)get_Value(COLUMNNAME_puntocemin);
	}

	/** puntoceuom AD_Reference_ID=53323 */
	public static final int PUNTOCEUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String PUNTOCEUOM_Angle = "AN";
	/** Area = AR */
	public static final String PUNTOCEUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String PUNTOCEUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String PUNTOCEUOM_Density = "DE";
	/** Energy = EN */
	public static final String PUNTOCEUOM_Energy = "EN";
	/** Force = FO */
	public static final String PUNTOCEUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String PUNTOCEUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String PUNTOCEUOM_Length = "LE";
	/** Power = PO */
	public static final String PUNTOCEUOM_Power = "PO";
	/** Pressure = PR */
	public static final String PUNTOCEUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String PUNTOCEUOM_Temperature = "TE";
	/** Time = TM */
	public static final String PUNTOCEUOM_Time = "TM";
	/** Torque = TO */
	public static final String PUNTOCEUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String PUNTOCEUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String PUNTOCEUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String PUNTOCEUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String PUNTOCEUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String PUNTOCEUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String PUNTOCEUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String PUNTOCEUOM_Frequency = "FR";
	/** Other = OT */
	public static final String PUNTOCEUOM_Other = "OT";
	/** Set puntoceuom.
		@param puntoceuom puntoceuom	  */
	public void setpuntoceuom (String puntoceuom)
	{

		set_Value (COLUMNNAME_puntoceuom, puntoceuom);
	}

	/** Get puntoceuom.
		@return puntoceuom	  */
	public String getpuntoceuom () 
	{
		return (String)get_Value(COLUMNNAME_puntoceuom);
	}

	/** Set RequestQty.
		@param RequestQty RequestQty	  */
	public void setRequestQty (BigDecimal RequestQty)
	{
		set_Value (COLUMNNAME_RequestQty, RequestQty);
	}

	/** Get RequestQty.
		@return RequestQty	  */
	public BigDecimal getRequestQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RequestQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set solidomax.
		@param solidomax solidomax	  */
	public void setsolidomax (String solidomax)
	{
		set_Value (COLUMNNAME_solidomax, solidomax);
	}

	/** Get solidomax.
		@return solidomax	  */
	public String getsolidomax () 
	{
		return (String)get_Value(COLUMNNAME_solidomax);
	}

	/** Set solidomin.
		@param solidomin solidomin	  */
	public void setsolidomin (String solidomin)
	{
		set_Value (COLUMNNAME_solidomin, solidomin);
	}

	/** Get solidomin.
		@return solidomin	  */
	public String getsolidomin () 
	{
		return (String)get_Value(COLUMNNAME_solidomin);
	}

	/** solidouom AD_Reference_ID=53323 */
	public static final int SOLIDOUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String SOLIDOUOM_Angle = "AN";
	/** Area = AR */
	public static final String SOLIDOUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String SOLIDOUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String SOLIDOUOM_Density = "DE";
	/** Energy = EN */
	public static final String SOLIDOUOM_Energy = "EN";
	/** Force = FO */
	public static final String SOLIDOUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String SOLIDOUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String SOLIDOUOM_Length = "LE";
	/** Power = PO */
	public static final String SOLIDOUOM_Power = "PO";
	/** Pressure = PR */
	public static final String SOLIDOUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String SOLIDOUOM_Temperature = "TE";
	/** Time = TM */
	public static final String SOLIDOUOM_Time = "TM";
	/** Torque = TO */
	public static final String SOLIDOUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String SOLIDOUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String SOLIDOUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String SOLIDOUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String SOLIDOUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String SOLIDOUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String SOLIDOUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String SOLIDOUOM_Frequency = "FR";
	/** Other = OT */
	public static final String SOLIDOUOM_Other = "OT";
	/** Set solidouom.
		@param solidouom solidouom	  */
	public void setsolidouom (String solidouom)
	{

		set_Value (COLUMNNAME_solidouom, solidouom);
	}

	/** Get solidouom.
		@return solidouom	  */
	public String getsolidouom () 
	{
		return (String)get_Value(COLUMNNAME_solidouom);
	}

	/** Set turbidezmax.
		@param turbidezmax turbidezmax	  */
	public void setturbidezmax (String turbidezmax)
	{
		set_Value (COLUMNNAME_turbidezmax, turbidezmax);
	}

	/** Get turbidezmax.
		@return turbidezmax	  */
	public String getturbidezmax () 
	{
		return (String)get_Value(COLUMNNAME_turbidezmax);
	}

	/** Set turbidezmin.
		@param turbidezmin turbidezmin	  */
	public void setturbidezmin (String turbidezmin)
	{
		set_Value (COLUMNNAME_turbidezmin, turbidezmin);
	}

	/** Get turbidezmin.
		@return turbidezmin	  */
	public String getturbidezmin () 
	{
		return (String)get_Value(COLUMNNAME_turbidezmin);
	}

	/** turbidezuom AD_Reference_ID=53323 */
	public static final int TURBIDEZUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String TURBIDEZUOM_Angle = "AN";
	/** Area = AR */
	public static final String TURBIDEZUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String TURBIDEZUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String TURBIDEZUOM_Density = "DE";
	/** Energy = EN */
	public static final String TURBIDEZUOM_Energy = "EN";
	/** Force = FO */
	public static final String TURBIDEZUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String TURBIDEZUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String TURBIDEZUOM_Length = "LE";
	/** Power = PO */
	public static final String TURBIDEZUOM_Power = "PO";
	/** Pressure = PR */
	public static final String TURBIDEZUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String TURBIDEZUOM_Temperature = "TE";
	/** Time = TM */
	public static final String TURBIDEZUOM_Time = "TM";
	/** Torque = TO */
	public static final String TURBIDEZUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String TURBIDEZUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String TURBIDEZUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String TURBIDEZUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String TURBIDEZUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String TURBIDEZUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String TURBIDEZUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String TURBIDEZUOM_Frequency = "FR";
	/** Other = OT */
	public static final String TURBIDEZUOM_Other = "OT";
	/** Set turbidezuom.
		@param turbidezuom turbidezuom	  */
	public void setturbidezuom (String turbidezuom)
	{

		set_Value (COLUMNNAME_turbidezuom, turbidezuom);
	}

	/** Get turbidezuom.
		@return turbidezuom	  */
	public String getturbidezuom () 
	{
		return (String)get_Value(COLUMNNAME_turbidezuom);
	}

	/** Set viscocidadmax.
		@param viscocidadmax viscocidadmax	  */
	public void setviscocidadmax (String viscocidadmax)
	{
		set_Value (COLUMNNAME_viscocidadmax, viscocidadmax);
	}

	/** Get viscocidadmax.
		@return viscocidadmax	  */
	public String getviscocidadmax () 
	{
		return (String)get_Value(COLUMNNAME_viscocidadmax);
	}

	/** Set viscocidadmin.
		@param viscocidadmin viscocidadmin	  */
	public void setviscocidadmin (String viscocidadmin)
	{
		set_Value (COLUMNNAME_viscocidadmin, viscocidadmin);
	}

	/** Get viscocidadmin.
		@return viscocidadmin	  */
	public String getviscocidadmin () 
	{
		return (String)get_Value(COLUMNNAME_viscocidadmin);
	}

	/** viscocidaduom AD_Reference_ID=53323 */
	public static final int VISCOCIDADUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String VISCOCIDADUOM_Angle = "AN";
	/** Area = AR */
	public static final String VISCOCIDADUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String VISCOCIDADUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String VISCOCIDADUOM_Density = "DE";
	/** Energy = EN */
	public static final String VISCOCIDADUOM_Energy = "EN";
	/** Force = FO */
	public static final String VISCOCIDADUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String VISCOCIDADUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String VISCOCIDADUOM_Length = "LE";
	/** Power = PO */
	public static final String VISCOCIDADUOM_Power = "PO";
	/** Pressure = PR */
	public static final String VISCOCIDADUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String VISCOCIDADUOM_Temperature = "TE";
	/** Time = TM */
	public static final String VISCOCIDADUOM_Time = "TM";
	/** Torque = TO */
	public static final String VISCOCIDADUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String VISCOCIDADUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String VISCOCIDADUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String VISCOCIDADUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String VISCOCIDADUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String VISCOCIDADUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String VISCOCIDADUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String VISCOCIDADUOM_Frequency = "FR";
	/** Other = OT */
	public static final String VISCOCIDADUOM_Other = "OT";
	/** Set viscocidaduom.
		@param viscocidaduom viscocidaduom	  */
	public void setviscocidaduom (String viscocidaduom)
	{

		set_Value (COLUMNNAME_viscocidaduom, viscocidaduom);
	}

	/** Get viscocidaduom.
		@return viscocidaduom	  */
	public String getviscocidaduom () 
	{
		return (String)get_Value(COLUMNNAME_viscocidaduom);
	}

	/** Set viscoplastimax.
		@param viscoplastimax viscoplastimax	  */
	public void setviscoplastimax (String viscoplastimax)
	{
		set_Value (COLUMNNAME_viscoplastimax, viscoplastimax);
	}

	/** Get viscoplastimax.
		@return viscoplastimax	  */
	public String getviscoplastimax () 
	{
		return (String)get_Value(COLUMNNAME_viscoplastimax);
	}

	/** Set viscoplastimin.
		@param viscoplastimin viscoplastimin	  */
	public void setviscoplastimin (String viscoplastimin)
	{
		set_Value (COLUMNNAME_viscoplastimin, viscoplastimin);
	}

	/** Get viscoplastimin.
		@return viscoplastimin	  */
	public String getviscoplastimin () 
	{
		return (String)get_Value(COLUMNNAME_viscoplastimin);
	}

	/** viscoplastiuom AD_Reference_ID=53323 */
	public static final int VISCOPLASTIUOM_AD_Reference_ID=53323;
	/** Angle = AN */
	public static final String VISCOPLASTIUOM_Angle = "AN";
	/** Area = AR */
	public static final String VISCOPLASTIUOM_Area = "AR";
	/** Data Storage = DS */
	public static final String VISCOPLASTIUOM_DataStorage = "DS";
	/** Density = DE */
	public static final String VISCOPLASTIUOM_Density = "DE";
	/** Energy = EN */
	public static final String VISCOPLASTIUOM_Energy = "EN";
	/** Force = FO */
	public static final String VISCOPLASTIUOM_Force = "FO";
	/** Kitchen Measures = KI */
	public static final String VISCOPLASTIUOM_KitchenMeasures = "KI";
	/** Length = LE */
	public static final String VISCOPLASTIUOM_Length = "LE";
	/** Power = PO */
	public static final String VISCOPLASTIUOM_Power = "PO";
	/** Pressure = PR */
	public static final String VISCOPLASTIUOM_Pressure = "PR";
	/** Temperature = TE */
	public static final String VISCOPLASTIUOM_Temperature = "TE";
	/** Time = TM */
	public static final String VISCOPLASTIUOM_Time = "TM";
	/** Torque = TO */
	public static final String VISCOPLASTIUOM_Torque = "TO";
	/** Velocity = VE */
	public static final String VISCOPLASTIUOM_Velocity = "VE";
	/** Volume Liquid = VL */
	public static final String VISCOPLASTIUOM_VolumeLiquid = "VL";
	/** Volume Dry = VD */
	public static final String VISCOPLASTIUOM_VolumeDry = "VD";
	/** Weigth = WE */
	public static final String VISCOPLASTIUOM_Weigth = "WE";
	/** Currency = CU */
	public static final String VISCOPLASTIUOM_Currency = "CU";
	/** Data Speed = DV */
	public static final String VISCOPLASTIUOM_DataSpeed = "DV";
	/** Frequency = FR */
	public static final String VISCOPLASTIUOM_Frequency = "FR";
	/** Other = OT */
	public static final String VISCOPLASTIUOM_Other = "OT";
	/** Set viscoplastiuom.
		@param viscoplastiuom viscoplastiuom	  */
	public void setviscoplastiuom (String viscoplastiuom)
	{

		set_Value (COLUMNNAME_viscoplastiuom, viscoplastiuom);
	}

	/** Get viscoplastiuom.
		@return viscoplastiuom	  */
	public String getviscoplastiuom () 
	{
		return (String)get_Value(COLUMNNAME_viscoplastiuom);
	}

	/** Set Weight.
		@param Weight 
		Weight of a product
	  */
	public void setWeight (BigDecimal Weight)
	{
		set_Value (COLUMNNAME_Weight, Weight);
	}

	/** Get Weight.
		@return Weight of a product
	  */
	public BigDecimal getWeight () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Weight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}