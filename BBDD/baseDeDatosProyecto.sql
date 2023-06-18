-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_tuirer
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `ID_CHAT` int NOT NULL AUTO_INCREMENT,
  `ID_USUARIO_EMISOR` int DEFAULT NULL,
  `ID_USUARIO_RECEPTOR` int DEFAULT NULL,
  PRIMARY KEY (`ID_CHAT`),
  KEY `ID_USUARIO_EMISOR_idx` (`ID_USUARIO_EMISOR`),
  KEY `ID_USUARIO_RECEPTOR_idx` (`ID_USUARIO_RECEPTOR`),
  CONSTRAINT `FK_ID_USUARIO_EMISOR` FOREIGN KEY (`ID_USUARIO_EMISOR`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE SET NULL,
  CONSTRAINT `FK_ID_USUARIO_RECEPTOR` FOREIGN KEY (`ID_USUARIO_RECEPTOR`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (10,2,8),(14,8,10),(15,8,13),(16,13,8),(17,13,11),(18,13,16),(19,13,15),(20,21,14),(21,13,16),(22,13,8),(23,23,14),(24,23,13),(25,25,13);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `ID_COMENTARIO` int NOT NULL AUTO_INCREMENT,
  `CONTENIDO` tinytext NOT NULL,
  `FECHA_PUBLICACION` date NOT NULL,
  `ID_USUARIO` int NOT NULL,
  `ID_TUIT_COMENTADO` int NOT NULL,
  PRIMARY KEY (`ID_COMENTARIO`),
  KEY `ID_TUIT_COMENTADOidx` (`ID_TUIT_COMENTADO`),
  KEY `FK_ID_USUARIO_idx` (`ID_USUARIO`),
  CONSTRAINT `FK928xlgq2nq2tlahm31eo14unm` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  CONSTRAINT `FK_ID_TUIT_COMENTARIO` FOREIGN KEY (`ID_TUIT_COMENTADO`) REFERENCES `tuit` (`ID_TUIT`) ON DELETE CASCADE,
  CONSTRAINT `FK_ID_USUARIO_COMENTARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (11,'prueba asdasdas','2023-03-24',2,11),(12,'Probando Comentario angular','2023-04-19',2,26),(13,'Si?','2023-04-20',2,27),(14,'prueba\n','2023-04-20',2,27),(15,'magkikos','2023-04-20',2,27),(16,'hola','2023-04-27',13,29),(17,'Hola\n','2023-04-27',13,27),(18,'El alex es el niño raqueta','2023-04-27',13,29),(19,'hola?\n','2023-04-27',13,30),(20,'asdasd','2023-05-02',13,30),(21,'asdasda','2023-05-02',13,30),(22,'liyu','2023-05-02',13,34),(23,'ola?','2023-05-05',13,35),(24,'ASasAS','2023-05-22',13,35),(25,'asdasdasd','2023-05-24',13,37),(26,'Hola tio','2023-05-30',17,30),(27,'que pasa tronca','2023-05-31',22,45),(28,'Que pasa chema','2023-05-31',22,43),(29,'Hola, que tal?','2023-06-12',15,43),(30,'Comentario','2023-06-13',23,46),(31,'Hola','2023-06-16',25,42);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `ID_LIKE` int NOT NULL AUTO_INCREMENT,
  `FLAG_LIKE` bit(1) DEFAULT NULL,
  `ID_USUARIO` int DEFAULT NULL,
  `ID_COMENTARIO` int DEFAULT NULL,
  `ID_TUIT` int DEFAULT NULL,
  PRIMARY KEY (`ID_LIKE`),
  KEY `FK1puv49t33h4lbvuf8wfgwhs15` (`ID_COMENTARIO`),
  KEY `FKds1itdko33nehtvayn1xr2d6l` (`ID_TUIT`),
  CONSTRAINT `FK1puv49t33h4lbvuf8wfgwhs15` FOREIGN KEY (`ID_COMENTARIO`) REFERENCES `comentario` (`ID_COMENTARIO`),
  CONSTRAINT `FKds1itdko33nehtvayn1xr2d6l` FOREIGN KEY (`ID_TUIT`) REFERENCES `tuit` (`ID_TUIT`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,_binary '',2,NULL,11),(2,_binary '',2,11,NULL),(3,_binary '',13,NULL,34),(4,_binary '',13,NULL,33),(5,_binary '',13,NULL,34),(6,_binary '',13,NULL,34),(7,_binary '',13,NULL,34),(8,_binary '',13,NULL,34),(9,_binary '',13,NULL,34),(10,_binary '',13,NULL,34),(11,_binary '',13,NULL,34),(12,_binary '',13,NULL,34),(13,_binary '',13,NULL,32),(14,_binary '',13,NULL,30),(15,_binary '',13,NULL,35),(16,_binary '',13,NULL,34),(17,_binary '',13,NULL,34),(18,_binary '',13,NULL,34),(19,_binary '',13,NULL,35),(20,_binary '',13,NULL,35),(21,_binary '',13,NULL,35),(22,_binary '',13,NULL,34),(23,_binary '',13,NULL,34),(24,_binary '',13,NULL,35),(25,_binary '',13,NULL,34),(26,_binary '',13,NULL,34),(27,_binary '',13,NULL,34),(28,_binary '',13,NULL,35),(29,_binary '',13,NULL,35),(30,_binary '',13,NULL,35),(31,_binary '',13,NULL,34),(32,_binary '',13,NULL,35),(33,_binary '',13,NULL,34),(34,_binary '',13,NULL,33),(35,_binary '',13,NULL,35),(36,_binary '',13,NULL,34),(37,_binary '',13,NULL,35),(38,_binary '',13,NULL,34),(39,_binary '',13,NULL,35),(40,_binary '',13,NULL,35),(41,_binary '',13,NULL,35),(42,_binary '',13,NULL,35),(43,_binary '',13,NULL,35),(44,_binary '',13,NULL,37),(45,_binary '',13,NULL,36),(46,_binary '',16,NULL,34),(47,_binary '',16,NULL,41),(48,_binary '',16,NULL,41),(49,_binary '',16,NULL,40),(50,_binary '',15,NULL,42),(51,_binary '',15,NULL,43),(52,_binary '',21,NULL,30),(53,_binary '',21,NULL,44),(54,_binary '',22,NULL,45),(55,_binary '',13,NULL,38),(56,_binary '',15,NULL,43),(57,_binary '',15,NULL,42),(58,_binary '',23,NULL,46),(59,_binary '',25,NULL,42),(60,_binary '',25,NULL,40),(61,_binary '',25,NULL,39);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `ID_MENSAJE` int NOT NULL AUTO_INCREMENT,
  `CONTENIDO` longtext NOT NULL,
  `ID_CHAT` int NOT NULL,
  `FECHA_ENVIADO` date NOT NULL,
  `ID_USUARIO` int NOT NULL,
  PRIMARY KEY (`ID_MENSAJE`),
  KEY `ID_CHAT_idx` (`ID_CHAT`),
  KEY `ID_USUARIO_idx` (`ID_USUARIO`),
  CONSTRAINT `FK_ID_CHAT` FOREIGN KEY (`ID_CHAT`) REFERENCES `chat` (`ID_CHAT`),
  CONSTRAINT `FK_ID_USUARIO_MENSAJE` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
INSERT INTO `mensaje` VALUES (1,'primer mensaje',10,'2023-05-31',2),(2,'primer mensaje',10,'2023-05-31',2),(3,'primer mensaje',10,'2023-05-31',2),(4,'primer mensaje',10,'2023-05-31',2),(5,'primer mensaje',10,'2023-05-31',2),(6,'primer mensaje',15,'2023-06-07',13),(7,'Segundo mensaje',15,'2023-06-07',13),(8,'Hola?',17,'2023-06-07',13),(9,'asdasd',19,'2023-06-07',13),(10,'asdasda',19,'2023-06-07',13),(11,'Hola?',20,'2023-06-07',21),(12,'asdasd',17,'2023-06-12',13),(13,'Hola?',19,'2023-06-12',15),(14,'Hola',23,'2023-06-13',23),(15,'hola',25,'2023-06-16',25),(16,'hola',25,'2023-06-16',13);
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimiento`
--

DROP TABLE IF EXISTS `seguimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimiento` (
  `ID_USUARIO_SEGUIDO` int NOT NULL,
  `ID_USUARIO_SEGUIDOR` int NOT NULL,
  PRIMARY KEY (`ID_USUARIO_SEGUIDO`,`ID_USUARIO_SEGUIDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimiento`
--

LOCK TABLES `seguimiento` WRITE;
/*!40000 ALTER TABLE `seguimiento` DISABLE KEYS */;
INSERT INTO `seguimiento` VALUES (2,8),(2,13),(2,15),(2,17),(2,21),(2,25),(8,15),(8,21),(10,15),(11,21),(13,13),(13,15),(14,15),(15,15),(15,22),(16,15),(16,25);
/*!40000 ALTER TABLE `seguimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuit`
--

DROP TABLE IF EXISTS `tuit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuit` (
  `ID_TUIT` int NOT NULL AUTO_INCREMENT,
  `CONTENIDO` varchar(600) NOT NULL,
  `FECHA_PUBLICACION` date NOT NULL,
  `ID_USUARIO` int NOT NULL,
  PRIMARY KEY (`ID_TUIT`),
  UNIQUE KEY `ID_TUIT_UNIQUE` (`ID_TUIT`) /*!80000 INVISIBLE */,
  KEY `ID_USUARIO_idx` (`ID_USUARIO`),
  CONSTRAINT `FK_ID_USUARIO_TUIT` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE CASCADE,
  CONSTRAINT `FKrnbarhi478xsyhscnq5fgd6et` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuit`
--

LOCK TABLES `tuit` WRITE;
/*!40000 ALTER TABLE `tuit` DISABLE KEYS */;
INSERT INTO `tuit` VALUES (11,'asdasdasd','2023-03-24',2),(12,'asdasdasdasd','2023-03-24',2),(13,'asdasdasdasd','2023-03-24',8),(14,'asdasdasdasd','2023-03-24',11),(15,'Prueba purueba','2023-03-24',11),(16,'Prueba purueba','2023-03-24',11),(17,'Prueba','2023-04-14',2),(18,'pruebaasaaaaa','2023-04-14',2),(19,'holaaaaaaaaaa','2023-04-14',2),(20,'Buenos dias','2023-04-15',2),(21,'prueba 3','2023-04-15',2),(22,'sdfsdf','2023-04-15',2),(23,'ultima prueba','2023-04-15',2),(24,'belen tonta','2023-04-15',2),(25,'Probando','2023-04-19',2),(26,'asdas','2023-04-19',2),(27,'Soy un paquete','2023-04-19',2),(28,'Probando admin','2023-04-27',2),(29,'hola','2023-04-27',13),(30,'Hola','2023-04-27',2),(31,'Probando admin','2023-05-02',13),(32,'Prueba reunion','2023-05-02',13),(33,'','2023-05-02',13),(34,'kjyhgb','2023-05-02',13),(35,'hola?','2023-05-05',13),(36,'asdasdas','2023-05-24',13),(37,'Hola?','2023-05-24',13),(38,'asdasdasd','2023-05-24',13),(39,'asdasd','2023-05-24',13),(40,'asdasdasd','2023-05-24',13),(41,'asdasd','2023-05-24',13),(42,'asdasd','2023-05-24',16),(43,'Hola que hase','2023-05-25',15),(44,'Que pasa markinas','2023-05-30',21),(45,'Hola Chicho','2023-05-31',22),(46,'Hola ','2023-06-13',23),(47,'prueba123','2023-06-16',25);
/*!40000 ALTER TABLE `tuit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(45) NOT NULL,
  `NOMBRE_USUARIO` varchar(45) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `FECHA_REGISTRO` date NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `NOMBRE_USUARIO_UNIQUE` (`NOMBRE_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Moncete','AdRiAn','$2a$10$z.t4fxb4a4JtIYcWWkXr2e8rAR5f9e6TCnWj9.rfkwvUAA2Xwhadu','2023-03-24'),(8,'Belen@gmail.com','bels','123123','2023-03-24'),(10,'pedro@Gmail.com','Peter','123123','2023-03-24'),(11,'Fernando@mail.com','Fer','123123','2023-03-24'),(13,'admin','admin','$2a$10$55wa2mY1t5XJeZa5C01OIu3q29nRQbio9VDmE7A.sAoIhoduC6AKy','2023-04-25'),(14,'diego','diego','$2a$10$y8gLxcvHy3fetpySgiuq5uhXkK3cAlfvEO58MqIrJwUcadommdsBG','2023-05-20'),(15,'chema@gmail.com','chemica','$2a$10$HcZuici8BgF7tDm1JVuAyOkAoYWi.cZ/Eoj4AHqYDJjuRSzxRGDka','2023-05-24'),(16,'kuasky@gmail.com','kuasky','$2a$10$xI3YjLgK8VYugoR53uXOq.kOMRsWUDk66VBvQO4yKdUIhFJWDpbNm','2023-05-24'),(17,'Diegopm96@gmail.com','dpm','$2a$10$vRx/43UNEOsY0mcp/a/5ae/WcgKsenH2zitJWBpW2zB8BEthSv8o2','2023-05-30'),(18,'lorenzo@gmail.com','loren','$2a$10$WDu4xm/ztPsVypqD1vq9wurX7qHSiYjb/M36xpZ4YJ0LPYPvd10em','2023-05-30'),(19,'asdasd@gmail.com','asdasd','$2a$10$UBKs771osOaNITqzqWFPcurviTDRNuMa0DdSBmZikgSIgru9y5Q/6','2023-05-30'),(20,'jesus@gmail.com','jesus','$2a$10$u/G70ROsED43TqyVTgLNWuRAegjPJbNB1Kvq7ZJH8w9dC5uMkw/uW','2023-05-30'),(21,'marcos@gmail.com','markikos','$2a$10$xzXLuChR6qKN13dOymb77OOhXL4C1m4Q4zX.lxVY5Ew2XVRSeqLai','2023-05-30'),(22,'bels@gmail.com','belen','$2a$10$mo8pDIsBo2trhQXMY68HN.RZQKTnw0q.fWD.L4VWWzaPVe.KGWbs2','2023-05-31'),(23,'pedro123@email.com','pedro123','$2a$10$VuV2B18Dukhf3Jm1innwHugFsC4v5S.lJES4T3pF/XFCu/.OO8qHG','2023-06-13'),(24,'asdasdsa@email.com','Probando2','$2a$10$U82gvlqsC5Iwc/FTX/KweO2pptIkPSY/T.IEOXPyAP95Aw28skySe','2023-06-14'),(25,'prueba@email.com','prueba','$2a$10$YOQ6qLHHwYDaoVgTmQaGi.ZBFPuncygijGmInrgkg5CYZI3ZDTlee','2023-06-16');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-16 18:17:24
