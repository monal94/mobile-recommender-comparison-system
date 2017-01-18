-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2015 at 05:50 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `apple`
--
CREATE TABLE IF NOT EXISTS `apple` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `featurephones`
--
CREATE TABLE IF NOT EXISTS `featurephones` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `lg`
--
CREATE TABLE IF NOT EXISTS `lg` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `micromax`
--
CREATE TABLE IF NOT EXISTS `micromax` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Table structure for table `mobile`
--

CREATE TABLE IF NOT EXISTS `mobile` (
  `MOBILE_ID` varchar(20) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `COMPANY` varchar(20) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `LAUNCH_DATE` varchar(20) DEFAULT NULL,
  `DISP_SIZE` varchar(20) DEFAULT NULL,
  `RESOLUTION` varchar(20) DEFAULT NULL,
  `OS` varchar(20) DEFAULT NULL,
  `CPU` varchar(20) DEFAULT NULL,
  `MEMORY` varchar(20) DEFAULT NULL,
  `RAM` varchar(20) DEFAULT NULL,
  `CAMERA_FRONT` varchar(20) DEFAULT NULL,
  `CAMERA_BACK` varchar(20) DEFAULT NULL,
  `BATTERY` varchar(20) DEFAULT NULL,
  `BLUETOOTH` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobile`
--

INSERT INTO `mobile` (`MOBILE_ID`, `NAME`, `COMPANY`, `TYPE`, `LAUNCH_DATE`, `DISP_SIZE`, `RESOLUTION`, `OS`, `CPU`, `MEMORY`, `RAM`, `CAMERA_FRONT`, `CAMERA_BACK`, `BATTERY`, `BLUETOOTH`) VALUES
('1100', 'Nokia 1100', 'Nokia', 'Feature Phone', 'Nov 2004', '2.1', 'N/A', 'SYMBIAN', 'N/A', '128MB', 'N/A', 'N/A', 'N/A', '300mAH', 'NO'),
('1325', 'Zensus m1', 'Zensus', 'multemedia', 'May 15', '4.8', '245', 'Android', '1.2Ghz', '2.5GB', '1GB', 'N/A', 'N/A', '1000mAh', '3.0'),
('2100', 'Nokia 2100', 'Nokia', 'Multimedia Phone', 'Nov 2010', '2.1', 'N/A', 'SYMBIAN', 'N/A', '100MB', 'N/A', 'N/A', 'N/A', '300mAH', 'NO'),
('3100', 'Nokia 3100', 'Nokia', 'Multimedia Phone', 'Nov 2005', '4.1', 'N/A', 'SYMBIAN', 'N/A', '250MB', 'N/A', 'N/A', '5MP', '3000mAH', 'N/A'),
('87pio', 'Pico', 'Micromax', 'feature phone', 'jun 2005', '3', '198', 'N/A', 'N/A', '128KB', 'N/A', 'N/A', '5MP', '2000mAh', '3.2'),
('968kik', 'kik', 'Micromax', 'smart phone', 'Aug 2012', '4', '368', 'Android', '2.4Ghz', '28GB', '2GB', '2MP', '13MP', '4000mAh', '4.0'),
('986poj', 'picachu', 'Chini', 'feature phone', 'Sep 2005', '3.5', '250', 'N/A', 'N/A', '180KB', 'N/A', '0.2MP', '5MP', '3000mAh', 'N/A'),
('A950', 'Samsung Grand', 'Samsung', 'Smart Phone', 'Nov 2014', '5', '330', 'Andorid 5.1.1', '1.5 GHz', '16 GB', '2 GB', '8 MP', '1.3 MP', '2100 mAh', '4.1'),
('e2132', 'Nokia E', 'Nokia', 'Smart Phone', 'Jan 2000', '3.0', '158', 'N/A', 'N/A', '258MB', 'N/A', 'N/A', '2MP', '2000mAh', '2.5'),
('E950', 'Nexus 4', 'LG', 'Smart Phone', 'Nov 2013', '4.7', '340', 'Andorid 5.1.1', '1.5 GHz', '16 GB', '2 GB', '8 MP', '1.3 MP', '2100 mAh', '4.1'),
('h4567', 'MixmH', 'Mixm', 'Feature Phone', 'Jan 2000', 'N/A', 'N/A', 'N/A', 'N/A', '128KB', 'N/A', 'N/A', 'N/A', '500mAH', 'N/A'),
('hit340', 'Himalaya', 'Zen', 'smart phone', 'Dec 2010', '4', '220', 'Android', '2.5Ghz', '200MB', '1GB', '2MP', '5MP', '2000mAh', '3.0'),
('i5', 'IPHONE 5', 'Apple', 'Smart Phone', 'Dec 2012', '4.1', '331', 'iOS', '1.2', '16 GB', '1GB', '1.3MP', '8.1MP', '1750 mAH', '2.0'),
('iphone 4s', 'iphone 4', 'Apple', 'smart phone', 'July 2005', '4.3', '542', 'iOS5', '2Ghz', '5GB', '2GB', '0.2MP', '5MP', '3000mAh', '3.2'),
('M123', 'ABC', 'Samsung', 'Smart Phone', 'Nov 2014', '4.7', '220', 'Android', '1.5 GHz', '32 GB', '2 GB', '8 MP', '1.3 MP', '3000 mAh', '4.0'),
('M234', 'REDMI 1S', 'XIAOMI', 'Smart Phone', 'May 2015', '4.8', '321', 'Android 5.1', '1 GHz', '16 GB', '1 GB', '8 MP', '8 MP', '2000 mAh', '4.0'),
('MT120', 'Xperia Sola', 'Samsung', 'Smart Phone', 'Nov 2014', '5', '330', 'Andorid 5.1.1', '1.5 GHz', '16 GB', '2 GB', '8 MP', '1.3 MP', '2100 mAh', '4.1'),
('N66', 'NOKIA 6600', 'NOKIA', 'Multimedia Phone', 'NOV 2005', '3.4', '100', 'SYMBIAN', '', '256MB', '128KB', 'NO', '2MP', '1500', '1.3'),
('O297', 'ONE PLUS ONE', 'ONE', 'Smart Phone', 'May 2015', '5.2', '321', 'Android 5.1', '1.5 GHz', '16 GB', '4 GB', '8 MP', '13 MP', '3500 mAh', '4.1'),
('p9868', 'Samsung P', 'Samsung', 'Feature Phone', 'Feb 2001', '5', 'N/A', 'N/A', 'N/A', '512MB', 'N/A', 'N/A', '5MP', '1000mAh', 'N/A'),
('S124', 'STAR NXT', 'ZEUS', 'Multimedia Phone', 'JAN 2009', '4.0', '150', 'BADA', '0.8 GHZ', '512MB', '100MB', 'N/A', '2MP', '1500mAH', '1.9'),
('ST258', 'Xperia S', 'Sony', 'Smart Phone', 'Feb 2014', '4', '295', 'Andorid 4.2.2', '1 GHz', '6 GB', '512MB', '0.2 MP', '5 MP', '2100 mAh', '4.0'),
('xi98', 'RedMi', 'Xiaomi', 'Smart Phone', 'Feb 2005', '5', '1252', 'Android', '2Ghz', '5GB', '2GB', '2MP', '2.8MP', '2000mAH', '2.0'),
('Yu589', 'Yurekamh', 'Micromax', 'Smart Phone', 'Jan 2015', '6', '550', 'Android', '2.5Ghz', '16GB', '2GB', '5MP', '15MP', '3500mAH', '4.0');

-- --------------------------------------------------------

--
-- Stand-in structure for view `multimediaphones`
--
CREATE TABLE IF NOT EXISTS `multimediaphones` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `nokia`
--
CREATE TABLE IF NOT EXISTS `nokia` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `oneplus`
--
CREATE TABLE IF NOT EXISTS `oneplus` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `samsung`
--
CREATE TABLE IF NOT EXISTS `samsung` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE IF NOT EXISTS `seller` (
  `SELLER_ID` varchar(20) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `REVIEWS` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`SELLER_ID`, `NAME`, `EMAIL`, `PHONE`, `ADDRESS`, `REVIEWS`) VALUES
('', '', '', '', '', NULL),
('s1', 'ABC', 'abc@yahoo.com', '9645252', 'Delhi', 'positive'),
('s123', 'Ramcharan', 'ram.phones@gmail.com', '9658214732', 'Uttam Nagar Delhi', 'Positive'),
('s124', 'Praveen', 'praveen.jai@gmail.com', '9773214568', 'Navada', 'good'),
('s1243', 'Suresh', 'suresh@outlook.com', '9771425486', 'Moti Nagar', 'Very good'),
('s145', 'Rakesh', 'rakesh@hotmail.com', '9935461478', 'Nangloi', 'Negative'),
('s154', 'Aanand', 'aanand@gmail.com', '9935648712', 'Karol Bagh', 'Very good'),
('s1965', 'Sagar', 'sagarrastogi@gmail.com', '9999965478', 'Bwana Delhi ', 'Very Good'),
('s2013', 'Aakash', 'aakash@gmail.com', '9978452011', 'Civil line', 'Negative'),
('s213', 'Ritvik', 'ritvik@yahoo.com', '9958632145', 'Janakpuri', 'Good'),
('s2145', 'Jaiprakash', 'jai.prakash@hotmail.com', '9865478521', 'Patel Nagar', 'Positive'),
('s234', 'Hitesh', 'h@gmail.com', '4567891235', 'delhi', 'positive'),
('s250', 'Vikas', 'vikas@yahoo.in', '7568963214', 'KAshmiri Gate Delhi', 'Negative'),
('s256', 'Hariom', 'hari.om@outlook.com', '9715483546', 'Uttam Nagar', 'Negative'),
('s265', 'Prateek', 'prateek@yahoo.com', '9865758968', 'Rajender Nagar', 'Very good'),
('s465', 'Manish', 'manish@outlook.com', '882456275', 'Pitampura', 'Positive'),
('s478', 'jitender', 'jitender@hotmail.com', '8856321479', 'JAnak Puri Dist. Centre Delhi', 'Very Good'),
('s524', 'Nitish', 'nitish@hotmail.com', '9968321475', 'Sadar Bazar', 'Possitive'),
('s546', 'Ritesh', 'ritesh@hotmail.com', '8824567563', 'Model Town', 'Very good'),
('s569', 'Ramesh', 'ramesh@gmail.com', '965863217', 'Nangloi Near MEtro Pillar 986', 'Excellent'),
('s657', 'Nitish', 'nitish@gmail.com', '8653214703', 'Cicil lines Delhi 85', 'Very Good'),
('s6767', 'Aanand', 'aanand@gmail.com', '9936547824', 'Larol Bagh', 'Positive'),
('s752', 'Dinbandhu', 'dinbhandhu@gmail.com', '88569321025', 'Sham Nath Marg Civil lines Delhi', 'Good'),
('s759', 'Subhash', 'subhas@gmail.com', '9658741236', 'Rajouri Garden Delhi', 'Good'),
('s785', 'Himanshu', 'him.cool@gmail.com', '8802365471', 'Janak puri Delhi Near Metro pillar number 720', 'Poor'),
('s8520', 'Rahul Communications', 'Rahul@gmail.com', '8854712369', 'Stree No. 4 BhajanPura Delhi', 'Good'),
('s8569', 'Nitesh Yadav', 'nitesh@gmail.com', '9658741235', 'Dwarka Sec 4', 'Positive'),
('s985', 'Dinesh Comm', 'dinesh@yahoo.com', '9568685745', 'Najafgarh Delhi', 'good'),
('s987', 'Gopi Communication', 'gopi@hcl.com', '9865321470', 'Chandni Chowk Delhi 6', 'Good');

-- --------------------------------------------------------

--
-- Table structure for table `sells`
--

CREATE TABLE IF NOT EXISTS `sells` (
  `SELLER_ID` varchar(20) NOT NULL,
  `MOBILE_ID` varchar(20) NOT NULL,
  `PRICE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sells`
--

INSERT INTO `sells` (`SELLER_ID`, `MOBILE_ID`, `PRICE`) VALUES
('s124', '1100', '850'),
('s123', '1100', '800'),
('s123', 'i5', '32000'),
('s1243', 'i5', '31000'),
('s124', 'i5', '35000'),
('s657', 'E950', '19000'),
('s1243', 'E950', '21000'),
('s785', 'M234', '7500'),
('s759', 'M234', '7000'),
('s8520', 'x198', '6000'),
('s265', 'x198', '5499'),
('s6767', '2100', '2200'),
('s785', '2100', '2500'),
('s213', 'O297', '24000'),
('s123', 'O297', '21999'),
('s124', 'N66', '6500'),
('s785', 'N66', '6100'),
('s234', '1100', '850');

-- --------------------------------------------------------

--
-- Stand-in structure for view `smartphones`
--
CREATE TABLE IF NOT EXISTS `smartphones` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `sony`
--
CREATE TABLE IF NOT EXISTS `sony` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `xiaomi`
--
CREATE TABLE IF NOT EXISTS `xiaomi` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `zensus`
--
CREATE TABLE IF NOT EXISTS `zensus` (
`MOBILE_ID` varchar(20)
,`NAME` varchar(30)
,`COMPANY` varchar(20)
,`TYPE` varchar(20)
,`LAUNCH_DATE` varchar(20)
,`DISP_SIZE` varchar(20)
,`RESOLUTION` varchar(20)
,`OS` varchar(20)
,`CPU` varchar(20)
,`MEMORY` varchar(20)
,`RAM` varchar(20)
,`CAMERA_FRONT` varchar(20)
,`CAMERA_BACK` varchar(20)
,`BATTERY` varchar(20)
,`BLUETOOTH` varchar(30)
);
-- --------------------------------------------------------

--
-- Structure for view `apple`
--
DROP TABLE IF EXISTS `apple`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `apple` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Apple'));

-- --------------------------------------------------------

--
-- Structure for view `featurephones`
--
DROP TABLE IF EXISTS `featurephones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `featurephones` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`TYPE` = 'Feature Phone'));

