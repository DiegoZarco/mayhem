insert into EMPRESA (id, nombre) values (EMPRESA_SEQ.NEXTVAL, 'Sanitas Hospitales S.A');
insert into EMPRESA (id, nombre) values (EMPRESA_SEQ.NEXTVAL, 'Consulta Medico prueba');

insert into CENTRO(id, nombre, codigo, empresa_id) values (CENTRO_SEQ.NEXTVAL, 'Hospital de la moraleja', 'CH0089', 1);
insert into CENTRO(id, nombre, codigo, empresa_id) values (CENTRO_SEQ.NEXTVAL, 'Virgen del mar', 'CH0068', 1);
insert into CENTRO(id, nombre, codigo, empresa_id) values (CENTRO_SEQ.NEXTVAL, 'Manises', 'CH0878', 1);
-- Asociado a la empresa prueba
insert into CENTRO(id, nombre, codigo, empresa_id) values (CENTRO_SEQ.NEXTVAL, 'Consulta Mecido Prueba', 'CH0001', 2);

insert into PROVEEDOR (id, nombre, apellido1, apellido2) values (PROVEEDOR_SEQ.NEXTVAL, 'nombre', 'apellido1', 'apellido2');

insert into SERVICIO (id, descripcion) values (SERVICIO_SEQ.NEXTVAL, 'ALERGOLOGIA');

insert into PRESTACION (id, servicio_id, descripcion, precio) values (PRESTACION_SEQ.NEXTVAL, 1, 'Primera visita', 50.35);
insert into PRESTACION (id, servicio_id, descripcion, precio) values (PRESTACION_SEQ.NEXTVAL, 1, 'Espirometria', 50.35);
insert into PRESTACION (id, servicio_id, descripcion, precio) values (PRESTACION_SEQ.NEXTVAL, 1, 'Parches', 50.35);

--Enlazamos los servicios con los centros
insert into SERVICIO_CENTRO(SERVICIO_ID, centros_id) values (1, 1);
insert into SERVICIO_CENTRO(SERVICIO_ID, centros_id) values (1, 2);

--Clientes
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido1_1', 'Apellido1_2', '01234567X', 'Madrid', '1989-11-09', 'Nombre1', '916123451', '696969661', 1);
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido2_1', 'Apellido2_2', '12345678X', 'Madrid', '1989-12-09', 'Nombre2', '916123452', '696969662', 1);
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido3_1', 'Apellido3_2', '12345678X', 'Madrid', '1989-12-09', 'Nombre3', '916123453', '696969663', 1);
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido4_1', 'Apellido4_2', '12345678X', 'Madrid', '1989-12-09', 'Nombre4', '916123454', '696969664', 1);
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido5_1', 'Apellido5_2', '12345678X', 'Madrid', '1989-12-09', 'Nombre5', '916123455', '696969665', 1);
insert into CLIENTE (id, apellido1, apellido2, documento, domicilio, fecha_nac, nombre, telefono1, telefono2, empresa_id)
values (CLIENTE_SEQ.NEXTVAL, 'Apellido6_1', 'Apellido6_2', '12345678X', 'Madrid', '1989-12-09', 'Nombre6', '916123456', '696969666', 1);