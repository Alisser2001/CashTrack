package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.dto.AccountDTO;
import com.alidev.cashtrack.exception.RepositoryException;

public interface AccountRepository {
    AccountDTO findById(int id) throws RepositoryException;
    AccountDTO findByAdminId(int id) throws RepositoryException;
    void createAccount(AccountDTO accountDTO) throws RepositoryException;
    void deleteAccount(AccountDTO accountDTO) throws RepositoryException;
    void updateAccountName(int id, String name) throws RepositoryException;
    void updateAdminId(int accId, int id) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updatePassword(int id, String password) throws RepositoryException;
}
