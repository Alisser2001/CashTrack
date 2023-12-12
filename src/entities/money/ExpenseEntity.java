package entities.money;

import interfaces.entities.money.IExpenseEntity;
import java.time.LocalDateTime;

public class ExpenseEntity extends MoneyEntity implements IExpenseEntity {
    private int expense_id;
    public ExpenseEntity() { }
    public ExpenseEntity(Double expense, String type, String description, int userId){
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
