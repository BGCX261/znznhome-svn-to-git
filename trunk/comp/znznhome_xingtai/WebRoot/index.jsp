<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
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
    
    <title>星泰龙森（北京）机械设备有限公司</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/xtls_index.css" />
<script type="text/javascript" src="js/sla.js"></script>
<script language="javascript">
function baidusearchTop() 
	{ 
	var searchValue=document.getElementsByName("bdsearch")[0].value; 
	var linkValue="http://www.baidu.com/s?si=www.zhenkongbengnet.com&cl=3&ct=2097152&tn=baidulocal&word="+searchValue; 
	window.open(linkValue); 
	}
</script>
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
  <li class="bg1 ts1"><a href="about.jsp" target="_self">关于我们</a></li>
  <li class="bg2"><a href="news-list?ename=news01" target="_self">新闻中心</a></li>
  <li class="bg2"><a href="cases-list?ename=cases01" target="_self">工程案例</a></li>
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
<div class="con1">
<div class="con1left">
<div class="title"><div class="more"><a href="about.jsp" target="_self">详细>></a></div></div>
<div class="midcon">
<div class="leftimg"><img src="images/contp1.jpg" /></div>
<div class="l"><img src="images/contp2.jpg" /></div>
</div>
<p>本系列无油爪式泵适用于化工和生物制药等行业。比传统加工工艺的真空度更高，能够在正常工作运转情况下不间断排除从泵进气口进入的液体，完全解决了容积脱除和工作液的排除问题，可获得最干净的真空，实现中间容积的回收，它还可以和罗茨泵组成无油中真空机组。<a href="about.jsp" target="_self">详细介绍</a></p>
</div>

<div class="con1left2">
<div class="title"><div class="more"><a href="news-list?ename=news01" target="_self">详细>></a></div></div>
<div class="midcon1">
<%
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	NewsManager newsManager = (NewsManager)ctx.getBean("newsManager");
	News news_topscore = newsManager.loadTopic();
	if(news_topscore != null) {
		int id_ = news_topscore.getId();
		String title_ = CommonUtil.filterHtmlAndSubStr(news_topscore.getTitle(),14);
		String content_ = CommonUtil.filterHtmlAndSubStr(news_topscore.getContent(), 40);
		String createtime_ = CommonUtil.getTime(news_topscore.getCreatetime());
%>
<div class="bt1"><a href="news.jsp?id=<%=id_ %>" target="_blank"><%=title_ %></a></div>
<p><%=content_ %></p>
<span style="float:right;"><%=createtime_ %></span>
<%		
	}
%>

</div>
<div class="midcon2">
<ul>
<%
	String sql_news = "select * from znzn_news where recflag=1 and topscore <> 1 and categoryname <> '关于我们' and categoryname <> '联系我们' and categoryname <> '人才招聘' order by createtime desc limit 0, 4;";
	List<News> list_news = newsManager.loadBySQL(sql_news);
	if(CommonUtil.isNotEmpty(list_news)) {
		for(News news : list_news) {
			int id = news.getId();
			String title = CommonUtil.filterHtmlAndSubStr(news.getTitle(),14);
			String createtime = CommonUtil.getTime(news.getCreatetime());
%>
		<li><a href="news.jsp?id=<%=id %>" target="_blank"><%=title %></a><span><%=createtime %></span></li>
<%		
		}
	}
%>
</ul>
</div>
</div>
<%
	CasesManager casesManager = (CasesManager)ctx.getBean("casesManager");
	String sql_cases = "select * from znzn_cases where recflag=1 order by createtime desc limit 0, 1;";
	List<Cases> list_cases = casesManager.loadBySQL(sql_cases);
	if(CommonUtil.isNotEmpty(list_cases)) {
		for(Cases cases : list_cases) {
			int id = cases.getId();
			String picurl = CommonUtil.setDefaultPic(cases.getPicurl(),"temp.jpg");
			String createtime = CommonUtil.getTime(cases.getCreatetime());
%>
		<div class="con1left3">
			<div class="title title1">
				<div class="more"><a href="cases-list?ename=cases01" target="_self">详细>></a>
				</div>
			</div>
			<div class="midcon">
			<a href="cases.jsp?id=<%=id %>" target="_blank"><img src="upload/<%=picurl %>" /></a>
			</div>
		</div>
<%		
		}
	}
%>

</div>
<div class="clearfloat"></div>
<div class="cpzx">
<div class="title">
<ul>
<li><a href="product-list?ename=product01" target="_self">德国Becker（贝克）真空泵</a></li>
<li><a href="product-list?ename=product02" target="_self">德国GardnerDenver真空泵</a></li>
<li><a href="product-list?ename=product03" target="_self">德国希赫水环真空泵</a></li>
<li><a href="product-list?ename=product06" target="_self">美国 Quincy（昆西）螺杆真空泵</a></li>
</ul>
</div>
    	<!-- 滚动图片 beigin -->
            <script language="javascript"> 
			<!--
			//图片滚动列表 mengjia 070927
			var Speed_1 = 30; //速度(毫秒)
			var Space_1 = 20; //每次移动(px)
			var PageWidth_1 = 182 * 3; //翻页宽度
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
			<DIV class=blk_18>
			<A onmouseup="ISL_StopUp_1()" class="LeftBotton" 
			onmousedown="ISL_GoUp_1()" onmouseout="ISL_StopUp_1()" href="javascript:void(0);" 
			target=_self></A>
			<DIV class=pcont id=ISL_Cont_1>
                <DIV class=ScrCont>
                    <DIV id=List1_1>
                    <!-- piclist begin -->
                    
<%
	ProductManager productManager = (ProductManager)ctx.getBean("productManager");
	String sql_product = "select * from znzn_product where recflag=1 order by createtime desc limit 0, 10;";
	List<Product> list_product = productManager.loadBySQL(sql_product);
	if(CommonUtil.isNotEmpty(list_product)) {
		for(Product product : list_product) {
			int id = product.getId();
			String porductName = product.getProductname();
			String title = CommonUtil.filterHtmlAndSubStr(product.getTitle(),8);
			String picurl = CommonUtil.setDefaultPic(product.getPicurl(),"temp.jpg");
			String createtime = CommonUtil.getTime(product.getCreatetime());
%>
		<a class=pl href="product.jsp?id=<%=id %>" target="_blank"><img width="162px" height="120px" src="upload/<%=picurl %>" alt="" title="" /><br /><%=porductName %></a>
<%		
		}
	}
%>                    
                    <!-- piclist end -->
                    </DIV>
                    <DIV id=List2_1></DIV>
                </DIV>
			</DIV>
			<A onmouseup=ISL_StopDown_1() 
			class=RightBotton onmousedown=ISL_GoDown_1() onmouseout=ISL_StopDown_1() 
			href="javascript:void(0);" target=_self></A>
			</DIV>
			
			
			<SCRIPT type="text/javascript">
			<!--
			picrun_ini()
			//-->
			</SCRIPT>
			<!-- picrotate_left end -->     
            <!-- 滚动图片 end -->   
			<div class="xxbf"><a href="product-list?ename=product01" target="_self"><img src="images/xxcp.gif"></a></div>
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
