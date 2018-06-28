package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.pentanet.model.MHRHCMFamily;
import org.pentanet.model.MHRHCMRequest;
import org.pentanet.model.MHRHCMRequestLine;
import org.pentanet.model.X_HR_HCMFamily;

/*
 * HCMDist: Distribution of HCM concept by payrroll
 * In: PO MHRHCMReques
 * out: MHRHCMRequesLines, calc distribution of HCM Rate and create distribution's line 
 * Description: register distribution's line from rate HCM employee. 
 * goal: concept HCM in Payroll Definition, search distribution's line with  month payroll
 * and applied amount as discount.
 * 
 */
public class HCMDist extends SvrProcess {
	
private int Req_id;
private int C_BPartner_ID;
private int HR_HCMRequest_ID;
private BigDecimal t_utilid;
private BigDecimal t_salary;
public List<MHRHCMFamily> listFamily;
private BigDecimal tsbm; 
private BigDecimal tsut;
private int anho; 

	@Override
	protected void prepare() {
		Req_id = getRecord_ID();

	}

	@Override
	protected String doIt() throws Exception {
		
		MHRHCMRequest Request1 = new MHRHCMRequest(getCtx(),Req_id , get_TrxName());
		//BigDecimal monto = DB.getSQLValueBD(get_TrxName(),"SELECT COALESCE(SUM(RATE),0) FROM HR_HCMFAMILY WHERE hr_hcmrequest_id = "+ Req_id);
		HR_HCMRequest_ID = Request1.getHR_HCMRequest_ID();
		C_BPartner_ID = Request1.getC_BPartner_ID();
		anho = DB.getSQLValue(get_TrxName(),"SELECT to_char(validto,'YYYY') :: numeric FROM HR_HCMTabVersion WHERE HR_HCMTabVersion_ID =" + Request1.getHR_HCMTabVersion_ID());
		
		
		int mes = Integer.parseInt(Request1.getCoverMonth1()!=null ? Request1.getCoverMonth1():"0");
		int month_Process = 0;
		MHRHCMRequestLine Rline=null;
		int idhcmline =0;
		
		int no = 0;
		
		//Borrar Distribición de Utilidades
		log.info("HR_HCMRequest... Borrando Distribución no procesada");
		no = DB.executeUpdate("DELETE FROM hr_hcmrequestline  WHERE HR_HCMRequest_ID = "+ Req_id + " AND issalaryinteg = 'N' AND Processed = 'N' ", null);
				
		if (mes > 0 && Request1.isApplied()== true){
			
			t_utilid = DB.getSQLValueBD(get_TrxName(),"select sum(amt_ut) from HR_HCMRequestline WHERE HR_HCMRequest_ID = "+ Req_id +"  "
					+ "AND issalaryinteg = 'Y' AND month_orig :: numeric < " + mes);
			t_salary = DB.getSQLValueBD(get_TrxName(),"select sum(amt) from HR_HCMRequestline WHERE HR_HCMRequest_ID = "+ Req_id +"  "
					+ " AND issalaryinteg = 'Y' AND month_orig :: numeric < " + mes);
			
			//Ultimo mes procesado
			idhcmline = DB.getSQLValue(null,"select coalesce((max(hr_hcmrequestline_ID) :: numeric),0) from hr_hcmrequestline where issalaryinteg = 'Y' "
					+ "AND month_orig :: numeric < " + mes +" AND hr_hcmrequest_id = "+ Req_id); 
			if(idhcmline > 0){
				Rline = new MHRHCMRequestLine(getCtx(),idhcmline, get_TrxName());
				month_Process = Integer.parseInt(Rline.getMonth_Orig()) + 1; 
			}
			
			//Borrar Distribición no procesadas y en un rango de mes
			log.info("HR_HCMRequest... Borrando Distribución no procesada");
			no = DB.executeUpdate("DELETE FROM hr_hcmrequestline WHERE HR_HCMRequest_ID = "+ Req_id
					+ " AND issalaryinteg = 'Y' AND Processed = 'N' AND month_orig :: numeric >= " + mes,null);
			
		}else{
			
			t_utilid = DB.getSQLValueBD(get_TrxName(),"select sum(amt_ut) from HR_HCMRequestline WHERE HR_HCMRequest_ID = "+ Req_id
					+ " AND issalaryinteg = 'Y' AND Processed = 'Y' ");
			t_salary = DB.getSQLValueBD(get_TrxName(),"select sum(amt) from HR_HCMRequestline WHERE HR_HCMRequest_ID = "+ Req_id
					+ " AND issalaryinteg = 'Y' AND Processed = 'Y' ");
			
			//Ultimo mes procesado
			idhcmline = DB.getSQLValue(null,"select coalesce((max(hr_hcmrequestline_ID) :: numeric),0) from hr_hcmrequestline where processed = 'Y'  and hr_hcmrequest_id = "+ Req_id); 
			if(idhcmline > 0){
				Rline = new MHRHCMRequestLine(getCtx(),idhcmline, get_TrxName());
				month_Process = Integer.parseInt(Rline.getMonth_Orig()) + 1; 
			}
			
			//Borrar Distribición no procesadas
			log.info("HR_HCMRequest... Borrando Distribución no procesada");
			no = DB.executeUpdate("DELETE FROM hr_hcmrequestline  WHERE HR_HCMRequest_ID = "+ Req_id + " AND issalaryinteg = 'Y' AND Processed = 'N'",null);
			
			t_utilid = t_utilid != null ? t_utilid : new BigDecimal(0);
			t_salary = t_salary != null ? t_salary : new BigDecimal(0);
		}
		
		log.info("HR_HCMRequest... Borrado..." + no);
		
		PreparedStatement pstmt = DB.prepareStatement ("SELECT * FROM credit_registers(" + C_BPartner_ID+")", get_TrxName());
		ResultSet rs;
		rs= pstmt.executeQuery ();
		while (rs.next ())
		{
			tsbm = rs.getBigDecimal(4);
			tsut = rs.getBigDecimal(5);
		}
		pstmt.close();
		rs.close();
		
		listFamily = new Query(getCtx(), X_HR_HCMFamily.Table_Name, " HR_HCMRequest_ID = "+ Req_id , get_TrxName())
		.setOnlyActiveRecords(true)
		.setOrderBy(X_HR_HCMFamily.COLUMNNAME_HR_HCMFamily_ID)
		.list();

		int item = 0; int item2 = 0; 
		int month1 = 0;
		int month2 = 0;
		BigDecimal percsalary = new BigDecimal(0);
		BigDecimal percutilid = new BigDecimal(0);
		
		
		// Verifica si el Primer convenio fue aplicado
		if (Request1.isApplied()== false){

			month1 = Integer.parseInt(Request1.getCoverMonth());
			month2 = Integer.parseInt((Request1.getExpMonth()));
			percsalary = Request1.getPercSalary();
			percutilid = Request1.getPercUtil();
			
			if (month_Process >= month1 && month_Process <= month2){
				month1 = month_Process;
			}else if (month_Process > month2){
				month1 = 0;
			}
			
			//Primer convenio
			if (month1 != 0){
				item = getDistribut(month1, month2, percsalary, percutilid);
			}
			
		}//Convenio Aplicado
		
		
		//Completar convenios
		if (Request1.getCoverMonth1() != null){
			month1 = Integer.parseInt(Request1.getCoverMonth1());
		}else{
			month1= 13;
		}
		if((month1  - month_Process) != 0 && Request1.isApplied()== true && idhcmline > 0){
			
			percsalary = Rline.getPercent();
			percutilid = Rline.getPercent2(); 

			item = getDistribut(month_Process, (month1-1), percsalary, percutilid);
			
		}
		
		//Segundo convenio
		if(Request1.getCoverMonth1() != null && Request1.getExpMonth1() != null && !Request1.getPercSalary2().equals(new BigDecimal(0)) 
				&& !Request1.getPercUtil2().equals(new BigDecimal(0)) && Request1.isApplied()== true){
			
			month2 = Integer.parseInt(Request1.getExpMonth1());
			percsalary = Request1.getPercSalary2();
			percutilid = Request1.getPercUtil2();
			
			if (month_Process >= month1 && month_Process <= month2){
				month1 = month_Process;
			}else if (month_Process > month2){
				month1 = 0;
			} 
			
			if (month1 != 0)
				item2 = getDistribut(month1, month2, percsalary, percutilid);
			
		}
		
		
		if (tsut.compareTo(t_utilid) < 0)
			throw new AdempiereException("Se Excede la Utilidad a Generer UT: " + tsut + ", Desc. HCM: " + t_utilid);
		
		// Now Utilidad
		if ((item + item2) > 0){
			MHRHCMRequestLine rline = new MHRHCMRequestLine(getCtx(),0,get_TrxName());
		    rline.setC_BPartner_ID(C_BPartner_ID);
		    rline.setHR_HCMRequest_ID(HR_HCMRequest_ID);
		    rline.setMonth_Aplication("12");
		    rline.setMonth_Orig("03");
		    
		    int count = 0;
		    for( X_HR_HCMFamily var : listFamily){
		    	count++;
		    	switch (count){
		    	case 1:
		    		rline.setHR_Family_ID(var.getHR_Family_ID());
		    		break;
		    	case 2:
		    		rline.setHR_Family1_ID(var.getHR_Family_ID());
		    		break;
		    	case 3:
		    		rline.setHR_Family2_ID(var.getHR_Family_ID());
		    		break;
		    	case 4:
		    		rline.setHR_Family3_ID(var.getHR_Family_ID());
		    		break;
		    	case 5:
		    		rline.setHR_Family4_ID(var.getHR_Family_ID());
		    		break;
		    	}
		    }
		    
		    rline.setAmt(t_salary);
		    rline.setAmt_Ut(t_utilid);
		    rline.setissalaryinteg(false);
		    rline.save();
		}
		
		item = item + item2;

		return "Generadas " + item + " lineas";
	}
	
