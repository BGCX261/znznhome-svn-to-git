drop database znzn;

create database znzn;

use znzn;

#目录
create table znzn_category (
	id int primary key not null auto_increment,
	pid int, #pid为0的是最顶层节点
	name varchar(255), #名称
	ename varchar(255), #英文名称
	categorycoding varchar(255), #目录编码 唯一
	descr varchar(255), #描述
	isleaf int default 1, #0 非叶子节点 1叶子节点
	grade int, #代表级别, 从1开始
	other varchar(255) #其它
);



#会员（注册信息）
create table znzn_member (
	id int primary key not null auto_increment,
	name varchar(100),
	type int(2) default 0, #0,普通会员； 1,VIP会员
	password varchar(100),
	purview int(2) not null, # 0,普通用户； 1,管理员
	email varchar(200),
	createtime timestamp default now(),
	passflag int(2) default 0,  #审核会员是否有效 0,未通过，1,通过，初期不审核，直接存成1；
	realname varchar(100), #真实姓名
	sex varchar(10), #性别
	phyle varchar(100), #民族
	blood varchar(10),#血型 A, B, AB, O
	college varchar(100),#学校
	company varchar(100),#公司
	address varchar(100),#住址
	contact varchar(100),#联系方式
	birthday timestamp #生日
);

insert into znzn_member (name, password, purview) values("admin","admin", 1);

#分类  id=1 根，             id=2 CoolJoke冷笑话， id=3 MyFavorite收藏夹， id=4 ChatMessage无聊版块， id=5 Message信息发布检索版块
#     id=6 Url网址列表版块，  id=7 google搜索版块
create table znzn_category (
	id int primary key not null auto_increment,
	pid int, #pid为0的是最顶层节点
	name varchar(255), #名称
	descr varchar(255), #描述
	isleaf int default 1, #0 非叶子节点 1叶子节点
	grade int, #代表级别, 从1开始
	other varchar(20) #备用
);

#冷笑话
create table znzn_cooljoke (
	id int primary key not null auto_increment,
	categoryid int default 1, #所属笑话分类ID，初期无分类，直接存成1；
	mbid int, #发布者ID，如果是后台发布，则ID为0
	mbname varchar(50), #发布者用户名，如果是后台发布，则name为“宅男宅女”
	title varchar(100), #备用
	content varchar(1000),
	ip varchar(20), #发布人的ip地址
	createtime timestamp default now(),
	passflag int(2) default 0,  #信息真核 0,未通过，1,通过，初期不审核，直接存成1；
	recflag int, #是否推荐到列表 0,不推荐 ， 1,推荐加“精” 2,推荐变红色 3,推荐变绿色
	other varchar(20) #备用
);


#收藏夹
create table znzn_myfavorite (
	id int primary key not null auto_increment,
	categoryid int default 1, #所属分类ID
	mbid int, #所属用户ID，如果是默认的收藏夹内容，则ID为0 该字段用于定制
	title varchar(100), #主题
	url varchar(100), #链接地址
	detail varchar(100), #备注
	createtime timestamp default now(),
	other varchar(20) #备用
);


#无聊版块
create table znzn_chatmessage (
	id int primary key not null auto_increment,
	categoryid int default 1, #所属分类ID，初期无分类，直接存成1；
	mbid int, #发布者ID，如果是后台发布，则ID为0,如果是前台用户未登录发布，则ID为-1
	mbname varchar(50), #发布者用户名，如果是后台发布，则name为“宅男宅女”，如果是用户未登录，则发布者为“匿名”
	mbphotono int, #发布者头像编号 后台为0，未登录为-1
	title varchar(100), #备用
	content varchar(1000), #内容
	contact varchar(100), #联系方式
	ip varchar(20), #发布人的ip地址 前台后台都记录IP
	createtime timestamp default now(),
	passflag int(2) default 0,  #信息真核 0,未通过，1,通过，初期不审核，直接存成1；
	other varchar(20) #备用
);


#无聊版块后台添加关键词，显示在前台无聊版块列表中
create table znzn_chatmessage_keywords (
	id int primary key not null auto_increment,
	keywords varchar(255), #关键词 作为搜索条件
	createtime timestamp default now(), #默认按时间排序
	grade int, #代表关键词等级，等级越高，越往前排，先设三级 0, 1, 2
	recflag int, #是否推荐到列表 0,不推荐 ， 1,推荐加“精” 2,推荐变红色 3,推荐变绿色
	other varchar(20) #备用
);

#网址列表
create table znzn_url (
    id int primary key not null auto_increment,
    categoryid int, #所属分类ID
    title varchar(100), # 标题
    urladdress varchar(100), #url地址
    descr varchar(100), #我们对该网站的评价和描述
    typeflag int, #信息类型  1,直接资源 2,网站地址
    recflag int, #是否推荐到列表 0,不推荐 ， 1,推荐加“精” 2,推荐变红色 3,推荐变绿色
    createtime timestamp default now()
);


#信息发布于检索模块--信息列表
create table znzn_message (
	id int primary key not null auto_increment,
	mbid int, #发布者id
	mbname varchar(100), #发布者账号
	categoryid int, #所属分类ID
	province varchar(100), #省份
	city varchar(100), #城市
	district varchar(100), #地区
	title varchar(100), #主题
	contact varchar(100), #联系方式
	keywords varchar(100), #关键字
	content text, #内容
	ip varchar(20), #发布人的ip地址
	createtime timestamp default now(), #发布时间
	passflag int default 0, #是否通过审核 0 未通过 1 通过 初期不审核，默认存成1；
	recflag int, #是否推荐到列表 0,不推荐 ， 1,推荐加“精” 2,推荐变红色 3,推荐变绿色
	foreign key(mbid) references znzn_member(id) on delete cascade on update cascade
);

#信息发布于检索模块--FCKEditor中默认的内容
create table znzn_message_default (
	id int primary key not null auto_increment,
	categoryid int, #所属分类的ID
	name varchar(255), #给默认的内容取个名字，或者默认为分类的名称
	content varchar(255), #信息发布列表中，默认的内容
	other varchar(20) #备用
);

#公告/帮助信息
create table znzn_notice_help (
	id int primary key not null auto_increment,
	typeflag int, #信息分类 1公告 2帮助信息
	title varchar(255), #公告主题
	content varchar(255), #公告内容
	createtime timestamp default now(), #发布时间
	other varchar(20) #备用
);


#满意度调查
create table znzn_feedback (
	id int primary key not null auto_increment,
	content varchar(255), #信息发布列表中，默认的内容
	createtime timestamp default now() #发布时间
);
#新闻  
create table znzn_news (
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

#产品
create table znzn_product (
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

#案例
create table znzn_cases (
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

#职位发布表
create table znzn_job (
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