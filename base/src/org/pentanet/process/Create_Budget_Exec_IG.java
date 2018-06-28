package org.pentanet.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class Create_Budget_Exec_IG extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		Create_Budget_Exec_inv objeto = Create_Budget_Exec_inv.class.newInstance();
		String sql ="SELECT C_Invoice_ID FROM C_Invoice WHERE DateAcct>='01/05/2018' and DocStatus='CO'";
		
		PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs;
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
				{
				  objeto.ejecuta_inv(rs.getInt(1));
				  System.err.println("ejecutada factura nro: " + rs.getInt(1) + " - ");
				
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Proceso para parar el documento originario
		}
		
		return "Ok";
	}

}
