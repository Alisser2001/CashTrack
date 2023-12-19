package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.MoneyDTO;

import java.time.LocalDateTime;

public class ExpenseDTOImpl extends MoneyDTOImpl implements MoneyDTO {
    private int id;

    // Constructor para obtener datos
    public ExpenseDTOImpl(int id, Double amount, String type, String description, int user, LocalDateTime dateTime){
        this.id = id;
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUserId(user);
        this.setDateTime(dateTime);
    }
    // Constructor para crear expenses
    public ExpenseDTOImpl(Double amount, String type, String description, int user, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUserId(user);
        this.setDateTime(dateTime);
    }

    public int getExpenseId(){
        return id;
    }
}
