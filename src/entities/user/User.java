package entities.user;

import interfaces.entities.user.IUser;

public class User implements IUser {
    private int id;
    private String username;
    private String email;
    private String pin;
    private int accountId;

    public User(){ }
    public User(String username){
        this.username = username;
    }
    public User(int id, String username){
        this.id = id;
        this.username = username;
    }
    public User(int id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public int getUserId(){
        return this.id;
    }
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

    public boolean setPin(String pin){
        this.password = password;
        return true;
    }
    @Override
    public String toString(){
        return "{ \n UserId: " + id + "\n" +
                " Name: " + username + "\n" +
                " Email: " + email + " \n}";
    }
}
