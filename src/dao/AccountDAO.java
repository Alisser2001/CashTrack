package dao;

import dao.dto.AccountDTO;
import entities.account.Account;
import entities.user.User;
import exceptions.DAOException;
import interfaces.dao.IAccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO implements IAccountDAO {
    private final Connection conn;
    public AccountDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public AccountDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account();
                account.setName(resultSet.getString("accountName"));
                PreparedStatement getAdminStatement = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
                getAdminStatement.setInt(1, resultSet.getInt("adminId"));
                ResultSet adminSet = getAdminStatement.executeQuery();
                if (resultSet.next()){
                    User admin = new User();
                    admin.setUsername(adminSet.getString("username"));
                    admin.setEmail(adminSet.getString("email"));
                    admin.setPin(adminSet.getString("pin"));
                    account.setAdmin(admin);
                }
                account.setDescription(resultSet.getString("description"));
                account.setPassword(resultSet.getString("password"));
                account.setBalance(resultSet.getDouble("balance"));
                return new AccountDTO(account);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public AccountDTO findByAdminId(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM accounts WHERE adminId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account();
                account.setName(resultSet.getString("accountName"));
                PreparedStatement getAdminStatement = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
                getAdminStatement.setInt(1, id);
                ResultSet adminSet = getAdminStatement.executeQuery();
                if (resultSet.next()){
                    User admin = new User();
                    admin.setUsername(adminSet.getString("username"));
                    admin.setEmail(adminSet.getString("email"));
                    admin.setPin(adminSet.getString("pin"));
                    account.setAdmin(admin);
                }
                account.setDescription(resultSet.getString("description"));
                account.setPassword(resultSet.getString("password"));
                account.setBalance(resultSet.getDouble("balance"));
                return new AccountDTO(account);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    public void createAccount(AccountDTO accountDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO accounts (accountName, adminId, description, password, balance) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, accountDTO.getAccountName());
            preparedStatement.setInt(2, accountDTO.getAdminId().getUserID());
            preparedStatement.setString(3, accountDTO.getDescription());
            preparedStatement.setString(4, "12345");
            preparedStatement.setDouble(5, accountDTO.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
    }
    public void deleteAccount(int id) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM accounts WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
    }
}
