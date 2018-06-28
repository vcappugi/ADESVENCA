/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 Adempiere, Inc. All Rights Reserved.               *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/

package org.compiere.pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

import org.adempiere.plaf.AdempierePLAF;
import org.compiere.apps.ADialog;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MCampaign;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.print.ReportCtl;
import org.compiere.print.ReportEngine;
import org.compiere.swing.CButton;
import org.compiere.swing.CComboBox;
import org.compiere.swing.CLabel;
import org.compiere.swing.CTextField;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;


/**
 *	Customer Sub Above Panel
 *	
 *  @author Comunidad de Desarrollo OpenXpertya 
 *         *Basado en Codigo Original Modificado, Revisado y Optimizado de:
 *         *Copyright � Jorg Janke
 *  @version $Id: SubBPartner.java,v 1.1 2004/07/12 04:10:04 jjanke Exp $
 */
@SuppressWarnings("unused")
public class SubAboveFunctionKeys extends PosSubPanel
implements ActionListener, FocusListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5895558315889871887L;
	private static CLogger log = CLogger.getCLogger(SubAboveFunctionKeys.class);
	
    private javax.swing.JPanel PanelProducto;
    private javax.swing.JSeparator Sep01;
    private javax.swing.JSeparator Sep02;
    private javax.swing.JButton btn_Imagen;
    private javax.swing.JLabel dtCampain;
    private javax.swing.JLabel dtVendedor;
    private javax.swing.JLabel f_DocumentNo;
    private javax.swing.JLabel f_name;
    private javax.swing.JFormattedTextField f_net;
    private javax.swing.JFormattedTextField f_tax;
    private javax.swing.JFormattedTextField f_total;
    private javax.swing.JLabel lNet;
    private javax.swing.JLabel lTax;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lblCampain;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JLabel lblVendedor;

    Font ifont3 = new Font("TheSansCorrespondence", Font.PLAIN, 16);
	Font ifont4 = new Font("TheSansCorrespondence", Font.PLAIN, 24);
    Font bigFont = AdempierePLAF.getFont_Field().deriveFont(32.0F);
    Font mFont = AdempierePLAF.getFont_Field().deriveFont(18.0F);
    Border empty2 = BorderFactory.createEmptyBorder();
	
	/**	The Business Partner		*/
	private MBPartner	m_bpartner;
	/** Campain*/
	private MCampaign m_Campaign; 
	
	/**	Price List Version to use	*/
	private int			m_M_PriceList_Version_ID = 0;
	private CTextField f_currency = new CTextField();

	/**
	 * 	Constructor
	 *	@param posPanel POS Panel
	 */
	public SubAboveFunctionKeys (PosBasePanel posPanel)
	{
		super (posPanel);
	}	//	PosSubCustomer
	
// Cambiar Valores de La Imegen del Producto //
	public  javax.swing.JButton getbtn_Imagen()
	{
		 return btn_Imagen;
	}
	

	
	public javax.swing.JLabel getf_DocumentNo() {return f_DocumentNo; }
	public javax.swing.JFormattedTextField getf_total() {return f_total; }
	public javax.swing.JFormattedTextField getf_net()  {return f_net; }
	public javax.swing.JFormattedTextField getf_tax() {return f_tax; }
//	public javax.swing.JFormattedTextField getfieldYourWICTotal() {return fieldYourWICTotal; }
//	public javax.swing.JFormattedTextField getfieldFoodStampTotal() {return fieldFoodStampTotal; }
//	public javax.swing.JFormattedTextField getfieldYouSavedTotal() {return fieldYouSavedTotal; }
	
	
	

	/**
	 * 	Initialize
	 */
	
	
