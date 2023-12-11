CREATE TYPE IF NOT EXISTS ExpenseType AS ENUM (
    'automovil', 'casa', 'comida', 'comunicaciones', 'deportes', 'entretenimiento', 'facturas', 'higiene', 'mascotas', 'regalos', 'restaurante', 'ropa', 'salud', 'taxi', 'transporte'
);
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