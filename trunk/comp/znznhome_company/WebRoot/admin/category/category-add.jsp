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

    
    <title>网址列表目录添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	
		<script src="<%=basePath%>js/jquery-1.7.2.js" type="text/javascript"></script>
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
      	<center><h5>添加网址列表目录信息</h5></center><hr>

      <!-- ----------表单开始-----------   -->
  <form action="admin/category-add" method="post" id="hshcategoryadd" name="hshcategoryadd">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">父目录：</td>
      <td width="24%">
      	<select  name="pid" >
			<option value="0">根目录</option>
<%
ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
List<Category> list = new ArrayList<Category>();
list = categoryManager.getAllChilds(list, 0); 
System.out.println(list.size());
if (list.size() > 0) {
	for(int i=0; i<list.size(); i++) {
		Category category = list.get(i);
		int id = category.getId();
		String name = category.getName();
		int grade = category.getGrade();
		String pre_str = "";
		for(int j=0; j<grade; j++) {
			pre_str = pre_str + "|----";
		}
%>
            <option value="<%=id %>"><%=pre_str + name %></option>
<%
	}//for(int i=0; i<categoryList.size(); i++) {    	
}%>
        </select>  
      </td>
      <td width="5%"  id="pcodeTip" ></td>
      <td width="8%">&nbsp;</td>
      <td width="65%">&nbsp;</td>
    </tr>

    <tr>
      <td>目录名称：</td>
      <td>
      <input name="name" type="text" id="name" size="30">
      </td>
      <td  id="pnameTip" > </td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    
    </tr>
    <tr>
      <td>目录英文名：</td>
      <td>
      <input name="ename" type="text" id="ename" size="30" onblur="$('#abc').load('admin/ajax/checkCategoryEname.jsp', {ename: 'hello'}, function(data){alert(data)})">
      </td>
      <td  id="pnameTip" > <div id="abc"></div></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    
    </tr>
        <tr>
      <td>目录编码：</td>
      <td>
      <input name="categorycoding" type="text" id="categorycoding" size="30" >
      </td>
      <td  id="pnameTip" > <div id="abc"></div></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    
    </tr>
    <tr>
      <td>目录描述：</td>
      <td> <input name="descr" type="text" id="descr" size="30"> </td>
      <td id="memberpriceTip"></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
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
