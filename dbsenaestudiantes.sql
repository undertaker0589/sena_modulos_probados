-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2026 a las 00:41:58
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbsenaestudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprendiz`
--

CREATE TABLE `aprendiz` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `programa` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `aprendiz`
--

INSERT INTO `aprendiz` (`id`, `nombre`, `apellido`, `programa`) VALUES
(1, 'Diego Alexander', 'Erazo Fernandez', 'ANALISIS Y DESARROLLO DE SOFTWARE'),
(2, 'MARLEN', 'BAICUE', 'ING INDUSTRIAL'),
(13, 'DIEGO fer', 'ERAZO', 'ANALISIS Y DESARROLLO DE SOFTWARE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aprendiz`
--
ALTER TABLE `aprendiz`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aprendiz`
--
ALTER TABLE `aprendiz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
