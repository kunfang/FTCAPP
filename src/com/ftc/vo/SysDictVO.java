package com.ftc.vo;
/**
 * 数据字典表 T_SYS_DICT
 * @author lining
 *
 */
public class SysDictVO {
	private static final long serialVersionUID = 1L;
	private String dataCode; //编码	
	private String dataType; //类型
	private String dataName; //名称
	private String parCode; //上级编码
	private String vaild; // 是否有效 0：有效 1：无效
	private String outerCode; //外部代码
	private String extendCode; //扩充代码
	private String remark; //备注
	private String invaildTm; //生效时间
	private String creater; //创建者
	private String createTm; //创建时间
	private String validFlag;
	private String updater; //修改者
	private String updateTm; //修改时间
	
	
	
	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateTm() {
		return updateTm;
	}

	public void setUpdateTm(String updateTm) {
		this.updateTm = updateTm;
	}

	public String getDataCode(){
	  return dataCode;
	}

	public void  setDataCode(String dataCode){
	  this.dataCode = dataCode;
	}

	public String getDataType(){
	  return dataType;
	}

	public void  setDataType(String dataType){
	  this.dataType = dataType;
	}

	public String getDataName(){
	  return dataName;
	}

	public void  setDataName(String dataName){
	  this.dataName = dataName;
	}

	public String getParCode(){
	  return parCode;
	}

	public void  setParCode(String parCode){
	  this.parCode = parCode;
	}

	public String getVaild(){
	  return vaild;
	}

	public void  setVaild(String vaild){
	  this.vaild = vaild;
	}

	public String getOuterCode(){
	  return outerCode;
	}

	public void  setOuterCode(String outerCode){
	  this.outerCode = outerCode;
	}

	public String getExtendCode(){
	  return extendCode;
	}

	public void  setExtendCode(String extendCode){
	  this.extendCode = extendCode;
	}

	public String getRemark(){
	  return remark;
	}

	public void  setRemark(String remark){
	  this.remark = remark;
	}

	public String getInvaildTm(){
	  if(invaildTm != null && invaildTm.length()>10) return invaildTm.substring(0,10); 
	 return invaildTm;
	}

	public void  setInvaildTm(String invaildTm){
	  this.invaildTm = invaildTm;
	}

	public String getCreater(){
	  return creater;
	}

	public void  setCreater(String creater){
	  this.creater = creater;
	}

	public String getCreateTm(){
	  if(createTm != null && createTm.length()>10) return createTm.substring(0,10); 
	 return createTm;
	}

	public void  setCreateTm(String createTm){
	  this.createTm = createTm;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	

}
