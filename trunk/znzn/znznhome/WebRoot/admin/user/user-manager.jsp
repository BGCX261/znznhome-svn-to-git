<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>
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
    
    <title>My JSP 'membermg.jsp' starting page</title>
    
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
  用户列表：</br>
 <table class="table"  border="1">
  		
  <tr class="tr1"><td>编号</td><td>姓名</td><td>密码</td><td>权限</td><td>&nbsp</td><td>&nbsp</td></tr>
  		
  			
		<%
			request.setCharacterEncoding("UTF-8");
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			MemberManager um = (MemberManager)ctx.getBean("memberManager");
			String sql = "select * from znzn_member";
			List<Member> memberList = um.loadBySQL(sql);
			for(Iterator<Member> it = memberList.iterator(); it.hasNext(); ) {
				Member u = it.next();
				int id = u.getId();
				//String name = new String(u.getName().getBytes("gb2312")); //解决中文乱码问题；
				String name = u.getName();
				String password = u.getPassword();
				int purview = u.getPurview();
			%>
			
  <tr class="tr2">
				<td><%=id %></td>
				<td><%=name %></td>
				<td><%=password %></td>
				<td><%=purview %></td>
				<td><a href="admin/user/user-modify.jsp?id=<%=id %>">修改</a></td>
				<td><a href="admin/member-delete.action?memberID=<%=id %>">删除</a></td>
			</tr>			
			<%	
			}
		 %>

	 </table>
  </body>
</html>
