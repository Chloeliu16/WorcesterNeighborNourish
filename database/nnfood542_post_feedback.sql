-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: nnfood542
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `post_feedback`
--

DROP TABLE IF EXISTS `post_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `feedback_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h7go442m7oj28me8ay3i0nmdf` (`feedback_id`),
  KEY `FKcejg2moccsuceytg0uambj6mu` (`customer_id`),
  CONSTRAINT `FKcejg2moccsuceytg0uambj6mu` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKng4v60rpxc8d8q9bn38mr3ntc` FOREIGN KEY (`feedback_id`) REFERENCES `feedback` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_feedback`
--

LOCK TABLES `post_feedback` WRITE;
/*!40000 ALTER TABLE `post_feedback` DISABLE KEYS */;
INSERT INTO `post_feedback` VALUES (1,'posted','2024-04-16 17:03:08.185000',1,1),(2,'posted','2024-05-01 18:25:54.369000',1,2);
/*!40000 ALTER TABLE `post_feedback` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-01 20:51:40
