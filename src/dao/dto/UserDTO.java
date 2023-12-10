package dao.dto;

import entities.user.User;
import interfaces.dao.dto.IUserDTO;

public class UserDTO implements IUserDTO {
    private int id;
    private String username;
    private String email;
    private int accountId;
    private String pin;

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
}

