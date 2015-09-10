package com.ftc.vo;


public class ProductVO {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private String productid;		  //产品ID
	private String prodName;	  //产品名称
	private String price;		  //产品价格
	private String storePrice;	  //产品进价
	private String categoryId;		  //产品种类ID   
	private String picture;		  //产品图片ID
	private String timeConsume;	  //持续时间
	private String timeKeep;	  //保持时间
	private String comments;      //产品备注
	
	private String workerid;
	
	
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStorePrice() {
		return storePrice;
	}
	public void setStorePrice(String storePrice) {
		this.storePrice = storePrice;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTimeConsume() {
		return timeConsume;
	}
	public void setTimeConsume(String timeConsume) {
		this.timeConsume = timeConsume;
	}
	public String getTimeKeep() {
		return timeKeep;
	}
	public void setTimeKeep(String timeKeep) {
		this.timeKeep = timeKeep;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
