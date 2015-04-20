<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>产品查看</title>
	</head>
	 <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center" >
 	 <%@ include file="/menu.jsp" %>  
		<form method="POST" action="/version"  onsubmit="return subMit()" enctype="MULTIPART/FORM-DATA" >
			<input type="hidden" name="mhd" value="doUpdate" />
			<div class="box">
				<div class="box_top"></div>
				<div class="box_center" >
	    		<table class="table1" >
				<tr >
					<td align="right">产品名称：</td>
					<td>&nbsp;${productPageVO.prodName}</td>
                    <td align="right">产品类型：</td>
					<td>&nbsp;${productPageVO.categoryName}</td>
				</tr>

				<tr>
					<td align="right">新手礼：</td>
					<td>&nbsp;${productPageVO.price}</td>
					<td align="right">店面价：</td>
					<td>&nbsp;${productPageVO.storePrice}</td>
				</tr>
				
				<tr>
					<td align="right">持续：</td>
					<td>&nbsp;${productPageVO.timeConsume}</td>
					<td align="right">保持：</td>
					<td>&nbsp;${productPageVO.timeKeep}</td>
				</tr>
				
				<tr>
					<td align="right">服务人数：</td>
					<td>&nbsp;${productPageVO.totalNum}</td>
					<td align="right">产品生效日期：</td>
					<td>&nbsp;${productPageVO.beginDate}</td>
				</tr>
				
				<tr>
					<td align="right">产品失效日期：</td>
					<td>&nbsp;${productPageVO.endDate}</td>
					<td align="right">产品最后更新日期：</td>
					<td>&nbsp;${productPageVO.datelastupdate}</td>
				</tr>
				<tr>
					<td align="right">产品状态：</td>
					<td>&nbsp;${productPageVO.statusName}</td>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right">产品评价：</td>
					<td>&nbsp;${productPageVO.comments}</td>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				
				<tr>
				    <td align="right">产品展示：</td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
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
    	</form>
	</body>
</html>
