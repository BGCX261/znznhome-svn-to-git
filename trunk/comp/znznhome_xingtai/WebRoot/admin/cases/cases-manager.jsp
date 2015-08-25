<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,java.util.Date,java.text.SimpleDateFormat" %>
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
    <title>cases-manager</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
  </head>
  
  <body>
  
  <br/><div id="tableTitle" class="tableTitle">工程案例列表</div><hr><br/>
  
<%
	  Page cases_page = (Page)request.getAttribute("page");
	  String sql = cases_page.getSql();
	  String sql_count = cases_page.getSql_count();
	  int pageSize = cases_page.getPageSize();
	  int pageNo = cases_page.getPageNo();
	  int totalPages = cases_page.getTotalPages();
%>
<form action="admin/cases-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="title">标题</option>
		    	 	<option value="casename">项目名称</option>
		    	 	<option value="content">项目内容描述</option>
		    	 </select> like
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索"> 
</form>
  
<form action="" method="post" name="mainform">
 <table class="table"  border="1">
  <tr class="tr1">
  	<td width="3%"></td>
    <td width="4%">ID</td>
    <td width="38%">标题</td>    
    <td width="12%">类别</td>    
    <td width="10%">项目名称</td>    
    <td width="10%">推荐</td>    
    <td width="13%">日期</td> 
    <td width="5%">修改</td>    
    <td width="5%">删除</td>
  </tr>

<%
	List<Cases> list = cases_page.getList();
   	if(list != null) {
  	    for(Iterator<Cases> it = list.iterator(); it.hasNext();) {
  	    	Cases cases = it.next();
  	  		int id = cases.getId();
  	  		int categoryid = cases.getCategoryid();
  	  		String title = CommonUtil.filterHtmlAndSubStr(cases.getTitle(), 12);
	  	  	String categoryname = cases.getCategoryname();
	  		int recflag = cases.getRecflag();
	  		String casename = cases.getCasename();
	  		String createtime = CommonUtil.getTime(cases.getCreatetime());
  	   		String str_recflag = recflag == 0 ? "未推荐" : "推荐";
%>

  <tr class="tr2">
  		<td><input type="checkbox" id="casesIDs" name="casesIDs" value="<%=id %>"></td>
  		<td><%=id %></td>
	    <td><%=title %></td>    
	    <td><%=categoryname %></td>    
	    <td><%=casename %></td>    
	    <td><%=str_recflag %></td>
	    <td><%=createtime %></td>
	    <td><a href="admin/cases/cases-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/cases-delete?casesID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>
</form>
		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/cases-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/cases-manager?pageNo=1">首页</a> 
			<a href="admin/cases-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/cases-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/cases-manager?pageNo=<%=totalPages%>">尾页</a> 
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
