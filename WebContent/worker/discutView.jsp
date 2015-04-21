<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>手艺人评论查看</title>
	</head>
	 <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center" >
 	 <%@ include file="/menu.jsp" %>  
		<form:form commandName="feedbackPageVO"  method="POST" action="/version"  onsubmit="return subMit()" enctype="MULTIPART/FORM-DATA" >
			<input type="hidden" name="method" value="toViewDiscu" />
			<div class="box">
				<div class="box_top"></div>
				<div class="box_center" >
	    		<table class="table1" >
				<tr >
					<td align="right">用户名称：</td>
					<td>&nbsp;${feedbackPageVO.userName}</td>
				</tr>
				<tr>
				    <td align="right">手艺人名称：</td>
					<td>&nbsp;${feedbackPageVO.workerName}</td>
				</tr>

				<tr>
					<td align="right">好/中/差评：</td>
					<td>&nbsp;${feedbackPageVO.statusName}</td>
				</tr>
				<tr>
				    <td align="right">评价时间：</td>
					<td>&nbsp;${feedbackPageVO.timeStamp}</td>
				</tr>
				
			    <tr>
					<td align="right">评论内容：</td>
					<td >&nbsp;
					<form:textarea path="comments" cols="45" rows="6" readonly="true"/></td>
				</tr>
				
				<tr>
		      	 <td align="center" colspan="4"> 
						<input name="B3" type="button"
							class="buttonClass"
							value="返回(B)" onclick="history.back()" accesskey="B" />
		         </td>
			 </tr>
			</table>&nbsp;
		   </div>
			<div class="box_bottom"></div>
			</div>
    	</form:form>
	</body>
</html>
