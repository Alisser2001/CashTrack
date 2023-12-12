package dao;

import dao.dto.AccountDTO;
import entities.account.AccountEntity;
import exceptions.DAOException;
import interfaces.dao.IAccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO implements IAccountDAO {
    private final Connection conn;
    private static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id = ?";
    private static final String FIND_ACCOUNT_BY_ADMIN_ID = "SELECT * FROM accounts WHERE adminId = ?";
    private static final String CREATE_ACCOUNT = "INSERT INTO accounts (accountName, adminId, description, password, balance) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = ?";
    private static final String DELETE_ACCOUNT_REVENUES = "DELETE FROM revenues WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_EXPENSES = "DELETE FROM expenses WHERE userId IN (SELECT userId FROM users WHERE account = ?);";
    private static final String DELETE_ACCOUNT_ID_FROM_USERS = "UPDATE users SET account = NULL WHERE account = ?;";

    public AccountDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public AccountDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AccountEntity account = new AccountEntity();
                account.setAdminId(resultSet.getInt("adminId"));
                account.setAccountId(resultSet.getInt("id"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setDescription(resultSet.getString("description"));
                account.setBalance(resultSet.getDouble("balance"));
                preparedStatement.close();
                return new AccountDTO(account.getAccountId(), account.getAdminId(), account.getAccountName(), account.getDescription(), account.getBalance());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public AccountDTO findByAdminId(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_ACCOUNT_BY_ADMIN_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AccountEntity account = new AccountEntity();
                account.setAdminId(resultSet.getInt("adminId"));
                account.setAccountId(resultSet.getInt("id"));
                account.setAccountName(resultSet.getString("accountName"));
                account.setDescription(resultSet.getString("description"));
                account.setBalance(resultSet.getDouble("balance"));
                preparedStatement.close();
                return new AccountDTO(account.getAccountId(), account.getAdminId(), account.getAccountName(), account.getDescription(), account.getBalance());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    public void createAccount(AccountDTO accountDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_ACCOUNT);
            preparedStatement.setString(1, accountDTO.getAccountName());
            preparedStatement.setInt(2, accountDTO.getAdminId());
            preparedStatement.setString(3, accountDTO.getDescription());
            preparedStatement.setString(4, accountDTO.getPassword());
            preparedStatement.setDouble(5, accountDTO.getBalance());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
    public void deleteAccount(AccountDTO account) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ACCOUNT);
            PreparedStatement deleteRevenuesPreparedStatement = conn.prepareStatement(DELETE_ACCOUNT_REVENUES);
            PreparedStatement deleteExpensesPreparedStatement = conn.prepareStatement(DELETE_ACCOUNT_EXPENSES);
            PreparedStatement deleteAccFromUsersPreparedStatement = conn.prepareStatement(DELETE_ACCOUNT_ID_FROM_USERS);
            deleteRevenuesPreparedStatement.setInt(1, account.getId());
            deleteExpensesPreparedStatement.setInt(1, account.getId());
            deleteAccFromUsersPreparedStatement.setInt(1, account.getId());
            preparedStatement.setInt(1, account.getId());
            deleteRevenuesPreparedStatement.executeUpdate();
            deleteExpensesPreparedStatement.executeUpdate();
            deleteAccFromUsersPreparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void updateAccountName(String name) {

    }

    @Override
    public void updateAdminId(int id) {

    }

    @Override
    public void updateDescription(String description) {

    }

    @Override
    public void updatePassword(String password) {

    }

    @Override
    public void updateBalance(Float balance) {

    }
}
