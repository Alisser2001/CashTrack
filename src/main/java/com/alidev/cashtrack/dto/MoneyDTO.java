package com.alidev.cashtrack.dto;

import java.time.LocalDateTime;

public interface MoneyDTO {
    Double getAmount();
    String getType();
    String getDescription();
    int getUserId();
    LocalDateTime getDateTime();
}
