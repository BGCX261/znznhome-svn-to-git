<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp, com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>

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
  网址列表：<br>
  <hr/>
  
  <%
  Page url_page = (Page)request.getAttribute("page");
  String sql = url_page.getSql();
  String sql_count = url_page.getSql_count();
  //int startNo = url_page.getStartNo();
  int pageSize = url_page.getPageSize();
  //int totalRecords = url_page.getTotalRecords();
  int pageNo = url_page.getPageNo();
  int totalPages = url_page.getTotalPages();
  %>
  <form action="admin/url-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="title">网址名称 </option>
		    	 	<option value="descr">描述 </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">目录ID</td>    
    <td width="12%">网站名称</td>    
    <td width="16%">网址</td>    
    <td width="30%">是否推荐</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Url> list = url_page.getList();

   	if(list != null) {
  	    for(Iterator<Url> it = list.iterator(); it.hasNext();) {
  	    	Url url = it.next();
  	  		int id = url.getId();
  			int categoryid = url.getCategoryid();
  	    	String title = url.getTitle();
  	    	String urladdress = url.getUrladdress();
  	    	String descr = url.getDescr();
  	    	int typeflag = url.getTypeflag();
  	   	 	int recflag = url.getRecflag();
  	   		Timestamp createtime = url.getCreatetime();
%>

  <tr class="tr2">
	    <td><%=categoryid %></td>    
	    <td><%=title %></td>    
	    <td><%=urladdress %></td>    
	    <td><%=typeflag %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/url/url-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/url-delete?urlID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/url-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/url-manager?pageNo=1">首页</a> 
			<a href="admin/url-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/url-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/url-manager?pageNo=<%=totalPages%>">尾页</a> 
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
