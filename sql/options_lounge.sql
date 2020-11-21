# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.4.6-MariaDB)
# Database: optionslounge
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table author
# ------------------------------------------------------------

DROP TABLE IF EXISTS `stock_option`;

CREATE TABLE `stock_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `month` varchar(45) DEFAULT NULL,
  `current_price` double DEFAULT NULL,
  `strike_price` double DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `created_ts` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `stock_option` WRITE;
/*!40000 ALTER TABLE `stock_option` DISABLE KEYS */;

INSERT INTO `stock_option` (`id`, `symbol`, `type`, `month`, `current_price`, `strike_price`, `expiration_date`, `created_ts`)
VALUES
	(1,'ABC','CALL','JULY',22.25, 23.0,'2020-07-21','2020-05-21'),
	(2,'ABC','CALL','JULY',22.25, 25.0,'2020-07-21','2020-05-21'),
	(3,'ABC','PUT','JULY',22.25, 23.0,'2020-07-21','2020-05-21'),
	(4,'DXY','CALL','SEPT',150.25, 155.0,'2020-09-21','2020-06-21'),
	(5,'DXY','PUT','SEPT',150.25, 153.0,'2020-09-21','2020-06-21'),
	(6,'DXY','PUT','SEPT',150.25, 152.50,'2020-09-21','2020-06-21'),
	(7,'AAPL','PUT','DEC',200.25, 205.00,'2020-12-21','2020-08-21'),
	(8,'AAPL','PUT','DEC',200.25, 210.00,'2020-12-21','2020-08-21'),
	(9,'AAPL','CALL','DEC',200.25, 215.00,'2020-12-21','2020-08-21'),
	(10,'AAPL','CALL','DEC',200.25, 220.00,'2020-12-21','2020-08-21');

/*!40000 ALTER TABLE `stock_option` ENABLE KEYS */;
UNLOCK TABLES;


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;