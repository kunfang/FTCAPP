<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
   String context1 =request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>手艺人新增</title>
		<script type="text/javascript">
		function saveProduct()
          {
              var workerName = document.getElementById("workerName").value;     //手艺人名称
              var mobile = document.getElementById("mobile").value;           //手机号码
              var specialtyRating = document.getElementById("specialtyRating").value; //专业
              var communicateRating = document.getElementById("communicateRating").value;         //沟通
              var punctualRating = document.getElementById("punctualRating").value;         //守时
              var levels =  document.getElementById("levels").value;       //职称描述
              var status = document.getElementById("status").value;          //手艺人状态
              var introduce = document.getElementById("introduce").value;         //自我评价
              var workerId = document.getElementById("workerId").value;
              var re = /^[0-9]+(.[0-9]{0,2})?$/g;
  			  var num= /^[0-9]+?$/g;

              if(workerName =="" || workerName==null ){
              		alert("手艺人名称不能为空");
              		document.getElementById("workerName").focus();
              		return ;
              }
              else if(mobile == "" || mobile==null )
              {
              		alert("手机号码不能为空");
              		document.getElementById("mobile").focus();
              		return ;
              }
              
              else if(specialtyRating == "" || specialtyRating == null)
              {
              		alert("专业评分不能为空");
              		document.getElementById("specialtyRating").focus();
              		return;
              }
              else if(!num.test(specialtyRating) && !re.test(specialtyRating)){
    				alert("请输入整数或两位以内的小数");
    				document.getElementById("specialtyRating").value="";
    				document.getElementById("specialtyRating").focus();
    				return;
              }
              
              else if(punctualRating == "" || punctualRating ==null)
              {
              		alert("守时评分不能为空");
              		document.getElementById("punctualRating").focus();
              		return;
              }
              
              else if(!num.test(punctualRating) && !re.test(punctualRating)){
  				alert("请输入整数或两位以内的小数");
  				document.getElementById("punctualRating").value="";
  				document.getElementById("punctualRating").focus();
  				return;
             }
              
              else if(communicateRating == "" || communicateRating == null)
              {
              		alert("沟通评分不能为空");
              		document.getElementById("communicateRating").focus();
              		return;
              }
              
              else if(!num.test(communicateRating) && !re.test(communicateRating)){
    				alert("请输入整数或两位以内的小数");
    				document.getElementById("communicateRating").value="";
    				document.getElementById("communicateRating").focus();
    				return;
              }
              
              else if(levels == "" || levels ==null)
              {
              		alert("职称描述不能为空");
              		return;
              }
              else if(status == "" || status ==null)
              {
              		alert("手艺人状态不能为空");
              		return;
              }
              else if(introduce == "" || introduce ==null )
              {
              		alert("自我介绍不能为空");
              		document.getElementById("introduce").focus();
              		return;
              }
 			  
 			 if(workerId==null || workerId==""){
 	 			  document.forms.action = "<%=context1%>/workerController.do?method=toInsertWorkder";
 	 			}else{
 	 			  document.forms.action = "<%=context1%>/workerController.do?method=toUpdateWorker";
 	 			  document.forms.target = "insert";
 	 			}  
 		  		
 				document.forms.submit();
        }	
          
		function backHome(){
			window.location.href="<%=context1%>/workerController.do?method=getWorkerbyList";
		}
		
	</script>
	</head>
	 <body style="width:100%; margin:0px; padding:0px; font-size:13px;">
  	<%@ include file="/menu.jsp" %>
  	<form:form commandName="workPageVO" method="POST" name="forms" > 
		<div class="box">
		<div class="box_top"></div>
		<div class="box_center">
			<input name="method" type="hidden" value="toInsertProduct"/>
			<form:hidden path="workerId" />
			
			<table class="table1">
			   <div style="margin-left:80px;">				 
  		   		带红<font color=red>*</font>的为必填项 				 
		 	   </div>
				<tr>
					<td align="right">
						手艺人名称：
					</td>
					<td>
						<form:input path="workerName" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td align="right">
						手机号码：
					</td>
					<td>
						<form:input path="mobile" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						专业：
					</td>
					<td>
						<form:input path="specialtyRating" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						守时：
					</td>
					<td>
						<form:input path="punctualRating" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td align="right">
				      	沟通：
				   </td>
				   <td>
				        <form:input path="communicateRating" maxlength="50"/>&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	籍贯：
				   </td>
				   <td>
				      <form:input path="infrom" maxlength="50"/>
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	爱好：
				   </td>
				   <td>
				      <form:input path="likes" maxlength="50"/>
				   </td>
				</tr>
				<tr>
					<td align="right">
						 星座：
					</td>
					<td>
						<form:select path="star" items="${starType}" itemValue="value" itemLabel="statusName"></form:select>
					</td>
				</tr>
				<tr>	
					<td align="right">
				      	职称描述：
				   </td>
				   <td>
				       <form:select path="levels" items="${descType}" itemValue="value" itemLabel="statusName"></form:select>&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>	
					<td align="right">
				      	手艺人状态：
				   </td>
				   <td>
				       <form:select path="status" items="${fileStatus}" itemValue="value" itemLabel="statusName"></form:select>&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				
				<tr>	
					<td align="right">
				      	自我介绍：
				   </td>
				   <td>
				      <form:textarea path="introduce" cols="45" rows="6" />&nbsp;&nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>
				   <td align="right">
				      	个人作品：
				   </td>
				   <td>
				       &nbsp;<font color="red">*</font>
				   </td>
				</tr>
				<tr>	
				    
					<td align="right">
				      	服务商圈：
				   </td>
				   <td>
				      <form:textarea path="distinctDesc" cols="45" rows="6" /><font color="red">*</font>
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
				