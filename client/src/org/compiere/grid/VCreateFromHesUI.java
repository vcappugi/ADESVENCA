/******************************************************************************
 * Copyright (C) 2009 Low Heng Sin                                            *
 * Copyright (C) 2009 Idalica Corporation                                     *
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
package org.compiere.grid;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.compiere.apps.ADialog;
import org.compiere.apps.AEnv;
import org.compiere.apps.ConfirmPanel;
import org.compiere.grid.ed.VDate;
import org.compiere.grid.ed.VLookup;
import org.compiere.grid.ed.VNumber;
import org.compiere.grid.ed.VString;
import org.compiere.model.GridTab;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MBankStatement;
import org.compiere.model.MClient;
import org.compiere.model.MColumn;
import org.compiere.model.MCurrency;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.model.MPayment;
import org.compiere.swing.CButton;
import org.compiere.swing.CLabel;
import org.compiere.swing.CPanel;
import org.compiere.swing.CTextField;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.pentanet.model.MCHes;

@SuppressWarnings("unused")
public class VCreateFromHesUI extends CreateFromHes implements ActionListener
{
	private static final long serialVersionUID = 1L;

	
	private VCreateFromDialog dialog;

	public VCreateFromHesUI(GridTab mTab)
	{
		super(mTab);
		log.info(getGridTab().toString());
		
		dialog = new VCreateFromDialog(this, getGridTab().getWindowNo(), true);
		
		p_WindowNo = getGridTab().getWindowNo();

		try
		{
			if (!dynInit())
				return;
			jbInit();

			setInitOK(true);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "", e);
			setInitOK(false);
		}
		AEnv.positionCenterWindow(Env.getWindow(p_WindowNo), dialog);
	}   //  VCreateFrom
	
	/** Window No               */
	private int p_WindowNo;

	/**	Logger			*/
	private CLogger log = CLogger.getCLogger(getClass());
	
	private JLabel preInvoiceLabel = new JLabel();
	private JComboBox preInvoiceField = new JComboBox();
	
	private CLabel currencyLabel = new CLabel(Msg.translate(Env.getCtx(), "C_Currency_ID"));
	protected CTextField currencyField = new CTextField(10);
	
	private Boolean someError = false;
	
	
	/**
	 *  Dynamic Init
	 *  @throws Exception if Lookups cannot be initialized
	 *  @return true if initialized
	 */
	public boolean dynInit() throws Exception
	{
		log.config("");
		
		super.dynInit();
		
		//Refresh button
		CButton refreshButton = ConfirmPanel.createRefreshButton(false);
		refreshButton.setMargin(new Insets (1, 10, 0, 10));
		refreshButton.setDefaultCapable(true);
		refreshButton.addActionListener(this);
		dialog.getConfirmPanel().addButton(refreshButton);
		dialog.getRootPane().setDefaultButton(refreshButton);
		
		if (getGridTab().getValue("C_Hes_ID") == null)
		{
			ADialog.error(0, dialog, "SaveErrorRowNotFound");
			return false;
		}
		
		MCurrency currency = new MCurrency(Env.getCtx(),(Integer) getGridTab().getValue("C_Currency_ID"), null);
		dialog.setTitle(getTitle());
		currencyField.setText(currency.getISO_Code());
		currencyField.setEditable(false);
		initPreInvoice();
	
		//bankAccount = new MBankAccount(Env.getCtx(), C_PreInvoiceG_ID, null);
		
		//loadBankAccount();
		
		if(someError)
		{
			return false;
		}
		else
		{
			return true;
		}
	}   //  dynInit
	
	protected void initPreInvoice ()
	{
		log.config("initPreInvoice");
		//KeyNamePair pp = new KeyNamePair(0,"");
		//  load PO Orders - Closed, Completed
		//preInvoiceField.removeActionListener(this);
		preInvoiceField.removeAllItems();
		//preInvoiceField.addItem(pp);
		
		ArrayList<KeyNamePair> list = loadPreInvoiceData();
		if(list.size() > 0)
		{
			for(KeyNamePair knp : list)
				preInvoiceField.addItem(knp);
			
			preInvoiceField.setSelectedIndex(0);
			preInvoiceField.addActionListener(this);
			
			KeyNamePair pp = (KeyNamePair)preInvoiceField.getSelectedItem();
			loadPreInvoice(pp.getKey());
			dialog.pack();
		}
		else
		{
			someError = true;
			ADialog.info(0,null,"Registros no encontrados.");
		}
		

		//****initBPDetails(C_BPartner_ID);
	}   //  initBPartnerOIS
	
	
	/**
	 *  Load PBartner dependent Order/Invoice/Shipment Field.
	 *  @param C_BPartner_ID BPartner
	 *  @param forInvoice for invoice
	 */
	protected ArrayList<KeyNamePair> loadPreInvoiceData ()
	{
		ArrayList<KeyNamePair> list = new ArrayList<KeyNamePair>();

		MCHes hes = new  MCHes(Env.getCtx(), (Integer)getGridTab().getValue("C_Hes_ID"), null);
		BigDecimal C_Currency_ID = new BigDecimal(hes.getC_Currency_ID());
		
		MClient client = new MClient(Env.getCtx(), null);
		
		StringBuffer sql = new StringBuffer("SELECT distinct p.C_PreInvoiceG_ID, p.value")
			.append(" FROM C_PreInvoiceG p"
					+ " INNER JOIN C_PreInvoiceLineG pl ON pl.C_PreInvoiceG_ID = p.C_PreInvoiceG_ID"
					+ " WHERE docstatus in ('IP','CO', 'CL')");
		
		if(hes.getC_PreInvoiceG_ID() > 0 )
		{
			sql = sql.append(" AND p.C_PreInvoiceG_ID = " + hes.getC_PreInvoiceG_ID());
			sql = sql.append(" AND pl.C_ContractLine_ID NOT IN (SELECT C_ContractLine_ID FROM C_HesLine WHERE C_Hes_ID = "+getGridTab().getValue("C_Hes_ID")+")");
		}
			
			
		
		if(C_Currency_ID.toString().equals(client.getC_Currency_ID()+""))
			sql = sql.append( " AND linenetamt_pure > 0 AND ((qty - COALESCE(qtyhes_veb,0)) > 0)");
		else
			sql = sql.append( " AND linenetamt_usd > 0 AND ((qty - COALESCE(qtyhes_usd,0)) > 0)");
		
		sql = sql.append(" ORDER BY p.value");
		//
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql.toString(), null);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				list.add(new KeyNamePair(rs.getInt(1), rs.getString(2)));
			}
		}
		catch (SQLException e)
		{
			log.log(Level.SEVERE, sql.toString(), e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}

		return list;
	}   //  initBPartnerOIS

    
	/**
	 *  </pre>
	 *  @throws Exception
	 */
    private void jbInit() throws Exception
    {
    	preInvoiceLabel.setText(Msg.translate(Env.getCtx(), "C_PreInvoiceG_ID"));
    	
    	CPanel parameterPanel = dialog.getParameterPanel();
    	parameterPanel.setLayout(new BorderLayout());
    	
    	CPanel parameterHesPanel = new CPanel();
    	parameterHesPanel.setLayout(new GridBagLayout());
    	parameterPanel.add(parameterHesPanel, BorderLayout.CENTER);
    	
    	parameterHesPanel.add(preInvoiceLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
    			,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	parameterHesPanel.add(preInvoiceField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
    				,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));

    	parameterHesPanel.add(currencyLabel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
    			,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	parameterHesPanel.add(currencyField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
    			,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));

    }   //  jbInit

	/*************************************************************************/
	
	/**
	 *  Action Listener
	 *  @param e event
	 */
	public void actionPerformed(ActionEvent e)
	{
		log.config("Action=" + e.getActionCommand());
//		Object source = e.getSource();
		if ( e.getActionCommand().equals(ConfirmPanel.A_REFRESH) )
		{
			Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
			//loadPreInvoice();
			dialog.tableChanged(null);
			Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
		}
		//  actionPerformed
		else if (e.getSource().equals(preInvoiceField))
		{
			KeyNamePair pp = (KeyNamePair)preInvoiceField.getSelectedItem();
			int C_PreInvoiceG_ID = 0;
			if (pp != null)
				C_PreInvoiceG_ID = pp.getKey();

			//preInvoiceField.setSelectedIndex(-1);
			loadPreInvoice(C_PreInvoiceG_ID);
		}
	}   
	
	
	protected void loadPreInvoice(int C_PreInvoiceG_ID)
	{
		loadTableOIS(getPreInvoiceData(C_PreInvoiceG_ID));
	}
	
	
	protected void loadTableOIS (Vector<?> data)
	{
		//  Remove previous listeners
		dialog.getMiniTable().getModel().removeTableModelListener(dialog);
		//  Set Model
		DefaultTableModel model = new DefaultTableModel(data, getOISColumnNames());
		model.addTableModelListener(dialog);
		dialog.getMiniTable().setModel(model);
		dialog.getMiniTable().getTableHeader().setReorderingAllowed(false);
		// 
		
		configureMiniTable(dialog.getMiniTable());
	}
	

	
	/**
	 *  List total amount
	 */
	public void info()
	{
		DecimalFormat format = DisplayType.getNumberFormat(DisplayType.Amount);

		BigDecimal total = new BigDecimal(0.0);
		int rows = dialog.getMiniTable().getRowCount();
		int count = 0;
		for (int i = 0; i < rows; i++)
		{
			if (((Boolean)dialog.getMiniTable().getValueAt(i, 0)).booleanValue())
			{
				total = total.add((BigDecimal)dialog.getMiniTable().getValueAt(i, 2));
				count++;
			}
		}
		dialog.setStatusLine(count, Msg.getMsg(Env.getCtx(), "Sum") + "  " + format.format(total));
	}   //  infoStatement */
	
	public void showWindow()
	{
		dialog.setSize(new Dimension(700,567));
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void closeWindow()
	{
		dialog.dispose();
	}
	
}
