<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp, com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../util/check2.jsp"  %>


    <%
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
    String ename = request.getParameter("ename");
    //System.out.println(ename);
    if(ename == null || ename.trim().equals("")){
    	out.print("<span style='color:red'>英文名不允许为空,请重新输入!</span>");
    	return;
    }
    String result = categoryManager.enameExists(ename)?"<span style='color:red'>英文名已存在,请重新输入!</span>":"<span style='color:green'>英文名未重复,输入合法!</span>";
    out.print(result);
    %>

