<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'usermodify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">

  </head>
  
  <body>
<%
	String id = request.getParameter("id");
	request.setCharacterEncoding("UTF-8");
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	MemberManager mm = (MemberManager)ctx.getBean("memberManager");
	Member u = new Member();
	u = mm.loadByID(Integer.parseInt(id));	
 %>
	  <form action="admin/member-modify" method="post" name="memberadd"  >
	  <input name="memberID" value="<%=id %>" type="hidden">
	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="6%">用户名：</td>
	      <td width="20%"><input name="name" value="<%=u.getName() %>" type="text" id="name" style="width: 200px;">  </td>
	      <td width="74%">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >密码：</td>
	      <td ><input name="password" value="<%=u.getPassword() %>" type="password" id="password" style="width: 200px;">  </td>
	      <td >&nbsp;</td>
	    </tr>

	    <tr>
	      <td >权限：</td>
	      <td >
	      <select name="purview" id="purview" style="width: 50px;"> 
		    		<option value="0">0</option>
		    		<option value="1">1</option>

					<script type="text/javascript">
					document.getElementById("purview").value="<%=u.getPurview() %>";
					</script>
		    	</select>
	  	  </td>
	      <td >&nbsp;</td>
	    </tr>
    </table>
<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="submit" value="修改" /> &nbsp;&nbsp;&nbsp;&nbsp; 
		    <input type="hidden" name="action" value="submit" />
		    <input type="hidden" name="id" value="<%=id %>">
	  

	  </form>
  </body>
</html>
