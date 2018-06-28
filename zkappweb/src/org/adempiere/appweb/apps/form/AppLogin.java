package org.adempiere.appweb.apps.form;

import java.text.MessageFormat;
import java.util.Properties;

import org.adempiere.appweb.AppWindow;
import org.adempiere.appweb.apps.AEnv;
import org.adempiere.appweb.apps.wf.WFAActivity;
import org.adempiere.appweb.exception.ApplicationException;
import org.adempiere.appweb.util.BrowserToken;
import org.compiere.Adempiere;
import org.compiere.model.MSession;
import org.compiere.model.MUser;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Login;
import org.compiere.util.Msg;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.Panel;


public class AppLogin  extends Panel implements EventListener{
	
	private Textbox txtpassw;
	private Textbox txtUser;
	private Label lbl3;
	private Properties ctx;
	private Button btnok;
	private Div row1;
	private Div row2;
	private Div rows;
	private AppWindow appwnd;
	
	private AppInfor  loginInfor;
	
	private boolean autentic = false;
	
	/**	Logger							*/
	private static final CLogger log = CLogger.getCLogger (AppLogin.class);
	private Execution exec = Executions.getCurrent();
	
	public AppLogin (Properties ctx, AppWindow appwindow){
        this.ctx = ctx;
        this.appwnd = appwindow;
        
        init();
	}
	
    private void init(){
    	
    	this.setId("PLogin");
    	
    	Panelchildren pc = new Panelchildren();
    	pc.setParent(this);
    	
    	//Fila Espacio
    	rows = new Div();
    	rows.setClass("row top-buffer");
    	appwnd.appendChild(rows);
    	
    	//Fila 1
    	row1 = new Div();
    	row1.setClass("row paddingtop");
    	
    	Div col1 = new Div();
    	col1.setClass("col-sm-6 col-sm-offset-3");
    	row1.appendChild(col1);
    	
    	
    	txtpassw = new Textbox();
    	txtpassw.setClass("form-control");
    	txtpassw.setType("password");
    	//txtpassw.setPlaceholder("Password");
    	
    	Label lbl2 = new Label("Password");
    	lbl2.setClass("label label-primary");
    	
    	txtUser = new Textbox();
    	txtUser.setClass("form-control");
    	//txtUser.setPlaceholder("Usuario");
    	
    	if(exec.getParameter("id") != null){
    		txtUser.setText(AEnv.getAD_User_Name(ctx));
    		txtUser.setReadonly(true);
    	}
    	
    	lbl3 = new Label("msg");
    	lbl3.setClass("label label-primary");
    	lbl3.setVisible(false);
    	
    	Label lbl1 = new Label("Usuario");
    	lbl1.setClass("label label-primary");
    	btnok = new Button("Confirmar Aprobación");
    	btnok.setId("btnok");
    	btnok.addEventListener("onClick", this);
    	btnok.setClass("btn btn-primary");

    	col1.appendChild(lbl1);
    	col1.appendChild(txtUser);

    	col1.appendChild(lbl2);
    	col1.appendChild(txtpassw);
    	
    	col1.appendChild(lbl3);

    	
    	//Fila 1
    	row2 = new Div();
    	row2.setClass("row paddingtop");
    	row2.setAlign("center");
    	
    	row2.appendChild(btnok);
    	col1.appendChild(row2);
    	
    	pc.appendChild(row1);
    	appwnd.appendChild(this);
    	
    }

	@Override
	public void onEvent(Event event) throws Exception {
		
        if (event.getTarget().getId().equals("btnok"))
        {
            validateLogin();
        }
		
	}
	
    public void validateLogin()
    {
        Login login = new Login(ctx);
        String userId = txtUser.getValue();
        String userPassword = txtpassw.getValue();

        //check is token
        String token = (String) txtpassw.getAttribute("user.token.hash");
        if (token != null && token.equals(userPassword))
        {
        	userPassword = "";
        	int AD_Session_ID = (Integer)txtpassw.getAttribute("user.token.sid");
        	MSession session = new MSession(Env.getCtx(), AD_Session_ID, null);
        	if (session.get_ID() == AD_Session_ID)
        	{
        		MUser user = MUser.get(Env.getCtx(), session.getCreatedBy());
        		if (BrowserToken.validateToken(session, user, token))
        		{
        			userPassword = user.getPassword();
        		}
        	}
        }
        
        
        
	        if (login.getRoles(userId, userPassword) == null){
	        	
	        	lbl3.setValue("User Id or Password invalid!!!");
	    		lbl3.setVisible(true);
	    		
	        }else{
	        	
	        	removerComp("PLogin");
	        	loginInfor = new AppInfor(ctx, appwnd);
	        	autentic = true;
	        }
        
	        KeyNamePair rolesKNPairs[] = login.getRoles(userId, userPassword);
	        if(rolesKNPairs == null || rolesKNPairs.length == 0)
	            throw new WrongValueException("User Id or Password invalid!!!");

	        else
	        {
	        	String langName = null;
	        	/*if ( lstLanguage.getSelectedItem() != null )
	        		langName = (String) lstLanguage.getSelectedItem().getLabel();
	        	else
	        		langName = Language.getBaseLanguage().getName();*/
	        	//Language language = findLanguage(langName);
	            //wndLogin.loginOk(userId, userPassword);

	            //Env.setContext(ctx, UserPreference.LANGUAGE_NAME, language.getName()); // Elaine 2009/02/06

	            //Locales.setThreadLocal(language.getLocale());

	            //Clients.response("zkLocaleJavaScript", new AuScript(null, ZkFns.outLocaleJavaScript()));
	            //String timeoutText = getUpdateTimeoutTextScript();
	            //if (!Strings.isEmpty(timeoutText))
	            	//Clients.response("zkLocaleJavaScript2", new AuScript(null, timeoutText));
	        }

		// This temporary validation code is added to check the reported bug
		// [ adempiere-ZK Web Client-2832968 ] User context lost?
		// https://sourceforge.net/tracker/?func=detail&atid=955896&aid=2832968&group_id=176962
		// it's harmless, if there is no bug then this must never fail
        Session currSess = Executions.getCurrent().getDesktop().getSession();
        currSess.setAttribute("Check_AD_User_ID", Env.getAD_User_ID(ctx));
		// End of temporary code for [ adempiere-ZK Web Client-2832968 ] User context lost?

        //Env.setContext(ctx, BrowserToken.REMEMBER_ME, chkRememberMe.isChecked());

		
        /* Check DB version */
        String version = DB.getSQLValueString(null, "SELECT Version FROM AD_System");
        //lbl3.setValue(version);
        //  Identical DB version
        if (!Adempiere.DB_VERSION.equals(version)) {
            String AD_Message = "DatabaseVersionError";
            //  Code assumes Database version {0}, but Database has Version {1}.
            String msg = Msg.getMsg(ctx, AD_Message);   //  complete message
            msg = MessageFormat.format(msg, new Object[] {Adempiere.DB_VERSION, version});
            throw new ApplicationException(msg);
        }

        //log.warning("User: " + ctx);
    }
    
    public void removerComp(String comp){
    	for(int i = 0; i< appwnd.getChildren().size(); i++){
    		if (((Component) appwnd.getChildren().get(i)).getId().equals(comp)){
    			appwnd.removeChild(((Component) appwnd.getChildren().get(i)));
    			break;
    		}
    	} 

    }
    

}
