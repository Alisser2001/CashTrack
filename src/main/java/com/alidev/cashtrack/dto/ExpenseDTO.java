package com.alidev.cashtrack.dto;

public interface ExpenseDTO extends MoneyDTO{
    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getExpenseId();
}
