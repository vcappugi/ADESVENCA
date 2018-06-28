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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;

/**
 *	Physical Inventory Callouts
 *	
 *  @author Jorg Janke
 *  @version $Id: CalloutInventory.java,v 1.2 2006/07/30 00:51:03 jjanke Exp $
 */
@SuppressWarnings("unused")
public class CalloutInventory extends CalloutEngine
{
	/**
	 *  Product/Locator/ASI modified.
	 * 		Set Attribute Set Instance
	 *
	 *  @param ctx      Context
	 *  @param WindowNo current Window No
	 *  @param mTab     Model Tab
	 *  @param mField   Model Field
	 *  @param value    The new value
	 *  @return Error message or ""
	 */
	public BigDecimal costs = null;
	public BigDecimal costsUsd = null;
    public BigDecimal costsPure =null;
    
	public String product (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive())
			return "";
		Integer InventoryLine = (Integer)mTab.getValue("M_InventoryLine_ID");
		BigDecimal bd = null;
		
		if (InventoryLine != null && InventoryLine.intValue() != 0) {
			MInventoryLine _ILine = new MInventoryLine(ctx, InventoryLine, null);
			Integer M_Product_ID = (Integer)mTab.getValue("M_Product_ID");
			Integer M_Locator_ID = (Integer)mTab.getValue("M_Locator_ID");		
			Integer M_AttributeSetInstance_ID = 0;
			// if product or locator has changed recalculate Book Qty
			if ((M_Product_ID != null && M_Product_ID != _ILine.getM_Product_ID()) || 
					(M_Locator_ID !=null && M_Locator_ID != _ILine.getM_Locator_ID())) {

				// Check ASI - if product has been changed remove old ASI
				if (M_Product_ID == _ILine.getM_Product_ID()) {
					M_AttributeSetInstance_ID = (Integer)mTab.getValue("M_AttributeSetInstance_ID");
					if( M_AttributeSetInstance_ID == null )
						M_AttributeSetInstance_ID = 0;
				} else {
					mTab.setValue("M_AttributeSetInstance_ID", null);
				}
				try {
					bd = setQtyBook(M_AttributeSetInstance_ID, M_Product_ID, M_Locator_ID);
					mTab.setValue("QtyBook", bd);
				} catch (Exception e) {
					return mTab.setValue("QtyBook", bd);
				}
			}
			
			
			return "";
		}
			
		//	New Line - Get Book Value
		int M_Product_ID = 0;
		Integer Product = (Integer)mTab.getValue("M_Product_ID");
		if (Product != null)
			M_Product_ID = Product.intValue();
		if (M_Product_ID == 0)
			return "";
		int M_Locator_ID = 0;
		Integer Locator = (Integer)mTab.getValue("M_Locator_ID");
		if (Locator != null)
			M_Locator_ID = Locator.intValue();
		if (M_Locator_ID == 0)
			return "";
		
