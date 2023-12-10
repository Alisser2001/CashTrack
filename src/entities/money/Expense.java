package entities.money;

import entities.user.User;
import interfaces.entities.money.IExpense;

import java.time.LocalDateTime;

public class Expense extends Money<TypeExpenses> implements IExpense {
    private int expense_id;
    public Expense(Double expense, TypeExpenses type, String description, User user){
        this.setMoney(expense);
        this.setDescription(description);
        this.setType(type);
        this.setUserId(user);
        this.setDateTime(LocalDateTime.now());
    }
    public int getExpenseId(){
        return expense_id;
    }
    public void setExpenseId(int id){
        this.expense_id = id;
    }
    @Override
    public String toString(){
        return this.getExpenseId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}
