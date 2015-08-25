<%@ page import="com.znznhome.model.*,com.opensymphony.xwork2.ActionContext" %>
	<% 
		String s = (String)ActionContext.getContext().getSession().get("name");
		Member member = (Member)ActionContext.getContext().getSession().get("member");
		if(s == null || member == null) {
			response.sendRedirect("../login.jsp");
			return;
		}	 
	 %>



