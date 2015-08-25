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
  Page message_page = (Page)request.getAttribute("page");
  String sql = message_page.getSql();
  String sql_count = message_page.getSql_count();
  //int startNo = message_page.getStartNo();
  int pageSize = message_page.getPageSize();
  //int totalRecords = message_page.getTotalRecords();
  int pageNo = message_page.getPageNo();
  int totalPages = message_page.getTotalPages();
  %>
  <form action="admin/message-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="content">内容</option>
		    	 	<option value="title">主题 </option>
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
    <td width="8%">查看</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Message> list = message_page.getList();

   	if(list != null) {
  	    for(Iterator<Message> it = list.iterator(); it.hasNext();) {
  	    	Message message = it.next();
  	  		int id = message.getId();
	  	  	int mbid = message.getMbid();
	  		String mbname = message.getMbname();
	  		int categoryid = message.getCategoryid();
	  		String province = message.getProvince();
	  		String city = message.getCity();
	  		String district = message.getDistrict();
	  		String title = message.getTitle();
	  		String contact = message.getContact();
	  		String keywords = message.getKeywords();
	  		String content = message.getContent();
	  		String ip = message.getIp();
	  		Timestamp createtime = message.getCreatetime();
	  		int passflag = message.getPassflag();
	  		int recflag = message.getRecflag();
%>

  <tr class="tr2">
	    <td><%=title %></td>    
	    <td><%=content %></td>    
	    <td><%=recflag %></td>    
	    <td><%=passflag %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/message/Message-view.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/view.gif"/></a></td>
	    <td><a href="admin/message-delete.action?messageID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/message-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/Message-manager.action?pageNo=1">首页</a> 
			<a href="admin/message-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/message-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/message-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
