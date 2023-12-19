package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.AccountDTO;
import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public class AccountDTOImpl implements AccountDTO {
    private int id;
    private int adminId;
    private String description;
    private String accountName;
    private Double balance;
    private String password;
    private List<UserEntity> users;

    // Contructores para obtener datos
    public AccountDTOImpl(int id, int adminId, String accName, String description, Double balance, String password) {
        this.id = id;
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
        this.password = password;
    }
    public AccountDTOImpl(int id, int adminId, String accName, String description, Double balance, String password, List<UserEntity> users) {
        this.id = id;
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
        this.password = password;
        this.users = users;
    }
    // Constructor de creación de cuentas
    public AccountDTOImpl(int adminId, String accName, String description, String password, Double balance) {
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.password = password;
        this.balance = balance;
    }
    public int getId(){
        return id;
    }
    public int getAdminId() {
        return adminId;
    }
    public String getAccountName() {
        return accountName;
    }
    @Override
    public String getDescription() {
        return description;
    }
    public Double getBalance() {
        return balance;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public List<UserEntity> getUsers() {
        return users;
    }
}
