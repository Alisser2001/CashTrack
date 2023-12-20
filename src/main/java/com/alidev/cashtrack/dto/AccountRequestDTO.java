package com.alidev.cashtrack.dto;

import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public interface AccountRequestDTO {
    String getAccountName();
    String getDescription();
    Double getBalance();
    int getAdminId();
    String getPassword();
}
