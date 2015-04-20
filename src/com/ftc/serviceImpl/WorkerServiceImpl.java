package com.ftc.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.dao.DefaultDAO;
import com.ftc.service.WorkerService;
import com.ftc.vo.DistinctVO;
import com.ftc.vo.FeedbackPageVO;
import com.ftc.vo.FileVO;
import com.ftc.vo.ProductPageVO;
import com.ftc.vo.ProductVO;
import com.ftc.vo.WorkPageVO;
import com.ftc.vo.WorkerVO;
@Service("ws") 
public class WorkerServiceImpl implements WorkerService{
	private static final Logger logger = Logger.getLogger(WorkerServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<WorkerVO> queryListOfWorkInfo(WorkerVO wvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryListOfWorkInfo(WorkerVO wvo) - start"); //$NON-NLS-1$
		}
		String sqlWhere="";
		if(wvo.getWorkerName()!=null && !"".equals(wvo.getWorkerName())){
			sqlWhere=" and a.WorkerName like '%"+wvo.getWorkerName().trim()+"%'";
		}
		else if(wvo.getMobile()!=null && !"".equals(wvo.getMobile())){
			sqlWhere=" and a.Mobile like '%"+wvo.getMobile().trim()+"%'";
		}
		
		int totalCount = dao.doTotalPageCount("worker.getTotalCount", sqlWhere);
		List<WorkerVO> list = dao.toList("worker.getProductByAll", sqlWhere);
		
		if (logger.isDebugEnabled()) {
			logger.debug("queryListOfWorkInfo(WorkerVO wvo) - end"); //$NON-NLS-1$
		}
		return list;
	}

	@Override
	public void deleteWorkById(WorkerVO wvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteWorkById(WorkerVO) - start"); //$NON-NLS-1$
		}
		WorkerVO work=(WorkerVO)dao.toView("worker.toList", wvo);
		if(work!=null){
			try {
				dao.startTransaction();
				dao.doDelete("worker.doWorkDelete", work);
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("deleteWorkById(WorkerVO) - end"); //$NON-NLS-1$
		}
		
	}

	@Override
	public WorkPageVO queryWorkByWid(String workId,String isView) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryWorkByWid(String) - start"); //$NON-NLS-1$
		}
		
		String sqlWhere="";
		String desc="";
		if(workId!= null && !"".equals(workId) ){
			sqlWhere=" and a.WorkerId ="+workId;
		}
		
		WorkPageVO workerVo=(WorkPageVO)dao.toView("worker.getProductByAll",sqlWhere);
		DistinctVO dvo=new DistinctVO();
		dvo.setWorkerId(workerVo.getWorkerId());
		List<DistinctVO> disList=dao.toList("distinct.getDistinctById",dvo);
		if(disList!=null && disList.size()>0 && !"Y".equals(isView)){
			int j=0;
			for(int i=0;i<disList.size();i++){
				j++;
				desc+=disList.get(i).getDistrictName()+" ,";
				if(j==5){
					desc+="<br/>";
					j=0;
				}
			}
			
			if(disList.size()%4==0){
				workerVo.setDistinctDesc(desc.substring(0, desc.length()-8));
			}else{
				workerVo.setDistinctDesc(desc.substring(0, desc.length()-1));
			}
		}else{
			for(int i=0;i<disList.size();i++){
				desc+=disList.get(i).getDistrictName()+" ,";
			}
			workerVo.setDistinctDesc(desc.substring(0, desc.length()-1));
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("queryWorkByWid(String) - end"); //$NON-NLS-1$
		}
		return workerVo;
	}

	@Override
	public void insertWorker(WorkPageVO wvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("insertWorker(WorkPageVO) - start"); //$NON-NLS-1$
		}
		String sqlWhere="";
			try {
			    dao.startTransaction();
			    WorkerVO worker =new WorkerVO();
				worker.setWorkerName(wvo.getWorkerName());
				worker.setMobile(wvo.getMobile());
				worker.setServe("0");
				worker.setSpecialtyRating(wvo.getSpecialtyRating());
				worker.setCommunicateRating(wvo.getCommunicateRating());
				worker.setPunctualRating(wvo.getPunctualRating());
				worker.setInfrom(wvo.getInfrom());
				worker.setIntroduce(wvo.getIntroduce());
				worker.setLevels(wvo.getLevels());
				worker.setLikes(wvo.getLikes());
				worker.setStatus(wvo.getStatus());
				worker.setStar(wvo.getStar());
				dao.doInsert("worker.doInsert", worker);
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
		if (logger.isDebugEnabled()) {
			logger.debug("insertWorker(WorkPageVO) - end"); //$NON-NLS-1$
		}
	
		
	}

	@Override
	public void updateWorker(WorkPageVO wvo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("updateWorker(WorkPageVO) - start"); //$NON-NLS-1$
		}
		try {
				dao.startTransaction();
				WorkerVO workerVO=new WorkerVO();
				workerVO.setWorkerId(wvo.getWorkerId());
				workerVO.setWorkerName(wvo.getWorkerName());
				workerVO.setMobile(wvo.getMobile());
				workerVO.setSpecialtyRating(wvo.getSpecialtyRating());
				workerVO.setCommunicateRating(wvo.getCommunicateRating());
				workerVO.setPunctualRating(wvo.getPunctualRating());
				workerVO.setInfrom(wvo.getInfrom());
				workerVO.setIntroduce(wvo.getIntroduce());
				workerVO.setLevels(wvo.getLevels());
				workerVO.setLikes(wvo.getLikes());
				workerVO.setStatus(wvo.getStatus());
				workerVO.setStar(wvo.getStar());
				String sqlWhere="and b.WorkerId="+wvo.getWorkerId();
				int orderNum=dao.doTotalPageCount("worker.selectOrderNumber", sqlWhere);//计算接单数
				System.out.println("number===="+orderNum);
				workerVO.setServe(String.valueOf(orderNum));
				dao.doUpdate("worker.doUpdate", workerVO);
				dao.commitTransation();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.endTransaction();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("updateWorker(WorkPageVO) - end"); //$NON-NLS-1$
		}
		
		
	}
	@Override
	public List<FeedbackPageVO> getFeedbackBywid(String workId) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getFeedbackBywid(String) - start"); //$NON-NLS-1$
		}
		String sqlWhere="";
		if(workId!=null && !"".equals(workId)){
			sqlWhere=" and a.WorkerId ="+workId.trim();
		}
		String result="";
		int totalCount = dao.doTotalPageCount("feedback.getTotalCount", sqlWhere);
		List<FeedbackPageVO> list = dao.toList("feedback.getFeedbackByAll", sqlWhere);
		for(int i=0;i<list.size();i++){
			result=list.get(i).getComments().substring(0, 10)+"......";
			list.get(i).setComments(result);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getFeedbackBywid(String) - end"); //$NON-NLS-1$
		}
		return list;
	}

}
