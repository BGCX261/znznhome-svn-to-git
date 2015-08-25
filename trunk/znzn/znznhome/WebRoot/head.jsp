<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.factory.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%
//分频道
String channel_head = request.getParameter("channel");
String[] claz = CssFactory.getNaviCss(channel_head);
%>
<div class="top">
  <div class="daohang">
    <div class="logo"><img src="images/homepage/logo.gif" /></div>
    <div class="dh">
<%
    String membername =  (String)session.getAttribute("name");
    Integer purview = (Integer)session.getAttribute("purview");
    //普通用户以上，均可以修改维护自己的东西；
    if(CommonUtil.isNotEmpty(membername) && CommonUtil.isNotEmpty(purview) && purview.intValue() <= Member.COMMONMANAGER) {
%>
      <P><img src="images/common/user.png" />
      Welcome: <a> <%=membername %></a>
      </P>
<%    	
    }else{
%>
      <P><img src="images/homepage/topr1.png" />
      <a href="login.html?height=160;width=400" class="thickbox">登录</a>
      <img src="images/homepage/topr2.png" />
      <a href="#" target="_blank">注册</a>
      </P>
<%    	
    }
%>
      <ul>
        <li><a <%=claz[0] %> href="channel.jsp?channel=homepage" target="_self">首 页</a></li>
        <li><a <%=claz[1] %>  href="channel.jsp?channel=news-posts" target="_self">新闻热帖</a></li>
        <li><a <%=claz[2] %>  href="channel.jsp?channel=self-study" target="_self">自学天地</a></li>
        <li><a <%=claz[3] %>  href="channel.jsp?channel=professional-gamers" target="_self">专业玩家</a></li>
        <li><a <%=claz[4] %>  href="channel.jsp?channel=video-music" target="_self">影视音乐</a></li>
        <li><a <%=claz[5] %>  href="channel.jsp?channel=znzn-opinions" target="_self">屌丝声音</a></li>
        <li><a <%=claz[6] %>  href="channel.jsp?channel=cool-sites" target="_self">未知酷站</a></li>
        <li><a <%=claz[7] %>  href="channel.jsp?channel=src-download" target="_self">资源下载</a></li>
      </ul>
    </div>
  </div>
  <%@ include file="menu.jsp" %>
</div>

