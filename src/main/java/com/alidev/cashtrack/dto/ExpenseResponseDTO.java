package com.alidev.cashtrack.dto;

import java.time.LocalDateTime;

public interface ExpenseResponseDTO extends MoneyRequestDTO {
    int getExpenseId();
    LocalDateTime getDateTime();
}
