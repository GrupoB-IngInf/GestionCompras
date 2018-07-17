USE dbcaso;

/*
Unidad de medida
*/
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (1,'UND');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (2,'KG');
INSERT INTO `unidadmedida` (`id`,`nombre`) VALUES (3,'BLD');

/*
Grupo
*/
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (1,'CLAVOS','CLAVOS DE TODO TAMAÑO');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (2,'PINTURA','TODO PINTURA');
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`) VALUES (3,'CEMENTO','');

/*
Material
*/
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (1,'CLAVO DE MEDIA PULGADA','CLAVO DE ACERO','Activo',2,1);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (2,'PINTURA LATEX LAVABLE','','Activo',3,2);
INSERT INTO `material` (`id`,`nombre`,`descripcion`,`estado`,`UnidadMedida_id`,`Grupo_id`) VALUES (3,'CEMENTO ANTISALITRE','','Activo',1,3);
