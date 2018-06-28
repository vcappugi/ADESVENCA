package org.pentanet.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.compiere.model.MInventory;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class RepostedForceDoc extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	protected String doIt() throws Exception {
		
		String sql = "select m_inventory_id from m_inventory where movementdate >= '01/10/2014' and   DocStatus in ('CO') and M_Inventory_ID=1002463";
        String resp=" ";
		PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs = pstmt.executeQuery ();
		    while (rs.next ())
		    {
		      MInventory minv = new MInventory(getCtx(),rs.getInt(1),null);
		      resp = minv.getDoc().post(true, true);
		      
		      
		}
		return resp;
	}

}
