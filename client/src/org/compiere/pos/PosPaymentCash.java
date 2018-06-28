package org.compiere.pos; 

import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MPayment;
import org.compiere.swing.CDialog;
import org.compiere.swing.CLabel;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings("unused")
public class PosPaymentCash  extends CDialog implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosPaymentCash.class);
	private PosBasePanel posPanel;
	private boolean bAcepto = false;
	private Properties p_ctx;

	// variables de calculos
	private double dt_Grandtotal;
	private double dt_Balance;
	private double dt_Paymentamount;
	private double dt_Tenderamount;
	private double dt_Paywith;
	private double dt_Change;
	private DecimalFormat df = new DecimalFormat("#.##");
	
// variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnProcess;
    private javax.swing.JTextField dtBalance;
    private javax.swing.JTextField dtCharge;
    private javax.swing.JTextField dtGrandtotal;
    private javax.swing.JTextField dtPaymentamount;
    private PosTextField dtPaywith;
    private PosTextField dtTenderamount;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCharge;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblPaymentamount;
    private javax.swing.JLabel lblPaywith;
    private javax.swing.JLabel lblTenderamount;
    private javax.swing.JLabel lblTendertype;
    private javax.swing.JPanel panelSelection;

	public PosPaymentCash (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosPaymentCash"), true);
		this.posPanel = posPanel;
		p_ctx = this.posPanel.getCtx();
		init();

		
	}    

	private void init() 
	{
		initComponents();
		this.dtTenderamount.requestFocus();

	    
	}

    private void initComponents() {

        panelSelection = new javax.swing.JPanel();
        lblGrandtotal = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblPaymentamount = new javax.swing.JLabel();
        lblTenderamount = new javax.swing.JLabel();
        lblCharge = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        dtGrandtotal = new javax.swing.JTextField();
        dtBalance = new javax.swing.JTextField();
        dtPaymentamount = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        dtTenderamount = new PosTextField(Msg.translate(p_ctx, "Tenderamount01"), this.posPanel, this.posPanel.p_pos.getOSNP_KeyLayout_ID(),  DisplayType.getNumberFormat(DisplayType.Amount));
        lblPaywith = new javax.swing.JLabel();
        dtPaywith =new PosTextField(Msg.translate(p_ctx, "dtPaywith02"), this.posPanel, this.posPanel.p_pos.getOSNP_KeyLayout_ID(),  DisplayType.getNumberFormat(DisplayType.Amount));
        jSeparator2 = new javax.swing.JSeparator();
        dtCharge = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblTendertype = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelSelection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblGrandtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandtotal.setText("Total Orden");

        lblBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBalance.setText("Balance");

        lblPaymentamount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPaymentamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPaymentamount.setText("Monto a Cancelar");

        lblTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTenderamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenderamount.setText("Monto Cancelado");

        lblCharge.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCharge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCharge.setText("Cambio");

        btnProcess.setIcon(Env.getImageIcon("Process24.gif")); 
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnCancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        dtGrandtotal.setEditable(false);
        dtGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtGrandtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        dtBalance.setEditable(false);
        dtBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        dtPaymentamount.setEditable(false);
        dtPaymentamount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtPaymentamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        dtTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtTenderamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        dtTenderamount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtTenderamountPropertyChange(evt);
            }
        });
        lblPaywith.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPaywith.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPaywith.setText("Cancela Con");

        dtPaywith.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtPaywith.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        dtPaywith.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	dtPaywithPropertyChange(evt);
            }
        });

        dtCharge.setEditable(false);
        dtCharge.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtCharge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout panelSelectionLayout = new javax.swing.GroupLayout(panelSelection);
        panelSelection.setLayout(panelSelectionLayout);
        panelSelectionLayout.setHorizontalGroup(
            panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCharge, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPaywith, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenderamount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPaymentamount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBalance, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGrandtotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtPaywith, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtTenderamount, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtGrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSelectionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator2)
                .addGap(10, 10, 10))
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
        );
        panelSelectionLayout.setVerticalGroup(
            panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtGrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrandtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtTenderamount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenderamount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtPaywith, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaywith))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCharge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblTendertype.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        lblTendertype.setText(Msg.translate(Env.getCtx(), "Efectivo"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTendertype))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTendertype)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
	
	
    protected void dtPaywithPropertyChange(PropertyChangeEvent evt) {
    	
    	 if( this.dtTenderamount.getValue() == null  ||  this.dtPaywith.getValue()==null)
       	 {
       		 return;   		 
       	 }
     	 if((!isNumeric(this.dtTenderamount.getValue().toString()) ) || (!isNumeric(this.dtPaywith.getValue().toString()) ))
       	 {
       		 return;   		 
       	 }
       	 else
       	 {
       		dt_Tenderamount=Double.parseDouble(this.dtTenderamount.getValue().toString());
       		dt_Paywith=Double.parseDouble(this.dtPaywith.getValue().toString());
           	if(dt_Paywith>dt_Tenderamount)
           	{
           		dt_Change=dt_Paywith-dt_Tenderamount;
           		this.dtCharge.setText(df.format(dt_Change));

           	}
           	else
           	{

        		dt_Paywith=dt_Tenderamount;
        		this.dtPaywith.setText(df.format(dt_Paywith));
           		this.dtCharge.setText(df.format(0));

           	}
       		 
       	 } 
		
	}


	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	this.bAcepto=false;
    	this.dispose();
    }                                         

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	if(this.dtTenderamount.getValue()==null)
    	{	
    		this.dtTenderamount.setValue(0);
    		dt_Tenderamount=0;
    	}
    	
    	this.bAcepto=true;
    	this.dispose();
    }                                         

    private void dtTenderamountPropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
   	 
    	if(this.dtTenderamount.getValue() == null )
    	{
    		return;   		 
    	}
        if(!isNumeric(this.dtTenderamount.getValue().toString()))
       	 {
      		 
       		 return;   		 
       	 }
       	 else
       	 {
         	
        		dt_Tenderamount=Double.parseDouble(this.dtTenderamount.getValue().toString());
        		dt_Paywith=dt_Tenderamount;
        		this.dtPaywith.setText(df.format(dt_Paywith));
           		this.dtCharge.setText(df.format(0));

       		 
       	 }
    	
    }    

    // Set Variables
    
	public void setdt_Grandtotal(double valor)
	{
		dt_Grandtotal= valor;
	}
	public void setdt_Balance( double valor)
	{
		dt_Balance = valor;
	}
	public void setdt_Paymentamount( double valor)
	{
		dt_Paymentamount = valor;
	}
	public void setdt_Tenderamount(double valor)
	{
		dt_Tenderamount=valor; 
	}
	public void setdt_Change(double valor)
	{
		dt_Change= valor;
	} 
   
	
	
	// get de los valores
	public double getdt_Grandtotal()
	{
		return dt_Grandtotal;
	}
	public double getdt_Balance()
	{
		return dt_Balance;
	}
	public double getdt_Paymentamount()
	{
		return dt_Paymentamount;
	}
	public double getdt_Tenderamount()
	{
		return dt_Tenderamount; 
	}
	public double getdt_Change()
	{
		return dt_Change;
	}
	
	public void SetValores() {
		this.dtPaymentamount.setText(df.format(dt_Paymentamount));
	    this.dtBalance.setText(df.format(dt_Balance));
	    this.dtGrandtotal.setText(df.format(dt_Grandtotal));
	    this.dtTenderamount.setText(df.format(dt_Tenderamount));
	    this.dtCharge.setText(df.format(dt_Change));
	}

	public boolean getbAcepto() {
		// TODO Auto-generated method stub
		return this.bAcepto;
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
