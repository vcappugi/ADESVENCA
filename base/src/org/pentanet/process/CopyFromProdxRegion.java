package org.pentanet.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.apps.ADialog;
import org.pentanet.model.MHProdxRegion;
import org.pentanet.model.MHProdxRegionLines;



public class CopyFromProdxRegion extends SvrProcess {
	int ProdxRegion_ID_From;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("H_ProdxRegion_ID_From"))
				ProdxRegion_ID_From = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	/************************************************************+
	 * Copy_lines: copiar Lineas de otra estructura de prodxreegion
	 * Recibe: 		ProdxRegion_ID_From : ID del Origen
	 * 				ProdxRegion_ID_To: ID del destino
	 * Devuelve:    Verdadero si ejecuto sin problemas/Falso si no
	 ***************************************************************/
	
	@Override
	protected String doIt() throws Exception {
		MHProdxRegion ProdxRegion_To = new MHProdxRegion(getCtx(), getRecord_ID(),null);
		MHProdxRegionLines LineNew = null;
		
		String sql_origen = "SELECT M_Product_ID, NAME, QTY, VALUE, C_UOM_ID FROM H_PRODXREGION_LINES WHERE H_PRODXREGION_ID= " +ProdxRegion_ID_From;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql_origen, "HProdxRegion_Lines");
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				LineNew = new MHProdxRegionLines(getCtx(),0,null);
				LineNew.setH_ProdxRegion_ID(getRecord_ID());
				LineNew.setM_Product_ID(rs.getInt(1));
				LineNew.setName(rs.getString(2));
				LineNew.setQty(rs.getBigDecimal(3));
				LineNew.setValue(rs.getString(4));
				LineNew.setC_UOM_ID(rs.getInt(5));
				LineNew.save();
				
			}
		}
		catch(Exception e){
			log.info(e.toString());
			return e.toString();
		}

		
		
		return "Lineas Generadas Correctamente";
	}

}
