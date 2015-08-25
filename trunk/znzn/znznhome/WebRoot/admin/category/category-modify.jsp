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
    <title>网址列表目录添加</title>
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
			$.formValidator.initConfig({formID:"categorymodifyform",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#pid").formValidator({onShow:"请选择父目录",onFocus:"父目录为必选项，可以是根目录",onCorrect:"输入正确"});
			$("#name").formValidator({onShow:"请输入目录名",onFocus:"请注意目录名为2~20位中文字符，例如:新闻",onCorrect:"输入正确"}).inputValidator({min:4,max:40,onError:"目录长度应为2~20位，输入不正确"});
			$("#ename").formValidator({onShow:"请输入目录英文名",onFocus:"请注意英文名为2~20位，例如:company_news",onCorrect:"输入正确"}).regexValidator({regExp:"username",dataType:"enum",onError:"目录英文名格式不正确"}).inputValidator({min:2,max:20,onError:"目录英文名长度应为2~20位，输入不正确"});
			$("#categorycoding").formValidator({onShow:"请输入你的目录编码",onFocus:"请注意编码为12位数字，例如:001002003004",onCorrect:"输入正确"}).regexValidator({regExp:"^\\d{12}$", dataType:"string", onError:"目录编码格式不正确"}).inputValidator({min:12,max:12,onError:"目录编码长度应为12位，输入不正确"});
			$("#checkbut").bind('click',function(){$.ajax({url:'admin/ajax/checkCategoryEname.jsp', data:{ename: $("#ename").val()}, success:function(data){$("#enameTip").html(data);}  }); }	);
		});
	</script>
  </head>
  
  <body>
<%
		String id = request.getParameter("id");
	  	request.setCharacterEncoding("utf-8");
	  	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	  	CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
		Category c = new Category();
		c = categoryManager.loadByID(Integer.parseInt(id));	
		String name = c.getName();
		String ename = c.getEname();
		String categorycoding = c.getCategorycoding();
		int pid = c.getPid();
		String descr = c.getDescr();
%>
        <br/><div id="tableTitle" class="tableTitle">修改目录分类信息</div><hr><br/>

  	<form action="admin/category-modify" method="post" id="categorymodifyform" name="categorymodifyform">
  	<input type="hidden" name="categoryID" value="<%=id %>">
	  <table width="90%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td width="10%">父目录：</td>
	      <td width="25%">
      	<select id="pid"  name="pid" >
			<option value="0">根目录</option>
<%
List<Category> list = new ArrayList();
list = categoryManager.getAllChilds(list,0); 
if (list.size() != 0) {
	for(int i=0; i<list.size(); i++) {
		Category category = list.get(i);
		int id_0 = category.getId();
		String name_0 = category.getName();
		int grade_0 = category.getGrade();
		String pre_str = "";
		for(int j=0; j<grade_0; j++) {
			pre_str = pre_str + "|----";
		}
%>

            <option value="<%=id_0 %>"><%=pre_str + name_0 %></option>
            
<%
	}//for(int i=0; i<categoryList.size(); i++) {    
}//if (list.size() != 0) {
%>
        </select> 
	                <script type="text/javascript">
			        	$("#pid")[0].value="<%=pid %>";
			        </script>
	      </td>
	      <td width="65%"  id="pidTip" ></td>
	    </tr>
	    <tr>
	      <td>目录名称：</td>
	      <td>
	      <input name="name" type="text" id="name" size="20" value="<%=name %>">
	      </td>
	      <td  id="nameTip" > </td>
	    </tr>
	    <tr>
	      <td>目录英文名：</td>
	      <td>
	      <span><input name="ename" type="text" id="ename" size="20" value="<%=ename %>">
	      <input id="checkbut" name="checkbut" value="check" type="button"></span>
	      </td>
	      <td  id="enameTip" ></td>
	    </tr>
	    <tr>
	      <td>目录编码：</td>
	      <td>
	      <input name="categorycoding" type="text" id="categorycoding" size="20" value="<%=categorycoding %>">
	      </td>
	      <td  id="categorycodingTip" > <div id="abc"></div></td>
	    </tr>
	    <tr>
	      <td>目录描述：</td>
	      <td> <input name="descr" type="text" id="descr" size="20" value="<%=descr %>"> </td>
	      <td id="descrTip"></td>
	    </tr>
	  </table>
		<br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" name="submit" value="修改"> &nbsp;&nbsp;<input type="reset" name="reset" value="重填"></td>
	    </div>	  
  	</form>    
  </body>
</html>
