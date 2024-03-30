/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.34 : Database - peop_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`peop_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `peop_db`;

/*Table structure for table `t_auth_dept` */

DROP TABLE IF EXISTS `t_auth_dept`;

CREATE TABLE `t_auth_dept` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `dep_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_auth_dept` */

insert  into `t_auth_dept`(`id`,`role_id`,`dep_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,1,19),(20,1,20),(21,1,21),(22,1,22),(23,1,23),(24,1,24),(25,1,25),(32,2,1),(33,2,2),(34,2,3),(35,2,4);

/*Table structure for table `t_auth_menu` */

DROP TABLE IF EXISTS `t_auth_menu`;

CREATE TABLE `t_auth_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(999) DEFAULT NULL,
  `parent` varchar(999) DEFAULT NULL,
  `disable` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_auth_menu` */

insert  into `t_auth_menu`(`id`,`menu_name`,`parent`,`disable`) values (1,'基础人力资源','0',0),(2,'人员管理','1',0),(3,'人员变动日志','1',0),(4,'组织管理','0',0),(5,'组织变动日志','4',0),(6,'考勤管理','0',0),(7,'刷卡数据','6',0),(8,'加班数据','6',0),(9,'请假数据','6',0),(10,'日结果','6',0),(11,'月结果','6',0),(12,'薪资管理','0',0),(13,'薪资设置','12',0),(14,'薪资基础','12',0),(15,'薪资计算','12',0);

/*Table structure for table `t_auth_role` */

DROP TABLE IF EXISTS `t_auth_role`;

CREATE TABLE `t_auth_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(999) DEFAULT NULL,
  `remark` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_auth_role` */

insert  into `t_auth_role`(`id`,`role_name`,`remark`) values (1,'超级管理员','超级管理员');

/*Table structure for table `t_auth_userrole` */

DROP TABLE IF EXISTS `t_auth_userrole`;

CREATE TABLE `t_auth_userrole` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_auth_userrole` */

insert  into `t_auth_userrole`(`id`,`user_id`,`role_id`) values (1,3,1);

/*Table structure for table `t_hrm_dept` */

DROP TABLE IF EXISTS `t_hrm_dept`;

CREATE TABLE `t_hrm_dept` (
  `id` int NOT NULL AUTO_INCREMENT,
  `depname` varchar(255) DEFAULT NULL,
  `depcode` varchar(255) DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `visable` tinyint(1) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `version` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_hrm_dept` */

insert  into `t_hrm_dept`(`id`,`depname`,`depcode`,`parent`,`type`,`visable`,`deleted`,`version`) values (1,'总部','00',NULL,'',1,0,1),(2,'SSC','00-01','1','group',1,0,1),(3,'人事部','01-01-01','2','division',1,0,1),(4,'OA组','00-01-01-01','3','dep',1,0,1),(5,'HRBP','00-01-01-02','3','dep',1,0,1),(6,'签证组','00-01-01-03','3','dep',1,0,1),(7,'薪酬组','00-01-01-04','3','dep',1,0,1),(8,'行政部','00-01-02','2','division',1,0,1),(9,'固定资产','00-01-02-01','8','dep',1,0,1),(10,'办公室','00-01-02-02','8','dep',1,0,1),(11,'宿舍','00-01-02-03','8','dep',1,0,1),(12,'财务部','00-01-03','2','division',1,0,1),(13,'项目中心','00-01-04','2','division',1,0,1),(14,'HQ','00-02','1','Group',1,0,1),(15,'HQPMHR1','00-02-01','14','division',1,0,1),(16,'HQPMHR2','00-02-02','14','division',1,0,1),(17,'HQPMHR3','00-02-03','14','division',1,0,1),(18,'HQPMHR4','00-02-04','14','division',1,0,1),(19,'HQM-DF','00-02-05','14','division',1,0,1),(20,'HQGS','00-02-06','14','division',1,0,1),(21,'HQM-RE','00-02-07','14','division',1,0,1),(22,'GE','00-03','1','Group',1,0,1),(23,'XC','00-04','1','Group',1,0,1),(24,'XRD','00-04','1','Group',1,0,1),(25,'资管结算','00-05','1','Group',1,0,1);

/*Table structure for table `t_hrm_user` */

DROP TABLE IF EXISTS `t_hrm_user`;

CREATE TABLE `t_hrm_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `workcode` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `depid` int DEFAULT NULL,
  `hiredate` varchar(255) DEFAULT NULL,
  `deleted` int DEFAULT '0',
  `version` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142647298 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_hrm_user` */

