package org.pentanet.process;

import java.util.List;
import java.util.logging.Level;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.wf.MWFNextCondition;
import org.compiere.wf.MWFNode;
import org.compiere.wf.MWFNodeNext;
import org.compiere.wf.MWorkflow;

public class CreateWFNodes extends SvrProcess{

	private List<MWFNode> listNode;
	private List<MWFNodeNext> listNodeNext;
	private List<MWFNextCondition> listNextCondition;
	private int AD_Workflow_FROM;
	private String sql;
	private int nodeTo;
	@Override
	protected void prepare() {
		
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("AD_WorkFlow_ID"))
				AD_Workflow_FROM = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		
	}

	@Override
	protected String doIt() throws Exception {
		
		String whereClause = " AD_WF_Node.AD_Workflow_ID = ? ";
		
		//Listado de Nodos (FROM)
		listNode = new Query(getCtx(), MWFNode.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(new Object[]{AD_Workflow_FROM})
		.setOnlyActiveRecords(true)
		.setOrderBy(MWFNode.COLUMNNAME_AD_WF_Node_ID)
		.list();
		
		//Recorrer nodos FROM
		for(MWFNode nodeFrom : listNode)
		{
			
			//Crear o Editar Nodo (TO)
			MWFNode nodeTo = getNode(nodeFrom.getValue());
			
			nodeTo.setAD_Workflow_ID(getRecord_ID());
			nodeTo.setValue(nodeFrom.getValue());
			nodeTo.setName(nodeFrom.getName());
			nodeTo.setEntityType(nodeFrom.getEntityType());
			nodeTo.setAD_WF_Responsible_ID(nodeFrom.getAD_WF_Responsible_ID());
			nodeTo.setAction(nodeFrom.getAction());
			nodeTo.setAD_Column_ID(nodeFrom.getAD_Column_ID());
			nodeTo.save();
			
			//Eliminar Nodo siguiente y condiciones
			//Lista de Nodos Siguientes (TO)
			listNodeNext = new Query(getCtx(), MWFNodeNext.Table_Name, "AD_WF_Node_ID=?", get_TrxName())
			.setParameters(new Object[]{nodeTo.getAD_WF_Node_ID()})
			.setOnlyActiveRecords(true)
			.setOrderBy(MWFNodeNext.COLUMNNAME_SeqNo)
			.list();
			
			for(MWFNodeNext nodeNextTo : listNodeNext)
			{
				DB.executeUpdate("DELETE * FROM AD_WF_NextCondition WHERE AD_WF_NodeNext_ID = " + nodeNextTo.getAD_WF_NodeNext_ID(), null);
				nodeNextTo.delete(true);
			}
		}
		
		
		//Recorrer nodos FROM (Para Crear Nodos Siguiente)
		for(MWFNode nodeFrom : listNode)
		{
			//Lista de Nodos Siguientes (FROM)
			listNodeNext = new Query(getCtx(), MWFNodeNext.Table_Name, "AD_WF_Node_ID=?", get_TrxName())
			.setParameters(new Object[]{nodeFrom.getAD_WF_Node_ID()})
			.setOnlyActiveRecords(true)
			.setOrderBy(MWFNodeNext.COLUMNNAME_SeqNo)
			.list();
			
			for(MWFNodeNext nodeNextFrom : listNodeNext)
			{
				//Nodo según nodeNext
				MWFNode nodeFrom_Next = new MWFNode(Env.getCtx(), nodeNextFrom.getAD_WF_Next_ID(), null);
				MWFNode nodeTo_Next = getNode(nodeFrom_Next.getValue());
				
				//Nodo según nodeFrom
				MWFNode nodeTo = getNode(nodeFrom.getValue());
				
				//Crear Nodo Siguiente (TO)
				MWFNodeNext nodeNextTo = new MWFNodeNext(Env.getCtx(), 0, null);
				nodeNextTo.setAD_WF_Node_ID(nodeTo.getAD_WF_Node_ID());
				nodeNextTo.setAD_WF_Next_ID(nodeTo_Next.getAD_WF_Node_ID());
				nodeNextTo.setSeqNo(nodeNextFrom.getSeqNo());
				nodeNextTo.setEntityType(nodeNextFrom.getEntityType());
				nodeNextTo.save();
				
				//Crear Condición
				//Lista de Condiciones (FROM)
				listNextCondition = new Query(getCtx(), MWFNextCondition.Table_Name, "AD_WF_NodeNext_ID=?", get_TrxName())
				.setParameters(new Object[]{nodeNextFrom.getAD_WF_NodeNext_ID()})
				.setOnlyActiveRecords(true)
				.setOrderBy(MWFNextCondition.COLUMNNAME_SeqNo)
				.list();
				
				for(MWFNextCondition conditionFrom : listNextCondition)
				{
					//Crear Condición (TO)
					MWFNextCondition conditionTo = new MWFNextCondition(Env.getCtx(), 0, null);
					conditionTo.setAD_WF_NodeNext_ID(nodeNextTo.getAD_WF_NodeNext_ID());
					conditionTo.setEntityType(conditionFrom.getEntityType());
					conditionTo.setAD_Column_ID(conditionFrom.getAD_Column_ID());
					conditionTo.setAndOr(conditionFrom.getAndOr());
					conditionTo.setOperation(conditionFrom.getOperation());
					conditionTo.setSeqNo(conditionFrom.getSeqNo());
					conditionTo.setValue(conditionFrom.getValue());
					conditionTo.save();
				}
				
			}
			
		}
		
		return null;
	}

	
	/*
	 * Obtener Nodo TO
	 * Parametro Value
	 */
	private MWFNode getNode(String value) {
		
		sql = "SELECT MAX(AD_WF_Node_ID) FROM AD_WF_Node WHERE AD_Workflow_ID = "+ getRecord_ID()
				+ " AND value = '" + value + "'";
		
		int node = DB.getSQLValue(null, sql);
		
		if(node==-1)
			node = 0;
			
		return new MWFNode(Env.getCtx(), node, null);
	}
	
	
}
