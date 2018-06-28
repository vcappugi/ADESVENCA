package org.compiere.pos;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MRole;
import org.compiere.model.MUser;


import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;

@SuppressWarnings("unused")
public class PosTransferOrder extends CDialog implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static CLogger log = CLogger.getCLogger(PosTransferOrder.class);
	private PosBasePanel posPanel;
	private Timestamp			m_today = Env.getContextAsDate(Env.getCtx(), "#Date");
	
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnProcess;
    private javax.swing.JTextField fieldCashier;
    private javax.swing.JFormattedTextField fieldCurrentDate;
    private javax.swing.JFormattedTextField fieldHours;
    private javax.swing.JTextField fieldOrderSource;
    private javax.swing.JComboBox fieldPOSTarget;
    private javax.swing.JTextField fieldSourcePOS;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCashier;
    private javax.swing.JLabel lblCurrenDate;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblPOSSource;
    private javax.swing.JLabel lblPosTarget;
    private javax.swing.JLabel lblTranferOrder;	
	private int toPos = 0 ;
	sincorinza refrescar ;
	
	
	public PosTransferOrder (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "PosTransferOrder"), true);
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

        lblTranferOrder = new javax.swing.JLabel();
        lblHours = new javax.swing.JLabel();
        fieldHours = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblCashier = new javax.swing.JLabel();
        fieldCashier = new javax.swing.JTextField();
        lblPOSSource = new javax.swing.JLabel();
        fieldOrderSource = new javax.swing.JTextField();
        lblCurrenDate = new javax.swing.JLabel();
        fieldCurrentDate = new javax.swing.JFormattedTextField();
        lblPosTarget = new javax.swing.JLabel();
        fieldPOSTarget = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        fieldSourcePOS = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        this.fieldCurrentDate.setValue(m_today);
        this.fieldHours.setText(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
        
        
        this.fieldCashier.setText((Env.getCtx().getProperty("#AD_User_Name")).toUpperCase());
        
        this.fieldOrderSource.setText(this.posPanel.m_order.getDocumentNo());
        this.fieldSourcePOS.setText(this.posPanel.p_pos.getName());


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblTranferOrder.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTranferOrder.setText("Tansfer Order");
        getContentPane().add(lblTranferOrder);
        lblTranferOrder.setBounds(10, 11, 120, 24);

        lblHours.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblHours.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHours.setText("Hours");
        getContentPane().add(lblHours);
        lblHours.setBounds(380, 10, 90, 30);

        fieldHours.setEditable(false);
        fieldHours.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldHours.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        fieldHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldHours.setText("07:17:09 PM");
        fieldHours.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldHours);
        fieldHours.setBounds(480, 10, 110, 26);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 150, 594, 10);

        lblCashier.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCashier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCashier.setText("Cashier Name");
        getContentPane().add(lblCashier);
        lblCashier.setBounds(0, 70, 110, 30);

        fieldCashier.setEditable(false);
        fieldCashier.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldCashier.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldCashier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldCashier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCashierKeyPressed(evt);
            }
        });
        getContentPane().add(fieldCashier);
        fieldCashier.setBounds(130, 70, 460, 30);

        lblPOSSource.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPOSSource.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPOSSource.setText("POS");
        getContentPane().add(lblPOSSource);
        lblPOSSource.setBounds(10, 110, 100, 30);

        fieldOrderSource.setEditable(false);
        fieldOrderSource.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldOrderSource.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldOrderSource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldOrderSource.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldOrderSourceKeyPressed(evt);
            }
        });
        getContentPane().add(fieldOrderSource);
        fieldOrderSource.setBounds(130, 10, 200, 30);

        lblCurrenDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCurrenDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrenDate.setText("Current Date");
        getContentPane().add(lblCurrenDate);
        lblCurrenDate.setBounds(340, 110, 90, 30);

        fieldCurrentDate.setEditable(false);
        fieldCurrentDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldCurrentDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        fieldCurrentDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCurrentDate.setText("01/01/2013");
        fieldCurrentDate.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(fieldCurrentDate);
        fieldCurrentDate.setBounds(440, 110, 150, 26);

        lblPosTarget.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPosTarget.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPosTarget.setText("To POS");
        getContentPane().add(lblPosTarget);
        lblPosTarget.setBounds(0, 160, 110, 30);

        fieldPOSTarget.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldPOSTarget.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldPOSTargetItemStateChanged(evt);
            }

			private void fieldPOSTargetItemStateChanged(ItemEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });
        fillPicksPOS();
        getContentPane().add(fieldPOSTarget);
        fieldPOSTarget.setBounds(130, 160, 200, 30);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 50, 594, 10);

        fieldSourcePOS.setEditable(false);
        fieldSourcePOS.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fieldSourcePOS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldSourcePOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(fieldSourcePOS);
        fieldSourcePOS.setBounds(130, 110, 200, 30);

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(470, 160, 120, 30);

        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcess);
        btnProcess.setBounds(340, 160, 120, 30);

        pack();
    }// </editor-fold>
	
    private void fieldCashierKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldOrderSourceKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldPOSTargetKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void fieldSourcePOSKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {
		KeyNamePair wh = (KeyNamePair)fieldPOSTarget.getSelectedItem();
		toPos=0;
		if (wh != null)
			toPos = wh.getKey();
		if(toPos!=0)
		{

			this.posPanel .m_order.set_CustomColumn("c_pos_id",toPos); // transferencia
			this.posPanel .m_order.save();
			this.posPanel .f_curLine.setmEmpty_table();
			this.posPanel .f_order.getf_iproduct().setText("");
			
			

			this.posPanel .f_subpanel.getbtn_Imagen().setIcon(null);
			this.posPanel .f_order.getp_Panellogo().getlabelItemCount().setText(Msg.translate(Env.getCtx(), "Su Orden Tiene")+" 0"+Msg.translate(Env.getCtx(), " Articulos"));


			this.posPanel .f_subpanel.getf_DocumentNo().setText("");
			this.posPanel .f_subpanel.getf_total().setValue(Env.ZERO);
			this.posPanel .f_subpanel.getf_net().setValue(Env.ZERO);
			this.posPanel .f_subpanel.getf_tax().setValue(Env.ZERO);
			this.posPanel .f_curLine.getf_name().setText("");



			JOptionPane.showMessageDialog(null, "Orden transferiada!");
			this.posPanel .m_order=null;

		}
    	refrescar.stop();	
    	super.dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	refrescar.stop();	
    	super.dispose();
    }   
    private void fieldSourcePOSActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    
    /// get Propiedades
    
    public void setfieldCashier ( String value)
    {
    	fieldCashier.setText(value);
    }
    
    public void setfieldSourcePOS (String value)
    {
    	fieldSourcePOS.setText(value);
    }
	private void fillPicksPOS ()
	{
		//	Price List
       String sql ="SELECT  c_pos.c_pos_id,  c_pos.name,  c_bankstatement.docstatus FROM  adempiere.c_bankstatement,  adempiere.c_pos WHERE   c_bankstatement.c_bankaccount_id = c_pos.c_bankaccount_id AND  c_bankstatement.docstatus = 'DR' and c_pos.c_pos_id <>"+this.posPanel.p_pos.get_ID();

		try
		{
			fieldPOSTarget.addItem(new KeyNamePair (0, ""));
			PreparedStatement pstmt = DB.prepareStatement(sql, null);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				KeyNamePair kn = new KeyNamePair (rs.getInt(1), rs.getString(2));
				fieldPOSTarget.addItem(kn);
			}
			rs.close();
			pstmt.close();
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql, e);
		}
	}	//	fillPicks
  



	
	
	
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