-- --------------------------------------------------------

--
-- Structure for view `lg`
--
DROP TABLE IF EXISTS `lg`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lg` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'LG'));

-- --------------------------------------------------------

--
-- Structure for view `micromax`
--
DROP TABLE IF EXISTS `micromax`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `micromax` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Micromax'));

-- --------------------------------------------------------

--
-- Structure for view `multimediaphones`
--
DROP TABLE IF EXISTS `multimediaphones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `multimediaphones` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`TYPE` = 'Multimedia Phone'));

-- --------------------------------------------------------

--
-- Structure for view `nokia`
--
DROP TABLE IF EXISTS `nokia`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `nokia` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Nokia'));

-- --------------------------------------------------------

--
-- Structure for view `oneplus`
--
DROP TABLE IF EXISTS `oneplus`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `oneplus` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'One'));

-- --------------------------------------------------------

--
-- Structure for view `samsung`
--
DROP TABLE IF EXISTS `samsung`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `samsung` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Samsung'));

-- --------------------------------------------------------

--
-- Structure for view `smartphones`
--
DROP TABLE IF EXISTS `smartphones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `smartphones` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`TYPE` = 'Smart Phone'));

-- --------------------------------------------------------

--
-- Structure for view `sony`
--
DROP TABLE IF EXISTS `sony`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sony` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Sony'));

