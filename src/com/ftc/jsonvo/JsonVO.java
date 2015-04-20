package com.ftc.jsonvo;

import java.util.List;
import java.util.Map;

public class JsonVO  {
	HeadVO head = new HeadVO();
	PageVO page ;
	ResultVO result;
	DataVO data;
	List list;
	Map map;
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public DataVO getData() {
		return data;
	}
	public void setData(DataVO data) {
		this.data = data;
	}
	//List list;
	public HeadVO getHead() {
		return head;
	}
	public void setHead(HeadVO head) {
		this.head = head;
	}
	public PageVO getPage() {
		return page;
	}
	public void setPage(PageVO page) {
		this.page = page;
	}
	
	public ResultVO getResult() {
		return result;
	}
	public void setResult(ResultVO result) {
		this.result = result;
	}
	
}