		//	Set Attribute
		int M_AttributeSetInstance_ID = 0; 
		Integer ASI = (Integer)mTab.getValue("M_AttributeSetInstance_ID");
		if (ASI != null)
			M_AttributeSetInstance_ID = ASI.intValue();
		//	Product Selection
		if (MInventoryLine.COLUMNNAME_M_Product_ID.equals(mField.getColumnName()))
		{
			if (Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_Product_ID") == M_Product_ID)
			{
				M_AttributeSetInstance_ID = Env.getContextAsInt(ctx, WindowNo, Env.TAB_INFO, "M_AttributeSetInstance_ID");
			}
			else
			{
				M_AttributeSetInstance_ID = 0;
			}
			if (M_AttributeSetInstance_ID != 0)
				mTab.setValue(MInventoryLine.COLUMNNAME_M_AttributeSetInstance_ID, M_AttributeSetInstance_ID);
			else
				mTab.setValue(MInventoryLine.COLUMNNAME_M_AttributeSetInstance_ID, null);
		}
			
		// Set QtyBook from first storage location
		// kviiksaar: Call's now the extracted function
		try {
			bd = setQtyBook(M_AttributeSetInstance_ID, M_Product_ID, M_Locator_ID);
			mTab.setValue("QtyBook", bd);
		} catch (Exception e) {
			return mTab.setValue("QtyBook", bd);
		}
		
		//
		log.info("M_Product_ID=" + M_Product_ID 
			+ ", M_Locator_ID=" + M_Locator_ID
			+ ", M_AttributeSetInstance_ID=" + M_AttributeSetInstance_ID
			+ " - QtyBook=" + bd);
		
		
		//Costos Promedio
		costAverage(ctx, WindowNo, mTab, mField, value);

		//Categoría de Producto Resultante
		MProduct product = new MProduct(Env.getCtx(), M_Product_ID, null);
		MProductCategory category = new MProductCategory(Env.getCtx(), product.getM_Product_Category_ID(), null);
		if(category.isResult()){
			mTab.setValue("IsResult", true);
		}
		
		return "";
	}   //  product
	
	
	/**
	 * kviiksaar
	 * 
	 * Returns the current Book Qty for given parameters or 0
	 * 
	 * @param M_AttributeSetInstance_ID
	 * @param M_Product_ID
	 * @param M_Locator_ID
	 * @return
	 * @throws Exception
	 */
	private BigDecimal setQtyBook (int M_AttributeSetInstance_ID, int M_Product_ID, int M_Locator_ID) throws Exception {
		// Set QtyBook from first storage location
		BigDecimal bd = null;
		String sql = "SELECT QtyOnHand FROM M_Storage "
			+ "WHERE M_Product_ID=?"	//	1
			+ " AND M_Locator_ID=?"		//	2
			+ " AND M_AttributeSetInstance_ID=?";
		if (M_AttributeSetInstance_ID == 0)
			sql = "SELECT SUM(QtyOnHand) FROM M_Storage "
			+ "WHERE M_Product_ID=?"	//	1
			+ " AND M_Locator_ID=?";	//	2
		
		try
		{
			PreparedStatement pstmt = DB.prepareStatement(sql, null);
			pstmt.setInt(1, M_Product_ID);
			pstmt.setInt(2, M_Locator_ID);
			if (M_AttributeSetInstance_ID != 0)
				pstmt.setInt(3, M_AttributeSetInstance_ID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				bd = rs.getBigDecimal(1);
				if (bd != null)
					return bd;
			} else {
				// gwu: 1719401: clear Booked Quantity to zero first in case the query returns no rows, 
				// for example when the locator has never stored a particular product.
				return new BigDecimal(0);
			}
			rs.close();
			pstmt.close();
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
			throw new Exception(e.getLocalizedMessage());
		}
		return new BigDecimal(0);
	}
	/*
	 * qty from modify UOM in Inventory and internal use
	 * 
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
			mTab.setValue("QtyInternalUse", QtyEntered);
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
				mTab.setValue("QtyInternalUse", QtyEntered);
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
			mTab.setValue("QtyInternalUse", MovementQty);
		}
		//	No UOM defined
		else if (Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID") == 0)
		{
			QtyEntered = (BigDecimal)mTab.getValue("Qty");
			mTab.setValue("QtyInternalUse", QtyEntered);
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
				mTab.setValue("QtyInternalUse", QtyEntered);
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
			mTab.setValue("QtyInternalUse", MovementQty);
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
				mTab.setValue("QtyInternalUse", MovementQty);
			}
			QtyEntered = MUOMConversion.convertProductTo (ctx, M_Product_ID,
				C_UOM_To_ID, MovementQty);
			if (QtyEntered == null)
				QtyEntered = MovementQty;
			boolean conversion = MovementQty.compareTo(QtyEntered) != 0;
			log.fine("UOM=" + C_UOM_To_ID
				+ ", MovementQty=" + MovementQty
				+ " -> " + conversion
				+ " QtyInternalUse=" + QtyEntered);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("QtyInternalUse", QtyEntered);
		}
		
		//Costos Promedio
		costAverage(ctx, WindowNo, mTab, mField, value);
		
		Boolean isin = mTab.getValueAsBoolean("IsIn");
		if(!isin)
			checkQtyAvailable(ctx, mTab, WindowNo, M_Product_ID, (BigDecimal) mTab.getValue("Qty"));
		
		//Categoría de Producto Resultante
		MProduct product = new MProduct(Env.getCtx(), M_Product_ID, null);
		MProductCategory category = new MProductCategory(Env.getCtx(), product.getM_Product_Category_ID(), null);
		if(category.isResult()){
			mTab.setValue("IsResult", true);
		}
		
		return "";
	}	//	qty
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
		if (MovementQty.signum()>=0) {
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
		}
		// End Armen
	}
	
	
	private String costAverage(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		//Costos en el almacén
		costs = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * m_product_cost)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND M_Product_Cost >= 0 AND QtyonHand >0");
        costsUsd = DB.getSQLValueBD(null , "SELECT coalesce((sum(qtyonhand * Cost_USD)/sum(qtyonhand)),0) from M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_USD >= 0 AND QtyonHand >0"); 
		costsPure = DB.getSQLValueBD(null, "SELECT coalesce((sum(qtyonhand * Cost_pure)/sum(qtyonhand)),0) FROM M_Storage WHERE M_Locator_ID ="+mTab.getValue("M_Locator_ID")+ " AND M_Product_ID=" + mTab.getValue("M_Product_ID") + " AND Cost_Pure >= 0 AND QtyonHand >0");
			
		
		//Costos Calculados desde la línea
		BigDecimal costo_ant = DB.getSQLValueBD(null, "SELECT coalesce(sum(M_Product_Cost * qty),0) FROM M_InventoryLine where IsResult ='N' AND Isin ='N' AND M_Inventory_ID="+ mTab.getValue("M_Inventory_ID"));
		BigDecimal costo_antUsd = DB.getSQLValueBD(null, "SELECT coalesce(sum(Cost_Usd * qty),0) FROM M_InventoryLine where IsResult ='N' AND Isin ='N' AND M_Inventory_ID="+ mTab.getValue("M_Inventory_ID"));
		BigDecimal costo_antPure = DB.getSQLValueBD(null, "SELECT coalesce(sum(Cost_Pure * qty),0) FROM M_InventoryLine where IsResult ='N' AND Isin ='N' AND M_Inventory_ID="+ mTab.getValue("M_Inventory_ID"));
		
		Boolean isRes =mTab.getValueAsBoolean("IsResult");   
		Boolean isin = mTab.getValueAsBoolean("IsIn");

		//Si los costos calculados son nulos
		if(costo_ant==null) {
			costo_ant = new BigDecimal(0);
			costo_antUsd = new BigDecimal(0);
			costo_antPure = new BigDecimal(0);
		}
		
		//Variables Auxiliares
		BigDecimal costs2 = costs;
		BigDecimal costsUsd2 = costsUsd;
		BigDecimal costsPure2 = costsPure;
		
		BigDecimal qty = (BigDecimal) mTab.getValue("Qty"); 
		if (isin) { //Entrada
			if (qty.signum()!=0) {
				costs = costo_ant.divide(qty.abs(),2);
				costsUsd = costo_antUsd.divide(qty.abs(), 2);
				costsPure = costo_antPure.divide(qty.abs(), 2);
			}
		}else if (isRes){ //No es entrada y es Resultante (Se contabilizar a costo cero)
			costs = new BigDecimal(0);
			costsUsd = new BigDecimal(0);
			costsPure = new BigDecimal(0);
		}   

		//Entrada - No Resultante - Sin Costo Calculado
		if((isin)&&!(isRes)&&(costo_ant.signum()==0)) {
			costs = costs2;
			costsUsd = costsUsd2;
			costsPure = costsPure2;
		}

		
		mTab.setValue("M_Product_Cost", costs.abs());
		mTab.setValue("Cost_USD", costsUsd.abs());
		mTab.setValue("Cost_Pure", costsPure.abs());
		return "";
	}
	
	
}	//	CalloutInventory
