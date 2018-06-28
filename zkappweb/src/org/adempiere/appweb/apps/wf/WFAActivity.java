package org.adempiere.appweb.apps.wf;

import java.util.Properties;
import java.util.logging.Level;


import org.adempiere.appweb.AppWindow;
import org.adempiere.appweb.apps.AEnv;
import org.adempiere.appweb.util.AppDialog;
import org.compiere.model.MColumn;
import org.compiere.model.MNote;
import org.compiere.model.MRole;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.wf.MWFActivity;
import org.compiere.wf.MWFNode;
import org.zkoss.zul.Panel;

public class WFAActivity  extends Panel{
	
	private Properties ctx;
	private AppWindow appwnd;
	
	/**	Window No					*/
	private int         		m_WindowNo = 0;
	/**	Open Activities				*/
	private MWFActivity[] 		m_activities = null;
	/**	Current Activity			*/
	private MWFActivity 		m_activity = null;
	/**	Current Activity			*/
	private int	 				m_index = 0;
	/**	Set Column					*/
	private	MColumn 			m_column = null;
	
	private static final CLogger log = CLogger.getCLogger (WFAActivity.class);
	
	public WFAActivity (Properties ctx, AppWindow appwindow){
        this.ctx = ctx;
        this.appwnd = appwindow;
        
        //init();
	}
	
	/**
	 * 	Search Activities
	 * 	@return int
	 */
	public boolean searchActivities(int record_id)
	{
		
		String sql = "SELECT * FROM AD_WF_Activity a "
				+ "WHERE a.Processed='N' AND a.WFState='OS' AND ("
				//	Owner of Activity
				+ " a.AD_User_ID=?"	//	#1
				//	Invoker (if no invoker = all)
				+ " OR EXISTS (SELECT * FROM AD_WF_Responsible r WHERE a.AD_WF_Responsible_ID=r.AD_WF_Responsible_ID"
				+ " AND COALESCE(r.AD_User_ID,0)=0 AND COALESCE(r.AD_Role_ID,0)=0 AND (a.AD_User_ID=? OR a.AD_User_ID IS NULL))"	//	#2
				// Responsible User
				+ " OR EXISTS (SELECT * FROM AD_WF_Responsible r WHERE a.AD_WF_Responsible_ID=r.AD_WF_Responsible_ID"
				+ " AND r.AD_User_ID=?)"		//	#3
				//	Responsible Role
				+ " OR EXISTS (SELECT * FROM AD_WF_Responsible r INNER JOIN AD_User_Roles ur ON (r.AD_Role_ID=ur.AD_Role_ID)"
				+ " WHERE a.AD_WF_Responsible_ID=r.AD_WF_Responsible_ID AND ur.IsActive='Y' AND ur.AD_User_ID=?)"	//	#4
				// JourneyManagement
				+ " OR (CASE WHEN "
				+ "	(select IsReq from ad_wf_node where ad_wf_node_id = a.ad_wf_node_id) in ('Y') THEN "
				+ "	Coalesce((select AD_User_ID from C_JourneyManagement where C_JourneyManagement_id = record_id),0) = ? END)" //    #5
				//
				+ ")  and  record_id = ? ORDER BY a.Priority DESC, Created";
		
				//int AD_User_ID = Env.getAD_User_ID(Env.getCtx());
				//MRole role = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
				//sql = role.addAccessSQL(sql, "a", true, false);
		
				int AD_User_ID = Env.getAD_User_ID(ctx);
				int AD_WF_Activity_ID = DB.getSQLValue(null, sql, new Object[]{AD_User_ID, AD_User_ID, AD_User_ID, AD_User_ID, AD_User_ID,record_id});
				log.warning("ADWFActivityID: " + AD_User_ID +" " + record_id);
				if(AD_WF_Activity_ID > 0){
					ctx.setProperty("#AD_WF_Activity_ID", String.valueOf(AD_WF_Activity_ID));
					log.warning("AD_WF_Activity_ID: " + AD_WF_Activity_ID);
					return true;
				}
				
				return false;
	}
	
