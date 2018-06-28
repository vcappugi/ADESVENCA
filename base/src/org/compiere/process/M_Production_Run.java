/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
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
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved.               *
 * Contributor(s): Victor Perez www.e-evolution.com                           *
 *****************************************************************************/

package org.compiere.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MClient;
import org.compiere.model.MLocator;
import org.compiere.model.MProduct;
import org.compiere.model.MStorage;
import org.compiere.model.MTransaction;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.model.X_M_Production;
import org.compiere.model.X_M_ProductionLine;
import org.compiere.model.X_M_ProductionPlan;
import org.compiere.model.X_M_ProductionTheory;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.ValueNamePair;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;

/**
 * Production of BOMs
 *   1) Creating ProductionLines when IsCreated = 'N'
 *   2) Posting the Lines (optionally only when fully stocked)
 * 
 * @author victor.perez@e-evolution.com
 * @contributor: Carlos Ruiz (globalqss) - review backward compatibility - implement mustBeStocked properly
 */

public class M_Production_Run extends SvrProcess {

	/** The Record */
	private int p_Record_ID = 0;

	@SuppressWarnings("unused")
	private boolean mustBeStocked = false;
	
	private int m_level = 0;
	public BigDecimal costs;
	public BigDecimal costs_USD;
	public BigDecimal costs_Pure;
	public BigDecimal costs_Conv;
	
    public 	BigDecimal avgCost = null;
    public 	BigDecimal avgCostUsd = null;
    public BigDecimal avgCostPure = null;

