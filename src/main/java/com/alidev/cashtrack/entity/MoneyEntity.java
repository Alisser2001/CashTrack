package com.alidev.cashtrack.entity;

import java.time.LocalDateTime;

public interface MoneyEntity {
    Double getAmount();
    void setAmount(Double money);
    String getDescription();
    void setDescription(String description);
    String getType();
    void setType(String type);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime date_time);
    int getUserId();
    void setUserId(int id);
}
