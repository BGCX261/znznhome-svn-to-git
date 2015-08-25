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
    <title>category-manager</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
  </head>
  <body>
  
    <br/><div id="tableTitle" class="tableTitle">目录分类列表</div><hr><br/>
  
 <%
	  Page category_page = (Page)request.getAttribute("page");
	  String sql = category_page.getSql();
	  String sql_count = category_page.getSql_count();
	  int pageSize = category_page.getPageSize();
	  int pageNo = category_page.getPageNo();
	  int totalPages = category_page.getTotalPages();
%>
  <form action="admin/category-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="name">目录名 </option>
		    	 	<option value="pid">父ID </option>
		    	 </select> like
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">ID</td>    
    <td width="10%">父ID</td>    
    <td width="14%">名称</td>    
    <td width="14%">英文名</td>  
    <td width="14%">目录编码</td>  
    <td width="14%">描述</td>    
    <td width="8%">级别</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
	List<Category> list = category_page.getList();
   	if(list != null) {
  	    for(Iterator<Category> it = list.iterator(); it.hasNext();) {
  	    	Category category = it.next();
  	  		int id = category.getId();
	  	  	int pid = category.getPid();
	  		String name = category.getName();
	  		String ename = category.getEname();
	  		String categorycoding = category.getCategorycoding();
	  		String descr = category.getDescr();
	  		//int cno = category.getCno();
	  		int grade = category.getGrade();
	  		String other = category.getOther();
%>

  <tr class="tr2">
	    <td><%=id %></td>    
	    <td><%=pid %></td>    
	    <td><%=name %></td>    
	    <td><%=ename %></td>   
	    <td><%=categorycoding %></td>   
	    <td><%=descr %></td>
	    <td><%=grade %></td>  
	    <td><a href="admin/category/category-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/category-delete?categoryID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
  </tr>
	  
<%
		} //-- for循环 --
	}
%>

</table>
		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/category-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/category-manager?pageNo=1">首页</a> 
			<a href="admin/category-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/category-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/category-manager?pageNo=<%=totalPages%>">尾页</a> 
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
