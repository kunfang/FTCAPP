<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>

<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    
    <title>日志管理</title>
    <link href="<%=path%>/css/page2.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/css/ddsmoothmenu.css" type="text/css" rel="stylesheet">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	   function changeBgColorOnMouseOut(obj) {
			obj.style.backgroundColor = '';
		}
	
		function changeBgColorOnMouseOver(obj) {
			obj.style.backgroundColor = '#cccccc';
		}
		
		function toSearch(flag){
			document.forms.submit();
		}
		
		function clean_onclick1(){
		    document.getElementById("startTime").value="";
		    document.getElementById("taskName").value="";
		}
		
	</script>
  </head>
  
  <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
		<%@ include file="/menu.jsp" %>&nbsp;
		    <div class="box">
			<div class="box_top"></div>
			<div class="box_center">	
		<form:form commandName="logServiceVO" method="post" action="webservicelist.do" name="forms">
			<input type="hidden" name="method" value="getWebServiceList" />
					<table class="table1" >
							<tr class="td1">
								<td align="right" class="mctitle">任务开始时间:</td>
								<td align="left" class="mctitle"><form:input path="startTime" maxlength="50" onfocus="new WdatePicker(this,'%Y-%M-%D',true)" />&nbsp;&nbsp;</td>
								<td align="right" class="mctitle">任务名称:</td>
								<td align="left" class="mctitle"><form:input path="taskName" maxlength="50"/>&nbsp;&nbsp;</td>
							</tr>
						</table>
						&nbsp;
					<div align="center">
						<input type="button" class="buttonClass" value="查询(F)" onclick="toSearch('search')"/>&nbsp;&nbsp;
						<input type="button" id="clean" name="clear" class="buttonClass" value="清除(C)" accesskey="c" onclick="clean_onclick1()"/>
					</div>
					<div style="width:970px; margin:0px auto;">
							<table class="table3" style="font-size:13px;">
							<tr>
								<th nowrap scope="col" height="24" >
									<div orderBy="true">任务编码</div>
								</th>
								<th scope="col" height="24" nowrap id=".truename">
									<div orderBy="true">任务名称</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">任务开始时间</div>
								</th>
								<th scope="col" height="24" nowrap id="">
									<div orderBy="true">任务结束时间</div>
								</th>
							    <th scope="col" height="24" nowrap id="">
									<div orderBy="true">是否成功</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">错误信息</div>
								</th>
							</tr>
							
							<%
								int i = 0;
								String trclass = "td2";
							%>
							<c1:forEach items="${logList}" var="logList" >
								<%
											i++;
											if (i % 2 == 0)
										trclass = "selecttr";
											else
										trclass = "";
								%>
								
								<tr
										onmouseover="javascript:changeBgColorOnMouseOver(this);"
										onmouseout="javascript:changeBgColorOnMouseOut(this);" >
									
									<td>
										&nbsp;
										  ${logList.taskId}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${logList.taskName}
									</td>
									<td height="14">
										&nbsp;
										${logList.startTime}
										&nbsp;
									</td>
									
									<td height="14">
										&nbsp;
										${logList.endTime}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										<c1:if test="${logList.isSuccess=='Y'}">成功</c1:if>
										<c1:if test="${logList.isSuccess=='N'}">失败</c1:if>
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${logList.message}
										&nbsp;
									</td>
								</tr>
							</c1:forEach>
						</table>						
					</div>
					<%@ include file="/common/pageLocation.in" %>
		      </form:form>
			</div>
			<div class="box_bottom"></div>
			</div>
	</body>
</html>
