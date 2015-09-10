package com.ftc.vo;

import java.io.Serializable;
public class LogServiceVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logId;     //日志ID
	private String taskId;    //任务ID
	private String taskName;  //任务名称
	private String startTime;  //任务开始时间
	private String endTime;    //任务结束时间
	private String message;    //错误信息
	private String isSuccess;  //是否成功
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}
