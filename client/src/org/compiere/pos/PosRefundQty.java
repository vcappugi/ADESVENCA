package org.compiere.pos;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import org.compiere.apps.ADialog;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MBPartner;
import org.compiere.model.MInOutLine;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "unused", "serial" })
public class PosRefundQty extends CDialog implements ActionListener {
    public static CLogger log = CLogger.getCLogger(PosRefundQty.class);
    private boolean isRefundQty=false;
	private KeyboardFocusManager originalKeyboardFocusManager;
	private PosKeyboardFocusManager	m_focusMgr = null;
	private PosBasePanel posPanel;
	
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnprocess;
    private javax.swing.JTextField fieldProductName;
    private javax.swing.JFormattedTextField fieldQtyAvalible;
    private javax.swing.JFormattedTextField fieldQtytoRefund;
    private javax.swing.JLabel lblQtyAvailable;
    private javax.swing.JLabel lblQtytoRefund;
    private javax.swing.JLabel lbltem;
    private javax.swing.JPanel panelQty;
    
	
	public PosRefundQty (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosRefundQty"), true);
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

        panelQty = new javax.swing.JPanel();
        lbltem = new javax.swing.JLabel();
        fieldProductName = new javax.swing.JTextField();
        lblQtytoRefund = new javax.swing.JLabel();
        fieldQtyAvalible = new javax.swing.JFormattedTextField();
        lblQtyAvailable = new javax.swing.JLabel();
        fieldQtytoRefund = new javax.swing.JFormattedTextField();
        btnImagen = new javax.swing.JButton();
        btnprocess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelQty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbltem.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbltem.setText("Items");

        fieldProductName.setEditable(false);
        fieldProductName.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        lblQtytoRefund.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblQtytoRefund.setText("Qty to refund");

        fieldQtyAvalible.setEditable(false);
        fieldQtyAvalible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldQtyAvalible.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        fieldQtyAvalible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldQtyAvalible.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        lblQtyAvailable.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblQtyAvailable.setText("Qty Available");

        fieldQtytoRefund.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldQtytoRefund.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        fieldQtytoRefund.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldQtytoRefund.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        fieldQtytoRefund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQtytoRefundActionPerformed(evt);
            }
        });
        fieldQtytoRefund.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldQtytoRefundKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelQtyLayout = new javax.swing.GroupLayout(panelQty);
        panelQty.setLayout(panelQtyLayout);
        panelQtyLayout.setHorizontalGroup(
            panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQtyLayout.createSequentialGroup()
                .addGroup(panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQtyLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbltem))
                    .addGroup(panelQtyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQtyAvailable)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelQtyLayout.createSequentialGroup()
                        .addComponent(fieldQtyAvalible, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQtytoRefund)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldQtytoRefund, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelQtyLayout.setVerticalGroup(
            panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltem)
                    .addComponent(fieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtytoRefund)
                    .addComponent(fieldQtyAvalible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtyAvailable)
                    .addComponent(fieldQtytoRefund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnImagen.setText("imagen_producto");

        btnprocess.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnprocess.setIcon(Env.getImageIcon("Process24.gif")); 
        btnprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocessActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnCancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            } 
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprocess, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>	
    private void btnprocessActionPerformed(java.awt.event.ActionEvent evt) {
    	Double QtyRefund = Double.valueOf(this.fieldQtytoRefund.getValue().toString());
    	Double QtyAvailable = Double.valueOf(this.fieldQtyAvalible.getValue().toString());
    	if(QtyRefund>QtyAvailable)
    	{
    		JOptionPane.showMessageDialog(null,Msg.getMsg(Env.getCtx(),"Not have Item Avalible!!!"));
    	}
    	else
    	{
        	isRefundQty=true; // aqui otras validaciones
            this.dispose();
    		
    	}
    }
   

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	isRefundQty=false; // aqui otras validaciones
       this.dispose();
    }

    private void fieldQtytoRefundActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldQtytoRefundKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }	
    
    public javax.swing.JButton getbtnImagen()
    {
    	return  btnImagen;
    }
    
    public javax.swing.JTextField getfieldProductName()
    {
    	 return fieldProductName;
    }
    
    public boolean getisRefundQty()
    {
    	return isRefundQty;
    }
    
    public javax.swing.JFormattedTextField getfieldQtytoRefund()
    {
    	return fieldQtytoRefund;
    }
    
    public javax.swing.JFormattedTextField getfieldQtyAvalible()
    {
    	return fieldQtyAvalible;
    }
  
  
}

