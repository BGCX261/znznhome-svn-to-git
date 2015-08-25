DROP TABLE IF EXISTS `znzn_meta_config`;
CREATE TABLE `znzn_meta_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL,
  `conffield` varchar(255) DEFAULT NULL,
  `confvalue` varchar(255) DEFAULT NULL,
  `confdescr` varchar(255) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;