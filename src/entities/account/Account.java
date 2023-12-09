package entities.account;
import entities.money.Expense;
import entities.money.Revenue;
import entities.money.TypeExpenses;
import entities.money.TypeRevenues;
import exceptions.ExpenseException;
import interfaces.entities.account.IAccount;
import interfaces.entities.account.IAccountOps;
import entities.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account implements IAccount, IAccountOps {
    private Double balance;
    private User user;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private Map<TypeExpenses, Integer> typesExpenses;
    private Map<TypeRevenues, Integer> typesRevenues;

    public Account(User user){
        this.balance = 0.0;
        this.user = user;
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.typesExpenses = new HashMap<>();
        this.typesRevenues = new HashMap<>();
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
        if (!typesRevenues.containsKey(type)){
            typesRevenues.put(type, 1);
        } else {
            typesRevenues.put(type, typesRevenues.get(type) + 1);
        }
        this.setBalance(this.getBalance() + amount);
        this.revenues.add(new Revenue(amount, type, description));
    }

    private void addExpense(Double amount, TypeExpenses type, String description) throws ExpenseException{
        Double actualBalance = this.getBalance();
        if(amount > actualBalance){
            throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + this.getBalance());
        }
        if (!typesExpenses.containsKey(type)){
            typesExpenses.put(type, 1);
        } else {
            typesExpenses.put(type, typesExpenses.get(type) + 1);
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

    public Map<TypeExpenses, Integer> getTypesExpenses() {
        return typesExpenses;
    }

    public Map<TypeRevenues, Integer> getTypesRevenues() {
        return typesRevenues;
    }

    @Override
    public String toString(){
        return "\nAccountBalance: " + this.getBalance() + "\n" +
                "User: " + this.getUser();
    }
    public void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description) throws ExpenseException, NullPointerException {
        if(amount == null){
            throw new NullPointerException("Ingrese una cantidad valida e intentelo de nuevo.");
        }
        if (typeExpense != null) {
            addExpense(amount, typeExpense, description);
        } else if (typeRevenue != null) {
            addRevenue(amount, typeRevenue, description);
        }
    }
}
