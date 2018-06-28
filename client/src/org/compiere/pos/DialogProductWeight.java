package org.compiere.pos;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JFormattedTextField;

import org.compiere.util.Env;
import org.compiere.util.Msg;
@SuppressWarnings({ "unused", "serial" })
public class DialogProductWeight extends javax.swing.JDialog{
    private javax.swing.JFormattedTextField fieldPeso;
    private javax.swing.JLabel labelProdcutName;
    private javax.swing.JLabel labelTitle;
    public DialogProductWeight(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.fieldPeso.requestFocus();
        this.fieldPeso.selectAll();
    }
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        labelProdcutName = new javax.swing.JLabel();
        fieldPeso = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        setForeground(java.awt.Color.white);
        setModal(true);
        setName("DplProductweight"); // NOI18N
        setResizable(false);

        labelTitle.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelTitle.setText("weight");

        labelProdcutName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelProdcutName.setText(Msg.translate(Env.getCtx(),  "Name of Product"));

        fieldPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        fieldPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPeso.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        fieldPeso.setText("0,00");
        fieldPeso.setValue(Env.ZERO);
        
        fieldPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProdcutName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(fieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelProdcutName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }    
    private void jFormattedTextField1KeyPressed(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
            this.dispose();
        }
    }  
    public javax.swing.JFormattedTextField getfieldPeso() { 	return fieldPeso ;  }
    public javax.swing.JLabel getlabelProdcutName() { return labelProdcutName; }
    public javax.swing.JLabel getlabelTitle(){ return labelTitle; }    
    
}
