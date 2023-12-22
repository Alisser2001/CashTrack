package com.alidev.cashtrack.service.impl;

import com.alidev.cashtrack.dto.AccountRequestDTO;
import com.alidev.cashtrack.dto.AccountResponseDTO;
import com.alidev.cashtrack.entity.AccountEntity;
import com.alidev.cashtrack.exception.ExpenseException;
import com.alidev.cashtrack.exception.RepositoryException;
import com.alidev.cashtrack.repository.AccountRepository;
import com.alidev.cashtrack.service.AccountService;
import com.alidev.cashtrack.util.AccountMapper;
import com.alidev.cashtrack.util.impl.AccountMapperImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private AccountMapper accountMapper = new AccountMapperImpl();
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponseDTO findById(int id) throws RepositoryException {
        AccountEntity accountEntity = accountRepository.findById(id);
        return accountMapper.mapAccountEntityToAccountDTO(accountEntity);
    }

    @Override
    public AccountResponseDTO findByAdminId(int id) throws RepositoryException {
        AccountEntity accountEntity = accountRepository.findByAdminId(id);
        return accountMapper.mapAccountEntityToAccountDTO(accountEntity);
    }

    @Override
    public void createAccount(AccountRequestDTO accountDTO) throws RepositoryException {
        AccountEntity accountEntity = accountMapper.mapAccountDTOToAccountEntity(accountDTO);
        accountRepository.createAccount(accountEntity);
    }

    @Override
    public void deleteAccount(int id) throws RepositoryException {
        accountRepository.deleteAccount(id);
    }

    @Override
    public void updateAccountName(int id, AccountRequestDTO account) throws RepositoryException {
        accountRepository.updateAccountName(id, account.getAccountName());
    }

    @Override
    public void updateAdminId(int id, AccountRequestDTO account) throws RepositoryException {
        accountRepository.updateAdminId(id, account.getAdminId());
    }

    @Override
    public void updateDescription(int id, AccountRequestDTO account) throws RepositoryException {
        accountRepository.updateDescription(id, account.getDescription());
    }

    @Override
    public void updatePassword(int id, AccountRequestDTO account) throws RepositoryException {
        accountRepository.updatePassword(id, account.getPassword());
    }

    @Override
    public void addMoney(int account, Double amount) throws ExpenseException, RepositoryException {
        accountRepository.addMoney(account, amount);
    }

    @Override
    public void removeMoney(int account, Double amount) throws ExpenseException, RepositoryException {
        accountRepository.removeMoney(account, amount);
    }
}
