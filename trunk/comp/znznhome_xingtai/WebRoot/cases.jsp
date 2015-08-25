<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String id = (String)request.getParameter("id");
if(id == null) {
	out.print("访问方式出错！");
	return;
}
ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CasesManager casesManager = (CasesManager)ctx.getBean("casesManager");
CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
Cases cases = casesManager.loadByID(Integer.parseInt(id));

		int categoryid = cases.getCategoryid();
		String ename = categoryManager.getEnameByID(categoryid);
		String categoryname = cases.getCategoryname();
		String title = cases.getTitle();
		String picurl = cases.getPicurl();
		String content = cases.getContent();
		String seotitle = cases.getSeotitle();
		String seokeywords = cases.getSeokeywords();
		String seodescription = cases.getSeodescription();
		int topscore = cases.getTopscore();

		
		if(seotitle == null || seotitle.trim().equals("")) {
			seotitle = "北京宅男宅女商贸有限公司 | 公司动态";
		}
		
		if(seokeywords == null || seokeywords.trim().equals("")) {
			seokeywords = "北京宅男宅女商贸有限公司 ,公司动态";
		}
		
		if(seodescription == null || seodescription.trim().equals("")) {
			seodescription = "北京宅男宅女商贸有限公司 ,公司动态";
		}
		String createtime = CommonUtil.getTime(cases.getCreatetime());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>星泰龙森（北京）机械设备有限公司</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=seokeywords %>">
	<meta http-equiv="description" content="<%=seodescription %>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/xtls_index.css" />
<script type="text/javascript" src="js/sla.js"></script>
</head>
<body>
<div class="topw">
  <div class="top" id="top">
    <ul class="sc">
      <li><a href="index.jsp" target="_self">首页</a>｜<a href="contact.jsp" target="_self">联系我们</a>｜<a href="javascript:window.external.AddFavorite('http://www.zhenkongbengnet.com','星泰龙森（北京）机械设备有限公司')">加入收藏</a></li>
    </ul>
    <div class="clearfloat"></div>
    <div class="ss">
      <table border="0">
        <tr>
          <td><input onclick="javascript:this.value=''" id="bdsearch" name="bdsearch" class="input1" type="text" value="请输入关键字.." /></td>
          <td><input class="input2" onclick="baidusearchTop();" name="" type="button" /></td>
        </tr>
      </table>
    </div>
  </div>
</div>
<ul class="daohang">
  <li class="bg1"><a href="about.jsp" target="_self">关于我们</a></li>
  <li class="bg2"><a href="news-list?ename=news01" target="_self">新闻中心</a></li>
  <li class="bg2  ts2"><a href="cases-list?ename=cases01" target="_self">工程案例</a></li>
  <li class="bg2"><a href="product-list?ename=product01" target="_self">产品中心</a></li>
  <li class="bg2"><a href="feedBack-list" target="_self">在线咨询</a></li>
  <li class="bg2"><a href="hr_list.jsp" target="_self">人才招聘</a></li>
  <li class="bg3"><a href="contact.jsp" target="_self">联系我们</a></li>
</ul>
<div class="jdt">
       <!-- 焦点图2 -->
      <div class="focus">
        <div class="sliderwrapper" id="slider">
          <div class="contentdiv" style="display:block; opacity:1; visibility: visible;"><a target="_blank"><img src="images/add1.jpg" alt=""/></a></div>
          <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a  target="_blank"><img src="images/add2.jpg" alt=""  /></a></div>
          <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a target="_blank"><img src="images/add3.jpg" alt=""/></a></div>
        </div>
        <div class="pagination" id="paginate-slider"> <a class="toc"  rel="1">1</a> <a class="toc" rel="2">2</a><a class="toc" style=" border-right:none;" rel="3">3</a> </div>
      </div>
      <div class="clearfloat"></div>
      <!-- 焦点图2 -->
</div>
<div class="clearfloat"></div>
<div class="content">
  <div class="leftcon"><div style=" margin:0 auto; width:159px;"><img style="padding-top:16px;" src="images/con2.jpg"  width="159" height="44"/></div>
    <ul class="ldhbf">
