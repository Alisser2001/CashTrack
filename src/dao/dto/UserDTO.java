package dao.dto;

import entities.money.ExpenseEntity;
import entities.money.RevenueEntity;
import interfaces.dao.dto.IUserDTO;
import java.util.List;
import java.util.Map;

public class UserDTO implements IUserDTO {
    private int id;
    private String username;
    private String email;
    private int accountId;
    private String pin;
    private List<ExpenseEntity> expenses;
    private List<RevenueEntity> revenues;
    private Map<String, Integer> typesExpenses;
    private Map<String, Integer> typesRevenues;

    public UserDTO(String username, String email, int accId, String pin) {
        this.username = username;
        this.email = email;
        this.accountId = accId;
        this.pin = pin;
    }
    public UserDTO(int id, String username, String email, int accId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountId = accId;
    }
    public int getId(){
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public int getAccountId(){
        return accountId;
    }
    public String getPin(){
        return pin;
    }
    public List<ExpenseEntity> getExpenses() {
        return expenses;
    }
    public List<RevenueEntity> getRevenues() {
        return revenues;
    }
    public Map<String, Integer> getTypesExpenses() {
        return typesExpenses;
    }
    public Map<String, Integer> getTypesRevenues() {
        return typesRevenues;
    }

}

