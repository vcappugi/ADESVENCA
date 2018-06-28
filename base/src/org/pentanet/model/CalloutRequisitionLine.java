package org.pentanet.model;
/************************************************************************
 * CalloutRequisitionLine
 * goal: find and manage budget public, without alter normal functionality
 * Module: BudgetPublic
 * Developer: Victor Cappugi 
 * 
 **********************************************************************/
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MRequisition;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;


public class CalloutRequisitionLine extends CalloutEngine {

    //Creacion de linea de asignacion presupuestarias
	//
	public String create_budget_exec(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	
	{
		if ( mTab.get_ValueAsString("DocStatus") == "IP") //Solo es valido para los que no son borrador (In Process)
		{
			String year = mTab.get_ValueAsString("DateDoc");
			int year_id =  DB.getSQLValue(null,"Select C_Year_ID from C_Year where FicalYear='"+year+"' ",0);
			ADialog.warn(WindowNo, null,"El año es :" + year_id);
			
			
		}
		
		
			//ADialog.warn(WindowNo, null,"Esta es una prueba");
		String Res = "Yes";
		
		return Res;
	}
	
	public String generate_req(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		MRequisition mreq = new MRequisition(null,0,null);
		mreq.setDateDoc(Env.getContextAsDate(ctx, "Date"));
		//mreq.setDateRequired();
		//mreq.setPriorityRule("5");
		//mreq.setC_Activity_ID();
		//mreq.setM_Warehouse_ID(M_Warehouse_ID);
		mreq.save();
		
		
		
		
		
		
		return " ";
	}
	
	
}
