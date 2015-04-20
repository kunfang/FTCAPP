<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>手艺人查看</title>
	</head>
	 <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center" >
 	 <%@ include file="/menu.jsp" %>  
		<form:form commandName="workPageVO"  method="POST" action="/version"  onsubmit="return subMit()" enctype="MULTIPART/FORM-DATA" >
			<input type="hidden" name="mhd" value="doUpdate" />
			<div class="box">
				<div class="box_top"></div>
				<div class="box_center" >
	    		<table class="table1" >
				<tr >
					<td align="right">手艺人名称：</td>
					<td>&nbsp;${workPageVO.workerName}</td>
				</tr>
				<tr>
				    <td align="right">手机号码：</td>
					<td>&nbsp;${workPageVO.mobile}</td>
				</tr>

				<tr>
					<td align="right">均价：</td>
					<td>&nbsp;${workPageVO.total}</td>
				</tr>
				<tr>
				    <td align="right">星级评价：</td>
					<td>&nbsp;<font color="red" size="4">****</font></td>
				</tr>
				
				<tr>
					<td align="right">专业：</td>
					<td>&nbsp;${workPageVO.specialtyRating}</td>
				</tr>
				<tr>
				    <td align="right">沟通：</td>
					<td>&nbsp;${workPageVO.communicateRating}</td>
				</tr>
				
				<tr>
					<td align="right">守时：</td>
					<td>&nbsp;${workPageVO.punctualRating}</td>
				</tr>
				<tr>
				    <td align="right">接单数：</td>
					<td>&nbsp;${workPageVO.serve}</td>
				</tr>
				
				<tr>
					<td align="right">籍贯：</td>
					<td>&nbsp;${workPageVO.infrom}</td>
				</tr>
				<tr>
				    <td align="right">爱好：</td>
					<td>&nbsp;${workPageVO.likes}</td>
				</tr>
				<tr>
					<td align="right">星座：</td>
					<td>&nbsp;${workPageVO.starDesc}</td>
				</tr>
				<tr>
				    <td align="right">职称描述：</td>
					<td>&nbsp;${workPageVO.levelsDesc}</td>
				</tr>
				
				<tr>
					<td align="right">手艺人状态：</td>
					<td>&nbsp;${workPageVO.statusname}</td>
				</tr>
			    <tr>
					<td align="right">自我评价：</td>
					<td >&nbsp;
					<form:textarea path="introduce" cols="45" rows="6" readonly="true"/></td>
				</tr>
				<tr>
				    <td align="right">服务商圈：</td>
					<td>&nbsp;${workPageVO.distinctDesc}</td>
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
