<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*,  java.text.SimpleDateFormat" %>

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
NewsManager newsManager = NewsManager.getInstance();
News news = newsManager.loadByID(Integer.parseInt(id));

		int categoryid = news.getCategoryid();
		String categoryname = news.getCategoryname();
		String title = news.getTitle();
		String picurl = news.getPicurl();
		String content = news.getContent();
		String seotitle = news.getSeotitle();
		String seokeywords = news.getSeokeywords();
		String seodescription = news.getSeodescription();
		int topscore = news.getTopscore();
		String author  = news.getAuthor();
		String origin = news.getOrigin();

		
		if(seotitle == null || seotitle.trim().equals("")) {
			seotitle = "北京鸿屹昌达商贸有限公司 | 公司动态";
		}
		
		if(seokeywords == null || seokeywords.trim().equals("")) {
			seokeywords = "北京鸿屹昌达商贸有限公司 ,公司动态";
		}
		
		if(seodescription == null || seodescription.trim().equals("")) {
			seodescription = "北京鸿屹昌达商贸有限公司 ,公司动态";
		}

    	//处理一下日期格式
		Timestamp ts = news.getCreatetime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String createtime = sdf.format(ts);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title><%=seotitle %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=seokeywords %>">
	<meta http-equiv="description" content="<%=seodescription %>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=basePath%>js/bdsearch.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/hy3-con.css" />
</head>
<body>
<div class="topht">
  <div class="topleft"><img src="images/logo.gif" width="217" height="53"/></div>
  <div class="topright"><span><a href="index.jsp" target="_self">主页</a><a href="#" target="_self">合作伙伴</a><a style="margin-right:0px;" href="contact.jsp" target="_self">联系我们</a></span>
    <div class="ss">
      <input name="" class="input" id="bdsearch" name="bdsearch" type="text" value="请输入关键字.." onclick="javascript: document.getElementById('bdsearch').value=''" />
      <input class="btn" onclick="baidusearchTop();" name="" type="button" />
    </div>
    <div class="clearfloat"></div>
    <div id="daohang1" class="daohang"><a class="bg1 fsxg1" href="index.jsp" target="_self">首 页 </a><a class="bg2" href="changda_about.jsp" target="_self">关于我们</a><a class="bg2" href="News-list.action?categoryid=4&countNumber=7" target="_self">公司动态</a><a class="bg2" href="Product-list.action?categoryid=17&countNumber=20" target="_self">产品展示</a><a class="bg2" href="Cases-list.action?categoryid=10&countNumber=5" target="_self">案例分享</a><a class="bg2" href="Job-list.action?countNumber=9" target="_self">招聘中心</a><a class="bg3" href="contact.jsp" target="_self">联系方式</a></div>
  </div>
</div>

    <!-- 改变两个导航的样式 -->
    <script language="javascript">
    document.getElementById("daohang1").getElementsByTagName("a")[2].className="bg2 fsxg";
    </script>

<div class="clearfloat"></div>
<div class="con1w">
  <div class="con1">
    <div class="leftcon">
<a href="#" target="_blank"><img src="images/add.jpg" alt="" width="740" height="153" /></a>
    </div>
    <div class="rightcon r">
      <div class="add"><a href="#" target="_blank"><img src="images/add1.jpg" width="214" height="153" /></a></div>
    </div>
  </div>
</div>
<div class="con2">
<div class="leftcon l">
 <div class="title">您当前的位置：<a href="index.jsp" target="_self">首页</a> > <a class="ra" href="News-list.action?categoryid=4&countNumber=7" target="_self">公司动态</a> > <a href="News-list.action?categoryid=<%=categoryid %>&countNumber=7" target="_blank"><%=categoryname %></a> </div>
   <div class="midcon1 midcon4">
   <div class="bt1"><%=title %></div>
    <div class="bt2">时间：<%=createtime %>&nbsp;&nbsp;&nbsp;&nbsp; 来源：<%=origin %> nbsp;&nbsp;&nbsp;&nbsp; 作者：<%=author %>&nbsp;&nbsp;&nbsp;&nbsp; </div>
  <%
	if(picurl != null && !picurl.trim().equals("")) {
%>
<div class="img"><img src="upload/<%=picurl %>" width="445" height="340" /></div>
<%
	}
  %>
  
