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
    
    <title>手艺人管理</title>
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
		
		//跳到增加页面
		function toInserts() {
			document.forms.action = "<%=path%>/workerController.do?method=toInsertWorkder";
			document.forms.submit();
		}
		
		
		//跳到查看页面
		function toView(infoId) {
		
			document.forms.action = "<%=path%>/workerController.do?method=toView&workerId="+infoId;
			document.forms.submit();
		}
		
		function clean_onclick1(){
		    document.getElementById("workerName").value="";
		    document.getElementById("mobile").value="";
		    document.getElementById("workerName").focus();
		}
		
		function doDelete(fids) {
	
			if (confirm("确定要删除该手艺人吗？") == false) {
				return false;
			}
		    document.forms.action = "<%=path%>/workerController.do?method=toWorkDelete&workerId=" + fids;
			document.forms.submit();
		}
	
	</script>
  </head>
  
  <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
		<%@ include file="/menu.jsp" %>&nbsp;
		    <div class="box">
			<div class="box_top"></div>
			<div class="box_center">	
		<form:form commandName="workerVO" method="post" action="workerController.do" name="forms">
			<input type="hidden" name="method" value="getWorkerbyList" />
					<table class="table1" width="80%">
							<tr class="td1">
								<td align="right" class="mctitle">手艺人名称:</td>
								<td align="left" class="mctitle"><form:input path="workerName"/></td>
								<td align="right" class="mctitle">手机号码:</td>
								<td align="left" class="mctitle"><form:input path="mobile"/></td>
							</tr>
						</table>
						&nbsp;
					<div align="center">
						<input type="button" class="buttonClass" value="查询(F)" onclick="toSearch('search')"/>&nbsp;&nbsp;
						<input type="button" class="buttonClass" value="新增(A)" onclick="toInserts()" />&nbsp;&nbsp;
						<input type="button" id="clean" name="clear" class="buttonClass" value="清除(C)" accesskey="c" onclick="clean_onclick1()"/>
					</div>
					<div style="width:970px; margin:0px auto;">
					
							<table class="table3" style="font-size:13px;">
							<tr>
								<th nowrap scope="col" height="24" >
									<div orderBy="true">手艺人名称</div>
								</th>
								<th scope="col" height="24" nowrap id=".truename">
									<div orderBy="true">手机号</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">接单数</div>
								</th>
								<th scope="col" height="24" nowrap id="">
									<div orderBy="true">专业评分</div>
								</th>
							    <th scope="col" height="24" nowrap id="">
									<div orderBy="true">沟通评分</div>
								</th>
								
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">守时评分</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">籍贯</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">职称描述</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">是否有效</div>
								</th>
								<th scope="col" height="24" nowrap>
									<div orderBy="true">操作</div>
								</th>
							</tr>
							
							<%
								int i = 0;
								String trclass = "td2";
							%>
							<c1:forEach items="${workerList}" var="workerList" >
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
										  ${workerList.workerName}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.mobile}
									</td>
									<td height="14">
										&nbsp;
										${workerList.serve}
										&nbsp;
									</td>
									
									<td height="14">
										&nbsp;
										${workerList.specialtyRating}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.communicateRating}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.punctualRating}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.infrom}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.levelsDesc}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${workerList.statusname}
										&nbsp;
									</td>
									<td height="14">
									    <a href="javascript:toView(${workerList.workerId});">查看</a>
									    &nbsp;
										<a href="<%=path%>/workerController.do?method=selectWorkForUpdate&workerId=${workerList.workerId}">修改</a>
                                        &nbsp;
										<a href="javascript:doDelete(${workerList.workerId});">删除</a>
										&nbsp;
										<a href="<%=path%>/workerController.do?method=toViewDiscu&workerId=${workerList.workerId}">评论</a>
									</td>
								</tr>
							</c1:forEach>
						</table>
					</div>
		      </form:form>
			</div>
			<div class="box_bottom"></div>
			</div>
	</body>
</html>
