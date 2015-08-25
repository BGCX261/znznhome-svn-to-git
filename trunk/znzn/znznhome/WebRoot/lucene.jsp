<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lucene.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <form action="create-index" method="post">
    <input type="hidden" name="indexBean" value="url"/>
    <input type="submit" name="submit"/>
    </form>
    
    <form action="search-index" method="get">
    <input type="hidden" name="indexBean" value="url"/>
    <input type="hidden" name="action_search" value="action_search"/>
    <input type="text" name="query"/>
    <input type="submit" name="submit"/>
    </form>
  </body>
</html>
