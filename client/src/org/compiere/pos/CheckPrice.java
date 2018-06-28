package org.compiere.pos;

import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import org.compiere.apps.ADialog;
import org.compiere.model.MImage;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MProduct;
import org.compiere.model.MWarehousePrice;
import org.compiere.swing.CButton;
import org.compiere.swing.CDialog;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings("serial")
public class CheckPrice extends CDialog implements ActionListener {
// Acciones
	private boolean bAddItems=false;
	private PosBasePanel posPanel;

	/** Warehouse					*/
	private int 			m_M_Warehouse_ID;
	private int 			m_M_product_ID;
	/** PLV							*/
	private int 			m_M_PriceList_Version_ID;	
	private boolean issoldw = false;
	private BigDecimal el_peso = Env.ZERO;
// La Forma
    // Variables declaration - do not modify
	private CButton			f_bSearch;	
	
    private javax.swing.JButton btnAddToOrder;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImagen;
    private javax.swing.JCheckBox chDeposit;
    private javax.swing.JCheckBox chEbt;
//    private javax.swing.JCheckBox chIsfoodstamp;
    private javax.swing.JCheckBox chTax;
    private javax.swing.JCheckBox chWic;
    private javax.swing.JFormattedTextField dtPricemanager;
    private javax.swing.JFormattedTextField dtPricemanageramount;
    private javax.swing.JFormattedTextField dtPricenormal;
    private javax.swing.JFormattedTextField dtPricespecial;
    private javax.swing.JFormattedTextField dtPricespecialamount;
    private PosTextField dtProduct;
    private javax.swing.JFormattedTextField dtProductname;
    private PosTextField dtUpc;
    private PosTextField dtWeight;
    private javax.swing.JFormattedTextField dtpricenormalamount;

    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblAmounts;
    private javax.swing.JLabel lblCheckPrice;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPriceNormal;
    private javax.swing.JLabel lblPricemanager;
    private javax.swing.JLabel lblPricespecial;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblUpc;
    private javax.swing.JLabel lblWeight;

