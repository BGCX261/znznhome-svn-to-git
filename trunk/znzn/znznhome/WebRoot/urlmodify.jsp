<%@ page language="java" import="java.util.*,net.fckeditor.*, java.net.*"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.Timestamp,com.znznhome.util.*,com.znznhome.model.*,com.znznhome.service.*"%>
<%@page
	import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>urlmodify</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/urladd.css"/>
		<script src="<%=basePath%>js/formValidator-4.0.1.min.js" type="text/javascript" ></script>
		<script src="<%=basePath%>js/formValidatorRegex.js" type="text/javascript" ></script>
		<script type="text/javascript">
			var flag = false;
			$(function(){
				$.formValidator.initConfig({formID:"url-modify",status:"sumbitingWithAjax", onError:function(msg){alert(msg);},onSuccess:function(){flag = true; return true;}});
				$("#idandname").formValidator({onShow:"请输入目录",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:1,onError: "<font color='red'>请选目录</font>"});
				$("#title").formValidator({onShow:"请输入标题",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:80,onError:"<font color='red'>最少4位</font>"});
				$("#tags").formValidator({onShow:"请输入标题",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:8,onError:"<font color='red'>2~4个字</font>"});
				$("#urladdress").formValidator({onShow:"请输入链接",onFocus:"必填项",onCorrect:"<font color='green'>输入正确</font>"}).inputValidator({min:4,max:200,onError:"<font color='red'>最少4位</font>"});
			});
			function znzn_urlAdd() {
				$("#url-modify").bind('submit',function(){
					//alert(flag); 
					if(flag==false){
						return false;
					}else{
						//alert("debug");
						//alert("#recflag" + $("#recflag").val());
						//alert("#idandname" + $("#idandname").val());
						//alert("#title" + $("#title").val());
						//alert("#urladdress" + $("#urladdress").val());
						//alert("#origin" + $("#origin").val());
						//alert("#descr" + $("#descr").val());
						var recflag = $("#recflag").val();
						var idandname = $("#idandname").val();
						var title = $("#title").val();
						var urladdress = $("#urladdress").val();
						var origin = $("#origin").val();
						var descr = $("#descr").val();
						$.ajax({url:'ajax/url-modify',type : 'POST', data:{'idandname' : idandname, 'title' : title, 'urladdress' : urladdress, 'origin' : origin, 'descr' : descr}, success:function(data) {alert('modify success!');TB_remove();}
								}); 
						return false;
					}
				} 	);
			}
		</script>
	</head>

	<body>
	<%
	//request.setCharacterEncoding("GBK"); 
	String categoryId = request.getParameter("categoryid");
	String categoryName = request.getParameter("categoryname");
	//服务器上不加，本地加
	categoryName = new String(categoryName.getBytes("latin1"),("UTF-8"));
	String idAndName = categoryId + "#" + categoryName;
	//out.println(idAndName);
	%>
		<div class="znzn_urladd">
			<div class="znzn_title">
				自由添加网址和链接(不合理内容将被拒绝)
			</div>
				<form action="" method="post" name="url-modify" id="url-modify" onsubmit="znzn_urlAdd();">
					<table class="znzn_urladdtable" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td class="znzn_bfont" width="100px">
								类别：
							</td>
							<td width="300px">
							<select class="znzn_selectbox"  id="idandname" name="idandname">
									<option value="0#根目录">
										根目录
									</option>
									<%
										ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
										CategoryManager categoryManager = (CategoryManager) ctx.getBean("categoryManager");
										List<Category> list = new ArrayList();
										list = categoryManager.getAllChilds(list, 0);
										if (list.size() != 0) {
											for (int i = 0; i < list.size(); i++) {
												Category category = list.get(i);
												int id = category.getId();
												String name = category.getName();
												int grade = category.getGrade();
												String pre_str = "";
												for (int j = 0; j <= grade; j++) {
													pre_str = pre_str + "|--";
												}
									%>

									<option value="<%=id%>#<%=name %>"><%=pre_str + name%></option>

									<%
										}//for(int i=0; i<categoryList.size(); i++) {    
										}//if (list.size() != 0) {
									%>
								</select>
									<script type="text/javascript">
			        					$("#idandname")[0].value="<%=idAndName %>";
			        				</script>
							</td>
							<td id="idandnameTip">
							</td>
						</tr>
						<tr>
							<td class="znzn_bfont">
								标题：
							</td>
							<td>
								<input class="znzn_txtbox" name="title" type="text" id="title" /><br/>
							</td>
							<td id="titleTip">
								
							</td>
							
						</tr>
						<tr>
							<td class="znzn_bfont">
								URL链接：
							</td>
							<td>
								<input class="znzn_txtbox" name="urladdress" type="text" id="urladdress"/><br/>
							</td>
							<td id="urladdressTip">
							</td>
							
						</tr>
						<tr>
							<td class="znzn_bfont">
								来源：
							</td>
							<td>
								<input class="znzn_txtbox" name="origin" type="text" id="origin"/><br/>
							</td>
							<td id="originTip">
							</td>
						</tr>
						<tr>
							<td class="znzn_bfont">
								标签：
							</td>
							<td>
								<input class="znzn_txtbox" name="tags" type="text" id="tags"/><br/>
							</td>
							<td id="tagsTip">
							</td>
						</tr>
						<tr>
							<td class="znzn_bfont">
								简评：
							</td>
							<td>
								<textarea class="znzn_areabox" name="descr" id="descr" ></textarea>
							</td>
							<td id="descrTip"></td>
						</tr>

						<tr>
							<td class="znzn_bfont">
							</td>
							<td>
							<input type="submit" value="添加" /> &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消" />	
							</td>
							<td>
							</td>
						</tr>
					</table>
				</form>

		</div>
	</body>
</html>
