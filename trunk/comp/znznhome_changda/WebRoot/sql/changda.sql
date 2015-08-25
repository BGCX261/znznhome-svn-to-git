drop database changda;

create database changda;

use changda;

#产品
create table product (
	id int primary key not null auto_increment, 
	categoryid int, #分类目录ID
	categoryname varchar(100), #分类名称
	title varchar(200) not null,  #标题
	productname varchar(200), #产品名称
	model varchar(200), #产品型号
	productnumber varchar(200), #产品货号
	brand varchar(100), #品牌
	unit varchar(100), #计量单位
	picurl varchar(200), #图片名称
	content	text, #产品详情
	createtime timestamp default now(), #创建时间
	updatetime timestamp, #更新时间
	seotitle varchar(200), #Seo页标题
	seokeywords varchar(200), #Seo关键词
	seodescription varchar(500), #Seo描述
	topscore int default 0, #置顶权重(0不置顶，1置顶)
	recflag int(2) #是否推荐（0不推荐，1推荐）
);

#新闻  
create table news (
	id int primary key not null auto_increment, 
	categoryid int, #分类目录ID
	categoryname varchar(100), #分类名称
	title varchar(200) not null,  #标题
	picurl varchar(200), #图片名称
	content	text, #新闻内容
	createtime timestamp default now(), #创建时间
	updatetime timestamp, #更新时间
	author varchar(100), #新闻作者
	origin varchar(200), #新闻来源
	seotitle varchar(200), #Seo文章页标题
	seokeywords varchar(200), #Seo关键词
	seodescription varchar(500), #Seo描述
	topscore int default 0, #置顶权重(0不置顶，1置顶)
	recflag int(2) #是否放到首页（0不推荐，1推荐）
);

#案例
create table cases (
	id int primary key not null auto_increment, 
	categoryid int, #分类目录ID
	categoryname varchar(100), #分类名称
	title varchar(200) not null,  #标题
	casename varchar(200), #项目名称
	scale varchar(200), #规模
	location varchar(200), #项目地点
	casetime varchar(200), #设计时间
	picurl varchar(200), #图片名称
	content	text, #内容
	createtime timestamp default now(), #创建时间
	updatetime timestamp, #更新时间
	seotitle varchar(200), #Seo页标题
	seokeywords varchar(200), #Seo关键词
	seodescription varchar(500), #Seo描述
	topscore int default 0, #置顶权重(0不置顶，1置顶)
	recflag int(2) #是否推荐（0不推荐，1推荐）
);

#订购反馈
create table feedback (
	id int primary key not null auto_increment,
	subject varchar(100), #反馈主题
	contactperson varchar(100), # 姓名
	title varchar(100), #职务
	email varchar(100), #email
	tel varchar(100), #电话
	mobile varchar(100), #手机
	fax varchar(100), #传真
	company varchar(100), #单位
	province varchar(100), #省
	city varchar(100),#市
	district varchar(100),#区
	address varchar(200), #地址
	postcode varchar(100), #邮编
	detail varchar(2000), #详细信息
	createtime timestamp default now()
);



#后台用户
create table user(
	id int not null auto_increment primary key,
	name varchar(20),
	password varchar(20),
	purview int(2) not null # 0,普通用户； 1,管理员
);

insert into user (name, password, purview) values("admin","admin", 1);

#会员（注册信息）
create table member (
	id int primary key not null auto_increment,
	name varchar(100),
	type int(2) default 0, #0,普通会员； 1,VIP会员
	password varchar(100),
	email varchar(200),
	createtime timestamp default now(),
	passflag int(2) default 0  #审核会员是否有效 0,未通过，1,通过，初期不审核，直接存成1；
);


#目录
create table category (
	id int primary key not null auto_increment,
	pid int, #pid为0的是最顶层节点
	name varchar(255), #名称
	isleaf int default 1, #0 非叶子节点 1叶子节点
	grade int #代表级别, 从1开始
);





#职位发布表
create table job (
	id int primary key not null auto_increment,
	position varchar(100), #职位
	field varchar(200), #所需专业
	location varchar(200), #工作地点
	totalnumber varchar(200), #招聘人数
	daytime varchar(200), #招聘日期
	intro varchar(2000), #职位说明
	stateflag int, #是否有效 0,无效， 1,有效 删除职位时，将该字段标记为0即可，不必真正删除；
	createtime timestamp default now()
);



