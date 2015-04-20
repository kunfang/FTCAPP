package com.ftc.exception;

public class NullSessionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8518229952444938872L;

	public NullSessionException(){
		super("session 为空！");
	}

}
