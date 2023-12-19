package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.RevenueDTO;

import java.time.LocalDateTime;

public class RevenueDTOImpl extends MoneyDTOImpl implements RevenueDTO {
    private int id;

    // Constructor para obtener datos
    public RevenueDTOImpl(int id, Double amount, String type, String description, int user, LocalDateTime dateTime) {
        this.id = id;
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUserId(user);
        this.setDateTime(dateTime);
    }
    //Constructor para crear revenues
    public RevenueDTOImpl(Double amount, String type, String description, int user, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUserId(user);
        this.setDateTime(dateTime);
    }
    public int getRevenueId(){
        return id;
    }
}
