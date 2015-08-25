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
	<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
	<link type="text/css" rel="stylesheet" href="css/admin/validator.css"></link>
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator-4.0.1.min.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$(function(){
			$.formValidator.initConfig({formID:"urlmodifyform",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#title").formValidator({onShow:"请输入标题",onFocus:"请注意标题为4个中文以上",onCorrect:"输入正确"}).inputValidator({min:8,onError:"标题长度应为4位以上，输入不正确"});
			//$("#origin").formValidator({onShow:"请输入来源",onFocus:"请注意来源为2个中文以上",onCorrect:"输入正确"}).inputValidator({min:4,onError:"来源长度应为2位以上，输入不正确"});
			$("#categoryid").formValidator({onShow:"请选择目录分类",onFocus:"目录必须选择",onCorrect:"输入正确"}).inputValidator({min:1,onError: "请选择目录分类，不能选根目录"});
			$("#title").formValidator({onShow:"请输入标题",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:80,onError:"<font color='red'>最少4位</font>"});
			$("#tags").formValidator({onShow:"请输入标签",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:8,onError:"<font color='red'>2~4个字</font>"});
			$("#urladdress").formValidator({onShow:"请输入链接",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:200,onError:"<font color='red'>最少4位</font>"});
			
			$("#categoryid").bind("change", function(){$("#categoryname")[0].value=($("#categoryid")[0].options[$("#categoryid")[0].selectedIndex].text);}  );
			
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
	u = um.loadByID(Long.parseLong(id));	
	int categoryid = u.getCategoryid();
    String title = u.getTitle();
    String urladdress = u.getUrladdress();
    String descr = u.getDescr();
    int recflag = u.getRecflag();
    String origin = u.getOrigin();
    String categoryName = u.getCategoryname();
    Timestamp createtime = u.getCreatetime();
    String idAndName = categoryid + "#" + categoryName;
 %>
<br/><div id="tableTitle" class="tableTitle">修改网址列表</div><hr><br/>

      <!-- ----------表单开始-----------   -->
  <form action="admin/url-modify" method="post" id="urlmodifyform" name="urlmodifyform">
  <input name="urlID" value="<%=id %>" type="hidden">
  <input type="hidden" name="categoryname" id="categoryname">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">标题：</td>
      <td width="18%"><input id="title" name="title" type="text" id="pcode" value="<%=title %>" size="25">  </td>
      <td width="24%"  id="titleTip" ></td>
      <td width="8%">类别：</td>
      <td width="18%">
      	<select id="idandname" name="idandname">
			<option value="0">根目录</option>
<%
	CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
	List<Category> list = new ArrayList();
	list = categoryManager.getAllChilds(list,0); 
	if (list.size() != 0) {
		for(int i=0; i<list.size(); i++) {
			Category category = list.get(i);
			int id_c = category.getId();
			String name = category.getName();
			int grade = category.getGrade();
			String pre_str = "";
			for(int j=0; j<=grade; j++) {
				pre_str = pre_str + "|----";
			}
%>

            <option value="<%=id_c%>#<%=name %>"><%=pre_str + name %></option>
            
<%
		}//for(int i=0; i<categoryList.size(); i++) {    
	}//if (list.size() != 0) {
%>
        </select>  
        		<script type="text/javascript">
					$("#idandname")[0].value="<%=idAndName %>";
				</script>
       </td>
       <td width="24%"  id="categoryidTip" ></td>
    </tr>

    <tr>
      <td>URL地址：</td>
      <td> <input name="urladdress" type="text" id="urladdress" value="<%=urladdress %>" size="25"> </td>
      <td  id="urladdressTip" > </td>
      <td>推荐方式:</td>
      <td>
	    <select name="recflag">
			<option value="0" selected>不推荐</option>
			<option value="1">加精</option>
			<option value="2">变红</option>
			<option value="3">变绿</option>
		</select>
				<script type="text/javascript">
					$("#recflag")[0].value="<%=recflag %>";
				</script>
	  </td>
	  <td id="" ></td>
    </tr>
    

    <tr>
      <td>标签：</td>
      <td> <input name="tags" type="text" id="tags" value="<%=descr %>" size="25"> </td>
      <td  id="tagsTip" > </td>
      <td>来源：</td>
      <td><input name=origin type="text" id="origin" value="<%=origin %>" size="25"></td>
	  <td id="originTip"></td>
    </tr>
    
	<tr>
      <td>简评：</td>
      <td colspan="2"> <textarea name="descr" id="descr" rows="4" cols="50"><%=descr %></textarea> </td>
      <td></td>
      <td></td>
	  <td></td>
    </tr>
	

  </table>
  		<br>
	    <div id="suojin" class="suojin1">
	    <input type="submit" name="submit" value="修改"> &nbsp;&nbsp;<input type="reset" name="reset" value="重填"></td>
	    </div>	  
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
