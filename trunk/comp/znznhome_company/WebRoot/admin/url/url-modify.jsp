<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp, com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>
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

    
    <title>网址列表修改</title>
    
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
  	request.setCharacterEncoding("UTF-8");
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	UrlManager um = (UrlManager)ctx.getBean("urlManager");
	Url u = new Url();
	u = um.loadByID(Integer.parseInt(id));	
	
	int categoryid = u.getCategoryid();
    String title = u.getTitle();
    String urladdress = u.getUrladdress();
    String descr = u.getDescr();
    int typeflag = u.getTypeflag();
    int recflag = u.getRecflag();
    Timestamp createtime = u.getCreatetime();
 %>
             <br>
      	<center><h5>修改网址</h5></center><hr>

      <!-- ----------表单开始-----------   -->
  <form action="admin/url-modify" method="post" id="yysnewsaddform" name="yysnewsaddform">
  	  <input name="urlID" value="<%=id %>" type="hidden">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">标题：</td>
      <td width="24%"><input id="title" name="title" value="<%=title %>" type="text" size="30">  </td>
      <td width="5%"  id="titleTip" ></td>
      <td width="8%">类别：</td>
      <td width="65%">
      	<select name="typeflag">
			<option value="1">直接资源</option>
			<option value="2">网站地址</option>
			
				<script type="text/javascript">
					document.getElementById("typeflag").value="<%=typeflag %>";
				</script>
			
		</select>
       </td>
    </tr>

    <tr>
      <td>URL地址：</td>
      <td> <input name="urladdress" type="text" id="urladdress" value="<%=urladdress %>" size="30"> </td>
      <td  id="urlTip" > </td>
      <td>所属模块:</td>
      <td>
	    <select name="categoryid" id="categoryid">
			<option value="0">不推荐</option>
			<option value="1">推荐</option>
		</select>
		        <script type="text/javascript">
					document.getElementById("categoryid").value="<%=categoryid %>";
				</script>
	  </td>
    </tr>
    
    <tr>
      <td>简评：</td>
      <td> <input name="descr" type="text" id="descr" value="<%=descr %>" size="30"> </td>
      <td  id="urlTip" > </td>
      <td>是否推荐:</td>
      <td>
	    <select name="recflag">
			<option value="0">不推荐</option>
			<option value="1">加精</option>
			<option value="2">变红</option>
			<option value="3">变绿</option>
		</select>
		
				<script type="text/javascript">
					document.getElementById("recflag").value="<%=recflag %>";
				</script>
		
	  </td>
    </tr>
	

  </table>
  <br/>
  	<table style="border:0px;">
  		<tr>
  			<td width="10%">&nbsp;
  			</td>
  			<td width="30%">
		  		<input type="submit" name="submit" value="提交">
				&nbsp;&nbsp;
		        <input type="reset" name="reset" value="重填">
  			</td>
  			<td>&nbsp;
  			</td>
  		</tr>
  	</table>
  <br><br/>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
