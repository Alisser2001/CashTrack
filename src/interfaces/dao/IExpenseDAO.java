package interfaces.dao;

import dao.dto.ExpenseDTO;
import exceptions.DAOException;

public interface IExpenseDAO {
    ExpenseDTO findById(int id) throws DAOException;
    void createExpense(ExpenseDTO expenseDTO) throws DAOException;
    void deleteExpense(ExpenseDTO expenseDTO) throws DAOException;
    void updateAmount(Float amount);
    void updateDescription(String description);
    void updateType(String type);
}
