package com.ftc.jsonvo;

public class HeadVO  {
	private String function="";
	private String method="";
	private String userCode="";
	private String sessinId;  //
	
	public String getSessinId() {
		return sessinId;
	}
	public void setSessinId(String sessinId) {
		this.sessinId = sessinId;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
}
