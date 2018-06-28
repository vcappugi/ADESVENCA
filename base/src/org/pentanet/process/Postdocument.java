package org.pentanet.process;

import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.Timestamp;

import org.compiere.model.MAcctSchema;
import org.compiere.model.MInvoice;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.acct.Doc;


public class Postdocument extends SvrProcess {

	private int P_C_Invoice_ID;
	private int P_C_Doctype_ID;
	private int P_Table_ID;
	private Timestamp P_DateAcct;
	public String sql="";
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (name.equals("C_Invoice_ID"))
			   P_C_Invoice_ID = para[i].getParameterAsInt();
			else if (name.equals("C_DocType_ID"))
				P_C_Doctype_ID = para[i].getParameterAsInt();
			else if (name.equals("AD_Table_ID"))
				P_Table_ID = para[i].getParameterAsInt();
			else if (name.equals("DateAcct"))
				P_DateAcct = (Timestamp) para[i].getParameter();
		}

	}

	@Override
	protected String doIt() throws Exception {
		int record_id = P_C_Invoice_ID;
		MInvoice inv = new MInvoice(getCtx(), record_id, null);
		MAcctSchema eschem[] = new MAcctSchema[] { new MAcctSchema(getCtx(),1000000, null)};
		String tablename = DB.getSQLValueString(get_TrxName(), "SELECT TABLENAME FROM AD_TABLE WHERE AD_TABLE_ID=" +P_Table_ID );
		
		if (tablename.equalsIgnoreCase("C_Invoice"))
					 sql= "SELECT * FROM C_INVOICE WHERE DATEACCT <=?" ;  //Facturas
		if (tablename.equalsIgnoreCase("C_Payment"))
			sql= "SELECT * FROM C_Payment WHERE DATEACCT <=?" ;           // Pagos
		if (tablename.equalsIgnoreCase("C_Order"))
			sql= "SELECT * FROM C_Order WHERE DATEACCT <=?" ;             //Ordenes (cuidado, otro proceso de contabilidad)
		if (tablename.equalsIgnoreCase("M_InOut"))						
			sql = "SELECT * FROM M_InOut WHERE DATEACCT <=?" ;             //Recepciones
		if (tablename.equalsIgnoreCase("M_InOut"))						
			sql = "SELECT * FROM M_InOut WHERE DATEACCT <=?" ;             //Entradas y salidas de inventario
		if (tablename.equalsIgnoreCase("M_Inventory"))						
			sql = "SELECT * FROM M_Inventory WHERE MOVEMENTDATE <=?" ;          //Consumos e inventario (conteo) 
		if (P_C_Doctype_ID>0)
			sql = sql + " AND C_DocType_ID =?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		pstmt = DB.prepareStatement (sql, get_TrxName());
		pstmt.setTimestamp(1, P_DateAcct);  
		pstmt.setInt(2, P_C_Doctype_ID);
	    rs = pstmt.executeQuery ();
		while (rs.next ())
		{
		   Doc doc = Doc.get(eschem, P_Table_ID, rs, null);
		//doc = doc.get(eschem, 318, rs, null);
		   doc.post(false, false);

		}		
		return null;
	}

}
