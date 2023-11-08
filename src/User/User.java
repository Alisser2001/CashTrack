package User;

public class User {
    private String userID;
    private String name;
    private String email;
    private String password;

    public String getUserID(){
        return this.userID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean setPassword(String password){
        this.password = password;
        return true;
    }
}
