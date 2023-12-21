package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.AccountRequestDTO;

public class AccountRequestDTOImpl implements AccountRequestDTO {
    private int adminId;
    private String description;
    private String accountName;
    private String password;
    private Double balance;

    public AccountRequestDTOImpl(){};
    public AccountRequestDTOImpl(int adminId, String accountName, String description, String password, Double balance) {
        this.adminId = adminId;
        this.accountName = accountName;
        this.description = description;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public int getAdminId() {
        return adminId;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
