package org.pentanet.apps;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.compiere.minigrid.IDColumn;
import org.compiere.minigrid.MiniTable;
import org.compiere.swing.CTabbedPane;
import org.compiere.swing.CTextPane;
import org.compiere.swing.CLabel;
import org.compiere.apps.ADialog;
import org.compiere.apps.ConfirmPanel;
import org.compiere.apps.StatusBar;
import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.apps.form.PaySelect;
import org.compiere.swing.CPanel;
import org.compiere.util.ASyncProcess;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import org.pentanet.model.MHRequestline;
import org.pentanet.model.MSalesOrder;

/**
 * @author vcappugi
 * 
 */
@SuppressWarnings("unused")
public class Delivery extends CPanel implements FormPanel, ActionListener,
		TableModelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Window No */
	private int m_WindowNo = 0;
	/** FormFrame */
	private FormFrame m_frame;
	private JScrollPane scrollPane = new JScrollPane();
	private StatusBar statusBar = new StatusBar();

	private CPanel mainPanel = new CPanel();
	private CPanel selPanel = new CPanel();
	private JButton bCancel = ConfirmPanel.createCancelButton(true);
	private JButton bGenerate = ConfirmPanel.createProcessButton(true);
	private BorderLayout selPanelLayout = new BorderLayout();
	private MiniTable miniTable = new MiniTable();
	private TitledBorder newBorder;
	private GridBagLayout newLayout = new GridBagLayout();
	private BorderLayout mainLayout = new BorderLayout();

	/** Logger */
	public static CLogger log = CLogger.getCLogger(Delivery.class);

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == bCancel)
			dispose();
		else if (arg0.getSource() == bGenerate)
			generate();

	}

	@Override
	public void init(int WindowNo, FormFrame frame) {

		// log.info("");
		m_WindowNo = WindowNo;
		m_frame = frame;
		try {
			// Aqui se pintan los objetos que van dentro de la forma

			distribution();
			// frame.add(selPanel);
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
		} catch (Exception e) {
			// log.log(Level.SEVERE, "", e);
		}
	}

	@Override
	public void dispose() {
		if (m_frame != null)
			m_frame.dispose();
		m_frame = null;

	}// dispose

	/*
	 * Distribucion de los paneles y visualizacion de la forma
	 */
	private void distribution() {
		// Objetos insertables
		// JButton jbt1 = new JButton();
		// CTextPane text1 = new CTextPane();
		CPanel selPanelText = new CPanel();
		CPanel selPanelBot = new CPanel();
		CLabel label1 = new CLabel();
		selPanel.setBorder(newBorder);
		selPanel.setLayout(newLayout);

		miniTable_set();
		miniTable_fill();

		mainPanel.setLayout(mainLayout);

		mainPanel.add(selPanel, BorderLayout.NORTH);
		newBorder = new TitledBorder("Productos Solicitados");
		selPanel.add(scrollPane, null);
		scrollPane.getViewport().add(miniTable, null);

		bGenerate.addActionListener(this);
		bCancel.addActionListener(this);

		mainPanel.add(selPanelText, BorderLayout.CENTER);
		label1.setText("Selecciones los productos que despachará del almacen general");
		selPanelText.add(label1);
		// selPanelText.setBorder(newBorder);
		// selPanelText.setLayout(newLayout);

		mainPanel.add(selPanelBot, BorderLayout.SOUTH);
		selPanelBot.add(bGenerate);
		selPanelBot.add(bCancel);

	}

	@Override
	public void tableChanged(TableModelEvent arg0) {

	}

	/*
	 * Seteo de las dimensiones y estructura de la minitabla
	 */

	public void miniTable_set() {
		miniTable.addColumn("ID_Row");
		miniTable.addColumn("Documento");
		miniTable.addColumn("H_Request_ID");
		miniTable.addColumn("producto");
		miniTable.addColumn("M_Product_ID");
		miniTable.addColumn("UDM");
		miniTable.addColumn("C_UOM_ID");
		miniTable.addColumn("Cant");
		miniTable.addColumn("Directo");
		miniTable.addColumn("Seleccion");
		//
		miniTable.setMultiSelection(true);
		miniTable.setRowSelectionAllowed(true);
		// set details
		miniTable.setColumnClass(0, int.class, true, "ID_Row");
		miniTable.setColumnClass(1, String.class, true, "Documento");
		miniTable.setColumnClass(2, int.class, true, "H_Request_ID");
		miniTable.setColumnClass(3, String.class, true, "Producto");
		miniTable.setColumnClass(4, int.class, true, "M_Product_ID");
		miniTable.setColumnClass(5, String.class, true, "UDM");
		miniTable.setColumnClass(6, int.class, true, "C_UOM_ID");
		miniTable.setColumnClass(7, double.class, true, "Cant");

		miniTable.setColumnClass(8, Boolean.class, true, "Directo");
		miniTable.setColumnClass(9, Boolean.class, false, "Seleccion");

		// formato de Columnas
		miniTable.setColumnVisibility(miniTable.getColumn(0), false);
		miniTable.setColumnVisibility(miniTable.getColumn(2), false);
		miniTable.setColumnVisibility(miniTable.getColumn(4), false);
		miniTable.setColumnVisibility(miniTable.getColumn(6), false);

		miniTable.autoSize();
		miniTable.getModel().addTableModelListener(this);

	}

	/*
	 * Rellena la minitabla con los datos de las solicitudes
	 */

	public void miniTable_fill() {
		miniTable.setRowCount(5);
		miniTable.autoSize();
		int row = 0;
		//
		String sql_l = "select hrl.h_request_line_id, hrl.h_request_id, hrl.m_product_id, hrl.c_uom_id, hrl.qty, "
				+ "hr.name as request, pr.name as product, uom.name as uom"
				+ " from h_request_line hrl"
				+ " inner join h_request hr on hr.h_request_id = hrl.h_request_id"
				+ " inner join m_product pr on pr.m_product_id = hrl.m_product_id"
				+ " left join C_UOM_TRL uom on uom.c_uom_id = hrl.c_uom_id"
				+ " where hrl.processed='N' and hrl.delivery='N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql_l, "H_Request_line");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				miniTable.setRowCount(row + 1);
				miniTable.setValueAt(rs.getInt(1), row, 0); // Id de Linea de
															// Sol
				miniTable.setValueAt(rs.getString(6), row, 1); // Documento de
																// Solicitud
				miniTable.setValueAt(rs.getInt(2), row, 2); // ID Documento de
															// Solicitud
				miniTable.setValueAt(rs.getString(7), row, 3); // Producto
				miniTable.setValueAt(rs.getInt(3), row, 4); // ID del Producto
				miniTable.setValueAt(rs.getString(8), row, 5); // UDM
				miniTable.setValueAt(rs.getInt(4), row, 6); // ID de la UDM
				miniTable.setValueAt(rs.getDouble(5), row, 7); // Cantidad
				miniTable.setValueAt(es_directo(rs.getInt(3)), row, 8);
				miniTable.setValueAt(false, row, 9);

				// rs.getString(1);
				// rs.getInt(2);
				row++;
			}
		} catch (Exception e) {
			log.info(e.toString());
			// return e.toString();
		}
	}

	/*
	 * Determina si el producto es descarga directa de inventario o si es solo
	 * movimiento de almacen
	 */
	public Boolean es_directo(int m_product) {
		String indic = "N";
		String query = "select m_direct_delivery from m_product where m_product_id="
				+ m_product;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(query, "M_Product");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				indic = rs.getString(1);
			}
		} catch (Exception e) {
			// log.info(e.toString());
			return false;
		}

		if (indic.equalsIgnoreCase("Y"))
			return true;
		else
			return false;
	}// es_directo

	/*
	 * Generar las actividades luego de seleccionar los registros en la mini
	 * tabla
	 */
	public void generate() {
		int i;
		/*
		 * logica: cuando los productos sean descarga directa de almacen, se
		 * debe ubicar la orden de venta para agregarlos directamente Si no son,
		 * se debe crear el documento de movimiento de almacen con estos
		 * productos.
		 */
		for (i = 0; i < miniTable.getRowCount(); i++) {
			if (((Boolean) miniTable.getValueAt(i, 9)).booleanValue()) // Si
																		// esta
																		// seleccionado
				if (((Boolean) miniTable.getValueAt(i, 8)).booleanValue()) // Si
																			// es
																			// descarga
																			// directa
																			// de
																			// inventario
					carga_producto(miniTable.getValueAt(i, 0).toString());
			// ADialog.warn(m_WindowNo, null, "Estoy generando de la linea" +
			// miniTable.getValueAt(i, 0));

		}
		ADialog.warn(
				m_WindowNo,
				null,
				"Productos despachados, 1 Producto directo a Factura y 4 productos a ubicacion de piso ");

	}// generate

	/*
	 * Carga Productos directamente del almacen y lo incluye en la orden de
	 * venta (o consumo)
	 */
	public void carga_producto(String request_line_id) {
		int id_req = Integer.parseInt(request_line_id);
		MHRequestline req_line = new MHRequestline(Env.getCtx(), id_req, null);
		int unidad = req_line.getC_SalesRegion_ID();
		int seccion = req_line.getC_SalesRegionD_ID();
		int ubicacion = req_line.getH_Bed_ID();
		int M_Product_ID = req_line.getM_Product_ID();
		BigDecimal Qty = req_line.getQty();
		BigDecimal PriceList;
		int H_Asigned_Budget_ID = 0;
		int C_UOM_ID = req_line.getC_UOM_ID();

		int orden = 0;
		// Busco la orden que tiene esa localidad actualmente
		String sql_u = "SELECT C_Order_id FROM C_Order WHERE H_ADMISSION_ID =(SELECT H_Admission_ID FROM H_ADMISSION WHERE C_SalesRegion_ID="
				+ unidad
				+ " AND C_SalesRegionD_ID="
				+ seccion
				+ " and H_Bed_ID=" + ubicacion + ") ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql_u, "C_Order");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orden = rs.getInt(1);
			}
		} catch (Exception e) {
			// log.info(e.toString());
			return;
		}

		// ahora trabajo con la orden
		MSalesOrder Order = new MSalesOrder(Env.getCtx(), orden, null);
		// Order.CreateOrderLine(Order, M_Product_ID, Qty, PriceList, C_UOM_ID,
		// H_Asigned_Budget_ID, "CO");

	}// carga_producti

}
