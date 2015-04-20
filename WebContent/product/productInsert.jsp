<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
   String context1 =request.getContextPath();
   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>产品新增</title>
		<script type="text/javascript">
		function saveProduct()
          {
              var prodName = document.getElementById("prodName").value;     //产品名称
              var price = document.getElementById("price").value;           //产品价格
              var storePrice = document.getElementById("storePrice").value; //产品进价
              var prodType = document.getElementById("categoryId").value;         //产品类型
              var fileType = document.getElementById("fileType").value;         //文件类型
              var startDate =  document.getElementById("beginDate").value;       //图片生效日期
              var endDate = document.getElementById("endDate").value;          //图片失效日期
              var fileStatus = document.getElementById("status").value;         //图片状态
              var timeConsume = document.getElementById("timeConsume").value;
              var timeKeep = document.getElementById("timeKeep").value;
              var productId = document.getElementById("productid").value;

              if(prodName =="" || prodName==null ){
              		alert("产品名称不能为空");
              		document.getElementById("prodName").focus();
              		return ;
              }
              else if(price == "" || price==null )
              {
              		alert("产品价格不能为空");
              		document.getElementById("price").focus();
              		return ;
              }
              
              else if(storePrice == "" || storePrice == null)
              {
              		alert("产品进价不能为空");
              		document.getElementById("storePrice").focus();
              		return;
              }
              
              else if(prodType == "" || prodType == null)
              {
              		alert("产品类型不能为空");
              		return;
              }
              else if(fileType == "" || fileType ==null)
              {
              		alert("文件类型不能为空");
              		return;
              }
              else if(startDate == "" || startDate ==null)
              {
              		alert("图片生效日期不能为空");
              		return;
              }
              else if(endDate == "" || endDate ==null)
              {
              		alert("图片失效日期不能为空");
              		return;
              }
              else if(fileStatus == "" || fileStatus ==null )
              {
              		alert("图片状态不能为空");
              		return;
              }
 			  isFloatValue(price);
 			  isFloatValue(storePrice);
 			  isFloatValue(timeConsume);
 			  isFloatValue(timeKeep);
 			  isFloatValue(price);
 			  
 			 if(productId==null || productId==""){
 	 			  document.forms.action = "<%=context1%>/productlist.do?method=toInsertProduct";
 	 			}else{
 	 			  document.forms.action = "<%=context1%>/productlist.do?method=toUpdateProduct";
 	 			  document.forms.target = "insert";
 	 			}  
 		  		
 				document.forms.submit();
        }	
          
          //文本框只能输入整数或一位小数或两位小数
		function isFloatValue(obj)
		{
			var re = /^[0-9]+(.[0-9]{0,2})?$/g;
			var num= /^[0-9]+?$/g;
			if(!num.test( obj ) && !re.test( obj )){
				alert("请输入整数或两位以内的小数");
				obj = "";
				return false;
			}
		}
		
		function backHome(){
			window.location.href="<%=context1%>/productlist.do?method=getProductbyList";
		}
		
	</script>
	</head>
	 <body style="width:100%; margin:0px; padding:0px; font-size:13px;">
  	<%@ include file="/menu.jsp" %>
  	<form:form commandName="productPageVO" method="POST" name="forms" > 
		<div class="box">
		<div class="box_top"></div>
		<div class="box_center">
		
			<input name="method" type="hidden" value="toInsertProduct"/>
			<form:hidden path="productid" />
			<form:hidden path="picture" />
			<table class="table1">
			   <div style="margin-left:80px;">				 
  		   		带红<font color=red>*</font>的为必填项 				 
		 	   </div>
				<tr>
					<td align="right">
						产品名称：
					</td>
					<td>
						<form:input path="prodName" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td align="right">
						新手礼：
					</td>
					<td>
						<form:input path="price" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						店面价：
					</td>
					<td>
						<form:input path="storePrice" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						服务人数：
					</td>
					<td>
						<form:input path="totalNum" readonly="true" cssStyle="border:none;"/>
					</td>
				</tr>
				<tr>	
					<td align="right">
				      	产品类型：
				   </td>
				   <td>
				        <form:select path="categoryId" items="${cateList}" itemValue="categoryId" itemLabel="categoryName"></form:select><font color="red">*</font>
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	耗时：
				   </td>
				   <td>
				      <form:input path="timeConsume" maxlength="50"/>&nbsp;&nbsp;
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	保持：
				   </td>
				   <td>
				      <form:input path="timeKeep" maxlength="50"/>&nbsp;&nbsp;
				   </td>
				</tr>
				<tr>
					<td align="right">
						 &nbsp; &nbsp;文件类型：
					</td>
					<td>
						<form:select path="fileType" items="${fileType}" itemValue="value" itemLabel="statusName"></form:select>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td align="right">
				      	产品生效日期：
				   </td>
				   <td>
				       <form:input path="beginDate" maxlength="50" onfocus="new WdatePicker(this,'%Y-%M-%D',true)" />&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	产品失效日期：
				   </td>
				   <td>
				       <form:input path="endDate" maxlength="50" onfocus="new WdatePicker(this,'%Y-%M-%D',true)" />&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				
				<tr>	
					<td align="right">
				      	产品状态：
				   </td>
				   <td>
				      <form:select path="status" items="${fileStatus}" itemValue="value" itemLabel="statusName"></form:select>&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>
				   <td align="right">
				      	产品上传：
				   </td>
				   <td>
				       <input type="file" name="picture" maxlength="50"/>&nbsp;&nbsp;
				   </td>
				</tr>
				<tr>	
				    
					<td align="right">
				      	产品评价：
				   </td>
				   <td>
				      <form:textarea path="comments" cols="60" rows="6" />&nbsp;&nbsp;
				   </td>
				</tr>
				<tr>
		      	 <td align="center" colspan="4"> 
		       		<input name="save" type="button" 
						class="buttonClass"
						value="保存(S)" accesskey="S" onclick="saveProduct()" />&nbsp;&nbsp;
					<input name="B3" type="button"
						class="buttonClass"
						value="返回(B)" onclick="backHome()" accesskey="B" />
		         </td>
			 </tr>
			</table>
 		</div>
			<div class="box_bottom"></div>
		</div>
		
		<iframe id="insert" name="insert" style="display: none;">
		</iframe> </form:form>
	</body>
</html>
				