package org.pentanet.process;

import java.util.ArrayList;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.eevolution.model.MHRProcess;
import org.pentanet.model.X_HR_Retroactive;
import org.pentanet.model.X_HR_Retroactive_Line;


public class Retroactiveline extends SvrProcess{

	
	public List<MHRProcess> listProcess; // Listado de Proecess
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		CreateRetroactiveline();
		return null;
	}
	
	public void CreateRetroactiveline(){

		Object[] par = new Object[]{getRecord_ID(),getRecord_ID()};
		// RE-Process, delete Retroactive_Line
		int no = DB.executeUpdateEx("DELETE FROM HR_Retroactive_Line "
				+ "WHERE NOT hr_retroactive_line_id IN (select distinct hr_retroactive_line_id "
				+ "from hr_movement_ret where HR_Retroactive_ID = ?) AND HR_Retroactive_ID = ? ",
				par, get_TrxName());
		log.info("HR_Retroactive_Line deleted #"+ no);
		

		X_HR_Retroactive ret = new X_HR_Retroactive(getCtx(), getRecord_ID(), get_TrxName());
		
		// Lista los Procesos de nominas que se encuentren en un rango de fecha
		String whereClause = "(DateAcct BETWEEN ? AND ?) AND HR_Payroll_ID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(ret.getStartDate());
		params.add(ret.getEndDate());
		params.add(ret.getHR_Payroll_ID());
			
		listProcess = new Query(getCtx(), MHRProcess.Table_Name, whereClause.toString(), get_TrxName())
		.setParameters(params)
		.setOnlyActiveRecords(true)
		.setOrderBy(MHRProcess.COLUMNNAME_DateAcct)
		.list();
		
		for( MHRProcess pros : listProcess){
			String rlines =  DB.getSQLValueString(get_TrxName(),"SELECT distinct hr_retroactive_line_id :: varchar from hr_movement_ret "
					+ "WHERE hr_retroactive_id = "+getRecord_ID() +" AND HR_Process_ID = " + pros.getHR_Process_ID());
			if(rlines == null){
				X_HR_Retroactive_Line retl = new X_HR_Retroactive_Line(getCtx(), 0, get_TrxName());
				retl.setAD_Org_ID(ret.getAD_Org_ID());
				retl.setName(pros.getName());
				retl.setHR_Process_ID(pros.getHR_Process_ID());
				retl.setHR_Retroactive_ID(getRecord_ID());
				retl.saveEx();
			}
		}
		
	}

}
