package com.alidev.cashtrack.entity.impl;

import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public class AccountEntityImpl implements AccountEntity {
    private int id;
    private int adminId;
    private String name;
    private String description;
    private String password;
    private Double balance;
    private List<UserEntity> users;

    public AccountEntityImpl(){ };

    @Override
    public int getAccountId() {
        return id;
    }
    public void setAccountId(int id) { this.id = id; }
    @Override
    public int getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(int id) {
        this.adminId = id;
    }
    @Override
    public String getAccountName() {
        return name;
    }
    @Override
    public void setAccountName(String name) {
        this.name = name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String getPassword() { return password; }
    @Override
    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }
    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public List<UserEntity> getUsers(){
        return users;
    }
    public void setUser(UserEntity user){
        this.users.add(user);
    }
}
