package com.ftc.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.dao.DefaultDAO;
import com.ftc.foundation.view.PageUtil;
import com.ftc.service.LogService;
import com.ftc.vo.LogServiceVO;

@Service("logService") 
public class LogServiceImpl implements LogService {
	private static final Logger logger = Logger.getLogger(LogServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<LogServiceVO> getLogListByAll(LogServiceVO logServiceVO,PageUtil pUtil) throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("getLogListByAll(LogServiceVO cfg) - start"); //$NON-NLS-1$
		}
		
		String sqlWhere="";
		if(logServiceVO.getTaskName()!=null && !"".equals(logServiceVO.getTaskName())){
			sqlWhere=" and s.taskname like '%"+logServiceVO.getTaskName().trim()+"%'";
		}
		if(logServiceVO.getStartTime()!=null && !"".equals(logServiceVO.getStartTime()) ){
			sqlWhere +=" and s.startime >= str_to_date('" +logServiceVO.getStartTime()+"','%Y-%m-%d')"
					+ " and s.startime < str_to_date('" +logServiceVO.getStartTime()+"','%Y-%m-%d')+1";
		}
		
		int totalCount = this.getLogCounts(logServiceVO);
		
		//int totalCount = dao.doTotalPageCount("logService.getTotalCount", logServiceVO);
		//List<LogServiceVO> list = dao.toList("logService.getLogServiceData", logServiceVO);
		
		sqlWhere += "  limit "+(pUtil.getCurPage()-1)+","+pUtil.getPageSize();
		
		List<LogServiceVO> list = dao.toList("logService.getLogServiceData", sqlWhere);
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				 if(list.get(i).getStartTime()!=null && !"".equals(list.get(i).getStartTime())){
					 list.get(i).setStartTime(list.get(i).getStartTime().substring(0, list.get(i).getStartTime().length()-2));
				 }
				 if(list.get(i).getEndTime()!=null && !"".equals(list.get(i).getEndTime())){
					 list.get(i).setEndTime(list.get(i).getEndTime().substring(0, list.get(i).getEndTime().length()-2));
				 }
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getLogListByAll(LogServiceVO cfg) - end"); //$NON-NLS-1$
		}
		return list;
	}
	@Override
	public int getLogCounts(LogServiceVO logServiceVO) throws Exception {
		// TODO Auto-generated method stub
				if (logger.isDebugEnabled()) {
					logger.debug("getLogCounts(LogServiceVO logServiceVO) - start"); //$NON-NLS-1$
				}		
				
				String sqlWhere="";
				if(logServiceVO.getTaskName()!=null && !"".equals(logServiceVO.getTaskName())){
					sqlWhere=" and taskname like '%"+logServiceVO.getTaskName().trim()+"%'";
				}
				if(logServiceVO.getStartTime()!=null && !"".equals(logServiceVO.getStartTime()) ){
					sqlWhere +=" and startime >= str_to_date('" +logServiceVO.getStartTime()+"','%Y-%m-%d')"
							+ " and startime < str_to_date('" +logServiceVO.getStartTime()+"','%Y-%m-%d')+1";
				}
				
				int totalCount = dao.doTotalPageCount("logService.getTotalCount", sqlWhere);
				
				if (logger.isDebugEnabled()) {
					logger.debug("getLogCounts(LogServiceVO logServiceVO) - end"); //$NON-NLS-1$
				}
				return totalCount;
	}

}
