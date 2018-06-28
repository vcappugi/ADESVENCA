/******************************************************************************
 * The contents of this file are subject to the   Compiere License  Version 1.1
 * ("License"); You may not use this file except in compliance with the License
 * You may obtain a copy of the License at http://www.compiere.org/license.html
 * Software distributed under the License is distributed on an  "AS IS"  basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * The Original Code is                  Compiere  ERP & CRM  Business Solution
 * The Initial Developer of the Original Code is Jorg Janke  and ComPiere, Inc.
 *
 * Copyright (C) 2005 Robert KLEIN. robeklein@gmail.com * 
 * Contributor(s): ______________________________________.
 *****************************************************************************/
package org.compiere.FA;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.compiere.model.X_A_Depreciation;
import org.compiere.model.X_A_Depreciation_Convention;
import org.compiere.model.X_A_Depreciation_Exp;
import org.compiere.model.X_A_Depreciation_Forecast;
import org.compiere.model.X_A_Depreciation_Method;
import org.compiere.model.X_A_Depreciation_Workfile;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

/**
 *	Build Depreciation Forecast File
 *	
 *  @author Rob Klein
 *  @version $Id: BuildDepForecastFile.java,v 1.0 $
 */

@SuppressWarnings("unused")
public class BuildDepForecastFile extends SvrProcess
{
	/** Record ID				*/
	private int p_Depreciation_Build_ID = 0;
	private boolean	m_DeleteOld = false;
	
	/**
	 *  Prepare - e.g., get Parameters.
	 */
	protected void prepare()
	{
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
	}	//	prepare

	
	/**
	 * 	Build Depreciation Workfile
	 *	@return info
	 *	@throws Exception
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	protected String doIt() throws java.lang.Exception
	{
		/*Metodo de Depreciacion en Linea REcta
		 * Por vcappugi
		 * Fecha: abril 2014
		 * Objetivo: generar comprobante de diario con asiento de depreciacion
		 *           asi como registrar en tabla A_Depreciation_workfile el registro de depreciacion 
		 *           de cada activo
		 */
		int depreciation_id;
		X_A_Depreciation_Forecast dep = new X_A_Depreciation_Forecast(getCtx(),p_Depreciation_Build_ID,null);
		
	    
		
		
		int A_AssetGroup_ID = DB.getSQLValue(get_TrxName(), "SELECT A_Asset_Group_ID FROM A_Depreciation_Forecast WHERE A_Depreciation_Forecast_ID=" + p_Depreciation_Build_ID);
		   //Elimino todos los registros de depreciacion vinculados a la fecha y categoria de activo
		int err=0;
		if (m_DeleteOld)
		   err = DB.executeUpdate("DELETE FROM A_DEPRECIATION_WORKFILE WHERE ASSETDEPRECIATIONDATE ='"+dep.getDateDoc()+"' AND A_ASSET_ID IN (SELECT A_ASSET_ID FROM A_ASSET WHERE A_ASSET_GROUP_ID="+A_AssetGroup_ID+")");
		
		
		//PASO 1: Ubicacion de los activos a Depreciar, con su costo inicial y fecha
		String sql = "SELECT A.A_ASSET_ID, A.A_ASSET_CREATEDATE, D.DATEACCT,  "  //1,2,3
 + " D.A_ASSET_COST, D.A_LIFE_PERIOD, ((D.A_ASSET_COST)/(Select uselifemonths from a_asset where a_asset_id = A.a_asset_id )) AS DEPRECIATION_PERIOD, "  //4,5,6
 +" D.A_QTY_CURRENT, A.USELIFEYEARS, D.A_SALVAGE_VALUE,D.A_ACCUMULATED_DEPR, D.C_ACTIVITY_ID  " //7.8.9, 10, 11
 + " FROM A_ASSET A "
 + " INNER JOIN A_DEPRECIATION_WORKFILE D ON D.A_ASSET_ID = A.A_ASSET_ID AND D.AssetDepreciationDate = (SELECT MIN(AssetDepreciationDate) FROM A_DEPRECIATION_WORKFILE WHERE A_ASSET_ID = A.A_ASSET_ID) "
 + " WHERE A.ISDEPRECIATED='Y' AND A.ISINPOSESSION='Y' AND D.A_LIFE_PERIOD>0 AND A.A_Asset_Group_ID="+A_AssetGroup_ID;
		
		PreparedStatement pstmt = null;
		pstmt = DB.prepareStatement (sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE,null);
		//PASO 2: Por cada Activo almacenar el registro de su depreciacion
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				//Ubicar si ya se ha ejecutado la depreciacion de este activo a la fecha indicada
				depreciation_id = DB.getSQLValue(null, "SELECT A_DEPRECIATION_WORKFILE_ID FROM A_DEPRECIATION_WORKFILE WHERE A_ASSET_ID=" + rs.getInt(1)+ " AND DATEACCT='"+ dep.getDateDoc()+"'");
				if (depreciation_id <=0 )
					depreciation_id=0;
				//UBICAR ULTIMO PERIODO DE VIDA
				int period_life = DB.getSQLValue(null, "SELECT MIN(A_LIFE_PERIOD)-1 FROM A_DEPRECIATION_WORKFILE  WHERE ASSETDEPRECIATIONDATE <>'"+dep.getDateDoc()+"' AND A_ASSET_ID=" + rs.getInt(1));
				//LA DEPRECIACION ACUMULADA HASTA AHORA
				BigDecimal depreciatoin_acum = rs.getBigDecimal(10);
				if (period_life >=0 ) { //solo si la vida actual es maypr a 0 y el minimo del monto de salvaguarda
				X_A_Depreciation_Workfile depreciation = new X_A_Depreciation_Workfile (getCtx(), depreciation_id, null);
					depreciation.setAD_Org_ID(dep.getAD_Org_ID());
					depreciation.setA_Asset_ID(rs.getInt(1));
					depreciation.setPostingType("A");
					depreciation.setDateAcct(dep.getDateDoc());
					depreciation.setA_Period_Forecast(rs.getBigDecimal(6).setScale(2,rs.getBigDecimal(6).ROUND_HALF_DOWN ));
					depreciation.setA_Curr_Dep_Exp(rs.getBigDecimal(6).setScale(2,rs.getBigDecimal(6).ROUND_HALF_DOWN ));
					depreciation.setA_Asset_Cost(rs.getBigDecimal(4));
					depreciation.setA_QTY_Current(rs.getBigDecimal(7));
					depreciation.setA_Asset_Life_Years(rs.getInt(8));
					depreciation.setA_Salvage_Value(rs.getBigDecimal(9));
					depreciation.setDateAcct(dep.getDateDoc());
					depreciation.setA_Life_Period(period_life);
					depreciation.setC_Activity_ID(rs.getInt(11));
					depreciation.setA_Accumulated_Depr(depreciatoin_acum.add(rs.getBigDecimal(6)).setScale(2,BigDecimal.ROUND_HALF_DOWN ));
					
					depreciation.setAssetDepreciationDate(dep.getDateDoc());
					
					depreciation.setIsDepreciated(true);
					
					depreciation.save();
				}
				
				
			}
		}catch (Exception e)
		{
			log.info("getAssets"+ e);
		}
		
			return "Calculo Terminado....";
	}	//	doIt
	
}	//	BuildDepForecastFile
