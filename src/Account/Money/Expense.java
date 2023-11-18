package Account.Money;

import Interfaces.Account.Money.IExpense;

import java.time.LocalDateTime;

public class Expense extends Money<TypeExpenses> implements IExpense {
    private final int expense_id;
    public Expense(Double expense, TypeExpenses type, String description){
        this.setMoney(expense);
        this.setDescription(description);
        this.setType(type);
        this.setDateTime(LocalDateTime.now());
        this.expense_id = Money.getExpensesAmount();
        Money.updateExpensesAmount();
    }
    public int getExpenseId(){
        return expense_id;
    }

    @Override
    public String toString(){
        return this.getExpenseId() + ". " + this.getMoney() + " (" + this.getType() + "): " + this.getDescription();
    }
}
