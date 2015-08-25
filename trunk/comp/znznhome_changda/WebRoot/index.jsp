<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*,  java.text.SimpleDateFormat" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京鸿屹昌达商贸有限公司</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=basePath%>js/bdsearch.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/hy3-index.css" />
<script type="text/javascript" src="js/sla.js"></script>
</head>
<body>
<%
NewsManager newsManager = NewsManager.getInstance();
ProductManager productManager = ProductManager.getInstance();
CasesManager casesManager = CasesManager.getInstance();
String sql_news_01 = "select * from news where recflag=1 and categoryid=4 order by createtime desc limit 0, 5;";
String sql_news_02 = "select * from news where recflag=1 and categoryid=5 order by createtime desc limit 0, 5;";
String sql_product = "select * from product where recflag=1 order by createtime desc limit 0, 10;";
String sql_cases = "select * from cases where recflag=1 order by createtime desc limit 0, 5;";

List<News> list_news_01 = newsManager.loadBySQL(sql_news_01);
List<News> list_news_02 = newsManager.loadBySQL(sql_news_02);
List<Product> list_product = productManager.loadBySQL(sql_product);
List<Cases> list_cases = casesManager.loadBySQL(sql_cases);

%>
<div class="topht">
  <div class="topleft"><img src="images/logo.gif" width="217" height="53"/></div>
  <div class="topright"><span><a href="index.jsp" target="_self">主页</a><a href="#" target="_self">合作伙伴</a><a style="margin-right:0px;" href="contact.jsp" target="_self">联系我们</a></span>
    <div class="ss">
      <input name="" class="input" id="bdsearch" name="bdsearch" type="text" value="请输入关键字.." onclick="javascript: document.getElementById('bdsearch').value=''" />
      <input class="btn" onclick="baidusearchTop();" name="" type="button" />
    </div>
    <div class="clearfloat"></div>
    <div id="daohang1" class="daohang"><a class="bg1" href="index.jsp" target="_self">首 页 </a><a class="bg2" href="changda_about.jsp" target="_self">关于我们</a><a class="bg2" href="News-list.action?categoryid=4&countNumber=7" target="_self">公司动态</a><a class="bg2" href="Product-list.action?categoryid=17&countNumber=20" target="_self">产品展示</a><a class="bg2" href="Cases-list.action?categoryid=10&countNumber=5" target="_self">案例分享</a><a class="bg2" href="Job-list.action?countNumber=9" target="_self">招聘中心</a><a class="bg3" href="contact.jsp" target="_self">联系方式</a></div>
  </div>
</div>

    <!-- 改变两个导航的样式 -->
    <script language="javascript">
    document.getElementById("daohang1").getElementsByTagName("a")[0].className="bg1";
    </script>

<div class="clearfloat"></div>
<div class="con1w">
  <div class="con1">
    <div class="leftcon">
      <!-- 焦点图2 -->
      <div class="focus">
        <div class="sliderwrapper" id="slider">
          <div class="contentdiv" style="display:block; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/jdt1.jpg" alt="" width="740" height="328" /></a></div>
          <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/jdt2.jpg" alt="" width="740" height="328" /></a></div>
          <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/jdt3.jpg" alt="" width="740" height="328" /></a></div>
          <div class="contentdiv" style="display:none; opacity: 1; visibility: visible;"><a href="#" target="_blank"><img src="images/jdt4.jpg" alt="" width="740" height="328" /></a></div>
          <div class="contentdiv" style="display:none; opacity: 1; visibility: visible;"><a href="#" target="_blank"><img src="images/jdt5.jpg" alt="" width="740" height="328" /></a></div>
        </div>
        <div class="clearfloat"></div>
        <div class="pagination" id="paginate-slider"> <a class="toc" href="#" rel="1">1</a> <a class="toc" href="#" rel="2">2</a> <a class="toc" href="#" rel="3">3</a> <a class="toc" href="#" rel="3">4</a> <a class="toc" style=" border-right:none;" href="#" rel="4">5</a> </div>
      </div>
      <!-- 焦点图2 -->
    </div>
    <div class="rightcon r">
      <div class="title"></div>
      <ul>
        <li><a href="Product-list.action?categoryid=17&countNumber=20" target="_self">壁纸系列</a></li>
        <li><a href="Product-list.action?categoryid=18&countNumber=20" target="_self">窗帘系列</a></li>
        <li><a href="Product-list.action?categoryid=19&countNumber=20" target="_self">地毯系列</a></li>
        <li><a href="Product-list.action?categoryid=20&countNumber=20" target="_self">新型环保材料</a></li>
      </ul>
      <div class="add"><a href="#" target="_blank"><img src="images/add.gif" width="214" height="153" /></a></div>
    </div>
  </div>
