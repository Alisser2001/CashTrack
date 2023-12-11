package entities.user;

import entities.money.Expense;
import entities.money.Revenue;
import entities.money.Types;
import interfaces.entities.user.IUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements IUser {
    private int id;
    private String username;
    private String email;
    private String pin;
    private int accountId;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private Map<Types, Integer> typesExpenses;
    private Map<Types, Integer> typesRevenues;

    public User(){ }
    public User(String username){
        this.username = username;
    }
    public User(int id, String username){
        this.id = id;
        this.username = username;
    }
    public User(int id, String username, String email, String pin, int accId){
        this.id = id;
        this.username = username;
        this.email = email;
        this.pin = pin;
        this.accountId = accId;
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.typesExpenses = new HashMap<>();
        this.typesRevenues = new HashMap<>();
    }

    public int getUserId(){
        return this.id;
    }
    public void setUserId(int id) { this.id = id; }
    public String getUsername(){
        return username;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPin() { return pin; }
    public boolean setPin(String pin){
        this.pin = pin;
        return true;
    }
    public void setAccountId(int id) { this.accountId = id; }
    public int getAccountId() { return accountId; }
    public void addRevenue(Double amount, Types type, String description, int userId){
        if (!typesRevenues.containsKey(type)){
            typesRevenues.put(type, 1);
        } else {
            typesRevenues.put(type, typesRevenues.get(type) + 1);
        }
        this.revenues.add(new Revenue(amount, type, description, userId));
    }

    public void addExpense(Double amount, Types type, String description, int userId) {
        /*if(amount > actualBalance){
            throw new ExpenseException("No se poseen fondos suficientes. Saldo: " + this.getBalance());
        }*/
        if (!typesExpenses.containsKey(type)){
            typesExpenses.put(type, 1);
        } else {
            typesExpenses.put(type, typesExpenses.get(type) + 1);
        }
        this.expenses.add(new Expense(amount, type, description, userId));
    }

    public List<Revenue> getRevenues(){
        return revenues;
    }

    public List<Expense> getExpenses(){
        return expenses;
    }

    public Map<Types, Integer> getTypesExpenses() {
        return typesExpenses;
    }

    public Map<Types, Integer> getTypesRevenues() {
        return typesRevenues;
    }

    @Override
    public String toString(){
        return "{ \n UserId: " + id + "\n" +
                " Name: " + username + "\n" +
                " Email: " + email + " \n}";
    }
}
