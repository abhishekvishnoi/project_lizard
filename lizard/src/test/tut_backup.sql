-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projectDB
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `category_tb_master`
--

DROP TABLE IF EXISTS `category_tb_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_tb_master` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tb_master`
--

LOCK TABLES `category_tb_master` WRITE;
/*!40000 ALTER TABLE `category_tb_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_tb_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product_tb_dtl`
--

DROP TABLE IF EXISTS `order_product_tb_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product_tb_dtl` (
  `ordr_prdct_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_price` float DEFAULT NULL,
  `product_qty` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`ordr_prdct_id`),
  KEY `product_id` (`product_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_product_tb_dtl_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products_tb_master` (`product_id`),
  CONSTRAINT `order_product_tb_dtl_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order_tb_master` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product_tb_dtl`
--

LOCK TABLES `order_product_tb_dtl` WRITE;
/*!40000 ALTER TABLE `order_product_tb_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product_tb_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tb_master`
--

DROP TABLE IF EXISTS `order_tb_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_tb_master` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `ordr_nmbr` varchar(32) DEFAULT NULL,
  `ordr_prc` float DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_tb_master_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products_tb_master` (`product_id`),
  CONSTRAINT `order_tb_master_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_tb_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tb_master`
--

LOCK TABLES `order_tb_master` WRITE;
/*!40000 ALTER TABLE `order_tb_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_tb_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_tb_master`
--

DROP TABLE IF EXISTS `products_tb_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products_tb_master` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(32) DEFAULT NULL,
  `product_price` float DEFAULT NULL,
  `product_image` varchar(128) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_tb_master`
--

LOCK TABLES `products_tb_master` WRITE;
/*!40000 ALTER TABLE `products_tb_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_tb_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb_master`
--

DROP TABLE IF EXISTS `user_tb_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tb_master` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `user_email` varchar(64) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_role` int(11) NOT NULL,
  `date_added` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb_master`
--

LOCK TABLES `user_tb_master` WRITE;
/*!40000 ALTER TABLE `user_tb_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_tb_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-27 15:48:38
