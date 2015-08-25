<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>中国护理网扩展模块后台登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/admin/ht-login.css" />
  </head>
  
  <body>
  
<div class="content">
 <div class="dlcon">
 
 <form method="post" action="admin/member-login" name="uaform">
 <input type="hidden" name="issubmit" value="y"/>
 <table class="dltable" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap="nowrap">用户名：</td>
    <td colspan="2"><input class="input1" type="text" name="name" /></td>
  </tr>
   <tr>
    <td nowrap="nowrap">密&nbsp;&nbsp;码：</td>
    <td colspan="2"><input class="input1" name="password" type="password" /></td>
  </tr>
  <tr>
    <td nowrap="nowrap"></td>
    <td width="107"><input class="input2" name="" type="checkbox" value="" />记住登录状态</td>
	<td width="67"><input onclick="JavaScript:document.uaform.submit();"  class="btn" name="btn1" type="button" /></td>
  </tr>
</table>
</form>


<div class="bqsm">&nbsp;
</div>

 </div>
</div>
</body>
</html>