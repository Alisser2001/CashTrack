package com.alidev.cashtrack.dto.impl;

import com.alidev.cashtrack.dto.ExpenseResponseDTO;

import java.time.LocalDateTime;

public class ExpenseResponseDTOImpl extends MoneyRequestDTOImpl implements ExpenseResponseDTO {
    private int id;

    public ExpenseResponseDTOImpl(int id, Double amount, String type, String description, int user, LocalDateTime dateTime){
        super(amount, type, description, user, dateTime);
        this.id = id;
    }

    public int getExpenseId(){
        return id;
    }
}