insert  into `t_hrm_user`(`id`,`username`,`password`,`type`,`gender`,`lastname`,`level`,`workcode`,`position`,`depid`,`hiredate`,`deleted`,`version`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3','user','Male','admin','M7','admin','HR Manager',0,'2023-11-20',0,1),(2,'Pie','21232f297a57a5a743894a0e4a801fc3','user','Male','Pie','P3','TW-0001-190909','OA管理师',3,'2023-11-20',0,1),(3,'Rogers','21232f297a57a5a743894a0e4a801fc3','user','Male','Rogers','P6','CN-0001-170210','OA开发高级工程师',3,'2023-11-20',0,1),(4,'Beck','21232f297a57a5a743894a0e4a801fc3','user','Male','Beck','P5','TW-0001-190210','OA开发高级工程师',3,'2023-11-20',0,1),(5,'Judy','21232f297a57a5a743894a0e4a801fc3','user','Female','Judy','M3','TW-0001-170521','OA经理',3,'2023-11-20',0,1),(6,'Levi','21232f297a57a5a743894a0e4a801fc3','user','Female','Levi','P3','TW-0002-230521','OA开发',3,'2023-11-20',0,1),(7,'Fegie','21232f297a57a5a743894a0e4a801fc3','user','Male','Fegie','P3','TW-0002-210911','OA开发',3,'2023-11-20',0,1),(8,'Rechal','21232f297a57a5a743894a0e4a801fc3','user','Female','Rechal','M1','TW-0002-190521','OA管理师',3,'2023-11-20',0,1),(9,'Ben','21232f297a57a5a743894a0e4a801fc3','user','Male','Ben','p3','TW-0001-220304','OA开发',3,'2023-11-20',0,1),(10,'Lisa','21232f297a57a5a743894a0e4a801fc3','user','Female','Lisa','M3','TH-0001-231227','Dancer',3,'2023-11-20',0,1),(142647297,'Rose','21232f297a57a5a743894a0e4a801fc3','user','Female','Rose','M3','KR-0001-240130','Dancer',3,'2024-01-30',1,1);

/*Table structure for table `t_sys_column` */

DROP TABLE IF EXISTS `t_sys_column`;

CREATE TABLE `t_sys_column` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tablename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `columnname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dataIndex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `visable` tinyint(1) DEFAULT NULL,
  `sortkey` int DEFAULT NULL,
  `showInMain` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_sys_column` */

insert  into `t_sys_column`(`id`,`tablename`,`columnname`,`dataIndex`,`key`,`title`,`visable`,`sortkey`,`showInMain`) values (1,'users','lastname','lastname','lastname','员工名称',1,4,1),(2,'users','workcode','workcode','workcode','工号',1,5,1),(3,'users','hiredate','hiredate','hiredate','入职日期',1,6,1),(4,'users','position','position','position','职务',1,8,1),(5,'users','level','level','level','职级',1,7,1),(6,'users','type','type','type','用户类别',0,99,0),(7,'users','gender','gender','gender','性别',1,9,1),(8,'users','username','username','username','账号',0,99,0),(9,'users','password','password','password','密码',0,99,0),(10,'users','status','status','status','员工状态',1,-1,1),(11,'users','Group','Group','Group','事业群',1,0,1),(12,'users','division','division','division','事业处',1,1,1),(13,'users','dep','dep','dep','部门',1,3,1),(14,'users','sal_group','sal_group','sal_group','所需薪资组',1,10,1),(15,'users','att_group','att_group','att_group','所需考勤组',1,16,0),(16,'users','planConfData','planConfData','planConfData','计划转正日期',1,11,0),(17,'users','actConfData','actConfData','actConfData','实际转正日期',1,12,0),(18,'users','housAllowance','housAllowance','housAllowance','是否享有房补',1,14,0),(19,'users','mealAllowance','mealAllowance','mealAllowance','是否享有餐补',1,15,0),(20,'users','isConf','isConf','isConf','是否转正',1,13,0),(21,'users','national','national','national','国籍',1,17,0),(22,'users','technPosition','techPosition','technPosition','是否技术岗',1,18,1),(23,'users','isCN','isCN','isCN','是否华人',1,19,0),(24,'users','costCenter','costCenter','costCenter','费用分摊部门',1,20,0),(25,'users','remark','remark','remark','备注',1,21,0);

/*Table structure for table `t_sys_filed` */

DROP TABLE IF EXISTS `t_sys_filed`;

CREATE TABLE `t_sys_filed` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `actConfData` varchar(255) DEFAULT NULL,
  `costcenter` varchar(255) DEFAULT NULL,
  `houseAllance` tinyint(1) DEFAULT NULL,
  `isCN` tinyint(1) DEFAULT NULL,
  `isConf` tinyint(1) DEFAULT NULL,
  `isTech` tinyint(1) DEFAULT NULL,
  `mealAllance` tinyint(1) DEFAULT NULL,
  `national` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `salGroup` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_id` (`uid`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`uid`) REFERENCES `t_hrm_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_sys_filed` */

insert  into `t_sys_filed`(`id`,`uid`,`actConfData`,`costcenter`,`houseAllance`,`isCN`,`isConf`,`isTech`,`mealAllance`,`national`,`remark`,`salGroup`) values (1,2,'2023-11-20','SSC',2,1,1,2,2,'TW','可爱',2),(2,3,'2023-11-20','SSC',1,1,1,1,1,'CN','爱吃',1),(3,4,'2023-11-20','SSC',2,1,1,1,2,'TW','可靠',2),(4,5,'2023-11-20','SSC',2,1,1,2,2,'CN','聪明',2),(5,6,'2023-11-20','SSC',2,1,1,2,2,'TW','未知',2),(6,7,'2023-11-20','SSC',2,1,1,2,2,'TW','年轻',2),(7,8,'2023-11-20','SSC',2,1,1,2,2,'TW','稳',2),(8,9,'2023-11-20','SSC',2,1,1,2,2,'TW','前卫',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
