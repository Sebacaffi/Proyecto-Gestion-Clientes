-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2020 a las 04:28:54
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionclientes`
--
CREATE DATABASE `gestionclientes`;
USE `gestionclientes`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `rut` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apaterno` varchar(20) NOT NULL,
  `amaterno` varchar(20) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `telefono` int(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `id_comuna` int(3) NOT NULL,
  `id_estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rut`, `nombre`, `apaterno`, `amaterno`, `genero`, `telefono`, `email`, `direccion`, `id_comuna`, `id_estado`) VALUES
('111-1', 'Gina', 'Gaggero', 'Schivo', 'F', 2346678, 'laginapascuala@gmail.es', 'Agua Santa', 1, 1),
('222-2', 'Sebastián Chascas', 'Caffi', 'Pereira', 'M', 9876453, 'fullfibraoptica@gmail.com', 'cerro mariposas 255', 2, 3),
('333-3', 'Felipe Leonidas', 'Beltrami', 'Caszely', 'M', 133132131, 'bienbellako@gmail.cl', 'Aguas Quéchua 21', 4, 4),
('444-4', 'Alain', 'Maltrain', 'Valdivieso', 'M', 696969696, 'capitanamerica@gyahoo.es', '23 norte 1942', 6, 1),
('555-5', 'Hernán Stark', 'Saavedra', 'González', 'M', 2365793, 'profehernanprofesor.duoc.cl', 'Escudo Directv 1933', 2, 2),
('666-6', 'Felix', 'Diaz', 'Soto', 'M', 3455678, 'fitofeli@yahoo.org', 'Las Nubes 12982', 5, 5),
('777-7', 'chihau San', 'Chau', 'Muñoz', 'M', 38774332, 'elplofe@google.com', 'Palo Alto, Silicón Valley', 10, 4),
('888-8', 'Ana', 'Rozas', 'Jeria', 'F', 23457787, 'anita@gmail.com', 'Las Acacias 233', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comuna`
--

CREATE TABLE `comuna` (
  `id_comuna` int(3) NOT NULL,
  `nombre_comuna` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comuna`
--

INSERT INTO `comuna` (`id_comuna`, `nombre_comuna`) VALUES
(1, 'Viña del Mar'),
(2, 'Valparaíso'),
(3, 'Concón'),
(4, 'Quilpué'),
(5, 'Villa Alemana'),
(6, 'La Ligua'),
(9, 'Petorca'),
(10, 'Los Andes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_civil`
--

CREATE TABLE `estado_civil` (
  `id_estado` int(1) NOT NULL,
  `nombre_estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estado_civil`
--

INSERT INTO `estado_civil` (`id_estado`, `nombre_estado`) VALUES
(1, 'Soltero'),
(2, 'Casado'),
(3, 'Separado'),
(4, 'Viudo'),
(5, 'Conviviente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut`),
  ADD KEY `id_comuna` (`id_comuna`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indices de la tabla `comuna`
--
ALTER TABLE `comuna`
  ADD PRIMARY KEY (`id_comuna`);

--
-- Indices de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  ADD PRIMARY KEY (`id_estado`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_comuna`) REFERENCES `comuna` (`id_comuna`),
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`id_estado`) REFERENCES `estado_civil` (`id_estado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
