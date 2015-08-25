<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    
    <title>添加会员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<script type="text/javascript" src="<%=basePath%>admin/fckediter/fckeditor.js"></script>
	
		<script src="<%=basePath%>js/jquery_last.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	
		<script type="text/javascript">
	$(document).ready(function(){
		//$.formValidator.initConfig({onerror:function(){alert("校验没有通过，具体错误请看错误提示")}});
		$.formValidator.initConfig({formid:"newsaddform",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
		$("#pcode").formValidator({tipid:"pcodeTip",onshow:"非空！数字编号",onfocus:"7位数以上编号",oncorrect:" "}).inputValidator({min:7,max:99,onerror:"编号输入不正确"});
		$("#pname").formValidator({tipid:"pnameTip",onshow:"非空！",onfocus:"至少1个字",oncorrect:" "}).inputValidator({min:2,max:99,onerror:"名称输入不正确"});
		
		$("#memberprice").formValidator({empty:false,onshow:"非空！必须是数字",onfocus:"只能输入数字",oncorrect:" ",onempty:" "}).inputValidator({min:1,max:10,onerror:"价格只能输入数字"});//.defaultPassed();
		$("#normalprice").formValidator({empty:false,onshow:"非空！必须是数字",onfocus:"只能输入数字",oncorrect:" ",onempty:" "}).inputValidator({min:1,max:10,onerror:"价格只能输入数字"});//.defaultPassed();
		$("#oldprice").formValidator({empty:false,onshow:"非空！必须是数字",onfocus:"只能输入数字",oncorrect:" ",onempty:" "}).inputValidator({min:1,max:10,onerror:"价格只能输入数字"});//.defaultPassed();
		$("#descr").formValidator({tipid:"descrTip",onshow:"非空！",onfocus:"至少1个字",oncorrect:" "}).inputValidator({min:2,max:99,onerror:"描述输入不正确"});
		
	});
	</script>
  </head>
  
  <body>
  
    <%
    	String id = request.getParameter("id");
    	MemberManager mm = MemberManager.getInstance();
    	Member member = new Member();
    	member = mm.loadByID(Integer.parseInt(id));	
    	
    	String name = member.getName();
    	int type = member.getType();
    	String password = member.getPassword();
    	String email = member.getEmail();
    	int passflag = member.getPassflag();
    %>
  
             <br>
      	<center><h5>修改会员信息</h5></center><hr>

      <!-- ----------表单开始-----------   -->
  <form action="admin/Member-modify.action" method="post" id="yysnewsaddform" name="yysnewsaddform">
  <input name="memberID" value="<%=id %>" type="hidden">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">会员名：</td>
      <td width="24%"><input id="name" name="name" type="text" id="name" size="30" value="<%=name %>">  </td>
      <td width="5%"  id="titleTip" ></td>
      <td width="8%">类别：</td>
      <td width="65%">
      	<select name="type">
			<option value="1">普通会员</option>
			<option value="2">高级会员</option>
		</select>
		
				<script type="text/javascript">
					document.getElementById("type").value="<%=type %>";
				</script>
		
       </td>
    </tr>

    <tr>
      <td>会员密码：</td>
      <td> <input name="password" type="password" id="Memberaddress" size="30" value="<%=password %>"> </td>
      <td  id="MemberTip" > </td>
      <td>审核:</td>
      <td>
	    <select name="passflag">
			<option value="0">未激活</option>
			<option value="1" selected>激活</option>
		</select>
		
				<script type="text/javascript">
					document.getElementById("passflag").value="<%=passflag %>";
				</script>
	  </td>
    </tr>

    <tr>
      <td>email：</td>
      <td> <input name="email" type="input" id="email" size="30" value="<%=email %>"> </td>
      <td  id="MemberTip" > </td>
      <td>&nbsp;</td>
      <td>
		&nbsp;
	  </td>
    </tr>
    

	

  </table>
		<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="submit" value="修改" /> &nbsp;&nbsp;<input type="reset" value="取消" /> 
	    <input type="hidden" name="action" value="submit" />
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
