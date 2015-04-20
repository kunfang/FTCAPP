package com.ftc.vo;

import java.util.Date;

public class FileVO {
	private static final long serialVersionUID = 1L;
	private String fileId;  //文件ID
	private String fileType; //文件类型
	private String fileName; //文件名称
	private String fileUrl; //文件路径
	private String size;    //文件大小
	private String beginDate; // 文件生效日期
	private String endDate;   //文件失效日期
	private String createDate; //文件创建日期
	private String status;  //文件状态
	private String datelastupdate; //最后更新日期
	
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDatelastupdate() {
		return datelastupdate;
	}
	public void setDatelastupdate(String datelastupdate) {
		this.datelastupdate = datelastupdate;
	}
	
}
