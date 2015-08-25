<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 

    <title>My JSP 'pwchg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	
	<script type="text/javascript">
		function check() {
			var pw = document.form1.newpassword.value;
			var cf = document.form1.newpasswordconfirm.value;
			if(pw == cf) {
				return true;
			} else {
				alert("新密码不一致!");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
	<%
			Member member2 = (Member)ActionContext.getContext().getSession().get("member");
			//Member member = (Member)session.getAttribute("member");
			int id = 0;
			String password = "";
			String name = "";
			if(member2 != null) {
				id = member.getId();
				//password = member.getPassword();
				name = member.getName();
			}
	 %>
	 <form action="admin/member-changepassword" method="post" onsubmit="return check();" name="form1">
	 <input type="hidden" name="name" value="<%=name %>">
	 <input type="hidden" name="memberID" value="<%=id %>">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="6%">原密码：</td>
	      <td width="20%"><input type="password" name="password" id="password" style="width: 200px;">  </td>
	      <td width="74%">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >新密码：</td>
	      <td ><input type="password" name="newpassword" id="newpassword" style="width: 200px;">  </td>
	      <td >&nbsp;</td>
	    </tr>
	    <tr>
	      <td >确认：</td>
	      <td ><input type="password" name="newpasswordconfirm" id="newpasswordconfirm" style="width: 200px;">  </td>
	      <td >&nbsp;</td>
	    </tr>

    </table>
<br/>
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <input type="submit" value="修改"/> &nbsp;&nbsp;<input type="reset" value="放弃"/>
	 </form>
  </body>
</html>
