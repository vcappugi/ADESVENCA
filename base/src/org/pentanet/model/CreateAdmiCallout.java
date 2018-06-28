package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.model.MQuery;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;
import org.compiere.util.DB;

public class CreateAdmiCallout extends CalloutEngine {
	/*
	 *Creacion del registro de la admision 
	 * 
	 *
	 */	
	public String Create_admision (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
				String ID_Patient =   Env.getContext(ctx, WindowNo, "H_Patient_ID");
				int M_PriceList_Version_ID=0;
				
				MHPatient Pacient = new MHPatient(ctx,Integer.parseInt(ID_Patient),null );
				
				if (Pacient.getName().isEmpty() ) {
					ADialog.error(WindowNo, null, "Error", "No se ha registrado paciente, almacene primero antes de crear Admision");
					return null;
				}
				//Validacion de Emision de Diagnostico Previo.
				String Diagnostic = Pacient.getInitialDiagnostic();
				if (Diagnostic == null) {
					ADialog.error(WindowNo, null, "Alerta", "No se ha detectado Diagnostico Previo, \n no se generara Admision sin este diagnostico");
				    return null;
				}		
		//Revision de la existencia de admisiones activas
		String sql = "SELECT count(H_Admission_ID) FROM ADEMPIERE.H_ADMISSION WHERE ISACTIVE='Y' AND DOCSTATUS IN ('DR', 'PR') AND H_PATIENT_ID="+ID_Patient;
		Integer totalA = DB.getSQLValue(null, sql);
		if (totalA > 0 ) {
			ADialog.error(WindowNo, null, "Alerta", "Se ha detectado una admision pendiente para este paciente, \n no se creara un nuevo registro");
		    return null;
		    }
		
		//Fecha actual
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		  long lnMilisegundos = utilDate.getTime();
		  //java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		  //java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
		  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
			
		//Creación del documento de Admision
		MHAdmission Admision = new MHAdmission (ctx, 0, null);
			Admision.setName("G.: " + Pacient.getName());
			Admision.setH_Patient_ID(Integer.parseInt(ID_Patient));
			Admision.setDescription(Diagnostic);
			Admision.setAdmissionDate(sqlTimestamp);
			Admision.setC_SalesRegion_ID(Pacient.getC_SalesRegion_ID());
			Admision.setC_SalesRegionD_ID(Pacient.getC_SalesRegionD_ID());
			Admision.setH_Bed_ID(Pacient.getH_Bed_ID());
			Admision.setC_DocType_ID(1000043);
			Admision.setAlta("N");
			if(Pacient.getPaymentForm().equalsIgnoreCase("S")){   //Solo para cuando la forma de pago es seguro medico
				M_PriceList_Version_ID = DB.getSQLValue(null, "select m_pricelist_id from c_bpartner where c_bpartner_id ="+Pacient.getC_BPartner_ID());
				Admision.setM_PriceList_Version_ID(M_PriceList_Version_ID);
			}			
			Admision.save();
			
			//Crea movimiendo de asignacion de cama.
			MHTransfer trans = new MHTransfer(ctx, 0, null);
			trans.setH_Admission_ID(Admision.getH_Admission_ID());
			trans.setName("Localizacion Inicial");
			trans.setC_SalesRegion_ID(Pacient.getC_SalesRegion_ID());
			trans.setC_SalesRegionD_ID(Pacient.getC_SalesRegionD_ID());
			trans.setH_Bed_ID(Pacient.getH_Bed_ID());
			trans.setDateTrx(sqlTimestamp);
			trans.save();
			
		    //Crear el caso medico.
			MHHistory Hist = new MHHistory (ctx, 0, null);
			Hist.setH_Patient_ID(Pacient.getH_Patient_ID());
			Hist.setHDate(sqlTimestamp);
			Hist.setName("D.I.: " + Pacient.getInitialDiagnostic());
			Hist.setH_Admission_ID(Admision.getH_Admission_ID());
			Hist.setAlta("N");
			
			Hist.save();
			
			//Registra el responsable financiero
			/*
			 * 
			MHResponsibleF respf = new MHResponsibleF(ctx,0,null);
			respf.setC_BPartner_ID(Pacient.getC_BPartner_ID());
			respf.setH_Admission_ID(Admision.getH_Admission_ID());
			respf.setH_Patient_ID(Pacient.getH_Patient_ID());
			respf.setKey(" ");
			respf.save();
			*/
			
			ADialog.info(WindowNo, null, "Admision nro "+Admision.getDocumentNo()+" generada, queda en estado borrador para constatar los datos");
			
			
			
		return null;
	} //CreateAdmision

	
	public String Generate_Budget (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		//Creado por vcappugi.
		//Modificado por Vladimir Mata
		//Creacion del registro de la admision
		//Validaciones iniciales
		if (!ADialog.ask(WindowNo, null, "¿Desea generar el presupuesto para el paciente?")) return "";
		
		if (Env.getContext(ctx, WindowNo, "H_Diagnostic_ID")=="") {
			ADialog.error(WindowNo, null, "Debe colocar un Diagnóstico Base antes de generar el Presupuesto Asignado");
			return "Error: Colocar un Diagnóstico Base";
		}
		
		//Busqueda de datos de paciente
		String ID_Patient =   Env.getContext(ctx, WindowNo, "H_Patient_ID");
		String ID_Admision = Env.getContext(ctx, WindowNo, "H_Admission_ID");
		MHAdmission Admision = new MHAdmission (ctx,Integer.parseInt(ID_Admision), null);
		String Productos="";
				
		//Buscar el presupuesto base del diagnostico
		String sql = "SELECT H_Budget_ID FROM ADEMPIERE.H_Budget WHERE ISACTIVE='Y' AND H_Diagnostic_ID="+ Admision.getH_Diagnostic_ID();
		
		Integer Budget_ID = DB.getSQLValue(null, sql);		
		MHPatient Patient = new MHPatient(ctx, Integer.parseInt(ID_Patient), null);
		
		//Buscar presupuesto asignado para el paciente, con admisión en estado borrador
		sql="SELECT abu.H_ASIGNED_BUDGET_ID FROM H_ADMISSION adm " +
			"INNER JOIN H_ASIGNED_BUDGET abu ON abu.H_ADMISSION_ID=adm.H_ADMISSION_ID " +
			"WHERE adm.H_PATIENT_ID="+Integer.parseInt(ID_Patient);
		
		Integer A_Budget_ID = DB.getSQLValue(null, sql);
		
		//Verificar si existe un presupuesto asignado al paciente y crearlo si no tiene.
		if (A_Budget_ID < 0){
			
			MHAsignedBudget A_Budget= new MHAsignedBudget(ctx,0,null);
						
			//Cabecera del Presupuesto asignado
			A_Budget.setH_Admission_ID(Integer.parseInt(ID_Admision));
			A_Budget.setName("P.G.: " + Patient.getName());
			A_Budget.setH_Patient_ID(Patient.getH_Patient_ID());
			A_Budget.setDescription(Admision.getDescription());
			A_Budget.setH_Diagnostic_ID(Admision.getH_Diagnostic_ID());
			A_Budget.setH_Budget_ID(Budget_ID);
			
			A_Budget.save();
			A_Budget_ID=A_Budget.getH_Asigned_Budget_ID();
		}
		
		//Actualizar fecha del presupuesto
		MHAsignedBudget A_Budget= new MHAsignedBudget(ctx,A_Budget_ID,null);
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
		A_Budget.setDateTrx(sqlTimestamp);
		A_Budget.setM_PriceList_Version_ID(Admision.getM_PriceList_Version_ID());
		//A_Budget.get_Table_ID();
		
		A_Budget.save();
		
		DB.executeUpdate("DELETE FROM H_ASIGNED_BUDGET_LINE WHERE H_ASIGNED_BUDGET_ID="+A_Budget_ID, ctx.toString());
		
		//Líneas del Presupuesto Asignado 
		String sql_l =	"SELECT DISTINCT pr.Name, pr.Description, bl.M_Product_ID, bl.C_UOM_ID, bl.Qty, pp.PRICELIST, umc.dividerate " +
						"FROM H_ADMISSION adm " +
						"INNER JOIN M_PRODUCTPRICE pp ON pp.M_PRICELIST_VERSION_ID=adm.M_PRICELIST_VERSION_ID "+
						"RIGHT JOIN H_BUDGETLINE bl ON bl.M_PRODUCT_ID=pp.M_PRODUCT_ID "+
						"INNER JOIN M_PRODUCT pr ON pr.M_PRODUCT_ID=bl.M_PRODUCT_ID "+
						"INNER JOIN C_UOM um ON um.C_UOM_ID=bl.C_UOM_ID "+
						"LEFT JOIN C_UOM_CONVERSION umc ON umc.C_UOM_ID=pr.C_UOM_ID AND umc.C_UOM_TO_ID=bl.C_UOM_ID "+
						"WHERE adm.H_ADMISSION_ID="+Integer.parseInt(ID_Admision)+" AND (H_BUDGET_ID="+Budget_ID+" "+
						"OR H_BUDGET_ID IN (SELECT H_BUDGET_ID FROM H_BUDGET bud INNER JOIN h_additionaldiag adia ON adia.H_DIAGNOSTIC_ID=bud.H_DIAGNOSTIC_ID WHERE adia.H_ADMISSION_ID="+Integer.parseInt(ID_Admision)+")) "+
						"ORDER BY bl.M_PRODUCT_ID";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql_l, "MHAsignedBudget");
			//pstmt.setInt(1, Variable Int);
			rs = pstmt.executeQuery();
			
