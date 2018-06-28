package org.compiere.pos;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.ecs.xhtml.var;
import org.compiere.grid.ed.VDate;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.TimeUtil;

@SuppressWarnings({ "unused", "serial" })
public class PanelWIC extends javax.swing.JDialog {
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private VDate fieldWICAfter;
    private PosTextField fieldWICAmount;
    private VDate fieldWICBefore;
    private PosTextField fieldWICNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
    private Timestamp			m_todayEnd = Env.getContextAsDate(Env.getCtx(), "#Date");
    private boolean bAcepto = false;
    private PosBasePanel posPanel;
    private double dMontoWic = 0;
    

	public PanelWIC (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosClaveMaster"), true);
		this.posPanel = posPanel;
		initComponents();
		fieldWICAfter.setFocusable(false);


		
		
	}   
    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	if(this.fieldWICBefore.getTimestamp()==null)
    	{
			JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Date Before Not Valid"));
			return;
    	}
    	
    	if(this.fieldWICBefore.getTimestamp()!=null)
    	{
        	m_today = this.fieldWICBefore.getTimestamp();
        	this.m_todayEnd=this.m_today;
        	long oneDay = 1 * 24 * 60 * 60 * 1000;
        	long oneMonth = oneDay*30;
        	this.m_todayEnd.setTime(m_today.getTime()+oneMonth);
        	this.fieldWICAfter.setValue(this.m_todayEnd);
        	
    		Timestamp to = m_todayEnd;

    		Timestamp from = Env.getContextAsDate(Env.getCtx(), "#Date");
    		
    		if (to.before(from))
    		{
    			SimpleDateFormat df = DisplayType.getDateFormat(DisplayType.Date);
    			
    			
    			JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Date not Valid " +df.format(to) + " < " + df.format(from)));

    			return;
    		}
    		else
    		{
    			if(this.fieldWICAmount.getValue()==null)
    			{
        			JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Amount Not Valid"));
        			return;
    				
    			}
    				
    			if(this.fieldWICNumber.getText()==null)
    			{
        			JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Nro. WIC Not Valid"));
        			return;
    				
    			}
    			if(this.fieldWICNumber.getText().trim().isEmpty())
    			{
        			JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Nro. WIC Not Valid"));
        			return;
    				
    			}
    				
            	bAcepto=true;
            	this.dispose();
    			
    		}
    		
        	
        	
    		
    	}
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	bAcepto=false;
    	this.dispose(); 	
    }

    private void fieldWICNumberKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }
    public void fieldWICBeforeKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
        	m_today = this.fieldWICBefore.getTimestamp();
        	this.m_todayEnd=this.m_today;
        	long oneDay = 1 * 24 * 60 * 60 * 1000;
        	long oneMonth = oneDay*30;
        	this.m_todayEnd.setTime(m_today.getTime()+oneMonth);
        	this.fieldWICAfter.setValue(this.m_todayEnd);
        	
        }
    }
  
  
    private void fieldWICAfterKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldWICAmountKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }
    private void initComponents() {


    	
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        fieldWICNumber = new PosTextField(Msg.translate(Env.getCtx(), "fieldWICNumber"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        jLabel4 = new javax.swing.JLabel();
        fieldWICBefore =  new VDate("DateFrom", false, false, true, DisplayType.Date, Msg.translate(Env.getCtx(), "DateFrom"));
        jLabel5 = new javax.swing.JLabel();
        fieldWICAfter = new VDate();
        jLabel2 = new javax.swing.JLabel();
        fieldWICAmount = new PosTextField(Msg.translate(Env.getCtx(), "fieldWICAmount"), posPanel, posPanel.p_pos.getOSNP_KeyLayout_ID());
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText(Msg.translate(Env.getCtx(),  "Order WIC"));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(Msg.translate(Env.getCtx(),  "WIC Number"));

        fieldWICNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldWICNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldWICNumber.addKeyListener(new java.awt.event.KeyAdapter() {
        	 @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldWICNumberKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(Msg.translate(Env.getCtx(),  "Not Good Before"));
      

        fieldWICBefore.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
      /*  
        
		keyHandler = new KeyHandler();
		fieldWICBefore.addKeyListener(keyHandler);

		KeyListener[]  elkeylis = fieldWICBefore.getKeyListeners();*/

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText(Msg.translate(Env.getCtx(),  "Not Good After"));

        fieldWICAfter.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldWICAfter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldWICAfterKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(Msg.translate(Env.getCtx(),  "Not Exceed"));

        fieldWICAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        fieldWICAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldWICAmount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldWICAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldWICAmountKeyPressed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirm.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnConfirm.setIcon(Env.getImageIcon("Process24.gif")); 
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(fieldWICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(fieldWICBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(fieldWICAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(fieldWICAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(8, 8, 8)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(fieldWICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(fieldWICBefore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(fieldWICAfter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(fieldWICAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>    
    public javax.swing.JFormattedTextField getfieldWICAmount()
    {
    	return fieldWICAmount;
    }
    public  javax.swing.JTextField gtfieldWICNumber()
    {
    	return fieldWICNumber;
    }
    public boolean isValidDate()
    {
      return true;
    }
    public boolean getbAcepto()
    {
    	return bAcepto;
    }
  
     
}
