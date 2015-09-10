package com.ftc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ftc.dao.DefaultDAO;
import com.ftc.jsonvo.DataVO;
import com.ftc.jsonvo.JsonVO;
import com.ftc.jsonvo.ResultVO;
import com.ftc.service.UserActionService;
import com.ftc.vo.User;

public class UserActionServiceImpl implements UserActionService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SysMenuServiceImpl.class);
	
	@Override
	public JsonVO AppLogin(String mobile) throws Exception {

		//System.out.println("--mobile="+mobile);
		
		if (logger.isDebugEnabled()) {
			logger.debug("getUserForMobile(String) - start"); //$NON-NLS-1$
		}
		
		DefaultDAO dao = new DefaultDAO();
		JsonVO jVo = new JsonVO();
		ResultVO resultVO = new ResultVO();
		resultVO.setCode("0"); //init message code
		System.out.println("-----------user Action: user-mobile= "+mobile);
		User user = new User();
		List<User> list = new ArrayList<User>();
		if ("".equals(mobile) || mobile == null ) {
			if (logger.isDebugEnabled()) {
				logger.debug("getUserForMobile(String) - end"); //$NON-NLS-1$
			}
			return null;
		}else {
			
			list = dao.toList("user.getUserByMobileNumber",mobile);
		}
//		
//		if(mobile == null || mobile.trim().equals(""))
//		{
//			if (logger.isDebugEnabled()) {
//				logger.debug("getUserForMobile(String) - end"); //$NON-NLS-1$
//			}
//			return null;
//		}
//
//		List<User> list = new ArrayList<User>();
//		list = dao.toList("user.getUserByMobileNumber",mobile);
//		
		if(list == null && list.isEmpty())
		{
			resultVO.setCode("1"); 
			resultVO.setMessage("用户不存在!");			
		}else{
			user = list.get(0);
		}
		
		jVo.setData(user);
		jVo.setResult(resultVO);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("getUserForMobile(String) - end"); //$NON-NLS-1$
		}
		return jVo;
	}

}
