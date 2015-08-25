<%@ page language="java" import="java.util.*, java.net.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<%
//分频道
String channel = request.getParameter("channel");
ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
UrlManager urlManager = (UrlManager)ctx.getBean("urlManager");
ConfigMap configMap = ConfigMap.getInstance();
List<String> categoryNames = configMap.getChannelCategoryName(channel);
List<Category> categorys = new ArrayList<Category>();
categorys =  categoryManager.getAllByNameList(categoryNames);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">  
    
    <title>图片网址列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
	<script type="text/javascript" src="js/znzn_base.js" ></script>
	
	
  </head>
  
<body>
<%@ include file="head.jsp" %>
<!-- <iframe height="50" width="500" src="menu.html"></iframe> -->

<div class="clearfloat"></div>

<div class="content">

<div class="content_left">
<%
  String str_categoryid = request.getParameter("categoryid");
  int ctgid = 0;
  if(CommonUtil.isNotEmpty(str_categoryid)) ctgid = Integer.parseInt(str_categoryid);
  Category category = categoryManager.loadByID(ctgid);
  String ctgname = category.getName();
  String intName = CommonUtil.chString2CharArray2intString(ctgname);
  Page url_page = (Page)request.getAttribute("page");
  int pageNo = url_page.getPageNo();
  int totalPages = url_page.getTotalPages();

  List<Url> urls = url_page.getList();
  Member member = (Member)session.getAttribute("member");
  %>
<div class="spdp expend_">
<div class="title">
	<span class="span_categoryname">
		<%=ctgname %>
	</span>
	<span class="span_add">
		<a href="urladd.jsp?height=340;width=520&categoryid=<%=ctgid %>&categoryname=<%=intName %>" class="thickbox">添加</a>
	</span>
	<span class="span_delete">
		<a onclick="test1();" id="batch_delete">删除</a>
	</span>
</div>

<%
	
	for(int j=0; j<urls.size(); j++) {
		Url url = (Url)urls.get(j);
		long id = url.getId();
		String title = CommonUtil.filterHtmlAndSubStr(url.getTitle(), 30);
		String CategoryName = url.getCategoryname();
		String descr = url.getDescr();
		String tags = url.getTags();
		String urlAddress = url.getUrladdress();
		String createtime = CommonUtil.getTime(url.getCreatetime());
		int memberId = url.getMemberid();
		long up = url.getUp();
		long down = url.getDown();
		long click = url.getClickrate();
%>
  <div class="urllist">
  <%
  		if(CommonUtil.isNotEmpty(member) && member.getId() == memberId){
  %>
  	<span class="span_checkbox"><input type="checkbox" id="urlIDs" name="urlIDs" value="<%=id %>"/></span>
  	<span class="span_tags2">[<%=tags %>]</span>
  <%		
  		}else{
  %>
  	<span class="span_tags">[<%=tags %>]</span>
  <%
  		}
  %>
    <span  class="span_urltitle"><a onclick="znzn_click(<%=id %>)" id="url-<%=id %>" href="<%=urlAddress %>" target="_blank" class="url_title"  onmouseover="showDescr('url-<%=id %>', 'descr-<%=id %>', event)"  ><%=title %></a></span>
    <div id="descr-<%=id %>" class="znzn_descr znzn_disable"><%=descr %></div>
    <span class="span_time"><%=createtime %></span>

	<span onclick="znzn_up(<%=id %>)" class="span_common"><a id="up_<%=id %>" target="_self" class="bg1"><%=up %></a></span>
    <span onclick="znzn_down(<%=id %>)" class="span_common"><a id="down_<%=id %>"  target="_self" class="bg2"><%=down %></a></span>
    <span class="span_common"><span id="click_<%=id %>" class="bg3"><%=click %></span></span>
    

  </div>
<%
			
	}
%>
</div>

	<div class="pages">
		<a href="url-list?categoryid=<%=ctgid %>&pageSize=<%=Constant.PAGESIZE %>&pageNo=<%=pageNo-1%>" target="_self"><</a>
	<%
	  
	  int pre = 0;
	  int index = 1;
	  int last = 6;
	  
	  if(totalPages < 6) {
		  for(int i=0; i<totalPages; i++) {
			  if(pageNo > 4){
				  pre = pageNo - 3;
			  }
			  %>
			  <a <%=(pageNo == index + pre ? "class=\"current_\"" : "") %> href="url-list?categoryid=<%=ctgid %>&pageSize=<%=Constant.PAGESIZE %>&pageNo=<%=index + pre%>" target="_self"><%=index + pre %></a>
			  <%	  
			  index++;
		  }
	  }else if(pageNo < (totalPages-3) && totalPages >= 6) {
		  for(int i=0; i<6; i++) {
			  if(pageNo > 4){
				  pre = pageNo - 3;
			  }
				  %>
				  <a <%=(pageNo == index + pre) ? "class=\"current_\"" : "" %> href="url-list?categoryid=<%=ctgid %>&pageSize=<%=Constant.PAGESIZE %>&pageNo=<%=index + pre%>" target="_self"><%=index + pre %></a>
				  <%=i == 5 ? "<p >...</p>" : "" %>
				  <%		  
			  index++;
		  }
	  }else if (pageNo >= (totalPages-3) && totalPages >= 6) {
		  for(int i=0; i<6; i++) {
				  %>
				  <a <%=(pageNo == totalPages - (6-i) + 1 ? "class=\"current_\"" : "") %> href="url-list?categoryid=<%=ctgid %>&pageSize=<%=Constant.PAGESIZE %>&pageNo=<%=totalPages - (6-i) + 1%>" target="_self"><%=totalPages - (6-i) + 1 %></a>
				  <%
		  }
		  
	  }
	  
	%>
		<a href="url-list?categoryid=<%=ctgid %>&pageSize=<%=Constant.PAGESIZE %>&pageNo=<%=pageNo+1%>" target="_self">></a>
	</div>
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