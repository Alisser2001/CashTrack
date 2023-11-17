package Interfaces.Account;
import Account.Money.*;
import Exceptions.ExpenseException;

public interface IAccountOps {
    void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description) throws ExpenseException;
}
