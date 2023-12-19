package com.alidev.cashtrack.dto;

public interface RevenueDTO extends MoneyDTO{
    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getRevenueId();
}
