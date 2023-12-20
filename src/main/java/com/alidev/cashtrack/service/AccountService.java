package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;

public interface AccountService {
    AccountResponseDTO findById(int id) throws RepositoryException;
    AccountResponseDTO findByAdminId(int id) throws RepositoryException;
    void createAccount(AccountRequestDTO account) throws RepositoryException;
    void deleteAccount(AccountRequestDTO account) throws RepositoryException;
    void updateAccountName(int id, String name) throws RepositoryException;
    void updateAdminId(int accId, int id) throws RepositoryException;
    void updateDescription(int id, String description) throws RepositoryException;
    void updatePassword(int id, String password) throws RepositoryException;
}
