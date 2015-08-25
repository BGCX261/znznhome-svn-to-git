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
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
	<link type="text/css" rel="stylesheet" href="css/admin/validator.css"></link>
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator-4.0.1.min.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$(function(){
			$.formValidator.initConfig({formID:"membermdf",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#name").formValidator({onShow:"请输入您的用户名",onFocus:"请注意用户名为3~20位，例如:lxd_810",onCorrect:"输入正确"}).regexValidator({regExp:"username",dataType:"enum",onError:"用户名格式不正确"}).inputValidator({min:3,max:20,onError:"用户名长度应为3~20位，输入不正确"});
			$("#password").formValidator({onShow:"请输入你的密码",onFocus:"请注意密码为6~10位，例如:cPt#$99",onCorrect:"输入正确"}).inputValidator({min:6,max:10,onError:"密码长度应为6~10位，输入不正确"});
			$("#pwconfirm").formValidator({onShow:"请确认密码",onFocus:"请注意两次密码必须一致",onCorrect:"输入正确"}).compareValidator({desID:"password",operateor:"=",dataType:"string", onError:"两次密码不一致，输入不正确"});
		});
	</script>

  </head>
  
  <body>
  
    <br/><div id="tableTitle" class="tableTitle">修改用户信息</div><hr><br/>
  
<%
	String id = request.getParameter("id");
	request.setCharacterEncoding("UTF-8");
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	MemberManager mm = (MemberManager)ctx.getBean("memberManager");
	Member u = new Member();
	u = mm.loadByID(Integer.parseInt(id));	
%>
	  <form action="admin/member-modify" method="post" id="membermdf"  >
	  <input name="memberID" value="<%=id %>" type="hidden">
	  
	  <table width="90%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="6%">用户名：</td>
	      <td width="20%"><input name="name" value="<%=u.getName() %>" type="text" id="name" style="width: 200px;">  </td>
	      <td id="nameTip" width="74%">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >密码：</td>
	      <td ><input name="password" type="password" value="<%=u.getPassword() %>" id="password" style="width: 200px;">  </td>
	      <td id="passwordTip">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >确认：</td>
	      <td ><input name="pwconfirm" type="password" id="pwconfirm" style="width: 200px;">  </td>
	      <td id="pwconfirmTip">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >权限：</td>
	      <td ><select name="purview" id="purview" style="width: 50px;"> 
	    		<option value="0">0</option>
	    		<option value="1">1</option>
   				<script type="text/javascript">
				$("#purview")[0].value="<%=u.getPurview() %>";
				</script>
	    	</select>  </td>
	      <td >&nbsp;</td>
	    </tr>
      </table>
	    <br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" value="修改" />  &nbsp;&nbsp;<input onclick="history.go(-1);" type="button" value="放弃"/>
	    <input type="hidden" name="action" value="submit" />
		<input type="hidden" name="id" value="<%=id %>">
	    </div>
	  </form>
  </body>
</html>
