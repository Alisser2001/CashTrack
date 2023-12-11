package dao.dto;

import interfaces.dao.dto.IRevenueDTO;
import java.time.LocalDateTime;

public class RevenueDTO extends MoneyDTO implements IRevenueDTO {
    private int id;

    public RevenueDTO(int id, Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.id = id;
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUser(user);
        this.setDateTime(dateTime);
    }
    public RevenueDTO(Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUser(user);
        this.setDateTime(dateTime);
    }
    public int getRevenueId(){
        return id;
    }
}
