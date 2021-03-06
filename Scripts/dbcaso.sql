-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2018 at 04:13 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcaso`
--
DROP DATABASE IF EXISTS dbcaso;
CREATE DATABASE dbcaso;
USE dbcaso;
-- --------------------------------------------------------

--
-- Table structure for table `areanegocio`
--

CREATE TABLE `areanegocio` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `prefijo` varchar(10) NOT NULL,
  `estado` enum('Activo','Baja') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `banco`
--

CREATE TABLE `banco` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `centro_de_costo`
--

CREATE TABLE `centro_de_costo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `etapa`
--

CREATE TABLE `etapa` (
  `id` int(11) NOT NULL,
  `denominacion` varchar(45) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `Proyecto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_remision` date DEFAULT NULL,
  `estado` enum('Activo','Baja') NOT NULL,
  `OrdendeCompra_id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `grupo`
--

CREATE TABLE `grupo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  `estado` enum('Activo','Baja') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  `estado` enum('Activo','Baja') NOT NULL,
  `UnidadMedida_id` int(11) NOT NULL,
  `Grupo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ordendecompra`
--

CREATE TABLE `ordendecompra` (
  `id` int(11) NOT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `forma_pago` enum('CONTADO','CONTRAENTREGA','FACTURA_7_DIAS','FACTURA_15_DIAS',
				'FACTURA_30_DIAS','LETRA_30_DIAS','LETRA_45_DIAS','LETRA_60_DIAS'),
  `tipo_pago` enum('CHEQUE','EFECTIVO','PAGARE','TRANSFERENCIA'),
  `moneda` enum('SOLES','DOLARES','EUROS'),
  `estado` enum('PENDIENTE','APROBADO','ANULADO'),
  `observaciones` varchar(45) DEFAULT NULL,
  `proveedor_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ordendecompradetalle`
--

CREATE TABLE `ordendecompradetalle` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(6,2) DEFAULT NULL,
  `familia` int(11) DEFAULT NULL,
  `ordendecompra_id` int(11) NOT NULL,
  `requerimientodetalle_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `permisos`
--

CREATE TABLE `permisos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `estado` enum('Activo','Baja') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ruc` char(11) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `cuenta_corriente` varchar(20) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `estado` enum('Activo','Baja') DEFAULT NULL,
  `id_banco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `proyecto`
--

CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `ubicacion` varchar(45) DEFAULT NULL,
  `estado` enum('Activo','Baja') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requerimiento`
--

CREATE TABLE `requerimiento` (
  `id` int(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `estado` enum('PENDIENTE','APROBADO', 'CERRADO') NOT NULL,
  `id_areanegocio` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_centrocosto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `requerimientodetalle`
--

CREATE TABLE `requerimientodetalle` (
  `id` int(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `cantidad_atendida` INT(11) NOT NULL DEFAULT 0,
  `atendido` BOOLEAN NOT NULL DEFAULT 0,
  `observaciones` TEXT NULL,
  `Requerimiento_id` int(11) NOT NULL,
  `Etapa_id` int(11) NOT NULL,
  `Material_id` int(11) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=REDUNDANT;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `roles_permisos`
--

CREATE TABLE `roles_permisos` (
  `id` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `id_permiso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `unidadmedida`
--

CREATE TABLE `unidadmedida` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `estado` enum('Activo','Baja') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombres` varchar(250) NOT NULL,
  `apellidos` varchar(250) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `estado` enum('Activo','Baja') NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `areanegocio`
--
ALTER TABLE `areanegocio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `centro_de_costo`
--
ALTER TABLE `centro_de_costo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `etapa`
--
ALTER TABLE `etapa`
  ADD PRIMARY KEY (`id`,`Proyecto_id`),
  ADD KEY `fk_Etapa_Proyecto1_idx` (`Proyecto_id`);

--
-- Indexes for table `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Factura_OrdendeCompra1_idx` (`OrdendeCompra_id`),
  ADD KEY `fk_Factura_Usuario_idx` (`id_usuario`);

--
-- Indexes for table `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`,`UnidadMedida_id`,`Grupo_id`),
  ADD KEY `fk_Material_UnidadMedida1_idx` (`UnidadMedida_id`),
  ADD KEY `fk_Material_Grupo1_idx` (`Grupo_id`);

--
-- Indexes for table `ordendecompra`
--
ALTER TABLE `ordendecompra`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ordendecompradetalle`
--
ALTER TABLE `ordendecompradetalle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_proveedor_banco` (`id_banco`);

--
-- Indexes for table `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requerimiento`
--
ALTER TABLE `requerimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_requerimientoAreanegocio` (`id_areanegocio`),
  ADD KEY `fk_requerimientoUsuario` (`id_usuario`),
  ADD KEY `fk_requerimientoCentrocosto` (`id_centrocosto`);

--
-- Indexes for table `requerimientodetalle`
--
ALTER TABLE `requerimientodetalle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles_permisos`
--
ALTER TABLE `roles_permisos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unidadmedida`
--
ALTER TABLE `unidadmedida`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_usuario_roles` (`id_rol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `areanegocio`
--
ALTER TABLE `areanegocio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `banco`
--
ALTER TABLE `banco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `centro_de_costo`
--
ALTER TABLE `centro_de_costo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `etapa`
--
ALTER TABLE `etapa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
  
--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `ordendecompra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `ordendecompradetalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
  
--
-- AUTO_INCREMENT for table `permisos`
--
ALTER TABLE `permisos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles_permisos`
--
ALTER TABLE `roles_permisos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `unidadmedida`
--
ALTER TABLE `unidadmedida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `etapa`
--
ALTER TABLE `etapa`
  ADD CONSTRAINT `fk_Etapa_Proyecto1` FOREIGN KEY (`Proyecto_id`) REFERENCES `proyecto` (`id`);

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_Factura_OrdendeCompra1` FOREIGN KEY (`OrdendeCompra_id`) REFERENCES `ordendecompra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Factura_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `fk_Material_Grupo1` FOREIGN KEY (`Grupo_id`) REFERENCES `grupo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Material_UnidadMedida1` FOREIGN KEY (`UnidadMedida_id`) REFERENCES `unidadmedida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ordendecompradetalle`
--
ALTER TABLE `ordendecompra`
  ADD CONSTRAINT `fk_OrdendeCompra_Proveedor` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_OrdendeCompra_Usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `ordendecompradetalle`
--
ALTER TABLE `ordendecompradetalle`
  ADD CONSTRAINT `fk_OrdendeCompraDetalle_OrdendeCompra1` FOREIGN KEY (`ordendecompra_id`) REFERENCES `ordendecompra` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_OrdendeCompraDetalle_RequerimientoDetalle` FOREIGN KEY (`requerimientodetalle_id`) REFERENCES `requerimientodetalle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `requerimiento`
--
ALTER TABLE `requerimiento`
  ADD CONSTRAINT `fk_requerimientoAreanegocio` FOREIGN KEY (`id_areanegocio`) REFERENCES `areanegocio` (`id`),
  ADD CONSTRAINT `fk_requerimientoCentrocosto` FOREIGN KEY (`id_centrocosto`) REFERENCES `centro_de_costo` (`id`),
  ADD CONSTRAINT `fk_requerimientoUsuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `requerimientodetalle`
--
ALTER TABLE `requerimientodetalle`
  ADD CONSTRAINT `fk_RequerimientoDetalle_Etapa1` FOREIGN KEY (`Etapa_id`) REFERENCES `etapa` (`id`),
  ADD CONSTRAINT `fk_RequerimientoDetalle_Material1` FOREIGN KEY (`Material_id`) REFERENCES `material` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_RequerimientoDetalle_Requerimiento1` FOREIGN KEY (`Requerimiento_id`) REFERENCES `requerimiento` (`id`);

--
-- Constraints for table `roles_permisos`
--
ALTER TABLE `roles_permisos`
  ADD CONSTRAINT `FK_roles_permisos_permiso` FOREIGN KEY (`id_permiso`) REFERENCES `permisos` (`id`),
  ADD CONSTRAINT `FK_roles_permisos_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
