DROP DATABASE IF EXISTS library;

CREATE DATABASE library;

USE library;

CREATE TABLE users(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    user_name CHAR(50)
);

CREATE TABLE books(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(50) NOT NULL,
    author CHAR(50) NOT NULL,
    
    company CHAR(50) NOT NULL,
    published_year INTEGER NOT NULL 
);

CREATE TABLE reservation(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    book_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    requisition_date DATE,
    delivery_date DATE,
    reserved BIT DEFAULT 0,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (user_name) VALUES 
('Alice'),
('Bob'),
('Charlie'),
('Diana'),
('Evan');

INSERT INTO books (book_name, author, company, published_year) VALUES 
('The Hobbit', 'Tolkien', 'HarperCollins', 1937),
('1984', 'Orwell', 'Penguin', 1949),
('Moby Dick', 'Melville', 'Harper & Brothers', 1851),
('Pride & Prejudice', 'Austen', 'T. Egerton', 1813),
('Hamlet', 'Shakespeare', 'Simon & Schuster', 1603),
('War and Peace', 'Tolstoi', 'The Russian Messenger', 1869),
('O Primo Basílio', 'Eça de Queirós', 'Livraria Lello', 1878),
('Anna Karenina', 'Tolstoi', 'The Russian Messenger', 1878);


INSERT INTO reservation (book_id, user_id, requisition_date, delivery_date, reserved) VALUES 
(1, 1, '2024-11-01', '2024-11-15',1),  -- Alice reserves The Hobbit
(2, 2, '2024-11-02', '2024-11-16',1),   -- Bob reserves 1984
(3, 3, '2024-11-03', '2024-11-17',1),  -- Charlie reserves Moby Dick
(4, 4, '2024-11-04', '2024-11-18',1),  -- Diana reserves Pride & Prejudice
(5, 5, '2024-11-05', '2024-11-19',1);  -- Evan reserves Hamlet

INSERT INTO reservation (book_id, user_id, requisition_date, delivery_date, reserved) VALUES
(6, 1, '2024-11-06', NULL, 0),  -- Alice reserva War and Peace
(7, 2, '2024-11-07', NULL, 0),  -- Bob reserva O Primo Basílio
(8, 3, '2024-11-08', NULL, 0);  -- Charlie reserva Anna Karenina


UPDATE reservation
SET delivery_date = '2024-11-20', reserved = 1
WHERE book_id = 6 AND user_id = 1;  -- Marcando entrega para a reserva de Alice (War and Peace)



SELECT * FROM reservation;

SELECT * FROM books WHERE author = 'Tolstoi';

SELECT b.book_name
FROM books AS b, reservation AS r
WHERE b.id = r.book_id AND r.reserved = 1;

SELECT company FROM books WHERE book_name = "O Primo Basílio";

SELECT u.user_name
FROM users AS u
WHERE u.id IN(
    SELECT r.user_id
    FROM reservation AS r
    WHERE r.book_id IN(
        SELECT b.id
        FROM books AS b
        WHERE b.published_year < 1974
    )
);

