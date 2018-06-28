package org.pentanet.model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Properties;
import org.compiere.model.MBPartner;

//import org.adempiere.webui.panel.InfoBPartnerPanel;
//import org.adempiere.webui.panel.InfoPanel;
//import org.compiere.apps.ADialog;
//import org.compiere.apps.search.InfoBPartner;
//import org.compiere.grid.GridController;
//import org.compiere.grid.VPanel;
//import org.compiere.grid.ed.VText;
//import org.compiere.grid.tree.VTreePanel;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.swing.CPanel;
import org.compiere.swing.CTextField;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutPaciente extends CalloutEngine {

	public void Marca_RF (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{	
		String ced_patient = mTab.get_ValueAsString("IDCard");
		
		int bpartner = DB.getSQLValue(null, "SELECT C_BPARTNER_ID FROM C_BPARTNER WHERE VALUE='" + ced_patient+"'");
		if ((value.toString()).equalsIgnoreCase("true")) //Marcado como responsable financiero
			DB.executeUpdate("UPDATE C_BPARTNER SET ISFRESPONSIBLE='Y' WHERE C_BPARTNER_ID="+bpartner, ctx.toString());	
		else
			DB.executeUpdate("UPDATE C_BPARTNER SET ISFRESPONSIBLE='N' WHERE C_BPARTNER_ID="+bpartner, ctx.toString());
		
	}    
          
	
}
