-- MySQL dump 10.13  Distrib 5.5.28, for osx10.6 (i386)
--
-- Host: localhost    Database: bdd_lady
-- ------------------------------------------------------
-- Server version	5.5.28

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
  `nom` varchar(100) NOT NULL,
  `taille` int(4) DEFAULT NULL,
  `poids` int(4) DEFAULT NULL,
  `tourDePoitrine` varchar(10) DEFAULT NULL,
  `tourDeTaille` varchar(10) DEFAULT NULL,
  `pointure` int(4) DEFAULT NULL,
  `modePaiement` int(11) DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `portable` (`portable`),
  KEY `fk_mode_paiement_client` (`modePaiement`),
  CONSTRAINT `fk_mode_paiement_client` FOREIGN KEY (`modePaiement`) REFERENCES `mode_paiement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (13,'慕容曦','13801381797','北京西城区灵境胡同12号院3号楼1门503室','尹路',163,118,'80B','2尺2',NULL,NULL,'2013-05-05 19:18:44'),(14,'大MO0MO0','13910661946','北京市东城区安定门外东滨河路三号院1单元507室','董子祺',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:19:58'),(15,'微信名安娜','18636941052','山西太原小店区南中环晋阳街山西省实验中学','徐安娜',170,116,NULL,NULL,NULL,NULL,'2013-05-05 19:21:30'),(16,'王的三次方Julie','15888871700','杭州市滨江区滨盛路2000号联通大厦17楼','王梦珏',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:22:45'),(17,'段雨欣Sandy','13910733657','北京朝阳北路青年路华纺易城5号楼1单元1302室','段书娟',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:23:38'),(18,'cici的粉围脖','18037778777','河南洛阳市西工区王城大道268号升龙广场3楼综合部','曲丹',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:24:40'),(19,'小答应_2008','15144178830','吉林省 长春市 绿园区 和平大街南阳路交汇车城苑3-1-502','李思纹',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:25:36'),(20,'周月tina','13810674080','北京丰台区西四环南路103号院设计师广场A座201','周王月',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:26:42'),(21,'大A','15000158388','上海市闸北区 广中西路999弄36号6A室','李艳',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:28:24'),(22,'Halo--王坚强不会哭','13478568878','辽宁大连普兰店市新城小学对面汽车配件楼上','王玉',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:29:12'),(23,'An -an-feng','13592172270','河南平顶山市曙光街9号院','张峰',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:31:28'),(24,'霸气的小灏子妈妈','15868099999','浙江温州市鹿城区雪山路华侨新村9僮1号','施冬平',160,103,NULL,NULL,NULL,NULL,'2013-05-05 19:32:18'),(25,'zwbeby','15880777462','福建省泉州市鲤城区涂门街秋源楼1栋204','李欣',175,100,'75B',NULL,NULL,NULL,'2013-05-05 19:35:46'),(26,'Crystal_37','18613989870','湖南省长沙市雨花区万芙路湘府名邸1栋1单元802','段小姐',163,120,NULL,NULL,NULL,NULL,'2013-05-05 19:36:51'),(27,'杜拉拉芳','13466562340','北京市首都机场生活区南路西里10号楼5单元501室','杜佳芳',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:38:15'),(28,'小乐妈妈','18635777609','山西省临汾市襄汾县铁路家属楼北楼3单元4楼东','王丹',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:38:56'),(29,'细雨绵绵','13616886600','浙江宁波市江东区华光城华锦巷60号201','尹小姐',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:39:27'),(30,'_柒汐_','13968892889','温州市雪山路雪景公寓C幢510','周巧巧',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:40:15'),(31,'vivian-施施','13697466808','广州海珠区工业大道南石溪新业路3号','林洛施',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:40:52'),(32,'幻灵雨泽','18015759701','四川省泸州市慈善路128号江阳区联社','黄敏',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:42:15'),(33,'Queen-璇子','18637905522','河南省洛阳市九都路67号洛阳广播电视台','张璇',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:43:11'),(34,'SUE','15869696893','山东济南天桥区北园大街红星美凯龙三楼西厅','苏张平',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:43:47'),(35,'OLIVIA_CF','13652008485','天津市河西区梅江福水园2-2-502','-',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:45:15'),(36,'洋气舞娘','15058357730','浙江省乐清市翁洋镇府前路57号','陈爱露',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:46:01'),(37,'Cyy媛小媛','13665321895','山东省青岛市李沧区升平路38号3号楼一单元602','陈媛媛',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 19:46:35'),(38,'li沫沫li','18622203711','天津市河西区大沽南路1118号天邦购物中心3楼D区','李沫',NULL,NULL,'75C',NULL,NULL,NULL,'2013-05-05 20:12:44'),(39,'橙子花儿园','18622550109','天津西青区海泰西路18号BPO产业园中北楼503海泰担保','张超',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:14:59'),(40,'vvvvvv點com','13858545057','浙江绍兴胜利东路357号招商银行绍兴分行','田薇',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:15:30'),(41,'ADA毕蓝','13935113344','山西太原坞城东街军区干休所A座2单元601','毕蓝',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:16:23'),(42,'微信A小','18624028789','辽宁沈阳于洪区松山西路13号3-2-2明华欣居园','赵洋洋',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:16:57'),(43,'小胡子晨','15022764095','北京朝阳区管庄京通苑22栋502','李晨',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:17:26'),(44,'KIKI琦','13885038015','贵州贵阳市南明区护国路31号名士大厦4楼贵州省医药集团和平兴业医药有限公司','陈莉',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:18:12'),(45,'微信号：KIMI','18600538743','北京朝阳区常营万象新天115楼1205','郭嘉琪',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:18:48'),(46,'炆琳','13769472967','云南昆明五华区青年路小花园昆明走廊4楼1240餐厅转茶室','袁炆林',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:19:33'),(47,'Super-Wenw','15982892217','成都市建设路万科金域蓝湾11栋8楼','文闻',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:20:12'),(48,'小M-only','13838566069','郑州市郑东新区商务外环路29号国泰财富中心17层','张会雨',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:20:46'),(49,'宝嘉缇的秘密','18868882858','浙江杭州萧山南阳镇横蓬村14组754号','项玲玲',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:21:35'),(50,'yi0326','18639029101','河南省洛阳洛龙区滨河路 东方今典小区 19号楼2单元','张丽健',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:22:27'),(51,'小马哥是大美女','13880089694','成都市青羊区贝双街二号贝森兴苑4-1-5-13','马俊',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:23:04'),(52,'可爱苏苏LOVE','15867639928','浙江省台州市仙居县环城南路276号','张梦君',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:23:39'),(53,'2006飞鱼2006','18653286339','山东省青岛市市南区山东路二号华仁大厦良子健身三楼','樊亚颖',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:24:37'),(54,'xxx0530','13810608015','北京通州区天桥湾小区8号楼122','徐晓璇',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:25:10'),(55,'健艺','0','云南昆明盘龙区龙泉路泰阳欣城A--206','王语轩',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:26:00'),(56,'菁','18901269666','北京西城区菜市口中心城二期1号楼1单元601室','-',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 20:58:09'),(57,'灏子妈的朋友','13736361608','浙江温州市车站大道京龙大厦8楼','赵思敏',162,100,'86','1尺9',NULL,NULL,'2013-05-05 20:59:26'),(58,'MioDotti','18604230809','辽宁省沈阳市皇姑区黄河南大街26号海韵花园28号兴业银行','李彤',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 21:03:46'),(59,'美小姗','15868817033','浙江杭州杭大路1号黄龙世纪广场A区4楼','林姗姗',NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-05 21:04:17'),(60,'Lover_Vivi','18749591777','河南许昌市长葛市文化路政府家属院3号楼','张薇薇',NULL,NULL,'87','75',NULL,NULL,'2013-05-05 21:05:39'),(61,'樱桃猫CherryCat','15936606600','河南省漯河市源汇区五一路南段盛事嘉圆北区 顺丰速运隔壁','余婷',168,108,'90','65',NULL,NULL,'2013-05-05 21:07:06'),(62,'开心小韦韦','13917455086','上海宝山区上大路99号上海大学社会学院B楼427室','韦淑珍老师',163,106,'85B',NULL,37,NULL,'2013-05-05 21:08:34');
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
  CONSTRAINT `fk_mode_paiement_commande` FOREIGN KEY (`modePaiement`) REFERENCES `mode_paiement` (`id`),
  CONSTRAINT `fk_mode_expedition_commande` FOREIGN KEY (`modeExpedition`) REFERENCES `mode_expedition` (`id`),
  CONSTRAINT `fk_client_commande` FOREIGN KEY (`client`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,13,3,'2013-03-23 08:00:00',NULL,NULL,NULL,NULL),(3,15,3,'2013-03-29 08:00:00',NULL,NULL,NULL,NULL),(4,16,3,'2013-04-01 08:00:00',NULL,NULL,NULL,NULL),(5,14,3,'2013-03-27 08:00:00',NULL,NULL,NULL,NULL),(6,17,3,'2013-04-05 08:00:00',NULL,NULL,NULL,NULL),(7,18,3,'2013-04-07 08:00:00',NULL,NULL,NULL,NULL),(8,19,3,'2013-04-08 08:00:00',NULL,NULL,NULL,NULL);
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
  `commande` int(11) NOT NULL,
  `prixCoutant` int(8) NOT NULL,
  `prixFacture` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_commande_produit` (`commande`),
  CONSTRAINT `fk_commande_produit` FOREIGN KEY (`commande`) REFERENCES `commande` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'斑马上衣',1,180,380),(3,'FAKE CC卫衣 粉色 M号',3,80,480),(4,'亮片绿裙子 M号',4,120,690),(5,'嘴唇套装L号',5,250,650),(6,'RV平底 39码',6,118,650),(7,'VL玫红色针织蓬蓬裙S',6,330,650),(8,'驼色毛衣S',6,140,560),(9,'仙女裙',6,310,680),(10,'RV腰带黑色',7,66,200),(11,'MIU刺绣鞋钻鞋蓝色37',7,95,400),(12,'三拼色呢子大衣',8,600,1200);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-06 22:13:37
