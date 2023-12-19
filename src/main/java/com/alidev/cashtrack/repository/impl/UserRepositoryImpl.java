package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.dto.UserDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDTO findById(int id) throws RepositoryException {
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
            throw new DAOException("Error al encontrar el usuario.", (SQLException) e);
        }
        return null;
    }

    @Override
    public UserDTO findByEmail(String email) throws RepositoryException {
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
            throw new DAOException("Error al encontrar el usuario.", (SQLException) e);
        }
        return null;
    }

    @Override
    public UserDTO findByUsername(String username) throws RepositoryException {
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
            throw new DAOException("Error al encontrar el usuario.", (SQLException) e);
        }
        return null;
    }

    @Override
    public void createUser(UserDTO userDTO) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getEmail());
            preparedStatement.setString(3, userDTO.getPin());
            preparedStatement.setInt(4, userDTO.getAccountId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al crear el usuario.", (SQLException) e);
        }
    }

    @Override
    public void deleteUser(UserDTO userDTO) throws RepositoryException {
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
            throw new DAOException("Error al eliminar el usuario .", (SQLException) e);
        }
    }

    @Override
    public void updateUsername(int id, String username) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USER_NAME);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar el nombre de usuario.", (SQLException) e);
        }
    }

    @Override
    public void updateEmail(int id, String email) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_EMAIL);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar el email.", (SQLException) e);
        }
    }

    @Override
    public void updatePin(int id, String pin) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PIN);
            preparedStatement.setString(1, pin);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar el pin.", (SQLException) e);
        }
    }

    @Override
    public void updateAccountId(int userId, int accId) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNT_ID);
            preparedStatement.setInt(1, accId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar la cuenta del usuario.", (SQLException) e);
        }
    }

    @Override
    public List<UserDTO> getUsersByAccountId(int id) throws RepositoryException {
        try {

        } catch (SQLException e) {
            throw new DAOException("Error al encontrar los gastos", (SQLException) e);
        }
        return null;
    }
}
