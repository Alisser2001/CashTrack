package Account;
import Account.Money.Expense;
import Account.Money.Revenue;
import Exceptions.ExpenseException;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Double balance;
    private User user;
    private List<Expense> expenses;
    private List<Revenue> revenues;

    public Account(User user){
        this.balance = 0.0;
        this.user = user;
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
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

    public Double addRevenue(Double amount, String description){
        this.setBalance(amount);
        this.revenues.add(new Revenue(amount, description));
        return this.getBalance();
    }

    public Double addExpense(Double amount, String description) throws ExpenseException{
        if(this.getBalance() < amount){
            throw new ExpenseException();
        }
        this.setBalance(this.getBalance() - amount);
        this.expenses.add(new Expense(amount, description));
        return this.getBalance();
    }

    public List<Revenue> getRevenues(){
        return revenues;
    }

    public List<Expense> getExpenses(){
        return expenses;
    }

    @Override
    public String toString(){
        return "AccountBalance: " + balance +
                "User: " + user +
                "Expenses: " + expenses +
                "Revenues: " + revenues;
    }
}
