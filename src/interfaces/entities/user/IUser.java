package interfaces.entities.user;

public interface IUser {
    int getUserId();
    void setUserId(int id);
    String getUsername();
    void setUsername(String username);
    String getEmail();
    void setEmail(String email);
    boolean setPin(String pin);
    String getPin();
    void setAccountId(int id);
    int getAccountId(int id);
    String toString();
}

