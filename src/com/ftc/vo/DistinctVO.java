package com.ftc.vo;

public class DistinctVO {
	private static final long serialVersionUID = 1L;
	private String workerId;    //商家ID
	private String districtId;  //商圈ID
	private String districtName; //商圈名称
	private String districtNameEn;//商圈英文名称 

	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictNameEn() {
		return districtNameEn;
	}
	public void setDistrictNameEn(String districtNameEn) {
		this.districtNameEn = districtNameEn;
	}
	
	
}