//Fonts Truetype
	public void init()
	{
		
		m_Campaign = new MCampaign(p_ctx, p_pos.get_ValueAsInt("c_campaign_id"), null);
		initComponents();
		this.dtCampain.setText(m_Campaign.getName()); // Comersso
	  }
	/**
	 * 	Dispose - Free Resources
	 */
	public void dispose()
	{
		if (f_name != null)
			f_name.removeFocusListener(this);
		f_name = null;
		removeAll();
		super.dispose();
	}	//	dispose

	/**************************************************************************
	 * 	Action Listener
	 *	@param e event
	 */
	public void actionPerformed (ActionEvent e)
	{
		String action = e.getActionCommand();
		if (action == null || action.length() == 0)
			return;
		log.info( "PosSubCustomer - actionPerformed: " + action);
		//	New
		if (action.equals("New"))
		{
			p_posPanel.newOrder(0); //red1 New POS Order instead - B_Partner already has direct field
			return;
		}
		//	Register
		if (action.equals("History"))
		{
			PosQuery qt = new QueryTicket(p_posPanel);
			//qt.setVisible(true);
			return;
		}
		else if (action.equals("Cancel"))
			deleteOrder();
		else if (action.equals("Cash"))
			payOrder();
		else if (action.equals("Print"))
			printOrder();
		else if (action.equals("BPartner"))
		{
			PosQuery qt = new QueryBPartner(p_posPanel);
			qt.setVisible(true);
		}
		// Logout
		else if (action.equals("Logout"))
		{
			p_posPanel.dispose();
			return;
		}
		//	Name
		else if (e.getSource() == f_name)
			findBPartner();
		
		p_posPanel.updateInfo();
	}	//	actionPerformed

	/**
	 * 
	 */
	private void printOrder() {
		{
			if (isOrderFullyPaid())
			{
				updateOrder();
				printTicket();
				openCashDrawer();
			}
		}
	}

	/**
	 * 
	 */
	private void payOrder() {

		//Check if order is completed, if so, print and open drawer, create an empty order and set cashGiven to zero

		if( p_posPanel.m_order != null ) 
		{
			if ( !p_posPanel.m_order.isProcessed() && !p_posPanel.m_order.processOrder() )
			{
				ADialog.warn(0, p_posPanel, "PosOrderProcessFailed");
				return;
			}

			if ( PosPayment.pay(p_posPanel) )
			{
				printTicket();
				p_posPanel.setOrder(0);
			}
		}	
	}

	/**
	 * 
	 */
	private void deleteOrder() {
		if ( p_posPanel != null && ADialog.ask(0, this, "Delete order?") )
			p_posPanel.m_order.deleteOrder();
		p_posPanel.f_curLine.setmEmpty_table();
		
	
		
		// p_posPanel.newOrder();

	}

	/**
	 * 	Focus Gained
	 *	@param e
	 */
	public void focusGained (FocusEvent e)
	{
	}	//	focusGained

	/**
	 * 	Focus Lost
	 *	@param e
	 */
	public void focusLost (FocusEvent e)
	{
		if (e.isTemporary())
			return;
		log.info(e.toString());
		findBPartner();
	}	//	focusLost

	
	/**
	 * 	Find/Set BPartner
	 */
	private void findBPartner()
	{
		
		String query = f_name.getText();
		
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
		MBPartnerInfo[] results = MBPartnerInfo.find(p_ctx, Value, Name, 
			/*Contact, */null, EMail, Phone, City);
		
		//	Set Result
		if (results.length == 0)
		{
			setC_BPartner_ID(0);
		}
		else if (results.length == 1)
		{
			setC_BPartner_ID(results[0].getC_BPartner_ID());
			f_name.setText(results[0].getName());

		}
		else	//	more than one
		{
			QueryBPartner qt = new QueryBPartner(p_posPanel);
			qt.setResults (results);
			qt.setVisible(true);
		}
	}	//	findBPartner
	
	
	/**************************************************************************
	 * 	Set BPartner
	 *	@param C_BPartner_ID id
	 */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		log.fine( "PosSubCustomer.setC_BPartner_ID=" + C_BPartner_ID);
		if (C_BPartner_ID == 0)
			m_bpartner = null;
		else
		{
			m_bpartner = new MBPartner(p_ctx, C_BPartner_ID, null);
			if (m_bpartner.get_ID() == 0)
				m_bpartner = null;
		}
		
		//	Set Info
		if (m_bpartner != null)
		{
			f_name.setText(m_bpartner.getName());

		}
		else
		{
			f_name.setText(null);
		
		}
		//	Sets Currency
		m_M_PriceList_Version_ID = 0;
		getM_PriceList_Version_ID();
		//fillCombos();
		if ( p_posPanel.m_order != null && m_bpartner != null )
			p_posPanel.m_order.setBPartner(m_bpartner);  //added by ConSerTi to update the client in the request
	}	//	setC_BPartner_ID

	/**
	 * 	Get BPartner
	 *	@return C_BPartner_ID
	 */
	public int getC_BPartner_ID ()
	{
		if (m_bpartner != null)
			return m_bpartner.getC_BPartner_ID();
		return 0;
	}	//	getC_BPartner_ID

	/**
	 * 	Get BPartner
	 *	@return BPartner
	 */
	public MBPartner getBPartner ()
	{
		return m_bpartner;
	}	//	getBPartner
	
	/**
	 * 	Get BPartner Location
	 *	@return C_BPartner_Location_ID
	 */
	public int getC_BPartner_Location_ID ()
	{
/*		if (m_bpartner != null)
		{
			KeyNamePair pp = (KeyNamePair)f_location.getSelectedItem();
			if (pp != null)
				return pp.getKey();
		}*/
		return 0;
	}	//	getC_BPartner_Location_ID
	
	/**
	 * 	Get BPartner Contact
	 *	@return AD_User_ID
	 */
	public int getAD_User_ID ()
	{
	/*	if (m_bpartner != null)
		{
			KeyNamePair pp = (KeyNamePair)f_user.getSelectedItem();
			if (pp != null)
				ret*urn pp.getKey();
		}*/
		return 0;
	}	//	getC_BPartner_Location_ID

	/**
	 * 	Get M_PriceList_Version_ID.
	 * 	Set Currency
	 *	@return plv
	 */
	public int getM_PriceList_Version_ID()
	{
		if (m_M_PriceList_Version_ID == 0)
		{
			int M_PriceList_ID = p_pos.getM_PriceList_ID();
			if (m_bpartner != null && m_bpartner.getM_PriceList_ID() != 0)
				M_PriceList_ID = m_bpartner.getM_PriceList_ID();
			//
			MPriceList pl = MPriceList.get(p_ctx, M_PriceList_ID, null);
			setCurrency(MCurrency.getISO_Code(p_ctx, pl.getC_Currency_ID()));
			f_name.setToolTipText(pl.getName());
			//
			MPriceListVersion plv = pl.getPriceListVersion (p_posPanel.getToday());
			if (plv != null && plv.getM_PriceList_Version_ID() != 0)
				m_M_PriceList_Version_ID = plv.getM_PriceList_Version_ID();
		}
		return m_M_PriceList_Version_ID;
	}	//	getM_PriceList_Version_ID
	

	/***************************************************************************
	 * Set Currency
	 * 
	 * @param currency
	 *            currency
	 */
	public void setCurrency(String currency) {
		if (currency == null)
			f_currency.setText("---");
		else
			f_currency.setText(currency);
	} //	setCurrency
	
	/**
	 * 	Print Ticket
	 *  @author Comunidad de Desarrollo OpenXpertya 
	 *  *Basado en Codigo Original Modificado, Revisado y Optimizado de:
	 *  *Copyright � ConSerTi
	 */
	public void printTicket()
	{
		if ( p_posPanel.m_order == null )
			return;
		
		MOrder order = p_posPanel.m_order;
		//int windowNo = p_posPanel.getWindowNo();
		//Properties m_ctx = p_posPanel.getPropiedades();
		
		if (order != null)
		{
			try 
			{
				//TODO: to incorporate work from Posterita
				/*
				if (p_pos.getAD_PrintLabel_ID() != 0)
					PrintLabel.printLabelTicket(order.getC_Order_ID(), p_pos.getAD_PrintLabel_ID());
				*/ 
				//print standard document
				ReportCtl.startDocumentPrint(ReportEngine.ORDER, order.getC_Order_ID(), null, Env.getWindowNo(this), true);
				
			}
			catch (Exception e) 
			{
				log.severe("PrintTicket - Error Printing Ticket");
			}
		}	  
	}	
	
	/**
	 * Is order fully pay ?
	 * Calculates if the given money is sufficient to pay the order
	 * 
	 * @author Comunidad de Desarrollo OpenXpertya 
 *         *Basado en Codigo Original Modificado, Revisado y Optimizado de:
 *         *Copyright � ConSerTi
	 */
	public boolean isOrderFullyPaid()
	{
		/*TODO
		BigDecimal given = new BigDecimal(f_cashGiven.getValue().toString());
		boolean paid = false;
		if (p_posPanel != null && p_posPanel.f_curLine != null)
		{
			MOrder order = p_posPanel.f_curLine.getOrder();
			BigDecimal total = new BigDecimal(0);
			if (order != null)
				total = order.getGrandTotal();
			paid = given.doubleValue() >= total.doubleValue();
		}
		return paid;
		*/
		return true;
	}
	
	/**
	 * 	Display cash return
	 *  Display the difference between tender amount and bill amount
	 *  @author Comunidad de Desarrollo OpenXpertya 
 *         *Basado en Codigo Original Modificado, Revisado y Optimizado de:
 *         *Copyright � ConSerTi
	 */
	public void updateOrder()
	{
		if (p_posPanel != null )
		{
			MOrder order = p_posPanel.m_order;
			if (order != null)
			{
				MOrderLine[] oLines = order.getLines();
				BigDecimal wic =Env.ZERO;
				BigDecimal food =Env.ZERO;
				BigDecimal saved =Env.ZERO;
				for (int i = 0; i < oLines.length; i++)
				{
					MOrderLine line = oLines[i];
					if(line.getProduct().isPurchased())
					{
						wic=wic.add(line.getLineNetAmt());
					}
					if(line.getProduct().isSold())
					{
						food=food.add(line.getLineNetAmt());
					}
					saved=saved.add(line.getPriceList().multiply(line.getQtyEntered()).multiply(line.getDiscount()).divide(Env.ONEHUNDRED, 2, BigDecimal.ROUND_HALF_UP));
				}
  				f_DocumentNo.setText(order.getDocumentNo());
  			
  				setC_BPartner_ID(order.getC_BPartner_ID());
  				//f_net.setValue(order.getSubtotal());
  				f_total.setValue(order.getGrandTotal());
  				f_net.setValue(order.getTotalLines());
  				f_tax.setValue(order.getGrandTotal().subtract(order.getTotalLines()));

			}
			else
			{
				f_DocumentNo.setText(null);
				setC_BPartner_ID(0);
				f_net.setValue(Env.ZERO);
				f_total.setValue(Env.ZERO);
//				fieldYourWICTotal.setValue(Env.ZERO);
//  				fieldFoodStampTotal.setValue(Env.ZERO);
//  				fieldYouSavedTotal.setValue(Env.ZERO);
				f_tax.setValue(Env.ZERO);

				
				
				/*f_bNew.setEnabled(true);
				f_bEdit.setEnabled(false);
				f_history.setEnabled(true);
				f_process.setEnabled(false);
				f_print.setEnabled(false);*/
//				f_cashPayment.setEnabled(true);
			}
			
		}
	}	

	/**
	 * 	Abrir caja
	 *  Abre la caja registradora
	 *  @author Comunidad de Desarrollo OpenXpertya 
 *         *Basado en Codigo Original Modificado, Revisado y Optimizado de:
 *         *Copyright � ConSerTi
	 */
	@SuppressWarnings("resource")
	public void openCashDrawer()
	{
		String port = "/dev/lp";
		
		byte data[] = new byte[] {0x1B, 0x40, 0x1C};
		try {  
            FileOutputStream m_out = null;
			if (m_out == null) {
                m_out = new FileOutputStream(port);  // No oner append = true.
            }
            m_out.write(data);
        } catch (IOException e) {
        }  
	}	
	/**
	 * 	Set Sums from Table
	 */
	void setSums(PosOrderModel order)
	{
		int noLines = p_posPanel.f_curLine.m_table.getRowCount();
		if (order == null || noLines == 0)
		{
			f_net.setValue(Env.ZERO);
			f_total.setValue(Env.ZERO);
			f_tax.setValue(Env.ZERO);
		}
		else
		{
			// order.getMOrder().prepareIt();
			f_net.setValue(order.getSubtotal());
			f_total.setValue(order.getGrandTotal());
			f_tax.setValue(order.getTaxAmt());

		}
	}	//	setSums
       // End of variables declaration

    private void initComponents() {
        PanelProducto = new javax.swing.JPanel();
        btn_Imagen = new javax.swing.JButton();
        dtCampain = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        lblOrden = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lNet = new javax.swing.JLabel();
        lTax = new javax.swing.JLabel();
        dtVendedor = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        f_DocumentNo = new javax.swing.JLabel();
        f_total = new javax.swing.JFormattedTextField();
        f_net = new javax.swing.JFormattedTextField();
        f_tax = new javax.swing.JFormattedTextField();
        lTotal = new javax.swing.JLabel();
        lblCampain = new javax.swing.JLabel();
        Sep01 = new javax.swing.JSeparator();
        Sep02 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(51, 0, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        PanelProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

     //   btn_Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posventas/527283_486580921389376_575660436_n.jpg"))); // NOI18N
        btn_Imagen.setBorder(null);

        javax.swing.GroupLayout PanelProductoLayout = new javax.swing.GroupLayout(PanelProducto);
        PanelProducto.setLayout(PanelProductoLayout);
        PanelProductoLayout.setHorizontalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelProductoLayout.setVerticalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductoLayout.createSequentialGroup()
                .addComponent(btn_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(PanelProducto);
        PanelProducto.setBounds(0, 0, 290, 310);

        dtCampain.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dtCampain.setForeground(new java.awt.Color(255, 204, 0));
        dtCampain.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    	
        //dtCampain.setText("Buscarlo");
        add(dtCampain);
        dtCampain.setBounds(300, 40, 270, 19);

        lblVendedor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedor.setText("Vendedor");
        add(lblVendedor);
        lblVendedor.setBounds(300, 80, 70, 19);

        lblOrden.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblOrden.setForeground(new java.awt.Color(255, 255, 255));
        lblOrden.setText("Orden");
        add(lblOrden);
        lblOrden.setBounds(300, 120, 60, 14);

        lblCliente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente");
        add(lblCliente);
        lblCliente.setBounds(300, 150, 60, 20);

        lNet.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lNet.setForeground(new java.awt.Color(255, 255, 255));
        lNet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNet.setText("Sub Total");
        add(lNet);
        lNet.setBounds(320, 200, 70, 20);

        lTax.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lTax.setForeground(new java.awt.Color(255, 255, 255));
        lTax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTax.setText("Total Impuesto");
        add(lTax);
        lTax.setBounds(290, 240, 100, 20);

        dtVendedor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dtVendedor.setForeground(new java.awt.Color(255, 255, 255));
        dtVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dtVendedor.setText("SUPERUSER");
        add(dtVendedor);
        dtVendedor.setBounds(390, 80, 180, 19);

        f_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        f_name.setForeground(new java.awt.Color(255, 255, 255));
        f_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        f_name.setText("");
        f_name.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(f_name);
        f_name.setBounds(350, 150, 220, 24);

        f_DocumentNo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        f_DocumentNo.setForeground(new java.awt.Color(255, 255, 255));
        f_DocumentNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        f_DocumentNo.setText("80039");
        f_DocumentNo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(f_DocumentNo);
        f_DocumentNo.setBounds(480, 110, 90, 24);

        f_total.setBackground(new java.awt.Color(204, 204, 255));
        f_total.setBorder(null);
        f_total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        f_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        f_total.setText("0");
        f_total.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        add(f_total);
        f_total.setBounds(400, 280, 170, 20);

        f_net.setBackground(new java.awt.Color(204, 204, 255));
        f_net.setBorder(null);
        f_net.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        f_net.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        f_net.setText("0");
        f_net.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(f_net);
        f_net.setBounds(400, 200, 170, 20);

        f_tax.setBackground(new java.awt.Color(204, 204, 255));
        f_tax.setBorder(null);
        f_tax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        f_tax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        f_tax.setText("0");
        f_tax.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        add(f_tax);
        f_tax.setBounds(400, 240, 170, 20);

        lTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lTotal.setForeground(new java.awt.Color(255, 255, 255));
        lTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotal.setText("Gran Total");
        add(lTotal);
        lTotal.setBounds(290, 280, 100, 20);

        lblCampain.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        lblCampain.setForeground(new java.awt.Color(255, 255, 255));
        lblCampain.setText("Operativo");
        add(lblCampain);
        lblCampain.setBounds(290, 0, 130, 30);

        Sep01.setBackground(new java.awt.Color(204, 204, 0));
        Sep01.setForeground(new java.awt.Color(255, 255, 51));
        Sep01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Sep01.setOpaque(true);
        add(Sep01);
        Sep01.setBounds(290, 30, 280, 5);
       setPreferredSize(new Dimension(200,410));
    }// </editor-fold>
   
}

	
	//	SubOrder