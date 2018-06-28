package org.compiere.pos;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.model.MBPartner;
import org.compiere.model.MBankStatement;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings({ "unused", "serial" })
public class PosOpenCash  extends CDialog implements ActionListener {
    public static CLogger log = CLogger.getCLogger(PosBottleReturns.class);
	private PosBasePanel posPanel;
	private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	private MBPartner	m_bpartner;
	sincorinza refrescar ;
	
	
	// variables beans
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnprocess;
    private javax.swing.JTextField fieldCashier;
    private javax.swing.JFormattedTextField fieldCurrentDate;
    private javax.swing.JTextField fieldHours;
    private javax.swing.JFormattedTextField fieldInitialCharge;
    private javax.swing.JTextField fieldPOS;
    private javax.swing.JTextArea fildNotes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCurrenDate;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblInitialCharge;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblOpenCash;
    private javax.swing.JLabel lblPOS;

	public PosOpenCash (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosOpenCash"), true);
		this.posPanel = posPanel;
		init();
	    this.fieldCurrentDate.setValue(m_today);

		
	}  
	private void init() 
	{
		initComponents();
	}    
    private void initComponents() {

		refrescar= new sincorinza();
		refrescar.start();	
    	
    	Date now = new Date();

    	
    	
    	jSeparator1 = new javax.swing.JSeparator();
        lblOpenCash = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPOS = new javax.swing.JLabel();
        fieldCashier = new javax.swing.JTextField();
        fieldInitialCharge = new javax.swing.JFormattedTextField();
        fieldInitialCharge.setValue(Env.ZERO);
        fieldPOS = new javax.swing.JTextField();
        fieldHours = new javax.swing.JFormattedTextField();
        lblNotes = new javax.swing.JLabel();
        lblHours = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblCurrenDate = new javax.swing.JLabel();
        fieldCurrentDate = new javax.swing.JFormattedTextField();
        lblInitialCharge = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fildNotes = new javax.swing.JTextArea();
        btnprocess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        this.fieldCurrentDate.setValue(m_today);
        this.fieldHours.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
        
        
        this.fieldCashier.setText((Env.getCtx().getProperty("#AD_User_Name")).toUpperCase());
        
        this.fieldPOS.setText(this.posPanel.p_pos.getName());
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 340, 594, 10);

        lblOpenCash.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblOpenCash.setText("Open Cash");
        getContentPane().add(lblOpenCash);
        lblOpenCash.setBounds(10, 10, 163, 30);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cashier Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 70, 110, 19);

        lblPOS.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOS.setText("POS");
        getContentPane().add(lblPOS);
        lblPOS.setBounds(10, 110, 100, 30);

        fieldCashier.setEditable(false);
        fieldCashier.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldCashier.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldCashier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        getContentPane().add(fieldCashier);
        fieldCashier.setBounds(120, 70, 470, 30);

        fieldInitialCharge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldInitialCharge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        fieldInitialCharge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldInitialCharge.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        getContentPane().add(fieldInitialCharge);
        fieldInitialCharge.setBounds(120, 160, 200, 30);

        fieldPOS.setEditable(false);
        fieldPOS.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldPOS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldPOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        getContentPane().add(fieldPOS);
        fieldPOS.setBounds(120, 110, 200, 30);

        fieldHours.setEditable(false);
        fieldHours.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        fieldHours.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldHours);
        fieldHours.setBounds(480, 10, 110, 26);

        lblNotes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNotes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNotes.setText("Notes");
        getContentPane().add(lblNotes);
        lblNotes.setBounds(20, 200, 90, 30);

        lblHours.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblHours.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHours.setText(Msg.translate(Env.getCtx(),  "Hours"));
        getContentPane().add(lblHours);
        lblHours.setBounds(380, 10, 90, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 50, 594, 10);

        lblCurrenDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCurrenDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrenDate.setText(Msg.translate(Env.getCtx(), "Current Date"));
        getContentPane().add(lblCurrenDate);
        lblCurrenDate.setBounds(320, 110, 90, 30);

        fieldCurrentDate.setEditable(false);
        fieldCurrentDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldCurrentDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        fieldCurrentDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        fieldCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldCurrentDate);
        fieldCurrentDate.setBounds(420, 110, 170, 26);

        lblInitialCharge.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblInitialCharge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInitialCharge.setText(Msg.translate(Env.getCtx(),  "Initial Charge"));
        getContentPane().add(lblInitialCharge);
        lblInitialCharge.setBounds(20, 160, 90, 30);

        fildNotes.setColumns(20);
        fildNotes.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fildNotes.setRows(5);
        fildNotes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(fildNotes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 200, 470, 130);

        btnprocess.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnprocess.setText("Process");
        btnprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocessActionPerformed(evt);
            }
        });
        getContentPane().add(btnprocess);
        btnprocess.setBounds(300, 350, 130, 60);

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(460, 350, 130, 60);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 150, 594, 10);

        pack();
    }// </editor-fold>}
    private void btnprocessActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    	
    	MBankStatement el_MBankStatement = new MBankStatement (Env.getCtx(), 0, null);
    	el_MBankStatement.setC_BankAccount_ID(this.posPanel.p_pos.getC_BankAccount_ID());
    	el_MBankStatement.setDescription(this.fildNotes.getText().trim()+ "/ Create at "+this.fieldHours.getText());

    	 NumberFormat nf = NumberFormat.getInstance();
          
    	el_MBankStatement.setBeginningBalance(BigDecimal.valueOf(Double.valueOf(fieldInitialCharge.getValue().toString())));
    	el_MBankStatement.setStatementDate(m_today);
    	el_MBankStatement.setName(this.posPanel.p_pos.getName());
    	
    	el_MBankStatement.save();
    	refrescar.stop();	
       	super.dispose();
    	
    	
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	refrescar.stop();	
    	super.dispose();
    }   
    
    
	private class sincorinza extends Applet implements Runnable {
		public sincorinza () { // Constructor no siempre necesario
			   super();
		   }
		private Thread hilo;
		int periodo_refresco = 100;
		//int periodo_refresco = 60000;

		/************************************************************************
		* run del hilo: se duerme durante un segundo
		***********************************************************************/
		public void run() {
			while ( hilo != null ) {
				try {
					Thread.sleep( periodo_refresco );
				}
				catch (InterruptedException e ) { return; }
				paint();
			}
		}

		public void paint(  ) {
			Date now = new Date();
	        fieldHours.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
		}

		/***********************************************************************
		* No confundirse: este metodo es el start del applet.
		* Desde aqui llamamos a start del hilo.
		***********************************************************************/
		public void start(  ) {
			if ( hilo == null ) {
				hilo = new Thread(this);  // Coloco applet en hilo
				hilo.start();
			}
		}

		/***********************************************************************
		* Parada del applet: si la referencia al hilo no es nula: paro el hilo.
		***********************************************************************/
		public void stop(  ) {
			if ( hilo != null ) {
				hilo.interrupt();
				hilo = null;
			}
		}
	}    
}