			BigDecimal PA_BudgetLine_ID=new BigDecimal(0);	//Línea anterior
			BigDecimal PM_Product_ID=new BigDecimal(0);		//Producto anterior
			BigDecimal MaxQty=new BigDecimal(0);			//Máxima cantidad base del producto
			int i=0;
			
			while (rs.next())
			{
				//Crear cada línea correspondiente al Presupuesto Base								
				MHAsignedBudgetLine A_BudgetLine= new MHAsignedBudgetLine(ctx,0,null);
				A_BudgetLine.setH_Asigned_Budget_ID(A_Budget_ID);
				A_BudgetLine.setName(rs.getString(1));
				A_BudgetLine.setDescription(rs.getString(2));
				A_BudgetLine.setM_Product_ID(rs.getInt(3));
				A_BudgetLine.setC_UOM_ID(rs.getInt(4));
				A_BudgetLine.setQty(rs.getBigDecimal(5));
				A_BudgetLine.setPriceList(rs.getBigDecimal(6));
				A_BudgetLine.setPriceActual(A_BudgetLine.getPriceList());
				A_BudgetLine.setQtyBudgeted((rs.getBigDecimal(7)==null ? rs.getBigDecimal(5):rs.getBigDecimal(7).multiply(rs.getBigDecimal(5))));
				A_BudgetLine.setPriceEntered((rs.getBigDecimal(7)==null ? rs.getBigDecimal(6):rs.getBigDecimal(7).multiply(rs.getBigDecimal(6))));
				A_BudgetLine.setLineNetAmt(A_BudgetLine.getPriceEntered().multiply(A_BudgetLine.getQty()));
				A_BudgetLine.setLineTotalAmt(A_BudgetLine.getLineNetAmt());
										
				MHAsignedBudgetLine PA_BudgetLine= new MHAsignedBudgetLine(ctx,Integer.parseInt(PA_BudgetLine_ID.toString()),null);
				
				if(PM_Product_ID.compareTo(new BigDecimal(A_BudgetLine.getM_Product_ID()))==0) { 
					if (A_BudgetLine.getQtyBudgeted().compareTo(MaxQty)>0) {
						
						PA_BudgetLine.setC_UOM_ID(rs.getInt(4));
						PA_BudgetLine.setQty(rs.getBigDecimal(5));
						PA_BudgetLine.setQtyBudgeted((rs.getBigDecimal(7)==null ? rs.getBigDecimal(5):rs.getBigDecimal(7).multiply(rs.getBigDecimal(5))));
						PA_BudgetLine.setPriceEntered((rs.getBigDecimal(7)==null ? rs.getBigDecimal(6):rs.getBigDecimal(7).multiply(rs.getBigDecimal(6))));
						PA_BudgetLine.setLineNetAmt(A_BudgetLine.getPriceEntered().multiply(A_BudgetLine.getQty()));
						PA_BudgetLine.setLineTotalAmt(PA_BudgetLine.getLineNetAmt());
						PA_BudgetLine.save();						
					}						
				}
				else {
					Productos=Productos+(++i)+".-\t"+A_BudgetLine.getName()+"\n";
					A_BudgetLine.setLine(i);
					A_BudgetLine.save();
					PA_BudgetLine_ID=new BigDecimal(A_BudgetLine.getH_Asigned_Budget_Line_ID());
					PM_Product_ID=new BigDecimal(A_BudgetLine.getM_Product_ID());
					
				}
				MaxQty=A_BudgetLine.getQtyBudgeted();
			}
			A_Budget.setTotal_Budget();	
			//Aqui llama metodo que crea el responsable financiero.....
			Registra_RF(Admision, Patient, ctx);
		}
		catch(Exception e){
			return e.toString();
		}
		
		MPriceListVersion PriceList=new MPriceListVersion(ctx,Admision.getM_PriceList_Version_ID(),null);
		String MissingP="";		
		if (MissingProducts(ctx,A_Budget)!="")
			MissingP="\nLos siguientes Productos no fueron agregados: \n\n"+MissingProducts(ctx,A_Budget)+"\n Ya que no se encuentran en la lista de precios \""+PriceList.getName()+"\"";
		
		ADialog.info(WindowNo, null, "Presupuesto Asignado del Paciente "+Patient.getName()+" generado\nContiene los siguientes productos:\n"+Productos+MissingP);
		
		//if (ValidaPresusuesto(ctx,Integer.parseInt(ID_Admision))>0) {
			//ADialog.error(WindowNo, null, "El Presupuesto Asignado supera la Covertura del Paciente\nEstatus del Presupuesto Asignado: \"En Negociación\"\n");
			A_Budget.setABudgetStatus("EN");			
		//}
		//else {
			//A_Budget.setABudgetStatus("VA");
		//}
		A_Budget.save();
		Admision.setGenerateBudget("Y");
		Admision.save();
		mTab.dataRefresh();
		
		return "Presupuesto Asignado creado con Éxito";
	}//Generate_Budget
	
	public static int ValidaPresusuesto(Properties ctx, int H_Admission_ID){
		MHAdmission Admission = new MHAdmission(ctx, H_Admission_ID, null);
		
		String sql="SELECT SUM(coverage) FROM H_EPersons WHERE H_Admission_ID="+Admission.getH_Admission_ID();
		BigDecimal Coverage=new BigDecimal(DB.getSQLValue(null, sql));
		
		sql="SELECT H_Asigned_Budget_ID FROM H_Asigned_Budget WHERE H_Admission_ID="+Admission.getH_Admission_ID(); 
		MHAsignedBudget Budget =new MHAsignedBudget(ctx, DB.getSQLValue(null, sql), null);
		
		return Budget.getTotal_Budget().compareTo(Coverage);
	}
	
	public static String MissingProducts (Properties ctx, MHAsignedBudget A_Budget){
		
		MHAdmission Admission=new MHAdmission(ctx, A_Budget.getH_Admission_ID(),null);
		String Products="";
		
		String sql = "SELECT H_Budget_ID FROM ADEMPIERE.H_Budget WHERE ISACTIVE='Y' AND H_Diagnostic_ID="+ Admission.getH_Diagnostic_ID();
		Integer Budget_ID = DB.getSQLValue(null, sql);
				
		sql =	"SELECT pr.Name, pr.M_Product_ID FROM H_BudgetLine bl INNER JOIN M_Product pr ON pr.M_Product_ID=bl.M_Product_ID " +
				"WHERE (H_BUDGET_ID="+Budget_ID+" OR H_BUDGET_ID IN (SELECT H_BUDGET_ID FROM H_BUDGET bud INNER JOIN h_additionaldiag adia ON adia.H_DIAGNOSTIC_ID=bud.H_DIAGNOSTIC_ID WHERE adia.H_ADMISSION_ID="+A_Budget.getH_Admission_ID()+")) " +
				"AND bl.M_Product_ID NOT IN (SELECT M_Product_ID FROM H_Asigned_Budget_Line WHERE H_Asigned_Budget_ID="+A_Budget.getH_Asigned_Budget_ID()+") ORDER BY pr.Name";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, "ProductsMissing");
			rs = pstmt.executeQuery();	
			
			int i=0;			
			while (rs.next()) Products=Products+(++i)+".-\t"+rs.getString(1)+"\n";			
		}
		catch (Exception e)
		{
			return e.toString();
		}
		return Products;
	}
