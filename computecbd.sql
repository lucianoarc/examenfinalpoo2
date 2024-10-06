-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2024 a las 17:18:57
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
-- Base de datos: `computecbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `Rut` varchar(10) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Comuna` varchar(50) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `telefono` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Rut`, `Nombre`, `Direccion`, `Comuna`, `Correo`, `telefono`) VALUES
('98765432-1', 'María González', 'Calle Los Álamos 567', 'Las Condes', 'maria.gonzalez@example.com', 876543210),
('11223344-5', 'Carlos Rodríguez', 'Av. Providencia 876', 'Providencia', 'carlos.rodriguez@example.com', 765432109),
('22334455-0', 'Laura Martínez', 'Calle La Serena 345', 'Viña del Mar', 'laura.martinez@example.com', 654321098),
('33445566-4', 'José Fernández', 'Paseo Ahumada 111', 'Santiago', 'jose.fernandez@example.com', 543210987);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `computador_escritorio`
--

CREATE TABLE `computador_escritorio` (
  `modelo` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `disco_duro` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `precio` int(11) NOT NULL,
  `placa_madre` varchar(255) NOT NULL,
  `fuente_poder` varchar(255) NOT NULL,
  `vendido` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `computador_escritorio`
--

INSERT INTO `computador_escritorio` (`modelo`, `cpu`, `disco_duro`, `ram`, `precio`, `placa_madre`, `fuente_poder`, `vendido`) VALUES
('Dell OptiPlex 3080', 'Intel Core i5-10400', '1TB HDD', '8GB', 450000, 'MSI B460M', '450W', 0),
('HP ProDesk 400 G7', 'Intel Core i7-10700', '512GB SSD', '16GB', 600000, 'ASUS PRIME B460M', '500W', 0),
('Lenovo ThinkCentre M720', 'Intel Core i3-9100', '1TB HDD', '4GB', 350000, 'Gigabyte H310M', '400W', 0),
('Acer Veriton X2660', 'Intel Core i5-9500', '256GB SSD', '8GB', 420000, 'MSI H310M', '450W', 0),
('Asus ExpertCenter D5', 'AMD Ryzen 5 3500', '1TB HDD', '8GB', 470000, 'ASRock B450M', '500W', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notebook`
--

CREATE TABLE `notebook` (
  `modelo` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `disco_duro` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `precio` int(11) NOT NULL,
  `pantalla` varchar(255) NOT NULL,
  `usb` varchar(255) NOT NULL,
  `touch` tinyint(1) NOT NULL,
  `vendido` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notebook`
--

INSERT INTO `notebook` (`modelo`, `cpu`, `disco_duro`, `ram`, `precio`, `pantalla`, `usb`, `touch`, `vendido`) VALUES
('Dell XPS 13', 'Intel Core i7-1165G7', '512GB SSD', '16GB', 1200000, '13.3\"', '3', 0, 0),
('HP Spectre x360', 'Intel Core i5-1135G7', '256GB SSD', '8GB', 950000, '13.3\"', '2', 1, 0),
('Lenovo Yoga 9i', 'Intel Core i7-1185G7', '1TB SSD', '16GB', 1350000, '14\"', '3', 1, 0),
('Acer Swift 3', 'AMD Ryzen 7 4700U', '512GB SSD', '8GB', 850000, '14\"', '2', 0, 0),
('Asus ZenBook 14', 'Intel Core i5-1135G7', '512GB SSD', '16GB', 1000000, '14\"', '3', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `Rut` varchar(15) NOT NULL,
  `Modelo` varchar(50) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`Rut`, `Modelo`, `Fecha`) VALUES
('98765432-1', 'Dell OptiPlex 3080', '2024-10-06'),
('98765432-1', 'HP ProDesk 400 G7', '2024-10-06'),
('98765432-1', 'Lenovo ThinkCentre M720', '2024-10-06');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
