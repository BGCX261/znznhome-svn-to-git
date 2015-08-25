<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'result2.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
body {
	font-family: arial, sans-serif;
	font: 13px/ 27px Arial, sans-serif;
}

.top_black {
	background-color: rgb(45, 45, 45);
	border-bottom: 1px solid rgb(0, 0, 0);
	background-position: 0px;
	height: 29px;
	opacity: 1;
	position: relative;
	top: 0px;
	width: 100%;
	z-index: 990;
}

.top_black span {
	display: inline;
	border-left: 1px solid transparent;
	border-right: 1px solid transparent;
	padding: 0px 5px;
	position: relative;
	z-index: 1000;
	color: rgb(204, 204, 204) !important;
	line-height: 27px;
}

.search_block {
	border-bottom: 1px solid rgb(229, 229, 229);
	height: 71px;
	background: none repeat scroll 0% 0% rgb(245, 245, 245);
}

.search_logo {
	left: 0px;
	position: relative;
	padding-top: 6px;
	padding-left: 16px;
	padding-right: 12px;
	z-index: 1;
	width: 100px;
	float: left;
}

.search_area {
	position: relative;
	padding-bottom: 2px;
	padding-top: 20px;
}

.search_input {
	padding-top: 3px;
	border-color: rgb(160, 160, 160) rgb(185, 185, 185) rgb(185, 185, 185)!important;
	box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3) inset;
	background-color: rgb(255, 255, 255);
	border-width: 1px;
	border-style: solid;
	border-right: 1px solid rgb(217, 217, 217);
	-moz-border-top-colors: none;
	-moz-border-right-colors: none;
	-moz-border-bottom-colors: none;
	-moz-border-left-colors: none;
	border-image: none;
	height: 27px;
	width: 650px;
	float: left;
}

.search_input input {
	color: rgb(0, 0, 0);
	font: 17px arial, sans-serif;
	width: 90%;
	border: 0px none;
	padding-left: 6px;
	padding-top: 0px !important;
	margin-top: 2px;
	margin-bottom: 2px;
	-moz-box-sizing: content-box;
	-moz-padding-start: 0px;
	-moz-padding-end: 0px;
	float: left;
}

.search_button {
	margin-left: 16px;
	position: relative;
	z-index: 100;
	height: 27px;
	width: 70px;
	padding: 0px;
	border-radius: 2px 2px 2px 2px;
	cursor: default !important;
	line-height: 27px;
	min-width: 54px;
	text-align: center;
	transition: all 0.218s ease 0s;
	-moz-user-select: none;
	background-image: -moz-linear-gradient(center top, rgb(77, 144, 254),
		rgb(71, 135, 237) );
	background-color: rgb(77, 144, 254);
	border: 1px solid rgb(48, 121, 237);
	float: left;
}

.search_button button {
	background: none repeat transparent;
	color: transparent;
	font-size: 0px;
	overflow: hidden;
	position: relative;
	width: 100%;
	border: 0px none;
	height: 30px;
	margin: 0px;
	vertical-align: top;
	cursor: default !important;
	text-align: center;
	float: left;
}

.button_span {
	background: url("images/common/search.gif") no-repeat transparent;
	width: 69px;
	height: 30px;
	display: inline-block;
	margin: 1px auto 0px;
	cursor: default !important;
	text-align: center;
}

.time_block {
color: rgb(34, 34, 34);
margin-left: 138px !important;
height: 35px;

}
.time_text {
padding: 0px 8px 0px 16px;
color: rgb(153, 153, 153);
font-size: 13px;
line-height: 35px;
overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
top: 0px;
transition: all 220ms ease-in-out 0s;
font-family: arial,sans-serif;

}

.result_block {
clear: both;
position: relative;
margin-top: 3px;
font-family: arial,sans-serif;


}

.result_center {
width: 528px;
margin-left: 138px !important;
padding: 0px 8px ;
clear: both;
margin-right: 264px;
font-size: medium;
font-weight: normal;
max-width: 42em;


}

.result_center ul {
border: 0px none;
margin: 0px;
padding: 10px 0px 20px 0px;
}
.result_center li {
border: 0px none;
margin: 0px;
padding: 0px;
list-style: none outside none;
line-height: 1.2;

}

.result_text_title{
display: block;
overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
line-height: 1;
color: rgb(17, 34, 204);
cursor: pointer;

}
.result_text_url{
display: block;
margin-bottom: 1px;
font-family: arial,sans-serif;
line-height: 1.54;
font-size: small;
font-weight: normal;
color: rgb(0, 153, 51);
font-style: normal;
}
.result_text_descr{
line-height: 1.24;
color: rgb(34, 34, 34);
font-size: small;
font-weight: normal;

}
</style>



	</head>

	<body>
		<div class="content_znzn">
			<div class="top_black">
				<span>abc</span><span>abc</span><span>abc</span>
			</div>
			<div class="search_block">
				<div class="search_bar">
					<div class="search_logo"><img src="images/logo_search.gif"/></div>
					<div class="search_area">
						<div class="search_input"><input type="text" value="" name="" id=""/></div>
						
						<div class="search_button"><button name="" ><span class="button_span"></span></button></div>
					</div>
					
				</div>
			</div>
			<div class="category_block"></div>
			<div class="time_block">
				<div class="time_text">找到约 29,600,000 条结果 （用时 0.11 秒） </div>
			</div>
			<div class="result_block">
				<div class="result_center">
					<ul>
						<li>
						<div class="result_text_title">图片搜索-搜索结果页面介绍</div>
						<div class="result_text_url">help.cn.yahoo.com/answerpage_3657.html </div>
						<div class="result_text_descr">图片搜索结果每个页面显示九张图片，左侧会显示“分类推荐”和“别人正在搜”，全部图片时提供“按大小筛选”的功能。 此条内容是否对您有帮助？ 是 否. 感谢您的反馈！
 </div>
						</li>
					</ul>
					
					<ul>
						<li>
						<div class="result_text_title">图片搜索-搜索结果页面介绍</div>
						<div class="result_text_url">help.cn.yahoo.com/answerpage_3657.html </div>
						<div class="result_text_descr">图片搜索结果每个页面显示九张图片，左侧会显示“分类推荐”和“别人正在搜”，全部图片时提供“按大小筛选”的功能。 此条内容是否对您有帮助？ 是 否. 感谢您的反馈！
 </div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>


