package interfaces.dao;

public interface IExpenseDAO {
    ExpenseDTO findById(int id);
    void createExpense(ExpenseDTO expenseDTO);
    void updateExpense(ExpenseDTO expenseDTO);
    void deleteExpense(int id);
}
