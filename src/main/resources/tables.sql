CREATE TYPE IF NOT EXISTS ExpenseType AS ENUM (
    'automovil', 'casa', 'comida', 'comunicaciones', 'deportes', 'entretenimiento', 'facturas', 'higiene', 'mascotas', 'regalos', 'restaurante', 'ropa', 'salud', 'taxi', 'transporte'
);

CREATE TYPE IF NOT EXISTS RevenueType AS ENUM (
    'ahorros', 'depositos', 'regalos', 'salario'
);

CREATE TABLE IF NOT EXISTS accounts (
    id INT NOT NULL AUTO_INCREMENT,
    accountName VARCHAR(50),
    adminId INT,
    description VARCHAR(250),
    password VARCHAR(250),
    balance FLOAT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(50),
    pin VARCHAR(15),
    account INT,
    PRIMARY KEY(id)
);

ALTER TABLE accounts
    ADD CONSTRAINT fkAdminAccount FOREIGN KEY (adminId) REFERENCES users(id);

ALTER TABLE users
    ADD CONSTRAINT fkAccountUser FOREIGN KEY (account) REFERENCES accounts(id);

CREATE TABLE IF NOT EXISTS expenses (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    description VARCHAR(250),
    type ExpenseType,
    date_time TIMESTAMP,
    userId INT,
    PRIMARY KEY(id),
    CONSTRAINT fkUserExpense FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS revenues (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    description VARCHAR(250),
    type RevenueType,
    date_time TIMESTAMP,
    userId INT,
    PRIMARY KEY(id),
    CONSTRAINT fkUserRevenue FOREIGN KEY (userId) REFERENCES users(id)
);