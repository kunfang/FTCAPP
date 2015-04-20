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
    
    <title>产品管理</title>
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
			document.forms.action = "<%=path%>/productlist.do?method=toInsertProduct&isflag=Y";
			document.forms.submit();
		}
		
		
		//跳到查看页面
		function toView(infoId) {
		
			document.forms.action = "<%=path%>/productlist.do?method=toView&productid="+infoId;
			document.forms.submit();
		}
		
		function clean_onclick1(){
		    document.getElementById("prodName").value="";
		    document.getElementById("prodName").focus();
		}
		
		function doDelete(fids) {
	
			if (confirm("确定要删除该产品吗？") == false) {
				return false;
			}
		    document.forms.action = "<%=path%>/productlist.do?method=toprodDelete&productid=" + fids;
			document.forms.submit();
		}
	
	</script>
  </head>
  
  <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
		<%@ include file="/menu.jsp" %>&nbsp;
		    <div class="box">
			<div class="box_top"></div>
			<div class="box_center">	
		<form:form commandName="productVO" method="post" action="productlist.do" name="forms">
			<input type="hidden" name="method" value="getProductbyList" />
					<table class="table1" >
							<tr class="td1">
								<td align="right" class="mctitle">产品类型:</td>
								<td align="left" class="mctitle"><form:select path="categoryId" items="${cateList}" itemValue="categoryId" itemLabel="categoryName" /></td>
								<td align="right" class="mctitle">产品名称:</td>
								<td align="left" class="mctitle"><form:input path="prodName"/></td>
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
									<div orderBy="true">产品名称</div>
								</th>
								<th scope="col" height="24" nowrap id=".truename">
									<div orderBy="true">产品类型</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">新手礼</div>
								</th>
								<th scope="col" height="24" nowrap id="">
									<div orderBy="true">店面价</div>
								</th>
							    <th scope="col" height="24" nowrap id="">
									<div orderBy="true">服务人数</div>
								</th>
								
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">耗时</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">保持</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">产品评价</div>
								</th>
								<th scope="col" height="24" nowrap>
									<div orderBy="true">操作</div>
								</th>
							</tr>
							
							<%
								int i = 0;
								String trclass = "td2";
							%>
							<c1:forEach items="${prodList}" var="prodList" >
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
										  ${prodList.prodName}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${prodList.categoryName}
									</td>
									<td height="14">
										&nbsp;
										${prodList.price}
										&nbsp;
									</td>
									
									<td height="14">
										&nbsp;
										${prodList.storePrice}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${prodList.totalNum}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${prodList.timeConsume}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${prodList.timeKeep}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${prodList.comments}
										&nbsp;
									</td>
									<td height="14">
									    &nbsp;
									    <a href="javascript:toView(${prodList.productid});">查看</a>
									    &nbsp;
										<a href="<%=path%>/productlist.do?method=selectProductForUpdate&productid=${prodList.productid}">修改</a>
                                        &nbsp;
										<a href="javascript:doDelete(${prodList.productid});">删除</a>
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
