package com.ftc.service;
import java.util.List;

import com.ftc.vo.FeedbackPageVO;
import com.ftc.vo.WorkPageVO;
import com.ftc.vo.WorkerVO;

public interface WorkerService {
    public List<WorkerVO> queryListOfWorkInfo(WorkerVO wvo) throws Exception;
	
	public void deleteWorkById(WorkerVO wvo) throws Exception;
	
	public WorkPageVO queryWorkByWid(String workId,String isView) throws Exception;

	public void insertWorker(WorkPageVO wvo) throws Exception;
	
    public void updateWorker(WorkPageVO wvo) throws Exception;
    
    public List<FeedbackPageVO> getFeedbackBywid(String workId) throws Exception;
	
}
