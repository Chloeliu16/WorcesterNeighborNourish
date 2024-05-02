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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `rest_username` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `restaurant_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkomdx99dhk2cveaxugl2lws2u` (`category_id`),
  KEY `FKm9xrxt95wwp1r2s7andom1l1c` (`restaurant_id`),
  CONSTRAINT `FKkomdx99dhk2cveaxugl2lws2u` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKm9xrxt95wwp1r2s7andom1l1c` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,17,'fried noodles','lily123',1,1),(2,40,'strawberry cake','lily123',2,1),(3,30,'apple','lily123',3,1),(4,30,'salad','lily123',4,1),(5,10,'Brioche','nick11',5,2),(6,20,'Hawaiian Pizza','nick11',6,2),(7,20,'noodles','lily123',7,1);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
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
