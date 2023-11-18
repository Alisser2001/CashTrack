package Account.Money;

import Interfaces.Account.Money.IExpense;

import java.time.LocalDateTime;

public class Expense extends Money implements IExpense {
    private int expense_id;
    private TypeExpenses type;
    public Expense(Double expense, TypeExpenses type, String description){
        this.setMoney(expense);
        this.setDescription(description);
        this.type = type;
        this.setDateTime(LocalDateTime.now());
        this.expense_id = Money.getExpensesAmount();
        Money.updateExpensesAmount();
    }
    public int getExpenseId(){
        return expense_id;
    }

    public TypeExpenses getType() {
        return type;
    }

    @Override
    public String toString(){
        return this.getExpenseId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}
