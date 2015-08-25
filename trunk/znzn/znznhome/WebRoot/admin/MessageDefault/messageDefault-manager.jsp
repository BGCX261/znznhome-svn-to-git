<%@ page language="java" import="java.util.*, net.fckeditor.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%//@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usermg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">

  </head>
  
  <body>&nbsp; 
  默认格式信息列表：<br>
  <hr/>
  
  <%
  Page messageDefault_page = (Page)request.getAttribute("page");
  String sql = messageDefault_page.getSql();
  String sql_count = messageDefault_page.getSql_count();
  //int startNo = messageDefault_page.getStartNo();
  int pageSize = messageDefault_page.getPageSize();
  //int totalRecords = messageDefault_page.getTotalRecords();
  int pageNo = messageDefault_page.getPageNo();
  int totalPages = messageDefault_page.getTotalPages();
  %>
  <form action="admin/messageDefault-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="name">名称</option>
		    	 	<option value="content">内容 </option>
		    	 	<option value="categoryid">分类ID </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">主题</td>    
    <td width="12%">内容</td>    
    <td width="16%">推荐</td>    
    <td width="30%">验证</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<MessageDefault> list = messageDefault_page.getList();

   	if(list != null) {
  	    for(Iterator<MessageDefault> it = list.iterator(); it.hasNext();) {
  	    	MessageDefault messageDefault = it.next();
  	    	int id = messageDefault.getId();
	  	  	int categoryid = messageDefault.getCategoryid();
	  		String name = messageDefault.getName();
	  		String content = messageDefault.getContent();
	  		String other = messageDefault.getOther();
%>

  <tr class="tr2">
	    <td><%=id %></td>    
	    <td><%=categoryid %></td>    
	    <td><%=name %></td>    
	    <td><%=content %></td>
	    <td><%=other %></td>  
	    <td><a href="admin/messageDefault/messageDefault-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/messageDefault-delete.action?messageDefaultID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/messageDefault-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/messageDefault-manager.action?pageNo=1">首页</a> 
			<a href="admin/messageDefault-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/messageDefault-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/messageDefault-manager.action?pageNo=<%=totalPages%>">尾页</a> 
			页次：<%=pageNo%>/<%=totalPages%>
			转到：<select name="pageNo" onChange="document.form1.submit()">
					<%
					for(int i=1; i<=totalPages; i++) {
					%>
					<option value=<%=i %> <%=(pageNo == i) ? "selected" : ""%>>第<%=i%>页 </option>
					<%
					}
					%>
				</select>
			</form>
		<!-- ------------以上HTML分页区------------ -->
  </body>
</html>
