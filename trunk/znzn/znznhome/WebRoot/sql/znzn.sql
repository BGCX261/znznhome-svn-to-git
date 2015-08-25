/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : znzn

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2012-11-26 00:12:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `znzn_cases`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_cases`;
CREATE TABLE `znzn_cases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `categoryname` varchar(100) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `casename` varchar(200) DEFAULT NULL,
  `scale` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `casetime` varchar(200) DEFAULT NULL,
  `picurl` varchar(200) DEFAULT NULL,
  `content` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seotitle` varchar(200) DEFAULT NULL,
  `seokeywords` varchar(200) DEFAULT NULL,
  `seodescription` varchar(500) DEFAULT NULL,
  `topscore` int(11) DEFAULT '0',
  `recflag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_cases
-- ----------------------------
INSERT INTO `znzn_cases` VALUES ('1', '15', '化工行业案例', '案例案例01', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:06', '2012-06-07 23:33:06', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('2', '15', '化工行业案例', '案例案例02', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:16', '2012-06-07 23:33:16', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('3', '15', '化工行业案例', '案例案例03', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:24', '2012-06-07 23:33:24', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('4', '15', '化工行业案例', '案例案例04', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:33', '2012-06-07 23:33:33', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('5', '16', '生物制药行业', '案例案例05', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:45', '2012-06-07 23:33:45', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('6', '16', '生物制药行业', '案例案例06', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:33:53', '2012-06-07 23:33:53', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('7', '16', '生物制药行业', '案例案例07', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:34:01', '2012-06-07 23:34:01', '案例', '案例', '案例', '0', '1');
INSERT INTO `znzn_cases` VALUES ('8', '16', '生物制药行业', '案例案例08', '案例', '大大大', '北京', '2010-10-2', 'mm.jpg', '<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>\r\n<p>案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例案例</p>', '2012-06-07 23:34:11', '2012-06-07 23:34:11', '案例', '案例', '案例', '0', '1');

-- ----------------------------
-- Table structure for `znzn_category`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_category`;
CREATE TABLE `znzn_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `categorycoding` varchar(255) DEFAULT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `isleaf` int(11) DEFAULT '1',
  `grade` int(11) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_category
-- ----------------------------
INSERT INTO `znzn_category` VALUES ('37', '0', '文章', 'article', '010000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('38', '0', '娱乐', 'amusement', '020000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('39', '0', '兴趣', 'Interest', '030000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('40', '0', '学习', 'learning', '040000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('41', '0', '生活', 'life', '050000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('42', '0', '美食', 'food', '060000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('43', '0', '购物', 'shopping', '070000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('44', '0', '旅游', 'travel', '080000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('45', '0', '知识', 'knowledge', '090000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('46', '0', '办事', 'affairs', '100000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('47', '0', '下载', 'download', '110000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('48', '0', '酷站', 'sites', '120000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('49', '0', '其它', 'others', '130000000000', '', '0', '1', null);
INSERT INTO `znzn_category` VALUES ('50', '37', '新闻', 'news', '010100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('51', '37', '热帖', 'posts', '010200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('52', '37', '博文', 'blog', '010300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('53', '37', '微博', 'microblog', '010400000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('54', '38', '影视', 'video', '020100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('55', '38', '音乐', 'music', '020200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('56', '38', '笑话', 'joke', '020300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('57', '38', '游戏', 'game', '020400000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('58', '39', '网球', 'tennis', '030100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('59', '39', '羽毛球', 'badminton', '030200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('60', '39', '乒乓', 'pingpang', '030300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('61', '39', '桌球', 'snooker', '030400000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('62', '39', '摄影', 'photography', '030500000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('63', '39', '跳舞', 'dance', '030600000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('64', '39', '滚轴', 'rollerblading', '030700000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('65', '39', '滑雪', 'skiing', '030800000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('66', '39', '游泳', 'swimming', '030900000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('67', '89', 'JAVA', 'java', '040201000000', '', '0', '3', null);
INSERT INTO `znzn_category` VALUES ('68', '41', '跳骚', 'flea', '050100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('69', '41', '悬赏', 'reward', '050200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('70', '41', '人肉', 'humansearch', '050300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('71', '42', '小吃', 'snack', '060100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('72', '42', '餐厅', 'restaurant', '060200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('73', '42', '菜谱', 'cooking', '060300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('74', '43', '晒单', 'shoppinglist', '070100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('75', '44', '自助游', 'walks', '080100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('76', '44', '风景区', 'landscape', '080200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('77', '45', '财经', 'finance', '090100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('78', '45', '军事', 'military', '090200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('79', '46', '就医', 'seeadoctor', '100100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('80', '46', '社保', 'socialsecurity', '100200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('81', '46', '投诉', 'complaints', '100300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('82', '47', '软件', 'soft', '110100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('83', '47', '源码', 'src', '110200000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('84', '47', '视频', 'videosrc', '110300000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('85', '47', '小说', 'novel', '110400000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('86', '48', '网络赚钱', 'makemoney', '120100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('87', '49', '站内公告', 'note', '130100000000', '', '1', '2', null);
INSERT INTO `znzn_category` VALUES ('88', '0', '收藏', 'collect', '140000000000', '', '1', '1', null);
INSERT INTO `znzn_category` VALUES ('89', '40', '编程', 'coding', '040200000000', '', '0', '2', null);
INSERT INTO `znzn_category` VALUES ('90', '89', 'JavaScript', 'JavaScript', '040202000000', '', '0', '3', null);
INSERT INTO `znzn_category` VALUES ('91', '89', 'Linux', 'Linux', '040203000000', '', '1', '3', null);
INSERT INTO `znzn_category` VALUES ('92', '89', 'Lucene', 'Lucene', '040204000000', '', '1', '3', null);
INSERT INTO `znzn_category` VALUES ('93', '89', 'Database', 'Database', '040205000000', '', '1', '3', null);
INSERT INTO `znzn_category` VALUES ('94', '89', 'CSS+DIV', 'CSSDIV', '040206000000', '', '1', '3', null);
INSERT INTO `znzn_category` VALUES ('95', '89', 'UML ', 'UML', '040208000000', '', '1', '3', null);
INSERT INTO `znzn_category` VALUES ('96', '67', '一般Java', 'commonjava', '040201170000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('97', '67', '性能', 'efficiency', '040201020000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('98', '67', '多线程', 'thread', '040201030000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('99', '67', '事务', 'transaction', '040201040000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('100', '67', '设计模式', 'designpattern', '040201050000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('101', '67', 'Jenkins', 'Jenkins', '040201060000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('102', '67', 'TestNG', 'TestNG', '040201070000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('103', '67', 'HttpUnit', 'HttpUnit', '040201080000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('104', '67', 'Ant ', 'Ant', '040201090000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('105', '67', 'Maven', 'Maven', '040201100000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('106', '67', 'Spring', 'Spring', '040201110000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('107', '67', 'Struts2', 'Struts2', '040201120000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('108', '67', 'Hibernate', 'Hibernate', '040201130000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('109', '67', 'Tomcat', 'Tomcat', '040201150000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('110', '67', 'Eclipse', 'Eclipse', '040201160000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('111', '67', '算法', 'algorithm', '040201010000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('112', '90', '一般JavaScript', 'commonjavascript', '040202010000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('113', '90', 'JQuery', 'jquery', '040202020000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('114', '90', 'YUI ', 'YUI', '040202030000', '', '1', '4', null);
INSERT INTO `znzn_category` VALUES ('115', '90', 'json', 'json', '040202040000', '', '1', '4', null);

-- ----------------------------
-- Table structure for `znzn_chatmessage`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_chatmessage`;
CREATE TABLE `znzn_chatmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT '1',
  `mbid` int(11) DEFAULT NULL,
  `mbname` varchar(50) DEFAULT NULL,
  `mbphotono` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `passflag` int(2) DEFAULT '0',
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_chatmessage
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_chatmessage_keywords`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_chatmessage_keywords`;
CREATE TABLE `znzn_chatmessage_keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keywords` varchar(255) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grade` int(11) DEFAULT NULL,
  `recflag` int(11) DEFAULT NULL,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_chatmessage_keywords
-- ----------------------------
INSERT INTO `znzn_chatmessage_keywords` VALUES ('1', 'asdf', '2012-03-15 22:07:28', '0', '0', 'asdf');

-- ----------------------------
-- Table structure for `znzn_cooljoke`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_cooljoke`;
CREATE TABLE `znzn_cooljoke` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT '1',
  `mbid` int(11) DEFAULT NULL,
  `mbname` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `passflag` int(2) DEFAULT '0',
  `recflag` int(11) DEFAULT NULL,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_cooljoke
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_feedback`;
CREATE TABLE `znzn_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_feedback
-- ----------------------------
INSERT INTO `znzn_feedback` VALUES ('2', null, null, null, null, null, null, '2012-05-30 00:40:46', '1');
INSERT INTO `znzn_feedback` VALUES ('3', 'fasf', '购买咨询', 'asfasdf', 'adf', 'fas', 'fas', '2012-05-30 00:41:26', '1');
INSERT INTO `znzn_feedback` VALUES ('4', null, null, null, null, null, null, '2012-05-30 00:47:34', '1');
INSERT INTO `znzn_feedback` VALUES ('5', null, null, null, null, null, null, '2012-05-30 00:48:13', '1');

-- ----------------------------
-- Table structure for `znzn_job`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_job`;
CREATE TABLE `znzn_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(100) DEFAULT NULL,
  `field` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `totalnumber` varchar(200) DEFAULT NULL,
  `daytime` varchar(200) DEFAULT NULL,
  `intro` varchar(2000) DEFAULT NULL,
  `stateflag` int(11) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_job
-- ----------------------------
INSERT INTO `znzn_job` VALUES ('1', 'ffffffffffffffffffffffffftttttttttttttttt', 'fffffffffffffffffftttttttttttttttttttttttt', 'fffffffffffffffffffffffffffffffftttttttttttttt', '1人', 'ffffffffffffffffffffffttttttttttttttttttttttttttt', '<p><img height=\"600\" alt=\"\" width=\"800\" src=\"/znznhome_company/userfiles/image/Winter.jpg\" /></p>\r\n<p>fffffffffffffffffffffffffffffffffff</p>', '1', '2012-05-25 00:25:53');

-- ----------------------------
-- Table structure for `znzn_member`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_member`;
CREATE TABLE `znzn_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` int(2) DEFAULT '0',
  `password` varchar(100) DEFAULT NULL,
  `purview` int(2) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `passflag` int(2) DEFAULT '0',
  `realname` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `phyle` varchar(100) DEFAULT NULL,
  `blood` varchar(10) DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `birthday` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_member
-- ----------------------------
INSERT INTO `znzn_member` VALUES ('1', 'admin', '0', 'admin', '1', null, '2012-03-20 01:00:11', '0', null, null, null, null, null, null, null, null, '0000-00-00 00:00:00');
INSERT INTO `znzn_member` VALUES ('3', 'sdaf', '0', 'asdf', '0', null, '2012-03-21 21:34:41', '0', null, null, null, null, null, null, null, null, '2012-03-21 21:34:41');
INSERT INTO `znzn_member` VALUES ('5', 'lxd', '0', 'lxd@12', '0', null, '2012-06-02 01:06:53', '0', null, null, null, null, null, null, null, null, '2012-06-02 01:06:53');
INSERT INTO `znzn_member` VALUES ('6', 'sssssss', '0', 'ssssssss', '0', null, '2012-06-02 01:07:07', '0', null, null, null, null, null, null, null, null, '2012-06-02 01:07:07');
INSERT INTO `znzn_member` VALUES ('7', 'dsafdas', '0', '222222222', '1', null, '2012-06-03 21:44:38', '0', null, null, null, null, null, null, null, null, '2012-06-03 21:44:56');

-- ----------------------------
-- Table structure for `znzn_message_default`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_message_default`;
CREATE TABLE `znzn_message_default` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_message_default
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_myfavorite`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_myfavorite`;
CREATE TABLE `znzn_myfavorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT '1',
  `mbid` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_myfavorite
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_news`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_news`;
CREATE TABLE `znzn_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `categoryname` varchar(100) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `picurl` varchar(200) DEFAULT NULL,
  `content` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `author` varchar(100) DEFAULT NULL,
  `origin` varchar(200) DEFAULT NULL,
  `seotitle` varchar(200) DEFAULT NULL,
  `seokeywords` varchar(200) DEFAULT NULL,
  `seodescription` varchar(500) DEFAULT NULL,
  `topscore` int(11) DEFAULT '0',
  `recflag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_news
-- ----------------------------
INSERT INTO `znzn_news` VALUES ('1', '18', '公司新闻', '新闻新闻01', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:35:18', '2012-06-07 23:35:18', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('2', '18', '公司新闻', '新闻新闻02', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:35:30', '2012-06-07 23:35:30', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('3', '18', '公司新闻', '新闻新闻03', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:35:44', '2012-06-07 23:35:44', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('4', '18', '公司新闻', '新闻新闻04', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:35:54', '2012-06-07 23:35:54', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('5', '19', '行业新闻', '新闻新闻05', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:36:08', '2012-06-07 23:36:08', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('6', '19', '行业新闻', '新闻新闻06', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:36:20', '2012-06-07 23:36:20', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('7', '19', '行业新闻', '新闻新闻07', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:36:32', '2012-06-07 23:36:32', '小二', '原创', '新闻', '新闻', '新闻', '0', '1');
INSERT INTO `znzn_news` VALUES ('8', '19', '行业新闻', '新闻新闻08', 'mm.jpg', '<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>\r\n<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>', '2012-06-07 23:36:43', '2012-06-07 23:36:43', '小二', '原创', '新闻', '新闻', '新闻', '1', '1');
INSERT INTO `znzn_news` VALUES ('9', '20', '关于我们', '关于我们', 'mm.jpg', '<p>&nbsp;在后台编辑关于我们的信息，然后提交，前台会自动更新！</p>', '2012-06-09 15:14:01', '2012-06-09 15:14:01', '白洁', '本站', '', '', '', '0', '1');
INSERT INTO `znzn_news` VALUES ('10', '21', '人才招聘', '人才招聘', 'mm.jpg', '<p>&nbsp; 在后台编辑人才招聘的信息，然后提交，前台会自动更新！支持表格和图片等。</p>', '2012-06-09 15:14:01', '2012-06-09 15:14:01', '白洁', '本站', '', '', '', '0', '1');
INSERT INTO `znzn_news` VALUES ('11', '22', '联系我们', '联系我们', 'mm.jpg', '<p>&nbsp;&nbsp;&nbsp; 后台编辑联系我们信息，会自动更新到前台，支持图片和表格等</p>', '2012-06-09 15:19:04', '2012-06-09 15:19:04', '白洁', '本站', '', '', '', '0', '1');

-- ----------------------------
-- Table structure for `znzn_notice_help`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_notice_help`;
CREATE TABLE `znzn_notice_help` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeflag` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_notice_help
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_noticehelp`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_noticehelp`;
CREATE TABLE `znzn_noticehelp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `typeflag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_noticehelp
-- ----------------------------

-- ----------------------------
-- Table structure for `znzn_product`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_product`;
CREATE TABLE `znzn_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `categoryname` varchar(100) DEFAULT NULL,
  `title` varchar(200) NOT NULL,
  `productname` varchar(200) DEFAULT NULL,
  `model` varchar(200) DEFAULT NULL,
  `productnumber` varchar(200) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `picurl` varchar(200) DEFAULT NULL,
  `content` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seotitle` varchar(200) DEFAULT NULL,
  `seokeywords` varchar(200) DEFAULT NULL,
  `seodescription` varchar(500) DEFAULT NULL,
  `topscore` int(11) DEFAULT '0',
  `recflag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_product
-- ----------------------------
INSERT INTO `znzn_product` VALUES ('1', '11', '化工机械', '测试产品01', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:29:29', '2012-06-07 23:29:29', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('2', '11', '化工机械', '测试产品02', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:29:37', '2012-06-07 23:29:37', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('3', '11', '化工机械', '测试产品03', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:29:58', '2012-06-07 23:29:58', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('4', '11', '化工机械', '测试产品04', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:30:08', '2012-06-07 23:30:08', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('5', '12', '医疗机械', '测试产品05', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:30:23', '2012-06-07 23:30:23', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('6', '12', '医疗机械', '测试产品06', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:30:33', '2012-06-07 23:30:33', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('7', '12', '医疗机械', '测试产品7', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:30:47', '2012-06-07 23:30:47', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('8', '13', '科研院所', '测试产品8', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:31:00', '2012-06-07 23:31:00', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('9', '13', '科研院所', '测试产品9', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:31:08', '2012-06-07 23:31:08', '产品', '产品', '产品', '0', '1');
INSERT INTO `znzn_product` VALUES ('10', '13', '科研院所', '测试产品10', '产品产品', '型号', '货号', '品牌', '个', 'mm.jpg', '<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品</p>\r\n<p>产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品产品</p>', '2012-06-07 23:31:20', '2012-06-07 23:31:20', '产品', '产品', '产品', '0', '1');

-- ----------------------------
-- Table structure for `znzn_url`
-- ----------------------------
DROP TABLE IF EXISTS `znzn_url`;
CREATE TABLE `znzn_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `categoryname` varchar(100) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  `membername` varchar(100) DEFAULT NULL,
  `origin` varchar(100) DEFAULT NULL,
  `ipaddress` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `urladdress` varchar(300) DEFAULT NULL,
  `descr` varchar(500) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `recflag` int(11) DEFAULT NULL,
  `topflag` int(11) DEFAULT NULL,
  `live` int(11) DEFAULT NULL,
  `clickrate` bigint(20) DEFAULT NULL,
  `up` bigint(20) DEFAULT NULL,
  `down` bigint(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tags` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of znzn_url
-- ----------------------------
INSERT INTO `znzn_url` VALUES ('1', '23', '新闻', '-1', '匿名', 'aaaa', '0:0:0:0:0:0:0:1', 'aaaa', 'aaaa', 'aaaa', '0', '0', '0', '1', '0', '0', '0', '2012-09-26 22:58:38', null);
INSERT INTO `znzn_url` VALUES ('2', '23', '新闻', '-1', '匿名', '6666', '0:0:0:0:0:0:0:1', '6666', '6666', '6666', '0', '0', '0', '1', '0', '0', '0', '2012-09-27 22:46:59', null);
INSERT INTO `znzn_url` VALUES ('3', '23', '新闻', '-1', '匿名', '22222', '0:0:0:0:0:0:0:1', 'hello', '22222', '222', '0', '0', '0', '1', '0', '0', '0', '2012-10-04 21:37:44', null);
INSERT INTO `znzn_url` VALUES ('4', '23', '新闻', '-1', '匿名', '888888888888', '0:0:0:0:0:0:0:1', 'hello', '8888888888', '888888888888', '0', '0', '0', '1', '0', '0', '0', '2012-10-04 21:39:16', null);
INSERT INTO `znzn_url` VALUES ('5', '23', '新闻', '-1', '匿名', '444444444444', '0:0:0:0:0:0:0:1', 'hello', '44444', '444444', '0', '0', '0', '1', '0', '0', '0', '2012-10-04 21:44:34', null);
INSERT INTO `znzn_url` VALUES ('6', '23', '新闻', '-1', '匿名', '55', '0:0:0:0:0:0:0:1', '中文的', '5555', '55', '0', '0', '0', '1', '0', '0', '0', '2012-10-04 21:49:19', null);
INSERT INTO `znzn_url` VALUES ('7', '23', '新闻', '-1', '匿名', '77777777777', '0:0:0:0:0:0:0:1', '中文的', '7777777', '777', '0', '0', '0', '1', '0', '0', '0', '2012-10-04 21:50:52', null);
INSERT INTO `znzn_url` VALUES ('8', '23', '新闻', '-1', '匿名', '你妈的来源', '0:0:0:0:0:0:0:1', '你妈的标题', '你妈的', '你妈的简评', '0', '0', '0', '1', '0', '0', '0', '2012-10-08 23:26:54', null);
INSERT INTO `znzn_url` VALUES ('9', '23', '新闻', '-1', '匿名', '你妈的来源', '0:0:0:0:0:0:0:1', '你妈的标题', '你妈的', '你妈的简评', '0', '0', '0', '1', '0', '0', '0', '2012-10-08 23:26:54', null);
INSERT INTO `znzn_url` VALUES ('10', '23', '新闻', '-1', '匿名', 'dsafas', '0:0:0:0:0:0:0:1', 'dsafsafdasfsa', 'fsafsafcsaf', 'fsafsafsda', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 00:34:24', null);
INSERT INTO `znzn_url` VALUES ('11', '23', '新闻', '-1', '匿名', 'Ada', '0:0:0:0:0:0:0:1', 'saDAdDS', 'SAdaDA', 'DAda', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 01:42:11', null);
INSERT INTO `znzn_url` VALUES ('12', '23', '新闻', '-1', '匿名', 'aDASd', '0:0:0:0:0:0:0:1', 'SadaDA', 'AdaDAd', 'asDAd', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 01:45:00', null);
INSERT INTO `znzn_url` VALUES ('13', '23', '新闻', '-1', '匿名', 'CCCC', '0:0:0:0:0:0:0:1', 'SadaDA', 'SAdaDA', '', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 01:45:22', null);
INSERT INTO `znzn_url` VALUES ('14', '23', '新闻', '-1', '匿名', 'Ada', '0:0:0:0:0:0:0:1', '中文的', 'SAdaDA', 'dsafa', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 01:45:34', null);
INSERT INTO `znzn_url` VALUES ('15', '23', '新闻', '-1', '匿名', 'Ada', '0:0:0:0:0:0:0:1', 'hello', 'BBBB', 'asdfsaf', '0', '0', '0', '1', '0', '0', '0', '2012-10-16 01:45:46', null);
INSERT INTO `znzn_url` VALUES ('16', '23', '新闻', '-1', '匿名', 'safsaf', '0:0:0:0:0:0:0:1', 'sdafsafsa', 'fafsafsaf', 'safsaf', '0', '0', '0', '1', '0', '0', '0', '2012-10-17 00:00:23', null);
INSERT INTO `znzn_url` VALUES ('17', '23', '新闻', '-1', '匿名', 'safsaf', '0:0:0:0:0:0:0:1', 'sdaffAS', 'SDAfsaf', 'safasf', '0', '0', '0', '1', '0', '0', '0', '2012-10-17 00:01:19', null);
INSERT INTO `znzn_url` VALUES ('18', '60', '乒乓', '1', 'admin', '阿斯蒂芬啊', '0:0:0:0:0:0:0:1', '的萨芬撒', '四大发生的 ', '阿斯蒂芬', '0', '0', '0', '0', '0', '0', '0', '2012-11-24 14:41:07', '阿斯蒂芬');
INSERT INTO `znzn_url` VALUES ('19', '62', '摄影', '1', 'admin', 'fasfsaf', '0:0:0:0:0:0:0:1', 'sdafsafsafasf', 'safsafsa', 'asfsafasfdsafdsa', '0', '0', '0', '1', '0', '0', '0', '2012-11-24 14:48:50', null);
INSERT INTO `znzn_url` VALUES ('20', '62', '摄影', '1', 'admin', '[河蟹][河蟹][河蟹]', '0:0:0:0:0:0:0:1', '[河蟹][河蟹][河蟹]', '办怔办怔办怔', '[河蟹][河蟹][河蟹][河蟹][河蟹][河蟹]', '0', '0', '0', '1', '0', '0', '0', '2012-11-24 14:50:30', null);
