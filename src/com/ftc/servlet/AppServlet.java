package com.ftc.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ftc.constant.WebConstants;
import com.ftc.dao.DefaultDAO;
import com.ftc.jsonvo.HeadVO;
import com.ftc.jsonvo.JsonUtil;
import com.ftc.jsonvo.JsonVO;
import com.ftc.jsonvo.ResultVO;
import com.ftc.service.SysMenuService;
import com.ftc.service.UserActionService;
import com.ftc.serviceImpl.SysMenuServiceImpl;
import com.ftc.serviceImpl.UserActionServiceImpl;
import com.ftc.vo.MobileLogVO;
import com.ftc.vo.User;

public class AppServlet extends HttpServlet{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppServlet.class);
	
	public DefaultDAO dDao ;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("doGet(HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}

		doPost(req, resp);

		if (logger.isDebugEnabled()) {
			logger.debug("doGet(HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("doPost(HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}
		System.out.println("我进入了吗?");
		
		HeadVO headVO = null;
		ResultVO resultVO = new ResultVO();
		JsonVO retVO = new JsonVO();  //返回的数据
		JsonUtil util = new JsonUtil();
		MobileLogVO tmbl=new MobileLogVO();
		User user = new User();
		//MobileLogImpl tmblLog=new MobileLogImpl();
		
		
		
		try {
			InputStreamReader isr = new InputStreamReader(request.getInputStream(),"UTF-8");
			BufferedReader in = new BufferedReader(isr);
			StringBuffer inStr =new StringBuffer("");
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				inStr.append(inputLine);
				inStr.append("\n");
			}
			in.close();	
			if (logger.isDebugEnabled()) {
				logger.debug("接收到转换之前xml--转码前：" + inStr.toString()); //$NON-NLS-1$m 
			}
			System.out.println("inStr="+inStr);
			
			String sendXml =URLDecoder.decode(inStr.toString(),"UTF-8");//转码
			
			System.out.println("XML="+sendXml);
			
			if (logger.isDebugEnabled()) {
				logger.debug("接收到转换之后xml--转换后：" + sendXml); //$NON-NLS-1$
			}
			System.out.println("--------------------------------1");
			tmbl.setReqContext(sendXml);
			System.out.println("--------------------------------2");
			new JSONObject();
			JSONObject json = JSONObject.fromObject(sendXml);  //将xml转成json	
			System.out.println("--------------------------------3"+json);
			//转成vo
			JsonVO jsonVO = null;  //因为不知道data具体是哪个类，所以要在各自的if体内转
			headVO = (HeadVO)JSONObject.toBean(JSONObject.fromObject(json.get("head")), HeadVO.class);  //取head值
			System.out.println(headVO.getFunction().trim()+"-------------------head----"+headVO);
			if(headVO.getFunction().trim().equals("user")){
				if(headVO.getMethod().trim().equals("applogin")){ //登录
//					
//					jsonVO = util.getJsonVOFromJson(json, User.class);
//					System.out.println("   0000"+((User)jsonVO.getData()).getMobile());
//					
					JSONObject  jObject = JSONObject.fromObject(json.get("data"));					
					String securityCode = jObject.get("SecurityCode").toString();					
					String mobile = jObject.get("mobilePhone").toString();
//					System.out.println(securityCode+"-----"+mobile);
					
					UserActionService uActionService = new UserActionServiceImpl();
					
					retVO = uActionService.AppLogin(mobile);
					
//					dDao = new DefaultDAO();
//					retVO.setList(dDao.toList("user.getUserByMobileNumber",mobile));
					
					
					
//					if(list != null && !list.isEmpty())
//					{
//						user = (User) list.get(0);
//					}
//					SysMenuServiceImpl asms = new SysMenuServiceImpl();
//					//user = asms.toView("");
//					//		getUserForMobile(mobile);
//					user = asms.toView("4");
					
					//System.out.println("user="+user);
					//jsonVO = (JsonVO) JSONObject.toBean(json, JsonVO.class);
					/*CustomerManagerFacade facade = new CustomerManagerFacadeImpl();
					tmbl.setSpecificType(WebConstants.SPECIFI_TYPE_GETCUSTOMERLIST);
					tmbl.setTransactionType(WebConstants.TRANSACTION_TYPE_OUTER);		
					retVO = facade.queryCustomerList(jsonVO);			*/
				}
			}
			
			
			resultVO.setCode("1");
			resultVO.setMessage("登陆成功");		
			tmbl.setSuccessFlag("1");
		} catch (IOException e) {
			logger.error("doPost(HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$

			tmbl.setSuccessFlag("0");
			logger.error("doPost(HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$			
			resultVO.setCode("0");
			resultVO.setMessage("系统错误。");
		} catch(Exception e){

			tmbl.setSuccessFlag("0");
			resultVO.setCode("0");
			resultVO.setMessage("系统错误。");
			e.printStackTrace();
			logger.error("doPost(HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$
		}
		finally{		 
			 
			//返回数据
			JSONObject retJson = new JSONObject();			
			retVO.setHead(headVO);
			retVO.setResult(resultVO);
			retVO.setData(retVO.getData());

			
			
			try{
				if (logger.isDebugEnabled()) {
					logger.debug("查询完成-------1"); //$NON-NLS-1$
				}
				String outStr = JSONObject.fromObject(retVO).toString();
				
				if (logger.isDebugEnabled()) {
					logger.debug("转换完成--------2"); //$NON-NLS-1$
				}
				
				if(!headVO.getMethod().trim().equals("getEntryInfo")){
					logger.debug("写入数据库-------3"); //$NON-NLS-1$
					if (logger.isDebugEnabled()) {
						logger.debug("finally:返回xml：" + outStr); //$NON-NLS-1$
					}
					tmbl.setResContext(outStr);			 
				//	tmblLog.insertLog(tmbl);
				}
				if (logger.isDebugEnabled()) {
					logger.debug("写入数据库完成-------4"); //$NON-NLS-1$
				}
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter write = response.getWriter();
				write.write(outStr);
				write.close();
			}catch(Exception ex)
			{
				logger.error("doPost(HttpServletRequest, HttpServletResponse)", ex); //$NON-NLS-1$
			}		
		}	
	
		if (logger.isDebugEnabled()) {
			logger.debug("doPost(HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
	}

}
