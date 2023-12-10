package interfaces.entities.account;
import entities.user.User;
import entities.money.*;
import java.util.List;
import java.util.Map;

public interface IAccount {
    int getAccountId();
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
    List<User> getUsers();
    void setUser(User user);
    List<Revenue> getRevenues();
    List<Expense> getExpenses();
    Map<TypeExpenses, Integer> getTypesExpenses();
    Map<TypeRevenues, Integer> getTypesRevenues();
    String toString();
}
