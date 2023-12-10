package dao.dto;

import entities.money.Expense;
import entities.money.TypeExpenses;
import interfaces.dao.dto.IExpenseDTO;

import java.time.LocalDateTime;

public class ExpenseDTO implements IExpenseDTO {
    private int id;
    private Double expenseAmount;
    private String expenseType;
    private String description;
    private UserDTO user;
    private LocalDateTime dateTime;

    public ExpenseDTO(int id, Double amount, String type, String description, UserDTO user, LocalDateTime dateTime){
        this.id = id;
        this.expenseAmount = amount;
        this.expenseType = type;
        this.description = description;
        this.user = user;
        this.dateTime = dateTime;
    }
    public ExpenseDTO(Double amount, String type, String description, UserDTO user, LocalDateTime dateTime) {
        this.expenseAmount = amount;
        this.expenseType = type;
        this.description = description;
        this.user = user;
        this.dateTime = dateTime;
    }

    public int getId(){
        return id;
    }
    public Double getExpenseAmount() {
        return expenseAmount;
    }
    public String getExpenseType() {
        return expenseType;
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
