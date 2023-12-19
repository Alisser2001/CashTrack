package com.alidev.cashtrack.util.impl;

import com.alidev.cashtrack.util.ExpenseMapper;

public class ExpenseMapperImpl implements ExpenseMapper {
    private ExpenseEntity mapResultSetToExpenseEntity(ResultSet resultSet) throws SQLException {
        int expenseId = resultSet.getInt("id");
        double amount = resultSet.getDouble("amount");
        String type = resultSet.getString("type");
        int userId = resultSet.getInt("userId");
        LocalDateTime dateTime = resultSet.getTimestamp("date_time").toLocalDateTime();
        String description = resultSet.getString("description");
        ExpenseEntity expense = new ExpenseEntity(amount, type, description, userId, dateTime);
        expense.setExpenseId(expenseId);
        return expense;
    }

    private List<ExpenseDTO> mapExpenseEntitiesToDTOs(List<ExpenseEntity> entities) {
        List<ExpenseDTO> dtos = new ArrayList<>();
        for (ExpenseEntity entity : entities) {
            ExpenseDTO dto = new ExpenseDTO(entity.getExpenseId(), entity.getMoney(), entity.getType(), entity.getDescription(), entity.getUserId(), entity.getDateTime());
            dtos.add(dto);
        }
        return dtos;
    }
}