</div>
<div class="con2">
  <div class="leftcon l">
    <div class="title"><span><a href="changda_about.jsp" target="_self">关于鸿屹昌达</a></span></div>
    <div class="midcon">
      <div class="tp l"><a href="changda_about.jsp" target="_self"><img src="images/tp.gif" width="115" height="74" /></a></div>
      <div class="txt l">北京鸿屹昌达商贸有限公司成立于2008年8月29日，主要从事建筑装饰装修材料的生产、销售与研发。 公司下设企业管理部、市场营销部、工程技术研发部、财务部、客户服务部等部门.. <a href="changda_about.jsp" target="_self">查看详细 ></a></div>
    </div>
  </div>
  <div class="leftcon r">
    <div class="title"><span><a href="Product-list.action?categoryid=17&countNumber=20" target="_self">产品展示</a></span><a class="ra" href="Product-list.action?categoryid=17&countNumber=20" target="_self"></a></div>
    <div class="midcon">
      <div class="hlhb_con">
        <!-- 滚动图片 beigin -->
        <script language="javascript"> 
			<!--
			//图片滚动列表 mengjia 070927
			var Speed_1 = 30; //速度(毫秒)
			var Space_1 = 20; //每次移动(px)
			var PageWidth_1 = 141 * 3; //翻页宽度
			var interval_1 = 7000; //翻页间隔
			var fill_1 = 0; //整体移位
			var MoveLock_1 = false;
			var MoveTimeObj_1;
			var MoveWay_1="right";
			var Comp_1 = 0;
			var AutoPlayObj_1=null;
			function GetObj(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}}
			function AutoPlay_1(){clearInterval(AutoPlayObj_1);AutoPlayObj_1=setInterval('ISL_GoDown_1();ISL_StopDown_1();',interval_1)}
			function ISL_GoUp_1(){if(MoveLock_1)return;clearInterval(AutoPlayObj_1);MoveLock_1=true;MoveWay_1="left";MoveTimeObj_1=setInterval('ISL_ScrUp_1();',Speed_1);}
			function ISL_StopUp_1(){if(MoveWay_1 == "right"){return};clearInterval(MoveTimeObj_1);if((GetObj('ISL_Cont_1').scrollLeft-fill_1)%PageWidth_1!=0){Comp_1=fill_1-(GetObj('ISL_Cont_1').scrollLeft%PageWidth_1);CompScr_1()}else{MoveLock_1=false}
			AutoPlay_1()}
			function ISL_ScrUp_1(){if(GetObj('ISL_Cont_1').scrollLeft<=0){GetObj('ISL_Cont_1').scrollLeft=GetObj('ISL_Cont_1').scrollLeft+GetObj('List1_1').offsetWidth}
			GetObj('ISL_Cont_1').scrollLeft-=Space_1}
			function ISL_GoDown_1(){clearInterval(MoveTimeObj_1);if(MoveLock_1)return;clearInterval(AutoPlayObj_1);MoveLock_1=true;MoveWay_1="right";ISL_ScrDown_1();MoveTimeObj_1=setInterval('ISL_ScrDown_1()',Speed_1)}
			function ISL_StopDown_1(){if(MoveWay_1 == "left"){return};clearInterval(MoveTimeObj_1);if(GetObj('ISL_Cont_1').scrollLeft%PageWidth_1-(fill_1>=0?fill_1:fill_1+1)!=0){Comp_1=PageWidth_1-GetObj('ISL_Cont_1').scrollLeft%PageWidth_1+fill_1;CompScr_1()}else{MoveLock_1=false}
			AutoPlay_1()}
			function ISL_ScrDown_1(){if(GetObj('ISL_Cont_1').scrollLeft>=GetObj('List1_1').scrollWidth){GetObj('ISL_Cont_1').scrollLeft=GetObj('ISL_Cont_1').scrollLeft-GetObj('List1_1').scrollWidth}
			GetObj('ISL_Cont_1').scrollLeft+=Space_1}
			function CompScr_1(){if(Comp_1==0){MoveLock_1=false;return}
			var num,TempSpeed=Speed_1,TempSpace=Space_1;if(Math.abs(Comp_1)<PageWidth_1/2){TempSpace=Math.round(Math.abs(Comp_1/Space_1));if(TempSpace<1){TempSpace=1}}
			if(Comp_1<0){if(Comp_1<-TempSpace){Comp_1+=TempSpace;num=TempSpace}else{num=-Comp_1;Comp_1=0}
			GetObj('ISL_Cont_1').scrollLeft-=num;setTimeout('CompScr_1()',TempSpeed)}else{if(Comp_1>TempSpace){Comp_1-=TempSpace;num=TempSpace}else{num=Comp_1;Comp_1=0}
			GetObj('ISL_Cont_1').scrollLeft+=num;setTimeout('CompScr_1()',TempSpeed)}}
			function picrun_ini(){
			GetObj("List2_1").innerHTML=GetObj("List1_1").innerHTML;
			GetObj('ISL_Cont_1').scrollLeft=fill_1>=0?fill_1:GetObj('List1_1').scrollWidth-Math.abs(fill_1);
			GetObj("ISL_Cont_1").onmouseover=function(){clearInterval(AutoPlayObj_1)}
			GetObj("ISL_Cont_1").onmouseout=function(){AutoPlay_1()}
			AutoPlay_1();
			}
			//产品展示滚动图片结束

			//-->
			</script>
        <!-- picrotate_left start  -->
        <DIV class=blk_18> <A onmouseup="ISL_StopUp_1()" class="LeftBotton" 
			onmousedown="ISL_GoUp_1()" onmouseout="ISL_StopUp_1()" href="javascript:void(0);" 
			target=_self></A>
          <DIV class=pcont id=ISL_Cont_1>
            <DIV class=ScrCont>
              <DIV id=List1_1>
                <!-- piclist begin -->
