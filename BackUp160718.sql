-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-07-2018 a las 21:50:21
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `caso-prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banco`
--

DROP TABLE IF EXISTS `banco`;
CREATE TABLE IF NOT EXISTS `banco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro_de_costo`
--

DROP TABLE IF EXISTS `centro_de_costo`;
CREATE TABLE IF NOT EXISTS `centro_de_costo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etapa`
--

DROP TABLE IF EXISTS `etapa`;
CREATE TABLE IF NOT EXISTS `etapa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(45) DEFAULT NULL,
  `ubicacion` varchar(45) DEFAULT NULL,
  `Proyecto_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Proyecto_id`),
  KEY `fk_Etapa_Proyecto1_idx` (`Proyecto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id` int(11) NOT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_remision` date DEFAULT NULL,
  `OrdendeCompra_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`OrdendeCompra_id`),
  KEY `fk_Factura_OrdendeCompra1_idx` (`OrdendeCompra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE IF NOT EXISTS `grupo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  `UnidadMedida_id` int(11) NOT NULL,
  `Grupo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`UnidadMedida_id`,`Grupo_id`),
  KEY `fk_Material_UnidadMedida1_idx` (`UnidadMedida_id`),
  KEY `fk_Material_Grupo1_idx` (`Grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordendecompra`
--

DROP TABLE IF EXISTS `ordendecompra`;
CREATE TABLE IF NOT EXISTS `ordendecompra` (
  `id` int(11) NOT NULL,
  `codigo` char(1) DEFAULT NULL,
  `Fecha_emision` date DEFAULT NULL,
  `Fecha_entrega` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `forma_pago` varchar(45) DEFAULT NULL,
  `tipo_pago` varchar(45) DEFAULT NULL,
  `moneda` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordendecompradetalle`
--

DROP TABLE IF EXISTS `ordendecompradetalle`;
CREATE TABLE IF NOT EXISTS `ordendecompradetalle` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` int(11) DEFAULT NULL,
  `familia` int(11) DEFAULT NULL,
  `OrdendeCompra_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`OrdendeCompra_id`),
  KEY `fk_OrdendeCompraDetalle_OrdendeCompra1_idx` (`OrdendeCompra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE IF NOT EXISTS `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `ruc` char(11) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `cuenta_corriente` varchar(20) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL,
  `id_banco` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_proveedor_banco` (`id_banco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE IF NOT EXISTS `proyecto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `ubicacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requerimiento`
--

DROP TABLE IF EXISTS `requerimiento`;
CREATE TABLE IF NOT EXISTS `requerimiento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requerimientodetalle`
--

DROP TABLE IF EXISTS `requerimientodetalle`;
CREATE TABLE IF NOT EXISTS `requerimientodetalle` (
  `id` int(11) NOT NULL,
  `Requerimiento_id` int(11) NOT NULL,
  `Etapa_id` int(11) NOT NULL,
  `OrdendeCompraDetalle_id` int(11) NOT NULL,
  `Material_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Requerimiento_id`,`Etapa_id`,`OrdendeCompraDetalle_id`,`Material_id`),
  KEY `fk_RequerimientoDetalle_Requerimiento1_idx` (`Requerimiento_id`),
  KEY `fk_RequerimientoDetalle_Etapa1_idx` (`Etapa_id`),
  KEY `fk_RequerimientoDetalle_OrdendeCompraDetalle1_idx` (`OrdendeCompraDetalle_id`),
  KEY `fk_RequerimientoDetalle_Material1_idx` (`Material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=REDUNDANT;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_permisos`
--

DROP TABLE IF EXISTS `roles_permisos`;
CREATE TABLE IF NOT EXISTS `roles_permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_rol` int(11) NOT NULL,
  `id_permiso` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_rol` (`id_rol`),
  KEY `id_permiso` (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
CREATE TABLE IF NOT EXISTS `unidadmedida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(250) NOT NULL,
  `apellidos` varchar(250) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `contraseña` varchar(250) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_roles` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `etapa`
--
ALTER TABLE `etapa`
  ADD CONSTRAINT `fk_Etapa_Proyecto1` FOREIGN KEY (`Proyecto_id`) REFERENCES `proyecto` (`id`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_Factura_OrdendeCompra1` FOREIGN KEY (`OrdendeCompra_id`) REFERENCES `ordendecompra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `fk_Material_Grupo1` FOREIGN KEY (`Grupo_id`) REFERENCES `grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Material_UnidadMedida1` FOREIGN KEY (`UnidadMedida_id`) REFERENCES `unidadmedida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ordendecompradetalle`
--
ALTER TABLE `ordendecompradetalle`
  ADD CONSTRAINT `fk_OrdendeCompraDetalle_OrdendeCompra1` FOREIGN KEY (`OrdendeCompra_id`) REFERENCES `ordendecompra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `requerimientodetalle`
--
ALTER TABLE `requerimientodetalle`
  ADD CONSTRAINT `fk_RequerimientoDetalle_Etapa1` FOREIGN KEY (`Etapa_id`) REFERENCES `etapa` (`id`),
  ADD CONSTRAINT `fk_RequerimientoDetalle_Material1` FOREIGN KEY (`Material_id`) REFERENCES `material` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_RequerimientoDetalle_OrdendeCompraDetalle1` FOREIGN KEY (`OrdendeCompraDetalle_id`) REFERENCES `ordendecompradetalle` (`id`),
  ADD CONSTRAINT `fk_RequerimientoDetalle_Requerimiento1` FOREIGN KEY (`Requerimiento_id`) REFERENCES `requerimiento` (`id`);
COMMIT;


ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_usuario_roles` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE `roles_permisos`
  ADD CONSTRAINT `FK_permisos_roles_roles` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `roles_permisos`
  ADD CONSTRAINT `FK_permisos_roles_permiso` FOREIGN KEY (`id_permiso`) REFERENCES `permisos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;