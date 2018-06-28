package org.compiere.pos;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.swing.CDialog;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings("unused")
public class PosPaymentDebitCard  extends CDialog implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosPaymentDebitCard.class);
	private PosBasePanel posPanel;
	private boolean bAcepto = false;
	private boolean bEdicion=false;
	private int RowEdit =0;	
    private String			m_sql;
	private static String s_sqlWhere = "c_payment_id=? ";    
	private static String s_sqlFrom = "c_payment";	
	private double dt_dtSumamount;
	private DecimalFormat df = new DecimalFormat("#.##");
	   // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chEditpayment;
    private PosTextField  dtAccountno;
    private PosTextField  dtAmount;
    private javax.swing.JFormattedTextField dtBalance;
    private PosTextField  dtCheckno;
    private javax.swing.JFormattedTextField dtGrandtotal;
    private javax.swing.JFormattedTextField dtPaymentamount;
    private PosTextField  dtRoutingno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccountno;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblPaymentamount;
    private javax.swing.JLabel lblRoutingno;
    private javax.swing.JLabel lblTendertype;
    private javax.swing.JLabel lblcheckno;
    private PosTable m_table;
    private javax.swing.JPanel panelDetalle;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTotales;
    private javax.swing.JLabel lblSumamount;
    private javax.swing.JFormattedTextField dtSumAmont;
    // End of variables declaration	
	public PosPaymentDebitCard (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "Pago Tarjeta de Debito"), true);
		this.posPanel = posPanel;
		init();
		setEditable(false);
		this.lblBalance.setVisible(false);
		this.dtBalance.setVisible(false);

		
	}    

	private void setEditable(boolean bAccion) {
	    
	    
	    btnCancelUpdate.setEnabled(bAccion);
	    btnUpdate.setEnabled(bAccion);
	    dtAccountno.setEnabled(bAccion);
	    dtAmount.setEnabled(bAccion);
	    dtCheckno.setEnabled(bAccion);
	    dtRoutingno.setEnabled(bAccion);;
		
	}

	private void init() 
	{
		initComponents();

	}	
	
	
	private static ColumnInfo[] s_layout = new ColumnInfo[] 
	{
		new ColumnInfo(" ", "C_Payment_ID", IDColumn.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "Identificacion No"), "routingno", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Cuenta No"), "accountno", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Tarjeta No"), "checkno", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Monto"), "payamt", Double.class),

	};	
    private void initComponents() {

        lblSumamount = new javax.swing.JLabel();
        dtSumAmont = new javax.swing.JFormattedTextField();
        panelTotales = new javax.swing.JPanel();
        lblGrandtotal = new javax.swing.JLabel();
        dtGrandtotal = new javax.swing.JFormattedTextField();
        lblBalance = new javax.swing.JLabel();
        dtBalance = new javax.swing.JFormattedTextField();
        lblPaymentamount = new javax.swing.JLabel();
        dtPaymentamount = new javax.swing.JFormattedTextField();
        panelDetalle = new javax.swing.JPanel();
        lblRoutingno = new javax.swing.JLabel();
        lblAccountno = new javax.swing.JLabel();
        lblcheckno = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        
        dtRoutingno =new PosTextField(Msg.translate(Env.getCtx(), "Identificacion No"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        dtAccountno = new PosTextField(Msg.translate(Env.getCtx(), "Cuenta No"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        dtCheckno = new PosTextField(Msg.translate(Env.getCtx(), "Tarjeta No"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        dtAmount = new PosTextField(Msg.translate(Env.getCtx(), "Monto"), posPanel, posPanel.p_pos.getOSNP_KeyLayout_ID(),  DisplayType.getNumberFormat(DisplayType.Amount));
        
        
        jSeparator1 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancelUpdate = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        m_table = new PosTable();
        btnDelete = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTendertype = new javax.swing.JLabel();
        chEditpayment = new javax.swing.JCheckBox();

        
		CScrollPane scroll_m_table = new CScrollPane(m_table);
		m_sql = m_table.prepareTable (s_layout, s_sqlFrom, 
				s_sqlWhere, false, "c_payment")
				+ " ORDER BY c_payment_id";
        
		m_table.setColumnVisibility(m_table.getColumn(0), false);
		m_table.getColumn(1).setPreferredWidth(150);
		m_table.getColumn(2).setPreferredWidth(150);
		m_table.getColumn(3).setPreferredWidth(150);
		m_table.getColumn(4).setPreferredWidth(150);
		m_table.setFocusable(false);
		m_table.setFillsViewportHeight( true ); //@Trifon
		m_table.growScrollbars();  
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTotales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblGrandtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandtotal.setText("Total Orden");

        dtGrandtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtGrandtotal.setText("0");
        dtGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtGrandtotal.setEditable(false);

        lblBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblBalance.setText("Balance");

        dtBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtBalance.setText("0");

        dtBalance.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        
        lblPaymentamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPaymentamount.setText("Monto a Cancelar");

        dtPaymentamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPaymentamount.setText("0");
        dtPaymentamount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtPaymentamount.setEditable(false);

        javax.swing.GroupLayout panelTotalesLayout = new javax.swing.GroupLayout(panelTotales);
        panelTotales.setLayout(panelTotalesLayout);
        panelTotalesLayout.setHorizontalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGrandtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtGrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPaymentamount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTotalesLayout.setVerticalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtPaymentamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentamount)
                    .addComponent(dtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance)
                    .addComponent(dtGrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrandtotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRoutingno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblRoutingno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRoutingno.setText("Identificacion No");

        lblAccountno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAccountno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountno.setText("        Cuenta No");

        lblcheckno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblcheckno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblcheckno.setText("Tarjeta No");

        lblAmount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmount.setText("Monto");

        dtRoutingno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtRoutingno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtAccountno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtAccountno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtCheckno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtCheckno.setText("");
        dtCheckno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        dtAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtAmount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        btnAdd.setIcon(Env.getImageIcon("New24.gif")); 
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(Env.getImageIcon("Assignment24.gif")); 
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancelUpdate.setIcon(Env.getImageIcon("Ignore24.gif"));
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetalleLayout = new javax.swing.GroupLayout(panelDetalle);
        panelDetalle.setLayout(panelDetalleLayout);
        panelDetalleLayout.setHorizontalGroup(
            panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalleLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnCancelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetalleLayout.createSequentialGroup()
                        .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAmount)
                            .addComponent(lblcheckno)
                            .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblRoutingno)
                                .addComponent(lblAccountno)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtAccountno)
                            .addComponent(dtCheckno)
                            .addComponent(dtAmount)
                            .addComponent(dtRoutingno, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(14, 14, 14))
        );

        panelDetalleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnCancelUpdate, btnUpdate});

        panelDetalleLayout.setVerticalGroup(
            panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoutingno)
                    .addComponent(dtRoutingno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountno)
                    .addComponent(dtAccountno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcheckno)
                    .addComponent(dtCheckno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(dtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelDetalleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnCancelUpdate, btnUpdate});

        panelTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));



        btnDelete.setIcon(Env.getImageIcon("Delete24.gif")); 
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_m_table, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_m_table, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTablaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnDelete, btnProcess});

        lblTendertype.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTendertype.setText(Msg.translate(Env.getCtx(), "Tarjeta de Debito"));

        chEditpayment.setText("Editar Linea");
        chEditpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chEditpaymentActionPerformed(evt);
            }
        });
        lblSumamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblSumamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSumamount.setText("Sumatoria");

        dtSumAmont.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtSumAmont.setText("0");
        dtSumAmont.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtSumAmont.setEditable(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblTendertype)
                                .addGap(77, 77, 77)
                                .addComponent(chEditpayment))
                            .addComponent(panelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblSumamount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtSumAmont, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTendertype)
                    .addComponent(chEditpayment)
                    .addComponent(lblSumamount)
                    .addComponent(dtSumAmont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelDetalle, panelTabla});

        pack();
    }// </editor-fold>

    private void m_tableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void chEditpaymentActionPerformed(java.awt.event.ActionEvent evt) {
    	if(bEdicion)
    	{
    		chEditpayment.setSelected(true);
    		return;
    	}
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
        if (model_local.getColumnCount()>0)
        {
             int[] selectedRow = m_table.getSelectedRows();
             
             for (int i = 0; i < selectedRow.length; i++) {
                  
            	 
         		String routingno = model_local.getValueAt(selectedRow[i], 1).toString();
         		String accountno = model_local.getValueAt(selectedRow[i], 2).toString();
         		String checkno = model_local.getValueAt(selectedRow[i], 3).toString();
         		Double payamt; 
         		payamt = Double.parseDouble(model_local.getValueAt(i, 4).toString());
         		this.dtRoutingno.setText(routingno);
         		this.dtAccountno.setText(accountno);
         		this.dtCheckno.setText(checkno);
         		this.dtAmount.setValue(payamt);
         		this.dtAmount.setText(model_local.getValueAt(i, 4).toString());
         		bEdicion=true;
         		RowEdit=selectedRow[i];
            	setEditable(true);
            	btnAdd.setEnabled(false);
            	this.dtRoutingno.requestFocus();
            	this.chEditpayment.setSelected(true);
         		break;
             }

        }  

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
	    this.dtRoutingno.setText("");
		this.dtAccountno.setText("");
		this.dtCheckno.setText("");
		this.dtAmount.setValue(0);
		this.dtAmount.setText("");
    	setEditable(true);
    	btnAdd.setEnabled(false);
    	this.dtRoutingno.requestFocus();
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:  PREVIA VALIDACION
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
    	Object IDColumn;

    	IDColumn C_Payment_ID = null ;
		String routingno = this.dtRoutingno.getText();
		String accountno = this.dtAccountno.getText();
		String checkno = this.dtCheckno.getText();
		Double payamt; 
		payamt = Double.parseDouble(this.dtAmount.getValue().toString());
		if(this.bEdicion)
		{
			this.bEdicion=false;
			this.chEditpayment.setSelected(false);
			model_local.setValueAt(C_Payment_ID, this.RowEdit, 0);
			model_local.setValueAt(routingno, this.RowEdit, 1);
			model_local.setValueAt(accountno, this.RowEdit, 2);
			model_local.setValueAt(checkno, this.RowEdit, 3);
			model_local.setValueAt(payamt, this.RowEdit, 4);
		}
		else
		{
			model_local.addRow(new Object[] {C_Payment_ID,routingno,accountno,checkno,payamt});	
		}
    	
    	setEditable(false);
    	btnAdd.setEnabled(true);
	    this.dtRoutingno.setText("");
		this.dtAccountno.setText("");
		this.dtCheckno.setText("");
		this.dtAmount.setValue(0);
		this.dtAmount.setText("");    	
    	setActualizaSaldos();
    }

    private void setActualizaSaldos() {
    	Double payamt =(double) 0;
    	Double Qty;
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
    	for ( int i = 0; i < m_table.getRowCount(); i ++ )
		{
    		
    		Qty = Double.parseDouble(model_local.getValueAt(i, 4).toString());
    		payamt=payamt+Qty;
		}

    	this.dtSumAmont.setValue(payamt);
    	this.dt_dtSumamount=payamt;
    	this.dtSumAmont.setText(df.format(payamt));
    	
		
	}

	private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		this.bEdicion=false;
		this.chEditpayment.setSelected(false);
	    this.dtRoutingno.setText("");
		this.dtAccountno.setText("");
		this.dtCheckno.setText("");
		this.dtAmount.setValue(0);
		this.dtAmount.setText("");    
		setEditable(false);
    	btnAdd.setEnabled(true);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
    	if(bEdicion)
    	{
    		return;
    	}
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
        if (model_local.getColumnCount()>0)
        {
             int[] selectedRow = m_table.getSelectedRows();
             
             for (int i = 0; i < selectedRow.length; i++) {
                  
            	 model_local.removeRow(selectedRow[i]);
             }
             setActualizaSaldos();
        }  
    }

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	this.bAcepto=true;
    	this.dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	this.bAcepto=false;
    	this.dispose();
    	
    }	
    public javax.swing.JFormattedTextField getdtGrandtotal()
    {
    	return dtGrandtotal;
    }
    public javax.swing.JFormattedTextField getdtPaymentamount()
    {
    	return this.dtPaymentamount;
    }

    public javax.swing.JFormattedTextField getdtSumAmont()
    {
    	return this.dtSumAmont;
    }

    
    public PosTable getm_table()
    {
    	return m_table;
    }
    public boolean getbAcepto()
    {
    	return this.bAcepto;
    }
    public double getdt_dtSumamount()
    {
    	return dt_dtSumamount;
    }
    
}
