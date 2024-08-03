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
(1, 'Mario Bros', '1985-09-13', 50.00, 'PLATAFORMAS', 1, 9),
(2, 'The Legend of Zelda', '1986-02-21', 60.00, 'AVENTURA', 1, 10),
(3, 'Donkey Kong', '1981-07-09', 40.00, 'PLATAFORMAS', 1, 8),
(4, 'Super Mario 64', '1996-06-23', 70.00, 'PLATAFORMAS', 1, 9),
(5, 'Pikmin', '2001-10-26', 55.00, 'ESTRATEGIA', 1, 8);

-- Hideo Kojima
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(6, 'Metal Gear Solid', '1998-09-03', 60.00, 'SIGILO', 2, 9),
(7, 'Death Stranding', '2019-11-08', 70.00, 'ACCION', 2, 8),
(8, 'Snatcher', '1988-11-26', 45.00, 'AVENTURA', 2, 7),
(9, 'Policenauts', '1994-07-29', 50.00, 'AVENTURA', 2, 8),
(10, 'Metal Gear Solid 2', '2001-11-13', 65.00, 'SIGILO', 2, 9);

-- Hironobu Sakaguchi
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(11, 'Final Fantasy', '1987-12-18', 50.00, 'RPG', 3, 9),
(12, 'Final Fantasy VII', '1997-01-31', 70.00, 'RPG', 3, 10),
(13, 'Chrono Trigger', '1995-03-11', 65.00, 'RPG', 3, 10),
(14, 'Lost Odyssey', '2007-12-06', 60.00, 'RPG', 3, 8),
(15, 'The Last Story', '2011-01-27', 55.00, 'RPG', 3, 8);

-- Sid Meier
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(16, 'Civilization', '1991-09-01', 50.00, 'ESTRATEGIA', 4, 9),
(17, 'Civilization II', '1996-02-29', 60.00, 'ESTRATEGIA', 4, 9),
(18, 'Civilization III', '2001-10-30', 65.00, 'ESTRATEGIA', 4, 8),
(19, 'Pirates!', '1987-06-01', 45.00, 'AVENTURA', 4, 8);

-- Todd Howard
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(20, 'The Elder Scrolls III: Morrowind', '2002-05-01', 60.00, 'RPG', 5, 9),
(21, 'The Elder Scrolls IV: Oblivion', '2006-03-20', 70.00, 'RPG', 5, 9),
(22, 'The Elder Scrolls V: Skyrim', '2011-11-11', 80.00, 'RPG', 5, 10),
(23, 'Fallout 3', '2008-10-28', 65.00, 'RPG', 5, 9),
(24, 'Fallout 4', '2015-11-10', 75.00, 'RPG', 5, 8);

-- Yu Suzuki
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(25, 'Shenmue', '1999-12-29', 60.00, 'AVENTURA', 6, 8),
(26, 'Shenmue II', '2001-09-06', 65.00, 'AVENTURA', 6, 8),
(27, 'Virtua Fighter', '1993-11-27', 55.00, 'LUCHA', 6, 9),
(28, 'Out Run', '1986-09-20', 50.00, 'CARRERAS', 6, 8),
(29, 'Space Harrier', '1985-12-14', 45.00, 'SHOOTER', 6, 7);

-- John Carmack
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(30, 'Doom', '1993-12-10', 50.00, 'SHOOTER', 7, 10),
(31, 'Doom II', '1994-10-10', 55.00, 'SHOOTER', 7, 9),
(32, 'Quake', '1996-06-22', 60.00, 'SHOOTER', 7, 9),
(33, 'Quake II', '1997-12-09', 65.00, 'SHOOTER', 7, 8),
(34, 'Wolfenstein 3D', '1992-05-05', 45.00, 'SHOOTER', 7, 9);

-- Will Wright
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(35, 'SimCity', '1989-02-03', 50.00, 'SIMULACION', 8, 9),
(36, 'The Sims', '2000-02-04', 60.00, 'SIMULACION', 8, 9),
(37, 'SimCity 2000', '1993-11-01', 55.00, 'SIMULACION', 8, 8),
(38, 'Spore', '2008-09-07', 65.00, 'SIMULACION', 8, 7),
(39, 'SimCity 4', '2003-01-14', 60.00, 'SIMULACION', 8, 8);

-- Ken Levine
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(40, 'Bioshock', '2007-08-21', 60.00, 'FPS', 9, 10),
(41, 'Thief: The Dark Project', '1998-11-30', 55.00, 'SIGILO', 9, 8),
(42, 'Bioshock 2', '2010-02-09', 65.00, 'FPS', 9, 8);

-- Fumito Ueda
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(43, 'Ico', '2001-09-24', 50.00, 'AVENTURA', 10, 9),
(44, 'Shadow of the Colossus', '2005-10-18', 60.00, 'AVENTURA', 10, 10),
(45, 'The Last Guardian', '2016-12-06', 70.00, 'AVENTURA', 10, 8);

-- Toby Fox
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(46, 'Undertale', '2015-09-15', 50.00, 'RPG', 11, 10),
(47, 'Deltarune Chapter 1', '2018-10-31', 0.00, 'RPG', 11, 9),
(48, 'Deltarune Chapter 2', '2021-09-17', 0.00, 'RPG', 11, 9);

-- EA
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(49, 'FIFA 21', '2020-10-09', 60.00, 'DEPORTES', 12, 8),
(50, 'Battlefield V', '2018-11-20', 70.00, 'SHOOTER', 12, 7),
(51, 'The Sims 4', '2014-09-02', 60.00, 'SIMULACION', 12, 8),
(52, 'Madden NFL 21', '2020-08-25', 60.00, 'DEPORTES', 12, 7),
(53, 'Need for Speed Heat', '2019-11-08', 50.00, 'CARRERAS', 12, 8);

-- Notch
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(54, 'Minecraft', '2011-11-18', 50.00, 'AVENTURA', 13, 10),
(55, 'Scrolls', '2014-12-11', 30.00, 'ESTRATEGIA', 13, 7);

-- Edmund McMillen
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(56, 'Super Meat Boy', '2010-10-20', 50.00, 'PLATAFORMAS', 14, 9),
(57, 'The Binding of Isaac', '2011-09-28', 40.00, 'RPG', 14, 9),
(58, 'The End is Nigh', '2017-07-12', 30.00, 'PLATAFORMAS', 14, 8),
(59, 'Binding of Isaac: Rebirth', '2014-11-04', 45.00, 'RPG', 14, 9),
(60, 'Meat Boy Forever', '2020-12-23', 50.00, 'PLATAFORMAS', 14, 8);

-- Lucas Pope
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(61, 'Papers, Please', '2013-08-08', 50.00, 'SIMULACION', 15, 10),
(62, 'Return of the Obra Dinn', '2018-10-18', 60.00, 'AVENTURA', 15, 9),
(63, 'The Republia Times', '2012-03-05', 0.00, 'SIMULACION', 15, 7),
(64, 'Six Degrees of Sabotage', '2012-03-05', 0.00, 'SIMULACION', 15, 7);

-- ConcernedApe
INSERT INTO Juegos (id, nombre, release, precio, genero, creador_Id, rating) VALUES
(65,'Stardew Valley', '2016-02-26', 50.00, 'SIMULACION', 16, 10);




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





