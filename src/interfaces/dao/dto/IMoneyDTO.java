package interfaces.dao.dto;

import dao.dto.UserDTO;
import java.time.LocalDateTime;

public interface IMoneyDTO {
    Double getAmount();
    String getType();
    String getDescription();
    UserDTO getUser();
    LocalDateTime getDateTime();
}
