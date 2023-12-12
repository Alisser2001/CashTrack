package interfaces.entities.account;
import entities.user.UserEntity;
import java.util.List;

public interface IAccountEntity {
    int getAccountId();
    void setAccountId(int id);
    int getAdminId();
    void setAdminId(int id);
    String getAccountName();
    void setAccountName(String name);
    String getDescription();
    void setDescription(String description);
    void setPassword(String password);
    String getPassword();
    Double getBalance();
    void setBalance(Double balance);
    List<UserEntity> getUsers();
    void setUser(UserEntity user);
    String toString();
}
