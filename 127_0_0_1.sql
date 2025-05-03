-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 03, 2025 at 12:49 PM
-- Server version: 9.1.0
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `activityphp`
--
CREATE DATABASE IF NOT EXISTS `activityphp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `activityphp`;

-- --------------------------------------------------------

--
-- Table structure for table `appliances_tbl`
--

DROP TABLE IF EXISTS `appliances_tbl`;
CREATE TABLE IF NOT EXISTS `appliances_tbl` (
  `num` int NOT NULL AUTO_INCREMENT,
  `Appliances` varchar(250) NOT NULL,
  `Manufacturer` varchar(250) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `appliances_tbl`
--

INSERT INTO `appliances_tbl` (`num`, `Appliances`, `Manufacturer`, `Date`) VALUES
(1, 'Air Purifier', 'chi', '2018-01-02'),
(2, 'Fan', 'Kawasaki', '2019-01-02'),
(3, 'Fan', 'Kawasaki', '2019-01-02'),
(4, 'Fan', 'Kawasaki', '2019-01-02'),
(5, 'Electric', 'Pinoy', '2020-01-02');
--
-- Database: `dbappdet`
--
CREATE DATABASE IF NOT EXISTS `dbappdet` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `dbappdet`;
--
-- Database: `db_android_login`
--
CREATE DATABASE IF NOT EXISTS `db_android_login` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `db_android_login`;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_index` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'usertest1', 'passtest1');

-- --------------------------------------------------------

--
-- Table structure for table `user_credentials`
--

DROP TABLE IF EXISTS `user_credentials`;
CREATE TABLE IF NOT EXISTS `user_credentials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `typeRegister` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `umak_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `umak_email_index` (`umak_email`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_credentials`
--

INSERT INTO `user_credentials` (`id`, `firstName`, `lastName`, `typeRegister`, `umak_email`) VALUES
(1, 'Cezar Dominic', 'Teope', 'STUDENT', 'cteope.a12344977@uma');
--
-- Database: `testinglangaa`
--
CREATE DATABASE IF NOT EXISTS `testinglangaa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `testinglangaa`;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `num` int NOT NULL AUTO_INCREMENT,
  `stud` varchar(250) NOT NULL,
  `sect` varchar(250) NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`num`, `stud`, `sect`) VALUES
(1, 'Kris Bading', 'II-A NETAD'),
(2, 'Gay Cynric', 'II-A NETAD'),
(3, 'GAE 1', 'II-A NETAD'),
(4, 'GAE2', 'II-A NETAD'),
(5, 'Gay3', 'II-A NETAD'),
(6, 'Gay3', 'II-A NETAD'),
(7, 'Gay4', 'II-A NETAD'),
(8, 'Gay5', 'II-A NETAD'),
(9, 'Gay5', 'II-A NETAD'),
(10, 'Gay6', 'II-A NETAD'),
(11, 'Gay6', 'II-A NETAD'),
(12, 'Gay6', 'II-A NETAD'),
(13, 'Gay7', 'II-A NETAD'),
(29, 'Gay11', 'II-A NETAD'),
(28, 'Gay10', 'II-A NETAD'),
(27, 'Gay9', 'II-A NETAD'),
(26, 'Gay8', 'II-A NETAD');
--
-- Database: `umakgymreserve_db`
--
CREATE DATABASE IF NOT EXISTS `umakgymreserve_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `umakgymreserve_db`;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `number` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `user` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
