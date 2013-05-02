-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bdd_lady
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.12.04.1

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(100) NOT NULL,
  `portable` varchar(100) NOT NULL,
  `adresse` text NOT NULL,
  `taille` int(4) DEFAULT NULL,
  `poids` int(4) DEFAULT NULL,
  `tourDePoitrine` int(4) DEFAULT NULL,
  `tourDeTaille` int(4) DEFAULT NULL,
  `pointure` int(4) DEFAULT NULL,
  `modePaiement` int(11) DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `portable` (`portable`),
  KEY `fk_mode_paiement_client` (`modePaiement`),
  CONSTRAINT `fk_mode_paiement_client` FOREIGN KEY (`modePaiement`) REFERENCES `mode_paiement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'test','13439457305','idfjgndfo iujhdf op54dfg ',156,NULL,54,NULL,45,NULL,'2013-04-24 14:53:36'),(2,'test','454656','fdfsg dfg sd',NULL,NULL,NULL,NULL,NULL,4,'2013-04-24 15:02:23'),(3,'test','54546','SDFSDFsdf',NULL,NULL,NULL,NULL,NULL,NULL,'2013-04-24 15:12:07'),(4,'dfsdf','68465','dfsdf',NULL,NULL,NULL,NULL,NULL,5,'2013-04-24 15:13:20'),(7,'LaChatteALaVoisine','13439457368','sddsf sdf54sd fsd 45f',19,NULL,NULL,NULL,45,1,'2013-04-25 17:18:28'),(8,'???','5646521','??????????',NULL,NULL,NULL,NULL,NULL,5,'2013-05-02 14:52:29'),(9,'地方分','123456789','3 rue des moulinards',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-02 16:41:38');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL,
  `prixCoutant` int(8) NOT NULL,
  `prixFacture` int(8) NOT NULL,
  `modePaiement` int(11) DEFAULT NULL,
  `datePaiement` datetime DEFAULT NULL,
  `dateCommandeProduits` datetime DEFAULT NULL,
  `dateReceptionProduits` datetime DEFAULT NULL,
  `dateExpeditionProduits` datetime DEFAULT NULL,
  `modeExpedition` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mode_paiement_commande` (`modePaiement`),
  KEY `fk_mode_expedition_commande` (`modeExpedition`),
  KEY `fk_client_commande` (`client`),
  CONSTRAINT `fk_client_commande` FOREIGN KEY (`client`) REFERENCES `client` (`id`),
  CONSTRAINT `fk_mode_expedition_commande` FOREIGN KEY (`modeExpedition`) REFERENCES `mode_expedition` (`id`),
  CONSTRAINT `fk_mode_paiement_commande` FOREIGN KEY (`modePaiement`) REFERENCES `mode_paiement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,3,123,12321,4,NULL,NULL,NULL,NULL,NULL),(2,1,125,456,2,NULL,NULL,NULL,NULL,NULL),(3,4,65,654,5,NULL,NULL,NULL,NULL,NULL),(4,4,684,6544,3,'2008-05-26 08:00:00',NULL,NULL,NULL,NULL),(5,4,654,6544,3,NULL,NULL,NULL,NULL,NULL),(6,1,654,65444,1,'2009-08-26 08:00:00',NULL,NULL,NULL,NULL),(7,7,15,450,5,NULL,NULL,NULL,NULL,NULL),(8,7,15,450,5,NULL,NULL,NULL,NULL,NULL),(9,7,12,123,3,'2013-04-26 08:00:00',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mode_expedition`
--

DROP TABLE IF EXISTS `mode_expedition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mode_expedition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modeExpedition` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mode_expedition`
--

LOCK TABLES `mode_expedition` WRITE;
/*!40000 ALTER TABLE `mode_expedition` DISABLE KEYS */;
INSERT INTO `mode_expedition` VALUES (1,'圆通 (Yuan Tong)'),(2,'顺丰 (Shun Feng)');
/*!40000 ALTER TABLE `mode_expedition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mode_paiement`
--

DROP TABLE IF EXISTS `mode_paiement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mode_paiement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modePaiement` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mode_paiement`
--

LOCK TABLES `mode_paiement` WRITE;
/*!40000 ALTER TABLE `mode_paiement` DISABLE KEYS */;
INSERT INTO `mode_paiement` VALUES (1,'农行 (Nong Hang)'),(2,'工行 (Gong Hang)'),(3,'建行 (Jian Hang)'),(4,'中信 (Zhong Xin)'),(5,'支付宝 (Zhi Fu Bao)');
/*!40000 ALTER TABLE `mode_paiement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `taille` varchar(10) DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'cx',NULL,'2013-04-24 16:44:45'),(2,'Marcel top classe fluo rose','L','2013-04-25 17:22:14');
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produits_commandes`
--

DROP TABLE IF EXISTS `produits_commandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produits_commandes` (
  `produit` int(11) NOT NULL,
  `commande` int(11) NOT NULL,
  KEY `fk_produit_PC` (`produit`),
  KEY `fk_commande_PC` (`commande`),
  CONSTRAINT `fk_commande_PC` FOREIGN KEY (`commande`) REFERENCES `commande` (`id`),
  CONSTRAINT `fk_produit_PC` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produits_commandes`
--

LOCK TABLES `produits_commandes` WRITE;
/*!40000 ALTER TABLE `produits_commandes` DISABLE KEYS */;
INSERT INTO `produits_commandes` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,7),(2,8),(2,9);
/*!40000 ALTER TABLE `produits_commandes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-02 16:41:50
