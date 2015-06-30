package com.ftc.service;
import java.util.List;

import com.ftc.foundation.view.PageUtil;
import com.ftc.vo.LogServiceVO;
import com.ftc.vo.ProductVO;
public interface LogService {
	
	public List<LogServiceVO> getLogListByAll(LogServiceVO logServiceVO,PageUtil pUtil) throws Exception;
	public int getLogCounts(LogServiceVO logServiceVO) throws Exception;
}
