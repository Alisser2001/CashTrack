package com.alidev.cashtrack.entity;

public interface ExpenseEntity extends MoneyEntity{
    int getExpenseId();
    void setExpenseId(int id);
}
