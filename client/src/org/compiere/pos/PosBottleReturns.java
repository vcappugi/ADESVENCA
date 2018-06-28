package org.compiere.pos;

import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.swing.KeyStroke;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MPayment;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "unused", "serial" })
public class PosBottleReturns  extends CDialog implements ActionListener {
    public static CLogger log = CLogger.getCLogger(PosBottleReturns.class);
	private PosBasePanel posPanel;
	private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	private MBPartner	m_bpartner;
	
// variables
	    // Variables declaration - do not modify
	    private javax.swing.JButton btnCancel;
	    private javax.swing.JButton btnprocess;
	    private javax.swing.JButton f_bSearch;
	    private javax.swing.JTextField fieldBpartner;
	    private javax.swing.JFormattedTextField fieldCurrentDate;
	    private javax.swing.JFormattedTextField fieldQtyBottle;
	    private javax.swing.JFormattedTextField fieldTicketNumber;
	    private javax.swing.JFormattedTextField fieldTotal;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JLabel lblBottleReturn;
	    private javax.swing.JLabel lblCurrentDate;
	    private javax.swing.JLabel lblQtyBottle;
	    private javax.swing.JLabel lblTicketNumber;
	    private javax.swing.JLabel lblTotal;
	public PosBottleReturns (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosClaveMaster"), true);
		this.posPanel = posPanel;
		init();
		 this.fieldCurrentDate.setValue(m_today);
		
	}    

	private void init() 
	{
		initComponents();
	}
    private void initComponents() {

      
    	f_bSearch =new javax.swing.JButton();

    	f_bSearch.setIcon(Env.getImageIcon("BPartner24.gif"));
    	lblBottleReturn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCurrentDate = new javax.swing.JLabel();
        fieldCurrentDate = new javax.swing.JFormattedTextField();
        lblTicketNumber = new javax.swing.JLabel();
        fieldQtyBottle = new javax.swing.JFormattedTextField();
        lblQtyBottle = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JFormattedTextField();
        lblTotal = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnprocess = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        fieldTicketNumber = new javax.swing.JFormattedTextField();
     //   f_bSearch = new javax.swing.JButton();

        
        fieldBpartner = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblBottleReturn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblBottleReturn.setText(Msg.translate(Env.getCtx(),  "Bottler Return"));
        getContentPane().add(lblBottleReturn);
        lblBottleReturn.setBounds(10, 11, 163, 24);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 41, 550, 10);

        lblCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCurrentDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrentDate.setText(Msg.translate(Env.getCtx(),  "Current Date"));
        getContentPane().add(lblCurrentDate);
        lblCurrentDate.setBounds(30, 120, 110, 19);

        fieldCurrentDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldCurrentDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        fieldCurrentDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        fieldCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldCurrentDate);
        fieldCurrentDate.setBounds(150, 120, 170, 26);

        lblTicketNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTicketNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTicketNumber.setText(Msg.translate(Env.getCtx(),  "Ticket Number"));
        getContentPane().add(lblTicketNumber);
        lblTicketNumber.setBounds(40, 160, 100, 19);

        fieldQtyBottle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldQtyBottle.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        fieldQtyBottle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldQtyBottle.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldQtyBottle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldQtyBottleKeyPressed(evt);
            }
        });
        getContentPane().add(fieldQtyBottle);
        fieldQtyBottle.setBounds(150, 200, 170, 26);

        lblQtyBottle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblQtyBottle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQtyBottle.setText(Msg.translate(Env.getCtx(),  "Qty of Bottle"));
        getContentPane().add(lblQtyBottle);
        lblQtyBottle.setBounds(60, 200, 80, 19);

        fieldTotal.setEditable(false);
        fieldTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        fieldTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldTotal.setText("0");
        fieldTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldTotal);
        fieldTotal.setBounds(150, 240, 170, 26);

        lblTotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText(Msg.translate(Env.getCtx(),  "Total"));
        getContentPane().add(lblTotal);
        lblTotal.setBounds(50, 240, 80, 19);

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(400, 110, 130, 60);

        btnprocess.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnprocess.setIcon(Env.getImageIcon("Process24.gif")); 
        btnprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocessActionPerformed(evt);
            }
        });
        getContentPane().add(btnprocess);
        btnprocess.setBounds(400, 210, 130, 60);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 100, 550, 10);

        fieldTicketNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldTicketNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldTicketNumber.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldTicketNumber);
        fieldTicketNumber.setBounds(150, 160, 170, 26);

        f_bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_bSearchActionPerformed(evt);
            }
        });
        getContentPane().add(f_bSearch);
        f_bSearch.setBounds(10, 50, 60, 40);

        fieldBpartner.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldBpartner.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldBpartner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        getContentPane().add(fieldBpartner);
        fieldBpartner.setBounds(80, 50, 470, 40);

        pack();
    }// </editor-fold>
    private void f_bSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.fieldBpartner.setText("");
        QueryBPartner qt = new QueryBPartner(this.posPanel);
		qt.SetisOnlySearch(true);
		qt.setVisible(true);
		setC_BPartner_ID(qt.getm_C_BPartner_ID());	
		findBPartner();
    }
    
	private void findBPartner()
	{
		
		String query =  this.fieldBpartner.getText();
		
		if (query == null || query.length() == 0)
			return;
		
		// unchanged
		if ( m_bpartner != null && m_bpartner.getName().equals(query))
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
			setC_BPartner_ID(0);
		}
		else if (results.length == 1)
		{
			setC_BPartner_ID(results[0].getC_BPartner_ID());
			fieldBpartner.setText(results[0].getName());
		}
		else	//	more than one
		{
			QueryBPartner qt = new QueryBPartner(posPanel);
			qt.setResults (results);
			qt.setVisible(true);
		}
	}	//	findBPartner
    
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
			fieldBpartner.setText(m_bpartner.getName());
		}
		else
		{
			fieldBpartner.setText(null);
		}
		//	Sets Currency
	}	//	setC_BPartner_ID  
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	super.dispose();
    }

    private void btnprocessActionPerformed(java.awt.event.ActionEvent evt) {
  	
    	
    	double dTotal = Double.parseDouble(fieldTotal.getValue().toString());
    	String TypeOfPayment="Bottle Returns";
    	
		//MPayment payment = createPayment(MPayment.TENDERTYPE_Cash);
		MPayment payment = createPayment(MPayment.TENDERTYPE_Account);
		payment.setC_CashBook_ID(posPanel.p_pos.getC_CashBook_ID());
		payment.setAmount(Env.getContextAsInt(Env.getCtx(),"C_Currency_ID"),BigDecimal.valueOf(dTotal));
		payment.setC_BankAccount_ID(posPanel.p_pos.getC_BankAccount_ID());
		payment.setDescription(TypeOfPayment);
		payment.save();
		payment.setDocAction(MPayment.DOCACTION_Complete);
		payment.setDocStatus(MPayment.DOCSTATUS_Drafted);
		if ( payment.processIt(MPayment.DOCACTION_Complete) )
		{
			payment.save();

		}
    	super.dispose();
    }

	private MPayment createPayment(String tenderType)
	{
		MPayment payment = new MPayment(Env.getCtx(), 0, null);
		payment.setAD_Org_ID(posPanel.p_pos.getAD_Org_ID());
		payment.setC_DocType_ID(false);
		payment.setTenderType(tenderType);
		payment.setC_Order_ID(0);
		payment.setIsReceipt(false);
		if(m_bpartner != null)
			payment.setC_BPartner_ID(m_bpartner.get_ID());
		else
			payment.setC_BPartner_ID(112);
		
		payment.setDocumentNo(this.fieldTicketNumber.getText());
		return payment;
	}
    
    private void fieldQtyBottleKeyPressed(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
    	if (key == KeyEvent.VK_ENTER) 
        { fieldQtyBottle.setValue(Integer.parseInt(fieldQtyBottle.getText().toString()));
            int Sqlcondicion = Env.getAD_Org_ID(Env.getCtx());
            double dValorUnidad    = Double.parseDouble( DB.getSQLValueString(null, "SELECT bottle_state_deposit FROM ad_orginfo WHERE AD_Org_ID=?", Sqlcondicion));
        
    		int la_cantidad = (Integer)fieldQtyBottle.getValue();
    		
        	double dTotal = la_cantidad*dValorUnidad;
        	fieldTotal.setValue(dTotal);        	
        	
        }
    }	
}
