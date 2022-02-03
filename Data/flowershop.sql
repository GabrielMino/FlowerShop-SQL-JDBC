-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-02-2022 a las 12:32:18
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flowershop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `decoration`
--

CREATE TABLE `decoration` (
  `productId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `decoration`
--

INSERT INTO `decoration` (`productId`, `name`, `material`, `price`) VALUES
(6, 'MESA', 'HIERRO', 68);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flower`
--

CREATE TABLE `flower` (
  `productId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `flower`
--

INSERT INTO `flower` (`productId`, `name`, `color`, `price`) VALUES
(10, 'JAZMÍN', 'RED', 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sells`
--

CREATE TABLE `sells` (
  `sellsId` int(11) NOT NULL,
  `products` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`products`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sells`
--

INSERT INTO `sells` (`sellsId`, `products`) VALUES
(1, '[{\"color\":\"RED\",\"productId\":7,\"name\":\"GERANIOS\",\"price\":35.0,\"category\":\"Flower\"},{\"material\":\"MADERA\",\"productId\":2,\"name\":\"SILLA\",\"price\":20.0,\"category\":\"Decoration\"}]'),
(4, '[{\"material\":\"MADERA\",\"productId\":3,\"name\":\"SILLA\",\"price\":30.0,\"category\":\"Decoration\"},{\"height\":130.0,\"productId\":8,\"name\":\"MANDARINO\",\"price\":68.0,\"category\":\"Tree\"}]'),
(5, '[{\"color\":\"GREEN\",\"productId\":11,\"name\":\"HORTENSIA\",\"price\":15.0,\"category\":\"Flower\"},{\"material\":\"PLASTICO\",\"productId\":5,\"name\":\"MESA\",\"price\":60.0,\"category\":\"Decoration\"}]'),
(6, '[{\"color\":\"GREEN\",\"productId\":6,\"name\":\"LAVANDA\",\"price\":12.0,\"category\":\"Flower\"},{\"material\":\"MADERA\",\"productId\":4,\"name\":\"SILLA\",\"price\":50.0,\"category\":\"Decoration\"}]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tree`
--

CREATE TABLE `tree` (
  `productId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tree`
--

INSERT INTO `tree` (`productId`, `name`, `height`, `price`) VALUES
(5, 'NECTARINA', 140, 35),
(9, 'ALMENDRO', 140, 68);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `decoration`
--
ALTER TABLE `decoration`
  ADD PRIMARY KEY (`productId`);

--
-- Indices de la tabla `flower`
--
ALTER TABLE `flower`
  ADD PRIMARY KEY (`productId`);

--
-- Indices de la tabla `sells`
--
ALTER TABLE `sells`
  ADD PRIMARY KEY (`sellsId`);

--
-- Indices de la tabla `tree`
--
ALTER TABLE `tree`
  ADD PRIMARY KEY (`productId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `decoration`
--
ALTER TABLE `decoration`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `flower`
--
ALTER TABLE `flower`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `sells`
--
ALTER TABLE `sells`
  MODIFY `sellsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tree`
--
ALTER TABLE `tree`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
