package com.alidev.cashtrack.entity.impl;

import com.alidev.cashtrack.entity.MoneyEntity;
import java.time.LocalDateTime;

abstract class MoneyEntityImpl implements MoneyEntity {
    private Double money;
    private String description;
    private LocalDateTime date_time;
    private String type;
    private int userId;

    public Double getAmount() {
        return money;
    }

    public void setAmount(Double money){
        this.money = money;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getDateTime(){
        return date_time;
    }
    public void setDateTime(LocalDateTime date_time){
        this.date_time = date_time;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int id){
        this.userId = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}
