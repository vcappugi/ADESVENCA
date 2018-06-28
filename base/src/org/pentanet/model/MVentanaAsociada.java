package org.pentanet.model;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import org.compiere.apps.AEnv;
import org.compiere.apps.AWindow;
import org.compiere.model.MQuery;
import org.compiere.model.MRMA;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Ini;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;


@SuppressWarnings("unused")
public class MVentanaAsociada 
{
	/**
	 *	Constructor
	 *  @param invoker component to display popup (optional)
	 *  @param tableName table name
	 *  @param query query
	 */
	public MVentanaAsociada (JComponent invoker, MWindow el_windows,int la_tabla, MQuery query)
	{
		MTable tmp_table = new MTable(Env.getCtx(),la_tabla,null);
		
		log.config("TableName=" + el_windows.getName() + " - " + query);
		m_tableName = tmp_table.get_ValueAsString("tablename");
		m_query = query;
		
		
		//	See What is there
		getZoomTargets (invoker,  el_windows);
	}	//	AReport

	/**	The Query						*/
	private MQuery	 	m_query;
	/**	The Popup						*/
	private JPopupMenu 	m_popup = new JPopupMenu("ZoomMenu");
	/**	The Option List					*/
	private ArrayList<KeyNamePair>	m_list = new ArrayList<KeyNamePair>();
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(MVentanaAsociada.class);
	/** Table Name */
	private String m_tableName;

	/**
	 * 	Get the Zomm Targets for the table.
	 *  Fill the list and the popup menu
	 *  @param invoker component to display popup (optional)
	 * 	@param tableName table
	 */
	private void getZoomTargets (JComponent invoker, MWindow el_windows)
	{
		
		int AD_Window_ID = el_windows.get_ID();
		String Name = el_windows.getName();
		addTarget(m_tableName, AD_Window_ID, Name, null);
		if (invoker.isShowing())
			m_popup.show(invoker, 0, invoker.getHeight());
	
	    //End - afalcone - Bug Fix [ 1659420 ] Usability: zoom across
		
	}	//	getZoomTargets

	/**
	 * 	Check Target and Add to popup
	 *	@param targetTableName table name
	 *	@param AD_Window_ID window
	 *	@param Name name
	 *	@param isSO has po/so Window
	 *	@return true if there is a record
	 */
	private boolean addTarget (String targetTableName, 
		int AD_Window_ID, String Name, Boolean isSO)
	{
		String sql = "SELECT COUNT(*) FROM " + targetTableName
			+ " WHERE " + m_query.getWhereClause(false);
		String sqlAdd = "";
		if (isSO != null)
		{
			sqlAdd = " AND IsSOTrx=" + (isSO.booleanValue() ? "'Y'" : "'N'");
		}
		int count = DB.getSQLValue(null, sql+sqlAdd);
		if (count < 0 && isSO != null)	//	error try again w/o SO
			count = DB.getSQLValue(null, sql);
		if (count <= 0)
			return false;
		//
		KeyNamePair pp = new KeyNamePair (AD_Window_ID, Name + " (#"+count+")");
		launchZoom (pp);
		return true;
	}	//	checkTarget
	

	/**
	 * 	Launch Zoom
	 *	@param pp KeyPair
	 */
	@SuppressWarnings("deprecation")
	private void launchZoom (KeyNamePair pp)
	{
		int AD_Window_ID = pp.getKey();
		log.info("AD_Window_ID=" + AD_Window_ID 
			+ " - " + m_query); 
		AWindow frame = new AWindow();
		if (!frame.initWindow(AD_Window_ID, m_query))
			return;
		AEnv.addToWindowManager(frame);
		if (Ini.isPropertyBool(Ini.P_OPEN_WINDOW_MAXIMIZED) ) 
		{
			AEnv.showMaximized(frame);
		}
		else
		{
			AEnv.showCenterScreen(frame);
		}
		frame = null;
	}	//	launchZoom
	
}	//	AZoom
