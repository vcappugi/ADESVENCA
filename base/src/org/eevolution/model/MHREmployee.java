/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved.               *
 * Contributor(s): Victor Perez www.e-evolution.com                           *
 *****************************************************************************/
package org.eevolution.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MBPartner;
import org.pentanet.model.X_HR_VacationProg_Line;
import org.compiere.model.Query;
import org.compiere.util.CCache;
import org.compiere.util.DB;
import org.compiere.util.Env;

import sun.util.logging.resources.logging;


/**
 * HR Employee Model
 *
 * @author Victor Perez
 * @author Cristina Ghita, www.arhipac.ro
 */
@SuppressWarnings("unused")
public class MHREmployee extends X_HR_Employee
{
	private static final long serialVersionUID = -7083160315471023587L;

	public static MHREmployee get(Properties ctx, int HR_Employee_ID)
	{
		if (HR_Employee_ID <= 0)
			return null;
		//
		MHREmployee employee = s_cache.get(HR_Employee_ID);
		if (employee != null)
			return employee;
		//
		employee = new MHREmployee(ctx, HR_Employee_ID, null);
		if (employee.get_ID() == HR_Employee_ID)
		{
			s_cache.put(HR_Employee_ID, employee);	
		}
		else
		{
			employee = null;
		}
		return employee; 
	}
	
