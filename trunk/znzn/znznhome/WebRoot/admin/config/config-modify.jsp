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
    
    <title>My JSP 'config-add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator-4.0.1.min.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$(function(){
			$.formValidator.initConfig({formID:"configmodify",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#item").formValidator({onShow:"请输入配置项",onFocus:"请注意配置项为2个字符以上",onCorrect:"输入正确"}).inputValidator({min:2,onError:"配置项长度应为2个字符以上，输入不正确"});
			$("#conffield").formValidator({onShow:"请输入配置字段",onFocus:"必填项",onCorrect:"输入正确"}).inputValidator({min:1,onError: "请选择目录分类，不能选根目录"});
			$("#confvalue").formValidator({onShow:"请输入配置值",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:1,max:80,onError:"<font color='red'>最少1位</font>"});
			//$("#confdescr").formValidator({onShow:"请输入配置描述",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:2,max:8,onError:"<font color='red'>最少2位</font>"});
		});
	</script>
  </head>
  
  <body>
  <br/><div id="tableTitle" class="tableTitle">修改配置项</div><hr><br/>
  <%
	String id = request.getParameter("id");
	request.setCharacterEncoding("UTF-8");
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	ConfigManager mm = (ConfigManager)ctx.getBean("configManager");
	Config u = mm.loadByID(Integer.parseInt(id));	
 %>
  <form action="admin/config-modify.action" method="post" name="configmodify" onsubmit="return check();"  >
  
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <input name="configID" value="<%=id %>" type="hidden">
	    <tr>
	      <td width="10%">配置项：</td>
	      <td width="30%"><input name="item" type="text" id="item"  value="<%=u.getItem() %>" style="width: 200px;">  </td>
	      <td width="60%" id="itemTip">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >配置字段：</td>
	      <td ><input name="conffield" type="text" id="conffield" value="<%=u.getConffield() %>" style="width: 200px;">  </td>
	      <td id="conffieldTip">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >配置值：</td>
	      <td ><input name="confvalue" type="text" id="confvalue" value="<%=u.getConfvalue() %>" style="width: 200px;">  </td>
	      <td id="confvalueTip">&nbsp;</td>
	    </tr>
	    <tr>
	      <td >排序值：</td>
	      <td ><input name="orders" type="text" id="orders"  value="<%=u.getOrders()%>" style="width: 200px;" >  </td>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <td >配置描述：</td>
	      <td ><input name="confdescr" type="text" id="confdescr" value="<%=u.getConfdescr() %>" style="width: 200px;">  </td>
	      <td id="confdescrTip">&nbsp;</td>
	    </tr>
    </table>
		<br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" value="修改" /> &nbsp;&nbsp;<input type="reset" value="取消" /> 
	    </div>
  </form>
  </body>
</html>
