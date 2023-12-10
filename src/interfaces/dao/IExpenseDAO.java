package interfaces.dao;

import dao.dto.ExpenseDTO;

public interface IExpenseDAO {
    ExpenseDTO findById(int id);
    void createExpense(ExpenseDTO expenseDTO);
    void deleteExpense(int id);
}
