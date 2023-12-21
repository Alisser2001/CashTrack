package com.alidev.cashtrack.dto;

import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public interface AccountResponseDTO {
    int getId();
    String getAccountName();
    String getDescription();
    Double getBalance();
    int getAdminId();
    List<UserEntity> getUsers();
}
