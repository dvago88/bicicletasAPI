INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_RASPBERRY');
-- passwords:
-- pass
-- pass
-- raspberry
-- test01
-- test02
-- https://www.browserling.com/tools/bcrypt
-- INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (1,'dan','$2a$10$us4QTd2e4dcuKZxouL4G6u.iQ0B9HIAxNmBIv48GMMvJ9l9qoKC5S','daniel','antonio','vargas',11111,22222,'da@fake.com','calle1','cc:f6:ab:b2',TRUE,1,'M');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (1,'dan','$2a$10$us4QTd2e4dcuKZxouL4G6u.iQ0B9HIAxNmBIv48GMMvJ9l9qoKC5S','daniel','antonio','vargas',11111,22222,'da@fake.com','calle1','613946237008',TRUE,1,'M');
-- INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (2,'jor','$2a$10$qRKjPB.3.sDSLdi3J.yQBOQVdJsryKbhXXnD.BsOxX/tlbPhSHKt2','jorge','eduardo','duran',11111,22222,'du@fake.com','calle12','65:1d:82:bb',TRUE,2,'F');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (2,'jor','$2a$10$qRKjPB.3.sDSLdi3J.yQBOQVdJsryKbhXXnD.BsOxX/tlbPhSHKt2','jorge','eduardo','duran',11111,22222,'du@fake.com','calle12','880311775779',TRUE,2,'F');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (3,'raspberry','$2a$10$ha.rxMICv6OKpxkt.tqvTOK3mnCCjY6avP4sEabi8ynvBU7qOLK6q','rasp','berry','pi',00000,00000,'rasp@fake.com','N/A','N/A',TRUE,3,'M');
-- INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (4,'test01','$2a$10$t5amr7swFQUCxVmPYxZCTeR6tikRCKbbg6RictE68jAb3kkc28jUW','test01','test01','test01',11111,22222,'test01','test01','1a:52:a7:89',TRUE,2,'M');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (4,'test01','$2a$10$t5amr7swFQUCxVmPYxZCTeR6tikRCKbbg6RictE68jAb3kkc28jUW','test01','test01','test01',11111,22222,'test01','test01','434286803777',TRUE,2,'M');
-- INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (5,'test02','$2a$10$zPSXVvcG0HPfsT85llK2rudfieayo/pjv34MtlFYQKNfsGJX/avCi','test02','test02','test02',11111,22222,'test02','test02','e5:83:24:d9',TRUE,2,'M');
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id, sexo) VALUES (5,'test02','$2a$10$zPSXVvcG0HPfsT85llK2rudfieayo/pjv34MtlFYQKNfsGJX/avCi','test02','test02','test02',11111,22222,'test02','test02','113055861094',TRUE,2,'M');

INSERT INTO station(id, available, numberOfUses) VALUES (1,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (2,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (3,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (4,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (5,true,0);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (1, 1, 1, 1519904508000, 1519915521000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (2, 1, 2, 1520257338000, 1520274176000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (3, 1, 2, 1520492456000, 1520512305000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (4, 1, 1, 1520862285000, 1520888400000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (5, 1, 1, 1521105753000, 1521107120000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (6, 2, 1, 1519904508000, 1519915521000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (7, 2, 2, 1520257338000, 1520274176000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (8, 2, 2, 1520492456000, 1520512305000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso, fechaSalida) VALUES (9, 2, 3, 1520862285000, 1520888400000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso) VALUES (10, 2, 5, 1522748720000);
INSERT INTO historial(id,user_id,station_id, fechaIngreso) VALUES (11, 1, 1, 1522748720000);
