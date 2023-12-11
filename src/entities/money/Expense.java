package entities.money;

import interfaces.entities.money.IExpense;
import java.time.LocalDateTime;

public class Expense extends Money implements IExpense {
    private int expense_id;
    public Expense() { }
    public Expense(Double expense, String type, String description, int userId){
        this.setMoney(expense);
        this.setDescription(description);
        this.setType(type);
        this.setUserId(userId);
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
