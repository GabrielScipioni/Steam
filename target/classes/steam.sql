INSERT INTO Usuarios (id, nombre, password, pais, last_login, created_at, nivel, coins) VALUES
(1,'Gabriel', '1234', 'ARGENTINA', '2024-08-03 10:00:00', '2024-08-01 08:00:00', 1, 50.0),
(2,'Agustin', '1234', 'ARGENTINA', '2024-08-03 11:00:00', '2024-08-01 09:00:00', 2, 100.0),
(3,'Rain', '1234', 'ARGENTINA', '2024-08-03 11:00:00', '2024-08-01 09:00:00', 2, 100.0),
(4,'Lucas', '1234', 'ARGENTINA', '2024-08-03 11:00:00', '2024-08-01 09:00:00', 2, 100.0),
(5,'Matias', '1234', 'ARGENTINA', '2024-08-03 11:00:00', '2024-08-01 09:00:00', 2, 100.0);



INSERT INTO Creadores (id, nombre) VALUES
(1, 'Shigeru Miyamoto'),
(2, 'Hideo Kojima'),
(3, 'Hironobu Sakaguchi'),
(4, 'Sid Meier'),
(5, 'Todd Howard'),
(6, 'Yu Suzuki'),
(7, 'John Carmack'),
(8, 'Will Wright'),
(9, 'Ken Levine'),
(10, 'Fumito Ueda'),
(11, 'Toby Fox'),
(12, 'EA'),
(13, 'Notch'),
(14, 'Edmund McMillen'),
(15, 'Lucas Pope'),
(16, 'ConcernedApe');


-- Shigeru Miyamoto
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(1, 'Mario Bros', '1985-09-13', 30.00, 'PLATAFORMAS', 1, 1),
(2, 'The Legend of Zelda', '1986-02-21', 35.00, 'AVENTURA', 1, 2),
(3, 'Donkey Kong', '1981-07-09', 25.00, 'PLATAFORMAS', 1, 5),
(4, 'Super Mario 64', '1996-06-23', 50.00, 'PLATAFORMAS', 1, 4),
(5, 'Pikmin', '2001-10-26', 40.00, 'ESTRATEGIA', 1, 6);

-- Hideo Kojima
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(6, 'Metal Gear Solid', '1998-09-03', 50.00, 'SIGILO', 2, 3),
(7, 'Death Stranding', '2019-11-08', 60.00, 'ACCION', 2, 15),
(8, 'Snatcher', '1988-11-26', 30.00, 'AVENTURA', 2, 25),
(9, 'Policenauts', '1994-07-29', 35.00, 'AVENTURA', 2, 20),
(10, 'Metal Gear Solid 2', '2001-11-13', 50.00, 'SIGILO', 2, 7);

-- Hironobu Sakaguchi
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(11, 'Final Fantasy', '1987-12-18', 30.00, 'RPG', 3, 10),
(12, 'Final Fantasy VII', '1997-01-31', 60.00, 'RPG', 3, 5),
(13, 'Chrono Trigger', '1995-03-11', 55.00, 'RPG', 3, 6),
(14, 'Lost Odyssey', '2007-12-06', 55.00, 'RPG', 3, 12),
(15, 'The Last Story', '2011-01-27', 50.00, 'RPG', 3, 18);

-- Sid Meier
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(16, 'Civilization', '1991-09-01', 30.00, 'ESTRATEGIA', 4, 8),
(17, 'Civilization II', '1996-02-29', 40.00, 'ESTRATEGIA', 4, 12),
(18, 'Civilization III', '2001-10-30', 50.00, 'ESTRATEGIA', 4, 11),
(19, 'Pirates!', '1987-06-01', 25.00, 'AVENTURA', 4, 20);
-- Todd Howard
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(20, 'The Elder Scrolls III: Morrowind', '2002-05-01', 55.00, 'RPG', 5, 9),
(21, 'The Elder Scrolls IV: Oblivion', '2006-03-20', 60.00, 'RPG', 5, 10),
(22, 'The Elder Scrolls V: Skyrim', '2011-11-11', 70.00, 'RPG', 5, 4),
(23, 'Fallout 3', '2008-10-28', 60.00, 'RPG', 5, 7),
(24, 'Fallout 4', '2015-11-10', 65.00, 'RPG', 5, 6);

