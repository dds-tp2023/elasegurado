-- INSERT DE PAIS
INSERT INTO pais (nombre_pais)
	VALUES ('Argentina');

-- INSERT DE PROVINCIA
INSERT INTO provincia (nombre_provincia, id_pais)
	VALUES ('Santa Fe', 1);
INSERT INTO provincia (nombre_provincia, id_pais)
	VALUES ('Entre Rios', 1);
INSERT INTO provincia (nombre_provincia, id_pais)
	VALUES ('Cordoba', 1);
	
-- INSERT DE LOCALIDAD
INSERT INTO localidad (nombre_localidad, codigo_postal, id_provincia) 
	VALUES ('Santa Fe', '3000', 1);
INSERT INTO localidad (nombre_localidad, codigo_postal, id_provincia) 
	VALUES ('Gualeguaychu', '2820', 2);
INSERT INTO localidad (nombre_localidad, codigo_postal, id_provincia) 
	VALUES ('Cordoba', '5000', 3);

-- INSERT DE DIRECCION
INSERT INTO direccion (calle, nro, id_localidad) 
	VALUES ('Republica de Siria', '6523', 1);
INSERT INTO direccion (calle, nro, id_localidad) 
	VALUES ('Caseros', '530', 2);
INSERT INTO direccion (calle, nro, id_localidad) 
	VALUES ('25 de Mayo', '1234', 1);
INSERT INTO direccion (calle, nro, id_localidad) 
	VALUES ('25 de Mayo', '5600', 3);
INSERT INTO direccion (calle, nro, id_localidad) 
	VALUES ('Las Heras', '4800', 2);

-- INSERT DE CLIENTE
INSERT INTO cliente(
	nro_cliente, apellido, nombre, tipo_documento, nro_documento, cuil, sexo,
	fecha_nacimiento, condicion_de_iva, email, estado_civil, profesion, anio_registro, condicion,
	eliminado, id_direccion)
	VALUES ('54-00000000', 'Rodriguez', 'Lucas', 'DNI', '30123456', '20301234562', 'MASCULINO',
		   '1970-10-20', 'CONSUMIDOR_FINAL', 'lucasrod@gmail.com', 'SOLTERO', 'ABOGADO', TO_DATE('2023', 'YYYY'), 'ACTIVO',
		   FALSE, 1);
INSERT INTO cliente(
	nro_cliente, apellido, nombre, tipo_documento, nro_documento, cuil, sexo,
	fecha_nacimiento, condicion_de_iva, email, estado_civil, profesion, anio_registro, condicion,
	eliminado, id_direccion)
	VALUES ('54-00000002', 'Martinez', 'Carlos', 'DNI', '35876543', '20358765432', 'MASCULINO',
		   '1980-11-13', 'SUJETO_EXENTO', 'carlosmart@gmail.com', 'DIVORCIADO', 'ARQUITECTO', TO_DATE('2023', 'YYYY'), 'ACTIVO',
		   FALSE, 3);		   
INSERT INTO cliente(
	nro_cliente, apellido, nombre, tipo_documento, nro_documento, cuil, sexo,
	fecha_nacimiento, condicion_de_iva, email, estado_civil, profesion, anio_registro, condicion,
	eliminado, id_direccion)
	VALUES ('54-00000001', 'Suarez', 'Sandra', 'DNI', '20112233', '27201122332', 'FEMENINO',
		   '1966-11-27', 'RESPONSABLE_INSCRIPTO', 'sandrasuarez@gmail.com', 'CASADO', 'CONTADOR', TO_DATE('2023', 'YYYY'), 'ACTIVO',
		   FALSE, 2);
INSERT INTO cliente(
	nro_cliente, apellido, nombre, tipo_documento, nro_documento, cuil, sexo,
	fecha_nacimiento, condicion_de_iva, email, estado_civil, profesion, anio_registro, condicion,
	eliminado, id_direccion)
	VALUES ('54-00000003', 'Suipacha', 'Alejandra', 'DNI', '23152236', '27231522362', 'FEMENINO',
		   '1960-12-27', 'RESPONSABLE_INSCRIPTO', 'salejandra@gmail.com', 'CASADO', 'CONTADOR', TO_DATE('2023', 'YYYY'), 'ACTIVO',
		   FALSE, 4);
