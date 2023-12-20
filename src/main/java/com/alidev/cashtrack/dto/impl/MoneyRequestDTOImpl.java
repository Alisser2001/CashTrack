package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.MoneyRequestDTO;

import java.time.LocalDateTime;

public class MoneyRequestDTOImpl implements MoneyRequestDTO {
    private Double amount;
    private String type;
    private String description;
    private int userId;
    private LocalDateTime dateTime;

    public MoneyRequestDTOImpl(Double amount, String type, String description, int userId, LocalDateTime dateTime){
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public Double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public int getUserId() {
        return userId;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
