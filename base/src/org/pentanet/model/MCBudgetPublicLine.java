package org.pentanet.model;

import java.util.Properties;

public class MCBudgetPublicLine extends X_C_BudgetPublic_Line {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	public MCBudgetPublicLine(Properties ctx, int C_BudgetPublic_Line_ID, String trxName)
	{
		super (ctx, C_BudgetPublic_Line_ID, trxName);
	}
	protected boolean beforeSave (boolean newRecord)
	{
		
		return true;
		
	}
	
	/*
	 * recalcular el saldo de la linea de presupuesto
	 * o la partida
	 */
	public void recalculate(){
		setRealAmount(getAmount().add(getAmountModify()).subtract(getAmtCau().add(getAmtComp().add(getAmtPay()))));
		return;
	}
	
}
