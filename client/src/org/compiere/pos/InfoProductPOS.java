/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.pos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

import org.compiere.model.I_C_Payment;
import org.compiere.model.I_M_Product;
import org.compiere.model.MPayment;
import org.compiere.model.MRole;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

import com.lowagie.text.Rectangle;

/**
 *	Search Product and return selection
 *
 *  @author     Jorg Janke
 *  @version    $Id: InfoProduct.java,v 1.4 2006/07/30 00:51:27 jjanke Exp $
 * 
 * @author Bogdan Ioan, SC ARHIPAC SERVICE SRL
 * 				<li>FR [ 2012362 ] Info Product: Add Product Category 
 */
@SuppressWarnings("unused")
public class InfoProductPOS extends  javax.swing.JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2076229793041196087L;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbCategoria;
    private Object[]		o_Categorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosSeleccionado;
    private javax.swing.JTextField txtBarra;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtBusqueda;
    private int el_almacen=0;
    private int la_lista=0;
    private String la_Seleccion="";

    /** Creates new form InfoProductPOS */
    @SuppressWarnings("serial")
	public InfoProductPOS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        o_Categorias= CargaCategorias();
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT);
        tablaProductos.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );        
        tablaProductos.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        TableColumn column = tablaProductos.getColumnModel().getColumn(2);
        column.setCellRenderer(new CustomRenderer());  