<%=content %> 
	
	
<!--<div class="xmxx" style="width:694px; margin:0 auto;"></div> 
<div class="pages"><div class="l" style="padding-left:10px;">共 <span>200</span> 条记录 / <span>50</span> 页&nbsp;&nbsp;当前为第 <span>2</span> 页</div><div class="r" style="padding-right:10px;"><a class="btn1" href="#" target="_blank">上一页</a><a class="btn1 btn2" href="#" target="_blank">下一页</a>跳转至第<input class="input1" name="" type="text" />页<input class="btn" name="" type="button" /></div></div>
   <div class="height15"></div>
-->		 
   </div>
   
</div>
<div class="rightcon r">
    <div class="title">公司动态</div>
	 <ul class="ul1">
        <li><a href="News-list.action?categoryid=4&countNumber=7" target="_self">企业新闻</a></li>
        <li><a href="News-list.action?categoryid=5&countNumber=7" target="_self">行业新闻</a></li>
        <li><a href="News-list.action?categoryid=6&countNumber=7" target="_self">产品知识</a></li>
		</ul>
    <div class="title3">装饰类材料</div>
    <ul class="ul3">
      <li><a href="Product-list.action?categoryid=17&countNumber=20" target="_self">壁纸系列</a></li>
      <li><a href="Product-list.action?categoryid=18&countNumber=20" target="_self">窗帘系列</a></li>
      <li><a href="Product-list.action?categoryid=19&countNumber=20" target="_self">地毯系列</a></li>
      <li class="nboder"><a href="Product-list.action?categoryid=20&countNumber=20" target="_self">新型环保材料</a></li>
    </ul>
    <div class="title3">幕墙材料</div>
    <ul class="ul3">
      <li><a href="Product-list.action?categoryid=21&countNumber=20" target="_self">石材</a></li>
      <li class="nboder"><a href="Product-list.action?categoryid=22&countNumber=20" target="_self">玻璃幕墙</a></li>
    </ul>
    <div class="title3">酒水</div>
    <ul class="ul3">
      <li><a href="Product-list.action?categoryid=23&countNumber=20" target="_self">白酒</a></li>
      <li class="nboder"><a href="Product-list.action?categoryid=24&countNumber=20" target="_self">红酒</a></li>
    </ul>

<%
CasesManager casesManager = CasesManager.getInstance();
String sql_cases_01 = "select * from cases where recflag=1 and topscore=1 order by createtime desc limit 0, 1;";
List<Cases> list_cases_01 = casesManager.loadBySQL(sql_cases_01);
String picurl_01 = "temp.jpg";
String title_01 = "";
int id_01 = 0;
if(list_cases_01 != null && list_cases_01.size() != 0) {
	Cases cases_01 = list_cases_01.get(0);
    id_01 = cases_01.getId();
    String title_01_long = cases_01.getTitle();
	if (title_01_long != null && title_01_long.length() > 10) {
		title_01 = title_01_long.substring(0,10) + "...";
	} else if(title_01_long != null) {
		title_01 = title_01_long;
	}
	picurl_01 = cases_01.getPicurl();
	if(picurl_01 == null || picurl_01.trim().equals("")) {
		picurl_01 = "temp.jpg";
	}
}
%>    
    
    <div class="rightcon1 rightcon3">
      <div class="title2"><a href="Cases-list.action?categoryid=10&countNumber=5" target="_self">案例分享</a></div>
      <div class="title1"><span>&middot;</span><a href="cases.jsp?id=<%=id_01 %>" target="_blank"><%=title_01 %></a></div>
      <div class="tp"><a href="upload/<%=picurl_01 %>" target="_blank"><img src="upload/<%=picurl_01 %>" width="168" height="110"/></a></div>
    </div>
    <div class="rightcon2">
      <div class="title2"><a href="contact.jsp" target="_self">联系方式</a></div>
      <ul class="ul2">
        <li><span>&middot;</span>电话：8610-58200526 </li>
        <li><span>&middot;</span>传真：8610-5820051</li>
        <li><span>&middot;</span>E-mail: cdl3333@126.com</li>
      </ul>
    </div>
  </div>
</div>


<div class="clearfloat"></div>
<iframe src="common-footer.html"  width="100%" height="125px" align="middle" scrolling="no" frameborder="0" ></iframe>
</body>
</html>