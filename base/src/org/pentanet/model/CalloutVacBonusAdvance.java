package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.DBException;
import org.compiere.apps.ADialog;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MUser;
import org.pentanet.model.X_HR_VacBonusAdvance_Line;
import org.pentanet.model.MHRVacBonusAdvance;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.MHREmployee;
import org.eevolution.model.MHRMovement;

public class CalloutVacBonusAdvance extends CalloutEngine{

	public String fillfields (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
	
		MUser usuario;
		MBPartner socio;
		MHREmployee emp;
		String sql;
		MDocType doc = new MDocType(Env.getCtx(), (Integer)mTab.getValue("C_DocType_ID"), null);
		
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
	    
		sql= "SELECT HR_Process_ID FROM HR_Process WHERE HR_Period_ID = ( " +
	            "SELECT max(per.HR_Period_ID) " +
	            "FROM HR_Movement mov " +
	            "INNER JOIN HR_Concept con ON con.HR_Concept_ID=mov.HR_Concept_ID " +
	            "INNER JOIN HR_Process pro ON pro.HR_Process_ID=mov.HR_Process_ID " +
	            "INNER JOIN HR_Period per ON per.HR_Period_ID=pro.HR_Period_ID " +
	            "WHERE mov.C_BPartner_ID="+socio.getC_BPartner_ID()+" AND pro.DocStatus in ('CO','CL') AND con.value='ACU')";

		Integer id_proceso = DB.getSQLValue(null,sql); //Ultimo proceso de nómina
	
		BigDecimal acum, anti, hcm, comp, saldo, req;
		
	//********************* U T I L I D A D E S
		
		sql = "SELECT mov.amount FROM HR_Movement mov " +
		    "INNER JOIN HR_Concept con ON con.HR_Concept_ID=mov.HR_Concept_ID " +
		    "INNER JOIN HR_Process pro ON pro.HR_Process_ID=mov.HR_Process_ID " +
		    "WHERE mov.C_BPartner_ID="+socio.getC_BPartner_ID()+" AND con.value='ACU' AND " +
		    "mov.HR_Process_ID="+id_proceso;
	
		acum = DB.getSQLValueBD(null,sql); //Acumulado de Utilidades a la fecha
		acum = (acum==null ? new BigDecimal(0):acum);
		
		sql = "SELECT SUM(amount) FROM HR_Credits_Pool WHERE Value IN ('UTIF','UTIG') AND C_BPartner_ID="+socio.getC_BPartner_ID()+
				" AND holiday(DateStart,0,'A')=holiday("+mTab.getValue("DateRequired")+",0,'A')";
		
		anti = DB.getSQLValueBD(null,sql); //Acumulado de Anticipos de Utilidades a la fecha
		anti = (anti==null ? new BigDecimal(0):anti);
		
		sql = "SELECT MAX(amt_ut) FROM HR_HCMRequestLine WHERE IsSalaryInteg='N' AND " +
			  "Processed='N' AND C_BPartner_ID="+socio.getC_BPartner_ID();
		
		hcm = DB.getSQLValueBD(null,sql); //Utilidades Comprometidas en HCM a la fecha
		hcm = (hcm==null ? new BigDecimal(0):hcm);
				
		comp = new BigDecimal(0);
		saldo = new BigDecimal(0);
		req = new BigDecimal(0);
		
		sql="SELECT retention_rpe FROM HR_Ivss_percent WHERE HR_Ivss_percent_ID IN " +
			"(SELECT HR_Ivss_percent_ID FROM HR_Employee WHERE IsActive='Y' AND C_BPartner_ID="+socio.getC_BPartner_ID()+")";
		BigDecimal rpe = DB.getSQLValueBD(null,sql); //RPE
		
		rpe = (rpe==null ? new BigDecimal(1):rpe);
		
		comp = comp.add(anti).add(hcm).add(acum.multiply(new BigDecimal(0.01)).multiply(rpe));
		comp = comp.setScale(2, BigDecimal.ROUND_HALF_UP);
		saldo=saldo.add(acum).subtract(comp);
	
		mTab.setValue("AmtUtiEstimated",acum);
		mTab.setValue("AmtUtiCommitted",comp);
		mTab.setValue("AmtUtiAvailable",saldo);
		mTab.setValue("AmtUtiRequired",req);
	
		
	//********************* V A C A C I O N E S
		
		String whereclause = "";
		if (doc.getName().equals("VacBonusAdv")){
			whereclause =  " AND DateStart < now() ";
		}
		
		sql="SELECT SUM(vac.BonDays*(atr.amount/30)) FROM HR_Vacation vac " +
				"INNER JOIN HR_Attribute atr ON atr.C_BPartner_ID=vac.C_BPartner_ID AND atr.IsActive='Y' " +
			    "AND atr.HR_Concept_ID=(SELECT HR_Concept_ID FROM HR_Concept WHERE value='SBM') " +
				"WHERE vac.C_BPartner_ID="+ socio.getC_BPartner_ID() +" AND vac.IsPaid='N' " + whereclause;
		
		acum = DB.getSQLValueBD(null,sql); //Estimado de Bono Vacacional a la fecha
		acum = (acum==null ? new BigDecimal(0):acum);
		
		sql="SELECT SUM(amount) FROM HR_Credits_Pool WHERE Value='VAC' AND IsDiscounted='N' AND C_BPartner_ID=" + socio.getC_BPartner_ID() + whereclause;
		anti = DB.getSQLValueBD(null,sql); //Acumulado de Anticipos de Bonos Vacacionales a la fecha
		anti = (anti==null ? new BigDecimal(0):anti);
		
		comp = new BigDecimal(0);
		saldo = new BigDecimal(0);
		req = new BigDecimal(0);
		
		comp = comp.add(anti);
		saldo=saldo.add(acum).subtract(comp);
		
		mTab.setValue("AmtVacEstimated",acum);
		mTab.setValue("AmtVacCommitted",comp);
		mTab.setValue("AmtVacAvailable",saldo);
		mTab.setValue("AmtVacRequired",req);
		
		
		//********************* U T I L I D A D E S   P O R   G E N E R A R
		
		BigDecimal utg = new BigDecimal(0);
		
		if (doc.getName().equals("PersonalLoan")){ //Verifica el tipo de documento
			
			sql = "select (amount :: numeric(10,2) * (12 - holiday(now(),0,'M')) * 0.3333) :: numeric(10,2) "
					+ "from hr_attribute where c_bpartner_id = "+ socio.getC_BPartner_ID() +" and hr_concept_id in "
					+ "(Select hr_concept_id from hr_concept where value = 'SBM') and isactive ='Y'";
			
			utg= DB.getSQLValueBD(null, sql);
			
		} else{
			
			mTab.setValue("AmtUtiGenRequired", new BigDecimal(0));
			
		}
		
		mTab.setValue("AmtUtiGenEstimated",utg);
		
		
		//********************* S U E L D O S   P O R   C O B R A R
		
		BigDecimal sc = new BigDecimal(0);
		BigDecimal disp = new BigDecimal(0);
		BigDecimal cuota = new BigDecimal(0);
		
		if (doc.getName().equals("PersonalLoan")){ //Verifica el tipo de documento (Prestamos Personales)
			
			sql = "select (amount :: numeric(10,2) * (12 - holiday(now(),0,'M'))) :: numeric(10,2) "
					+ "from hr_attribute where c_bpartner_id = "+ socio.getC_BPartner_ID() +" and hr_concept_id in "
					+ "(Select hr_concept_id from hr_concept where value = 'SBM') and isactive ='Y'";

			sc= DB.getSQLValueBD(null, sql);
			disp = sc.multiply(new BigDecimal(0.30)).setScale(2,BigDecimal.ROUND_HALF_UP);
			cuota= DB.getSQLValueBD(null, "select (12 - holiday(now(),0,'M'))");
			
		} else{
			
			mTab.setValue("AmtSCRequired", new BigDecimal(0));
			
		}

		mTab.setValue("AmtSCEstimated",sc);
		mTab.setValue("AmtSCAvailable",disp);
		mTab.setValue("QtyShareSC",cuota);
		
		return "";
	}
	
	
	public String amtrequiredvac (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal disp = (BigDecimal)mTab.getValue("AmtVacAvailable");
		BigDecimal req = (BigDecimal)mTab.getValue("AmtVacRequired");
		Integer HR_VacBonusAdvance_ID = (Integer)mTab.getValue("HR_VacBonusAdvance_ID");
		Integer HR_VacBonusAdvance_Line_ID = (Integer)mTab.getValue("HR_VacBonusAdvance_Line_ID");
		
		if(req.compareTo(disp)>0)
		{
			req=disp;
			mTab.setValue("AmtVacRequired", req);
		}
		
		String sql = "SELECT AmtVacRequired FROM HR_VacBonusAdvance_Line " + 
					"WHERE HR_VacBonusAdvance_Line_ID="+HR_VacBonusAdvance_Line_ID;
		BigDecimal oldreq=DB.getSQLValueBD(null,sql);
		
		oldreq = (oldreq==null ? new BigDecimal(0):oldreq);
		
		req = req.subtract(oldreq);
		
		sql="UPDATE HR_VacBonusAdvance SET AmtVacRequired=(AmtVacRequired+"+req+") "+ 
					"WHERE HR_VacBonusAdvance_ID="+HR_VacBonusAdvance_ID;
		DB.executeUpdate(sql,null);
			
		sql="UPDATE HR_VacBonusAdvance SET Total=(AmtVacRequired+AmtUtiRequired+AmtUtiGenRequired+AmtSCRequired) "+ 
				"WHERE HR_VacBonusAdvance_ID="+HR_VacBonusAdvance_ID;
		DB.executeUpdate(sql,null);
	
		return "";
	}
	
