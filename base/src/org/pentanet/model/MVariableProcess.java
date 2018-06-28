package org.pentanet.model;

public class MVariableProcess {
	
	private String name;
	private String code;
	private Object value;

	public MVariableProcess(String name, String code, Object value) {
		// TODO Auto-generated constructor stub
		this.name= name;
		this.code = code;
		this.value = value;
	}


	public Object getValue() {
		return value;
	}


	public void setValue(Object value) {
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	

}
