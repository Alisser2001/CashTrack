package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.entity.UserEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.UserRepository;
import com.alidev.cashtrack.util.SQLSentences;
import com.alidev.cashtrack.util.UserMapper;
import com.alidev.cashtrack.util.impl.SQLSentencesImpl;
import com.alidev.cashtrack.util.impl.UserMapperImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private SQLSentences sentences = new SQLSentencesImpl();
    private UserMapper userMapper = new UserMapperImpl();


    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserEntity findById(int id) throws RepositoryException {
        try {
            String FIND_USER_BY_ID = String.format(sentences.get_find_all_from_by_sentence(), "users", "id");
            return jdbcTemplate.queryForObject(FIND_USER_BY_ID,
                    (resultSet, rowNum) -> userMapper.mapResultSetToUserEntity(resultSet),
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ususario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public UserEntity findByEmail(String email) throws RepositoryException {
        try {
            String FIND_USER_BY_EMAIL = String.format(sentences.get_find_all_from_by_sentence(), "users", "email");
            return jdbcTemplate.queryForObject(FIND_USER_BY_EMAIL,
                    (resultSet, rowNum) -> userMapper.mapResultSetToUserEntity(resultSet),
                    email);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ususario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public UserEntity findByUsername(String username) throws RepositoryException {
        try {
            String FIND_USER_BY_USERNAME = String.format(sentences.get_find_all_from_by_sentence(), "users", "username");
            return jdbcTemplate.queryForObject(FIND_USER_BY_USERNAME,
                    (resultSet, rowNum) -> userMapper.mapResultSetToUserEntity(resultSet),
                    username);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el ususario.: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void createUser(UserEntity user) throws RepositoryException {
        try{
            String CREATE_USER = sentences.get_create_user_sentence();
            jdbcTemplate.update(CREATE_USER,
                    user.getUsername(),
                    user.getEmail(),
                    user.getPin(),
                    user.getAccountId());
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al crear el ususario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void deleteUser(int id) throws RepositoryException {
        try{
            String DELETE_USER = String.format(sentences.get_delete_entity_sentence(), "users", "id");
            String DELETE_REVENUES = String.format(sentences.get_delete_entity_sentence(), "revenues", "userId");
            String DELETE_EXPENSES = String.format(sentences.get_delete_entity_sentence(), "expenses", "userId");
            jdbcTemplate.update(DELETE_REVENUES,
                    id);
            jdbcTemplate.update(DELETE_EXPENSES,
                    id);
            jdbcTemplate.update(DELETE_USER,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al eliminar el ususario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateUsername(int id, String username) throws RepositoryException {
        try{
            String UPDATE_USER_NAME = String.format(sentences.get_update_value_sentence(), "users", "username", "id");
            jdbcTemplate.update(UPDATE_USER_NAME,
                    username,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar el nombre de ususario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateEmail(int id, String email) throws RepositoryException {
        try{
            String UPDATE_EMAIL = String.format(sentences.get_update_value_sentence(), "users", "email", "id");
            jdbcTemplate.update(UPDATE_EMAIL,
                    email,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar el email: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updatePin(int id, String pin) throws RepositoryException {
        try{
            String UPDATE_PIN = String.format(sentences.get_update_value_sentence(), "users", "pin", "id");
            jdbcTemplate.update(UPDATE_PIN,
                    pin,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar el pin: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateAccountId(int userId, int accId) throws RepositoryException {
        try{
            String UPDATE_ACCOUNT_ID = String.format(sentences.get_update_value_sentence(), "users", "account", "id");
            jdbcTemplate.update(UPDATE_ACCOUNT_ID,
                    accId,
                    userId);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar la cuenta del usuario: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public List<UserEntity> getUsersByAccountId(int id) throws RepositoryException {
        try {

        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar los usuarios: " + e.getMessage(), (DataAccessException) e);
        }
        return null;
    }
}