<%
	String claz01 = "", claz02 = "", claz03 = "", claz04 = "", claz05 = "", claz06 = "", claz07 = "", claz08 = "";
	if(ename.equals("cases01")) {
		claz01 = " class=\"fsxg\" ";
	}else if(ename.equals("cases02")) {
		claz02 = " class=\"fsxg\" ";
	}else if(ename.equals("cases03")) {
		claz03 = " class=\"fsxg\" ";
	}else if(ename.equals("cases04")) {
		claz04 = " class=\"fsxg\" ";
	}else if(ename.equals("cases05")) {
		claz05 = " class=\"fsxg\" ";
	}else if(ename.equals("cases06")) {
		claz06 = " class=\"fsxg\" ";
	}else if(ename.equals("cases07")) {
		claz07 = " class=\"fsxg\" ";
	}else if(ename.equals("cases08")) {
		claz08 = " class=\"fsxg\" ";
	}
%>    
	  <li><a <%=claz01 %> href="cases-list?ename=cases01" target="_self">电子行业 </a></li>
      <li><a <%=claz02 %> href="cases-list?ename=cases02" target="_self">医疗行业</a></li>
	  <li><a <%=claz03 %> href="cases-list?ename=cases03" target="_self">真空包装 </a></li>
      <li><a <%=claz04 %> href="cases-list?ename=cases04" target="_self">制造行业</a></li>	  
      <li><a <%=claz05 %> href="cases-list?ename=cases05" target="_self">印刷行业 </a></li>
      <li><a <%=claz06 %> href="cases-list?ename=cases06" target="_self">航空航天</a></li>
	  <li><a <%=claz07 %> href="cases-list?ename=cases07" target="_self">污水处理 </a></li>
      <li><a <%=claz08 %> href="cases-list?ename=cases08" target="_self">真空搬运</a></li>
    </ul>
  </div>
  <div class="rightcon"><div class="lxwbt2">案例介绍</div>  <div class="rightcon1"> 
  <div class="bt1"><%=title %></div>
  <div class="bt2"><%=createtime %> </div>
     <%
	if(picurl != null && !picurl.trim().equals("")) {
%>
<center><div class="img"><img src="upload/<%=picurl %>" width="445" height="340" /></div></center>
<%
	}
  %>
  <%=content %> 
</div>
  </div><div class="clearfloat"></div>
</div>
<div class="clearfloat"></div>
<div class="footer">
  <div class="footern">
    <ul class="ftbf ftbf1">
      <li><img class="l" src="images/lx1.jpg" />
       <div class="bt1">星泰龙森（北京）机械设备有限公司</div> <div style="height:5px;"></div>
        <p>电话：010-69759338 18601227856<br/>
          地址：北京市朝阳区北辰西路峻峰华亭C座<br />
          电邮：xingtailongsen@hotmail.com<br />
          传真：010-69759338<br />
          <a href="contact.jsp" target="_blank"><img src="images/xt4.jpg" /></a><br />
        </p>
      </li>
    </ul>
    <ul class="ftbf ftbf1">
      <li><img  class="l" src="images/lx2.jpg" /> <div style="height:5px;"></div>
        <p>如果您对我们的产品有任何意见获建议，都可以给我们留言，
          我们会在第一时间给您答复！<br /> <div style="height:5px;"></div>
        <a href="feedBack-list" target="_blank"><img src="images/xt3.jpg" /></a><br />
        </p>
      </li>
    </ul>
    <ul class="ftbf ftbf2">
      <li><img  class="l" src="images/lx3.jpg" /><div style="height:5px;"></div>
        <p>您还可以在线联系我们的客服<div style="height:5px;"></div>
        <img src="images/xt2.jpg" border="0" usemap="#Map" />
<map name="Map" id="Map">
  <area shape="circle" coords="21,20,17" /><area shape="circle" coords="60,19,16" href="feedBack-list" /><area shape="circle" coords="101,20,18" href="contact.jsp" />
<area shape="circle" coords="141,19,18" href="#" />
</map>
		<a href="#top"> <img style="margin-top:62px;_margin-top:28px; float:right; display:inline; margin-right:15px;" src="images/xt5.jpg" /></a>
        </p>
      </li>
    </ul>
  </div>
<div class="clearfloat"></div>
<div class="bqbf">
<div class="l">Copyright © 2009 XING TAI LONG SEN BEIJING. All Rights Reserved   星泰龙森 版权所有    TEL: 010-69759338</div>
<div class="r">备案序号:京ICP备12018132号-1</div>
</div>
</div>
</body>
</html>
<script>
 featuredcontentslider.init({
id: "slider",
contentsource: ["inline", ""],
revealtype: "mouseover",
enablefade: [true, 0.2],
autorotate: [true, 3000],
onChange: function(previndex, curindex){}
})

 </script>
<!-- 焦点图1 -->