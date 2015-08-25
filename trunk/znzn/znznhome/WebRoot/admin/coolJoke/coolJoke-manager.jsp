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
  笑话列表：<br>
  <hr/>
  
  <%
  Page coolJoke_page = (Page)request.getAttribute("page");
  String sql = coolJoke_page.getSql();
  String sql_count = coolJoke_page.getSql_count();
  //int startNo = url_page.getStartNo();
  int pageSize = coolJoke_page.getPageSize();
  //int totalRecords = url_page.getTotalRecords();
  int pageNo = coolJoke_page.getPageNo();
  int totalPages = coolJoke_page.getTotalPages();
  %>
  <form action="admin/coolJoke-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="content">内容 </option>
		    	 	<option value="categoryid">分类ID </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">目录ID</td>    
    <td width="12%">内容</td>    
    <td width="16%">审核</td>    
    <td width="30%">推荐</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<CoolJoke> list = coolJoke_page.getList();

   	if(list != null) {
  	    for(Iterator<CoolJoke> it = list.iterator(); it.hasNext();) {
  	    	CoolJoke coolJoke = it.next();
  	  		int id = coolJoke.getId();
	  		int categoryid = coolJoke.getCategoryid();
	  		int mbid = coolJoke.getMbid();
	  		String mbname = coolJoke.getMbname();
	  		String title = coolJoke.getTitle();
	  		String content_long = coolJoke.getContent();
	  		String ip = coolJoke.getIp();
	  		Timestamp createtime = coolJoke.getCreatetime();
	  		int passflag = coolJoke.getPassflag();
	  		int recflag = coolJoke.getRecflag();
	  		String other = coolJoke.getOther();
	  		
	  		//截取一段字符，不然显示的时候就撑开了
			String content = ""; 
			if (content_long != null && content_long.length() > 30) {
				content = content_long.substring(0,30) + "...";
			} else if(content_long != null) {
				content = content_long;
			}
%>

  <tr class="tr2">
	    <td><%=categoryid %></td>    
	    <td><%=content %></td>    
	    <td><%=passflag %></td>    
	    <td><%=recflag %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/coolJoke/coolJoke-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/coolJoke-delete.action?coolJokeID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/CoolJoke-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/CoolJoke-manager.action?pageNo=1">首页</a> 
			<a href="admin/CoolJoke-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/CoolJoke-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/CoolJoke-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