INSERT INTO cliente(
	nro_cliente, apellido, nombre, tipo_documento, nro_documento, cuil, sexo,
	fecha_nacimiento, condicion_de_iva, email, estado_civil, profesion, anio_registro, condicion,
	eliminado, id_direccion)
	VALUES ('54-00000004', 'Martinez', 'Lucila', 'DNI', '41152238', '27411522382', 'FEMENINO',
		   '1998-09-27', 'RESPONSABLE_INSCRIPTO', 'mlucila@gmail.com', 'CASADO', 'CONTADOR', TO_DATE('2023', 'YYYY'), 'ACTIVO',
		   FALSE, 5);
		   
-- INSERT DE USUARIO
INSERT INTO usuario(rol, nombre_usuario, contrasenia)
	VALUES ('PRODUCTOR_SEGURO', 'productor01', 'admin');   
INSERT INTO usuario(rol,nombre_usuario,contrasenia)
	VALUES ('COBRADOR','cobrador01','admin');

-- INSERT DE MARCA
INSERT INTO marca (nombre_marca) VALUES ('Ford');
INSERT INTO marca (nombre_marca) VALUES ('Fiat');
INSERT INTO marca (nombre_marca) VALUES ('Audi');
INSERT INTO marca (nombre_marca) VALUES ('Toyota');

-- INSERT DE MODELO
--Modelos Ford
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Fiesta',1);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Mustang',1);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Bronco',1);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Maverick',1);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('F-150',1);
--Modelos Fiat
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Cronos',2);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Strada',2);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Toro',2);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Fiorino',2);
--Modelos Audi
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('A1',3);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('A4',3);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('A7',3);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Q5',3);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Q8',3);
--Modelos Toyota
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Etios',4);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Corolla',4);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Yaris',4);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Hilux',4);
INSERT INTO modelo (nombre_modelo, id_marca) VALUES ('Land Cruiser',4);

-- INSERT DE ANIO_FABICACION
INSERT INTO anio_fabricacion (anio) VALUES ('2010');
INSERT INTO anio_fabricacion (anio) VALUES ('2011');
INSERT INTO anio_fabricacion (anio) VALUES ('2012');
INSERT INTO anio_fabricacion (anio) VALUES ('2013');
INSERT INTO anio_fabricacion (anio) VALUES ('2014');
INSERT INTO anio_fabricacion (anio) VALUES ('2015');
INSERT INTO anio_fabricacion (anio) VALUES ('2016');
INSERT INTO anio_fabricacion (anio) VALUES ('2017');
INSERT INTO anio_fabricacion (anio) VALUES ('2018');
INSERT INTO anio_fabricacion (anio) VALUES ('2019');
INSERT INTO anio_fabricacion (anio) VALUES ('2020');
INSERT INTO anio_fabricacion (anio) VALUES ('2021');
INSERT INTO anio_fabricacion (anio) VALUES ('2022');
INSERT INTO anio_fabricacion (anio) VALUES ('2023');

-- INSERT MEDIDA_SEGURIDAD
INSERT INTO medida_seguridad(nombre)
	VALUES ('se_guarda_en_garage');
INSERT INTO medida_seguridad(nombre)
	VALUES ('tiene_alarma');
INSERT INTO medida_seguridad(nombre)
	VALUES ('posee_dispositivos_de_rastreo');
INSERT INTO medida_seguridad(nombre)
	VALUES ('posee_tuercas_antirrobo');

-- INSERT TIPO_COBERTURA
INSERT INTO tipo_cobertura(nombre)
	VALUES ('RESPONSABILIDAD_CIVIL');
INSERT INTO tipo_cobertura(nombre)
	VALUES ('RESP_CIVIL_ROBO_O_INCENDIO_TOTAL');
