CREATE TABLE IF NOT EXISTS revenues (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    description VARCHAR(250),
    type INT,
    date_time TIMESTAMP,
    user INT,
    PRIMARY KEY(id),
    CONSTRAINT fkType FOREIGN KEY (type) REFERENCES revenuesTypes(id),
    CONSTRAINT fkUser FOREIGN KEY (user) REFERENCES users(id)
);