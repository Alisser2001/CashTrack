CREATE TABLE IF NOT EXISTS revenues (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    description VARCHAR(250),
    type VARCHAR(25),
    date_time TIMESTAMP,
    userId INT,
    PRIMARY KEY(id),
    CONSTRAINT fkUserRevenue FOREIGN KEY (userId) REFERENCES users(id)
);