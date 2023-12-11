package dao.dto;

import interfaces.dao.dto.IExpenseDTO;
import java.time.LocalDateTime;

public class ExpenseDTO extends MoneyDTO implements IExpenseDTO {
    private int id;

    public ExpenseDTO(int id, Double amount, String type, String description, UserDTO user, LocalDateTime dateTime){
        this.id = id;
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUser(user);
        this.setDateTime(dateTime);
    }
    public ExpenseDTO(Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setType(type);
        this.setDescription(description);
        this.setUser(user);
        this.setDateTime(dateTime);
    }

    public int getExpenseId(){
        return id;
    }
}
