<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*" %>
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
订购反馈信息列表：<br>
  <hr/>
  
  <%
  Page feedback_page = (Page)request.getAttribute("page");
  String sql = feedback_page.getSql();
  String sql_count = feedback_page.getSql_count();
  //int startNo = feedback_page.getStartNo();
  int pageSize = feedback_page.getPageSize();
  //int totalRecords = feedback_page.getTotalRecords();
  int pageNo = feedback_page.getPageNo();
  int totalPages = feedback_page.getTotalPages();
  %>
  <form action="admin/Feedback-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="subject">反馈主题</option>
		    	 	<option value="contactperson">姓名</option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索"> 
		    	 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="20%">反馈主题</td>    
    <td width="12%">公司</td>    
    <td width="23%">联系人</td>    
    <td width="13%">电话</td>    
    <td width="16%">日期</td>    
    <td width="8%">查看</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Feedback> list = feedback_page.getList();

   	if(list != null) {
  	    for(Iterator<Feedback> it = list.iterator(); it.hasNext();) {
  	    	Feedback feedback = it.next();
  	  		int id = feedback.getId();
  	  		String subject = feedback.getSubject();
	  		String company = feedback.getCompany();
	  		String contactperson = feedback.getContactperson();
	  		String tel = feedback.getTel();
  	   		Timestamp createtime = feedback.getCreatetime();
  	   		
%>

  <tr class="tr2">
	    <td><%=subject %></td>    
	    <td><%=company %></td>    
	    <td><%=contactperson %></td>    
	    <td><%=tel %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/Feedback/Feedback-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/Feedback-delete.action?feedbackID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/Feedback-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/Feedback-manager.action?pageNo=1">首页</a> 
			<a href="admin/Feedback-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/Feedback-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/Feedback-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
