package dao.dto;

import entities.money.Expense;
import entities.money.TypeExpenses;
import interfaces.dao.dto.IExpenseDTO;

import java.time.LocalDateTime;

public class ExpenseDTO implements IExpenseDTO {
    private int expenseId;
    private Double expenseAmount;
    private TypeExpenses expenseType;
    private String description;
    private UserDTO user;
    private LocalDateTime dateTime;

    // Constructor que acepta una instancia de Expense
    public ExpenseDTO(Expense expense) {
        this.expenseId = expense.getExpenseId();
        this.expenseAmount = expense.getMoney();
        this.expenseType = expense.getType();
        this.description = expense.getDescription();
        this.user = new UserDTO(expense.getUser());
        this.dateTime = expense.getDateTime();
    }
    public int getExpenseId() {
        return expenseId;
    }
    public Double getExpenseAmount() {
        return expenseAmount;
    }
    public TypeExpenses getExpenseType() {
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
