package dao.dto;

import entities.user.User;
import interfaces.dao.dto.IUserDTO;

public class UserDTO implements IUserDTO {
    private int userId;
    private String username;
    private String email;

    public UserDTO(User user) {
        this.userId = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
}

