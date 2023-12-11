package interfaces.entities.user;

import entities.money.Expense;
import entities.money.Revenue;
import entities.money.Types;
import java.util.List;
import java.util.Map;

public interface IUser {
    int getUserId();
    void setUserId(int id);
    String getUsername();
    void setUsername(String username);
    String getEmail();
    void setEmail(String email);
    boolean setPin(String pin);
    String getPin();
    void setAccountId(int id);
    int getAccountId();
    void addExpense(Double amount, Types type, String description, int userId);
    void addRevenue(Double amount, Types type, String description, int userId);
    List<Revenue> getRevenues();
    List<Expense> getExpenses();
    Map<Types, Integer> getTypesExpenses();
    Map<Types, Integer> getTypesRevenues();
    String toString();
}