INSERT INTO tipo_cobertura(nombre)
	VALUES ('TODO_TOTAL');
INSERT INTO tipo_cobertura(nombre)
	VALUES ('TERCEROS_COMPLETOS');
INSERT INTO tipo_cobertura(nombre)
	VALUES ('TODO_RIESGO_CON_FRANQUICIA');

-- INSERT SUMA_ASEGURADA
--Modelo fiesta año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (1,14,999999);
--Modelo Mustang año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (2,14,999999);
--Modelo Bronco año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (3,14,999999);
--Modelo Maverick año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (4,14,999999);
--Modelo F-150 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (5,14,999999);
--Modelo Cronos año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (6,14,999999);
--Modelo Strada año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (7,14,999999);
--Modelo Toro año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (8,14,999999);
--Modelo Fiorino año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (9,14,999999);
--Modelo A1 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (10,14,999999);
--Modelo A4 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (11,14,999999);
--Modelo A7 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (12,14,999999);
--Modelo Q5 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (13,14,999999);
--Modelo Q8 año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (14,14,999999);
--Modelo Etios año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (15,14,999999);
--Modelo Corolla año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (16,14,999999);
--Modelo Yaris año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (17,14,999999);
--Modelo Hilux año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (18,14,999999);
--Modelo Land Cruiser año fabricacion 2010-2023
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,1,222222);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,2,333333);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,3,444444);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,4,555555);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,5,666666);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,6,777000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,7,777500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,8,777900);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,9,800000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,10,808000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,11,880000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,12,888000);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,13,888500);
INSERT INTO suma_asegurada (id_modelo,id_anio_fabricacion,suma_asegurada) VALUES (19,14,999999);

-- INSERT DE REGISTRO_AUDITORIA
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);
INSERT INTO registro_auditoria(accion, fecha_modificacion, id_usuario)
	VALUES ('CREACION', '2023-11-15', 1);

-- INSERT DE AJUSTE_TIPO_COBERTURA
INSERT INTO ajuste_tipo_cobertura(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
								  id_tipo_cobertura, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.01280610, 1, 1);
INSERT INTO ajuste_tipo_cobertura(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
								  id_tipo_cobertura, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0256122, 2, 2);
INSERT INTO ajuste_tipo_cobertura(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
								  id_tipo_cobertura, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0384183, 3, 3);
INSERT INTO ajuste_tipo_cobertura(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
								  id_tipo_cobertura, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0512244, 4, 4);
INSERT INTO ajuste_tipo_cobertura(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
								  id_tipo_cobertura, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0640305, 5, 5);

-- INSERT DE AJUSTE_LOCALIDAD
INSERT INTO ajuste_localidad(fecha_inicio_vigencia, fecha_fin_vigencia,
									valor_porcentual, id_localidad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.01280610, 1, 6);
INSERT INTO ajuste_localidad(fecha_inicio_vigencia, fecha_fin_vigencia,
									valor_porcentual, id_localidad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0256122, 2, 7);
INSERT INTO ajuste_localidad(fecha_inicio_vigencia, fecha_fin_vigencia,
									valor_porcentual, id_localidad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0384183, 3, 8);

-- INSERT DE AJUSTE_MEDIDA_SEGURIDAD
INSERT INTO ajuste_medida_seguridad(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
										   id_medida_seguridad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.01280610, 1, 9);
INSERT INTO ajuste_medida_seguridad(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
										   id_medida_seguridad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0256122, 2, 10);
INSERT INTO ajuste_medida_seguridad(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
										   id_medida_seguridad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0384183, 3, 11);
INSERT INTO ajuste_medida_seguridad(fecha_inicio_vigencia, fecha_fin_vigencia, valor_porcentual,
										   id_medida_seguridad, id_registro_auditoria)
	VALUES ('2023-11-15', '2024-11-15', 0.0512244, 4, 12);
	
