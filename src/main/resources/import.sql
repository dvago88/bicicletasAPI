INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (1,'dan','pass','daniel','antonio','vargas',11111,22222,'da@fake.com','calle1','cc:f6:ab:b2',TRUE,1);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (2,'jor','pass','jorge','eduardo','duran',11111,22222,'du@fake.com','calle12','65:1d:82:bb',TRUE,1);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (3,'test01','test01','test01','test01','test01',11111,22222,'test01','test01','1a:52:a7:89',TRUE,1);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (4,'test02','test02','test02','test02','test02',11111,22222,'test02','test02','e5:83:24:d9',TRUE,1);

-- INSERT INTO historial(id,user_id,station_id,fechaSalida,fechaIngreso) VALUES