CREATE TABLE IF NOT EXISTS accounts (
    id INT NOT NULL AUTO_INCREMENT,
    accountName VARCHAR(50),
    adminId INT NOT NULL,
    description VARCHAR(250),
    password VARCHAR(250),
    balance FLOAT,
    PRIMARY KEY (id)
);