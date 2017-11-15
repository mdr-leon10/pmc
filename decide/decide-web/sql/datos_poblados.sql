/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mdr.leon10
 * Created: 15/11/2017
 */
delete from tituloentity;
delete from propuestaentity;
delete from investigacionentity;
delete from cargoentity;
delete from politicoentity;
-- Jorge Enrique
INSERT INTO POLITICOENTITY VALUES (1, 1950, 14204889, 'Ibagué', 'Jorge Enrique Robledo Castillo', 'Polo Democrático Alternativo');
insert into cargoentity values (1, 'Municipio de Soacha', 'Concejal', 4, 1);
insert into cargoentity values (2, 'Municipio de Soacha', 'Secretario General MOIR', 4, 1);
insert into cargoentity values (3, 'U. Nal de Manizalez', 'Profesor', 4, 1);
insert into cargoentity values (4, 'Dpto de Caldas', 'Candidato Gobernación', 4, 1);
insert into cargoentity values (5, 'Congreso de la Rep.', 'Senador 2002', 3, 1);
insert into cargoentity values (6, 'Congreso de la Rep.', 'Senador 2006', 3, 1);

-- Alejandro O.
INSERT INTO POLITICOENTITY VALUES (2, 1955, 87063785, 'Bucaramanga', 'Alejandro Ordoñez Maldonado', 'Conservador');
insert into cargoentity values (10, 'Municipio de Bucaramanga', 'Concejal', 4, 2);
insert into cargoentity values (11, 'Tribunal Administrativo de Santander', 'Magistrado', 2, 2);
insert into cargoentity values (12, 'Consejo de Estado de Colombia', 'Presidente Consejo de Estado', 2, 2);
insert into cargoentity values (13, 'Procuraduría general de la Nación', 'Procurador General', 4, 2);

-- Clara Eugenia
INSERT INTO POLITICOENTITY VALUES (3, 1950, 41481937, 'Bogotá', 'Clara Eugenia López Obregón', 'Polo Democrático');
insert into cargoentity values (20, 'Presidencia de la República', 'Secretaria Económica', 4, 3);
insert into cargoentity values (21, 'Contraloría de Bogotá', 'Contralora', 4, 3);
insert into cargoentity values (22, 'Bogotá D.C.', 'Concejal', 4, 3);
insert into cargoentity values (23, 'Bogotá D.C.', 'Candidata Alcaldía', 4, 3);
insert into cargoentity values (24, 'Bogotá D.C.', 'Candidata Cámara de Rep.', 3, 3);
insert into cargoentity values (25, 'Bogotá D.C.', 'Alcalde encargada', 4, 3);
insert into cargoentity values (26, 'República de Colombia', 'Ministra de Trabajo', 4, 3);

-- German Vargas Lleras
INSERT INTO POLITICOENTITY VALUES (4, 1962, 87063785, 'Bucaramanga', 'Germán Vargas Lleras', 'Cambio Radical ');
insert into cargoentity values (31, 'Municipio de bojaca', 'Concejal', 4, 4);
insert into cargoentity values (32, 'Bogotá', 'Concejal', 4, 4);
insert into cargoentity values (33, 'Congreso de la republica', 'Senador', 3, 4);
insert into cargoentity values (34, 'Presidencia de la republica', 'Candidato a la presidencia', 4, 4);
insert into cargoentity values (35, 'Republica de Colombia', 'Ministro de interior y justicia', 4, 4);
insert into cargoentity values (36, 'Republica de Colombia', 'Vice presidente', 4, 4);

-- Sergio Fajardo
INSERT INTO POLITICOENTITY VALUES (5, 1956, 0, 'Medillin', 'Sergio Fajardo', 'Firmas');
insert into cargoentity values (40, 'Colsiencias', 'Miembo del consejo nacional de ciencias basicas', 4, 5);
insert into cargoentity values (41, 'Departamento de Antioquia', 'Alcalde de medellin', 4, 5);
insert into cargoentity values (42, 'Universidad de los Andes', 'Director del departamento de matematicas', 4, 5);

