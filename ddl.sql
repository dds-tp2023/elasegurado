-- CREACION DE TABLAS
CREATE TABLE pais (
	id SERIAL NOT NULL CONSTRAINT pk_id_pais PRIMARY KEY,
	nombre_pais VARCHAR(30)
);

CREATE TABLE provincia (
	id SERIAL NOT NULL CONSTRAINT pk_id_provincia PRIMARY KEY,
	nombre_provincia VARCHAR(50),
	id_pais INTEGER NOT NULL,
	CONSTRAINT fk_id_pais FOREIGN KEY(id_pais) REFERENCES pais(id)
);

CREATE TABLE localidad (
	id SERIAL NOT NULL CONSTRAINT pk_id_localidad PRIMARY KEY,
	nombre_localidad VARCHAR(50),
	codigo_postal VARCHAR(4),
	id_provincia INTEGER NOT NULL,
	CONSTRAINT fk_id_provincia FOREIGN KEY(id_provincia) REFERENCES provincia(id)
);

CREATE TABLE tipo_cobertura (
	id SERIAL NOT NULL CONSTRAINT pk_id_tipo_cobertura PRIMARY KEY,
	nombre VARCHAR(255) CHECK (nombre IN ('RESPONSABILIDAD_CIVIL', 'RESP_CIVIL_ROBO_O_INCENDIO_TOTAL',
									  'TODO_TOTAL', 'TERCEROS_COMPLETOS', 'TODO_RIESGO_CON_FRANQUICIA'))
);

CREATE TABLE usuario (
	id SERIAL NOT NULL CONSTRAINT pk_id_usuario PRIMARY KEY,
	rol VARCHAR(255) CHECK (rol IN ('GERENCIA','PRODUCTOR_SEGURO','COBRADOR')),
	nombre_usuario VARCHAR(15),
	contrasenia VARCHAR(20)
);

CREATE TABLE registro_auditoria (
	id SERIAL NOT NULL CONSTRAINT pk_id_registro_auditoria PRIMARY KEY,
	accion VARCHAR(255) CHECK (accion IN ('CREACION','MODIFICACION','ELIMINACION')),
	fecha_modificacion DATE,
	id_usuario INTEGER NOT NULL,
	CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id)
);

CREATE TABLE ajuste_localidad (
	id SERIAL NOT NULL CONSTRAINT pk_id_ajuste_localidad PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual FLOAT,
	id_localidad INTEGER NOT NULL,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id)
);

CREATE TABLE ajuste_tipo_cobertura (
	id SERIAL NOT NULL CONSTRAINT pk_id_ajuste_tipo_cobertura PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual FLOAT,
	id_tipo_cobertura INTEGER NOT NULL,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_tipo_cobertura FOREIGN KEY(id_tipo_cobertura) REFERENCES tipo_cobertura(id),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id)
);

CREATE TABLE pago (
	id SERIAL NOT NULL CONSTRAINT pk_id_pago PRIMARY KEY,
	nro_poliza VARCHAR(13),
	nro_recibo VARCHAR(10),
	fecha_hora TIMESTAMP,
	importe FLOAT,
	vuelto FLOAT,
	id_usuario INTEGER NOT NULL,
	CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id)
);

CREATE TABLE direccion (
	id SERIAL NOT NULL CONSTRAINT pk_id_direccion PRIMARY KEY,
	calle VARCHAR(40),
	nro VARCHAR(5),
	piso VARCHAR(2),
	dpto VARCHAR(10),
	id_localidad INTEGER NOT NULL,
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id)
);

