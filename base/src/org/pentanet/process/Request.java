package org.pentanet.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;

import org.compiere.model.MProductPrice;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereSystemError;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.util.ValueNamePair;
import org.pentanet.model.MHATreatment;

public class Request extends SvrProcess {

	private int M_Product;
	private BigDecimal qty;
	private int uom;
	private int Request;
	
	@Override
	protected void prepare() {
		Request = getRecord_ID();
		

	}

	@Override
	protected String doIt() throws Exception {
		DB.executeUpdate("UPDATE H_Request SET DocStatus='IP', DocAction='CO', Processed='Y' WHERE H_Request_ID="+Request, getCtx().toString());
		return "Solicitud en Proceso";
		
	}

}
