/******************************************************************************
 Monitores 
 *****************************************************************************/
package org.pentanet.model;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.adempiere.apps.graph.PerformanceDetail;
import org.adempiere.apps.graph.PerformanceIndicator;
import org.compiere.apps.AEnv;
import org.compiere.apps.AWindow;
import org.compiere.apps.AZoomAcross;
import org.compiere.apps.ConfirmPanel;
import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.plaf.CompiereColor;
import org.compiere.print.MPrintColor;
import org.compiere.swing.CPanel;
import org.compiere.model.MGoal;
import org.compiere.model.MQuery;
import org.compiere.model.MRole;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.swing.CButton;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Ini;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
@SuppressWarnings("unused")
public class ViewMonitores extends CPanel
implements FormPanel, ActionListener
{
	private static final long serialVersionUID = 8022906851004145960L;
    private javax.swing.JPanel monitor;
    private javax.swing.JPanel monitordetalle;
    private JScrollPane ScrollMonitor;
    private JScrollPane ScrollMonitorDetalle;
    private int BottonesRow =0;
    private sincorinza refrescar ; 
	public void init (int WindowNo, FormFrame frame)
	{
		log.fine("");
		m_WindowNo = WindowNo;
		m_frame = frame;
		try
		{
			refrescar= new sincorinza();
			refrescar.start();
		    construyeTodo(m_frame);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "", e);
		}
		sizeIt();
	}	

	/**
	 * 	Size Window
	 */
	private void sizeIt()
	{
		m_frame.pack();
//			Dimension size = m_frame.getPreferredSize();
//			size.width = 2000;
//			m_frame.setSize(size);
	}	//	size

	/**
	 * 	Dispose
	 */
	public void dispose()
	{
		if (m_frame != null)
			m_frame.dispose();
		m_frame = null;
		removeAll();
		refrescar.stop(); 
	}	
	/**	Window No					*/
	private int         m_WindowNo = 0;
	/**	FormFrame					*/
	private FormFrame 	m_frame;
	/**	Logger	*/
	private static CLogger log = CLogger.getCLogger (ViewMonitores.class);
    private void construyeTodo(JFrame contenedor)
    {
     
        monitor = new javax.swing.JPanel();
        monitordetalle = new javax.swing.JPanel();
        monitordetalle.setLayout(new GridLayout(1,5));
        monitor.setLayout(new GridLayout(1,1));
        monitor.add(construyePanel());
        monitor.setBackground(new java.awt.Color(204, 204, 204));
        monitor.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        javax.swing.GroupLayout monitorLayout = new javax.swing.GroupLayout(monitor);

        ScrollMonitor = new JScrollPane(monitor);
        ScrollMonitor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollMonitor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        
        ScrollMonitorDetalle = new JScrollPane(monitordetalle);
        ScrollMonitorDetalle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollMonitorDetalle.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        monitorLayout.setHorizontalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        monitorLayout.setVerticalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        monitordetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        javax.swing.GroupLayout monitordetalleLayout = new javax.swing.GroupLayout(monitordetalle);
       // monitordetalle.setLayout(monitordetalleLayout);
        monitordetalleLayout.setHorizontalGroup(
            monitordetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        monitordetalleLayout.setVerticalGroup(
            monitordetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contenedor.getContentPane());
        contenedor.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollMonitorDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ScrollMonitorDetalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollMonitor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
 	}	


	/**
	 * 	Action Listener for Drill Down
	 *	@param e event
	 */
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() instanceof MButton)
		{
			MButton pi = (MButton)e.getSource();
			log.info(pi.getName());
			cmd_zoomAcross(pi.GetAD_Window_ID(),pi.GetNombreCampoID(),pi.GetValor_CampoID(), pi.GetAD_Table_ID());
		}
	}	

	private void cmd_zoomAcross(int la_ventana, String la_clave, int el_valor, int la_tabla)
	{
		int record_ID =el_valor;
		log.info("ID=" + record_ID);
		if (record_ID <= 0)
			return;
		MWindow el_windows = new MWindow(Env.getCtx(),la_ventana,null);
		MQuery query = new MQuery();
		String link = la_clave;
		if (link.length() == 0)
			link =la_clave;
		if (link.length() != 0)
		{
			query.addRestriction(link, MQuery.EQUAL,el_valor);
					
		}
	
		new MVentanaAsociada (this, 
				el_windows, la_tabla, query);
	}	
	
    private JScrollPane construyePanel()
    {
    	// Aqui realizo el query de monitor Padre
    	boolean lo_incluimos=false;
    	CPanel el_panel=  new CPanel();
    	MMONITOR[] goals = MMONITOR.getGoals(Env.getCtx());
		for (int i = 0; i < goals.length; i++)
		{
			lo_incluimos = construyePanel2(goals[i].get_ID());
			if(lo_incluimos)
			{
			   CButton pi=new CButton(goals[i].getName());
			   pi.addActionListener(this);
			   el_panel.add (pi);
			}
			
		}
		 el_panel.setLayout(new GridLayout(0,1));
        JScrollPane sc = new JScrollPane(el_panel);
        sc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "El Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)));
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return sc;   
    }
  
    
    private boolean construyePanel2(int el_Monitor)
    {
    	// Aqui realizo el query de monitor hijo
    	boolean encontro_algo=false;
    	String el_Nombre_Indicador ="";
		String sql = "SELECT * FROM MONITORLINE WHERE IsActive='Y' AND MONITOR_ID=" + el_Monitor  
				+ " ORDER BY MONITORLINE_ID";
			sql = MRole.getDefault(Env.getCtx(), false).addAccessSQL(sql.toUpperCase(), "MONITORLINE", 
				false, true);	//	RW to restrict Access
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try
			
			{
				pstmt = DB.prepareStatement (sql, null);
				rs = pstmt.executeQuery ();
				while (rs.next ())
				{
					MMONITORLINE el_indicador = new MMONITORLINE (Env.getCtx(), rs, null);
					el_Nombre_Indicador=el_indicador.getName();
					String sSqlDetalle = el_indicador.getQUERYMONITOR();
					
					MTable tmp_table = new MTable(Env.getCtx(),el_indicador.getTablaVentana(),null);
					
		
					String el_NombreDeTabla = tmp_table.get_ValueAsString("tablename");
					sSqlDetalle = MRole.getDefault(Env.getCtx(), false).addAccessSQL(sSqlDetalle.toUpperCase(),el_NombreDeTabla.toUpperCase(), 
							false, true);	//	RW to restrict Access	
					// Lleno el rs
					PreparedStatement pstmtdetalle = null;
					ResultSet rsdetalle = null;
					try
					{
						int lasFilas =GetBottonesRow(sSqlDetalle);
						int cols = ((lasFilas-1) % 8) + 1;
						CPanel el_panel = new CPanel (new GridLayout(0,2));
						pstmtdetalle = DB.prepareStatement (sSqlDetalle, null);
						rsdetalle = pstmtdetalle.executeQuery ();
						boolean encontro_detalle = false;
						while (rsdetalle.next ())
						{
							encontro_algo=true;
						    encontro_detalle=true;
							MButton el_boton = new MButton(rsdetalle.getString(el_indicador.getHTMLBUTTON()));
							el_boton.SetValor_CampoID(rsdetalle.getInt(el_indicador.getCOLUMNAMECLAVE()));
							el_boton.SetNombreCampoID(el_indicador.getCOLUMNAMECLAVE());
							el_boton.SetAD_Window_ID(el_indicador.getAD_Window_ID());
							el_boton.SetAD_Table_ID(el_indicador.getTablaVentana());
							int BUTTONWIDTH =el_indicador.getButtonHigh();
							int BUTTONHIGH= el_indicador.getButtonWidth();
							if(BUTTONWIDTH!=0 | BUTTONHIGH!=0  )
							{
								el_boton.setPreferredSize(new Dimension(BUTTONWIDTH,BUTTONHIGH));
							}
							else
							{
								el_boton.setPreferredSize(new Dimension(80,100));	
							}
							// El Color
							MPrintColor color = MPrintColor.get(Env.getCtx(),el_indicador.getAD_PrintColor_ID());
							Color keyColor = Color.lightGray;
							keyColor = color.getColor();
							el_boton.setBackground(keyColor);
							// La accion 
							el_boton.setActionCommand(String.valueOf(el_indicador.getCOLUMNAMECLAVE()));
							el_boton.addActionListener(this);
							
							el_panel.add(el_boton);
					        el_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), el_Nombre_Indicador));
						}
				        JScrollPane sc = new JScrollPane(el_panel);
				        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				        el_panel.setPreferredSize(new Dimension(cols*80, lasFilas*50));
				        if(encontro_detalle)
				        monitordetalle.add(sc);
					}
					catch (Exception e)
					{
					//	s_log.log (Level.SEVERE, sql, e);
					}
					finally
					{
						DB.close(rsdetalle, pstmtdetalle);
						rsdetalle = null; pstmtdetalle = null;
					}
				}
			}
			catch (Exception e)
			{
			//	s_log.log (Level.SEVERE, sql, e);
			}
			finally
			{
				DB.close(rs, pstmt);
				rs = null; pstmt = null;
			}
			return encontro_algo;
    }
    
