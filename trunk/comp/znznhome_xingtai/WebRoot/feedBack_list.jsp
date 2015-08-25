<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
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
	<link rel="stylesheet" href="css/xtls_index.css" />
	<link type="text/css" rel="stylesheet" href="css/admin/validator.css"></link>
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/formValidator-4.0.1.min.js" type="text/javascript" ></script>
	<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
	<script type="text/javascript" src="js/sla.js"></script>
	<script type="text/javascript">
		$(function(){
			$.formValidator.initConfig({formID:"feedBackForm",onError:function(msg){alert(msg)},onsuccess:function(){return true;}});
			$("#name").formValidator({onShow:"请输入姓名",onFocus:"姓名为4个以上字符",onCorrect:"输入正确"}).inputValidator({min:4,onError:"输入不正确"});
			$("#tel").formValidator({onShow:"请输入电话",onFocus:"电话为8个以上字符",onCorrect:"输入正确"}).inputValidator({min:8,onError:"输入不正确"});
			$("#email").formValidator({onShow:"请输入email",onFocus:"email为5个以上字符",onCorrect:"输入正确"}).inputValidator({min:5,onError:"输入不正确"});
			$("#title").formValidator({onShow:"请输入标题",onFocus:"标题为4个以上字符",onCorrect:"输入正确"}).inputValidator({min:4,onError:"输入不正确"});
			$("#content").formValidator({onShow:"请输入内容",onFocus:"内容为10个以上字符",onCorrect:"输入正确"}).inputValidator({min:10,onError:"输入不正确"});
			
		});
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
  <li class="bg1"><a href="about.jsp" target="_self">关于我们</a></li>
  <li class="bg2"><a href="news-list?ename=news01" target="_self">新闻中心</a></li>
  <li class="bg2"><a href="cases-list?ename=cases01" target="_self">工程案例</a></li>
  <li class="bg2"><a href="product-list?ename=product01" target="_self">产品中心</a></li>
  <li class="bg2 ts2"><a href="feedBack-list" target="_self">在线咨询</a></li>
  <li class="bg2"><a href="hr_list.jsp" target="_self">人才招聘</a></li>
  <li class="bg3"><a href="contact.jsp" target="_self">联系我们</a></li>
</ul>
<div class="jdt">
  <!-- 焦点图2 -->
  <div class="focus">
    <div class="sliderwrapper" id="slider">
      <div class="contentdiv" style="display:block; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/add1.jpg" alt=""/></a></div>
      <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/add2.jpg" alt=""  /></a></div>
      <div class="contentdiv" style="display:none; opacity:1; visibility: visible;"><a href="#" target="_blank"><img src="images/add3.jpg" alt=""/></a></div>
    </div>
    <div class="pagination" id="paginate-slider"> <a class="toc" href="#" rel="1">1</a> <a class="toc" href="#" rel="2">2</a><a class="toc" style=" border-right:none;" href="#" rel="3">3</a> </div>
  </div>
  <div class="clearfloat"></div>
  <!-- 焦点图2 -->
