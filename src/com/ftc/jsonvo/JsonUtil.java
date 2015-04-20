package com.ftc.jsonvo;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
public class JsonUtil {

	public Pagination getPagination(PageVO page)
	{
		Pagination pagination = new Pagination(page.getRows());
		pagination.setCurrentPage(page.getPage() != null ? page.getPage() : 1);
		pagination.setOrderByFields(page.getOrderFid());
		pagination.setOrderType(page.getOrderType());
		pagination.setRowsPerPage(page.getSize() != null ? page.getSize() : 10);
		return pagination;
	}
	
	
	/**
	 * 将json字符串转成JsonVO，关键是data要重新处理，否则得不到数据
	 * @param jsonString
	 * @param dataClass  data对应的类
	 * @return
	 * @throws Exception
	 */
	public JsonVO getJsonVOFromString( String jsonString,Class dataClass,Class listClass,String listNote)  throws Exception
	{
		JSONObject json = new JSONObject();
		new JSONObject();
		json = JSONObject.fromObject(jsonString);  //将xml转成json
		   
		return this.getJsonVOFromJson(json, dataClass,listClass,listNote);
	}
	
	public JsonVO getJsonVOFromString( String jsonString,Class dataClass,Class listClass)  throws Exception
	{
		return this.getJsonVOFromString(jsonString,dataClass,listClass,null);
	}
	
	public JsonVO getJsonVOFromString( String jsonString,Class dataClass)  throws Exception
	{
		return this.getJsonVOFromString(jsonString, dataClass, null);
	}
	public JsonVO getJsonVOFromJson( JSONObject json,Class dataClass,Class listClass,String listNote)  throws Exception
	{
		ResultVO rst = (ResultVO)JSONObject.toBean(json.getJSONObject("result"),ResultVO.class);
		DataVO dataVO = new DataVO();
		if(rst == null || !"0".equals(rst.getCode()))  //返回错误
		{
			if(dataClass != null)
				dataVO = (DataVO)JSONObject.toBean(json.getJSONObject("data"), dataClass);
		}
		json.remove("data");  //因为datavo没有定义任何属性，必须去除
		JsonVO jsVO = null;
		if(listClass != null)
		{
			Map<String, Class> classMap = new HashMap<String, Class>();   
			classMap.put(listNote, listClass);
			jsVO = (JsonVO)JSONObject.toBean(json, JsonVO.class,classMap);
		}
		else
		{
			jsVO = (JsonVO)JSONObject.toBean(json, JsonVO.class);
		}
		jsVO.setData(dataVO);
		//转成vo
		return jsVO;
	}
	
	/**
	 * 包含list的对象装换
	 * @param json json对象
	 * @param dataClass data对象对应的实体类
	 * @param map list对应的VO map
	 * @return
	 */
	public JsonVO getJsonVOFromJson(JSONObject json,Class dataClass,Map<String, Class> map)
	{
		//判断返回的结果
		JsonVO jsonvo = new JsonVO();
		ResultVO result = (ResultVO)JSONObject.toBean(json.getJSONObject("result"),ResultVO.class);
		DataVO dataVO = new DataVO();
		if(result == null || !"0".equals(result.getCode()))  //返回成功 
		{
			if(map!=null) //vo中包含list
			{
				dataVO = (DataVO)JSONObject.toBean(json.getJSONObject("data"), dataClass,map);
			}else
			{
				dataVO = (DataVO)JSONObject.toBean(json.getJSONObject("data"), dataClass);
			}
		}
		json.remove("data");
		jsonvo = (JsonVO) JSONObject.toBean(json,JsonVO.class);
		
		jsonvo.setData(dataVO);
		return jsonvo;
	}
	
	/*
	public JsonVO getJsonVOFromJson( JSONObject json,Class dataClass,Class listClass)  throws Exception
	{
		return this.getJsonVOFromJson(json, dataClass,listClass,"list");
	}*/
	public JsonVO getJsonVOFromJson( JSONObject json,Class dataClass)  throws Exception
	{
		return this.getJsonVOFromJson(json, dataClass, null);
	}
	

}
