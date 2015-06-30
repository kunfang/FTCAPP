package com.ftc.foundation.view;

import java.util.HashMap;
import java.util.List;

public class PageUtil {
	private static final long serialVersionUID = 1L;
	private int totalPage; //总页数
	private int curPage;	//当前页
	private int totalCount;	//总条数
	private int pageSize = 3;	//每页多少条 ,默认12条
	
	public HashMap<String, Integer> getPageList(int curPage, int totalCount, int pageSize){
		
		if (curPage==0 && totalCount>0) {
			this.curPage = 1;
		}else {
			this.curPage = curPage;
		}
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("totalPage", (int)Math.ceil((double)totalCount/(double)pageSize));
		hMap.put("curPage", this.curPage);
		hMap.put("totalCount", totalCount);
		hMap.put("pageSize", pageSize);
		
		return hMap;
	} 
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	public PageUtil() {
		super();
	}


	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	}
