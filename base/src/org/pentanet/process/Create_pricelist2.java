package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;

import org.compiere.model.MProductPrice;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereSystemError;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.util.ValueNamePair;
import org.pentanet.model.MHATreatment;

public class Create_pricelist2 extends SvrProcess {
	
	private int mod_pricelist_ID=0;
	private int S_PriceList_ID =0;
	private int S_PriceListVersion_ID =0;
	private int T_PriceList_ID =0;
	private int T_PriceListVersion_ID =0;
	
	private BigDecimal General_Increment;
	private int m_AD_PInstance_ID = 0; 
	
	
	protected void prepare() {
		mod_pricelist_ID=getRecord_ID();
		 m_AD_PInstance_ID = getAD_PInstance_ID();
		 // buscar los datos del registro de modificcacion de lista de precios
		 String sql = "select docstatus, m_pricelist_id, m_pricelisttarget_id, percent, m_pricelist_version_id, m_pricelist_tversion_id from h_mpricelist_mod where h_mpricelist_mod_id="+mod_pricelist_ID;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try
			{
	    		pstmt = DB.prepareStatement(sql, "H_MPricelist_mod");
				rs = pstmt.executeQuery();
				while (rs.next())
				{  S_PriceList_ID = rs.getInt(2);
					T_PriceList_ID = rs.getInt(3);
				   S_PriceListVersion_ID = rs.getInt(5);
				   T_PriceListVersion_ID=rs.getInt(6);
				   General_Increment = rs.getBigDecimal(4);
				}
					
			}
			catch(Exception e){
				log.info(e.toString());
			}
		 
		 
		 
		/* esto estaba en el original, debe quitarse ??
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("Incremental"))
				Incremental = (BigDecimal) para[i].getParameter();
			else if (name.equals("PriceList_Version_ID"))
				p_PriceList_Version_ID = para[i].getParameterAsInt();			
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		if (p_PriceList_Version_ID==0) {
			p_PriceList_Version_ID = getRecord_ID();
		}
		
		 */
	} //*prepare*/

	@Override
	protected String doIt() throws Exception {
		/*
		 *  Modificar la condenada lista de precios
		 *  en base a lo que consiga en una tabla 
		 *  donde esta el porcentaje por tipo de 
		 *  producto 
		 */
		BigDecimal new_price;
		BigDecimal Incremento = General_Increment;
		String sql_prod;
		String sql_p = "Select M_Product_ID, PriceList from M_ProductPrice where M_Pricelist_Version_ID=" + S_PriceListVersion_ID + " order by m_product_id";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
    		pstmt = DB.prepareStatement(sql_p, "M_ProductPrice");
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				//validar si hay modificaciones especificas para la categoria de producto
				sql_prod = "select percent from h_mpricelist_mod_line where m_product_category_id=(select m_product_category_id from m_product where m_product_id="+rs.getInt(1)+") and h_mpricelist_mod_id="+mod_pricelist_ID;
				PreparedStatement pstmt2 = null;
				ResultSet rs2 = null;
				try
				{
					pstmt2 = DB.prepareStatement(sql_prod, "H_MPricelist_mod_line");
					rs2 = pstmt2.executeQuery();
					while (rs2.next()) {
					if (rs2.getInt(1) !=0 )
						Incremento = rs2.getBigDecimal(1);
					else
						Incremento = General_Increment;
					}
				}
				catch(Exception e){
					///log.info(e.toString());
					//return e.toString();
					Incremento = General_Increment;
				}


				
				new_price = rs.getBigDecimal(2).add((rs.getBigDecimal(2).multiply(Incremento)).divide(new BigDecimal(100)));
				MProductPrice product_price = new MProductPrice(getCtx(), 0,null);
				product_price.setM_PriceList_Version_ID(T_PriceListVersion_ID);
				product_price.setM_Product_ID(rs.getInt(1));
				product_price.setPriceList(new_price);
				product_price.setPriceLimit(new_price);
				product_price.setPriceStd(new_price);
				product_price.save();
				
			}
		}	
		catch(Exception e){
			log.info(e.toString());
			return e.toString();
		}
		String update = "update h_mpricelist_mod set DocAction='CO', DocStatus ='CL', Processed='Y' where h_mpricelist_mod_id="+mod_pricelist_ID;
		DB.executeUpdate(update, getCtx().toString());
		DB.executeUpdate("update h_mpricelist_mod_line set processed='Y' where h_mpricelist_mod_ID=" +mod_pricelist_ID, getCtx().toString());
				
		return "Modificación Realizada exitosamente !!!";
	}
	

}
