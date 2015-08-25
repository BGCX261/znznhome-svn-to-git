<%@ page language="java" import="java.util.*, net.fckeditor.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*" %>
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

    
    <title>网址列表添加</title>
    
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
			$.formValidator.initConfig({formID:"urladdform",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#title").formValidator({onShow:"请输入标题",onFocus:"请注意标题为4个中文以上",onCorrect:"输入正确"}).inputValidator({min:8,onError:"标题长度应为4位以上，输入不正确"});
			//$("#origin").formValidator({onShow:"请输入来源",onFocus:"请注意来源为2个中文以上",onCorrect:"输入正确"}).inputValidator({min:4,onError:"来源长度应为2位以上，输入不正确"});
			$("#categoryid").formValidator({onShow:"请选择目录分类",onFocus:"目录必须选择",onCorrect:"输入正确"}).inputValidator({min:1,onError: "请选择目录分类，不能选根目录"});
			
			$("#categoryid").bind("change", function(){$("#categoryname")[0].value=($("#categoryid")[0].options[$("#categoryid")[0].selectedIndex].text);}  );
			
		});
	</script>
  </head>
  
  <body>
  
	<br/><div id="tableTitle" class="tableTitle">添加网址列表</div><hr><br/>

      <!-- ----------表单开始-----------   -->
  <form action="admin/url-add" method="post" id="urladdform" name="urladdform">
  <input type="hidden" name="categoryname" id="categoryname">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">标题：</td>
      <td width="18%"><input id="title" name="title" type="text" id="pcode" size="25">  </td>
      <td width="24%"  id="titleTip" ></td>
      <td width="8%">类别：</td>
      <td width="18%">
      	<select id="categoryid"  name="categoryid" >
			<option value="0">根目录</option>
<%
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
	List<Category> list = new ArrayList();
	list = categoryManager.getAllChilds(list,0); 
	if (list.size() != 0) {
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
	}//if (list.size() != 0) {
%>
        </select>  
       </td>
       <td width="24%"  id="categoryidTip" ></td>
    </tr>

    <tr>
      <td>URL地址：</td>
      <td> <input name="urladdress" type="text" id="urladdress" size="25"> </td>
      <td  id="urladdressTip" > </td>
      <td>推荐方式:</td>
      <td>
	    <select name="recflag">
			<option value="0" selected>不推荐</option>
			<option value="1">加精</option>
			<option value="2">变红</option>
			<option value="3">变绿</option>
		</select>
	  </td>
	  <td id="" ></td>
    </tr>
    
    <tr>
      <td>简评：</td>
      <td> <input name="descr" type="text" id="descr" size="25"> </td>
      <td  id="descrTip" > </td>
      <td>来源：</td>
      <td><input name=origin type="text" id="origin" size="25"></td>
	  <td id="originTip"></td>
    </tr>
	

  </table>
  		<br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" value="添加" /> &nbsp;&nbsp;<input type="reset" value="取消" /> 
	    </div>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