	public int getDistribut(int month1, int month2, BigDecimal percsalary, BigDecimal percutilid){
		//first iteration

		int meses =  Math.abs(month1 - month2) ;
		String m ="00";
		String mo ="00";
		BigDecimal cuota = new BigDecimal(12); //(new BigDecimal(meses+1)).setScale(4, BigDecimal.ROUND_HALF_UP);
		
		
		int i;
		for (i=0; i <= meses; i++){ //La aplicacion del salario
			
			BigDecimal monto = DB.getSQLValueBD(get_TrxName(),"SELECT amount FROM Annual_Premium("+getRecord_ID()+","+C_BPartner_ID+","+getConvertMonth(month1 + i)+","+anho+")");
			monto = monto == null? new BigDecimal(0):monto;
			
			if(!monto.equals(new BigDecimal(0))){
				
				BigDecimal salary = monto.multiply(percsalary).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal utilid = monto.multiply(percutilid).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal cuota_sal = salary.divide(cuota, 2, BigDecimal.ROUND_HALF_UP );
				BigDecimal cuota_ut = utilid.divide(cuota, 2, BigDecimal.ROUND_HALF_UP );
				
				if (tsbm.compareTo(cuota_sal) < 0)
					throw new AdempiereException("La Cuota excede el tercio de su sueldo Mensual. SM: " + tsbm + ", Cuota: " + cuota_sal);
				
				MHRHCMRequestLine rline = new MHRHCMRequestLine(getCtx(),0,get_TrxName());
			    rline.setC_BPartner_ID(C_BPartner_ID);
			    rline.setHR_HCMRequest_ID(HR_HCMRequest_ID);
			    
			    // Total cuotas HCM a descontar en Utilidades
			    t_utilid = t_utilid.add(cuota_ut);
			    //Total cuotas de salario para mostrar
			    t_salary = t_salary.add(cuota_sal);
			    
			    //mes de aplicacion
			    if (getConvertMonth(month1 + i)<10){
			    	m =  "0"+String.valueOf(getConvertMonth(month1 + i));
			    }else{
			        m =  String.valueOf(getConvertMonth(month1 + i));
			    }
			    
			    if ((month1 + i)<10){
			    	mo =  "0"+String.valueOf((month1 + i));
			    }else{
			    	mo =  String.valueOf((month1 + i));
			    }
			    rline.setMonth_Aplication(m);
			    rline.setMonth_Orig(mo);
			    
			    int count = 0;
			    for( MHRHCMFamily var : listFamily){
			    	count++;
			    	switch (count){
			    	case 1:
			    		rline.setHR_Family_ID(var.getHR_Family_ID());
			    		break;
			    	case 2:
			    		rline.setHR_Family1_ID(var.getHR_Family_ID());
			    		break;
			    	case 3:
			    		rline.setHR_Family2_ID(var.getHR_Family_ID());
			    		break;
			    	case 4:
			    		rline.setHR_Family3_ID(var.getHR_Family_ID());
			    		break;
			    	case 5:
			    		rline.setHR_Family4_ID(var.getHR_Family_ID());
			    		break;
			    	}
			    }
			    
			    rline.setPercent(percsalary);
			    rline.setPercent2(percutilid);
			    rline.setAmt(cuota_sal);
			    rline.setAmt_Ut(cuota_ut);
			    rline.setissalaryinteg(true);
			    rline.save();
			    
			} else {// Monto = 0
				break;
			}
			
		}
		//second iteration
	    return i;
	}
	

	
	public int getConvertMonth(int ConvertMonth){
		int valor = 0;
		switch (ConvertMonth){
		case 1:// Octubre
			valor = 10;
			break;
		case 2:
			valor = 11;
			break;
		case 3:
			valor = 12;
			break;
		case 4:
			valor = 1;
			break;
		case 5:
			valor = 2;
			break;
		case 6:
			valor = 3;
			break;
		case 7:
			valor = 4;
			break;
		case 8:
			valor = 5;
			break;
		case 9:
			valor = 6;
			break;
		case 10:
			valor = 7;
			break;
		case 11:
			valor = 8;
			break;
		case 12: // Septiembre
			valor = 9;
			break;
		}
		
		return valor;
	}

}
