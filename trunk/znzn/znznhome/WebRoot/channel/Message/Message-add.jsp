<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>信息发布</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/channel/znzn-xxcon.css" />
  </head>
  
<body>
<%@ include file="../../head.jsp" %>
<div class="clearfloat"></div>
<div class="spdp xxfb">
  <div class="title"><span style=" float:left;"><a href="#" target="_blank">视频短片</a></span><span class="rightxx">lxd810，您好！</span></div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_fb">
    <tr>
      <td width="80" align="right">主题：</td>
      <td width="270"><input class="input1" name="" type="text" /></td>
      <td width="80" align="right">分类：</td>
      <td width="270"><select class="input1" name="">
          <option>网上商城</option>
        </select></td>
    </tr>
    <tr>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
    </tr>
    <tr>
      <td align="right">所在地：</td>
      <td><select class="input2 mright6" name="">
          <option></option>
        </select>
        <select class="input2 mright6" name="">
          <option></option>
        </select>
        <select class="input2" name="">
          <option></option>
        </select></td>
      <td align="right">联系方式：</td>
      <td><input class="input1" name="" type="text" /></td>
    </tr>
    <tr>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
    </tr>
    <tr>
      <td align="right">关键字：</td>
      <td><input class="input1" name="" type="text" /></td>
      <td align="right">XXX：</td>
      <td><input class="input1" name="" type="text" /></td>
    </tr>
    <tr>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
      <td></td>
      <td class="yzxx">请输入正确的格式</td>
    </tr>
	 <tr>
      <td align="right" valign="top">详细内容：</td>
      <td colspan="3" align="left"  class="bjqw"><input class="bjq" name="" type="text" value="这里放编辑器" /></td>
    </tr>
	<tr>
      <td></td>
      <td colspan="3" class="yzxx">请输入正确的格式</td>
    </tr>
	<tr>
      <td></td>
      <td colspan="3" align="center"><input class="tj" name="" type="button" />&nbsp;&nbsp;<input class="cz" name="" type="button" /></td>
    </tr>
  </table>
</div>
<div class="hw_lx"></div>
<div class="clearfloat"></div>
<div class="footerw"></div>
<%@ include file="../../foot.jsp" %>
</body>
</html>