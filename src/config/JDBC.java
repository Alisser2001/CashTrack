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
            String userEntityQuery = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50), password VARCHAR(15), account FOREIGN KEY (SELECT accounts), revenues FOREIGN KEY (SELECT revenues), expenses FOREIGN KEY (SELECT expenses))";
            String expenseEntityQuery = "CREATE TABLE IF NOT EXISTS expenses (id INT PRIMARY KEY, amount FLOAT, description VARCHAR(250), type FOREIGN KEY (SELECT expensesTypes), date-time DATE-TIME, user FOREIGN KEY(SELECT users))";
            String revenueEntityQuery = "CREATE TABLE IF NOT EXISTS revenues (id INT PRIMARY KEY, amount FLOAT, description VARCHAR(250), type FOREIGN KEY (SELECT revenuesTypes), date-time DATE-TIME, user FOREIGN KEY(SELECT users))";
            String accountEntityQuery = "CREATE TABLE IF NOT EXISTS account (id INT PRIMARY KEY, balance FLOAT, users FOREIGN KEY (SELECT users))";
            statement.executeUpdate(userEntityQuery);
            statement.executeUpdate(expenseEntityQuery);
            statement.executeUpdate(revenueEntityQuery);
            statement.executeUpdate(accountEntityQuery);
            return conn;
            /*
            // Insertar registros
            String insertQuery = "INSERT INTO usuarios VALUES (1, 'John Doe'), (2, 'Jane Smith')";
            statement.executeUpdate(insertQuery);
            // Cerrar la conexión
            statement.close();
            // Cerrar la conexión
            connection.close();*/
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
