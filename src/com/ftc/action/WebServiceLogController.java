package com.ftc.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftc.foundation.view.PageUtil;
import com.ftc.service.LogService;
import com.ftc.vo.LogServiceVO;
import com.ftc.vo.ProductVO;
@Controller("webServiceLogController")
@RequestMapping("/webservicelist.do")
public class WebServiceLogController {
	private static final Logger logger = Logger.getLogger(WebServiceLogController.class);
	
	@Resource
	private LogService logService;
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	/**
     *@param  [ProductVO,Model] [查询条件信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [日志清单]
     */
	@RequestMapping(params="method=getWebServiceList") 
	public String getWebServiceList(LogServiceVO logServiceVO,PageUtil pUtil,Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getWebServiceList(LogServiceVO) - start"); //$NON-NLS-1$
		}
		try {			
			List<LogServiceVO> list=logService.getLogListByAll(logServiceVO,pUtil);
			int totalCount = logService.getLogCounts(logServiceVO);
					
			PageUtil pU = new PageUtil();
			HashMap<String, Integer> pageList = pU.getPageList( pUtil.getCurPage(), totalCount,3);
			
			model.addAttribute("logList",list);
			model.addAttribute("pageList",pageList);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","Login Error!!!");
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("getWebServiceList(LogServiceVO) - end"); //$NON-NLS-1$
		}
		return "log/logAllList";  
	}
	
	
}
