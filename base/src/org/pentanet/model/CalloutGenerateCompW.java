package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.pentanet.model.MLCOComprobant;

public class CalloutGenerateCompW extends CalloutEngine {
	
	/*
	 * Genera Comprobante de retencion IVA
	 * Diciembre 2013
	 * PAra solventar art. 10 ley impuestos y retenciones
	 * comprobantes de fretencion a terceros
	 */
	public void Comp_IVA (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		//int fact = mTab.getValue("C_Invoice_ID") ;
		String sql = "select C_Inoice_ID, LCO_InvoiceWithholding_ID, C_Tax_ID,taxbaseamt, taxamt "
				+" from lco_invoicewithholding where" 
				+" c_invoice_id ="+mTab.getValue("C_Invoice_ID")+" and c_tax_id in (select c_tax_id from c_tax where c_taxcategory_id =1000003) "
				+" MLCOComprobant comprobant = new MLCOComprobant(ctx,0, null)";
		PreparedStatement pstmt = DB.prepareStatement (sql, null);
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next ())
				{
				MLCOComprobant comprobant = new MLCOComprobant (ctx, 0,null); 
				//comprobant.setC_Invoice_ID();
				//comprobant.setnum_comprobante(num_comprobante);
				//comprobant.setC_Payment_ID(pago);
				}
		}catch (SQLException e) {
				
				e.printStackTrace();//
			}
		
		
	} //Comp_IVA
}
