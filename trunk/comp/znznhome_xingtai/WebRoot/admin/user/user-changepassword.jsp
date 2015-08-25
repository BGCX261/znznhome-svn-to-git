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

    <title>change pw</title>
    
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
			$.formValidator.initConfig({formID:"changepw",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#password").formValidator({onShow:"请输入原密码",onFocus:"请注意密码为6~10位",onCorrect:"输入正确"}).inputValidator({min:6,max:10,onError:"密码长度应为6~10位，输入不正确"});
			$("#newpassword").formValidator({onShow:"请输入新密码",onFocus:"请注意密码为6~10位",onCorrect:"输入正确"}).inputValidator({min:6,max:10,onError:"密码长度应为6~10位，输入不正确"});
			$("#newpasswordconfirm").formValidator({onShow:"请确认密码",onFocus:"请注意两次密码必须一致",onCorrect:"输入正确"}).compareValidator({desID:"newpassword",operateor:"=",dataType:"string", onError:"两次密码不一致，输入不正确"});
		});
	</script>
  </head>
  
  <body>
	<%
			Member member2 = (Member)ActionContext.getContext().getSession().get("member");
			int id = 0;
			String password = "";
			String name = "";
			if(member2 != null) {
				id = member.getId();
				name = member.getName();
			}
	 %>
	 
	 <br/><div id="tableTitle" class="tableTitle">修改密码</div><hr><br/>
	 
	 <form action="admin/member-changepassword" method="post" onsubmit="return check();" id="changepw" name="form1">
	 <input type="hidden" name="name" value="<%=name %>">
	 <input type="hidden" name="memberID" value="<%=id %>">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="6%">原密码：</td>
	      <td width="20%"><input type="password" name="password" id="password" style="width: 200px;">  </td>
	      <td id="passwordTip" width="74%">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >新密码：</td>
	      <td ><input type="password" name="newpassword" id="newpassword" style="width: 200px;">  </td>
	      <td id="newpasswordTip" >&nbsp;</td>
	    </tr>
	    <tr>
	      <td >确认：</td>
	      <td ><input type="password" name="newpasswordconfirm" id="newpasswordconfirm" style="width: 200px;">  </td>
	      <td id="newpasswordconfirmTip" >&nbsp;</td>
	    </tr>

    </table>
	<br/>

    <div id="suojin" class="suojin1">
    <input type="submit" value="修改"/> &nbsp;&nbsp;<input onclick="history.go(-1);" type="button" value="放弃"/>
    <input type="hidden" name="action" value="submit" />
    </div>
		 
	</form>
  </body>
</html>
