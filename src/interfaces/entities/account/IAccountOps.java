package interfaces.entities.account;
import entities.money.*;
import entities.user.User;
import exceptions.ExpenseException;

public interface IAccountOps {
    void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description, User user) throws ExpenseException;
}
