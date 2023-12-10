package interfaces.dao.dto;

import dao.dto.UserDTO;
import entities.money.TypeRevenues;
import java.time.LocalDateTime;


public interface IRevenueDTO {
    Double getRevenueAmount();
    String getRevenueType();
    String getDescription();
    UserDTO getUser();
    LocalDateTime getDateTime();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
}
