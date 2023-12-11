package dao.dto;

import interfaces.dao.dto.IMoneyDTO;
import java.time.LocalDateTime;

abstract class MoneyDTO implements IMoneyDTO {
    private Double amount;
    private String type;
    private String description;
    private int userId;
    private LocalDateTime dateTime;

    public Double getAmount() {
        return amount;
    }
    protected void setAmount(Double amount) { this.amount = amount; }
    public String getType() {
        return type;
    }
    protected void setType(String type){ this.type = type; }
    public String getDescription() {
        return description;
    }
    protected void setDescription(String description) { this.description = description; }
    public int getUserId() {
        return userId;
    }
    protected  void setUserId(int userId) { this.userId = userId; }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    protected void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
