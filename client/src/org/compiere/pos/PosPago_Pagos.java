package org.compiere.pos;    

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import org.compiere.apps.ADialog;
import org.compiere.apps.AEnv;
import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MBPartner;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;    
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "unused", "serial" })
public class PosPago_Pagos extends CDialog implements ActionListener {
    public static CLogger log = CLogger.getCLogger(PosBottleReturns.class);
	private PosBasePanel posPanel;
	private Timestamp	m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	private boolean	bPosPagoOK = false;

	private  DecimalFormat df = new DecimalFormat("#.##");
    // Variables declaration - do not modify
    private javax.swing.JPanel PanelAccion;
    private javax.swing.JPanel PanelFormas;
    private javax.swing.JPanel PanelResultados;
    private javax.swing.JButton btnCASH;
    private javax.swing.JButton btnCCARD;
    private javax.swing.JButton btnCHECH;
    private javax.swing.JButton btnCREDITO;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDCARD;
    private javax.swing.JButton btnDEPOSITO;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnTRANS;
    private javax.swing.JFormattedTextField dtCash;
    private javax.swing.JFormattedTextField dtCcard;
    private javax.swing.JFormattedTextField dtCheck;
    private javax.swing.JFormattedTextField dtCredito;
    private javax.swing.JFormattedTextField dtDcard;
    private javax.swing.JFormattedTextField dtPago;
    private javax.swing.JFormattedTextField dtDeposito;
    private javax.swing.JFormattedTextField dtGrandtotal;
    private javax.swing.JFormattedTextField dtSubtotal;
    private javax.swing.JFormattedTextField dtTaxamount;
    private javax.swing.JFormattedTextField dtTransf;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblCcard;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblCredito;
    private javax.swing.JLabel lblDcard;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblDeposito;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTaxamount;
    private javax.swing.JLabel lblTrans;

    // Las etiquetas
    private String lblCouponStrore = "<html>" + "STORE" + "<br>" + "COUPON" + "</html>";
    private String lblHOUSECHARGE = "<html>" + "HOUSE " + "<br>" + "CHAGE" + "</html>";
    private String lblGIFCARD = "<html>" + "GIF " + "<br>" + "CARD" + "</html>";
    private String lblVENDORCOUPON = "<html>" + "VENDOR " + "<br>" + "COUPON" + "</html>";
    

    // la Data
    private javax.swing.JTable T_Data_Cheque = new javax.swing.JTable();
    private javax.swing.JTable T_Data_T_Credito = new javax.swing.JTable();
    private javax.swing.JTable T_Data_T_Debito = new javax.swing.JTable();
    private javax.swing.JTable T_Data_Deposito = new javax.swing.JTable();
    private javax.swing.JTable T_Data_Transf = new javax.swing.JTable();
    
    
	// los montos de los diferentes tipos de pago
    private double d_dtCash =0 ;
    private double d_dtCashChange =0 ;
    private double d_dtCheck=0 ;
    private double d_dtCcard=0 ;
    private double d_dtDcard=0 ;
    private double d_dtDeposito=0 ;
    private double d_dtPago=0 ;
    private double d_dtTransf=0 ;
    private double d_Credito=0 ;
    private double d_dtGrandtotal=0 ;

    private double d_dtSubtotal=0 ;
    private double d_dtbalance=0;

    
	public PosPago_Pagos (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosPago_Pagos"), true);
		this.posPanel = posPanel;
		init();

		
	}    

	private void init() 
	{
		initComponents();
		initT_Data();
		
	}

	private void initT_Data()
	    {
	        // CHEQUE  
		
	    	T_Data_Cheque.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
					 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
	            };

