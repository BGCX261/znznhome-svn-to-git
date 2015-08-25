<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'member-add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
  </head>
  
  <body>
  
  <form action="admin/member-add.action" method="post" name="memberadd" onsubmit="return check();"  >
  
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="6%">用户名：</td>
	      <td width="20%"><input name="name" type="text" id="title" style="width: 200px;">  </td>
	      <td width="74%">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >密码：</td>
	      <td ><input name="password" type="password" id="title" style="width: 200px;">  </td>
	      <td >&nbsp;</td>
	    </tr>
	    <tr>
	      <td >确认：</td>
	      <td ><input name="pwconfirm" type="password" id="title" style="width: 200px;">  </td>
	      <td >&nbsp;</td>
	    </tr>
	    <tr>
	      <td >权限：</td>
	      <td ><select name="purview" style="width: 50px;"> 
	    		<option value="0">0</option>
	    		<option value="1">1</option>
	    	</select>  </td>
	      <td >&nbsp;</td>
	    </tr>
    </table>
		<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="submit" value="添加" /> &nbsp;&nbsp;<input type="reset" value="取消" /> 
	    <input type="hidden" name="action" value="submit" />
  </form>
  </body>
</html>
