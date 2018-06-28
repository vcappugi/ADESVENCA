package org.compiere.pos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.swing.CDialog;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

public class PosPaymenGifCard  extends CDialog implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosPaymenGifCard.class);
	private PosBasePanel posPanel;
	private boolean bAcepto = false;
	private boolean bEdicion=false;
	private int RowEdit =0;
	// variables de calculos
	@SuppressWarnings("unused")
	private double dt_Paymentamount;
	private double dt_dtSumamount;
	
	private DecimalFormat df = new DecimalFormat("#.##");
	@SuppressWarnings("unused")
	private String			m_sql;
	private static String s_sqlWhere = "c_payment_id=? ";    
	private static String s_sqlFrom = "c_payment";	
	
	   // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chEditpayment;
    private javax.swing.JFormattedTextField dtBalance;

    private javax.swing.JFormattedTextField dtGrandtotal;
    private PosTextField dtName;
    private PosTextField dtNumber;
    private javax.swing.JFormattedTextField dtPaymentamount;
    private PosTextField dtTenderamount;
    private javax.swing.JTextField dtSumamount;
    private javax.swing.JLabel lblSumamout;
    private javax.swing.JPanel jPanel1;

    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblPaymentamount;
    private javax.swing.JLabel lblTenderamount;
    private javax.swing.JLabel lblTendertype;
    private PosTable m_table;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTotales;
    // End of variables declaration	
	public PosPaymenGifCard (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosPaymenGifCard"), true);
		this.posPanel = posPanel;
		init();

		setEditable(false);
		this.lblBalance.setVisible(false);
		this.dtBalance.setVisible(false);

		
	}    

	private void setEditable(boolean bAccion) {
	    btnCancelUpdate.setEnabled(bAccion);
	    btnUpdate.setEnabled(bAccion);
	    this.dtName.setEnabled(bAccion);
	    this.dtNumber.setEnabled(bAccion);
	    this.dtTenderamount.setEnabled(bAccion);
	}

	private void init() 
	{
		initComponents();

	}	
	
	
	private static ColumnInfo[] s_layout = new ColumnInfo[] 
	{
		new ColumnInfo(" ", "C_Payment_ID", IDColumn.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "Number"), "creditcardnumber", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Name"), "Name", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Payment Amount"), "payamt", Double.class),
	};	

    private void initComponents() {

        lblTendertype = new javax.swing.JLabel();
        chEditpayment = new javax.swing.JCheckBox();
        lblSumamout = new javax.swing.JLabel();
        dtSumamount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblNumber = new javax.swing.JLabel();
        dtNumber =new PosTextField(Msg.translate(Env.getCtx(), "number"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        lblName = new javax.swing.JLabel();
        dtName =  new PosTextField(Msg.translate(Env.getCtx(), "name"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        lblTenderamount = new javax.swing.JLabel();
        dtTenderamount = new  PosTextField(Msg.translate(Env.getCtx(), "Tenderamount"), this.posPanel, this.posPanel.p_pos.getOSNP_KeyLayout_ID(),  DisplayType.getNumberFormat(DisplayType.Amount));
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnCancelUpdate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();

        m_table = new PosTable();
        btnDelete = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        panelTotales = new javax.swing.JPanel();
        lblGrandtotal = new javax.swing.JLabel();
        dtGrandtotal = new javax.swing.JFormattedTextField();
        lblBalance = new javax.swing.JLabel();
        dtBalance = new javax.swing.JFormattedTextField();
        lblPaymentamount = new javax.swing.JLabel();
        dtPaymentamount = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTendertype.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTendertype.setText(Msg.translate(Env.getCtx(), "Gif Card"));

        chEditpayment.setText("Edit payment");
        chEditpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chEditpaymentActionPerformed(evt);
            }
        });

        lblSumamout.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSumamout.setText("Sum Amount");

        dtSumamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtSumamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumber.setText("Number");

        dtNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtNumber.setText(" ");

        lblName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name");

        dtName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtName.setText(" ");

        lblTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTenderamount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenderamount.setText("Tender amount");

        dtTenderamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtTenderamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        btnCancelUpdate.setIcon(Env.getImageIcon("Ignore24.gif"));
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(Env.getImageIcon("Assignment24.gif")); 
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(Env.getImageIcon("New24.gif")); 
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumber)
                            .addComponent(lblName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtName)
                            .addComponent(dtNumber)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTenderamount)
                        .addGap(18, 18, 18)
                        .addComponent(dtTenderamount)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtTenderamount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenderamount))
                .addGap(76, 76, 76)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


		CScrollPane scroll_m_table = new CScrollPane(m_table);
		m_sql = m_table.prepareTable (s_layout, s_sqlFrom, 
				s_sqlWhere, false, "c_payment")
				+ " ORDER BY c_payment_id";
		
		m_table.setColumnVisibility(m_table.getColumn(0), false);
		m_table.getColumn(1).setPreferredWidth(100);
		m_table.getColumn(2).setPreferredWidth(150);
		m_table.getColumn(3).setPreferredWidth(185);

		m_table.setFocusable(false);
		m_table.setFillsViewportHeight( true ); //@Trifon
		m_table.growScrollbars();  
		
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
                    .addComponent(scroll_m_table)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_m_table, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTotales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblGrandtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGrandtotal.setText("Grad Total");

        dtGrandtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtGrandtotal.setText("0");
        dtGrandtotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lblBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblBalance.setText("Balance");

        dtBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtBalance.setText("0");

        lblPaymentamount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPaymentamount.setText("Payment Amount");

        dtPaymentamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPaymentamount.setText("0");
        dtPaymentamount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(lblPaymentamount)
                .addGap(54, 54, 54)
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
                                .addComponent(lblTendertype)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chEditpayment))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblSumamout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtSumamount, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtSumamount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSumamout)
                    .addComponent(chEditpayment)
                    .addComponent(lblTendertype))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
	
	
    @SuppressWarnings("unused")
	protected void chEditpaymentActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
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
                  
            	
         		String number =  model_local.getValueAt(selectedRow[i], 1).toString();
         		String name =  model_local.getValueAt(selectedRow[i], 2).toString();
         		Double payamt; 
         		payamt = Double.parseDouble(  model_local.getValueAt(selectedRow[i], 3).toString());
         		this.dtNumber.setText(number);
         		this.dtName.setText(name);
         		this.dtTenderamount.setText(model_local.getValueAt(selectedRow[i], 3).toString());
         		this.dtTenderamount.setValue(payamt);
         		bEdicion=true;
         		RowEdit=selectedRow[i];
            	setEditable(true);
            	btnAdd.setEnabled(false);
            	this.chEditpayment.setSelected(true);
         		break;
             }

        }  
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
		this.dtNumber.setText("");
		this.dtName.setText("");
		this.dtTenderamount.setValue(0);
		this.dtTenderamount.setText("");

    	setEditable(true);
    	btnAdd.setEnabled(false);
    	this.dtNumber.requestFocus();
    }

    @SuppressWarnings("unused")
	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:  PREVIA VALIDACION
    	// Expires
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
    	Object IDColumn;
    	IDColumn C_Payment_ID = null ;
		String number = this.dtNumber.getText();
		String name = this.dtName.getText();
		Double payamt; 
		payamt = Double.parseDouble(this.dtTenderamount.getValue().toString());
		if(this.bEdicion)
		{
			this.bEdicion=false;
			this.chEditpayment.setSelected(false);
			model_local.setValueAt(C_Payment_ID, this.RowEdit, 0);
			model_local.setValueAt(number, this.RowEdit, 1);
			model_local.setValueAt(name, this.RowEdit, 2);
			model_local.setValueAt(payamt, this.RowEdit, 3);
			
		}
		else
		{
		
    	   model_local.addRow(new Object[] {C_Payment_ID,number,name,payamt});
		}
    	setEditable(false);
    	btnAdd.setEnabled(true);
		this.dtNumber.setText("");
		this.dtName.setText("");
		this.dtTenderamount.setValue(0);
		this.dtTenderamount.setText("");
    	setActualizaSaldos();
    }

    private void setActualizaSaldos() {
    	Double payamt =(double) 0;
    	Double Qty;
    	DefaultTableModel model_local = (DefaultTableModel) m_table.getModel();
    	for ( int i = 0; i < m_table.getRowCount(); i ++ )
		{
    		
    		Qty = Double.parseDouble(model_local.getValueAt(i, 3).toString());
    		payamt=payamt+Qty;
		}
        this.dtSumamount.setText(df.format(payamt));
        dt_dtSumamount=payamt;
		
	}

	private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		this.dtNumber.setText("");
		this.dtName.setText("");
		this.dtTenderamount.setValue(0);
		this.dtTenderamount.setText("");
		this.bEdicion=false;
		this.chEditpayment.setSelected(false);
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

    public javax.swing.JTextField getdtSumAmont()
    {
    	return this.dtSumamount;
    }

    public double getdt_dtSumamount()
    {
    	return dt_dtSumamount;
    }
    
    public PosTable getm_table()
    {
    	return m_table;
    }
    public boolean getbAcepto()
    {
    	return this.bAcepto;
    }

	@SuppressWarnings("unused")
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
