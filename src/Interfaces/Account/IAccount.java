package Interfaces.Account;
import User.User;
import Account.Money.*;
import Exceptions.ExpenseException;
import java.util.List;

public interface IAccount {
    Double getBalance();
    void setBalance(Double balance);
    User getUser();
    void setUser(User user);
    List<Revenue> getRevenues();
    List<Expense> getExpenses();
    String toString();
}
