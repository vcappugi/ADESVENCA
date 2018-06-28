package org.compiere.pos;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Properties;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerInfo;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

public class PosPaymenHouseCharge  extends CDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosPaymentCash.class);
	private PosBasePanel posPanel;
	private boolean bAcepto = false;
	private Properties p_ctx;
	private int c_bpartner_id;
	private MBPartner	m_bpartner;
	// variables de calculos
	@SuppressWarnings("unused")
	private double dt_Grandtotal;
	private double dt_Paymentamount;
	private double dt_Tenderamount;
	private DecimalFormat df = new DecimalFormat("#.##");
	
    private javax.swing.JButton btnBpartner;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnProcess;
    private javax.swing.JTextField dtName;
    private javax.swing.JFormattedTextField dtPaymentamount;
    private PosTextField dtTenderamount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPaymentamount;
    private javax.swing.JLabel lblTenderamount;
    private javax.swing.JLabel lblTendertype;
	public PosPaymenHouseCharge (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "House Charge"), true);
		this.posPanel = posPanel;
		p_ctx = this.posPanel.getCtx();
		init();
	}    

	private void init() 
	{
		initComponents();
		this.btnBpartner.requestFocus();
	}
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBpartner = new javax.swing.JButton();
        dtName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        dtTenderamount = new PosTextField(Msg.translate(p_ctx, "Tenderamount"), this.posPanel, this.posPanel.p_pos.getOSNP_KeyLayout_ID(),  DisplayType.getNumberFormat(DisplayType.Amount));
        lblTenderamount = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTendertype = new javax.swing.JLabel();
        lblPaymentamount = new javax.swing.JLabel();
        dtPaymentamount = new javax.swing.JFormattedTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBpartner.setIcon(Env.getImageIcon("BPartner24.gif"));
        btnBpartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBpartnerActionPerformed(evt);
            }
        });

        dtName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtName.setText(" ");

        dtTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtTenderamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTenderamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenderamount.setText("Tender amount");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTenderamount)
                        .addGap(18, 18, 18)
                        .addComponent(dtTenderamount))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBpartner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtName, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBpartner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtName, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtTenderamount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenderamount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTendertype.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTendertype.setText(Msg.translate(Env.getCtx(), "House Charge"));

        lblPaymentamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPaymentamount.setText("Payment Amount");

        dtPaymentamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPaymentamount.setText("0");
        dtPaymentamount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTendertype)
                        .addGap(87, 87, 87)
                        .addComponent(lblPaymentamount)
                        .addGap(18, 18, 18)
                        .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTendertype)
                    .addComponent(lblPaymentamount)
                    .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
	
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {
    	this.bAcepto=true;
    	if(this.dtTenderamount.getValue()==null)
    		this.dtTenderamount.setValue(0);
		dt_Tenderamount=Double.parseDouble(this.dtTenderamount.getValue().toString());

    	this.dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	this.bAcepto=false;
    	this.dispose();
    }


    
	public void setdt_Paymentamount( double valor)
	{
		dt_Paymentamount = valor;
	}
	public void setdt_Tenderamount(double valor)
	{
		dt_Tenderamount=valor; 
	}
	public void SetValores() {
		this.dtPaymentamount.setText(df.format(dt_Paymentamount));
	    this.dtTenderamount.setText(df.format(dt_Tenderamount));

	}	
    
	public double getdt_Paymentamount()
	{
		return dt_Paymentamount;
	}
	public double getdt_Tenderamount()
	{
		return dt_Tenderamount; 
	}
	

	public boolean getbAcepto() {
		// TODO Auto-generated method stub
		return this.bAcepto;
	}
	public void setc_bpartner_id(int value)
	{
		c_bpartner_id=value;
	}
	public int getc_bpartner_id()
	{
		return c_bpartner_id;
	}
	
	
    private void btnBpartnerActionPerformed(java.awt.event.ActionEvent evt) {
        this.dtName.setText("");
        QueryBPartner qt = new QueryBPartner(this.posPanel);
		qt.SetisOnlySearch(true);
		qt.setVisible(true);
		setC_BPartner_ID(qt.getm_C_BPartner_ID());	
		findBPartner();
    }	
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		log.fine( "PosSubCustomer.setC_BPartner_ID=" + C_BPartner_ID);
		if (C_BPartner_ID == 0)
			m_bpartner = null;
		else
		{
			m_bpartner = new MBPartner(Env.getCtx(), C_BPartner_ID, null);
			if (m_bpartner.get_ID() == 0)
				m_bpartner = null;
		}
		
		//	Set Info
		if (m_bpartner != null)
		{
			this.dtName.setText(m_bpartner.getName());
			this.c_bpartner_id=C_BPartner_ID;
		}
		else
		{
			this.dtName.setText(null);
		}
		//	Sets Currency
	}	//	setC_BPartner_ID  
    	
	private void findBPartner()
	{
		
		String query =  this.dtName.getText();
		
		if (query == null || query.length() == 0)
			return;
		
		
		query = query.toUpperCase();
		//	Test Number
		boolean allNumber = true;
		boolean noNumber = true;
		char[] qq = query.toCharArray();
		for (int i = 0; i < qq.length; i++)
		{
			if (Character.isDigit(qq[i]))
			{
				noNumber = false;
				break;
			}
		}
		try
		{
			Integer.parseInt(query);
		}
		catch (Exception e)
		{
			allNumber = false;
		}
		String Value = query;
		String Name = (allNumber ? null : query);
		String EMail = (query.indexOf('@') != -1 ? query : null); 
		String Phone = (noNumber ? null : query);
		String City = null;
		//
		//TODO: contact have been remove from rv_bpartner
		MBPartnerInfo[] results = MBPartnerInfo.find(Env.getCtx(), Value, Name, 
			/*Contact, */null, EMail, Phone, City);
		
		//	Set Result
		if (results.length == 0)
		{
			c_bpartner_id=0;
		}
		else if (results.length == 1)
		{
			c_bpartner_id=results[0].getC_BPartner_ID();
			this.dtName.setText(results[0].getName());
		}
		else	//	more than one
		{
			QueryBPartner qt = new QueryBPartner(posPanel);
			qt.setResults (results);
			qt.setVisible(true);
		}
	}	//	findBPartner
	
}
