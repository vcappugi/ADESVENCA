package org.adempiere.appweb.model;

import java.util.Properties;



public class MCtxApprove {
	
	private Object ADUserID;
	private String ADUser;
	private String ADRole;
	private Object ADRecord;
	private Object ADTable;
	private Object ADId;
	


	private org.adempiere.appweb.util.EncryptRLMH.Encrypt Encrypt = new org.adempiere.appweb.util.EncryptRLMH.Encrypt();

	public MCtxApprove(String chain) {
		
		String[] t = Encrypt.getDecrypt(chain).split("&");
		
		this.ADUserID= t[0];
		this.ADUser= t[1];
		this.ADRole = t[2];
		this.ADRecord = t[3];
		this.ADTable = t[4];
		this.ADId = t[5];
	}
	
	public void setCtx(Properties ctx) {
		ctx.setProperty("#AD_User_ID", getADUserID().toString());
		ctx.setProperty("#AD_User_Name", getADUser());
		ctx.setProperty("#AD_Role_ID", getADRole());
		ctx.setProperty("#Record_ID", getADRecord().toString());
		ctx.setProperty("#AD_Table_ID", getADTable().toString());
		ctx.setProperty("#Appweb_ID", getADId().toString());
		
		ctx.setProperty("#AD_Org_ID", "0");
		ctx.setProperty("#AD_Client_ID", "1000000");
	}
	
	

	public Object getADUserID() {
		return ADUserID;
	}

	public void setADUserID(Object aDUserID) {
		ADUserID = aDUserID;
	}

	public String getADUser() {
		return ADUser;
	}

	public void setADUser(String aDUser) {
		ADUser = aDUser;
	}

	public String getADRole() {
		return ADRole;
	}

	public void setADRole(String aDRole) {
		ADRole = aDRole;
	}

	public Object getADRecord() {
		return ADRecord;
	}

	public void setADRecord(Object aDRecord) {
		ADRecord = aDRecord;
	}

	public Object getADTable() {
		return ADTable;
	}

	public void setADTable(Object aDTable) {
		ADTable = aDTable;
	}
	
	public Object getADId() {
		return ADId;
	}

	public void setADId(Object aDId) {
		ADId = aDId;
	}
}
