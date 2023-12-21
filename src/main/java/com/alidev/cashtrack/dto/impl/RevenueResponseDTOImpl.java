package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.RevenueResponseDTO;

import java.time.LocalDateTime;

public class RevenueResponseDTOImpl extends MoneyRequestDTOImpl implements RevenueResponseDTO {
    private int id;

    public RevenueResponseDTOImpl(int id, Double amount, String type, String description, int user, LocalDateTime dateTime) {
        super(amount, type, description, user, dateTime);
        this.id = id;
    }
    public int getRevenueId(){
        return id;
    }
}
