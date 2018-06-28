package org.compiere.pos;


import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.swing.CDialog;
import org.compiere.swing.CFrame;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "serial", "unused" })
public class PosClaveMaster extends CDialog implements ActionListener {
	javax.swing.JPasswordField fieldpws;
    private javax.swing.JLabel jLabel1;
    private boolean isMasterPos=false;
    public static CLogger log = CLogger.getCLogger(PosClaveMaster.class);
    private boolean isAccesoAccion = false;
    private boolean isValidado = false;
	private KeyboardFocusManager originalKeyboardFocusManager;
	private PosKeyboardFocusManager	m_focusMgr = null;
	private PosBasePanel posPanel;
 /*   public PosClaveMaster(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
		originalKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		m_focusMgr = new PosKeyboardFocusManager();
		KeyboardFocusManager.setCurrentKeyboardFocusManager(m_focusMgr);        
        initComponents();
    }  */
    
	public PosClaveMaster (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosClaveMaster"), true);
		this.posPanel = posPanel;
		originalKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		m_focusMgr = new PosKeyboardFocusManager();
		KeyboardFocusManager.setCurrentKeyboardFocusManager(m_focusMgr); 		
		init();
		
	}    

	private void init() 
	{
		initComponents();
	}
	
    private void initComponents() {

      //   fieldpws = new PosTextField(Msg.translate(posPanel.getCtx(), "PIN"), posPanel, posPanel.p_pos.getOSNP_KeyLayout_ID());
    	 fieldpws = new javax.swing.JPasswordField();
    	jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Msg.translate(Env.getCtx(),  "Please Enter Manager Password"));
        setModal(true);


        fieldpws.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldpwsKeyPressed(evt);
            }
        });
        fieldpws.setText("");

        jLabel1.setText(Msg.translate(Env.getCtx(), "Password"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldpws, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldpws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>    
    private void fieldpwsKeyPressed(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
        	if(!isAccesoAccion)
        	{
        		
            	if(getMasterPOS())
            	{
                    this.isMasterPos=true;
            		this.dispose();
            		isValidado=true;
            	}
            	else if(getUserPOS())
            	{
                    this.isMasterPos=true;
            		this.dispose();
            		isValidado=true;
            	}
            	else
            	{
                    this.isMasterPos=false;
                    isValidado=false;
            	}
        	}
        	else
        	{
            	if(getMasterPOS())
            	{
                    this.isMasterPos=true;
            		this.dispose();
            		isValidado=true;
            	}  		
        	}
        		
        }
        if (key == KeyEvent.VK_ESCAPE)
        {
        	if(isAccesoAccion)
        	{
        		
                this.isMasterPos=true;
        		this.dispose();
        		isValidado=false;
        	}
        		
        }

    }    
    @SuppressWarnings("deprecation")
	private boolean getUserPOS() {
		boolean bRetorno = false;
		MUser el_Usuario = new MUser(Env.getCtx(),Env.getContextAsInt(Env.getCtx(), "#AD_User_ID"),null);
		if(el_Usuario.getUserPIN().toString().trim().equalsIgnoreCase(this.fieldpws.getText().trim()))
			bRetorno= true;

		return bRetorno;
	    }
    
    @SuppressWarnings("deprecation")
	private boolean getMasterPOS() {
		boolean bRetorno = false;
		String sql = "SELECT ad_user.ad_user_id,  ad_user.name, ad_user.userpin FROM ad_user, ad_user_roles, ad_role WHERE " ;
		sql = sql + " ad_user.ad_user_id = ad_user_roles.ad_user_id AND  ad_user.ad_client_id = ad_user_roles.ad_client_id AND ad_user.ad_org_id = ad_user_roles.ad_org_id AND " ;
		sql = sql + " ad_user_roles.ad_client_id = ad_role.ad_client_id AND  ad_user_roles.ad_org_id = ad_role.ad_org_id AND  ad_user_roles.ad_role_id = ad_role.ad_role_id AND " ;
		sql = sql + " ad_user.userpin = '" + this.fieldpws.getText()+"'";
	        try
	        {
	            PreparedStatement pstmt = DB.prepareStatement(sql.toString(), null);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next())
	            {
	            	bRetorno=true;
	            }
	        }
	        catch (SQLException e)
	        {
	            log.log(Level.SEVERE, sql.toString(), e);
	        }
	       
	        return bRetorno;
	    }

	@Override
    public void dispose() 
    {
		KeyboardFocusManager.setCurrentKeyboardFocusManager(originalKeyboardFocusManager);
   		super.dispose();
    } 
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	public void mousePressed (MouseEvent e) {}
	public void mouseReleased (MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {}
	public void setisAccesoAccion(boolean valor)
	{
		this.isAccesoAccion=valor;
	}
	public boolean getisValidado()
	{
		return this.isValidado;	
	}
	 
  
}
