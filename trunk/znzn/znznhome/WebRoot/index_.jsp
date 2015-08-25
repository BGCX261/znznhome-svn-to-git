<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.znznhome.util.*, com.znznhome.service.*, com.znznhome.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>宅男宅女</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/homepage/thickbox_plus.js"></script>
	<link rel="stylesheet" type="text/css" href="css/homepage/login.css"/>
	<link rel="stylesheet" type="text/css" href="css/homepage/thickbox.css"/>
	<link rel="stylesheet"  type="text/css" href="css/homepage/znzn-index.css" />
	
  </head>
  
  <body>

<%@ include file="head.jsp" %>
<div class="clearfloat"></div>
<div class="xihua">
  <div class="xhleft">
    <div class="title"><img src="images/homepage/xh.gif" /></div>
    <p>最近同学A交了个女朋友，打算周六去KF，跑去问同学B：杜蕾斯多少钱一盒… 
      B:四十左右吧… A：那么贵啊 B:嫌贵啊，那买二手的吧...
</p>
    <div class="title title1"><img src="images/homepage/hd.gif" /></div>
  </div>
  <div class="xhright"><a href="#" target="_blank"><img src="images/homepage/add.gif" /></a></div>
</div>
<div class="clearfloat"></div>
<div class="myscw">
  <div class="mysc">
    <div class="title"></div>
    <div class="sc">站点
      <input class="input1" name="" type="text" />
      地址
      <input class="input1" name="" type="text" />
      <select name="">
        <option>分类</option>
      </select>
      <input class="input2" name="" type="button" value="收藏" />
      <input class="input1" name="" type="text" />
      <input class="input2" name="" type="button" value="添加分类" />
    </div>
    <div class="clearfloat"></div>
    <p>
      <input class="input3" name="" type="button" value="常用网址" />
      <input class="input3" name="" type="button" value="资讯类" />
      <input class="input3" name="" type="button" value="购物类" />
      <input class="input3" name="" type="button" value="娱乐生活类" />
      <input class="input3" name="" type="button" value="我的访问记录" />
    </p>
  </div>
</div>
<div class="ss">
  <table border="0" class="gogo" cellpadding="0" cellspacing="0">
    <tr>
      <td width="255"><input class="input1" name="" type="text" /></td>
      <td width="9">&nbsp;</td>
      <td width="65"><input class="input2" name="" type="button" value="搜索" /></td>
    </tr>
  </table>
  <div class="yqss">
    <input class="input3" name="" type="radio" value="" />
    谷歌
    <input class="input3" name="" type="radio" value="" />
    百度
    <input class="input3" name="" type="radio" value="" />
    搜搜
    <input class="input3" name="" type="radio" value="" />
    有道
    <input class="input3" name="" type="radio" value="" />
    狗狗影视
    <input class="input3" name="" type="radio" value="" />
    站内
    <input class="input3" name="" type="radio" value="" />
    手机归属地
    <input class="input4" name="" type="button" value="定制" />
  </div>
</div>
<div class="clearfloat"></div>
<div class="mywlw">
  <div class="mywl">
    <div class="ywleft">
      <div class="title"></div>
      <div class="title1">清早起床 发现温度还没有降清早起床 发现温度还没有降</div>
      <div class="clearfloat"></div>
      <div class="mid">
        <input class="text" name="" type="text" />
        <p>主  题
          <input class="input1" name="" type="text" />
          联系方式
          <input class="input1" name="" type="text" />
          <input class="input2" name="" type="button" value="发布" />
        </p>
        <p>
          <select class="input4" name="">
            <option>主题</option>
          </select>
          <input class="input3" name="" type="text" />
          <input class="input2 input22" name="" type="button" value="搜索" />
        </p>
        <div class="clearfloat"></div>
        <div class="paa"> <a href="#" target="_blank">张震岳演唱会</a><a href="#" target="_blank">降温</a><a href="#" target="_blank">中超</a><a href="#" target="_blank">Selina俞灏明烧伤</a><a href="#" target="_blank">台风鲇鱼</a><a href="#" target="_blank">李刚</a><a href="#" target="_blank">非诚勿扰</a><a href="#" target="_blank">微博快跑杭州</a><a href="#" target="_blank">张震岳演唱</a><a href="#" target="_blank">张震岳演唱会</a><a href="#" target="_blank">降温</a><a href="#" target="_blank">降温</a><a href="#" target="_blank">张震岳演唱会</a><a href="#" target="_blank">降温</a> <a href="#" target="_blank">中超</a><a href="#" target="_blank">Selina俞灏明烧伤</a><a href="#" target="_blank">台风鲇鱼</a><a href="#" target="_blank">李刚</a><a href="#" target="_blank">非诚勿扰</a><a href="#" target="_blank">微博快跑杭州</a><a href="#" target="_blank">张震岳演唱</a><a href="#" target="_blank">张震岳演唱会</a><a href="#" target="_blank">降温</a><a href="#" target="_blank">降温</a> </div>
      </div>
    </div>
    <div class="ywright">
      <ul>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
        <li><span class="leftcon"><img src="images/homepage/ltrt.gif" />高倩zaozao：<span class="hs">清早起床 发现温度还没有还没有降降等</span></span><span class="rightcon">13分钟前</span> </li>
      </ul>
      <div class="pages"><a href="#">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">8</a><a href="#">9</a><a href="#">10</a><a href="#">>></a></div>
    </div>
  </div>
