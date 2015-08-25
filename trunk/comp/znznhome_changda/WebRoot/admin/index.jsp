<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="util/check.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>鸿屹集团后台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<frameset rows="140,*,8" frameborder="no" border="0" framespacing="0">
  <frame src="admin/top.html" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frameset id="attachucp" framespacing="0" border="0" frameborder="no" cols="147,10,*" rows="*">
<frame scrolling="no" noresize="no" frameborder="no" name="leftFrame" src="admin/left.html">
<frame id="leftbar" scrolling="no" noresize="" name="switchFrame" src="admin/swich.html">
<frame scrolling="yes" noresize="" border="0" name="mainFrame" src="admin/welcome.html">
</frameset>
  <frame src="admin/down.html" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes><body>
</body>
</noframes></html>
