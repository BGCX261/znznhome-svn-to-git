<%@ page import="com.changda.model.*,com.opensymphony.xwork2.ActionContext" %>
	<% 
		String s = (String)ActionContext.getContext().getSession().get("name");
		User user = (User)ActionContext.getContext().getSession().get("user");
		if(s == null || user == null) {
			response.sendRedirect("../login.jsp");
			return;
		}	 
	 %>



