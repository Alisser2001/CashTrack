CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(50),
    pin VARCHAR(15),
    account INT,
    PRIMARY KEY(id),
    CONSTRAINT fkAccountUser FOREIGN KEY (account) REFERENCES accounts(id)
);
