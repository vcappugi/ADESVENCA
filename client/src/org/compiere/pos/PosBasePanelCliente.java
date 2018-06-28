package org.compiere.pos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MPOS;
import org.compiere.swing.CFrame;
import org.compiere.swing.CPanel;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "unused", "serial" })
public class PosBasePanelCliente extends javax.swing.JPanel {
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private PosTable 	m_table;
    private PosPanelLogo posPanelLogo1;
    private SubAboveFunctionKeys f_subpanel;
    private PosBasePanel _PosBasePanel ;
    private String			m_sql;
	private static String s_sqlWhere = "C_Order_ID=? AND LineNetAmt <> 0";    
	private static String s_sqlFrom = "C_Order_LineTax_v";
    public PosBasePanelCliente(PosBasePanel valor) {
    	_PosBasePanel=valor;
    	initComponents();
    }
	/**	Table Column Layout Info			*/
	private static ColumnInfo[] s_layout = new ColumnInfo[] 
	{
		new ColumnInfo(" ", "C_OrderLine_ID", IDColumn.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "Name"), "Name", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "Qty"), "QtyOrdered", Double.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_UOM_ID"), "UOMSymbol", String.class),
		new ColumnInfo(Msg.translate(Env.getCtx(), "PriceActual"), "PriceActual", BigDecimal.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "LineNetAmt"), "LineNetAmt", BigDecimal.class), 
		new ColumnInfo(Msg.translate(Env.getCtx(), "C_Tax_ID"), "TaxIndicator", String.class), 
	};
    private void initComponents() {

    	m_table = new PosTable();
    	
    	
    	posPanelLogo1 = new PosPanelLogo();
        f_subpanel = new SubAboveFunctionKeys(_PosBasePanel);
        jPanel2 = new javax.swing.JPanel();
    	m_table = new PosTable();
		CScrollPane scroll = new CScrollPane(m_table);
		m_sql = m_table.prepareTable (s_layout, s_sqlFrom, 
				s_sqlWhere, false, "C_Order_LineTax_v")
				+ " ORDER BY Line";
		
		//	m_table.addMouseListener(this);

		m_table.setColumnVisibility(m_table.getColumn(0), false);
		m_table.getColumn(1).setPreferredWidth(175);
		m_table.getColumn(2).setPreferredWidth(75);
		m_table.getColumn(3).setPreferredWidth(30);
		m_table.getColumn(4).setPreferredWidth(75);
		m_table.getColumn(5).setPreferredWidth(75);
		m_table.getColumn(6).setPreferredWidth(30);
		m_table.setFocusable(false);
		m_table.setFillsViewportHeight( true ); //@Trifon
		m_table.growScrollbars();


        posPanelLogo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));



        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_subpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(posPanelLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(posPanelLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_subpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>
    public void dispose() {
		dispose();
		
	}
    public SubAboveFunctionKeys getf_subpanel()
    {
    	return f_subpanel;
    }
    public PosPanelLogo getposPanelLogo1()
    {
    	return  posPanelLogo1;
    }
	public PosTable	getm_table()
	{
		return m_table;
	}    
	
	public void setm_table(PosTable value)
	{
		m_table=value;
		
	} 
}
