package interfaces.dao.dto;

import dao.dto.UserDTO;
import entities.money.TypeExpenses;
import java.time.LocalDateTime;

public interface IExpenseDTO {
    int getExpenseId();
    Double getExpenseAmount();
    TypeExpenses getExpenseType();
    String getDescription();
    UserDTO getUser();
    LocalDateTime getDateTime();
}
