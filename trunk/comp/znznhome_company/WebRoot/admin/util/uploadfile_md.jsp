<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*, com.opensymphony.xwork2.ActionContext" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

    <head>

		<base href="<%=basePath%>">
       <title>上传文件</title>

       <meta http-equiv="Content-Type" content="text/html; charset=GB18030">

       <meta http-equiv="pragma" content="no-cache">

       <meta http-equiv="cache-control" content="no-cache">

       <script language="JavaScript" type="text/javascript">

       function upload()

       {     

           var filename = document.tab.uploadfile.value;

           if (filename=='')

           {

               alert("没有选择要上传的文件，请选择!");

               return;

           }


           document.tab.action = "admin/FileUpload";//提交上传为文件时，所指向的servlet配置的Servlet动作

           document.tab.target="show";//指向iframe的ID，即刷新页面返回时所指的地方。

           document.tab.submit();     

          

       }

    </script>

    </head>

    <body style="margin:0px;">
<%
ActionContext actionContext = ActionContext.getContext();
Map session2 = actionContext.getSession();
String str_picurl = (String)session2.get("picurl_md");
%>
       <form name="tab" method="post" action="" enctype="multipart/form-data">
       
			<img id="img1" src="<%=basePath%>upload/<%=str_picurl %>" style="position: static; height:100px; width:100px;" /><br>
       
           <input type="file" id="uploadfile" name="uploadfile" style="border:1px solid black;" onchange="document.getElementById('img1').src=this.value;">

           <input type="button" name="up" value="上传" style="border:1px solid black;height:20px;" onClick="upload()">

       </form>   

    </body>

</html>