-- --------------------------------------------------------

--
-- Structure for view `xiaomi`
--
DROP TABLE IF EXISTS `xiaomi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `xiaomi` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Xiomi'));

-- --------------------------------------------------------

--
-- Structure for view `zensus`
--
DROP TABLE IF EXISTS `zensus`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `zensus` AS (select `mobile`.`MOBILE_ID` AS `MOBILE_ID`,`mobile`.`NAME` AS `NAME`,`mobile`.`COMPANY` AS `COMPANY`,`mobile`.`TYPE` AS `TYPE`,`mobile`.`LAUNCH_DATE` AS `LAUNCH_DATE`,`mobile`.`DISP_SIZE` AS `DISP_SIZE`,`mobile`.`RESOLUTION` AS `RESOLUTION`,`mobile`.`OS` AS `OS`,`mobile`.`CPU` AS `CPU`,`mobile`.`MEMORY` AS `MEMORY`,`mobile`.`RAM` AS `RAM`,`mobile`.`CAMERA_FRONT` AS `CAMERA_FRONT`,`mobile`.`CAMERA_BACK` AS `CAMERA_BACK`,`mobile`.`BATTERY` AS `BATTERY`,`mobile`.`BLUETOOTH` AS `BLUETOOTH` from `mobile` where (`mobile`.`COMPANY` = 'Zensus'));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobile`
--
ALTER TABLE `mobile`
 ADD PRIMARY KEY (`MOBILE_ID`);

--
-- Indexes for table `seller`
--
ALTER TABLE `seller`
 ADD PRIMARY KEY (`SELLER_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