	/**
	 * 	Get Employees of Process
	 *  @param p HR Process
	 * 	@return Array of Business Partners
	 */
	public static MBPartner[] getEmployees (MHRProcess p)
	{
		List<Object> params = new ArrayList<Object>();
		StringBuffer whereClause = new StringBuffer();
		
		//Obtiene y Verifica el tipo de nomina que se va a procesar
		String pclas =DB.getSQLValueString(null,"SELECT COALESCE(Payroll_Clasif,'Q') FROM HR_Payroll WHERE HR_Payroll_id = " + p.getHR_Payroll_ID());
		boolean pver = pclas.equals("VAC")? false : (pclas.equals("LIQ")? false : true);
		if(pver == true){ 
			
			if(pclas.equals("UT")){
				
				whereClause.append(" C_BPartner.C_BPartner_ID IN (SELECT e.C_BPartner_ID FROM HR_Employee e WHERE e.IsActive = ?");
				params.add(true);
				
			}else{
				
				whereClause.append(" C_BPartner.C_BPartner_ID IN (SELECT e.C_BPartner_ID FROM HR_Employee e WHERE e.IsActive in ('Y','N') ");
				
			}
			
			// This payroll not content periods, NOT IS a Regular Payroll > ogi-cd 28Nov2007
			if(p.getHR_Payroll_ID() != 0 && p.getHR_Period_ID() != 0)
			{
				whereClause.append(" AND  (e.HR_Payroll_ID IS NULL OR e.HR_Payroll_ID=?) " );
				params.add(p.getHR_Payroll_ID());
			}
			
			// HR Period
			if(p.getHR_Period_ID() == 0)
			{
				whereClause.append(" AND e.StartDate <=? ");
				params.add(p.getDateAcct());	
			}
			else
			{
				MHRPeriod period = new MHRPeriod(p.getCtx(), p.getHR_Period_ID(), p.get_TrxName());
				whereClause.append(" AND e.StartDate <=? ");
				params.add(period.getEndDate());
				whereClause.append(" AND (e.EndDate IS NULL OR e.EndDate >=?) ");
				//whereClause.append(" AND (e.EndDate IS NULL) ");
				params.add(period.getStartDate());
			}
			
			// Selected Department
			if (p.getHR_Department_ID() != 0) 
			{
				whereClause.append(" AND e.HR_Department_ID =? ");
				params.add(p.getHR_Department_ID());
			}
			//Selected Contract
			
			if (p.getHR_Contract_ID() !=0 )
			{
				whereClause.append(" AND e.HR_Contract_ID=? ");
				params.add(p.getHR_Contract_ID());
			}
			
			if (p.getHR_Payroll_Type_Line_ID() !=0 )
			{
				whereClause.append(" AND e.HR_Payroll_Type_Line_ID=? ");
				params.add(p.getHR_Payroll_Type_Line_ID());
			}
			
			//whereClause.append(" AND e.hr_payroll_type_line_id = 1000003) "); // end select from HR_Employee
			whereClause.append(" ) "); // end select from HR_Employee
			

				
			
		}else{ //Filtra los empleados que esten tildados para pagar
			if(pclas.equals("VAC")){ 

			whereClause.append(" C_BPartner.C_BPartner_ID IN (SELECT v.c_bpartner_id FROM hr_vacationprog vp " +
								"INNER JOIN hr_vacationprog_line vpl ON vpl.hr_vacationprog_id = vp.hr_vacationprog_id  AND vpl.ispaid = 'Y' " +
								"INNER JOIN hr_vacation v ON v.hr_vacation_id = vpl.hr_vacation_id " + 
								"LEFT JOIN hr_vacationrequisition vr ON vr.hr_periodvac_id = v.hr_periodvac_id AND v.c_bpartner_id= vr.c_bpartner_id "+
								"WHERE vp.HR_Process_ID = ? AND vp.hr_period_id = ?)");
			// Periodo del proceso
			params.add(p.getHR_Process_ID());
			params.add(p.getHR_Period_ID());
			
			}else if(pclas.equals("LIQ")){
				
				whereClause.append(" C_BPartner.C_BPartner_ID IN (SELECT lpl.c_bpartner_id FROM hr_liquidationprog lp "
						+ " INNER JOIN hr_liquidationprog_line lpl ON lpl.hr_liquidationprog_id = lp.hr_liquidationprog_id"
						+ " WHERE lp.HR_Process_ID = ?)");
				// Proceso
				params.add(p.getHR_Process_ID());
				
			}
			
			
		} //VAC

		
		// Selected Employee
		if (p.getC_BPartner_ID() != 0)
		{
			whereClause.append(" AND C_BPartner_ID =? ");
			params.add(p.getC_BPartner_ID());
		}
		
		/*Filtra a los empleados que estan en tiempo trabajado en un Sitio de Trabajo especifico y de una nomina 
		 * regular
		 * */
		
		if (p.getHR_Standing_ID() !=0 && pclas.equals("Q"))
		{
			whereClause.append(" AND C_BPartner.C_BPartner_ID IN ("
					+ " SELECT w.C_BPartner_ID FROM hr_workedtime wt"
					+ " INNER JOIN hr_workedtimeline w ON w.hr_workedtime_id = wt.hr_workedtime_id,"
					+ " hr_process p"
					+ " INNER JOIN hr_period pd ON pd.hr_period_id = p.hr_period_id"
					+ " WHERE wt.hr_standing_id = ?  AND p.hr_process_id= ? AND"
					+ " (CASE WHEN p.hr_contract_id= 1000002 THEN "
					+ " (CASE WHEN adddays(datestart,(wt.netdays-1)) between firstlastdays(pd.startdate,1) "
					+ " and pd.enddate THEN 1 ELSE 0 END)  ELSE "
					+ " (CASE WHEN adddays(datestart,(wt.netdays-1)) between pd.startdate and pd.enddate THEN 1 ELSE 0 END)"
					+ " END) = 1 ) ");
			params.add(p.getHR_Standing_ID());
			params.add(p.getHR_Process_ID());
		}
		
		
		//client
		whereClause.append(" AND AD_Client_ID =? ");
		params.add(p.getAD_Client_ID());
		
		//Selected Organitation
		if (p.getAD_Org_ID() != 0)
		{
			whereClause.append(" AND AD_Org_ID =? ");
			params.add(p.getAD_Org_ID());
		}

			List<MBPartner> list = new Query(p.getCtx(), MBPartner.Table_Name, whereClause.toString(), p.get_TrxName())
									.setParameters(params)
									.setOnlyActiveRecords(true)
									.setOrderBy(COLUMNNAME_Name)
									.list();
			
			

			return list.toArray(new MBPartner[list.size()]);


	}	//	getEmployees
	
	public static MHREmployee getActiveEmployee(Properties ctx, int C_BPartner_ID, String trxName)
	{
		return new Query(ctx, Table_Name, COLUMNNAME_C_BPartner_ID+"=?", trxName)
							//.setOnlyActiveRecords(true)
							.setParameters(new Object[]{C_BPartner_ID})
							.setOrderBy(COLUMNNAME_HR_Employee_ID+" DESC") // just in case...
							.first();
	}

	/** Cache */
	private static CCache<Integer, MHREmployee> s_cache = new CCache<Integer, MHREmployee>(Table_Name, 1000);
	
	/**************************************************************************
	 * 	Invoice Line Constructor
	 * 	@param ctx context
	 * 	@param HR_Employee_ID ID Employee
	 * 	@param trxName transaction name
	 */
	public MHREmployee (Properties ctx, int HR_Employee_ID, String trxName) //--
	{
		super (ctx, HR_Employee_ID, trxName);
		if (HR_Employee_ID == 0)
		{
			setClientOrg(Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Org_ID(Env.getCtx()));
		}
	}	//	MHREmployee
	
	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 */
	public MHREmployee (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MHREmployee
}	//	MHREmployee
