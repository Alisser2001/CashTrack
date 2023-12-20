package com.alidev.cashtrack.dto;

import java.time.LocalDateTime;

public interface MoneyRequestDTO {
    Double getAmount();
    String getType();
    String getDescription();
    int getUserId();
    LocalDateTime getDateTime();
}
