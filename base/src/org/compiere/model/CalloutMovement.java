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
 * Contributor(s): Armen Rizal (armen@goodwill.co.id) Bug Fix 1564496         *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 *	Inventory Movement Callouts
 *	
 *  @author Jorg Janke
 *  @version $Id: CalloutMovement.java,v 1.2 2006/07/30 00:51:03 jjanke Exp $
 * 
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 * 			<li>BF [ 1879568 ] CalloutMouvement QtyAvailable issues
 */
public class CalloutMovement extends CalloutEngine
{
	/**
	 *  Product modified
	 * 		Set Attribute Set Instance
	 *
	 *  @param ctx      Context
	 *  @param WindowNo current Window No
	 *  @param GridTab     Model Tab
	 *  @param GridField   Model Field
	 *  @param value    The new value
	 *  @return Error message or ""
	 */
	public BigDecimal costs = null;
	
	public String product (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		Integer M_Product_ID = (Integer)value;
		if (M_Product_ID == null || M_Product_ID.intValue() == 0)
			return "";
		//	Set Attribute
		if (Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_Product_ID") == M_Product_ID.intValue()
			&& Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_AttributeSetInstance_ID") != 0)
			mTab.setValue("M_AttributeSetInstance_ID", Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_AttributeSetInstance_ID"));
		else
			mTab.setValue("M_AttributeSetInstance_ID", null);
		 
		
		MProduct product = MProduct.get(ctx, M_Product_ID.intValue());
		mTab.setValue("C_UOM_ID", new Integer (product.getC_UOM_ID()));
		BigDecimal QtyEntered = (BigDecimal)mTab.getValue("Qty");
		mTab.setValue("MovementQty", QtyEntered);
		checkQtyAvailable(ctx, mTab, WindowNo, M_Product_ID, null);
		
		
		//Import cost avrage from m_locator
		BigDecimal costs = new BigDecimal(0);
		BigDecimal costsUsd = new BigDecimal(0);
		BigDecimal costsPure = new BigDecimal(0);
		
		costs = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * m_product_cost)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND M_Product_Cost >= 0 AND QtyonHand >0");
      	costsUsd = DB.getSQLValueBD(null , "SELECT coalesce((sum(qtyonhand * Cost_USD)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_USD >= 0 AND QtyonHand >0"); 
      	costsPure = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * Cost_pure)/sum(qtyonhand)),0) FROM M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_Pure >= 0 AND QtyonHand >0");
		
		
		mTab.setValue("M_Product_Cost", costs.abs());
		mTab.setValue("Cost_USD", costsUsd.abs());
		mTab.setValue("Cost_Pure", costsPure.abs());
		//End import cost average from m_locator
		
		//Categoría de Producto Resultante
		MProductCategory category = new MProductCategory(Env.getCtx(), product.getM_Product_Category_ID(), null);
		if(category.isResult()){
			mTab.setValue("IsResult", true);
		}
		
		return "";
	}   //  product
	
	// Begin Armen 2006/10/01
	/**
	 *  Movement Line - MovementQty modified
	 *              called from MovementQty
	 *
	 *  @param ctx      Context
	 *  @param WindowNo current Window No
	 *  @param GridTab     Model Tab
	 *  @param GridField   Model Field
	 *  @param value    The new value
	 *  @return Error message or ""
	 */
	public String qty (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive() || value == null)
			return "";
		
		
		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, "M_Product_ID");
		//	log.log(Level.WARNING,"qty - init - M_Product_ID=" + M_Product_ID);
		BigDecimal MovementQty, QtyEntered;
		
		//	No Product
		if (M_Product_ID == 0)
		{
			QtyEntered = (BigDecimal)mTab.getValue("Qty");
			mTab.setValue("MovementQty", QtyEntered);
		}
		//	UOM Changed - convert from Entered -> Product
		else if (mField.getColumnName().equals("C_UOM_ID"))
		{
			int C_UOM_To_ID = ((Integer)value).intValue();
			QtyEntered = (BigDecimal)mTab.getValue("Qty");
			BigDecimal QtyEntered1 = QtyEntered.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), BigDecimal.ROUND_HALF_UP);
			if (QtyEntered.compareTo(QtyEntered1) != 0)
			{
				log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyEntered + "->" + QtyEntered1);
				QtyEntered = QtyEntered1;
				mTab.setValue("QtyEntered", QtyEntered);
			}
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyEntered);
			if (MovementQty == null)
				MovementQty = QtyEntered;
			boolean conversion = QtyEntered.compareTo(MovementQty) != 0;
			log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyEntered
				+ " -> " + conversion
				+ " MovementQty=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("MovementQty", MovementQty);
			
			
		}
		//	No UOM defined
		else if (Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID") == 0)
		{
			QtyEntered = (BigDecimal)mTab.getValue("Qty");
			mTab.setValue("MovementQty", QtyEntered);
		}
		//	QtyEntered changed - calculate MovementQty
		else if (mField.getColumnName().equals("Qty"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
			QtyEntered = (BigDecimal)value;
			BigDecimal QtyEntered1 = QtyEntered.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), BigDecimal.ROUND_HALF_UP);
			if (QtyEntered.compareTo(QtyEntered1) != 0)
			{
				log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyEntered + "->" + QtyEntered1);
				QtyEntered = QtyEntered1;
				mTab.setValue("QtyEntered", QtyEntered);
			}
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyEntered);
			if (MovementQty == null)
				MovementQty = QtyEntered;
			boolean conversion = QtyEntered.compareTo(MovementQty) != 0;
			log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyEntered
				+ " -> " + conversion
				+ " MovementQty=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("MovementQty", MovementQty);
		}
		//	MovementQty changed - calculate QtyEntered (should not happen)
		else if (mField.getColumnName().equals("Qty"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
			MovementQty = (BigDecimal)value;
			int precision = MProduct.get(ctx, M_Product_ID).getUOMPrecision();
			BigDecimal MovementQty1 = MovementQty.setScale(precision, BigDecimal.ROUND_HALF_UP);
			if (MovementQty.compareTo(MovementQty1) != 0)
			{
				log.fine("Corrected MovementQty "
					+ MovementQty + "->" + MovementQty1);
				MovementQty = MovementQty1;
				mTab.setValue("MovementQty", MovementQty);
			}
			QtyEntered = MUOMConversion.convertProductTo (ctx, M_Product_ID,
				C_UOM_To_ID, MovementQty);
			if (QtyEntered == null)
				QtyEntered = MovementQty;
			boolean conversion = MovementQty.compareTo(QtyEntered) != 0;
			log.fine("UOM=" + C_UOM_To_ID
				+ ", MovementQty=" + MovementQty
				+ " -> " + conversion
				+ " QtyEntered=" + QtyEntered);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("QtyEntered", QtyEntered);
		}
		//
		//
		//Import cost avrage from m_locator
		BigDecimal costs = new BigDecimal(0);
		BigDecimal costsUsd = new BigDecimal(0);;
		BigDecimal costsPure = new BigDecimal(0);
		
		costs = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * m_product_cost)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND M_Product_Cost >= 0 AND QtyonHand >0");
	    costsUsd = DB.getSQLValueBD(null , "SELECT coalesce((sum(qtyonhand * Cost_USD)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_USD >= 0 AND QtyonHand >0"); 
		costsPure = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * Cost_pure)/sum(qtyonhand)),0) FROM M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_Pure >= 0 AND QtyonHand >0");
		
		
		mTab.setValue("M_Product_Cost", costs.abs());
		mTab.setValue("Cost_USD", costsUsd.abs());
		mTab.setValue("Cost_Pure", costsPure.abs());
		//End import cost average from m_locator
		
		checkQtyAvailable(ctx, mTab, WindowNo, M_Product_ID,(BigDecimal) mTab.getValue("MovemnetQty"));
		
		MProduct product = new MProduct(Env.getCtx(), M_Product_ID, null);
		MProductCategory category = new MProductCategory(Env.getCtx(), product.getM_Product_Category_ID(), null);
		if(category.isResult()){
			mTab.setValue("IsResult", true);
		}
		
		
		return "";
	}	//	qty

	
	/**
	 * Movement Line - Locator modified
	 * 
	 * @param ctx      Context
	 * @param WindowNo current Window No
	 * @param GridTab     Model Tab
	 * @param GridField   Model Field
	 * @param value    The new value
	 * @return Error message or ""
	 */
	public String locator(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, "M_Product_ID");
		checkQtyAvailable(ctx, mTab, WindowNo, M_Product_ID, null);
		return "";
	}

	/**
	 * Check available qty
	 * 
	 * @param ctx context
	 * @param mTab Model Tab
	 * @param WindowNo current Window No
	 * @param M_Product_ID product ID
	 * @param MovementQty movement qty (if null will be get from context "MovementQty")
	 */
	private void checkQtyAvailable(Properties ctx, GridTab mTab, int WindowNo, int M_Product_ID, BigDecimal MovementQty) {
		// Begin Armen 2006/10/01
		if (M_Product_ID != 0) {
			MProduct product = MProduct.get(ctx, M_Product_ID);
			if (product.isStocked()) {
				if (MovementQty == null)
					MovementQty = (BigDecimal) mTab.getValue("MovementQty");
				int M_Locator_ID = Env.getContextAsInt(ctx, WindowNo, "M_Locator_ID");
				// If no locator, don't check anything and assume is ok
				if (M_Locator_ID <= 0)
					return;
				int M_AttributeSetInstance_ID = Env.getContextAsInt(ctx, WindowNo, "M_AttributeSetInstance_ID");
				BigDecimal available = MStorage.getQtyAvailable(0, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID, null);
				if (available == null)
					available = Env.ZERO;
				if (available.signum() == 0) {
					mTab.fireDataStatusEEvent("NoQtyAvailable", "0", false);
					 mTab.setValue("M_Product_ID",0);	
				}
				else if (available.compareTo(MovementQty) < 0) {
					mTab.fireDataStatusEEvent("InsufficientQtyAvailable", available.toString(), false);
				    mTab.setValue("M_Product_ID",0);	
				}
			}
		}
		// End Armen
	}
}	//	CalloutMove