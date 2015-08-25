<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp, com.znznhome.util.*,com.znznhome.model.*, com.znznhome.service.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'configmg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=basePath%>js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/admin/table-list.css">
	<script type="text/javascript">
			function znzn_config_refresh() {
				$.ajax({url:'ajax/config-refresh',type : 'POST', data:{}, success:function(data) {alert('refresh success!');}
								}); 
			}
	</script>

  </head>
  
  <body>&nbsp; 
  
   <br/><div id="tableTitle" class="tableTitle">计划任务列表 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="button" onclick="znzn_config_refresh();" value="刷新配置文件"/></div> <hr><br/>
  <%
  Page config_page = (Page)request.getAttribute("page");
  String sql = config_page.getSql();
  String sql_count = config_page.getSql_count();
  int pageSize = config_page.getPageSize();
  int pageNo = config_page.getPageNo();
  int totalPages = config_page.getTotalPages();
  %>
   <form action="admin/config-manager" method="post" name="managerform">
   		    	&nbsp;&nbsp;&nbsp;&nbsp; <select style="width:80px" name="search_condition">
		    	 	<option value="item">配置项 </option>
		    	 	<option value="conffield">配置字段 </option>
		    	 	<option value="confdescr">配置描述 </option>
		    	 </select> like
		    	 
		    	 <input style="width:180px" type="text" name="search_content"> 
		    	 <input type="hidden" name="action_search" value="action_search">
		    	 <input type="submit" value="搜索">
  </form>
 <table class="table"  border="1">
 
  <tr class="tr1">
	  <td width="5%">ID</td>
	  <td width="10%">配置项</td>
	  <td width="8%">配置字段</td>
	  <td width="7%">配置值</td>
	  <td width="5%">排序值</td>
	  <td width="35%">配置描述</td>
	  <td width="15%">&nbsp</td>
	  <td width="15%">&nbsp</td>
  </tr>
  		
  			
		<%
		List<Config> configList = config_page.getList();
		if(configList != null) {
			for(Iterator<Config> it = configList.iterator(); it.hasNext(); ) {
				Config u = it.next();
				int id = u.getId();
				//String name = new String(u.getName().getBytes("gb2312")); //解决中文乱码问题；
				String item = u.getItem();
				String conffield = u.getConffield();
				String confvalue = u.getConfvalue();
				String confdescr = u.getConfdescr();
				int orders = u.getOrders();
			%>
			
  <tr class="tr2">
				<td><%=id %></td>
				<td><%=item %></td>
				<td><%=conffield %></td>
				<td><%=confvalue %></td>
				<td><%=orders %></td>
				<td><%=confdescr %></td>
				<td><a href="admin/config/config-modify.jsp?id=<%=id %>">修改</a></td>
				<td><a href="admin/config-delete.action?configID=<%=id %>">删除</a></td>
			</tr>			
			<%	
			}
		 }
		 %>

	 </table>
	 <!-- ------------以下HTML分页区------------ -->
			<form name="form1"  action="admin/config-manager">			
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="admin/config-manager?pageNo=1">首页</a> 
			<a href="admin/config-manager?pageNo=<%=pageNo-1%>">上一页</a> 
			<a href="admin/config-manager?pageNo=<%=pageNo+1%>">下一页</a>   
			<a href="admin/config-manager?pageNo=<%=totalPages%>">尾页</a> 
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