-- Gustavo Petro
INSERT INTO POLITICOENTITY VALUES (6, 1960, 0, 'Ciénaga de Oro', 'Gustavo Petro', 'Progresistas');
insert into cargoentity values (50, 'Congreso de la republica', 'Senador', 3, 6);
insert into cargoentity values (51, 'Alcaldia de Bogotá', 'Alcalde de Bogota', 4, 6);

-- Roy Barreras
INSERT INTO POLITICOENTITY VALUES (7, 1963, 0, 'Cali', 'Roy Barreras ', 'Partido de la U');
insert into cargoentity values (60, 'Congreso de la republica ', 'Senador', 3, 7);
insert into cargoentity values (61, 'Congreso de la republica ', 'Presidente del senado', 3, 7);into cargoentity values (60, 'aa', 'aa', 4, 7);

-- Maria del Rosario
INSERT INTO POLITICOENTITY VALUES (8, 1955, 51636557, 'Sincelejo', 'Maria del Rosario Guerra', 'Centro Democratico');
insert into cargoentity values (70, 'Congreso de la Republica', 'Senadora', 3, 8);
insert into cargoentity values (71, 'Ministerio de las TIC', 'Ministra de Tecnologias de la información y las comunicaciones de Colombia', 4, 8);
insert into cargoentity values (72, 'Fondo Financiero de proyectos de desarrollo', 'Directora', 4, 8);
INSERT INTO PROPUESTAENTITY VALUES (1, 'Propuestas', 10, 8);

-- Carlos Holmes
INSERT INTO POLITICOENTITY VALUES (9, 1951, 0, 'Cartago', 'Carlos Holmes Trujillo', 'Centro Democratico');
insert into cargoentity values (81, 'Embajada de Tokio', 'Consul', 4, 9);
insert into cargoentity values (82, 'Alcaldía de Cali', 'Secretario de Hacienda', 4, 9);
insert into cargoentity values (83, 'Alcaldía de Cali', 'Alcalde', 4, 9);
insert into cargoentity values (84, 'Embajador ante la OEA', 'Embajador', 4, 9);
insert into cargoentity values (85, 'Embajador ante la ONU', 'Embajador', 4, 9);
insert into cargoentity values (86, 'Ministerio de Educación nacional', 'Ministro de educación', 4, 9);
insert into cargoentity values (87, 'Ministerio del interior', 'Ministro del interior', 4, 9);
insert into cargoentity values (88, 'Ministerio de delegatorio de funciones presidenciales', 'Ministro Delegatorio de funciones presidenciales', 4, 9);

-- Paloma Susana
INSERT INTO POLITICOENTITY VALUES (10, 1978, 25280205, 'Popayan', 'Paloma Susana Valencia Laserna', 'Centro Democratico');
insert into cargoentity values (90, 'El espectador', 'Columnista', 1, 10);
insert into cargoentity values (91, 'El país', 'Columnista', 1, 10);
insert into cargoentity values (92, 'Blu Radio', 'Analista Politica', 1, 10);
insert into cargoentity values (93, 'La otra esquina', 'Fundadora', 1, 10);
insert into cargoentity values (94, 'Congreso de la Republica', 'Senadora', 3, 10);
insert into cargoentity values (95, 'La hora de la verdad', 'Analista Politica', 1, 10);

