package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.UserResponseDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;

import java.util.List;
import java.util.Map;

public class UserResponseDTOImpl implements UserResponseDTO {
    private int id;
    private String username;
    private String email;
    private int accountId;
    private List<ExpenseEntity> expenses;
    private List<RevenueEntity> revenues;
    private Map<String, Integer> typesExpenses;
    private Map<String, Integer> typesRevenues;

    public UserResponseDTOImpl(int id, String username, String email, int accId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountId = accId;
    }
    public UserResponseDTOImpl(int id, String username, String email, int accId, List<ExpenseEntity> expenses, List<RevenueEntity> revenues, Map<String, Integer> typesExpenses, Map<String, Integer> typesRevenues) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountId = accId;
        this.expenses = expenses;
        this.revenues = revenues;
        this.typesExpenses = typesExpenses;
        this.typesRevenues = typesRevenues;
    }
    public int getId(){
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public int getAccountId(){
        return accountId;
    }
    public List<ExpenseEntity> getExpenses() {
        return expenses;
    }
    public List<RevenueEntity> getRevenues() {
        return revenues;
    }
    public Map<String, Integer> getTypesExpenses() {
        return typesExpenses;
    }
    public Map<String, Integer> getTypesRevenues() {
        return typesRevenues;
    }
}
