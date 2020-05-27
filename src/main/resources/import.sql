INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES ('ROLE_USER');

INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('SN','IPCA','MARKET','4106861','Av Isabel la Catolica, Cuenca','ipca_cuenca@hotmail.es','2000-01-03');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0106385065','andres','bermeo','0990613829','Lazareto','pepeandy1998@gmail.com','1998-01-20');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0000000000','pablo ','chacon','SN','ciudadela kenedy','SN','2018-01-03');
INSERT INTO personas(cedula,nombre,apellido,telefono,direccion,email,fecha) VALUES ('0000000001','byron','anchundia','SN','plutarco y euclides','SN','2018-01-03');
			
INSERT INTO categorias(nombre) VALUES ('Papas');
INSERT INTO categorias(nombre) VALUES ('Bebidas');
INSERT INTO categorias(nombre) VALUES ('Galletas');

INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('123456789','Coca Cola 400ML','Bebida Coca Cola de 400 Militros a 50  centavos',0.50,20,5,2);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('123456780','Cola Fanta 400ML','Bebida Cola Fanta de 400 Militros a 50  centavos',0.50,20,5,2);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('123456781','Papas Ruffles Natural 200 GR','Papas Ruffles Naturales de 200 Gramos a 50  centavos',0.50,20,5,1);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('123456782','Papas Ruffles Picante 44 GR','Papas Ruffles Picantes de 44 Gramos a 50  centavos',0.50,20,5,1);
INSERT INTO productos(codigo_barras,nombre,descripcion,precio,cantidad_maxima,cantidad_minima,categoria_id) VALUES('123456783','Galleta Amor Chocolate 100 GR','Galleta Amor Pequeña de Chocolate a un dolar',1.00,20,5,3);

INSERT INTO usuarios(activo,username,password,persona_id) VALUES (true,'ipca','12345',1);
INSERT INTO usuarios(activo,username,password,persona_id) VALUES (true,'andres','12345',2);

INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (2,1);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (2,2);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES (1,1);


	       