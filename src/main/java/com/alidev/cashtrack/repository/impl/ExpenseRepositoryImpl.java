package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.exception.ExpenseException;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.ExpenseRepository;
import com.alidev.cashtrack.util.ExpenseMapper;
import com.alidev.cashtrack.util.SQLSentences;
import com.alidev.cashtrack.util.impl.ExpenseMapperImpl;
import com.alidev.cashtrack.util.impl.SQLSentencesImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;
    private SQLSentences sentences = new SQLSentencesImpl();
    private ExpenseMapper expenseMapper = new ExpenseMapperImpl();

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ExpenseEntity findById(int id) throws RepositoryException {
        try {
            String FIND_EXPENSE_BY_ID = String.format(sentences.get_find_all_from_by_sentence(), "expenses", "id");
            return jdbcTemplate.queryForObject(FIND_EXPENSE_BY_ID,
                    (resultSet, rowNum) -> expenseMapper.mapResultSetToExpenseEntity(resultSet),
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar el gasto: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void createExpense(ExpenseEntity expense) throws RepositoryException {
        try{
            String CREATE_EXPENSE = String.format(sentences.get_create_money_sentence(), "expenses");
            Timestamp timestamp = Timestamp.valueOf(expense.getDateTime());
            jdbcTemplate.update(CREATE_EXPENSE,
                    expense.getAmount(),
                    expense.getDescription(),
                    expense.getType(),
                    timestamp,
                    expense.getUserId());
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al registrar el gasto: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void deleteExpense(int id) throws RepositoryException {
        try{
            String DELETE_EXPENSE = String.format(sentences.get_delete_entity_sentence(), "expenses", "id");
            jdbcTemplate.update(DELETE_EXPENSE,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al borrar el gasto: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {
        try{
            String UPDATE_DESCRIPTION = String.format(sentences.get_update_value_sentence(), "expenses", "description", "id");
            jdbcTemplate.update(UPDATE_DESCRIPTION,
                    description,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar la descripcion de gasto: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {
        try{
            String UPDATE_TYPE = String.format(sentences.get_update_value_sentence(), "expenses", "type", "id");
            jdbcTemplate.update(UPDATE_TYPE,
                    type,
                    id);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al actualizar el tipo de gasto: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public List<ExpenseEntity> getExpensesByUserId(int userId) throws RepositoryException {
        try {
            String GET_EXPENSES_BY_USER_ID = String.format(sentences.get_all_from_by_sentence(), "expenses", "userId");
            return jdbcTemplate.queryForObject(GET_EXPENSES_BY_USER_ID,
                    (resultSet, rowNum) -> {
                        try {
                            return expenseMapper.mapResultSetToExpensesEntities(resultSet);
                        } catch (RepositoryException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    userId);
        } catch (DataAccessException e) {
            throw new RepositoryException("Error al encontrar los gastos: " + e.getMessage(), (DataAccessException) e);
        }
    }

    @Override
    public Map<String, Integer> getTypesExpenses() throws RepositoryException {
        return null;
    }
}
