package entities.account;

import interfaces.entities.account.IAccount;
import entities.user.User;
import java.util.List;

public class Account implements IAccount {
    private int id;
    private int adminId;
    private String name;
    private String description;
    private String password;
    private Double balance;
    private List<User> users;

    public Account(){ };
    public Account(int adminId, String password){
        this.balance = 0.0;
        this.adminId = adminId;
        this.password = password;
    }
    public Account(int adminId, String password, Double balance){
        this.balance = balance;
        this.adminId = adminId;
        this.password = password;
    }

    @Override
    public int getAccountId() {
        return id;
    }
    public void setAccountId(int id) { this.id = id; }
    @Override
    public int getAdminId() {
        return adminId;
    }
    @Override
    public void setAdminId(int id) {
        this.adminId = adminId;
    }
    @Override
    public String getAccountName() {
        return name;
    }
    @Override
    public void setAccountName(String name) {
        this.name = name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String getPassword() { return password; }
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
    @Override
    public String toString(){
        return "\nAccountBalance: " + this.getBalance() + "\n" +
                "User: " + this.getAdminId();
    }
}