CREATE TABLE cliente (
	id SERIAL NOT NULL CONSTRAINT pk_id_cliente PRIMARY KEY,
	nro_cliente VARCHAR(11),
	apellido VARCHAR(50),
	nombre VARCHAR(50),
	tipo_documento VARCHAR(255) CHECK (tipo_documento IN ('DNI','LE','PASAPORTE', 'LC')),
	nro_documento VARCHAR(10),
	cuil VARCHAR(13),
	sexo VARCHAR(255) CHECK (sexo IN ('MASCULINO','FEMENINO')),
	fecha_nacimiento DATE,
	condicion_de_iva VARCHAR(255) CHECK (condicion_de_iva IN ('RESPONSABLE_INSCRIPTO','SUJETO_EXENTO','CONSUMIDOR_FINAL')),
	email VARCHAR(50),
	estado_civil VARCHAR(255) CHECK (estado_civil IN ('SOLTERO','CASADO','VIUDO', 'DIVORCIADO')),
	profesion VARCHAR(50),
	anio_registro DATE,
	condicion VARCHAR(255) NOT NULL CHECK (condicion IN ('NORMAL','ACTIVO','PLATA')),
	eliminado BOOLEAN,
	id_direccion INTEGER NOT NULL,
	CONSTRAINT fk_id_direccion FOREIGN KEY(id_direccion) REFERENCES direccion(id)
);

CREATE TABLE parametro_poliza (
	id SERIAL NOT NULL CONSTRAINT pk_id_parametro_poliza PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	porcentaje_por_cada_diez_mil_km FLOAT,
	porcentaje_sin_siniestro FLOAT,
	porcentaje_un_siniestro FLOAT,
	porcentaje_dos_siniestro FLOAT,
	porcentaje_mas_de_dos_siniestro FLOAT,
	porcentaje_por_hijo_registrado FLOAT,
	descuento_por_unidad_adicional FLOAT,
	descuento_por_pago_semestral FLOAT,
	valor_derecho_de_emision FLOAT,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id)
);

CREATE TABLE medida_seguridad (
	id SERIAL NOT NULL CONSTRAINT pk_id_medida_seguridad PRIMARY KEY,
	nombre VARCHAR(50)
);

CREATE TABLE ajuste_medida_seguridad (
	id SERIAL NOT NULL CONSTRAINT pk_id_ajuste_medida_seguridad PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual FLOAT,
	id_medida_seguridad INTEGER NOT NULL,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id)
);

CREATE TABLE marca (
	id SERIAL NOT NULL CONSTRAINT pk_id_marca PRIMARY KEY,
	nombre_marca VARCHAR(40)
);

CREATE TABLE modelo (
	id SERIAL NOT NULL CONSTRAINT pk_id_modelo PRIMARY KEY,
	nombre_modelo VARCHAR(40),
	id_marca INTEGER NOT NULL,
	CONSTRAINT fk_id_marca FOREIGN KEY(id_marca) REFERENCES marca(id)
);

CREATE TABLE ajuste_modelo (
	id SERIAL NOT NULL CONSTRAINT pk_id_ajuste_modelo PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual FLOAT,
	id_modelo INTEGER NOT NULL,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id)
);

CREATE TABLE anio_fabricacion (
	id SERIAL NOT NULL CONSTRAINT pk_id_anio_fabricacion PRIMARY KEY,
	anio VARCHAR(4)
);

CREATE TABLE suma_asegurada (
	id SERIAL NOT NULL,
	id_modelo INTEGER NOT NULL,
	id_anio_fabricacion INTEGER NOT NULL,
	suma_asegurada FLOAT NOT NULL,
	CONSTRAINT pk_id PRIMARY KEY(id),
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id),
	CONSTRAINT fk_id_anio_fabricacion FOREIGN KEY(id_anio_fabricacion) REFERENCES anio_fabricacion(id)
);

CREATE TABLE poliza (
	id SERIAL NOT NULL CONSTRAINT pk_id_poliza PRIMARY KEY,
	motor VARCHAR(20) NOT NULL,
	cantidad_siniestros VARCHAR(255) NOT NULL CHECK (cantidad_siniestros IN ('NINGUNO','UNO','DOS', 'MAS_DE_DOS')),
	fecha_inicio_vigencia DATE NOT NULL,
	fecha_fin_vigencia DATE NOT NULL,
	patente VARCHAR(20),
	estado VARCHAR(255) NOT NULL CHECK (estado IN ('GENERADA','SUSPENDIDA','VIGENTE', 'NO_VIGENTE')),
	km_por_anio INTEGER NOT NULL,
	nro_poliza VARCHAR(13) NOT NULL,
	forma_pago VARCHAR(255) NOT NULL CHECK (forma_pago IN ('MENSUAL','SEMESTRAL')),
	chasis VARCHAR(50) NOT NULL,
	valor_descuento FLOAT NOT NULL,
	valor_premio FLOAT NOT NULL,
	id_modelo INTEGER NOT NULL,
	id_localidad INTEGER NOT NULL,
	id_parametro_poliza INTEGER NOT NULL,
	id_cliente INTEGER NOT NULL,
	id_tipo_cobertura INTEGER NOT NULL,
	id_anio_fabricacion INTEGER NOT NULL,
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id),
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id),
	CONSTRAINT fk_id_parametro_poliza FOREIGN KEY(id_parametro_poliza) REFERENCES parametro_poliza(id),
	CONSTRAINT fk_id_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id),
	CONSTRAINT fk_id_tipo_cobertura FOREIGN KEY(id_tipo_cobertura) REFERENCES tipo_cobertura(id),
	CONSTRAINT fk_id_anio_fabricacion FOREIGN KEY(id_anio_fabricacion) REFERENCES anio_fabricacion(id)
);