	            @SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });	
	    	// TARJETA DE CREDITO
	    	T_Data_T_Credito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		            		"C_Payment_ID", "CreditCard", "number","name","Expires","CVC","payamt"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, 
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	
	    	
	    	// TARJETA DE DEBITO
	    	T_Data_T_Debito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });
	    		    	
	        // DEPOSITO  
			
	    	T_Data_Deposito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });
	    	
	        // TRANFERENCIA  
			
	    	T_Data_Transf.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
					 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
	            };

	            @SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });		    	
	    }
	  
    private void initComponents() {
        PanelFormas = new javax.swing.JPanel();
        btnCASH = new javax.swing.JButton();
        btnCHECH = new javax.swing.JButton();
        btnCCARD = new javax.swing.JButton();
        btnDCARD = new javax.swing.JButton();
        btnDEPOSITO = new javax.swing.JButton();
        btnTRANS = new javax.swing.JButton();
        btnCREDITO = new javax.swing.JButton();
        PanelAccion = new javax.swing.JPanel();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        PanelResultados = new javax.swing.JPanel();
        lblTaxamount = new javax.swing.JLabel();
        lblDeposit = new javax.swing.JLabel();
        lblCash = new javax.swing.JLabel();
        lblGrandtotal = new javax.swing.JLabel();
        lblCheck = new javax.swing.JLabel();
        lblCcard = new javax.swing.JLabel();
        lblDeposito = new javax.swing.JLabel();
        lblTrans = new javax.swing.JLabel();
        lblDcard = new javax.swing.JLabel();
        lblCredito = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        dtSubtotal = new javax.swing.JFormattedTextField();
        dtTaxamount = new javax.swing.JFormattedTextField();
        dtPago = new javax.swing.JFormattedTextField();
        dtGrandtotal = new javax.swing.JFormattedTextField();
        dtCash = new javax.swing.JFormattedTextField();
        dtCheck = new javax.swing.JFormattedTextField();
        dtCcard = new javax.swing.JFormattedTextField();
        dtDcard = new javax.swing.JFormattedTextField();
        dtDeposito = new javax.swing.JFormattedTextField();
        dtTransf = new javax.swing.JFormattedTextField();
        dtCredito = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        PanelFormas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCASH.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCASH.setText("CASH");
        btnCASH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCASH.setIconTextGap(12);
        btnCASH.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCASHActionPerformed(evt);
            }
        });

        btnCHECH.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCHECH.setText("CHECK");
        btnCHECH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCHECH.setIconTextGap(12);
        btnCHECH.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCHECH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHECHActionPerformed(evt);
            }
        });

        btnCCARD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCCARD.setText("C.CARD");
        btnCCARD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCCARD.setIconTextGap(12);
        btnCCARD.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCCARD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCARDActionPerformed(evt);
            }
        });

        btnDCARD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDCARD.setText("D.CARD");
        btnDCARD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDCARD.setIconTextGap(12);
        btnDCARD.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnDCARD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDCARDActionPerformed(evt);
            }
        });

        btnDEPOSITO.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDEPOSITO.setText("DEPOSITO");
        btnDEPOSITO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDEPOSITO.setIconTextGap(12);
        btnDEPOSITO.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
       btnDEPOSITO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDEPOSITOActionPerformed(evt);
            }
        });

        btnTRANS.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTRANS.setText("TRANSF.");
        btnTRANS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTRANS.setIconTextGap(12);
        btnTRANS.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnTRANS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTRANSActionPerformed(evt);
            }
        });

        btnCREDITO.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCREDITO.setText("CREDITO");
        btnCREDITO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCREDITO.setIconTextGap(12);
        btnCREDITO.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    /*    btnCREDITO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCREDITOActionPerformed(evt);
            }
        });*/

        javax.swing.GroupLayout PanelFormasLayout = new javax.swing.GroupLayout(PanelFormas);
        PanelFormas.setLayout(PanelFormasLayout);
        PanelFormasLayout.setHorizontalGroup(
            PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCCARD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCASH, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDEPOSITO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCREDITO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCHECH, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnDCARD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTRANS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(227, 227, 227))
        );

        PanelFormasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCASH, btnCCARD, btnCHECH});

        PanelFormasLayout.setVerticalGroup(
            PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCASH, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCHECH, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCCARD, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDCARD, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormasLayout.createSequentialGroup()
                        .addComponent(btnDEPOSITO, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnCREDITO, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTRANS, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFormasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCASH, btnCCARD, btnCHECH});

        PanelAccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnProcess.setText("PROCESS");
        btnProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProcess.setIconTextGap(12);
        btnProcess.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setIconTextGap(12);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAccionLayout = new javax.swing.GroupLayout(PanelAccion);
        PanelAccion.setLayout(PanelAccionLayout);
        PanelAccionLayout.setHorizontalGroup(
            PanelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelAccionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnProcess});

        PanelAccionLayout.setVerticalGroup(
            PanelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelAccionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnProcess});

        PanelResultados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTaxamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTaxamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTaxamount.setText("Impuesto:");

        lblDeposit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDeposit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDeposit.setText("Pago:");

        lblCash.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCash.setText("EFECTIVO:");

        lblGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblGrandtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandtotal.setText("Total:");

        lblCheck.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCheck.setText("CHEQUE:");

        lblCcard.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCcard.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCcard.setText("TARJETA CREDITO:");

        lblDeposito.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDeposito.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDeposito.setText("DEPOSITO:");

        lblTrans.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTrans.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrans.setText("TRANSFERENCIA:");

        lblDcard.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDcard.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDcard.setText("TARJETA DEBITO:");

        lblCredito.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCredito.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCredito.setText("CREDITO:");

        lblSubtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("Sub Total:");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        dtSubtotal.setEditable(false);
        dtSubtotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtSubtotal.setText("0");
        dtSubtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtTaxamount.setEditable(false);
        dtTaxamount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtTaxamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtTaxamount.setText("0");
        dtTaxamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtPago.setEditable(false);
        dtPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPago.setText("0");
        dtPago.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtGrandtotal.setEditable(false);
        dtGrandtotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtGrandtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtGrandtotal.setText("0");
        dtGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        dtCash.setEditable(false);
        dtCash.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCash.setText("0");
        dtCash.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtCheck.setEditable(false);
        dtCheck.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtCheck.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCheck.setText("0");
        dtCheck.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtCcard.setEditable(false);
        dtCcard.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtCcard.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCcard.setText("0");
        dtCcard.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtDcard.setEditable(false);
        dtDcard.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtDcard.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtDcard.setText("0");
        dtDcard.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtDeposito.setEditable(false);
        dtDeposito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtDeposito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtDeposito.setText("0");
        dtDeposito.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtTransf.setEditable(false);
        dtTransf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtTransf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtTransf.setText("0");
        dtTransf.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtCredito.setEditable(false);
        dtCredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCredito.setText("0");
        dtCredito.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout PanelResultadosLayout = new javax.swing.GroupLayout(PanelResultados);
        PanelResultados.setLayout(PanelResultadosLayout);
        PanelResultadosLayout.setHorizontalGroup(
            PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelResultadosLayout.createSequentialGroup()
                        .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrans, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDeposito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDcard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCcard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrandtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDeposit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTaxamount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtTaxamount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtGrandtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCcard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtDcard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtDeposito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtTransf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addComponent(jSeparator4))
                .addContainerGap())
        );

        PanelResultadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCash, lblCcard, lblCheck, lblCredito, lblDcard, lblDeposit, lblDeposito, lblGrandtotal, lblSubtotal, lblTaxamount, lblTrans});

        PanelResultadosLayout.setVerticalGroup(
            PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(dtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaxamount)
                    .addComponent(dtTaxamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeposit)
                    .addComponent(dtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrandtotal)
                    .addComponent(dtGrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCash)
                    .addComponent(dtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheck)
                    .addComponent(dtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCcard)
                    .addComponent(dtCcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDcard)
                    .addComponent(dtDcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeposito)
                    .addComponent(dtDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrans)
                    .addComponent(dtTransf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCredito)
                    .addComponent(dtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelResultadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCash, lblCcard, lblCheck, lblCredito, lblDcard, lblDeposit, lblDeposito, lblGrandtotal, lblSubtotal, lblTaxamount, lblTrans});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelFormas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PanelAccion, PanelFormas});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFormas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        pack();    
        
    }
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	setSaldoPayment();
    	if(this.d_dtPago<d_dtGrandtotal)
    	{
    		ADialog.warn(0, posPanel, "Payment not Balanced");
    	}
    	else
    	{
        	bPosPagoOK=true;
        	this.dispose();
    	}

    }                                          

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	bPosPagoOK=false;
    	this.dispose();
    }                                         
    private void btnCASHActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // 
        PosPaymentCash el_Payment = new PosPaymentCash(this.posPanel,true);

        // asigno variables
        
        el_Payment.setdt_Grandtotal(d_dtGrandtotal);
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;

        
        if(d_dtCash!=0)
        {
        	 dBalance=dMontoTotal-dMontoDeposito+Double.parseDouble(this.dtCash.getValue().toString());
        }
        el_Payment.setdt_Grandtotal(dMontoTotal);
        el_Payment.setdt_Balance(dBalance);
       	el_Payment.setdt_Paymentamount(dBalance);
       	el_Payment.setdt_Tenderamount(0);
       	el_Payment.setdt_Change(0);
       	
       	el_Payment.SetValores();
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        

        if(el_Payment.getbAcepto())
        {
        	this.dtCash.setText(String.valueOf(el_Payment.getdt_Tenderamount()));
        	d_dtCash=el_Payment.getdt_Tenderamount();
        	this.dtCash.setValue(d_dtCash);
        	setSaldoPayment();

        
        }
    }
    private void btnDCARDActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	PosPaymentDebitCard el_Payment = new PosPaymentDebitCard(this.posPanel,true);
        el_Payment.getdtGrandtotal().setText(this.dtGrandtotal.getText());
        el_Payment.getdtPaymentamount().setText(this.dtGrandtotal.getText());
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;
        el_Payment.getdtPaymentamount().setText(df.format(dBalance));
        el_Payment.setPreferredSize(new Dimension(el_Payment.getPreferredSize().width+140,el_Payment.getPreferredSize().height));
        
        
        DefaultTableModel model_local = (DefaultTableModel) T_Data_T_Debito.getModel();
        DefaultTableModel model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {
        
        	Object IDColumn;

        	IDColumn C_Payment_ID = null ;
    		String routingno = model_local.getValueAt(iPos, 1).toString();
    		String accountno = model_local.getValueAt(iPos, 2).toString();
    		String checkno = model_local.getValueAt(iPos, 3).toString();
    		Double payamt; 
    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
    		model_Dialogo.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
        }        
        if(this.d_dtDcard!=0)
        {
        	 el_Payment.getdtSumAmont().setText(this.dtDcard.getText());
        }       
    
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        if(el_Payment.getbAcepto())
        {
            this.dtDcard.setText(el_Payment.getdtSumAmont().getText());
            this.dtDcard.setValue(el_Payment.getdt_dtSumamount());
            T_Data_T_Debito = new javax.swing.JTable();
            T_Data_T_Debito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	       
            model_local = (DefaultTableModel) T_Data_T_Debito.getModel();
            // Agrego los valores de grid
            model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
            // referencia base pare enviar al PosPago
            for (int i = 0, rows = model_Dialogo.getRowCount(); i < rows; i++)
            {
            	Object IDColumn;
            	IDColumn C_Payment_ID = null ;
        		String routingno = model_Dialogo.getValueAt(i, 1).toString();
        		String accountno = model_Dialogo.getValueAt(i, 2).toString();
        		String checkno = model_Dialogo.getValueAt(i, 3).toString();
        		Double payamt; 
        		payamt = Double.parseDouble(model_Dialogo.getValueAt(i, 4).toString());
        		model_local.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
            }
            

        	this.dtDcard.setText(el_Payment.getdtSumAmont().getText());
        	
        	this.d_dtDcard=Double.parseDouble(el_Payment.getdtSumAmont().getValue().toString());
        	this.dtDcard.setValue(d_dtDcard);

        	setSaldoPayment(); 
            
        }
            

        
    }                                        
    
    private void btnDEPOSITOActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	PosPaymenDeposito el_Payment = new PosPaymenDeposito(this.posPanel,true);
        el_Payment.getdtGrandtotal().setText(this.dtGrandtotal.getText());
        el_Payment.getdtPaymentamount().setText(this.dtGrandtotal.getText());
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;
        el_Payment.getdtPaymentamount().setText(df.format(dBalance));
        el_Payment.setPreferredSize(new Dimension(el_Payment.getPreferredSize().width+140,el_Payment.getPreferredSize().height));
        
        
        DefaultTableModel model_local = (DefaultTableModel) T_Data_Deposito.getModel();
        DefaultTableModel model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {
        
        	Object IDColumn;

        	IDColumn C_Payment_ID = null ;
    		String routingno = model_local.getValueAt(iPos, 1).toString();
    		String accountno = model_local.getValueAt(iPos, 2).toString();
    		String checkno = model_local.getValueAt(iPos, 3).toString();
    		Double payamt; 
    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
    		model_Dialogo.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
        }        
        if(d_dtDeposito!=0)
        {
        	 el_Payment.getdtSumAmont().setText(this.dtCheck.getText());
        }       
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        if(el_Payment.getbAcepto())
        {
            this.dtDeposito.setText(el_Payment.getdtSumAmont().getText());
            this.dtDeposito.setValue(el_Payment.getdt_dtSumamount());
            T_Data_Deposito = new javax.swing.JTable();
	    	T_Data_Deposito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	       
            model_local = (DefaultTableModel) T_Data_Deposito.getModel();
            // Agrego los valores de grid
            model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
            // referencia base pare enviar al PosPago
            for (int i = 0, rows = model_Dialogo.getRowCount(); i < rows; i++)
            {
            	Object IDColumn;
            	IDColumn C_Payment_ID = null ;
        		String routingno = model_Dialogo.getValueAt(i, 1).toString();
        		String accountno = model_Dialogo.getValueAt(i, 2).toString();
        		String checkno = model_Dialogo.getValueAt(i, 3).toString();
        		Double payamt; 
        		payamt = Double.parseDouble(model_Dialogo.getValueAt(i, 4).toString());
        		model_local.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
            }
            

        	this.dtDeposito.setText(el_Payment.getdtSumAmont().getText());
        	
        	d_dtDeposito=Double.parseDouble(el_Payment.getdtSumAmont().getValue().toString());
        	this.dtDeposito.setValue(d_dtDeposito);

        	setSaldoPayment(); 
            
        }
    }                                        
    private void btnCHECHActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	PosPaymenCheck el_Payment = new PosPaymenCheck(this.posPanel,true);
        el_Payment.getdtGrandtotal().setText(this.dtGrandtotal.getText());
        el_Payment.getdtPaymentamount().setText(this.dtGrandtotal.getText());
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;
        el_Payment.getdtPaymentamount().setText(df.format(dBalance));
        el_Payment.setPreferredSize(new Dimension(el_Payment.getPreferredSize().width+140,el_Payment.getPreferredSize().height));
        
        
        DefaultTableModel model_local = (DefaultTableModel) T_Data_Cheque.getModel();
        DefaultTableModel model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {
        
        	Object IDColumn;

        	IDColumn C_Payment_ID = null ;
    		String routingno = model_local.getValueAt(iPos, 1).toString();
    		String accountno = model_local.getValueAt(iPos, 2).toString();
    		String checkno = model_local.getValueAt(iPos, 3).toString();
    		Double payamt; 
    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
    		model_Dialogo.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
        }        
        if(d_dtCheck!=0)
        {
        	 el_Payment.getdtSumAmont().setText(this.dtCheck.getText());
        }       
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        if(el_Payment.getbAcepto())
        {
            this.dtCheck.setText(el_Payment.getdtSumAmont().getText());
            this.dtCheck.setValue(el_Payment.getdt_dtSumamount());
            T_Data_Cheque = new javax.swing.JTable();
	    	T_Data_Cheque.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	       
            model_local = (DefaultTableModel) T_Data_Cheque.getModel();
            // Agrego los valores de grid
            model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
            // referencia base pare enviar al PosPago
            for (int i = 0, rows = model_Dialogo.getRowCount(); i < rows; i++)
            {
            	Object IDColumn;
            	IDColumn C_Payment_ID = null ;
        		String routingno = model_Dialogo.getValueAt(i, 1).toString();
        		String accountno = model_Dialogo.getValueAt(i, 2).toString();
        		String checkno = model_Dialogo.getValueAt(i, 3).toString();
        		Double payamt; 
        		payamt = Double.parseDouble(model_Dialogo.getValueAt(i, 4).toString());
        		model_local.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
            }
            

        	this.dtCheck.setText(el_Payment.getdtSumAmont().getText());
        	
        	d_dtCheck=Double.parseDouble(el_Payment.getdtSumAmont().getValue().toString());
        	this.dtCheck.setValue(d_dtCheck);

        	setSaldoPayment(); 
            
        }
      }   
    
    private void btnTRANSActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	PosPaymenTransf el_Payment = new PosPaymenTransf(this.posPanel,true);
        el_Payment.getdtGrandtotal().setText(this.dtGrandtotal.getText());
        el_Payment.getdtPaymentamount().setText(this.dtGrandtotal.getText());
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;
        el_Payment.getdtPaymentamount().setText(df.format(dBalance));
        el_Payment.setPreferredSize(new Dimension(el_Payment.getPreferredSize().width+140,el_Payment.getPreferredSize().height));
        
        
        DefaultTableModel model_local = (DefaultTableModel) T_Data_Transf.getModel();
        DefaultTableModel model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {
        
        	Object IDColumn;

        	IDColumn C_Payment_ID = null ;
    		String routingno = model_local.getValueAt(iPos, 1).toString();
    		String accountno = model_local.getValueAt(iPos, 2).toString();
    		String checkno = model_local.getValueAt(iPos, 3).toString();
    		Double payamt; 
    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
    		model_Dialogo.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
        }        
        if(d_dtTransf!=0)
        {
        	 el_Payment.getdtSumAmont().setText(this.dtTransf.getText());
        }       
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        if(el_Payment.getbAcepto())
        {
            this.dtTransf.setText(el_Payment.getdtSumAmont().getText());
            this.dtTransf.setValue(el_Payment.getdt_dtSumamount());
            T_Data_Transf = new javax.swing.JTable();
	    	T_Data_Transf.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "routingno", "accountno","checkno","Nombre"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	       
            model_local = (DefaultTableModel) T_Data_Transf.getModel();
            // Agrego los valores de grid
            model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
            // referencia base pare enviar al PosPago
            for (int i = 0, rows = model_Dialogo.getRowCount(); i < rows; i++)
            {
            	Object IDColumn;
            	IDColumn C_Payment_ID = null ;
        		String routingno = model_Dialogo.getValueAt(i, 1).toString();
        		String accountno = model_Dialogo.getValueAt(i, 2).toString();
        		String checkno = model_Dialogo.getValueAt(i, 3).toString();
        		Double payamt; 
        		payamt = Double.parseDouble(model_Dialogo.getValueAt(i, 4).toString());
        		model_local.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});
            }
            

        	this.dtTransf.setText(el_Payment.getdtSumAmont().getText());
        	
        	d_dtTransf=Double.parseDouble(el_Payment.getdtSumAmont().getValue().toString());
        	this.dtTransf.setValue(d_dtTransf);

        	setSaldoPayment(); 
            
        }
      }   

    
    private void btnCCARDActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Tarjeta de Crdito
    	
    	PosPaymenCreditCard el_Payment = new PosPaymenCreditCard(this.posPanel,true);
        el_Payment.getdtGrandtotal().setText(this.dtGrandtotal.getText());
        el_Payment.getdtPaymentamount().setText(this.dtGrandtotal.getText());
        
        double dMontoTotal= Double.parseDouble(this.dtGrandtotal.getValue().toString());
        double dMontoDeposito= Double.parseDouble(this.dtPago.getValue().toString());
        double dBalance=dMontoTotal-dMontoDeposito;
        el_Payment.getdtPaymentamount().setText(df.format(dBalance));
        el_Payment.setPreferredSize(new Dimension(el_Payment.getPreferredSize().width+140,el_Payment.getPreferredSize().height));
        
        
        DefaultTableModel model_local = (DefaultTableModel) T_Data_T_Credito.getModel();
        DefaultTableModel model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {

        	Object IDColumn;
        	IDColumn C_Payment_ID = null ;
    		Object CreditCard = model_local.getValueAt(iPos, 1);
    		String number =  model_local.getValueAt(iPos, 2).toString();
    		String name =  model_local.getValueAt(iPos, 3).toString();
    		String Expires =  model_local.getValueAt(iPos, 4).toString();
    		String CVC = model_local.getValueAt(iPos, 5).toString();
    		Double payamt; 
    		payamt = Double.parseDouble( model_local.getValueAt(iPos,6).toString().toString());
    		model_Dialogo.addRow(new Object[] {C_Payment_ID,CreditCard,number,name,Expires,CVC,payamt});
        }        
        if(d_dtCcard!=0) 
        {
        
        	 
        	 el_Payment.getdtSumAmont().setText(this.dtCcard.getText());

        }       
        AEnv.showCenterWindow(posPanel.getm_frame(), el_Payment);
        if(el_Payment.getbAcepto())
        {
            this.dtCcard.setText(el_Payment.getdtSumAmont().getText());
            this.dtCcard.setValue(el_Payment.getdt_dtSumamount());
            T_Data_T_Credito = new javax.swing.JTable();
            T_Data_T_Credito.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		            },
		            new String [] {
		                "C_Payment_ID", "CreditCard", "number","name","Expires","CVC","payamt"
		            }
		        ) {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
						 IDColumn.class, 
						 java.lang.Object.class, 
						 java.lang.String.class, 
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.Double.class
		            };

		            @SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
		                return types [columnIndex];
		            }
		        });	       
            model_local = (DefaultTableModel) T_Data_T_Credito.getModel();
            // Agrego los valores de grid
            model_Dialogo =  (DefaultTableModel)el_Payment.getm_table().getModel();
            // referencia base pare enviar al PosPago
            for (int i = 0, rows = model_Dialogo.getRowCount(); i < rows; i++)
            {
            	

            	Object IDColumn;
            	IDColumn C_Payment_ID = null ;
        		Object CreditCard =  model_Dialogo.getValueAt(i, 1);
        		String number =  model_Dialogo.getValueAt(i, 2).toString();
        		String name =  model_Dialogo.getValueAt(i, 3).toString();
        		String Expires =   model_Dialogo.getValueAt(i, 4).toString();
        		String CVC =  model_Dialogo.getValueAt(i, 5).toString();
        		Double payamt; 
        		payamt = Double.parseDouble(  model_Dialogo.getValueAt(i, 6).toString());
        		model_local.addRow(new Object[] {C_Payment_ID,CreditCard,number,name,Expires,CVC,payamt});
            }
            

        	this.dtCcard.setText(el_Payment.getdtSumAmont().getText());
        	
        	d_dtCcard=el_Payment.getdt_dtSumamount();
        	this.dtCcard.setValue(d_dtCcard);

        	setSaldoPayment(); 
        }    	
    }                                        
    
    // base

   //   funciones de control
    public boolean getbPosPagoOK()
    {
    	return this.bPosPagoOK ;
    }
    public javax.swing.JFormattedTextField getdtCash()
    {
    	return this.dtCash;
    }
    public javax.swing.JFormattedTextField getdtCcard()
    {
    	return this.dtCcard;
    }
    public javax.swing.JFormattedTextField getdtCheck()
    {
    	return this.dtCheck;
    }
    public javax.swing.JFormattedTextField getdtPago()
    {
    	return this.dtPago;
    }
    public javax.swing.JFormattedTextField getdtGrandtotal()
    {
    	return this.dtGrandtotal;
    }
    public javax.swing.JFormattedTextField getdtSubtotal()
    {
    	return this.dtSubtotal;
    }
    public javax.swing.JFormattedTextField getdtTaxamount()
    {
    	return this.dtTaxamount;
    }
    // Aqui calculo los acumulados
    public void setSaldoPayment()
    {
    	this.d_dtPago=this.d_dtCash+this.d_dtCheck+this.d_dtCcard+this.d_dtDcard+this.d_dtDeposito+this.d_dtTransf;
    	this.dtPago.setValue(d_dtPago);
    	this.dtPago.setText(String.valueOf(d_dtPago));
    }
    
    // llamar a las formas de pago
    public double getd_dtCash()
    {
    	return d_dtCash;
    }
    public double getd_dtCcard()
    {
    	return d_dtCcard;
    }
    public double getd_dtCheck()
    {
    	return d_dtCheck;
    }
    public double getd_dtPago()
    {
    	return d_dtPago;
    }
    public  javax.swing.JTable getT_Data_Cheque()
    {
    	return T_Data_Cheque;
    }
    public javax.swing.JTable getT_Data_T_Credito()
    {
    	return T_Data_T_Credito;
    }
   
    
    // los label
        public javax.swing.JLabel getlblTaxamount()
    {
    	return lblTaxamount;
    }
    public void setd_dtGrandtotal(double value)
    {
    	 d_dtGrandtotal=value;
    }
}
