package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.dto.impl.ExpenseResponseDTOImpl;
import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.impl.ExpenseEntityImpl;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.util.ExpenseMapper;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ExpenseMapperImpl implements ExpenseMapper {
    @Override
    public ExpenseEntity mapResultSetToExpenseEntity(ResultSet resultSet) throws DataAccessException, SQLException {
        int expenseId = resultSet.getInt("id");
        double amount = resultSet.getDouble("amount");
        String description = resultSet.getString("description");
        String type = resultSet.getString("type");
        LocalDateTime dateTime = resultSet.getTimestamp("date_time").toLocalDateTime();
        int userId = resultSet.getInt("userId");
        ExpenseEntity expense = new ExpenseEntityImpl();
        expense.setExpenseId(expenseId);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setType(type);
        expense.setDateTime(dateTime);
        expense.setUserId(userId);
        return expense;
    }

    @Override
    public ExpenseEntity mapExpenseDTOToExpenseEntity(MoneyRequestDTO expenseDTO) {
        ExpenseEntity expense = new ExpenseEntityImpl();
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setType(expenseDTO.getType());
        expense.setDateTime(expenseDTO.getDateTime());
        expense.setUserId(expenseDTO.getUserId());
        return expense;
    }

    @Override
    public ExpenseResponseDTO mapExpenseEntityToExpenseDTO(ExpenseEntity expenseEntity) {
        int expenseId = expenseEntity.getExpenseId();
        double amount = expenseEntity.getAmount();
        String description = expenseEntity.getDescription();
        String type = expenseEntity.getType();
        LocalDateTime dateTime = expenseEntity.getDateTime();
        int userId = expenseEntity.getUserId();
        return new ExpenseResponseDTOImpl(
                expenseId,
                amount,
                type,
                description,
                userId,
                dateTime
        );
    }

    @Override
    public List<ExpenseEntity> mapResultSetToExpensesEntities(ResultSet resultSet) throws RepositoryException {
        try{
            List<ExpenseEntity> expensesEntities = new ArrayList<>();
            while (resultSet.next()) {
                ExpenseEntity expense = mapResultSetToExpenseEntity(resultSet);
                expensesEntities.add(expense);
            }
            return expensesEntities;
        } catch(DataAccessException e){
            throw new RepositoryException("Error al mapear el resultado.", (DataAccessException) e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExpenseEntity> mapExpensesDTOsToExpensesEntities(List<MoneyRequestDTO> expensesDTOs) {
        List<ExpenseEntity> expEntities = new ArrayList<>();
        for (MoneyRequestDTO dto : expensesDTOs) {
            ExpenseEntity expense = mapExpenseDTOToExpenseEntity(dto);
            expEntities.add(expense);
        }
        return expEntities;
    }

    @Override
    public List<ExpenseResponseDTO> mapExpensesEntitiesToExpensesDTOs(List<ExpenseEntity> expensesEntities) {
        List<ExpenseResponseDTO> dtos = new ArrayList<>();
        for (ExpenseEntity entity : expensesEntities) {
            ExpenseResponseDTO dto = mapExpenseEntityToExpenseDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
