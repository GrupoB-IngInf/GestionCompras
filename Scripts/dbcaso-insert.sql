USE dbcaso;

/*Unidad de medida*/
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (1,'UND');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (2,'KG');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (3,'BLD');

/*Grupo*/
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (1,'CLAVOS','CLAVOS DE TODO TAMA脩O');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (2,'PINTURA','TODO PINTURA');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (3,'CEMENTO','');

/* Material*/
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (1,'CLAVO DE MEDIA PULGADA','CLAVO DE ACERO','Activo',2,1);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (2,'PINTURA LATEX LAVABLE','','Activo',3,2);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (3,'CEMENTO ANTISALITRE','','Activo',1,3);

/* Area de negocio */
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AC', 'Atenci贸n al Cliente');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AI', 'Administraci贸n Ica');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AL', 'Administraci贸n Lima');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('MA', 'Mantenimiento');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('MK', 'Marketing');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('OS', 'Osi');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('PC', 'Producci贸n/Urbanismo');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('SE', 'Seguridad');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('VC', 'Ventas/Cr茅dito y Cobranza');

/* Centro de Costo */
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (1, 'Administraci髇 y Finanzas', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (2, 'Contabilidad', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (3, 'Tesoreria', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (5, 'Administraci髇', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (6, 'RRHH', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (8, 'Administraci髇 Ica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (9, 'Administraci髇 Piura', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (10, 'Legal', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (11, 'Legal Ica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (12, 'Legal Piura', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (13, 'Operaciones', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (14, 'Operaciones Ica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (15, 'Planta', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (16, 'Planta Concreto', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (17, 'Urbanismo', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (18, 'Mantenimiento', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (19, 'Proyectos', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (20, 'Logistica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (21, 'Piura', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (22, 'Utilidad Piura', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (24, 'Comercial Ica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (25, 'Comercial Piura', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (26, 'Comercial', 'Activo');