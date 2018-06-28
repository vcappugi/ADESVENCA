package org.compiere.pos;

import org.compiere.util.Env;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;

import javax.swing.border.LineBorder;

@SuppressWarnings({ "unused", "serial" })
public class PosPanelLogo extends javax.swing.JPanel {
    private javax.swing.JButton btn_Imagen;
    private javax.swing.JTextField f_iproduct;
    private javax.swing.JPanel jPanelIProduct;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JLabel labelItemCount;
    private javax.swing.JLabel labelSoldDate;
    public PosPanelLogo() {
        initComponents();
    }
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelIProduct = new javax.swing.JPanel();
        f_iproduct = new javax.swing.JTextField();
        labelItemCount = new javax.swing.JLabel();
        labelSoldDate = new javax.swing.JLabel();
        jPanelImagen = new javax.swing.JPanel();
        btn_Imagen = new javax.swing.JButton();

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowHeights = new int[]{106, 0, 0};
        setLayout(gridBagLayout);

        f_iproduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        f_iproduct.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        f_iproduct.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1));
    
        javax.swing.GroupLayout jPanelIProductLayout = new javax.swing.GroupLayout(jPanelIProduct);
        jPanelIProduct.setLayout(jPanelIProductLayout);
        jPanelIProductLayout.setHorizontalGroup(
            jPanelIProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIProductLayout.createSequentialGroup()
                .addComponent(f_iproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        
        jPanelIProductLayout.setVerticalGroup(
            jPanelIProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(f_iproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(jPanelIProduct, gridBagConstraints);

        labelItemCount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelItemCount.setText("Su Orden Tiene 0 Articulos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(labelItemCount, gridBagConstraints);

  /*      labelSoldDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        labelSoldDate.setHorizontalAlignment(SwingConstants.LEFT);
        labelSoldDate.setText("Vendido el");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 38, 0, 0);
        add(labelSoldDate, gridBagConstraints);
*/
        jPanelImagen.setLayout(null);

        
        btn_Imagen.setBorder(UIManager.getBorder("DesktopIcon.border"));
        jPanelImagen.add(btn_Imagen);
        btn_Imagen.setBounds(0, 0, 490, 95);//490 130

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 489;
        gridBagConstraints.ipady = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanelImagen, gridBagConstraints);
    }// </editor-fold>
    
    public javax.swing.JButton getbtn_Imagen() {
    	return btn_Imagen;
    }
    	
    public javax.swing.JPanel getjPanelImagen()
    {
    	return jPanelImagen;
    }
    public JTextField  getf_iproduct()
	{
		return f_iproduct;
	}
    public javax.swing.JLabel getlabelItemCount()
    {
    	return labelItemCount;
    }
    
}
