package dao.dto;

import entities.money.Revenue;
import entities.money.TypeRevenues;
import interfaces.dao.dto.IRevenueDTO;

import java.time.LocalDateTime;

public class RevenueDTO implements IRevenueDTO {
    private int id;
    private Double revenueAmount;
    private String revenueType;
    private String description;
    private UserDTO user;
    private LocalDateTime dateTime;

    public RevenueDTO(int id, Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.id = id;
        this.revenueAmount = amount;
        this.revenueType = type;
        this.description = description;
        this.user = user;
        this.dateTime = dateTime;
    }
    public RevenueDTO(Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.revenueAmount = amount;
        this.revenueType = type;
        this.description = description;
        this.user = user;
        this.dateTime = dateTime;
    }
    public int getId(){
        return id;
    }
    public Double getRevenueAmount() {
        return revenueAmount;
    }
    public String getRevenueType() {
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
