package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.model.MUser;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.MHREmployee;

public class CallaoutAgeBenefitsAdvance extends CalloutEngine{

	
	public String fillfields (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
	
		MUser usuario;
		MBPartner socio;
		MHREmployee emp;
		String sql;
		
		if (mTab.getValue("C_BPartner_ID")==null) //Empleado
		{
			usuario = new MUser(Env.getCtx(), Env.getContextAsInt(ctx , WindowNo, "AD_User_ID"), null);
			
			socio = new MBPartner(Env.getCtx(), usuario.getC_BPartner_ID(), null);
		    
		    mTab.setValue("C_BPartner_ID", socio.getC_BPartner_ID());

		}
		else
		{
			socio = new MBPartner(Env.getCtx(), (Integer)mTab.getValue("C_BPartner_ID"), null);
		}
		
	    sql = "SELECT max(HR_Employee_ID) FROM HR_Employee WHERE IsActive='Y' AND C_BPartner_ID="+socio.getC_BPartner_ID();
	    emp = new MHREmployee(Env.getCtx(), DB.getSQLValue(null, sql), null);
	    
	    mTab.setValue("HR_ZonaOperacion_ID", emp.getHR_ZonaOperacion_ID());
		
		sql = "SELECT max(mov.amount) FROM HR_Movement mov " +
			       "INNER JOIN HR_Concept con ON con.HR_Concept_ID=mov.HR_Concept_ID " +
			       "INNER JOIN HR_Process pro ON pro.HR_Process_ID=mov.HR_Process_ID " +
			       "INNER JOIN HR_Period per ON per.HR_Period_ID=pro.HR_Period_ID " +
			       "WHERE pro.DocStatus in ('CO','CL') AND con.value='GAA' AND  mov.C_BPartner_ID="+socio.getC_BPartner_ID();

		BigDecimal acum = DB.getSQLValueBD(null,sql); //Acumulado de Prestaciones a la fecha
		
		sql = "SELECT max(mov.amount) FROM HR_Movement mov " +
			       "INNER JOIN HR_Concept con ON con.HR_Concept_ID=mov.HR_Concept_ID " +
			       "INNER JOIN HR_Process pro ON pro.HR_Process_ID=mov.HR_Process_ID " +
			       "INNER JOIN HR_Period per ON per.HR_Period_ID=pro.HR_Period_ID " +
			       "WHERE pro.DocStatus in ('CO','CL') AND con.value='ACA' AND  mov.C_BPartner_ID="+socio.getC_BPartner_ID();

		BigDecimal anti1 = DB.getSQLValueBD(null,sql); //Acumulado de Anticipos a la fecha (Movimientos de Nómina)

		if(anti1==null)
			anti1 = new BigDecimal(0);
		
		sql="SELECT SUM(amount) FROM HR_Credits_Pool WHERE Value='ANTP' AND IsDiscounted='N' AND C_BPartner_ID="+socio.getC_BPartner_ID();
		
		BigDecimal anti2 = DB.getSQLValueBD(null,sql); //Acumulado de Anticipos a la fecha (Que aún no estan en Movimientos de Nómina)
		
		if(anti2==null)
			anti2 = new BigDecimal(0);
		
		BigDecimal anti = anti1.add(anti2);
		
		if(acum==null)
			acum = new BigDecimal(0);
		
		BigDecimal saldo = new BigDecimal(0);
		saldo= saldo.add(acum).subtract(anti);
		
		BigDecimal disp75=(acum.multiply(new BigDecimal(0.75))).subtract(anti);
		BigDecimal req = new BigDecimal(0);

		mTab.setValue("AmtAccrued",acum);
		mTab.setValue("AmtAdvance",anti);
		mTab.setValue("AmtTotal",saldo);
		mTab.setValue("AmtAvailable",disp75);
		mTab.setValue("AmtRequired",req);
			
		return "";
	}
	
	
	public String fillpercentage (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal req = (BigDecimal)mTab.getValue("AmtRequired");
		BigDecimal total = (BigDecimal)mTab.getValue("AmtTotal");
		
		if((!req.equals(new BigDecimal(0)))&&(!total.equals(new BigDecimal(0))))
		{
			if(req.compareTo(total)>0) {
			     req=total;
			     mTab.setValue("AmtRequired",req);
			}
			BigDecimal porc = new BigDecimal(0);
			porc = porc.add(req).divide(total, 2).multiply(new BigDecimal(100));
			porc = porc.setScale(2, BigDecimal.ROUND_HALF_UP);
			mTab.setValue("PercRequired",porc);
		}
		
		return "";
	}
	
}
