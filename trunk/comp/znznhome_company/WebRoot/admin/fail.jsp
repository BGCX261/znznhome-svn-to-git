<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="css/yly_loginfail.css" />
  </head>
  
  <body>
    <div class="yly_container">
	<div class="yly_logo">
   		<span><a href="#" target="_blank"><img src="images/yly_logo.gif" alt="" width="257" height="44" /></a></span>
        <span><img src="images/yly_adimg2.jpg" alt="" width="663" height="58" /></span>
    	<div class="clearfloat"></div>
    </div>
    <div class="yly_banner">
    	<div class="banner_one">
       <div class="banner_left">
        <span><a href="yly_home.html">首页</a></span>
        <span><a href="#" target="_blank">社区</a></span>
      </div>
        </div>
        <div class="banner_two">
        	<span>最新加入养老院：</span>
          <span style="width:820px;"><marquee scrollamount="3" onmouseover="stop();" onmouseout="start();">
                <a href="#" target="_blank">北京市第一社会福利院</a>
                <a href="#" target="_blank">北京吉安老年护理院</a>
                <a href="#" target="_blank">北京市东城区老年公寓</a>
                <a href="#" target="_blank">北京市英智康复老年护</a>
                <a href="#" target="_blank">北京市爱德敬老院</a>
                <a href="#" target="_blank">北京市京香安老院</a>
            </marquee></span>
        </div>
    </div>
    <div class="ylyloginfail_main">
    	<p><img src="images/ylyloginfail_mainbg.gif" alt="" align="absmiddle" /> 操作失败，请重试！</p>
        <p><input type="button" value="返 回" onclick="javascript:history.go(-1);location.reload();"/></p>
    </div>
    <div class="clearfloat"></div>
</div>
<iframe src="footer.html" frameBorder="0" width="964" height="251" scrolling="no"></iframe>
  </body>
</html>
