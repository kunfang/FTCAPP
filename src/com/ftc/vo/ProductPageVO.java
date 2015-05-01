package com.ftc.vo;

import java.util.Date;

public class ProductPageVO {
	private static final long serialVersionUID = 1L;
	private String productid;		//产品ID
	private String prodName;		//产品名称
	private String price;		//新手礼
	private String storePrice;		//店面价
	private String categoryId;		//产品种类ID   
	private String picture;		//产品图片ID
	private String timeConsume;		//持续时间
	private String timeKeep;		//保持时间
	private String comments;    //产品备注
	private String fileType;    //文件类型
	private String filetypeName; //产品类型描述
	private String categoryName; //产品类型
	private String beginDate;       //产品生效日期
	private String endDate;         //产品失效日期
	private String createdate;      //产品创建日期
	private String status;           //产品状态
	private String statusName;    //产品件状态描述
	private String datelastupdate;  //最后更新日期
	private String totalNum;     //使用人数
	
	private String fileUrl; // 图片文件路径
	
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFiletypeName() {
		return filetypeName;
	}
	public void setFiletypeName(String filetypeName) {
		this.filetypeName = filetypeName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getDatelastupdate() {
		return datelastupdate;
	}
	public void setDatelastupdate(String datelastupdate) {
		this.datelastupdate = datelastupdate;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

}
