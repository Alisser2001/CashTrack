package com.alidev.cashtrack.repository.impl;

import com.alidev.cashtrack.dto.ExpenseDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ExpenseDTO findById(int id) throws RepositoryException {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_EXPENSE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ExpenseEntity expense = new ExpenseEntity();
                expense.setExpenseId(resultSet.getInt("id"));
                expense.setMoney(resultSet.getDouble("amount"));
                expense.setType(resultSet.getString("type"));
                expense.setDescription(resultSet.getString("description"));
                expense.setUserId(resultSet.getInt("userId"));
                expense.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                preparedStatement.close();
                return new ExpenseDTO(expense.getExpenseId(), expense.getMoney(), expense.getType(), expense.getDescription(), expense.getUserId(), expense.getDateTime());
            }
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar el gasto.", (SQLException) e);
        }
        return null;
    }

    @Override
    public void createExpense(ExpenseDTO expenseDTO) throws RepositoryException {
        try{
            PreparedStatement getBalancePreparedStatement = conn.prepareStatement(GET_ACCOUNT_BALANCE);
            getBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            ResultSet accResultSet = getBalancePreparedStatement.executeQuery();
            double accBalance = accResultSet.getDouble("balance");
            getBalancePreparedStatement.close();
            if (accBalance < expenseDTO.getAmount()){
                throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + accBalance);
            } else {
                PreparedStatement preparedStatement = conn.prepareStatement(CREATE_EXPENSE);
                preparedStatement.setDouble(1, expenseDTO.getAmount());
                preparedStatement.setString(2, expenseDTO.getDescription());
                preparedStatement.setString(3, expenseDTO.getType());
                Timestamp timestamp = Timestamp.valueOf(expenseDTO.getDateTime());
                preparedStatement.setTimestamp(4, timestamp);
                preparedStatement.setInt(5, expenseDTO.getUserId());
                preparedStatement.executeUpdate();
                PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_REMOVE);
                updateBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
                updateBalancePreparedStatement.setInt(2, expenseDTO.getExpenseId());
                updateBalancePreparedStatement.executeUpdate();
                updateBalancePreparedStatement.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error al crear el gasto.", (SQLException) e);
        } catch (ExpenseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteExpense(ExpenseDTO expenseDTO) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_EXPENSE);
            preparedStatement.setInt(1, expenseDTO.getExpenseId());
            preparedStatement.executeUpdate();
            PreparedStatement updateBalancePreparedStatement = conn.prepareStatement(UPDATE_BALANCE_ADD);
            updateBalancePreparedStatement.setInt(1, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.setInt(2, expenseDTO.getExpenseId());
            updateBalancePreparedStatement.executeUpdate();
            updateBalancePreparedStatement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al borrar el gasto.", (SQLException) e);
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
            throw new DAOException("Error al encontrar el gasto.", (SQLException) e);
        }
    }

    @Override
    public void updateType(int id, String type) throws RepositoryException {
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_TYPE);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar el gasto.", (SQLException) e);
        }
    }

    @Override
    public List<ExpenseDTO> getExpensesByUserId(int userId) throws RepositoryException {
        try {
            List<ExpenseEntity> expenseEntities = new ArrayList<>();
            List<ExpenseDTO> expenseDTOs = new ArrayList<>();
            PreparedStatement preparedStatement = conn.prepareStatement(GET_EXPENSES_BY_USER_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ExpenseEntity expenseEntity = mapResultSetToExpenseEntity(resultSet);
                expenseEntities.add(expenseEntity);
            }
            expenseDTOs = mapExpenseEntitiesToDTOs(expenseEntities);
            return expenseDTOs;
        } catch (SQLException e) {
            throw new DAOException("Error al encontrar los gastos", (SQLException) e);
        }
    }

    @Override
    public Map<String, Integer> getTypesExpenses() throws RepositoryException {
        return null;
    }
}
