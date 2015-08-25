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
  信息列表：<br>
  <hr/>
  
  <%
  Page chatMessage_page = (Page)request.getAttribute("page");
  String sql = chatMessage_page.getSql();
  String sql_count = chatMessage_page.getSql_count();
  //int startNo = chatMessage_page.getStartNo();
  int pageSize = chatMessage_page.getPageSize();
  //int totalRecords = chatMessage_page.getTotalRecords();
  int pageNo = chatMessage_page.getPageNo();
  int totalPages = chatMessage_page.getTotalPages();
  %>
  <form action="admin/chatMessage-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="content">内容</option>
		    	 	<option value="contact">联系方式 </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">内容</td>    
    <td width="12%">联系方式</td>    
    <td width="16%">发布人</td>    
    <td width="30%">验证</td>    
    <td width="16%">日期</td>    
    <td width="8%">查看</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<ChatMessage> list = chatMessage_page.getList();

   	if(list != null) {
  	    for(Iterator<ChatMessage> it = list.iterator(); it.hasNext();) {
  	    	ChatMessage chatMessage = it.next();
  	  		int id = chatMessage.getId();
	  	  	int categoryid = chatMessage.getCategoryid();
	  		int mbid = chatMessage.getMbid();
	  		String mbname = chatMessage.getMbname();
	  		int mbphotono = chatMessage.getMbphotono();
	  		String title = chatMessage.getTitle();
	  		String content = chatMessage.getContent();
	  		String contact = chatMessage.getContact();
	  		String ip = chatMessage.getIp();
	  		Timestamp createtime = chatMessage.getCreatetime();
	  		int passflag = chatMessage.getPassflag();
	  		String other = chatMessage.getOther();
%>

  <tr class="tr2">
	    <td><%=content %></td>    
	    <td><%=contact %></td>    
	    <td><%=mbname %></td>    
	    <td><%=passflag %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/ChatMessage/chatMessage-view.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/view.gif"/></a></td>
	    <td><a href="admin/chatMessage-delete.action?chatMessageID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/chatMessage-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/chatMessage-manager.action?pageNo=1">首页</a> 
			<a href="admin/chatMessage-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/chatMessage-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/chatMessage-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
