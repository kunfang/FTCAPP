package com.ftc.vo;

public class MobileLogVO {
	private static final long serialVersionUID = 1L;
	private String logid;  //接口日志id         
	private String reqEmp; //发送人         
	private String reqDpt; //发送机构        
	private String reqTm;  //发送时间         
	private String reqContext; //发送报文     
	private String successFlag; //成功标示（0为否，1为是）     
	private String resContext; //返回内容    
	private String tel; //手机号          
	private String insertCde;//被保人身份证号         
	private String specificType;//具体的接口类型  
	private String transactionType;//发送接口类型       
	private String createTm;  //创建时间      
	private String createCde; //创建人   
	private String updateTm;  //修改时间      
	private String updateCde; //修改人
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getReqEmp() {
		return reqEmp;
	}
	public void setReqEmp(String reqEmp) {
		this.reqEmp = reqEmp;
	}
	public String getReqDpt() {
		return reqDpt;
	}
	public void setReqDpt(String reqDpt) {
		this.reqDpt = reqDpt;
	}
	public String getReqTm() {
		return reqTm;
	}
	public void setReqTm(String reqTm) {
		this.reqTm = reqTm;
	}
	public String getReqContext() {
		return reqContext;
	}
	public void setReqContext(String reqContext) {
		this.reqContext = reqContext;
	}
	public String getSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}
	public String getResContext() {
		return resContext;
	}
	public void setResContext(String resContext) {
		this.resContext = resContext;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInsertCde() {
		return insertCde;
	}
	public void setInsertCde(String insertCde) {
		this.insertCde = insertCde;
	}
	public String getSpecificType() {
		return specificType;
	}
	public void setSpecificType(String specificType) {
		this.specificType = specificType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getCreateCde() {
		return createCde;
	}
	public void setCreateCde(String createCde) {
		this.createCde = createCde;
	}
	public String getUpdateTm() {
		return updateTm;
	}
	public void setUpdateTm(String updateTm) {
		this.updateTm = updateTm;
	}
	public String getUpdateCde() {
		return updateCde;
	}
	public void setUpdateCde(String updateCde) {
		this.updateCde = updateCde;
	}
}
