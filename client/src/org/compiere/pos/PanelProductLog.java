package org.compiere.pos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.compiere.model.MImage;
import org.compiere.util.Env;

import net.miginfocom.swing.MigLayout;
@SuppressWarnings({ "unused", "serial" })
public class PanelProductLog  extends PosSubPanel {
    public PanelProductLog(PosBasePanel posPanel) {
    	super(posPanel);
      
    }
    private MImage la_imagen;
    private javax.swing.JButton btn_Imagen;
    private void initComponents() {

        btn_Imagen = new javax.swing.JButton();


        btn_Imagen.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 299, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
        );
    }// </editor-fold>
    
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		  initComponents();
	}
	
    @SuppressWarnings("null")
	public void setImagen ( MImage valor)
    {
    	 la_imagen = valor;
         btn_Imagen.setIcon(la_imagen.getIcon()); // NOI18N
         btn_Imagen.repaint();
         

         
         Graphics g = null;
         g.drawLine(20, 100, 120, 100);
         g.drawImage(Env.getImage("LogoPos.jpg"), 0, 0, getWidth(), getHeight(),
                 this);
         super.paint(g);
    }
}
