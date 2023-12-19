package com.alidev.cashtrack.entity.impl;

import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;
import com.alidev.cashtrack.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class UserEntityImpl implements UserEntity {
    private int id;
    private String username;
    private String email;
    private String pin;
    private int accountId;
    private List<ExpenseEntity> expenses;
    private List<RevenueEntity> revenues;
    private Map<String, Integer> typesExpenses;
    private Map<String, Integer> typesRevenues;

    public UserEntityImpl(){ }

    public int getUserId(){
        return this.id;
    }
    public void setUserId(int id) { this.id = id; }
    public String getUsername(){
        return username;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPin() { return pin; }
    public boolean setPin(String pin){
        this.pin = pin;
        return true;
    }
    public void setAccountId(int id) { this.accountId = id; }
    public int getAccountId() { return accountId; }
    public void addRevenue(RevenueEntity revenueEntity){
        if (!typesRevenues.containsKey(revenueEntity.getType())){
            typesRevenues.put(revenueEntity.getType(), 1);
        } else {
            typesRevenues.put(revenueEntity.getType(), typesRevenues.get(revenueEntity.getType()) + 1);
        }
        this.revenues.add(revenueEntity);
    }

    public void addExpense(ExpenseEntity expenseEntity) {
        if (!typesExpenses.containsKey(expenseEntity.getType())){
            typesExpenses.put(expenseEntity.getType(), 1);
        } else {
            typesExpenses.put(expenseEntity.getType(), typesExpenses.get(expenseEntity.getType()) + 1);
        }
        this.expenses.add(expenseEntity);
    }

    public List<RevenueEntity> getRevenues(){
        return revenues;
    }

    public List<ExpenseEntity> getExpenses(){
        return expenses;
    }

    public Map<String, Integer> getTypesExpenses() {
        return typesExpenses;
    }

    public Map<String, Integer> getTypesRevenues() {
        return typesRevenues;
    }
}
