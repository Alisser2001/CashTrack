package com.alidev.cashtrack.repository;

import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.exception.RepositoryException;

public interface AccountRepository {
    AccountEntity findById(int id) throws RepositoryException;
    AccountEntity findByAdminId(int id) throws RepositoryException;
    void createAccount(AccountEntity account) throws RepositoryException;
    void deleteAccount(AccountEntity account) throws RepositoryException;
    void updateAccountName(int id, String name) throws RepositoryException;
    void updateAdminId(int accId, int id) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updatePassword(int id, String password) throws RepositoryException;
}
