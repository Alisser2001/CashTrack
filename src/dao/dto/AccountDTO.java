package dao.dto;

import entities.user.User;
import interfaces.dao.dto.IAccountDTO;
import java.util.List;

public class AccountDTO implements IAccountDTO {
    private int id;
    private int adminId;
    private String description;
    private String accountName;
    private Double balance;
    private String password;
    private List<User> users;

    public AccountDTO(int id, int adminId, String accName, String description, Double balance) {
        this.id = id;
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.balance = balance;
    }
    public AccountDTO(int adminId, String accName, String description, String password, Double balance) {
        this.adminId = adminId;
        this.accountName = accName;
        this.description = description;
        this.password = password;
        this.balance = balance;
    }
    public int getId(){
        return id;
    }
    public int getAdminId() {
        return adminId;
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
}