CREATE TABLE solicitud_poliza (
	id SERIAL NOT NULL CONSTRAINT pk_id_solicitud_poliza PRIMARY KEY,
	nro_solicitud_poliza VARCHAR(7) NOT NULL,
	motor VARCHAR(20) NOT NULL,
	chasis VARCHAR(50) NOT NULL,
	patente VARCHAR(20),
	km_por_anio INTEGER NOT NULL,
	cantidad_siniestros VARCHAR(255) NOT NULL CHECK (cantidad_siniestros IN ('NINGUNO','UNO','DOS', 'MAS_DE_DOS')),
	id_anio_fabricacion INTEGER NOT NULL,
	id_modelo INTEGER NOT NULL,
	id_registro_auditoria INTEGER,
	id_poliza INTEGER NOT NULL,
	CONSTRAINT fk_id_anio_fabricacion FOREIGN KEY(id_anio_fabricacion) REFERENCES anio_fabricacion(id),
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id),
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id)
);

CREATE TABLE posee (
	id_poliza INTEGER NOT NULL,
	id_medida_seguridad INTEGER NOT NULL,
	CONSTRAINT pk_id_poliza_id_medida_seguridad PRIMARY KEY(id_poliza, id_medida_seguridad),
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id),
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id)
);

CREATE TABLE asociado_a (
	id_solicitud_poliza INTEGER NOT NULL,
	id_medida_seguridad INTEGER NOT NULL,
	CONSTRAINT pk_id_solicitud_poliza_id_medida_seguridad PRIMARY KEY(id_solicitud_poliza, id_medida_seguridad),
	CONSTRAINT fk_id_solicitud_poliza FOREIGN KEY(id_solicitud_poliza) REFERENCES solicitud_poliza(id),
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id)
);

CREATE TABLE hijo_declarado (
	id SERIAL NOT NULL CONSTRAINT pk_id_hijo_declarado PRIMARY KEY,
	fecha_nacimiento DATE,
	sexo VARCHAR(255) CHECK (sexo IN ('MASCULINO','FEMENINO')),
	estado_civil VARCHAR(255) CHECK (estado_civil IN ('SOLTERO','CASADO','VIUDO', 'DIVORCIADO')),
	id_poliza INTEGER NOT NULL,
	id_solicitud_poliza INTEGER,
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id),
	CONSTRAINT fk_id_solicitud_poliza FOREIGN KEY(id_solicitud_poliza) REFERENCES solicitud_poliza(id)
);

CREATE TABLE cuota (
	id SERIAL NOT NULL CONSTRAINT pk_id_cuota PRIMARY KEY,
	nro_cuota INTEGER,
	mes_abonado VARCHAR(10),
	estado VARCHAR(255) CHECK (estado IN ('PAGO','IMPAGO')),
	estado_pago_cuota VARCHAR(255) CHECK (estado_pago_cuota IN ('ADELANTADA','MORA','EN_TERMINO')),
	recargo_mora FLOAT,
	ultimo_dia_de_pago DATE,
	bonificacion_pago_adelantado FLOAT,
	anio_abonado VARCHAR(4),
	monto FLOAT,
	id_poliza INTEGER NOT NULL,
	id_pago INTEGER,
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id),
	CONSTRAINT fk_id_pago FOREIGN KEY(id_pago) REFERENCES pago(id)
);