-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Credit
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act_catalog_tab`
--

DROP TABLE IF EXISTS `act_catalog_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_catalog_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyid` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userKeyid` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slogan` text COLLATE utf8_unicode_ci,
  `creattime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `holdtime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `finishtime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `acttype` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `place` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `actgrade` double DEFAULT NULL,
  `member` int(11) DEFAULT NULL,
  `info01` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info04` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info05` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_catalog_tab`
--

LOCK TABLES `act_catalog_tab` WRITE;
/*!40000 ALTER TABLE `act_catalog_tab` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_catalog_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_class_tab`
--

DROP TABLE IF EXISTS `act_class_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_class_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyid` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `creattime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  `info01` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_class_tab`
--

LOCK TABLES `act_class_tab` WRITE;
/*!40000 ALTER TABLE `act_class_tab` DISABLE KEYS */;
INSERT INTO `act_class_tab` VALUES (1,'10001','知识竞赛',1,'2017-10-12 12:25:12',0,NULL,NULL,NULL),(2,'10002','游戏活动',2,'2017-10-12 12:25:12',0,NULL,NULL,NULL),(3,'10003','体育活动',3,'2017-10-12 12:25:12',0,NULL,NULL,NULL),(4,'10004','电竞活动',4,'2017-10-12 12:25:12',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `act_class_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_person_tab`
--

DROP TABLE IF EXISTS `act_person_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_person_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyid` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `activekeyid` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activename` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stukeyid` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `finishtime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activegrade` double DEFAULT NULL,
  `info01` int(4) DEFAULT NULL,
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info04` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info05` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `jointime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_person_tab`
--

LOCK TABLES `act_person_tab` WRITE;
/*!40000 ALTER TABLE `act_person_tab` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_person_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu_tab`
--

DROP TABLE IF EXISTS `sys_menu_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyid` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `path` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info01` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info04` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info05` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu_tab`
--

LOCK TABLES `sys_menu_tab` WRITE;
/*!40000 ALTER TABLE `sys_menu_tab` DISABLE KEYS */;
INSERT INTO `sys_menu_tab` VALUES (1,'1000001','申请活动','1002','applyact',NULL,NULL,NULL,NULL,NULL),(2,'1000002','申请记录','1002','applyrecord',NULL,NULL,NULL,NULL,NULL),(3,'1000003','查看学分','1002','showgrade',NULL,NULL,NULL,NULL,NULL),(4,'1000004','我的活动','1002','myact',NULL,NULL,NULL,NULL,NULL),(5,'1000005','活动公示','1002','publicity',NULL,NULL,NULL,NULL,NULL),(6,'1000006','活动审批','1001','approve',NULL,NULL,NULL,NULL,NULL),(7,'1000007','学分类别','1001','graclasses',NULL,NULL,NULL,NULL,NULL),(8,'1000008','学分统计','1001','grastatistics',NULL,NULL,NULL,NULL,NULL),(9,'1000009','学生管理','1001','stumanage',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_menu_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_tab`
--

DROP TABLE IF EXISTS `sys_role_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `rolename` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `info01` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_tab`
--

LOCK TABLES `sys_role_tab` WRITE;
/*!40000 ALTER TABLE `sys_role_tab` DISABLE KEYS */;
INSERT INTO `sys_role_tab` VALUES (1,'1','1001','活动审批',1,NULL,NULL,NULL),(2,'1','1001','学分类别',2,NULL,NULL,NULL),(3,'1','1001','学分统计',3,NULL,NULL,NULL),(4,'1','1001','学生管理',4,NULL,NULL,NULL),(5,'2','1002','申请活动',1,NULL,NULL,NULL),(6,'2','1002','申请记录',2,NULL,NULL,NULL),(7,'2','1002','查看学分',3,NULL,NULL,NULL),(8,'2','1002','我的活动',4,NULL,NULL,NULL),(9,'2','1002','活动公示',5,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_role_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_tab`
--

DROP TABLE IF EXISTS `sys_user_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyid` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `role` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enrollmentTime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info01` varchar(45) COLLATE utf8_unicode_ci DEFAULT '0',
  `info02` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info03` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info04` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info05` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info06` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info07` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_tab`
--

LOCK TABLES `sys_user_tab` WRITE;
/*!40000 ALTER TABLE `sys_user_tab` DISABLE KEYS */;
INSERT INTO `sys_user_tab` VALUES (1,'e2a6a1ace352668000aed191a817d143','admin','123qwe','admin','18566666666',0,'1','男','2015-04-08','0',NULL,NULL,NULL,NULL,NULL,NULL),(2,'bb36c34eb6644ab9694315af7d68e629','stu1','123qwe','小安','12345678912',0,'2','男','2017-09-05','0',NULL,NULL,NULL,NULL,NULL,NULL),(3,'3dc81e3f2c523fb5955761bbe2d150f2','stu2','123qwe','晓华','13199999999',0,'2','男','2015-09-09','0',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_user_tab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-03 10:32:20
