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
 关键词列表：<br>
  <hr/>
  
  <%
  Page chatMessageKeywords_page = (Page)request.getAttribute("page");
  String sql = chatMessageKeywords_page.getSql();
  String sql_count = chatMessageKeywords_page.getSql_count();
  //int startNo = url_page.getStartNo();
  int pageSize = chatMessageKeywords_page.getPageSize();
  //int totalRecords = url_page.getTotalRecords();
  int pageNo = chatMessageKeywords_page.getPageNo();
  int totalPages = chatMessageKeywords_page.getTotalPages();
  %>
  <form action="admin/chatMessageKeywords-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="keywords">关键词 </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">ID</td>    
    <td width="12%">关键词</td>    
    <td width="16%">级别</td>    
    <td width="30%">推荐</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<ChatMessageKeywords> list = chatMessageKeywords_page.getList();

   	if(list != null) {
  	    for(Iterator<ChatMessageKeywords> it = list.iterator(); it.hasNext();) {
  	    	ChatMessageKeywords chatMessageKeywords = it.next();
  	  		int id = chatMessageKeywords.getId();
	  	  	String keywords = chatMessageKeywords.getKeywords();
	  		Timestamp createtime = chatMessageKeywords.getCreatetime();
	  		int grade = chatMessageKeywords.getGrade();
	  		int recflag = chatMessageKeywords.getRecflag();
	  		String other = chatMessageKeywords.getOther();

%>

  <tr class="tr2">
	    <td><%=id %></td>    
	    <td><%=keywords %></td>    
	    <td><%=grade %></td>    
	    <td><%=recflag %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/chatMessageKeywords/chatMessageKeywords-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/chatMessageKeywords-delete.action?chatMessageKeywordsID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/chatMessageKeywords-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/chatMessageKeywords-manager.action?pageNo=1">首页</a> 
			<a href="admin/chatMessageKeywords-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/chatMessageKeywords-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/chatMessageKeywords-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
