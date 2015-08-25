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
  网址列表：<br>
  <hr/>
  
  <%
  Page member_page = (Page)request.getAttribute("page");
  String sql = member_page.getSql();
  String sql_count = member_page.getSql_count();
  //int startNo = member_page.getStartNo();
  int pageSize = member_page.getPageSize();
  //int totalRecords = member_page.getTotalRecords();
  int pageNo = member_page.getPageNo();
  int totalPages = member_page.getTotalPages();
  %>
  <form action="admin/Member-manager.action" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="name">会员名称 </option>
		    	 </select> is
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
  
  
 <table class="table"  border="1">
  <tr class="tr1">
    <td width="10%">编号</td>    
    <td width="12%">会员名</td>    
    <td width="16%">审核</td>    
    <td width="30%">类型</td>    
    <td width="16%">日期</td>    
    <td width="8%">修改</td>    
    <td width="8%">删除</td>
  </tr>

<%
List<Member> list = member_page.getList();

   	if(list != null) {
  	    for(Iterator<Member> it = list.iterator(); it.hasNext();) {
  	    	Member member = it.next();
  	  		int id = member.getId();
	  		String name = member.getName();
	  		int type = member.getType();
	  		String password = member.getPassword();
	  		String email = member.getEmail();
	  		int passflag = member.getPassflag();
  	   		Timestamp createtime = member.getCreatetime();
  	   		
  	   		String str_type = "";
  	   		String str_passflag = "";
  	   		
  	   		if(type == 1) {
  	   			str_type = "普通会员";
  	   		} else if(type == 2) {
  	   			str_type = "高级会员";
  	   		} else {
  	   			str_type = "问题会员";
  	   		}
  	   		
  	   		if(passflag == 0) {
  	   			str_passflag = "未激活";
  	   		} else {
  	   			str_passflag = "已激活";
  	   		} 
%>

  <tr class="tr2">
	    <td><%=id %></td>    
	    <td><%=name %></td>    
	    <td><%=str_passflag %></td>    
	    <td><%=str_type %></td>
	    <td><%=createtime %></td>  
	    <td><a href="admin/Member/Member-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/Member-delete.action?memberID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
	  	<%} //-- for循环 --

}%>

</table>

		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/Member-manager.action">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/Member-manager.action?pageNo=1">首页</a> 
			<a href="admin/Member-manager.action?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/Member-manager.action?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/Member-manager.action?pageNo=<%=totalPages%>">尾页</a> 
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
