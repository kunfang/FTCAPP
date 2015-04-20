package com.ftc.jsonvo;

import org.apache.log4j.Logger;

public class PageVO {
	private String orderType;
	private String orderFid;
	private Integer page;
	private Integer size; // 每页数量
	private Integer pages; // 总页数
	private Integer rows; // 总条数

	// 根据行数初始化对象
	public void init(Integer rowNum) {
		rowNum = rowNum != null ? rowNum : 0;
		if (this.getSize() == null || this.getSize() <= 1) {
			this.setSize(20);
		}
		this.setRows(rowNum);
		Logger.getLogger(this.getClass()).info("-------------:" + this.getSize());
		this.setPages((int) Math.ceil((rowNum * 1.0) / this.getSize()));
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderFid() {
		return orderFid;
	}

	public void setOrderFid(String orderFid) {
		this.orderFid = orderFid;
	}

}