-- Claudia Lopez
INSERT INTO POLITICOENTITY VALUES (11, 1970, 51992648, 'Bogotá', 'Claudia Nayibe Lopez Hernandez', 'Partido alianza verde');
insert into cargoentity values (100, 'Yale World Fellow', 'Yale University', 1, 11);
insert into cargoentity values (101, 'Directora observatorio de la Democracia', 'Misión de observación electoral', 1, 11);
insert into cargoentity values (102, 'Coordinadora observatorio de conflicto armado', 'Coorporación Nuevo Arco Iris', 1, 11);
insert into cargoentity values (103, 'Columnista', 'Semana.com', 1, 11);
insert into cargoentity values (104, 'Columnista', 'lasillavacia.com', 1, 11);
insert into cargoentity values (105, 'Analista Politica', 'Hora 20 de Caracol Radio', 1, 11);
insert into cargoentity values (106, 'Columnista', 'El Tiempo', 1, 11);
insert into cargoentity values (107, 'Consultora Asociada', 'Programa de naciones unidas para el desarrollo', 1, 11);
insert into cargoentity values (108, 'Asesora del viceministro de Vivienda y Desarrollo Territorial', 'Ministerio de medio ambiente, vivienda y desarrollo territorial', 4, 11);
insert into cargoentity values (109, 'Directora departamento administrativo de accion comunal', 'Alcaldia Mayor de bogota', 4, 11);
insert into cargoentity values (110, 'Alcaldesa Localidad de Santafé', 'Alcaldia Mayor de bogota', 4, 11);
INSERT INTO PROPUESTAENTITY VALUES (2,'Hijos amados y deseados', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (3,'La niñez se respeta', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (4,'Ser colombiano paga', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (5,'La salud es un derecho, no un negocio', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (6,'Estado: seguridad, justicia e inversion pública son derechos fundamentales', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (7,'La vida de nuestros niños, jovenes y mujeres es sagrada', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (8,'Camos a gobernar con nuestros 7 mandatos anticorrupcion', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (9,'Todos protegemos y creemos en nuestra casa comun', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (10,'Todos estudiamos, todos trabajamos, todos ahorramos para la vejez', 1, 11);
INSERT INTO PROPUESTAENTITY VALUES (11,'Todos ponen todos toman', 1, 11);

-- Ivan Duque
INSERT INTO POLITICOENTITY VALUES (12, 1976, 79940745, 'Bogotá', 'Iván Duque Márquez', 'Centro Democratico');
insert into cargoentity values (120, 'Congreso de la Republica', 'Senador', 3, 12);
insert into cargoentity values (121, 'Cultura, Creativity and Solidarity Affairs Division chief', 'IDB', 1, 12);
insert into cargoentity values (122, 'Senior advisor department of political affairs', 'United nations', 1, 12);
insert into cargoentity values (123, 'Senior Counselor for colombia and Peru', 'International duty', 1, 12);
insert into cargoentity values (124, 'Ministro de Hacienda', 'Ministerio de Hacienda', 4, 12);
INSERT INTO PROPUESTAENTITY VALUES (12,'Seguridad y Justicia', 18, 12);
INSERT INTO PROPUESTAENTITY VALUES (13,'Instituciones independientes', 8, 12);
INSERT INTO PROPUESTAENTITY VALUES (14,'Educación', 12, 12);
INSERT INTO PROPUESTAENTITY VALUES (15,'Salud', 9, 12);
INSERT INTO PROPUESTAENTITY VALUES (16,'Familia', 6, 12);
INSERT INTO PROPUESTAENTITY VALUES (17,'Cultura', 6, 12);
INSERT INTO PROPUESTAENTITY VALUES (18,'Economìa', 11, 12);
INSERT INTO PROPUESTAENTITY VALUES (19,'Innovación social', 9, 12);
INSERT INTO PROPUESTAENTITY VALUES (20,'Campo con progreso', 8, 12);
INSERT INTO PROPUESTAENTITY VALUES (21,'Emprendimiento', 7, 12);
INSERT INTO PROPUESTAENTITY VALUES (22,'Ciencia y tecnologia', 6, 12);
INSERT INTO PROPUESTAENTITY VALUES (23,'Economia naranja y deporte', 7, 12);
INSERT INTO PROPUESTAENTITY VALUES (24,'Infraestructura', 5, 12);
INSERT INTO PROPUESTAENTITY VALUES (25,'Ciudades inteligentes y creativas', 6, 12);
INSERT INTO PROPUESTAENTITY VALUES (26,'Sostenibilidad Ambiental', 7, 12);
INSERT INTO PROPUESTAENTITY VALUES (27,'Empleos dignos y estables', 6, 12);
INSERT INTO PROPUESTAENTITY VALUES (28,'Equidad', 5, 12);
INSERT INTO PROPUESTAENTITY VALUES (29,'Felicidad', 2, 12);
INSERT INTO PROPUESTAENTITY VALUES (30,'Transparencia', 1, 12);
INSERT INTO PROPUESTAENTITY VALUES (31,'Participación', 1, 12);
INSERT INTO PROPUESTAENTITY VALUES (32,'Contra la corrupción', 14, 12);




