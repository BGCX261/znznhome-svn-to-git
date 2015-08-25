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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>product-add</title>
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
		function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
		}
		$(function(){
			$.formValidator.initConfig({formID:"productaddform",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#title").formValidator({onShow:"请输入标题",onFocus:"请注意标题为4个中文以上",onCorrect:"输入正确"}).inputValidator({min:8,onError:"标题长度应为4位以上，输入不正确"});
			$("#productname").formValidator({onShow:"请输入产品名称",onFocus:"请注意作者为2个中文以上",onCorrect:"输入正确"}).inputValidator({min:4,onError:"产品名称长度应为2位以上，输入不正确"});
			$("#model").formValidator({onShow:"请输入产品型号",onFocus:"请注意型号为2个中文以上",onCorrect:"输入正确"}).inputValidator({min:4,onError:"型号长度应为2位以上，输入不正确"});
			$("#categoryid").formValidator({onShow:"请选择目录分类",onFocus:"目录必须选择",onCorrect:"输入正确"}).inputValidator({min:1,onError: "请选择目录分类，不能选根目录"});
			
			$("#categoryid").bind("change", function(){$("#categoryname")[0].value=($("#categoryid")[0].options[$("#categoryid")[0].selectedIndex].text);}  );
			
		});
	</script>
  </head>
    <%
		FCKeditor fckEditor = new FCKeditor(request, "content");
	%>
  <body>

	<br/><div id="tableTitle" class="tableTitle">添加产品</div><hr><br/>
    
      <!-- ----------表单开始-----------   -->
  <form action="admin/product-add" method="post" id="productaddform" name="productaddform">
  <input type="hidden" name="categoryname" id="categoryname" value="">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">标题：</td>
      <td width="18%"><input name="title" type="text" id="title" size="25">  </td>
      <td width="24%" id="titleTip"></td>
      <td width="8%">类别：</td>
      <td width="18%">
      	<select  id="categoryid" name="categoryid">
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
      <td id="categoryidTip" width="24%"></td>
    </tr>
    <tr>
      <td>产品名称：</td>
      <td> <input type="text" id="productname" name="productname"  size="25"> </td>
      <td id="productnameTip"></td>
	  <td>SEO标题</td>
      <td>
		<input name="seotitle" type="text" id="seotitle" size="25">
	  </td>
	  <td id="seotitleTip"></td>
    </tr>
    <tr>
      <td>产品型号：</td>
      <td> <input name="model" type="text" id="model" size="25"> </td>
      <td id="modelTip" > </td>
      <td>SEO关键词</td>
      <td><input name="seokeywords" type="text" id="seokeywords" size="25"></td>
      <td id="seokeywordsTip"></td>
    </tr>
    <tr>
      <td>货号：</td>
      <td> <input name="productnumber" type="text" id="productnumber" size="25"> </td>
      <td id="productnumberTip"> </td>
      <td>SEO描述</td>
      <td><input name="seodescription" type="text" id="seodescription" size="25"></td>
      <td id="seodescriptionTip"></td>
    </tr>    
    <tr>
      <td>是否推荐：</td>
      <td> 
      	<select id="recflag" name="recflag">
			<option value="1">推荐</option>
			<option value="0">不推荐</option>
		</select>
      </td>
      <td id="recflagTip"> </td>
      <td>品牌：</td>
      <td><input name="brand" type="text" id="brand" size="25"></td>
      <td id="brandTip"></td>
    </tr>
    <tr>
      <td>置顶权重：</td>
      <td> 
      	<select id="topscore" name="topscore">
			<option value="0">不置顶</option>
			<option value="1">置顶</option>
		</select>
      </td>
      <td id="topscoreTip"> </td>
      <td>计量单位：</td>
      <td><input name="unit" type="text" id="unit" size="25"></td>
      <td id="unitTip"></td>
    </tr>
    <tr>
      <td><label>上传图片：</label></td>
      <td colspan="5"><iframe width="70%" height="135" frameborder="0" id="show" name="show" 
			src="<%=basePath%>admin/util/uploadfile.jsp" scrolling="no" style="frameborder:0" align="left"></iframe></td>
	</tr>
    <tr>
      <td>内容 ：</td>
      <td colspan="5">					
		<%
			fckEditor.setValue("");
			out.println(fckEditor);
		%>
	 </td>    
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
