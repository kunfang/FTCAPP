package com.ftc.vo;

import java.io.Serializable;

public class FeedbackPageVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;   //用户ID
	private String userName; //用户名
	private String workerId; //商家ID
	private String workerName; //商家名称
	private String ratStatus;  //评论状态
	private String statusName; //评论描述
	private String comments;  //评论
	private String timeStamp;     //创建时间
    private String datelastupdate; //最后更新时间	
    private String fileUrl;        //文件路径
    private String fileName;       //文件名称
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getRatStatus() {
		return ratStatus;
	}
	public void setRatStatus(String ratStatus) {
		this.ratStatus = ratStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDatelastupdate() {
		return datelastupdate;
	}
	public void setDatelastupdate(String datelastupdate) {
		this.datelastupdate = datelastupdate;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
