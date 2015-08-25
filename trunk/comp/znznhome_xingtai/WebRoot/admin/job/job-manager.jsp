<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
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
招聘职位列表：<br>
  <hr/>
  
  <%
  Page job_page = (Page)request.getAttribute("page");
  String sql = job_page.getSql();
  String sql_count = job_page.getSql_count();
  //int startNo = job_page.getStartNo();
  int pageSize = job_page.getPageSize();
  //int totalRecords = job_page.getTotalRecords();
  int pageNo = job_page.getPageNo();
  int totalPages = job_page.getTotalPages();
  %>
  <form action="admin/job-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="position">职位名称</option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索"> 
		    	 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="20%">职位名称</td>    
    <td width="12%">工作地点</td>    
    <td width="23%">所需专业</td>    
    <td width="13%">人数</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Job> list = job_page.getList();

   	if(list != null) {
  	    for(Iterator<Job> it = list.iterator(); it.hasNext();) {
  	    	Job job = it.next();
  	  		int id = job.getId();
  	  		
	  	  	String position = job.getPosition();
	  		String field = job.getField();
	  		String location = job.getLocation();
	  		String totalnumber = job.getTotalnumber();

  	   		Timestamp createtime = job.getCreatetime();
  	   		
%>

  <tr class="tr2">
	    <td><%=position %></td>    
	    <td><%=location %></td>    
	    <td><%=field %></td>    
	    <td><%=totalnumber %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/job/job-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/job-delete?jobID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/job-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/job-manager?pageNo=1">首页</a> 
			<a href="admin/job-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/job-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/job-manager?pageNo=<%=totalPages%>">尾页</a> 
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
