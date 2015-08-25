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
<table border="0" cellpadding="0" cellspacing="0" class="grxx2">
  <tr>
    <td align="left" colspan="2" class="jbzltitle" style="color:#262722;">基本资料</td>
  </tr>

  <tr>
    <td align="right">真实姓名：</td>
    <td align="left"><input class="input1" name="" type="text" /></td>
  </tr>
    <tr>
    <td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    <td align="left"><input class="input3"  name="" type="radio" value="" />男<input class="input3"  name="" type="radio" value="" />女</td>
  </tr>
    <tr>
    <td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
    <td align="left"><select class="input2" name=""><option>请选择年龄</option></select></td>
  </tr>
    <tr>
    <td align="right">所&nbsp;在&nbsp;地：</td>
    <td align="left"><select class="input2" name=""><option>请选择省(直辖市、自治区)</option></select><select class="input2" name=""><option>请选择市(地区)</option></select></td>
  </tr>
   <tr>
    <td align="right">单位全称：</td>
    <td align="left"><input class="input1" name="" type="text" /></td>
  </tr>
   <tr>
    <td align="right">单位类型：</td>
    <td align="left"><select class="input2" name=""><option>请选择单位所属类型</option></select></td>
  </tr>
   <tr>
    <td align="right">手机号码：</td>
    <td align="left"><input class="input1" name="" type="text" /></td>
  </tr>
   <tr>
    <td align="right">电子邮箱：</td>
    <td align="left"><input class="input1" name="" type="text" /></td>
  </tr>
   <tr>
    <td align="left" colspan="2" style="padding-left:20px;"><input class="but1" name="" type="button" />&nbsp;&nbsp;<input class="but2" name="" type="button" /></td>
  </tr>

</table>



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