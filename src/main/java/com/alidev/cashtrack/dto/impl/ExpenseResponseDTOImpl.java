package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;

import java.time.LocalDateTime;

public class ExpenseResponseDTOImpl extends MoneyRequestDTOImpl implements ExpenseResponseDTO {
    private int id;
    private LocalDateTime dateTime;

    public ExpenseResponseDTOImpl(int id, Double amount, String type, String description, int user, LocalDateTime dateTime){
        super(amount, type, description, user);
        this.id = id;
        this.dateTime = dateTime;
    }

    public int getExpenseId(){
        return id;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
