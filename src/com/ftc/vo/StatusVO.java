package com.ftc.vo;

public class StatusVO {
	private static final long serialVersionUID = 1L;
	private String value;      //状态ID
	private String statusName; //状态名称
	private String category;   //状态类型
	private String comments;   //备注
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
