package dao;

import dao.dto.AccountDTO;
import dao.dto.UserDTO;
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
                PreparedStatement getAdminStatement = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
                getAdminStatement.setInt(1, resultSet.getInt("adminId"));
                ResultSet adminSet = getAdminStatement.executeQuery();
                if (adminSet.next()){
                    User admin = new User();
                    admin.setUserId(adminSet.getInt("id"));
                    admin.setUsername(adminSet.getString("username"));
                    admin.setEmail(adminSet.getString("email"));
                    admin.setAccountId(adminSet.getInt("account"));
                    account.setAdmin(new UserDTO(admin.getUserId(), admin.getUsername(), admin.getEmail(), admin.getAccountId()));
                }
                account.setAccountId(resultSet.getInt("id"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setDescription(resultSet.getString("description"));
                account.setBalance(resultSet.getDouble("balance"));
                getAdminStatement.close();
                preparedStatement.close();
                return new AccountDTO(account.getAccountId(), account.getAdmin(), account.getAccountName(), account.getDescription(), account.getBalance());
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
                PreparedStatement getAdminStatement = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
                getAdminStatement.setInt(1, resultSet.getInt("adminId"));
                ResultSet adminSet = getAdminStatement.executeQuery();
                if (adminSet.next()){
                    User admin = new User();
                    admin.setUserId(adminSet.getInt("id"));
                    admin.setUsername(adminSet.getString("username"));
                    admin.setEmail(adminSet.getString("email"));
                    admin.setAccountId(adminSet.getInt("account"));
                    account.setAdmin(new UserDTO(admin.getUserId(), admin.getUsername(), admin.getEmail(), admin.getAccountId()));
                }
                account.setAccountId(resultSet.getInt("id"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setDescription(resultSet.getString("description"));
                account.setBalance(resultSet.getDouble("balance"));
                getAdminStatement.close();
                preparedStatement.close();
                return new AccountDTO(account.getAccountId(), account.getAdmin(), account.getAccountName(), account.getDescription(), account.getBalance());
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
            preparedStatement.setInt(2, accountDTO.getAdmin().getId());
            preparedStatement.setString(3, accountDTO.getDescription());
            preparedStatement.setString(4, accountDTO.getPassword());
            preparedStatement.setDouble(5, accountDTO.getBalance());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
    public void deleteAccount(AccountDTO account) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM accounts WHERE id = ?");
            preparedStatement.setInt(1, account.getId());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
}
