package interfaces.dao;

public interface IAccountDAO {
    AccountDTO findById(int id);
    void createAccount(AccountDTO accountDTO);
    void updateAccount(AccountDTO accountDTO);
    void deleteAccount(int id);
}