</div>
<div class="clearfloat"></div>
<div class="content">
  <div class="leftcon">
    <div style=" margin:0 auto; width:159px;"><img style="padding-top:16px;" src="images/con2_4.jpg"  width="159" height="44"/></div>
    <ul class="ldhbf">
      <li><a class="ldhbf" href="product-list?ename=product01" target="_self">德国Becker（贝克）真空泵 </a></li>
      <li><a href="product-list?ename=product02" target="_self">德国GardnerDenver（格南登福里其乐）真空泵</a></li>
      <li><a href="product-list?ename=product03" target="_self">德国Sterling-sihi（希赫）水环真空泵</a></li>
      <li><a href="product-list?ename=product04" target="_self">德国Busch（普旭）真空泵 </a></li>
      <li><a href="product-list?ename=product05" target="_self">法国leybold（莱宝）真空泵</a></li>
      <li><a href="product-list?ename=product06" target="_self">美国 Quincy（昆西）螺杆真空泵</a></li>
    </ul>
  </div>
  <div class="rightcon"><div class="lxwbt2">在线咨询</div>
    <div class="lycon">
      <div class="wyly1">
        <p>如果你有疑问请在线咨询，注<span>*</span>为必须填写</p>
      </div>
      <form action="feedBack-add" name="feedBackForm" id="feedBackForm" method="post">
      <table class="lysr" border="0" cellpadding="0" cellspacing="0">
	   <tr>
          <td colspan="2"><img src="images/xxx.gif" /><input name="type" type="radio" value="技术咨询" checked/>技术咨询&nbsp;&nbsp;&nbsp;&nbsp;<input name="type" type="radio" value="购买咨询" />购买咨询</td>
        </tr>
        <tr>
          <td width="80"><img src="images/xxx.gif" />姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
          <td width="430"><input class="input1" name="name" id="name" type="text" />
          <span id="nameTip"></span>
          </td>
        </tr>
        <tr>
          <td><img src="images/xxx.gif" />电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
          <td><input class="input1" name="tel" id="tel" type="text"  />
          <span id="telTip"></span>
          </td>
        </tr>
        <tr>
          <td><img src="images/xxx.gif" />E-mail：</td>
          <td><input class="input1" name="email" id="email" type="text" />
          <span id="emailTip"></span>
          </td>
        </tr>
        <tr>
          <td><img src="images/xxx.gif" />标&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
          <td><input class="input1" name="title"   id="title" type="text"/>
          <span id="titleTip"></span>
          </td>
        </tr>
        <tr>
          <td valign="top"><img src="images/xxx.gif" />留言内容：</td>
          <td><textarea class="input2" name="content" id="content" cols="" rows=""  max="500"></textarea>
          <br/><span id="contentTip"></span>
          </td>
        </tr>
        <tr height="70">
          <td></td>
          <td align="center"><input class="btn1" type="button" value="重置"  />
            &nbsp;&nbsp;&nbsp;
            <input class="btn2" name=""  type="submit" value="提交" /></td>
        </tr>
      </table>
	  </form>
	  
	  
	  <%
  
  //System.out.println(s);
  Page feedBack_page = (Page)request.getAttribute("page");
  //int startNo = feedBack_page.getStartNo();
  int pageSize = feedBack_page.getPageSize();
  int totalRecords = feedBack_page.getTotalRecords();
  int pageNo = feedBack_page.getPageNo();
  int totalPages = feedBack_page.getTotalPages();

  List<FeedBack> list_feedBack = feedBack_page.getList();
  %>
	  
	   <div class="wyly">
        <div class="spanleft">我要留言</div>
        <div class='spanright'>已经有<font><%=totalRecords %></font>个网友发表了留言</div>
      </div>
      <ul class="ully">
      
       <%
 	if(list_feedBack != null) {
	    for(Iterator<FeedBack> it = list_feedBack.iterator(); it.hasNext();) {
	    	FeedBack feedBack = it.next();
	  		int id = feedBack.getId();
	  		String title = feedBack.getTitle();
	  		String name = feedBack.getName();
	  		String content = feedBack.getContent();
			String createtime = CommonUtil.getTime(feedBack.getCreatetime());
%>
        <li>
          <div class='bt'><span class='spanleft'><%=content %></span><span class='spanright'><%=createtime %></span><span class='spanright spanmid'><%=name %></span></div>
          <p>     <%=content %></p>
        </li>
<%				
   	  	} //-- for循环 --
}
%>    
      
      </ul>
      
	  <div class="pages"><%
	  if(pageNo <= 1) {
		  %>
		  <span class="disabled"> <  Prev</span>
		  <%
	  }else {
		  %>
		  <a href="feedBack-list?countNumber=7&pageNo=<%=pageNo-1%>"> <  Prev</a>
		  <%
	  }

		for(int i=1; i<=totalPages; i++) {
			if(i == pageNo) {
				%>
				<span class="current"><%=i %></span>
		<%
			}else{
		%>
				<a href="Activity-list.action?ename=product01&pageNo=<%=i%>" target="_self"><%=i %></a>
		<%	
			}
		}
	  if(pageNo >= totalPages) {
		  %>
		  <span class="disabled">Next  > </span>
		  <%
	  }else {
		  %>
		  <a href="feedBack-list?countNumber=7&pageNo=<%=pageNo+1%>"> Next  > </a>
		  <%
	  }
	  %>
	  &nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
  </div>
  <div class="clearfloat"></div>
</div>
</div>

</div>
<div class="clearfloat"></div>
<div class="footer">
  <div class="footern">
    <ul class="ftbf ftbf1">
      <li><img class="l" src="images/lx1.jpg" />
        <div class="bt1">星泰龙森（北京）机械设备有限公司</div>
        <div style="height:5px;"></div>
        <p>电话：<img src="images/xt1.jpg" /> 地址：北京市朝阳区亮马桥平安国际金融中心<br />
          电邮：bj@163.com<br />
          传真：010-81485860<br />
          <img src="images/xt4.jpg" /><br />
        </p>
      </li>
    </ul>
    <ul class="ftbf ftbf1">
      <li><img  class="l" src="images/lx2.jpg" />
        <div style="height:5px;"></div>
        <p>如果您对我们的产品有任何意见获建议，都可以给我们留言，
          我们会在第一时间给您答复！<br />
        <div style="height:5px;"></div>
        <img src="images/xt3.jpg" /><br />
        </p>
      </li>
    </ul>
    <ul class="ftbf ftbf2">
      <li><img  class="l" src="images/lx3.jpg" />
        <div style="height:5px;"></div>
        <p>您还可以在线联系我们的客服
        <div style="height:5px;"></div>
        <img src="images/xt2.jpg" border="0" usemap="#Map" />
        <map name="Map" id="Map">
          <area shape="circle" coords="21,20,17" href="#" />
          <area shape="circle" coords="60,19,16" href="#" />
          <area shape="circle" coords="101,20,18" href="#" />
          <area shape="circle" coords="141,19,18" href="#" />
        </map>
        <a href="#top"> <img style="margin-top:62px;_margin-top:28px; float:right; display:inline; margin-right:15px;" src="images/xt5.jpg" /></a>
        </p>
      </li>
    </ul>
  </div>
  <div class="clearfloat"></div>
  <div class="bqbf">
    <div class="l">Copyright © 2009 XING TAI LONG SEN BEIJING. All Rights Reserved   星泰龙森 版权所有    TEL: 010-61257360</div>
    <div class="r">备案序号:京ICP备10200836</div>
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
