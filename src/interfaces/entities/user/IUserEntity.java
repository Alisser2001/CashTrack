package interfaces.entities.user;

import entities.money.ExpenseEntity;
import entities.money.RevenueEntity;

import java.util.List;
import java.util.Map;

public interface IUserEntity {
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
    void addExpense(Double amount, String type, String description, int userId);
    void addRevenue(Double amount, String type, String description, int userId);
    List<RevenueEntity> getRevenues();
    List<ExpenseEntity> getExpenses();
    Map<String, Integer> getTypesExpenses();
    Map<String, Integer> getTypesRevenues();
    String toString();
}

