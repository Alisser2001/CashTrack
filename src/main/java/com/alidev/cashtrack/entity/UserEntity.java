package com.alidev.cashtrack.entity;

import java.util.List;
import java.util.Map;

public interface UserEntity {
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
    void addExpense(ExpenseEntity expense);
    void addRevenue(RevenueEntity revenue);
    List<RevenueEntity> getRevenues();
    List<ExpenseEntity> getExpenses();
    Map<String, Integer> getTypesExpenses();
    Map<String, Integer> getTypesRevenues();
}
