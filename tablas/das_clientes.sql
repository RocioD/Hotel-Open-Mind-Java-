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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `rut` varchar(10) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Apellido_Paterno` varchar(45) NOT NULL,
  `Apellido_Materno` varchar(45) NOT NULL,
  `Sexo` char(1) NOT NULL,
  `Fecha_Nacimiento` varchar(45) NOT NULL,
  `Nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('12032023-7','Mario Alberto','Marin','Aguilera','M','11-03-82','Chilena'),('12032889-4','Carla Marta','Amigo','Bueno','F','18-07-69','Chilena'),('13158123-4','Joan Pablo','RODRIGUEZ','PASADAS','M','20-03-70','Chilena'),('13452120-9','Ximena Laura','Lizama','Moreno','F','20-03-83','Chilena'),('13554220-9','Arturo Mario','Slovak','Blanco','M','10-10-83','Chilena'),('14144251-1','Pedro Ivan','Toledo','Pascual','M','16-11-86','Chilena'),('15023954-K','Juanita Maria','Parra','Perez','F','13-01-89','Chilena'),('16025411-9','Miguel Alejandro','Pereira','Casas','M','23-09-90','Chilena'),('17561741-2','Maria Estefania','Román','Tejado','F','23-07-91','Chilena'),('18025646-9','Manuel Adrian','Sanchez','Rodriguez','M','02-09-91','Chilena'),('18256744-4','Margarita Raquel','Sandoval','Morales','F','17-09-92','Chilena'),('19159951-9','ANDRES Eliot','SOTO','AROCAS','M','13-12-93','Chilena'),('25032145-7','Miguel Ramon','Perez','Gilabert','M','20-07-90','Peruana'),('26032301-8','Jose Jesus','Jaramillo','Barroso','M','29-05-60','Colombiano'),('9256124-7','Paulina Esther','Andrea','Perez','F','16-10-64','Chilena');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
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
