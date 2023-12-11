package dao;

import dao.dto.UserDTO;
import entities.user.User;
import exceptions.DAOException;
import interfaces.dao.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private final Connection conn;
    public UserDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public UserDTO findById(int id) throws DAOException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
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
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
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
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
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
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO users (username, email, pin, account) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getEmail());
            preparedStatement.setString(3, userDTO.getPin());
            preparedStatement.setInt(4, userDTO.getAccountId());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
    @Override
    public void deleteUser(UserDTO userDTO) throws DAOException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, userDTO.getId());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar la cuenta.", (SQLException) e);
        }
    }
}
