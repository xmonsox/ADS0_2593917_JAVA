-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2024 a las 23:17:49
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
-- Base de datos: `preguntas_v2_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuestionarios`
--

CREATE TABLE `cuestionarios` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) UNSIGNED NOT NULL,
  `cant_preguntas` int(11) NOT NULL,
  `cant_ok` int(11) NOT NULL,
  `cant_error` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL DEFAULT current_timestamp(),
  `fecha_fin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cuestionarios`
--

INSERT INTO `cuestionarios` (`id`, `id_usuario`, `cant_preguntas`, `cant_ok`, `cant_error`, `fecha_inicio`, `fecha_fin`) VALUES
(1, 1, 0, 0, 0, '2024-01-25 20:32:56', NULL),
(2, 1, 0, 0, 0, '2024-01-25 23:41:44', '2024-01-25 23:47:44'),
(38, 1, 0, 0, 0, '2024-01-26 12:18:46', NULL),
(39, 1, 0, 0, 0, '2024-01-26 12:26:09', NULL),
(40, 1, 0, 0, 0, '2024-03-01 17:38:30', '0000-00-00 00:00:00'),
(41, 1, 0, 0, 0, '2024-03-01 17:51:38', '0000-00-00 00:00:00'),
(42, 1, 0, 0, 0, '2024-03-01 17:51:46', '0000-00-00 00:00:00'),
(43, 1, 0, 0, 0, '2024-03-01 17:52:35', '0000-00-00 00:00:00'),
(44, 1, 0, 0, 0, '2024-03-01 17:53:22', '0000-00-00 00:00:00'),
(45, 1, 0, 0, 0, '2024-03-01 18:02:13', '0000-00-00 00:00:00'),
(46, 1, 0, 0, 0, '2024-03-01 18:03:07', '0000-00-00 00:00:00'),
(47, 1, 0, 0, 0, '2024-03-01 18:16:27', '0000-00-00 00:00:00'),
(48, 1, 0, 0, 0, '2024-03-01 18:21:11', '0000-00-00 00:00:00'),
(49, 1, 0, 0, 0, '2024-03-01 18:21:53', '0000-00-00 00:00:00'),
(50, 1, 0, 0, 0, '2024-03-01 18:23:53', '0000-00-00 00:00:00'),
(51, 1, 0, 0, 0, '2024-03-01 18:24:42', '0000-00-00 00:00:00'),
(52, 1, 0, 0, 0, '2024-03-01 18:28:13', '0000-00-00 00:00:00'),
(53, 1, 0, 0, 0, '2024-03-01 18:32:00', '0000-00-00 00:00:00'),
(54, 1, 0, 0, 0, '2024-03-01 18:35:51', '0000-00-00 00:00:00'),
(55, 1, 0, 0, 0, '2024-03-01 18:37:20', '0000-00-00 00:00:00'),
(56, 1, 0, 0, 0, '2024-03-01 18:40:12', '0000-00-00 00:00:00'),
(57, 1, 0, 0, 0, '2024-03-01 18:43:08', '0000-00-00 00:00:00'),
(58, 1, 0, 0, 0, '2024-03-07 14:55:44', '0000-00-00 00:00:00'),
(59, 1, 0, 0, 0, '2024-03-07 15:03:38', '0000-00-00 00:00:00'),
(60, 1, 0, 0, 0, '2024-03-07 15:30:02', '0000-00-00 00:00:00'),
(61, 1, 0, 0, 0, '2024-03-07 15:39:11', '0000-00-00 00:00:00'),
(62, 1, 0, 0, 0, '2024-03-07 15:41:28', '0000-00-00 00:00:00'),
(63, 1, 0, 0, 0, '2024-03-07 15:44:24', '0000-00-00 00:00:00'),
(64, 1, 0, 0, 0, '2024-03-07 15:46:26', '0000-00-00 00:00:00'),
(65, 1, 0, 0, 0, '2024-03-07 15:48:43', '0000-00-00 00:00:00'),
(66, 1, 0, 0, 0, '2024-03-07 15:49:20', '0000-00-00 00:00:00'),
(67, 1, 0, 0, 0, '2024-03-07 16:03:28', '0000-00-00 00:00:00'),
(68, 1, 0, 0, 0, '2024-03-07 16:05:17', '0000-00-00 00:00:00'),
(69, 1, 0, 0, 0, '2024-03-07 16:06:28', '0000-00-00 00:00:00'),
(70, 1, 0, 0, 0, '2024-03-07 16:08:23', '0000-00-00 00:00:00'),
(71, 1, 0, 0, 0, '2024-03-07 16:10:01', '0000-00-00 00:00:00'),
(72, 1, 0, 0, 0, '2024-03-07 16:18:15', '0000-00-00 00:00:00'),
(73, 1, 10, 5, 5, '2024-03-07 16:23:00', '2024-03-07 16:23:19'),
(74, 1, 10, 4, 6, '2024-03-07 16:33:29', '2024-03-07 16:34:22'),
(75, 1, 0, 0, 0, '2024-03-07 16:46:51', '0000-00-00 00:00:00'),
(76, 1, 10, 7, 3, '2024-03-07 16:48:49', '2024-03-07 21:49:39'),
(77, 1, 10, 5, 5, '2024-03-07 17:00:25', '2024-03-07 17:00:48'),
(78, 1, 9, 2, 8, '2024-03-07 17:14:18', '2024-03-07 17:14:36');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones`
--

CREATE TABLE `opciones` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_pregunta` int(10) UNSIGNED DEFAULT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `opciones`
--

