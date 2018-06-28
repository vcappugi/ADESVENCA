package org.pentanet.process;

import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.model.MProduct;
import org.compiere.model.MRfQ;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQLineQty;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.process.RfQCreate;


public class CreateRFQFromRequest extends SvrProcess {

	private int M_Requisition_ID_P;
	private int C_RFQ_Topic_ID_P;
	
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("M_Requisition_ID"))
				M_Requisition_ID_P =  para[i].getParameterAsInt();
			else if (name.equals("C_RFQ_Topic_ID"))
				C_RFQ_Topic_ID_P=  para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	/*
	 * Crear RFQ desde requisicion, debe haberse establecido primero un
	 * tema para la solicitud de cotizacion
	 */
	@Override
	protected String doIt() throws Exception {
		//seek MREQUISITION
		MRequisition mreq = new MRequisition(getCtx(),M_Requisition_ID_P, get_TrxName());
		
		//Create MRFQ 
		MRfQ rfq = new MRfQ(getCtx(),0,get_TrxName());
		
		rfq.setC_RfQ_Topic_ID(C_RFQ_Topic_ID_P);
		rfq.setName("Proceso de procura de relacionado a Requisición:" + mreq.getDocumentNo());
		rfq.setAD_Org_ID(mreq.getAD_Org_ID());
		rfq.setC_Currency_ID(mreq.getC_Currency_ID());
		rfq.setQuoteType("A");
		rfq.setM_Requisition_ID(mreq.getM_Requisition_ID());
		
		rfq.save();
		
		//Create Lines RFQ
		MRequisitionLine[] mreql = mreq.getLines();
		for (int i = 0; i < mreql.length; i++)
		{
			MProduct prod = new MProduct(getCtx(),mreql[i].getM_Product_ID(),get_TrxName());
			MRfQLine mrfql = new MRfQLine(getCtx(),0,get_TrxName());
			mrfql.setC_RfQ_ID(rfq.getC_RfQ_ID());
			mrfql.setM_Product_ID(prod.getM_Product_ID());
			mrfql.setAD_Org_ID(rfq.getAD_Org_ID());
			mrfql.setDescription(mreql[i].getDescription());
			mrfql.setM_RequisitionLine_ID(mreql[i].getM_RequisitionLine_ID());
			mrfql.save();
			MRfQLineQty mrfqlq = new MRfQLineQty(getCtx(),0,get_TrxName());
			mrfqlq.setC_RfQLine_ID(mrfql.getC_RfQLine_ID());
			mrfqlq.setAD_Org_ID(mrfql.getAD_Org_ID());
			mrfqlq.setQty(mreql[i].getQty());
            mrfqlq.setC_UOM_ID(prod.getC_UOM_ID());
            mrfqlq.setIsPurchaseQty(true);
			mrfqlq.save();
			
		}	
		
		return "Creado Nro" + rfq.getDocumentNo();
	}

}
