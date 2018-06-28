package org.compiere.pos;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import org.compiere.util.Env;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings({ "unused", "serial" })
public  class PanelLogoPOS  extends PosSubPanel {
	 
	    public PanelLogoPOS(PosBasePanel posPanel) {
	    	super(posPanel);
	      
	    }	 
	    private javax.swing.JButton jButton1;

	    private void initComponents() {

	//        jButton1 = new javax.swing.JButton();

	        setMaximumSize(new java.awt.Dimension(303, 167));
	        setPreferredSize(new java.awt.Dimension(303, 167));
	        setLayout(new java.awt.BorderLayout());
	 //       jButton1.setAutoscrolls(true);
	//        jButton1.setIcon(Env.getImageIcon("LogoPos.jpg"));
	 //       add(jButton1, java.awt.BorderLayout.CENTER);
	    }// </editor-fold>
		@Override
		protected void init() {
			// TODO Auto-generated method stub
			  initComponents();
		}
		   @Override
		   
		   
		    public void paint(Graphics g) {
				g.drawImage(Env.getImage("LogoPos.jpg"), 0, 0, getWidth(), getHeight(),
		                        this);

				setOpaque(false);
		        super.paint(g);
		    }	
}
