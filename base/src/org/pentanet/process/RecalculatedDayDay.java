package org.pentanet.process;


import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.TimeStamp;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.apps.ADialog;
import org.pentanet.model.*;


@SuppressWarnings("unused")
public class RecalculatedDayDay extends SvrProcess {


	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
	} //prepare

	@Override
	protected String doIt() throws Exception {
			//OK
			String msg = Recalculated();
			return msg;

	}//doIt
	
	public String Recalculated() throws SQLException{
		
			String mensaje = "No Recalculo";
		
			MCWorkDDGLine wgl = new MCWorkDDGLine(getCtx(),getRecord_ID(),get_TrxName());
			
			//Verifica la diferencia entre las partidas global y partidas de Historico
			BigDecimal qty = DB.getSQLValueBD(get_TrxName(), "SELECT COALESCE((SELECT  qty_con  FROM formula_workdd(" + wgl.getC_WorkDDG_ID() + ", 'R') fw  "
					+ "WHERE fw.C_ContractLine_ID =  " + wgl.getC_ContractLine_ID() + " AND fw.C_Phase_ID = " + wgl.getC_Phase_ID() +"),0)");
			
			String sql ="SELECT wl.C_WorkDDLine_ID, C_WorkDDGLine_ID FROM C_WorkDD w "
					+ " INNER JOIN C_WorkDDLine wl ON wl.C_WorkDD_ID = w.C_WorkDD_ID "
					+ " INNER JOIN C_WorkDDGLine wgl ON wgl.C_WorkDDG_ID = w.C_WorkDDG_ID AND  wgl.C_ContractLine_ID =  wl.C_ContractLine_ID"
					+ " WHERE w.C_WorkDDG_ID = " + wgl.getC_WorkDDG_ID() + " AND w.DocStatus IN ('IP','DR') AND wl.IsCalculated ='Y' "
					+ " AND wl.C_Phase_ID = " + wgl.getC_Phase_ID();
			
			//String sql = 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = DB.prepareStatement (sql, null);
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				//Actualizar línea
				wgl = new MCWorkDDGLine(getCtx(),rs.getInt(2),get_TrxName());
				
				MCWorkDDLine wl = new MCWorkDDLine(getCtx(),rs.getInt(1),get_TrxName());
				
				if(wgl.isCalculated()){
					
					wgl.setQty(qty);
					wgl.setLineNetAmt(wgl.getPrice().multiply(qty));
					wgl.setLineNetAmt_Usd(wgl.getPrice_Usd().multiply(qty));
					wgl.setLineNetAmt_Pure(wgl.getPrice_Pure().multiply(qty));
					wgl.save();
					
				}
				
				wl.setQty(wgl.getQty());
				wl.setPrice(wgl.getPrice());
				wl.setPrice_Usd(wgl.getPrice_Usd());
				wl.setPrice_Pure(wgl.getPrice_Pure());
				wl.setLineNetAmt(wgl.getPrice().multiply(wgl.getQty()));
				wl.setLineNetAmt_Usd(wgl.getPrice_Usd().multiply(wgl.getQty()));
				wl.setLineNetAmt_Pure(wgl.getPrice_Pure().multiply(wgl.getQty()));
				wl.save();
				
				mensaje = "Recalculalculado";
			    	
			}
			
			return mensaje;
	
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
		String type_cont; 
		String regist;
		String real_cont; 
		int cworkddgline;
		BigDecimal qty_pend;
		BigDecimal qty_equip;
		
		
		

		public listSet(Timestamp docdate, int contractLine, int phase,
				int charge, BigDecimal qty_dif, BigDecimal qty_hist,
				BigDecimal price_pure, BigDecimal price_usd, BigDecimal price,
				BigDecimal percent, String type_cont, String regist,
				String real_cont, int cworkddgline, BigDecimal qty_pend,
				BigDecimal qty_equip) {
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



