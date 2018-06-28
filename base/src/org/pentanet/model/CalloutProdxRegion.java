package org.pentanet.model;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;


public class CalloutProdxRegion extends CalloutEngine {
	public void Fill_Name(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
        MProduct prod = new MProduct (ctx,(Integer) value ,null);
        
		mTab.setValue("Name", prod.getName() );
		
	}

}
