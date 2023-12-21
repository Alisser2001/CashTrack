package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.UserRequestDTO;
import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;

import java.util.List;
import java.util.Map;

public class UserRequestDTOImpl implements UserRequestDTO {
    private String username;
    private String email;
    private int accountId;
    private String pin;

    public UserRequestDTOImpl(){};
    public UserRequestDTOImpl(String username, String email, int accountId, String pin) {
        this.username = username;
        this.email = email;
        this.accountId = accountId;
        this.pin = pin;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public String getPin() {
        return pin;
    }
}