	public String amtrequireduti (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal disp = (BigDecimal)mTab.getValue("AmtUtiEstimated");
		BigDecimal req = (BigDecimal)mTab.getValue("AmtUtiRequired");
		
		if(req.compareTo(disp)>0)
		{
			req=disp;
			mTab.setValue("AmtUtiRequired", req);
		}
		
		return "";
	}
	
	public String amtrequiredutigen (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal disp = (BigDecimal)mTab.getValue("AmtUtiGenEstimated");
		BigDecimal req = (BigDecimal)mTab.getValue("AmtUtiGenRequired");
		
		if(req.compareTo(disp)>0)
		{
			req=disp;
			mTab.setValue("AmtUtiGenRequired", req);
		}
		
		return "";
	}

	public String amtrequiredsc (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal disp = (BigDecimal)mTab.getValue("AmtSCAvailable");
		BigDecimal req = (BigDecimal)mTab.getValue("AmtSCRequired");
		
		if(req.compareTo(disp)>0)
		{
			req=disp;
			mTab.setValue("AmtSCRequired", req);
		}
		
		return "";
	}
	
	public String amtTotal (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
		BigDecimal totalvac = (BigDecimal)mTab.getValue("AmtVacRequired");
		BigDecimal totaluti = (BigDecimal)mTab.getValue("AmtUtiRequired");
		BigDecimal totalutig = (BigDecimal)mTab.getValue("AmtUtiGenRequired");
		BigDecimal totalsc = (BigDecimal)mTab.getValue("AmtSCRequired");
		
		BigDecimal total =totalvac.add(totaluti).add(totalutig).add(totalsc);
		
		mTab.setValue("Total",total);
		
		return "";
	}
	
}

