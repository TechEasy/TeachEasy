start transaction;

drop database if exists `TeachEasy`;
create database `TeachEasy`;

use `TeachEasy`;

create user 'acme-user'@'%' identified by password '*4F10007AADA9EE3DBB2CC36575DFC6F4FDE27577';
create user 'acme-manager'@'%' identified by password '*FDB8CD304EB2317D10C95D797A4BD7492560F55F';

grant select, insert, update, delete
	on `TeachEasy`.* to 'acme-user'@'%';

grant select, insert, update, delete, create, drop, references, index, alter, 
        create temporary tables, lock tables, create view, create routine, 
        alter routine, execute, trigger, show view
	 on `Acme-Pad-Thai`.* to 'acme-manager'@'%';





-- MySQL dump 10.13  Distrib 5.5.29, for Win64 (x86)
--
-- Host: localhost    Database: TeachEasy
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `academy`
--

DROP TABLE IF EXISTS `academy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academy` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avgStars` double DEFAULT NULL,
  `cif` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `feeAmount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paypalMail` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `userAccount_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ae6mrfke5ikqsinq6dx38dy8m` (`userAccount_id`),
  CONSTRAINT `FK_ae6mrfke5ikqsinq6dx38dy8m` FOREIGN KEY (`userAccount_id`) REFERENCES `useraccount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academy`
--

LOCK TABLES `academy` WRITE;
/*!40000 ALTER TABLE `academy` DISABLE KEYS */;
INSERT INTO `academy` VALUES (37,0,'Calle General Prim',3,'CIF152','Sevilla','Somos una academia especializada en Matematicas',200,'Academia de los numeros','academiaNumeros@gmail.com','https://pbs.twimg.com/profile_images/664478201725526016/tno78YbX.jpg',8),(38,0,'Calle Botica',5,'CIF45698','Granada','Academia de dibujo',560,'EzDraw','ezdraw@gmail.com','http://www.ediciona.com/portafolio/image/0/4/2/6/logo_llapis_i_paper_6240.jpg',9),(39,0,'Calle Maritima',4.2,'CIF55220','Cádiz','Academia de idiomas',450,'Languages Academy','academiaidiomas@gmail.com','http://www.srsanchez.es/wp-content/uploads/2013/12/logo-global-languaje.jpg',10);
/*!40000 ALTER TABLE `academy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `userAccount_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cgls5lrufx91ufsyh467spwa3` (`userAccount_id`),
  CONSTRAINT `FK_cgls5lrufx91ufsyh467spwa3` FOREIGN KEY (`userAccount_id`) REFERENCES `useraccount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `userAccount_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_idt4b4u259p6vs4pyr9lax4eg` (`userAccount_id`),
  CONSTRAINT `FK_idt4b4u259p6vs4pyr9lax4eg` FOREIGN KEY (`userAccount_id`) REFERENCES `useraccount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (27,0,'Calle Sanlucar la Mayor Bloque 7','Sevilla','1982-04-03 00:00:00','simantant@gmail.com','Simón','654123852','http://stawamuschiefpark.com/wp-content/uploads/2014/12/avatar-300x300.png','Antón Antunez',1);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `createMoment` datetime DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `academy_id` int(11) DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nnflthuefryvskgcyd8jj9ry` (`academy_id`),
  KEY `FK_shk7ebucipmiqnoe05wrtr371` (`student_id`),
  KEY `FK_2qx823oe5qoub3xfghcfhgye3` (`teacher_id`),
  CONSTRAINT `FK_2qx823oe5qoub3xfghcfhgye3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FK_nnflthuefryvskgcyd8jj9ry` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`),
  CONSTRAINT `FK_shk7ebucipmiqnoe05wrtr371` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (78,0,'2017-02-04 20:00:00',3,'Podría asistir a otra hora?','Comentario sobre teacher1',NULL,34,28),(79,0,'2017-03-04 20:00:00',3,'Hola teacher2','Comentario sobre teacher2',NULL,34,30),(80,0,'2017-03-04 20:00:00',3,'¿Podrían darme un numero de contacto?','Comentario sobre academia 1',37,34,NULL),(81,0,'2017-11-04 20:00:00',5,'Gran clase, me sirvió de mucho','Comentario sobre academy2',38,35,NULL),(82,0,'2017-02-04 20:00:00',5,'Nice academy. Guess im improving my english level','Comentario sobre academy3',39,36,NULL),(83,0,'2017-03-04 20:00:00',4,'Hola teacher3, gracias por la clase','Comentario sobre teacher3',NULL,34,32),(84,0,'2017-03-04 20:00:00',3,'¿Podrían darme un numero de contacto?','Comentario sobre academia 1',37,35,NULL),(85,0,'2017-11-04 20:00:00',5,'Muy buena academia de numeros','Comentario sobre academy1',37,34,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `createMoment` datetime DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updateMoment` datetime DEFAULT NULL,
  `subjectMatter_id` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `academy_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qa387lq6ajdnxxcqj2stkmt7v` (`ticker`),
  KEY `FK_bc9ifd1hhxpnv9se06pofu6sx` (`academy_id`),
  KEY `FK_htgo2cor10nf9heefu41ied1e` (`subjectMatter_id`),
  CONSTRAINT `FK_bc9ifd1hhxpnv9se06pofu6sx` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`),
  CONSTRAINT `FK_htgo2cor10nf9heefu41ied1e` FOREIGN KEY (`subjectMatter_id`) REFERENCES `subjectmatter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (60,0,'2017-10-04 20:00:00',4,'07','Matematicas','2017-10-04 21:00:00',53,2,'4º ESO',37),(61,0,'2017-05-05 20:00:00',4,'08','Algebra','2017-05-05 21:00:00',49,2,'Bachillerato',37),(62,0,'2017-05-05 20:00:00',5,'09','Dibujo','2017-05-05 21:00:00',52,3,'Bachillerato',38),(63,0,'2017-05-05 20:00:00',5,'10','Ingles','2017-05-05 21:00:00',44,3,'B2',39),(64,0,'2017-05-05 20:00:00',4,'11','Frances','2017-05-05 21:00:00',45,4,'B1',39);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curricula`
