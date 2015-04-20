package com.ftc.vo;

public class CategoryVO {
	private static final long serialVersionUID = 1L;
	private int categoryId;  //类型ID
	private String categoryName; //类型名称
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
