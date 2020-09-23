/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.11-log : Database - learninglibrary
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`learninglibrary` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `learninglibrary`;

/*Table structure for table `classify` */

DROP TABLE IF EXISTS `classify`;

CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `classify_name` varchar(255) NOT NULL COMMENT '分类名',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='分类表';

/*Data for the table `classify` */

insert  into `classify`(`id`,`classify_name`,`operate_time`) values (1,'前端','2020-09-15 10:02:19');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `parent_id` int(11) DEFAULT NULL COMMENT '所属父级id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态值（1：删除/0：非删除）',
  `share_id` int(11) NOT NULL COMMENT '分享id',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

/*Data for the table `comment` */

/*Table structure for table `label` */

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `label_name` varchar(255) NOT NULL COMMENT '标签名',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_labelname_key` (`user_id`,`label_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='标签表';

/*Data for the table `label` */

insert  into `label`(`id`,`user_id`,`label_name`,`operate_time`) values (1,1,'css','2020-09-15 10:02:06'),(2,1,'js','2020-09-15 10:51:22');

/*Table structure for table `share` */

DROP TABLE IF EXISTS `share`;

CREATE TABLE `share` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `type` tinyint(4) NOT NULL COMMENT '分享类型（1：文章/2：文档）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值（0：删除/1：非删除）',
  `property` tinyint(4) NOT NULL COMMENT '分享属性（0:原创/1:转载）',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `synopsis` varchar(255) NOT NULL COMMENT '简介',
  `content` text NOT NULL COMMENT '内容',
  `label_id` varchar(11) DEFAULT NULL COMMENT '标签id',
  `classify_id` int(11) NOT NULL COMMENT '分类id',
  `visits_num` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='分享表';

/*Data for the table `share` */

insert  into `share`(`id`,`user_id`,`type`,`status`,`property`,`title`,`synopsis`,`content`,`label_id`,`classify_id`,`visits_num`,`operate_time`) values (1,1,0,1,0,'string','string','string','1,2',1,0,'2020-08-20 10:30:41');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `nikename` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`nickname`,`operate_time`,`status`,`salt`) values (1,'admin','$2a$10$wxLKAc97Clzq7FsTeAU2FOApC4gc6MANXJB3U19mJWXdAicDMBhfG','admin','2020-08-24 13:28:20','1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
