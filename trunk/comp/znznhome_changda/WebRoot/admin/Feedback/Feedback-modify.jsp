<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp,com.changda.util.*,com.changda.model.*,com.changda.service.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="../util/check2.jsp"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    
    <title>订购反馈信息查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/admin/table-add.css">
	

	
  </head>
  
  <body>
  <%
	String id = request.getParameter("id");
	FeedbackManager feedbackManager = FeedbackManager.getInstance();
	Feedback feedback = new Feedback();
	feedback = feedbackManager.loadByID(Integer.parseInt(id));	
	
	String address = feedback.getAddress();
	String contactperson = feedback.getContactperson();
	String company = feedback.getCompany();
	String tel = feedback.getTel();
	String email = feedback.getEmail();
	String detail = feedback.getDetail();
	Timestamp createtime = feedback.getCreatetime();
	String subject = feedback.getSubject();
	String title = feedback.getTitle();
	String mobile = feedback.getMobile();
	String fax = feedback.getFax();
	String province = feedback.getProvince();
	String postcode = feedback.getPostcode();

 %>
         <br>
      	<center><h5>订购反馈信息查看</h5></center><hr>

      <!-- ----------表单开始-----------   -->
  <form action="admin/Feedback-modify.action" method="post" id="hshfeedbackadd" name="hshfeedbackadd">
  <input type="hidden" name="feedbackID" value="<%=id %>">
  <table width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="8%">联系人：</td>
      <td width="24%">
<input disabled="true" name="name" type="text" id="name" size="30" value="<%=contactperson %>">

        
      </td>
      <td width="5%"  id="pcodeTip" ></td>
      <td width="8%">反馈主题：</td>
      <td width="65%"><input disabled="true" name="name" type="text" id="name" size="30" value="<%=subject %>"></td>
    </tr>

    <tr>
      <td>职务：</td>
      <td>
      <input disabled="true" name="name" type="text" id="name" size="30" value="<%=title %>">
      </td>
      <td  id="pnameTip" > </td>
      <td>email：</td>
      <td><input disabled="true" name="name" type="text" id="name" size="30" value="<%=email %>"></td>
    
    </tr>
       <tr>
      <td width="8%">电话：</td>
      <td width="24%">
<input disabled="true" name="name" type="text" id="name" size="30" value="<%=tel %>">

        
      </td>
      <td width="5%"  id="pcodeTip" ></td>
      <td width="8%">手机：</td>
      <td width="65%"><input disabled="true" name="name" type="text" id="name" size="30" value="<%=mobile %>"></td>
    </tr>

    <tr>
      <td>单位名称：</td>
      <td>
<input disabled="true" name="name" type="text" id="name" size="30" value="<%=company %>">
      </td>
      <td  id="pnameTip" > </td>
      <td>传真：</td>
      <td><input disabled="true" name="name" type="text" id="name" size="30" value="<%=fax %>"></td>
    
    </tr>
    
        <tr>
      <td width="8%">省/市：</td>
      <td width="24%">
<input disabled="true" name="name" type="text" id="name" size="30" value="<%=province %>">

        
      </td>
      <td width="5%"  id="pcodeTip" ></td>
      <td width="8%">详细地址：</td>
      <td width="65%"><input disabled="true" name="name" type="text" id="name" size="30" value="<%=address %>"></td>
    </tr>

    <tr>
      <td>邮编：</td>
      <td>
<input disabled="true" name="name" type="text" id="name" size="30" value="<%=postcode %>">
      </td>
      <td  id="pnameTip" > </td>
      <td></td>
      <td></td>
    
    </tr>
    
        <tr>
      <td>信息描述：</td>
      <td>
<textarea rows="3" cols="30" disabled="true"><%=detail %></textarea>
      </td>
      <td  id="pnameTip" > </td>
      <td></td>
      <td></td>
    
    </tr>
    



   
    <tr>
      <td>&nbsp;</td>
      <td colspan="2"><input  type="button" onclick="javascript:history.go(-1);" value="返回" /></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <br><br/>
  </form>
    <!-- ----------表单结束-----------   -->
  </body>
</html>
