/***********************************************************
 * Crea la orden de compra desde el presupuesto asignado
 * en base a los datos grabados en el paciente
 * Por vcappugi
 * vcappugi@gmail.com
 *********************************************************/

package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;
import org.pentanet.model.*;
import org.compiere.model.*;

public class Create_SO_frombudgeta extends SvrProcess {
	private int ABudget_ID =0;
	private int ABudget_aux_ID=0;
	
	
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("H_Asigned_Budget_ID"))
				ABudget_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else
				log.log(Level.SEVERE, "prepare - Unknown Parameter: " + name);
		}

	}

	
	protected String doIt() throws Exception {
		//int ABudget_aux_ID = getRecord_ID();
		//creo un objeto de tipo ABUDGET con el presupuesto existente en memoria (getRecordID)
		int admision = Env.getContextAsInt(getCtx(), "#H_Admission_ID");
		ADialog.warn(0, null, "el nro de Admision :"+ admision);
			
		MHAsignedBudget MAsigned = new MHAsignedBudget(getCtx(), getRecord_ID(), get_TrxName());
		int HAdmision_ID= MAsigned.getH_Admission_ID();
		//Valida el estado de la admision, si no esta en proceso, no podra hacer nada
		MHAdmission Admision = new MHAdmission (getCtx(), HAdmision_ID, get_TrxName());
		if (!Admision.getDocStatus().equalsIgnoreCase("IP"))
			return "Error, no se puede generar Orden sin una Admision en proceso";
		
		//Obtener el monto total del presupuesto
		BigDecimal tot_bud = MAsigned.getTotal_Budget();
		String SQL_Prod_B = null;
		String linea = null;
		String DocNo = "";
		String dev ="";
		int h_pat = MAsigned.getH_Patient_ID();
	    int BPartner_ID = DB.getSQLValue(null, "SELECT C_BPartner_ID FROM C_BPartner WHERE value =(SELECT IDCARD FROM H_PATIENT WHERE H_PATIENT_ID="+MAsigned.getH_Patient_ID()+")");
		//creo la orden del sdn del cliente
		
		MSalesOrder Osales = CreateSOrder(MAsigned, BPartner_ID); //creo cabecera de Orden
		
				//grabo la covertura en la orden para referencia
			//Osales.setAmount_Coverage(Cob);
				//Ahora toaca grabar la distribucion de los productos.
				Osales.save();
				DocNo = Osales.getDocumentNo();
				//Ahora ciclo para cada producto del presupuesto base
				SQL_Prod_B ="SELECT M_PRODUCT_ID, QTY, PRICEENTERED, C_UOM_ID, H_ASIGNED_BUDGET_ID FROM H_ASIGNED_BUDGET_LINE WHERE H_ASIGNED_BUDGET_ID= "+ MAsigned.getH_Asigned_Budget_ID();
				
				ResultSet rs = null;
				try
				{
					PreparedStatement pstmt1 = DB.prepareStatement (SQL_Prod_B, "H_ASIGNED_BUDGET_LINE");
					rs = pstmt1.executeQuery();
					while (rs.next())
					{
						//Crear la linea desde el presupuesto
						dev = Osales.CreateOrderLine(Osales, rs.getInt(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getInt(4),rs.getInt(5), "NC");
						
					}
				}
				catch(Exception e){
					return e.toString();
				}
				
		return "Ordenes Generadas Nro: " + DocNo ;
	}
	
/*****************************************************************************
 * Creacion de la Orden de Venta
 * desde el presupuesto asignado
 * Recibe: Objeto tipo Presupuesto asignado
 *         Entero con el id del SDN a crear
 * Devuelve: objeto tipo Orden de Venta (cabecera)	
 ******************************************************************************/
	
	public MSalesOrder CreateSOrder(MHAsignedBudget MAsigned, int C_BPartner_ID){
		int C_DocType_ID=1000030;	//Tipo de doc. Orden de Venta Standar
		int HAdmision_ID= MAsigned.getH_Admission_ID();
		
		
	    MSalesOrder Sorder = null;
		if (!(C_BPartner_ID >0))
			return null;
		else {
			//El termino de Pago, en caso de que no exista, se colocara inmediato...
			int PaymentTerm = DB.getSQLValue(null, "SELECT C_PAYMENTTERM_ID FROM C_BPARTNER WHERE C_BPARTNER_ID ="+C_BPartner_ID);
		    if (!(PaymentTerm > 0)) {
		    	PaymentTerm = DB.getSQLValue(null, "SELECT C_PAYMENTTERM_ID FROM C_PAYMENTTERM WHERE ISDEFAULT ='Y'");
		    	 if (!(PaymentTerm > 0))
		    		 PaymentTerm = 1000004;   //OJO ESTE ES EL ID DE CONTADO, PERO NO DEBERIA SER DIRECTO
		    }
		    int Pricelist = DB.getSQLValue(null, "SELECT M_PRICELIST_ID FROM C_BPARTNER WHERE C_BPARTNER_ID ="+C_BPartner_ID);
		    if (!(Pricelist > 0)) {
		    	Pricelist = DB.getSQLValue(null, "select m_pricelist_id from m_pricelist_version where m_pricelist_version_id in  (select m_pricelist_version_id from h_admission where h_admission_id ="+HAdmision_ID+")");
		    	if (!(Pricelist > 0))
		    		Pricelist =1000000;
		    }
		    //La direccion del cliente
		    int CBP_Loc = DB.getSQLValue (null, "select c_bpartner_location_id from c_bpartner_location where c_bpartner_id =" + C_BPartner_ID);
		    
		//Busco la admision si fue generada
		int SalesOrder_ID = DB.getSQLValue(null, "SELECT C_ORDER_ID FROM C_ORDER WHERE H_ADMISSION_ID ="+HAdmision_ID + "AND C_BPARTNER_ID="+C_BPartner_ID);
		if (SalesOrder_ID<0){    		    
					Sorder = new MSalesOrder(getCtx(), 0, get_TrxName());				
					Sorder.setC_DocType_ID(C_DocType_ID);
					//Sorder.setDateOrdered();
					Sorder.setC_BPartner_ID(C_BPartner_ID);
					Sorder.setC_BPartner_Location_ID(CBP_Loc);
					Sorder.setSalesRep_ID(1000000);  			//Representante de ventas admin
					Sorder.setIsSOTrx(true);		 			//Es una orden de ventas
					Sorder.setC_PaymentTerm_ID(PaymentTerm);	//Termino de Pago del sdn
					Sorder.setM_PriceList_ID(Pricelist);        //La Lista de precios
					Sorder.setH_Admission_ID(HAdmision_ID);     //Relacion con la Admision
					
					Sorder.save();
					}
		else
		{
			Sorder =new MSalesOrder(getCtx(),SalesOrder_ID,get_TrxName()); //Si la orden existe, devuelvo la orden  
		}
		
		return Sorder;
		}
	}
	
}
