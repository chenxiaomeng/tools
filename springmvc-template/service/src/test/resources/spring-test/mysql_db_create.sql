/*
Navicat MySQL Data Transfer

Source Server         : awcbetawind-downtimemq01.cw1zsttpjvrr.rds.cn-north-1.amazonaws.com.cn
Source Server Version : 50627
Source Host           : awcbetawind-downtimemq01.cw1zsttpjvrr.rds.cn-north-1.amazonaws.com.cn:3306
Source Database       : mars

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2017-09-29 14:12:46
*/

DROP TABLE IF EXISTS `data_template`;
CREATE TABLE `data_template` (
  `id` varchar(100) NOT NULL,
  `name_zh` varchar(100) DEFAULT NULL,
  `name_en` varchar(100) DEFAULT NULL,
  `owner` varchar(100) DEFAULT NULL,
  `owner_name` varchar(100) DEFAULT NULL,
  `is_deploy` int(11) NOT NULL,
  `tag` varchar(100) DEFAULT NULL,
  `tag_name` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `detail` text,
  `is_valid` int(11) NOT NULL,
  `add_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;