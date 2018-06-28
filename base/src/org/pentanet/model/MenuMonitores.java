/******************************************************************************
 Monitores 
 *****************************************************************************/
package org.pentanet.model;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

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
import org.compiere.model.MTreeNode;
import org.compiere.model.MWindow;
import org.compiere.swing.CButton;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Ini;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.pentanet.model.MButton;
import org.pentanet.model.MMONITOR;
import org.pentanet.model.MMONITORLINE;
import org.pentanet.model.MVentanaAsociada;
import org.pentanet.model.ViewMonitores.sincorinza;
@SuppressWarnings("unused")
public class MenuMonitores extends CPanel implements FormPanel, ActionListener, TreeSelectionListener
{
	private static final long serialVersionUID = 8022906851004145960L;
    private javax.swing.JPanel monitor;
    private javax.swing.JPanel monitordetalle;
    private JScrollPane ScrollMonitor;
    private JScrollPane ScrollMonitorDetalle;
    private int BottonesRow =0;
    private sincorinza refrescar ; 
    private int el_monitorActual =0;
    private int el_tiempo = 30000;
    
    // el panel principal
    private javax.swing.JPanel el_panel_principal;
    private JScrollPane Scroll_el_menu;
    private  JTree el_menu;
    private MTreeNode  	m_root = null;
    private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	private JPopupMenu popMenuTree = new JPopupMenu();
	public void init (int WindowNo, FormFrame frame)
	{
		log.fine("");
		m_WindowNo = WindowNo;
		m_frame = frame;
		try
		{
			m_root = new MTreeNode (0, 0, "Monitores", "Monitores", 0, true, null, false, null);
//			DefaultMutableTreeNode top = new DefaultMutableTreeNode("Los Monitores");
	        AddMonitores(m_root);
	
	        el_menu = new JTree(m_root);
	        el_menu.addTreeSelectionListener(this);
	        el_menu.getSelectionModel().setSelectionMode
	                (TreeSelectionModel.SINGLE_TREE_SELECTION);
	        
	        el_menu.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                el_menuMouseClicked(evt);
	            }
	        });
	        
	        Scroll_el_menu = new JScrollPane(el_menu);
	        monitor = new javax.swing.JPanel();
	        monitor.setLayout(new GridLayout(1,1));
	        monitor.add(construyePanel());
	        monitor.setBackground(new java.awt.Color(204, 204, 204));
	        monitor.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

	        ScrollMonitor = new JScrollPane(monitor);
	        ScrollMonitor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        ScrollMonitor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        
	        splitPane.setTopComponent(Scroll_el_menu);
	        splitPane.setDividerLocation(300); 
	        splitPane.setPreferredSize(new Dimension(1200, 800));
	        splitPane.setTopComponent(Scroll_el_menu);
	        splitPane.setBottomComponent(monitor);
	        m_frame.add(splitPane);
	        
			refrescar= new sincorinza();
			refrescar.start();
	        //sizeIt();

	       // construyeTodo(m_frame);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "", e);
		}
		sizeIt();
	}	

	@SuppressWarnings("deprecation")
	private void el_menuMouseClicked(java.awt.event.MouseEvent evt) {

		// TODO add your handling code here:
		if (SwingUtilities.isLeftMouseButton(evt)
				&& evt.getClickCount() == 2)
			{
				int selRow = el_menu.getRowForLocation(evt.getX(), evt.getY());
				if(selRow != -1)
				{
					TreePath selPath = el_menu.getPathForLocation(evt.getX(), evt.getY());
					el_menu.setSelectionPath(selPath);
					
					Rectangle r = el_menu.getPathBounds(el_menu.getSelectionPath());
					if(r!=null){
				        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				        		el_menu.getLastSelectedPathComponent();
				        if (node == null) return;
				        Object nodeInfo = node.getUserObject();
				        if (node.isLeaf()) 
				        {
					      el_monitor_Info el_item = (el_monitor_Info)nodeInfo;

							try
							{
								//	Create instance w/o parameters
							    El_monitor frm = new El_monitor(el_item.getel_monitor(), this);
							    frm.setel_tiempo(el_item.getel_descanso());
							    frm.show();
								
							}
							catch (Exception e)
							{
							}

					      
					      
					      //aqui llamo a la nueva ventana y Listo;
					      
					//		popMenuTree.show(el_menu, (int)r.getMaxX(), (int)r.getY());
					      
					      
				        }
					}else{
					  popMenuTree.show(el_menu, evt.getX(), evt.getY());
					}

				}
			}
		else if (SwingUtilities.isRightMouseButton(evt))
		{
			int selRow = el_menu.getRowForLocation(evt.getX(), evt.getY());
			TreePath selPath = el_menu.getPathForLocation(evt.getX(), evt.getY());
			if(selRow != -1){
				el_menu.setSelectionPath(selPath);
				
				Rectangle r = el_menu.getPathBounds(el_menu.getSelectionPath());
				if(r!=null){
					popMenuTree.show(el_menu, (int)r.getMaxX(), (int)r.getY());
				}else{
				  popMenuTree.show(el_menu, evt.getX(), evt.getY());
				}
		/*		if(m_hasBar){
					MTreeNode nd = (MTreeNode)tree.getSelectionPath().getLastPathComponent();
					firePropertyChange(NODE_SELECTION_RIGHT, null, nd);
				}*/
			}
		}

	}

	
	/**
	 * 	Size Window
	 */
	private void sizeIt()
	{
//		m_frame.pack();
			Dimension size = m_frame.getPreferredSize();
			size.width = 1000;
			m_frame.setSize(size);
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
	private static CLogger log = CLogger.getCLogger (MenuMonitores.class);

    private JScrollPane construyePanel()
    {
    	// Aqui realizo el query de monitor Padre
    	boolean lo_incluimos=false;
    	CPanel el_panel=  new CPanel();
        el_panel.setLayout(new GridLayout(0,1));
        JScrollPane sc = new JScrollPane(el_panel);
        sc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "El Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)));
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return sc;   
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
    private void AddMonitores(DefaultMutableTreeNode top) 
    {
       	MMONITOR[] monitores = MMONITOR.getGoals(Env.getCtx());
    	for (int i = 0; i < monitores.length; i++)
    	{
            DefaultMutableTreeNode la_categoria = null;
            la_categoria = new DefaultMutableTreeNode(new el_monitor_Info
 	               (monitores[i].getName(),
 	            		   monitores[i].get_ID()));
            top.add(la_categoria);
    		AddDetalleMonitores(monitores[i].get_ID(),la_categoria);
   		}
   }
    private boolean AddDetalleMonitores(int el_Monitor,DefaultMutableTreeNode top)
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
					DefaultMutableTreeNode el_monitorline = null;
					el_monitor_Info la_informacion = new el_monitor_Info
			  	               (el_indicador.getName(),
				  	            		 el_indicador.getMONITORLINE_ID());
					la_informacion.setel_descanso(la_informacion.busca_tiempo_descanso(el_Monitor));
					
					el_monitorline = new DefaultMutableTreeNode(la_informacion);					
//					category = new DefaultMutableTreeNode(el_Nombre_Indicador);
					top.add(el_monitorline);
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
    public class el_monitor_Info {
        public String el_titulo;
        public int el_monitor_id;
        public int el_descanso =10000;
        
        public el_monitor_Info(String el_titulo, int el_monitor) {
        	this.el_titulo = el_titulo;
        	this.el_monitor_id= el_monitor;
        	this.setel_descanso(busca_tiempo_descanso(el_monitor));
        }

        public String toString() {
            return this.el_titulo;
        }
        public int getel_monitor()
        {
        	return this.el_monitor_id;
        }
        public int getel_descanso()
        {
        	return this.el_descanso;
        }
        public void setel_descanso(int el_tiempo)
        {
        	this.el_descanso=el_tiempo;
        }
        public int busca_tiempo_descanso(int el_monitor)
        {
        	int el_retorno = 10000;
           	MMONITOR monitor = new MMONITOR(Env.getCtx(),el_monitor,null);
           	el_retorno = monitor.getThread();
        	
        	
        	return el_retorno;
        }
    }

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
        		el_menu.getLastSelectedPathComponent();
        if (node == null) return;
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) 
        {
	      el_monitor_Info el_item = (el_monitor_Info)nodeInfo;
	      
	      
        }
        else  // es la raiz del monitor
        {
        	
        	el_monitor_Info el_item = (el_monitor_Info)nodeInfo;
        	ActualizaDetalle(el_item.getel_monitor());
        	el_monitorActual=el_item.getel_monitor();
			refrescar.stop();
			refrescar=null;
        	el_tiempo = el_item.getel_descanso();
			refrescar= new sincorinza();
			refrescar.start();
        }
        

	}
	private void ActualizaDetalle(int el_monitor)
	{
		if(monitor!=null)
		monitor.removeAll();
		if(ScrollMonitorDetalle!=null)
		this.remove(ScrollMonitorDetalle);
		
		construyePanel2(el_monitor);
        splitPane.setBottomComponent(monitor);
        splitPane.setDividerLocation(300); 

		

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
							  encontro_detalle=true;
						      String initialText =EvaluaHtml(el_indicador.getHTMLBUTTON(),rsdetalle); 
		                      MButton el_boton = new MButton();
						      el_boton.setText(initialText);
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
				        monitor.add(sc);
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
    
    private String EvaluaHtml(String htmlbutton, ResultSet rsdetalle) {
		String sRetorno="";
		sRetorno=EvaluaSitaxis(Env.getCtx(), htmlbutton,rsdetalle);
		
		return sRetorno;
	}
	public static String EvaluaSitaxis(Properties ctx, String text,ResultSet rsdetalle)
	{
		if (text == null || text.length() == 0)
			return text;

		String inStr = text;
		String token;
		StringBuffer outStr = new StringBuffer();

		int i = inStr.indexOf('@');
		while (i != -1)
		{
			outStr.append(inStr.substring(0, i));			// up to @
			inStr = inStr.substring(i+1, inStr.length());	// from first @

			int j = inStr.indexOf('@');						// next @
			if (j < 0)										// no second tag
			{
				inStr = "@" + inStr;
				break;
			}

			token = inStr.substring(0, j);
			 try
			   {
				   outStr.append(rsdetalle.getString(token));			// replace context	   
			   }
				catch (Exception e)
				{
					//	s_log.log (Level.SEVERE, sql, e);
			    }		   
			inStr = inStr.substring(j+1, inStr.length());	// from second @
			i = inStr.indexOf('@');
		}

		outStr.append(inStr);           					//	add remainder
		return outStr.toString();
	}   //  parseTranslation

    
	@SuppressWarnings("serial")
	public class sincorinza extends Applet implements Runnable {
		public sincorinza () { 
			   super();
		   }
		private Thread hilo;


		/************************************************************************
		* run del hilo: se duerme durante un segundo
		***********************************************************************/
		public void run() {
			while ( hilo != null ) {
				try {
					Thread.sleep( el_tiempo );
				}
				catch (InterruptedException e ) { return; }
				paint();
			}
		}

		public void paint(  ) {
			ActualizaDetalle(el_monitorActual);
       
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
   
}