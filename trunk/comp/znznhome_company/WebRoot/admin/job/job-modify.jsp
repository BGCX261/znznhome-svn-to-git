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
    
    <title>My JSP 'newsadd.jsp' starting page</title>
    
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
		$.formValidator.initConfig({formid:"newsaddform",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
	
		$("#title").formValidator({tipid:"titleTip",onshow:"非空！",onfocus:"至少5个字",oncorrect:" "}).inputValidator({min:10,max:99,onerror:"输入不正确"});
		$("#origin").formValidator({tipid:"originTip",onshow:"非空！",onfocus:"至少1个字",oncorrect:" "}).inputValidator({min:2,max:99,onerror:"输入不正确"});
	});
	</script>
	
	
  </head>
    	<%
		FCKeditor fckEditor = new FCKeditor(request, "intro");
	%>
  <body>

    <%
    	String id = request.getParameter("id");
    	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	JobManager nm = (JobManager)ctx.getBean("jobManager");
    	Job job = new Job();
    	job = nm.loadByID(Integer.parseInt(id));	
    	
    	String position = job.getPosition();
    	String field = job.getField();
    	String location = job.getLocation();
    	String totalnumber = job.getTotalnumber();
    	String daytime = job.getDaytime();
    	String intro = job.getIntro();
    	int stateflag = job.getStateflag();
    %>
	
      <br>
      	<center><h5>职位修改</h5></center><hr>
    
      <!-- ----------表单开始-----------   -->
  <form action="admin/job-modify" method="post" id="jobmodifyform" name="jobmodifyform">
  <input name="jobID" value="<%=id %>" type="hidden">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="11%">职位名称：</td>
      <td width="20%"><input name="position" type="text" id="position" size="40" value="<%=position %>">  </td>
      <td width="21%"><div id="titleTip" style="width:100px"> </div></td>
      <td width="10%">招聘人数：</td>
      <td width="20%">
      	<select id="totalnumber" name="totalnumber">
			<option value="1人">1人</option>
			<option value="2人">2人</option>
			<option value="3人">3人</option>
			<option value="4人">4人</option>
			<option value="5人">5人</option>
			<option value="若干">若干</option>
		</select> 
				<script type="text/javascript">
					document.getElementById("totalnumber").value="<%=totalnumber %>";
				</script>
		 
      </td>
      <td width="18%"><div id="titleTip" style="width:100px"> </div></td>
      
    </tr>

    <tr>
      <td>所需专业：</td>
      <td colspan="2"> <input type="text" name="field"  size="40" value="<%=field %>"> </td>
	  <td>工作地点</td>
      <td>
		<input name="location" type="text" id="location" size="40" value="<%=location %>">
	  </td>
	  <td><div id="titleTip" style="width:100px"> </div></td>
    </tr>
    
    <tr>
      <td>招聘时间：</td>
      <td> <input name="daytime" type="text" id="daytime" size="40" value="<%=daytime %>"> </td>
      <td> <div id="originTip" style="width:100px"> </div></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
   
    <tr>
      <td>职位说明：</td>
      <td colspan="5">					
		<%
			fckEditor.setValue(intro);
			out.println(fckEditor);
		%>
	 </td>    
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="2"><input type="submit" name="submit" value="提交">
        <input type="reset" name="reset" value="重填"></td>
      <td>&nbsp;</td>
      <td colspan="2">&nbsp;</td>
    </tr>
  </table>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
