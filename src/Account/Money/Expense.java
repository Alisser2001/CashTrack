package Account.Money;

public class Expense extends Money {
    public Expense(Double expense, String description){
        this.setMoney(expense);
        this.setDescription(description);
    }
    @Override
    public String toString(){
        return this.getMoney() + ": " + this.getDescription();
    }
}
