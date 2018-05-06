CREATE TABLE USUARIO (ID BIGINT NOT NULL, LOCALIDAD VARCHAR(255) NOT NULL, NIF VARCHAR(255) NOT NULL, APELLIDOS VARCHAR(255) NOT NULL, CODIGO_POSTAL INTEGER NOT NULL, CONTRASENIA VARCHAR(255) NOT NULL, CUOTA_TOTAL INTEGER NOT NULL, DIRECCION VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL, FECHA_BAJA DATE, FECHA_INGRESO DATE NOT NULL, FECHA_NACIMIENTO DATE NOT NULL, METODO_PAGO VARCHAR(255), MOVIL INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PROVINCIA VARCHAR(255) NOT NULL, SEXO VARCHAR(255) NOT NULL, TELEFONO INTEGER NOT NULL, PERFILES_ROL BIGINT, RESPONSABLE_ID BIGINT, SECCION_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE PERFIL (ROL BIGINT NOT NULL, PRIMARY KEY (ROL))
CREATE TABLE PAGO_CUOTA (ID BIGINT NOT NULL, TIPO_PAGO VARCHAR(255) NOT NULL, CANTIDAD_PAGADA INTEGER NOT NULL, FECHA_DEL_PAGO DATE NOT NULL, USUARIOS_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE COMENTARIO (ID BIGINT NOT NULL, FECHA_CREACION DATE NOT NULL, TEXTO VARCHAR(255) NOT NULL, EVENTO_ID BIGINT, USUARIO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE DOCUMENTO (ID BIGINT NOT NULL, ESTADO VARCHAR(255) NOT NULL, FECHA_ENTREGA DATE, TIPO VARCHAR(255) NOT NULL, EVENTO_ID BIGINT, USUARIO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE EVENTO (ID BIGINT NOT NULL, DESCRIPCION VARCHAR(255), FECHA DATE NOT NULL, LOCALIZACION VARCHAR(255) NOT NULL, PRECIO INTEGER, TITULO VARCHAR(255) NOT NULL, SECCION_ID BIGINT, USUARIO_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE SECCION (ID BIGINT NOT NULL, EDAD_MAXIMA INTEGER, EDAD_MINIMA INTEGER, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE PRIVILEGIOS (ID BIGINT NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE NOTIFICACION (TEXTO VARCHAR(255) NOT NULL, TITULO VARCHAR(255) NOT NULL, EVENTO_ID BIGINT NOT NULL, USUARIO_ID BIGINT NOT NULL, PRIMARY KEY (EVENTO_ID, USUARIO_ID))
CREATE TABLE RESPONSABLE_LEGAL (ID BIGINT NOT NULL, APELLIDOS VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE inscripcion (id_usuario BIGINT NOT NULL, id_evento BIGINT NOT NULL, PRIMARY KEY (id_usuario, id_evento))
CREATE TABLE privilegios_asociados (perfil_user BIGINT NOT NULL, privilegios_user BIGINT NOT NULL, PRIMARY KEY (perfil_user, privilegios_user))
ALTER TABLE USUARIO ADD CONSTRAINT SUARIORSPONSABLEID FOREIGN KEY (RESPONSABLE_ID) REFERENCES RESPONSABLE_LEGAL (ID)
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_SECCION_ID FOREIGN KEY (SECCION_ID) REFERENCES SECCION (ID)
ALTER TABLE USUARIO ADD CONSTRAINT USUARIOPERFILESROL FOREIGN KEY (PERFILES_ROL) REFERENCES PERFIL (ROL)
ALTER TABLE PAGO_CUOTA ADD CONSTRAINT PAGOCUOTASUARIOSID FOREIGN KEY (USUARIOS_ID) REFERENCES USUARIO (ID)
ALTER TABLE COMENTARIO ADD CONSTRAINT COMENTARIOEVENTOID FOREIGN KEY (EVENTO_ID) REFERENCES EVENTO (ID)
ALTER TABLE COMENTARIO ADD CONSTRAINT COMENTARIOSUARIOID FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID)
ALTER TABLE DOCUMENTO ADD CONSTRAINT DOCUMENTOEVENTO_ID FOREIGN KEY (EVENTO_ID) REFERENCES EVENTO (ID)
ALTER TABLE DOCUMENTO ADD CONSTRAINT DOCUMENTOUSUARIOID FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID)
ALTER TABLE EVENTO ADD CONSTRAINT EVENTO_USUARIO_ID FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID)
ALTER TABLE EVENTO ADD CONSTRAINT EVENTO_SECCION_ID FOREIGN KEY (SECCION_ID) REFERENCES SECCION (ID)
ALTER TABLE NOTIFICACION ADD CONSTRAINT NTIFICACIONVENTOID FOREIGN KEY (EVENTO_ID) REFERENCES EVENTO (ID)
ALTER TABLE NOTIFICACION ADD CONSTRAINT NTIFICACIONSARIOID FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO (ID)
ALTER TABLE inscripcion ADD CONSTRAINT nscripcionidevento FOREIGN KEY (id_evento) REFERENCES EVENTO (ID)
ALTER TABLE inscripcion ADD CONSTRAINT nscripciondusuario FOREIGN KEY (id_usuario) REFERENCES USUARIO (ID)
ALTER TABLE privilegios_asociados ADD CONSTRAINT prvlgsscdsprvlgssr FOREIGN KEY (privilegios_user) REFERENCES PRIVILEGIOS (ID)
ALTER TABLE privilegios_asociados ADD CONSTRAINT prvlgsscadosprflsr FOREIGN KEY (perfil_user) REFERENCES PERFIL (ROL)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
