package com.ftc.jsonvo;

public class ResultVO  {
	private String code="";
	private String message="";
	public String getCode() {
		if(code == null || code.trim().equals(""))
		{
			code = "1";
		}
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
