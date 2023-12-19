package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.dto.AccountDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.AccountRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AccountDTO findById(int id) throws RepositoryException {
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
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
        return null;
    }

    @Override
    public AccountDTO findByAdminId(int id) throws RepositoryException {
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
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
        return null;
    }

    @Override
    public void createAccount(AccountDTO accountDTO) throws RepositoryException {
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
            throw new DAOException("Error al crear la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void deleteAccount(AccountDTO accountDTO) throws RepositoryException {
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
            throw new DAOException("Error al borrar la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void updateAccountName(int id, String name) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNT_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void updateAdminId(int accId, int id) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ADMIN_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, accId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta..", (SQLException) e);
        }
    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_DESCRIPTION);
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta..", (SQLException) e);
        }
    }

    @Override
    public void updatePassword(int id, String password) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PASSWORD);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
}
