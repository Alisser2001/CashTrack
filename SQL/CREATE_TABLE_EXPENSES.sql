CREATE TABLE IF NOT EXISTS expenses (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    description VARCHAR(250),
    type VARCHAR(25),
    date_time TIMESTAMP,
    userId INT,
    PRIMARY KEY(id),
    CONSTRAINT fkUserExpense FOREIGN KEY (userId) REFERENCES users(id)
);