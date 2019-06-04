-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: das
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `Numero_Orden` int(11) NOT NULL AUTO_INCREMENT,
  `Habitacion` varchar(45) NOT NULL,
  `Cantidad_Personas` int(11) NOT NULL,
  `Modalidad` int(1) NOT NULL,
  `Costo_Habitacion` int(11) NOT NULL,
  `Fecha_Hora_Ingreso` varchar(45) NOT NULL,
  PRIMARY KEY (`Numero_Orden`),
  UNIQUE KEY `Numero_Orden_UNIQUE` (`Numero_Orden`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` VALUES (1,'LoveChair',2,1,55200,'22:15 14/01/19'),(2,'La China',3,2,117720,'23:40 27/01/19'),(3,'Vaquero',4,1,113920,'19:30 11/02/19'),(4,'Parque de diversiones',2,2,60000,'20:00 09/03/19'),(5,'La China',2,1,87200,'15:05 10/03/19'),(6,'Lunar',3,2,74520,'16:00 11/03/19'),(7,'Túnel subterráneo',4,1,78720,'17:05 12/03/19'),(8,'Cassandra',2,2,25200,'18:10 13/03/19'),(9,'Egipcia',2,1,61200,'19:15 14/03/19'),(10,'Kamasutra',2,2,91200,'20:30 15/03/19'),(11,'Cassandra',1,2,0,'12:42 15/3/19');
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-01 16:04:37
