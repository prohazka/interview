CREATE TABLE Halls (
    id INTEGER PRIMARY KEY,
  	title VARCHAR NOT NULL
);
INSERT INTO Halls (id, title) VALUES
(1, 'RED'),
(2, 'GREEN'),
(3, 'BLUE');
CREATE TABLE Seats (
    id INTEGER PRIMARY KEY,
    hall_id INTEGER NOT NULL REFERENCES Halls(id),
    row_num INTEGER NOT NULL,
    seat_num INTEGER NOT NULL
);
INSERT INTO Seats (id, hall_id, row_num, seat_num) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 2, 1, 2),
(4, 2, 2, 1),
(5, 3, 1, 1),
(6, 3, 1, 2);
CREATE TABLE Users (
    id integer PRIMARY KEY,
    alias VARCHAR(255) NOT NULL
);
INSERT INTO Users (id, alias) VALUES
(1, 'Vitya'),
(2, 'Masha'),
(3, 'Sasha');
CREATE TABLE Orders (
    id integer PRIMARY KEY,
    user_id integer NOT NULL REFERENCES Users(id),
    order_date TIMESTAMP NOT NULL
);
INSERT INTO Orders (id, user_id, order_date) VALUES
(1, 1, '2021-07-15 10:30:00'),
(2, 1, '2021-08-20 11:45:00'),
(3, 2, '2024-01-25 09:15:00'),
(4, 2, '2021-08-25 09:15:00'),
(5, 3, '2024-01-05 14:20:00'),
(6, 3, '2024-01-05 14:20:00');
CREATE TABLE Movies (
    id integer PRIMARY KEY,
    name VARCHAR NOT NULL
);
INSERT INTO Movies (id, name) VALUES
(1, 'Ирония Судьбы'),
(2, 'Терминатор 2');
CREATE TABLE Seances (
    id integer PRIMARY KEY,
    hall_id integer NOT NULL REFERENCES Halls(id),
    movie_id integer NOT NULL REFERENCES Movies(id),
    start_date TIMESTAMP NOT NULL
);
INSERT INTO Seances (id, hall_id, movie_id, start_date) VALUES
(1, 1, 1,'2024-01-25 09:15:00'),
(2, 1, 2,'2024-01-05 14:20:00'),
(3, 2, 1,'2024-01-05 14:20:00');
CREATE TABLE Tickets (
    id integer PRIMARY KEY,
    seat_id integer NOT NULL REFERENCES Seats(id),
    seance_id integer NOT NULL REFERENCES Seances(id)
);
INSERT INTO Tickets (id, seat_id, seance_id) VALUES
(1, 2, 1),
(2, 4, 1),
(3, 2, 2),
(4, 3, 2),
(5, 3, 3);