	public CheckPrice (PosBasePanel posPanel)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "CheckPrice"), true);
		this.posPanel = posPanel;
		init();
		
	}
	private void init() 
	{
		initComponents();
		this.chDeposit.setEnabled(false);
		this.chEbt.setVisible(false);
	//	this.chIsfoodstamp.setEnabled(false);
		this.chTax.setEnabled(false);
		this.chWic.setVisible(false);
	}
    private void initComponents() {

    	f_bSearch = this.posPanel.f_subpanel.createButtonAction ("Product", KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
        dtWeight =new PosTextField(Msg.translate(posPanel.getCtx(), "Peso"), posPanel, posPanel.p_pos.getOSNP_KeyLayout_ID());
        dtUpc =new PosTextField(Msg.translate(posPanel.getCtx(), "UPC"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        dtProduct =new PosTextField(Msg.translate(posPanel.getCtx(), "Producto"), posPanel, posPanel.p_pos.getOSK_KeyLayout_ID());
        
        
        lblUpc = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblPricespecial = new javax.swing.JLabel();
        lblPriceNormal = new javax.swing.JLabel();
        lblPricemanager = new javax.swing.JLabel();
        chWic = new javax.swing.JCheckBox();
        chTax = new javax.swing.JCheckBox();
    //    chIsfoodstamp = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancel = new javax.swing.JButton();
        btnImagen = new javax.swing.JButton();
        btnAddToOrder = new javax.swing.JButton();
        chDeposit = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        lblPrice = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblCheckPrice = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblAmounts = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        dtPricemanageramount = new javax.swing.JFormattedTextField();
        dtPricenormal = new javax.swing.JFormattedTextField();
        dtPricespecial = new javax.swing.JFormattedTextField();
        dtPricemanager = new javax.swing.JFormattedTextField();
        dtpricenormalamount = new javax.swing.JFormattedTextField();
        dtPricespecialamount = new javax.swing.JFormattedTextField();
        dtProductname = new javax.swing.JFormattedTextField();
        chEbt = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();


        setLayout(null);

        lblUpc.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblUpc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUpc.setText("UPC");
        add(lblUpc);
        lblUpc.setBounds(80, 60, 100, 19);

        lblWeight.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWeight.setText("Peso");
        add(lblWeight);
        lblWeight.setBounds(80, 200, 100, 20);

        lblPricespecial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPricespecial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPricespecial.setText("Especial");
        add(lblPricespecial);
        lblPricespecial.setBounds(40, 480, 80, 19);

        lblPriceNormal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPriceNormal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPriceNormal.setText("Normal");
        add(lblPriceNormal);
        lblPriceNormal.setBounds(40, 440, 80, 19);

        lblPricemanager.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPricemanager.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPricemanager.setText("Supervisor");
        add(lblPricemanager);
        lblPricemanager.setBounds(40, 520, 80, 19);

        chWic.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        chWic.setText("Wic");

        add(chWic);
        chWic.setBounds(200, 280, 50, 27);

        chTax.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        chTax.setText("Impuesto");
        add(chTax);
        chTax.setBounds(390, 280, 50, 27);


        add(jSeparator1);
        jSeparator1.setBounds(10, 180, 570, 0);

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        add(btnCancel);
        btnCancel.setBounds(20, 590, 180, 60);


        add(btnImagen);
        btnImagen.setBounds(420, 50, 250, 180);

        btnAddToOrder.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnAddToOrder.setText("Agregar a la Orden");
        btnAddToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToOrderActionPerformed(evt);
            }
        });
        add(btnAddToOrder);
        btnAddToOrder.setBounds(470, 590, 190, 60);

        chDeposit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        chDeposit.setText("Deposito");
        add(chDeposit);
        chDeposit.setBounds(20, 280, 80, 27);
        add(jSeparator3);
        jSeparator3.setBounds(10, 48, 170, 2);

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPrice.setText("Precio");
        add(lblPrice);
        lblPrice.setBounds(20, 400, 230, 22);

        lblProduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProduct.setText("Producto");
        add(lblProduct);
        lblProduct.setBounds(120, 130, 60, 19);
        add(jSeparator2);
        jSeparator2.setBounds(20, 430, 180, 2);

        lblCheckPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCheckPrice.setText("Ver Precios");
        add(lblCheckPrice);
        lblCheckPrice.setBounds(10, 20, 230, 22);
        add(jSeparator4);
        jSeparator4.setBounds(430, 430, 180, 2);

        lblAmounts.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAmounts.setText("Monto");
        add(lblAmounts);
        lblAmounts.setBounds(430, 400, 230, 22);
        add(jSeparator5);
        jSeparator5.setBounds(10, 570, 660, 2);

        dtPricemanageramount.setEditable(false);
        dtPricemanageramount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtPricemanageramount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPricemanageramount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPricemanageramount.setText("0");
        dtPricemanageramount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtPricemanageramount);
        dtPricemanageramount.setBounds(450, 520, 200, 26);

        dtPricenormal.setEditable(false);
        dtPricenormal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtPricenormal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPricenormal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPricenormal.setText("0");
        dtPricenormal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtPricenormal);
        dtPricenormal.setBounds(130, 440, 200, 26);

        dtPricespecial.setEditable(false);
        dtPricespecial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtPricespecial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPricespecial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPricespecial.setText("0");
        dtPricespecial.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtPricespecial);
        dtPricespecial.setBounds(130, 480, 200, 26);

        dtPricemanager.setEditable(false);
        dtPricemanager.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtPricemanager.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPricemanager.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPricemanager.setText("0");
        dtPricemanager.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtPricemanager);
        dtPricemanager.setBounds(130, 520, 200, 26);

        dtpricenormalamount.setEditable(false);
        dtpricenormalamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtpricenormalamount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtpricenormalamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtpricenormalamount.setText("0");
        dtpricenormalamount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtpricenormalamount);
        dtpricenormalamount.setBounds(450, 440, 200, 26);

        dtPricespecialamount.setEditable(false);
        dtPricespecialamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtPricespecialamount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtPricespecialamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtPricespecialamount.setText("0");
        dtPricespecialamount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(dtPricespecialamount);
        dtPricespecialamount.setBounds(450, 480, 200, 26);

        dtWeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtWeight.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        dtWeight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dtWeight.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        dtWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	dtdWeightKeyPressed(evt);
            }
        });
        add(dtWeight);
        dtWeight.setBounds(190, 200, 200, 26);

        dtProductname.setEditable(false);
        dtProductname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtProductname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dtProductname.setText("Producto");
        dtProductname.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        add(dtProductname);
        dtProductname.setBounds(10, 330, 650, 40);

        dtUpc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtUpc.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        dtUpc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	dtUPCKeyPressed(evt);
            }
        });
        add(dtUpc);
        dtUpc.setBounds(190, 60, 200, 26);

        dtProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dtProduct.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        dtProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtProductKeyPressed(evt);
            }
        });
        add(dtProduct);
        dtProduct.setBounds(190, 130, 200, 26);
        add(jSeparator6);
        jSeparator6.setBounds(10, 260, 660, 2);

        chEbt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        chEbt.setText("EBT");

        add(chEbt);
        chEbt.setBounds(590, 280, 53, 27);
        add(jSeparator7);
        jSeparator7.setBounds(10, 390, 660, 2);


        f_bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_bSearchActionPerformed(evt);
            }
        });
        add(f_bSearch);
        f_bSearch.setBounds(30, 100, 73, 80);        
        
        

    }// </editor-fold>

    private void dtUPCKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
        	
        	findProduct();
        }    	
    }

    private void dtProductKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
        	findProduct();
        }    	
    }


    private void dtdWeightKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) 
        {
          // Calcular peso*precio
        	
        	
            String el_numero=this.dtWeight.getText();
            
            el_numero = el_numero.replace(".","");
            el_numero = el_numero.replace(",",".");
            double elPeso = Double.parseDouble(el_numero);

            this.dtWeight.setValue(elPeso);
            
        	BigDecimal elValor =BigDecimal.valueOf(elPeso);
        	BigDecimal dfieldPriceNormalAmount= Env.ZERO;
            BigDecimal dfieldPriceManagerAmount = Env.ZERO;
          
            BigDecimal dfieldPriceSpecialAmount= Env.ZERO;
            
            
            dfieldPriceNormalAmount=dfieldPriceNormalAmount.add((BigDecimal)this.dtPricenormal.getValue()).multiply(elValor);
            
          
            
            dfieldPriceManagerAmount=dfieldPriceManagerAmount.add((BigDecimal)this.dtPricemanager.getValue()).multiply(elValor);
            
            dfieldPriceSpecialAmount=dfieldPriceSpecialAmount.add((BigDecimal)this.dtPricespecial.getValue()).multiply(elValor);
            
     
            this.dtPricemanageramount.setValue(dfieldPriceManagerAmount);
            this.dtpricenormalamount.setValue(dfieldPriceNormalAmount);
            this.dtPricespecialamount.setValue(dfieldPriceSpecialAmount);
            
            this.el_peso=elValor;
            
        }     	
    }
    private void f_bSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dtPricemanageramount.setValue(0);
        this.dtPricenormal.setValue(0);
        this.dtPricespecial.setValue(0);
        this.dtPricemanager.setValue(0);
        this.dtpricenormalamount.setValue(0);
        this.dtPricespecialamount.setValue(0);
        this.dtWeight.setValue(0);
        this.dtProductname.setText("");
        this.dtUpc.setText("");
        this.dtProduct.setText("");
 	
    	setParameter();
		QueryProduct qt = new QueryProduct(this.posPanel);
		qt.setQueryData(m_M_PriceList_Version_ID, m_M_Warehouse_ID);
		qt.setm_M_Product_ID(0);
		qt.SetisOnlySearch(true);
		qt.setVisible(true);
		setM_Product_ID(qt.getm_M_Product_ID());	
		findProduct();

    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
     this.dispose();
    }	
    public boolean getbAddItems()
    {
    	return bAddItems;
    }
    public javax.swing.JFormattedTextField getdtProduct()
    {
    	return dtProduct;	   
    }
    public javax.swing.JFormattedTextField getdtWeight()
    {
    	return dtWeight;	   
    }    
    public int getm_M_product_ID()
    {
    	return m_M_product_ID;
    }
    public BigDecimal getel_peso()
    {
    	return el_peso;
    	
    }
    public boolean getissoldw()
    {
    	return issoldw;
    }
	/**************************************************************************
	 * 	Find/Set Product & Price
	 */
	private void findProduct()
	{
		String query = this.dtProduct.getText();
		if (query == null || query.length() == 0)
			query = this.dtUpc.getText();
		if (query == null || query.length() == 0)
			return;
		query = query.toUpperCase();
		//	Test Number
		boolean allNumber = true;
		try
		{
			Integer.getInteger(query);
		}
		catch (Exception e)
		{
			allNumber = false;
		}
		String Value = query;
		String Name = query;
		String UPC = (allNumber ? query : null);
		UPC=this.dtUpc.getText();
		String SKU = (allNumber ? query : null);
		
		MWarehousePrice[] results = null;
		setParameter();
		//
		results = MWarehousePrice.find (this.posPanel.getCtx(),
			m_M_PriceList_Version_ID, m_M_Warehouse_ID,
			Value, Name, UPC, SKU, null);
		
		//	Set Result
		if (results.length == 0)
		{
			String message = Msg.translate(this.posPanel.getCtx(),  "search.product.notfound");
			ADialog.warn(0, this.posPanel, message + query);
			setM_Product_ID(0);
			
		}
		else if (results.length == 1)
		{
			setM_Product_ID(results[0].getM_Product_ID());

			this.dtProduct.setText(results[0].getName());
			this.dtPricemanager.setValue(results[0].getPriceLimit());
			this.dtPricenormal.setValue(results[0].getPriceList());
			this.dtPricespecial.setValue(results[0].getPriceStd());
			
		}

	}	//	findProduct
	private void setParameter()
	{
		//	What PriceList ?
		if(posPanel.f_order.p_pos!=null)
			 m_M_Warehouse_ID = posPanel.f_order.p_pos.getM_Warehouse_ID();
		m_M_PriceList_Version_ID = this.posPanel.f_order.getM_PriceList_Version_ID();
	}	//	setParameter	
	
	
	
	public void setM_Product_ID (int M_Product_ID)
	{

		MProduct m_product = new  MProduct(Env.getCtx(), M_Product_ID,null);
		if (m_product.get_ID() == 0)
			m_product = null;
		//	Set String Info
		if (m_product != null)
		{
			this.dtProduct.setText(m_product.getValue());
			this.dtUpc.setText(m_product.getUPC());
		    this.dtProductname.setText(m_product.getName());
		    this.dtProductname.setToolTipText(m_product.getDescription());
            this.issoldw=false; // m_product.get_ValueAsBoolean("issoldw"); NICAURY
            this.chDeposit.setSelected(m_product.get_ValueAsBoolean("isdeposit"));
            this.chWic.setSelected(m_product.get_ValueAsBoolean("iswic"));
            this.chTax.setSelected(psBusca_Impuesto(m_product.getC_TaxCategory_ID()));
            
            
            

            //NICAURI AQUI DEBES AGREGAR LOS OTROS CAMPOS A LA TABLA DE PRODUCTO
            // ejemplo : sfoodstamp
            
            
            
            
	        MImage la_imagen = MImage.get(Env.getCtx(),m_product.get_ValueAsInt("AD_Image_ID"));
	        if(la_imagen.get_ID()==0 )
	        {
	        	MOrgInfo la_organizacion = MOrgInfo.get(Env.getCtx(),Env.getAD_Org_ID(Env.getCtx()),null);
	        	la_imagen = MImage.get(Env.getCtx() ,la_organizacion.get_ValueAsInt("logo_id"));
	        }
	        if(la_imagen.get_ID()!=0 )
    			this.btnImagen.setIcon(new ImageIcon(la_imagen.getImage().getScaledInstance(this.btnImagen.getWidth(),this.btnImagen.getHeight(), Image.SCALE_DEFAULT)));
	        this.dtWeight.setEditable(false);
	        if(this.issoldw)
		
	        {
	        	this.dtWeight.setEditable(true);
	        	this.dtWeight.requestFocus();
	        }
			this.m_M_product_ID=m_product.get_ID();
		
		}
		else
		{
			this.dtProductname.setText(null);
			this.dtProductname.setToolTipText(null);
		}
	}	//	setM_Product_ID	
	
    private boolean psBusca_Impuesto(int sCategoria_Tax) {
    	boolean bRetorno =false;
   		String sql = "SELECT * FROM C_TAX WHERE C_TAX_ID="+sCategoria_Tax;
   		PreparedStatement pstmt = null;
   		ResultSet rs = null;
   		try
    		{
    			pstmt = DB.prepareStatement(sql, "C_TAX");
    			rs = pstmt.executeQuery();
    			while (rs.next())
    			{
    				if(!rs.getString("RATE").trim().isEmpty())
    				{
    					if(rs.getBigDecimal("RATE").compareTo(Env.ZERO)==0)
    					{
    						bRetorno =false ; // EXCENTO
    					}
    					else
    					{
    						bRetorno=true ;
    					}
    				}
    			}
    		}
    		catch (Exception e)
    		{
    		}
    		finally
    		{
    			DB.close(rs, pstmt);
    			rs = null;
    			pstmt = null;
    		}
    		return bRetorno;

	}
	private void btnAddToOrderActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	findProduct();
    	bAddItems=true;
    	this.dispose();
    			
    	
    } 	
}
