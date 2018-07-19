USE dbcaso;

/*Unidad de medida*/
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (1,'UND');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (2,'KG');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (3,'BLD');

/*Grupo*/
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (1,'CLAVOS','CLAVOS DE TODO TAMAÑO');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (2,'PINTURA','TODO PINTURA');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (3,'CEMENTO','');

/* Material*/
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (1,'CLAVO DE MEDIA PULGADA','CLAVO DE ACERO','Activo',2,1);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (2,'PINTURA LATEX LAVABLE','','Activo',3,2);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (3,'CEMENTO ANTISALITRE','','Activo',1,3);

/* Area de negocio */
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AC', 'Atención al Cliente');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AI', 'Administración Ica');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('AL', 'Administración Lima');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('MA', 'Mantenimiento');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('MK', 'Marketing');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('OS', 'Osi');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('PC', 'Producción/Urbanismo');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('SE', 'Seguridad');
INSERT INTO `dbcaso`.`areanegocio` (`prefijo`, `nombre`) VALUES ('VC', 'Ventas/Crédito y Cobranza');

/* Usuario */
INSERT INTO `dbcaso`.`usuarios` (`id`, `nombres`,`apellidos`,`correo`,`contraseña`,`telefono`,`id_rol`,`estado`) VALUES (1, 'Luis','Chirinos Carranza','Chirinos@gmail.com','123456','123456789',1,'Activo');
INSERT INTO `dbcaso`.`usuarios` (`id`, `nombres`,`apellidos`,`correo`,`contraseña`,`telefono`,`id_rol`,`estado`) VALUES (2, 'Axel','Gutierrez Lopez','axl@gmail.com','123456','123456789',2,'Activo');

/* Rol */
insert into `dbcaso`.`roles` (`id`, `nombre`) VALUES (1, 'Administrador');
insert into `dbcaso`.`roles` (`id`, `nombre`) VALUES (2, 'Jefe de Compras');
insert into `dbcaso`.`roles` (`id`, `nombre`) VALUES (3, 'Encargado Compras');

/* Permiso */
insert into `dbcaso`.`permisos` (`id`, `nombre`) VALUES (1, 'Crear Requerimientos');
insert into `dbcaso`.`permisos` (`id`, `nombre`) VALUES (2, 'Editar Requerimientos');
insert into `dbcaso`.`permisos` (`id`, `nombre`) VALUES (3, 'Crear Orden de Compra');
insert into `dbcaso`.`permisos` (`id`, `nombre`) VALUES (4, 'Editar Orden de Compra');

/* roles_permisos */
insert into `dbcaso`.`roles_permisos` (`id`, `id_rol`,`id_permiso`) VALUES (1, 1,1);
insert into `dbcaso`.`roles_permisos` (`id`, `id_rol`,`id_permiso`) VALUES (2, 1,2);
insert into `dbcaso`.`roles_permisos` (`id`, `id_rol`,`id_permiso`) VALUES (3, 1,3);
insert into `dbcaso`.`roles_permisos` (`id`, `id_rol`,`id_permiso`) VALUES (4, 2,1);