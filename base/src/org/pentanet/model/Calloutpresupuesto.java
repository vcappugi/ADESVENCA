package org.pentanet.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.util.Env;

public class Calloutpresupuesto extends CalloutEngine {

	public void buscacliente (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{		
		mTab.setValue("Description", "value");
        mTab.setValue("C_Bpartner_ID",Env.ONE);
        MBPartner mb = new MBPartner(ctx,(Integer)value,null);
        if(!(mb.getC_BPartner_ID()==0))
        {
        	mTab.setValue("Name",mb.getName());
        }
        else
        {
        	mTab.setValue("Name","No localizado");
        }
        	
      
          
	}	
	
	
}
