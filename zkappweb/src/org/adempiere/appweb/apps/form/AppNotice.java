package org.adempiere.appweb.apps.form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.appweb.AppWindow;
import org.adempiere.appweb.apps.AEnv;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

public class AppNotice extends Panel{

	private Div irow;
	private Div rowim;
	
	private Properties ctx;
	private AppWindow appwnd;
	
	private static final CLogger log = CLogger.getCLogger (AppInfor.class);
	
	public AppNotice (Properties ctx, AppWindow appwindow){
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
	    
	    Label ilbl = new Label("A  V  I  S  O");
	    ilbl.setClass("label label-primary center-block");
	    
    	Div irow2 = new Div();
    	irow2.setClass("row paddingtop");
	    Div icol3 = new Div();
	    icol3.setClass("col-xs-12");
	    icol3.setAlign("center");
		    Label ilbl3 = new Label("EL DOCUMENTO AL QUE HACE REFERENCIA YA FUE PROCESADO");
		    ilbl3.setClass("font-bold");
    	
	    Div icol4 = new Div();
	    icol4.setClass("col-xs-12");
	    Div icol5 = new Div();
	    icol5.setClass("col-xs-12");

	    Label ilbl4 = null;
	    Label ilbl5 = null;

    	String sql = "SELECT doctype, "
    			+ " (CASE WHEN doc_status = 'NA' THEN 'No Aprobado' ELSE 'Aprobado' END) FROM document_info(?, ?)";
    	
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
				    ilbl4 = new Label("Tipo de Documento: " + rs.getString(1) + ".");
				    ilbl5 = new Label("Acción: " + rs.getString(2)+ ".");

				    
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
				
					icol5.appendChild(ilbl5);
				irow2.appendChild(icol5);

			mcol.appendChild(irow2);
		
		icol1.appendChild(mcol);
	    irow.appendChild(icol1);
	    pc.appendChild(irow);
	    /*
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
    	img1.setSrc("theme/default/images/Aprobado_50.png");
    	msg ="Aprobado";
    	img1.setClass("img-responsive");
    	rcol1.appendChild(img1);
    	
    	pc.appendChild(rowim);*/
    	
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
    
}
