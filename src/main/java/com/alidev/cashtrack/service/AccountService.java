package com.alidev.cashtrack.service;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;

public interface AccountService {
    AccountResponseDTO findById(int id) throws RepositoryException;
    AccountResponseDTO findByAdminId(int id) throws RepositoryException;
    void createAccount(AccountRequestDTO account) throws RepositoryException;
    void deleteAccount(int id) throws RepositoryException;
    void updateAccountName(int id, AccountRequestDTO account) throws RepositoryException;
    void updateAdminId(int id, AccountRequestDTO account) throws RepositoryException;
    void updateDescription(int id, AccountRequestDTO account) throws RepositoryException;
    void updatePassword(int id, AccountRequestDTO account) throws RepositoryException;
}
