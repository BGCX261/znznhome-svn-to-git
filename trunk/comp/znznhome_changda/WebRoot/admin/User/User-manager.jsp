<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="com.changda.util.*,com.changda.model.*,com.changda.service.*" %>
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
  用户列表：</br>
 <table class="table"  border="1">
  		
  <tr class="tr1"><td>编号</td><td>姓名</td><td>密码</td><td>权限</td><td>&nbsp</td><td>&nbsp</td></tr>
  		
  			
		<%
			request.setCharacterEncoding("UTF-8");
			UserManager um = UserManager.getInstance();
			String sql = "select * from user";
			List<User> userList = um.loadBySQL(sql);
			for(Iterator<User> it = userList.iterator(); it.hasNext(); ) {
				User u = it.next();
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
				<td><a href="admin/User/User-modify.jsp?id=<%=id %>">修改</a></td>
				<td><a href="admin/User-delete.action?userid=<%=id %>">删除</a></td>
			</tr>			
			<%	
			}
		 %>

	 </table>
  </body>
</html>
