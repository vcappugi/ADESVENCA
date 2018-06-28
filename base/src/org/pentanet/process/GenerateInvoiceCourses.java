package org.pentanet.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.*;
import org.compiere.apps.ADialog;
import org.compiere.util.Env;
import org.pentanet.model.X_HR_CompetitorCourses;
import org.pentanet.model.X_HR_TakenCourses;
import org.pentanet.model.X_HR_TakenCourses_Line;
import org.pentanet.model.X_HR_TakenCourses_par;

import java.util.*;
import java.sql.*;
import java.text.*; 

public class GenerateInvoiceCourses extends SvrProcess{
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {

		String sql= "SELECT id_activity, max(HR_TakenCourses_par_id) FROM HR_TakenCourses_par WHERE processed = 'N' GROUP BY id_activity";
		PreparedStatement pstmt = DB.prepareStatement (sql,get_TrxName());
		ResultSet rs = pstmt.executeQuery ();
		
		while (rs.next ())
		{
		    //Buscar en la Tabla par
		    X_HR_TakenCourses_par tcp = new X_HR_TakenCourses_par(getCtx(), rs.getInt(2), get_TrxName());

		    //Nueva Cabecera de Cursos Realizados
		    X_HR_TakenCourses tc = new X_HR_TakenCourses(getCtx(), 0, null);
		    tc.setValue(tcp.getValue());
		    tc.setName(tcp.getName());
		    tc.setC_BPartner_ID(tcp.getBPartner_Institute());
		    tc.setEndCourse(tcp.getEndCourse());
		    tc.setStartCourse(tcp.getStartCourse());
		    tc.setC_Country_ID(tcp.getC_Country_ID());
		    tc.setC_Region_ID(tcp.getC_Region_ID());
		    tc.setC_City_ID(tcp.getC_City_ID());
		    tc.setHR_Courses_ID(tcp.getID_Activity());
		    tc.save();
		    //ADialog.warn(0, null,"id udm" + tcp.getValue());
		    
		    //Cargar Proveedores
		    String sqlp= "SELECT bpartner_provider, max(HR_TakenCourses_par_id), sum(costamt) FROM HR_TakenCourses_par WHERE id_activity = " + rs.getInt(1) + " group by bpartner_provider";
		    PreparedStatement pstmtp = DB.prepareStatement (sqlp,get_TrxName());
		    ResultSet rsp = pstmtp.executeQuery ();
		    while (rsp.next ())
		    {
		            //ADialog.warn(0, null,"id udm" + rsp.getInt(3));
		        //Buscar en la Tabla par
		        X_HR_TakenCourses_par tcpl = new X_HR_TakenCourses_par(getCtx(), rsp.getInt(2), get_TrxName());
		    
		        //Nueva Cabecera de Cursos Realizados
		        X_HR_TakenCourses_Line tcl = new X_HR_TakenCourses_Line(getCtx(), 0, null);
		                tcl.setHR_TakenCourses_ID(tc.getHR_TakenCourses_ID());
		                tcl.setC_BPartner_ID(tcpl.getBPartner_Provider());
		                int sc = DB.getSQLValue(null,"SELECT HR_ServicesCourses_ID FROM HR_ServicesCourses WHERE m_product_exp_id =" + tcpl.getM_Product_Exp_ID());
		                tcl.setHR_ServicesCourses_ID(sc);
		                tcl.setCostAmt(rsp.getBigDecimal(3));
		        tcl.save();
		        
			    //Cargar Empleados del curso
			    String sqle= "SELECT HR_TakenCourses_par_id FROM HR_TakenCourses_par WHERE id_activity = " + rs.getInt(1) + " AND bpartner_provider = "+ tcpl.getBPartner_Provider() +" :: varchar ";
			    PreparedStatement pstmte = DB.prepareStatement (sqle,get_TrxName());
			    ResultSet rse = pstmte.executeQuery ();
			    while (rse.next ())
			    {
			            //ADialog.warn(0, null,"id udm" + rsp.getInt(3));
			        //Buscar en la Tabla par
			        X_HR_TakenCourses_par tcpe = new X_HR_TakenCourses_par(getCtx(), rse.getInt(1), get_TrxName());
			    
			        //Nueva Cabecera de Cursos Realizados
			        X_HR_CompetitorCourses tcc = new X_HR_CompetitorCourses(getCtx(), 0, null);
			                tcc.setHR_TakenCourses_ID(tc.getHR_TakenCourses_ID());
			                tcc.setHR_TakenCourses_Line_ID(tcl.getHR_TakenCourses_Line_ID());
			                tcc.setC_BPartner_ID(tcpe.getBPartner_Employee());
			                int cc = DB.getSQLValue(null,"SELECT C_Activity_ID  FROM workedtime_activity("+ tcpe.getBPartner_Employee() +")");
			                tcc.setC_Activity_ID(cc);
			                boolean cost = DB.getSQLValueString(null,"SELECT IsCost FROM workedtime_activity("+ tcpe.getBPartner_Employee() +")") == "Y" ? true : false;
			                tcc.setIsCost(cost);
			        tcc.save();
			        
			    }
			    pstmte.close();
			    rse.close();
		        
		        
		    }
		    pstmtp.close();
		    rsp.close();

		} // Registros de Cursos realizado Par

		return "Listo....";
	}
	
	
}