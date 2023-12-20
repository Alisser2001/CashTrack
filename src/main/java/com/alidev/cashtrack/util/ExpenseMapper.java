package com.alidev.cashtrack.util;
import com.alidev.cashtrack.dto.ExpenseResponseDTO;
import com.alidev.cashtrack.dto.MoneyRequestDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import org.springframework.dao.DataAccessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ExpenseMapper {
    ExpenseEntity mapResultSetToExpenseEntity(ResultSet resultSet) throws DataAccessException, SQLException;
    ExpenseEntity mapExpenseDTOToExpenseEntity(MoneyRequestDTO expenseDTO);
    ExpenseResponseDTO mapExpenseEntityToExpenseDTO(ExpenseEntity expenseEntity);
    List<ExpenseEntity> mapResultSetToExpensesEntities(ResultSet resultSet);
    List<ExpenseEntity> mapExpensesDTOsToExpensesEntities(List<MoneyRequestDTO> expensesDTOs);
    List<ExpenseResponseDTO> mapExpensesEntitiesToExpensesDTOs(List<ExpenseEntity> expensesEntities);
}
