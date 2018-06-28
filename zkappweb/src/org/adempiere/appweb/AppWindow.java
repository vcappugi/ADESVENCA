package org.adempiere.appweb;


import java.util.Properties;

import org.adempiere.appweb.apps.AEnv;
import org.adempiere.appweb.apps.form.AppLogin;
import org.adempiere.appweb.apps.form.AppNotice;
import org.adempiere.appweb.apps.wf.WFAActivity;
import org.adempiere.appweb.model.MCtxApprove;
import org.adempiere.appweb.session.SessionManager;
import org.adempiere.appweb.util.UserPreference;
import org.adempiere.appweb.IWebClient;
import org.compiere.db.CConnection;
import org.compiere.db.CConnectionEditor;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;



public class AppWindow extends Window implements EventListener , IWebClient{
	
	public static final String APP_NAME = "Adempiere";
	
	private Properties ctx;

	
	private AppLogin  loginDesktop;
	private AppNotice  noticeDesktop;
	
	private UserPreference userPreference;
	private String langSession;
	private boolean		    m_connectionOK = false;
	private CConnectionEditor hostField = new CConnectionEditor();
	private Execution exec = Executions.getCurrent();
	
	private WFAActivity wfa = null;
	

	
	/**	Logger							*/
	private static final CLogger log = CLogger.getCLogger (AppWindow.class);

	
	/** Server Connection       */
	private CConnection 	m_cc;
	
	public AppWindow(){
		
    	userPreference = new UserPreference();
		this.setVisible(true);

	}
 
    
    public void onCreate()
    {   
    	this.getPage().setTitle("Web Movil Adempiere");
    	
        ctx = Env.getCtx();
        langSession = Env.getContext(ctx, Env.LANGUAGE);
        SessionManager.setSessionApplication(this);
        Session session = Executions.getCurrent().getDesktop().getSession();
        
        //log.warning("OK....." + session.getAttribute(SessionContextListener.SESSION_CTX));
        
        if (!SessionManager.isUserLoggedIn(ctx))
        {
	        header();
	    	if(exec.getParameter("id") != null){
	    		MCtxApprove wfapp = new MCtxApprove(exec.getParameter("id"));
	    		wfapp.setCtx(ctx);
	    		//log.warning("OK....." + AEnv.getRecord_ID(ctx));
	    		wfa = new WFAActivity(ctx, this);
	    		
	        	if (wfa.searchActivities(AEnv.getRecord_ID(ctx)) == true){
	        		loginDesktop = new AppLogin(ctx, this);
	        	}else{
	        		log.warning("notice....." + AEnv.getRecord_ID(ctx));
	        		noticeDesktop = new AppNotice(ctx, this);
	        	}
	    	}else{
	    		
	    		loginDesktop = new AppLogin(ctx, this);
	    		
	    	}
	    	
	        
        }else{
        	header();
    		wfa = new WFAActivity(ctx, this);
    		
        	if (wfa.searchActivities(AEnv.getRecord_ID(ctx)) == true){
        		loginDesktop = new AppLogin(ctx, this);
        	}else{
        		log.warning("notice....." + AEnv.getRecord_ID(ctx));
        		noticeDesktop = new AppNotice(ctx, this);
        	}
        	//loginCompleted();
        }
	    	
	        
    }
    
    private void header(){
    	//Fila Header
    	Div hrow = new Div();
    	hrow.setClass("row div-default margin-0px");
    	
    	Div hcol1 = new Div();
    	hcol1.setClass("col-lg-3 col-md-3 col-sm-3 col-xs-3");
    	hrow.appendChild(hcol1);
    	
    	Image img1 = new Image();
    	img1.setSrc("theme/default/images/logo_ADempiere.png");
    	img1.setClass("img-responsive");
    	hcol1.appendChild(img1);
    	
    	Div hcol2 = new Div();
    	hcol2.setClass("col-lg-offset-3  col-lg-6 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6");
    	hrow.appendChild(hcol2);
    	
    	Image img2 = new Image();
    	img2.setSrc("theme/default/images/esvenca_logo_65.png");
    	img2.setClass("img-responsive");
    	img2.setAlign("right");
    	hcol2.appendChild(img2);
    	
    	
    	this.appendChild(hrow);
    	
    }
    
    
    /**
     *  validates user name and password when logging in
     *
    **/

    
	private String getUpdateTimeoutTextScript() {
		String msg = Msg.getMsg(Env.getCtx(), "SessionTimeoutText");
		if (msg == null || msg.equals("SessionTimeoutText")) {
			return null;
		}
		msg = Strings.escape(msg, "\"");
		String s = "adempiere.store.set(\"zkTimeoutText\", \"" + msg + "\")";
		return s;
	}


	@Override
	public void loginCompleted() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserPreference loadUserPreference(int userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserPreference getUserPreference() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}

}