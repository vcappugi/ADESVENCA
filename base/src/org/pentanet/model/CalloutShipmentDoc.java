package org.pentanet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;


import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.apps.ADialog;
import org.compiere.util.Env;



public class CalloutShipmentDoc extends CalloutEngine {
	
	public String createLinesDoc (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		String Doc_ID =  Env.getContext(ctx, WindowNo,"P_ShipmentDoc_ID");
		String chofer = Env.getContext(ctx, WindowNo,"M_Shipper_ID");

		//Busca los datos de los despachos (tipo de doc 1000011) que no este en guia (In_Guia='N')
		//y que este asignado al chofer
		String sql= "select m_inout_id, c_bpartner_id, c_bpartner_location_id  from m_inout where docstatus='CO' and c_doctype_id=1000011 and In_Guia='N' and m_shipper_id="+chofer;
		
		//ADialog.info(WindowNo, null, "El Query es: " + sql);
		
		PreparedStatement pstmt = DB.prepareStatement (sql, "M_InOut");
		try {
			ResultSet rs = pstmt.executeQuery ();
			while (rs.next())
			{
			MPShipmentDocLine DocLine = new MPShipmentDocLine (ctx, 0,null);
			DocLine.setM_InOut_ID(rs.getInt(1));
			DocLine.setP_ShipmentDoc_ID(Integer.parseInt(Doc_ID));
			DocLine.save();
			}
		}
		catch (Exception e) {
			return "Error !!!!" + e;
		}
		
		return "Ok";
		
	}

}
