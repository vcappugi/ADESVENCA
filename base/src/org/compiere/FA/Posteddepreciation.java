/*
 * Proceso para actualizar contablemente 
 * las depreciaciones desde el pronostico
 * desarrolado por vcappugi
 * abril 2014
 */

package org.compiere.FA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.model.MFactAcct;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.X_C_ValidCombination;
import org.compiere.model.X_A_Depreciation_Forecast;


@SuppressWarnings("unused")
public class Posteddepreciation extends SvrProcess {
	
	/** Record ID				*/
	private int p_Depreciation_Build_ID = 0;
	private boolean	m_DeleteOld = false;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("DeleteOld"))
				m_DeleteOld = "Y".equals(para[i].getParameter());
			else
				log.info("prepare - Unknown Parameter: " + name);
		}
		p_Depreciation_Build_ID = getRecord_ID();

	}

	@Override
	/*
	 * Proceso de Actualizacion de FACT_ACCT
	 *
	 */
	protected String doIt() throws Exception {
		
		X_A_Depreciation_Forecast dep = new X_A_Depreciation_Forecast(getCtx(),p_Depreciation_Build_ID,null);

MJournalBatch jour = new MJournalBatch(getCtx(),0,null);
String nombregrupo = DB.getSQLValueString(get_TrxName(),"SELECT Name from A_Asset_Group WHERE A_Asset_Group_I=" + dep.getA_Asset_Group_ID() );
//CREO EL JOURNALBATCH
jour.setDescription("DOCUMENTO AUTOMATICO DE DEPRECIACION DE ACTIVOS "+nombregrupo);
jour.setPostingType("A");
jour.setGL_Category_ID(1000000);
jour.setC_DocType_ID(1000000);
jour.setDateDoc(dep.getDateDoc());
jour.setDateAcct(dep.getDateDoc());
jour.setC_Currency_ID(205);
jour.save();
int id_lote = jour.getGL_JournalBatch_ID();
int id_period = jour.getC_Period_ID();
//CREO EL DIARIO
MJournal diario = new MJournal(getCtx(),0,null);
diario.setDescription("Diario Generado para Depreciacion de Activos " + nombregrupo);
diario.setGL_JournalBatch_ID(id_lote);
diario.setC_AcctSchema_ID(1000000);
diario.setC_DocType_ID(1000000);
diario.setPostingType("A");
diario.setDateDoc(dep.getDateDoc());
diario.setDateAcct(dep.getDateDoc());
diario.setGL_Category_ID(1000000);
diario.setC_Period_ID(id_period);
diario.setC_ConversionType_ID(114);
diario.setC_Currency_ID(205);
diario.save();
int id_diario=diario.getGL_Journal_ID();

//Busco las configuraciones contables de los activos 
//int client=Env.getContextAsInt(A_Ctx, "#AD_Client_ID");
String sql_l ="SELECT A.NAME AS ACTIVO, AA.A_Asset_ID, AA.A_Depreciation_ACCT, AA.A_AccumDepreciation_ACCT, "
+ " D.A_PERIOD_FORECAST "
+" FROM A_ASSET_ACCT AA"
+" INNER JOIN A_ASSET A ON A.A_ASSET_ID = AA.A_ASSET_ID"
+" INNER JOIN A_DEPRECIATION_WORKFILE D ON D.A_ASSET_ID = A.A_ASSET_ID AND D.AssetDepreciationDate =SUBSTR('" + dep.getDateDoc()+"',1,10)::timestamp "
+" WHERE AA.AD_Client_ID=1000000 AND A.ISDEPRECIATED='Y' AND A.ISINPOSESSION='Y' AND A.A_Asset_Group_ID=" +  dep.getA_Asset_Group_ID() ;

PreparedStatement pstmt = DB.prepareStatement (sql_l,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE,null);

ResultSet rs = pstmt.executeQuery ();

//Ahora las Lineas del diario contable
while (rs.next ())
{	

	//Inicio de grabacion de comprobante de depreciacion
                       //Por el Debe el gasto de depreciacion
//Combinacion valida
	X_C_ValidCombination comb1 = new X_C_ValidCombination(getCtx(),rs.getInt(3),null);
	X_C_ValidCombination comb2= new X_C_ValidCombination(getCtx(),rs.getInt(4),null);
//Buscar CC de Ubicacion Actual del Activo
	int cc = DB.getSQLValue(null, "SELECT C_ACTIVITY_ID FROM A_ASSET_USE WHERE A_ASSET_ID="+rs.getInt(2)+" AND USEDATE=(SELECT MAX(USEDATE) FROM A_ASSET_USE WHERE A_ASSET_ID="+rs.getInt(2)+" AND USEDATE<=substr('" + dep.getDateDoc()+"',1,10)::timestamp)");
if (!(cc>0)){
	cc= DB.getSQLValue(get_TrxName(), "SELECT C_ACTIVITY FROM A_Depreciation_Workfile WHERE A_ASSET_ID="+rs.getInt(2)+" AND A_Depreciation_Workfile = (Select MAX(A_Depreciation_Workfile) FROM A_Depreciation_Workfile WHERE A_ASSET_ID="+rs.getInt(2)+")");
	
	
}
	//Incluye el centro de costo en la combinacion (ojo quita el que estaba de ultimo)	
	if (cc >0){
	   comb1.setC_Activity_ID(cc);
	   comb1.save();
	   comb2.setC_Activity_ID(cc);
	   comb2.save();
	}

	
	MJournalLine linea = new MJournalLine(getCtx(),0,null);
	linea.setGL_Journal_ID(id_diario);
	linea.setDescription("Gasto de Depreciacion: " + rs.getString(1));
	linea.setC_Currency_ID(205);
	linea.setDateAcct(dep.getDateDoc());
	linea.setC_ConversionType_ID(114);
	linea.setC_ValidCombination_ID(comb1.getC_ValidCombination_ID());
	linea.setA_Asset_ID(rs.getInt(2));
	linea.setAmtAcctDr(rs.getBigDecimal(5));
	linea.setAmtSourceDr(rs.getBigDecimal(5));
	linea.setA_CreateAsset(true);
	linea.save();
	
	//Por el Haber la depreciacion acumulada
	MJournalLine linea2 = new MJournalLine(getCtx(),0,null);
	linea2.setGL_Journal_ID(id_diario);
	linea2.setDescription("Depreciacion Acumulada: "+ rs.getString(1));
	linea2.setC_Currency_ID(205);
	linea2.setDateAcct(dep.getDateDoc());
	linea2.setC_ConversionType_ID(114);
	linea2.setC_ValidCombination_ID(comb2.getC_ValidCombination_ID());
	linea2.setAmtAcctCr(rs.getBigDecimal(5));
	linea2.setAmtSourceCr(rs.getBigDecimal(5));
	linea2.setA_CreateAsset(true);
	
	linea2.setA_Asset_ID(rs.getInt(2));
	linea2.save();	
		
}

//Completar y Contabilizar

//jour.completeIt();
//jour.save();



		
		return "Generado ASiento de Diario " + jour.getDocumentNo();
	}

}
