package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public class AccountResponseDTOImpl implements AccountResponseDTO {
    private int id;
    private int adminId;
    private String description;
    private String accountName;
    private Double balance;
    private List<UserEntity> users;

    public AccountResponseDTOImpl(int id, int adminId, String accName, String description, Double balance) {
        this.id = id;
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
    }
    public AccountResponseDTOImpl(int id, int adminId, String accName, String description, Double balance, List<UserEntity> users) {
        this.id = id;
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
        this.users = users;
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
    public List<UserEntity> getUsers() {
        return users;
    }
}
