package org.pentanet.model;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutResponsibleF extends CalloutEngine {
	public void fillPatient (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{	
		String id_Adm =  mTab.get_ValueAsString("H_Admission_ID");
		int id_p = DB.getSQLValue(ctx.toString(), "SELECT H_PATIENT_ID FROM H_ADMISSION WHERE H_ADMISSION_ID="+id_Adm);
		mTab.setValue("H_Patient_ID", id_p);
		
		
	} 

}
