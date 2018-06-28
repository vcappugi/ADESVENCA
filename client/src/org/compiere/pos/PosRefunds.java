package org.compiere.pos;

import java.applet.Applet;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.compiere.apps.ADialog;
import org.compiere.apps.AEnv;
import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MClientInfo;
import org.compiere.model.MImage;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.model.MRole;
import org.compiere.swing.CDialog;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.compiere.util.ValueNamePair;

@SuppressWarnings("unused")
public class PosRefunds  extends CDialog implements ActionListener, ListSelectionListener {
	private Object[]    m_RMA_Type ;
	
	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosTransferOrder.class);
	private PosBasePanel posPanel;
	private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	private String			m_sql;
	private String			m_sqlTargt;
	private static String s_sqlWhere = "C_Order_ID=? AND LineNetAmt <> 0";    
	private static String s_sqlFrom = "C_Order_LineTax_v";    
	
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnQty;
    private javax.swing.JButton btnRetuenLine;
    private javax.swing.JButton btnWholeLine;
    private javax.swing.JComboBox cbTypeRMA;
    private javax.swing.JTextField fieldAmontOrder;
    private javax.swing.JTextField fieldAmountRefund;
    private javax.swing.JTextField fieldCashier;
    private javax.swing.JFormattedTextField fieldCurrentDate;
    private javax.swing.JFormattedTextField fieldHours;
    private javax.swing.JTextField fieldOrderSource;
    private javax.swing.JTextField fieldSourcePOS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane ScrollSource;
    private javax.swing.JScrollPane ScrollTarget;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCashier;
    private javax.swing.JLabel lblCurrenDate;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblMotiverefund;
    private javax.swing.JLabel lblPOSSource;
    private javax.swing.JLabel lblTranferOrder;
    private PosTable m_table;
    private PosTable m_table_target;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelSource;
    private javax.swing.JPanel panelTarget;
    private javax.swing.JPanel panelType;
	 
	sincorinza refrescar ;

	
	
	public PosRefunds (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosRefunds"), true);
		this.posPanel = posPanel;
		init();
	    this.fieldCurrentDate.setValue(m_today);


		
	}  
	private void init() 
	{
		
		initComponents();
	} 
	/**	Table Column Layout Info			*/
	private static ColumnInfo[] s_layout_m_table = new ColumnInfo[] 
	{
		new ColumnInfo(" ", "C_OrderLine_ID", IDColumn.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "Name"), "Name", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Qty"), "QtyOrdered", Double.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_UOM_ID"), "UOMSymbol", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "PriceActual"), "PriceActual", BigDecimal.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "LineNetAmt"), "LineNetAmt", BigDecimal.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_Tax_ID"), "TaxIndicator", String.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "QtyRefund"), "0", Double.class)
	};	
	
	
	private static ColumnInfo[] s_layout_m_table_target = new ColumnInfo[] 
	{
		new ColumnInfo(" ", "C_OrderLine_ID", IDColumn.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "Name"), "Name", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Qty"), "QtyOrdered", Double.class),   //2
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_UOM_ID"), "UOMSymbol", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "PriceActual"), "PriceActual", BigDecimal.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "LineNetAmt"), "LineNetAmt", BigDecimal.class),  //5
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_Tax_ID"), "TaxIndicator", String.class) 

	};		
    private void initComponents() {
    	m_RMA_Type = FillRMAType();
    	
    	this.cbTypeRMA = new javax.swing.JComboBox (m_RMA_Type);
    	
    	
    	
        panelInfo = new javax.swing.JPanel();
        lblTranferOrder = new javax.swing.JLabel();
        fieldOrderSource = new javax.swing.JTextField();
        lblHours = new javax.swing.JLabel();
        fieldHours = new javax.swing.JFormattedTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblCashier = new javax.swing.JLabel();
        fieldCashier = new javax.swing.JTextField();
        lblPOSSource = new javax.swing.JLabel();
        fieldSourcePOS = new javax.swing.JTextField();
        lblCurrenDate = new javax.swing.JLabel();
        fieldCurrentDate = new javax.swing.JFormattedTextField();
        panelType = new javax.swing.JPanel();
        lblMotiverefund = new javax.swing.JLabel();

        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        panelSource = new javax.swing.JPanel();
        
		refrescar= new sincorinza();
		refrescar.start();	
    	Date now = new Date();

        
    	m_table = new PosTable();
    	ScrollSource = new CScrollPane(m_table);
		m_sql = m_table.prepareTable (s_layout_m_table, s_sqlFrom, 
				s_sqlWhere, false, "C_Order_LineTax_v")
				+ " ORDER BY Line";
		
		

		
			m_table.addMouseListener(this);
			m_table.getSelectionModel().addListSelectionListener(this);
		m_table.setColumnVisibility(m_table.getColumn(0), false);
		m_table.getColumn(1).setPreferredWidth(175);
		m_table.getColumn(2).setPreferredWidth(75);
		m_table.getColumn(3).setPreferredWidth(30);
		m_table.getColumn(4).setPreferredWidth(75);
		m_table.getColumn(5).setPreferredWidth(75);
		m_table.getColumn(6).setPreferredWidth(30);
		m_table.getColumn(7).setPreferredWidth(30);
		
		m_table.setFocusable(false);
		m_table.setFillsViewportHeight( true ); 
		m_table.growScrollbars();
        
        
		
    	m_table_target = new PosTable();
    	ScrollTarget = new CScrollPane(m_table_target);
    	m_sqlTargt = m_table_target.prepareTable (s_layout_m_table_target, s_sqlFrom, 
				s_sqlWhere, false, "C_Order_LineTax_v")
				+ " ORDER BY Line";
		
		m_table_target.setRowCount(0);

		m_table_target.setColumnVisibility(m_table_target.getColumn(0), false);
		m_table_target.getColumn(1).setPreferredWidth(175);
		m_table_target.getColumn(2).setPreferredWidth(75);
		m_table_target.getColumn(3).setPreferredWidth(30);
		m_table_target.getColumn(4).setPreferredWidth(75);
		m_table_target.getColumn(5).setPreferredWidth(75);
		m_table_target.getColumn(6).setPreferredWidth(30);
		m_table_target.setFocusable(false);
		m_table_target.setFillsViewportHeight( true ); 
		m_table_target.growScrollbars();	
		
		
		
		
        btnQty = new javax.swing.JButton();
        btnWholeLine = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldAmontOrder = new javax.swing.JTextField();
        panelTarget = new javax.swing.JPanel();


        btnRetuenLine = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fieldAmountRefund = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTranferOrder.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTranferOrder.setText(Msg.translate(Env.getCtx(),  "Refund Order"));

        fieldOrderSource.setEditable(false);
        fieldOrderSource.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldOrderSource.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldOrderSource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldOrderSource.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldOrderSourceKeyPressed(evt);
            }
        });

        lblHours.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblHours.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHours.setText(Msg.translate(Env.getCtx(),  "Hours"));

        fieldHours.setEditable(false);
        fieldHours.setBorder(null);
        fieldHours.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        fieldHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
 
        fieldHours.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        lblCashier.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCashier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCashier.setText(Msg.translate(Env.getCtx(),  "Cashier Name"));

        fieldCashier.setEditable(false);
        fieldCashier.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldCashier.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        fieldCashier.setBorder(null);
        fieldCashier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCashierKeyPressed(evt);
            }
        });

        lblPOSSource.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPOSSource.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOSSource.setText(Msg.translate(Env.getCtx(),  "POS"));

        fieldSourcePOS.setEditable(false);
        fieldSourcePOS.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldSourcePOS.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        fieldSourcePOS.setBorder(null);
        fieldSourcePOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSourcePOSActionPerformed(evt);
            }
        });
        fieldSourcePOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSourcePOSKeyPressed(evt);
            }
        });

        lblCurrenDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCurrenDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrenDate.setText(Msg.translate(Env.getCtx(), "Current Date"));

        fieldCurrentDate.setEditable(false);
        fieldCurrentDate.setBorder(null);
        fieldCurrentDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        fieldCurrentDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        fieldCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPOSSource, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTranferOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldSourcePOS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                                .addComponent(fieldOrderSource, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHours, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(lblCurrenDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldHours, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCurrentDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lblCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(442, 442, 442))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(fieldCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCurrenDate, lblHours});

        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTranferOrder)
                    .addComponent(fieldOrderSource, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHours, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPOSSource, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldSourcePOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                        .addComponent(lblCurrenDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(fieldCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGap(46, 46, 46))
        );

        panelType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMotiverefund.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblMotiverefund.setText(Msg.translate(Env.getCtx(), "Motive of the refund"));

        cbTypeRMA.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N


        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        //btnProcess.setText("Process");
        btnProcess.setIcon(Env.getImageIcon("Process24.gif")); 
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        
        //btnCancel.setText("Cancel");
        btnCancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTypeLayout = new javax.swing.GroupLayout(panelType);
        panelType.setLayout(panelTypeLayout);
        panelTypeLayout.setHorizontalGroup(
            panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTypeRMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTypeLayout.createSequentialGroup()
                        .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMotiverefund, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTypeLayout.setVerticalGroup(
            panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMotiverefund)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbTypeRMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnProcess))
                .addContainerGap())
        );

        panelSource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));



        ScrollSource.setViewportView(m_table);

        btnQty.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnQty.setText(Msg.translate(Env.getCtx(),  "Qty"));
        btnQty.setIcon(Env.getImageIcon("Minus24.gif")); 
        btnQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtyActionPerformed(evt);
            }
        });

        btnWholeLine.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnWholeLine.setText(Msg.translate(Env.getCtx(),  "Qty Available"));
        btnWholeLine.setIcon(Env.getImageIcon("MultiX24.gif")); 
        btnWholeLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWholeLineActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText(Msg.translate(Env.getCtx(), "Amount Invoice"));

        fieldAmontOrder.setEditable(false);
        fieldAmontOrder.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldAmontOrder.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldAmontOrder.setText("0");

        javax.swing.GroupLayout panelSourceLayout = new javax.swing.GroupLayout(panelSource);
        panelSource.setLayout(panelSourceLayout);
        panelSourceLayout.setHorizontalGroup(
            panelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSourceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSourceLayout.createSequentialGroup()
                        .addComponent(ScrollSource, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSourceLayout.createSequentialGroup()
                        .addComponent(btnQty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnWholeLine, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAmontOrder)))
                .addContainerGap())
        );
        panelSourceLayout.setVerticalGroup(
            panelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSourceLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ScrollSource, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQty, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWholeLine, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(fieldAmontOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTarget.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        ScrollTarget.setViewportView(m_table_target);

        btnRetuenLine.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnRetuenLine.setText(Msg.translate(Env.getCtx(),  "Ignore"));
        btnRetuenLine.setIcon(Env.getImageIcon("Ignore24.gif")); 
        btnRetuenLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetuenLineActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText(Msg.translate(Env.getCtx(),  "Amount Refund"));

        fieldAmountRefund.setEditable(false);
        fieldAmountRefund.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldAmountRefund.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldAmountRefund.setText("0");

        javax.swing.GroupLayout panelTargetLayout = new javax.swing.GroupLayout(panelTarget);
        panelTarget.setLayout(panelTargetLayout);
        panelTargetLayout.setHorizontalGroup(
            panelTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTargetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTargetLayout.createSequentialGroup()
                        .addComponent(btnRetuenLine)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAmountRefund)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTargetLayout.setVerticalGroup(
            panelTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTargetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ScrollTarget)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetuenLine, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(fieldAmountRefund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

	public PosTable	getm_table()
	{
		return m_table;
	}    
	
	public void setm_table(PosTable value)
	{
		m_table=value;
		
	}    
	

	public void setSourceItems(PosOrderModel m_order) {
		Date now = new Date();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (m_sql, null);
			pstmt.setInt (1, m_order.get_ID());
			rs = pstmt.executeQuery ();
			m_table.loadTable(rs);
	        this.fieldCurrentDate.setValue(m_today);
	        this.fieldHours.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
	        
	        
	        this.fieldCashier.setText((Env.getCtx().getProperty("#AD_User_Name")).toUpperCase());
	        
	        this.fieldOrderSource.setText(this.posPanel.m_order.getDocumentNo());
	        this.fieldSourcePOS.setText(this.posPanel.p_pos.getName());
	        this.fieldAmontOrder.setText(this.posPanel.m_order.getGrandTotal().toString());
	        
	        
	        
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, m_sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}

		
	}

	
	// Accines
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {

    	if(!checkQty())
    		return;
    	if(PagoPosRefunds(this.posPanel)=="")
    		return;
    	
    	MRMA el_rma = new MRMA (posPanel.getCtx(), 0, null);
    	el_rma.setC_Order_ID(posPanel.m_order.get_ID());
    	el_rma.setName("Refund OC:" + posPanel.m_order.getDocumentNo().toString());
    	el_rma.setC_BPartner_ID(posPanel.m_order.getC_BPartner_ID());
    	el_rma.setM_InOut_ID(pIntBuscaInOut(posPanel.m_order.get_ID()));
    	el_rma.setIsSOTrx(true);
    	KeyNamePair kp = (KeyNamePair)this.cbTypeRMA.getSelectedItem();
    	el_rma.setM_RMAType_ID(kp.getKey());
    	el_rma.setC_DocType_ID(149);
    	el_rma.setSalesRep_ID(posPanel.m_order.getSalesRep_ID());
    	el_rma.saveEx();
    	
    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
		{
    		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(i, 0);
    		Double cantidad= Double.parseDouble(m_table_target.getValueAt(i, 2).toString());
    		Double precio = Double.parseDouble(m_table_target.getValueAt(i, 4).toString());
    		int m_inoutline_id = pIntBuscaInOutLine(key.getRecord_ID());

    		MRMALine line = new MRMALine(posPanel.getCtx(), 0, null);
        	line.setM_InOutLine_ID(m_inoutline_id);
        	line.setM_RMA_ID(el_rma.get_ID());
        	line.addDescription(Msg.getMsg(posPanel.m_order.getCtx(), "Refun"));
        
        	line.setQty(BigDecimal.valueOf(cantidad));
        	line.setAmt(BigDecimal.valueOf(precio));
        	
        	line.saveEx();
    		
		}
    	//* Crea la Factura
    	
    	el_rma.completeIt();
    	int el_Invoice= generateInvoice(el_rma.get_ID());
    	posPanel.f_order.printTicketRefund(el_Invoice);
    	this.dispose();

    	
    }
    
    private int generateInvoice(int M_RMA_ID)
    {
        int el_invoice=0;
    	MRMA rma = new MRMA(Env.getCtx(), M_RMA_ID,null);
        
        MInvoice invoice = createInvoice(rma);
        MInvoiceLine invoiceLines[] = createInvoiceLines(rma, invoice);
        
        if (invoiceLines.length == 0)
        {
            log.log(Level.WARNING, "No invoice lines created: M_RMA_ID="
                    + M_RMA_ID + ", M_Invoice_ID=" + invoice.get_ID());
        }
        
        StringBuffer processMsg = new StringBuffer(invoice.getDocumentNo());
        
        if (!invoice.processIt("CO"))
        {
            processMsg.append(" (NOT Processed)");
            log.warning("Invoice Processing failed: " + invoice + " - " + invoice.getProcessMsg());
        }
        
        invoice.saveEx();
        el_invoice=invoice.get_ID();
       return el_invoice; 
    }
    private MInvoice createInvoice(MRMA rma)
    {
        int docTypeId =118; // getInvoiceDocTypeId(rma.get_ID());
            
        if (docTypeId == -1)
        {
            throw new IllegalStateException("Could not get invoice document type for Vendor RMA");
        }
        
        MInvoice invoice = new MInvoice(Env.getCtx(), 0, null);
        invoice.setRMA(rma);
        
        invoice.setC_DocTypeTarget_ID(docTypeId);
        invoice.saveEx();
        
        return invoice;
    }    
    private MInvoiceLine[] createInvoiceLines(MRMA rma, MInvoice invoice)
    {
        ArrayList<MInvoiceLine> invLineList = new ArrayList<MInvoiceLine>();
        
        MRMALine rmaLines[] = rma.getLines(true);
        
        for (MRMALine rmaLine : rmaLines)
        {
            if (rmaLine.getM_InOutLine_ID() == 0)
            {
                throw new IllegalStateException("No customer return line - RMA = " 
                        + rma.getDocumentNo() + ", Line = " + rmaLine.getLine());
            }
            
            MInvoiceLine invLine = new MInvoiceLine(invoice);
            invLine.setRMALine(rmaLine);
            invLine.saveEx();
            invLineList.add(invLine);
        }
        
        MInvoiceLine invLines[] = new MInvoiceLine[invLineList.size()];
        invLineList.toArray(invLines);
        
        return invLines;
    }
    
    private int getInvoiceDocTypeId(int M_RMA_ID)
    {
        String docTypeSQl = "SELECT dt.C_DocTypeInvoice_ID FROM C_DocType dt "
            + "INNER JOIN M_RMA rma ON dt.C_DocType_ID=rma.C_DocType_ID "
            + "WHERE rma.M_RMA_ID=?";
        
        int docTypeId = DB.getSQLValue(null, docTypeSQl, M_RMA_ID);
        
        return docTypeId;
    }


    public boolean checkQty() {
    	
    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
		{

    		String sSql =  "" ;  
            		
    		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(i, 0);
    		Double cantidad= Double.parseDouble(m_table_target.getValueAt(i, 2).toString());
    		BigDecimal elValor = Env.ZERO;
    		int m_inoutline_id = pIntBuscaInOutLine(key.getRecord_ID());
    		sSql = "SELECT SUM(Qty) FROM M_RMALine rl JOIN M_RMA r ON (r.M_RMA_ID = rl.M_RMA_ID) WHERE M_InOutLine_ID = " + m_inoutline_id ;
    	
    		BigDecimal totalQty = DB.getSQLValueBD(null, sSql);
            
            if(totalQty==null)
            	totalQty=Env.ZERO;
            
            MInOutLine  m_ioLine = new MInOutLine (Env.getCtx(), m_inoutline_id, null);
            
            elValor = m_ioLine.getQtyEntered();
            
            
            if( elValor.subtract(totalQty).compareTo(BigDecimal.valueOf(cantidad)) < 0)
            {
            	ADialog.warn(0, this, "Cantidad No Disponible  "+Msg.translate(Env.getCtx(), (m_table_target.getValueAt(i, 1).toString())));
            	return false;
            }
    		
		}

		return true;
	}
    
  /*  
    public boolean checkQtyItem(int m_inoutline_id) {
    	
    		String sSql =  "" ;  
    		BigDecimal elValor = Env.ZERO;
    		sSql = "SELECT SUM(Qty) FROM M_RMALine rl JOIN M_RMA r ON (r.M_RMA_ID = rl.M_RMA_ID) WHERE M_InOutLine_ID = " + m_inoutline_id ;
    	
    		BigDecimal totalQty = DB.getSQLValueBD(null, sSql);
            
            if(totalQty==null)
            {
            	return true;
            }
            
            MInOutLine  m_ioLine = new MInOutLine (Env.getCtx(), m_inoutline_id, null);
            
            elValor = m_ioLine.getQtyEntered();
            
            
            if( elValor.subtract(totalQty).compareTo(BigDecimal.valueOf(cantidad)) < 0)
            {
            	ADialog.warn(0, this, "Cantidad No Disponible  "+Msg.translate(Env.getCtx(), (m_table_target.getValueAt(i, 1).toString())));
            	return false;
            }
    		
		}

		return true;
	}
   */ 
    
	private static int pIntBuscaInOut(int cOrderID) {

	    int InOut_ID=0;
	    
		String sql01 = "Select * from Adempiere.M_INOUT WHERE C_ORDER_ID="+cOrderID;		
		PreparedStatement pstmt01 = null; // FILTRO DE CLIENTE
		try {
			pstmt01 = DB.prepareStatement(sql01, null);
			ResultSet rs01 = pstmt01.executeQuery();
			while (rs01.next())
			{
				  InOut_ID=rs01.getInt("M_INOUT_ID");
				  break;
			}
			DB.close(rs01, pstmt01);
			rs01 = null;
			pstmt01 = null;			
		} catch (SQLException ex) {
			// 	log.log(Level.SEVERE, finalSql, ex);
		}
		return InOut_ID;
	}
	public static int pIntBuscaInOutLine(int valor) {

	    int InOutLine_ID=0;
	    
		String sql01 = "Select * from Adempiere.M_INOUTLINE WHERE c_orderline_id="+valor;		
		PreparedStatement pstmt01 = null; // FILTRO DE CLIENTE
		try {
			pstmt01 = DB.prepareStatement(sql01, null);
			ResultSet rs01 = pstmt01.executeQuery();
			while (rs01.next())
			{
				InOutLine_ID=rs01.getInt("m_inoutline_id");
				  break;
			}
			DB.close(rs01, pstmt01);
			rs01 = null;
			pstmt01 = null;			
		} catch (SQLException ex) {
			// 	log.log(Level.SEVERE, finalSql, ex);
		}
		return InOutLine_ID;
	}
	
	
	
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
      this.dispose();
    }

    private void fieldSourcePOSKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldSourcePOSActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldCashierKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldOrderSourceKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    


    private void btnQtyActionPerformed(java.awt.event.ActionEvent evt) {
    
		boolean bSeleccionoItems = false;
		int c_orderLine_id =0;
		Integer id_m_table=0;
		
	    MProduct m_product=null;
    	String  Name="";
    	Double Qty =new Double(0);
    	Double QtyAvailable =new Double(0);
    	Double QtyRefund =new Double(0);
    	Double el_monto =new Double(0);
    	String C_UOM_ID = "";
    	String C_Tax_ID ="";
    	Double PriceActual = new Double(0);
    	BigDecimal LineNetAmt = new BigDecimal(0);
		int row = m_table.getSelectedRow();
		if (row != -1 )
		{
			Object data = m_table.getModel().getValueAt(row, 0);
			if ( data != null )
			{

				id_m_table = (Integer) ((IDColumn)data).getRecord_ID();
				
				
				bSeleccionoItems=true;
				c_orderLine_id=id_m_table;
				Name =m_table.getValueAt(row, 1).toString();
	        	C_UOM_ID=m_table.getValueAt(row, 3).toString();
	        	PriceActual =Double.parseDouble(m_table.getValueAt(row, 4).toString());
	        	Qty=Double.parseDouble(m_table.getValueAt(row, 2).toString());
	        	QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
	        	QtyAvailable=Qty-QtyRefund;
				
				
			}
		}
		
    	if(bSeleccionoItems)
    	{
    		PosRefundQty dlgQty = new PosRefundQty(this.posPanel,true);

			MOrderLine line = new MOrderLine(Env.getCtx(), c_orderLine_id, null);
			if ( line != null )
			{
			  
				m_product = MProduct.get(Env.getCtx(), line.getM_Product_ID());
				if (m_product.get_ID() == 0)
					m_product = null;
			}
			//	Set String Info
			if (m_product != null)
			{
		    	dlgQty.getfieldQtyAvalible().setValue(QtyAvailable);   
	    	
				
				dlgQty.getfieldProductName().setText(m_product.getName());
				dlgQty.getfieldProductName().setToolTipText(m_product.getDescription());
				dlgQty.getfieldProductName().setText(m_product.getName().trim()+" / "+ line.getQtyOrdered().setScale(2) +" / "+m_product.getUOMSymbol().trim() +" / " +line.getPriceActual().setScale(2));

		        MImage la_imagen = MImage.get(Env.getCtx(),m_product.get_ValueAsInt("AD_Image_ID"));
		        if(la_imagen.get_ID()==0 )
		        {
		        
		        	MClientInfo la_organizacion = MClientInfo.get(Env.getCtx(),Env.getAD_Client_ID(Env.getCtx()),null);
		        	la_imagen = MImage.get(Env.getCtx() ,la_organizacion.get_ValueAsInt("logo_id"));
		        }
		        if(la_imagen.get_ID()!=0 )
		        {
		        	dlgQty.getbtnImagen().setIcon(new ImageIcon(la_imagen.getImage().getScaledInstance(dlgQty.getbtnImagen().getWidth(),dlgQty.getbtnImagen().getHeight(), Image.SCALE_DEFAULT)));
		        }
			
			}
			
			
			// calcula nro items
			
			
			dlgQty.getfieldQtyAvalible().setText(QtyAvailable.toString());
			dlgQty.getfieldQtyAvalible().setValue(Double.parseDouble(QtyAvailable.toString()));
			if(Double.parseDouble(QtyAvailable.toString())==0)
			{
				 JOptionPane.showMessageDialog(null,Msg.getMsg(Env.getCtx(),"Not have Item Avalible!!!"));
				return;
			}
			AEnv.showCenterWindow(this.posPanel.getm_frame(), dlgQty);
			if(dlgQty.getisRefundQty())
			{
				if(findLine(c_orderLine_id)) // ya existe el producto en el target
				{
			    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
					{
			    		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(i, 0);		
						if ( key.getRecord_ID()==c_orderLine_id)
						{
							
						
							Double QtyRefundTarget = Double.valueOf(dlgQty.getfieldQtytoRefund().getValue().toString());
							QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
							m_table.setValueAt(QtyRefundTarget+QtyRefund, row,7);
							m_table_target.setValueAt(QtyRefundTarget+QtyRefund, i,2);
							el_monto= (QtyRefundTarget+QtyRefund)*PriceActual;
							m_table_target.setValueAt(el_monto, i,5);
							
							
							break;
						}
					}
					
				}
				else
				{
					Qty=Double.valueOf(dlgQty.getfieldQtytoRefund().getValue().toString());
					
					DefaultTableModel model_target = (DefaultTableModel)m_table_target.getModel();


					
					Double QtyRefundTarget = Qty;
					QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
					m_table.setValueAt(QtyRefundTarget+QtyRefund, row,7);
					Object data = m_table.getModel().getValueAt(row, 0);
					el_monto= (QtyRefundTarget+QtyRefund)*PriceActual;			
				//	LineNetAmt = LineNetAmt.add(LineNetAmt.multiply(BigDecimal.valueOf(Qty)).multiply(PriceActual));
		        	model_target.addRow(new Object[] {data,Name,Qty,C_UOM_ID,PriceActual,el_monto,C_Tax_ID});  
				}
			
				fActualizaMontoRefund();
			}
    	}
    }

    private boolean findLine(int c_orderLine_id) {
    	
    	boolean bRetorno=false;
    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
		{
    		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(i, 0);		
			if ( key.getRecord_ID()==c_orderLine_id)
			{
				bRetorno=true;
				break;
			}
		}
		return bRetorno;
	}
	private void btnWholeLineActionPerformed(java.awt.event.ActionEvent evt) {
		int row = m_table.getSelectedRow();
		if (row != -1 )
		{   
			Object data = m_table.getModel().getValueAt(row, 0);
			if ( data != null )
			{
				
	   /* 		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(row, 0);
	    		BigDecimal elValor = Env.ZERO;
	    		int m_inoutline_id = pIntBuscaInOutLine(key.getRecord_ID());
				
	    		if(!checkQtyItem(m_inoutline_id))
	    		{
	    			JOptionPane.showMessageDialog(null,Msg.getMsg(Env.getCtx(),"Not have Item Avalible!!!"));
	    			return;
	    		}
	    			
				*/
				
				Double Qty=Double.parseDouble(m_table.getValueAt(row, 2).toString());
	        	Double QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
	        	Double QtyAvailable=Qty-QtyRefund;
				Double PriceActual = Double.parseDouble(m_table.getValueAt(row, 4).toString());
				
				Double el_monto = new Double(0);
				
				if(Double.parseDouble(QtyAvailable.toString())==0)
				{
				  JOptionPane.showMessageDialog(null,Msg.getMsg(Env.getCtx(),"Not have Item Avalible!!!"));
				}
				else
				{
					int c_orderLine_id= ((IDColumn)data).getRecord_ID();
					if(findLine(c_orderLine_id)) // ya existe el producto en el target
					{
				    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
						{
				    		IDColumn key = (IDColumn) m_table_target.getModel().getValueAt(i, 0);		
							if ( key.getRecord_ID()==c_orderLine_id)
							{
								
								QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
								m_table.setValueAt(QtyAvailable+QtyRefund, row,7);
								
								el_monto=(QtyAvailable+QtyRefund)*PriceActual;
								
								m_table_target.setValueAt(QtyAvailable+QtyRefund, i,2);
								m_table_target.setValueAt(el_monto, i,5);
								
								
								
								break;
							}
						}
						
					}
					else
					{

						String Name =m_table.getValueAt(row, 1).toString();
			        	String C_UOM_ID=m_table.getValueAt(row, 3).toString();
			        	String C_Tax_ID ="";
						DefaultTableModel model_target = (DefaultTableModel)m_table_target.getModel();
						
						Double QtyRefundTarget = Qty;
						QtyRefund=Double.parseDouble(m_table.getValueAt(row, 7).toString());
						m_table.setValueAt(QtyRefundTarget+QtyRefund, row,7);
						el_monto=(QtyAvailable+QtyRefund)*PriceActual;						
			        	model_target.addRow(new Object[] {data,Name,Qty,C_UOM_ID,PriceActual,el_monto,C_Tax_ID});  
					}
				}
				fActualizaMontoRefund();
			}
		}
    }

    private void btnRetuenLineActionPerformed(java.awt.event.ActionEvent evt) {
		int row = m_table_target.getSelectedRow();
		if (row != -1 )
		{
			Object data = m_table_target.getModel().getValueAt(row, 0);
			int c_orderLine_id= ((IDColumn)data).getRecord_ID();
			if ( data != null )
			{
		    	for ( int i = 0; i < m_table.getRowCount(); i ++ )
				{
		    		IDColumn key = (IDColumn) m_table.getModel().getValueAt(i, 0);		
					if ( key.getRecord_ID()==c_orderLine_id)
					{
						m_table.setValueAt(0, i,7);
						
						DefaultTableModel model = (DefaultTableModel) this.m_table_target.getModel();
					    model.removeRow(row);

					    // actualizar los montos
						break;
					}
				}
		    	fActualizaMontoRefund();

			}
		}
    }
	
	private void fActualizaMontoRefund() {
		Double Monto= new Double(0);
		Double cantidad= new Double(0);
		Double precio = new Double(0);
		Double el_total= new Double(0);
		
    	for ( int i = 0; i < m_table_target.getRowCount(); i ++ )
		{
    		
    		cantidad= Double.parseDouble(m_table_target.getValueAt(i, 2).toString());
    		precio = Double.parseDouble(m_table_target.getValueAt(i, 4).toString());
    	    Monto= cantidad*precio;
    	    
    	    el_total=el_total+Monto;
    		
		}
    	this.fieldAmountRefund.setText(el_total.toString());

		
	}
	private Object[] FillRMAType()
	{
		ArrayList<KeyNamePair> list = new ArrayList<KeyNamePair>();
		KeyNamePair[] retValue = new KeyNamePair[0];
		
		String sqlt = "SELECT m_rmatype_id,NAME "
			+ " FROM m_rmatype "
			+ " WHERE  IsActive = 'Y' ";
	//	sqlt = MRole.getDefault().addAccessSQL(sqlt, "M_RMA", MRole.SQL_NOTQUALIFIED, MRole.SQL_RO);
		PreparedStatement pstmtt = DB.prepareStatement(sqlt, null);
		try
		{
			ResultSet rst = pstmtt.executeQuery();
			while (rst.next())
			{
				list.add(new KeyNamePair(rst.getInt("m_rmatype_id"),rst.getString("NAME")));
			}
			retValue = new KeyNamePair[list.size()];
			list.toArray(retValue);
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, "", e);
			return retValue;
		}	

        return retValue;
	}	
	public void valueChanged(ListSelectionEvent e) {
		if ( e.getValueIsAdjusting() )
			return;

		int row = m_table.getSelectedRow();
		if (row != -1 )
		{
			Object data = m_table.getModel().getValueAt(row, 0);
			if ( data != null )
			{
				m_table.setRowSelectionInterval(row,row);
				Integer id = (Integer) ((IDColumn)data).getRecord_ID();
			}
		}

		
	}
	
