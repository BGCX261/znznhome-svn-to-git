<%@ page language="java" import="java.util.*, net.fckeditor.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<%
String ip = request.getRemoteAddr();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    
    <title>冷笑话添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	
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
         <br>
      	<center><h5>添加笑话</h5></center><hr>

      <!-- ----------表单开始-----------   -->
  <form action="admin/CoolJoke-add.action" method="post" id="hshcategoryadd" name="hshcategoryadd">
  <input type="hidden" name="ip" value="<%=ip %>">
  <input type="hidden" name="mbname" value="宅男宅女">
  <input type="hidden" name="mbid" value="0">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">标题：</td>
      <td width="24%"><input name="title" type="text" id="title" size="30">  </td>
      <td width="5%"  id="pcodeTip" ></td>
      <td width="8%">分类：</td>
      <td width="65%">
      	<select  name="categoryid" >
<%
ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
List<Category> list = new ArrayList();
list = categoryManager.getAllChilds(list,"宅得开心"); 
if (list.size() == 0) return;
for(int i=0; i<list.size(); i++) {
	Category category = list.get(i);
	int id = category.getId();
	String name = category.getName();
	int grade = category.getGrade();
	String pre_str = "";
	for(int j=0; j<=grade; j++) {
		pre_str = pre_str + "|----";
	}
%>
            <option value="<%=id %>"><%=pre_str + name %></option>
<%
}//for(int i=0; i<categoryList.size(); i++) {    	
%>
        </select>  
       </td>
    </tr>

    <tr>
      <td>审核：</td>
      <td> 
        <select name="passflag">
      		<option value="0">未通过</option>
      		<option value="1" selected>通过</option>
      	</select>
      </td>
      <td  id="pnameTip" > </td>
      <td>推荐：</td>
      <td>
      	<select name="recflag">
      		<option value="0" selected>不推荐</option>
      		<option value="1" >加"精"</option>
      		<option value="2" >红字</option>
      		<option value="3" >绿字</option>
      	</select>
      </td>
    
    </tr>
    
    <tr>
      <td>内容：</td>
      <td> <textarea name="content" cols="32" rows="3"></textarea> </td>
      <td id="memberpriceTip"></td>
      <td>其它：</td>
      <td><textarea name="other" cols="32" rows="3"></textarea></td>
    </tr>
    
   
    <tr>
      <td>&nbsp;</td>
      <td colspan="2"><input type="submit" name="submit" value="提交">
        <input type="reset" name="reset" value="重填"></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <br><br/>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
