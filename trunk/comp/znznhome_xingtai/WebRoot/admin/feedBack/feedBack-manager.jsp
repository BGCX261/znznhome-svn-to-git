<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,java.util.Date,java.text.SimpleDateFormat" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>feedBack-manager</title>
    
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
  
  <br/><div id="tableTitle" class="tableTitle">反馈信息列表</div><hr><br/>
  
<%
	  Page feedBack_page = (Page)request.getAttribute("page");
	  String sql = feedBack_page.getSql();
	  String sql_count = feedBack_page.getSql_count();
	  int pageSize = feedBack_page.getPageSize();
	  int pageNo = feedBack_page.getPageNo();
	  int totalPages = feedBack_page.getTotalPages();
%>
<form action="admin/feedBack-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; 
		    	 <select style="width:80px" name="search_condition">
		    	 	<option value="title">标题 </option>
		    	 	<option value="content">反馈内容 </option>
		    	 </select> like
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
</form>
  
 <table class="table"  border="1">
  <tr class="tr1">
 	<td width="3%"></td>
    <td width="4%">ID</td>    
    <td width="20%">标题</td> 
    <td width="30%">反馈信息</td>   
    <td width="6%">审核</td>   
    <td width="15%">日期</td>    
    <td width="8%">查看</td>    
    <td width="8%">删除</td>
  </tr>

<%
	List<FeedBack> list = feedBack_page.getList();
   	if(list != null) {
  	    for(Iterator<FeedBack> it = list.iterator(); it.hasNext();) {
  	    	FeedBack feedBack = it.next();
  	  		int id = feedBack.getId();
  	  		String title = CommonUtil.filterHtmlAndSubStr(feedBack.getTitle(), 10);
  	  		String content = CommonUtil.filterHtmlAndSubStr(feedBack.getContent(),20);
  			String createtime = CommonUtil.getTime(feedBack.getCreatetime());
  			String status = feedBack.getStatus() == 1 ? "通过" : "未审核";
%>

  <tr class="tr2">
  		<td><input type="checkbox" id="" name=""></td>
	    <td><%=id %></td>    
	    <td><%=title %></td>  
	    <td><%=content %></td>    
	    <td><%=status %></td>    
	    <td><%=createtime %></td>  
	    <td><a href="admin/feedBack/feedBack-view.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/view.gif"/></a></td>
	    <td><a href="admin/feedBack-delete?feedBackID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
<%
		} //-- for循环 --
	}
%>
</table>
		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/feedBack-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/feedBack-manager?pageNo=1">首页</a> 
			<a href="admin/feedBack-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/feedBack-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/feedBack-manager?pageNo=<%=totalPages%>">尾页</a> 
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