--

DROP TABLE IF EXISTS `curricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curricula` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `educationSection` varchar(255) DEFAULT NULL,
  `experienceSection` varchar(255) DEFAULT NULL,
  `hobbiesSection` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curricula`
--

LOCK TABLES `curricula` WRITE;
/*!40000 ALTER TABLE `curricula` DISABLE KEYS */;
INSERT INTO `curricula` VALUES (29,0,'He cursado Ingeniería Informática del Software en Sevilla','He estado trabjando 10 años en Everis','Me gusta leer comics'),(31,0,'Tengo c1 en Inglés y Francés','Trabajando 10 años en un hotel de Inglaterra','Me gustan muchos los niños'),(33,0,'He cursado Educación Infantil','He estado trabjando en el colegio Joaquín García','Me gustan los videojuegos');
/*!40000 ALTER TABLE `curricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day`
--

DROP TABLE IF EXISTS `day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day`
--

LOCK TABLES `day` WRITE;
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
INSERT INTO `day` VALUES (19,0,'Lunes'),(20,0,'Martes'),(21,0,'Miercoles'),(22,0,'Jueves'),(23,0,'Viernes');
/*!40000 ALTER TABLE `day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day_worktime`
--

DROP TABLE IF EXISTS `day_worktime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_worktime` (
  `Day_id` int(11) NOT NULL,
  `workTimes_id` int(11) NOT NULL,
  UNIQUE KEY `UK_pt6mca0aytj5k30oskvbu2d2s` (`workTimes_id`),
  KEY `FK_96moebmcciph8o6n1pjoreqx5` (`Day_id`),
  CONSTRAINT `FK_96moebmcciph8o6n1pjoreqx5` FOREIGN KEY (`Day_id`) REFERENCES `day` (`id`),
  CONSTRAINT `FK_pt6mca0aytj5k30oskvbu2d2s` FOREIGN KEY (`workTimes_id`) REFERENCES `worktime` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_worktime`
--

