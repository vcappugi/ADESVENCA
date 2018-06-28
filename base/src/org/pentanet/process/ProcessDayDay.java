package org.pentanet.process;


import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.tomcat.util.buf.TimeStamp;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.apps.ADialog;
import org.pentanet.model.*;


public class ProcessDayDay extends SvrProcess {

	private BigDecimal cgrandTotal_pure = new BigDecimal(0);
	private BigDecimal cgrandTotal_usd = new BigDecimal(0);
	private BigDecimal cgrandTotal = new BigDecimal(0);
	
	private BigDecimal mgrandTotal_pure = new BigDecimal(0);
	private BigDecimal mgrandTotal_usd = new BigDecimal(0);
	private BigDecimal mgrandTotal = new BigDecimal(0);
	
    private MCWorkDD wddc = null;
    private MCWorkDD wddm = null;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
	} //prepare

	@Override
	protected String doIt() throws Exception {
		
			String msg = GenerateContract();
			return msg;

	}//doIt
	
	@SuppressWarnings("deprecation")
	private String GenerateContract() throws SQLException{
		
		//Verifica la diferencia entre las partidas global y partidas de Historico
		String sql = "SELECT now()::timestamp, C_ContractLine_ID, C_Phase_ID, C_Charge_ID, qty_dif, qty_hist, price_pure, " 
				  + " price_usd, price, percent, type_cont, regist, real_cont, cworkddgline, qty_pend, qty_equip,isworkinghours,qtyhoursforday,hours " +
			      " FROM generate_workdd(" + getRecord_ID() + ") ";

		//Verificar si ya se genero el documento
		//int generado = DB.getSQLValue(null, "SELECT COUNT(*) FROM C_WorkDD WHERE dateshort(StartDate) = dateshort(now())");
		
		String Mensaje = "Documento de Día a Día: ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//if(generado==0){

		    MCWorkDDG glob = new  MCWorkDDG(getCtx(), getRecord_ID(), null);
		    
		    
		    
		    int a = 0;
		    int b = 0;
		    String sql_day_day = "select count(*) from c_workdd where c_workddg_id = "+getRecord_ID()+" AND (startdate BETWEEN '"+glob.getStartDate()+"' AND '"+glob.getEndDate()+"' OR enddate BETWEEN '"+glob.getStartDate()+"' AND '"+glob.getEndDate()+"')";
		    //ADialog.info(0,null,sql_day_day);
		    if(DB.getSQLValue(null, sql_day_day) == 0)
	    	{
		    	pstmt = DB.prepareStatement (sql, null);
			    rs = pstmt.executeQuery ();
			    while (rs.next ())
			    {
			    		listSet ls = new listSet(rs.getTimestamp(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getBigDecimal(5),
			    				rs.getBigDecimal(6), rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getBigDecimal(9), rs.getBigDecimal(10), 
			    				rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14), rs.getBigDecimal(15), rs.getBigDecimal(16), rs.getString(17), rs.getBigDecimal(18), rs.getBigDecimal(19));
			    		
				    	//Crea los registros para las partidas Calculadas
				    	if(rs.getString(11).equals("CAL")){
				    		
				    		a++;
				    		GenerateCalculated(ls, glob, a);
				    		
			    		}else{//Crea los registros para las partidas de volumen y/o consumo
			    			
			    			b++;
				    		GenerateMix(ls, glob, b);
				    		
			    		}
				    	
				    	//Update Contract Qty Preinvoiced
				    	BigDecimal qty = ls.getQty_equip().signum() == 0 ? ls.getQty_hist() : ls.getQty_hist().multiply(ls.getQty_equip());
				    	
						X_C_ContractLine contLine = new X_C_ContractLine(Env.getCtx(), ls.getContractLine(), get_TrxName());
						contLine.setQtyPreinvoiced(contLine.getQtyPreinvoiced().subtract(qty));
						contLine.save();
				    	
			    	
				    }//while

			    boolean exist;
			    //Para Partidas Calculadas (CT,CS)
				if(a==0){
					//Mensaje = "No existen Día a Día para la Fecha";
				}else{
					wddc.setGrandTotal(cgrandTotal);
					wddc.setGrandTotal_Pure(cgrandTotal_pure);
					wddc.setGrandTotal_Usd(cgrandTotal_usd);
					wddc.processIt("CO");
					wddc.save();
				}
				
			    //Para Partidas Calculadas (F)
				if(b==0){
					//Mensaje = "No existen Día a Día para la Fecha";
				}else{
					wddm.setGrandTotal(cgrandTotal);
					wddm.setGrandTotal_Pure(cgrandTotal_pure);
					wddm.setGrandTotal_Usd(cgrandTotal_usd);
					wddm.save();
				}
				
				
			//}else{
			///   Mensaje = "Ya existe documento generado para esta Fecha";
			//}
				
				
				/*
				 * todos las cantidades ingresadas, las restablece a 0
				 */
				
				if((a+b) != 0)
				{

					DB.executeUpdate("UPDATE c_workddgline SET qty = 0,linenetamt = 0,linenetamt_pure = 0,linenetamt_usd = 0 WHERE c_workddg_id = "+getRecord_ID());
				
					
					glob.setHelp("");
					/*
					glob.setGrandTotal(new BigDecimal(0));
					glob.setGrandTotal_Pure(new BigDecimal(0));
					glob.setGrandTotal_Usd(new BigDecimal(0));*/
					glob.save();
					
				}
				
	    	}
		    
		
		return Mensaje=(a + b != 0)? Mensaje : "Ya fue Generado el Día a Día para la Fecha";
	}
	
	private String GenerateCalculated(listSet ls, MCWorkDDG glob, int a) throws SQLException{
			
			String Mensaje = "Documento de Día a Día: ";
			
			if(a==1){
				//Crear Cabecera
				wddc = new MCWorkDD(getCtx(), 0, get_TrxName());
		
				wddc.setC_WorkDDG_ID(glob.getC_WorkDDG_ID());
				wddc.setDescription(glob.getDescription());
				wddc.setHelp(glob.getHelp());
				wddc.setC_DocType_ID(1000098); //WorkDD
				wddc.setAD_Org_ID(glob.getAD_Org_ID());
				wddc.setC_Activity_ID(glob.getC_Activity_ID());
				wddc.setC_Currency_ID(glob.getC_Currency_ID());
				wddc.setC_Municipality_ID(glob.getC_Municipality_ID());
				wddc.setC_Contract_ID(glob.getC_Contract_ID());
				wddc.setDateAcct(ls.getDocdate());
				wddc.setDateDoc(ls.getDocdate());
				wddc.setStartDate(glob.getStartDate());//antes era ls.getDocdate()
				wddc.setEndDate(glob.getEndDate());//antes era ls.getDocdate()
				wddc.save();
			}

			BigDecimal percent = ls.getPercent().signum() == 0 ? new BigDecimal(1) : ls.getPercent();
			BigDecimal qty = ls.getQty_equip().signum() == 0 ? ls.getQty_hist() : percent.multiply(ls.getQty_hist().multiply(ls.getQty_equip()));// antes estaba por la diferencia y sin el porcentaje
			BigDecimal price_pure = ls.getPrice_pure();
			BigDecimal price_usd = ls.getPrice_usd();
			BigDecimal price = ls.getPrice();
			
			Boolean isWorkingHours = ls.getIsworkinghours();
			BigDecimal hoursForDay = ls.getQtyhoursforday();
			BigDecimal hours = ls.hours;
		
			//Crear línea
			MCWorkDDLine wddl = new MCWorkDDLine(getCtx(),0,get_TrxName());
			wddl.setAD_Org_ID(glob.getAD_Org_ID());
			wddl.setC_WorkDD_ID(wddc.getC_WorkDD_ID());
			wddl.setC_ContractLine_ID(ls.getContractLine());
			wddl.setC_Phase_ID(ls.getPhase());
			wddl.setC_Charge_ID(ls.getCharge());
			wddl.setProcessed(true);
			wddl.setQty(qty);
			wddl.setQtyEquipment(ls.getQty_equip());
			wddl.setPrice(price);
			wddl.setPrice_Usd(price_usd);
			wddl.setC_UOM_ID(DB.getSQLValue(null, "SELECT C_UOM_ID FROM C_ContractLine WHERE C_ContractLine_ID="+ls.getContractLine()));
			wddl.setPrice_Pure(price_pure);
			wddl.setLineNetAmt(price.multiply(qty).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setLineNetAmt_Usd(price_usd.multiply(qty).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setLineNetAmt_Pure(price_pure.multiply(qty).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setIsWorkingHours(isWorkingHours);//para transformar horas a dias
			wddl.setQtyHoursForDay(hoursForDay);//para transformar horas a dias
			wddl.setHours(hours);//para transformar horas a dias
			
			

			wddl.save();
		
			cgrandTotal = cgrandTotal.add(wddl.getLineNetAmt());
			cgrandTotal_usd = cgrandTotal_usd.add(wddl.getLineNetAmt_Usd());
			cgrandTotal_pure = cgrandTotal_pure.add(wddl.getLineNetAmt_Pure());        
		
		return Mensaje;
	}
	

	private String GenerateMix(listSet ls, MCWorkDDG glob, int a) throws SQLException{
			
			String Mensaje = "Documento de Día a Día: ";
			
			if(a==1){
				
				//Crear Cabecera
				wddm = new MCWorkDD(getCtx(), 0, get_TrxName());
				wddm.setC_WorkDDG_ID(glob.getC_WorkDDG_ID());
				wddm.setDescription(glob.getDescription());
				wddm.setHelp(glob.getHelp());
				wddm.setC_DocType_ID(1000098); //WorkDD
				wddm.setAD_Org_ID(glob.getAD_Org_ID());
				wddm.setC_Activity_ID(glob.getC_Activity_ID());
				wddm.setC_Currency_ID(glob.getC_Currency_ID());
				wddm.setC_Municipality_ID(glob.getC_Municipality_ID());
				wddm.setC_Contract_ID(glob.getC_Contract_ID());
				wddm.setDateAcct(ls.getDocdate());
				wddm.setDateDoc(ls.getDocdate());
				wddm.setStartDate(glob.getStartDate());// antes era ls.getDocdate()
				wddm.setEndDate(glob.getEndDate());// antes era ls.getDocdate()
				wddm.save();
				
			}
		
			BigDecimal qty = ls.getQty_equip().signum() == 0 ? ls.getQty_hist() : ls.getQty_hist().multiply(ls.getQty_equip()); // antes estaba por la diferencia
			BigDecimal qty_h = ls.getQty_hist();
			BigDecimal qty_p = ls.getQty_equip().signum() == 0 ? ls.getQty_pend() : ls.getQty_pend().multiply(ls.getQty_equip());
			BigDecimal price_pure = ls.getPrice_pure();
			BigDecimal price_usd = ls.getPrice_usd();
			BigDecimal price = ls.getPrice();
			BigDecimal percent = ls.getPercent().signum() == 0 ? new BigDecimal(1) : ls.getPercent().divide(new BigDecimal(100));
		
			Boolean isWorkingHours = ls.getIsworkinghours();
			BigDecimal hoursForDay = ls.getQtyhoursforday();
			BigDecimal hours = ls.getHours();
			
			//Crear línea
			MCWorkDDLine wddl = new MCWorkDDLine(getCtx(),0,get_TrxName());
			wddl.setAD_Org_ID(glob.getAD_Org_ID());
			wddl.setC_WorkDD_ID(wddm.getC_WorkDD_ID());
			wddl.setC_ContractLine_ID(ls.getContractLine());
			wddl.setC_Phase_ID(ls.getPhase());
			wddl.setC_Charge_ID(ls.getCharge());
			wddl.setQty(qty);
			wddl.setQtyEquipment(ls.getQty_equip());
			wddl.setPrice(price);
			wddl.setPrice_Usd(price_usd);
			wddl.setPrice_Pure(price_pure);
			wddl.setC_UOM_ID(DB.getSQLValue(null, "SELECT C_UOM_ID FROM C_ContractLine WHERE C_ContractLine_ID="+ls.getContractLine()));
			wddl.setLineNetAmt(price.multiply(qty).multiply(percent).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setLineNetAmt_Usd(price_usd.multiply(qty).multiply(percent).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setLineNetAmt_Pure(price_pure.multiply(qty).multiply(percent).setScale(3, BigDecimal.ROUND_HALF_UP));
			wddl.setIsWorkingHours(isWorkingHours);//para transformar horas a dias
			wddl.setQtyHoursForDay(hoursForDay);//para transformar horas a dias
			wddl.setHours(hours);//para transformar horas a dias
			wddl.save();
		
			mgrandTotal = mgrandTotal.add(wddl.getLineNetAmt());
			mgrandTotal_usd = mgrandTotal_usd.add(wddl.getLineNetAmt_Usd());
			mgrandTotal_pure = mgrandTotal_pure.add(wddl.getLineNetAmt_Pure()); 
			
			//Para Registros Globales
			if(ls.getRegist().equals("Y")){
				
				//Actualizar línea
				MCWorkDDGLine wgl = new MCWorkDDGLine(getCtx(),ls.getCworkddgline(),get_TrxName());
				wgl.setQty(qty_h);
				wgl.setQtyPending(qty_p);
				wgl.setLineNetAmt(price.multiply(qty_p).multiply(percent));
				wgl.setC_UOM_ID(DB.getSQLValue(null, "SELECT C_UOM_ID FROM C_ContractLine WHERE C_ContractLine_ID="+ls.getContractLine()));
				wgl.setLineNetAmt_Usd(price_usd.multiply(qty_p).multiply(percent));
				wgl.setLineNetAmt_Pure(price_pure.multiply(qty_p).multiply(percent));
				wgl.save();
				
			}else{
				
				if(ls.getReal_cont().equals("CON")){
					//Crea nueva partida en la global
			        MCWorkDDGLine wgl = new MCWorkDDGLine(getCtx(),ls.getCworkddgline(),get_TrxName());
			        wgl.setAD_Org_ID(glob.getAD_Org_ID());
			        wgl.setC_WorkDDG_ID(glob.getC_WorkDDG_ID());
			        wgl.setC_Phase_ID(ls.getPhase());
			        wgl.setIsVar(false);
			        wgl.setIsCalculated(false);
			        wgl.setIsAutomaticGenerated(true);
			        wgl.setC_ContractLine_ID(ls.getContractLine());
			        wgl.setC_Charge_ID(ls.getCharge());
			        wgl.setQty(qty_h);
			        wgl.setC_UOM_ID(DB.getSQLValue(null, "SELECT C_UOM_ID FROM C_ContractLine WHERE C_ContractLine_ID="+ls.getContractLine()));
			        wgl.setQtyEquipment(ls.getQty_equip());
					wgl.setPrice(price);
					wgl.setPrice_Usd(price_usd);
					wgl.setPrice_Pure(price_pure);
					wgl.setLineNetAmt(price.multiply(qty_h).multiply(percent));
					wgl.setLineNetAmt_Usd(price_usd.multiply(qty_h).multiply(percent));
					wgl.setLineNetAmt_Pure(price_pure.multiply(qty_h).multiply(percent));
			        wgl.save();
			        
				}
			}
		
		return Mensaje;
	}
	
	
	public class listSet{
		
		Timestamp docdate;
		int contractLine;
		int phase; 
		int charge;
		BigDecimal qty_dif;
		BigDecimal qty_hist;
		BigDecimal price_pure;
		BigDecimal price_usd;
		BigDecimal price;
		BigDecimal percent;
		BigDecimal qtyhoursforday;
		BigDecimal hours;
		String type_cont; 
		String regist;
		String real_cont; 
		Boolean isworkinghours;
		int cworkddgline;
		BigDecimal qty_pend;
		BigDecimal qty_equip;
		
		
		

		public listSet(Timestamp docdate, int contractLine, int phase,
				int charge, BigDecimal qty_dif, BigDecimal qty_hist,
				BigDecimal price_pure, BigDecimal price_usd, BigDecimal price,
				BigDecimal percent, String type_cont, String regist,
				String real_cont, int cworkddgline, BigDecimal qty_pend,
				BigDecimal qty_equip,String isworkinghours,BigDecimal qtyhoursforday,BigDecimal hours) {
			super();
			this.docdate = docdate;
			this.contractLine = contractLine;
			this.phase = phase;
			this.charge = charge;
			this.qty_dif = qty_dif;
			this.qty_hist = qty_hist;
			this.price_pure = price_pure;
			this.price_usd = price_usd;
			this.price = price;
			this.percent = percent;
			this.qtyhoursforday = qtyhoursforday;
			this.hours = hours;
			this.isworkinghours = (isworkinghours.equals("Y")) ? true : false;
			this.type_cont = type_cont;
			this.regist = regist;
			this.real_cont = real_cont;
			this.cworkddgline = cworkddgline;
			this.qty_pend = qty_pend;
			this.qty_equip = qty_equip;
		}
		
		public Timestamp getDocdate() {
			return docdate;
		}
		public void setDocdate(Timestamp docdate) {
			this.docdate = docdate;
		}
		
		public BigDecimal getQtyhoursforday() {
			return qtyhoursforday;
		}

		public void setQtyhoursforday(BigDecimal qtyhoursforday) {
			this.qtyhoursforday = qtyhoursforday;
		}

		public BigDecimal getHours() {
			return hours;
		}

		public void setHours(BigDecimal hours) {
			this.hours = hours;
		}

		public Boolean getIsworkinghours() {
			return isworkinghours;
		}

		public void setIsworkinghours(Boolean isworkinghours) {
			this.isworkinghours = isworkinghours;
		}

		public int getContractLine() {
			return contractLine;
		}

		public void setContractLine(int contractLine) {
			this.contractLine = contractLine;
		}

		public int getPhase() {
			return phase;
		}

		public void setPhase(int phase) {
			this.phase = phase;
		}

		public int getCharge() {
			return charge;
		}

		public void setCharge(int charge) {
			this.charge = charge;
		}

		public BigDecimal getQty_dif() {
			return qty_dif;
		}
		public void setQty_dif(BigDecimal qty_dif) {
			this.qty_dif = qty_dif;
		}
		public BigDecimal getQty_hist() {
			return qty_hist;
		}
		public void setQty_hist(BigDecimal qty_hist) {
			this.qty_hist = qty_hist;
		}
		public BigDecimal getPrice_pure() {
			return price_pure;
		}
		public void setPrice_pure(BigDecimal price_pure) {
			this.price_pure = price_pure;
		}
		public BigDecimal getPrice_usd() {
			return price_usd;
		}
		public void setPrice_usd(BigDecimal price_usd) {
			this.price_usd = price_usd;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public BigDecimal getPercent() {
			return percent;
		}
		public void setPercent(BigDecimal percent) {
			this.percent = percent;
		}
		public String getType_cont() {
			return type_cont;
		}
		public void setType_cont(String type_cont) {
			this.type_cont = type_cont;
		}
		public String getRegist() {
			return regist;
		}
		public void setRegist(String regist) {
			this.regist = regist;
		}

		public String getReal_cont() {
			return real_cont;
		}

		public void setReal_cont(String real_cont) {
			this.real_cont = real_cont;
		}

		public int getCworkddgline() {
			return cworkddgline;
		}

		public void setCworkddgline(int cworkddgline) {
			this.cworkddgline = cworkddgline;
		}
		public BigDecimal getQty_pend() {
			return qty_pend;
		}
		public void setQty_pend(BigDecimal qty_pend) {
			this.qty_pend = qty_pend;
		}
		public BigDecimal getQty_equip() {
			return qty_equip;
		}
		public void setQty_equip(BigDecimal qty_equip) {
			this.qty_equip = qty_equip;
		}
		
		
	}
	
}



