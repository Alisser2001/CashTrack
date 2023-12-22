package com.alidev.cashtrack.dto;

import java.time.LocalDateTime;

public interface RevenueResponseDTO extends MoneyRequestDTO {
    int getRevenueId();
    LocalDateTime getDateTime();
}
