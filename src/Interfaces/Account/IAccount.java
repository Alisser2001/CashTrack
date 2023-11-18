package Interfaces.Account;
import User.User;
import Account.Money.*;
import java.util.List;
import java.util.Map;

public interface IAccount {
    Double getBalance();
    void setBalance(Double balance);
    User getUser();
    void setUser(User user);
    List<Revenue> getRevenues();
    List<Expense> getExpenses();
    Map<TypeExpenses, Integer> getTypesExpenses();
    Map<TypeRevenues, Integer> getTypesRevenues();
    String toString();
}