	/**
	 * Prepare - e.g., get Parameters.
	 */
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("MustBeStocked"))
				mustBeStocked = ((String) para[i].getParameter()).equals("Y");
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		p_Record_ID = getRecord_ID();
	} //prepare

	/**
	 * Process
	 * 
	 * @return message
	 * @throws Exception
	 */

	@SuppressWarnings("unused")
	protected String doIt() throws Exception 
	{
		log.info("Search fields in M_Production");

		X_M_Production production = new X_M_Production(getCtx(), p_Record_ID, get_TrxName());
		/**
		 * No Action
		 */
		if (production.isProcessed()) 
		{
			log.info("Already Posted");
			return "@AlreadyPosted@";
		}
		

			String whereClause = "M_Production_ID=? ";
			List<X_M_ProductionPlan> lines = new Query(getCtx(), X_M_ProductionPlan.Table_Name , whereClause, get_TrxName())
													  .setParameters(p_Record_ID)
													  .setOrderBy("Line, M_Product_ID")
													  .list();
				for (X_M_ProductionPlan pp :lines)
				{	
					
					if (!production.isCreated()) 
					{
						int line = 100;
						
						// Production theory
						int no2 = DB.executeUpdateEx("DELETE M_Productiontheory WHERE M_ProductionPlan_ID = ?", new Object[]{pp.getM_ProductionPlan_ID()},get_TrxName());
						if (no2 == -1) raiseError("ERROR", "DELETE M_ProductionTheory WHERE M_ProductionPlan_ID = "+ pp.getM_ProductionPlan_ID());
						
						X_M_ProductionTheory pt = new X_M_ProductionTheory(getCtx(), 0 , get_TrxName());
						pt.setLine(line);
						pt.setDescription(pp.getDescription());
						pt.setM_Product_ID(pp.getM_Product_ID());
						pt.setM_Locator_ID(pp.getM_Locator_ID());
						pt.setM_ProductionPlan_ID(pp.getM_ProductionPlan_ID());
						pt.setMovementQty(pp.getRequestQty());
						pt.setIsIn(true);

						//Obtiene Costos Promedios de la Localización
						getAvgCost(pt.getM_Locator_ID(), pt.getM_Product_ID());
						
						costs = avgCost; 
						costs_USD = avgCostUsd;
						costs_Pure = avgCostPure; 
						
						
						pt.setM_Product_Cost(costs.setScale(2,BigDecimal.ROUND_HALF_UP));
						pt.setCost_USD(costs_USD.setScale(2,BigDecimal.ROUND_HALF_UP));
						pt.setCost_Pure(costs_Pure.setScale(2,BigDecimal.ROUND_HALF_UP));
						pt.saveEx();
						
						
						// Production Real
						int no = DB.executeUpdateEx("DELETE M_ProductionLine WHERE M_ProductionPlan_ID = ?", new Object[]{pp.getM_ProductionPlan_ID()},get_TrxName());
						if (no == -1) raiseError("ERROR", "DELETE M_ProductionLine WHERE M_ProductionPlan_ID = "+ pp.getM_ProductionPlan_ID());
						
						MProduct product = MProduct.get(getCtx(), pp.getM_Product_ID());
						
						if (!pp.getProductionQty().equals(pp.getRequestQty())){ //La cantidad solicitada debe ser diferente a la produccion
							X_M_ProductionLine pl = new X_M_ProductionLine(getCtx(), 0 , get_TrxName());
							pl.setLine(line);
							pl.setDescription(pp.getDescription());
							pl.setM_Product_ID(pp.getM_Product_ID());
							pl.setM_Locator_ID(pp.getM_Locator_ID());
							pl.setM_ProductionPlan_ID(pp.getM_ProductionPlan_ID());
							pl.setMovementQty(pp.getProductionQty());
							pl.setIsIn(true);
							pl.setM_Product_Cost(costs.setScale(2,BigDecimal.ROUND_HALF_UP));
							pl.setCost_USD(costs_USD.setScale(2,BigDecimal.ROUND_HALF_UP));
							pl.setCost_Pure(costs_Pure.setScale(2,BigDecimal.ROUND_HALF_UP));
							pl.saveEx();
						}
						
						
						if (explosion(pp, product, pp.getProductionQty() ,pp.getRequestQty(), line) == 0 )
							raiseError("No BOM Lines", "");
						
					}
					else
					{	
						getAverageCost(pp.getM_ProductionPlan_ID(), production);
						
						pp.setProcessed(true);
						pp.saveEx();
					} 	
		} // Production Plan
				
		if(!production.isCreated())	
		{	
			production.setIsCreated(true);
			production.saveEx();
		}
		else
		{
			 production.setProcessed(true);
			 production.saveEx();	

			 /* Immediate accounting */
			 if (MClient.isClientAccountingImmediate()) {
				 String ignoreError = DocumentEngine.postImmediate(getCtx(), getAD_Client_ID(), production.get_Table_ID(), production.get_ID(), true, get_TrxName());						
			 }
			
		}
		
		return "@OK@";

	} 


	/**
	 * Explosion the Production Plan
	 * @param pp
	 * @param product
	 * @param qty
	 * @throws Exception 
	 */
	private int explosion(X_M_ProductionPlan pp , MProduct product , BigDecimal qtyreal, BigDecimal qtytheory , int line) throws Exception
	{
		MPPProductBOM bom = MPPProductBOM.getDefault(product, get_TrxName());
		if(bom == null )
		{	
			raiseError("Do not exist default BOM for this product :" 
					+ product.getValue() + "-" 
					+ product.getName(),"");
			
		}				
		MPPProductBOMLine[] bom_lines = bom.getLines(new Timestamp (System.currentTimeMillis()));
		m_level += 1;
		int components = 0;
		line = line * m_level;
		for(MPPProductBOMLine bomline : bom_lines)
		{
			MProduct component = MProduct.get(getCtx(), bomline.getM_Product_ID());
			
			if(component.isBOM() && !component.isStocked())
			{	
				explosion(pp, component, bomline.getQtyBOM(), new BigDecimal(0) , line);
			}
			else
			{	
				line += 1;
		
				
				// Production theory
				X_M_ProductionTheory pt = new X_M_ProductionTheory(getCtx(), 0 , get_TrxName());
				pt.setLine(line);
				pt.setDescription(bomline.getDescription());
				pt.setM_Product_ID(bomline.getM_Product_ID());
				pt.setM_Locator_ID(pp.getM_Locator_ID());
				pt.setM_ProductionPlan_ID(pp.getM_ProductionPlan_ID());
				pt.setMovementQty(bomline.getQtyBOM().multiply(qtytheory).negate());
				pt.setIsDensifying(bomline.IsDensifying());
				
				//Obtiene Costos Promedios de la Localización
				getAvgCost(pt.getM_Locator_ID(), pt.getM_Product_ID());
				
				costs = avgCost; 
				costs_USD = avgCostUsd;
				costs_Pure = avgCostPure; 
				
				pt.setM_Product_Cost(costs.setScale(2,BigDecimal.ROUND_HALF_UP));
				pt.setCost_USD(costs_USD.setScale(2,BigDecimal.ROUND_HALF_UP));
				pt.setCost_Pure(costs_Pure.setScale(2,BigDecimal.ROUND_HALF_UP));
				
				pt.saveEx();				
				
				
				if (!qtyreal.equals(qtytheory)){ //La cantidad solicitada debe ser diferente a la produccion
					//Prodution Real
					X_M_ProductionLine pl = new X_M_ProductionLine(getCtx(), 0 , get_TrxName());
					
					pl.setLine(line);
					pl.setDescription(bomline.getDescription());
					pl.setM_Product_ID(bomline.getM_Product_ID());
					pl.setM_Locator_ID(pp.getM_Locator_ID());
					pl.setM_ProductionPlan_ID(pp.getM_ProductionPlan_ID());
					pl.setMovementQty(bomline.getQtyBOM().multiply(qtyreal).negate());
					pl.setIsDensifying(bomline.IsDensifying());
					pl.setM_Product_Cost(costs.setScale(2,BigDecimal.ROUND_HALF_UP));
					pl.setCost_USD(costs_USD.setScale(2,BigDecimal.ROUND_HALF_UP));
					pl.setCost_Pure(costs_Pure.setScale(2,BigDecimal.ROUND_HALF_UP));
					pl.saveEx();
		            //aqui deberia reservar el producto ???
				}
			
				
				components += 1;
				
			}
		
		}
		return  components;
	}	
	
	private void raiseError(String string, String sql) throws Exception {
		String msg = string;
		ValueNamePair pp = CLogger.retrieveError();
		if (pp != null)
			msg = pp.getName() + " - ";
		msg += sql;
		throw new AdempiereUserError (msg);
	}
	
	private boolean recalc_cost(X_M_Production prod){
		String sql,sqlpure, sqlusd;
		BigDecimal qty;
		
		sql = "select sum(M_Product_Cost * movementqty)  from m_productionplan pp, m_productionline pl where pp.m_productionplan_id = pl.m_productionplan_id and pp.M_Production_ID="+prod.getM_Production_ID()+" and pl.m_product_id <> pp.m_product_id";
		sqlpure = "select sum(Cost_Pure * movementqty)  from m_productionplan pp, m_productionline pl where pp.m_productionplan_id = pl.m_productionplan_id and pp.M_Production_ID="+prod.getM_Production_ID()+" and pl.m_product_id <> pp.m_product_id";
		sqlusd = "select sum(Cost_USD * movementqty)  from m_productionplan pp, m_productionline pl where pp.m_productionplan_id = pl.m_productionplan_id and pp.M_Production_ID="+prod.getM_Production_ID()+" and pl.m_product_id <> pp.m_product_id";
		
		costs = DB.getSQLValueBD(null, sql);
		costs_Pure = DB.getSQLValueBD(null, sqlpure);
		costs_USD = DB.getSQLValueBD(null, sqlusd);
		
		sql = "select sum(productionqty) from m_productionplan where M_Production_ID=" + prod.getM_Production_ID();
		qty = (DB.getSQLValueBD(null, sql)!=null)? DB.getSQLValueBD(null, sql) : new BigDecimal(1);
		
		costs = costs.divide(qty,2);
		costs_USD = costs_USD.divide(qty,2);
		costs_Pure = costs_Pure.divide(qty,2);
		
		int pplan_id = DB.getSQLValue(null,"SELECT M_ProductionPlan_ID FROM M_ProductionPlan where M_Production_ID=" + prod.getM_Production_ID());
		X_M_ProductionPlan pplan = new X_M_ProductionPlan(getCtx(), pplan_id , get_TrxName());
		
		int linea = DB.getSQLValue(null, "SELECT M_Productionline_ID from M_ProductionLine WHERE M_ProductionPlan_ID="+pplan_id+" AND M_Product_ID="+pplan.getM_Product_ID());
		X_M_ProductionLine plin = new X_M_ProductionLine(getCtx(), linea , get_TrxName());
		plin.setM_Product_Cost(costs.abs());
		plin.setCost_USD(costs_USD.abs());
		plin.setCost_Pure(costs_Pure.abs());
		plin.save();
		
		//String sql3 = "Update m_productionline set m_product_cost ="+ newc.toString() + " where m_product_id in (select m_product_id from m_productionplan where m_production_id="+prod.getM_Production_ID()+")";
		//DB.executeUpdate(sql3);
		
		
		return true;
	}
	
	@SuppressWarnings("unused")
	private void getAverageCost(int plan_id, X_M_Production production){
		
		recalc_cost(production); // Calcula el Costo del Producto a Producir
		
		List<X_M_ProductionLine> lines = new Query(getCtx(), X_M_ProductionLine.Table_Name, "M_ProductionPlan_ID = ?", get_TrxName())
		.setParameters(plan_id)
		.setOrderBy(X_M_ProductionLine.COLUMNNAME_Line)
		.list();
		
		int M_LocatorTo_ID = 0;
		MWarehouse warehouse;
		BigDecimal totalQty;
		
		for (X_M_ProductionLine line : lines){
			//promedia todos los costos del almacen
			
			MLocator locator = MLocator.get(getCtx(), line.getM_Locator_ID());
			String MovementType = MTransaction.MOVEMENTTYPE_ProductionPlus;		
			BigDecimal MovementQty = line.getMovementQty();	
			
			//Obtiene Costos Promedios de la Localización
			getAvgCost(line.getM_Locator_ID(), line.getM_Product_ID());
			
			costs = avgCost; 
			costs_USD = avgCostUsd;
			costs_Pure = avgCostPure; 
			
			
			if (!line.isActive())
				continue;
			if (!line.isIn())
				if(!costs.equals(new BigDecimal(0)))
					setAverageCost(line.getM_Locator_ID(), line.getM_Product_ID());
			
			
			
			//MProduct product = line.getProduct();	

			if(line.isIn())
			{
				//Totalizar Almacen por Ronny Montaño
				M_LocatorTo_ID = line.getM_Locator_ID();

				warehouse = new MWarehouse(Env.getCtx(), locator.getM_Warehouse_ID(), get_TrxName());
				
				if (!warehouse.isNation())
				{
					totalQty = MStorage.getQtyAvailable(0, line.getM_Locator_ID(), line.getM_Product_ID(), 0, get_TrxName());

					if((totalQty != null) && (totalQty.signum()>0)){
						
						//Elimina Registros de la localizacion - producto
						deleteFromStorage(line.getM_Locator_ID(), line.getM_Product_ID());
						
						MAttributeSetInstance instance = new MAttributeSetInstance(Env.getCtx(), 0, null); //Attribute Set Instance
						instance.save();
						
						MStorage storage = MStorage.getCreate(Env.getCtx(), line.getM_Locator_ID(), line.getM_Product_ID(), instance.getM_AttributeSetInstance_ID(), null); //Creo Nuevo Registro Totalizado
						storage.setQtyOnHand(totalQty);
						storage.setM_Product_Cost(avgCost);
						storage.setCost_USD(avgCostUsd); //USD
						storage.setCost_Pure(avgCostPure);
						storage.setQtyOrdered(new BigDecimal(0));
						storage.setQtyReserved(new BigDecimal(0));
						storage.save();
					}
				}
				
				
			}
			
			
			if (!MStorage.add(getCtx(),locator.getM_Warehouse_ID(),
					line.getM_Locator_ID(),
					line.getM_Product_ID(), 
					line.getM_AttributeSetInstance_ID(), 0, 
					line.getMovementQty(), Env.ZERO ,  Env.ZERO , get_TrxName()))
			{
				String m_processMsg = "Cannot correct Inventory (MA)";
			}
			
				//Actualizacion del costo de producto en el almacen
				MStorage mst = MStorage.get(getCtx(), line.getM_Locator_ID(), line.getM_Product_ID(), 
						line.getM_AttributeSetInstance_ID(), get_TrxName());
				if(line.isIn())
				{
					mst.setM_Product_Cost(line.getM_Product_Cost().abs());
					mst.setCost_USD(line.getCost_USD().abs());
					mst.setCost_Pure(line.getCost_Pure().abs());
				}else{
					mst.setM_Product_Cost(costs.abs());
					mst.setCost_USD(costs_USD.abs());
					mst.setCost_Pure(costs_Pure.abs());
				}
				mst.save();
			
			MTransaction mtrx = new MTransaction (getCtx(), line.getAD_Org_ID(), 
					MovementType, locator.getM_Locator_ID(),
					line.getM_Product_ID(), line.getM_AttributeSetInstance_ID(), 
					MovementQty, production.getMovementDate(), get_TrxName());
				mtrx.setM_ProductionLine_ID(line.getM_ProductionLine_ID());
				mtrx.saveEx();
				
				line.setProcessed(true);
				line.saveEx();
			
		}
		
	}
	
	/**
	 * Set the average cost to Locator
	 */
	private void setAverageCost(int M_Locator_ID, int M_Product_ID){

		MStorage lines[] = MStorage.getAll(Env.getCtx(), M_Product_ID, M_Locator_ID, get_TrxName());
		
		for (MStorage line : lines) {
			line.setM_Product_Cost(costs);
			line.setCost_USD(costs_USD==null ? new BigDecimal(0) : costs_USD);
			line.setCost_Pure(costs_Pure==null ? new BigDecimal(0) : costs_Pure);
			line.save();
		}
		
	}
	
	
	/**
	 * Get the average cost for Locator
	 */
	private void getAvgCost(int M_Locator_ID, int M_Product_ID){

		//Inicializar
		avgCost = new BigDecimal(0);
		avgCostUsd = new BigDecimal(0);
		avgCostPure = new BigDecimal(0);
		BigDecimal qty = new BigDecimal(0);
		
		//Lineas de Localización con Qty > 0
		MStorage lines[] = MStorage.getAllWithQty(Env.getCtx(), M_Product_ID, M_Locator_ID, get_TrxName());
		
		for (MStorage line : lines) {
			qty = qty.add(line.getQtyOnHand());
			avgCost = avgCost.add((line.getM_Product_Cost()==null ? new BigDecimal(0) : line.getM_Product_Cost()).multiply(line.getQtyOnHand()));
			avgCostUsd = avgCostUsd.add((line.getCost_USD()==null ? new BigDecimal(0) : line.getCost_USD()).multiply(line.getQtyOnHand()));
			avgCostPure = avgCostPure.add((line.getCost_Pure()==null ? new BigDecimal(0) : line.getCost_Pure()).multiply(line.getQtyOnHand()));
		}
		
		if(qty.signum()>0) {
			avgCost = avgCost.divide(qty, 4, BigDecimal.ROUND_HALF_UP);
			avgCostUsd = avgCostUsd.divide(qty, 4, BigDecimal.ROUND_HALF_UP);
			if(avgCostUsd.signum()==0)
				avgCostPure = avgCost;
			else
				avgCostPure = avgCostPure.divide(qty, 4, BigDecimal.ROUND_HALF_UP);;
		}
		
		
	}
	
	
	/**
	 * Delete From Storage
	 */
	private void deleteFromStorage(int M_Locator_ID, int M_Product_ID) {
		
		MStorage lines[] = MStorage.getAll(Env.getCtx(), M_Product_ID, M_Locator_ID, get_TrxName());
		
		for (MStorage line : lines) {
			line.delete(true);
		}
	}
	
	
	/**
	 * Delete ZERO Storage
	 */
	@SuppressWarnings("unused")
	private void deleteZeroStorage(int M_Locator_ID, int M_Product_ID) {
		
		MStorage lines[] = MStorage.getAllWithOutQty(Env.getCtx(), M_Product_ID, M_Locator_ID, get_TrxName());
		
		for (MStorage line : lines) {
			line.delete(true);
		}
	}
	
} // M_Production_Run