/*        tablaProductos.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaProductos.getColumnModel().getColumn(5).setWidth(0);*/
        tablaProductos.removeColumn(tablaProductos.getColumnModel().getColumn(5));
        
        // Tabla de Productos Seeccion
        tablaProductosSeleccionado.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Seleccion", "Codigo", "Nombre", "Precio", "Existencia","M_PRODUCT_ID"
                }
            ) {
                @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
                    java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
                };

                @SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });

    }
   
    @SuppressWarnings("serial")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBarra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox(o_Categorias);
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        tablaProductosSeleccionado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscar.setText("");
        btnBuscar.setIcon(Env.getImageIcon("Find24.gif")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Codigo");

        txtCodigo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("C. Barra");

        txtBarra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarraKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        cbCategoria.setEditable(true);
        cbCategoria.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAceptar.setText("");
        btnAceptar.setIcon(Env.getImageIcon("Process24.gif")); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("");
        btnCancelar.setIcon(Env.getImageIcon("Cancel24.gif")); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(585, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        tablaProductos.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seleccion", "Codigo", "Nombre", "Precio", "Existencia","M_PRODUCT_ID"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(300);
        tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    public String getla_Seleccion()
    {
    	return la_Seleccion;
    }
    public void setAlmacen(int valor)
    {
    	this.el_almacen=valor;
    }
    public void selLista(int valor)
    {
    	this.la_lista=valor;
    }
	private Object[] CargaCategorias()
	{
		String sql = "SELECT m_product_category_id , Name FROM M_Product_Category WHERE IsActive='Y' ORDER BY 2";
		sql = MRole.getDefault().addAccessSQL(sql, "M_Product_Category", MRole.SQL_NOTQUALIFIED, MRole.SQL_RO);
		return DB.getKeyNamePairs(sql, true);
	}
	

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {  
 	
    	DefaultTableModel model_Dialogo = (DefaultTableModel) tablaProductos.getModel();
    	DefaultTableModel model_Seleccion = (DefaultTableModel) tablaProductosSeleccionado.getModel();
    	String sClausula ="";
		KeyNamePair p = (KeyNamePair)this.cbCategoria.getSelectedItem();
		if (p != null && p.getKey() > 0)
		{
			sClausula=" and m_product_category_id="+p.getID().toString();
		}
		else
		{
			sClausula=" and 1=1";
		}
		if(!this.txtCodigo.getText().isEmpty())
		{
			sClausula=sClausula +" And UPPER(m_product.value) like '%"+ this.txtCodigo.getText().toUpperCase()+"%'"; 
		}
		if(!this.txtNombre.getText().isEmpty())
		{
			sClausula=sClausula +" And UPPER(m_product.name) like '%"+ this.txtNombre.getText().toUpperCase()+"%'";
		}
		String sItemSelect="";


		// Agrego lo seleccionado de la tabla modelo local

        for (int iPos = 0; iPos < model_Dialogo.getRowCount(); iPos++) 
        {
           if((Boolean)model_Dialogo.getValueAt(iPos, 0))
           {
               String sValue=model_Dialogo.getValueAt(iPos, 1).toString();
	           String sNombre=model_Dialogo.getValueAt(iPos, 2).toString();
	           double dPrecio=Double.valueOf(model_Dialogo.getValueAt(iPos, 3).toString());
	           double dExistencia=Double.valueOf(model_Dialogo.getValueAt(iPos, 4).toString());
	           int M_PRODUCT_ID=Integer.valueOf(model_Dialogo.getValueAt(iPos,5).toString());
	           model_Seleccion.addRow(new Object[] {true,sValue,sNombre,dPrecio,dExistencia,M_PRODUCT_ID}); 
           }
        }		
		
		sItemSelect=getSelectItem(tablaProductosSeleccionado,0,5);	
		
		
		model_Dialogo.setRowCount(0);
		
		if(!sItemSelect.isEmpty())
			  sClausula=sClausula+" And m_product.m_product_id not in("+sItemSelect+")";		

		String sql =setQuerySql(sClausula,el_almacen,la_lista);
		//"SELECT value,name,c_uom_id,m_product_category_id FROM M_Product WHERE " + sClausula +"  and IsActive='Y' ORDER BY name";
		//sql = MRole.getDefault().addAccessSQL(sql, "m_product", MRole.SQL_NOTQUALIFIED, MRole.SQL_RO);
		
		if(!sItemSelect.isEmpty())
		{
	        for (int iPos = 0; iPos < model_Seleccion.getRowCount(); iPos++) 
	        {
	               String sValue=model_Seleccion.getValueAt(iPos, 1).toString();
		           String sNombre=model_Seleccion.getValueAt(iPos, 2).toString();
		           double dPrecio=Double.valueOf(model_Seleccion.getValueAt(iPos, 3).toString());
		           double dExistencia=Double.valueOf(model_Seleccion.getValueAt(iPos, 4).toString());
		           int M_PRODUCT_ID=Integer.valueOf(model_Seleccion.getValueAt(iPos,5).toString());
		           model_Dialogo.addRow(new Object[] {true,sValue,sNombre,dPrecio,dExistencia,M_PRODUCT_ID});  
	        }	
	        model_Seleccion.setRowCount(0);
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, null);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
		           String sValue=rs.getString("value");
		           String sNombre=rs.getString("name");
		           double dPrecio=rs.getDouble("PRICESTD");
		           double dExistencia=rs.getDouble("qtyavailable");
		           int M_PRODUCT_ID=rs.getInt("M_PRODUCT_ID") ;
		           model_Dialogo.addRow(new Object[] {false,sValue,sNombre,dPrecio,dExistencia,M_PRODUCT_ID});  
			}
		}
		catch (Exception e)
		{
			String sValue="error";
			sValue="dd";
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}

    }                                        
   private String setQuerySql(String sClausula,int el_almacen,int la_lista )
   {
	   String sql="SELECT m_product.M_PRODUCT_ID,m_product.VALUE,  m_product.NAME,  SUM(m_product_stock_v.QTYAVAILABLE) AS qtyavailable, m_product_stock_v.M_WAREHOUSE_ID, ";
	   sql=sql+"M_PRODUCTPRICE.PRICESTD,M_PRODUCTPRICE.M_PRODUCT_ID FROM m_product,m_product_stock_v,M_PRODUCTPRICE,M_PRICELIST_VERSION WHERE m_product.VALUE = m_product_stock_v.VALUE ";
	   sql=sql+"AND m_product.AD_CLIENT_ID = m_product_stock_v.AD_CLIENT_ID AND m_product.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID ";
	   sql=sql+"AND M_PRICELIST_VERSION.M_PRICELIST_VERSION_ID = M_PRODUCTPRICE.M_PRICELIST_VERSION_ID "  + sClausula  ;
	   sql=sql+" AND m_product.ISACTIVE = 'Y' AND M_PRICELIST_VERSION.M_PRICELIST_ID = " + la_lista +" ";
	   sql=sql+"GROUP BY m_product.M_PRODUCT_ID,m_product.VALUE,m_product.NAME,m_product_stock_v.M_WAREHOUSE_ID,M_PRODUCTPRICE.PRICESTD,M_PRODUCTPRICE.M_PRODUCT_ID,M_PRICELIST_VERSION.M_PRICELIST_ID ORDER BY m_product.NAME ";
	   /*
	   String sql="SELECT m_product.value, m_product.name, sum(m_product_stock_v.qtyavailable) as qtyavailable,m_product_stock_v.m_warehouse_id " ;
	   sql= sql + "FROM m_product,m_product_stock_v WHERE m_product.value = m_product_stock_v.value AND m_product.ad_client_id = m_product_stock_v.ad_client_id and ";
	   */
	 //  sql ="SELECT VALUE, NAME, 1 AS qtyavailable, 2 as PRICESTD from adempiere.m_product";

/*	   String sql="SELECT m_product.M_PRODUCT_ID,m_product.VALUE,  m_product.NAME,  SUM(m_product_stock_v.QTYAVAILABLE) AS qtyavailable, m_product_stock_v.M_WAREHOUSE_ID, ";
	   sql=sql+"M_PRODUCTPRICE.PRICESTD,M_PRODUCTPRICE.M_PRODUCT_ID FROM m_product,m_product_stock_v,M_PRODUCTPRICE,M_PRICELIST_VERSION WHERE m_product.VALUE = m_product_stock_v.VALUE ";
	   sql=sql+"AND m_product.AD_CLIENT_ID = m_product_stock_v.AD_CLIENT_ID AND m_product.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID ";
	   sql=sql+"AND M_PRICELIST_VERSION.M_PRICELIST_VERSION_ID = M_PRODUCTPRICE.M_PRICELIST_VERSION_ID "  + sClausula + " AND m_product_stock_v.M_WAREHOUSE_ID =" ;
	   sql=sql+el_almacen + " AND m_product.ISACTIVE = 'Y' AND M_PRICELIST_VERSION.M_PRICELIST_ID = " + la_lista +" ";
	   sql=sql+"GROUP BY m_product.M_PRODUCT_ID,m_product.VALUE,m_product.NAME,m_product_stock_v.M_WAREHOUSE_ID,M_PRODUCTPRICE.PRICESTD,M_PRODUCTPRICE.M_PRODUCT_ID,M_PRICELIST_VERSION.M_PRICELIST_ID ORDER BY m_product.NAME ";
*/	   
	   
	   
	   return sql;
   }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	la_Seleccion="";
    	this.dispose();
    }                                        

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	la_Seleccion=getSelectItem(tablaProductos,0,5);
    	this.dispose();
    }                                        

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
    }                                  

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
    }                                  

    private void txtBarraKeyTyped(java.awt.event.KeyEvent evt) {                                  
        // TODO add your handling code here:
    }

    private String getSelectItem(javax.swing.JTable laTabla,int ColSel,int ColVal)
    {
    	String elRetorno="";
        DefaultTableModel model_local = (DefaultTableModel) laTabla.getModel();
        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
        {
           if((Boolean)model_local.getValueAt(iPos, ColSel))
           {
               String sItem=model_local.getValueAt(iPos, ColVal).toString();
               if(elRetorno.isEmpty())
            	   elRetorno=sItem;
               else
            	   elRetorno=elRetorno+","+sItem;
           }
        }
    	return elRetorno;
    }
    class CustomRenderer implements TableCellRenderer  
    {  
        JScrollPane scrollPane;  
        JTextArea textArea;  
       
        public CustomRenderer()  
        {  
            textArea = new JTextArea();  
            textArea.setWrapStyleWord(false);
           
            scrollPane = new JScrollPane(textArea); 
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        }  
       
        public Component getTableCellRendererComponent(JTable table,  
                                                       Object value,  
                                                       boolean isSelected,  
                                                       boolean hasFocus,  
                                                       int row, int column)  
        {  
            textArea.setText((String)value);  
            scrollPane.setBorder(null);
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = 
                new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            
            try {
            	textArea.getHighlighter().removeAllHighlights();
                if(txtNombre.getText().isEmpty())
                	  return scrollPane;  
                Document doc = textArea.getDocument();
                String text = doc.getText(0, doc.getLength());
                int pos = 0;
                while ((pos = text.toUpperCase().indexOf(txtNombre.getText().toUpperCase(), pos)) >= 0) {
                	textArea.getHighlighter().addHighlight(pos, pos+txtNombre.getText().length(), highlightPainter);
                    pos +=txtNombre.getText().length();
                }

              } catch (Exception ble) 
              {

              }
        return scrollPane;  
        }  
  }
  
  
}	