/*
 * Callout para buscar y colocar el paciente en la ventana.
 */
	public String search_patient(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		String whereClause="";
		if (value!=null) {
			int id = DB.getSQLValue(null, "Select H_PATIENT_ID from H_PATIENT WHERE IDCard='" + (String) value+"'");
			if (id > 0) {
				whereClause = "H_Patient_ID ="+id;
				mTab.dataIgnore();
			    mTab.setCurrentRow(id);
			    MQuery query = new MQuery("H_Patient");
			    query.addRestriction(whereClause);
			    mTab.setQuery(query);
			    mTab.query(true);
			    mTab.dataRefresh();
			}		
			//ADialog.warn(WindowNo, null, "El Paciente con ced " + (String) value );
		
		}
		return "";
	}
/*
 * Registrar el responsable financiero directamente desde la preadmision 
 * con los datos registrados al principio (Preadmision)
 */

	public String Registra_RF (MHAdmission Admision, MHPatient pacient, Properties ctx  ) {
		//Buscar si no existe ya el responsable para no crearlo 2 veces
		
		// crea nuevo objeto de tipo responsibleF
		MHResponsibleF respF = new MHResponsibleF(ctx, 0, null);
		respF.setH_Admission_ID(Admision.getH_Admission_ID());
		respF.setH_Patient_ID(pacient.getH_Patient_ID());
		if (pacient.isFResponsible()) {
			respF.setValue(pacient.getIDCard());
		}
		else {
			respF.setTitular(pacient.getTitular_Poliza());
			respF.setValue(pacient.getCed_titular());
			respF.setCopyCI(pacient.isCedula());
			respF.setCard(pacient.isCarnet());
			respF.setU_Voucher(pacient.isUltimoV());
			respF.setC_BPartner_ID(pacient.getC_BPartner_ID());
		}
		respF.setDescription("Incluido en la Pre - Admision");	
		
		
		respF.save();
		
		
		
		return null;
	}
	
	/*
	 * Callout para cambio de alta en las admisiones
	 * parecido a cambio de estado, pero con el campo ALTA.
	 * N: no esta de alta
	 * M: Alta medica (documento en proceso)
	 * A: Alta administrativa (documento completo)
	 */
	public String Alta(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		//String ID_Patient =   Env.getContext(ctx, WindowNo, "H_Patient_ID");
		//String ID_Admision = Env.getContext(ctx, WindowNo, "H_Admission_ID");
		String cama_id, paciente;
		
		
		
		String ID_Admision = mTab.getValue("H_Admission_ID").toString();
		String al_ta = (String) value;
		
		if (al_ta.equalsIgnoreCase("N") && mTab.getAD_Table_ID()!=1000013){
			DB.executeUpdate("UPDATE H_Admission SET Alta='M'WHERE H_Admission_ID="+ID_Admision, null);
			DB.executeUpdate("UPDATE H_MHistory SET Alta='M' WHERE H_Admission_ID="+ID_Admision, null);
			ADialog.warn(WindowNo, null, "Se realizo el Alta Médica del Paciente. ");
		}
		if (al_ta.equalsIgnoreCase("N") && mTab.getAD_Table_ID()==1000013){
			ADialog.error(WindowNo, null, "Solo el Medico tratante puede realizar el Alta Médica");
		}
		if (al_ta.equalsIgnoreCase("M") && mTab.getAD_Table_ID()==1000013) { //Solo se hace alta administrativa desde la ventana de Admision
			DB.executeUpdate("UPDATE H_Admission SET Alta='A' WHERE H_Admission_ID="+ID_Admision, null);
			//Libera la cama....
			cama_id = mTab.getValue("H_Bed_ID").toString();
			paciente = mTab.getValue("H_Patient_ID").toString();
			ADialog.info(WindowNo, null, "Se marcara la cama como desocupada");
			DB.executeUpdate("UPDATE H_BED SET IsOccupied='N' WHERE H_Bed_ID="+cama_id,null);
			//Vacia los datos de ubicacion del paciente
			DB.executeUpdate("UPDATE H_PAtient SET C_SalesRegion_ID=null, C_SalesRegionD_ID=null, H_Bed_ID=null WHERE H_PAtient_ID="+paciente,null);
			
			
		}
		
		
		
		mTab.dataRefresh();
		
		return "";
	}
	
	/*
	 * Procesar el presupuesto desde la ventana de Admision
	 * Cambia el estatus del pressupuesto solo a Procesado. El cierre del presupuesto
	 * Debe hacerse por la ventana de presupuesto
	 */
	public String Proc_Budget(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		//Crea el Objeto del presupuesto asignado
		String Admission = mTab.get_ValueAsString("H_Admission_ID").toString();
		String sql="SELECT H_Asigned_Budget_ID FROM H_Asigned_Budget WHERE H_Admission_ID="+Admission; 
		MHAsignedBudget Budget =new MHAsignedBudget(ctx, DB.getSQLValue(null, sql), null);
		if (Budget.getDocStatus().equalsIgnoreCase("DR")) //Solo si esta en estatus borrador, lo coloca como procesado
			{
			Budget.setDocStatus("IP");
			Budget.setDocAction("CO");
			Budget.save();
			DB.executeUpdate("UPDATE H_Admission SET GenerateBudget='A' WHERE H_Admission_ID="+Admission,null);
			
			}
		//Refresco el mTab completo para que aparezca el boton de accion de la admision
		mTab.dataRefresh();
		return "";
	}
	
}