</div>
<div class="xxfbw">
  <div class="xxfb">
    <div class="fbleft">
      <div class="title"></div>
      <div class="title1">清早起床 发现温度还没有降清早起床 发现温度还没有降</div>
      <div class="clearfloat"></div>
      <div class="mid">
        <p>分  类
          <select class="input1" name="">
            <option>分  类</option>
          </select>
          联系方式
          <input class="input1" name="" type="text" />
        </p>
        <input class="text" name="" type="text" />
        <input class="input2" name="" type="button" value="" />
        <p>分  类
          <select class="input4" name="">
            <option>分  类</option>
          </select>
          <input class="input3" name="" type="text" />
          <input class="input22" name="" type="button" value="搜索" />
        </p>
        <div class="clearfloat"></div>
        <div class="paa"> <a href="#" target="_blank">家政</a><a href="#" target="_blank">降温</a><a href="#" target="_blank">房产</a><a href="#" target="_blank">二手</a><a href="#" target="_blank">车辆</a><a href="#" target="_blank">招聘</a><a href="#" target="_blank">求职</a><a href="#" target="_blank">服务</a><a href="#" target="_blank">宠物</a><a href="#" target="_blank">票务</a><a href="#" target="_blank">教育</a><a href="#" target="_blank">培训</a><a href="#" target="_blank">活动</a><a href="#" target="_blank">美食</a><a href="#" target="_blank">交友</a><a href="#" target="_blank">拼车</a><a href="#" target="_blank">合租</a><a href="#" target="_blank">贷款</a><a href="#" target="_blank">旅游</a><a href="#" target="_blank">家政</a><a href="#" target="_blank">活动</a><a href="#" target="_blank">美食</a><a href="#" target="_blank">交友</a><a href="#" target="_blank">拼车</a><a href="#" target="_blank">美食</a><a href="#" target="_blank">交友</a><a href="#" target="_blank">拼车</a><a href="#" target="_blank">合租</a><a href="#" target="_blank">贷款</a><a href="#" target="_blank">旅游</a><a href="#" target="_blank">家政</a><a href="#" target="_blank">活动</a><a href="#" target="_blank">美食</a><a href="#" target="_blank">交友</a><a href="#" target="_blank">拼车</a></div>
      </div>
    </div>
    <div class="fbright">
      <div class="title">最新北京租房信息</div>
      <ul>
        <li><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li class="lbg"><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li class="lbg"><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li class="lbg"><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
        <li class="lbg"><span class="leftcon"><span>2300元/月</span><span>一居</span><span>精装大主卧带 国贸 - 太阳星城...</span></span><span class="rightcon">2分钟前</span> </li>
      </ul>
      <div class="pages"><a href="#">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">8</a><a href="#">9</a><a href="#">10</a><a href="#">>></a></div>
    </div>
  </div>
</div>
<div class="mmljw">
  <div class="mmlj">
    <ul>
      <li><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.15.net">4334妖屋小说网</a> <a href="http://www.zongheng.com/?CO=114la">纵横文学网</a> <a href="http://book.sina.com.cn/">新浪读书</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li class="lbg"><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.15.net">4334妖屋小说网</a> <a href="http://book.sina.com.cn/">新浪读书</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.15.net">4334妖屋小说网</a> <a href="http://www.zongheng.com/?CO=114la">纵横文学网</a> <a href="http://book.sina.com.cn/">新浪读书</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li class="lbg"><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="s/catalog/game.htm#39">天龙八部</a> <a href="s/catalog/game.htm#78">地下城与勇士</a> <a href="s/catalog/game.htm#15">梦幻西游</a> <a href="s/catalog/game.htm#42">《诛仙》</a> <a href="s/catalog/game.htm#83">传奇外传</a> <a href="s/catalog/game.htm#27">《问道》</a> <a href="s/catalog/game.htm#81">穿越火线</a> </span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li><span class="leftcon"> <span class="bt">小说</span> <span class="middle"> <a href="s/catalog/game.htm#20">热血江湖</a> <a href="s/catalog/game.htm#18">劲舞团</a> <a href="s/catalog/game.htm#16">跑跑卡丁车</a> <a href="s/catalog/game.htm#101">Aion永恒之塔</a> <a href="s/catalog/game.htm#25">反恐精英CS</a> <a href="s/catalog/game.htm#14">街头篮球</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li class="lbg"><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.15.net">4334妖屋小说网</a> <a href="http://www.zongheng.com/?CO=114la">纵横文学网</a> <a href="http://book.sina.com.cn/">新浪读书</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a><a href="http://book.sina.com.cn/">新浪读书</a><a href="http://www.15.net">4334妖屋小说网</a> <a href="http://www.zongheng.com/?CO=114la">纵横文学网</a><a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li class="lbg"><span class="leftcon"> <span class="bt">小说</span> <span class="middle"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.15.net">4334妖屋小说网</a> <a href="http://www.zongheng.com/?CO=114la">纵横文学网</a> <a href="http://book.sina.com.cn/">新浪读书</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
      <li><span class="leftcon"> <span class="bt">小说</span> <span class="middle" style=" text-align:center;"><a href="http://www.qidian.com/">1212起点</a> <a href="http://www.xxsy.net">言情小说</a> <a href="http://www.readnovel.com/">小说阅读网</a> <a href="http://www.xiaoshuo0.com/">玄幻小说林</a></span></span> <span class="rightcon"><a href="#" target="_blank">更多>></a></span> </li>
    </ul>
  </div>
</div>
<div class="clearfloat"></div>
<div class="footerw"></div>
<%@ include file="../../foot.jsp" %>
</body>
</html>