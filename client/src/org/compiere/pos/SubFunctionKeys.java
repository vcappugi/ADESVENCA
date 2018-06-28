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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import org.adempiere.util.ProcessUtil;
import org.compiere.apps.ADialog;
import org.compiere.apps.AEnv;
import org.compiere.apps.form.FormPanel;
import org.compiere.model.Callout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.GridTabVO;
import org.compiere.model.GridWindowVO;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.MProcess;
import org.compiere.print.MPrintColor;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.swing.CButton;
import org.compiere.swing.CPanel;
import org.compiere.swing.CScrollPane;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;


/**
 *	Function Key Sub Panel
 *	
 *  @author Comunidad de Desarrollo OpenXpertya 
 *         *Basado en Codigo Original Modificado, Revisado y Optimizado de:
 *         *Copyright (c) Jorg Janke
 *  @version $Id: SubFunctionKeys.java,v 1.1 2004/07/12 04:10:04 jjanke Exp $
 */
@SuppressWarnings("unused")
public class SubFunctionKeys extends PosSubPanel implements PosKeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2131406504920855582L;
	
	private PosBasePanel _posPanel;
	
	private List<String> activeCallouts = new ArrayList<String>();
	private List<Callout> activeCalloutInstance = new ArrayList<Callout>();
	
	/**
	 * 	Constructor
	 *	@param posPanel POS Panel
	 */
	public SubFunctionKeys (PosBasePanel posPanel)
	{
		super (posPanel);
		_posPanel=posPanel;
	}	//	PosSubFunctionKeys
	
	/**	Keys				*/
	private MPOSKey[] 	m_keys;
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(SubFunctionKeys.class);
	
	/**
	 * 	Initialize
	 */
	public void init()
	{
		int C_POSKeyLayout_ID = p_pos.getC_POSKeyLayout_ID();
		if (C_POSKeyLayout_ID == 0)
			return;
		
		PosKeyPanel panel = new PosKeyPanel(C_POSKeyLayout_ID, this);
		this.setLayout(new MigLayout("fill, ins 0"));
		add(panel, "growx, growy");
//		lasFunciones= new PosFuntionKeys(_posPanel);

	}	//	init
	
	/**
	 * 	Dispose - Free Resources
	 */
	public void dispose()
	{
		super.dispose();
	}	//	dispose

	/**
	 * Call back from key panel
	 */
	public void keyReturned(MPOSKey key) {

		String[] args = null;
		String laClase="";
		if(!key.get_ValueAsString("type").isEmpty())
		{
			if(key.get_ValueAsString("type").equalsIgnoreCase("J"))
			{
				
				//int methodStart = laClase.lastIndexOf('.');
				String MetodoName = key.get_ValueAsString("code");
				
				try {
					Class<?> classToCall = Class.forName("org.compiere.pos.PosFuntionKeys");
					
					try {
						Method methodToExecute = classToCall.getDeclaredMethod(MetodoName, new Class[]{ PosBasePanel.class});
						try {
							methodToExecute.invoke(classToCall.newInstance(), _posPanel);
							return;
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		if ( p_posPanel.m_order==null)
		{
			InfoProductPOS info =  new InfoProductPOS(new java.awt.Frame(),true);
			info.setAlmacen(super.p_pos.getM_Warehouse_ID());
			AEnv.showCenterWindow(Env.getFrame(this), info);


			return;
		}	
		// new line
		p_posPanel.f_curLine.setM_Product_ID(key.getM_Product_ID());
		p_posPanel.f_curLine.setPrice();
		p_posPanel.f_curLine.setQty(key.getQty());
		if ( !p_posPanel.f_curLine.saveLine() )
		{
			ADialog.error(0, this, "Could not save order line");
		}
		p_posPanel.updateInfo();
		return;
	}
	protected boolean openForm (int m_WindowNo, String className, String name)
	{
		FormPanel 	m_panel = null;
		log.info("AD_Form_ID=" + m_WindowNo + " - Class=" + className);
		Properties ctx = Env.getCtx();
		Env.setContext(ctx, m_WindowNo, "WindowName", name);
	

		try
		{
			//	Create instance w/o parameters
			m_panel = (FormPanel)Class.forName(className).newInstance();
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Class=" + className + ", AD_Form_ID=" + m_WindowNo, e);
			return false;
		}
		//
		
		m_panel.init(m_WindowNo,null);
		
		return true;
	}	//	openForm
	
	
}	//	PosSubFunctionKeys