	private void message( MWFActivity activity, String value, String textMsg)
	{
        String valor="";
		MNote avisar=new MNote(Env.getCtx(),0,null);
		avisar.setAD_Message_ID(283);                                                          //Mensage de Documento Generado
		int user = DB.getSQLValue(null, "Select ad_user_id from AD_WF_Activity where AD_WF_ACtivity_ID = "
				+ "(Select  min(ad_wf_activity_id) from ad_wf_activity where ad_wf_process_id="+activity.getAD_WF_Process_ID()+")");
		avisar.setAD_User_ID(user);                                  //ID del Usuario
		
		if (value.equalsIgnoreCase("Y"))
			valor="APROBADO";
		else
			valor="RECHAZADO";
		avisar.setTextMsg("Respuesta de documento fue " +valor+" Comentario: "+ textMsg );                                 //Texto Generado
		avisar.setAD_Table_ID(activity.getAD_Table_ID());                //Tabla
		avisar.setRecord_ID(activity.getRecord_ID());                                 //ID de registro
		//ADialog.warn(0, null,"se le aviso al usuario ");
		avisar.save();
	}
	
	/**
	 * 	Save
	 */
	@SuppressWarnings("unused")
	public void onOK(MWFActivity m_act)
	{
		
		m_activity = m_act;
		log.warning("Approved: " + m_activity);
		
		log.config("Activity=" + m_activity);
		if (m_activity == null)
			return;
		int AD_User_ID = Env.getAD_User_ID(Env.getCtx());
		String textMsg = null; //fTextMsg.getText();
		//fTextMsg.setText("");
		//
		MWFNode node = m_activity.getNode();
		
		
		Object forward = null;//fForward.getValue();

		// ensure activity is ran within a transaction - [ 1953628 ]
		Trx trx = Trx.get(Trx.createTrxName("FWFA"), true);
		m_activity.set_TrxName(trx.getTrxName());
		
		if (forward != null)
		{
			log.config("Forward to " + forward);
			int fw = ((Integer)forward).intValue();
			if (fw == AD_User_ID || fw == 0)
			{
				log.log(Level.SEVERE, "Forward User=" + fw);
				trx.rollback();
				trx.close();
				return;
			}
			if (!m_activity.forwardTo(fw, textMsg))
			{
				AppDialog.error(m_WindowNo, this, "CannotForward");
				trx.rollback();
				trx.close();
				return;
			}
		}
		//	User Choice - Answer
		else if (MWFNode.ACTION_UserChoice.equals(node.getAction()))
		{
			if (m_column == null)
				m_column = node.getColumn();
			//	Do we have an answer?
			int dt = m_column.getAD_Reference_ID();
			String value = null; //fAnswerText.getText();
			if (dt == DisplayType.YesNo || dt == DisplayType.List)
			{
				//ValueNamePair pp = (ValueNamePair)fAnswerList.getSelectedItem();
				value = AEnv.getAppweb_ID(ctx) == 1 ? "Y" : "N";//pp.getValue();
			}
			if (value == null || value.length() == 0)
			{
				AppDialog.error(m_WindowNo, this, "FillMandatory", Msg.getMsg(Env.getCtx(), "Answer"));
				trx.rollback();
				trx.close();
				return;
			}
			//
			log.config("Answer=" + value + " - " + textMsg);
			try
			{
				m_activity.setUserChoice(AD_User_ID, value, dt, textMsg);
				message(  m_activity, value, textMsg);
			}
			catch (Exception e)
			{
				log.log(Level.SEVERE, node.getName(), e);
				AppDialog.error(m_WindowNo, this, "Error", e.toString());
				trx.rollback();
				trx.close();
				return;
			}
		}
		//	User Action
		else
		{
			log.config("Action=" + node.getAction() + " - " + textMsg);
			try
			{
				// ensure activity is ran within a transaction
				m_activity.setUserConfirmation(AD_User_ID, textMsg);
			}
			catch (Exception e)
			{
				log.log(Level.SEVERE, node.getName(), e);
				AppDialog.error(m_WindowNo, this, "Error", e.toString());
				trx.rollback();
				trx.close();
				return;
			}
			
		}
		
		trx.commit();
		trx.close();


		//	Next
			//loadActivities();
			//display(-1);
	}	//	onOK
	
}
