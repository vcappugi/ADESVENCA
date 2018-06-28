package org.compiere.pos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import org.compiere.util.Env;

import javax.swing.JPasswordField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import org.compiere.apps.AppsAction;
import org.compiere.model.MUser;
import org.compiere.swing.CButton;
import org.compiere.swing.CDialog;
import org.compiere.swing.CLabel;
import org.compiere.swing.CPanel;
import org.compiere.swing.CTextField;
import org.compiere.util.Msg;

public class PosLogin extends CDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8490567722808711399L;
	protected CPanel northPanel;
	private PosBasePanel posPanel;
	//private CTextField username;
	//private JPasswordField pin;
	private CTextField username;
	private JPasswordField pin;
	private CButton bProcess;
	public MUser user= null;

	/**
	 * 	Constructor
	 *	@param posPanel POS Panel
	 */
	public PosLogin (PosBasePanel posPanel)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "Login"), true);
		this.posPanel = posPanel;
		init();
		this.posPanel = posPanel;
	}

	private void init() {
		CPanel panel = new CPanel();
		panel.setLayout(new MigLayout("fill"));
		getContentPane().add(panel);
		northPanel = new CPanel(new MigLayout("fill", "", "[50][50][]"));
		panel.add (northPanel, "north");
		northPanel.setBorder(new TitledBorder(Msg.getMsg(Env.getCtx(), "Pin")));
		
		
		CLabel lvalue = new CLabel(Msg.translate(Env.getCtx(),"SalesRep_ID"));
		northPanel.add (lvalue, "growx");
		System.err.println("pospanel: " +posPanel); // +"POS: " +posPanel.p_pos);
		//username = new CTextField(40);
		username=new CTextField(40);
		lvalue.setLabelFor(username);
		//username.setReadWrite(true);
		username.requestFocus();
		//username.addActionListener(this);
		northPanel.add(username, "h 30, w 200, wrap");
		
		northPanel.add(new CLabel(Msg.translate(Env.getCtx(), "UserPIN")));
		
		//pin = new JPasswordField();
		//pin.setEditable(true);
		pin=new JPasswordField("", posPanel.p_pos.getOSK_KeyLayout_ID());
		
		northPanel.add(pin, "h 30, w 200, wrap");
		
		AppsAction act = new AppsAction("Ok", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), false);
		act.setDelegate(this);
		bProcess = (CButton)act.getButton();
		bProcess.setFocusable(false);
		northPanel.add (bProcess, "h 50!, w 50!");
		
		pack();
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(bProcess) )
		{
			user= MUser.get(Env.getCtx(), username.getText(), pin.getText());
			System.err.println("USER: " +user +"usuario:"+username.getText() +" pwd:" +pin.getText());
		}
		
		dispose();
	}
	
	public int getUser() {
		if(user!= null)
			return user.get_ID();
		return 0;
	}

}