<%
if(list_product != null) {
	for(Iterator<Product> it = list_product.iterator(); it.hasNext();) {
		Product product = it.next();
	    int id = product.getId();
	    String title_long = product.getTitle();
	    String title = "";
		if (title_long != null && title_long.length() > 14) {
			title = title_long.substring(0,14) + "...";
		} else if(title_long != null) {
			title = title_long;
		}
		String picurl = product.getPicurl();
		if(picurl == null || picurl.trim().equals("")) {
			picurl = "temp.jpg";
		}
%>
		<a class=pl href="cases.jsp?id=<%=id %>" target="_blank"><img src="upload/<%=picurl %>" alt="" title="" width="115" height="74" /></a>

<%	}
}
%>

                <!-- piclist end -->
              </DIV>
              <DIV id=List2_1></DIV>
            </DIV>
          </DIV>
          <A onmouseup=ISL_StopDown_1() 
			class=RightBotton onmousedown=ISL_GoDown_1() onmouseout=ISL_StopDown_1() 
			href="javascript:void(0);" target=_self></A> </DIV>
        <SCRIPT type="text/javascript">
			<!--
			picrun_ini()
			//-->
			</SCRIPT>
        <!-- picrotate_left end -->
        <!-- 滚动图片 end -->
      </div>
    </div>
  </div>
