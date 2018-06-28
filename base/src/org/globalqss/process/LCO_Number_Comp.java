package org.globalqss.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class LCO_Number_Comp extends SvrProcess {
	private int		p_Record_ID = 0;
	@Override
	protected void prepare() {
		p_Record_ID = getRecord_ID();

	}

	@SuppressWarnings("unused")
	@Override
	protected String doIt() throws Exception {
		int numb = number_comprob(p_Record_ID);
		return null;
	}

	
	/*
	 * Num Comprob by vcappugi
	 * update number of comprob for iva, islr and mun.
	 * valid to R.B. Venezuela....
	 */
		@SuppressWarnings("unused")
		int number_comprob(int C_Invoice_id){
			String sql="select c_tax_id from lco_invoicewithholding where c_invoice_id = "+C_Invoice_id+" and c_tax_id in (Select c_tax_id from c_tax where c_taxcategory_id =1000003)";
			//ADialog.info(A_WindowNo , null,"esta es una prueba");
			int tipo = DB.getSQLValue(null,sql);
			if (tipo >0) { //Retencion de IVA
				String tiene = DB.getSQLValueString(null,"select num_comprobante from c_invoice where c_invoice_id="+C_Invoice_id);
			if (tiene == null) {
				String st_anterior=DB.getSQLValueString(null,"select num_comp_iva  from num_comprobantes");
				int nu_anterior = DB.getSQLValue(null,"select cont_comp_iva from num_comprobantes ");
				String sql_n ="select to_char((select dateinvoiced from c_invoice where c_invoice_id = "+C_Invoice_id+"),'YYYY-MM')||'-' ||lpad((select (cont_comp_iva+1)::int from num_comprobantes)::varchar,9,'0')  from c_invoice where c_invoice_id = " +C_Invoice_id;
				String nuevo_nro = DB.getSQLValueString(null,sql_n);
				int fact = DB.executeUpdate(null,"update c_invoice set num_comprobante='"+nuevo_nro+"' where c_invoice_id="+C_Invoice_id);
				int incrementa = DB.executeUpdate(null,"update num_comprobantes set cont_comp_iva=cont_comp_iva+1, num_comp_iva='"+nuevo_nro+"'");
			}
			}
		return 1;
		}
}
