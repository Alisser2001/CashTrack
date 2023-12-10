package interfaces.dao.dto;

import dao.dto.UserDTO;
import entities.money.TypeExpenses;
import java.time.LocalDateTime;

public interface IExpenseDTO {
    Double getExpenseAmount();
    String getExpenseType();
    String getDescription();
    UserDTO getUser();
    LocalDateTime getDateTime();

    // Métodos opcionales sólo en transferencia de información desde la DB a la capa de presentación
    int getId();
}
