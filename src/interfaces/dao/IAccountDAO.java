package interfaces.dao;

import dao.dto.AccountDTO;
import exceptions.DAOException;

public interface IAccountDAO {
    AccountDTO findById(int id) throws DAOException;
    AccountDTO findByAdminId(int id) throws DAOException;
    void createAccount(AccountDTO accountDTO) throws DAOException;
    void deleteAccount(AccountDTO accountDTO) throws DAOException;
}
