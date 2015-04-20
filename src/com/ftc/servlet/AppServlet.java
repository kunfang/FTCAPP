package com.ftc.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import com.ftc.constant.WebConstants;
import com.ftc.jsonvo.HeadVO;
import com.ftc.jsonvo.JsonUtil;
import com.ftc.jsonvo.JsonVO;
import com.ftc.jsonvo.ResultVO;
import com.ftc.vo.MobileLogVO;

public class AppServlet extends HttpServlet{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppServlet.class);
	
	
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
		
		HeadVO headVO = null;
		ResultVO resultVO = new ResultVO();
		JsonVO retVO = new JsonVO();  //返回的数据
		JsonUtil util = new JsonUtil();
		MobileLogVO tmbl=new MobileLogVO();
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
			String sendXml =URLDecoder.decode(inStr.toString(),"UTF-8");//转码
			if (logger.isDebugEnabled()) {
				logger.debug("接收到转换之后xml--转换后：" + sendXml); //$NON-NLS-1$
			}
			tmbl.setReqContext(sendXml);
			 
			new JSONObject();
			JSONObject json = JSONObject.fromObject(sendXml);  //将xml转成json	
			
			//转成vo
			JsonVO jsonVO = null;  //因为不知道data具体是哪个类，所以要在各自的if体内转
			headVO = (HeadVO)JSONObject.toBean(JSONObject.fromObject(json.get("head")), HeadVO.class);  //取head值

			if(headVO.getFunction().trim().equals("product")){
				if(headVO.getMethod().trim().equals("query")){ //登录
					jsonVO = (JsonVO) JSONObject.toBean(json, JsonVO.class);
					/*CustomerManagerFacade facade = new CustomerManagerFacadeImpl();
					tmbl.setSpecificType(WebConstants.SPECIFI_TYPE_GETCUSTOMERLIST);
					tmbl.setTransactionType(WebConstants.TRANSACTION_TYPE_OUTER);		
					retVO = facade.queryCustomerList(jsonVO);			*/
				}
			}
			
			
			
			
			
			resultVO = retVO.getResult();		
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

//			System.out.println(startDate+"接口开始时间");
//			System.out.println(df.format(new Date())+"接口结束时间");
			
			
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
