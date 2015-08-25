<%@ page language="java" import="java.util.*, net.fckeditor.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*" %>
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
    
    <title>My JSP 'productadd.jsp' starting page</title>
    
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
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
	</script>
	
	
	<script src="<%=basePath%>js/jquery_last.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		//$.formValidator.initConfig({onerror:function(){alert("校验没有通过，具体错误请看错误提示")}});
		$.formValidator.initConfig({formid:"productaddform",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
	
		$("#title").formValidator({tipid:"titleTip",onshow:"非空！",onfocus:"至少5个字",oncorrect:" "}).inputValidator({min:10,max:99,onerror:"输入不正确"});
		$("#origin").formValidator({tipid:"originTip",onshow:"非空！",onfocus:"至少1个字",oncorrect:" "}).inputValidator({min:2,max:99,onerror:"输入不正确"});
	});
	</script>
	
	
  </head>
    	<%
		FCKeditor fckEditor = new FCKeditor(request, "content");
	%>
  <body>

	
      <br>
      	<center><h5>产品添加</h5></center><hr>
    
      <!-- ----------表单开始-----------   -->
  <form action="admin/Product-add.action" method="post" id="productaddform" name="productaddform">
  <input type="hidden" name="categoryname" id="categoryname" value="">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="11%">标题：</td>
      <td width="20%"><input name="title" type="text" id="title" size="40">  </td>
      <td width="21%"><div id="titleTip" style="width:100px"> </div></td>
      <td width="10%">类别：</td>
      <td width="38%">
      	<select  name="categoryid" onchange="document.getElementById('categoryname').value=(document.getElementById('categoryid').options[(document.getElementById('categoryid')).selectedIndex].text);">
			<option value="0">根目录</option>
<%
CategoryManager categoryManager = CategoryManager.getInstance();
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
    </tr>

    <tr>
      <td>产品名称：</td>
      <td colspan="2"> <input type="text" name="productname"  size="40"> </td>
	  <td>SEO标题</td>
      <td>
		<input name="seotitle" type="text" id="seotitle" size="40">
	  </td>
    </tr>
    
    <tr>
      <td>产品型号：</td>
      <td> <input name="model" type="text" id="model" size="40"> </td>
      <td> <div id="originTip" style="width:100px"> </div></td>
      <td>SEO关键词</td>
      <td><input name="seokeywords" type="text" id="seokeywords" size="40"></td>
    </tr>
    
    <tr>
      <td>货号：</td>
      <td> <input name="productnumber" type="text" id="productnumber" size="40"> </td>
      <td> <div id="originTip" style="width:100px"> </div></td>
      <td>SEO描述</td>
      <td><input name="seodescription" type="text" id="seodescription" size="40"></td>
    </tr>    
    
    <tr>
      <td>是否推荐：</td>
      <td> 
      	<select name="recflag">
			<option value="1">推荐</option>
			<option value="0">不推荐</option>
		</select>
      </td>
      <td> <div id="originTip" style="width:100px"> </div></td>
      <td>品牌：</td>
      <td><input name="brand" type="text" id="brand" size="40"></td>
    </tr>
    <tr>
      <td>置顶权重：</td>
      <td> 
      	<select name="topscore">
			<option value="0">不置顶</option>
			<option value="1">置顶</option>
		</select>
      </td>
      <td> <div id="originTip" style="width:100px"> </div></td>
      <td>计量单位：</td>
      <td><input name="unit" type="text" id="unit" size="40"></td>
    </tr>
    
   
    
    <tr>
      <td><label>上传图片：</label></td>
      <td colspan="4"><iframe width="70%" height="135" frameborder="0" id="show" name="show" 
			src="<%=basePath%>admin/util/uploadfile.jsp" scrolling="no" style="frameborder:0" align="left"></iframe></td>
	</tr>
    <tr>
      <td>内容 ：</td>
      <td colspan="4">					
		<%
			fckEditor.setValue("");
			out.println(fckEditor);
		%>
	 </td>    
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="2"><input type="submit" name="submit" value="提交">
        <input type="reset" name="reset" value="重填"></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
