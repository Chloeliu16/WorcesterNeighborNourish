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
-- Table structure for table `faq`
--

DROP TABLE IF EXISTS `faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faq` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq`
--

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
INSERT INTO `faq` VALUES (1,'You can find the registration page on our website and fill in the required information to register.','How can I register as a user?'),(2,'We provide various types of food, including fresh ingredients, canned goods, and frozen foods.','What types of food do you provide?'),(3,'Yes, the food we provide is free of charge, with no additional fees.','Is the food free? Are there any additional charges?'),(4,'You can use the map feature or search function on our website to locate nearby free food distribution points.','How can I find nearby free food?'),(5,'Typically, you may need to provide identification or other relevant documents to obtain free food.','What kind of proof do I need to obtain free food?'),(6,'Yes, you can collect free food multiple times according to our distribution rules.','Can I collect free food multiple times?'),(7,'You can find the donation page on our website, fill in the required information, and our staff will contact you.','How can I donate food?'),(8,'You can find the application page on our website, fill in the relevant information, and our staff will review your application.','How do we apply to become beneficiaries?'),(9,'You can support our work by donating food, funds, or volunteering.','How can I support your work?'),(10,'We have implemented a series of security measures to protect your personal information, including encrypted storage and access control.','How do you protect my personal information?');
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
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
