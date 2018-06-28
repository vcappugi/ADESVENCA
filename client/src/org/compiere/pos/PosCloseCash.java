package org.compiere.pos;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

import org.compiere.model.MBPartner;
import org.compiere.model.MBankStatement;


import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "unused", "serial" })
public class PosCloseCash extends CDialog implements ActionListener {
    public static CLogger log = CLogger.getCLogger(PosBottleReturns.class);
	private PosBasePanel posPanel;
	private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	private MBPartner	m_bpartner;
	sincorinza refrescar ;
	private int C_BankStatement_ID = 0;
    // Variables declaration - do not modify
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnProcess;
    private javax.swing.JFormattedTextField dtCash;
    private javax.swing.JFormattedTextField dtCash1;
    private javax.swing.JFormattedTextField dtCash2;
    private javax.swing.JFormattedTextField dtCcard;
    private javax.swing.JFormattedTextField dtCcard1;
    private javax.swing.JFormattedTextField dtCcard2;
    private javax.swing.JFormattedTextField dtCheck;
    private javax.swing.JFormattedTextField dtCheck1;
    private javax.swing.JFormattedTextField dtCheck2;
    private javax.swing.JFormattedTextField dtCierre;
    private javax.swing.JFormattedTextField dtDevoluciones;
    private javax.swing.JFormattedTextField dtDirferencia;
    private javax.swing.JFormattedTextField dtFacturas;
    private javax.swing.JFormattedTextField dtGcard;
    private javax.swing.JFormattedTextField dtGcard1;
    private javax.swing.JFormattedTextField dtGcard2;
    private javax.swing.JFormattedTextField dtGrandtotal;
    private javax.swing.JFormattedTextField dtGrandtotal1;
    private javax.swing.JFormattedTextField dtHousecharge;
    private javax.swing.JFormattedTextField dtHousecharge1;
    private javax.swing.JFormattedTextField dtHousecharge2;
    private javax.swing.JFormattedTextField dtInicio;
    private javax.swing.JTextField dtOrdenes;
    private javax.swing.JTextField dtPos;
    private javax.swing.JFormattedTextField dtStorecoupon;
    private javax.swing.JFormattedTextField dtStorecoupon1;
    private javax.swing.JFormattedTextField dtStorecoupon2;
    private javax.swing.JTextField dtUsuario;
    private javax.swing.JFormattedTextField dtVendorcoupon;
    private javax.swing.JFormattedTextField dtVendorcoupon1;
    private javax.swing.JFormattedTextField dtVendorcoupon2;
    private javax.swing.JFormattedTextField dtYousavedtotal;
    private javax.swing.JFormattedTextField dtYousavedtotal1;
    private javax.swing.JFormattedTextField dtYouwictotal;
    private javax.swing.JFormattedTextField dtYouwictotal1;
    private javax.swing.JFormattedTextField fieldCurrentDate;
    private javax.swing.JFormattedTextField fieldHours;
    private javax.swing.JTextArea fildNotes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblCash1;
    private javax.swing.JLabel lblCash2;
    private javax.swing.JLabel lblCcard;
    private javax.swing.JLabel lblCcard1;
    private javax.swing.JLabel lblCcard2;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblCheck1;
    private javax.swing.JLabel lblCheck2;
    private javax.swing.JLabel lblCierre;
    private javax.swing.JLabel lblCurrenDate;
    private javax.swing.JLabel lblDevoluciones;
    private javax.swing.JLabel lblDiferencia;
    private javax.swing.JLabel lblFacturas;
    private javax.swing.JLabel lblGcard;
    private javax.swing.JLabel lblGcard1;
    private javax.swing.JLabel lblGcard2;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblGrandtotal1;
    private javax.swing.JLabel lblHousecharge;
    private javax.swing.JLabel lblHousecharge1;
    private javax.swing.JLabel lblHousecharge2;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblOpenCash;
    private javax.swing.JLabel lblPOS;
    private javax.swing.JLabel lblPOS1;
    private javax.swing.JLabel lblPOS2;
    private javax.swing.JLabel lblStorecoupon;
    private javax.swing.JLabel lblStorecoupon1;
    private javax.swing.JLabel lblStorecoupon2;
    private javax.swing.JLabel lblVendorcoupon;
    private javax.swing.JLabel lblVendorcoupon1;
    private javax.swing.JLabel lblVendorcoupon2;
    private javax.swing.JLabel lblYourwictotal;
    private javax.swing.JLabel lblYourwictotal1;
    private javax.swing.JLabel lblYousavedtotal;
    private javax.swing.JLabel lblYousavedtotal1;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelResultados1;
    private javax.swing.JPanel panelResultados2;
    // End of variables declaration
	public PosCloseCash (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosCloseCash"), true);
		this.posPanel = posPanel;
		init();
	    this.fieldCurrentDate.setValue(m_today);
	    C_BankStatement_ID = getBankStatement(posPanel);

		
	}  
	private void init() 
	{
		initComponents();
		initSaldo();
	}     
	private void initSaldo()
	{
		double efectivo=0;
		double cheque=0;
		double tcredito=0;
		double tdebito=0;
		double credito=0;
		double deposito=0;
		double transferencia=0;
		efectivo=getLineas("X");
		this.dtCash.setValue(efectivo);
		
		
	}
    private void initComponents() {

    	
		refrescar= new sincorinza();
		refrescar.start();	
    	
    	Date now = new Date();    	
        jPanel1 = new javax.swing.JPanel();
        lblOpenCash = new javax.swing.JLabel();
        fieldHours = new javax.swing.JFormattedTextField();
        fieldCurrentDate = new javax.swing.JFormattedTextField();
        lblCurrenDate = new javax.swing.JLabel();
        panelResultados2 = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        lblCierre = new javax.swing.JLabel();
        lblCash2 = new javax.swing.JLabel();
        lblDiferencia = new javax.swing.JLabel();
        lblCheck2 = new javax.swing.JLabel();
        lblCcard2 = new javax.swing.JLabel();
        lblGcard2 = new javax.swing.JLabel();
        lblStorecoupon2 = new javax.swing.JLabel();
        lblHousecharge2 = new javax.swing.JLabel();
        lblVendorcoupon2 = new javax.swing.JLabel();
        lblDevoluciones = new javax.swing.JLabel();
        lblFacturas = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        dtInicio = new javax.swing.JFormattedTextField();
        dtCierre = new javax.swing.JFormattedTextField();
        dtFacturas = new javax.swing.JFormattedTextField();
        dtDevoluciones = new javax.swing.JFormattedTextField();
        dtDirferencia = new javax.swing.JFormattedTextField();
        dtCash = new javax.swing.JFormattedTextField();
        dtCash2 = new javax.swing.JFormattedTextField();
        dtCheck2 = new javax.swing.JFormattedTextField();
        dtCcard2 = new javax.swing.JFormattedTextField();
        dtHousecharge2 = new javax.swing.JFormattedTextField();
        dtGcard2 = new javax.swing.JFormattedTextField();
        dtStorecoupon2 = new javax.swing.JFormattedTextField();
        dtVendorcoupon2 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblPOS = new javax.swing.JLabel();
        dtPos = new javax.swing.JTextField();
        lblPOS1 = new javax.swing.JLabel();
        dtUsuario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblPOS2 = new javax.swing.JLabel();
        dtOrdenes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fildNotes = new javax.swing.JTextArea();
        lblNotes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblOpenCash.setFont(new java.awt.Font("SansSerif", 0, 18));
        lblOpenCash.setText("Cierre de Caja");

        fieldHours.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldHours.setEditable(false);
        fieldHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldHours.setText("07:17:09 PM");
        fieldHours.setFont(new java.awt.Font("SansSerif", 0, 18));

        fieldCurrentDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldCurrentDate.setEditable(false);
        fieldCurrentDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCurrentDate.setText("01/01/2013");
        fieldCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 18));

        lblCurrenDate.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblCurrenDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrenDate.setText("Fecha/Hora:");

        panelResultados2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblInicio.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicio.setText("Inicio:");

        lblCierre.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblCierre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCierre.setText("Cierre:");

        lblCash2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblCash2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCash2.setText("CASH:");

        lblDiferencia.setFont(new java.awt.Font("SansSerif", 1, 16));
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiferencia.setText("Direferencia:");

        lblCheck2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblCheck2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCheck2.setText("CHECK:");

        lblCcard2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblCcard2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCcard2.setText("C. CARD:");

        lblGcard2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblGcard2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGcard2.setText("G. CARD:");

        lblStorecoupon2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblStorecoupon2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStorecoupon2.setText("STORE COUPON:");

        lblHousecharge2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblHousecharge2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHousecharge2.setText("HOUSE CHARGE:");

        lblVendorcoupon2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblVendorcoupon2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVendorcoupon2.setText("VENDOR COUPON:");

        lblDevoluciones.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDevoluciones.setText("Devoluciones:");

        lblFacturas.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblFacturas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacturas.setText("Facturas:");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        dtInicio.setEditable(false);
        dtInicio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtInicio.setText("0");
        dtInicio.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtCierre.setEditable(false);
        dtCierre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCierre.setText("0");
        dtCierre.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtFacturas.setEditable(false);
        dtFacturas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtFacturas.setText("0");
        dtFacturas.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtDevoluciones.setEditable(false);
        dtDevoluciones.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtDevoluciones.setText("0");
        dtDevoluciones.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtDirferencia.setEditable(false);
        dtDirferencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtDirferencia.setText("0");
        dtDirferencia.setFont(new java.awt.Font("SansSerif", 1, 14));

        dtCash2.setEditable(false);
        dtCash2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCash2.setText("0");
        dtCash2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtCheck2.setEditable(false);
        dtCheck2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCheck2.setText("0");
        dtCheck2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtCcard2.setEditable(false);
        dtCcard2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCcard2.setText("0");
        dtCcard2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtHousecharge2.setEditable(false);
        dtHousecharge2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtHousecharge2.setText("0");
        dtHousecharge2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtGcard2.setEditable(false);
        dtGcard2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtGcard2.setText("0");
        dtGcard2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtStorecoupon2.setEditable(false);
        dtStorecoupon2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtStorecoupon2.setText("0");
        dtStorecoupon2.setFont(new java.awt.Font("SansSerif", 0, 14));

        dtVendorcoupon2.setEditable(false);
        dtVendorcoupon2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtVendorcoupon2.setText("0");
        dtVendorcoupon2.setFont(new java.awt.Font("SansSerif", 0, 14));

        javax.swing.GroupLayout panelResultados2Layout = new javax.swing.GroupLayout(panelResultados2);
        panelResultados2.setLayout(panelResultados2Layout);
        panelResultados2Layout.setHorizontalGroup(
            panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultados2Layout.createSequentialGroup()
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelResultados2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDevoluciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFacturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCierre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCierre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtFacturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtDevoluciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultados2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDirferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultados2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultados2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVendorcoupon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStorecoupon2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGcard2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHousecharge2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCcard2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheck2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCash2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtCash2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCheck2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtCcard2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtHousecharge2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtGcard2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtStorecoupon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(dtVendorcoupon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelResultados2Layout.setVerticalGroup(
            panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultados2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio)
                    .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCierre)
                    .addComponent(dtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFacturas)
                    .addComponent(dtFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDevoluciones)
                    .addComponent(dtDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtDirferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCash2)
                    .addComponent(dtCash2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheck2)
                    .addComponent(dtCheck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCcard2)
                    .addComponent(dtCcard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHousecharge2)
                    .addComponent(dtHousecharge2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGcard2)
                    .addComponent(dtGcard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStorecoupon2)
                    .addComponent(dtStorecoupon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendorcoupon2)
                    .addComponent(dtVendorcoupon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 12));
        btnProcess.setText("Procesar");
        btnProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProcess.setIconTextGap(12);
        btnProcess.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 12));
        btnCancel.setText("Cancelar");
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setIconTextGap(12);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPOS.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblPOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOS.setText("POS");

        dtPos.setEditable(false);
        dtPos.setFont(new java.awt.Font("SansSerif", 0, 18));
        dtPos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dtPos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPOS1.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblPOS1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOS1.setText("USUARIO");

        dtUsuario.setEditable(false);
        dtUsuario.setFont(new java.awt.Font("SansSerif", 0, 18));
        dtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(dtPos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtPos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPOS2.setFont(new java.awt.Font("SansSerif", 0, 14));
        lblPOS2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOS2.setText("ORDENES PROCESADAS");

        dtOrdenes.setEditable(false);
        dtOrdenes.setFont(new java.awt.Font("SansSerif", 0, 18));
        dtOrdenes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dtOrdenes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPOS2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(dtOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPOS2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fildNotes.setColumns(20);
        fildNotes.setFont(new java.awt.Font("SansSerif", 0, 18));
        fildNotes.setRows(5);
        fildNotes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(fildNotes);

        lblNotes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNotes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNotes.setText("Notas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelResultados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOpenCash, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(lblCurrenDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(fieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpenCash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrenDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelResultados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lblNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

	private int getBankStatement(PosBasePanel posPanel)
	{
		int elRetorno=0;
		
		String sql ="SELECT c_bankstatement_id FROM c_bankstatement Where c_bankstatement.c_bankaccount_id=? and  c_bankstatement.docstatus='DR'" ;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
			{
				pstmt = DB.prepareStatement(sql, "c_bankstatement");
				pstmt.setInt(1, posPanel.f_subpanel.p_pos.getC_BankAccount_ID());
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					elRetorno=rs.getInt("c_bankstatement_id");
				}

				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				DB.close(rs, pstmt);
				rs = null;
				pstmt = null;
			}
			return elRetorno;
		}	
	private double getLineas(String tipo )
	{
		double elRetorno=0;
		C_BankStatement_ID = getBankStatement(posPanel);
		String sql ="SELECT sum(trxamt) as monto FROM c_bankstatementline Where c_bankstatementline.c_bankstatement_id=? and  c_bankstatementline.efttrxid='"+tipo+"'" ;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
			{
				pstmt = DB.prepareStatement(sql, "c_bankstatement");
				pstmt.setInt(1,C_BankStatement_ID);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					elRetorno=rs.getInt("monto");
				}

				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				DB.close(rs, pstmt);
				rs = null;
				pstmt = null;
			}
			return elRetorno;
	}
	    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    	/*
    	MBankStatement el_MBankStatement = new MBankStatement (Env.getCtx(), 0, null);
    	el_MBankStatement.setC_BankAccount_ID(this.posPanel.p_pos.getC_BankAccount_ID());
    	el_MBankStatement.setDescription(this.fildNotes.getText().trim()+ "/ Create at "+this.fieldHours.getText());

    	 NumberFormat nf = NumberFormat.getInstance();
          
    	el_MBankStatement.setBeginningBalance(BigDecimal.valueOf(Double.valueOf(fieldInitialCharge.getValue().toString())));
    	el_MBankStatement.setStatementDate(m_today);
    	el_MBankStatement.setName(this.posPanel.p_pos.getName());
    	
    	el_MBankStatement.save();*/
	    	
	    	
	    	MBankStatement el_MBankStatement = new MBankStatement (Env.getCtx(), C_BankStatement_ID, null);
	    	el_MBankStatement.completeIt();
	    	el_MBankStatement.closeIt();
	    	el_MBankStatement.setDocStatus("CO");
	    	el_MBankStatement.saveEx();
	    	

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
