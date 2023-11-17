package Account;
import Account.Money.Expense;
import Account.Money.Revenue;
import Account.Money.TypeExpenses;
import Account.Money.TypeRevenues;
import Exceptions.ExpenseException;
import Interfaces.Account.IAccount;
import Interfaces.Account.IAccountOps;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount, IAccountOps {
    private Double balance;
    private User user;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private List<TypeExpenses> typesExpenses;
    private List<TypeRevenues> typesRevenues;

    public Account(User user){
        this.balance = 0.0;
        this.user = user;
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.typesExpenses = new ArrayList<>();
        this.typesRevenues = new ArrayList<>();
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    private void addRevenue(Double amount, TypeRevenues type, String description){
        if (!typesRevenues.contains(type)){
            typesRevenues.add(type);
        }
        this.setBalance(this.getBalance() + amount);
        this.revenues.add(new Revenue(amount, type, description));
    }

    private void addExpense(Double amount, TypeExpenses type, String description) throws ExpenseException{
        Double actualBalance = this.getBalance();
        if(amount > actualBalance){
            throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + this.getBalance());
        }
        if (!typesExpenses.contains(type)){
            this.typesExpenses.add(type);
        }
        this.setBalance(this.getBalance() - amount);
        this.expenses.add(new Expense(amount, type, description));
    }

    public List<Revenue> getRevenues(){
        return revenues;
    }

    public List<Expense> getExpenses(){
        return expenses;
    }

    public List<TypeExpenses> getTypesExpenses() {
        return typesExpenses;
    }
    public List<TypeRevenues> getTypesRevenues() {
        return typesRevenues;
    }

    @Override
    public String toString(){
        return "\nAccountBalance: " + this.getBalance() + "\n" +
                "User: " + this.getUser();
    }
    public void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description) throws ExpenseException {
        if (typeExpense != null) {
            addExpense(amount, typeExpense, description);
        } else if (typeRevenue != null) {
            addRevenue(amount, typeRevenue, description);
        }
    }
}
