<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page buffer="10kb"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <%  
 	String context =request.getContextPath(); 
 	String loginErrInfo = (String)request.getSession().getAttribute("loginErrInfo");
 	if (loginErrInfo == null || loginErrInfo.length() == 0)
 		loginErrInfo = "";
 %>  
 <HEAD>
 <TITLE>后台管理系统</TITLE>
   <meta http-equiv=Content-Type content="text/html; charset=utf-8"/>
   <meta content="MSHTML 6.00.2800.1400" name=GENERATOR/>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
}
.STYLE1 {
	color: #000000;
	font-size: 14px;
}
-->
</style>
</HEAD>
<body onload="getFocus()" >
<form method="post" action="menuList.do" name="forms" onsubmit="return login()">
 <table width="1024" height="100%" align="center" border="0" cellPadding="0" cellSpacing="0" background="<%=context%>/images/login.png" style="background-repeat:no-repeat;">
	<tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="235" background="images/login_03.gif">&nbsp;
        <input type="hidden" name="method" value="getAssessSysMenubyList"/></td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="394" height="53" background="images/login_05.gif">&nbsp;</td>
            <td width="206" background="images/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="16%" height="25"><div align="right"><span class="STYLE1">用户:</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text" id="username" name="username" style="width:105px; height:17px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:14px; color:#292929">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">密码:</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" id="password" name="password" style="width:105px; height:17px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:14px; color:#292929"/>
                </div></td>
                <td height="25"><div align="left"><input name="Submit2" type="submit"  class="button_sys" style="width:60;height:25" value="登录"/> </div></td>
              </tr>
            </table></td>
            <td width="362" background="images/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="213" background="images/login_08.gif"><center><font color=red><%=loginErrInfo %></font></center>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
	
 </table>

	<script type="text/javascript">
		function getFocus(){
			document.getElementById("username").focus();
		 }
		function login(){
		    var name = document.getElementById("username").value.replace(/(^\s*)|(\s*$)/g, "");
			if(name == ""){
		     	alert("请输入用户名称!");
		     	document.getElementById("username").focus();
		     	return false;
			}
			
		    var password = document.getElementById("password").value.replace(/(^\s*)|(\s*$)/g, "");
			if(password == ""){
		     	alert("请输入用户密码!");
		     	document.getElementById("password").focus();
		     	return false;
		     	
			}
		    /*var inputValidateCode = document.forms[0].validateCode.value.replace(/(^\s*)|(\s*$)/g, "");
			if(inputValidateCode == ""){
		     	alert("请输入验证码!");
			  	document.getElementsByName("validateCode")[0].focus();
		     	return false;
			}*/
		}
		
		function refresh1(obj){
				nowTime = new Date();
		    	obj.src="<%=context%>/getpicservlet?validSession=1&r="+nowTime;
		    }
</script>
</form>
</body>


</html>