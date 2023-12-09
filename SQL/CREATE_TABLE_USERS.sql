CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(15),
    account INT,
    PRIMARY KEY(id),
    CONSTRAINT fkAccount FOREIGN KEY (account) REFERENCES accounts(id)
);
