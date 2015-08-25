/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : znzn

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2012-11-13 01:10:40
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

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
INSERT INTO `znzn_category` VALUES ('67', '40', 'JAVA', 'java', '040100000000', '', '1', '2', null);
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
