package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.AccountRepository;
import com.alidev.cashtrack.util.AccountMapper;
import com.alidev.cashtrack.util.SQLSentences;
import com.alidev.cashtrack.util.impl.AccountMapperImpl;
import com.alidev.cashtrack.util.impl.SQLSentencesImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    private SQLSentences sentences = new SQLSentencesImpl();
    private AccountMapper accountMapper = new AccountMapperImpl();

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AccountEntity findById(int id) throws RepositoryException {
        try {
            String FIND_ACCOUNT_BY_ID = String.format(sentences.get_find_all_from_by_sentence(), "accounts", "id");
            return jdbcTemplate.queryForObject(FIND_ACCOUNT_BY_ID,
                    (resultSet, rowNum) -> accountMapper.mapResultSetToAccountEntity(resultSet),
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public AccountEntity findByAdminId(int id) throws RepositoryException {
        try {
            String FIND_ACCOUNT_BY_ADMIN_ID = String.format(sentences.get_find_all_from_by_sentence(), "accounts", "adminId");
            return jdbcTemplate.queryForObject(FIND_ACCOUNT_BY_ADMIN_ID,
                    (resultSet, rowNum) -> accountMapper.mapResultSetToAccountEntity(resultSet),
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void createAccount(AccountEntity account) throws RepositoryException {
        try{
            String CREATE_ACCOUNT = sentences.get_create_account_sentence();
            jdbcTemplate.update(CREATE_ACCOUNT,
                    account.getAccountName(),
                    account.getAdminId(),
                    account.getDescription(),
                    account.getPassword(),
                    account.getBalance());
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void deleteAccount(AccountEntity account) throws RepositoryException {
        try{
            String DELETE_ACCOUNT = String.format(sentences.get_delete_entity_sentence(), "accounts", "id");
            String DELETE_ACCOUNT_REVENUES = sentences.get_delete_account_revenues_sentence();
            String DELETE_ACCOUNT_EXPENSES = sentences.get_delete_account_expenses_sentence();
            String DELETE_ACCOUNT_ID_FROM_USERS = sentences.get_delete_account_id_from_users_sentence();
            jdbcTemplate.update(DELETE_ACCOUNT,
                    account.getAccountId());
            jdbcTemplate.update(DELETE_ACCOUNT_REVENUES,
                    account.getAccountId());
            jdbcTemplate.update(DELETE_ACCOUNT_EXPENSES,
                    account.getAccountId());
            jdbcTemplate.update(DELETE_ACCOUNT_ID_FROM_USERS,
                    account.getAccountId());
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void updateAccountName(int id, String name) throws RepositoryException {
        try{
            String UPDATE_ACCOUNT_NAME = String.format(sentences.get_update_value_sentence(), "accounts", "accountName", "id");
            jdbcTemplate.update(UPDATE_ACCOUNT_NAME,
                    name,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void updateAdminId(int accId, int id) throws RepositoryException {
        try{
            String UPDATE_ADMIN_ID = String.format(sentences.get_update_value_sentence(), "accounts", "adminId", "id");
            jdbcTemplate.update(UPDATE_ADMIN_ID,
                    id,
                    accId);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {
        try{
            String UPDATE_DESCRIPTION = String.format(sentences.get_update_value_sentence(), "accounts", "description", "id");
            jdbcTemplate.update(UPDATE_DESCRIPTION,
                    description,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }

    @Override
    public void updatePassword(int id, String password) throws RepositoryException {
        try{
            String UPDATE_PASSWORD = String.format(sentences.get_update_value_sentence(), "accounts", "password", "id");
            jdbcTemplate.update(UPDATE_PASSWORD,
                    password,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar la cuenta.", (DataAccessException) e);
        }
    }
}