INSERT INTO `opciones` (`id`, `id_pregunta`, `descripcion`) VALUES
(1, 1, 'HyperText Markup Language'),
(2, 1, 'Hyperlink Text Markup Language'),
(3, 1, 'High-Level'),
(4, 2, 'C'),
(5, 2, 'C++'),
(6, 2, 'Ruby'),
(7, 3, 'Cascading Styling Sheets'),
(8, 3, 'Cascading Style Sheets'),
(9, 3, 'Cascaded S'),
(10, 4, '->'),
(11, 4, '='),
(12, 4, '==='),
(13, 5, 'Crear las bases de datos'),
(14, 5, 'Almacenar grandes cantidades de datos'),
(15, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos'),
(16, 6, 'Modelo-Visa-Controlador'),
(17, 6, 'Modelo-Vista-Controlador'),
(18, 6, 'Microservices-Virtual Container'),
(19, 7, 'Java'),
(20, 7, 'PHP'),
(21, 7, 'C'),
(22, 8, 'Instruccion de salida'),
(23, 8, 'Estructura de control de iteración'),
(24, 8, 'Comando de consola'),
(25, 9, 'SVN'),
(26, 9, 'Mercurial'),
(27, 9, 'GitHub'),
(28, 10, 'Un conjunto de monedas'),
(29, 10, 'Un dispositivo de almacenamiento de datos'),
(30, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea'),
(31, 9, 'Git');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(10) UNSIGNED NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_correcta` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `url_imagen` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `descripcion`, `id_correcta`, `url_imagen`) VALUES
(1, '¿Qué significa HTML?', '1', 'https://www.oxfordwebstudio.com/user/pages/06.da-li-znate/sta-je-html/sta-je-html.jpg'),
(2, '¿En qué lenguaje est? escrito Python?', '4', 'https://www.solvetic.com/uploads/monthly_01_2016/tutorials-1415-0-60642300-1452279191.jpg'),
(3, '¿Qué es CSS?', '8', 'https://1000marcas.net/wp-content/uploads/2021/02/CSS-Logo.png'),
(4, '¿Cuál es el símbolo de asignación en JavaScript?', '11', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png'),
(5, '¿Cuál es el propósito de SQL?', '15', 'https://www.bigbaydata.com/wp-content/uploads/2022/11/sql_ejercicios.png'),
(6, '¿Qué significa MVC en el contexto del desarrollo web?', '17', 'https://estradawebgroup.com/ImagesUpload/File_Upload_202331310241646_U_7.webp'),
(7, '¿Cuál es el lenguaje de programación más utilizado para el desarrollo de aplicaciones Android?', '19', 'https://developer.android.com/static/training/basics/firstapp/images/first_app.svg?hl=es-419'),
(8, '¿Qué es un bucle \"for\" en la programación?', '23', 'https://sistemasumma.files.wordpress.com/2012/10/ciclos.png?w=1140'),
(9, '¿Cuál es el sistema de control de versiones más utilizado?', '31', 'https://victorroblesweb.es/wp-content/uploads/2018/04/git.png'),
(10, '¿Qué es un algoritmo?', '30', 'https://cdn.openwebinars.net/media/featured_images/blog-que-es-un-algoritmo-informatico.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id_respuesta` int(10) UNSIGNED NOT NULL,
  `id_cuestionario` int(11) NOT NULL,
  `id_pregunta` int(10) UNSIGNED DEFAULT NULL,
  `respuesta` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `estado` enum('OK','ERROR') CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `fecha` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`id_respuesta`, `id_cuestionario`, `id_pregunta`, `respuesta`, `estado`, `fecha`) VALUES
(3, 1, 1, 'Hyperlink Text Markup Language', 'OK', '2024-01-25 20:38:55'),
(5, 1, 5, 'Crear las bases de datos', 'ERROR', '2024-01-25 20:40:15'),
(6, 2, 7, 'Java', 'OK', '2024-01-25 23:43:42'),
(7, 2, 9, 'Git', 'OK', '2024-01-25 23:43:42'),
(8, 2, 4, '=', 'OK', '2024-01-25 23:44:08'),
(9, 2, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-01-25 23:44:35'),
(44, 38, 6, 'Microservices-Virtual Container', 'ERROR', '2024-01-26 07:18:53'),
(45, 38, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-01-26 07:18:55'),
(46, 38, 8, 'Instruccion de salida', 'ERROR', '2024-01-26 07:18:58'),
(47, 38, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-01-26 07:19:01'),
(48, 39, 6, 'Maquina Virtual de Control', 'ERROR', '2024-01-26 07:26:56'),
(49, 39, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-01-26 07:29:01'),
(50, 39, 4, '==', 'ERROR', '2024-01-26 07:31:30'),
(51, 39, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-01-26 07:32:29'),
(52, 39, 3, 'Cascading Styling Sheets', 'ERROR', '2024-01-26 07:32:31'),
(53, 39, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-01-26 07:32:33'),
(54, 39, 9, 'Mercurial', 'ERROR', '2024-01-26 07:32:48'),
(55, 39, 2, 'C++', 'ERROR', '2024-01-26 07:32:50'),
(56, 39, 8, 'Estructura de selecciÃƒÂ³n', 'OK', '2024-01-26 07:32:52'),
(57, 58, 1, 'HyperText Markup Language', 'OK', '2024-03-07 14:55:44'),
(58, 58, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 14:55:44'),
(59, 58, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 14:55:44'),
(60, 58, 4, '->', 'ERROR', '2024-03-07 14:55:44'),
(61, 58, 2, 'Ruby', 'ERROR', '2024-03-07 14:55:44'),
(62, 58, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 14:55:44'),
(63, 58, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 14:55:44'),
(64, 58, 9, 'SVN', 'ERROR', '2024-03-07 14:55:44'),
(65, 58, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 14:55:44'),
(66, 58, 7, 'Java', 'OK', '2024-03-07 14:55:44'),
(67, 59, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 15:03:38'),
(68, 59, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 15:03:38'),
(69, 59, 2, 'Ruby', 'ERROR', '2024-03-07 15:03:38'),
(70, 59, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:03:38'),
(71, 59, 6, 'Modelo-Visa-Controlador', 'ERROR', '2024-03-07 15:03:38'),
(72, 59, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 15:03:38'),
(73, 59, 7, 'Java', 'OK', '2024-03-07 15:03:38'),
(74, 59, 1, 'High-Level', 'ERROR', '2024-03-07 15:03:38'),
(75, 59, 9, 'Mercurial', 'ERROR', '2024-03-07 15:03:38'),
(76, 59, 4, '===', 'ERROR', '2024-03-07 15:03:38'),
(77, 60, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:30:02'),
(78, 60, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:30:02'),
(79, 60, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 15:30:02'),
(80, 60, 7, 'PHP', 'ERROR', '2024-03-07 15:30:02'),
(81, 60, 4, '=', 'OK', '2024-03-07 15:30:02'),
(82, 60, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 15:30:02'),
(83, 60, 9, 'SVN', 'ERROR', '2024-03-07 15:30:02'),
(84, 60, 1, 'High-Level', 'ERROR', '2024-03-07 15:30:02'),
(85, 60, 2, 'C++', 'ERROR', '2024-03-07 15:30:02'),
(86, 60, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 15:30:02'),
(87, 61, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:39:11'),
(88, 61, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 15:39:11'),
(89, 61, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 15:39:11'),
(90, 61, 8, 'Instruccion de salida', 'ERROR', '2024-03-07 15:39:11'),
(91, 61, 2, 'C++', 'ERROR', '2024-03-07 15:39:11'),
(92, 61, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 15:39:11'),
(93, 61, 4, '->', 'ERROR', '2024-03-07 15:39:11'),
(94, 61, 7, 'Java', 'OK', '2024-03-07 15:39:11'),
(95, 61, 9, 'GitHub', 'ERROR', '2024-03-07 15:39:11'),
(96, 61, 1, 'High-Level', 'ERROR', '2024-03-07 15:39:11'),
(97, 62, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:41:28'),
(98, 62, 2, 'C++', 'ERROR', '2024-03-07 15:41:28'),
(99, 62, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 15:41:28'),
(100, 62, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 15:41:28'),
(101, 62, 9, 'Git', 'OK', '2024-03-07 15:41:28'),
(102, 62, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:41:28'),
(103, 62, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 15:41:28'),
(104, 62, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 15:41:28'),
(105, 62, 4, '===', 'ERROR', '2024-03-07 15:41:28'),
(106, 62, 7, 'Java', 'OK', '2024-03-07 15:41:28'),
(107, 63, 4, '===', 'ERROR', '2024-03-07 15:44:24'),
(108, 63, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 15:44:24'),
(109, 63, 5, 'Crear las bases de datos', 'ERROR', '2024-03-07 15:44:24'),
(110, 63, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:44:24'),
(111, 63, 2, 'C++', 'ERROR', '2024-03-07 15:44:24'),
(112, 63, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:44:24'),
(113, 63, 7, 'Java', 'OK', '2024-03-07 15:44:24'),
(114, 63, 9, 'GitHub', 'ERROR', '2024-03-07 15:44:24'),
(115, 63, 1, 'High-Level', 'ERROR', '2024-03-07 15:44:24'),
(116, 63, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 15:44:24'),
(117, 64, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 15:46:26'),
(118, 64, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 15:46:26'),
(119, 64, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 15:46:26'),
(120, 64, 7, 'Java', 'OK', '2024-03-07 15:46:26'),
(121, 64, 9, 'GitHub', 'ERROR', '2024-03-07 15:46:26'),
(122, 64, 2, 'C++', 'ERROR', '2024-03-07 15:46:26'),
(123, 64, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 15:46:26'),
(124, 64, 6, 'Modelo-Visa-Controlador', 'ERROR', '2024-03-07 15:46:26'),
(125, 64, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:46:26'),
(126, 64, 4, '=', 'OK', '2024-03-07 15:46:26'),
(127, 65, 2, 'C++', 'ERROR', '2024-03-07 15:48:43'),
(128, 65, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:48:43'),
(129, 65, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 15:48:43'),
(130, 65, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 15:48:43'),
(131, 65, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 15:48:43'),
(132, 65, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:48:43'),
(133, 65, 9, 'Git', 'OK', '2024-03-07 15:48:43'),
(134, 65, 7, 'Java', 'OK', '2024-03-07 15:48:43'),
(135, 65, 3, 'Cascaded S', 'ERROR', '2024-03-07 15:48:43'),
(136, 66, 4, '=', 'OK', '2024-03-07 15:49:20'),
(137, 66, 9, 'Mercurial', 'ERROR', '2024-03-07 15:49:20'),
(138, 66, 1, 'HyperText Markup Language', 'OK', '2024-03-07 15:49:20'),
(139, 66, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 15:49:20'),
(140, 66, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 15:49:20'),
(141, 66, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 15:49:20'),
(142, 66, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 15:49:20'),
(143, 66, 7, 'Java', 'OK', '2024-03-07 15:49:20'),
(144, 66, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 15:49:20'),
(145, 66, 2, 'C', 'OK', '2024-03-07 15:49:20'),
(146, 67, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:03:28'),
(147, 67, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:03:28'),
(148, 67, 5, 'Crear las bases de datos', 'ERROR', '2024-03-07 16:03:28'),
(149, 67, 8, 'Instruccion de salida', 'ERROR', '2024-03-07 16:03:28'),
(150, 67, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:03:28'),
(151, 67, 7, 'Java', 'OK', '2024-03-07 16:03:28'),
(152, 67, 4, '=', 'OK', '2024-03-07 16:03:28'),
(153, 67, 9, 'Git', 'OK', '2024-03-07 16:03:28'),
(154, 67, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:03:28'),
(155, 67, 2, 'C++', 'ERROR', '2024-03-07 16:03:28'),
(156, 68, 2, 'Ruby', 'ERROR', '2024-03-07 16:05:17'),
(157, 68, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:05:17'),
(158, 68, 4, '->', 'ERROR', '2024-03-07 16:05:17'),
(159, 68, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:05:17'),
(160, 68, 9, 'GitHub', 'ERROR', '2024-03-07 16:05:17'),
(161, 68, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:05:17'),
(162, 68, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 16:05:17'),
(163, 68, 7, 'PHP', 'ERROR', '2024-03-07 16:05:17'),
(164, 68, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:05:17'),
(165, 68, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:05:17'),
(166, 69, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:06:28'),
(167, 69, 2, 'C++', 'ERROR', '2024-03-07 16:06:28'),
(168, 69, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 16:06:28'),
(169, 69, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:06:28'),
(170, 69, 4, '=', 'OK', '2024-03-07 16:06:28'),
(171, 69, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:06:28'),
(172, 69, 6, 'Modelo-Visa-Controlador', 'ERROR', '2024-03-07 16:06:28'),
(173, 69, 7, 'PHP', 'ERROR', '2024-03-07 16:06:28'),
(174, 69, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:06:28'),
(175, 69, 9, 'GitHub', 'ERROR', '2024-03-07 16:06:28'),
(176, 70, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:08:23'),
(177, 70, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 16:08:23'),
(178, 70, 1, 'High-Level', 'ERROR', '2024-03-07 16:08:23'),
(179, 70, 9, 'Git', 'OK', '2024-03-07 16:08:23'),
(180, 70, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:08:23'),
(181, 70, 2, 'C++', 'ERROR', '2024-03-07 16:08:23'),
(182, 70, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:08:23'),
(183, 70, 7, 'PHP', 'ERROR', '2024-03-07 16:08:23'),
(184, 70, 4, '===', 'ERROR', '2024-03-07 16:08:23'),
(185, 70, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:08:23'),
(186, 71, 1, 'HyperText Markup Language', 'OK', '2024-03-07 16:10:01'),
(187, 71, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 16:10:01'),
(188, 71, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:10:01'),
(189, 71, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:10:01'),
(190, 71, 4, '=', 'OK', '2024-03-07 16:10:01'),
(191, 71, 2, 'Ruby', 'ERROR', '2024-03-07 16:10:01'),
(192, 71, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:10:01'),
(193, 71, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:10:01'),
(194, 71, 9, 'Git', 'OK', '2024-03-07 16:10:01'),
(195, 71, 7, 'PHP', 'ERROR', '2024-03-07 16:10:01'),
(196, 72, 4, '->', 'ERROR', '2024-03-07 16:18:15'),
(197, 72, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 16:18:15'),
(198, 72, 2, 'C++', 'ERROR', '2024-03-07 16:18:15'),
(199, 72, 1, 'High-Level', 'ERROR', '2024-03-07 16:18:15'),
(200, 72, 7, 'PHP', 'ERROR', '2024-03-07 16:18:15'),
(201, 72, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:18:15'),
(202, 72, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:18:15'),
(203, 72, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:18:15'),
(204, 72, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 16:18:15'),
(205, 72, 9, 'Git', 'OK', '2024-03-07 16:18:15'),
(206, 73, 4, '=', 'OK', '2024-03-07 16:23:00'),
(207, 73, 2, 'Ruby', 'ERROR', '2024-03-07 16:23:00'),
(208, 73, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 16:23:00'),
(209, 73, 7, 'PHP', 'ERROR', '2024-03-07 16:23:00'),
(210, 73, 8, 'Comando de consola', 'ERROR', '2024-03-07 16:23:00'),
(211, 73, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:23:00'),
(212, 73, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 16:23:00'),
(213, 73, 9, 'Git', 'OK', '2024-03-07 16:23:00'),
(214, 73, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 16:23:00'),
(215, 73, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:23:00'),
(216, 74, 2, 'Ruby', 'ERROR', '2024-03-07 16:33:29'),
(217, 74, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:33:29'),
(218, 74, 7, 'Java', 'OK', '2024-03-07 16:33:29'),
(219, 74, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:33:29'),
(220, 74, 4, '=', 'OK', '2024-03-07 16:33:29'),
(221, 74, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 16:33:29'),
(222, 74, 10, 'Un conjunto de monedas', 'ERROR', '2024-03-07 16:33:29'),
(223, 74, 9, 'Mercurial', 'ERROR', '2024-03-07 16:33:29'),
(224, 74, 6, 'Microservices-Virtual Container', 'ERROR', '2024-03-07 16:33:29'),
(225, 74, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 16:33:29'),
(226, 75, 4, '->', 'ERROR', '2024-03-07 16:46:51'),
(227, 76, 5, 'Lenguaje de consulta estructurada para gestionar bases de datos', 'OK', '2024-03-07 16:48:49'),
(228, 76, 10, 'Un conjunto de instrucciones paso a paso para realizar una tarea', 'OK', '2024-03-07 16:48:49'),
(229, 76, 9, 'Git', 'OK', '2024-03-07 16:48:49'),
(230, 76, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 16:48:49'),
(231, 76, 3, 'Cascading Styling Sheets', 'ERROR', '2024-03-07 16:48:49'),
(232, 76, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 16:48:49'),
(233, 76, 4, '=', 'OK', '2024-03-07 16:48:49'),
(234, 76, 7, 'Java', 'OK', '2024-03-07 16:48:49'),
(235, 76, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 16:48:49'),
(236, 76, 2, 'C++', 'ERROR', '2024-03-07 16:48:49'),
(237, 77, 6, 'Modelo-Vista-Controlador', 'OK', '2024-03-07 17:00:25'),
(238, 77, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 17:00:25'),
(239, 77, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 17:00:25'),
(240, 77, 7, 'PHP', 'ERROR', '2024-03-07 17:00:25'),
(241, 77, 8, 'Estructura de control de iteración', 'OK', '2024-03-07 17:00:25'),
(242, 77, 2, 'C++', 'ERROR', '2024-03-07 17:00:25'),
(243, 77, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 17:00:25'),
(244, 77, 9, 'Git', 'OK', '2024-03-07 17:00:25'),
(245, 77, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 17:00:25'),
(246, 77, 4, '=', 'OK', '2024-03-07 17:00:25'),
(247, 78, 4, '=', 'OK', '2024-03-07 17:14:18'),
(248, 78, 7, 'PHP', 'ERROR', '2024-03-07 17:14:18'),
(249, 78, 3, 'Cascading Style Sheets', 'OK', '2024-03-07 17:14:18'),
(250, 78, 5, 'Almacenar grandes cantidades de datos', 'ERROR', '2024-03-07 17:14:18'),
(251, 78, 10, 'Un dispositivo de almacenamiento de datos', 'ERROR', '2024-03-07 17:14:18'),
(252, 78, 2, 'Ruby', 'ERROR', '2024-03-07 17:14:18'),
(253, 78, 9, 'Mercurial', 'ERROR', '2024-03-07 17:14:18'),
(254, 78, 1, 'Hyperlink Text Markup Language', 'ERROR', '2024-03-07 17:14:18'),
(255, 78, 6, 'Microservices-Virtual Container', 'ERROR', '2024-03-07 17:14:18'),
(256, 78, 8, 'Instruccion de salida', 'ERROR', '2024-03-07 17:14:18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(10) UNSIGNED NOT NULL,
  `nombres` varchar(80) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `correo` varchar(120) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombres`, `correo`, `password`) VALUES
(1, 'Oscar Andres Loaiza Pabon', 'andres@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuestionarios`
--
ALTER TABLE `cuestionarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pregunta` (`id_pregunta`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id_respuesta`),
  ADD KEY `pregunta` (`id_pregunta`),
  ADD KEY `id_cuestionarios` (`id_cuestionario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuestionarios`
--
ALTER TABLE `cuestionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT de la tabla `opciones`
--
ALTER TABLE `opciones`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id_respuesta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=257;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuestionarios`
--
ALTER TABLE `cuestionarios`
  ADD CONSTRAINT `cuestionarios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD CONSTRAINT `opciones_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id`);

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_3` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuestas_ibfk_4` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
