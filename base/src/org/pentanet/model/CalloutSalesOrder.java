package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.apps.ADialog;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutSalesOrder extends CalloutEngine {
	/*
	 * Callout para la creacion de facturas desde la orden de venta
	 * divide la factura de acuerdo a los responsables financieros 
	 * contenidos en el documento de admision.
	 */
	
	public String Create_Invoice (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		//int Admision_id = mTab.getValue("H_Admission_ID");
		
		int i=0, j=0;
		int C_Order_ID=Env.getContextAsInt(ctx, WindowNo, "C_Order_ID");
		int H_Admission_ID=Env.getContextAsInt(ctx, WindowNo, "H_Admission_ID");
		//int M_PriceList_ID=Env.getContextAsInt(ctx, WindowNo, "M_PriceList_ID");
		BigDecimal Disp= new BigDecimal(0);
		BigDecimal Qty=new BigDecimal(0);
		BigDecimal GrandTotal=new BigDecimal(0);
		
		MOrderLine OrderLine[]=listaOL(ctx, C_Order_ID);
		MHResponsibleF Resp[]=listaRF(ctx, H_Admission_ID);
		MInvoice Invoice[]=new MInvoice[Resp.length];
		MInvoiceLine InLine[]=new MInvoiceLine[OrderLine.length];
		//MBPartner BPart;
		String products="";
		int cantResp=Resp.length;
		
		for (i=0; i<cantResp; i++){
			//BPart=new MBPartner(ctx, Resp[i].getC_BPartner_ID(),null);
			
			Invoice[i]=new MInvoice(ctx,0,null);
			Invoice[i].setC_DocType_ID(1000002);
			Invoice[i].setC_BPartner_ID(Resp[i].getC_BPartner_ID());
			//Invoice[i].setC_BPartner_Location_ID(getLocationofBP(ctx,Resp[i].getC_BPartner_ID()));
			//Invoice[i].setM_PriceList_ID(M_PriceList_ID);
			//Invoice[i].setC_PaymentTerm_ID(BPart.getC_PaymentTerm_ID());
			Invoice[i].setSalesRep_ID(1000000);
			Invoice[i].save();
			
			for (j=0; j<OrderLine.length; j++){
				if (OrderLine[j].getQtyEntered().compareTo(Env.ONE)!=-1){
					InLine[j]=new MInvoiceLine(ctx,0,null);
					InLine[j].setC_Invoice_ID(Invoice[i].getC_Invoice_ID());
					InLine[j].setLine(OrderLine[j].getLine());
					InLine[j].setM_Product_ID(OrderLine[j].getM_Product_ID());
					InLine[j].setQty(1);
					InLine[j].setPriceList(OrderLine[j].getPriceList());
					InLine[j].setC_UOM_ID(OrderLine[j].getC_UOM_ID());
					InLine[j].setC_Tax_ID(OrderLine[j].getC_Tax_ID());
					InLine[j].save();
					OrderLine[j].setQty(OrderLine[j].getQtyEntered().subtract(InLine[j].getQtyEntered()));
				}				
			}
			GrandTotal=Invoice[i].getGrandTotal();
			
			for (j=0; j<OrderLine.length; j++){
				GrandTotal=DB.getSQLValueBD(null, "SELECT GrandTotal FROM C_Invoice WHERE C_Invoice_ID="+Invoice[i].getC_Invoice_ID());
				
				if (GrandTotal.compareTo(Resp[i].getCoverage())==-1 && OrderLine[j].getQtyEntered().compareTo(Env.ZERO)!=0){
					if (InLine[j].getPriceList().compareTo(Env.ZERO)==0){
						MProduct Product=new MProduct(ctx,InLine[j].getM_Product_ID(),null);
						ADialog.error(WindowNo, null, "El Producto \""+Product.getName()+"\" de la línea "+InLine[j].getLine()+" no tiene precio en la Orden de Venta");
					}
					else {
						Disp=Resp[i].getCoverage().subtract(GrandTotal);
						Qty=Disp.divide(InLine[j].getLineTotalAmt(), BigDecimal.ROUND_FLOOR);
						Qty=Qty.setScale(0, BigDecimal.ROUND_FLOOR);
												
						if (Qty.compareTo(OrderLine[j].getQtyEntered().subtract( new BigDecimal(cantResp-(i+1))))==1)
							Qty=OrderLine[j].getQtyEntered().subtract( new BigDecimal(cantResp-(i+1)));
						
						InLine[j].setQty(Qty.add(InLine[j].getQtyEntered()));
						InLine[j].save();
						OrderLine[j].setQty(OrderLine[j].getQtyEntered().subtract(Qty));						
					}
				}								
			}
		}
		
		for (j=0; j<OrderLine.length; j++){
			if (OrderLine[j].getQtyEntered().compareTo(Env.ZERO)==1){
				MProduct Prod =new MProduct(ctx,OrderLine[j].getM_Product_ID(),null);
				products=products+Prod.getName()+" Cantidad: "+OrderLine[j].getQtyEntered()+
						 " Monto: "+OrderLine[j].getPriceEntered().multiply(OrderLine[j].getQtyEntered()).setScale(4, BigDecimal.ROUND_UP)+"\n";
			}				
		}
		ADialog.error(WindowNo, null, "Los siguiente productos no pudieron ser incluidos en las facturas\n\n"+products);
		
		return "Ok";
		
	}
	
	private MHResponsibleF[] listaRF(Properties ctx, int admision){
        int cantRF = DB.getSQLValue(null, "SELECT COUNT(H_ResponsibleF_ID) FROM H_Responsiblef WHERE H_Admission_ID="+admision);
        MHResponsibleF rf[];
        int i=0;
        rf = new MHResponsibleF[cantRF];
        ////
        String SQL_Prod_B ="SELECT H_ResponsibleF_ID FROM H_ResponsibleF WHERE H_Admission_ID= "+ admision+ " ORDER BY Coverage Desc";
        
        ResultSet rs = null;
        try
        {
            PreparedStatement pstmt1 = DB.prepareStatement (SQL_Prod_B, "H_ResponsibleF");
            rs = pstmt1.executeQuery();
            while (rs.next())
            {
                rf[i] = new MHResponsibleF(ctx ,rs.getInt(1), null);
                i++;
            }
        }
        catch(Exception e){
            return null;
        }
        return rf;
    }
    
    private MOrderLine[] listaOL(Properties ctx, int Order){
        int cantOl = DB.getSQLValue(null, "SELECT COUNT(C_OrderLine_ID) FROM C_OrderLine WHERE C_Order_ID="+Order);
        MOrderLine ol[];
        int i=0;
        ol = new MOrderLine[cantOl];
        ////
        String SQL_Prod_B ="SELECT C_OrderLine_ID FROM C_OrderLine WHERE C_Order_ID= "+ Order+" ORDER BY PriceEntered Desc";
        
        ResultSet rs = null;
        try
        {
            PreparedStatement pstmt1 = DB.prepareStatement (SQL_Prod_B, "C_OrderLine");
            rs = pstmt1.executeQuery();
            while (rs.next())
            {
                ol[i] = new MOrderLine(ctx ,rs.getInt(1), null);
                i++;
            }
        }
        catch(Exception e){
            return null;
        }
        return ol;
    }
    
    private int getLocationofBP (Properties ctx, int C_BPartner_ID){
        int idLocat = DB.getSQLValue(ctx.toString(), "SELECT C_BPartner_Location_ID FROM C_BPartner_Location WHERE C_BPartner_ID="+C_BPartner_ID);
        return idLocat;
    }
}
