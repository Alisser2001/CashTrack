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
    private int id;
    private User admin;
    private String name;
    private String email;
    private String description;
    private String password;
    private Double balance;
    private List<User> users;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private Map<TypeExpenses, Integer> typesExpenses;
    private Map<TypeRevenues, Integer> typesRevenues;

    public Account(){ };
    public Account(User admin, String password){
        this.balance = 0.0;
        this.admin = admin;
        this.password = password;
        this.email = admin.getEmail();
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.typesExpenses = new HashMap<>();
        this.typesRevenues = new HashMap<>();
    }
    public Account(User admin, String password, Double balance){
        this.balance = balance;
        this.admin = admin;
        this.password = password;
        this.email = admin.getEmail();
        this.expenses = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.typesExpenses = new HashMap<>();
        this.typesRevenues = new HashMap<>();
    }

    @Override
    public int getAccountId() {
        return id;
    }
    @Override
    public User getAdmin() {
        return admin;
    }
    @Override
    public void setAdmin(User admin) {
        this.admin = admin;
        this.email = admin.getEmail();
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getDescription() {
        return null;
    }
    @Override
    public void setDescription(String description) {

    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public List<User> getUsers(){
        return users;
    }
    public void setUser(User user){
        this.users.add(user);
    }
    private void addRevenue(Double amount, TypeRevenues type, String description, User user){
        if (!typesRevenues.containsKey(type)){
            typesRevenues.put(type, 1);
        } else {
            typesRevenues.put(type, typesRevenues.get(type) + 1);
        }
        this.setBalance(this.getBalance() + amount);
        this.revenues.add(new Revenue(amount, type, description, user));
    }

    private void addExpense(Double amount, TypeExpenses type, String description, User user) throws ExpenseException{
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
        this.expenses.add(new Expense(amount, type, description, user));
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
                "User: " + this.getAdmin();
    }
    public void addTransaction(Double amount, TypeExpenses typeExpense, TypeRevenues typeRevenue, String description, User user) throws ExpenseException, NullPointerException {
        if(amount == null){
            throw new NullPointerException("Ingrese una cantidad valida e intentelo de nuevo.");
        }
        if (typeExpense != null) {
            addExpense(amount, typeExpense, description, user);
        } else if (typeRevenue != null) {
            addRevenue(amount, typeRevenue, description, user);
        }
    }
}
