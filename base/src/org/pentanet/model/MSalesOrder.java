/*
 * Extension de la Orden de Venta especial para los procesos
 * de clinicas desarrollados por Pentanes, C.A.
 * Por Vcappugi
 * 
 */

package org.pentanet.model;


import java.math.BigDecimal;
import java.util.Properties;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;


public class MSalesOrder extends MOrder {
	
	private static final long serialVersionUID = -1575104995897726572L;
	
	public MSalesOrder(Properties ctx, int C_Order_ID, String trxName)
	{
		super (ctx, C_Order_ID, trxName);
	}
	
	/**********************************************************************************
	 * CreateOrderLine
	 * Crea la linea de la orden e incluye el @producto
	 * Recibe: Order de tipo MSalesOrder
	 *         M_Product de tipo int
	 *         Qty de tipo BigDecimal
	 *         UOM de tipo int
	 *         Budget Id del presupuesto
	 *         pricenetered BigDecimal
	 *         cons bandera para "CO" Consumino o "NC" No consumido
	 **********************************************************************************/
		public String CreateOrderLine (MSalesOrder Order, int MProduct, BigDecimal qty, BigDecimal Price, int uom, int Budget, String cons ){
			int prod;
			//Determinar si el producto es facturable (solo se crean en la orden los facturables)
			if (Isinvoiced(MProduct)) {
					if (cons == "CO") 
						prod = validate_item_budget(MProduct, qty, Price,Budget, Order.getC_Order_ID());
					else
						prod = MProduct;
					if (prod >0) {
						//Determinar si el producto existe en la orden y añadir cantidades si es asi o crear nuevo si no
						int line_id=DB.getSQLValue(null,"SELECT C_OrderLine_ID FROM C_ORDERLINE WHERE C_ORDER_ID="+Order.getC_Order_ID() 
								+ " AND M_PRODUCT_ID="+MProduct);
						if (line_id < 0)
							line_id=0;
						
						if(valida_producto_unico(prod,Order.getC_Order_ID()))
						{
							MOrderLine line = new MOrderLine(getCtx(), line_id, get_TrxName());
							BigDecimal cant_ant;
							if (line_id != 0) {
								cant_ant = line.getQtyEntered().add(qty) ;
							    line.setQtyOrdered(cant_ant);
								line.setQtyEntered(cant_ant);
								line.save();
							}
								
							else {	
								int BPLoc = Order.getC_BPartner_Location_ID();
								int BP = Order.getC_BPartner_ID();
								line.setC_Order_ID(Order.getC_Order_ID());
								line.setM_Product_ID(MProduct);
								line.setQtyOrdered(qty);
								line.setQtyEntered(qty);
								line.setPrice(Price);
								line.setPriceActual(Price);
								line.setPriceEntered(Price);
								line.setC_BPartner_ID(BP);
								line.setDatePromised(Env.getContextAsDate(getCtx(), "#Date"));
								line.setC_BPartner_Location_ID(BPLoc);
								line.setC_UOM_ID(uom);
								line.save();
							}
						}
					}
					else
					{
						//Si no Da el presupuesto.... que hago??
						ADialog.warn(0, null,"PRESUPUESTO NO CUBIERTO PARA ESTA CANTIDAD....");
					}
			}		
			return null;
		}
		
		/******************************************************
		 * medicina_presupuestada
		 * busca el producto dentro del presupuesto
		 * si es medicina (en el presupuesto esta un producto generico) valida el monto 
		 * y lo compara con el total por medicinas en la orden
		 * devuelve el id del producto medicina, para inclusion
		 * o cero si no hay producto
		 *******************************************************/
		public int validate_item_budget (int M_Product, BigDecimal qty, BigDecimal price, int Budget, int SalesO){
			int devuelve=0;
			BigDecimal a_incluir = qty.multiply(price);
			//Total de medicina presupuestada
			String sql1 ="select sum(linetotalamt) from H_asigned_budget_line where H_Asigned_budget_id = "
					+ Budget+" and m_product_id in (select M_Product_id from m_product where m_product_category_id in"
					+ "(select m_product_category_id from m_product_category where IsInvoiced ='N')) ";
			BigDecimal total_M_B = DB.getSQLValueBD(null, sql1);
			//Total de medicina en orden de ventas
			String sql2 = "SELECT SUM(LINENETAMT) FROM C_ORDERLINE WHERE "
						+ "C_ORDER_ID="+SalesO+" AND M_PRODUCT_ID IN "
						+ "(SELECT M_PRODUCT_ID FROM M_PRODUCT WHERE M_PRODUCT_CATEGORY_ID = "
						+ "(SELECT M_PRODUCT_CATEGORY_ID FROM M_PRODUCT_CATEGORY WHERE VALUE='MED'))";
			BigDecimal total_M_O = (DB.getSQLValueBD(null,sql2)==null ? new BigDecimal(0):DB.getSQLValueBD(null,sql2));
			
			if (total_M_B.compareTo(total_M_O.add(a_incluir)) >0)
				devuelve = M_Product;
			
			return devuelve;
		}
		/**************************************************************
		 * IsInvoiced : Determina si el product esta dentro de la catgoria de los
		 *              no facturables.
		 * Recibe:		El Id del Producto
		 * Devuelve:    Verdadero si es facturable/Falso si no
		 **************************************************************/
		public boolean Isinvoiced(int MProduct){
			boolean respuesta;
			String sqli = "select isinvoiced from m_product_Category where m_product_category_id = "
					+ "(select m_product_category_id from m_product where m_product_id ="+MProduct+")";			
			respuesta = (DB.getSQLValueString(null,sqli).equalsIgnoreCase("Y"));	
			
			return respuesta;
		}
		
		public boolean valida_producto_unico(int producto_id , int orden_id){
			String es_unico = DB.getSQLValueString(null, "Select m_charge_all from m_product where m_product_ID="+producto_id);
			
			int id_prod = DB.getSQLValue(null, "select M_Product_id from c_orderline where C_Order_ID ="+orden_id+" and M_PRoduct_ID="+producto_id);
			if (id_prod > 0 && es_unico.equalsIgnoreCase("Y"))
				return false;
			else
				return true;
		}

	
	
	
}

