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
    private User admin;
    private String description;
    private String name;
    private String email;
    private Double balance;
    private List<User> users;
    private List<Expense> expenses;
    private List<Revenue> revenues;
    private Map<TypeExpenses, Integer> typesExpenses;
    private Map<TypeRevenues, Integer> typesRevenues;

    public AccountDTO(Account account) {
        this.id = account.getAccountId();
        this.admin = account.getAdmin();
        this.name = account.getName();
        this.description = account.getDescription();
        this.email = account.getEmail();
        this.balance = account.getBalance();
        this.users = account.getUsers();
        this.expenses = account.getExpenses();
        this.revenues = account.getRevenues();
        this.typesExpenses = account.getTypesExpenses();
        this.typesRevenues = account.getTypesRevenues();
    }
    public int getAccountId(){
        return id;
    }
    public User getAdminId() {
        return admin;
    }
    public String getAccountName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    public String getEmail() {
        return email;
    }
    public Double getBalance() {
        return balance;
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
