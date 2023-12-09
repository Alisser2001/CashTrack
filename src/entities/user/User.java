package entities.user;

public class User {
    private static int usersAmount = 0;
    private int userID;
    private String name;
    private String email;
    private String password;

    public User(){
        this.userID = usersAmount;
        setUsersAmount();
    }

    private static void setUsersAmount(){
        usersAmount += 1;
    }

    public int getUserID(){
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
    @Override
    public String toString(){
        return "{ \n UserId: " + userID + "\n" +
                " Name: " + name + "\n" +
                " Email: " + email + " \n}";
    }
}
