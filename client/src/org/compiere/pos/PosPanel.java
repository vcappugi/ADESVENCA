package org.compiere.pos;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.compiere.apps.AEnv;
import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.swing.CFrame;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings("unused")
public class PosPanel implements FormPanel {
	private PosBasePanel panel;
	private PosBasePanelCliente panelCliente;
	private CFrame el_FrameCliente;
	
	/**
	 * Constructor por defecto 
	 */
	public PosPanel(){
		initDevices();
	}
	
	
	public void dispose() {

	//		el_FrameCliente.dispose();
			panel.dispose();
	}

	public void init(int WindowNo, FormFrame frame) {
	
		panel = new PosBasePanel();
		panel.init(0, frame);
		if(panel.getisSelectMPOS())
		{
			el_FrameCliente = new CFrame();
			panelCliente =  new PosBasePanelCliente(panel);

	//		el_FrameCliente.setMinimumSize(new Dimension(1280,768));
			//el_FrameCliente.setLocation(map.get(":0.1"));
	//		el_FrameCliente.setTitle(Msg.translate(Env.getCtx(), "POS - Windows Partner"));
	//		el_FrameCliente.add(panelCliente);
	//		el_FrameCliente.setVisible(true);
			if(panel.f_order!=null)
			{
	//			panelCliente.getposPanelLogo1().getbtn_Imagen().setIcon(panel.f_order.getp_Panellogo().getbtn_Imagen().getIcon());
			}
			panel.setpanelCliente(panelCliente);
			el_FrameCliente.setVisible(false);  //POSVICTOR
	//		AEnv.addToWindowManager(el_FrameCliente);
		}
		else
		{
			panel.setEnabled(false);
			panel.dispose(); // aqui deberia cerrar no lo esta haciendo ya que elcontrol lo tiene FormFrame  DENIS
		}

	}
	public PosPanel getPosPanel()
	{
		return this;
	}
	 Map<String, Point> map = new HashMap<String, Point>();
	    protected void initDevices() {
	    	Point p = null;
	        GraphicsDevice gdDefault = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	        GraphicsDevice gd[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	        
	        
	        for (int i = 0; i < gd.length; i++) {
	        	
	        	System.out.println("gd[]=" + gd[i].getIDstring() + "    gdDefault = " + gdDefault.getIDstring());
	            p = gd[i].getDefaultConfiguration().getBounds().getLocation();
	            
	            map.put(gd[i].getIDstring(), p);
	            
	        } 
	       // createFrame(":0.1");
	        
	        }
}