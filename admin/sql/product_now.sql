/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : product

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-04-04 10:10:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `pswd` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `number` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`date`,`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1234', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('234243', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('354354', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('556567', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('6578687', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('7898798', '2014-04-03 05:33:28', 'receive', null);
INSERT INTO `product` VALUES ('0610', '2014-04-03 05:45:47', 'send', null);
INSERT INTO `product` VALUES ('678687', '2014-04-03 05:52:34', 'receive', null);
INSERT INTO `product` VALUES ('654654', '2014-04-03 05:52:37', 'receive', null);
INSERT INTO `product` VALUES ('888888', '2014-04-03 05:52:44', 'send', null);
INSERT INTO `product` VALUES ('678678', '2014-04-03 06:10:02', 'send', null);
INSERT INTO `product` VALUES ('2345', '2014-04-03 18:13:24', 'send', null);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `realname` varchar(25) DEFAULT '',
  `status` varchar(10) DEFAULT '暂停',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '2014001', '2014001', '张三', 'OK');
INSERT INTO `userinfo` VALUES ('2', '2014002', '2014002', '李四', 'PAUSE');
INSERT INTO `userinfo` VALUES ('3', '2014003', '2014003', '王五', 'OK');
INSERT INTO `userinfo` VALUES ('4', '2014004', '2014004', '麻子', 'OK');
INSERT INTO `userinfo` VALUES ('5', '2014005', '2014005', '赵六', 'OK');
INSERT INTO `userinfo` VALUES ('6', '2014006', '2014006', '孙七', 'OK');
INSERT INTO `userinfo` VALUES ('7', '2014007', '2014007', '钱八', 'OK');
INSERT INTO `userinfo` VALUES ('8', '2014008', '2014008', '吴九', 'OK');
INSERT INTO `userinfo` VALUES ('9', '2014009', '2014009', '郑十', 'OK');
INSERT INTO `userinfo` VALUES ('10', '2014010', '2014010', '小明', 'PAUSE');
INSERT INTO `userinfo` VALUES ('11', '2014011', '2014011', '小红', 'OK');
INSERT INTO `userinfo` VALUES ('12', '2014012', '2014012', '某甲', 'OK');
