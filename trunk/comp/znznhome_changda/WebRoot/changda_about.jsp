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
    
    <title>北京鸿屹昌达商贸有限公司 | 关于我们</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
    document.getElementById("daohang1").getElementsByTagName("a")[1].className="bg2 fsxg";
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
 <div class="title">您当前的位置：<a href="index.jsp" target="_self">首页</a> > <a class="ra" href="changda_about.jsp" target="_self">关于我们</a>  </div>
   <div class="midcon1 midcon4">
   <div class="bt3"><span>公司简介</span></div>
<p> 北京鸿屹昌达商贸有北京鸿屹昌达商贸有限公司成立于2008年8月29日，主要从事建筑装饰装修材料的生产、销售与研发。 公司下设企业管理部、市场营销部、工程技术研发部、财务部、客户服务部等部门。公司所主营产品的销售以全国各大中型城市为主，部分产品远销美国、德国、南非等海外国家。 </p>
<p>公司自成立以来一直坚持装饰建材“环保、艺术、表现”的理念，奉行“质量第一、服务致上、价格合理”的经营路线 ，以客户利益为重，想客户所想、急客户所急、最大限度的满足客户的合理要求。在不断的更新产品的同时，树立了良好的企业形象，建立了良好的信誉度，带动企业持续健康的发展。在与您的合作过程中我们将倾尽全力，为您提供优质高效的服务，真诚期待与您的合作！ </p>
<p>公司经营产品种类： </p>
<p>  一、墙纸：<br />&nbsp;&nbsp;&nbsp;&nbsp;多变的质感、丰富的色彩、逼真的表现力使得墙体呈现出生动、艺术的装饰效果，成为选择率极高的新型墙体装饰材料。本公司主要经营韩国、日本、比利时、英国、德国等国家的进口品牌墙纸以及国产品牌墙纸，如天籁之音、Art city、卡瓦斯、布鲁斯特、摩登世家、柔然、朗饰、丽彩、爱舍、seegreen、新视点、天地人等，以及公司自主品牌hy系列。产品价格与品种繁多，在同行业占据优势，给您带来实在的价格和优质便捷的服务。 </p>
<p> 二、地毯：<br />&nbsp;&nbsp;&nbsp;&nbsp; 主要产品有：interface、美林肯、山花、海马、开利、惠普等各种品牌高、中、低不同档次，样式齐全的地毯。我们的样品如您还不满意您可自带小样定织地毯，价格是优惠最大限度的满足不同需求的客户要求产品种类有：纯羊毛地毯、尼龙地毯、晴纶地毯、环保地毯、阿克明斯特地毯，威尔顿地毯。无纺地毯，疏水毯、铝镁合金地垫，铝合金地垫，刮泥地垫，可定织异型手工毯、3M地垫，手工挂毯等。 </p>
<p>三、新型材料：<br />&nbsp;&nbsp;&nbsp;&nbsp;公司还经营目前在欧美等国家广泛使用的新型建筑材料—环保木塑制品，该产品主要用于室外工程装饰挂板地板。具有超强的耐腐蚀、耐酸碱、耐风化、不易变形等性能，是户外装饰木材的替代品，科技、环保。可制作成多种颜色多种规格，选择性强，目前新型高效的木塑房车已经研发成功，并已推向国内市场，反映良好。可制作成多种颜色多种规格，选择性强，目前新型高效的木塑房车已经研发成功，并已推向国内市场，反映良好。可制作成多种颜色多种规格，选择性强，目前新型高效的木塑房车已经研发成功，并已推向国内市场，反映良好。</p>
	

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
