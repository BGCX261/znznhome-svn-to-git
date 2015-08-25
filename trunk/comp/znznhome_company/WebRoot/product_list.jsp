<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext,java.text.SimpleDateFormat" %>
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
    
    <title>北京宅男宅女商贸有限公司 | 产品展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--><script src="<%=basePath%>js/bdsearch.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/hy3-con.css" />
</head>
<body>

  <%
  String str_categoryid = request.getParameter("categoryid");
  int ctgid = 0;
  if(str_categoryid != null && !str_categoryid.trim().equals("")) ctgid = Integer.parseInt(str_categoryid);
  ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
  CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
  Category category = categoryManager.loadByID(ctgid);
  String ctgname = category.getName();
  //System.out.println(s);
  Page product_page = (Page)request.getAttribute("page");
  //int startNo = product_page.getStartNo();
  int pageSize = product_page.getPageSize();
  //int totalRecords = product_page.getTotalRecords();
  int pageNo = product_page.getPageNo();
  int totalPages = product_page.getTotalPages();

  List<Product> list_product = product_page.getList();
  %>

<div class="topht">
  <div class="topleft"><img src="images/logo.gif" width="217" height="53"/></div>
  <div class="topright"><span><a href="index.jsp" target="_self">主页</a><a href="#" target="_self">合作伙伴</a><a style="margin-right:0px;" href="contact.jsp" target="_self">联系我们</a></span>
    <div class="ss">
      <input name="" class="input" id="bdsearch" name="bdsearch" type="text" value="请输入关键字.." onclick="javascript: document.getElementById('bdsearch').value=''" />
      <input class="btn" onclick="baidusearchTop();" name="" type="button" />
    </div>
    <div class="clearfloat"></div>
    <div id="daohang1" class="daohang"><a class="bg1 fsxg1" href="index.jsp" target="_self">首 页 </a><a class="bg2" href="about.jsp" target="_self">关于我们</a><a class="bg2" href="news-list?categoryid=4&countNumber=7" target="_self">公司动态</a><a class="bg2" href="product-list?categoryid=17&countNumber=20" target="_self">产品展示</a><a class="bg2" href="cases-list?categoryid=10&countNumber=5" target="_self">案例分享</a><a class="bg2" href="job-list?countNumber=9" target="_self">招聘中心</a><a class="bg3" href="contact.jsp" target="_self">联系方式</a></div>
  </div>
</div>

    <!-- 改变两个导航的样式 -->
    <script language="javascript">
    document.getElementById("daohang1").getElementsByTagName("a")[3].className="bg2 fsxg";
    </script>

<div class="clearfloat"></div>
<div class="con1w">
  <div class="con1">
    <div class="leftcon"> <a href="#" target="_blank"><img src="images/add.jpg" alt="" width="740" height="153" /></a> </div>
    <div class="rightcon r">
      <div class="add"><a href="#" target="_blank"><img src="images/add1.jpg" width="214" height="153" /></a></div>
    </div>
  </div>
</div>
<div class="con2">
  <div class="leftcon l">
    <div class="title">您当前的位置：<a href="index.jsp" target="_self">首页</a> > <a class="ra" href="product-list?categoryid=17&countNumber=20" target="_self">产品展示</a> > <a href="product-list?categoryid=<%=ctgid %>&countNumber=20" target="_self"><%=ctgname %></a></div>
    <div class="midcon1 midcon5">
