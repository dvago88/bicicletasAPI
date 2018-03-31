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
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (1,'dan','$2a$10$us4QTd2e4dcuKZxouL4G6u.iQ0B9HIAxNmBIv48GMMvJ9l9qoKC5S','daniel','antonio','vargas',11111,22222,'da@fake.com','calle1','cc:f6:ab:b2',TRUE,1);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (2,'jor','$2a$10$qRKjPB.3.sDSLdi3J.yQBOQVdJsryKbhXXnD.BsOxX/tlbPhSHKt2','jorge','eduardo','duran',11111,22222,'du@fake.com','calle12','65:1d:82:bb',TRUE,2);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (3,'raspberry','$2a$10$ha.rxMICv6OKpxkt.tqvTOK3mnCCjY6avP4sEabi8ynvBU7qOLK6q','rasp','berry','pi',00000,00000,'rasp@fake.com','N/A','N/A',TRUE,3);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (4,'test01','$2a$10$t5amr7swFQUCxVmPYxZCTeR6tikRCKbbg6RictE68jAb3kkc28jUW','test01','test01','test01',11111,22222,'test01','test01','1a:52:a7:89',TRUE,2);
INSERT INTO usuario(id,username,password,primerNombre,segundoNombre,apellidos,telefono,celular,email,direccion,codigo,enabled,role_id) VALUES (5,'test02','$2a$10$zPSXVvcG0HPfsT85llK2rudfieayo/pjv34MtlFYQKNfsGJX/avCi','test02','test02','test02',11111,22222,'test02','test02','e5:83:24:d9',TRUE,2);

INSERT INTO station(id, available, numberOfUses) VALUES (1,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (2,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (3,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (4,true,0);
INSERT INTO station(id, available, numberOfUses) VALUES (5,true,0);
INSERT INTO historial(id,user_id,station_id) VALUES (1, 1, 1);
INSERT INTO historial(id,user_id,station_id) VALUES (2, 1, 2);
INSERT INTO historial(id,user_id,station_id) VALUES (3, 1, 2);
INSERT INTO historial(id,user_id,station_id) VALUES (4, 1, 1);
INSERT INTO historial(id,user_id,station_id) VALUES (5, 1, 1);
INSERT INTO historial(id,user_id,station_id) VALUES (6, 2, 1);
INSERT INTO historial(id,user_id,station_id) VALUES (7, 2, 2);
INSERT INTO historial(id,user_id,station_id) VALUES (8, 2, 2);
INSERT INTO historial(id,user_id,station_id) VALUES (9, 2, 3);
INSERT INTO historial(id,user_id,station_id) VALUES (10, 2, 5);