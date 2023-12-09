package interfaces.dao.dto;

import dao.dto.UserDTO;
import entities.money.TypeRevenues;
import java.time.LocalDateTime;


public interface IRevenueDTO {
    int getRevenueId();
    Double getRevenueAmount();
    TypeRevenues getRevenueType();
    String getDescription();
    UserDTO getUser();
    LocalDateTime getDateTime();
}
