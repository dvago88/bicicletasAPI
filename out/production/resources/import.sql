-----------------------------------------------
--                 ROLES                     --
-----------------------------------------------
INSERT INTO role (name) VALUES ('ROLE_SUPERADMIN');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_MINIADMIN');
INSERT INTO role (name) VALUES ('ROLE_RASPBERRY');
INSERT INTO role (name) VALUES ('ROLE_USER');

-----------------------------------------------
--              ORGANIZACIONES               --
-----------------------------------------------
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Centro Empresarial Ciudad del Rio','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567);
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Otro Centro Empresarial Por Ahí','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567);
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Un Centro Empresarial Importante','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Cundinamarca','Bogotá','Medellín??',1234567,2345678,3001234567);
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Otro Hijuemadre Centro Empresarial','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Itagui','Medellín??',1234567,2345678,3001234567);
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Super Centro Empresarial de Envigado','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Envigado','Medellín??',1234567,2345678,3001234567);
INSERT INTO organizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular) VALUES ('Otro Super Centro','deshabilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567);

-----------------------------------------------
--              SUBORGANIZACIONES            --
-----------------------------------------------
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 1','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,1);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 2','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,1);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 3','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,1);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 4','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,1);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 5','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,1);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 6','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,2);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 7','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,2);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 8','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,2);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 9','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,2);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 10','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,2);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 11','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,3);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 12','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,3);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 13','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,3);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 14','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,4);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 15','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,4);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 16','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,4);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 17','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,4);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 18','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,5);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 19','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,5);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 20','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,5);
INSERT INTO Suborganizacion (nombre,estado,razonSocial,nit_identificacion,email,direccion,pais,departamento,ciudad,municipio,telefono,telefono2,celular,organizacion_id) VALUES ('Sub Organización de prueba 21','habilitado','NPI','12345','cenempciuderi@hotmail.com','Calle falsa 123','Colombia','Antioquia','Medellín','Medellín??',1234567,2345678,3001234567,5);

-----------------------------------------------
--              USUARIOS                     --
-----------------------------------------------
-- passwords:
-- raspberry
-- pass
-- LaBici2018*
-- test
-- test
-- https://www.browserling.com/tools/bcrypt
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES ('raspberry','$2a$10$ha.rxMICv6OKpxkt.tqvTOK3mnCCjY6avP4sEabi8ynvBU7qOLK6q','rasp','berry','pi',00000,00000,'rasp@fake.com','N/A','N/A',TRUE,4,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES ('dan','$2a$10$us4QTd2e4dcuKZxouL4G6u.iQ0B9HIAxNmBIv48GMMvJ9l9qoKC5S','daniel','antonio','vargas',11111,22222,'da@fake.com','calle1','987654321',TRUE,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES ('Sadmin','$2a$10$OWFpGAzXpA97ZW5S/khGJeBxrwx8a.//dhKa/ybAdtXcgUP45em7q','jorge','eduardo','duran',11111,22222,'du@fake.com','calle12','13245678910',TRUE,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id, sexo) VALUES ('admin01','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Andrea','','Castillo',11111,22222,'generico1@hotmail.com','Calle 123','876543210',TRUE,2,1,'F');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id, sexo) VALUES ('admin02','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Santiago','David','Morales',11111,22222,'generico2@hotmail.com','Calle 123','765432101',TRUE,2,2,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id, sexo) VALUES ('admin03','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Karina','Maria','De La Espriella',11111,22222,'generico3@hotmail.com','Calle 123','7654321012',TRUE,2,3,'F');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id, sexo) VALUES ('admin04','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Alejandro','','Restrepo',11111,22222,'generico4@hotmail.com','Calle 123','234567891011',TRUE,2,4,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id, sexo) VALUES ('admin05','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Mario','','Gómez',11111,22222,'generico5@hotmail.com','Calle 123','23456789101',TRUE,2,5,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('miniadmin01','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Sandra','Camila','Cardona',11111,22222,'generico6@hotmail.com','Calle 123','34567891011',TRUE,3,1,1,'F');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('miniadmin02','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Mariano','','Sanchez',11111,22222,'generico7@hotmail.com','Calle 123','456789101112',TRUE,3,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('miniadmin03','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Santiago','','Correa',11111,22222,'generico8@hotmail.com','Calle 123','5678910111213',TRUE,3,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('miniadmin04','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Juan','Pablo','Duque',11111,22222,'generico9@hotmail.com','Calle 123','678910111213',TRUE,3,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('miniadmin05','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Manuel','','Zuluaga',11111,22222,'generico10@hotmail.com','Calle 123','7891011121314',TRUE,3,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('user','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Juan','Camilo','Arias',11111,22222,'generico10@hotmail.com','Calle 123','613946237008',TRUE,5,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('user02','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Marcela','','Marín',11111,22222,'generico10@hotmail.com','Calle 123','434286803777',TRUE,5,1,1,'F');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('user03','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Diego','Andrés','Perez',11111,22222,'generico10@hotmail.com','Calle 123','113055861094',TRUE,5,1,1,'M');
INSERT INTO usuario(username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id,organizacion_id,suborganizacion_id, sexo) VALUES ('user04','$2a$10$KApFxDAhHuhzkPokQtTem.JMA9/7zD/iBAtQAStbH/6iEt8xWFLvi','Sebastian','','Jimenez',11111,22222,'generico10@hotmail.com','Calle 123','880311775779',TRUE,5,1,1,'');

-----------------------------------------------
--              ESTACIONES                   --
-----------------------------------------------
INSERT INTO station(id, available, numberOfUses) VALUES (1,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (2,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (3,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (4,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (5,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (6,true,0);

-----------------------------------------------
--              HISTORIAL                    --
-----------------------------------------------
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 1, 1519904508000, 1519915521000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 2, 1520257338000, 1520274176000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 2, 1520492456000, 1520512305000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 1, 1520862285000, 1520888400000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 1, 1521105753000, 1521107120000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (2, 1, 1519904508000, 1519915521000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (2, 2, 1520257338000, 1520274176000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (2, 2, 1520492456000, 1520512305000);
INSERT INTO historial(user_id,station_id, fechaIngreso, fechaSalida) VALUES (2, 3, 1520862285000, 1520888400000);
INSERT INTO historial(user_id,station_id, fechaIngreso) VALUES (2, 5, 1522748720000);
INSERT INTO historial(user_id,station_id, fechaIngreso) VALUES (1, 1, 1522748720000);
