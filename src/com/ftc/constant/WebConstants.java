package com.ftc.constant;
/**
 *@author     [RoseJiang]
 *@version     [1.0]
 *@createdate  [2015-04-09]
 *@since       [定义常量信息]
 *@description  [定义常量信息]
 */
public final class WebConstants {
//	public static String title = "title";
	public final static String SYSTEM_PARAMETER="systemParam";
	public final static String ORG_LIST="orgList";  

	public final static String USER_INFO="userInfo";		//用户信息
	public final static String TASKALERTTIME = "taskalerttime";  //新任务提示信息上次刷新时间

	public static final String EXCEPTION_KEY = "ESTAR_VIDEO_SYSTEM_EXCEPTION";

	
	public final static String SPECIFI_TYPE_LOGIN ="0010001"; //登录接口
	public final static String SPECIFI_TYPE_UPDATEPWD ="0010002"; //修改密码接口
	public final static String SPECIFI_TYPE_GETCUSTOMERLIST="0010003"; //查询客户接口
	public final static String SPECIFI_TYPE_UPDATECUTOMERINFO ="0010004"; //修改客户信息接口
	public final static String SPECIFI_TYPE_INSERTCUTTOMERiNFO ="0010005"; //新增客户接口
	public final static String SPECIFI_TYPE_GETAREA ="0010006"; //获取地区接口
	public final static String SPECIFI_TYPE_GETALLMAKER="0010007"; //获取所有厂商接口
	public final static String SPECIFI_TYPE_GETBRAND="0010008"; //获取车辆品牌接口
	public final static String SPECIFI_TYPE_GETVHNAME="0010009"; //获取车款接口
	public final static String SPECIFI_TYPE_GETDISPLACEMENT ="0010010"; //获取排气量接口
	public final static String SPECIFI_TYPE_GETTRANSMISSIONTYPE ="0010011"; //获取排挡接口
	public final static String SPECIFI_TYPE_GETVHLREMARK="0010012"; //获取配置型号接口
	public final static String SPECIFI_TYPE_GETPRODUCT ="0010013"; //获取套餐接口
	public final static String SPECIFI_TYPE_GETRENEWAL ="0010014"; //续保查询接口
	public final static String SPECIFI_TYPE_GETPREMUIMSALI ="0010015"; //获取交强险和车船税报价接口
	public final static String SPECIFI_TYPE_GETPREMUIM="0010016"; //获取商业险报价接口
	public final static String SPECIFI_TYPE_TOORDER ="0010017"; //提交订单接口
	public final static String SPECIFI_TYPE_GETPLYORCLAIMLIST ="0010018"; //查询用户保单或赔案列表信息接口
	public final static String SPECIFI_TYPE_GETPLYORCLAIMDETAL ="0010019"; //查询用户保单或赔案详细信息接口
	public final static String SPECIFI_TYPE_TOFINDTHEPASSWORD ="0010020"; //发送验证码
	public final static String SPECIFI_TYPE_UPDATEPASSWORD="0010021"; //手机端修改密码
	public final static String SPECIFI_TYPE_FINDDEPT ="0010022"; //查询分公司
	public final static String SPECIFI_TYPE_QUERYDETAIL ="0010023"; //保单详细接口
	public final static String SPECIFI_TYPE_QUERYCAR ="0010024"; //车险理赔接口
	public final static String SPECIFI_TYPE_QUERYNOCAR="0010025"; //非车理赔接口
	public final static String SPECIFI_TYPE_GETCATEGORY ="0010026"; //词条类别接口
	public final static String SPECIFI_TYPE_GETENTRY ="0010027"; //根据词条类别代码获取此类别词条下的词条信息
	public final static String SPECIFI_TYPE_GETENTRYINFO ="0010028"; //词条详细信息获取
	public final static String SPECIFI_TYPE_SEARCHENTRY="0010029"; //词条搜索
	 
	
	
	public final static String TRANSACTION_TYPE_OUTER ="0020001"; //外部接口
	public final static String TRANSACTION_TYPE_MOBILE ="0020002"; //手机接口
	
	
	public final static String SPECIFI_TYPE_LIBRARY="0040001"; //保费计算
	public final static String SPECIFI_TYPE_UP="0040002"; //保费提交
}
