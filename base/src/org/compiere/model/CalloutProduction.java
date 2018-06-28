/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 *	Production Callouts
 *	
 *  @author Jorg Janke
 *  @version $Id: CalloutProduction.java,v 1.2 2006/07/30 00:51:05 jjanke Exp $
 */
@SuppressWarnings("unused")
public class CalloutProduction extends CalloutEngine
{
	public BigDecimal costs;
	public BigDecimal costs_USD;
	public BigDecimal costs_Pure;
	
	/**
	 *  Product modified
	 * 		Set Attribute Set Instance
	 *
	 *  @param ctx      Context
	 *  @param WindowNo current Window No
	 *  @param mTab     Model Tab
	 *  @param mField   Model Field
	 *  @param value    The new value
	 *  @return Error message or ""
	 */
	public String product (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		Integer M_Product_ID = (Integer)value;
		if (M_Product_ID == null || M_Product_ID.intValue() == 0)
			return "";
		//	Set Attribute
		if (Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_Product_ID") == M_Product_ID.intValue()
			&& Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_AttributeSetInstance_ID") != 0)
		{
			mTab.setValue("M_AttributeSetInstance_ID", new Integer(Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_AttributeSetInstance_ID")));
		}
		else
		{
			mTab.setValue("M_AttributeSetInstance_ID", null);
		}
		return "";
	}   //  product
	
	
	public String Cost_Prodct (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		Integer M_Product_ID = (Integer)value;
		BigDecimal product = DB.getSQLValueBD(null, "SELECT COALESCE((SELECT  M_Product_ID FROM M_ProductionLine WHERE M_ProductionPlan_id = 1000098 AND M_Product_ID = "+ M_Product_ID +"),0)");
		
		if(product.compareTo(new BigDecimal(0)) == 0){
			if(M_Product_ID != null){
	
				X_M_ProductionPlan plan = new X_M_ProductionPlan(Env.getCtx(), (Integer) mTab.getValue("M_ProductionPlan_ID"),null);
				costs = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * m_product_cost)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+plan.getM_Locator_ID()+ " AND M_Product_ID=" + M_Product_ID + " AND M_Product_Cost >= 0 AND QtyonHand >=0");
				costs_USD = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * Cost_USD)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+plan.getM_Locator_ID()+ " AND M_Product_ID=" + M_Product_ID + " AND Cost_USD >= 0 AND QtyonHand >=0");
				costs_Pure = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * Cost_Pure)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+plan.getM_Locator_ID()+ " AND M_Product_ID=" + M_Product_ID + " AND Cost_Pure >= 0 AND QtyonHand >=0");
				
				mTab.setValue("M_Product_Cost", costs.abs().setScale(2,BigDecimal.ROUND_HALF_UP));
				mTab.setValue("Cost_USD", costs_USD.abs().setScale(2,BigDecimal.ROUND_HALF_UP));
				mTab.setValue("Cost_Pure", costs_Pure.abs().setScale(2,BigDecimal.ROUND_HALF_UP));
				
			//JOptionPane.showMessageDialog(null,mTab.getValue("M_ProductionPlan_ID"));
			}
		}else{
			mTab.setValue("M_Product_ID", null);
			return "El Producto ya se Encuentra Registrado...";
		}
		return "";
	} // Costo del producto
	

}	//	CalloutProduction
