package org.pentanet.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.EMail;
import org.compiere.model.MClient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.pentanet.model.MCBudgetPublicExecLine;
import org.pentanet.model.X_HR_WorkedTimeLine;
import org.compiere.util.Env;

public class GenerateEmployeeRotation extends SvrProcess{
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		
		Integer user = Env.getContextAsInt(getCtx() , 0, "#AD_User_ID");
		String sql="SELECT COUNT(C_BPartner_ID) FROM HR_WorkedTimeLine WHERE HR_WorkedTime_ID="+getRecord_ID();
		Integer cant_emp=DB.getSQLValue(null,sql);

		Integer ab=0;
		if (cant_emp==0)
		{
			ab=1;
		}
		else //if(ADialog.ask(0, null,"Se volverá a Generar Proceso","Se eliminarán los datos cargados y se volverán a generar turnos por empleado")==true)
		{
			DB.executeUpdate("DELETE FROM HR_WorkedTimeLine WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
			ab=1;
		}

		if(ab==1)
		{
			//Filtrado por semana o mes
			int a=DB.getSQLValue(null,"SELECT NetDays FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID());

			int [] turno = new int[a];

			//Obtener Empleados del Grupo de Trabajo
			sql="SELECT COUNT(C_BPartner_ID) FROM HR_WorkGroup_Employee WHERE IsActive='Y' AND HR_WorkGroup_ID IN "
				+ "(SELECT HR_WorkGroup_ID FROM HR_WorkGroup WHERE HR_Standing_ID IN "
				+ "(SELECT HR_Standing_ID FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+"))";
			int hay = DB.getSQLValue(null,sql);  
		
			if(hay==0)
			{
				sql="SELECT C_BPartner_ID FROM HR_Employee WHERE IsActive='Y' AND HR_Standing_ID IN "
					+"(SELECT HR_Standing_ID FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+")";
			}
			else
			{
				sql="SELECT C_BPartner_ID FROM HR_Employee WHERE IsActive='Y' AND C_BPartner_ID IN "
			    	+"(SELECT C_BPartner_ID FROM HR_WorkGroup_Employee WHERE HR_WorkGroup_ID IN "
			    	+"(SELECT HR_WorkGroup_ID FROM HR_WorkGroup WHERE HR_Standing_ID IN "
			    	+"(SELECT HR_Standing_ID FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+")))";

			}
		
			PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
			ResultSet rs;
			try 
			{
				rs = pstmt.executeQuery ();
				while(rs.next())
				{
					  String vnul="N";
					  //Tomar centro de Costo que se puso en el WorkedTime
					  sql="SELECT Coalesce(C_Activity_ID,0) FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID();
					  int actividad=DB.getSQLValue(null,sql);
	
					  //Determinar si el empleado es LOTTT-Administrativo
					  sql="SELECT HR_Payroll_Type_line_ID FROM HR_Employee WHERE C_BPartner_ID="+rs.getInt(1);
					  int tipo_nomina=DB.getSQLValue(null,sql);
		
					  int admin=0;
					  if(tipo_nomina==1000001) //Nómina Administrativa --Centro de Costo Fijo
					  {
						    sql="SELECT C_Activity_ID FROM HR_Department WHERE HR_Department_ID IN "
						    	+"(SELECT HR_Department_ID FROM HR_Employee WHERE C_BPartner_ID="+rs.getInt(1)+")";
						    actividad=DB.getSQLValue(null,sql);
						    admin=1;
					  }
		
					  //Cargar turnos de Movimientos de Rotación a Tiempo Trabajado
					  for(int i=0;i<a;i++)
					  {
						    //Saber si el dia es Feriado
						    sql="SELECT qty_holidays((SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+"), "
						    	+"(SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+"),0,"+rs.getInt(1)+")";
						    int feriado=DB.getSQLValue(null,sql);
			
						    //Si el empleado es administrativo, cargar como dia de descanso
						    if((tipo_nomina==1000001)&&(feriado>=1)) {
						    	turno[i]=1000004;
						    }
						    else if(tipo_nomina==1000004) { //Si el empleado es eventual, cargar turno eventual
						    	turno[i]=1000058;
						    }
						    else {
						    	sql = "SELECT HR_Turn_ID FROM HR_RotationMove WHERE C_BPartner_ID="+rs.getInt(1)+" AND "
							    	 +"(SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+") BETWEEN DateStart AND DateEnd";
						    	turno[i]=DB.getSQLValue(null,sql);
						    }
			
						    //Verifica si esta de Vacaciones
						    sql="SELECT COUNT(*) FROM HR_Vacation WHERE IsPaid='Y' AND BtnProcess='Y' AND C_BPartner_ID="+rs.getInt(1)+" AND "
						    	+"((SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+") BETWEEN DateStart AND DateEnd)";
						    int vac=DB.getSQLValue(null,sql);
						    
						    if(vac>0)
						    {
						    	//Verifica si el programado coincide con el efectivo
						    	sql="SELECT COUNT (*) FROM HR_Vacation vac "+
						    		 "INNER JOIN HR_Vacation_Incidence vacl ON vacl.HR_Vacation_ID=vac.HR_Vacation_ID "+
						    		 "WHERE vac.IsPaid='Y' AND vac.BtnProcess='Y' AND vac.C_BPartner_ID="+rs.getInt(1)+" AND " +
						    		 "( (SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+") BETWEEN vac.DateStart AND vac.DateEnd) "+
						    		 "( (SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+") BETWEEN vacl.DateStart AND vacl.DateEnd) "+
						    		 "AND vacl.IsProgramated='N' AND vacl.IsAnticipated='N' AND vacl.IsReprogManual='N' AND vacl.IsReprogPay='N'";
						    	int coincide=DB.getSQLValue(null,sql);
						    	if(coincide>0)
						    	{
						    		turno[i]=1000057; //Vacación (V)
						    	}
						    	else
						    	{
						    		turno[i]=1000118; //Regreso de Vacaciones Anticipadas (RVA)
						    	}
						    }
						    
						    //Anticipo de Vacaciones
					    	sql="SELECT COUNT (*) FROM HR_Vacation vac "+
						    	"INNER JOIN HR_Vacation_Incidence vacl ON vacl.HR_Vacation_ID=vac.HR_Vacation_ID "+
						    	"WHERE AND vac.BtnProcess='Y' AND vac.C_BPartner_ID="+rs.getInt(1)+" AND " +
						    	"( (SELECT (DateStart +"+i+") FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+") BETWEEN vacl.DateStart AND vacl.DateEnd) "+
						    	"AND vacl.IsProgramated='N' AND vacl.IsAnticipated='Y' AND vacl.IsReprogManual='N' AND vacl.IsReprogPay='N'";
						    int vac_anti=DB.getSQLValue(null,sql);
						    if(vac_anti>0)
						    {
						    	turno[i]=1000116; //Vacaciones Anticipadas (VA)
						    }
			
						    if(turno[i]==-1)
						    {
						      vnul="Y";
						      i=a+1;
						    }
		
					  }
		
					  X_HR_WorkedTimeLine rot = new X_HR_WorkedTimeLine(getCtx(), 0, null);  //creo un registro en HR_WorkedTimeLine
					  rot.setHR_WorkedTime_ID(getRecord_ID());
					  rot.setC_BPartner_ID(rs.getInt(1));
		
					  if(vnul=="N") //Verifica si tiene rotacion
					  {
							if(a>=1)
							 rot.setD1_ID(turno[0]);
							if(a>=2)
							 rot.setD2_ID(turno[1]);
							if(a>=3) 
							 rot.setD3_ID(turno[2]);
							if(a>=4)
							 rot.setD4_ID(turno[3]); 
							if(a>=5)
							 rot.setD5_ID(turno[4]); 
							if(a>=6)
							 rot.setD6_ID(turno[5]); 
							if(a>=7)
							 rot.setD7_ID(turno[6]);
							if(a>=8)
							 rot.setD8_ID(turno[7]);
							if(a>=9)
							 rot.setD9_ID(turno[8]);
							if(a>=10)
							 rot.setD10_ID(turno[9]);
							if(a>=11)
							 rot.setD11_ID(turno[10]);
							if(a>=12)
							 rot.setD12_ID(turno[11]);
							if(a>=13)
							 rot.setD13_ID(turno[12]);
							if(a>=14) 
							 rot.setD14_ID(turno[13]);
							if(a>=15)
							 rot.setD15_ID(turno[14]); 
							if(a>=16)
							 rot.setD16_ID(turno[15]); 
							if(a>=17)
							 rot.setD17_ID(turno[16]); 
							if(a>=18)
							 rot.setD18_ID(turno[17]);
							if(a>=19)
							 rot.setD19_ID(turno[18]);
							if(a>=20)
							 rot.setD20_ID(turno[19]);
							if(a>=21)
							 rot.setD21_ID(turno[20]);
							if(a>=22)
							 rot.setD22_ID(turno[21]);
							if(a>=23) 
							 rot.setD23_ID(turno[22]);
							if(a>=24)
							 rot.setD24_ID(turno[23]); 
							if(a>=25)
							 rot.setD25_ID(turno[24]); 
							if(a>=26)
							 rot.setD26_ID(turno[25]); 
							if(a>=27)
							 rot.setD27_ID(turno[26]);
							if(a>=28)
							 rot.setD28_ID(turno[27]);
							if(a>=29)
							 rot.setD29_ID(turno[28]);
							if(a>=30)
							 rot.setD30_ID(turno[29]);
							if(a>=31)
							 rot.setD31_ID(turno[30]);
					  }
		
					  if(((admin==1)||(actividad!=0))&&(vnul=="N"))
					  {
							if(a>=1)
							 rot.setActivity1_ID(actividad);
							if(a>=2)
							 rot.setActivity2_ID(actividad);
							if(a>=3) 
							 rot.setActivity3_ID(actividad);
							if(a>=4)
							 rot.setActivity4_ID(actividad);
							if(a>=5)
							 rot.setActivity5_ID(actividad);
							if(a>=6)
							 rot.setActivity6_ID(actividad); 
							if(a>=7)
							 rot.setActivity7_ID(actividad);
							if(a>=8)
							 rot.setActivity8_ID(actividad);
							if(a>=9)
							 rot.setActivity9_ID(actividad);
							if(a>=10)
							 rot.setActivity10_ID(actividad);
							if(a>=11)
							 rot.setActivity11_ID(actividad);
							if(a>=12)
							 rot.setActivity12_ID(actividad);
							if(a>=13)
							 rot.setActivity13_ID(actividad);
							if(a>=14) 
							 rot.setActivity14_ID(actividad);
							if(a>=15)
							 rot.setActivity15_ID(actividad); 
							if(a>=16)
							 rot.setActivity16_ID(actividad); 
							if(a>=17)
							 rot.setActivity17_ID(actividad);
							if(a>=18)
							 rot.setActivity18_ID(actividad);
							if(a>=19)
							 rot.setActivity19_ID(actividad);
							if(a>=20)
							 rot.setActivity20_ID(actividad);
							if(a>=21)
							 rot.setActivity21_ID(actividad);
							if(a>=22)
							 rot.setActivity22_ID(actividad);
							if(a>=23) 
							 rot.setActivity23_ID(actividad);
							if(a>=24)
							 rot.setActivity24_ID(actividad);
							if(a>=25)
							  rot.setActivity25_ID(actividad);
							if(a>=26)
							  rot.setActivity26_ID(actividad);
							if(a>=27)
							  rot.setActivity27_ID(actividad);
							if(a>=28)
							  rot.setActivity28_ID(actividad);
							if(a>=29)
							  rot.setActivity29_ID(actividad);
							if(a>=30)
							  rot.setActivity30_ID(actividad);
							if(a>=31)
							  rot.setActivity31_ID(actividad);
		
					    }
					    rot.save(); 
				}
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}


			//Actualizar Encargados de Elaborar Revisar y Aprobar
			sql="SELECT (Case WHEN Elaborate1_ID is null Then 0 ELSE Elaborate1_ID END), "
					+"(Case WHEN Elaborate2_ID is null Then 0 ELSE Elaborate2_ID END), (Case WHEN Revise1_ID is null Then 0 ELSE Revise1_ID END), "
					+ "(Case WHEN Revise2_ID is null Then 0 ELSE Revise2_ID END), (Case WHEN Approve1_ID is null Then 0 ELSE Approve1_ID END), "
					+ "(Case WHEN Approve2_ID is null Then 0 ELSE Approve2_ID END)  FROM HR_ZonaOperacion WHERE HR_ZonaOperacion_ID IN "
					+ "(SELECT HR_ZonaOperacion_ID FROM HR_Standing WHERE HR_Standing_ID IN (SELECT HR_Standing_ID FROM HR_WorkedTime WHERE HR_WorkedTime_ID="+getRecord_ID()+"))";

			PreparedStatement pstusu = DB.prepareStatement (sql, get_TrxName());
			ResultSet rs_usu;

			try 
			{
				rs_usu = pstusu.executeQuery ();
				while(rs_usu.next())
				{
					int usuario;
				  
					if(rs_usu.getInt(1)!=0)
					{
						usuario=rs_usu.getInt(1);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Elaborate1_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					if(rs_usu.getInt(2)!=0)
					{
						usuario=rs_usu.getInt(2);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Elaborate2_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					if(rs_usu.getInt(3)!=0)
					{
						usuario=rs_usu.getInt(3);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Revise1_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					if(rs_usu.getInt(4)!=0)
					{
						usuario=rs_usu.getInt(4);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Revise2_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					if(rs_usu.getInt(5)!=0)
					{
						usuario=rs_usu.getInt(5);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Approve1_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					if(rs_usu.getInt(6)!=0)
					{
						usuario=rs_usu.getInt(6);
						DB.executeUpdate("UPDATE HR_WorkedTime SET Approve2_ID="+usuario+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
					}
	
					DB.executeUpdate("UPDATE HR_WorkedTime SET ElaboratedBy="+user+"WHERE HR_WorkedTime_ID="+getRecord_ID(),null);
				}

			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}		
		
	return "Listo....";
	}
	
	
}