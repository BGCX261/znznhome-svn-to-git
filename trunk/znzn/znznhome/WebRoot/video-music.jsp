<%@ page language="java" import="java.util.*, java.net.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">  
    
    <title>图片网址列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/znzn-main.css" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/homepage/thickbox_plus.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<link rel="stylesheet" type="text/css" href="css/thickbox.css"/>
	<link rel="stylesheet" type="text/css" href="css/znzn_base.css"/>
	<script type="text/javascript" src="js/znzn_base.js" />
	<script type="text/javascript">
		function urlChinese(name){ 
   			return encodeURI(name); 
		} 
	</script>
	
  </head>
  
<body>
<%@ include file="head.jsp" %>
<!-- <iframe height="50" width="500" src="menu.html"></iframe> -->

<div class="clearfloat"></div>

<div class="content">

<div class="content_left">
<%
ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
UrlManager urlManager = (UrlManager)ctx.getBean("urlManager");
ConfigMap configMap = ConfigMap.getInstance();
List<String> categoryNames = configMap.getCategoryNamesListVideo();
List<Category> categorys = new ArrayList<Category>();
categorys =  categoryManager.getAllByNameList(categoryNames);


for(int i=0; i<categorys.size(); i++) {
	int cid = categorys.get(i).getId();
	String name = categorys.get(i).getName();
%>

<div class="spdp">
<div class="title"><span class="span_categoryname"><a href="url-list?categoryid=<%=cid %>" target="_self"><%=name %></a></span><span class="span_add"><a href="urladd.jsp?height=340;width=520&categoryid=<%=cid %>&categoryname=<%=URLEncoder.encode(name, "utf-8") %>" class="thickbox">添加</a></span></div>

<%
	List<Url> urls = new ArrayList<Url>();
	String urlSql = "select * from znzn_url where categoryid = " + cid + " order by createtime desc limit 0,15";
	urls = urlManager.loadBySQL(urlSql);
	for(int j=0; j<urls.size(); j++) {
		Url url = (Url)urls.get(j);
		long id = url.getId();
		String title = CommonUtil.filterHtmlAndSubStr(url.getTitle(), 11);
		String CategoryName = url.getCategoryname();
		String descr = url.getDescr();
		String urlAddress = url.getUrladdress();
%>
  <div class="urllist">
    <span class="span_belong">[小说下载]</span>
    <span  class="span_urltitle"><a id="url-<%=id %>" href="http://znznhome.com?name=中文" target="_blank" class="url_title"  onmouseover="showDescr('url-<%=id %>', 'descr-<%=id %>', event)"  ><%=title %></a></span>
    <div id="descr-<%=id %>" class="znzn_descr znzn_disable"><%=descr %></div>
    <span class="span_time">2012/08/15</span>

    <span class="span_common"><a href="http://www.baidu.com" target="_blank" class="bg1">1500</a></span>
    <span class="span_common"><a href="http://www.sohu.com" target="_blank" class="bg2">300</a></span>
    <span class="span_common"><a href="http://www.tom.com" target="_blank" class="bg3">566</a></span>
  </div>
<%
			
	}
%>
</div>
<%
}
%>
 </div>

<div class="content_right">
	<div class="ad"><img width="174px" src="images/ad/ad1.gif"/></div>
	<div class="ad"><img width="174px" src="images/ad/ad2.gif"/></div>
</div>
</div>
<div class="clearfloat"></div>
<div class="footerw"></div>
<%@ include file="foot.jsp" %>
</body>
</html>