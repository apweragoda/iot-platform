-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: iot_platform
-- ------------------------------------------------------
-- Server version	5.7.32-0ubuntu0.18.04.1

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
-- Table structure for table `flow_rate`
--

DROP TABLE IF EXISTS `flow_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flow_rate` (
  `flow_rate_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_rate` double(6,2) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `sensor_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`flow_rate_id`),
  KEY `fk_flow_rate_sensor_id_idx` (`sensor_id`),
  CONSTRAINT `fk_flow_rate_sensor_id` FOREIGN KEY (`sensor_id`) REFERENCES `sensor` (`sensor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow_rate`
--

LOCK TABLES `flow_rate` WRITE;
/*!40000 ALTER TABLE `flow_rate` DISABLE KEYS */;
INSERT INTO `flow_rate` VALUES (1,10.99,'2020-11-30','17:49:48','SNSR_003'),(2,43.66,'2020-11-30','17:49:48','SNSR_003'),(3,42.87,'2020-11-29','17:49:48','SNSR_003'),(4,46.66,'2020-12-01','17:49:48','SNSR_003'),(5,45.00,'2020-12-01','17:49:48','SNSR_003'),(6,90.66,'2020-12-27','14:11:51','SNSR_003'),(7,90.66,'2020-12-27','14:35:11','SNSR_003'),(8,90.66,'2020-12-27','14:50:26','SNSR_003');
/*!40000 ALTER TABLE `flow_rate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-27 20:04:31
