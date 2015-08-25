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
    
    <title>My JSP 'usermg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"> 
<!-- 
     function selectall(obj) { 
         var temp = document.getElementsByName("newsIDs"); 
         for (var i =0; i<temp.length; i++) 
         { 
             temp[i].checked = obj.checked; 
         } 
     } 
     function cancel(obj,all) { 
         var flag = 0; 
         var all = document.getElementsByName(all)[0]; 
         if (!obj.checked) 
         { 
             all.checked = false; 
         } 
         else 
         { 
             for (var i=0; i<document.getElementsByName(obj.name).length; i++) 
             { 
                 if (!document.getElementsByName(obj.name)[i].checked) 
                 { 
                     all.checked = false; 
                 } 
                 else 
                 { 
                     flag++; 
                 } 
             } 
             if (flag == document.getElementsByName(obj.name).length) 
             { 
                 all.checked = true; 
             } 
         } 
     } 
//--> 
</script> 

<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">

  </head>
  
  <body>&nbsp; 
新闻列表：<br>
  <hr/>
  
  <%
  Page news_page = (Page)request.getAttribute("page");
  String sql = news_page.getSql();
  String sql_count = news_page.getSql_count();
  //int startNo = news_page.getStartNo();
  int pageSize = news_page.getPageSize();
  //int totalRecords = news_page.getTotalRecords();
  int pageNo = news_page.getPageNo();
  int totalPages = news_page.getTotalPages();
  %>
  <form action="admin/news-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="title">标题</option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索"> 
		    	 
  </form>
  
<form action="admin/news-updateMultipleNews" method="post" name="mainform">
 <table class="table"  border="1">
  <tr class="tr1">
  	<td width="3%"></td>
    <td width="4%">ID</td>
    <td width="38%">标题</td>    
    <td width="12%">类别</td>    
    <td width="10%">来源</td>    
    <td width="10%">推荐</td>    
    <td width="13%">日期</td> 
    <td width="5%">修改</td>    
    <td width="5%">删除</td>
  </tr>

<%
List<News> list = news_page.getList();

   	if(list != null) {
  	    for(Iterator<News> it = list.iterator(); it.hasNext();) {
  	    	News news = it.next();
  	  		int id = news.getId();
  	  		int categoryid = news.getCategoryid();
	  	  	String title = news.getTitle();
	  	  	if(title.length() > 12) title = title.substring(0, 12);
	  	  	String categoryname = news.getCategoryname();
	  		String picurl = news.getPicurl();
	  		int recflag = news.getRecflag();
	  		String origin = news.getOrigin();

	  		Timestamp ts = news.getCreatetime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createtime = sdf.format(ts);
			
  	   		String str_created = "";
  	   		String operation = "";

  	   	
  	   		
  	   		String str_recflag = "";

  	   		if(recflag == 0) {
  	   			str_recflag = "未推荐";
  	   		} else {
  	   			str_recflag = "推荐";
  	   		} 
  	   		
  	   		String preName = "content";
  	   		//switch (categoryid) {
  	   		//case 1:
  	   			//preName = "news";
  	   		//}
%>

  <tr class="tr2">
  		<td><input type="checkbox" id="newsIDs" name="newsIDs" value="<%=id %>"></td>
  		<td><%=id %></td>
	    <td><%=title %></td>    
	    <td><%=categoryname %></td>    
	    <td><%=origin %></td>    
	    <td><%=str_recflag %></td>
	    <td><%=createtime %></td>
	    <td><a href="admin/news/news-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/news-delete?newsID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>
</form>
		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/news-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/news-manager?pageNo=1">首页</a> 
			<a href="admin/news-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/news-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/news-manager?pageNo=<%=totalPages%>">尾页</a> 
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
