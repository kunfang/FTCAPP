package com.ftc.vo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class VOBase {
	public String pk;
	private String orderFid; //排序字段
	private String orderType; //排序类型:asc/desc
	
	public String getOrderFid() {
		return orderFid;
	}

	public void setOrderFid(String orderFid) {
		this.orderFid = orderFid;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
	
	public void set(String attributeName,Object value)
	{
		try{
		//this.getClass().getDeclaredField(arrtibuteName).set(this,value);
			String method = "set";
			attributeName = attributeName.substring(0,1).toUpperCase() + attributeName.substring(1);
			method = method + attributeName;   //ƴ��set������
		Object[] objs = new Object[]{value};   //set��ֵ
		
		java.lang.Class[] cls = new java.lang.Class[]{value.getClass()};  //�������� 
		this.getClass().getDeclaredMethod(method, cls).invoke(this,objs);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public Object get(String attributeName)
	{
		Object obj = null;
		try{
			//this.getClass().getDeclaredField(arrtibuteName).set(this,value);
				String method = "get";
				attributeName = attributeName.substring(0,1).toUpperCase() + attributeName.substring(1);
				method = method + attributeName;   //ƴ��set������
			 
			obj = this.getClass().getDeclaredMethod(method, null).invoke(this,null);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			return obj;
	}
}
