<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>会员中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/channel/memberhome.css" />
  </head>
  
  <body>
<%@ include file="../../head.jsp" %>

<div class="clearfloat"></div>
<div class="grzx"><img src="images/channel/gzadd.gif" alt="" width="960" height="115" /></div>
<div class="grzx">
  <div class="leftcon">
    <div class="title"><span class="spanleft">用户信息</span></div>
    <div class="leftdh">
      <div class="yhtx"> <img src="images/channel/rt.gif" alt="" width="102" height="97"/><br />
        <a href="#" target="_blank">宅男宅女的家</a> </div>
      <div class="ejdh">
        <ul>
          <li><a href="#" target="_blank">更改密码</a></li>
          <li><a href="#" target="_blank">完善个人资料</a></li>
          <li><a href="#" target="_blank">版块定制</a></li>
          <li><a href="#" target="_blank">模块和导航</a></li>
          <li><a href="#" target="_blank">列表定制</a></li>
          <li><a href="#" target="_blank">无聊版块</a></li>
          <li><a href="#" target="_blank">信息发布检索版块</a></li>
        </ul>
      </div>
	  <div style="height:30px;"></div>
    </div>
    <div class="rightxx1">
	<div class="zxtitle">
	<div class="leftdl">欢迎<span>宅男宅女</span>登录</div>
	<div class="rightlj"><a href="#" target="_blank">编辑个人信息</a>&nbsp;&nbsp;<a href="#" target="_blank">修改密码</a></div></div>
	<div class="clearfloat"></div>
	<div class="grxxcon">
		<table border="0" class="table" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="37">姓名：</td>
    <td width="110">照明</td>
    <td width="37">性别：</td>
	<td width="53">男</td>
    <td width="41">生日：</td>
    <td width="154"class="rdq1">5月11日</td>
  </tr>
   <tr>
    <td>血型：</td>
    <td>AB</td>
    <td>婚姻：</td>
	<td colspan="3">已婚</td>
  </tr>
   <tr>
    <td nowrap="nowrap" colspan="6">电子邮箱：52881673@qq.com</td>
  </tr>
</table>
</div>
	<div class="leftd2">我近期发布的信息</div>
	<div class="grbk">
	<div class="grtitle">我和无聊<span>实在太无聊了，有人一起出去玩吗？</span></div>
	<p>清早起床 发现温度还没有降清早起床 发现温度还没有降清早起床 发现温度还没有
降清早起床 发现温度还没有降</p>
<p class="psc"><a href="#" target="_blank">删除</a>&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">修改</a></p>
	</div>
	<div class="grbk">
	<div class="grtitle">我和无聊<span>实在太无聊了，有人一起出去玩吗？</span></div>
	<p>清早起床 发现温度还没有降清早起床 发现温度还没有降清早起床 发现温度还没有
降清早起床 发现温度还没有降</p>
<p class="psc"><a href="#" target="_blank">删除</a>&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">修改</a></p>
	</div>
	<div class="grbk">
	<div class="grtitle">我和无聊<span>实在太无聊了，有人一起出去玩吗？</span></div>
	<p>清早起床 发现温度还没有降清早起床 发现温度还没有降清早起床 发现温度还没有
降清早起床 发现温度还没有降</p>
<p class="psc"><a href="#" target="_blank">删除</a>&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">修改</a></p>
	</div>

	</div>
  </div>
  <div class="rightcon">
  <div class="title"><span class="spanleft">宅男宅女公告</span><span class="spanright"><a href="#" target="_blank"></a></span></div>
   <ul>
          <li><a href="#" target="_blank">全国易逃税案前</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">全国网交易逃税案</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">电子商以想像</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">网上开别</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">按照我为</a><span>[07-01]</span></li>
        </ul>
		 <div class="title"><span class="spanleft spanleft1">宅男宅女公告</span><span class="spanright"><a href="#" target="_blank"></a></span></div>
   <ul>
          <li><a href="#" target="_blank">全国易逃税案前</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">全国网交易逃税案</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">电子商以想像</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">网上开别</a><span>[07-01]</span></li>
          <li><a href="#" target="_blank">按照我为</a><span>[07-01]</span></li>
        </ul>
		 <div class="title"><span class="spanleft spanleft2">我有话说</span><span class="spanright"><a href="#" target="_blank"></a></span></div>
   <div class="wyhys">
   <p>用的满意吗?有话您直说!</p>
   <input class="input1" name="" type="text" />
   <input class="input2" name="" type="button"  value="提交"/>
   </div>
  </div>
</div>
<div class="clearfloat"></div>
<div class="footerw"></div>
<%@ include file="../../foot.jsp" %>
</body>
</html>