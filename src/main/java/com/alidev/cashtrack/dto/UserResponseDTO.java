package com.alidev.cashtrack.dto;

import com.alidev.cashtrack.entity.ExpenseEntity;
import com.alidev.cashtrack.entity.RevenueEntity;

import java.util.List;
import java.util.Map;

public interface UserResponseDTO {
    int getId();
    String getUsername();
    String getEmail();
    int getAccountId();
    List<ExpenseEntity> getExpenses();
    List<RevenueEntity> getRevenues();
    Map<String, Integer> getTypesExpenses();
    Map<String, Integer> getTypesRevenues();
}
