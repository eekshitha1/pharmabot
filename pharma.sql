-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2020 at 10:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `pharma`
--

CREATE TABLE `pharma` (
  `disease` varchar(20) NOT NULL,
  `medicine` varchar(40) NOT NULL,
  `symptoms` varchar(60) NOT NULL,
  `precautions` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharma`
--

INSERT INTO `pharma` (`disease`, `medicine`, `symptoms`, `precautions`) VALUES
('common cold', 'chlorpheniramine maleate', 'sneeze , watery eyes , nastal congestion', 'wash hands often , avoid touching face , Be clean'),
('fever', 'paracetemol , acetaminophen', 'high temperature , shivering , headache , excessive sweat', 'Be hydrated ,hHave more fluids , be clean'),
('sore throat', 'benzocain , mentholtopical', 'pain in swallowing and talking , red tonsils', 'have lots of fluids and healthy diet ,dont share food'),
('cough', 'dextromethorpham', 'sore throat , shortness in breath, hoarseness', 'gargle with warm salt water regularly, be hydrated'),
('chicken pox', 'acyclovir, privigen', 'small ,itchy blisters, headache, loss of appetite', 'vaccine and limit contact with infected people'),
('measles', 'immune globulin', 'skin rash ,dry cough ,malaise fever ,inflammed eyes', 'MMR Vaccination');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