//   Funciones para el Dato del Query del Monitor
    

    private int GetBottonesRow(String Sql)
    {

    	int iRetorno =0;
    	PreparedStatement pstmtdetalle = null;
		ResultSet rsdetalle = null;
		try
			{
				pstmtdetalle = DB.prepareStatement (Sql, null);
				rsdetalle = pstmtdetalle.executeQuery ();
				while (rsdetalle.next ())
					iRetorno++;
			}
			catch (Exception e)
			{
			//	s_log.log (Level.SEVERE, sql, e);
			}
			finally
			{
				DB.close(rsdetalle, pstmtdetalle);
				rsdetalle = null; pstmtdetalle = null;
			}
	   return iRetorno;	
    }
	@SuppressWarnings("serial")
	public class sincorinza extends Applet implements Runnable {
		public sincorinza () { 
			   super();
		   }
		private Thread hilo;
		int periodo_refresco = 20000; 
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
			monitor.removeAll();
			monitordetalle.removeAll();
			
			m_frame.remove(ScrollMonitor);
			m_frame.remove(ScrollMonitorDetalle);
			
        	 construyeTodo(m_frame);
			 m_frame.repaint();
		}

		/***********************************************************************
		* No confundirse: este metodo es el start del applet.
		* Desde aquí llamamos a start del hilo.
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