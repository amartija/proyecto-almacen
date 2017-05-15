-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-04-2017 a las 17:12:19
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionalmacen`
--
CREATE DATABASE IF NOT EXISTS `gestionalmacen` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestionalmacen`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion`
--

DROP TABLE IF EXISTS `coleccion`;
CREATE TABLE `coleccion` (
  `codigo` int(11) NOT NULL,
  `year` varchar(45) NOT NULL,
  `gama` varchar(45) DEFAULT NULL,
  `tematica` varchar(45) DEFAULT NULL,
  `fEntrada` date NOT NULL,
  `codigo_fabricante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coleccion`
--

INSERT INTO `coleccion` (`codigo`, `year`, `gama`, `tematica`, `fEntrada`, `codigo_fabricante`) VALUES
(1, '2000', 'alta', 'otoño', '2017-12-11', 2),
(2, '2001', 'media', 'invierno', '2016-11-15', NULL),
(3, '2002', 'baja', 'primavera', '2017-04-27', NULL),
(4, '2007', 'Alta', 'Otoño-Invierno', '2017-12-12', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion_prenda`
--

DROP TABLE IF EXISTS `coleccion_prenda`;
CREATE TABLE `coleccion_prenda` (
  `codigo` int(11) NOT NULL,
  `codigo_coleccion` int(11) DEFAULT NULL,
  `codigo_prenda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coleccion_prenda`
--

INSERT INTO `coleccion_prenda` (`codigo`, `codigo_coleccion`, `codigo_prenda`) VALUES
(1, 1, 2),
(2, 4, 1),
(3, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
CREATE TABLE `fabricante` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `personaContacto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `fabricante`
--

INSERT INTO `fabricante` (`codigo`, `nombre`, `telefono`, `ciudad`, `personaContacto`) VALUES
(1, 'zara', '1234567', 'madrid', 'gerente1'),
(2, 'mango', '1234567', 'barcelona', 'gerente2'),
(3, 'pos', '1234567', 'madrid', 'gerente3'),
(4, 'ssgwegtg', 'ss', 'sas', 'sassa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prenda`
--

DROP TABLE IF EXISTS `prenda`;
CREATE TABLE `prenda` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `talla` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `tipoTela` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prenda`
--

INSERT INTO `prenda` (`codigo`, `nombre`, `talla`, `color`, `tipoTela`) VALUES
(1, 'pantalon', 'grande', 'rojo', 'pana'),
(2, 'camisa', 'mediana', 'azul', 'seda'),
(3, 'zapatos', 'pequeña', 'verde', 'cuero'),
(4, 'nuevo', 'nuevo', 'nuevo', 'nuevo'),
(5, 'gwergrr', 'tgrrg', 'wetgtrw', 'wegtg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coleccion`
--
ALTER TABLE `coleccion`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  ADD KEY `fk_codigo_fabricante_idx` (`codigo_fabricante`);

--
-- Indices de la tabla `coleccion_prenda`
--
ALTER TABLE `coleccion_prenda`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  ADD KEY `fk_codigo_coleccion_idx` (`codigo_coleccion`),
  ADD KEY `fk_codigo_prenda_idx` (`codigo_prenda`);

--
-- Indices de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `prenda`
--
ALTER TABLE `prenda`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `coleccion`
--
ALTER TABLE `coleccion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `coleccion_prenda`
--
ALTER TABLE `coleccion_prenda`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `prenda`
--
ALTER TABLE `prenda`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `coleccion`
--
ALTER TABLE `coleccion`
  ADD CONSTRAINT `fk_codigo_fabricante` FOREIGN KEY (`codigo_fabricante`) REFERENCES `fabricante` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `coleccion_prenda`
--
ALTER TABLE `coleccion_prenda`
  ADD CONSTRAINT `fk_codigo_coleccion` FOREIGN KEY (`codigo_coleccion`) REFERENCES `coleccion` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_codigo_prenda` FOREIGN KEY (`codigo_prenda`) REFERENCES `prenda` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
