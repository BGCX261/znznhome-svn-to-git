<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp, com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*,org.apache.lucene.document.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchresult.jsp' starting page</title>
    
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
  Page index_page = (Page)request.getAttribute("page");
  //int startNo = index_page.getStartNo();
  int pageSize = index_page.getPageSize();
  //int totalRecords = index_page.getTotalRecords();
  int pageNo = index_page.getPageNo();
  int totalPages = index_page.getTotalPages();
  %>
  <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">ID</td>    
    <td width="12%">title</td>    
    <td width="16%">categoryname</td>    
    <td width="15%">origin</td>   
    <td width="15%">descr</td>    
    <td width="16%">urladdress</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Document> list = index_page.getList();

   	if(list != null) {
  	    for(Iterator<Document> it = list.iterator(); it.hasNext();) {
  	    	Document doc = it.next();
  	    	String text[] = doc.getValues("title");
  	    	int i = 0;
  	    	for(String t : text) {
  	    	
  	    		//out.print(t + "  --" + i + "--");
  	    		i++;
  	    	}
  	  		String id = doc.getValues("id")[0];
  			String title = doc.getValues("title")[0];
  			String categoryname = doc.getValues("categoryname")[0];
  			String origin = doc.getValues("origin")[0];
  			String descr = doc.getValues("descr")[0];
  			String urladdress = doc.getValues("urladdress")[0];
%>

  <tr class="tr2">
	    <td><%=id %></td>    
	    <td><%=title %></td>    
	    <td><%=categoryname %></td>    
	    <td><%=origin %></td>
	    <td><%=descr %></td>
	    <td><%=urladdress %></td>  
	    <td><a href="admin/index/index-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/index-delete?indexID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/index-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/index-manager?pageNo=1">首页</a> 
			<a href="admin/index-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/index-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/index-manager?pageNo=<%=totalPages%>">尾页</a> 
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
