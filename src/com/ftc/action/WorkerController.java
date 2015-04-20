package com.ftc.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftc.service.ProductService;
import com.ftc.service.WorkerService;
import com.ftc.vo.CategoryVO;
import com.ftc.vo.FeedbackPageVO;
import com.ftc.vo.ProductPageVO;
import com.ftc.vo.ProductVO;
import com.ftc.vo.StatusVO;
import com.ftc.vo.WorkPageVO;
import com.ftc.vo.WorkerVO;

@Controller("workerController")
@RequestMapping("/workerController.do")
public class WorkerController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkerController.class);
	
	@Resource
	private WorkerService ws ;
	public WorkerService getWs() {
		return ws;
	}
	public void setWs(WorkerService ws) {
		this.ws = ws;
	}
	
	@Resource
	private ProductService ps;
	public ProductService getPs() {
		return ps;
	}
	public void setPs(ProductService ps) {
		this.ps = ps;
	}
	/**
     *@param  [WorkerVO,Model] [查询条件信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [手艺人清单]
     */
	@RequestMapping(params="method=getWorkerbyList") 
	public String getWorkerbyList(WorkerVO workerVo,Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getWorkerbyList(WorkerVO) - start"); //$NON-NLS-1$
		}
		try {
			List<WorkerVO> list=ws.queryListOfWorkInfo(workerVo);
			model.addAttribute("workerList",list);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","getWorkerbyList Error!!!");
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("getWorkerbyList(WorkerVO) - end"); //$NON-NLS-1$
		}
		return "worker/workerAllList";  
	}
	
	/**
     *@param  [WorkerVO,Model] [手艺人信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [手艺人删除]
     */
	@RequestMapping(params="method=toWorkDelete") 
	public String toWorkDelete(WorkerVO wVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toWorkDelete(WorkerVO,Model) - start"); //$NON-NLS-1$
		}
		try {
			ws.deleteWorkById(wVo);
			this.getWorkerbyList(wVo, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toprodDelete(ProductVO,Model) - end"); //$NON-NLS-1$
		}
		return "worker/workerAllList";  
	}
	
	/**
     *@param  [WorkerVO,Model] [手艺人信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [手艺人信息查看]
     */
	@RequestMapping(params="method=toView") 
	public String toView(WorkerVO wVO,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toView(WorkerVO,Model) - start"); //$NON-NLS-1$
		}
		String result="";
		try {
			WorkPageVO worker=ws.queryWorkByWid(wVO.getWorkerId(),"N");
			model.addAttribute("workPageVO", worker);
			result="worker/workerView";
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toView(WorkerVO,Model) - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	/**
     *@param  [workPageVO,Model] [手艺人信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [手艺人新增]
     */
	@RequestMapping(params="method=toInsertWorkder") 
	public String toInsertWorkder(WorkPageVO workPageVo,WorkerVO workerVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("toInsertWorkder(WorkPageVO,Model) - start"); //$NON-NLS-1$
		}
		String result="";
		try {
			if(workPageVo.getWorkerName()!=null && !"".equals(workPageVo.getWorkerName())){
				ws.insertWorker(workPageVo);
				workerVo.setMobile("");
				workerVo.setWorkerName("");
				this.getWorkerbyList(workerVo, model);
				result="worker/workerAllList"; 
			}else{
				List<StatusVO> fileStatus= ps.getStatusnameByType("FileStatus");
				List<StatusVO> descType=ps.getStatusnameByType("DescType");
				List<StatusVO> starType=ps.getStatusnameByType("StarType");
				model.addAttribute("fileStatus", fileStatus);
				model.addAttribute("descType",descType);
				model.addAttribute("starType",starType);
				result="worker/workderInsert";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("toInsertProduct(ProductVO,Model) - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	/**
     *@param  [ProductPageVO,Model] [产品信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [产品查看(修改)]
     */
	@RequestMapping(params="method=selectWorkForUpdate") 
	public String selectWorkForUpdate(WorkPageVO workPageVo,Model model){
		if (logger.isDebugEnabled()) {
			logger.debug("selectWorkForUpdate(WorkPageVO) - start"); //$NON-NLS-1$
		}
		try {
			List<StatusVO> fileStatus= ps.getStatusnameByType("FileStatus");
			List<StatusVO> descType=ps.getStatusnameByType("DescType");
			List<StatusVO> starType=ps.getStatusnameByType("StarType");
		    WorkPageVO worker=ws.queryWorkByWid(workPageVo.getWorkerId(),"Y");
			model.addAttribute("fileStatus", fileStatus);
			model.addAttribute("descType",descType);
			model.addAttribute("starType",starType);
			model.addAttribute("workPageVO",worker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("selectWorkForUpdate(WorkPageVO) - end"); //$NON-NLS-1$
		}
		return "worker/workderInsert";
	}
	
	/**
     *@param  [WorkPageVO,Model] [手艺人信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [手艺人修改]
     */
	@RequestMapping(params="method=toUpdateWorker") 
	public String toUpdateWorker(WorkPageVO workPageVo,Model model,HttpServletRequest request){
		if (logger.isDebugEnabled()) {
			logger.debug("toUpdateWorker(WorkPageVO,Model,HttpServletRequest) - start"); //$NON-NLS-1$
		}
		
		try {
			ws.updateWorker(workPageVo);
			request.setAttribute("msg", "保存手艺人信息成功");
			request.setAttribute("code", "0");
		} catch (Exception e) {
			request.setAttribute("msg", "保存手艺人信息失败");
			request.setAttribute("code", "1");
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("toUpdateWorker(WorkPageVO,Model,HttpServletRequest) - end"); //$NON-NLS-1$
		}
		return "product/showmsg";
	}
    
	/**
     *@param  [WorkPageVO,Model] [手艺人信息,对象绑定]
     *@return  [返回需要跳转的页面名称]
     *@description [用户评论查看]
     */
	@RequestMapping(params="method=toViewDiscu") 
	public String toViewDiscu(FeedbackPageVO fvo,Model model,HttpServletRequest request){
		if (logger.isDebugEnabled()) {
			logger.debug("toViewDiscu(FeedbackPageVO,Model,HttpServletRequest) - start"); //$NON-NLS-1$
		}
		try {
			List<FeedbackPageVO> list=ws.getFeedbackBywid(fvo.getWorkerId());
			model.addAttribute("feedbackPageList",list);
			//model.addAttribute("workderId",fvo.getWorkerId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","getWorkerbyList Error!!!");
		} 
		if (logger.isDebugEnabled()) {
			logger.debug("toViewDiscu(FeedbackPageVO,Model,HttpServletRequest) - end"); //$NON-NLS-1$
		}
		return "worker/DiscutAllList";
	}
}
