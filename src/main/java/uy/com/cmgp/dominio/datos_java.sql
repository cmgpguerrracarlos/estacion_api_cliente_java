-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 20, 2021 at 07:00 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `estacion`
--

-- --------------------------------------------------------

--
-- Table structure for table `datos_java`
--

CREATE TABLE `datos_java` (
  `id_estacion` int(11) NOT NULL,
  `fecha_hora` varchar(20) NOT NULL,
  `temperatura` varchar(10) NOT NULL,
  `presion` varchar(10) NOT NULL,
  `velocidad_viento` varchar(10) NOT NULL,
  `direccion_viento` int(11) NOT NULL,
  `radiacion_solar` int(11) NOT NULL,
  `radiacion_uv` int(11) NOT NULL,
  `humedad` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datos_java`
--
ALTER TABLE `datos_java`
  ADD PRIMARY KEY (`id_estacion`,`fecha_hora`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
