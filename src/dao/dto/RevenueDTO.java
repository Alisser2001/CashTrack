package dao.dto;

import entities.money.Revenue;
import entities.money.TypeRevenues;
import interfaces.dao.dto.IRevenueDTO;

import java.time.LocalDateTime;

public class RevenueDTO implements IRevenueDTO {
    private int revenueId;
    private Double revenueAmount;
    private TypeRevenues revenueType;
    private String description;
    private UserDTO user;
    private LocalDateTime dateTime;

    public RevenueDTO(Revenue revenue) {
        this.revenueId = revenue.getRevenueId();
        this.revenueAmount = revenue.getMoney();
        this.revenueType = revenue.getType();
        this.description = revenue.getDescription();
        this.user = new UserDTO(revenue.getUser());
        this.dateTime = revenue.getDateTime();
    }

    public int getRevenueId() {
        return revenueId;
    }
    public Double getRevenueAmount() {
        return revenueAmount;
    }
    public TypeRevenues getRevenueType() {
        return revenueType;
    }
    public String getDescription() {
        return description;
    }
    public UserDTO getUser() {
        return user;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
