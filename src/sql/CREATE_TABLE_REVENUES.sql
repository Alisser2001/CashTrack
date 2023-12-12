CREATE TYPE IF NOT EXISTS RevenueType AS ENUM (
    'ahorros', 'depositos', 'regalos', 'salario'
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