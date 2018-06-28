package org.pentanet.model;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.MHRPeriod;
import org.pentanet.process.NewEmail;

public class MHRVacationRequisition extends X_HR_VacationRequisition implements DocAction,DocOptions{
	
	private static final long serialVersionUID = 20140211L;
	
	private String m_processMsg;
	
	
	public MHRVacationRequisition (Properties ctx, int HR_VacationRequisition_ID, String trxName)
	{
		super (ctx, HR_VacationRequisition_ID, trxName);
		//  New
		if (HR_VacationRequisition_ID == 0)
		{
			setDocAction(DOCACTION_Complete);
			setDocStatus(DOCSTATUS_Drafted);			
			setProcessed(false);
			//setIsApproved (false);
			//setProcessing(false);
			//setPosted (false);
			//			
		}
	}
	
	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 */
	public MHRVacationRequisition (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MRequisition
	
	
	/**************************************************************************
	 * 	Customize Valid Actions
	 *	@param *
	 *	@return index
	 *********************************************************/
	
    public int customizeValidActions (String docStatus, Object processing, 
            String orderType, String isSOTrx, int AD_Table_ID, String[] docAction, String[] options, int index) {

		// If status = Drafted, add "Prepare" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Drafted)
				|| docStatus.equals(DocumentEngine.STATUS_Invalid)) {
			options[index++] = DocumentEngine.ACTION_Prepare;
		}
		
		
		// If status = Completed, add "Reactivate" in the list
		if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
			//options[index++] = DocumentEngine.ACTION_ReActivate;
			options[index++] = DocumentEngine.ACTION_Void;
		}   	
		
