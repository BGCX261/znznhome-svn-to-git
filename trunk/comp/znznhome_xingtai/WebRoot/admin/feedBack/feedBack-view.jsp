<%@ page language="java" import="java.util.*, net.fckeditor.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>feedBack-modify</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
  </head>
  <body>
  
 <%
    	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	String id = request.getParameter("id");
    	FeedBackManager nm = (FeedBackManager)ctx.getBean("feedBackManager");
    	FeedBack feedBack = new FeedBack();
    	feedBack = nm.loadByID(Integer.parseInt(id));	
    	String title = feedBack.getTitle();
    	String content = feedBack.getContent();
    	String tel = feedBack.getTel();
    	String email = feedBack.getEmail();
    	String name = feedBack.getName();
    	String type = feedBack.getType();
    	String status = feedBack.getStatus() == 1 ? "通过" : "未审核";
    	
%>

	<br/><div id="tableTitle" class="tableTitle">反馈信息查看与审核</div><hr><br/>
       
 <form action="admin/feedBack-modify" method="post" id="feedBackmodifyform" name="feedBackmodifyform">
  <input name="feedBackID" value="<%=id %>" type="hidden">
  <input name="status" value="1" type="hidden">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">姓名：</td>
      <td width="20%"><input name="name" disabled="true" type="text" id="name" size="25" value="<%=name %>">  </td>
      <td width="8%">电话：</td>
      <td width="20%"><input name="tel" disabled="true" type="text" id="tel" size="25" value="<%=tel %>"> </td>
      <td width="8%">email：</td>
      <td width="20%"><input name="email" disabled="true" type="text" id="email" size="25" value="<%=email %>"> </td>
    </tr>
    <tr>
      <td width="8%">标题：</td>
      <td width="20%"><input name="title" disabled="true" type="text" id="title" size="25" value="<%=title %>">  </td>
      <td width="8%">类别：</td>
      <td width="20%"><input name="type" disabled="true" type="text" id="type" size="25" value="<%=type %>"> </td>
      <td width="8%">审核：</td>
      <td width="20%"><input name="" disabled="true" type="text" id="" size="25" value="<%=status %>"> </td>
    </tr>
    <tr>
      <td width="8%">内容：</td>
      <td width="20%" colspan="5"><textarea disabled="true" rows="5" cols="50" name="content" id="content" ><%=content %></textarea></td>

    </tr>
    
  </table>
    	<br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" value="允许显示" /> &nbsp;&nbsp;<input type="button" onclick="history.go(-1)" value="返回" /> 
	    </div>
  </form>
  </body>
</html>
