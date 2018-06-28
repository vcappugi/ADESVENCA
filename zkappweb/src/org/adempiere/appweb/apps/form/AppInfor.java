package org.adempiere.appweb.apps.form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.appweb.AppWindow;
import org.adempiere.appweb.apps.AEnv;
import org.adempiere.appweb.apps.wf.WFAActivity;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.wf.MWFActivity;
import org.eevolution.model.MHRPeriod;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Textbox;

public class AppInfor extends Panel{
	

	private Div irow;
	private Div rowim;
	
	private Properties ctx;
	private AppWindow appwnd;
	
	private static final CLogger log = CLogger.getCLogger (AppInfor.class);
	
	public AppInfor (Properties ctx, AppWindow appwindow){
        this.ctx = ctx;
        this.appwnd = appwindow;
        
        init();
	}
	

    private void init(){
    	
    	Panelchildren pc = new Panelchildren();
    	pc.setParent(this);
    	
    	//Fila Header
    	irow = new Div();
    	irow.setClass("row");
    	irow.setVisible(true);
    	
    	Div icol1 = new Div();
    	icol1.setClass("col-sm-6 col-sm-offset-3");
    	
    	Div mcol = new Div();
    	mcol.setClass("thumbnail2");
    	
    	Div irow1 = new Div();
    	irow1.setClass("row");
    	
	    Div icol2 = new Div();
	    icol2.setClass("col-xs-12");
	    
	    Label ilbl = new Label("Informacíon del Documento");
	    ilbl.setClass("label label-primary center-block");
	    
    	Div irow2 = new Div();
    	irow2.setClass("row paddingtop");
    	
	    Div icol3 = new Div();
	    icol3.setClass("col-xs-12");
	    Div icol4 = new Div();
	    icol4.setClass("col-xs-12");
	    /*
	    Div icol5 = new Div();
	    icol5.setClass("col-xs-12");
		    */
	    Div icol6 = new Div();
	    icol6.setClass("col-xs-12");
	    Div icol7 = new Div();
	    icol7.setClass("col-xs-12");
	    Div icol8 = new Div();
	    icol8.setClass("col-xs-12");
	    
	    Label ilbl3 = null;
	    Label ilbl4 = null;
	    //Label ilbl5 = null;
	    Label ilbl6 = null;
	    Label ilbl7 = null;
	    Label ilbl8 = null;
 
    	String sql = "SELECT doctype, userd, documentno, description, coalesce(to_char(total, 'FM9,999,999.00') || ' ' || moneda, ' ') "
    			+ " FROM document_info(?, ?)";
    	
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
		try{
			
			//log.warning("User: " + Env.getContext(ctx, "ADTable"));
			pstm = DB.prepareStatement (sql, null);
			
			pstm.setObject(1, AEnv.getAD_Table_ID(ctx));
			pstm.setObject(2, AEnv.getRecord_ID(ctx));
			
			rs = pstm.executeQuery ();

			
			while (rs.next ())
			{
				    ilbl3 = new Label("Tipo de Documento: " + rs.getString(1) + ".");
				    ilbl4 = new Label("Solicitante: " + rs.getString(2)+ ".");
				    //ilbl5 = new Label("Fecha/Hora: 24-09-2015 08:19 am..");
				    ilbl6 = new Label("Documento: " + rs.getString(3)+ ".");
				    ilbl7 = new Label("Descripción: " + rs.getString(4)+ ".");
				    ilbl8 = new Label("Monto: " + rs.getString(5)+ ".");
				    
			}//Close de Resultset y PreparedStatement
			pstm.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new AdempiereException("Error Calculando Variable Parciales" );
		}
		
					icol2.appendChild(ilbl);
	    		irow1.appendChild(icol2);
	    	mcol.appendChild(irow1);

			    	icol3.appendChild(ilbl3);
				irow2.appendChild(icol3);
					icol4.appendChild(ilbl4);
				irow2.appendChild(icol4);
					//icol5.appendChild(ilbl5);
				//irow2.appendChild(icol5);
					icol6.appendChild(ilbl6);
				irow2.appendChild(icol6);
					icol7.appendChild(ilbl7);
				irow2.appendChild(icol7);
					icol8.appendChild(ilbl8);
				irow2.appendChild(icol8);
			mcol.appendChild(irow2);
		
		icol1.appendChild(mcol);
	    irow.appendChild(icol1);
	    pc.appendChild(irow);
	    
    	//Fila Imagen Desc
    	rowim = new Div();
    	rowim.setClass("row");
    	rowim.setVisible(true);
    	
    	Div rcol1 = new Div();
    	rcol1.setClass("col-lg-offset-4 col-lg-4  col-md-offset-4 col-md-4  col-sm-offset-4 col-sm-4 col-xs-offset-4 col-xs-4");
    	rcol1.setAlign("center");
    	rowim.appendChild(rcol1);
    	

    	String msg = "";
    	
    	Image img1 = new Image();
    	if (AEnv.getAppweb_ID(ctx) == 1){
    		eventInfo("OK");
    		img1.setSrc("theme/default/images/Aprobado_50.png");
    		msg ="Aprobado";
    	}else{
    		eventInfo("CANCEL");
    		img1.setSrc("theme/default/images/rechazar_45.png");
    		msg ="Rechazado";
    	}
    	img1.setClass("img-responsive");
    	rcol1.appendChild(img1);
    	
    	pc.appendChild(rowim);
    	
    	//Fila info
	    Div icol9 = new Div();
	    icol9.setClass("col-xs-12");
	    icol9.setAlign("center");
		    Label ilbl9 = new Label(msg);
		    ilbl9.setClass("font-bold");
		icol9.appendChild(ilbl9);
		   
		pc.appendChild(icol9);
    	
    	appwnd.appendChild(this);
    	
    }
    
    public void removerComp(){
    	for(int i = 0; i< appwnd.getChildren().size(); i++){
    		if (appwnd.getChildren().get(i).equals("Plogin")){
    			appwnd.removeChild((Component) appwnd.getChildren().get(i));
    			break;
    		}
    	} 

    }
    
    private void eventInfo(String action){
    	
    	log.warning("Approved: " + AEnv.getRecord_ID(ctx));
    	
    	MWFActivity m_act = new MWFActivity (ctx, AEnv.getAD_WF_Activity_ID(ctx), null);
    	WFAActivity wfa = new WFAActivity(ctx, appwnd);
    	wfa.onOK(m_act);
    	log.warning("Approved: " + action);
  
    }

}