<ul>

  <%
 	if(list_product != null) {
	    for(Iterator<Product> it = list_product.iterator(); it.hasNext();) {
	    	Product product = it.next();
	  		int id = product.getId();
	  		
	  		String title = product.getTitle();
	  		String picurl = product.getPicurl();
	  		String productnumber = product.getProductnumber();
	  		String brand_long = product.getBrand();
	  		if(picurl == null || picurl.trim().equals("")) picurl = "temp.jpg";
	  		String content_long = product.getContent();
	  		
	  		String content_filter = Html2Text.filter(content_long);
	  		String content = "";
			if (content_filter != null && content_filter.length() > 130) {
				content = content_filter.substring(0,130) + "...";
			} else if(content_filter != null) {
				content = content_filter;
			}
			
	  		String brand = "";
			if (brand_long != null && brand_long.length() > 5) {
				brand = brand_long.substring(0,5) + "..";
			} else if(brand_long != null) {
				brand = brand_long;
			}
	  		
	    	//处理一下日期格式
			Timestamp ts = product.getCreatetime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createtime = sdf.format(ts);
%>
		
<li>
<div class="tp"><a href="product.jsp?id=<%=id %>" target="_blank"><img src="images/tp.gif" width="115" height="74"/></a></div>
<div class="bt">货号：<%=productnumber %><br />
品牌：<%=brand %></div>
</li>

<%				
   	  	} //-- for循环 --
}
%>




</ul>
<div class="clearfloat"></div>

	  		<!-- ------------以下HTML分页区------------ -->
	  	<form name="form1"  action="product-list">	
	  	<input type="hidden" name="countNumber" value="7"/>
	  	<input type="hidden" name="categoryid" value="<%=ctgid %>"/>
		<div class="pages"><div class="l" style="padding-left:10px;">
		
		共 <span><%=totalPages %></span>页&nbsp;&nbsp;当前为第 <span><%=pageNo %></span> 页</div>
		<div class="r" style="padding-right:10px;">
	  <a class="btn1" href="product-list?categoryid=<%=ctgid %>&countNumber=7&pageNo=<%=pageNo-1%>" >上一页</a>
	  <a class="btn1 btn2" href="product-list?categoryid=<%=ctgid %>&countNumber=7&pageNo=<%=pageNo+1%>" target="_blank">下一页</a>
   跳转到：<select name="pageNo" onChange="document.form1.submit()">
					<%
					for(int i=1; i<=totalPages; i++) {
					%>
					<option value=<%=i %> <%=(pageNo == i) ? "selected" : ""%>>第<%=i%>页 </option>
					<%
					}
					%>
		</select>
			  </div>
        </div>
        </form>
      <!-- ------------以上HTML分页区------------ -->	

		<div class="height15"></div>
    </div>
  </div>
  <div class="rightcon r">
    <div class="title"><a href="#" target="_blank">产品展示</a></div>
    <div class="title3">装饰类材料</div>
    <ul class="ul3">
      <li><a href="product-list?categoryid=17&countNumber=20" target="_self">壁纸系列</a></li>
      <li><a href="product-list?categoryid=18&countNumber=20" target="_self">窗帘系列</a></li>
      <li><a href="product-list?categoryid=19&countNumber=20" target="_self">地毯系列</a></li>
      <li class="nboder"><a href="product-list?categoryid=20&countNumber=20" target="_self">新型环保材料</a></li>
    </ul>
    <div class="title3">幕墙材料</div>
    <ul class="ul3">
      <li><a href="product-list?categoryid=21&countNumber=20" target="_self">石材</a></li>
      <li class="nboder"><a href="product-list?categoryid=22&countNumber=20" target="_self">玻璃幕墙</a></li>
    </ul>
    <div class="title3">酒水</div>
    <ul class="ul3">
      <li><a href="product-list?categoryid=23&countNumber=20" target="_self">白酒</a></li>
      <li class="nboder"><a href="product-list?categoryid=24&countNumber=20" target="_self">红酒</a></li>
    </ul>

<%
CasesManager casesManager =  (CasesManager)ctx.getBean("casesManager");
String sql_cases_01 = "select * from znzn_cases where recflag=1 and topscore=1 order by createtime desc limit 0, 1;";
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
      <div class="title2"><a href="cases-list?categoryid=10&countNumber=5" target="_self">案例分享</a></div>
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
