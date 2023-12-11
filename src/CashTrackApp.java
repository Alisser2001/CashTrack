import config.JDBC;
import dao.AccountDAO;
import dao.UserDAO;
import dao.dto.AccountDTO;
import dao.dto.UserDTO;
import exceptions.DAOException;
import exceptions.ExpenseException;
import interfaces.dao.IAccountDAO;
import interfaces.dao.IUserDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class CashTrackApp {
    public static void main(String[] args) throws ExpenseException, SQLException, DAOException {
        Connection conn = JDBC.getDbConn();
        System.out.println("Conexión Exitosa");
        /*IUserDAO newUserDao = new UserDAO(conn);
        UserDTO newUserDto = new UserDTO("alidev", "alidev@udea.edu.co", 1, "1234");
        IAccountDAO newAccDao = new AccountDAO(conn);
        AccountDTO newAccDto = new AccountDTO(newUserDto.getId(), "alidev ahorros", "ahorros míos", "12345", 2500.0);
        newAccDao.createAccount(newAccDto);*/
        conn.close();
    }
}