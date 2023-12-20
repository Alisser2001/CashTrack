package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.AccountRepository;
import com.alidev.cashtrack.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponseDTO findById(int id) throws RepositoryException {
        return null;
    }

    @Override
    public AccountResponseDTO findByAdminId(int id) throws RepositoryException {
        return null;
    }

    @Override
    public void createAccount(AccountRequestDTO accountDTO) throws RepositoryException {

    }

    @Override
    public void deleteAccount(AccountRequestDTO accountDTO) throws RepositoryException {

    }

    @Override
    public void updateAccountName(int id, String name) throws RepositoryException {

    }

    @Override
    public void updateAdminId(int accId, int id) throws RepositoryException {

    }

    @Override
    public void updateDescription(int id, String description) throws RepositoryException {

    }

    @Override
    public void updatePassword(int id, String password) throws RepositoryException {

    }
}
