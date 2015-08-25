<%@ page language="java" import="java.util.*, java.net.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,com.opensymphony.xwork2.ActionContext" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>图片网址列表</title>
	<link rel="stylesheet" type="text/css" href="css/menu/superfish.css" media="screen">
	<script type="text/javascript" src="js/menu/hoverIntent.js"></script>
	<script type="text/javascript" src="js/menu/superfish.js"></script>
	<script type="text/javascript">

	// initialise plugins
	jQuery(function(){
		jQuery('ul.sf-menu').superfish();
	});

	</script>
	<style type="text/css">
		.znzn_menu {text-align: center; height:26px }
		.znzn_menu_span {display: inline-block; width: 959px; margin-top: 2px;}
	</style>
	
  </head>
  
<body>
<%
ApplicationContext ctx_menu = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
CategoryManager categoryManager_menu = (CategoryManager)ctx_menu.getBean("categoryManager");
List<Category> categorys_menu = new ArrayList<Category>();
categorys_menu =  categoryManager_menu.getChilds(0);
if(categorys_menu != null && categorys_menu.size() > 0) {
%>
<div class="znzn_menu">
		<span class="znzn_menu_span">
		<ul class="sf-menu">
<%
	for(int i=0; i<categorys_menu.size(); i++) {
		Category category = categorys_menu.get(i);
		int id = category.getId();
		int leaf = category.getIsleaf();
%>
		<li>
				<a href="url-list?categoryid=<%=id %>&countNumber=<%=Constant.PAGESIZE %>"><%=category.getName() %></a>
					<ul>
<%
		if(leaf == 0) {
			getTree(id, out);
		}
%>
				</ul>
		</li>
<%
	}
%>
		</ul>
		</span>
</div>
<%	
}
%>

<%!
public void getTree(int id, JspWriter out) {
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	CategoryManager categoryManager = (CategoryManager)ctx.getBean("categoryManager");
	List<Category> categorys = new ArrayList<Category>();
	categorys =  categoryManager.getChilds(id);
	if(categorys != null && categorys.size() > 0) {
		for(int i=0; i<categorys.size(); i++) {
			Category category = categorys.get(i);
			int cid = category.getId();
			int leaf = category.getIsleaf();

			if(leaf == 0) {
				try{
					out.println("<li><a href=\"url-list?categoryid=" + cid + "&countNumber=" + Constant.PAGESIZE + "\">" + category.getName() + "</a><ul>");
				}catch(Exception e) {
					e.printStackTrace();
				}
				getTree(cid, out);
				try{
					out.println("</ul></li>");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else{
				try{
					out.println("<li><a href=\"url-list?categoryid=" + cid + "&countNumber=" + Constant.PAGESIZE + "\">" + category.getName() + "</a></li>");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
%>

</body>
</html>