package com.ftc.service;

import com.ftc.jsonvo.JsonVO;

/**
 * App 登陆接口
 * @author yangchun.gan
 *
 */
public interface UserActionService {

	/**
	 * 登陆
	 * 
	 * 
	 */
	public JsonVO AppLogin(String params) throws Exception;
	
	
	
}
