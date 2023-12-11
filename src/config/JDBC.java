package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static final String DB_CONN = "jdbc:h2:~/cashtrack";
    private static final String DB_USER = "alidev";
    private static final String DB_PASSWORD = "c@shtr@ck";
    private static final String DB_DRIVER = "org.h2.Driver";
    public static Connection getDbConn(){
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();
            /*
            user: N/1 :account
            user: 1/N :expenses
            user: 1/N :revenues
             */
            String expenseTypeQuery = "CREATE TYPE IF NOT EXISTS ExpenseType AS ENUM (" +
                    "'automovil', 'casa', 'comida', 'comunicaciones', 'deportes', 'entretenimiento', 'facturas', 'higiene', 'mascotas', 'regalos', 'restaurante', 'ropa', 'salud', 'taxi', 'transporte'" +
                    ");";
            String revenueTypeQuery = "CREATE TYPE IF NOT EXISTS RevenueType AS ENUM (" +
                    "'ahorros', 'depositos', 'regalos', 'salario'" +
                    ");";
            statement.executeUpdate(expenseTypeQuery);
            statement.executeUpdate(revenueTypeQuery);
            String userEntityQuery = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "username VARCHAR(50)," +
                    "email VARCHAR(50)," +
                    "pin VARCHAR(15)," +
                    "account INT," +
                    "PRIMARY KEY(id)," +
                    "CONSTRAINT fkAccountUser FOREIGN KEY (account) REFERENCES accounts(id)" +
                    ");";
            String expenseEntityQuery = "CREATE TABLE IF NOT EXISTS expenses (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "amount FLOAT," +
                    "description VARCHAR(250)," +
                    "type ExpenseType," +
                    "date_time TIMESTAMP," +
                    "userId INT," +
                    "PRIMARY KEY(id)," +
                    "CONSTRAINT fkUserExpense FOREIGN KEY (userId) REFERENCES users(id)" +
                    ");";
            String revenueEntityQuery = "CREATE TABLE IF NOT EXISTS revenues (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "amount FLOAT," +
                    "description VARCHAR(250)," +
                    "type RevenueType," +
                    "date_time TIMESTAMP," +
                    "userId INT," +
                    "PRIMARY KEY(id)," +
                    "CONSTRAINT fkUserRevenue FOREIGN KEY (userId) REFERENCES users(id)" +
                    ");";
            String accountEntityQuery = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "accountName VARCHAR(50)," +
                    "adminId INT NOT NULL," +
                    "description VARCHAR(250)," +
                    "password VARCHAR(250)," +
                    "balance FLOAT," +
                    "PRIMARY KEY (id)" +
                    ");";
            statement.executeUpdate(accountEntityQuery);
            statement.executeUpdate(userEntityQuery);
            statement.executeUpdate(expenseEntityQuery);
            statement.executeUpdate(revenueEntityQuery);
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