-- Yu Suzuki
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(25, 'Shenmue', '1999-12-29', 55.00, 'AVENTURA', 6, 17),
(26, 'Shenmue II', '2001-09-06', 60.00, 'AVENTURA', 6, 15),
(27, 'Virtua Fighter', '1993-11-27', 45.00, 'LUCHA', 6, 18),
(28, 'Out Run', '1986-09-20', 30.00, 'CARRERAS', 6, 22),
(29, 'Space Harrier', '1985-12-14', 25.00, 'SHOOTER', 6, 30);

-- John Carmack
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(30, 'Doom', '1993-12-10', 40.00, 'SHOOTER', 7, 2),
(31, 'Doom II', '1994-10-10', 45.00, 'SHOOTER', 7, 8),
(32, 'Quake', '1996-06-22', 50.00, 'SHOOTER', 7, 10),
(33, 'Quake II', '1997-12-09', 55.00, 'SHOOTER', 7, 25),
(34, 'Wolfenstein 3D', '1992-05-05', 35.00, 'SHOOTER', 7, 15);

-- Will Wright
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(35, 'SimCity', '1989-02-03', 30.00, 'SIMULACION', 8, 5),
(36, 'The Sims', '2000-02-04', 50.00, 'SIMULACION', 8, 3),
(37, 'SimCity 2000', '1993-11-01', 40.00, 'SIMULACION', 8, 12),
(38, 'Spore', '2008-09-07', 55.00, 'SIMULACION', 8, 20),
(39, 'SimCity 4', '2003-01-14', 45.00, 'SIMULACION', 8, 18);

-- Ken Levine
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(40, 'Bioshock', '2007-08-21', 55.00, 'FPS', 9, 10),
(41, 'Thief: The Dark Project', '1998-11-30', 35.00, 'SIGILO', 9, 18),
(42, 'Bioshock 2', '2010-02-09', 60.00, 'FPS', 9, 14);
-- Fumito Ueda
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(43, 'Ico', '2001-09-24', 45.00, 'AVENTURA', 10, 20),
(44, 'Shadow of the Colossus', '2005-10-18', 50.00, 'AVENTURA', 10, 8),
(45, 'The Last Guardian', '2016-12-06', 60.00, 'AVENTURA', 10, 15);
-- Toby Fox
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(46, 'Undertale', '2015-09-15', 25.00, 'RPG', 11, 7),
(47, 'Deltarune Chapter 1', '2018-10-31', 0.00, 'RPG', 11, 10),
(48, 'Deltarune Chapter 2', '2021-09-17', 0.00, 'RPG', 11, 10);
-- EA
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(49, 'FIFA 21', '2020-10-09', 60.00, 'DEPORTES', 12, 22),
(50, 'Battlefield V', '2018-11-20', 55.00, 'SHOOTER', 12, 30),
(51, 'The Sims 4', '2014-09-02', 50.00, 'SIMULACION', 12, 18),
(52, 'Madden NFL 21', '2020-08-25', 60.00, 'DEPORTES', 12, 27);




INSERT INTO Review (juego_Id, usuario_Id, comentario) VALUES
(1, 1, 'Excelente juego!'),
(1, 2, 'me disgusto!'),
(2, 2, 'Muy entretenido.'),
(2, 1, 'muy malo, no lo recomiendo.');


INSERT INTO Logros (id,juego_Id, logro) VALUES
(1, 11, 'no se, no jugue final fantasy'),
(2, 35, 'a ver que te compraste? ... ¿este juego?');

INSERT INTO LogrosXUsuarios (logro_Id, usuario_Id) VALUES
(2, 2),
(1, 4);



INSERT INTO Biblioteca (juego_Id, usuario_Id, horas, minutos) VALUES
(1, 1, 5, 30),
(2, 2, 15, 30),
(3, 3, 20, 30),
(4, 4, 32, 30),
(5, 5, 96, 45);





