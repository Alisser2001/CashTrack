package dao;

import dao.dto.UserDTO;
import entities.user.UserEntity;
import exceptions.DAOException;
import interfaces.dao.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private final Connection conn;
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String CREATE_USER = "INSERT INTO users (username, email, pin, account) VALUES (?, ?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    private static final String DELETE_REVENUES = "DELETE FROM revenues WHERE userId = ?;";
    private static final String DELETE_EXPENSES = "DELETE FROM expenses WHERE userId = ?;";

    public UserDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public UserDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setAccountId(resultSet.getInt("account"));
                preparedStatement.close();
                return new UserDTO(user.getUserId(), user.getUsername(), user.getEmail(), user.getAccountId());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public UserDTO findByEmail(String email) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setAccountId(resultSet.getInt("account"));
                preparedStatement.close();
                return new UserDTO(user.getUserId(), user.getUsername(), user.getEmail(), user.getAccountId());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public UserDTO findByUsername(String username) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setAccountId(resultSet.getInt("account"));
                preparedStatement.close();
                return new UserDTO(user.getUserId(), user.getUsername(), user.getEmail(), user.getAccountId());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta", (SQLException) e);
        }
        return null;
    }
    @Override
    public void createUser(UserDTO userDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getEmail());
            preparedStatement.setString(3, userDTO.getPin());
            preparedStatement.setInt(4, userDTO.getAccountId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
    @Override
    public void deleteUser(UserDTO userDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER);
            PreparedStatement deleteRevenuesPreparedStatement = conn.prepareStatement(DELETE_REVENUES);
            PreparedStatement deleteExpensesPreparedStatement = conn.prepareStatement(DELETE_EXPENSES);
            deleteRevenuesPreparedStatement.setInt(1, userDTO.getId());
            deleteExpensesPreparedStatement.setInt(1, userDTO.getId());
            preparedStatement.setInt(1, userDTO.getId());
            deleteRevenuesPreparedStatement.executeUpdate();
            deleteExpensesPreparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }

    @Override
    public void updateUsername(String username) {

    }

    @Override
    public void updateEmail(String email) {

    }

    @Override
    public void updatePin(String pin) {

    }

    @Override
    public void updateAccountId(int id) {

    }
}
