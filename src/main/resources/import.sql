INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES ('ROLE_DOCENTE');
INSERT INTO roles(nombre) VALUES ('ROLE_ESTUDIANTE');

INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('SN','IPCA','MARKET','4106861','AV ISABEL LA CATÓLICA , CUENCA','ipca_cuenca@hotmail.es','2000-01-03');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0106385065','ANDRES','BERMEO','0990613829','LAZARETO','pepeandy1998@gmail.com','1998-01-20');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0000000000','PABL0 ','CHACON','SN','CIUDADELA KENEDY','SN','2018-01-03');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0000000001','BYRON','ANCHUNDIA','SN','PLUTARCO Y EUCLIDES','SN','2018-01-03');
			
INSERT INTO categorias(nombre) VALUES ('PAPAS');
INSERT INTO categorias(nombre) VALUES ('BEBIDAS');
INSERT INTO categorias(nombre) VALUES ('GALLETAS');

INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('1234567890','COCA COLA 400ML','BEBIDA COCA COLA DE 400 MILILITROS A 50 CENTAVOS',0.50,20,5,2);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('1234567891','COLA FANTA 400ML','BEBIDA COLA FANTA DE 400 MILILITROS A 50 CENTAVOS',0.50,20,5,2);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('1234567892','PAPAS RUFFLES NATURAL 200 GR','PAPAS RUFFLES NATURALES DE 200 GRAMOS A 50 CENTAVOS',0.50,20,5,1);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('1234567893','PAPAS RUFFLES PICANTE 44 GR','PAPAS RUFFLES PICANTES DE 44 GRAMOS A 50 CENTAVOS',0.50,20,5,1);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('1234567894','GALLETA AMOR DE CHOCOLATE 100 GR','GALLETA AMOR PEQUEÑA DE 100 GR SABOR A CHOCOLATE A UN DOLAR',1.00,20,5,3);

INSERT INTO usuarios(activo,username,password,persona_id) VALUES (true,'ipca','$2a$10$33FTBUYA86fzgrnp8v3H.u9KKZ0yzQzZ.3mXFppIfwhfufxZmaQOO',1);
INSERT INTO usuarios(activo,username,password,persona_id) VALUES (true,'andres','$2a$10$33FTBUYA86fzgrnp8v3H.u9KKZ0yzQzZ.3mXFppIfwhfufxZmaQOO',2);

INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (2,1);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (2,2);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (1,1);
INSERT INTO facturas (fecha,observacion,usuario_id) VALUES (now(),'',1);
INSERT INTO facturas (fecha,observacion,usuario_id) VALUES (now(),'',1);
INSERT INTO facturas (fecha,observacion,usuario_id) VALUES (now(),'',2);
INSERT INTO facturas (fecha,observacion,usuario_id) VALUES (now(),'',2);

INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,1,1);
INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,2,1);

INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,3,2);
INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,4,2);

INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,4,3);
INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (1,1,5,3);

INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,1,4);
INSERT INTO detalles_facturas (cantidad,total,producto_id,factura_id) VALUES (2,1,1,4);