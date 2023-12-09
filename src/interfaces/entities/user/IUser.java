package interfaces.entities.user;

public interface IUser {
    int getUserID();
    String getUsername();
    void setUsername(String username);
    String getEmail();
    void setEmail(String email);
    boolean setPin(String password);
    String toString();
}

