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

<<<<<<< HEAD
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
=======
/*Banco*/
INSERT INTO  `banco` (`id`,`nombre`,`estado`) VALUES (1,'BBVA Continental','Activo');
INSERT INTO  `banco` (`id`,`nombre`,`estado`) VALUES (2,'Banco de Crédito del Perú','Activo');
INSERT INTO  `banco` (`id`,`nombre`,`estado`) VALUES (3,'Banco Financiero','Activo');
INSERT INTO  `banco` (`id`,`nombre`,`estado`) VALUES (4,'Interbank','Activo');
INSERT INTO  `banco` (`id`,`nombre`,`estado`) VALUES (5,'Banco Azteca','Activo');

/*Proveedor*/
INSERT INTO  `proveedor` (`id`,`nombre`,`ruc`, `direccion`,`contacto`,`correo`,`cuenta_corriente`,`telefono`,`estado`,`id_banco`) 
VALUES (1,'El Acero Bohler','10254365869','Castro Ronceros 777, Cercado de Lima','Marcelo Hugo Moreno Lara','aceros.boh@gmail.com','301-78654567-0-21','956453422','Activo',1);
INSERT INTO  `proveedor` (`id`,`nombre`,`ruc`, `direccion`,`contacto`,`correo`,`cuenta_corriente`,`telefono`,`estado`,`id_banco`) 
VALUES (2,'Maderera Nueva Era','17765598231','Los Nogales Mz. F lote 9 Urb. Parc. Huertos de Villena, Lurin','Enrique Gustavo Romero Cerna','maderera_nva_era@gmail.com','301-87675544-0-11','922436594','Activo',1);
INSERT INTO  `proveedor` (`id`,`nombre`,`ruc`, `direccion`,`contacto`,`correo`,`cuenta_corriente`,`telefono`,`estado`,`id_banco`) 
VALUES (3,'Vidrios y Cristales SOPRAN','23654478651','Av. Ruiz Cortines 3220 Pte. Colonia, Surquillo','Juan Jose Meza Quintadilla','sopran.vidrios@gmail.com','311-54657321-0-12','966745311','Activo',2);
INSERT INTO  `proveedor` (`id`,`nombre`,`ruc`, `direccion`,`contacto`,`correo`,`cuenta_corriente`,`telefono`,`estado`,`id_banco`) 
VALUES (4,'Cementos Indu','20785649102','Av. Pizarro 608, Cercado de Lima','Ernesto Josue Moreno Saavedra','indu_ce@gmail.com','321-88675462-0-32','956996433','Activo',1);
INSERT INTO  `proveedor` (`id`,`nombre`,`ruc`, `direccion`,`contacto`,`correo`,`cuenta_corriente`,`telefono`,`estado`,`id_banco`) 
VALUES (5,'Viesgo Ligth Empresa','87556366210','Av. Faucet 564, Surquillo','Jose Luis Rojas Ruiz','ligth_viesgo.10@gmail.com','361-76843109-0-34','971988832','Activo',5);

/* Centro de Costo */
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (1, 'Administración y Finanzas', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (2, 'Contabilidad', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (3, 'Tesoreria', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (5, 'Administración', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (6, 'RRHH', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (8, 'Administración Ica', 'Activo');
INSERT INTO `centro_de_costo` (`id`, `nombre`, `estado`) VALUES (9, 'Administración Piura', 'Activo');
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

>>>>>>> faaa6c93e2b46aad263eb07358f5f222538bcf89
