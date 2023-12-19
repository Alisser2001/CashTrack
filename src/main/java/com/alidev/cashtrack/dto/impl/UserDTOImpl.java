package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.UserDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;

import java.util.List;
import java.util.Map;

public class UserDTOImpl implements UserDTO {
    private int id;
    private String username;
    private String email;
    private int accountId;
    private String pin;
    private List<ExpenseEntity> expenses;
    private List<RevenueEntity> revenues;
    private Map<String, Integer> typesExpenses;
    private Map<String, Integer> typesRevenues;

    // Constructor para crear users
    public UserDTOImpl(String username, String email, int accId, String pin) {
        this.username = username;
        this.email = email;
        this.accountId = accId;
        this.pin = pin;
    }
    // Constructores para obtener datos
    public UserDTOImpl(int id, String username, String email, int accId, String pin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountId = accId;
        this.pin = pin;
    }
    public UserDTOImpl(int id, String username, String email, int accId, String pin, List<ExpenseEntity> expenses, List<RevenueEntity> revenues, Map<String, Integer> typesExpenses, Map<String, Integer> typesRevenues) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountId = accId;
        this.pin = pin;
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
    public String getPin(){
        return pin;
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