		return index;
	}
	
	
	
	
	/**************************************************************************
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 **************************************/
	public boolean processIt (String processAction)
	{
		//m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	process

	/**	Just Prepared Flag			*/
	private boolean 		m_justPrepared = false;

	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean invalidateIt() {
		log.info(toString());
		
		return true;
	
	}


	@Override
	public String prepareIt() {

		m_justPrepared = true;
		
		String whereClause = "";
		String sql = null;
		
		if((getHR_Vacation_Incidence_ID()!=0)&&(getHR_Vacation_Incidence2_ID()!=0)) {
			whereClause = " AND (HR_Vacation_Incidence_ID = " + getHR_Vacation_Incidence_ID() 
						+ " OR HR_Vacation_Incidence2_ID = " + getHR_Vacation_Incidence2_ID() + ")";
		}
		else if(getHR_Vacation_Incidence_ID()!=0)
			whereClause = " AND HR_Vacation_Incidence_ID = " + getHR_Vacation_Incidence_ID();
		else
			whereClause = " AND HR_Vacation_Incidence2_ID = " + getHR_Vacation_Incidence2_ID();
		
		sql = "SELECT COUNT(*) FROM HR_VacationRequisition WHERE DocStatus IN ('CO', 'IP', 'CL') AND not HR_VacationRequisition_ID = " + getHR_VacationRequisition_ID()
				+ whereClause;
		
		if(DB.getSQLValue(null, sql)>0){
			m_processMsg = "Ya posee una Solicitud Relacionada";
			return DocAction.STATUS_Invalid;
		}
		
		
		//Obtener Periodo
		sql="SELECT per.name FROM HR_PeriodVac per WHERE " 
				+"HR_PeriodVac_ID="+getHR_PeriodVac_ID();
		String periodo=DB.getSQLValueString(null, sql);
		
		//Obtener Empleado
		sql="SELECT emp.name FROM C_BPartner emp WHERE " 
				+"C_BPartner_ID="+getC_BPartner_ID();
		String empleado=DB.getSQLValueString(null, sql);
		
		//Obtener Zona oprecaion
		sql="SELECT emp.HR_ZonaOperacion_ID FROM HR_Employee emp WHERE IsActive='Y' " 
				+"AND C_BPartner_ID="+getC_BPartner_ID();
		String zo=DB.getSQLValueString(null, sql);
		
		//Obtener tipo de Solicitud
		sql ="SELECT name FROM AD_Ref_List WHERE AD_Reference_ID=1000133 AND value='"+getRequisitionType()+"'";
		String tipo = DB.getSQLValueString(null,sql);
		
	    String titulo= tipo + " período " + periodo + " de "+empleado;
	    
		//Envio de correo por nodo de aprobación
		sql="SELECT DISTINCT us.email, us.description "+
			"FROM AD_WF_NextCondition cond "+
			"INNER JOIN AD_WF_NodeNext pnod ON pnod.AD_WF_NodeNext_ID=cond.AD_WF_NodeNext_ID "+
			"INNER JOIN AD_WF_Node nod ON nod.AD_WF_Node_ID=pnod.AD_WF_Next_ID "+
			"INNER JOIN AD_Workflow wf ON nod.AD_Workflow_ID=wf.AD_Workflow_ID "+
			"INNER JOIN AD_WF_Responsible resp ON resp.AD_WF_Responsible_ID=nod.AD_WF_Responsible_ID "+
			"INNER JOIN AD_User_Roles rol_us ON rol_us.AD_Role_ID=resp.AD_Role_ID "+
			"INNER JOIN AD_User us ON us.AD_User_ID=rol_us.AD_User_ID "+
			"INNER JOIN AD_Role r ON r.AD_Role_ID=rol_us.AD_Role_ID "+
			"WHERE cond.AD_Column_ID=1005142 AND wf.AD_Workflow_ID=1000011 AND rol_us.IsActive='Y' "+ 
			"AND r.IsEmail='N' AND not us.AD_User_ID =100 AND cond.value='"+zo+"'";

			//sql="SELECT description, email, name FROM AD_User WHERE C_BPartner_ID=1006902 --1005040";
	    PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
		ResultSet rs;
		try {
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				String supervisor=rs.getString(2);
				String mail_u=rs.getString(1);
				
			    String body = "<P>Estimado (s) Señor(es) "+ supervisor +"</p> " +
			    		"<P>Por medio del presente  solicitamos la aprobación de solicitud de vacaciones del Sr(a). "+empleado+".</p>" +
			    		"<P>Para visualizar la solicitud pulse aquí " +
			    		"<A HREF=\"http://adempiere.esvenca.com:8084/webui/\">ADempiere</A>. "+
			    		"<br><br><br>"+
			    		"<p ALIGN=right><i>Esperando brindarle la Calidad de Servicio que usted se merece." +
			    		"<br>Equipo de Planificación y Compensación.</i></p>" +
			    		"<br>" +
			    		"<P ALIGN=right><FONT SIZE=2>En caso de perdida de usuario o clave ADempiere comunicarse con "+ 
						"<A HREF= \"http://soporte.esvenca.com\">Soporte IT</A>.</FONT>";
			    		    
			    		    NewEmail correo = new NewEmail();
			    		    //sendEmail(String from, String to,String tittle,String subtittle, String body)    
			    		    correo.sendEmail(null, mail_u, titulo, null, body);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	    
			//setDocAction(DOCACTION_Complete);
			return DocAction.STATUS_InProgress;
		//}
	}


	@Override
	public boolean approveIt() {
		
		setIsApproved(true);
		
		return true;
	}


	@Override
	public boolean rejectIt() {
		
		setIsApproved(false);
		return true;
	}


	@Override
	public String completeIt() {

		if (!isApproved())
			approveIt();
		
		//Reprogramación de Vacaciones
		if((getRequisitionType().equals("VRe"))&&(isApproved()))
		{
			//Crear Solicitud Programada Aprobada (Para evitar volver a hacer la solicitud)
			X_HR_VacationRequisition vacr = new X_HR_VacationRequisition(getCtx(),0 ,null);
			vacr.setAD_Org_ID(getAD_Org_ID());
			vacr.setC_BPartner_ID(getC_BPartner_ID());
			vacr.setHR_PeriodVac_ID(getHR_PeriodVac_ID());
			vacr.setHR_PeriodVac1_ID(getHR_PeriodVac_ID());
			vacr.setC_DocType_ID(getC_DocType_ID());
			vacr.setRequisitionType("VPr");
			vacr.setHR_ZonaOperacion_ID(getHR_ZonaOperacion_ID());
			vacr.setDocStatus("CO");
			vacr.setDocAction("CL");
			vacr.setProcessed(true);
			vacr.setIsApproved(true);
			
			
			if(getDateStart4() != null) //Vacación Programada
			{
				//ID de la vacacion
				String sql="SELECT HR_Vacation_ID FROM HR_Vacation_Incidence WHERE " 
						+"HR_Vacation_Incidence_ID="+getHR_Vacation_Incidence_ID();
				int id_vac=DB.getSQLValue(null, sql);
				
				//Objeto (HR_Vacation)
				X_HR_Vacation vaca = new X_HR_Vacation(getCtx(), id_vac ,null);
				
				//Marcar como Reprogramada Manual
				X_HR_Vacation_Incidence vacap_1 = new X_HR_Vacation_Incidence(getCtx(),getHR_Vacation_Incidence_ID() ,null);
				vacap_1.setIsReprogManual(true);
				vacap_1.setIsActive(false);
				vacap_1.save();								

				//Cambiar fecha a la Vacacion (HR_Vacation)
				vaca.setDateStart(getDateStart4());
				vaca.setDateEnd(getDateEnd4());
				vaca.save();
				
			    String fecha=getDateStart4()+"";  
			    String fecha_d=fecha.substring(8,10)+"-"+fecha.substring(5,7)+"-"+fecha.substring(0,4);

			    String fecha2=getDateEnd4()+""; 
			    String fecha_h=fecha2.substring(8,10)+"-"+fecha2.substring(5,7)+"-"+fecha2.substring(0,4);

			    String nombre="Del "+fecha_d+" al "+fecha_h;
			    
				sql="SELECT (VacDays+AdiDays) FROM HR_Vacation WHERE HR_Vacation_ID="+id_vac;
				BigDecimal dias_vac=DB.getSQLValueBD(null, sql);
				
				//Crear nuevo incidencia de vacacion programada
				X_HR_Vacation_Incidence vacap = new X_HR_Vacation_Incidence(getCtx(),0 ,null);
			    vacap.setHR_Vacation_ID(id_vac);
			    vacap.setName(nombre);
			    vacap.setDateStart(getDateStart4());
			    vacap.setDateEnd(getDateEnd4());
			    vacap.setVacDays(dias_vac);
			    vacap.setIsProgramated(true);
			    vacap.save();
			    
				vacr.setHR_Vacation_Incidence_ID(vacap.getHR_Vacation_Incidence_ID());
			    vacr.setDateStart2(vacap.getDateStart());
			    vacr.setDateEnd2(vacap.getDateEnd());
			}
			
			if(getDateStart5() != null) //Vacación Efectiva
			{
				//ID de la vacacion
				String sql="SELECT HR_Vacation_ID FROM HR_Vacation_Incidence WHERE " 
						+"HR_Vacation_Incidence_ID="+getHR_Vacation_Incidence2_ID();
				int id_vac=DB.getSQLValue(null, sql);
				
				//Objeto (HR_Vacation)
				X_HR_Vacation vaca = new X_HR_Vacation(getCtx(), id_vac ,null);
				
				//Marcar como Reprogramada Manual
				X_HR_Vacation_Incidence vacap_2 = new X_HR_Vacation_Incidence(getCtx(),getHR_Vacation_Incidence2_ID() ,null);
				vacap_2.setIsReprogManual(true);
				vacap_2.setIsActive(false);
				vacap_2.save();
							
				sql="SELECT qty_holidays('"+getDateStart5()+"','"+getDateEnd5()+"',null,"+vaca.getC_BPartner_ID()+")";
			    BigDecimal feriados=DB.getSQLValueBD(null,sql);
				
			    sql="SELECT diffdate('"+getDateEnd5()+"','"+getDateStart5()+"')";
			    BigDecimal dias_vac=DB.getSQLValueBD(null,sql);
			    
			    BigDecimal total=dias_vac.subtract(feriados);
			    
			    if(getDateStart4() == null) //Disminuir Días Pendientes (Porque no pasará por Pago de Nómina)
				{
			    	BigDecimal pen = vaca.getPenDays();
			    	pen = pen.subtract(total);
			    	vaca.setPenDays(pen);
			    	vaca.save();
				}
			    
			    String fecha=getDateStart5()+"";  
			    String fecha_d=fecha.substring(8,10)+"-"+fecha.substring(5,7)+"-"+fecha.substring(0,4);

			    String fecha2=getDateEnd5()+""; 
			    String fecha_h=fecha2.substring(8,10)+"-"+fecha2.substring(5,7)+"-"+fecha2.substring(0,4);

			    String nombre="Del "+fecha_d+" al "+fecha_h;
			    
			    //Crear nueva incidencia efectiva
				X_HR_Vacation_Incidence vacae = new X_HR_Vacation_Incidence(getCtx(),0 ,null);
			    vacae.setHR_Vacation_ID(id_vac);
			    vacae.setName(nombre);
			    vacae.setDateStart(getDateStart5());
			    vacae.setDateEnd(getDateEnd5());
			    vacae.setVacDays(total);
			    vacae.setIsProgramated(false);
			    vacae.save();
			    
			    vacr.setHR_Vacation_Incidence2_ID(vacae.getHR_Vacation_Incidence_ID());
			    vacr.setDateStart3(vacae.getDateStart());
			    vacr.setDateEnd3(vacae.getDateEnd());
			}
			
			vacr.save(); //Guardar Vacación Programada
			
		} //Reprogramación

		
		//Vacaciones Anticipadas
		if((getRequisitionType().equals("VAn"))&&(isApproved()))
		{
			//ID de la vacacion
			String sql="SELECT HR_Vacation_ID FROM HR_Vacation WHERE " 
					+" HR_PeriodVac_ID="+getHR_PeriodVac_ID()
					+" AND C_BPartner_ID="+getC_BPartner_ID();
			int id_vac=DB.getSQLValue(null, sql);
						
		    String fecha=getDateStart5()+"";  
		    String fecha_d=fecha.substring(8,10)+"-"+fecha.substring(5,7)+"-"+fecha.substring(0,4);

		    String fecha2=getDateEnd5()+""; 
		    String fecha_h=fecha2.substring(8,10)+"-"+fecha2.substring(5,7)+"-"+fecha2.substring(0,4);

		    String nombre="Del "+fecha_d+" al "+fecha_h;
		    
			//Crear nuevo Vacacion Anticipada
			X_HR_Vacation_Incidence vacaa = new X_HR_Vacation_Incidence(getCtx(),0 ,null);
		    vacaa.setHR_Vacation_ID(id_vac);
		    vacaa.setName(nombre);
		    vacaa.setDateStart(getDateStart5());
		    vacaa.setDateEnd(getDateEnd5());
		    vacaa.setVacDays(getVacDays());
		    vacaa.setIsProgramated(false);
		    vacaa.setIsActive(false);
		    vacaa.setIsAnticipated(true);
		    vacaa.save();
		    
			//Objeto (HR_Vacation)
			X_HR_Vacation vaca = new X_HR_Vacation(getCtx(), id_vac ,null);
			
			//Dias Pendientes
			BigDecimal PenDays = vaca.getPenDays();
			
			//Dias Anticipados
			BigDecimal VacDays_ant = getVacDays();
			
		    //Totalizar días pendientes
		    PenDays=PenDays.subtract(VacDays_ant);		    

		    //Totalizar dias anticipados
		    if(vaca.getAntDays()!=null)
		    {
		    	VacDays_ant=VacDays_ant.add(vaca.getAntDays());
		    }
		    
		    vaca.setPenDays(PenDays);
		    vaca.setAntDays(VacDays_ant);
		    vaca.save();
		    
		    BigDecimal anti = getVacDays();
		    
			//ID de las vacaciones efectivas para disminuir dias anticipados
			sql="SELECT HR_Vacation_Incidence_ID FROM HR_Vacation_Incidence WHERE IsProgramated='N' AND Processed='N'" 
					+" AND HR_Vacation_ID="+id_vac+" ORDER BY DateStart";
			PreparedStatement pstmt = DB.prepareStatement (sql, get_TrxName());
			ResultSet rs;
			try {
				rs = pstmt.executeQuery ();
				while (rs.next ())
				{
					if(!anti.equals(new BigDecimal(0))) 
					{
						//Crear objeto de la vacacion efectiva
						X_HR_Vacation_Incidence vacae = new X_HR_Vacation_Incidence(getCtx(),rs.getInt(1) ,null);								
						if(vacae.getVacDays().compareTo(anti)>=0)
						{
							BigDecimal vacdays = vacae.getVacDays().subtract(anti);
							vacae.setVacDays(vacdays);
							vacae.save();
							
							sql="SELECT qty_holidays('"+vacae.getDateStart()+"',adddays_ts('"+getDateStart()+"',"+vacdays+"),null,"+getC_BPartner_ID()+")";
						    BigDecimal feriados=DB.getSQLValueBD(null,sql);
						    
						    BigDecimal total = vacdays.add(feriados);
						    sql="UPDATE HR_Vacation_Incidence SET DateEnd = adddays_ts('"+vacae.getDateStart()+"',"+total+") WHERE HR_Vacation_Incidence_ID="+vacae.getHR_Vacation_Incidence_ID();
						    DB.executeUpdate(sql, null);
				
						   //Crear objeto de la vacacion efectiva para colocar nombre
							X_HR_Vacation_Incidence vacae_e = new X_HR_Vacation_Incidence(getCtx(),rs.getInt(1) ,null);
						    fecha=vacae_e.getDateStart()+"";  
						    fecha_d=fecha.substring(8,10)+"-"+fecha.substring(5,7)+"-"+fecha.substring(0,4);

						    fecha2=vacae_e.getDateEnd()+""; 
						    fecha_h=fecha2.substring(8,10)+"-"+fecha2.substring(5,7)+"-"+fecha2.substring(0,4);

						    nombre="Del "+fecha_d+" al "+fecha_h;
						    
						    vacae_e.setName(nombre);
						    vacae_e.save();
						    
							anti = new BigDecimal(0);
						}
						else
						{
							anti=anti.subtract(vacae.getVacDays());
							
						    vacae.deleteEx(true, null);
						}
					}
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		} //Vacaciones Anticipadas
					
		
		
		//Vacaciones Efectiva
		if((getRequisitionType().equals("VEf"))&&(isApproved()))
		{
			//ID de la vacacion
			String sql="SELECT HR_Vacation_ID FROM HR_Vacation_Incidence WHERE " 
					+"HR_Vacation_Incidence_ID="+getHR_Vacation_Incidence2_ID();
			int id_vac=DB.getSQLValue(null, sql);
			
			//Objeto (HR_Vacation)
			X_HR_Vacation vaca = new X_HR_Vacation(getCtx(), id_vac ,null);
			
			//Vacacion efectiva
			X_HR_Vacation_Incidence vacaa = new X_HR_Vacation_Incidence(getCtx(), getHR_Vacation_Incidence2_ID(), null);
		    vacaa.setIsActive(false);
		    vacaa.save();
		    
			//Dias Pendientes
			BigDecimal PenDays = vaca.getPenDays();
			
			//Dias Anticipados
			BigDecimal VacDays = vacaa.getVacDays();
			
		    //Totalizar días pendientes
		    PenDays=PenDays.subtract(VacDays);	
		    
		    vaca.setPenDays(PenDays);
			vaca.save();
			
		} //Vacaciones Efectivas
		
		//Vacaciones reprogramacion efectivas
		if((getRequisitionType().equals("VRv"))&&(isApproved()))
		{
			//ID de la vacacion
			String sql="SELECT HR_Vacation_ID FROM HR_Vacation_Incidence WHERE " 
					+"HR_Vacation_Incidence_ID="+getHR_Vacation_Incidence3_ID();
			int id_vac=DB.getSQLValue(null, sql);
			
			//Objeto (HR_Vacation)
			X_HR_Vacation vaca = new X_HR_Vacation(getCtx(), id_vac ,null);
			
			//Vacacion efectiva
			X_HR_Vacation_Incidence vacaa = new X_HR_Vacation_Incidence(getCtx(), getHR_Vacation_Incidence3_ID(), null);
		    vacaa.setIsActive(false);
		    vacaa.save();
		    
			//Dias Pendientes
			BigDecimal PenDays = vaca.getPenDays();
			
			//Dias Anticipados
			BigDecimal VacDays = vacaa.getVacDays();
			
		    //Totalizar días pendientes
		    PenDays=PenDays;	
		    
		    vaca.setPenDays(PenDays);
			vaca.save();
			
		} //Vacaciones Efectivas
				
		
		/*
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}
		*/
		
		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();
		
		
		//ENVIO
		
		//Obtener Periodo
		String sql="SELECT per.name FROM HR_PeriodVac per WHERE " 
				+"HR_PeriodVac_ID="+getHR_PeriodVac_ID();
		String periodo=DB.getSQLValueString(null, sql);
		
		//Obtener Empleado
		sql="SELECT emp.name FROM C_BPartner emp WHERE " 
				+"C_BPartner_ID="+getC_BPartner_ID();
		String empleado=DB.getSQLValueString(null, sql);
		
		//Obtener tipo de nomina
		sql="SELECT emp.hr_payroll_type_id FROM HR_Employee emp WHERE IsActive='Y' " 
				+"AND C_BPartner_ID="+getC_BPartner_ID();
		int payroll=DB.getSQLValue(null, sql);
		
		if(payroll==1000008) //Envio de correo solo a personal lottt
		{
			//Obtener tipo de Solicitud
			sql ="SELECT name FROM AD_Ref_List WHERE AD_Reference_ID=1000133 AND value='"+getRequisitionType()+"'";
			String tipo = DB.getSQLValueString(null,sql);
			
		    String titulo= "Aprobación de Vacaciones";
		    
		    String aprobado;
		    if (isApproved())
		    	aprobado ="Aprobada";
		    else
		    	aprobado ="Reprogramada";
		    
			//Envio de correo de vacación aprobada / reprogramada
			sql="SELECT DISTINCT email FROM AD_User WHERE C_BPartner_ID="+getC_BPartner_ID();
			
				String mail_u=DB.getSQLValueString(null, sql);
				
			    String body = "<p>Estimado (s) Señor(es) "+ empleado +"</p> " +
			    		"<p>Por medio del presente le notificamos que su solicitud de vacaciones ha sido "+aprobado+".</p>"+
			    		"<p>Para visualizar la solicitud pulse aquí " +
			    		"<A HREF=\"http://adempiere.esvenca.com:8084/webui/\">ADempiere</A>. "+
			    		"<br><br><br>"+
			    		"<p ALIGN=right><i>Esperando brindarle la Calidad de Servicio que usted se merece." +
			    		"<br>Equipo de Planificación y Compensación.</i></p>" +
			    		"<br>" +
			    		"<p ALIGN=right><FONT SIZE=2>En caso de perdida de usuario o clave ADempiere comunicarse con "+ 
						"<A HREF= \"http://soporte.esvenca.com\">Soporte IT</A>.</FONT>";
			    		    
			   NewEmail correo = new NewEmail();
			   //sendEmail(String from, String to,String tittle,String subtittle, String body)    
			   correo.sendEmail(null, mail_u, titulo, null, body);
		}
		
		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
						
	} //completit


	private void setDefiniteDocumentNo() {
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());

		if (dt.isOverwriteSeqOnComplete()) {
			String value = DB.getDocumentNo(getC_DocType_ID(), get_TrxName(), true, this);
			if (value != null)
				setDocumentNo(value);
		}
	}
	
	@Override
	public boolean voidIt() {
		
		int HR_Vacation_Incidence2_ID = 0;
		
		//No Aprobado
		if(!isApproved())
			return false;
		
		//No es Vacación Efectiva ni Vacación Programada
		if((!getRequisitionType().equals("VEf")) && (!getRequisitionType().equals("VPr")) && (!getRequisitionType().equals("VRv")) && (!getRequisitionType().equals("VAn"))){
			m_processMsg = "No se pueden Anular las Reprogramaciones de Vacaciones Completas";
			return false;
		}
		
		
		
		
		
		
		//Anulación de Vacaciones Programadas
		if((getRequisitionType().equals("VPr"))&&(isApproved()))
		{
			X_HR_Vacation_Incidence vi_p = new X_HR_Vacation_Incidence(Env.getCtx(), getHR_Vacation_Incidence_ID(), get_TrxName());
			
			X_HR_Vacation vac = new X_HR_Vacation(Env.getCtx(), vi_p.getHR_Vacation_ID(), get_TrxName());
			
			//No se puede anular vacaciones pagas
			if(vac.isPaid()){
				m_processMsg = "No se pueden Anular Solicitudes de Vacaciones que ya entraron en un Proceso de Nómina";
				return false;
			}
			
			vi_p.setIsActive(true);
			vi_p.save();
		}
		
		//Si tiene disfrute (Vacaciones Efectivas)
		if(getHR_Vacation_Incidence2_ID() != 0){
			X_HR_Vacation_Incidence vi = new X_HR_Vacation_Incidence(Env.getCtx(), getHR_Vacation_Incidence2_ID(), get_TrxName());
			
			if(!vi.isActive()){
				vi.setIsActive(true);
				vi.save();
				
				X_HR_Vacation vac = new X_HR_Vacation(Env.getCtx(), vi.getHR_Vacation_ID(), get_TrxName());
				vac.setPenDays(vac.getPenDays().add(vi.getVacDays()));
				vac.save();
			}	
		} 
		int pd1 =  getPenDays().intValue();
		String sql = "UPDATE HR_Vacation set PenDays = PenDays + " +pd1 + " WHERE HR_PeriodVac_ID="+ getHR_PeriodVac_ID() + " and C_BPArtner_ID=" + getC_BPartner_ID();
		DB.executeUpdate(sql);
		
		setProcessed(true);
		setDocAction(DOCACTION_None);	
		return true;
	}


	@Override
	public boolean closeIt() {
		// TODO Auto-generated method stub
		log.info(toString());
		// Before Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_CLOSE);
		if (m_processMsg != null)
			return false;

		// After Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_CLOSE);
		if (m_processMsg != null)
			return false;

		
		//setDocAction(DOCACTION_None);
		return true;
	}


	@Override
	public boolean reverseCorrectIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean reverseAccrualIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean reActivateIt() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getDocumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File createPDF() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	public String getProcessMsg()
	{
		return m_processMsg;
	}	//	getProcessMsg


	@Override
	public int getDoc_User_ID() {
		// TODO Auto-generated method stub
		return 0;
	}


	protected boolean beforeSave (boolean newRecord)
	{
		//setDescription(getDescription(), "M");
		
		return true;
	}	//	beforeSave

	@Override
	public int getC_Currency_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Solo se borra lo que este en estado Borrador
	@Override
	protected boolean beforeDelete() {
		
		String valida =  DB.getSQLValueString(null,"SELECT DocStatus FROM HR_VacationRequisition WHERE HR_VacationRequisition_ID=" + getHR_VacationRequisition_ID());
        if (!valida.contains("DR")){
        	
        	throw new AdempiereException("No se puede Eliminar este documento por motivos de Auditoria");

        }
		
		return true;
	}
	
	
}   //  MVacationRequisition


