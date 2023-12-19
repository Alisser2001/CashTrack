package com.alidev.cashtrack.dto;

import com.alidev.cashtrack.entity.UserEntity;

import java.util.List;

public interface AccountDTO {
    // Métodos obligatorios en la transferencia de la capa de presentación a la DB y vicenversa
    int getAdminId();
    String getAccountName();
    String getDescription();
    Double getBalance();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
    String getPassword();
    List<UserEntity> getUsers();
}
