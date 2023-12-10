package dao.dto;

import entities.account.Account;
import entities.money.Expense;
import entities.money.Revenue;
import entities.money.TypeExpenses;
import entities.money.TypeRevenues;
import entities.user.User;
import interfaces.dao.dto.IAccountDTO;

import java.util.List;
import java.util.Map;

public class AccountDTO implements IAccountDTO {
    private int id;
    private UserDTO admin;
    private String description;
    private String accountName;
    private Double balance;
    private String password;
    private List<User> users;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private Map<TypeExpenses, Integer> typesExpenses;
    private Map<TypeRevenues, Integer> typesRevenues;

    public AccountDTO(int id, UserDTO admin, String accName, String description, Double balance) {
        this.id = id;
        this.admin = admin;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
    }
    public AccountDTO(UserDTO admin, String accName, String description, String password, Double balance) {
        this.admin = admin;
        this.accountName = accName;
        this.description = description;
        this.password = password;
        this.balance = balance;
    }
    public int getId(){
        return id;
    }
    public UserDTO getAdmin() {
        return admin;
    }
    public String getAccountName() {
        return accountName;
    }
    @Override
    public String getDescription() {
        return description;
    }
    public Double getBalance() {
        return balance;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public List<Revenue> getRevenues() {
        return revenues;
    }
    public Map<TypeExpenses, Integer> getTypesExpenses() {
        return typesExpenses;
    }
    public Map<TypeRevenues, Integer> getTypesRevenues() {
        return typesRevenues;
    }
}
