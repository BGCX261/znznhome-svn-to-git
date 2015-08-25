<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*,java.util.Date,java.text.SimpleDateFormat" %>
<%@page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%//@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>product-manager</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">
	<link rel="stylesheet" type="text/css" href="css/admin/content_format.css">
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
  </head>
  
  <br/><div id="tableTitle" class="tableTitle">产品列表</div><hr><br/>
  
<%
	  Page product_page = (Page)request.getAttribute("page");
	  String sql = product_page.getSql();
	  String sql_count = product_page.getSql_count();
	  int pageSize = product_page.getPageSize();
	  int pageNo = product_page.getPageNo();
	  int totalPages = product_page.getTotalPages();
%>
<form action="admin/product-manager" method="post" name="hshproductmgsearch">
		    	&nbsp;&nbsp;&nbsp;&nbsp; 
		    	<select style="width:80px" name="search_condition">
		    	 	<option value="title">标题</option>
		    	 	<option value="productname">产品名称</option>
		    	 	<option value="productnumber">产品货号</option>
		    	 	<option value="content">内容说明</option>
		    	 </select> like
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索"> 
</form>
  
<form action="" method="post" name="mainform">
 <table class="table"  border="1">
  <tr class="tr1">
  	<td width="3%"></td>
    <td width="4%">ID</td>
    <td width="30%">标题</td>    
    <td width="10%">类别</td>    
    <td width="20%">产品名称</td>    
    <td width="10%">推荐</td>    
    <td width="13%">日期</td> 
    <td width="5%">修改</td>    
    <td width="5%">删除</td>
  </tr>

<%
	List<Product> list = product_page.getList();
   	if(list != null) {
  	    for(Iterator<Product> it = list.iterator(); it.hasNext();) {
  	    	Product product = it.next();
  	  		int id = product.getId();
  	  		int categoryid = product.getCategoryid();
	  	  	String title = CommonUtil.filterHtmlAndSubStr(product.getTitle(), 12);
	  	  	String categoryname = product.getCategoryname();
	  		int recflag = product.getRecflag();
	  		String productname = product.getProductname();
	  		String createtime = CommonUtil.getTime(product.getCreatetime());
	  		String str_recflag = recflag == 0 ? "未推荐" : "推荐";
%>

  <tr class="tr2">
  		<td><input type="checkbox" id="productIDs" name="productIDs" value="<%=id %>"></td>
  		<td><%=id %></td>
	    <td><%=title %></td>    
	    <td><%=categoryname %></td>    
	    <td><%=productname %></td>    
	    <td><%=str_recflag %></td>
	    <td><%=createtime %></td>
	    <td><a href="admin/product/product-modify.jsp?id=<%=id %>"><img style="border-width: 0px" src="<%=basePath %>/images/admin/modify.gif"/></a></td>
	    <td><a href="admin/product-delete?productID=<%=id %>"><img style="border-width: 0px; " src="<%=basePath %>/images/admin/del.gif"/></a></td>
	  </tr>
<%
		} //-- for循环 --
	}
%>
</table>
</form>
		<!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/product-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/product-manager?pageNo=1">首页</a> 
			<a href="admin/product-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/product-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/product-manager?pageNo=<%=totalPages%>">尾页</a> 
			页次：<%=pageNo%>/<%=totalPages%>
			转到：<select name="pageNo" onChange="document.form1.submit()">
					<%
					for(int i=1; i<=totalPages; i++) {
					%>
					<option value=<%=i %> <%=(pageNo == i) ? "selected" : ""%>>第<%=i%>页 </option>
					<%
					}
					%>
				</select>
			</form>
		<!-- ------------以上HTML分页区------------ -->
  </body>
</html>
