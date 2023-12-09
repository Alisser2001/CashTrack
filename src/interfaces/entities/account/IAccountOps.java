package interfaces.entities.account;
import entities.money.*;
import exceptions.ExpenseException;

public interface IAccountOps {
    void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description) throws ExpenseException;
}