LOCK TABLES `day_worktime` WRITE;
/*!40000 ALTER TABLE `day_worktime` DISABLE KEYS */;
INSERT INTO `day_worktime` VALUES (19,11),(19,12),(20,13),(20,14),(21,15),(21,16),(22,17),(23,18);
/*!40000 ALTER TABLE `day_worktime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finder`
--

DROP TABLE IF EXISTS `finder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finder` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `matter` varchar(255) DEFAULT NULL,
  `maximumPrice` double DEFAULT NULL,
  `minimumPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finder`
--

LOCK TABLES `finder` WRITE;
/*!40000 ALTER TABLE `finder` DISABLE KEYS */;
INSERT INTO `finder` VALUES (77,0,'Sevilla','english','English',20,10);
/*!40000 ALTER TABLE `finder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finder_rclass`
--

DROP TABLE IF EXISTS `finder_rclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finder_rclass` (
  `Finder_id` int(11) NOT NULL,
  `results_id` int(11) NOT NULL,
  UNIQUE KEY `UK_addo01wnl3qfvgkaepf3ur41e` (`results_id`),
  KEY `FK_14l0jspk5synxp42a3qqtdrmp` (`Finder_id`),
  CONSTRAINT `FK_14l0jspk5synxp42a3qqtdrmp` FOREIGN KEY (`Finder_id`) REFERENCES `finder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finder_rclass`
--

LOCK TABLES `finder_rclass` WRITE;
/*!40000 ALTER TABLE `finder_rclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `finder_rclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('DomainEntity',1);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `authoredMoment` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `vatNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (72,0,'2017-03-03 16:00:00','No hay detalles importantes que mostrar','Invoice realizado para el student 1',150,'000000001'),(73,0,'2016-12-12 16:00:00','Se ha pagado al completo','Segundo invoice realizado para el student 1',15,'000000010'),(74,0,'2016-10-10 16:00:00','Se ha pagado tarde','Invoice del student 2',30,'000000011'),(75,0,'2016-11-10 16:00:00','Se ha pagado al completo','Invoice del student 1',40,'000000111'),(76,0,'2016-12-10 16:00:00','Se ha pagado al completo','Invoice del student 2',50,'000001011');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposal`
--

DROP TABLE IF EXISTS `proposal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proposal` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `createMoment` datetime DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updateMoment` datetime DEFAULT NULL,
  `subjectMatter_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_palmm6k8kdw7a6r4jm9ona49b` (`ticker`),
  KEY `FK_2jc8xfdgpkg1o1tc98cpmpb38` (`teacher_id`),
  KEY `FK_kye2xh9rq5yvj90is66vkxekw` (`subjectMatter_id`),
  CONSTRAINT `FK_2jc8xfdgpkg1o1tc98cpmpb38` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FK_kye2xh9rq5yvj90is66vkxekw` FOREIGN KEY (`subjectMatter_id`) REFERENCES `subjectmatter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposal`
--

LOCK TABLES `proposal` WRITE;
/*!40000 ALTER TABLE `proposal` DISABLE KEYS */;
INSERT INTO `proposal` VALUES (54,0,'2017-01-04 20:00:00',12,'01','Clases de Inglés','2017-01-04 21:00:00',44,28),(55,0,'2017-12-04 20:00:00',4,'03','Clases de Francés','2017-12-04 21:00:00',45,28),(56,0,'2017-03-04 20:00:00',5,'02','Clases de Programacion','2017-03-04 21:00:00',46,30),(57,0,'2017-12-04 20:00:00',4,'04','Clases de HTML y CSS','2017-12-04 21:00:00',50,30),(58,0,'2017-12-04 20:00:00',4,'05','Clases de Fisica','2017-12-04 21:00:00',47,32),(59,0,'2017-12-04 20:00:00',5,'06','Clases de Quimica','2017-12-04 21:00:00',48,32);
/*!40000 ALTER TABLE `proposal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rclass`
--

DROP TABLE IF EXISTS `rclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rclass` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `createMoment` datetime DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updateMoment` datetime DEFAULT NULL,
  `subjectMatter_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1uphs78rkuu39tdbumgwbeoj1` (`ticker`),
  KEY `FK_4vch5koxxrmtjl1qqdfjqdv41` (`subjectMatter_id`),
  CONSTRAINT `FK_4vch5koxxrmtjl1qqdfjqdv41` FOREIGN KEY (`subjectMatter_id`) REFERENCES `subjectmatter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rclass`
--

LOCK TABLES `rclass` WRITE;
/*!40000 ALTER TABLE `rclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `rclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `checkIn` varchar(255) DEFAULT NULL,
  `checkOut` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `rclass_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g4m6p32gsyfqxeympot7hnam1` (`invoice_id`),
  KEY `FK_i0fb2ggwjb79hifdb8k0xwjxl` (`student_id`),
  CONSTRAINT `FK_g4m6p32gsyfqxeympot7hnam1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `FK_i0fb2ggwjb79hifdb8k0xwjxl` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (65,6,'04/04/2017 14:45','04/04/2017 15:10','ACCEPTED',72,54,34),(66,0,'10/04/2017 15:00','10/04/2017 16:00','PENDING',NULL,60,35),(67,0,'15/03/2017 15:00','15/04/2017 16:00','DENIED',NULL,54,35),(68,1,'05/04/2017 15:00','05/04/2017 16:00','ACCEPTED',73,55,34),(69,1,'06/04/2017 15:00','06/04/2017 16:00','ACCEPTED',74,56,35),(70,1,'04/03/2017 15:00','04/03/2017 16:00','ACCEPTED',75,57,34),(71,1,'07/05/2017 15:00','07/05/2017 17:00','ACCEPTED',76,58,35);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialidentity`
--

DROP TABLE IF EXISTS `socialidentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socialidentity` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `nick` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(255) DEFAULT NULL,
  `socialNetwork` varchar(255) DEFAULT NULL,
  `academy_id` int(11) DEFAULT NULL,
  `actor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_brkdx34hqt39d1yd00a2l90qx` (`academy_id`),
  CONSTRAINT `FK_brkdx34hqt39d1yd00a2l90qx` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialidentity`
--

LOCK TABLES `socialidentity` WRITE;
/*!40000 ALTER TABLE `socialidentity` DISABLE KEYS */;
INSERT INTO `socialidentity` VALUES (40,0,'admin1','https://twitter.com/admin1','Twitter',NULL,27),(41,0,'student1','https://twitter.com/student1','Twitter',NULL,34),(42,0,'teacher1','https://twitter.com/teacher1','Twitter',NULL,28),(43,0,'academyNumber1','https://twitter.com/academy1','Twitter',37,NULL);
/*!40000 ALTER TABLE `socialidentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `userAccount_id` int(11) NOT NULL,
  `finder_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1wi576q4evovlcg3tygsmdw1p` (`userAccount_id`),
  KEY `FK_bwdn286ot7e63dc04u3nlad3s` (`finder_id`),
  CONSTRAINT `FK_1wi576q4evovlcg3tygsmdw1p` FOREIGN KEY (`userAccount_id`) REFERENCES `useraccount` (`id`),
  CONSTRAINT `FK_bwdn286ot7e63dc04u3nlad3s` FOREIGN KEY (`finder_id`) REFERENCES `finder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (34,1,'Calle Silos','Sevilla','1994-12-01 00:00:00','antiñijae@gmail.com','Antonio','654126547','https://cdn2.iconfinder.com/data/icons/danger-problems/512/anonymous-512.png','Iñigo Jaén',5,77),(35,0,'Marqués de Valdecañas','Málaga','2000-09-03 00:00:00','juamenmil@gmail.com','Juan','694123447','https://cdn2.iconfinder.com/data/icons/users-6/100/USER1-512.png','Mendizábal Millán',6,NULL),(36,0,'Calle Malasmañanas','Sevilla','1999-04-03 00:00:00','fraramque@gmail.com','Francisco','654126547','https://cdn2.iconfinder.com/data/icons/users-6/100/USER7-512.png','Ramirez Quero',7,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectmatter`
--

DROP TABLE IF EXISTS `subjectmatter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjectmatter` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `validated` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectmatter`
--

LOCK TABLES `subjectmatter` WRITE;
/*!40000 ALTER TABLE `subjectmatter` DISABLE KEYS */;
INSERT INTO `subjectmatter` VALUES (44,0,'Clases de Inglés','Inglés',''),(45,0,'Clases de Francés','Francés',''),(46,0,'Programación orientada a objetos','Programación',''),(47,0,'Clases de Fisica','Fisica',''),(48,0,'Clases de Quimica','Quimica',''),(49,0,'Clases de Algebra','Algebra',''),(50,0,'Clases de HTML y CSS','HTMLCSS',''),(51,0,'Clases de Historia','Historia',''),(52,0,'Clases de Dibujo','Dibujo',''),(53,0,'Clases de Matematicas','Matematicas','');
/*!40000 ALTER TABLE `subjectmatter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `userAccount_id` int(11) NOT NULL,
  `avgStars` double DEFAULT NULL,
  `feeAmount` double DEFAULT NULL,
  `paypalMail` varchar(255) DEFAULT NULL,
  `curricula_id` int(11) DEFAULT NULL,
  `timeTable_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hh7bf6toh1ysrkeqxhr1077dv` (`userAccount_id`),
  KEY `FK_hk6lhly9g3k54cnrc44wow98h` (`curricula_id`),
  KEY `FK_ac2cti2cbblfs4ji7rbmb7vx3` (`timeTable_id`),
  CONSTRAINT `FK_ac2cti2cbblfs4ji7rbmb7vx3` FOREIGN KEY (`timeTable_id`) REFERENCES `timetable` (`id`),
  CONSTRAINT `FK_hh7bf6toh1ysrkeqxhr1077dv` FOREIGN KEY (`userAccount_id`) REFERENCES `useraccount` (`id`),
  CONSTRAINT `FK_hk6lhly9g3k54cnrc44wow98h` FOREIGN KEY (`curricula_id`) REFERENCES `curricula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (28,0,'Calle Saenz de Tejada','Sevilla','1975-12-01 00:00:00','albcabcan@gmail.com','Alberto','654122347','https://cdn3.iconfinder.com/data/icons/users-6/100/654854-user-women-256.png','Cabrera Cantero',2,2,200,'albcabcan@gmail.com',29,24),(30,0,'Pablo Picaso Portal 11','Granada','1980-12-01 00:00:00','joschaech@gmail.com','José','609822347','http://cyrusindia.com/hrpanel/mriAssets2016/me1.png','Chamorro Echevarria',3,5,1000,'joschaech@gmail.com',31,25),(32,0,'Álamo del Marques','Cadiz','1985-12-01 00:00:00','rauescdon@gmail.com','Raúl','645692347','http://media.keepo.me/keepo.me-cartoon_avatar-male-bald.png','Escribano Donoso',4,3.2,120,'rauescdon@gmail.com',33,26);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (24,0),(25,0),(26,0);
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable_day`
--

DROP TABLE IF EXISTS `timetable_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable_day` (
  `TimeTable_id` int(11) NOT NULL,
  `days_id` int(11) NOT NULL,
  UNIQUE KEY `UK_hpw2u4dj4ltbmorrxulgb4r16` (`days_id`),
  KEY `FK_krdjs1qrfrtmiaq9bi2x81pko` (`TimeTable_id`),
  CONSTRAINT `FK_hpw2u4dj4ltbmorrxulgb4r16` FOREIGN KEY (`days_id`) REFERENCES `day` (`id`),
  CONSTRAINT `FK_krdjs1qrfrtmiaq9bi2x81pko` FOREIGN KEY (`TimeTable_id`) REFERENCES `timetable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable_day`
--

LOCK TABLES `timetable_day` WRITE;
/*!40000 ALTER TABLE `timetable_day` DISABLE KEYS */;
INSERT INTO `timetable_day` VALUES (24,19),(24,21),(25,20),(25,22),(26,23);
/*!40000 ALTER TABLE `timetable_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_csivo9yqa08nrbkog71ycilh5` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` VALUES (1,0,'21232f297a57a5a743894a0e4a801fc3','admin'),(2,0,'41c8949aa55b8cb5dbec662f34b62df3','teacher1'),(3,0,'ccffb0bb993eeb79059b31e1611ec353','teacher2'),(4,0,'82470256ea4b80343b27afccbca1015b','teacher3'),(5,0,'5e5545d38a68148a2d5bd5ec9a89e327','student1'),(6,0,'213ee683360d88249109c2f92789dbc3','student2'),(7,0,'8e4947690532bc44a8e41e9fb365b76a','student3'),(8,0,'2867dc13a84476546c069b33dc859bc7','academy1'),(9,0,'86cbff988e1e889653b316f6695e5e6b','academy2'),(10,0,'526c4e886de557da4a11880c41fe3c0f','academy3');
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount_authorities`
--

DROP TABLE IF EXISTS `useraccount_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount_authorities` (
  `UserAccount_id` int(11) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  KEY `FK_b63ua47r0u1m7ccc9lte2ui4r` (`UserAccount_id`),
  CONSTRAINT `FK_b63ua47r0u1m7ccc9lte2ui4r` FOREIGN KEY (`UserAccount_id`) REFERENCES `useraccount` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount_authorities`
--

LOCK TABLES `useraccount_authorities` WRITE;
/*!40000 ALTER TABLE `useraccount_authorities` DISABLE KEYS */;
INSERT INTO `useraccount_authorities` VALUES (1,'ADMIN'),(2,'TEACHER'),(3,'TEACHER'),(4,'TEACHER'),(5,'STUDENT'),(6,'STUDENT'),(7,'STUDENT'),(8,'ACADEMY'),(9,'ACADEMY'),(10,'ACADEMY');
/*!40000 ALTER TABLE `useraccount_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worktime`
--

DROP TABLE IF EXISTS `worktime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worktime` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `checkIn` varchar(255) DEFAULT NULL,
  `checkOut` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worktime`
--

LOCK TABLES `worktime` WRITE;
/*!40000 ALTER TABLE `worktime` DISABLE KEYS */;
INSERT INTO `worktime` VALUES (11,0,'','09:00','11:00'),(12,0,'\0','11:00','13:00'),(13,0,'','17:00','19:00'),(14,0,'','19:00','21:00'),(15,0,'','10:00','12:00'),(16,0,'','12:00','14:00'),(17,0,'','16:00','18:00'),(18,0,'','18:00','20:00');
/*!40000 ALTER TABLE `worktime` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-03 19:17:04

commit;