// Forma de Pago Devolucion
	private String  PagoPosRefunds(PosBasePanel posPanel)
	{
		String sRetorno ="";
		int C_BankStatement_ID = getBankStatement(posPanel);
		try 
		
		{

			PosPago_Pagos PosPago = new PosPago_Pagos(posPanel,true);
			PosPago.setResizable(false);
			PosPago.setTitle("Payment Order Refunds");
			PosPago.setResizable(false);
				
					
			PosPago.getdtSubtotal().setText(fieldAmountRefund.getText());
			PosPago.getdtSubtotal().setValue(Double.parseDouble(fieldAmountRefund.getText()));
					
					
			PosPago.getdtGrandtotal().setText(fieldAmountRefund.getText());
			PosPago.getdtGrandtotal().setValue(Double.parseDouble(fieldAmountRefund.getText()));
					
			
			PosPago.getdtTaxamount().setVisible(false);
			
			PosPago.getlblTaxamount().setVisible(false);
					
			PosPago.getdtPago().setText("0,00");
			PosPago.getdtPago().setValue(0);
			PosPago.setd_dtGrandtotal(Double.parseDouble(fieldAmountRefund.getText()));

			AEnv.showCenterWindow(posPanel.getm_frame(), PosPago);		
					// Aqui el Cierre y Ticket
			if (PosPago.getbPosPagoOK())
			{

				sRetorno="OK";
				if(PosPago.getd_dtCash()!=0)
			       posPanel.m_order.payCash(BigDecimal.valueOf(PosPago.getd_dtCash()),C_BankStatement_ID);
						
						if(PosPago.getd_dtCheck()!=0) 
						{
							DefaultTableModel model_local = (DefaultTableModel)PosPago.getT_Data_Cheque().getModel();
					        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++)
					        							        {
						    		String routingno = model_local.getValueAt(iPos, 1).toString();
						    		String accountno = model_local.getValueAt(iPos, 2).toString();
						    		String checkno = model_local.getValueAt(iPos, 3).toString();
						    		Double payamt; 
						    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
						    		if(!(posPanel.m_order.payCheck(BigDecimal.valueOf(payamt).negate(), accountno, routingno, checkno,C_BankStatement_ID)))
						    		{
										ADialog.warn(0, posPanel, "PosOrderProcessFailed");
										return "Error Cheque";
						    		}
						        } 
							
						}
						if(PosPago.getd_dtCcard()!=0)
						{
					        DefaultTableModel model_local = (DefaultTableModel)PosPago.getT_Data_T_Credito().getModel();
					        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
					        {
					    		Object CreditCard = model_local.getValueAt(iPos, 1);
					    		ValueNamePair vp = (ValueNamePair)CreditCard;
					    		String PaymentRule = vp.getValue();
					    		String number =  model_local.getValueAt(iPos, 2).toString();
					    		String name =  model_local.getValueAt(iPos, 3).toString();
					    		String Expires =  model_local.getValueAt(iPos, 4).toString();
					    		String CVC = model_local.getValueAt(iPos, 5).toString();
					    		String mmStr = Expires.trim().substring(0,2);
					    		String yyStr = Expires.trim().substring(2);
					    		Double payamt; 
					    		payamt = Double.parseDouble( model_local.getValueAt(iPos,6).toString().toString());
					    		if(!(posPanel.m_order.payCreditCard(BigDecimal.valueOf(payamt).negate(), name,Integer.parseInt(mmStr),Integer.parseInt(yyStr), number, CVC,PaymentRule,C_BankStatement_ID)))
					    		{
									ADialog.warn(0, posPanel, "PosOrderProcessFailed");
									return "Error Credit Card";	
					    		}
					        }   
							
						}


					}


		}

		catch (Exception e) 
			{
			  JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "this order cannot be payed Refunds!!!"));
			  sRetorno="";
			}
	   return sRetorno;
	}
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
	
	private class sincorinza extends Applet implements Runnable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private sincorinza () { // Constructor no siempre necesario
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
