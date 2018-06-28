package org.pentanet.model;

import java.util.Properties;
import org.compiere.util.DB;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;


public class MHPatient extends X_H_Patient {

	public MHPatient(Properties ctx, int M_Patient_ID, String trxName)
	{
		super (ctx, M_Patient_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		return true;
		
	}
	/**
	 * 	After Save
	 *	@param newRecord new
	 *	@param success success
	 *	@return success
	 */
	protected boolean afterSave (boolean newRecord, boolean success){	
		MBPartner bpart, bpart2;
		MBPartnerLocation bploc, bploc2;
		//ubico o busco en sdn por cedula a ver si existe
	int existe = DB.getSQLValue(null, "SELECT C_BPARTNER_ID FROM C_BPARTNER WHERE VALUE='" + getIDCard()+"'");
	
	if (existe <= 0) {
		bpart = new MBPartner( getCtx() ,0,null);
		bpart.setName(getName());
		bpart.setValue(getIDCard());
		bpart.setIsCustomer(true);
		bpart.setC_BP_Group_ID(1000003);   //Grupo de Pacientes .... crear y buscar id
		//Direccion del SDN	
		bpart.save();
		//Actualizo la marca de responsable financiero
		//Solo si es diferente de seguro medico
		if (!getPaymentForm().contentEquals("S")) {
			if (isFResponsible())
				DB.executeUpdate("UPDATE C_BPartner set isfresponsible='Y' where C_BPartner_ID="+bpart.getC_BPartner_ID(),null);
			else{
				//Creo un nuevo socio de negocios
				existe = DB.getSQLValue(null, "SELECT C_BPARTNER_ID FROM C_BPARTNER WHERE VALUE='" + getCed_titular()+"'");
				if (existe <= 0) {
					 bpart2 = new MBPartner( getCtx() ,0,null);
					 bpart2.setName(getTitular_Poliza());
					 bpart2.setValue(getCed_titular());
					 bpart2.setIsCustomer(true);
					 bpart2.setC_BP_Group_ID(1000003);   //Grupo de Pacientes .... crear y buscar id
					 bpart2.save();
					 //Direccion del nuevo sdn
					 bploc2 = new MBPartnerLocation(getCtx(),0,null);
					 bploc2.setC_BPartner_ID(bpart2.getC_BPartner_ID());
					 bploc2.setC_Location_ID(getC_Location_ID());
					 bploc2.save();
					 
				}
				DB.executeUpdate("UPDATE C_BPartner set isfresponsible='Y' where VALUE='"+getCed_titular()+"'",null);
			}
				
			
		}
			
		
		bploc = new MBPartnerLocation(getCtx(),0,null);
		bploc.setC_BPartner_ID(bpart.getC_BPartner_ID());
		bploc.setC_Location_ID(getC_Location_ID());
		bploc.save();
	}
	//coloca la cama/camilla como ocupada
	boolean oc = ocupa_bed();
	
		
	//if (newRecord && success)
			//Grabo paciente como sdn y como cliente
		return success;
	}	//	afterSave
	/*
	 * 
	 * Ocupa_bed : Coloca como ocupada la cama del paciente.
	 */
	public boolean ocupa_bed(){
		MHBed cama = new MHBed(getCtx(), getH_Bed_ID(), null );
		cama.setIsOccupied(true);
		cama.save();
		return true;
	}
	
}
