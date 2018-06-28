package org.compiere.pos;

import java.text.DecimalFormat;

import org.compiere.util.Env;

@SuppressWarnings("serial")
public class PosPago_Credito extends javax.swing.JDialog {

    /**
     * Creates new form PagoPos_Credito
     */
    public PosPago_Credito(java.awt.Frame parent, boolean modal,double dBalance) {
        super(parent, modal);
        initComponents();
        this.Txt_Balance.setText(String.valueOf(dBalance));
        el_Balance=dBalance*-1;
    }
    private boolean bAcepto = false;
    @SuppressWarnings("unused")
	private double el_Balance=0;    
    // Variables declaration - do not modify
    private javax.swing.JLabel EFE_Titulo;
    private javax.swing.JButton Tabla_Aceptar;
    private javax.swing.JButton Tabla_Cancelar;
    private javax.swing.JTextField Txt_Balance;
    private javax.swing.JComboBox cbTermino;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JFormattedTextField txt_Monto;
    public boolean getAcepto()
    {
        return this.bAcepto;
    } 
    public javax.swing.JTextField getTxt_Balance()
    {
        return this.Txt_Balance;
    }    
    public javax.swing.JFormattedTextField gettxt_Monto()
    {
        return this.txt_Monto;
    }       
    public javax.swing.JComboBox getcbTermino()
    {
    	return this.cbTermino;
    }
    public void setcbTermino(javax.swing.JComboBox valor)
    {
    	this.cbTermino=valor;
    }
    
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txt_Monto =new javax.swing.JFormattedTextField(new DecimalFormat("#.0"));
        Tabla_Cancelar = new javax.swing.JButton();
        Tabla_Aceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Txt_Balance = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        EFE_Titulo = new javax.swing.JLabel();
        cbTermino = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("Monto");

        txt_Monto.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txt_Monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_Monto.setPreferredSize(new java.awt.Dimension(121, 30));
        txt_Monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_MontoKeyPressed(evt);
            }
        });

        Tabla_Cancelar.setText("");
        Tabla_Cancelar.setIcon(Env.getImageIcon("pe_Edc_Cancelar.png")); // NOI18N
        Tabla_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_CancelarActionPerformed(evt);
            }
        });

        Tabla_Aceptar.setText("");
        Tabla_Aceptar.setIcon(Env.getImageIcon("pe_Edc_Aceptar.png")); // NOI18N
        Tabla_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_AceptarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Balance");

        Txt_Balance.setEditable(false);
        Txt_Balance.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Txt_Balance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 0, 51));
        jSeparator2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        EFE_Titulo.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        EFE_Titulo.setText("Credito");

        cbTermino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Immediato", "a 30 Dias", "50% Immediato 50% 30 Dias", " ", " ", " ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_Balance))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tabla_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tabla_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Monto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EFE_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(EFE_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(cbTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txt_Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tabla_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tabla_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void txt_MontoKeyPressed(java.awt.event.KeyEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void Tabla_AceptarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    	this.bAcepto=true;
    	this.dispose();
    }                                               

    private void Tabla_CancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    	this.bAcepto=false;
    	this.dispose();
    }                                                

}