-- INSERT DE AJUSTE_MODELO
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.01280610,1,13);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0256122,2,14);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0384183,3,15);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0512244,4,16);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0640305,5,17);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0768366,6,18);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.0896427,7,19);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1024488,8,20);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1152549,9,21);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.128061,10,22);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1408671,11,23);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1536732,12,24);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1664793,13,25);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1792854,14,26);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.1920915,15,27);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.2048976,16,28);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.2177037,17,29);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.2305098,18,30);
INSERT INTO ajuste_modelo (fecha_inicio_vigencia,fecha_fin_vigencia,valor_porcentual,id_modelo,
						   id_registro_auditoria) 
	VALUES('2023-11-15','2024-11-15',0.2433159,19,31);

-- INSERT DE PARAMETRO POLIZA
INSERT INTO parametro_poliza (fecha_inicio_vigencia, fecha_fin_vigencia, porcentaje_por_cada_diez_mil_km,
							 porcentaje_sin_siniestro, porcentaje_un_siniestro, porcentaje_dos_siniestro,
							 porcentaje_mas_de_dos_siniestro, porcentaje_por_hijo_registrado, 
							 descuento_por_unidad_adicional, descuento_por_pago_semestral,valor_derecho_de_emision, id_registro_auditoria)
							 VALUES ('2020-11-15', '2024-11-15', 0.00840566,
									0, 0.00925994, 0.01530689,
									0.01157732, 0.00329591,
									0.05678593,0.25, 364, 32);

-- INSERT DE POLIZA
INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2021-01-01','2021-06-30','AD278FX','NO_VIGENTE',
							70000,'3528000000000','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2021-07-01','2021-12-31','AD278FX','NO_VIGENTE',
							80000,'3528000000001','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2022-01-01','2022-06-30','AD278FX','NO_VIGENTE',
							90000,'3528000000002','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2022-07-01','2022-12-31','AD278FX','NO_VIGENTE',
							100000,'3528000000003','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2023-01-01','2023-06-30','AD278FX','NO_VIGENTE',
							110000,'3528000000004','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

INSERT INTO poliza (motor,cantidad_siniestros,fecha_inicio_vigencia,fecha_fin_vigencia,patente,estado,
					km_por_anio,nro_poliza,forma_pago,chasis,valor_descuento,valor_premio,id_modelo,id_localidad,
					id_parametro_poliza,id_cliente,id_tipo_cobertura,id_anio_fabricacion)
					VALUES ('aaaaa','NINGUNO','2023-07-01','2023-12-31','AD278FX','VIGENTE',
							120000,'3528000000005','SEMESTRAL','aaaaa',15091,60000,1,1,1,1,1,1);

-- INSERT DE PAGO
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000000','0000000001','2020-12-31 12:00:00',45273,0,2);
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000001','0000000002','2021-06-30 12:00:00',45273,0,2);
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000002','0000000003','2021-12-31 12:00:00',45273,0,2);
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000003','0000000004','2022-06-30 12:00:00',45273,0,2);
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000004','0000000005','2022-12-31 12:00:00',45273,0,2);
INSERT INTO pago (nro_poliza,nro_recibo,fecha_hora,importe,vuelto,id_usuario)
			VALUES ('3528000000005','0000000006','2023-06-30 12:00:00',45273,0,2);

-- INSERT DE CUOTA
INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','ENERO','EN_TERMINO',0,'2020-12-31',0,'2021',45273,1,1);

INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','JULIO','EN_TERMINO',0,'2021-06-30',0,'2021',45273,2,2);

INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','ENERO','EN_TERMINO',0,'2021-12-31',0,'2022',45273,3,3);

INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','JULIO','EN_TERMINO',0,'2022-06-30',0,'2022',45273,4,4);

INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','ENERO','EN_TERMINO',0,'2022-12-31',0,'2023',45273,5,5);

INSERT INTO cuota (nro_cuota,estado,mes_abonado,estado_pago_cuota,recargo_mora,ultimo_dia_de_pago,
					bonificacion_pago_adelantado,anio_abonado,monto,id_poliza,id_pago)
					VALUES (1,'PAGO','JULIO','EN_TERMINO',0,'2023-06-30',0,'2023',45273,6,6);