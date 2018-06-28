package org.pentanet.process;

import java.util.List;

import org.compiere.model.MMailText;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.eevolution.model.MHRConcept;


public class VacationServer extends SvrProcess{

	public List<MMailText> listMailT;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	protected String doIt() throws Exception {
		
		String whereClause = " R_MailText.IsServer = 'Y' ";
		
		listMailT = new Query(getCtx(), MMailText.Table_Name, whereClause.toString(), get_TrxName())
		.setOnlyActiveRecords(true)
		.setOrderBy(MMailText.COLUMNNAME_R_MailText_ID)
		.list();
		
		NewEmail correo = new NewEmail();
		
		for(MMailText mt : listMailT)
		{
			//sendEmail(int R_MailText_ID)
			correo.sendEmail(mt.getR_MailText_ID());
		}
		
		return "Done";
	}

}
