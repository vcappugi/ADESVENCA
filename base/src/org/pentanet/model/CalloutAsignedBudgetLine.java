package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPricing;
import org.compiere.model.MRole;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.compiere.model.MUOMConversion;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutAsignedBudgetLine extends CalloutEngine{

	public String product (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		Integer M_Product_ID = (Integer)value;
		
		if (M_Product_ID == null || M_Product_ID.intValue() == 0){
			mTab.setValue("Name", "");
			mTab.setValue("Description", "");			
			mTab.setValue("C_UOM_ID", 0);		
			mTab.setValue("LineAmt", "");
			mTab.setValue("Qty", 1);
			mTab.setValue("QtyBudgeted", 1);
			mTab.setValue("PriceList", 0);
			mTab.setValue("PriceActual", 0);
			mTab.setValue("PriceEntered", 0);
			mTab.setValue("LineNetAmt", 0);
			mTab.setValue("LineTotalAmt", 0);
			return "";
		}
		
		String sql="SELECT M_Product_ID ISNULL FROM H_Asigned_Budget_Line WHERE H_Asigned_Budget_ID="+Env.getContext(ctx, WindowNo, "H_Asigned_Budget_ID")+" AND M_Product_ID="+M_Product_ID;
		String EqualProduct=DB.getSQLValueString(null, sql);
		
		if("f".equals(DB.getSQLValueString(null, sql))) {
			mTab.dataIgnore();			
			return "El Producto ya existe";
		}			
		
		String ID_Admision = Env.getContext(ctx, WindowNo, "H_Admission_ID");
		MHAdmission Admision = new MHAdmission (ctx,Integer.parseInt(ID_Admision), null);
		
		MProduct Product =new MProduct(ctx, M_Product_ID,null);
		BigDecimal PriceList = new BigDecimal(DB.getSQLValue(null, "SELECT  pricelist FROM M_ProductPrice WHERE M_PriceList_Version_ID="+Admision.getM_PriceList_Version_ID()+" AND M_Product_ID="+M_Product_ID));
				
		mTab.setValue("Name", Product.getName());
		mTab.setValue("Description", Product.getDescription());
		mTab.setValue("C_UOM_ID", Product.getC_UOM_ID());		
		mTab.setValue("LineAmt", mTab.getValue("Qty"));
		mTab.setValue("QtyBudgeted", mTab.getValue("Qty"));		
		mTab.setValue("PriceList", PriceList);
		mTab.setValue("PriceActual", PriceList);
		mTab.setValue("PriceEntered", PriceList);
		mTab.setValue("LineNetAmt", PriceList.multiply((BigDecimal)mTab.getValue("Qty")));
		mTab.setValue("LineTotalAmt", mTab.getValue("LineNetAmt"));
		
		return "";
	}
	
	public String qty (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive() || value == null)
			return "";

		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, "M_Product_ID");	
		BigDecimal QtyBudgeted, Qty, PriceActual, PriceEntered;
		
		//	No Product
		if (M_Product_ID == 0)
		{
			Qty = (BigDecimal)mTab.getValue("Qty");
			mTab.setValue("QtyBudgeted", Qty);
		}
		//	UOM Changed - convert from Entered -> Product
		else if (mField.getColumnName().equals("C_UOM_ID"))
		{
			int C_UOM_To_ID = ((Integer)value).intValue();
			Qty = (BigDecimal)mTab.getValue("Qty");
			BigDecimal Qty1 = Qty.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), BigDecimal.ROUND_HALF_UP);
			if (Qty.compareTo(Qty1) != 0)
			{
				log.fine("Corrected Qty Scale UOM=" + C_UOM_To_ID 
					+ "; Qty=" + Qty + "->" + Qty1);  
				Qty = Qty1;
				mTab.setValue("Qty", Qty);
			}
			QtyBudgeted = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
				C_UOM_To_ID, Qty);
			if (QtyBudgeted == null)
				QtyBudgeted = Qty;
			boolean conversion = Qty.compareTo(QtyBudgeted) != 0;
			PriceActual = (BigDecimal)mTab.getValue("PriceActual");
			PriceEntered = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
				C_UOM_To_ID, PriceActual);
			if (PriceEntered == null)
				PriceEntered = PriceActual; 
			log.fine("qty - UOM=" + C_UOM_To_ID 
				+ ", Qty/PriceActual=" + Qty + "/" + PriceActual
				+ " -> " + conversion 
				+ " QtyBudgeted/PriceEntered=" + QtyBudgeted + "/" + PriceEntered);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("QtyBudgeted", QtyBudgeted);
			mTab.setValue("PriceEntered", PriceEntered);
		}
		//	QtyEntered changed - calculate QtyInvoiced
		else if (mField.getColumnName().equals("Qty"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
			Qty = (BigDecimal)value;
			BigDecimal Qty1 = Qty.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), BigDecimal.ROUND_HALF_UP);
			if (Qty.compareTo(Qty1) != 0)
			{
				log.fine("Corrected Qty Scale UOM=" + C_UOM_To_ID 
					+ "; Qty=" + Qty + "->" + Qty1);  
				Qty = Qty1;
				mTab.setValue("Qty", Qty);
			}
			QtyBudgeted = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
				C_UOM_To_ID, Qty);
			if (QtyBudgeted == null)
				QtyBudgeted = Qty;
			boolean conversion = Qty.compareTo(Qty) != 0;
			log.fine("qty - UOM=" + C_UOM_To_ID 
				+ ", Qty=" + Qty
				+ " -> " + conversion 
				+ " QtyBudgeted=" + QtyBudgeted);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("QtyBudgeted", QtyBudgeted);
		}
		//	QtyInvoiced changed - calculate QtyEntered (should not happen)
		else if (mField.getColumnName().equals("QtyBudgeted"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
			QtyBudgeted = (BigDecimal)value;
			int precision = MProduct.get(ctx, M_Product_ID).getUOMPrecision(); 
			BigDecimal QtyBudgeted1 = QtyBudgeted.setScale(precision, BigDecimal.ROUND_HALF_UP);
			if (QtyBudgeted.compareTo(QtyBudgeted1) != 0)
			{
				log.fine("Corrected QtyBudgeted Scale "
					+ QtyBudgeted + "->" + QtyBudgeted1);  
				QtyBudgeted = QtyBudgeted1;
				mTab.setValue("QtyBudgeted", QtyBudgeted);
			}
			Qty = MUOMConversion.convertProductTo (ctx, M_Product_ID, 
				C_UOM_To_ID, QtyBudgeted);
			if (Qty == null)
				Qty = QtyBudgeted;
			boolean conversion = QtyBudgeted.compareTo(Qty) != 0;
			log.fine("qty - UOM=" + C_UOM_To_ID 
				+ ", QtyBudgeted=" + Qty
				+ " -> " + conversion 
				+ " Qty=" + Qty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue("Qty", Qty);
		}
		//
		return "";
	}	//	qty
	
	
	public String amt (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if (isCalloutActive() || value == null)
			return "";

		MHAsignedBudget ABudget=new  MHAsignedBudget(ctx,Env.getContextAsInt(ctx, WindowNo, "H_Asigned_Budget_ID"),null);
		MHAdmission Admission=new MHAdmission(ctx,ABudget.getH_Admission_ID(),null);
		MPriceListVersion PLVersion=new MPriceListVersion(ctx,Admission.getM_PriceList_Version_ID(),null);
		
		
		int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, "C_UOM_ID");
		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, "M_Product_ID");
		int M_PriceList_ID = PLVersion.getM_PriceList_ID();//Env.getContextAsInt(ctx, WindowNo, "M_PriceList_ID");
		int StdPrecision = MPriceList.getStandardPrecision(ctx, M_PriceList_ID);
		BigDecimal Qty, QtyBudgeted, PriceEntered, PriceActual, PriceList;//, PriceLimit, Discount
		//	get values
		Qty = (BigDecimal)mTab.getValue("Qty");
		QtyBudgeted = (BigDecimal)mTab.getValue("QtyBudgeted");
		log.fine("Qty=" + Qty + ", Budgeted=" + QtyBudgeted + ", UOM=" + C_UOM_To_ID);
		//
		PriceEntered = (BigDecimal)mTab.getValue("PriceEntered");
		PriceActual = (BigDecimal)mTab.getValue("PriceActual");

		//PriceLimit = (BigDecimal)mTab.getValue("PriceLimit");
		PriceList = (BigDecimal)mTab.getValue("PriceList");
		log.fine("PriceList=" + PriceList + ", Precision=" + StdPrecision);
		log.fine("PriceEntered=" + PriceEntered + ", Actual=" + PriceActual);// + ", Discount=" + Discount);

		//		No Product
		if ( M_Product_ID == 0 )
		{
			// if price change sync price actual and entered
			// else ignore
			if (mField.getColumnName().equals("PriceActual"))
			{
				PriceEntered = (BigDecimal) value;
				mTab.setValue("PriceEntered", value);
			}
			else if (mField.getColumnName().equals("PriceEntered"))
			{
				PriceActual = (BigDecimal) value;
				mTab.setValue("PriceActual", value);
			}
		}
		//	Product Qty changed - recalc price
		else if ((mField.getColumnName().equals("QtyBudgeted") 
			|| mField.getColumnName().equals("Qty")
			|| mField.getColumnName().equals("C_UOM_ID")
			|| mField.getColumnName().equals("M_Product_ID")))
		{
					
			if (mField.getColumnName().equals("Qty"))
				QtyBudgeted = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
					C_UOM_To_ID, Qty);
			if (QtyBudgeted == null)
				QtyBudgeted = Qty;
			
			PriceList = new BigDecimal(DB.getSQLValue(null, "SELECT  pricelist FROM M_ProductPrice WHERE M_PriceList_Version_ID="+Admission.getM_PriceList_Version_ID()+" AND M_Product_ID="+M_Product_ID));
						
			//
			PriceEntered = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
				C_UOM_To_ID, PriceList);
			if (PriceEntered == null)
				PriceEntered = PriceList;
			//
			log.fine("amt - QtyChanged -> PriceActual=" + PriceList 
				+ ", PriceEntered=" + PriceEntered);
			
			PriceActual = PriceList;
			mTab.setValue("PriceActual", PriceList);
		
			mTab.setValue("PriceEntered", PriceEntered);
			
		}
		else if (mField.getColumnName().equals("PriceActual"))
		{
			PriceActual = (BigDecimal)value;
			PriceEntered = MUOMConversion.convertProductFrom (ctx, M_Product_ID, 
				C_UOM_To_ID, PriceActual);
			if (PriceEntered == null)
				PriceEntered = PriceActual;
			//
			log.fine("amt - PriceActual=" + PriceActual 
				+ " -> PriceEntered=" + PriceEntered);
			mTab.setValue("PriceEntered", PriceEntered);
		}
		else if (mField.getColumnName().equals("PriceEntered"))
		{
			PriceEntered = (BigDecimal)value;
			PriceActual = MUOMConversion.convertProductTo (ctx, M_Product_ID, 
				C_UOM_To_ID, PriceEntered);
			if (PriceActual == null)
				PriceActual = PriceEntered;
			//
			log.fine("amt - PriceEntered=" + PriceEntered 
				+ " -> PriceActual=" + PriceActual);
			mTab.setValue("PriceActual", PriceActual);
		}
		
		
		//	Line Net Amt
		BigDecimal LineNetAmt = QtyBudgeted.multiply(PriceActual);
		if (LineNetAmt.scale() > StdPrecision)
			LineNetAmt = LineNetAmt.setScale(StdPrecision, BigDecimal.ROUND_HALF_UP);
		log.info("amt = LineNetAmt=" + LineNetAmt);
		mTab.setValue("LineNetAmt", LineNetAmt);

				
			BigDecimal TaxAmt = Env.ZERO; // teo_sarca: [ 1656829 ] Problem when there is not tax selected in vendor invoice
			
			mTab.setValue("LineTotalAmt", LineNetAmt.add(TaxAmt));		

		return "";
	}	//	amt
	
}