</div>
<div class="con3">
  <div class="leftcon l margr10">
    <div class="title"><span><a href="News-list.action?categoryid=4&countNumber=7" target="_self">企业新闻</a></span><a class="ra" href="News-list.action?categoryid=4&countNumber=7" target="_self"></a></div>
    <div class="midbf">
      <ul>

<%
if(list_news_01 != null) {
	for(Iterator<News> it = list_news_01.iterator(); it.hasNext();) {
		News news = it.next();
	    int id = news.getId();
	    String title_long = news.getTitle();
	    String title = "";
		if (title_long != null && title_long.length() > 14) {
			title = title_long.substring(0,14) + "...";
		} else if(title_long != null) {
			title = title_long;
		}
		String picurl = news.getPicurl();
		if(picurl == null || picurl.trim().equals("")) {
			picurl = "temp.jpg";
		}
%>
		<li>&middot;<a href="news.jsp?id=<%=id %>" target="_blank"><%=title %></a></li>

<%	}
}
%>

      </ul>
    </div>
  </div>
  
  <div class="leftcon l margr10 wd234">
    <div class="title wd234"><span><a href="News-list.action?categoryid=5&countNumber=7" target="_self">行业新闻</a></span><a class="ra" href="News-list.action?categoryid=5&countNumber=7" target="_self"></a></div>
    <div class="midbf">
      <ul>
<%
if(list_news_02 != null) {
	for(Iterator<News> it = list_news_02.iterator(); it.hasNext();) {
		News news = it.next();
	    int id = news.getId();
	    String title_long = news.getTitle();
	    String title = "";
		if (title_long != null && title_long.length() > 14) {
			title = title_long.substring(0,14) + "...";
		} else if(title_long != null) {
			title = title_long;
		}
		String picurl = news.getPicurl();
		if(picurl == null || picurl.trim().equals("")) {
			picurl = "temp.jpg";
		}
%>
		<li>&middot;<a href="news.jsp?id=<%=id %>" target="_blank"><%=title %></a></li>

<%	}
}
%>
      </ul>
    </div>
  </div>
  
  <div class="leftcon leftcon wd447 l">
    <div class="title wd447"><span><a href="Cases-list.action?categoryid=10&countNumber=5" target="_self">成功案例</a></span><a class="ra" href="Cases-list.action?categoryid=10&countNumber=5" target="_self"></a></div>
    <div class="midbf wd447">
      <ul class="l" style="margin-left:14px;">
<%
if(list_cases != null) {
	for(Iterator<Cases> it = list_cases.iterator(); it.hasNext();) {
		Cases cases = it.next();
	    int id = cases.getId();
	    String title_long = cases.getTitle();
	    String title = "";
		if (title_long != null && title_long.length() > 14) {
			title = title_long.substring(0,14) + "...";
		} else if(title_long != null) {
			title = title_long;
		}
		String picurl = cases.getPicurl();
		if(picurl == null || picurl.trim().equals("")) {
			picurl = "temp.jpg";
		}
%>
		<li>&middot;<a href="cases.jsp?id=<%=id %>" target="_blank"><%=title %></a></li>

<%	}
}
%>
      </ul>
	  <div class="add1 r" style="margin-right:14px;"><a href="#" target="_blank"><img src="images/add1.gif" width="202" height="133" /></a></div>
    </div>
  </div>
</div>

<div class="clearfloat"></div>
<iframe src="common-footer.html"  width="100%" height="125px" align="middle" scrolling="no" frameborder="0" ></iframe>
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
<!-- 焦点图2 -->
